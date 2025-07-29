package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

/* compiled from: EnumEntriesDeserializationSupport.kt */
/* loaded from: classes5.dex */
public final class JvmEnumEntriesDeserializationSupport implements EnumEntriesDeserializationSupport {
    public static final JvmEnumEntriesDeserializationSupport INSTANCE = new JvmEnumEntriesDeserializationSupport();

    private JvmEnumEntriesDeserializationSupport() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.EnumEntriesDeserializationSupport
    public Boolean canSynthesizeEnumEntries() {
        return true;
    }
}
