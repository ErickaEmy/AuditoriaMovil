package c;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class xc {

    /* renamed from: fb  reason: collision with root package name */
    public static int f3955fb;

    /* renamed from: gv  reason: collision with root package name */
    public int f3957gv;

    /* renamed from: n3  reason: collision with root package name */
    public int f3958n3;
    public ArrayList<n.v> y = new ArrayList<>();

    /* renamed from: zn  reason: collision with root package name */
    public boolean f3960zn = false;

    /* renamed from: v  reason: collision with root package name */
    public ArrayList<y> f3959v = null;

    /* renamed from: a  reason: collision with root package name */
    public int f3956a = -1;

    /* loaded from: classes.dex */
    public class y {

        /* renamed from: a  reason: collision with root package name */
        public int f3961a;

        /* renamed from: fb  reason: collision with root package name */
        public int f3962fb;

        /* renamed from: gv  reason: collision with root package name */
        public int f3963gv;

        /* renamed from: n3  reason: collision with root package name */
        public int f3964n3;

        /* renamed from: v  reason: collision with root package name */
        public int f3966v;
        public WeakReference<n.v> y;

        /* renamed from: zn  reason: collision with root package name */
        public int f3967zn;

        public y(n.v vVar, f3.gv gvVar, int i) {
            this.y = new WeakReference<>(vVar);
            this.f3964n3 = gvVar.f3(vVar.f11700ej);
            this.f3967zn = gvVar.f3(vVar.f11747ud);
            this.f3963gv = gvVar.f3(vVar.f11687a8);
            this.f3966v = gvVar.f3(vVar.f11753x);
            this.f3961a = gvVar.f3(vVar.f11689b);
            this.f3962fb = i;
        }
    }

    public xc(int i) {
        int i5 = f3955fb;
        f3955fb = i5 + 1;
        this.f3958n3 = i5;
        this.f3957gv = i;
    }

    public int a(f3.gv gvVar, int i) {
        if (this.y.size() == 0) {
            return 0;
        }
        return i9(gvVar, this.y, i);
    }

    public void c5(int i) {
        this.f3957gv = i;
    }

    public void fb(int i, xc xcVar) {
        Iterator<n.v> it = this.y.iterator();
        while (it.hasNext()) {
            n.v next = it.next();
            xcVar.y(next);
            if (i == 0) {
                next.f11731pz = xcVar.zn();
            } else {
                next.f11730pq = xcVar.zn();
            }
        }
        this.f3956a = xcVar.f3958n3;
    }

    public int gv() {
        return this.f3957gv;
    }

    public final int i9(f3.gv gvVar, ArrayList<n.v> arrayList, int i) {
        int f32;
        int f33;
        n.a aVar = (n.a) arrayList.get(0).ud();
        gvVar.mg();
        aVar.fb(gvVar, false);
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            arrayList.get(i5).fb(gvVar, false);
        }
        if (i == 0 && aVar.f11641oa > 0) {
            n.n3.n3(aVar, gvVar, arrayList, 0);
        }
        if (i == 1 && aVar.f11650w9 > 0) {
            n.n3.n3(aVar, gvVar, arrayList, 1);
        }
        try {
            gvVar.c();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.f3959v = new ArrayList<>();
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            this.f3959v.add(new y(arrayList.get(i6), gvVar, i));
        }
        if (i == 0) {
            f32 = gvVar.f3(aVar.f11700ej);
            f33 = gvVar.f3(aVar.f11687a8);
            gvVar.mg();
        } else {
            f32 = gvVar.f3(aVar.f11747ud);
            f33 = gvVar.f3(aVar.f11753x);
            gvVar.mg();
        }
        return f33 - f32;
    }

    public void n3(ArrayList<xc> arrayList) {
        int size = this.y.size();
        if (this.f3956a != -1 && size > 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                xc xcVar = arrayList.get(i);
                if (this.f3956a == xcVar.f3958n3) {
                    fb(this.f3957gv, xcVar);
                }
            }
        }
        if (size == 0) {
            arrayList.remove(this);
        }
    }

    public void s(boolean z2) {
        this.f3960zn = z2;
    }

    public String toString() {
        Iterator<n.v> it;
        String str = v() + " [" + this.f3958n3 + "] <";
        while (this.y.iterator().hasNext()) {
            str = str + " " + it.next().mt();
        }
        return str + " >";
    }

    public final String v() {
        int i = this.f3957gv;
        if (i == 0) {
            return "Horizontal";
        }
        if (i == 1) {
            return "Vertical";
        }
        if (i == 2) {
            return "Both";
        }
        return "Unknown";
    }

    public boolean y(n.v vVar) {
        if (this.y.contains(vVar)) {
            return false;
        }
        this.y.add(vVar);
        return true;
    }

    public int zn() {
        return this.f3958n3;
    }
}
