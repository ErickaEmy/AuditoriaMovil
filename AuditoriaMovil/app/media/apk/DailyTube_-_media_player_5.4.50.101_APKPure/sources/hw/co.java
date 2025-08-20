package hw;

import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public final class co implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* renamed from: fb  reason: collision with root package name */
    public final Runnable f8935fb;

    /* renamed from: v  reason: collision with root package name */
    public ViewTreeObserver f8936v;
    public final View y;

    public co(View view, Runnable runnable) {
        this.y = view;
        this.f8936v = view.getViewTreeObserver();
        this.f8935fb = runnable;
    }

    @NonNull
    public static co y(@NonNull View view, @NonNull Runnable runnable) {
        if (view != null) {
            if (runnable != null) {
                co coVar = new co(view, runnable);
                view.getViewTreeObserver().addOnPreDrawListener(coVar);
                view.addOnAttachStateChangeListener(coVar);
                return coVar;
            }
            throw new NullPointerException("runnable == null");
        }
        throw new NullPointerException("view == null");
    }

    public void n3() {
        if (this.f8936v.isAlive()) {
            this.f8936v.removeOnPreDrawListener(this);
        } else {
            this.y.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.y.removeOnAttachStateChangeListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        n3();
        this.f8935fb.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(@NonNull View view) {
        this.f8936v = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(@NonNull View view) {
        n3();
    }
}
