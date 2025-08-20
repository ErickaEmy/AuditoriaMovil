package kx;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.SocketTimeoutException;
/* loaded from: classes.dex */
public final class j extends fb {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f10043a;
    @Nullable

    /* renamed from: c5  reason: collision with root package name */
    public DatagramSocket f10044c5;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public InetAddress f10045f;

    /* renamed from: fb  reason: collision with root package name */
    public final DatagramPacket f10046fb;
    @Nullable

    /* renamed from: i9  reason: collision with root package name */
    public MulticastSocket f10047i9;
    @Nullable

    /* renamed from: s  reason: collision with root package name */
    public Uri f10048s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f10049t;

    /* renamed from: tl  reason: collision with root package name */
    public int f10050tl;

    /* renamed from: v  reason: collision with root package name */
    public final int f10051v;

    /* loaded from: classes.dex */
    public static final class y extends wz {
        public y(Throwable th, int i) {
            super(th, i);
        }
    }

    public j() {
        this(2000);
    }

    @Override // kx.tl
    public void close() {
        this.f10048s = null;
        MulticastSocket multicastSocket = this.f10047i9;
        if (multicastSocket != null) {
            try {
                multicastSocket.leaveGroup((InetAddress) v5.y.v(this.f10045f));
            } catch (IOException unused) {
            }
            this.f10047i9 = null;
        }
        DatagramSocket datagramSocket = this.f10044c5;
        if (datagramSocket != null) {
            datagramSocket.close();
            this.f10044c5 = null;
        }
        this.f10045f = null;
        this.f10050tl = 0;
        if (this.f10049t) {
            this.f10049t = false;
            r();
        }
    }

    public int gv() {
        DatagramSocket datagramSocket = this.f10044c5;
        if (datagramSocket == null) {
            return -1;
        }
        return datagramSocket.getLocalPort();
    }

    @Override // kx.tl
    @Nullable
    public Uri n3() {
        return this.f10048s;
    }

    @Override // kx.c5
    public int read(byte[] bArr, int i, int i5) throws y {
        if (i5 == 0) {
            return 0;
        }
        if (this.f10050tl == 0) {
            try {
                ((DatagramSocket) v5.y.v(this.f10044c5)).receive(this.f10046fb);
                int length = this.f10046fb.getLength();
                this.f10050tl = length;
                mt(length);
            } catch (SocketTimeoutException e2) {
                throw new y(e2, 2002);
            } catch (IOException e3) {
                throw new y(e3, 2001);
            }
        }
        int length2 = this.f10046fb.getLength();
        int i6 = this.f10050tl;
        int min = Math.min(i6, i5);
        System.arraycopy(this.f10043a, length2 - i6, bArr, i, min);
        this.f10050tl -= min;
        return min;
    }

    @Override // kx.tl
    public long y(p pVar) throws y {
        Uri uri = pVar.y;
        this.f10048s = uri;
        String str = (String) v5.y.v(uri.getHost());
        int port = this.f10048s.getPort();
        x4(pVar);
        try {
            this.f10045f = InetAddress.getByName(str);
            InetSocketAddress inetSocketAddress = new InetSocketAddress(this.f10045f, port);
            if (this.f10045f.isMulticastAddress()) {
                MulticastSocket multicastSocket = new MulticastSocket(inetSocketAddress);
                this.f10047i9 = multicastSocket;
                multicastSocket.joinGroup(this.f10045f);
                this.f10044c5 = this.f10047i9;
            } else {
                this.f10044c5 = new DatagramSocket(inetSocketAddress);
            }
            this.f10044c5.setSoTimeout(this.f10051v);
            this.f10049t = true;
            i4(pVar);
            return -1L;
        } catch (IOException e2) {
            throw new y(e2, 2001);
        } catch (SecurityException e3) {
            throw new y(e3, 2006);
        }
    }

    public j(int i) {
        this(i, 8000);
    }

    public j(int i, int i5) {
        super(true);
        this.f10051v = i5;
        byte[] bArr = new byte[i];
        this.f10043a = bArr;
        this.f10046fb = new DatagramPacket(bArr, 0, i);
    }
}
