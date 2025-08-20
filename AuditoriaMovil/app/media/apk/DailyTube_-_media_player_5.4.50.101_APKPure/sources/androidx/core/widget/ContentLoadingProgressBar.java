package androidx.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.ContentLoadingProgressBar;
/* loaded from: classes.dex */
public class ContentLoadingProgressBar extends ProgressBar {

    /* renamed from: f  reason: collision with root package name */
    public final Runnable f2338f;

    /* renamed from: fb  reason: collision with root package name */
    public boolean f2339fb;

    /* renamed from: s  reason: collision with root package name */
    public boolean f2340s;

    /* renamed from: t  reason: collision with root package name */
    public final Runnable f2341t;

    /* renamed from: v  reason: collision with root package name */
    public boolean f2342v;
    public long y;

    public ContentLoadingProgressBar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.y = -1L;
        this.f2338f = new Runnable() { // from class: j.gv
            @Override // java.lang.Runnable
            public final void run() {
                ContentLoadingProgressBar.this.fb();
            }
        };
        this.f2341t = new Runnable() { // from class: j.v
            @Override // java.lang.Runnable
            public final void run() {
                ContentLoadingProgressBar.this.s();
            }
        };
    }

    public final void a() {
        this.f2340s = true;
        removeCallbacks(this.f2341t);
        this.f2339fb = false;
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = this.y;
        long j4 = currentTimeMillis - j2;
        if (j4 < 500 && j2 != -1) {
            if (!this.f2342v) {
                postDelayed(this.f2338f, 500 - j4);
                this.f2342v = true;
                return;
            }
            return;
        }
        setVisibility(8);
    }

    public final void c5() {
        removeCallbacks(this.f2338f);
        removeCallbacks(this.f2341t);
    }

    public final void f() {
        this.y = -1L;
        this.f2340s = false;
        removeCallbacks(this.f2338f);
        this.f2342v = false;
        if (!this.f2339fb) {
            postDelayed(this.f2341t, 500L);
            this.f2339fb = true;
        }
    }

    public final /* synthetic */ void fb() {
        this.f2342v = false;
        this.y = -1L;
        setVisibility(8);
    }

    public void i9() {
        post(new Runnable() { // from class: j.a
            @Override // java.lang.Runnable
            public final void run() {
                ContentLoadingProgressBar.this.f();
            }
        });
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        c5();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c5();
    }

    public final /* synthetic */ void s() {
        this.f2339fb = false;
        if (!this.f2340s) {
            this.y = System.currentTimeMillis();
            setVisibility(0);
        }
    }

    public void v() {
        post(new Runnable() { // from class: j.fb
            @Override // java.lang.Runnable
            public final void run() {
                ContentLoadingProgressBar.this.a();
            }
        });
    }
}
