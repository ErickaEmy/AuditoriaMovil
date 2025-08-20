package okhttp3;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public interface Dns {
    public static final y y = new y(null);
    public static final Dns SYSTEM = new y.C0177y();

    /* loaded from: classes.dex */
    public static final class y {

        /* renamed from: okhttp3.Dns$y$y  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0177y implements Dns {
            @Override // okhttp3.Dns
            public List<InetAddress> lookup(String hostname) {
                Intrinsics.checkNotNullParameter(hostname, "hostname");
                try {
                    InetAddress[] allByName = InetAddress.getAllByName(hostname);
                    Intrinsics.checkNotNullExpressionValue(allByName, "InetAddress.getAllByName(hostname)");
                    return ArraysKt.toList(allByName);
                } catch (NullPointerException e2) {
                    UnknownHostException unknownHostException = new UnknownHostException("Broken system behaviour for dns lookup of " + hostname);
                    unknownHostException.initCause(e2);
                    throw unknownHostException;
                }
            }
        }

        public y() {
        }

        public /* synthetic */ y(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    List<InetAddress> lookup(String str) throws UnknownHostException;
}
