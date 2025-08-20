package yk;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class yt {
    public boolean y;

    /* renamed from: n3  reason: collision with root package name */
    public final Set<n3> f15463n3 = new z.n3();

    /* renamed from: zn  reason: collision with root package name */
    public final Map<String, br.a> f15464zn = new HashMap();

    /* renamed from: gv  reason: collision with root package name */
    public final Comparator<vl.gv<String, Float>> f15462gv = new y();

    /* loaded from: classes.dex */
    public interface n3 {
        void y(float f4);
    }

    /* loaded from: classes.dex */
    public class y implements Comparator<vl.gv<String, Float>> {
        public y() {
        }

        @Override // java.util.Comparator
        /* renamed from: y */
        public int compare(vl.gv<String, Float> gvVar, vl.gv<String, Float> gvVar2) {
            float floatValue = gvVar.f14456n3.floatValue();
            float floatValue2 = gvVar2.f14456n3.floatValue();
            if (floatValue2 > floatValue) {
                return 1;
            }
            if (floatValue > floatValue2) {
                return -1;
            }
            return 0;
        }
    }

    public void n3(boolean z2) {
        this.y = z2;
    }

    public void y(String str, float f4) {
        if (!this.y) {
            return;
        }
        br.a aVar = this.f15464zn.get(str);
        if (aVar == null) {
            aVar = new br.a();
            this.f15464zn.put(str, aVar);
        }
        aVar.y(f4);
        if (str.equals("__container")) {
            for (n3 n3Var : this.f15463n3) {
                n3Var.y(f4);
            }
        }
    }
}
