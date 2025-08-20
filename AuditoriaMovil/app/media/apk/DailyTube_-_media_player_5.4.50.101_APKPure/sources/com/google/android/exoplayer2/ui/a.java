package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ui.SubtitleView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import mn.wz;
import v5.j5;
/* loaded from: classes.dex */
public final class a extends FrameLayout implements SubtitleView.y {

    /* renamed from: f  reason: collision with root package name */
    public float f4827f;

    /* renamed from: fb  reason: collision with root package name */
    public List<qh.n3> f4828fb;

    /* renamed from: s  reason: collision with root package name */
    public mn.n3 f4829s;

    /* renamed from: t  reason: collision with root package name */
    public int f4830t;

    /* renamed from: v  reason: collision with root package name */
    public final WebView f4831v;

    /* renamed from: w  reason: collision with root package name */
    public float f4832w;
    public final com.google.android.exoplayer2.ui.y y;

    /* loaded from: classes.dex */
    public static /* synthetic */ class n3 {
        public static final /* synthetic */ int[] y;

        static {
            int[] iArr = new int[Layout.Alignment.values().length];
            y = iArr;
            try {
                iArr[Layout.Alignment.ALIGN_NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                y[Layout.Alignment.ALIGN_OPPOSITE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                y[Layout.Alignment.ALIGN_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes.dex */
    public class y extends WebView {
        public y(a aVar, Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public final void n3(WebViewClient webViewClient) {
            super.setWebViewClient(webViewClient);
        }

        @Override // android.webkit.WebView, android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            super.onTouchEvent(motionEvent);
            return false;
        }

        @Override // android.view.View
        public boolean performClick() {
            super.performClick();
            return false;
        }

        @Override // android.webkit.WebView
        public void setWebViewClient(WebViewClient webViewClient) {
            WebViewSubtitleOutput$1$_boostWeave.HookProxy_setMyWebViewClient(this, webViewClient);
        }
    }

    public a(Context context) {
        this(context, null);
    }

    public static String a(int i) {
        if (i != 1) {
            if (i != 2) {
                return "horizontal-tb";
            }
            return "vertical-lr";
        }
        return "vertical-rl";
    }

    public static String gv(mn.n3 n3Var) {
        int i = n3Var.f11511gv;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return "unset";
                    }
                    return j5.rz("-0.05em -0.05em 0.15em %s", mn.a.n3(n3Var.f11513v));
                }
                return j5.rz("0.06em 0.08em 0.15em %s", mn.a.n3(n3Var.f11513v));
            }
            return j5.rz("0.1em 0.12em 0.15em %s", mn.a.n3(n3Var.f11513v));
        }
        return j5.rz("1px 1px 0 %1$s, 1px -1px 0 %1$s, -1px 1px 0 %1$s, -1px -1px 0 %1$s", mn.a.n3(n3Var.f11513v));
    }

    public static int n3(int i) {
        if (i != 1) {
            return i != 2 ? 0 : -100;
        }
        return -50;
    }

    public static String s(qh.n3 n3Var) {
        String str;
        float f4 = n3Var.f12865d;
        if (f4 != 0.0f) {
            int i = n3Var.f12870fh;
            if (i != 2 && i != 1) {
                str = "skewX";
            } else {
                str = "skewY";
            }
            return j5.rz("%s(%.2fdeg)", str, Float.valueOf(f4));
        }
        return "";
    }

    public static String zn(@Nullable Layout.Alignment alignment) {
        if (alignment == null) {
            return "center";
        }
        int i = n3.y[alignment.ordinal()];
        if (i != 1) {
            if (i != 2) {
                return "center";
            }
            return "end";
        }
        return "start";
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0148, code lost:
        if (r13 != false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x014b, code lost:
        r21 = "left";
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x014d, code lost:
        r23 = "top";
        r13 = 2;
        r22 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0153, code lost:
        if (r13 != false) goto L54;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0243  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c5() {
        /*
            Method dump skipped, instructions count: 711
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.a.c5():void");
    }

    public void fb() {
        this.f4831v.destroy();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i, int i5, int i6, int i8) {
        super.onLayout(z2, i, i5, i6, i8);
        if (z2 && !this.f4828fb.isEmpty()) {
            c5();
        }
    }

    public final String v(int i, float f4) {
        float s2 = wz.s(i, f4, getHeight(), (getHeight() - getPaddingTop()) - getPaddingBottom());
        if (s2 == -3.4028235E38f) {
            return "unset";
        }
        return j5.rz("%.2fpx", Float.valueOf(s2 / getContext().getResources().getDisplayMetrics().density));
    }

    @Override // com.google.android.exoplayer2.ui.SubtitleView.y
    public void y(List<qh.n3> list, mn.n3 n3Var, float f4, int i, float f6) {
        this.f4829s = n3Var;
        this.f4827f = f4;
        this.f4830t = i;
        this.f4832w = f6;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i5 = 0; i5 < list.size(); i5++) {
            qh.n3 n3Var2 = list.get(i5);
            if (n3Var2.f12874s != null) {
                arrayList.add(n3Var2);
            } else {
                arrayList2.add(n3Var2);
            }
        }
        if (!this.f4828fb.isEmpty() || !arrayList2.isEmpty()) {
            this.f4828fb = arrayList2;
            c5();
        }
        this.y.y(arrayList, n3Var, f4, i, f6);
        invalidate();
    }

    public a(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4828fb = Collections.emptyList();
        this.f4829s = mn.n3.f11509fb;
        this.f4827f = 0.0533f;
        this.f4830t = 0;
        this.f4832w = 0.08f;
        com.google.android.exoplayer2.ui.y yVar = new com.google.android.exoplayer2.ui.y(context, attributeSet);
        this.y = yVar;
        y yVar2 = new y(this, context, attributeSet);
        this.f4831v = yVar2;
        yVar2.setBackgroundColor(0);
        addView(yVar);
        addView(yVar2);
    }
}
