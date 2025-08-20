package rb;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import rb.p;
@SuppressLint({"PrivateConstructorForUtilityClass"})
/* loaded from: classes.dex */
public class mg {
    public static final Object y = new Object();

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes.dex */
    public class n3<T> implements jb1.v<Object, eb1.wz<T>> {
        public final /* synthetic */ eb1.t y;

        public n3(eb1.t tVar) {
            this.y = tVar;
        }

        /* renamed from: y */
        public eb1.wz<T> apply(Object obj) throws Exception {
            return this.y;
        }
    }

    /* loaded from: classes.dex */
    public class y implements eb1.i9<Object> {

        /* renamed from: n3  reason: collision with root package name */
        public final /* synthetic */ i4 f13193n3;
        public final /* synthetic */ String[] y;

        /* loaded from: classes.dex */
        public class n3 implements jb1.y {
            public final /* synthetic */ p.zn y;

            public n3(p.zn znVar) {
                this.y = znVar;
            }

            public void run() throws Exception {
                y.this.f13193n3.getInvalidationTracker().xc(this.y);
            }
        }

        /* renamed from: rb.mg$y$y  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0201y extends p.zn {

            /* renamed from: n3  reason: collision with root package name */
            public final /* synthetic */ eb1.c5 f13195n3;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0201y(String[] strArr, eb1.c5 c5Var) {
                super(strArr);
                this.f13195n3 = c5Var;
            }

            @Override // rb.p.zn
            public void zn(@NonNull Set<String> set) {
                if (!this.f13195n3.isCancelled()) {
                    this.f13195n3.onNext(mg.y);
                }
            }
        }

        public y(String[] strArr, i4 i4Var) {
            this.y = strArr;
            this.f13193n3 = i4Var;
        }

        public void y(eb1.c5<Object> c5Var) throws Exception {
            C0201y c0201y = new C0201y(this.y, c5Var);
            if (!c5Var.isCancelled()) {
                this.f13193n3.getInvalidationTracker().n3(c0201y);
                c5Var.y(hb1.gv.zn(new n3(c0201y)));
            }
            if (!c5Var.isCancelled()) {
                c5Var.onNext(mg.y);
            }
        }
    }

    public static eb1.s<Object> n3(i4 i4Var, String... strArr) {
        return eb1.s.v(new y(strArr, i4Var), eb1.y.f);
    }

    public static <T> eb1.s<T> y(i4 i4Var, boolean z2, String[] strArr, Callable<T> callable) {
        eb1.mt n32 = bc1.y.n3(zn(i4Var, z2));
        return n3(i4Var, strArr).x4(n32).f3(n32).tl(n32).c5(new n3(eb1.t.fb(callable)));
    }

    public static Executor zn(i4 i4Var, boolean z2) {
        if (z2) {
            return i4Var.getTransactionExecutor();
        }
        return i4Var.getQueryExecutor();
    }
}
