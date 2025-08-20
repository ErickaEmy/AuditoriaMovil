package kotlin;

import ch.qos.logback.core.CoreConstants;
import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Tuples.kt */
/* loaded from: classes.dex */
public final class Triple implements Serializable {
    private final Object first;
    private final Object second;
    private final Object third;

    public final Object component1() {
        return this.first;
    }

    public final Object component2() {
        return this.second;
    }

    public final Object component3() {
        return this.third;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Triple) {
            Triple triple = (Triple) obj;
            return Intrinsics.areEqual(this.first, triple.first) && Intrinsics.areEqual(this.second, triple.second) && Intrinsics.areEqual(this.third, triple.third);
        }
        return false;
    }

    public final Object getFirst() {
        return this.first;
    }

    public final Object getSecond() {
        return this.second;
    }

    public final Object getThird() {
        return this.third;
    }

    public int hashCode() {
        Object obj = this.first;
        int hashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.second;
        int hashCode2 = (hashCode + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Object obj3 = this.third;
        return hashCode2 + (obj3 != null ? obj3.hashCode() : 0);
    }

    public Triple(Object obj, Object obj2, Object obj3) {
        this.first = obj;
        this.second = obj2;
        this.third = obj3;
    }

    public String toString() {
        return CoreConstants.LEFT_PARENTHESIS_CHAR + this.first + ", " + this.second + ", " + this.third + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
