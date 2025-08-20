package sc1;

import java.io.IOException;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public interface t {

    /* renamed from: n3  reason: collision with root package name */
    public static final y f13837n3 = new y(null);
    public static final t y = new y.C0216y();

    /* loaded from: classes.dex */
    public static final class y {

        /* renamed from: sc1.t$y$y  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0216y implements t {
            @Override // sc1.t
            public boolean gv(int i, List<zn> responseHeaders, boolean z2) {
                Intrinsics.checkNotNullParameter(responseHeaders, "responseHeaders");
                return true;
            }

            @Override // sc1.t
            public void n3(int i, n3 errorCode) {
                Intrinsics.checkNotNullParameter(errorCode, "errorCode");
            }

            @Override // sc1.t
            public boolean y(int i, zc1.fb source, int i5, boolean z2) throws IOException {
                Intrinsics.checkNotNullParameter(source, "source");
                source.skip(i5);
                return true;
            }

            @Override // sc1.t
            public boolean zn(int i, List<zn> requestHeaders) {
                Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
                return true;
            }
        }

        public y() {
        }

        public /* synthetic */ y(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    boolean gv(int i, List<zn> list, boolean z2);

    void n3(int i, n3 n3Var);

    boolean y(int i, zc1.fb fbVar, int i5, boolean z2) throws IOException;

    boolean zn(int i, List<zn> list);
}
