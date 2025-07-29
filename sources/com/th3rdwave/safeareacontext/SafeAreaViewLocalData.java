package com.th3rdwave.safeareacontext;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SafeAreaViewLocalData.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/th3rdwave/safeareacontext/SafeAreaViewLocalData;", "", "insets", "Lcom/th3rdwave/safeareacontext/EdgeInsets;", "mode", "Lcom/th3rdwave/safeareacontext/SafeAreaViewMode;", "edges", "Lcom/th3rdwave/safeareacontext/SafeAreaViewEdges;", "(Lcom/th3rdwave/safeareacontext/EdgeInsets;Lcom/th3rdwave/safeareacontext/SafeAreaViewMode;Lcom/th3rdwave/safeareacontext/SafeAreaViewEdges;)V", "getEdges", "()Lcom/th3rdwave/safeareacontext/SafeAreaViewEdges;", "getInsets", "()Lcom/th3rdwave/safeareacontext/EdgeInsets;", "getMode", "()Lcom/th3rdwave/safeareacontext/SafeAreaViewMode;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "react-native-safe-area-context_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SafeAreaViewLocalData {
    private final SafeAreaViewEdges edges;
    private final EdgeInsets insets;
    private final SafeAreaViewMode mode;

    public static /* synthetic */ SafeAreaViewLocalData copy$default(SafeAreaViewLocalData safeAreaViewLocalData, EdgeInsets edgeInsets, SafeAreaViewMode safeAreaViewMode, SafeAreaViewEdges safeAreaViewEdges, int i, Object obj) {
        if ((i & 1) != 0) {
            edgeInsets = safeAreaViewLocalData.insets;
        }
        if ((i & 2) != 0) {
            safeAreaViewMode = safeAreaViewLocalData.mode;
        }
        if ((i & 4) != 0) {
            safeAreaViewEdges = safeAreaViewLocalData.edges;
        }
        return safeAreaViewLocalData.copy(edgeInsets, safeAreaViewMode, safeAreaViewEdges);
    }

    /* renamed from: component1, reason: from getter */
    public final EdgeInsets getInsets() {
        return this.insets;
    }

    /* renamed from: component2, reason: from getter */
    public final SafeAreaViewMode getMode() {
        return this.mode;
    }

    /* renamed from: component3, reason: from getter */
    public final SafeAreaViewEdges getEdges() {
        return this.edges;
    }

    public final SafeAreaViewLocalData copy(EdgeInsets insets, SafeAreaViewMode mode, SafeAreaViewEdges edges) {
        Intrinsics.checkNotNullParameter(insets, "insets");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(edges, "edges");
        return new SafeAreaViewLocalData(insets, mode, edges);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SafeAreaViewLocalData)) {
            return false;
        }
        SafeAreaViewLocalData safeAreaViewLocalData = (SafeAreaViewLocalData) other;
        return Intrinsics.areEqual(this.insets, safeAreaViewLocalData.insets) && this.mode == safeAreaViewLocalData.mode && Intrinsics.areEqual(this.edges, safeAreaViewLocalData.edges);
    }

    public int hashCode() {
        return (((this.insets.hashCode() * 31) + this.mode.hashCode()) * 31) + this.edges.hashCode();
    }

    public String toString() {
        return "SafeAreaViewLocalData(insets=" + this.insets + ", mode=" + this.mode + ", edges=" + this.edges + ")";
    }

    public SafeAreaViewLocalData(EdgeInsets insets, SafeAreaViewMode mode, SafeAreaViewEdges edges) {
        Intrinsics.checkNotNullParameter(insets, "insets");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(edges, "edges");
        this.insets = insets;
        this.mode = mode;
        this.edges = edges;
    }

    public final EdgeInsets getInsets() {
        return this.insets;
    }

    public final SafeAreaViewMode getMode() {
        return this.mode;
    }

    public final SafeAreaViewEdges getEdges() {
        return this.edges;
    }
}
