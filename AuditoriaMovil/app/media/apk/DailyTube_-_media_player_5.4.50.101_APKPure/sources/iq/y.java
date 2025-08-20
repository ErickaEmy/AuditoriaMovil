package iq;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
/* loaded from: classes.dex */
public interface y {
    public static final C0125y y = C0125y.f9310zn;

    /* renamed from: iq.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0125y implements y {

        /* renamed from: zn  reason: collision with root package name */
        public static final /* synthetic */ C0125y f9310zn = new C0125y();

        /* renamed from: n3  reason: collision with root package name */
        public final /* synthetic */ y f9311n3 = (y) sd1.n3.y.zn().v().n3().zn(Reflection.getOrCreateKotlinClass(y.class), null, null);

        @Override // iq.y
        public String y(String head, String tag, String msg) {
            Intrinsics.checkNotNullParameter(head, "head");
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            return this.f9311n3.y(head, tag, msg);
        }
    }

    String y(String str, String str2, String str3);
}
