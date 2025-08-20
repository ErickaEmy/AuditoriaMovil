package kx;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import kx.d0;
import kx.x4;
import z0.q9;
/* loaded from: classes.dex */
public class x4 extends fb implements d0 {

    /* renamed from: a  reason: collision with root package name */
    public final int f10135a;
    @Nullable

    /* renamed from: c5  reason: collision with root package name */
    public final d0.a f10136c5;

    /* renamed from: co  reason: collision with root package name */
    public long f10137co;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f10138f;

    /* renamed from: fb  reason: collision with root package name */
    public final int f10139fb;

    /* renamed from: i9  reason: collision with root package name */
    public final d0.a f10140i9;

    /* renamed from: mt  reason: collision with root package name */
    public long f10141mt;

    /* renamed from: p  reason: collision with root package name */
    public int f10142p;
    @Nullable

    /* renamed from: s  reason: collision with root package name */
    public final String f10143s;
    @Nullable

    /* renamed from: t  reason: collision with root package name */
    public w0.w<String> f10144t;
    @Nullable

    /* renamed from: tl  reason: collision with root package name */
    public p f10145tl;

    /* renamed from: v  reason: collision with root package name */
    public final boolean f10146v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f10147w;
    @Nullable

    /* renamed from: wz  reason: collision with root package name */
    public HttpURLConnection f10148wz;
    @Nullable

    /* renamed from: xc  reason: collision with root package name */
    public InputStream f10149xc;

    /* loaded from: classes.dex */
    public static final class n3 implements d0.n3 {

        /* renamed from: fb  reason: collision with root package name */
        public boolean f10151fb;
        @Nullable

        /* renamed from: gv  reason: collision with root package name */
        public String f10152gv;
        @Nullable

        /* renamed from: n3  reason: collision with root package name */
        public o f10153n3;

        /* renamed from: s  reason: collision with root package name */
        public boolean f10154s;
        @Nullable

        /* renamed from: zn  reason: collision with root package name */
        public w0.w<String> f10156zn;
        public final d0.a y = new d0.a();

        /* renamed from: v  reason: collision with root package name */
        public int f10155v = 8000;

        /* renamed from: a  reason: collision with root package name */
        public int f10150a = 8000;

        public n3 gv(int i) {
            this.f10150a = i;
            return this;
        }

        @Override // kx.tl.y
        /* renamed from: n3 */
        public x4 y() {
            x4 x4Var = new x4(this.f10152gv, this.f10155v, this.f10150a, this.f10151fb, this.y, this.f10156zn, this.f10154s);
            o oVar = this.f10153n3;
            if (oVar != null) {
                x4Var.i9(oVar);
            }
            return x4Var;
        }

        public n3 v(@Nullable String str) {
            this.f10152gv = str;
            return this;
        }

        public n3 zn(int i) {
            this.f10155v = i;
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static class zn extends z0.p<String, List<String>> {
        public final Map<String, List<String>> y;

        public zn(Map<String, List<String>> map) {
            this.y = map;
        }

        public static /* synthetic */ boolean f(Map.Entry entry) {
            if (entry.getKey() != null) {
                return true;
            }
            return false;
        }

        public static /* synthetic */ boolean t(String str) {
            if (str != null) {
                return true;
            }
            return false;
        }

        @Override // z0.p, java.util.Map
        public boolean containsKey(@Nullable Object obj) {
            if (obj != null && super.containsKey(obj)) {
                return true;
            }
            return false;
        }

        @Override // java.util.Map
        public boolean containsValue(@Nullable Object obj) {
            return super.zn(obj);
        }

        @Override // z0.p, java.util.Map
        public Set<Map.Entry<String, List<String>>> entrySet() {
            return q9.n3(super.entrySet(), new w0.w() { // from class: kx.f3
                @Override // w0.w
                public final boolean apply(Object obj) {
                    boolean f4;
                    f4 = x4.zn.f((Map.Entry) obj);
                    return f4;
                }
            });
        }

        @Override // java.util.Map
        public boolean equals(@Nullable Object obj) {
            if (obj != null && super.v(obj)) {
                return true;
            }
            return false;
        }

        @Override // java.util.Map
        public int hashCode() {
            return super.fb();
        }

        @Override // z0.p, java.util.Map
        @Nullable
        /* renamed from: i9 */
        public List<String> get(@Nullable Object obj) {
            if (obj == null) {
                return null;
            }
            return (List) super.get(obj);
        }

        @Override // z0.p, java.util.Map
        public boolean isEmpty() {
            if (super.isEmpty()) {
                return true;
            }
            if (super.size() == 1 && super.containsKey(null)) {
                return true;
            }
            return false;
        }

        @Override // z0.p, java.util.Map
        public Set<String> keySet() {
            return q9.n3(super.keySet(), new w0.w() { // from class: kx.i4
                @Override // w0.w
                public final boolean apply(Object obj) {
                    boolean t2;
                    t2 = x4.zn.t((String) obj);
                    return t2;
                }
            });
        }

        @Override // z0.mt
        /* renamed from: n3 */
        public Map<String, List<String>> y() {
            return this.y;
        }

        @Override // z0.p, java.util.Map
        public int size() {
            return super.size() - (super.containsKey(null) ? 1 : 0);
        }
    }

    public static boolean c(HttpURLConnection httpURLConnection) {
        return "gzip".equalsIgnoreCase(httpURLConnection.getHeaderField("Content-Encoding"));
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00ac, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.net.HttpURLConnection fh(kx.p r26) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 220
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kx.x4.fh(kx.p):java.net.HttpURLConnection");
    }

    public static void rz(@Nullable HttpURLConnection httpURLConnection, long j2) {
        int i;
        if (httpURLConnection != null && (i = v5.j5.y) >= 19 && i <= 20) {
            try {
                InputStream inputStream = httpURLConnection.getInputStream();
                if (j2 == -1) {
                    if (inputStream.read() == -1) {
                        return;
                    }
                } else if (j2 <= 2048) {
                    return;
                }
                String name = inputStream.getClass().getName();
                if ("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream".equals(name) || "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream".equals(name)) {
                    Method declaredMethod = ((Class) v5.y.v(inputStream.getClass().getSuperclass())).getDeclaredMethod("unexpectedEndOfInput", null);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(inputStream, null);
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // kx.tl
    public void close() throws d0.zn {
        try {
            InputStream inputStream = this.f10149xc;
            if (inputStream != null) {
                long j2 = this.f10141mt;
                long j4 = -1;
                if (j2 != -1) {
                    j4 = j2 - this.f10137co;
                }
                rz(this.f10148wz, j4);
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    throw new d0.zn(e2, (p) v5.j5.i9(this.f10145tl), 2000, 3);
                }
            }
        } finally {
            this.f10149xc = null;
            f3();
            if (this.f10147w) {
                this.f10147w = false;
                r();
            }
        }
    }

    public final void d(long j2, p pVar) throws IOException {
        if (j2 == 0) {
            return;
        }
        byte[] bArr = new byte[4096];
        while (j2 > 0) {
            int read = ((InputStream) v5.j5.i9(this.f10149xc)).read(bArr, 0, (int) Math.min(j2, 4096));
            if (!Thread.currentThread().isInterrupted()) {
                if (read != -1) {
                    j2 -= read;
                    mt(read);
                } else {
                    throw new d0.zn(pVar, 2008, 1);
                }
            } else {
                throw new d0.zn(new InterruptedIOException(), pVar, 2000, 1);
            }
        }
    }

    public final HttpURLConnection d0(URL url, int i, @Nullable byte[] bArr, long j2, long j4, boolean z2, boolean z3, Map<String, String> map) throws IOException {
        String str;
        boolean z4;
        HttpURLConnection mg2 = mg(url);
        mg2.setConnectTimeout(this.f10135a);
        mg2.setReadTimeout(this.f10139fb);
        HashMap hashMap = new HashMap();
        d0.a aVar = this.f10136c5;
        if (aVar != null) {
            hashMap.putAll(aVar.y());
        }
        hashMap.putAll(this.f10140i9.y());
        hashMap.putAll(map);
        for (Map.Entry entry : hashMap.entrySet()) {
            mg2.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
        String y2 = fh.y(j2, j4);
        if (y2 != null) {
            mg2.setRequestProperty("Range", y2);
        }
        String str2 = this.f10143s;
        if (str2 != null) {
            mg2.setRequestProperty("User-Agent", str2);
        }
        if (z2) {
            str = "gzip";
        } else {
            str = "identity";
        }
        mg2.setRequestProperty("Accept-Encoding", str);
        mg2.setInstanceFollowRedirects(z3);
        if (bArr != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        mg2.setDoOutput(z4);
        mg2.setRequestMethod(p.zn(i));
        if (bArr != null) {
            mg2.setFixedLengthStreamingMode(bArr.length);
            mg2.connect();
            OutputStream outputStream = mg2.getOutputStream();
            outputStream.write(bArr);
            outputStream.close();
        } else {
            mg2.connect();
        }
        return mg2;
    }

    public final void f3() {
        HttpURLConnection httpURLConnection = this.f10148wz;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e2) {
                v5.r.gv("DefaultHttpDataSource", "Unexpected error while disconnecting", e2);
            }
            this.f10148wz = null;
        }
    }

    @Override // kx.fb, kx.tl
    public Map<String, List<String>> fb() {
        HttpURLConnection httpURLConnection = this.f10148wz;
        if (httpURLConnection == null) {
            return z0.f3.x4();
        }
        return new zn(httpURLConnection.getHeaderFields());
    }

    public HttpURLConnection mg(URL url) throws IOException {
        return (HttpURLConnection) url.openConnection();
    }

    public final URL n(URL url, @Nullable String str, p pVar) throws d0.zn {
        if (str != null) {
            try {
                URL url2 = new URL(url, str);
                String protocol = url2.getProtocol();
                if (!"https".equals(protocol) && !"http".equals(protocol)) {
                    throw new d0.zn("Unsupported protocol redirect: " + protocol, pVar, 2001, 1);
                } else if (!this.f10146v && !protocol.equals(url.getProtocol())) {
                    throw new d0.zn("Disallowed cross-protocol redirect (" + url.getProtocol() + " to " + protocol + ")", pVar, 2001, 1);
                } else {
                    return url2;
                }
            } catch (MalformedURLException e2) {
                throw new d0.zn(e2, pVar, 2001, 1);
            }
        }
        throw new d0.zn("Null location redirect", pVar, 2001, 1);
    }

    @Override // kx.tl
    @Nullable
    public Uri n3() {
        HttpURLConnection httpURLConnection = this.f10148wz;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    @Override // kx.c5
    public int read(byte[] bArr, int i, int i5) throws d0.zn {
        try {
            return ta(bArr, i, i5);
        } catch (IOException e2) {
            throw d0.zn.v(e2, (p) v5.j5.i9(this.f10145tl), 2);
        }
    }

    public final int ta(byte[] bArr, int i, int i5) throws IOException {
        if (i5 == 0) {
            return 0;
        }
        long j2 = this.f10141mt;
        if (j2 != -1) {
            long j4 = j2 - this.f10137co;
            if (j4 == 0) {
                return -1;
            }
            i5 = (int) Math.min(i5, j4);
        }
        int read = ((InputStream) v5.j5.i9(this.f10149xc)).read(bArr, i, i5);
        if (read == -1) {
            return -1;
        }
        this.f10137co += read;
        mt(read);
        return read;
    }

    @Override // kx.tl
    public long y(p pVar) throws d0.zn {
        byte[] bArr;
        wz wzVar;
        this.f10145tl = pVar;
        long j2 = 0;
        this.f10137co = 0L;
        this.f10141mt = 0L;
        x4(pVar);
        try {
            HttpURLConnection fh2 = fh(pVar);
            this.f10148wz = fh2;
            this.f10142p = fh2.getResponseCode();
            String responseMessage = fh2.getResponseMessage();
            int i = this.f10142p;
            long j4 = -1;
            if (i >= 200 && i <= 299) {
                String contentType = fh2.getContentType();
                w0.w<String> wVar = this.f10144t;
                if (wVar != null && !wVar.apply(contentType)) {
                    f3();
                    throw new d0.gv(contentType, pVar);
                }
                if (this.f10142p == 200) {
                    long j6 = pVar.f10071fb;
                    if (j6 != 0) {
                        j2 = j6;
                    }
                }
                boolean c2 = c(fh2);
                if (!c2) {
                    long j7 = pVar.f10075s;
                    if (j7 != -1) {
                        this.f10141mt = j7;
                    } else {
                        long n32 = fh.n3(fh2.getHeaderField("Content-Length"), fh2.getHeaderField("Content-Range"));
                        if (n32 != -1) {
                            j4 = n32 - j2;
                        }
                        this.f10141mt = j4;
                    }
                } else {
                    this.f10141mt = pVar.f10075s;
                }
                try {
                    this.f10149xc = fh2.getInputStream();
                    if (c2) {
                        this.f10149xc = new GZIPInputStream(this.f10149xc);
                    }
                    this.f10147w = true;
                    i4(pVar);
                    try {
                        d(j2, pVar);
                        return this.f10141mt;
                    } catch (IOException e2) {
                        f3();
                        if (e2 instanceof d0.zn) {
                            throw ((d0.zn) e2);
                        }
                        throw new d0.zn(e2, pVar, 2000, 1);
                    }
                } catch (IOException e3) {
                    f3();
                    throw new d0.zn(e3, pVar, 2000, 1);
                }
            }
            Map<String, List<String>> headerFields = fh2.getHeaderFields();
            if (this.f10142p == 416) {
                if (pVar.f10071fb == fh.zn(fh2.getHeaderField("Content-Range"))) {
                    this.f10147w = true;
                    i4(pVar);
                    long j8 = pVar.f10075s;
                    if (j8 == -1) {
                        return 0L;
                    }
                    return j8;
                }
            }
            InputStream errorStream = fh2.getErrorStream();
            try {
                if (errorStream != null) {
                    bArr = v5.j5.vn(errorStream);
                } else {
                    bArr = v5.j5.f14357a;
                }
            } catch (IOException unused) {
                bArr = v5.j5.f14357a;
            }
            byte[] bArr2 = bArr;
            f3();
            if (this.f10142p == 416) {
                wzVar = new wz(2008);
            } else {
                wzVar = null;
            }
            throw new d0.v(this.f10142p, responseMessage, wzVar, headerFields, pVar, bArr2);
        } catch (IOException e5) {
            f3();
            throw d0.zn.v(e5, pVar, 1);
        }
    }

    public x4(@Nullable String str, int i, int i5, boolean z2, @Nullable d0.a aVar, @Nullable w0.w<String> wVar, boolean z3) {
        super(true);
        this.f10143s = str;
        this.f10135a = i;
        this.f10139fb = i5;
        this.f10146v = z2;
        this.f10136c5 = aVar;
        this.f10144t = wVar;
        this.f10140i9 = new d0.a();
        this.f10138f = z3;
    }
}
