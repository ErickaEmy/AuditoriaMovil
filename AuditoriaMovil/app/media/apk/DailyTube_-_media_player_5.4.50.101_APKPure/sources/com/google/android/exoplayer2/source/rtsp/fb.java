package com.google.android.exoplayer2.source.rtsp;

import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.source.rtsp.fb;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kx.ta;
import m1.ne;
import z0.x4;
/* loaded from: classes.dex */
public final class fb implements Closeable {

    /* renamed from: w  reason: collision with root package name */
    public static final Charset f4592w = w0.v.f14523zn;

    /* renamed from: f  reason: collision with root package name */
    public Socket f4593f;

    /* renamed from: s  reason: collision with root package name */
    public C0050fb f4595s;

    /* renamed from: t  reason: collision with root package name */
    public volatile boolean f4596t;
    public final gv y;

    /* renamed from: v  reason: collision with root package name */
    public final ta f4597v = new ta("ExoPlayer:RtspMessageChannel:ReceiverLoader");

    /* renamed from: fb  reason: collision with root package name */
    public final Map<Integer, n3> f4594fb = Collections.synchronizedMap(new HashMap());

    /* loaded from: classes.dex */
    public final class a implements ta.v {

        /* renamed from: n3  reason: collision with root package name */
        public final v f4599n3 = new v();
        public final DataInputStream y;

        /* renamed from: zn  reason: collision with root package name */
        public volatile boolean f4600zn;

        public a(InputStream inputStream) {
            this.y = new DataInputStream(inputStream);
        }

        @Override // kx.ta.v
        public void load() throws IOException {
            while (!this.f4600zn) {
                byte readByte = this.y.readByte();
                if (readByte == 36) {
                    y();
                } else {
                    zn(readByte);
                }
            }
        }

        @Override // kx.ta.v
        public void n3() {
            this.f4600zn = true;
        }

        public final void y() throws IOException {
            int readUnsignedByte = this.y.readUnsignedByte();
            int readUnsignedShort = this.y.readUnsignedShort();
            byte[] bArr = new byte[readUnsignedShort];
            this.y.readFully(bArr, 0, readUnsignedShort);
            n3 n3Var = (n3) fb.this.f4594fb.get(Integer.valueOf(readUnsignedByte));
            if (n3Var != null && !fb.this.f4596t) {
                n3Var.c5(bArr);
            }
        }

        public final void zn(byte b2) throws IOException {
            if (!fb.this.f4596t) {
                fb.this.y.zn(this.f4599n3.zn(b2, this.y));
            }
        }
    }

    /* renamed from: com.google.android.exoplayer2.source.rtsp.fb$fb  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public final class C0050fb implements Closeable {

        /* renamed from: fb  reason: collision with root package name */
        public final Handler f4601fb;

        /* renamed from: v  reason: collision with root package name */
        public final HandlerThread f4603v;
        public final OutputStream y;

        public C0050fb(OutputStream outputStream) {
            this.y = outputStream;
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:RtspMessageChannel:Sender");
            this.f4603v = handlerThread;
            handlerThread.start();
            this.f4601fb = new Handler(handlerThread.getLooper());
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            Handler handler = this.f4601fb;
            final HandlerThread handlerThread = this.f4603v;
            Objects.requireNonNull(handlerThread);
            handler.post(new Runnable() { // from class: r4.mt
                @Override // java.lang.Runnable
                public final void run() {
                    handlerThread.quit();
                }
            });
            try {
                this.f4603v.join();
            } catch (InterruptedException unused) {
                this.f4603v.interrupt();
            }
        }

        public void s(final List<String> list) {
            final byte[] n32 = s.n3(list);
            this.f4601fb.post(new Runnable() { // from class: r4.p
                @Override // java.lang.Runnable
                public final void run() {
                    fb.C0050fb.this.v(n32, list);
                }
            });
        }

        public final /* synthetic */ void v(byte[] bArr, List list) {
            try {
                this.y.write(bArr);
            } catch (Exception e2) {
                if (!fb.this.f4596t) {
                    fb.this.y.n3(list, e2);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public interface gv {
        void n3(List<String> list, Exception exc);

        void y(Exception exc);

        void zn(List<String> list);
    }

    /* loaded from: classes.dex */
    public interface n3 {
        void c5(byte[] bArr);
    }

    /* loaded from: classes.dex */
    public static final class v {

        /* renamed from: zn  reason: collision with root package name */
        public long f4605zn;
        public final List<String> y = new ArrayList();

        /* renamed from: n3  reason: collision with root package name */
        public int f4604n3 = 1;

        public static byte[] gv(byte b2, DataInputStream dataInputStream) throws IOException {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = {b2, dataInputStream.readByte()};
            byteArrayOutputStream.write(bArr);
            while (true) {
                if (bArr[0] == 13 && bArr[1] == 10) {
                    return byteArrayOutputStream.toByteArray();
                }
                bArr[0] = bArr[1];
                byte readByte = dataInputStream.readByte();
                bArr[1] = readByte;
                byteArrayOutputStream.write(readByte);
            }
        }

        @Nullable
        public final x4<String> n3(byte[] bArr) throws ne {
            boolean z2;
            if (bArr.length >= 2 && bArr[bArr.length - 2] == 13 && bArr[bArr.length - 1] == 10) {
                z2 = true;
            } else {
                z2 = false;
            }
            v5.y.y(z2);
            String str = new String(bArr, 0, bArr.length - 2, fb.f4592w);
            this.y.add(str);
            int i = this.f4604n3;
            if (i != 1) {
                if (i == 2) {
                    long fb2 = s.fb(str);
                    if (fb2 != -1) {
                        this.f4605zn = fb2;
                    }
                    if (str.isEmpty()) {
                        if (this.f4605zn > 0) {
                            this.f4604n3 = 3;
                            return null;
                        }
                        x4<String> d2 = x4.d(this.y);
                        v();
                        return d2;
                    }
                    return null;
                }
                throw new IllegalStateException();
            } else if (s.a(str)) {
                this.f4604n3 = 2;
                return null;
            } else {
                return null;
            }
        }

        public final void v() {
            this.y.clear();
            this.f4604n3 = 1;
            this.f4605zn = 0L;
        }

        public final x4<String> y(byte[] bArr) {
            boolean z2;
            String str;
            if (this.f4604n3 == 3) {
                z2 = true;
            } else {
                z2 = false;
            }
            v5.y.fb(z2);
            if (bArr.length > 0 && bArr[bArr.length - 1] == 10) {
                if (bArr.length > 1 && bArr[bArr.length - 2] == 13) {
                    str = new String(bArr, 0, bArr.length - 2, fb.f4592w);
                } else {
                    str = new String(bArr, 0, bArr.length - 1, fb.f4592w);
                }
                this.y.add(str);
                x4<String> d2 = x4.d(this.y);
                v();
                return d2;
            }
            throw new IllegalArgumentException("Message body is empty or does not end with a LF.");
        }

        public x4<String> zn(byte b2, DataInputStream dataInputStream) throws IOException {
            boolean z2;
            x4<String> n32 = n3(gv(b2, dataInputStream));
            while (n32 == null) {
                if (this.f4604n3 == 3) {
                    long j2 = this.f4605zn;
                    if (j2 > 0) {
                        int gv2 = d1.a.gv(j2);
                        if (gv2 != -1) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        v5.y.fb(z2);
                        byte[] bArr = new byte[gv2];
                        dataInputStream.readFully(bArr, 0, gv2);
                        n32 = y(bArr);
                    } else {
                        throw new IllegalStateException("Expects a greater than zero Content-Length.");
                    }
                } else {
                    n32 = n3(gv(dataInputStream.readByte(), dataInputStream));
                }
            }
            return n32;
        }
    }

    /* loaded from: classes.dex */
    public final class zn implements ta.n3<a> {
        public zn() {
        }

        @Override // kx.ta.n3
        /* renamed from: n3 */
        public void ta(a aVar, long j2, long j4) {
        }

        @Override // kx.ta.n3
        /* renamed from: y */
        public void ud(a aVar, long j2, long j4, boolean z2) {
        }

        @Override // kx.ta.n3
        /* renamed from: zn */
        public ta.zn oz(a aVar, long j2, long j4, IOException iOException, int i) {
            if (!fb.this.f4596t) {
                fb.this.y.y(iOException);
            }
            return ta.f10108a;
        }
    }

    public fb(gv gvVar) {
        this.y = gvVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f4596t) {
            return;
        }
        try {
            C0050fb c0050fb = this.f4595s;
            if (c0050fb != null) {
                c0050fb.close();
            }
            this.f4597v.t();
            Socket socket = this.f4593f;
            if (socket != null) {
                socket.close();
            }
            this.f4596t = true;
        } catch (Throwable th) {
            this.f4596t = true;
            throw th;
        }
    }

    public void co(List<String> list) {
        v5.y.c5(this.f4595s);
        this.f4595s.s(list);
    }

    public void mt(int i, n3 n3Var) {
        this.f4594fb.put(Integer.valueOf(i), n3Var);
    }

    public void p(Socket socket) throws IOException {
        this.f4593f = socket;
        this.f4595s = new C0050fb(socket.getOutputStream());
        this.f4597v.wz(new a(socket.getInputStream()), new zn(), 0);
    }
}
