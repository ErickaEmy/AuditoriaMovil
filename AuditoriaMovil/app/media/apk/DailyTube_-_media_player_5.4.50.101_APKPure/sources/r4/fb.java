package r4;

import androidx.annotation.Nullable;
import java.util.Comparator;
import java.util.TreeSet;
import r4.fb;
/* loaded from: classes.dex */
public final class fb {

    /* renamed from: gv  reason: collision with root package name */
    public boolean f13051gv;

    /* renamed from: n3  reason: collision with root package name */
    public int f13052n3;
    public final TreeSet<y> y = new TreeSet<>(new Comparator() { // from class: r4.a
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int gv2;
            gv2 = fb.gv((fb.y) obj, (fb.y) obj2);
            return gv2;
        }
    });

    /* renamed from: zn  reason: collision with root package name */
    public int f13053zn;

    /* loaded from: classes.dex */
    public static final class y {

        /* renamed from: n3  reason: collision with root package name */
        public final long f13054n3;
        public final v y;

        public y(v vVar, long j2) {
            this.y = vVar;
            this.f13054n3 = j2;
        }
    }

    public fb() {
        fb();
    }

    public static /* synthetic */ int gv(y yVar, y yVar2) {
        return zn(yVar.y.f13106fb, yVar2.y.f13106fb);
    }

    public static int zn(int i, int i5) {
        int min;
        int i6 = i - i5;
        if (Math.abs(i6) > 1000 && (min = (Math.min(i, i5) - Math.max(i, i5)) + 65535) < 1000) {
            if (i >= i5) {
                return -min;
            }
            return min;
        }
        return i6;
    }

    @Nullable
    public synchronized v a(long j2) {
        if (this.y.isEmpty()) {
            return null;
        }
        y first = this.y.first();
        int i = first.y.f13106fb;
        if (i != v.n3(this.f13053zn) && j2 < first.f13054n3) {
            return null;
        }
        this.y.pollFirst();
        this.f13053zn = i;
        return first.y;
    }

    public synchronized void fb() {
        this.y.clear();
        this.f13051gv = false;
        this.f13053zn = -1;
        this.f13052n3 = -1;
    }

    public final synchronized void n3(y yVar) {
        this.f13052n3 = yVar.y.f13106fb;
        this.y.add(yVar);
    }

    public synchronized boolean v(v vVar, long j2) {
        if (this.y.size() < 5000) {
            int i = vVar.f13106fb;
            if (!this.f13051gv) {
                fb();
                this.f13053zn = v.zn(i);
                this.f13051gv = true;
                n3(new y(vVar, j2));
                return true;
            } else if (Math.abs(zn(i, v.n3(this.f13052n3))) < 1000) {
                if (zn(i, this.f13053zn) > 0) {
                    n3(new y(vVar, j2));
                    return true;
                }
                return false;
            } else {
                this.f13053zn = v.zn(i);
                this.y.clear();
                n3(new y(vVar, j2));
                return true;
            }
        }
        throw new IllegalStateException("Queue size limit of 5000 reached.");
    }
}
