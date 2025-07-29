package com.nimbusds.jose.util;

import net.jcip.annotations.Immutable;

@Immutable
/* loaded from: classes5.dex */
public class Pair<L, R> {
    private final L left;
    private final R right;

    protected Pair(L l, R r) {
        this.left = l;
        this.right = r;
    }

    public static <L, R> Pair<L, R> of(L l, R r) {
        return new Pair<>(l, r);
    }

    public L getLeft() {
        return this.left;
    }

    public R getRight() {
        return this.right;
    }
}
