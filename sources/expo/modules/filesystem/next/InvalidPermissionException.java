package expo.modules.filesystem.next;

import expo.modules.interfaces.filesystem.Permission;
import expo.modules.kotlin.exception.CodedException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FileSystemNextExceptions.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lexpo/modules/filesystem/next/InvalidPermissionException;", "Lexpo/modules/kotlin/exception/CodedException;", "permission", "Lexpo/modules/interfaces/filesystem/Permission;", "(Lexpo/modules/interfaces/filesystem/Permission;)V", "expo-file-system_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InvalidPermissionException extends CodedException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InvalidPermissionException(Permission permission) {
        super("Missing '" + permission.name() + "' permission for accessing the file.", null, 2, null);
        Intrinsics.checkNotNullParameter(permission, "permission");
    }
}
