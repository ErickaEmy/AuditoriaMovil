package v5;

import android.os.SystemClock;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import kx.ta;
/* loaded from: classes.dex */
public final class ej {

    /* renamed from: gv  reason: collision with root package name */
    public static long f14338gv = 0;

    /* renamed from: v  reason: collision with root package name */
    public static String f14340v = "time.android.com";

    /* renamed from: zn  reason: collision with root package name */
    public static boolean f14341zn;
    public static final Object y = new Object();

    /* renamed from: n3  reason: collision with root package name */
    public static final Object f14339n3 = new Object();

    /* loaded from: classes.dex */
    public interface n3 {
        void n3(IOException iOException);

        void y();
    }

    public static String c5() {
        String str;
        synchronized (f14339n3) {
            str = f14340v;
        }
        return str;
    }

    public static boolean f() {
        boolean z2;
        synchronized (f14339n3) {
            z2 = f14341zn;
        }
        return z2;
    }

    public static void fb(byte b2, byte b3, int i, long j2) throws IOException {
        if (b2 != 3) {
            if (b3 != 4 && b3 != 5) {
                throw new IOException("SNTP: Untrusted mode: " + ((int) b3));
            } else if (i != 0 && i <= 15) {
                if (j2 != 0) {
                    return;
                }
                throw new IOException("SNTP: Zero transmitTime");
            } else {
                throw new IOException("SNTP: Untrusted stratum: " + i);
            }
        }
        throw new IOException("SNTP: Unsynchronized server");
    }

    public static void i9(@Nullable kx.ta taVar, @Nullable n3 n3Var) {
        if (f()) {
            if (n3Var != null) {
                n3Var.y();
                return;
            }
            return;
        }
        if (taVar == null) {
            taVar = new kx.ta("SntpClient");
        }
        taVar.wz(new gv(), new zn(n3Var), 1);
    }

    public static long s() {
        long j2;
        synchronized (f14339n3) {
            try {
                if (f14341zn) {
                    j2 = f14338gv;
                } else {
                    j2 = -9223372036854775807L;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return j2;
    }

    public static long t() throws IOException {
        InetAddress byName = InetAddress.getByName(c5());
        DatagramSocket datagramSocket = new DatagramSocket();
        try {
            datagramSocket.setSoTimeout(10000);
            byte[] bArr = new byte[48];
            DatagramPacket datagramPacket = new DatagramPacket(bArr, 48, byName, 123);
            bArr[0] = 27;
            long currentTimeMillis = System.currentTimeMillis();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            xc(bArr, 40, currentTimeMillis);
            datagramSocket.send(datagramPacket);
            datagramSocket.receive(new DatagramPacket(bArr, 48));
            long elapsedRealtime2 = SystemClock.elapsedRealtime();
            long j2 = currentTimeMillis + (elapsedRealtime2 - elapsedRealtime);
            byte b2 = bArr[0];
            long wz2 = wz(bArr, 24);
            long wz3 = wz(bArr, 32);
            long wz4 = wz(bArr, 40);
            fb((byte) ((b2 >> 6) & 3), (byte) (b2 & 7), bArr[1] & 255, wz4);
            long j4 = (j2 + (((wz3 - wz2) + (wz4 - j2)) / 2)) - elapsedRealtime2;
            datagramSocket.close();
            return j4;
        } catch (Throwable th) {
            try {
                datagramSocket.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static long tl(byte[] bArr, int i) {
        int i5 = bArr[i];
        int i6 = bArr[i + 1];
        int i8 = bArr[i + 2];
        int i10 = bArr[i + 3];
        if ((i5 & NotificationCompat.FLAG_HIGH_PRIORITY) == 128) {
            i5 = (i5 & 127) + NotificationCompat.FLAG_HIGH_PRIORITY;
        }
        if ((i6 & NotificationCompat.FLAG_HIGH_PRIORITY) == 128) {
            i6 = (i6 & 127) + NotificationCompat.FLAG_HIGH_PRIORITY;
        }
        if ((i8 & NotificationCompat.FLAG_HIGH_PRIORITY) == 128) {
            i8 = (i8 & 127) + NotificationCompat.FLAG_HIGH_PRIORITY;
        }
        if ((i10 & NotificationCompat.FLAG_HIGH_PRIORITY) == 128) {
            i10 = (i10 & 127) + NotificationCompat.FLAG_HIGH_PRIORITY;
        }
        return (i5 << 24) + (i6 << 16) + (i8 << 8) + i10;
    }

    public static /* synthetic */ long v() throws IOException {
        return t();
    }

    public static long wz(byte[] bArr, int i) {
        long tl2 = tl(bArr, i);
        long tl3 = tl(bArr, i + 4);
        if (tl2 == 0 && tl3 == 0) {
            return 0L;
        }
        return ((tl2 - 2208988800L) * 1000) + ((tl3 * 1000) / 4294967296L);
    }

    public static void xc(byte[] bArr, int i, long j2) {
        if (j2 == 0) {
            Arrays.fill(bArr, i, i + 8, (byte) 0);
            return;
        }
        long j4 = j2 / 1000;
        long j6 = j2 - (j4 * 1000);
        long j7 = j4 + 2208988800L;
        bArr[i] = (byte) (j7 >> 24);
        bArr[i + 1] = (byte) (j7 >> 16);
        bArr[i + 2] = (byte) (j7 >> 8);
        bArr[i + 3] = (byte) j7;
        long j8 = (j6 * 4294967296L) / 1000;
        bArr[i + 4] = (byte) (j8 >> 24);
        bArr[i + 5] = (byte) (j8 >> 16);
        bArr[i + 6] = (byte) (j8 >> 8);
        bArr[i + 7] = (byte) (Math.random() * 255.0d);
    }

    /* loaded from: classes.dex */
    public static final class gv implements ta.v {
        public gv() {
        }

        @Override // kx.ta.v
        public void load() throws IOException {
            synchronized (ej.y) {
                synchronized (ej.f14339n3) {
                    if (ej.f14341zn) {
                        return;
                    }
                    long v2 = ej.v();
                    synchronized (ej.f14339n3) {
                        long unused = ej.f14338gv = v2;
                        boolean unused2 = ej.f14341zn = true;
                    }
                }
            }
        }

        @Override // kx.ta.v
        public void n3() {
        }
    }

    /* loaded from: classes.dex */
    public static final class zn implements ta.n3<ta.v> {
        @Nullable
        public final n3 y;

        public zn(@Nullable n3 n3Var) {
            this.y = n3Var;
        }

        @Override // kx.ta.n3
        public ta.zn oz(ta.v vVar, long j2, long j4, IOException iOException, int i) {
            n3 n3Var = this.y;
            if (n3Var != null) {
                n3Var.n3(iOException);
            }
            return kx.ta.f10108a;
        }

        @Override // kx.ta.n3
        public void ta(ta.v vVar, long j2, long j4) {
            if (this.y != null) {
                if (!ej.f()) {
                    this.y.n3(new IOException(new ConcurrentModificationException()));
                } else {
                    this.y.y();
                }
            }
        }

        @Override // kx.ta.n3
        public void ud(ta.v vVar, long j2, long j4, boolean z2) {
        }
    }
}
