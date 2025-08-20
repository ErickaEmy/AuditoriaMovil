package iq;

import android.app.Application;
import android.content.Context;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
/* loaded from: classes.dex */
public interface n3 {
    public static final y y = y.f9308n3;

    /* loaded from: classes.dex */
    public static final class y implements n3 {

        /* renamed from: n3  reason: collision with root package name */
        public static final /* synthetic */ y f9308n3 = new y();

        /* renamed from: zn  reason: collision with root package name */
        public static final Lazy<List<n3>> f9309zn = LazyKt.lazy(C0124y.y);

        /* renamed from: iq.n3$y$y  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0124y extends Lambda implements Function0<List<? extends n3>> {
            public static final C0124y y = new C0124y();

            public C0124y() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends n3> invoke() {
                return CollectionsKt.toList(sd1.n3.y.zn().v().n3().gv(Reflection.getOrCreateKotlinClass(n3.class)));
            }
        }

        public static /* synthetic */ void a(y yVar, String str, String str2, String str3, int i, Object obj) {
            if ((i & 4) != 0) {
                str3 = "";
            }
            yVar.v(str, str2, str3);
        }

        public final List<n3> fb() {
            return f9309zn.getValue();
        }

        public final void gv(String tag, String msg) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            a(this, tag, msg, null, 4, null);
        }

        @Override // iq.n3
        public void n3(Context context, Map<String, String> datas) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(datas, "datas");
            for (n3 n3Var : fb()) {
                n3Var.n3(context, datas);
            }
        }

        @Override // iq.n3
        public void setUserId(String userId) {
            Intrinsics.checkNotNullParameter(userId, "userId");
            for (n3 n3Var : fb()) {
                n3Var.setUserId(userId);
            }
        }

        public final void v(String tag, String msg, String head) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            Intrinsics.checkNotNullParameter(head, "head");
            for (n3 n3Var : fb()) {
                n3Var.y(iq.y.y.y(head, tag, msg));
            }
        }

        @Override // iq.n3
        public void y(String msg) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            for (n3 n3Var : fb()) {
                n3Var.y(msg);
            }
        }

        @Override // iq.n3
        public void zn(Application context, boolean z2) {
            Intrinsics.checkNotNullParameter(context, "context");
            for (n3 n3Var : fb()) {
                n3Var.zn(context, z2);
            }
        }
    }

    void n3(Context context, Map<String, String> map);

    void setUserId(String str);

    void y(String str);

    void zn(Application application, boolean z2);
}
