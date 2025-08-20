package ie1;

import kc1.mg;
import kc1.rz;
/* loaded from: classes.dex */
public final class mt<T> {

    /* renamed from: n3  reason: collision with root package name */
    public final T f9209n3;
    public final rz y;

    /* renamed from: zn  reason: collision with root package name */
    public final mg f9210zn;

    public mt(rz rzVar, T t2, mg mgVar) {
        this.y = rzVar;
        this.f9209n3 = t2;
        this.f9210zn = mgVar;
    }

    public static <T> mt<T> a(T t2, rz rzVar) {
        i4.n3(rzVar, "rawResponse == null");
        if (rzVar.isSuccessful()) {
            return new mt<>(rzVar, t2, null);
        }
        throw new IllegalArgumentException("rawResponse must be successful response");
    }

    public static <T> mt<T> zn(mg mgVar, rz rzVar) {
        i4.n3(mgVar, "body == null");
        i4.n3(rzVar, "rawResponse == null");
        if (!rzVar.isSuccessful()) {
            return new mt<>(rzVar, null, mgVar);
        }
        throw new IllegalArgumentException("rawResponse should not be successful response");
    }

    public boolean gv() {
        return this.y.isSuccessful();
    }

    public int n3() {
        return this.y.mt();
    }

    public String toString() {
        return this.y.toString();
    }

    public String v() {
        return this.y.k5();
    }

    public T y() {
        return this.f9209n3;
    }
}
