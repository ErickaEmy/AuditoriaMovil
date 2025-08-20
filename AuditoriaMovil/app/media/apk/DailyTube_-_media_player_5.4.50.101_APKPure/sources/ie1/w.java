package ie1;

import java.io.IOException;
import java.util.regex.Pattern;
import kc1.d0;
import kc1.f3;
import kc1.fh;
import kc1.mt;
import kc1.r;
import kc1.z;
/* loaded from: classes.dex */
public final class w {

    /* renamed from: t  reason: collision with root package name */
    public static final char[] f9260t = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: tl  reason: collision with root package name */
    public static final Pattern f9261tl = Pattern.compile("(.*/)?(\\.|%2e|%2E){1,2}(/.*)?");

    /* renamed from: a  reason: collision with root package name */
    public final z.y f9262a;

    /* renamed from: c5  reason: collision with root package name */
    public f3.y f9263c5;

    /* renamed from: f  reason: collision with root package name */
    public fh f9264f;

    /* renamed from: fb  reason: collision with root package name */
    public kc1.i4 f9265fb;

    /* renamed from: gv  reason: collision with root package name */
    public r.y f9266gv;

    /* renamed from: i9  reason: collision with root package name */
    public mt.y f9267i9;

    /* renamed from: n3  reason: collision with root package name */
    public final kc1.r f9268n3;

    /* renamed from: s  reason: collision with root package name */
    public final boolean f9269s;

    /* renamed from: v  reason: collision with root package name */
    public final d0.y f9270v = new d0.y();
    public final String y;

    /* renamed from: zn  reason: collision with root package name */
    public String f9271zn;

    /* loaded from: classes.dex */
    public static class y extends fh {

        /* renamed from: n3  reason: collision with root package name */
        public final kc1.i4 f9272n3;
        public final fh y;

        public y(fh fhVar, kc1.i4 i4Var) {
            this.y = fhVar;
            this.f9272n3 = i4Var;
        }

        @Override // kc1.fh
        public long contentLength() throws IOException {
            return this.y.contentLength();
        }

        @Override // kc1.fh
        public kc1.i4 contentType() {
            return this.f9272n3;
        }

        @Override // kc1.fh
        public void writeTo(zc1.a aVar) throws IOException {
            this.y.writeTo(aVar);
        }
    }

    public w(String str, kc1.r rVar, String str2, kc1.z zVar, kc1.i4 i4Var, boolean z2, boolean z3, boolean z4) {
        this.y = str;
        this.f9268n3 = rVar;
        this.f9271zn = str2;
        this.f9265fb = i4Var;
        this.f9269s = z2;
        if (zVar != null) {
            this.f9262a = zVar.v();
        } else {
            this.f9262a = new z.y();
        }
        if (z3) {
            this.f9267i9 = new mt.y();
        } else if (z4) {
            f3.y yVar = new f3.y();
            this.f9263c5 = yVar;
            yVar.a(f3.f9740f);
        }
    }

    public static String c5(String str, boolean z2) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            int codePointAt = str.codePointAt(i);
            if (codePointAt >= 32 && codePointAt < 127 && " \"<>^`{}|\\?#".indexOf(codePointAt) == -1 && (z2 || (codePointAt != 47 && codePointAt != 37))) {
                i += Character.charCount(codePointAt);
            } else {
                zc1.v vVar = new zc1.v();
                vVar.q(str, 0, i);
                i9(vVar, str, i, length, z2);
                return vVar.wf();
            }
        }
        return str;
    }

    public static void i9(zc1.v vVar, String str, int i, int i5, boolean z2) {
        zc1.v vVar2 = null;
        while (i < i5) {
            int codePointAt = str.codePointAt(i);
            if (!z2 || (codePointAt != 9 && codePointAt != 10 && codePointAt != 12 && codePointAt != 13)) {
                if (codePointAt >= 32 && codePointAt < 127 && " \"<>^`{}|\\?#".indexOf(codePointAt) == -1 && (z2 || (codePointAt != 47 && codePointAt != 37))) {
                    vVar.wm(codePointAt);
                } else {
                    if (vVar2 == null) {
                        vVar2 = new zc1.v();
                    }
                    vVar2.wm(codePointAt);
                    while (!vVar2.nf()) {
                        byte readByte = vVar2.readByte();
                        vVar.w2(37);
                        char[] cArr = f9260t;
                        vVar.w2(cArr[((readByte & 255) >> 4) & 15]);
                        vVar.w2(cArr[readByte & 15]);
                    }
                }
            }
            i += Character.charCount(codePointAt);
        }
    }

    public void a(String str, String str2, boolean z2) {
        if (this.f9271zn != null) {
            String c52 = c5(str2, z2);
            String str3 = this.f9271zn;
            String replace = str3.replace("{" + str + "}", c52);
            if (!f9261tl.matcher(replace).matches()) {
                this.f9271zn = replace;
                return;
            }
            throw new IllegalArgumentException("@Path parameters shouldn't perform path traversal ('.' or '..'): " + str2);
        }
        throw new AssertionError();
    }

    public d0.y f() {
        kc1.r r2;
        r.y yVar = this.f9266gv;
        if (yVar != null) {
            r2 = yVar.gv();
        } else {
            r2 = this.f9268n3.r(this.f9271zn);
            if (r2 == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.f9268n3 + ", Relative: " + this.f9271zn);
            }
        }
        y yVar2 = this.f9264f;
        if (yVar2 == null) {
            mt.y yVar3 = this.f9267i9;
            if (yVar3 != null) {
                yVar2 = yVar3.zn();
            } else {
                f3.y yVar4 = this.f9263c5;
                if (yVar4 != null) {
                    yVar2 = yVar4.v();
                } else if (this.f9269s) {
                    yVar2 = fh.create((kc1.i4) null, new byte[0]);
                }
            }
        }
        kc1.i4 i4Var = this.f9265fb;
        if (i4Var != null) {
            if (yVar2 != null) {
                yVar2 = new y(yVar2, i4Var);
            } else {
                this.f9262a.y("Content-Type", i4Var.toString());
            }
        }
        return this.f9270v.p(r2).s(this.f9262a.a()).c5(this.y, yVar2);
    }

    public void fb(String str, String str2, boolean z2) {
        String str3 = this.f9271zn;
        if (str3 != null) {
            r.y wz2 = this.f9268n3.wz(str3);
            this.f9266gv = wz2;
            if (wz2 != null) {
                this.f9271zn = null;
            } else {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.f9268n3 + ", Relative: " + this.f9271zn);
            }
        }
        if (z2) {
            this.f9266gv.n3(str, str2);
        } else {
            this.f9266gv.zn(str, str2);
        }
    }

    public void gv(kc1.z zVar, fh fhVar) {
        this.f9263c5.zn(zVar, fhVar);
    }

    public void n3(String str, String str2) {
        if ("Content-Type".equalsIgnoreCase(str)) {
            try {
                this.f9265fb = kc1.i4.v(str2);
                return;
            } catch (IllegalArgumentException e2) {
                throw new IllegalArgumentException("Malformed content type: " + str2, e2);
            }
        }
        this.f9262a.y(str, str2);
    }

    public <T> void s(Class<T> cls, T t2) {
        this.f9270v.wz(cls, t2);
    }

    public void t(fh fhVar) {
        this.f9264f = fhVar;
    }

    public void tl(Object obj) {
        this.f9271zn = obj.toString();
    }

    public void v(f3.zn znVar) {
        this.f9263c5.gv(znVar);
    }

    public void y(String str, String str2, boolean z2) {
        if (z2) {
            this.f9267i9.n3(str, str2);
        } else {
            this.f9267i9.y(str, str2);
        }
    }

    public void zn(kc1.z zVar) {
        this.f9262a.n3(zVar);
    }
}
