package xc1;

import java.security.cert.Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import uc1.s;
/* loaded from: classes.dex */
public abstract class zn {
    public static final y y = new y(null);

    /* loaded from: classes.dex */
    public static final class y {
        public y() {
        }

        public final zn y(X509TrustManager trustManager) {
            Intrinsics.checkNotNullParameter(trustManager, "trustManager");
            return s.f14065zn.fb().zn(trustManager);
        }

        public /* synthetic */ y(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public abstract List<Certificate> y(List<? extends Certificate> list, String str) throws SSLPeerUnverifiedException;
}
