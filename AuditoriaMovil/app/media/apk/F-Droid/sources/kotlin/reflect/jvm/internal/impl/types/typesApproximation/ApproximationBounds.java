package kotlin.reflect.jvm.internal.impl.types.typesApproximation;

import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CapturedTypeApproximation.kt */
/* loaded from: classes2.dex */
public final class ApproximationBounds {
    private final Object lower;
    private final Object upper;

    public final Object component1() {
        return this.lower;
    }

    public final Object component2() {
        return this.upper;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ApproximationBounds) {
            ApproximationBounds approximationBounds = (ApproximationBounds) obj;
            return Intrinsics.areEqual(this.lower, approximationBounds.lower) && Intrinsics.areEqual(this.upper, approximationBounds.upper);
        }
        return false;
    }

    public final Object getLower() {
        return this.lower;
    }

    public final Object getUpper() {
        return this.upper;
    }

    public int hashCode() {
        Object obj = this.lower;
        int hashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.upper;
        return hashCode + (obj2 != null ? obj2.hashCode() : 0);
    }

    public String toString() {
        return "ApproximationBounds(lower=" + this.lower + ", upper=" + this.upper + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public ApproximationBounds(Object obj, Object obj2) {
        this.lower = obj;
        this.upper = obj2;
    }
}
