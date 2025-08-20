package kd1;

import ae1.zn;
import android.app.Application;
import android.content.Context;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import td1.gv;
/* loaded from: classes.dex */
public final class y {

    /* loaded from: classes.dex */
    public static final class n3 extends Lambda implements Function1<xd1.y, Unit> {
        final /* synthetic */ Context $androidContext;

        /* renamed from: kd1.y$n3$y  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0139y extends Lambda implements Function2<be1.y, yd1.y, Context> {
            final /* synthetic */ Context $androidContext;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0139y(Context context) {
                super(2);
                this.$androidContext = context;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: y */
            public final Context invoke(be1.y single, yd1.y it) {
                Intrinsics.checkNotNullParameter(single, "$this$single");
                Intrinsics.checkNotNullParameter(it, "it");
                return this.$androidContext;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n3(Context context) {
            super(1);
            this.$androidContext = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(xd1.y yVar) {
            invoke2(yVar);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(xd1.y module) {
            Intrinsics.checkNotNullParameter(module, "$this$module");
            C0139y c0139y = new C0139y(this.$androidContext);
            gv gvVar = gv.Singleton;
            zn.y yVar = zn.f105v;
            td1.y yVar2 = new td1.y(yVar.y(), Reflection.getOrCreateKotlinClass(Context.class), null, c0139y, gvVar, CollectionsKt.emptyList());
            String y = td1.n3.y(yVar2.n3(), null, yVar.y());
            vd1.gv<?> gvVar2 = new vd1.gv<>(yVar2);
            xd1.y.a(module, y, gvVar2, false, 4, null);
            if (module.y()) {
                module.n3().add(gvVar2);
            }
            new Pair(module, gvVar2);
        }
    }

    /* renamed from: kd1.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0140y extends Lambda implements Function1<xd1.y, Unit> {
        final /* synthetic */ Context $androidContext;

        /* renamed from: kd1.y$y$y  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0141y extends Lambda implements Function2<be1.y, yd1.y, Context> {
            final /* synthetic */ Context $androidContext;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0141y(Context context) {
                super(2);
                this.$androidContext = context;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: y */
            public final Context invoke(be1.y single, yd1.y it) {
                Intrinsics.checkNotNullParameter(single, "$this$single");
                Intrinsics.checkNotNullParameter(it, "it");
                return this.$androidContext;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0140y(Context context) {
            super(1);
            this.$androidContext = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(xd1.y yVar) {
            invoke2(yVar);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(xd1.y module) {
            Intrinsics.checkNotNullParameter(module, "$this$module");
            C0141y c0141y = new C0141y(this.$androidContext);
            gv gvVar = gv.Singleton;
            zn.y yVar = zn.f105v;
            td1.y yVar2 = new td1.y(yVar.y(), Reflection.getOrCreateKotlinClass(Context.class), null, c0141y, gvVar, CollectionsKt.emptyList());
            String y = td1.n3.y(yVar2.n3(), null, yVar.y());
            vd1.gv<?> gvVar2 = new vd1.gv<>(yVar2);
            xd1.y.a(module, y, gvVar2, false, 4, null);
            if (module.y()) {
                module.n3().add(gvVar2);
            }
            de1.y.y(new Pair(module, gvVar2), Reflection.getOrCreateKotlinClass(Application.class));
        }
    }

    public static final qd1.n3 n3(qd1.n3 n3Var, wd1.n3 level) {
        Intrinsics.checkNotNullParameter(n3Var, "<this>");
        Intrinsics.checkNotNullParameter(level, "level");
        n3Var.n3().c5(new ld1.y(level));
        return n3Var;
    }

    public static final qd1.n3 y(qd1.n3 n3Var, Context androidContext) {
        Intrinsics.checkNotNullParameter(n3Var, "<this>");
        Intrinsics.checkNotNullParameter(androidContext, "androidContext");
        if (n3Var.n3().zn().fb(wd1.n3.INFO)) {
            n3Var.n3().zn().a("[init] declare Android Context");
        }
        if (androidContext instanceof Application) {
            qd1.y.fb(n3Var.n3(), CollectionsKt.listOf(de1.n3.n3(false, new C0140y(androidContext), 1, null)), false, 2, null);
        } else {
            qd1.y.fb(n3Var.n3(), CollectionsKt.listOf(de1.n3.n3(false, new n3(androidContext), 1, null)), false, 2, null);
        }
        return n3Var;
    }
}
