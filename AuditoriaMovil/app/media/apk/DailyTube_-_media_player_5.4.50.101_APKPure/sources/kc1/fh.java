package kc1;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import kc1.i4;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
/* loaded from: classes.dex */
public abstract class fh {
    public static final y Companion = new y(null);

    /* loaded from: classes.dex */
    public static final class y {

        /* loaded from: classes.dex */
        public static final class n3 extends fh {

            /* renamed from: n3 */
            public final /* synthetic */ i4 f9761n3;
            public final /* synthetic */ zc1.s y;

            public n3(zc1.s sVar, i4 i4Var) {
                this.y = sVar;
                this.f9761n3 = i4Var;
            }

            @Override // kc1.fh
            public long contentLength() {
                return this.y.j();
            }

            @Override // kc1.fh
            public i4 contentType() {
                return this.f9761n3;
            }

            @Override // kc1.fh
            public void writeTo(zc1.a sink) {
                Intrinsics.checkNotNullParameter(sink, "sink");
                sink.x(this.y);
            }
        }

        /* renamed from: kc1.fh$y$y */
        /* loaded from: classes.dex */
        public static final class C0133y extends fh {

            /* renamed from: n3 */
            public final /* synthetic */ i4 f9762n3;
            public final /* synthetic */ File y;

            public C0133y(File file, i4 i4Var) {
                this.y = file;
                this.f9762n3 = i4Var;
            }

            @Override // kc1.fh
            public long contentLength() {
                return this.y.length();
            }

            @Override // kc1.fh
            public i4 contentType() {
                return this.f9762n3;
            }

            @Override // kc1.fh
            public void writeTo(zc1.a sink) {
                Intrinsics.checkNotNullParameter(sink, "sink");
                zc1.ta f4 = zc1.p.f(this.y);
                try {
                    sink.a(f4);
                    CloseableKt.closeFinally(f4, null);
                } finally {
                }
            }
        }

        /* loaded from: classes.dex */
        public static final class zn extends fh {

            /* renamed from: gv */
            public final /* synthetic */ int f9763gv;

            /* renamed from: n3 */
            public final /* synthetic */ i4 f9764n3;
            public final /* synthetic */ byte[] y;

            /* renamed from: zn */
            public final /* synthetic */ int f9765zn;

            public zn(byte[] bArr, i4 i4Var, int i, int i5) {
                this.y = bArr;
                this.f9764n3 = i4Var;
                this.f9765zn = i;
                this.f9763gv = i5;
            }

            @Override // kc1.fh
            public long contentLength() {
                return this.f9765zn;
            }

            @Override // kc1.fh
            public i4 contentType() {
                return this.f9764n3;
            }

            @Override // kc1.fh
            public void writeTo(zc1.a sink) {
                Intrinsics.checkNotNullParameter(sink, "sink");
                sink.write(this.y, this.f9763gv, this.f9765zn);
            }
        }

        public y() {
        }

        public static /* synthetic */ fh c5(y yVar, String str, i4 i4Var, int i, Object obj) {
            if ((i & 1) != 0) {
                i4Var = null;
            }
            return yVar.n3(str, i4Var);
        }

        public static /* synthetic */ fh f(y yVar, byte[] bArr, i4 i4Var, int i, int i5, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                i4Var = null;
            }
            if ((i6 & 2) != 0) {
                i = 0;
            }
            if ((i6 & 4) != 0) {
                i5 = bArr.length;
            }
            return yVar.s(bArr, i4Var, i, i5);
        }

        public static /* synthetic */ fh i9(y yVar, i4 i4Var, byte[] bArr, int i, int i5, int i6, Object obj) {
            if ((i6 & 4) != 0) {
                i = 0;
            }
            if ((i6 & 8) != 0) {
                i5 = bArr.length;
            }
            return yVar.a(i4Var, bArr, i, i5);
        }

        public final fh a(i4 i4Var, byte[] content, int i, int i5) {
            Intrinsics.checkNotNullParameter(content, "content");
            return s(content, i4Var, i, i5);
        }

        public final fh fb(zc1.s toRequestBody, i4 i4Var) {
            Intrinsics.checkNotNullParameter(toRequestBody, "$this$toRequestBody");
            return new n3(toRequestBody, i4Var);
        }

        public final fh gv(i4 i4Var, String content) {
            Intrinsics.checkNotNullParameter(content, "content");
            return n3(content, i4Var);
        }

        public final fh n3(String toRequestBody, i4 i4Var) {
            Intrinsics.checkNotNullParameter(toRequestBody, "$this$toRequestBody");
            Charset charset = Charsets.UTF_8;
            if (i4Var != null) {
                Charset gv2 = i4.gv(i4Var, null, 1, null);
                if (gv2 == null) {
                    i4.y yVar = i4.f9789fb;
                    i4Var = yVar.n3(i4Var + "; charset=utf-8");
                } else {
                    charset = gv2;
                }
            }
            byte[] bytes = toRequestBody.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            return s(bytes, i4Var, 0, bytes.length);
        }

        public final fh s(byte[] toRequestBody, i4 i4Var, int i, int i5) {
            Intrinsics.checkNotNullParameter(toRequestBody, "$this$toRequestBody");
            lc1.n3.c5(toRequestBody.length, i, i5);
            return new zn(toRequestBody, i4Var, i5, i);
        }

        public final fh v(i4 i4Var, zc1.s content) {
            Intrinsics.checkNotNullParameter(content, "content");
            return fb(content, i4Var);
        }

        public final fh y(File asRequestBody, i4 i4Var) {
            Intrinsics.checkNotNullParameter(asRequestBody, "$this$asRequestBody");
            return new C0133y(asRequestBody, i4Var);
        }

        public final fh zn(i4 i4Var, File file) {
            Intrinsics.checkNotNullParameter(file, "file");
            return y(file, i4Var);
        }

        public /* synthetic */ y(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final fh create(File file, i4 i4Var) {
        return Companion.y(file, i4Var);
    }

    public long contentLength() throws IOException {
        return -1L;
    }

    public abstract i4 contentType();

    public boolean isDuplex() {
        return false;
    }

    public boolean isOneShot() {
        return false;
    }

    public abstract void writeTo(zc1.a aVar) throws IOException;

    public static final fh create(String str, i4 i4Var) {
        return Companion.n3(str, i4Var);
    }

    public static final fh create(i4 i4Var, File file) {
        return Companion.zn(i4Var, file);
    }

    public static final fh create(i4 i4Var, String str) {
        return Companion.gv(i4Var, str);
    }

    public static final fh create(i4 i4Var, zc1.s sVar) {
        return Companion.v(i4Var, sVar);
    }

    public static final fh create(i4 i4Var, byte[] bArr) {
        return y.i9(Companion, i4Var, bArr, 0, 0, 12, null);
    }

    public static final fh create(i4 i4Var, byte[] bArr, int i) {
        return y.i9(Companion, i4Var, bArr, i, 0, 8, null);
    }

    public static final fh create(i4 i4Var, byte[] bArr, int i, int i5) {
        return Companion.a(i4Var, bArr, i, i5);
    }

    public static final fh create(zc1.s sVar, i4 i4Var) {
        return Companion.fb(sVar, i4Var);
    }

    public static final fh create(byte[] bArr) {
        return y.f(Companion, bArr, null, 0, 0, 7, null);
    }

    public static final fh create(byte[] bArr, i4 i4Var) {
        return y.f(Companion, bArr, i4Var, 0, 0, 6, null);
    }

    public static final fh create(byte[] bArr, i4 i4Var, int i) {
        return y.f(Companion, bArr, i4Var, i, 0, 4, null);
    }

    public static final fh create(byte[] bArr, i4 i4Var, int i, int i5) {
        return Companion.s(bArr, i4Var, i, i5);
    }
}
