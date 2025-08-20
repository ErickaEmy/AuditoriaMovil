package com.facebook.ads.redexgen.X;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.uv.v7.R;
import java.util.Arrays;
import java.util.Map;
/* loaded from: assets/audience_network.dex */
public class V4 implements View.OnClickListener, View.OnLongClickListener, View.OnTouchListener, InterfaceC04407b {
    public static byte[] A02;
    public final C1116Yn A00;
    public final /* synthetic */ V2 A01;

    static {
        A02();
    }

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 59);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{43, 14, 74, 9, 11, 4, 4, 5, 30, 74, 8, 15, 74, 9, 6, 3, 9, 1, 15, 14, 74, 8, 15, 12, 5, 24, 15, 74, 3, 30, 74, 3, 25, 74, 28, 3, 15, 29, 15, 14, 68, 66, 109, 104, 98, 106, 114, 33, 105, 96, 113, 113, 100, 111, 100, 101, 33, 117, 110, 110, 33, 103, 96, 114, 117, 47, 20, 16, 19, 39, 54, 59, 55, 60, 49, 55, 28, 55, 38, 37, 61, 32, 57, 56, 25, 86, 2, 25, 3, 21, 30, 86, 18, 23, 2, 23, 86, 4, 19, 21, 25, 4, 18, 19, 18, 90, 86, 6, 26, 19, 23, 5, 19, 86, 19, 24, 5, 3, 4, 19, 86, 2, 25, 3, 21, 30, 86, 19, 0, 19, 24, 2, 5, 86, 4, 19, 23, 21, 30, 86, 2, 30, 19, 86, 23, 18, 86, 32, 31, 19, 1, 86, 20, 15, 86, 4, 19, 2, 3, 4, 24, 31, 24, 17, 86, 16, 23, 26, 5, 19, 86, 31, 16, 86, 15, 25, 3, 86, 31, 24, 2, 19, 4, 21, 19, 6, 2, 86, 2, 30, 19, 86, 19, 0, 19, 24, 2, 88, 33, 39, 60, 94, 68, 89};
    }

    public V4(V2 v2, C1116Yn c1116Yn) {
        this.A01 = v2;
        this.A00 = c1116Yn;
    }

    public /* synthetic */ V4(V2 v2, C1116Yn c1116Yn, VD vd) {
        this(v2, c1116Yn);
    }

    private Map<String, String> A01() {
        RE re;
        C0775Lg c0775Lg;
        JS js;
        boolean z2;
        boolean z3;
        JS js2;
        C0829Ni c0829Ni = new C0829Ni();
        re = this.A01.A0R;
        C0829Ni A03 = c0829Ni.A03(re);
        c0775Lg = this.A01.A0f;
        Map<String, String> A05 = A03.A02(c0775Lg).A05();
        js = this.A01.A0I;
        if (js != null) {
            js2 = this.A01.A0I;
            A05.put(A00(201, 3, 11), String.valueOf(js2.A04()));
        }
        z2 = this.A01.A0W;
        if (z2) {
            z3 = this.A01.A0W;
            A05.put(A00(198, 3, 116), String.valueOf(z3));
        }
        return A05;
    }

    private void A03(Map<String, String> extraData) {
        if (this.A01.A0a != null) {
            this.A01.A0a.A0M(extraData);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC04407b
    public final C1116Yn A5t() {
        return this.A00;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        C0775Lg c0775Lg;
        C1116Yn c1116Yn;
        C0775Lg c0775Lg2;
        C1116Yn c1116Yn2;
        C0775Lg c0775Lg3;
        C0775Lg c0775Lg4;
        if (KL.A02(this)) {
            return;
        }
        try {
            c0775Lg = this.A01.A0f;
            boolean A08 = c0775Lg.A08();
            String A00 = A00(66, 17, 105);
            if (!A08) {
                Log.e(A00, A00(83, R.styleable.AppCompatTheme_tooltipFrameBackground, 77));
            }
            c1116Yn = this.A01.A0c;
            int minimumElapsedTime = C0705Ih.A0G(c1116Yn);
            if (minimumElapsedTime >= 0) {
                c0775Lg3 = this.A01.A0f;
                if (c0775Lg3.A03() < minimumElapsedTime) {
                    c0775Lg4 = this.A01.A0f;
                    if (!c0775Lg4.A07()) {
                        Log.e(A00, A00(0, 41, 81));
                        return;
                    } else {
                        Log.e(A00, A00(41, 25, 58));
                        return;
                    }
                }
            }
            c0775Lg2 = this.A01.A0f;
            c1116Yn2 = this.A01.A0c;
            if (c0775Lg2.A09(c1116Yn2)) {
                if (this.A01.A0a != null) {
                    this.A01.A0a.A0N(A01());
                    return;
                }
                return;
            }
            A03(A01());
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        View view2;
        C0827Ng c0827Ng;
        C0827Ng c0827Ng2;
        View view3;
        View view4;
        C0827Ng c0827Ng3;
        C0827Ng c0827Ng4;
        view2 = this.A01.A04;
        if (view2 != null) {
            c0827Ng = this.A01.A0L;
            if (c0827Ng != null) {
                c0827Ng2 = this.A01.A0L;
                view3 = this.A01.A04;
                int width = view3.getWidth();
                view4 = this.A01.A04;
                c0827Ng2.setBounds(0, 0, width, view4.getHeight());
                c0827Ng3 = this.A01.A0L;
                c0827Ng4 = this.A01.A0L;
                c0827Ng3.A0D(!c0827Ng4.A0E());
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        C0775Lg c0775Lg;
        C1116Yn c1116Yn;
        View view2;
        View.OnTouchListener onTouchListener;
        View.OnTouchListener onTouchListener2;
        c0775Lg = this.A01.A0f;
        c1116Yn = this.A01.A0c;
        view2 = this.A01.A04;
        c0775Lg.A06(c1116Yn, motionEvent, view2, view);
        onTouchListener = this.A01.A02;
        if (onTouchListener != null) {
            onTouchListener2 = this.A01.A02;
            if (onTouchListener2.onTouch(view, motionEvent)) {
                return true;
            }
        }
        return false;
    }
}
