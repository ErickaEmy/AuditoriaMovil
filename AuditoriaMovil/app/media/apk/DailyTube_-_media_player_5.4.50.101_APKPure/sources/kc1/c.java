package kc1;

import java.io.IOException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public enum c {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2"),
    H2_PRIOR_KNOWLEDGE("h2_prior_knowledge"),
    QUIC("quic");
    

    /* renamed from: p  reason: collision with root package name */
    public static final y f9603p = new y(null);
    private final String protocol;

    /* loaded from: classes.dex */
    public static final class y {
        public y() {
        }

        public final c y(String protocol) throws IOException {
            Intrinsics.checkNotNullParameter(protocol, "protocol");
            c cVar = c.HTTP_1_0;
            if (!Intrinsics.areEqual(protocol, cVar.protocol)) {
                cVar = c.HTTP_1_1;
                if (!Intrinsics.areEqual(protocol, cVar.protocol)) {
                    cVar = c.H2_PRIOR_KNOWLEDGE;
                    if (!Intrinsics.areEqual(protocol, cVar.protocol)) {
                        cVar = c.HTTP_2;
                        if (!Intrinsics.areEqual(protocol, cVar.protocol)) {
                            cVar = c.SPDY_3;
                            if (!Intrinsics.areEqual(protocol, cVar.protocol)) {
                                cVar = c.QUIC;
                                if (!Intrinsics.areEqual(protocol, cVar.protocol)) {
                                    throw new IOException("Unexpected protocol: " + protocol);
                                }
                            }
                        }
                    }
                }
            }
            return cVar;
        }

        public /* synthetic */ y(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    c(String str) {
        this.protocol = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.protocol;
    }
}
