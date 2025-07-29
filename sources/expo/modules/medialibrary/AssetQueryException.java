package expo.modules.medialibrary;

import expo.modules.kotlin.exception.CodedException;
import kotlin.Metadata;

/* compiled from: Exceptions.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lexpo/modules/medialibrary/AssetQueryException;", "Lexpo/modules/kotlin/exception/CodedException;", "()V", "expo-media-library_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AssetQueryException extends CodedException {
    public AssetQueryException() {
        super("Could not get asset. Query returns null", null, 2, null);
    }
}
