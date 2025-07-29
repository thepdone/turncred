package cl.json;

import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.ContentUris;
import android.content.Context;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.react.bridge.ReactContext;
import java.io.File;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public class RNSharePathUtil {
    private static final ArrayList<String> authorities = new ArrayList<>();

    public static void compileAuthorities(ReactContext reactContext) {
        ArrayList<String> arrayList = authorities;
        if (arrayList.size() == 0) {
            ComponentCallbacks2 componentCallbacks2 = (Application) reactContext.getApplicationContext();
            if (componentCallbacks2 instanceof ShareApplication) {
                arrayList.add(((ShareApplication) componentCallbacks2).getFileProviderAuthority());
            }
            arrayList.add(reactContext.getPackageName() + ".rnshare.fileprovider");
        }
    }

    public static Uri compatUriFromFile(ReactContext reactContext, File file) {
        compileAuthorities(reactContext);
        String authority = Uri.fromFile(file).getAuthority();
        if (!TextUtils.isEmpty(authority) && authorities.contains(authority)) {
            return Uri.fromFile(file);
        }
        if (file.getAbsolutePath().startsWith("content://")) {
            return Uri.fromFile(file);
        }
        Uri uriForFile = null;
        int i = 0;
        while (true) {
            ArrayList<String> arrayList = authorities;
            if (i >= arrayList.size()) {
                break;
            }
            try {
                uriForFile = FileProvider.getUriForFile(reactContext, arrayList.get(i), file);
            } catch (Exception e) {
                System.out.println("RNSharePathUtil::compatUriFromFile ERROR " + e.getMessage());
            }
            if (uriForFile != null) {
                break;
            }
            i++;
        }
        return uriForFile;
    }

    public static String getRealPathFromURI(Context context, Uri uri, Boolean bool) {
        Uri uri2 = null;
        if (DocumentsContract.isDocumentUri(context, uri)) {
            if (isExternalStorageDocument(uri)) {
                String[] strArrSplit = DocumentsContract.getDocumentId(uri).split(":");
                String str = strArrSplit[0];
                if ("primary".equalsIgnoreCase(str) || AppEventsConstants.EVENT_PARAM_VALUE_NO.equalsIgnoreCase(str)) {
                    return "" + (bool.booleanValue() ? context.getCacheDir() : context.getExternalCacheDir()) + "/" + strArrSplit[1];
                }
                if ("raw".equalsIgnoreCase(str)) {
                    return "" + strArrSplit[1];
                }
                if (!TextUtils.isEmpty(str)) {
                    return "/storage/" + str + "/" + strArrSplit[1];
                }
            } else {
                if (isDownloadsDocument(uri)) {
                    String documentId = DocumentsContract.getDocumentId(uri);
                    if (documentId.startsWith("raw:")) {
                        return "" + documentId.replaceFirst("raw:", "");
                    }
                    return "" + getDataColumn(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(documentId).longValue()), null, null);
                }
                if (isMediaDocument(uri)) {
                    String[] strArrSplit2 = DocumentsContract.getDocumentId(uri).split(":");
                    String str2 = strArrSplit2[0];
                    if ("image".equals(str2)) {
                        uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                    } else if ("video".equals(str2)) {
                        uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                    } else if ("audio".equals(str2)) {
                        uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                    } else if ("raw".equalsIgnoreCase(str2)) {
                        return "" + strArrSplit2[1];
                    }
                    return "" + getDataColumn(context, uri2, "_id=?", new String[]{strArrSplit2[1]});
                }
            }
        } else {
            if ("content".equalsIgnoreCase(uri.getScheme())) {
                if (isGooglePhotosUri(uri)) {
                    return uri.getLastPathSegment();
                }
                return "" + getDataColumn(context, uri, null, null);
            }
            if ("file".equalsIgnoreCase(uri.getScheme())) {
                return uri.getPath();
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getDataColumn(android.content.Context r10, android.net.Uri r11, java.lang.String r12, java.lang.String[] r13) throws java.lang.Throwable {
        /*
            r0 = 1
            java.lang.String[] r4 = new java.lang.String[r0]
            r0 = 0
            java.lang.String r8 = "_data"
            r4[r0] = r8
            r0 = 0
            androidx.loader.content.CursorLoader r9 = new androidx.loader.content.CursorLoader     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L38
            r7 = 0
            r1 = r9
            r2 = r10
            r3 = r11
            r5 = r12
            r6 = r13
            r1.<init>(r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L38
            android.database.Cursor r10 = r9.loadInBackground()     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L38
            if (r10 == 0) goto L30
            boolean r11 = r10.moveToFirst()     // Catch: java.lang.Exception -> L2e java.lang.Throwable -> L43
            if (r11 == 0) goto L30
            int r11 = r10.getColumnIndexOrThrow(r8)     // Catch: java.lang.Exception -> L2e java.lang.Throwable -> L43
            java.lang.String r11 = r10.getString(r11)     // Catch: java.lang.Exception -> L2e java.lang.Throwable -> L43
            if (r10 == 0) goto L2d
            r10.close()
        L2d:
            return r11
        L2e:
            r11 = move-exception
            goto L3a
        L30:
            if (r10 == 0) goto L35
            r10.close()
        L35:
            return r0
        L36:
            r11 = move-exception
            goto L45
        L38:
            r11 = move-exception
            r10 = r0
        L3a:
            r11.printStackTrace()     // Catch: java.lang.Throwable -> L43
            if (r10 == 0) goto L42
            r10.close()
        L42:
            return r0
        L43:
            r11 = move-exception
            r0 = r10
        L45:
            if (r0 == 0) goto L4a
            r0.close()
        L4a:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: cl.json.RNSharePathUtil.getDataColumn(android.content.Context, android.net.Uri, java.lang.String, java.lang.String[]):java.lang.String");
    }

    public static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public static boolean isGooglePhotosUri(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }
}
