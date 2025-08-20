package ab1;

import android.app.Application;
import com.uv.v7.BuildConfig;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
/* loaded from: classes.dex */
public final class y {

    /* renamed from: v  reason: collision with root package name */
    public static Pair<String, String> f99v;
    public static final y y = new y();

    /* renamed from: n3  reason: collision with root package name */
    public static final Lazy f98n3 = LazyKt.lazy(C0001y.y);

    /* renamed from: zn  reason: collision with root package name */
    public static final Lazy f100zn = LazyKt.lazy(zn.y);

    /* renamed from: gv  reason: collision with root package name */
    public static final Lazy f97gv = LazyKt.lazy(n3.y);

    /* loaded from: classes.dex */
    public static final class n3 extends Lambda implements Function0<Pair<? extends String, ? extends String>> {
        public static final n3 y = new n3();

        public n3() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: y */
        public final Pair<String, String> invoke() {
            return y.y.gv(qa1.y.y());
        }
    }

    /* renamed from: ab1.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0001y extends Lambda implements Function0<Boolean> {
        public static final C0001y y = new C0001y();

        public C0001y() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            return y.y.zn(qa1.y.y());
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
            return y.y.v(qa1.y.y());
        }
    }

    public final Pair<String, String> gv(Application application) {
        Pair<String, String> pair;
        Intrinsics.checkNotNullParameter(application, "application");
        Pair<String, String> pair2 = f99v;
        if (pair2 != null) {
            return pair2;
        }
        String zn2 = ta1.zn.y.zn(application);
        if (zn2 == null) {
            return TuplesKt.to("unknown", null);
        }
        if (Intrinsics.areEqual(zn2, BuildConfig.SIGN)) {
            pair = TuplesKt.to("0", null);
        } else {
            pair = TuplesKt.to("1", zn2);
        }
        f99v = pair;
        return pair;
    }

    public final String n3() {
        return (String) f100zn.getValue();
    }

    public final String v(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        return gv(application).getFirst();
    }

    public final Pair<String, String> y() {
        return (Pair) f97gv.getValue();
    }

    public final Boolean zn(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        String v2 = v(application);
        if (Intrinsics.areEqual(v2, "1")) {
            return Boolean.TRUE;
        }
        if (Intrinsics.areEqual(v2, "0")) {
            return Boolean.FALSE;
        }
        return null;
    }
}
