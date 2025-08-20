package wz;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.AppCompatEditText;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class r {

    /* renamed from: t  reason: collision with root package name */
    public static final RectF f14754t = new RectF();
    @SuppressLint({"BanConcurrentHashMap"})

    /* renamed from: tl  reason: collision with root package name */
    public static ConcurrentHashMap<String, Method> f14755tl = new ConcurrentHashMap<>();
    @SuppressLint({"BanConcurrentHashMap"})

    /* renamed from: wz  reason: collision with root package name */
    public static ConcurrentHashMap<String, Field> f14756wz = new ConcurrentHashMap<>();
    @NonNull

    /* renamed from: c5  reason: collision with root package name */
    public final TextView f14758c5;

    /* renamed from: f  reason: collision with root package name */
    public final zn f14759f;

    /* renamed from: fb  reason: collision with root package name */
    public boolean f14760fb;

    /* renamed from: i9  reason: collision with root package name */
    public final Context f14762i9;

    /* renamed from: n3  reason: collision with root package name */
    public boolean f14763n3;

    /* renamed from: s  reason: collision with root package name */
    public TextPaint f14764s;
    public int y;

    /* renamed from: zn  reason: collision with root package name */
    public float f14766zn = -1.0f;

    /* renamed from: gv  reason: collision with root package name */
    public float f14761gv = -1.0f;

    /* renamed from: v  reason: collision with root package name */
    public float f14765v = -1.0f;

    /* renamed from: a  reason: collision with root package name */
    public int[] f14757a = new int[0];

    /* loaded from: classes.dex */
    public static class n3 extends y {
        @Override // wz.r.zn
        public boolean n3(TextView textView) {
            return textView.isHorizontallyScrollable();
        }

        @Override // wz.r.y, wz.r.zn
        public void y(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection(textView.getTextDirectionHeuristic());
        }
    }

    /* loaded from: classes.dex */
    public static class y extends zn {
        @Override // wz.r.zn
        public void y(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection((TextDirectionHeuristic) r.xc(textView, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR));
        }
    }

    public r(@NonNull TextView textView) {
        this.f14758c5 = textView;
        this.f14762i9 = textView.getContext();
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            this.f14759f = new n3();
        } else if (i >= 23) {
            this.f14759f = new y();
        } else {
            this.f14759f = new zn();
        }
    }

    @Nullable
    public static Method tl(@NonNull String str) {
        try {
            Method method = f14755tl.get(str);
            if (method == null && (method = TextView.class.getDeclaredMethod(str, null)) != null) {
                method.setAccessible(true);
                f14755tl.put(str, method);
            }
            return method;
        } catch (Exception e2) {
            Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + str + "() method", e2);
            return null;
        }
    }

    public static <T> T xc(@NonNull Object obj, @NonNull String str, @NonNull T t2) {
        try {
            return (T) tl(str).invoke(obj, null);
        } catch (Exception e2) {
            Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#" + str + "() method", e2);
            return t2;
        }
    }

    public final StaticLayout a(CharSequence charSequence, Layout.Alignment alignment, int i) {
        return new StaticLayout(charSequence, this.f14764s, i, alignment, this.f14758c5.getLineSpacingMultiplier(), this.f14758c5.getLineSpacingExtra(), this.f14758c5.getIncludeFontPadding());
    }

    public final boolean c(int i, RectF rectF) {
        CharSequence transformation;
        CharSequence text = this.f14758c5.getText();
        TransformationMethod transformationMethod = this.f14758c5.getTransformationMethod();
        if (transformationMethod != null && (transformation = transformationMethod.getTransformation(text, this.f14758c5)) != null) {
            text = transformation;
        }
        int maxLines = this.f14758c5.getMaxLines();
        wz(i);
        StaticLayout gv2 = gv(text, (Layout.Alignment) xc(this.f14758c5, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL), Math.round(rectF.right), maxLines);
        if ((maxLines != -1 && (gv2.getLineCount() > maxLines || gv2.getLineEnd(gv2.getLineCount() - 1) != text.length())) || gv2.getHeight() > rectF.bottom) {
            return false;
        }
        return true;
    }

    public int c5() {
        return Math.round(this.f14761gv);
    }

    public void co(@NonNull int[] iArr, int i) throws IllegalArgumentException {
        if (d0()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArr2 = new int[length];
                if (i == 0) {
                    iArr2 = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = this.f14762i9.getResources().getDisplayMetrics();
                    for (int i5 = 0; i5 < length; i5++) {
                        iArr2[i5] = Math.round(TypedValue.applyDimension(i, iArr[i5], displayMetrics));
                    }
                }
                this.f14757a = n3(iArr2);
                if (!n()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                this.f14760fb = false;
            }
            if (i4()) {
                y();
            }
        }
    }

    public final boolean d0() {
        return !(this.f14758c5 instanceof AppCompatEditText);
    }

    public int[] f() {
        return this.f14757a;
    }

    public final void f3(TypedArray typedArray) {
        int length = typedArray.length();
        int[] iArr = new int[length];
        if (length > 0) {
            for (int i = 0; i < length; i++) {
                iArr[i] = typedArray.getDimensionPixelSize(i, -1);
            }
            this.f14757a = n3(iArr);
            n();
        }
    }

    public final int fb(RectF rectF) {
        int length = this.f14757a.length;
        if (length != 0) {
            int i = 1;
            int i5 = length - 1;
            int i6 = 0;
            while (i <= i5) {
                int i8 = (i + i5) / 2;
                if (c(this.f14757a[i8], rectF)) {
                    int i10 = i8 + 1;
                    i6 = i;
                    i = i10;
                } else {
                    i6 = i8 - 1;
                    i5 = i6;
                }
            }
            return this.f14757a[i6];
        }
        throw new IllegalStateException("No available text sizes to choose from.");
    }

    public final void fh(float f4, float f6, float f9) throws IllegalArgumentException {
        if (f4 > 0.0f) {
            if (f6 > f4) {
                if (f9 > 0.0f) {
                    this.y = 1;
                    this.f14761gv = f4;
                    this.f14765v = f6;
                    this.f14766zn = f9;
                    this.f14760fb = false;
                    return;
                }
                throw new IllegalArgumentException("The auto-size step granularity (" + f9 + "px) is less or equal to (0px)");
            }
            throw new IllegalArgumentException("Maximum auto-size text size (" + f6 + "px) is less or equal to minimum auto-size text size (" + f4 + "px)");
        }
        throw new IllegalArgumentException("Minimum auto-size text size (" + f4 + "px) is less or equal to (0px)");
    }

    public StaticLayout gv(CharSequence charSequence, Layout.Alignment alignment, int i, int i5) {
        if (Build.VERSION.SDK_INT >= 23) {
            return v(charSequence, alignment, i, i5);
        }
        return a(charSequence, alignment, i);
    }

    public final boolean i4() {
        if (d0() && this.y == 1) {
            if (!this.f14760fb || this.f14757a.length == 0) {
                int floor = ((int) Math.floor((this.f14765v - this.f14761gv) / this.f14766zn)) + 1;
                int[] iArr = new int[floor];
                for (int i = 0; i < floor; i++) {
                    iArr[i] = Math.round(this.f14761gv + (i * this.f14766zn));
                }
                this.f14757a = n3(iArr);
            }
            this.f14763n3 = true;
        } else {
            this.f14763n3 = false;
        }
        return this.f14763n3;
    }

    public int i9() {
        return Math.round(this.f14766zn);
    }

    public void mt(int i, int i5, int i6, int i8) throws IllegalArgumentException {
        if (d0()) {
            DisplayMetrics displayMetrics = this.f14762i9.getResources().getDisplayMetrics();
            fh(TypedValue.applyDimension(i8, i, displayMetrics), TypedValue.applyDimension(i8, i5, displayMetrics), TypedValue.applyDimension(i8, i6, displayMetrics));
            if (i4()) {
                y();
            }
        }
    }

    public final boolean n() {
        boolean z2;
        int[] iArr = this.f14757a;
        int length = iArr.length;
        if (length > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.f14760fb = z2;
        if (z2) {
            this.y = 1;
            this.f14761gv = iArr[0];
            this.f14765v = iArr[length - 1];
            this.f14766zn = -1.0f;
        }
        return z2;
    }

    public final int[] n3(int[] iArr) {
        int length = iArr.length;
        if (length == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        ArrayList arrayList = new ArrayList();
        for (int i : iArr) {
            if (i > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i)) < 0) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        if (length == arrayList.size()) {
            return iArr;
        }
        int size = arrayList.size();
        int[] iArr2 = new int[size];
        for (int i5 = 0; i5 < size; i5++) {
            iArr2[i5] = ((Integer) arrayList.get(i5)).intValue();
        }
        return iArr2;
    }

    public void p(@Nullable AttributeSet attributeSet, int i) {
        float f4;
        float f6;
        float f9;
        int resourceId;
        Context context = this.f14762i9;
        int[] iArr = R$styleable.f830eb;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i, 0);
        TextView textView = this.f14758c5;
        hw.i4.kp(textView, textView.getContext(), iArr, attributeSet, obtainStyledAttributes, i, 0);
        int i5 = R$styleable.f896s8;
        if (obtainStyledAttributes.hasValue(i5)) {
            this.y = obtainStyledAttributes.getInt(i5, 0);
        }
        int i6 = R$styleable.f828e;
        if (obtainStyledAttributes.hasValue(i6)) {
            f4 = obtainStyledAttributes.getDimension(i6, -1.0f);
        } else {
            f4 = -1.0f;
        }
        int i8 = R$styleable.f874nf;
        if (obtainStyledAttributes.hasValue(i8)) {
            f6 = obtainStyledAttributes.getDimension(i8, -1.0f);
        } else {
            f6 = -1.0f;
        }
        int i10 = R$styleable.f861lc;
        if (obtainStyledAttributes.hasValue(i10)) {
            f9 = obtainStyledAttributes.getDimension(i10, -1.0f);
        } else {
            f9 = -1.0f;
        }
        int i11 = R$styleable.f890ra;
        if (obtainStyledAttributes.hasValue(i11) && (resourceId = obtainStyledAttributes.getResourceId(i11, 0)) > 0) {
            TypedArray obtainTypedArray = obtainStyledAttributes.getResources().obtainTypedArray(resourceId);
            f3(obtainTypedArray);
            obtainTypedArray.recycle();
        }
        obtainStyledAttributes.recycle();
        if (d0()) {
            if (this.y == 1) {
                if (!this.f14760fb) {
                    DisplayMetrics displayMetrics = this.f14762i9.getResources().getDisplayMetrics();
                    if (f6 == -1.0f) {
                        f6 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                    }
                    if (f9 == -1.0f) {
                        f9 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                    }
                    if (f4 == -1.0f) {
                        f4 = 1.0f;
                    }
                    fh(f6, f9, f4);
                }
                i4();
                return;
            }
            return;
        }
        this.y = 0;
    }

    public final void r(float f4) {
        if (f4 != this.f14758c5.getPaint().getTextSize()) {
            this.f14758c5.getPaint().setTextSize(f4);
            boolean isInLayout = this.f14758c5.isInLayout();
            if (this.f14758c5.getLayout() != null) {
                this.f14763n3 = false;
                try {
                    Method tl2 = tl("nullLayouts");
                    if (tl2 != null) {
                        tl2.invoke(this.f14758c5, null);
                    }
                } catch (Exception e2) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", e2);
                }
                if (!isInLayout) {
                    this.f14758c5.requestLayout();
                } else {
                    this.f14758c5.forceLayout();
                }
                this.f14758c5.invalidate();
            }
        }
    }

    public int s() {
        return Math.round(this.f14765v);
    }

    public int t() {
        return this.y;
    }

    public final StaticLayout v(CharSequence charSequence, Layout.Alignment alignment, int i, int i5) {
        StaticLayout.Builder obtain = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), this.f14764s, i);
        StaticLayout.Builder hyphenationFrequency = obtain.setAlignment(alignment).setLineSpacing(this.f14758c5.getLineSpacingExtra(), this.f14758c5.getLineSpacingMultiplier()).setIncludePad(this.f14758c5.getIncludeFontPadding()).setBreakStrategy(this.f14758c5.getBreakStrategy()).setHyphenationFrequency(this.f14758c5.getHyphenationFrequency());
        if (i5 == -1) {
            i5 = Integer.MAX_VALUE;
        }
        hyphenationFrequency.setMaxLines(i5);
        try {
            this.f14759f.y(obtain, this.f14758c5);
        } catch (ClassCastException unused) {
            Log.w("ACTVAutoSizeHelper", "Failed to obtain TextDirectionHeuristic, auto size may be incorrect");
        }
        return obtain.build();
    }

    public boolean w() {
        if (d0() && this.y != 0) {
            return true;
        }
        return false;
    }

    public void wz(int i) {
        TextPaint textPaint = this.f14764s;
        if (textPaint == null) {
            this.f14764s = new TextPaint();
        } else {
            textPaint.reset();
        }
        this.f14764s.set(this.f14758c5.getPaint());
        this.f14764s.setTextSize(i);
    }

    public void x4(int i, float f4) {
        Resources resources;
        Context context = this.f14762i9;
        if (context == null) {
            resources = Resources.getSystem();
        } else {
            resources = context.getResources();
        }
        r(TypedValue.applyDimension(i, f4, resources.getDisplayMetrics()));
    }

    public void y() {
        int measuredWidth;
        if (!w()) {
            return;
        }
        if (this.f14763n3) {
            if (this.f14758c5.getMeasuredHeight() > 0 && this.f14758c5.getMeasuredWidth() > 0) {
                if (this.f14759f.n3(this.f14758c5)) {
                    measuredWidth = 1048576;
                } else {
                    measuredWidth = (this.f14758c5.getMeasuredWidth() - this.f14758c5.getTotalPaddingLeft()) - this.f14758c5.getTotalPaddingRight();
                }
                int height = (this.f14758c5.getHeight() - this.f14758c5.getCompoundPaddingBottom()) - this.f14758c5.getCompoundPaddingTop();
                if (measuredWidth > 0 && height > 0) {
                    RectF rectF = f14754t;
                    synchronized (rectF) {
                        try {
                            rectF.setEmpty();
                            rectF.right = measuredWidth;
                            rectF.bottom = height;
                            float fb2 = fb(rectF);
                            if (fb2 != this.f14758c5.getTextSize()) {
                                x4(0, fb2);
                            }
                        } finally {
                        }
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        this.f14763n3 = true;
    }

    public void z(int i) {
        if (d0()) {
            if (i != 0) {
                if (i == 1) {
                    DisplayMetrics displayMetrics = this.f14762i9.getResources().getDisplayMetrics();
                    fh(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
                    if (i4()) {
                        y();
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("Unknown auto-size text type: " + i);
            }
            zn();
        }
    }

    public final void zn() {
        this.y = 0;
        this.f14761gv = -1.0f;
        this.f14765v = -1.0f;
        this.f14766zn = -1.0f;
        this.f14757a = new int[0];
        this.f14763n3 = false;
    }

    /* loaded from: classes.dex */
    public static class zn {
        public boolean n3(TextView textView) {
            return ((Boolean) r.xc(textView, "getHorizontallyScrolling", Boolean.FALSE)).booleanValue();
        }

        public void y(StaticLayout.Builder builder, TextView textView) {
        }
    }
}
