package q5;

import android.content.Context;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import l.f;
/* loaded from: classes.dex */
public abstract class gv<T> {

    /* renamed from: a  reason: collision with root package name */
    public static final String f12760a = f.a("ConstraintTracker");

    /* renamed from: n3  reason: collision with root package name */
    public final Context f12762n3;

    /* renamed from: v  reason: collision with root package name */
    public T f12763v;
    public final ix.y y;

    /* renamed from: zn  reason: collision with root package name */
    public final Object f12764zn = new Object();

    /* renamed from: gv  reason: collision with root package name */
    public final Set<w2.y<T>> f12761gv = new LinkedHashSet();

    /* loaded from: classes.dex */
    public class y implements Runnable {
        public final /* synthetic */ List y;

        public y(List list) {
            this.y = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (w2.y yVar : this.y) {
                yVar.y(gv.this.f12763v);
            }
        }
    }

    public gv(@NonNull Context context, @NonNull ix.y yVar) {
        this.f12762n3 = context.getApplicationContext();
        this.y = yVar;
    }

    public abstract void a();

    public void gv(T t2) {
        synchronized (this.f12764zn) {
            try {
                T t3 = this.f12763v;
                if (t3 != t2 && (t3 == null || !t3.equals(t2))) {
                    this.f12763v = t2;
                    this.y.y().execute(new y(new ArrayList(this.f12761gv)));
                }
            } finally {
            }
        }
    }

    public abstract T n3();

    public abstract void v();

    public void y(w2.y<T> yVar) {
        synchronized (this.f12764zn) {
            try {
                if (this.f12761gv.add(yVar)) {
                    if (this.f12761gv.size() == 1) {
                        this.f12763v = n3();
                        f.zn().y(f12760a, String.format("%s: initial state = %s", getClass().getSimpleName(), this.f12763v), new Throwable[0]);
                        v();
                    }
                    yVar.y(this.f12763v);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void zn(w2.y<T> yVar) {
        synchronized (this.f12764zn) {
            try {
                if (this.f12761gv.remove(yVar) && this.f12761gv.isEmpty()) {
                    a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
