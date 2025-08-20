package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ui.SubtitleView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import mn.f;
import mn.wz;
import qh.n3;
/* loaded from: classes.dex */
public final class y extends View implements SubtitleView.y {

    /* renamed from: f  reason: collision with root package name */
    public mn.n3 f4880f;

    /* renamed from: fb  reason: collision with root package name */
    public int f4881fb;

    /* renamed from: s  reason: collision with root package name */
    public float f4882s;

    /* renamed from: t  reason: collision with root package name */
    public float f4883t;

    /* renamed from: v  reason: collision with root package name */
    public List<qh.n3> f4884v;
    public final List<f> y;

    public y(Context context) {
        this(context, null);
    }

    public static qh.n3 n3(qh.n3 n3Var) {
        n3.C0187n3 w4 = n3Var.n3().f(-3.4028235E38f).t(Integer.MIN_VALUE).w(null);
        if (n3Var.f12875t == 0) {
            w4.s(1.0f - n3Var.f12867f, 0);
        } else {
            w4.s((-n3Var.f12867f) - 1.0f, 1);
        }
        int i = n3Var.f12877w;
        if (i != 0) {
            if (i == 2) {
                w4.c5(0);
            }
        } else {
            w4.c5(2);
        }
        return w4.y();
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas canvas) {
        List<qh.n3> list = this.f4884v;
        if (list.isEmpty()) {
            return;
        }
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int paddingBottom = height - getPaddingBottom();
        if (paddingBottom > paddingTop && width > paddingLeft) {
            int i = paddingBottom - paddingTop;
            float s2 = wz.s(this.f4881fb, this.f4882s, height, i);
            if (s2 <= 0.0f) {
                return;
            }
            int size = list.size();
            int i5 = 0;
            while (i5 < size) {
                qh.n3 n3Var = list.get(i5);
                if (n3Var.f12870fh != Integer.MIN_VALUE) {
                    n3Var = n3(n3Var);
                }
                qh.n3 n3Var2 = n3Var;
                int i6 = paddingBottom;
                this.y.get(i5).n3(n3Var2, this.f4880f, s2, wz.s(n3Var2.f12863c, n3Var2.f12866d0, height, i), this.f4883t, canvas, paddingLeft, paddingTop, width, i6);
                i5++;
                size = size;
                i = i;
                paddingBottom = i6;
                width = width;
            }
        }
    }

    @Override // com.google.android.exoplayer2.ui.SubtitleView.y
    public void y(List<qh.n3> list, mn.n3 n3Var, float f4, int i, float f6) {
        this.f4884v = list;
        this.f4880f = n3Var;
        this.f4882s = f4;
        this.f4881fb = i;
        this.f4883t = f6;
        while (this.y.size() < list.size()) {
            this.y.add(new f(getContext()));
        }
        invalidate();
    }

    public y(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.y = new ArrayList();
        this.f4884v = Collections.emptyList();
        this.f4881fb = 0;
        this.f4882s = 0.0533f;
        this.f4880f = mn.n3.f11509fb;
        this.f4883t = 0.08f;
    }
}
