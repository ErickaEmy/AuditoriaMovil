package w2;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import l.f;
import le.w;
import x5.a;
import x5.fb;
import x5.s;
import x5.v;
import x5.zn;
/* loaded from: classes.dex */
public class gv implements zn.y {

    /* renamed from: gv  reason: collision with root package name */
    public static final String f14525gv = f.a("WorkConstraintsTracker");

    /* renamed from: n3  reason: collision with root package name */
    public final x5.zn<?>[] f14526n3;
    @Nullable
    public final zn y;

    /* renamed from: zn  reason: collision with root package name */
    public final Object f14527zn;

    public gv(@NonNull Context context, @NonNull ix.y yVar, @Nullable zn znVar) {
        Context applicationContext = context.getApplicationContext();
        this.y = znVar;
        this.f14526n3 = new x5.zn[]{new x5.y(applicationContext, yVar), new x5.n3(applicationContext, yVar), new s(applicationContext, yVar), new x5.gv(applicationContext, yVar), new fb(applicationContext, yVar), new a(applicationContext, yVar), new v(applicationContext, yVar)};
        this.f14527zn = new Object();
    }

    public void gv(@NonNull Iterable<w> iterable) {
        synchronized (this.f14527zn) {
            try {
                for (x5.zn<?> znVar : this.f14526n3) {
                    znVar.fb(null);
                }
                for (x5.zn<?> znVar2 : this.f14526n3) {
                    znVar2.v(iterable);
                }
                for (x5.zn<?> znVar3 : this.f14526n3) {
                    znVar3.fb(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // x5.zn.y
    public void n3(@NonNull List<String> list) {
        synchronized (this.f14527zn) {
            try {
                zn znVar = this.y;
                if (znVar != null) {
                    znVar.n3(list);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void v() {
        synchronized (this.f14527zn) {
            try {
                for (x5.zn<?> znVar : this.f14526n3) {
                    znVar.a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // x5.zn.y
    public void y(@NonNull List<String> list) {
        synchronized (this.f14527zn) {
            try {
                ArrayList arrayList = new ArrayList();
                for (String str : list) {
                    if (zn(str)) {
                        f.zn().y(f14525gv, String.format("Constraints met for %s", str), new Throwable[0]);
                        arrayList.add(str);
                    }
                }
                zn znVar = this.y;
                if (znVar != null) {
                    znVar.v(arrayList);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean zn(@NonNull String str) {
        x5.zn<?>[] znVarArr;
        synchronized (this.f14527zn) {
            try {
                for (x5.zn<?> znVar : this.f14526n3) {
                    if (znVar.gv(str)) {
                        f.zn().y(f14525gv, String.format("Work %s constrained by %s", str, znVar.getClass().getSimpleName()), new Throwable[0]);
                        return false;
                    }
                }
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
