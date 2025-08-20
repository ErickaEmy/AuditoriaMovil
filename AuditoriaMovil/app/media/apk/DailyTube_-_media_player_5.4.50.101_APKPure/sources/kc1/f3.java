package kc1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kc1.fh;
import kc1.i4;
import kc1.z;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class f3 extends fh {

    /* renamed from: c5  reason: collision with root package name */
    public static final i4 f9739c5;

    /* renamed from: f  reason: collision with root package name */
    public static final i4 f9740f;

    /* renamed from: fb  reason: collision with root package name */
    public static final i4 f9741fb;

    /* renamed from: i9  reason: collision with root package name */
    public static final i4 f9742i9;

    /* renamed from: s  reason: collision with root package name */
    public static final i4 f9743s;

    /* renamed from: t  reason: collision with root package name */
    public static final byte[] f9744t;

    /* renamed from: tl  reason: collision with root package name */
    public static final byte[] f9745tl;

    /* renamed from: wz  reason: collision with root package name */
    public static final byte[] f9746wz;

    /* renamed from: xc  reason: collision with root package name */
    public static final n3 f9747xc = new n3(null);

    /* renamed from: gv  reason: collision with root package name */
    public final i4 f9748gv;

    /* renamed from: n3  reason: collision with root package name */
    public long f9749n3;

    /* renamed from: v  reason: collision with root package name */
    public final List<zn> f9750v;
    public final i4 y;

    /* renamed from: zn  reason: collision with root package name */
    public final zc1.s f9751zn;

    /* loaded from: classes.dex */
    public static final class n3 {
        public n3() {
        }

        public final void y(StringBuilder appendQuotedString, String key) {
            Intrinsics.checkNotNullParameter(appendQuotedString, "$this$appendQuotedString");
            Intrinsics.checkNotNullParameter(key, "key");
            appendQuotedString.append('\"');
            int length = key.length();
            for (int i = 0; i < length; i++) {
                char charAt = key.charAt(i);
                if (charAt != '\n') {
                    if (charAt != '\r') {
                        if (charAt != '\"') {
                            appendQuotedString.append(charAt);
                        } else {
                            appendQuotedString.append("%22");
                        }
                    } else {
                        appendQuotedString.append("%0D");
                    }
                } else {
                    appendQuotedString.append("%0A");
                }
            }
            appendQuotedString.append('\"');
        }

        public /* synthetic */ n3(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public static final class y {

        /* renamed from: n3  reason: collision with root package name */
        public i4 f9752n3;
        public final zc1.s y;

        /* renamed from: zn  reason: collision with root package name */
        public final List<zn> f9753zn;

        public y() {
            this(null, 1, null);
        }

        public final y a(i4 type) {
            Intrinsics.checkNotNullParameter(type, "type");
            if (Intrinsics.areEqual(type.c5(), "multipart")) {
                this.f9752n3 = type;
                return this;
            }
            throw new IllegalArgumentException(("multipart != " + type).toString());
        }

        public final y gv(zn part) {
            Intrinsics.checkNotNullParameter(part, "part");
            this.f9753zn.add(part);
            return this;
        }

        public final y n3(String name, String str, fh body) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(body, "body");
            gv(zn.f9754zn.zn(name, str, body));
            return this;
        }

        public final f3 v() {
            if (!this.f9753zn.isEmpty()) {
                return new f3(this.y, this.f9752n3, lc1.n3.j5(this.f9753zn));
            }
            throw new IllegalStateException("Multipart body must have at least one part.");
        }

        public final y y(String name, String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            gv(zn.f9754zn.n3(name, value));
            return this;
        }

        public final y zn(z zVar, fh body) {
            Intrinsics.checkNotNullParameter(body, "body");
            gv(zn.f9754zn.y(zVar, body));
            return this;
        }

        public y(String boundary) {
            Intrinsics.checkNotNullParameter(boundary, "boundary");
            this.y = zc1.s.fb.gv(boundary);
            this.f9752n3 = f3.f9741fb;
            this.f9753zn = new ArrayList();
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public /* synthetic */ y(java.lang.String r1, int r2, kotlin.jvm.internal.DefaultConstructorMarker r3) {
            /*
                r0 = this;
                r2 = r2 & 1
                if (r2 == 0) goto L11
                java.util.UUID r1 = java.util.UUID.randomUUID()
                java.lang.String r1 = r1.toString()
                java.lang.String r2 = "UUID.randomUUID().toString()"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            L11:
                r0.<init>(r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kc1.f3.y.<init>(java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }
    }

    /* loaded from: classes.dex */
    public static final class zn {

        /* renamed from: zn  reason: collision with root package name */
        public static final y f9754zn = new y(null);

        /* renamed from: n3  reason: collision with root package name */
        public final fh f9755n3;
        public final z y;

        /* loaded from: classes.dex */
        public static final class y {
            public y() {
            }

            public final zn n3(String name, String value) {
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(value, "value");
                return zn(name, null, fh.y.c5(fh.Companion, value, null, 1, null));
            }

            public final zn y(z zVar, fh body) {
                String str;
                boolean z2;
                String str2;
                Intrinsics.checkNotNullParameter(body, "body");
                if (zVar != null) {
                    str = zVar.y("Content-Type");
                } else {
                    str = null;
                }
                boolean z3 = false;
                if (str == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    if (zVar != null) {
                        str2 = zVar.y("Content-Length");
                    } else {
                        str2 = null;
                    }
                    if (str2 == null) {
                        z3 = true;
                    }
                    if (z3) {
                        return new zn(zVar, body, null);
                    }
                    throw new IllegalArgumentException("Unexpected header: Content-Length");
                }
                throw new IllegalArgumentException("Unexpected header: Content-Type");
            }

            public final zn zn(String name, String str, fh body) {
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(body, "body");
                StringBuilder sb = new StringBuilder();
                sb.append("form-data; name=");
                n3 n3Var = f3.f9747xc;
                n3Var.y(sb, name);
                if (str != null) {
                    sb.append("; filename=");
                    n3Var.y(sb, str);
                }
                String sb2 = sb.toString();
                Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
                return y(new z.y().v("Content-Disposition", sb2).a(), body);
            }

            public /* synthetic */ y(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public zn(z zVar, fh fhVar) {
            this.y = zVar;
            this.f9755n3 = fhVar;
        }

        public final z n3() {
            return this.y;
        }

        public final fh y() {
            return this.f9755n3;
        }

        public /* synthetic */ zn(z zVar, fh fhVar, DefaultConstructorMarker defaultConstructorMarker) {
            this(zVar, fhVar);
        }
    }

    static {
        i4.y yVar = i4.f9789fb;
        f9741fb = yVar.y("multipart/mixed");
        f9743s = yVar.y("multipart/alternative");
        f9739c5 = yVar.y("multipart/digest");
        f9742i9 = yVar.y("multipart/parallel");
        f9740f = yVar.y("multipart/form-data");
        f9744t = new byte[]{(byte) 58, (byte) 32};
        f9745tl = new byte[]{(byte) 13, (byte) 10};
        byte b2 = (byte) 45;
        f9746wz = new byte[]{b2, b2};
    }

    public f3(zc1.s boundaryByteString, i4 type, List<zn> parts) {
        Intrinsics.checkNotNullParameter(boundaryByteString, "boundaryByteString");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(parts, "parts");
        this.f9751zn = boundaryByteString;
        this.f9748gv = type;
        this.f9750v = parts;
        i4.y yVar = i4.f9789fb;
        this.y = yVar.y(type + "; boundary=" + y());
        this.f9749n3 = -1L;
    }

    private final long n3(zc1.a aVar, boolean z2) throws IOException {
        zc1.a aVar2;
        if (z2) {
            aVar = new zc1.v();
            aVar2 = aVar;
        } else {
            aVar2 = null;
        }
        int size = this.f9750v.size();
        long j2 = 0;
        for (int i = 0; i < size; i++) {
            zn znVar = this.f9750v.get(i);
            z n32 = znVar.n3();
            fh y2 = znVar.y();
            Intrinsics.checkNotNull(aVar);
            aVar.write(f9746wz);
            aVar.x(this.f9751zn);
            aVar.write(f9745tl);
            if (n32 != null) {
                int size2 = n32.size();
                for (int i5 = 0; i5 < size2; i5++) {
                    aVar.n(n32.zn(i5)).write(f9744t).n(n32.c5(i5)).write(f9745tl);
                }
            }
            i4 contentType = y2.contentType();
            if (contentType != null) {
                aVar.n("Content-Type: ").n(contentType.toString()).write(f9745tl);
            }
            long contentLength = y2.contentLength();
            if (contentLength != -1) {
                aVar.n("Content-Length: ").f7(contentLength).write(f9745tl);
            } else if (z2) {
                Intrinsics.checkNotNull(aVar2);
                aVar2.s();
                return -1L;
            }
            byte[] bArr = f9745tl;
            aVar.write(bArr);
            if (z2) {
                j2 += contentLength;
            } else {
                y2.writeTo(aVar);
            }
            aVar.write(bArr);
        }
        Intrinsics.checkNotNull(aVar);
        byte[] bArr2 = f9746wz;
        aVar.write(bArr2);
        aVar.x(this.f9751zn);
        aVar.write(bArr2);
        aVar.write(f9745tl);
        if (z2) {
            Intrinsics.checkNotNull(aVar2);
            long m2 = j2 + aVar2.m();
            aVar2.s();
            return m2;
        }
        return j2;
    }

    @Override // kc1.fh
    public long contentLength() throws IOException {
        long j2 = this.f9749n3;
        if (j2 == -1) {
            long n32 = n3(null, true);
            this.f9749n3 = n32;
            return n32;
        }
        return j2;
    }

    @Override // kc1.fh
    public i4 contentType() {
        return this.y;
    }

    @Override // kc1.fh
    public void writeTo(zc1.a sink) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        n3(sink, false);
    }

    public final String y() {
        return this.f9751zn.dm();
    }
}
