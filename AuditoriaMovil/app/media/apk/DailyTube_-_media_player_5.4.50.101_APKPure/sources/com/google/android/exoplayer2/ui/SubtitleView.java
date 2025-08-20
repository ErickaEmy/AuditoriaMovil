package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.accessibility.CaptioningManager;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import mn.wz;
import qh.n3;
import v5.j5;
/* loaded from: classes.dex */
public final class SubtitleView extends FrameLayout {

    /* renamed from: co  reason: collision with root package name */
    public y f4805co;

    /* renamed from: f  reason: collision with root package name */
    public float f4806f;

    /* renamed from: fb  reason: collision with root package name */
    public int f4807fb;

    /* renamed from: p  reason: collision with root package name */
    public int f4808p;

    /* renamed from: s  reason: collision with root package name */
    public float f4809s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f4810t;

    /* renamed from: v  reason: collision with root package name */
    public mn.n3 f4811v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f4812w;
    public List<qh.n3> y;

    /* renamed from: z  reason: collision with root package name */
    public View f4813z;

    /* loaded from: classes.dex */
    public interface y {
        void y(List<qh.n3> list, mn.n3 n3Var, float f4, int i, float f6);
    }

    public SubtitleView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.y = Collections.emptyList();
        this.f4811v = mn.n3.f11509fb;
        this.f4807fb = 0;
        this.f4809s = 0.0533f;
        this.f4806f = 0.08f;
        this.f4810t = true;
        this.f4812w = true;
        com.google.android.exoplayer2.ui.y yVar = new com.google.android.exoplayer2.ui.y(context);
        this.f4805co = yVar;
        this.f4813z = yVar;
        addView(yVar);
        this.f4808p = 1;
    }

    private List<qh.n3> getCuesWithStylingPreferencesApplied() {
        if (this.f4810t && this.f4812w) {
            return this.y;
        }
        ArrayList arrayList = new ArrayList(this.y.size());
        for (int i = 0; i < this.y.size(); i++) {
            arrayList.add(y(this.y.get(i)));
        }
        return arrayList;
    }

    private float getUserCaptionFontScale() {
        CaptioningManager captioningManager;
        if (j5.y < 19 || isInEditMode() || (captioningManager = (CaptioningManager) getContext().getSystemService("captioning")) == null || !captioningManager.isEnabled()) {
            return 1.0f;
        }
        return captioningManager.getFontScale();
    }

    private mn.n3 getUserCaptionStyle() {
        if (j5.y >= 19 && !isInEditMode()) {
            CaptioningManager captioningManager = (CaptioningManager) getContext().getSystemService("captioning");
            if (captioningManager != null && captioningManager.isEnabled()) {
                return mn.n3.y(captioningManager.getUserStyle());
            }
            return mn.n3.f11509fb;
        }
        return mn.n3.f11509fb;
    }

    private <T extends View & y> void setView(T t2) {
        removeView(this.f4813z);
        View view = this.f4813z;
        if (view instanceof a) {
            ((a) view).fb();
        }
        this.f4813z = t2;
        this.f4805co = t2;
        addView(t2);
    }

    public void a() {
        setFractionalTextSize(getUserCaptionFontScale() * 0.0533f);
    }

    public final void fb() {
        this.f4805co.y(getCuesWithStylingPreferencesApplied(), this.f4811v, this.f4809s, this.f4807fb, this.f4806f);
    }

    public final void gv(int i, float f4) {
        this.f4807fb = i;
        this.f4809s = f4;
        fb();
    }

    public void n3(int i, float f4) {
        Resources resources;
        Context context = getContext();
        if (context == null) {
            resources = Resources.getSystem();
        } else {
            resources = context.getResources();
        }
        gv(2, TypedValue.applyDimension(i, f4, resources.getDisplayMetrics()));
    }

    public void setApplyEmbeddedFontSizes(boolean z2) {
        this.f4812w = z2;
        fb();
    }

    public void setApplyEmbeddedStyles(boolean z2) {
        this.f4810t = z2;
        fb();
    }

    public void setBottomPaddingFraction(float f4) {
        this.f4806f = f4;
        fb();
    }

    public void setCues(@Nullable List<qh.n3> list) {
        if (list == null) {
            list = Collections.emptyList();
        }
        this.y = list;
        fb();
    }

    public void setFractionalTextSize(float f4) {
        zn(f4, false);
    }

    public void setStyle(mn.n3 n3Var) {
        this.f4811v = n3Var;
        fb();
    }

    public void setViewType(int i) {
        if (this.f4808p == i) {
            return;
        }
        if (i != 1) {
            if (i == 2) {
                setView(new a(getContext()));
            } else {
                throw new IllegalArgumentException();
            }
        } else {
            setView(new com.google.android.exoplayer2.ui.y(getContext()));
        }
        this.f4808p = i;
    }

    public void v() {
        setStyle(getUserCaptionStyle());
    }

    public final qh.n3 y(qh.n3 n3Var) {
        n3.C0187n3 n32 = n3Var.n3();
        if (!this.f4810t) {
            wz.v(n32);
        } else if (!this.f4812w) {
            wz.a(n32);
        }
        return n32.y();
    }

    public void zn(float f4, boolean z2) {
        gv(z2 ? 1 : 0, f4);
    }
}
