package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes.dex */
public class wz {
    public static int n3(RecyclerView.fh fhVar, f fVar, View view, View view2, RecyclerView.w wVar, boolean z2, boolean z3) {
        int max;
        if (wVar.oz() == 0 || fhVar.n3() == 0 || view == null || view2 == null) {
            return 0;
        }
        int min = Math.min(wVar.ap(view), wVar.ap(view2));
        int max2 = Math.max(wVar.ap(view), wVar.ap(view2));
        if (z3) {
            max = Math.max(0, (fhVar.n3() - max2) - 1);
        } else {
            max = Math.max(0, min);
        }
        if (!z2) {
            return max;
        }
        return Math.round((max * (Math.abs(fVar.gv(view2) - fVar.fb(view)) / (Math.abs(wVar.ap(view) - wVar.ap(view2)) + 1))) + (fVar.tl() - fVar.fb(view)));
    }

    public static int y(RecyclerView.fh fhVar, f fVar, View view, View view2, RecyclerView.w wVar, boolean z2) {
        if (wVar.oz() != 0 && fhVar.n3() != 0 && view != null && view2 != null) {
            if (!z2) {
                return Math.abs(wVar.ap(view) - wVar.ap(view2)) + 1;
            }
            return Math.min(fVar.wz(), fVar.gv(view2) - fVar.fb(view));
        }
        return 0;
    }

    public static int zn(RecyclerView.fh fhVar, f fVar, View view, View view2, RecyclerView.w wVar, boolean z2) {
        if (wVar.oz() != 0 && fhVar.n3() != 0 && view != null && view2 != null) {
            if (!z2) {
                return fhVar.n3();
            }
            return (int) (((fVar.gv(view2) - fVar.fb(view)) / (Math.abs(wVar.ap(view) - wVar.ap(view2)) + 1)) * fhVar.n3());
        }
        return 0;
    }
}
