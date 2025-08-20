package ie1;

import ie1.zn;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.Executor;
import kc1.d0;
/* loaded from: classes.dex */
public final class fb extends zn.y {
    public final Executor y;

    /* loaded from: classes.dex */
    public static final class n3<T> implements ie1.n3<T> {

        /* renamed from: v  reason: collision with root package name */
        public final ie1.n3<T> f9199v;
        public final Executor y;

        /* loaded from: classes.dex */
        public class y implements gv<T> {
            public final /* synthetic */ gv y;

            /* renamed from: ie1.fb$n3$y$n3  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class RunnableC0116n3 implements Runnable {
                public final /* synthetic */ Throwable y;

                public RunnableC0116n3(Throwable th) {
                    this.y = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    y yVar = y.this;
                    yVar.y.n3(n3.this, this.y);
                }
            }

            /* renamed from: ie1.fb$n3$y$y  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class RunnableC0117y implements Runnable {
                public final /* synthetic */ mt y;

                public RunnableC0117y(mt mtVar) {
                    this.y = mtVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (n3.this.f9199v.v()) {
                        y yVar = y.this;
                        yVar.y.n3(n3.this, new IOException("Canceled"));
                        return;
                    }
                    y yVar2 = y.this;
                    yVar2.y.y(n3.this, this.y);
                }
            }

            public y(gv gvVar) {
                this.y = gvVar;
            }

            @Override // ie1.gv
            public void n3(ie1.n3<T> n3Var, Throwable th) {
                n3.this.y.execute(new RunnableC0116n3(th));
            }

            @Override // ie1.gv
            public void y(ie1.n3<T> n3Var, mt<T> mtVar) {
                n3.this.y.execute(new RunnableC0117y(mtVar));
            }
        }

        public n3(Executor executor, ie1.n3<T> n3Var) {
            this.y = executor;
            this.f9199v = n3Var;
        }

        @Override // ie1.n3
        public void cancel() {
            this.f9199v.cancel();
        }

        @Override // ie1.n3
        public mt<T> execute() throws IOException {
            return this.f9199v.execute();
        }

        @Override // ie1.n3
        public void r(gv<T> gvVar) {
            i4.n3(gvVar, "callback == null");
            this.f9199v.r(new y(gvVar));
        }

        @Override // ie1.n3
        public boolean v() {
            return this.f9199v.v();
        }

        @Override // ie1.n3
        public d0 y() {
            return this.f9199v.y();
        }

        @Override // ie1.n3
        /* renamed from: clone */
        public ie1.n3<T> m25clone() {
            return new n3(this.y, this.f9199v.clone());
        }
    }

    /* loaded from: classes.dex */
    public class y implements zn<Object, ie1.n3<?>> {

        /* renamed from: n3  reason: collision with root package name */
        public final /* synthetic */ Executor f9203n3;
        public final /* synthetic */ Type y;

        public y(Type type, Executor executor) {
            this.y = type;
            this.f9203n3 = executor;
        }

        @Override // ie1.zn
        public Type y() {
            return this.y;
        }

        @Override // ie1.zn
        /* renamed from: zn */
        public ie1.n3<Object> n3(ie1.n3<Object> n3Var) {
            Executor executor = this.f9203n3;
            if (executor != null) {
                return new n3(executor, n3Var);
            }
            return n3Var;
        }
    }

    public fb(Executor executor) {
        this.y = executor;
    }

    @Override // ie1.zn.y
    public zn<?, ?> y(Type type, Annotation[] annotationArr, co coVar) {
        Executor executor = null;
        if (zn.y.zn(type) != ie1.n3.class) {
            return null;
        }
        if (type instanceof ParameterizedType) {
            Type s2 = i4.s(0, (ParameterizedType) type);
            if (!i4.tl(annotationArr, r.class)) {
                executor = this.y;
            }
            return new y(s2, executor);
        }
        throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
    }
}
