package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.collect.ImmutableSetMultimap;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
public final class zzik {
    public static final Supplier<ImmutableSetMultimap<String, String>> zza = Suppliers.memoize(new Supplier() { // from class: com.google.android.gms.internal.measurement.zzim
        @Override // com.google.common.base.Supplier
        public final Object get() {
            return new ImmutableSetMultimap.Builder().build();
        }
    });
}
