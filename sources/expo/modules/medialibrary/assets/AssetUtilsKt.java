package expo.modules.medialibrary.assets;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import androidx.camera.video.AudioStats;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.react.bridge.BaseJavaModule;
import com.nimbusds.jose.jwk.JWKParameterNames;
import expo.modules.kotlin.Promise;
import expo.modules.medialibrary.AssetQueryException;
import expo.modules.medialibrary.MediaLibraryConstantsKt;
import io.sentry.protocol.Device;
import io.sentry.protocol.Response;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AssetUtils.kt */
@Metadata(d1 = {"\u0000d\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a<\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003\u001a\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010\u001a\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0013H\u0007\u001a\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u00102\u0006\u0010\b\u001a\u00020\t\u001a*\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00052\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0003\u001a<\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u001a2\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001e\u001a=\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u00012\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010$2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020&¢\u0006\u0002\u0010'¨\u0006("}, d2 = {"exportMediaType", "", "mediaType", "", "getAssetDimensionsFromCursor", "Lkotlin/Pair;", "contentResolver", "Landroid/content/ContentResolver;", "exifInterface", "Landroidx/exifinterface/media/ExifInterface;", "cursor", "Landroid/database/Cursor;", "localUriColumnIndex", "getExifFullInfo", "", Response.TYPE, "Landroid/os/Bundle;", "getExifLocationForUri", "photoUri", "Landroid/net/Uri;", "getExifLocationLegacy", "maybeRotateAssetSize", "width", "height", Device.JsonKeys.ORIENTATION, "putAssetsInfo", "", "limit", "offset", "resolveWithFullInfo", "", "queryAssetInfo", "context", "Landroid/content/Context;", "selection", "selectionArgs", "", BaseJavaModule.METHOD_TYPE_PROMISE, "Lexpo/modules/kotlin/Promise;", "(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;ZLexpo/modules/kotlin/Promise;)V", "expo-media-library_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AssetUtilsKt {
    public static final void queryAssetInfo(Context context, String str, String[] strArr, boolean z, Promise promise) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(promise, "promise");
        ContentResolver contentResolver = context.getContentResolver();
        try {
            Cursor cursorQuery = contentResolver.query(MediaLibraryConstantsKt.getEXTERNAL_CONTENT_URI(), MediaLibraryConstantsKt.getASSET_PROJECTION(), str, strArr, null);
            try {
                Cursor cursor = cursorQuery;
                if (cursor == null) {
                    throw new AssetQueryException();
                }
                if (cursor.getCount() == 1) {
                    cursor.moveToFirst();
                    ArrayList arrayList = new ArrayList();
                    Intrinsics.checkNotNull(contentResolver);
                    putAssetsInfo(contentResolver, cursor, arrayList, 1, 0, z);
                    promise.resolve((Collection<? extends Object>) arrayList);
                } else {
                    promise.resolve((Object) null);
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(cursorQuery, null);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(cursorQuery, th);
                    throw th2;
                }
            }
        } catch (IOException e) {
            promise.reject(MediaLibraryConstantsKt.ERROR_IO_EXCEPTION, "Could not read file", e);
        } catch (SecurityException e2) {
            promise.reject(MediaLibraryConstantsKt.ERROR_UNABLE_TO_LOAD_PERMISSION, "Could not get asset: need READ_EXTERNAL_STORAGE permission.", e2);
        } catch (UnsupportedOperationException e3) {
            e3.printStackTrace();
            promise.reject(MediaLibraryConstantsKt.ERROR_NO_PERMISSIONS, e3.getMessage(), e3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0144  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void putAssetsInfo(android.content.ContentResolver r19, android.database.Cursor r20, java.util.List<android.os.Bundle> r21, int r22, int r23, boolean r24) throws java.lang.UnsupportedOperationException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 347
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.medialibrary.assets.AssetUtilsKt.putAssetsInfo(android.content.ContentResolver, android.database.Cursor, java.util.List, int, int, boolean):void");
    }

    public static final void getExifFullInfo(ExifInterface exifInterface, Bundle response) {
        Intrinsics.checkNotNullParameter(exifInterface, "exifInterface");
        Intrinsics.checkNotNullParameter(response, "response");
        Bundle bundle = new Bundle();
        for (String[] strArr : MediaLibraryConstantsKt.getEXIF_TAGS()) {
            String str = strArr[0];
            String str2 = strArr[1];
            if (exifInterface.getAttribute(str2) != null) {
                int iHashCode = str.hashCode();
                if (iHashCode != -1325958191) {
                    if (iHashCode != -891985903) {
                        if (iHashCode == 104431 && str.equals("int")) {
                            bundle.putInt(str2, exifInterface.getAttributeInt(str2, 0));
                        }
                    } else if (str.equals("string")) {
                        bundle.putString(str2, exifInterface.getAttribute(str2));
                    }
                } else if (str.equals("double")) {
                    bundle.putDouble(str2, exifInterface.getAttributeDouble(str2, AudioStats.AUDIO_AMPLITUDE_NONE));
                }
            }
        }
        response.putParcelable("exif", bundle);
    }

    public static final Bundle getExifLocationForUri(ContentResolver contentResolver, Uri photoUri) throws UnsupportedOperationException, IOException {
        Bundle bundle;
        Intrinsics.checkNotNullParameter(contentResolver, "contentResolver");
        Intrinsics.checkNotNullParameter(photoUri, "photoUri");
        try {
            Uri requireOriginal = MediaStore.setRequireOriginal(photoUri);
            Intrinsics.checkNotNullExpressionValue(requireOriginal, "setRequireOriginal(...)");
            InputStream inputStreamOpenInputStream = contentResolver.openInputStream(requireOriginal);
            if (inputStreamOpenInputStream == null) {
                return null;
            }
            InputStream inputStream = inputStreamOpenInputStream;
            try {
                double[] latLong = new ExifInterface(inputStream).getLatLong();
                if (latLong != null) {
                    double d = latLong[0];
                    double d2 = latLong[1];
                    bundle = new Bundle();
                    bundle.putDouble("latitude", d);
                    bundle.putDouble("longitude", d2);
                } else {
                    bundle = null;
                }
                CloseableKt.closeFinally(inputStream, null);
                return bundle;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(inputStream, th);
                    throw th2;
                }
            }
        } catch (IOException e) {
            Log.w("expo-media-library", "Could not parse EXIF tags for " + photoUri);
            e.printStackTrace();
            return null;
        } catch (UnsupportedOperationException unused) {
            throw new UnsupportedOperationException("Cannot access ExifInterface because of missing ACCESS_MEDIA_LOCATION permission");
        }
    }

    public static final Bundle getExifLocationLegacy(ExifInterface exifInterface) {
        Intrinsics.checkNotNullParameter(exifInterface, "exifInterface");
        double[] latLong = exifInterface.getLatLong();
        if (latLong == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putDouble("latitude", latLong[0]);
        bundle.putDouble("longitude", latLong[1]);
        return bundle;
    }

    public static final Pair<Integer, Integer> getAssetDimensionsFromCursor(ContentResolver contentResolver, ExifInterface exifInterface, Cursor cursor, int i, int i2) throws IOException {
        int attributeInt;
        Intrinsics.checkNotNullParameter(contentResolver, "contentResolver");
        Intrinsics.checkNotNullParameter(cursor, "cursor");
        String string = cursor.getString(i2);
        if (i == 3) {
            try {
                AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = contentResolver.openAssetFileDescriptor(Uri.parse("file://" + string), JWKParameterNames.RSA_OTHER_PRIMES__PRIME_FACTOR);
                try {
                    AssetFileDescriptor assetFileDescriptor = assetFileDescriptorOpenAssetFileDescriptor;
                    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                    try {
                        MediaMetadataRetriever mediaMetadataRetriever2 = mediaMetadataRetriever;
                        Intrinsics.checkNotNull(assetFileDescriptor);
                        mediaMetadataRetriever2.setDataSource(assetFileDescriptor.getFileDescriptor());
                        String strExtractMetadata = mediaMetadataRetriever2.extractMetadata(18);
                        Intrinsics.checkNotNull(strExtractMetadata);
                        int i3 = Integer.parseInt(strExtractMetadata);
                        String strExtractMetadata2 = mediaMetadataRetriever2.extractMetadata(19);
                        Intrinsics.checkNotNull(strExtractMetadata2);
                        int i4 = Integer.parseInt(strExtractMetadata2);
                        String strExtractMetadata3 = mediaMetadataRetriever2.extractMetadata(24);
                        Intrinsics.checkNotNull(strExtractMetadata3);
                        Pair<Integer, Integer> pairMaybeRotateAssetSize = maybeRotateAssetSize(i3, i4, Integer.parseInt(strExtractMetadata3));
                        AutoCloseableKt.closeFinally(mediaMetadataRetriever, null);
                        CloseableKt.closeFinally(assetFileDescriptorOpenAssetFileDescriptor, null);
                        return pairMaybeRotateAssetSize;
                    } finally {
                    }
                } finally {
                }
            } catch (FileNotFoundException e) {
                Log.e("expo-media-library", "ContentResolver failed to read " + string + ": " + e.getMessage());
            } catch (NumberFormatException e2) {
                Log.e("expo-media-library", "MediaMetadataRetriever unexpectedly returned non-integer: " + e2.getMessage());
            } catch (RuntimeException e3) {
                Log.e("expo-media-library", "MediaMetadataRetriever finished with unexpected error: " + e3.getMessage());
            }
        }
        int columnIndex = cursor.getColumnIndex("width");
        int columnIndex2 = cursor.getColumnIndex("height");
        int columnIndex3 = cursor.getColumnIndex(Device.JsonKeys.ORIENTATION);
        int i5 = cursor.getInt(columnIndex);
        int i6 = cursor.getInt(columnIndex2);
        int i7 = cursor.getInt(columnIndex3);
        if (i == 1 && (i5 <= 0 || i6 <= 0)) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(string, options);
            int i8 = options.outWidth;
            i6 = options.outHeight;
            i5 = i8;
        }
        if (exifInterface != null && ((attributeInt = exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION, 1)) == 5 || attributeInt == 6 || attributeInt == 7 || attributeInt == 8)) {
            i7 = 90;
        }
        return maybeRotateAssetSize(i5, i6, i7);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.String exportMediaType(int r1) {
        /*
            r0 = 1
            if (r1 == r0) goto L15
            r0 = 2
            if (r1 == r0) goto L12
            r0 = 3
            if (r1 == r0) goto Lf
            r0 = 4
            if (r1 == r0) goto L12
            expo.modules.medialibrary.MediaType r1 = expo.modules.medialibrary.MediaType.UNKNOWN
            goto L17
        Lf:
            expo.modules.medialibrary.MediaType r1 = expo.modules.medialibrary.MediaType.VIDEO
            goto L17
        L12:
            expo.modules.medialibrary.MediaType r1 = expo.modules.medialibrary.MediaType.AUDIO
            goto L17
        L15:
            expo.modules.medialibrary.MediaType r1 = expo.modules.medialibrary.MediaType.PHOTO
        L17:
            java.lang.String r1 = r1.getApiName()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.medialibrary.assets.AssetUtilsKt.exportMediaType(int):java.lang.String");
    }

    public static final Pair<Integer, Integer> maybeRotateAssetSize(int i, int i2, int i3) {
        if (Math.abs(i3) % RotationOptions.ROTATE_180 == 90) {
            return new Pair<>(Integer.valueOf(i2), Integer.valueOf(i));
        }
        return new Pair<>(Integer.valueOf(i), Integer.valueOf(i2));
    }
}
