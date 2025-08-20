package be1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Pair;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClass;
/* loaded from: classes.dex */
public final class y {

    /* renamed from: a  reason: collision with root package name */
    public Object f3832a;

    /* renamed from: c5  reason: collision with root package name */
    public boolean f3833c5;

    /* renamed from: fb  reason: collision with root package name */
    public final ArrayList<Object> f3834fb;

    /* renamed from: gv  reason: collision with root package name */
    public final qd1.y f3835gv;

    /* renamed from: n3  reason: collision with root package name */
    public final String f3836n3;

    /* renamed from: s  reason: collision with root package name */
    public final ArrayDeque<yd1.y> f3837s;

    /* renamed from: v  reason: collision with root package name */
    public final ArrayList<y> f3838v;
    public final zd1.y y;

    /* renamed from: zn  reason: collision with root package name */
    public final boolean f3839zn;

    /* loaded from: classes.dex */
    public static final class a extends Lambda implements Function0<String> {
        final /* synthetic */ KClass<?> $clazz;
        final /* synthetic */ zd1.y $qualifier;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(KClass<?> kClass, zd1.y yVar) {
            super(0);
            this.$clazz = kClass;
            this.$qualifier = yVar;
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return "- lookup? t:'" + ee1.y.y(this.$clazz) + "' - q:'" + this.$qualifier + "' look in other scopes";
        }
    }

    /* loaded from: classes.dex */
    public static final class fb extends Lambda implements Function0<String> {
        public static final fb y = new fb();

        public fb() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return "| clear parameter stack";
        }
    }

    /* loaded from: classes.dex */
    public static final class gv extends Lambda implements Function0<String> {
        final /* synthetic */ KClass<?> $clazz;
        final /* synthetic */ zd1.y $qualifier;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public gv(KClass<?> kClass, zd1.y yVar) {
            super(0);
            this.$clazz = kClass;
            this.$qualifier = yVar;
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return "- lookup? t:'" + ee1.y.y(this.$clazz) + "' - q:'" + this.$qualifier + "' look in injected parameters";
        }
    }

    /* loaded from: classes.dex */
    public static final class n3 extends Lambda implements Function0<String> {
        final /* synthetic */ yd1.y $parameters;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n3(yd1.y yVar) {
            super(0);
            this.$parameters = yVar;
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return "| put parameters on stack " + this.$parameters + ' ';
        }
    }

    /* loaded from: classes.dex */
    public static final class v extends Lambda implements Function0<String> {
        final /* synthetic */ KClass<?> $clazz;
        final /* synthetic */ zd1.y $qualifier;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v(KClass<?> kClass, zd1.y yVar) {
            super(0);
            this.$clazz = kClass;
            this.$qualifier = yVar;
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return "- lookup? t:'" + ee1.y.y(this.$clazz) + "' - q:'" + this.$qualifier + "' look at scope source";
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: be1.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0036y<T> extends Lambda implements Function0<T> {
        final /* synthetic */ KClass<?> $clazz;
        final /* synthetic */ Function0<yd1.y> $parameters;
        final /* synthetic */ zd1.y $qualifier;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C0036y(zd1.y yVar, KClass<?> kClass, Function0<? extends yd1.y> function0) {
            super(0);
            this.$qualifier = yVar;
            this.$clazz = kClass;
            this.$parameters = function0;
        }

        @Override // kotlin.jvm.functions.Function0
        public final T invoke() {
            return (T) y.this.f(this.$qualifier, this.$clazz, this.$parameters);
        }
    }

    /* loaded from: classes.dex */
    public static final class zn extends Lambda implements Function0<String> {
        public static final zn y = new zn();

        public zn() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return "| remove parameters from stack";
        }
    }

    public y(zd1.y scopeQualifier, String id, boolean z2, qd1.y _koin) {
        Intrinsics.checkNotNullParameter(scopeQualifier, "scopeQualifier");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(_koin, "_koin");
        this.y = scopeQualifier;
        this.f3836n3 = id;
        this.f3839zn = z2;
        this.f3835gv = _koin;
        this.f3838v = new ArrayList<>();
        this.f3834fb = new ArrayList<>();
        this.f3837s = new ArrayDeque<>();
    }

    public final <T> T a(KClass<?> clazz, zd1.y yVar, Function0<? extends yd1.y> function0) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        try {
            return (T) zn(clazz, yVar, function0);
        } catch (ud1.v unused) {
            wd1.zn zn2 = this.f3835gv.zn();
            zn2.n3("|- No instance found for " + ee1.y.y(clazz) + " on scope " + this);
            return null;
        } catch (ud1.y unused2) {
            wd1.zn zn3 = this.f3835gv.zn();
            zn3.n3("|- Scope closed - no instance found for " + ee1.y.y(clazz) + " on scope " + this);
            return null;
        }
    }

    public final ArrayDeque<yd1.y> c5() {
        return this.f3837s;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        if (Intrinsics.areEqual(this.y, yVar.y) && Intrinsics.areEqual(this.f3836n3, yVar.f3836n3) && this.f3839zn == yVar.f3839zn && Intrinsics.areEqual(this.f3835gv, yVar.f3835gv)) {
            return true;
        }
        return false;
    }

    public final <T> T f(zd1.y yVar, KClass<?> kClass, Function0<? extends yd1.y> function0) {
        yd1.y invoke;
        if (!this.f3833c5) {
            if (function0 == null) {
                invoke = null;
            } else {
                invoke = function0.invoke();
            }
            if (invoke != null) {
                this.f3835gv.zn().c5(wd1.n3.DEBUG, new n3(invoke));
                this.f3837s.addFirst(invoke);
            }
            T t2 = (T) t(yVar, kClass, new vd1.n3(this.f3835gv, this, invoke), function0);
            if (invoke != null) {
                this.f3835gv.zn().c5(wd1.n3.DEBUG, zn.y);
                this.f3837s.removeFirstOrNull();
            }
            return t2;
        }
        throw new ud1.y("Scope '" + this.f3836n3 + "' is closed");
    }

    public final zd1.y fb() {
        return this.y;
    }

    public final <T> List<T> gv(KClass<?> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        List<T> zn2 = this.f3835gv.n3().zn(clazz, new vd1.n3(this.f3835gv, this, null, 4, null));
        ArrayList<y> arrayList = this.f3838v;
        ArrayList arrayList2 = new ArrayList();
        for (y yVar : arrayList) {
            CollectionsKt.addAll(arrayList2, yVar.gv(clazz));
        }
        return CollectionsKt.plus((Collection) zn2, (Iterable) arrayList2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.y.hashCode() * 31) + this.f3836n3.hashCode()) * 31;
        boolean z2 = this.f3839zn;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        return ((hashCode + i) * 31) + this.f3835gv.hashCode();
    }

    public final Object i9() {
        return this.f3832a;
    }

    public final <T> T n3(KClass<?> kClass, zd1.y yVar, Function0<? extends yd1.y> function0) {
        Iterator<y> it = this.f3838v.iterator();
        T t2 = null;
        while (it.hasNext() && (t2 = (T) it.next().a(kClass, yVar, function0)) == null) {
        }
        return t2;
    }

    public final qd1.y s() {
        return this.f3835gv;
    }

    public final <T> T t(zd1.y yVar, KClass<?> kClass, vd1.n3 n3Var, Function0<? extends yd1.y> function0) {
        Object obj = (T) this.f3835gv.n3().fb(yVar, kClass, this.y, n3Var);
        if (obj == null) {
            wd1.zn zn2 = s().zn();
            wd1.n3 n3Var2 = wd1.n3.DEBUG;
            zn2.c5(n3Var2, new gv(kClass, yVar));
            yd1.y firstOrNull = c5().firstOrNull();
            Object obj2 = null;
            if (firstOrNull == null) {
                obj = null;
            } else {
                obj = firstOrNull.n3(kClass);
            }
            if (obj == null) {
                s().zn().c5(n3Var2, new v(kClass, yVar));
                Object i92 = i9();
                if (i92 != null && kClass.isInstance(i92)) {
                    obj2 = i9();
                }
                obj = (T) obj2;
                if (obj == null) {
                    s().zn().c5(n3Var2, new a(kClass, yVar));
                    obj = (T) n3(kClass, yVar, function0);
                    if (obj == null) {
                        c5().clear();
                        s().zn().c5(n3Var2, fb.y);
                        tl(yVar, kClass);
                        throw new KotlinNothingValueException();
                    }
                }
            }
        }
        return (T) obj;
    }

    public final Void tl(zd1.y yVar, KClass<?> kClass) {
        String str = "";
        if (yVar != null) {
            String str2 = " & qualifier:'" + yVar + '\'';
            if (str2 != null) {
                str = str2;
            }
        }
        throw new ud1.v("|- No definition found for class:'" + ee1.y.y(kClass) + '\'' + str + ". Check your definitions!");
    }

    public String toString() {
        return "['" + this.f3836n3 + "']";
    }

    public final String v() {
        return this.f3836n3;
    }

    public final <T> T zn(KClass<?> clazz, zd1.y yVar, Function0<? extends yd1.y> function0) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        if (this.f3835gv.zn().fb(wd1.n3.DEBUG)) {
            String str = "";
            if (yVar != null) {
                String str2 = " with qualifier '" + yVar + '\'';
                if (str2 != null) {
                    str = str2;
                }
            }
            this.f3835gv.zn().n3("+- '" + ee1.y.y(clazz) + '\'' + str);
            Pair n32 = ce1.y.n3(new C0036y(yVar, clazz, function0));
            T t2 = (T) n32.component1();
            double doubleValue = ((Number) n32.component2()).doubleValue();
            this.f3835gv.zn().n3("|- '" + ee1.y.y(clazz) + "' in " + doubleValue + " ms");
            return t2;
        }
        return (T) f(yVar, clazz, function0);
    }
}
