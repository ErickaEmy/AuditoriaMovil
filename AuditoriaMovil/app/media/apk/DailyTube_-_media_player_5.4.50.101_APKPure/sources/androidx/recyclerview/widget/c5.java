package androidx.recyclerview.widget;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes.dex */
public class c5 extends w {
    @Nullable

    /* renamed from: gv  reason: collision with root package name */
    public f f3229gv;
    @Nullable

    /* renamed from: v  reason: collision with root package name */
    public f f3230v;

    @Override // androidx.recyclerview.widget.w
    public View fb(RecyclerView.w wVar) {
        if (wVar.x4()) {
            return tl(wVar, xc(wVar));
        }
        if (wVar.r()) {
            return tl(wVar, wz(wVar));
        }
        return null;
    }

    public final int t(@NonNull View view, f fVar) {
        return (fVar.fb(view) + (fVar.v(view) / 2)) - (fVar.tl() + (fVar.wz() / 2));
    }

    @Nullable
    public final View tl(RecyclerView.w wVar, f fVar) {
        int oz2 = wVar.oz();
        View view = null;
        if (oz2 == 0) {
            return null;
        }
        int tl2 = fVar.tl() + (fVar.wz() / 2);
        int i = Integer.MAX_VALUE;
        for (int i5 = 0; i5 < oz2; i5++) {
            View j2 = wVar.j(i5);
            int abs = Math.abs((fVar.fb(j2) + (fVar.v(j2) / 2)) - tl2);
            if (abs < i) {
                view = j2;
                i = abs;
            }
        }
        return view;
    }

    @NonNull
    public final f wz(@NonNull RecyclerView.w wVar) {
        f fVar = this.f3230v;
        if (fVar == null || fVar.y != wVar) {
            this.f3230v = f.y(wVar);
        }
        return this.f3230v;
    }

    @NonNull
    public final f xc(@NonNull RecyclerView.w wVar) {
        f fVar = this.f3229gv;
        if (fVar == null || fVar.y != wVar) {
            this.f3229gv = f.zn(wVar);
        }
        return this.f3229gv;
    }

    @Override // androidx.recyclerview.widget.w
    public int[] zn(@NonNull RecyclerView.w wVar, @NonNull View view) {
        int[] iArr = new int[2];
        if (wVar.r()) {
            iArr[0] = t(view, wz(wVar));
        } else {
            iArr[0] = 0;
        }
        if (wVar.x4()) {
            iArr[1] = t(view, xc(wVar));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }
}
