package qg;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes.dex */
public class c5 extends LinearLayoutManager {

    /* loaded from: classes.dex */
    public class y extends androidx.recyclerview.widget.s {
        public y(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.s
        public float x4(DisplayMetrics displayMetrics) {
            return 100.0f / displayMetrics.densityDpi;
        }
    }

    public c5(Context context, int i, boolean z2) {
        super(context, i, z2);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.w
    public void ob(RecyclerView recyclerView, RecyclerView.fh fhVar, int i) {
        y yVar = new y(recyclerView.getContext());
        yVar.w(i);
        vb(yVar);
    }
}
