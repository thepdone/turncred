package expo.modules.kotlin.classcomponent;

import expo.modules.kotlin.functions.SyncFunctionComponent;
import expo.modules.kotlin.objects.ObjectDefinitionData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ClassDefinitionData.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lexpo/modules/kotlin/classcomponent/ClassDefinitionData;", "", "name", "", "constructor", "Lexpo/modules/kotlin/functions/SyncFunctionComponent;", "objectDefinition", "Lexpo/modules/kotlin/objects/ObjectDefinitionData;", "isSharedRef", "", "(Ljava/lang/String;Lexpo/modules/kotlin/functions/SyncFunctionComponent;Lexpo/modules/kotlin/objects/ObjectDefinitionData;Z)V", "getConstructor", "()Lexpo/modules/kotlin/functions/SyncFunctionComponent;", "()Z", "getName", "()Ljava/lang/String;", "getObjectDefinition", "()Lexpo/modules/kotlin/objects/ObjectDefinitionData;", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ClassDefinitionData {
    public static final int $stable = 8;
    private final SyncFunctionComponent constructor;
    private final boolean isSharedRef;
    private final String name;
    private final ObjectDefinitionData objectDefinition;

    public ClassDefinitionData(String name, SyncFunctionComponent constructor, ObjectDefinitionData objectDefinition, boolean z) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.checkNotNullParameter(objectDefinition, "objectDefinition");
        this.name = name;
        this.constructor = constructor;
        this.objectDefinition = objectDefinition;
        this.isSharedRef = z;
    }

    public final String getName() {
        return this.name;
    }

    public final SyncFunctionComponent getConstructor() {
        return this.constructor;
    }

    public final ObjectDefinitionData getObjectDefinition() {
        return this.objectDefinition;
    }

    /* renamed from: isSharedRef, reason: from getter */
    public final boolean getIsSharedRef() {
        return this.isSharedRef;
    }
}
