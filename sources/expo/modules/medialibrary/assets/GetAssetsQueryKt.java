package expo.modules.medialibrary.assets;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import expo.modules.medialibrary.AssetsOptions;
import expo.modules.medialibrary.MediaType;
import expo.modules.medialibrary.SortBy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: GetAssetsQuery.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u001a\u0014\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003\u001a\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0000\u001a\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0001H\u0002\u001a\u000e\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001¨\u0006\u000e"}, d2 = {"convertOrderDescriptors", "", "orderDescriptor", "", "createSelectionString", "input", "Lexpo/modules/medialibrary/AssetsOptions;", "getQueryFromOptions", "Lexpo/modules/medialibrary/assets/GetAssetsQuery;", "parseMediaType", "", "mediaTypeName", "parseSortByKey", SDKConstants.PARAM_KEY, "expo-media-library_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GetAssetsQueryKt {
    /* JADX WARN: Removed duplicated region for block: B:14:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final expo.modules.medialibrary.assets.GetAssetsQuery getQueryFromOptions(expo.modules.medialibrary.AssetsOptions r7) throws java.lang.IllegalArgumentException {
        /*
            java.lang.String r0 = "input"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            double r4 = r7.getFirst()
            java.lang.String r0 = r7.getAfter()
            if (r0 == 0) goto L39
            kotlin.Result$Companion r1 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L1e
            int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.Throwable -> L1e
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Throwable -> L1e
            java.lang.Object r0 = kotlin.Result.m5937constructorimpl(r0)     // Catch: java.lang.Throwable -> L1e
            goto L29
        L1e:
            r0 = move-exception
            kotlin.Result$Companion r1 = kotlin.Result.INSTANCE
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m5937constructorimpl(r0)
        L29:
            boolean r1 = kotlin.Result.m5943isFailureimpl(r0)
            if (r1 == 0) goto L30
            r0 = 0
        L30:
            java.lang.Integer r0 = (java.lang.Integer) r0
            if (r0 == 0) goto L39
            int r0 = r0.intValue()
            goto L3a
        L39:
            r0 = 0
        L3a:
            r6 = r0
            java.lang.String r2 = createSelectionString(r7)
            java.util.List r0 = r7.getSortBy()
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L54
            java.util.List r7 = r7.getSortBy()
            java.lang.String r7 = convertOrderDescriptors(r7)
            goto L56
        L54:
            java.lang.String r7 = "bucket_display_name"
        L56:
            r3 = r7
            expo.modules.medialibrary.assets.GetAssetsQuery r7 = new expo.modules.medialibrary.assets.GetAssetsQuery
            r1 = r7
            r1.<init>(r2, r3, r4, r6)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.medialibrary.assets.GetAssetsQueryKt.getQueryFromOptions(expo.modules.medialibrary.AssetsOptions):expo.modules.medialibrary.assets.GetAssetsQuery");
    }

    private static final String createSelectionString(AssetsOptions assetsOptions) throws IllegalArgumentException {
        StringBuilder sb = new StringBuilder();
        if (assetsOptions.getAlbum() != null) {
            sb.append("bucket_id = " + assetsOptions.getAlbum());
            sb.append(" AND ");
        }
        List<String> mediaType = assetsOptions.getMediaType();
        if (!mediaType.isEmpty() && !mediaType.contains(MediaType.ALL.getApiName())) {
            List<String> list = mediaType;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(Integer.valueOf(parseMediaType((String) it.next())));
            }
            sb.append("media_type IN (" + CollectionsKt.joinToString$default(arrayList, ",", null, null, 0, null, null, 62, null) + ")");
        } else {
            sb.append("media_type != 0");
        }
        Double createdAfter = assetsOptions.getCreatedAfter();
        if (createdAfter != null) {
            sb.append(" AND datetaken > " + ((long) createdAfter.doubleValue()));
        }
        Double createdBefore = assetsOptions.getCreatedBefore();
        if (createdBefore != null) {
            sb.append(" AND datetaken < " + ((long) createdBefore.doubleValue()));
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public static final String parseSortByKey(String key) throws IllegalArgumentException {
        Intrinsics.checkNotNullParameter(key, "key");
        SortBy sortByFromKeyName = SortBy.INSTANCE.fromKeyName(key);
        String mediaColumnName = sortByFromKeyName != null ? sortByFromKeyName.getMediaColumnName() : null;
        if (mediaColumnName != null) {
            return mediaColumnName;
        }
        throw new IllegalArgumentException("SortBy key " + key + " is not supported!");
    }

    public static final String convertOrderDescriptors(List<String> orderDescriptor) throws IllegalArgumentException {
        Intrinsics.checkNotNullParameter(orderDescriptor, "orderDescriptor");
        ArrayList arrayList = new ArrayList(20);
        Iterator<String> it = orderDescriptor.iterator();
        while (it.hasNext()) {
            List listSplit$default = StringsKt.split$default((CharSequence) it.next(), new String[]{" "}, false, 0, 6, (Object) null);
            if (listSplit$default.size() != 2) {
                throw new IllegalArgumentException("Array sortBy in assetsOptions has invalid layout.".toString());
            }
            arrayList.add(parseSortByKey((String) listSplit$default.get(0)) + " " + ((String) listSplit$default.get(1)));
        }
        return CollectionsKt.joinToString$default(arrayList, ",", null, null, 0, null, null, 62, null);
    }

    private static final int parseMediaType(String str) throws IllegalArgumentException {
        MediaType mediaTypeFromApiName = MediaType.INSTANCE.fromApiName(str);
        Integer mediaColumn = mediaTypeFromApiName != null ? mediaTypeFromApiName.getMediaColumn() : null;
        if (mediaColumn != null) {
            return mediaColumn.intValue();
        }
        throw new IllegalArgumentException("MediaType " + str + " is not supported!");
    }
}
