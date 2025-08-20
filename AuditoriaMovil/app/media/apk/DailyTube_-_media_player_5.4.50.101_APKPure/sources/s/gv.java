package s;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import t.n3;
/* loaded from: classes.dex */
public abstract class gv {
    public static int y = -100;

    /* renamed from: v  reason: collision with root package name */
    public static final z.n3<WeakReference<gv>> f13381v = new z.n3<>();

    /* renamed from: fb  reason: collision with root package name */
    public static final Object f13380fb = new Object();

    public static void c(@NonNull gv gvVar) {
        synchronized (f13380fb) {
            d0(gvVar);
        }
    }

    public static void d0(@NonNull gv gvVar) {
        synchronized (f13380fb) {
            try {
                Iterator<WeakReference<gv>> it = f13381v.iterator();
                while (it.hasNext()) {
                    gv gvVar2 = it.next().get();
                    if (gvVar2 == gvVar || gvVar2 == null) {
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static int f() {
        return y;
    }

    @NonNull
    public static gv fb(@NonNull Activity activity, @Nullable zn znVar) {
        return new v(activity, znVar);
    }

    @NonNull
    public static gv s(@NonNull Dialog dialog, @Nullable zn znVar) {
        return new v(dialog, znVar);
    }

    public static void zn(@NonNull gv gvVar) {
        synchronized (f13380fb) {
            d0(gvVar);
            f13381v.add(new WeakReference<>(gvVar));
        }
    }

    @NonNull
    public Context a(@NonNull Context context) {
        v(context);
        return context;
    }

    public abstract View c5(@Nullable View view, String str, @NonNull Context context, @NonNull AttributeSet attributeSet);

    public abstract void co(Bundle bundle);

    public abstract void d(@Nullable Toolbar toolbar);

    public abstract void ej(@Nullable CharSequence charSequence);

    public abstract void f3();

    public abstract boolean fh(int i);

    public abstract void gv(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void i4(Bundle bundle);

    @Nullable
    public abstract <T extends View> T i9(int i);

    public abstract void mg(View view);

    public abstract void mt(Configuration configuration);

    public abstract void n();

    public abstract void p();

    public abstract void r(Bundle bundle);

    public abstract void rz(int i);

    @Nullable
    public abstract n3 t();

    public abstract void ta(View view, ViewGroup.LayoutParams layoutParams);

    public int tl() {
        return -100;
    }

    @Nullable
    public abstract t.n3 ud(@NonNull n3.y yVar);

    public abstract void w();

    public abstract MenuInflater wz();

    public abstract void x4();

    @Nullable
    public abstract y xc();

    public abstract void z();

    @Deprecated
    public void v(Context context) {
    }

    public void z6(int i) {
    }
}
