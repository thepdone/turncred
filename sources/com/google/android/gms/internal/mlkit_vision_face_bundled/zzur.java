package com.google.android.gms.internal.mlkit_vision_face_bundled;

import java.io.IOException;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
public final class zzur extends IOException {
    zzur() {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.");
    }

    zzur(String str, Throwable th) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(String.valueOf(str)), th);
    }

    zzur(Throwable th) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
    }
}
