package kotlin.reflect.jvm.internal.impl.types;

import androidx.webkit.ProxyConfig;

/* loaded from: classes5.dex */
public abstract class TypeProjectionBase implements TypeProjection {
    public String toString() {
        if (isStarProjection()) {
            return ProxyConfig.MATCH_ALL_SCHEMES;
        }
        if (getProjectionKind() == Variance.INVARIANT) {
            return getType().toString();
        }
        return getProjectionKind() + " " + getType();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TypeProjection)) {
            return false;
        }
        TypeProjection typeProjection = (TypeProjection) obj;
        return isStarProjection() == typeProjection.isStarProjection() && getProjectionKind() == typeProjection.getProjectionKind() && getType().equals(typeProjection.getType());
    }

    public int hashCode() {
        int iHashCode = getProjectionKind().hashCode();
        if (TypeUtils.noExpectedType(getType())) {
            return (iHashCode * 31) + 19;
        }
        return (iHashCode * 31) + (isStarProjection() ? 17 : getType().hashCode());
    }
}
