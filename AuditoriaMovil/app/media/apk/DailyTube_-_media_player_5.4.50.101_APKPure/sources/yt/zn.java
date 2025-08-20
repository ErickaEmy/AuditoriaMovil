package yt;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.Layout;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.xc;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import vl.s;
/* loaded from: classes.dex */
public class zn implements Spannable {

    /* renamed from: f  reason: collision with root package name */
    public static final Object f15500f = new Object();
    @NonNull

    /* renamed from: t  reason: collision with root package name */
    public static Executor f15501t;
    @NonNull

    /* renamed from: fb  reason: collision with root package name */
    public final int[] f15502fb;
    @Nullable

    /* renamed from: s  reason: collision with root package name */
    public final PrecomputedText f15503s;
    @NonNull

    /* renamed from: v  reason: collision with root package name */
    public final n3 f15504v;
    @NonNull
    public final Spannable y;

    /* renamed from: yt.zn$zn  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0258zn extends FutureTask<zn> {

        /* renamed from: yt.zn$zn$y */
        /* loaded from: classes.dex */
        public static class y implements Callable<zn> {

            /* renamed from: v  reason: collision with root package name */
            public CharSequence f15512v;
            public n3 y;

            public y(@NonNull n3 n3Var, @NonNull CharSequence charSequence) {
                this.y = n3Var;
                this.f15512v = charSequence;
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: y */
            public zn call() throws Exception {
                return zn.y(this.f15512v, this.y);
            }
        }

        public C0258zn(@NonNull n3 n3Var, @NonNull CharSequence charSequence) {
            super(new y(n3Var, charSequence));
        }
    }

    public zn(@NonNull CharSequence charSequence, @NonNull n3 n3Var, @NonNull int[] iArr) {
        this.y = new SpannableString(charSequence);
        this.f15504v = n3Var;
        this.f15502fb = iArr;
        this.f15503s = null;
    }

    public static Future<zn> gv(@NonNull CharSequence charSequence, @NonNull n3 n3Var, @Nullable Executor executor) {
        C0258zn c0258zn = new C0258zn(n3Var, charSequence);
        if (executor == null) {
            synchronized (f15500f) {
                try {
                    if (f15501t == null) {
                        f15501t = Executors.newFixedThreadPool(1);
                    }
                    executor = f15501t;
                } finally {
                }
            }
        }
        executor.execute(c0258zn);
        return c0258zn;
    }

    @SuppressLint({"WrongConstant"})
    public static zn y(@NonNull CharSequence charSequence, @NonNull n3 n3Var) {
        PrecomputedText.Params params;
        s.fb(charSequence);
        s.fb(n3Var);
        try {
            xc.y("PrecomputedText");
            if (Build.VERSION.SDK_INT >= 29 && (params = n3Var.f15507v) != null) {
                return new zn(PrecomputedText.create(charSequence, params), n3Var);
            }
            ArrayList arrayList = new ArrayList();
            int length = charSequence.length();
            int i = 0;
            while (i < length) {
                int indexOf = TextUtils.indexOf(charSequence, '\n', i, length);
                if (indexOf < 0) {
                    i = length;
                } else {
                    i = indexOf + 1;
                }
                arrayList.add(Integer.valueOf(i));
            }
            int[] iArr = new int[arrayList.size()];
            for (int i5 = 0; i5 < arrayList.size(); i5++) {
                iArr[i5] = ((Integer) arrayList.get(i5)).intValue();
            }
            if (Build.VERSION.SDK_INT >= 23) {
                StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), n3Var.v(), Integer.MAX_VALUE).setBreakStrategy(n3Var.n3()).setHyphenationFrequency(n3Var.zn()).setTextDirection(n3Var.gv()).build();
            } else {
                new StaticLayout(charSequence, n3Var.v(), Integer.MAX_VALUE, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            }
            return new zn(charSequence, n3Var, iArr);
        } finally {
            xc.n3();
        }
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        return this.y.charAt(i);
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object obj) {
        return this.y.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object obj) {
        return this.y.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object obj) {
        return this.y.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public <T> T[] getSpans(int i, int i5, Class<T> cls) {
        if (Build.VERSION.SDK_INT >= 29) {
            return (T[]) this.f15503s.getSpans(i, i5, cls);
        }
        return (T[]) this.y.getSpans(i, i5, cls);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.y.length();
    }

    @NonNull
    public n3 n3() {
        return this.f15504v;
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int i, int i5, Class cls) {
        return this.y.nextSpanTransition(i, i5, cls);
    }

    @Override // android.text.Spannable
    public void removeSpan(Object obj) {
        if (!(obj instanceof MetricAffectingSpan)) {
            if (Build.VERSION.SDK_INT >= 29) {
                this.f15503s.removeSpan(obj);
                return;
            } else {
                this.y.removeSpan(obj);
                return;
            }
        }
        throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
    }

    @Override // android.text.Spannable
    public void setSpan(Object obj, int i, int i5, int i6) {
        if (!(obj instanceof MetricAffectingSpan)) {
            if (Build.VERSION.SDK_INT >= 29) {
                this.f15503s.setSpan(obj, i, i5, i6);
                return;
            } else {
                this.y.setSpan(obj, i, i5, i6);
                return;
            }
        }
        throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i5) {
        return this.y.subSequence(i, i5);
    }

    @Override // java.lang.CharSequence
    @NonNull
    public String toString() {
        return this.y.toString();
    }

    @Nullable
    public PrecomputedText zn() {
        Spannable spannable = this.y;
        if (spannable instanceof PrecomputedText) {
            return (PrecomputedText) spannable;
        }
        return null;
    }

    public zn(@NonNull PrecomputedText precomputedText, @NonNull n3 n3Var) {
        this.y = y.y(precomputedText);
        this.f15504v = n3Var;
        this.f15502fb = null;
        this.f15503s = Build.VERSION.SDK_INT < 29 ? null : precomputedText;
    }

    /* loaded from: classes.dex */
    public static final class n3 {

        /* renamed from: gv  reason: collision with root package name */
        public final int f15505gv;
        @Nullable

        /* renamed from: n3  reason: collision with root package name */
        public final TextDirectionHeuristic f15506n3;

        /* renamed from: v  reason: collision with root package name */
        public final PrecomputedText.Params f15507v;
        @NonNull
        public final TextPaint y;

        /* renamed from: zn  reason: collision with root package name */
        public final int f15508zn;

        /* loaded from: classes.dex */
        public static class y {

            /* renamed from: gv  reason: collision with root package name */
            public int f15509gv;

            /* renamed from: n3  reason: collision with root package name */
            public TextDirectionHeuristic f15510n3;
            @NonNull
            public final TextPaint y;

            /* renamed from: zn  reason: collision with root package name */
            public int f15511zn;

            public y(@NonNull TextPaint textPaint) {
                this.y = textPaint;
                if (Build.VERSION.SDK_INT >= 23) {
                    this.f15511zn = 1;
                    this.f15509gv = 1;
                } else {
                    this.f15509gv = 0;
                    this.f15511zn = 0;
                }
                this.f15510n3 = TextDirectionHeuristics.FIRSTSTRONG_LTR;
            }

            public y gv(@NonNull TextDirectionHeuristic textDirectionHeuristic) {
                this.f15510n3 = textDirectionHeuristic;
                return this;
            }

            public y n3(int i) {
                this.f15511zn = i;
                return this;
            }

            @NonNull
            public n3 y() {
                return new n3(this.y, this.f15510n3, this.f15511zn, this.f15509gv);
            }

            public y zn(int i) {
                this.f15509gv = i;
                return this;
            }
        }

        public n3(@NonNull TextPaint textPaint, @NonNull TextDirectionHeuristic textDirectionHeuristic, int i, int i5) {
            if (Build.VERSION.SDK_INT >= 29) {
                this.f15507v = new PrecomputedText.Params.Builder(textPaint).setBreakStrategy(i).setHyphenationFrequency(i5).setTextDirection(textDirectionHeuristic).build();
            } else {
                this.f15507v = null;
            }
            this.y = textPaint;
            this.f15506n3 = textDirectionHeuristic;
            this.f15508zn = i;
            this.f15505gv = i5;
        }

        public boolean equals(@Nullable Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof n3)) {
                return false;
            }
            n3 n3Var = (n3) obj;
            if (y(n3Var) && this.f15506n3 == n3Var.gv()) {
                return true;
            }
            return false;
        }

        @Nullable
        public TextDirectionHeuristic gv() {
            return this.f15506n3;
        }

        public int hashCode() {
            if (Build.VERSION.SDK_INT >= 24) {
                return vl.zn.n3(Float.valueOf(this.y.getTextSize()), Float.valueOf(this.y.getTextScaleX()), Float.valueOf(this.y.getTextSkewX()), Float.valueOf(this.y.getLetterSpacing()), Integer.valueOf(this.y.getFlags()), this.y.getTextLocales(), this.y.getTypeface(), Boolean.valueOf(this.y.isElegantTextHeight()), this.f15506n3, Integer.valueOf(this.f15508zn), Integer.valueOf(this.f15505gv));
            }
            return vl.zn.n3(Float.valueOf(this.y.getTextSize()), Float.valueOf(this.y.getTextScaleX()), Float.valueOf(this.y.getTextSkewX()), Float.valueOf(this.y.getLetterSpacing()), Integer.valueOf(this.y.getFlags()), this.y.getTextLocale(), this.y.getTypeface(), Boolean.valueOf(this.y.isElegantTextHeight()), this.f15506n3, Integer.valueOf(this.f15508zn), Integer.valueOf(this.f15505gv));
        }

        public int n3() {
            return this.f15508zn;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            sb.append("textSize=" + this.y.getTextSize());
            sb.append(", textScaleX=" + this.y.getTextScaleX());
            sb.append(", textSkewX=" + this.y.getTextSkewX());
            int i = Build.VERSION.SDK_INT;
            sb.append(", letterSpacing=" + this.y.getLetterSpacing());
            sb.append(", elegantTextHeight=" + this.y.isElegantTextHeight());
            if (i >= 24) {
                sb.append(", textLocale=" + this.y.getTextLocales());
            } else {
                sb.append(", textLocale=" + this.y.getTextLocale());
            }
            sb.append(", typeface=" + this.y.getTypeface());
            if (i >= 26) {
                sb.append(", variationSettings=" + this.y.getFontVariationSettings());
            }
            sb.append(", textDir=" + this.f15506n3);
            sb.append(", breakStrategy=" + this.f15508zn);
            sb.append(", hyphenationFrequency=" + this.f15505gv);
            sb.append("}");
            return sb.toString();
        }

        @NonNull
        public TextPaint v() {
            return this.y;
        }

        public boolean y(@NonNull n3 n3Var) {
            int i = Build.VERSION.SDK_INT;
            if ((i >= 23 && (this.f15508zn != n3Var.n3() || this.f15505gv != n3Var.zn())) || this.y.getTextSize() != n3Var.v().getTextSize() || this.y.getTextScaleX() != n3Var.v().getTextScaleX() || this.y.getTextSkewX() != n3Var.v().getTextSkewX() || this.y.getLetterSpacing() != n3Var.v().getLetterSpacing() || !TextUtils.equals(this.y.getFontFeatureSettings(), n3Var.v().getFontFeatureSettings()) || this.y.getFlags() != n3Var.v().getFlags()) {
                return false;
            }
            if (i >= 24) {
                if (!this.y.getTextLocales().equals(n3Var.v().getTextLocales())) {
                    return false;
                }
            } else if (!this.y.getTextLocale().equals(n3Var.v().getTextLocale())) {
                return false;
            }
            if (this.y.getTypeface() == null) {
                if (n3Var.v().getTypeface() != null) {
                    return false;
                }
                return true;
            } else if (!this.y.getTypeface().equals(n3Var.v().getTypeface())) {
                return false;
            } else {
                return true;
            }
        }

        public int zn() {
            return this.f15505gv;
        }

        public n3(@NonNull PrecomputedText.Params params) {
            this.y = params.getTextPaint();
            this.f15506n3 = params.getTextDirection();
            this.f15508zn = params.getBreakStrategy();
            this.f15505gv = params.getHyphenationFrequency();
            this.f15507v = Build.VERSION.SDK_INT < 29 ? null : params;
        }
    }

    /* loaded from: classes.dex */
    public static class y {
        public static Spannable y(PrecomputedText precomputedText) {
            return precomputedText;
        }
    }
}
