package di;

import androidx.annotation.Nullable;
import java.io.File;
import java.util.ArrayList;
import java.util.TreeSet;
/* loaded from: classes.dex */
public final class f {

    /* renamed from: gv  reason: collision with root package name */
    public final ArrayList<y> f7255gv;

    /* renamed from: n3  reason: collision with root package name */
    public final String f7256n3;

    /* renamed from: v  reason: collision with root package name */
    public w f7257v;
    public final int y;

    /* renamed from: zn  reason: collision with root package name */
    public final TreeSet<r> f7258zn;

    /* loaded from: classes.dex */
    public static final class y {

        /* renamed from: n3  reason: collision with root package name */
        public final long f7259n3;
        public final long y;

        public y(long j2, long j4) {
            this.y = j2;
            this.f7259n3 = j4;
        }

        public boolean n3(long j2, long j4) {
            long j6 = this.y;
            if (j6 <= j2) {
                long j7 = this.f7259n3;
                if (j7 == -1 || j6 + j7 > j2) {
                    return true;
                }
                return false;
            } else if (j4 == -1 || j2 + j4 > j6) {
                return true;
            } else {
                return false;
            }
        }

        public boolean y(long j2, long j4) {
            long j6 = this.f7259n3;
            if (j6 == -1) {
                if (j2 >= this.y) {
                    return true;
                }
                return false;
            } else if (j4 == -1) {
                return false;
            } else {
                long j7 = this.y;
                if (j7 <= j2 && j2 + j4 <= j7 + j6) {
                    return true;
                }
                return false;
            }
        }
    }

    public f(int i, String str) {
        this(i, str, w.f7300zn);
    }

    public TreeSet<r> a() {
        return this.f7258zn;
    }

    public boolean c5() {
        return this.f7255gv.isEmpty();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || f.class != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        if (this.y == fVar.y && this.f7256n3.equals(fVar.f7256n3) && this.f7258zn.equals(fVar.f7258zn) && this.f7257v.equals(fVar.f7257v)) {
            return true;
        }
        return false;
    }

    public boolean f(c5 c5Var) {
        if (this.f7258zn.remove(c5Var)) {
            File file = c5Var.f7250f;
            if (file != null) {
                file.delete();
                return true;
            }
            return true;
        }
        return false;
    }

    public boolean fb() {
        return this.f7258zn.isEmpty();
    }

    public w gv() {
        return this.f7257v;
    }

    public int hashCode() {
        return (((this.y * 31) + this.f7256n3.hashCode()) * 31) + this.f7257v.hashCode();
    }

    public boolean i9(long j2, long j4) {
        for (int i = 0; i < this.f7255gv.size(); i++) {
            if (this.f7255gv.get(i).n3(j2, j4)) {
                return false;
            }
        }
        this.f7255gv.add(new y(j2, j4));
        return true;
    }

    public boolean n3(xc xcVar) {
        w wVar = this.f7257v;
        w v2 = wVar.v(xcVar);
        this.f7257v = v2;
        return !v2.equals(wVar);
    }

    public boolean s(long j2, long j4) {
        for (int i = 0; i < this.f7255gv.size(); i++) {
            if (this.f7255gv.get(i).y(j2, j4)) {
                return true;
            }
        }
        return false;
    }

    public r t(r rVar, long j2, boolean z2) {
        v5.y.fb(this.f7258zn.remove(rVar));
        File file = (File) v5.y.v(rVar.f7250f);
        if (z2) {
            File c52 = r.c5((File) v5.y.v(file.getParentFile()), this.y, rVar.f7254v, j2);
            if (file.renameTo(c52)) {
                file = c52;
            } else {
                v5.r.c5("CachedContent", "Failed to rename " + file + " to " + c52);
            }
        }
        r gv2 = rVar.gv(file, j2);
        this.f7258zn.add(gv2);
        return gv2;
    }

    public void tl(long j2) {
        for (int i = 0; i < this.f7255gv.size(); i++) {
            if (this.f7255gv.get(i).y == j2) {
                this.f7255gv.remove(i);
                return;
            }
        }
        throw new IllegalStateException();
    }

    public r v(long j2, long j4) {
        r s2 = r.s(this.f7256n3, j2);
        r floor = this.f7258zn.floor(s2);
        if (floor != null && floor.f7254v + floor.f7251fb > j2) {
            return floor;
        }
        r ceiling = this.f7258zn.ceiling(s2);
        if (ceiling != null) {
            long j6 = ceiling.f7254v - j2;
            if (j4 == -1) {
                j4 = j6;
            } else {
                j4 = Math.min(j6, j4);
            }
        }
        return r.fb(this.f7256n3, j2, j4);
    }

    public void y(r rVar) {
        this.f7258zn.add(rVar);
    }

    public long zn(long j2, long j4) {
        boolean z2;
        boolean z3 = true;
        if (j2 >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.y(z2);
        if (j4 < 0) {
            z3 = false;
        }
        v5.y.y(z3);
        r v2 = v(j2, j4);
        long j6 = Long.MAX_VALUE;
        if (v2.n3()) {
            if (!v2.zn()) {
                j6 = v2.f7251fb;
            }
            return -Math.min(j6, j4);
        }
        long j7 = j2 + j4;
        if (j7 >= 0) {
            j6 = j7;
        }
        long j8 = v2.f7254v + v2.f7251fb;
        if (j8 < j6) {
            for (r rVar : this.f7258zn.tailSet(v2, false)) {
                long j9 = rVar.f7254v;
                if (j9 > j8) {
                    break;
                }
                j8 = Math.max(j8, j9 + rVar.f7251fb);
                if (j8 >= j6) {
                    break;
                }
            }
        }
        return Math.min(j8 - j2, j4);
    }

    public f(int i, String str, w wVar) {
        this.y = i;
        this.f7256n3 = str;
        this.f7257v = wVar;
        this.f7258zn = new TreeSet<>();
        this.f7255gv = new ArrayList<>();
    }
}
