package com.streem.selectcontact;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import androidx.autofill.HintConstants;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import expo.modules.contacts.Columns;
import io.sentry.protocol.Geo;

/* loaded from: classes5.dex */
public class SelectContactModule extends ReactContextBaseJavaModule implements ActivityEventListener {
    private static final int CONTACT_REQUEST = 11112;
    public static final String E_CONTACT_CANCELLED = "E_CONTACT_CANCELLED";
    public static final String E_CONTACT_EXCEPTION = "E_CONTACT_EXCEPTION";
    public static final String E_CONTACT_NO_DATA = "E_CONTACT_NO_DATA";
    public static final String E_CONTACT_PERMISSION = "E_CONTACT_PERMISSION";
    private static final String TAG = "SelectContactModule";
    private final ContentResolver contentResolver;
    private Promise mContactsPromise;

    @Override // com.facebook.react.bridge.ActivityEventListener
    public void onNewIntent(Intent intent) {
    }

    public SelectContactModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.contentResolver = getReactApplicationContext().getContentResolver();
        reactApplicationContext.addActivityEventListener(this);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "SelectContact";
    }

    @ReactMethod
    public void openContactSelection(Promise promise) {
        launchPicker(promise, CONTACT_REQUEST);
    }

    private void launchPicker(Promise promise, int i) {
        this.mContactsPromise = promise;
        Cursor cursorQuery = this.contentResolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
        if (cursorQuery != null) {
            Intent intent = new Intent("android.intent.action.PICK");
            intent.setType("vnd.android.cursor.dir/contact");
            Activity currentActivity = getCurrentActivity();
            if (intent.resolveActivity(currentActivity.getPackageManager()) != null) {
                currentActivity.startActivityForResult(intent, i);
            }
            cursorQuery.close();
            return;
        }
        this.mContactsPromise.reject(E_CONTACT_PERMISSION, "no permission");
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0081  */
    @Override // com.facebook.react.bridge.ActivityEventListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onActivityResult(android.app.Activity r12, int r13, int r14, android.content.Intent r15) {
        /*
            Method dump skipped, instructions count: 246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.streem.selectcontact.SelectContactModule.onActivityResult(android.app.Activity, int, int, android.content.Intent):void");
    }

    private String getContactId(Uri uri) throws SelectContactException {
        Cursor cursorQuery = this.contentResolver.query(uri, null, null, null, null);
        if (cursorQuery == null || !cursorQuery.moveToFirst()) {
            throw new SelectContactException(E_CONTACT_NO_DATA, "Contact Data Not Found");
        }
        return cursorQuery.getString(cursorQuery.getColumnIndex(Columns.ID));
    }

    private Uri buildContactUri(String str) {
        return Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_URI, str).buildUpon().appendPath("entities").build();
    }

    private Cursor openContactQuery(Uri uri) throws SelectContactException {
        Cursor cursorQuery = this.contentResolver.query(uri, new String[]{Columns.MIMETYPE, Columns.DATA, Columns.TYPE, Columns.LABEL}, null, null, "raw_contact_id ASC");
        if (cursorQuery != null) {
            return cursorQuery;
        }
        throw new SelectContactException(E_CONTACT_EXCEPTION, "Could not query contacts data. Unable to create cursor.");
    }

    private void addNameData(WritableMap writableMap, Cursor cursor) {
        writableMap.putString("name", cursor.getString(cursor.getColumnIndex(Columns.DATA)));
        int columnIndex = cursor.getColumnIndex(Columns.TYPE);
        if (columnIndex != -1) {
            writableMap.putString("givenName", cursor.getString(columnIndex));
        }
        if (cursor.getColumnIndex(Columns.LABEL) != -1) {
            writableMap.putString("familyName", cursor.getString(cursor.getColumnIndex(Columns.LABEL)));
        }
        int columnIndex2 = cursor.getColumnIndex(Columns.DATA_5);
        if (columnIndex2 != -1) {
            writableMap.putString("middleName", cursor.getString(columnIndex2));
        }
    }

    private void addPostalData(WritableArray writableArray, Cursor cursor, Activity activity) {
        int columnIndex = cursor.getColumnIndex(Columns.DATA);
        int columnIndex2 = cursor.getColumnIndex(Columns.DATA_4);
        int columnIndex3 = cursor.getColumnIndex(Columns.DATA_7);
        int columnIndex4 = cursor.getColumnIndex(Columns.DATA_8);
        int columnIndex5 = cursor.getColumnIndex(Columns.DATA_9);
        int columnIndex6 = cursor.getColumnIndex(Columns.DATA_10);
        WritableMap writableMapCreateMap = Arguments.createMap();
        if (columnIndex != -1) {
            writableMapCreateMap.putString("formattedAddress", cursor.getString(columnIndex));
        }
        if (columnIndex2 != -1) {
            writableMapCreateMap.putString("street", cursor.getString(columnIndex2));
        }
        if (columnIndex3 != -1) {
            writableMapCreateMap.putString(Geo.JsonKeys.CITY, cursor.getString(columnIndex3));
        }
        if (columnIndex4 != -1) {
            writableMapCreateMap.putString("state", cursor.getString(columnIndex4));
        }
        if (columnIndex5 != -1) {
            writableMapCreateMap.putString(HintConstants.AUTOFILL_HINT_POSTAL_CODE, cursor.getString(columnIndex5));
        }
        if (columnIndex6 != -1) {
            writableMapCreateMap.putString("isoCountryCode", cursor.getString(columnIndex6));
        }
        int columnIndex7 = cursor.getColumnIndex(Columns.TYPE);
        int columnIndex8 = cursor.getColumnIndex(Columns.LABEL);
        if (columnIndex7 != -1 && columnIndex8 != -1) {
            String string = cursor.getString(columnIndex8);
            writableMapCreateMap.putString("type", String.valueOf(ContactsContract.CommonDataKinds.StructuredPostal.getTypeLabel(activity.getResources(), cursor.getInt(columnIndex7), string)));
        }
        writableArray.pushMap(writableMapCreateMap);
    }

    private void addPhoneEntry(WritableArray writableArray, Cursor cursor, Activity activity) {
        String string = cursor.getString(cursor.getColumnIndex(Columns.DATA));
        CharSequence typeLabel = ContactsContract.CommonDataKinds.Phone.getTypeLabel(activity.getResources(), cursor.getInt(cursor.getColumnIndex(Columns.TYPE)), cursor.getString(cursor.getColumnIndex(Columns.LABEL)));
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("number", string);
        writableMapCreateMap.putString("type", String.valueOf(typeLabel));
        writableArray.pushMap(writableMapCreateMap);
    }

    private void addEmailEntry(WritableArray writableArray, Cursor cursor, Activity activity) {
        String string = cursor.getString(cursor.getColumnIndex(Columns.DATA));
        CharSequence typeLabel = ContactsContract.CommonDataKinds.Email.getTypeLabel(activity.getResources(), cursor.getInt(cursor.getColumnIndex(Columns.TYPE)), cursor.getString(cursor.getColumnIndex(Columns.LABEL)));
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("address", string);
        writableMapCreateMap.putString("type", String.valueOf(typeLabel));
        writableArray.pushMap(writableMapCreateMap);
    }

    public static class SelectContactException extends Exception {
        private final String errorCode;

        public SelectContactException(String str, String str2) {
            super(str2);
            this.errorCode = str;
        }

        public String getErrorCode() {
            return this.errorCode;
        }
    }
}
