package pc1;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import kc1.t;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class n3 {

    /* renamed from: gv  reason: collision with root package name */
    public final List<t> f12553gv;

    /* renamed from: n3  reason: collision with root package name */
    public boolean f12554n3;
    public int y;

    /* renamed from: zn  reason: collision with root package name */
    public boolean f12555zn;

    public n3(List<t> connectionSpecs) {
        Intrinsics.checkNotNullParameter(connectionSpecs, "connectionSpecs");
        this.f12553gv = connectionSpecs;
    }

    public final boolean n3(IOException e2) {
        Intrinsics.checkNotNullParameter(e2, "e");
        this.f12555zn = true;
        if (this.f12554n3 && !(e2 instanceof ProtocolException) && !(e2 instanceof InterruptedIOException) && ((!(e2 instanceof SSLHandshakeException) || !(e2.getCause() instanceof CertificateException)) && !(e2 instanceof SSLPeerUnverifiedException) && (e2 instanceof SSLException))) {
            return true;
        }
        return false;
    }

    public final t y(SSLSocket sslSocket) throws IOException {
        t tVar;
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        int i = this.y;
        int size = this.f12553gv.size();
        while (true) {
            if (i < size) {
                tVar = this.f12553gv.get(i);
                if (tVar.v(sslSocket)) {
                    this.y = i + 1;
                    break;
                }
                i++;
            } else {
                tVar = null;
                break;
            }
        }
        if (tVar != null) {
            this.f12554n3 = zn(sslSocket);
            tVar.zn(sslSocket, this.f12555zn);
            return tVar;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unable to find acceptable protocols. isFallback=");
        sb.append(this.f12555zn);
        sb.append(',');
        sb.append(" modes=");
        sb.append(this.f12553gv);
        sb.append(',');
        sb.append(" supported protocols=");
        String[] enabledProtocols = sslSocket.getEnabledProtocols();
        Intrinsics.checkNotNull(enabledProtocols);
        String arrays = Arrays.toString(enabledProtocols);
        Intrinsics.checkNotNullExpressionValue(arrays, "java.util.Arrays.toString(this)");
        sb.append(arrays);
        throw new UnknownServiceException(sb.toString());
    }

    public final boolean zn(SSLSocket sSLSocket) {
        int size = this.f12553gv.size();
        for (int i = this.y; i < size; i++) {
            if (this.f12553gv.get(i).v(sSLSocket)) {
                return true;
            }
        }
        return false;
    }
}
