package qc1;

import java.io.IOException;
import java.util.List;
import kc1.d0;
import kc1.fh;
import kc1.i4;
import kc1.mg;
import kc1.rz;
import kc1.tl;
import kc1.wz;
import kc1.x4;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import zc1.p;
/* loaded from: classes.dex */
public final class y implements x4 {
    public final wz y;

    public y(wz cookieJar) {
        Intrinsics.checkNotNullParameter(cookieJar, "cookieJar");
        this.y = cookieJar;
    }

    @Override // kc1.x4
    public rz intercept(x4.y chain) throws IOException {
        mg y;
        Intrinsics.checkNotNullParameter(chain, "chain");
        d0 y2 = chain.y();
        d0.y c52 = y2.c5();
        fh y7 = y2.y();
        if (y7 != null) {
            i4 contentType = y7.contentType();
            if (contentType != null) {
                c52.fb("Content-Type", contentType.toString());
            }
            long contentLength = y7.contentLength();
            if (contentLength != -1) {
                c52.fb("Content-Length", String.valueOf(contentLength));
                c52.tl("Transfer-Encoding");
            } else {
                c52.fb("Transfer-Encoding", "chunked");
                c52.tl("Content-Length");
            }
        }
        boolean z2 = false;
        if (y2.gv("Host") == null) {
            c52.fb("Host", lc1.n3.hw(y2.t(), false, 1, null));
        }
        if (y2.gv("Connection") == null) {
            c52.fb("Connection", "Keep-Alive");
        }
        if (y2.gv("Accept-Encoding") == null && y2.gv("Range") == null) {
            c52.fb("Accept-Encoding", "gzip");
            z2 = true;
        }
        List<tl> loadForRequest = this.y.loadForRequest(y2.t());
        if (!loadForRequest.isEmpty()) {
            c52.fb("Cookie", y(loadForRequest));
        }
        if (y2.gv("User-Agent") == null) {
            c52.fb("User-Agent", "okhttp/4.9.3");
        }
        rz n32 = chain.n3(c52.n3());
        v.fb(this.y, y2.t(), n32.b());
        rz.y co2 = n32.j5().co(y2);
        if (z2 && StringsKt.equals("gzip", rz.d(n32, "Content-Encoding", null, 2, null), true) && v.zn(n32) && (y = n32.y()) != null) {
            zc1.wz wzVar = new zc1.wz(y.source());
            co2.f(n32.b().v().c5("Content-Encoding").c5("Content-Length").a());
            co2.n3(new s(rz.d(n32, "Content-Type", null, 2, null), -1L, p.gv(wzVar)));
        }
        return co2.zn();
    }

    public final String y(List<tl> list) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (Object obj : list) {
            int i5 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            tl tlVar = (tl) obj;
            if (i > 0) {
                sb.append("; ");
            }
            sb.append(tlVar.v());
            sb.append('=');
            sb.append(tlVar.fb());
            i = i5;
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
