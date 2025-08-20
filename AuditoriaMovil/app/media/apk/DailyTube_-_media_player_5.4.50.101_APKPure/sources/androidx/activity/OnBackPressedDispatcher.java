package androidx.activity;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.a;
import androidx.lifecycle.v;
import gv.gv;
import java.util.ArrayDeque;
import java.util.Iterator;
import y5.co;
/* loaded from: classes.dex */
public final class OnBackPressedDispatcher {

    /* renamed from: n3  reason: collision with root package name */
    public final ArrayDeque<gv> f595n3 = new ArrayDeque<>();
    @Nullable
    public final Runnable y;

    /* loaded from: classes.dex */
    public class LifecycleOnBackPressedCancellable implements a, gv.y {
        @Nullable

        /* renamed from: fb  reason: collision with root package name */
        public gv.y f596fb;

        /* renamed from: v  reason: collision with root package name */
        public final gv f598v;
        public final v y;

        public LifecycleOnBackPressedCancellable(@NonNull v vVar, @NonNull gv gvVar) {
            this.y = vVar;
            this.f598v = gvVar;
            vVar.y(this);
        }

        @Override // gv.y
        public void cancel() {
            this.y.zn(this);
            this.f598v.removeCancellable(this);
            gv.y yVar = this.f596fb;
            if (yVar != null) {
                yVar.cancel();
                this.f596fb = null;
            }
        }

        @Override // androidx.lifecycle.a
        public void onStateChanged(@NonNull co coVar, @NonNull v.n3 n3Var) {
            if (n3Var == v.n3.ON_START) {
                this.f596fb = OnBackPressedDispatcher.this.zn(this.f598v);
            } else if (n3Var == v.n3.ON_STOP) {
                gv.y yVar = this.f596fb;
                if (yVar != null) {
                    yVar.cancel();
                }
            } else if (n3Var == v.n3.ON_DESTROY) {
                cancel();
            }
        }
    }

    /* loaded from: classes.dex */
    public class y implements gv.y {
        public final gv y;

        public y(gv gvVar) {
            this.y = gvVar;
        }

        @Override // gv.y
        public void cancel() {
            OnBackPressedDispatcher.this.f595n3.remove(this.y);
            this.y.removeCancellable(this);
        }
    }

    public OnBackPressedDispatcher(@Nullable Runnable runnable) {
        this.y = runnable;
    }

    public void gv() {
        Iterator<gv> descendingIterator = this.f595n3.descendingIterator();
        while (descendingIterator.hasNext()) {
            gv next = descendingIterator.next();
            if (next.isEnabled()) {
                next.handleOnBackPressed();
                return;
            }
        }
        Runnable runnable = this.y;
        if (runnable != null) {
            runnable.run();
        }
    }

    @SuppressLint({"LambdaLast"})
    public void n3(@NonNull co coVar, @NonNull gv gvVar) {
        v lifecycle = coVar.getLifecycle();
        if (lifecycle.n3() == v.zn.DESTROYED) {
            return;
        }
        gvVar.addCancellable(new LifecycleOnBackPressedCancellable(lifecycle, gvVar));
    }

    public void y(@NonNull gv gvVar) {
        zn(gvVar);
    }

    @NonNull
    public gv.y zn(@NonNull gv gvVar) {
        this.f595n3.add(gvVar);
        y yVar = new y(gvVar);
        gvVar.addCancellable(yVar);
        return yVar;
    }
}
