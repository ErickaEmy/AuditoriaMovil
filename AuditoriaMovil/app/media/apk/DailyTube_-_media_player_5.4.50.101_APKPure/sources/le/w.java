package le;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import l.z;
/* loaded from: classes.dex */
public final class w {

    /* renamed from: co  reason: collision with root package name */
    public static final String f10329co = l.f.a("WorkSpec");

    /* renamed from: z  reason: collision with root package name */
    public static final p.y<List<zn>, List<l.z>> f10330z = new y();
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public androidx.work.n3 f10331a;

    /* renamed from: c5  reason: collision with root package name */
    public long f10332c5;

    /* renamed from: f  reason: collision with root package name */
    public int f10333f;

    /* renamed from: fb  reason: collision with root package name */
    public long f10334fb;

    /* renamed from: gv  reason: collision with root package name */
    public String f10335gv;
    @NonNull

    /* renamed from: i9  reason: collision with root package name */
    public l.n3 f10336i9;
    @NonNull

    /* renamed from: mt  reason: collision with root package name */
    public l.xc f10337mt;
    @NonNull

    /* renamed from: n3  reason: collision with root package name */
    public z.y f10338n3;

    /* renamed from: p  reason: collision with root package name */
    public boolean f10339p;

    /* renamed from: s  reason: collision with root package name */
    public long f10340s;
    @NonNull

    /* renamed from: t  reason: collision with root package name */
    public l.y f10341t;

    /* renamed from: tl  reason: collision with root package name */
    public long f10342tl;
    @NonNull

    /* renamed from: v  reason: collision with root package name */
    public androidx.work.n3 f10343v;

    /* renamed from: w  reason: collision with root package name */
    public long f10344w;

    /* renamed from: wz  reason: collision with root package name */
    public long f10345wz;

    /* renamed from: xc  reason: collision with root package name */
    public long f10346xc;
    @NonNull
    public String y;
    @NonNull

    /* renamed from: zn  reason: collision with root package name */
    public String f10347zn;

    /* loaded from: classes.dex */
    public static class n3 {

        /* renamed from: n3  reason: collision with root package name */
        public z.y f10348n3;
        public String y;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof n3)) {
                return false;
            }
            n3 n3Var = (n3) obj;
            if (this.f10348n3 != n3Var.f10348n3) {
                return false;
            }
            return this.y.equals(n3Var.y);
        }

        public int hashCode() {
            return (this.y.hashCode() * 31) + this.f10348n3.hashCode();
        }
    }

    /* loaded from: classes.dex */
    public class y implements p.y<List<zn>, List<l.z>> {
        @Override // p.y
        /* renamed from: y */
        public List<l.z> apply(List<zn> list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (zn znVar : list) {
                arrayList.add(znVar.y());
            }
            return arrayList;
        }
    }

    /* loaded from: classes.dex */
    public static class zn {

        /* renamed from: a  reason: collision with root package name */
        public List<androidx.work.n3> f10349a;

        /* renamed from: gv  reason: collision with root package name */
        public int f10350gv;

        /* renamed from: n3  reason: collision with root package name */
        public z.y f10351n3;

        /* renamed from: v  reason: collision with root package name */
        public List<String> f10352v;
        public String y;

        /* renamed from: zn  reason: collision with root package name */
        public androidx.work.n3 f10353zn;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof zn)) {
                return false;
            }
            zn znVar = (zn) obj;
            if (this.f10350gv != znVar.f10350gv) {
                return false;
            }
            String str = this.y;
            if (str == null ? znVar.y != null : !str.equals(znVar.y)) {
                return false;
            }
            if (this.f10351n3 != znVar.f10351n3) {
                return false;
            }
            androidx.work.n3 n3Var = this.f10353zn;
            if (n3Var == null ? znVar.f10353zn != null : !n3Var.equals(znVar.f10353zn)) {
                return false;
            }
            List<String> list = this.f10352v;
            if (list == null ? znVar.f10352v != null : !list.equals(znVar.f10352v)) {
                return false;
            }
            List<androidx.work.n3> list2 = this.f10349a;
            List<androidx.work.n3> list3 = znVar.f10349a;
            if (list2 != null) {
                return list2.equals(list3);
            }
            if (list3 == null) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i;
            int i5;
            int i6;
            int i8;
            String str = this.y;
            int i10 = 0;
            if (str != null) {
                i = str.hashCode();
            } else {
                i = 0;
            }
            int i11 = i * 31;
            z.y yVar = this.f10351n3;
            if (yVar != null) {
                i5 = yVar.hashCode();
            } else {
                i5 = 0;
            }
            int i12 = (i11 + i5) * 31;
            androidx.work.n3 n3Var = this.f10353zn;
            if (n3Var != null) {
                i6 = n3Var.hashCode();
            } else {
                i6 = 0;
            }
            int i13 = (((i12 + i6) * 31) + this.f10350gv) * 31;
            List<String> list = this.f10352v;
            if (list != null) {
                i8 = list.hashCode();
            } else {
                i8 = 0;
            }
            int i14 = (i13 + i8) * 31;
            List<androidx.work.n3> list2 = this.f10349a;
            if (list2 != null) {
                i10 = list2.hashCode();
            }
            return i14 + i10;
        }

        @NonNull
        public l.z y() {
            androidx.work.n3 n3Var;
            List<androidx.work.n3> list = this.f10349a;
            if (list != null && !list.isEmpty()) {
                n3Var = this.f10349a.get(0);
            } else {
                n3Var = androidx.work.n3.f3773zn;
            }
            return new l.z(UUID.fromString(this.y), this.f10351n3, this.f10353zn, this.f10352v, n3Var, this.f10350gv);
        }
    }

    public w(@NonNull String str, @NonNull String str2) {
        this.f10338n3 = z.y.ENQUEUED;
        androidx.work.n3 n3Var = androidx.work.n3.f3773zn;
        this.f10343v = n3Var;
        this.f10331a = n3Var;
        this.f10336i9 = l.n3.f10204c5;
        this.f10341t = l.y.EXPONENTIAL;
        this.f10342tl = 30000L;
        this.f10344w = -1L;
        this.f10337mt = l.xc.RUN_AS_NON_EXPEDITED_WORK_REQUEST;
        this.y = str;
        this.f10347zn = str2;
    }

    public void a(long j2, long j4) {
        if (j2 < 900000) {
            l.f.zn().s(f10329co, String.format("Interval duration lesser than minimum allowed value; Changed to %s", 900000L), new Throwable[0]);
            j2 = 900000;
        }
        if (j4 < 300000) {
            l.f.zn().s(f10329co, String.format("Flex duration lesser than minimum allowed value; Changed to %s", 300000L), new Throwable[0]);
            j4 = 300000;
        }
        if (j4 > j2) {
            l.f.zn().s(f10329co, String.format("Flex duration greater than interval duration; Changed to %s", Long.valueOf(j2)), new Throwable[0]);
            j4 = j2;
        }
        this.f10340s = j2;
        this.f10332c5 = j4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || w.class != obj.getClass()) {
            return false;
        }
        w wVar = (w) obj;
        if (this.f10334fb != wVar.f10334fb || this.f10340s != wVar.f10340s || this.f10332c5 != wVar.f10332c5 || this.f10333f != wVar.f10333f || this.f10342tl != wVar.f10342tl || this.f10345wz != wVar.f10345wz || this.f10346xc != wVar.f10346xc || this.f10344w != wVar.f10344w || this.f10339p != wVar.f10339p || !this.y.equals(wVar.y) || this.f10338n3 != wVar.f10338n3 || !this.f10347zn.equals(wVar.f10347zn)) {
            return false;
        }
        String str = this.f10335gv;
        if (str == null ? wVar.f10335gv != null : !str.equals(wVar.f10335gv)) {
            return false;
        }
        if (this.f10343v.equals(wVar.f10343v) && this.f10331a.equals(wVar.f10331a) && this.f10336i9.equals(wVar.f10336i9) && this.f10341t == wVar.f10341t && this.f10337mt == wVar.f10337mt) {
            return true;
        }
        return false;
    }

    public boolean gv() {
        if (this.f10340s != 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i;
        int hashCode = ((((this.y.hashCode() * 31) + this.f10338n3.hashCode()) * 31) + this.f10347zn.hashCode()) * 31;
        String str = this.f10335gv;
        if (str != null) {
            i = str.hashCode();
        } else {
            i = 0;
        }
        long j2 = this.f10334fb;
        long j4 = this.f10340s;
        long j6 = this.f10332c5;
        long j7 = this.f10342tl;
        long j8 = this.f10345wz;
        long j9 = this.f10346xc;
        long j10 = this.f10344w;
        return ((((((((((((((((((((((((((((hashCode + i) * 31) + this.f10343v.hashCode()) * 31) + this.f10331a.hashCode()) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31) + ((int) (j6 ^ (j6 >>> 32)))) * 31) + this.f10336i9.hashCode()) * 31) + this.f10333f) * 31) + this.f10341t.hashCode()) * 31) + ((int) (j7 ^ (j7 >>> 32)))) * 31) + ((int) (j8 ^ (j8 >>> 32)))) * 31) + ((int) (j9 ^ (j9 >>> 32)))) * 31) + ((int) (j10 ^ (j10 >>> 32)))) * 31) + (this.f10339p ? 1 : 0)) * 31) + this.f10337mt.hashCode();
    }

    public boolean n3() {
        return !l.n3.f10204c5.equals(this.f10336i9);
    }

    @NonNull
    public String toString() {
        return "{WorkSpec: " + this.y + "}";
    }

    public void v(long j2) {
        if (j2 < 900000) {
            l.f.zn().s(f10329co, String.format("Interval duration lesser than minimum allowed value; Changed to %s", 900000L), new Throwable[0]);
            j2 = 900000;
        }
        a(j2, j2);
    }

    public long y() {
        long j2;
        long scalb;
        if (zn()) {
            if (this.f10341t == l.y.LINEAR) {
                scalb = this.f10342tl * this.f10333f;
            } else {
                scalb = Math.scalb((float) this.f10342tl, this.f10333f - 1);
            }
            return this.f10345wz + Math.min(18000000L, scalb);
        }
        long j4 = 0;
        if (gv()) {
            long currentTimeMillis = System.currentTimeMillis();
            long j6 = this.f10345wz;
            if (j6 == 0) {
                j2 = currentTimeMillis + this.f10334fb;
            } else {
                j2 = j6;
            }
            long j7 = this.f10332c5;
            long j8 = this.f10340s;
            if (j7 != j8) {
                if (j6 == 0) {
                    j4 = j7 * (-1);
                }
                return j2 + j8 + j4;
            }
            if (j6 != 0) {
                j4 = j8;
            }
            return j2 + j4;
        }
        long j9 = this.f10345wz;
        if (j9 == 0) {
            j9 = System.currentTimeMillis();
        }
        return j9 + this.f10334fb;
    }

    public boolean zn() {
        if (this.f10338n3 == z.y.ENQUEUED && this.f10333f > 0) {
            return true;
        }
        return false;
    }

    public w(@NonNull w wVar) {
        this.f10338n3 = z.y.ENQUEUED;
        androidx.work.n3 n3Var = androidx.work.n3.f3773zn;
        this.f10343v = n3Var;
        this.f10331a = n3Var;
        this.f10336i9 = l.n3.f10204c5;
        this.f10341t = l.y.EXPONENTIAL;
        this.f10342tl = 30000L;
        this.f10344w = -1L;
        this.f10337mt = l.xc.RUN_AS_NON_EXPEDITED_WORK_REQUEST;
        this.y = wVar.y;
        this.f10347zn = wVar.f10347zn;
        this.f10338n3 = wVar.f10338n3;
        this.f10335gv = wVar.f10335gv;
        this.f10343v = new androidx.work.n3(wVar.f10343v);
        this.f10331a = new androidx.work.n3(wVar.f10331a);
        this.f10334fb = wVar.f10334fb;
        this.f10340s = wVar.f10340s;
        this.f10332c5 = wVar.f10332c5;
        this.f10336i9 = new l.n3(wVar.f10336i9);
        this.f10333f = wVar.f10333f;
        this.f10341t = wVar.f10341t;
        this.f10342tl = wVar.f10342tl;
        this.f10345wz = wVar.f10345wz;
        this.f10346xc = wVar.f10346xc;
        this.f10344w = wVar.f10344w;
        this.f10339p = wVar.f10339p;
        this.f10337mt = wVar.f10337mt;
    }
}
