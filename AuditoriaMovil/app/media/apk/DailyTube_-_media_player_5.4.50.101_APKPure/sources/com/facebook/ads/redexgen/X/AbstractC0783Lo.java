package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build;
import android.text.Layout;
import android.transition.AutoTransition;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.TextView;
import android.widget.Toast;
import com.uv.v7.R;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
/* renamed from: com.facebook.ads.redexgen.X.Lo  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public abstract class AbstractC0783Lo {
    public static byte[] A00;
    public static String[] A01 = {"T9yeGAB86XK0vsZmNpfh4sIozppRZOgX", "Zi2TG3AXo50avc5D0Zq9wx", "JqBKj5K49VPZ3Gy9qBscEl", "4Ni4MdhmG8L", "r65r3", "RNCTQQIFlAbprT7c08Eivsd0jPtRWtbK", "BqjiC5lxzxq0feSMCCnGMnwMzT1DFPOJ", "3asmvLId1fZdr9gBLrqbDNcfpMudytXC"};
    public static final int A02;
    public static final int A03;
    public static final ConcurrentHashMap<Integer, Integer> A04;
    public static final AtomicInteger A05;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static int A03(TextView textView) {
        Layout layout;
        int lineCount;
        if (textView == null || textView.getLayout() == null || (lineCount = (layout = textView.getLayout()).getLineCount()) <= 0) {
            return 0;
        }
        double ellipsisCount = layout.getEllipsisCount(lineCount - 1);
        return (int) Math.ceil(ellipsisCount / (textView.getText().length() - ellipsisCount));
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static Drawable A09(int i, int i5, int i6, int i8) {
        return Build.VERSION.SDK_INT >= 21 ? new RippleDrawable(ColorStateList.valueOf(i5), A06(i, i8), A07(i6, i8)) : A0A(i, i5, i8);
    }

    public static String A0D(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 87);
        }
        return new String(copyOfRange);
    }

    public static void A0E() {
        A00 = new byte[]{-24, -26, -15, -15, -22, -9, -39, -2, -11, -22, 21, 30, 27, 21, 29, 17, 37, 33, 39, 36, 21, 23, 58, 61, 64, 72, 57, 70, 57, 56, 51, 55, 64, 61, 55, 63, 51, 56, 57, 64, 53, 77, 51, 65, 71, 46, 51, 57, 42, 55, 56, 57, 46, 57, 46, 38, 49, 33, 43, 23, 27, 42, 29, 25, 44, 33, 46, 29, 23, 25, 43, 23, 27, 44, 25, 23, 46, -22, -11, -24, -6, -28, -11, -25, -24, -25, -30, -7, -20, -25, -24, -14, -8, -26, -13, -8, -78, -8, -22, -9, -18, -21, -78, -14, -22, -23, -18, -6, -14, -52, -59, -64, -56, -52, -68, -96, -69, -33, -35, -49, -36, -51, -42, -45, -51, -43};
    }

    static {
        A0E();
        A03 = AbstractC03322p.A01(-1, 0);
        A02 = AbstractC03322p.A01(-16777216, R.styleable.AppCompatTheme_tooltipFrameBackground);
        A05 = new AtomicInteger(1);
        A04 = new ConcurrentHashMap<>();
    }

    public static int A00() {
        AtomicInteger atomicInteger;
        int newValue;
        int result;
        do {
            atomicInteger = A05;
            newValue = atomicInteger.get();
            result = newValue + 1;
            if (result > 16777215) {
                result = 1;
            }
        } while (!atomicInteger.compareAndSet(newValue, result));
        return newValue;
    }

    public static int A01(int i) {
        return (int) TypedValue.applyDimension(2, i, LD.A03);
    }

    public static int A02(int i) {
        if (A0b(i)) {
            return AbstractC03322p.A02(i, -1, 0.4f);
        }
        return AbstractC03322p.A02(i, -16777216, 0.2f);
    }

    public static int A04(TextView textView, int i) {
        int lineHeightTitle = A03(textView);
        int lines = 0;
        int extraLinesRequired = textView.getLineHeight();
        while (i > extraLinesRequired && lines < lineHeightTitle) {
            lines++;
            i -= extraLinesRequired;
        }
        return lines;
    }

    public static Drawable A05(int i, int i5) {
        return A08(i, A02(i), i5);
    }

    public static Drawable A06(int i, int i5) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i);
        gradientDrawable.setCornerRadius(i5);
        return gradientDrawable;
    }

    public static Drawable A07(int i, int i5) {
        float[] fArr = new float[8];
        Arrays.fill(fArr, i5);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(fArr, null, null));
        shapeDrawable.getPaint().setColor(i);
        return shapeDrawable;
    }

    public static Drawable A08(int i, int i5, int i6) {
        return A09(i, i5, i, i6);
    }

    public static StateListDrawable A0A(int i, int i5, int i6) {
        return A0B(new int[][]{new int[]{16842919}, new int[0]}, new int[]{i5, i}, i6);
    }

    public static StateListDrawable A0B(int[][] iArr, int[] iArr2, int i) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        for (int i5 = 0; i5 < iArr.length; i5++) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(iArr2[i5]);
            gradientDrawable.setCornerRadius(i);
            stateListDrawable.addState(iArr[i5], gradientDrawable);
        }
        return stateListDrawable;
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0005 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.widget.TextView A0C(android.view.ViewGroup r3) {
        /*
            r2 = 0
        L1:
            int r0 = r3.getChildCount()
            if (r2 >= r0) goto L1e
            android.view.View r1 = r3.getChildAt(r2)
            boolean r0 = r1 instanceof android.widget.TextView
            if (r0 == 0) goto L12
            android.widget.TextView r1 = (android.widget.TextView) r1
            return r1
        L12:
            boolean r0 = r1 instanceof android.view.ViewGroup
            if (r0 == 0) goto L1b
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            A0C(r1)
        L1b:
            int r2 = r2 + 1
            goto L1
        L1e:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC0783Lo.A0C(android.view.ViewGroup):android.widget.TextView");
    }

    public static void A0F(int i, View view) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.8f, 1.0f, 0.8f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(i / 3);
        scaleAnimation.setInterpolator(new AccelerateInterpolator());
        ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.8f, 1.0f, 0.8f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation2.setDuration((i / 3) * 2);
        scaleAnimation2.setInterpolator(new BounceInterpolator());
        scaleAnimation.setAnimationListener(new C1005Uc(view, scaleAnimation2));
        view.startAnimation(scaleAnimation);
    }

    public static void A0G(int i, View view) {
        Integer viewId = A04.get(Integer.valueOf(i));
        if (viewId != null) {
            view.setId(viewId.intValue());
        } else {
            A0K(view);
        }
    }

    public static void A0H(View view) {
        A0N(view, 8);
    }

    public static void A0I(View view) {
        ViewParent parent = view.getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            A0T((ViewGroup) parent);
        }
    }

    public static void A0J(View view) {
        ViewGroup parent;
        if (view != null && (parent = (ViewGroup) view.getParent()) != null) {
            parent.removeView(view);
        }
    }

    public static void A0K(View view) {
        if (view == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            view.setId(View.generateViewId());
        } else {
            view.setId(A00());
        }
    }

    public static void A0L(View view) {
        A0N(view, 0);
    }

    public static void A0M(View view, int i) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(new ColorDrawable(i));
        } else {
            view.setBackgroundDrawable(new ColorDrawable(i));
        }
    }

    public static void A0N(View view, int i) {
        if (view != null) {
            view.setVisibility(i);
        }
    }

    public static void A0O(View view, int i, int i5) {
        A0S(view, A08(i, A02(i), i5));
    }

    public static void A0P(View view, int i, int i5, int i6) {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{A03, A02});
        gradientDrawable.setCornerRadius(i);
        gradientDrawable.setStroke(i5, i6);
        A0S(view, gradientDrawable);
    }

    public static void A0Q(View view, int i, int i5, int i6) {
        A0S(view, A09(i, A02(i), i5, i6));
    }

    public static void A0R(View view, Context context) {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{A03, A02});
        gradientDrawable.setCornerRadius(0.0f);
        A0S(view, gradientDrawable);
    }

    public static void A0S(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    public static void A0T(ViewGroup viewGroup) {
        if (Build.VERSION.SDK_INT > 19) {
            A0U(viewGroup, 200);
        }
    }

    public static void A0U(ViewGroup viewGroup, int i) {
        if (Build.VERSION.SDK_INT > 19) {
            A0W(viewGroup, new AutoTransition(), i);
        }
    }

    public static void A0V(ViewGroup viewGroup, Transition transition) {
        if (Build.VERSION.SDK_INT > 19) {
            A0W(viewGroup, transition, 200);
        }
    }

    public static void A0W(ViewGroup viewGroup, Transition transition, int i) {
        transition.setDuration(i);
        transition.setInterpolator(new AccelerateDecelerateInterpolator());
        TransitionManager.beginDelayedTransition(viewGroup, transition);
    }

    public static void A0X(TextView textView, boolean z2, int i) {
        Typeface typeface;
        if (z2) {
            typeface = Build.VERSION.SDK_INT >= 21 ? Typeface.create(A0D(92, 17, 46), 0) : Typeface.create(Typeface.SANS_SERIF, 1);
        } else {
            Typeface typeface2 = Typeface.SANS_SERIF;
            typeface = Typeface.create(typeface2, 0);
        }
        textView.setTypeface(typeface);
        textView.setTextSize(2, i);
    }

    public static void A0Y(Toast toast, String str, int i, int i5, int i6) {
        if (toast == null) {
            return;
        }
        toast.setGravity(i, i5, i6);
        TextView A0C = A0C((ViewGroup) toast.getView());
        if (A0C != null) {
            A0C.setText(str);
            A0C.setGravity(17);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0053, code lost:
        if (r3.equals(A0D(45, 12, com.uv.v7.R.styleable.AppCompatTheme_textColorAlertDialogListItem)) != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0055, code lost:
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x006f, code lost:
        if (r3.equals(A0D(45, 8, 48)) != false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void A0Z(java.util.Map<java.lang.String, java.lang.String> r5, com.facebook.ads.redexgen.X.AbstractC1219b5 r6) {
        /*
            Method dump skipped, instructions count: 252
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC0783Lo.A0Z(java.util.Map, com.facebook.ads.redexgen.X.b5):void");
    }

    public static void A0a(View... viewArr) {
        for (View view : viewArr) {
            A0J(view);
        }
    }

    public static boolean A0b(int i) {
        return AbstractC03322p.A00(i) < 0.5d;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean A0c(com.facebook.ads.redexgen.X.EnumC02720g r5, java.util.Map<java.lang.String, java.lang.String> r6) {
        /*
            r2 = 10
            r1 = 12
            r0 = 91
            java.lang.String r0 = A0D(r2, r1, r0)
            java.lang.Object r4 = r6.get(r0)
            java.lang.String r4 = (java.lang.String) r4
            r3 = 1
            if (r4 == 0) goto L32
            r2 = 117(0x75, float:1.64E-43)
            r1 = 9
            r0 = 19
            java.lang.String r0 = A0D(r2, r1, r0)
            boolean r0 = r0.equals(r4)
            if (r0 != 0) goto L32
            r1 = 1
        L24:
            com.facebook.ads.redexgen.X.0g r0 = com.facebook.ads.redexgen.X.EnumC02720g.A07
            if (r5 == r0) goto L30
            r0 = 1
        L29:
            if (r1 == 0) goto L2e
            if (r0 == 0) goto L2e
        L2d:
            return r3
        L2e:
            r3 = 0
            goto L2d
        L30:
            r0 = 0
            goto L29
        L32:
            r1 = 0
            goto L24
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC0783Lo.A0c(com.facebook.ads.redexgen.X.0g, java.util.Map):boolean");
    }

    public static boolean A0d(C1116Yn c1116Yn, EnumC02720g enumC02720g) {
        return enumC02720g == EnumC02720g.A07 && C0705Ih.A2N(c1116Yn);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean A0e(com.facebook.ads.redexgen.X.C1116Yn r5, com.facebook.ads.redexgen.X.EnumC02720g r6, java.util.Map<java.lang.String, java.lang.String> r7) {
        /*
            r2 = 57
            r1 = 21
            r0 = 97
            java.lang.String r0 = A0D(r2, r1, r0)
            java.lang.Object r1 = r7.get(r0)
            java.lang.String r1 = (java.lang.String) r1
            r4 = 1
            if (r1 == 0) goto L51
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            java.lang.String r0 = r0.toString()
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L51
            r0 = 1
        L20:
            if (r0 == 0) goto L4f
            boolean r3 = A0d(r5, r6)
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.AbstractC0783Lo.A01
            r0 = 6
            r1 = r2[r0]
            r0 = 7
            r2 = r2[r0]
            r0 = 11
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto L53
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.AbstractC0783Lo.A01
            java.lang.String r1 = "u8VsnBmPWVphPllKxtlQdK"
            r0 = 1
            r2[r0] = r1
            java.lang.String r1 = "HE77zV2Ng27gpeh0j3drVs"
            r0 = 2
            r2[r0] = r1
            if (r3 != 0) goto L4e
            boolean r0 = A0c(r6, r7)
            if (r0 == 0) goto L4f
        L4e:
            return r4
        L4f:
            r4 = 0
            goto L4e
        L51:
            r0 = 0
            goto L20
        L53:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC0783Lo.A0e(com.facebook.ads.redexgen.X.Yn, com.facebook.ads.redexgen.X.0g, java.util.Map):boolean");
    }
}
