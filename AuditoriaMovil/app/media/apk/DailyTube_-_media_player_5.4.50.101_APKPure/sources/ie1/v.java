package ie1;

import ie1.zn;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.CompletableFuture;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
@IgnoreJRERequirement
/* loaded from: classes.dex */
public final class v extends zn.y {
    public static final zn.y y = new v();

    @IgnoreJRERequirement
    /* loaded from: classes.dex */
    public static final class n3<R> implements zn<R, CompletableFuture<mt<R>>> {
        public final Type y;

        /* renamed from: ie1.v$n3$n3  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0118n3 implements gv<R> {
            public final /* synthetic */ CompletableFuture y;

            public C0118n3(CompletableFuture completableFuture) {
                this.y = completableFuture;
            }

            @Override // ie1.gv
            public void n3(ie1.n3<R> n3Var, Throwable th) {
                this.y.completeExceptionally(th);
            }

            @Override // ie1.gv
            public void y(ie1.n3<R> n3Var, mt<R> mtVar) {
                this.y.complete(mtVar);
            }
        }

        /* loaded from: classes.dex */
        public class y extends CompletableFuture<mt<R>> {
            public final /* synthetic */ ie1.n3 y;

            public y(ie1.n3 n3Var) {
                this.y = n3Var;
            }

            @Override // java.util.concurrent.CompletableFuture, java.util.concurrent.Future
            public boolean cancel(boolean z2) {
                if (z2) {
                    this.y.cancel();
                }
                return super.cancel(z2);
            }
        }

        public n3(Type type) {
            this.y = type;
        }

        @Override // ie1.zn
        public Type y() {
            return this.y;
        }

        @Override // ie1.zn
        /* renamed from: zn */
        public CompletableFuture<mt<R>> n3(ie1.n3<R> n3Var) {
            y yVar = new y(n3Var);
            n3Var.r(new C0118n3(yVar));
            return yVar;
        }
    }

    @IgnoreJRERequirement
    /* loaded from: classes.dex */
    public static final class y<R> implements zn<R, CompletableFuture<R>> {
        public final Type y;

        /* loaded from: classes.dex */
        public class n3 implements gv<R> {
            public final /* synthetic */ CompletableFuture y;

            public n3(CompletableFuture completableFuture) {
                this.y = completableFuture;
            }

            @Override // ie1.gv
            public void n3(ie1.n3<R> n3Var, Throwable th) {
                this.y.completeExceptionally(th);
            }

            @Override // ie1.gv
            public void y(ie1.n3<R> n3Var, mt<R> mtVar) {
                if (mtVar.gv()) {
                    this.y.complete(mtVar.y());
                } else {
                    this.y.completeExceptionally(new s(mtVar));
                }
            }
        }

        /* renamed from: ie1.v$y$y  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0119y extends CompletableFuture<R> {
            public final /* synthetic */ ie1.n3 y;

            public C0119y(ie1.n3 n3Var) {
                this.y = n3Var;
            }

            @Override // java.util.concurrent.CompletableFuture, java.util.concurrent.Future
            public boolean cancel(boolean z2) {
                if (z2) {
                    this.y.cancel();
                }
                return super.cancel(z2);
            }
        }

        public y(Type type) {
            this.y = type;
        }

        @Override // ie1.zn
        public Type y() {
            return this.y;
        }

        @Override // ie1.zn
        /* renamed from: zn */
        public CompletableFuture<R> n3(ie1.n3<R> n3Var) {
            C0119y c0119y = new C0119y(n3Var);
            n3Var.r(new n3(c0119y));
            return c0119y;
        }
    }

    @Override // ie1.zn.y
    public zn<?, ?> y(Type type, Annotation[] annotationArr, co coVar) {
        if (zn.y.zn(type) != CompletableFuture.class) {
            return null;
        }
        if (type instanceof ParameterizedType) {
            Type n32 = zn.y.n3(0, (ParameterizedType) type);
            if (zn.y.zn(n32) != mt.class) {
                return new y(n32);
            }
            if (n32 instanceof ParameterizedType) {
                return new n3(zn.y.n3(0, (ParameterizedType) n32));
            }
            throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
        }
        throw new IllegalStateException("CompletableFuture return type must be parameterized as CompletableFuture<Foo> or CompletableFuture<? extends Foo>");
    }
}
