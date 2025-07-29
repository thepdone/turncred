package com.mrousavy.camera.core.types;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.mrousavy.camera.core.InvalidTypeScriptUnionError;
import com.mrousavy.camera.core.types.CodeType;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CodeScannerOptions.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/mrousavy/camera/core/types/CodeScannerOptions;", "", "codeTypes", "", "Lcom/mrousavy/camera/core/types/CodeType;", "(Ljava/util/List;)V", "getCodeTypes", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "Companion", "react-native-vision-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class CodeScannerOptions {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<CodeType> codeTypes;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CodeScannerOptions copy$default(CodeScannerOptions codeScannerOptions, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = codeScannerOptions.codeTypes;
        }
        return codeScannerOptions.copy(list);
    }

    public final List<CodeType> component1() {
        return this.codeTypes;
    }

    public final CodeScannerOptions copy(List<? extends CodeType> codeTypes) {
        Intrinsics.checkNotNullParameter(codeTypes, "codeTypes");
        return new CodeScannerOptions(codeTypes);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof CodeScannerOptions) && Intrinsics.areEqual(this.codeTypes, ((CodeScannerOptions) other).codeTypes);
    }

    public int hashCode() {
        return this.codeTypes.hashCode();
    }

    public String toString() {
        return "CodeScannerOptions(codeTypes=" + this.codeTypes + ")";
    }

    /* compiled from: CodeScannerOptions.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/mrousavy/camera/core/types/CodeScannerOptions$Companion;", "", "()V", "fromJSValue", "Lcom/mrousavy/camera/core/types/CodeScannerOptions;", "value", "Lcom/facebook/react/bridge/ReadableMap;", "react-native-vision-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CodeScannerOptions fromJSValue(ReadableMap value) throws InvalidTypeScriptUnionError {
            Intrinsics.checkNotNullParameter(value, "value");
            ReadableArray array = value.getArray("codeTypes");
            if (array == null) {
                throw new InvalidTypeScriptUnionError("codeScanner", value.toString());
            }
            ArrayList<Object> arrayList = array.toArrayList();
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
            for (Object obj : arrayList) {
                CodeType.Companion companion = CodeType.INSTANCE;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                arrayList2.add(companion.fromUnionValue((String) obj));
            }
            return new CodeScannerOptions(arrayList2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CodeScannerOptions(List<? extends CodeType> codeTypes) {
        Intrinsics.checkNotNullParameter(codeTypes, "codeTypes");
        this.codeTypes = codeTypes;
    }

    public final List<CodeType> getCodeTypes() {
        return this.codeTypes;
    }
}
