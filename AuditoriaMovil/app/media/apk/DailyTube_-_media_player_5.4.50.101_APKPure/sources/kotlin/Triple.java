package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class Triple<A, B, C> implements Serializable {
    private final A first;
    private final B second;
    private final C third;

    public Triple(A a2, B b2, C c2) {
        this.first = a2;
        this.second = b2;
        this.third = c2;
    }

    public final A component1() {
        return this.first;
    }

    public final B component2() {
        return this.second;
    }

    public final C component3() {
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

    public final A getFirst() {
        return this.first;
    }

    public final B getSecond() {
        return this.second;
    }

    public final C getThird() {
        return this.third;
    }

    public int hashCode() {
        A a2 = this.first;
        int hashCode = (a2 == null ? 0 : a2.hashCode()) * 31;
        B b2 = this.second;
        int hashCode2 = (hashCode + (b2 == null ? 0 : b2.hashCode())) * 31;
        C c2 = this.third;
        return hashCode2 + (c2 != null ? c2.hashCode() : 0);
    }

    public String toString() {
        return '(' + this.first + ", " + this.second + ", " + this.third + ')';
    }
}
