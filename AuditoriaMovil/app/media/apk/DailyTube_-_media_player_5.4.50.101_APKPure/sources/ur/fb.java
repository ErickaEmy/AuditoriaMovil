package ur;

import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Constructor;
/* loaded from: classes.dex */
public final class fb {

    /* renamed from: f  reason: collision with root package name */
    public static boolean f14090f;
    @Nullable

    /* renamed from: t  reason: collision with root package name */
    public static Constructor<StaticLayout> f14091t;
    @Nullable

    /* renamed from: tl  reason: collision with root package name */
    public static Object f14092tl;

    /* renamed from: c5  reason: collision with root package name */
    public boolean f14094c5;

    /* renamed from: gv  reason: collision with root package name */
    public int f14096gv;

    /* renamed from: n3  reason: collision with root package name */
    public final TextPaint f14098n3;

    /* renamed from: v  reason: collision with root package name */
    public int f14100v;
    public CharSequence y;

    /* renamed from: zn  reason: collision with root package name */
    public final int f14101zn;

    /* renamed from: a  reason: collision with root package name */
    public Layout.Alignment f14093a = Layout.Alignment.ALIGN_NORMAL;

    /* renamed from: fb  reason: collision with root package name */
    public int f14095fb = Integer.MAX_VALUE;

    /* renamed from: s  reason: collision with root package name */
    public boolean f14099s = true;
    @Nullable

    /* renamed from: i9  reason: collision with root package name */
    public TextUtils.TruncateAt f14097i9 = null;

    /* loaded from: classes.dex */
    public static class y extends Exception {
        public y(Throwable th) {
            super("Error thrown initializing StaticLayout " + th.getMessage(), th);
        }
    }

    public fb(CharSequence charSequence, TextPaint textPaint, int i) {
        this.y = charSequence;
        this.f14098n3 = textPaint;
        this.f14101zn = i;
        this.f14100v = charSequence.length();
    }

    @NonNull
    public static fb zn(@NonNull CharSequence charSequence, @NonNull TextPaint textPaint, int i) {
        return new fb(charSequence, textPaint, i);
    }

    @NonNull
    public fb a(boolean z2) {
        this.f14099s = z2;
        return this;
    }

    public fb fb(boolean z2) {
        this.f14094c5 = z2;
        return this;
    }

    @NonNull
    public fb gv(@NonNull Layout.Alignment alignment) {
        this.f14093a = alignment;
        return this;
    }

    public final void n3() throws y {
        boolean z2;
        TextDirectionHeuristic textDirectionHeuristic;
        if (f14090f) {
            return;
        }
        try {
            if (this.f14094c5 && Build.VERSION.SDK_INT >= 23) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                textDirectionHeuristic = TextDirectionHeuristics.RTL;
            } else {
                textDirectionHeuristic = TextDirectionHeuristics.LTR;
            }
            f14092tl = textDirectionHeuristic;
            Class cls = Integer.TYPE;
            Class cls2 = Float.TYPE;
            Constructor<StaticLayout> declaredConstructor = StaticLayout.class.getDeclaredConstructor(CharSequence.class, cls, cls, TextPaint.class, cls, Layout.Alignment.class, TextDirectionHeuristic.class, cls2, cls2, Boolean.TYPE, TextUtils.TruncateAt.class, cls, cls);
            f14091t = declaredConstructor;
            declaredConstructor.setAccessible(true);
            f14090f = true;
        } catch (Exception e2) {
            throw new y(e2);
        }
    }

    @NonNull
    public fb s(int i) {
        this.f14095fb = i;
        return this;
    }

    @NonNull
    public fb v(@Nullable TextUtils.TruncateAt truncateAt) {
        this.f14097i9 = truncateAt;
        return this;
    }

    public StaticLayout y() throws y {
        TextDirectionHeuristic textDirectionHeuristic;
        if (this.y == null) {
            this.y = "";
        }
        int max = Math.max(0, this.f14101zn);
        CharSequence charSequence = this.y;
        if (this.f14095fb == 1) {
            charSequence = TextUtils.ellipsize(charSequence, this.f14098n3, max, this.f14097i9);
        }
        int min = Math.min(charSequence.length(), this.f14100v);
        this.f14100v = min;
        if (Build.VERSION.SDK_INT >= 23) {
            if (this.f14094c5) {
                this.f14093a = Layout.Alignment.ALIGN_OPPOSITE;
            }
            StaticLayout.Builder obtain = StaticLayout.Builder.obtain(charSequence, this.f14096gv, min, this.f14098n3, max);
            obtain.setAlignment(this.f14093a);
            obtain.setIncludePad(this.f14099s);
            if (this.f14094c5) {
                textDirectionHeuristic = TextDirectionHeuristics.RTL;
            } else {
                textDirectionHeuristic = TextDirectionHeuristics.LTR;
            }
            obtain.setTextDirection(textDirectionHeuristic);
            TextUtils.TruncateAt truncateAt = this.f14097i9;
            if (truncateAt != null) {
                obtain.setEllipsize(truncateAt);
            }
            obtain.setMaxLines(this.f14095fb);
            return obtain.build();
        }
        n3();
        try {
            return (StaticLayout) ((Constructor) vl.s.fb(f14091t)).newInstance(charSequence, Integer.valueOf(this.f14096gv), Integer.valueOf(this.f14100v), this.f14098n3, Integer.valueOf(max), this.f14093a, vl.s.fb(f14092tl), Float.valueOf(1.0f), Float.valueOf(0.0f), Boolean.valueOf(this.f14099s), null, Integer.valueOf(max), Integer.valueOf(this.f14095fb));
        } catch (Exception e2) {
            throw new y(e2);
        }
    }
}
