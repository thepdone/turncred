package expo.modules.kotlin.exception;

import expo.modules.interfaces.filesystem.FilePermissionModuleInterface;
import expo.modules.interfaces.permissions.Permissions;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: CommonExceptions.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001:\r\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000fB\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0010"}, d2 = {"Lexpo/modules/kotlin/exception/Exceptions;", "", "()V", "AppContextLost", "FileSystemModuleNotFound", "IllegalArgument", "IllegalStateException", "IncorrectThreadException", "MissingActivity", "MissingPermissions", "MissingRootView", "ModuleNotFound", "PermissionsModuleNotFound", "ReactContextLost", "SimulatorNotSupported", "ViewNotFound", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Exceptions {
    public static final int $stable = 0;

    /* compiled from: CommonExceptions.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lexpo/modules/kotlin/exception/Exceptions$ViewNotFound;", "Lexpo/modules/kotlin/exception/CodedException;", "viewType", "Lkotlin/reflect/KClass;", "viewTag", "", "(Lkotlin/reflect/KClass;I)V", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ViewNotFound extends CodedException {
        public static final int $stable = 0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewNotFound(KClass<?> viewType, int i) {
            super("Unable to find the " + viewType + " view with tag " + i, null, 2, null);
            Intrinsics.checkNotNullParameter(viewType, "viewType");
        }
    }

    /* compiled from: CommonExceptions.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lexpo/modules/kotlin/exception/Exceptions$AppContextLost;", "Lexpo/modules/kotlin/exception/CodedException;", "()V", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class AppContextLost extends CodedException {
        public static final int $stable = 0;

        public AppContextLost() {
            super("The app context has been lost", null, 2, null);
        }
    }

    /* compiled from: CommonExceptions.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lexpo/modules/kotlin/exception/Exceptions$ReactContextLost;", "Lexpo/modules/kotlin/exception/CodedException;", "()V", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ReactContextLost extends CodedException {
        public static final int $stable = 0;

        public ReactContextLost() {
            super("The react context has been lost", null, 2, null);
        }
    }

    /* compiled from: CommonExceptions.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lexpo/modules/kotlin/exception/Exceptions$ModuleNotFound;", "Lexpo/modules/kotlin/exception/CodedException;", "clazz", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)V", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static class ModuleNotFound extends CodedException {
        public static final int $stable = 0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ModuleNotFound(KClass<?> clazz) {
            super(clazz + " module not found, make sure that everything is linked correctly", null, 2, null);
            Intrinsics.checkNotNullParameter(clazz, "clazz");
        }
    }

    /* compiled from: CommonExceptions.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lexpo/modules/kotlin/exception/Exceptions$PermissionsModuleNotFound;", "Lexpo/modules/kotlin/exception/Exceptions$ModuleNotFound;", "()V", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class PermissionsModuleNotFound extends ModuleNotFound {
        public static final int $stable = 0;

        public PermissionsModuleNotFound() {
            super(Reflection.getOrCreateKotlinClass(Permissions.class));
        }
    }

    /* compiled from: CommonExceptions.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lexpo/modules/kotlin/exception/Exceptions$FileSystemModuleNotFound;", "Lexpo/modules/kotlin/exception/Exceptions$ModuleNotFound;", "()V", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class FileSystemModuleNotFound extends ModuleNotFound {
        public static final int $stable = 0;

        public FileSystemModuleNotFound() {
            super(Reflection.getOrCreateKotlinClass(FilePermissionModuleInterface.class));
        }
    }

    /* compiled from: CommonExceptions.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lexpo/modules/kotlin/exception/Exceptions$SimulatorNotSupported;", "Lexpo/modules/kotlin/exception/CodedException;", "()V", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class SimulatorNotSupported extends CodedException {
        public static final int $stable = 0;

        public SimulatorNotSupported() {
            super("This operation is not supported on the simulator", null, 2, null);
        }
    }

    /* compiled from: CommonExceptions.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lexpo/modules/kotlin/exception/Exceptions$MissingPermissions;", "Lexpo/modules/kotlin/exception/CodedException;", "permissions", "", "", "([Ljava/lang/String;)V", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class MissingPermissions extends CodedException {
        public static final int $stable = 0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MissingPermissions(String... permissions) {
            super("Missing permissions: " + ArraysKt.joinToString$default(permissions, ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null), null, 2, null);
            Intrinsics.checkNotNullParameter(permissions, "permissions");
        }
    }

    /* compiled from: CommonExceptions.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lexpo/modules/kotlin/exception/Exceptions$MissingActivity;", "Lexpo/modules/kotlin/exception/CodedException;", "()V", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class MissingActivity extends CodedException {
        public static final int $stable = 0;

        public MissingActivity() {
            super("The current activity is no longer available", null, 2, null);
        }
    }

    /* compiled from: CommonExceptions.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lexpo/modules/kotlin/exception/Exceptions$IncorrectThreadException;", "Lexpo/modules/kotlin/exception/CodedException;", "currentThreadName", "", "expectedThreadName", "(Ljava/lang/String;Ljava/lang/String;)V", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class IncorrectThreadException extends CodedException {
        public static final int $stable = 0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public IncorrectThreadException(String currentThreadName, String expectedThreadName) {
            super("Expected to run on " + expectedThreadName + " thread, but was run on " + currentThreadName, null, 2, null);
            Intrinsics.checkNotNullParameter(currentThreadName, "currentThreadName");
            Intrinsics.checkNotNullParameter(expectedThreadName, "expectedThreadName");
        }
    }

    /* compiled from: CommonExceptions.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lexpo/modules/kotlin/exception/Exceptions$MissingRootView;", "Lexpo/modules/kotlin/exception/CodedException;", "()V", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class MissingRootView extends CodedException {
        public static final int $stable = 0;

        public MissingRootView() {
            super("The root view is missing", null, 2, null);
        }
    }

    /* compiled from: CommonExceptions.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lexpo/modules/kotlin/exception/Exceptions$IllegalArgument;", "Lexpo/modules/kotlin/exception/CodedException;", "message", "", "cause", "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class IllegalArgument extends CodedException {
        public static final int $stable = 0;

        public /* synthetic */ IllegalArgument(String str, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : th);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public IllegalArgument(String message, Throwable th) {
            super(message, th);
            Intrinsics.checkNotNullParameter(message, "message");
        }
    }

    /* compiled from: CommonExceptions.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lexpo/modules/kotlin/exception/Exceptions$IllegalStateException;", "Lexpo/modules/kotlin/exception/CodedException;", "message", "", "cause", "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class IllegalStateException extends CodedException {
        public static final int $stable = 0;

        public /* synthetic */ IllegalStateException(String str, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : th);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public IllegalStateException(String message, Throwable th) {
            super(message, th);
            Intrinsics.checkNotNullParameter(message, "message");
        }
    }
}
