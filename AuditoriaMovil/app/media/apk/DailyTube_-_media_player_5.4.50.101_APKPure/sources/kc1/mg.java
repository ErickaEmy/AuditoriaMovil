package kc1;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import kc1.i4;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
/* loaded from: classes.dex */
public abstract class mg implements Closeable {
    public static final n3 Companion = new n3(null);
    private Reader reader;

    /* loaded from: classes.dex */
    public static final class n3 {

        /* loaded from: classes.dex */
        public static final class y extends mg {

            /* renamed from: fb  reason: collision with root package name */
            public final /* synthetic */ long f9794fb;

            /* renamed from: v  reason: collision with root package name */
            public final /* synthetic */ i4 f9795v;
            public final /* synthetic */ zc1.fb y;

            public y(zc1.fb fbVar, i4 i4Var, long j2) {
                this.y = fbVar;
                this.f9795v = i4Var;
                this.f9794fb = j2;
            }

            @Override // kc1.mg
            public long contentLength() {
                return this.f9794fb;
            }

            @Override // kc1.mg
            public i4 contentType() {
                return this.f9795v;
            }

            @Override // kc1.mg
            public zc1.fb source() {
                return this.y;
            }
        }

        public n3() {
        }

        public static /* synthetic */ mg c5(n3 n3Var, byte[] bArr, i4 i4Var, int i, Object obj) {
            if ((i & 1) != 0) {
                i4Var = null;
            }
            return n3Var.s(bArr, i4Var);
        }

        public final mg a(zc1.fb asResponseBody, i4 i4Var, long j2) {
            Intrinsics.checkNotNullParameter(asResponseBody, "$this$asResponseBody");
            return new y(asResponseBody, i4Var, j2);
        }

        public final mg fb(zc1.s toResponseBody, i4 i4Var) {
            Intrinsics.checkNotNullParameter(toResponseBody, "$this$toResponseBody");
            return a(new zc1.v().qk(toResponseBody), i4Var, toResponseBody.j());
        }

        public final mg gv(i4 i4Var, zc1.s content) {
            Intrinsics.checkNotNullParameter(content, "content");
            return fb(content, i4Var);
        }

        public final mg n3(i4 i4Var, long j2, zc1.fb content) {
            Intrinsics.checkNotNullParameter(content, "content");
            return a(content, i4Var, j2);
        }

        public final mg s(byte[] toResponseBody, i4 i4Var) {
            Intrinsics.checkNotNullParameter(toResponseBody, "$this$toResponseBody");
            return a(new zc1.v().l(toResponseBody), i4Var, toResponseBody.length);
        }

        public final mg v(i4 i4Var, byte[] content) {
            Intrinsics.checkNotNullParameter(content, "content");
            return s(content, i4Var);
        }

        public final mg y(String toResponseBody, i4 i4Var) {
            Intrinsics.checkNotNullParameter(toResponseBody, "$this$toResponseBody");
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
            zc1.v j32 = new zc1.v().j3(toResponseBody, charset);
            return a(j32, i4Var, j32.m());
        }

        public final mg zn(i4 i4Var, String content) {
            Intrinsics.checkNotNullParameter(content, "content");
            return y(content, i4Var);
        }

        public /* synthetic */ n3(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public static final class y extends Reader {

        /* renamed from: fb  reason: collision with root package name */
        public final zc1.fb f9796fb;

        /* renamed from: s  reason: collision with root package name */
        public final Charset f9797s;

        /* renamed from: v  reason: collision with root package name */
        public Reader f9798v;
        public boolean y;

        public y(zc1.fb source, Charset charset) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(charset, "charset");
            this.f9796fb = source;
            this.f9797s = charset;
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.y = true;
            Reader reader = this.f9798v;
            if (reader != null) {
                reader.close();
            } else {
                this.f9796fb.close();
            }
        }

        @Override // java.io.Reader
        public int read(char[] cbuf, int i, int i5) throws IOException {
            Intrinsics.checkNotNullParameter(cbuf, "cbuf");
            if (!this.y) {
                Reader reader = this.f9798v;
                if (reader == null) {
                    reader = new InputStreamReader(this.f9796fb.le(), lc1.n3.z6(this.f9796fb, this.f9797s));
                    this.f9798v = reader;
                }
                return reader.read(cbuf, i, i5);
            }
            throw new IOException("Stream closed");
        }
    }

    private final Charset charset() {
        Charset zn2;
        i4 contentType = contentType();
        if (contentType == null || (zn2 = contentType.zn(Charsets.UTF_8)) == null) {
            return Charsets.UTF_8;
        }
        return zn2;
    }

    /* JADX WARN: Type inference failed for: r6v3, types: [T, java.lang.Object] */
    private final <T> T consumeSource(Function1<? super zc1.fb, ? extends T> function1, Function1<? super T, Integer> function12) {
        long contentLength = contentLength();
        if (contentLength <= Integer.MAX_VALUE) {
            zc1.fb source = source();
            try {
                T invoke = function1.invoke(source);
                InlineMarker.finallyStart(1);
                CloseableKt.closeFinally(source, null);
                InlineMarker.finallyEnd(1);
                int intValue = function12.invoke(invoke).intValue();
                if (contentLength != -1 && contentLength != intValue) {
                    throw new IOException("Content-Length (" + contentLength + ") and stream length (" + intValue + ") disagree");
                }
                return invoke;
            } finally {
            }
        } else {
            throw new IOException("Cannot buffer entire body for content length: " + contentLength);
        }
    }

    public static final mg create(String str, i4 i4Var) {
        return Companion.y(str, i4Var);
    }

    public final InputStream byteStream() {
        return source().le();
    }

    public final zc1.s byteString() throws IOException {
        long contentLength = contentLength();
        if (contentLength <= Integer.MAX_VALUE) {
            zc1.fb source = source();
            try {
                zc1.s bk2 = source.bk();
                CloseableKt.closeFinally(source, null);
                int j2 = bk2.j();
                if (contentLength != -1 && contentLength != j2) {
                    throw new IOException("Content-Length (" + contentLength + ") and stream length (" + j2 + ") disagree");
                }
                return bk2;
            } finally {
            }
        } else {
            throw new IOException("Cannot buffer entire body for content length: " + contentLength);
        }
    }

    public final byte[] bytes() throws IOException {
        long contentLength = contentLength();
        if (contentLength <= Integer.MAX_VALUE) {
            zc1.fb source = source();
            try {
                byte[] eb2 = source.eb();
                CloseableKt.closeFinally(source, null);
                int length = eb2.length;
                if (contentLength != -1 && contentLength != length) {
                    throw new IOException("Content-Length (" + contentLength + ") and stream length (" + length + ") disagree");
                }
                return eb2;
            } finally {
            }
        } else {
            throw new IOException("Cannot buffer entire body for content length: " + contentLength);
        }
    }

    public final Reader charStream() {
        Reader reader = this.reader;
        if (reader == null) {
            y yVar = new y(source(), charset());
            this.reader = yVar;
            return yVar;
        }
        return reader;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        lc1.n3.i9(source());
    }

    public abstract long contentLength();

    public abstract i4 contentType();

    public abstract zc1.fb source();

    public final String string() throws IOException {
        zc1.fb source = source();
        try {
            String g32 = source.g3(lc1.n3.z6(source, charset()));
            CloseableKt.closeFinally(source, null);
            return g32;
        } finally {
        }
    }

    public static final mg create(i4 i4Var, long j2, zc1.fb fbVar) {
        return Companion.n3(i4Var, j2, fbVar);
    }

    public static final mg create(i4 i4Var, String str) {
        return Companion.zn(i4Var, str);
    }

    public static final mg create(i4 i4Var, zc1.s sVar) {
        return Companion.gv(i4Var, sVar);
    }

    public static final mg create(i4 i4Var, byte[] bArr) {
        return Companion.v(i4Var, bArr);
    }

    public static final mg create(zc1.fb fbVar, i4 i4Var, long j2) {
        return Companion.a(fbVar, i4Var, j2);
    }

    public static final mg create(zc1.s sVar, i4 i4Var) {
        return Companion.fb(sVar, i4Var);
    }

    public static final mg create(byte[] bArr, i4 i4Var) {
        return Companion.s(bArr, i4Var);
    }
}
