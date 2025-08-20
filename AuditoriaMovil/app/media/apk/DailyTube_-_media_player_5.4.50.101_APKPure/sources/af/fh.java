package af;

import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public class fh {

    /* renamed from: gv  reason: collision with root package name */
    public final long f238gv;

    /* renamed from: n3  reason: collision with root package name */
    public final int f239n3;

    /* renamed from: v  reason: collision with root package name */
    public final int f240v;
    public final Object y;

    /* renamed from: zn  reason: collision with root package name */
    public final int f241zn;

    public fh(Object obj) {
        this(obj, -1L);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof fh)) {
            return false;
        }
        fh fhVar = (fh) obj;
        if (this.y.equals(fhVar.y) && this.f239n3 == fhVar.f239n3 && this.f241zn == fhVar.f241zn && this.f238gv == fhVar.f238gv && this.f240v == fhVar.f240v) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((((((527 + this.y.hashCode()) * 31) + this.f239n3) * 31) + this.f241zn) * 31) + ((int) this.f238gv)) * 31) + this.f240v;
    }

    public boolean n3() {
        if (this.f239n3 != -1) {
            return true;
        }
        return false;
    }

    public fh y(Object obj) {
        if (this.y.equals(obj)) {
            return this;
        }
        return new fh(obj, this.f239n3, this.f241zn, this.f238gv, this.f240v);
    }

    public fh(Object obj, long j2) {
        this(obj, -1, -1, j2, -1);
    }

    public fh(Object obj, long j2, int i) {
        this(obj, -1, -1, j2, i);
    }

    public fh(Object obj, int i, int i5, long j2) {
        this(obj, i, i5, j2, -1);
    }

    public fh(fh fhVar) {
        this.y = fhVar.y;
        this.f239n3 = fhVar.f239n3;
        this.f241zn = fhVar.f241zn;
        this.f238gv = fhVar.f238gv;
        this.f240v = fhVar.f240v;
    }

    public fh(Object obj, int i, int i5, long j2, int i6) {
        this.y = obj;
        this.f239n3 = i;
        this.f241zn = i5;
        this.f238gv = j2;
        this.f240v = i6;
    }
}
