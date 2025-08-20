package td1;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClass;
/* loaded from: classes.dex */
public final class y<T> {

    /* renamed from: a  reason: collision with root package name */
    public List<? extends KClass<?>> f13961a;

    /* renamed from: fb  reason: collision with root package name */
    public zn<T> f13962fb;

    /* renamed from: gv  reason: collision with root package name */
    public final Function2<be1.y, yd1.y, T> f13963gv;

    /* renamed from: n3  reason: collision with root package name */
    public final KClass<?> f13964n3;

    /* renamed from: v  reason: collision with root package name */
    public final gv f13965v;
    public final zd1.y y;

    /* renamed from: zn  reason: collision with root package name */
    public final zd1.y f13966zn;

    /* renamed from: td1.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0220y extends Lambda implements Function1<KClass<?>, CharSequence> {
        public static final C0220y y = new C0220y();

        public C0220y() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: y */
        public final CharSequence invoke(KClass<?> it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return ee1.y.y(it);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public y(zd1.y scopeQualifier, KClass<?> primaryType, zd1.y yVar, Function2<? super be1.y, ? super yd1.y, ? extends T> definition, gv kind, List<? extends KClass<?>> secondaryTypes) {
        Intrinsics.checkNotNullParameter(scopeQualifier, "scopeQualifier");
        Intrinsics.checkNotNullParameter(primaryType, "primaryType");
        Intrinsics.checkNotNullParameter(definition, "definition");
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(secondaryTypes, "secondaryTypes");
        this.y = scopeQualifier;
        this.f13964n3 = primaryType;
        this.f13966zn = yVar;
        this.f13963gv = definition;
        this.f13965v = kind;
        this.f13961a = secondaryTypes;
        this.f13962fb = new zn<>(null, 1, null);
    }

    public final void a(List<? extends KClass<?>> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.f13961a = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            y yVar = (y) obj;
            if (Intrinsics.areEqual(this.f13964n3, yVar.f13964n3) && Intrinsics.areEqual(this.f13966zn, yVar.f13966zn) && Intrinsics.areEqual(this.y, yVar.y)) {
                return true;
            }
            return false;
        }
        throw new NullPointerException("null cannot be cast to non-null type org.koin.core.definition.BeanDefinition<*>");
    }

    public final zd1.y gv() {
        return this.y;
    }

    public int hashCode() {
        int hashCode;
        zd1.y yVar = this.f13966zn;
        if (yVar == null) {
            hashCode = 0;
        } else {
            hashCode = yVar.hashCode();
        }
        return (((hashCode * 31) + this.f13964n3.hashCode()) * 31) + this.y.hashCode();
    }

    public final KClass<?> n3() {
        return this.f13964n3;
    }

    public String toString() {
        String stringPlus;
        String stringPlus2;
        String obj = this.f13965v.toString();
        String str = '\'' + ee1.y.y(this.f13964n3) + '\'';
        String str2 = "";
        if (this.f13966zn == null || (stringPlus = Intrinsics.stringPlus(",qualifier:", zn())) == null) {
            stringPlus = "";
        }
        if (Intrinsics.areEqual(this.y, ae1.zn.f105v.y())) {
            stringPlus2 = "";
        } else {
            stringPlus2 = Intrinsics.stringPlus(",scope:", gv());
        }
        if (!this.f13961a.isEmpty()) {
            str2 = Intrinsics.stringPlus(",binds:", CollectionsKt.joinToString$default(this.f13961a, ",", null, null, 0, null, C0220y.y, 30, null));
        }
        return '[' + obj + ':' + str + stringPlus + stringPlus2 + str2 + ']';
    }

    public final List<KClass<?>> v() {
        return this.f13961a;
    }

    public final Function2<be1.y, yd1.y, T> y() {
        return this.f13963gv;
    }

    public final zd1.y zn() {
        return this.f13966zn;
    }
}
