package yc1;

import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kc1.d0;
import kc1.fh;
import kc1.i4;
import kc1.i9;
import kc1.mg;
import kc1.rz;
import kc1.x4;
import kc1.z;
import zc1.fb;
import zc1.v;
import zc1.wz;
/* loaded from: classes.dex */
public final class y implements x4 {

    /* renamed from: gv  reason: collision with root package name */
    public static final Charset f15333gv = Charset.forName("UTF-8");
    public final n3 y;

    /* renamed from: n3  reason: collision with root package name */
    public volatile Set<String> f15334n3 = Collections.emptySet();

    /* renamed from: zn  reason: collision with root package name */
    public volatile EnumC0254y f15335zn = EnumC0254y.NONE;

    /* loaded from: classes.dex */
    public interface n3 {
        void log(String str);
    }

    /* renamed from: yc1.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public enum EnumC0254y {
        NONE,
        BASIC,
        HEADERS,
        BODY
    }

    public y(n3 n3Var) {
        this.y = n3Var;
    }

    public static boolean n3(v vVar) {
        long j2;
        try {
            v vVar2 = new v();
            if (vVar.m() < 64) {
                j2 = vVar.m();
            } else {
                j2 = 64;
            }
            vVar.x4(vVar2, 0L, j2);
            for (int i = 0; i < 16; i++) {
                if (!vVar2.nf()) {
                    int ap2 = vVar2.ap();
                    if (Character.isISOControl(ap2) && !Character.isWhitespace(ap2)) {
                        return false;
                    }
                } else {
                    return true;
                }
            }
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    public static boolean y(z zVar) {
        String y = zVar.y("Content-Encoding");
        if (y != null && !y.equalsIgnoreCase("identity") && !y.equalsIgnoreCase("gzip")) {
            return true;
        }
        return false;
    }

    public y gv(EnumC0254y enumC0254y) {
        if (enumC0254y != null) {
            this.f15335zn = enumC0254y;
            return this;
        }
        throw new NullPointerException("level == null. Use Level.NONE instead.");
    }

    @Override // kc1.x4
    public rz intercept(x4.y yVar) throws IOException {
        boolean z2;
        boolean z3;
        String str;
        String str2;
        long j2;
        char c2;
        String sb;
        String str3;
        EnumC0254y enumC0254y = this.f15335zn;
        d0 y = yVar.y();
        if (enumC0254y == EnumC0254y.NONE) {
            return yVar.n3(y);
        }
        boolean z4 = true;
        if (enumC0254y == EnumC0254y.BODY) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2 && enumC0254y != EnumC0254y.HEADERS) {
            z3 = false;
        } else {
            z3 = true;
        }
        fh y2 = y.y();
        if (y2 == null) {
            z4 = false;
        }
        i9 zn2 = yVar.zn();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("--> ");
        sb2.append(y.s());
        sb2.append(' ');
        sb2.append(y.t());
        if (zn2 == null) {
            str = "";
        } else {
            str = " " + zn2.y();
        }
        sb2.append(str);
        String sb3 = sb2.toString();
        if (!z3 && z4) {
            sb3 = sb3 + " (" + y2.contentLength() + "-byte body)";
        }
        this.y.log(sb3);
        if (z3) {
            if (z4) {
                if (y2.contentType() != null) {
                    this.y.log("Content-Type: " + y2.contentType());
                }
                if (y2.contentLength() != -1) {
                    this.y.log("Content-Length: " + y2.contentLength());
                }
            }
            z a2 = y.a();
            int size = a2.size();
            for (int i = 0; i < size; i++) {
                String zn3 = a2.zn(i);
                if (!"Content-Type".equalsIgnoreCase(zn3) && !"Content-Length".equalsIgnoreCase(zn3)) {
                    zn(a2, i);
                }
            }
            if (z2 && z4) {
                if (y(y.a())) {
                    this.y.log("--> END " + y.s() + " (encoded body omitted)");
                } else {
                    v vVar = new v();
                    y2.writeTo(vVar);
                    Charset charset = f15333gv;
                    i4 contentType = y2.contentType();
                    if (contentType != null) {
                        charset = contentType.zn(charset);
                    }
                    this.y.log("");
                    if (n3(vVar)) {
                        this.y.log(vVar.g3(charset));
                        this.y.log("--> END " + y.s() + " (" + y2.contentLength() + "-byte body)");
                    } else {
                        this.y.log("--> END " + y.s() + " (binary " + y2.contentLength() + "-byte body omitted)");
                    }
                }
            } else {
                this.y.log("--> END " + y.s());
            }
        }
        long nanoTime = System.nanoTime();
        try {
            rz n32 = yVar.n3(y);
            long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime);
            mg y7 = n32.y();
            long contentLength = y7.contentLength();
            if (contentLength != -1) {
                str2 = contentLength + "-byte";
            } else {
                str2 = "unknown-length";
            }
            n3 n3Var = this.y;
            StringBuilder sb4 = new StringBuilder();
            sb4.append("<-- ");
            sb4.append(n32.mt());
            if (n32.k5().isEmpty()) {
                sb = "";
                j2 = contentLength;
                c2 = ' ';
            } else {
                StringBuilder sb5 = new StringBuilder();
                j2 = contentLength;
                c2 = ' ';
                sb5.append(' ');
                sb5.append(n32.k5());
                sb = sb5.toString();
            }
            sb4.append(sb);
            sb4.append(c2);
            sb4.append(n32.o4().t());
            sb4.append(" (");
            sb4.append(millis);
            sb4.append("ms");
            if (z3) {
                str3 = "";
            } else {
                str3 = ", " + str2 + " body";
            }
            sb4.append(str3);
            sb4.append(')');
            n3Var.log(sb4.toString());
            if (z3) {
                z b2 = n32.b();
                int size2 = b2.size();
                for (int i5 = 0; i5 < size2; i5++) {
                    zn(b2, i5);
                }
                if (z2 && qc1.v.y(n32)) {
                    if (y(n32.b())) {
                        this.y.log("<-- END HTTP (encoded body omitted)");
                    } else {
                        fb source = y7.source();
                        source.gv(Long.MAX_VALUE);
                        v n33 = source.n3();
                        wz wzVar = null;
                        if ("gzip".equalsIgnoreCase(b2.y("Content-Encoding"))) {
                            wz valueOf = Long.valueOf(n33.m());
                            try {
                                wz wzVar2 = new wz(n33.p());
                                try {
                                    n33 = new v();
                                    n33.a(wzVar2);
                                    wzVar2.close();
                                    wzVar = valueOf;
                                } catch (Throwable th) {
                                    th = th;
                                    wzVar = wzVar2;
                                    if (wzVar != null) {
                                        wzVar.close();
                                    }
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        }
                        Charset charset2 = f15333gv;
                        i4 contentType2 = y7.contentType();
                        if (contentType2 != null) {
                            charset2 = contentType2.zn(charset2);
                        }
                        if (!n3(n33)) {
                            this.y.log("");
                            this.y.log("<-- END HTTP (binary " + n33.m() + "-byte body omitted)");
                            return n32;
                        }
                        if (j2 != 0) {
                            this.y.log("");
                            this.y.log(n33.p().g3(charset2));
                        }
                        if (wzVar != null) {
                            this.y.log("<-- END HTTP (" + n33.m() + "-byte, " + wzVar + "-gzipped-byte body)");
                        } else {
                            this.y.log("<-- END HTTP (" + n33.m() + "-byte body)");
                        }
                    }
                } else {
                    this.y.log("<-- END HTTP");
                }
            }
            return n32;
        } catch (Exception e2) {
            this.y.log("<-- HTTP FAILED: " + e2);
            throw e2;
        }
    }

    public final void zn(z zVar, int i) {
        String c52;
        if (this.f15334n3.contains(zVar.zn(i))) {
            c52 = "██";
        } else {
            c52 = zVar.c5(i);
        }
        n3 n3Var = this.y;
        n3Var.log(zVar.zn(i) + ": " + c52);
    }
}
