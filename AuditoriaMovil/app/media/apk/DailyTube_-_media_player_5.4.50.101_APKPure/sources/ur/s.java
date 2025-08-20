package ur;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class s {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public pv.gv f14110a;

    /* renamed from: zn  reason: collision with root package name */
    public float f14114zn;
    public final TextPaint y = new TextPaint(1);

    /* renamed from: n3  reason: collision with root package name */
    public final pv.a f14112n3 = new y();

    /* renamed from: gv  reason: collision with root package name */
    public boolean f14111gv = true;
    @Nullable

    /* renamed from: v  reason: collision with root package name */
    public WeakReference<n3> f14113v = new WeakReference<>(null);

    /* loaded from: classes.dex */
    public interface n3 {
        @NonNull
        int[] getState();

        boolean onStateChange(int[] iArr);

        void y();
    }

    /* loaded from: classes.dex */
    public class y extends pv.a {
        public y() {
        }

        @Override // pv.a
        public void n3(@NonNull Typeface typeface, boolean z2) {
            if (!z2) {
                s.this.f14111gv = true;
                n3 n3Var = (n3) s.this.f14113v.get();
                if (n3Var != null) {
                    n3Var.y();
                }
            }
        }

        @Override // pv.a
        public void y(int i) {
            s.this.f14111gv = true;
            n3 n3Var = (n3) s.this.f14113v.get();
            if (n3Var != null) {
                n3Var.y();
            }
        }
    }

    public s(@Nullable n3 n3Var) {
        fb(n3Var);
    }

    public float a(String str) {
        if (!this.f14111gv) {
            return this.f14114zn;
        }
        float zn2 = zn(str);
        this.f14114zn = zn2;
        this.f14111gv = false;
        return zn2;
    }

    public void c5(boolean z2) {
        this.f14111gv = z2;
    }

    public void fb(@Nullable n3 n3Var) {
        this.f14113v = new WeakReference<>(n3Var);
    }

    @Nullable
    public pv.gv gv() {
        return this.f14110a;
    }

    public void i9(Context context) {
        this.f14110a.i9(context, this.y, this.f14112n3);
    }

    public void s(@Nullable pv.gv gvVar, Context context) {
        if (this.f14110a != gvVar) {
            this.f14110a = gvVar;
            if (gvVar != null) {
                gvVar.f(context, this.y, this.f14112n3);
                n3 n3Var = this.f14113v.get();
                if (n3Var != null) {
                    this.y.drawableState = n3Var.getState();
                }
                gvVar.i9(context, this.y, this.f14112n3);
                this.f14111gv = true;
            }
            n3 n3Var2 = this.f14113v.get();
            if (n3Var2 != null) {
                n3Var2.y();
                n3Var2.onStateChange(n3Var2.getState());
            }
        }
    }

    @NonNull
    public TextPaint v() {
        return this.y;
    }

    public final float zn(@Nullable CharSequence charSequence) {
        if (charSequence == null) {
            return 0.0f;
        }
        return this.y.measureText(charSequence, 0, charSequence.length());
    }
}
