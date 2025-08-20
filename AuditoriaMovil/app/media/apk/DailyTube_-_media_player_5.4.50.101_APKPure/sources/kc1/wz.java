package kc1;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public interface wz {

    /* renamed from: n3  reason: collision with root package name */
    public static final y f9947n3 = new y(null);
    public static final wz y = new y.C0136y();

    /* loaded from: classes.dex */
    public static final class y {

        /* renamed from: kc1.wz$y$y  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0136y implements wz {
            @Override // kc1.wz
            public List<tl> loadForRequest(r url) {
                Intrinsics.checkNotNullParameter(url, "url");
                return CollectionsKt.emptyList();
            }

            @Override // kc1.wz
            public void saveFromResponse(r url, List<tl> cookies) {
                Intrinsics.checkNotNullParameter(url, "url");
                Intrinsics.checkNotNullParameter(cookies, "cookies");
            }
        }

        public y() {
        }

        public /* synthetic */ y(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    List<tl> loadForRequest(r rVar);

    void saveFromResponse(r rVar, List<tl> list);
}
