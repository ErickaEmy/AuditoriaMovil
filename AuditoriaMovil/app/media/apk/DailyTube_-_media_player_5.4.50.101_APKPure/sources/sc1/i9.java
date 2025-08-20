package sc1;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sc1.gv;
/* loaded from: classes.dex */
public final class i9 implements Closeable {

    /* renamed from: p  reason: collision with root package name */
    public static final y f13805p = new y(null);

    /* renamed from: w  reason: collision with root package name */
    public static final Logger f13806w = Logger.getLogger(v.class.getName());

    /* renamed from: f  reason: collision with root package name */
    public final zc1.a f13807f;

    /* renamed from: fb  reason: collision with root package name */
    public boolean f13808fb;

    /* renamed from: s  reason: collision with root package name */
    public final gv.n3 f13809s;

    /* renamed from: t  reason: collision with root package name */
    public final boolean f13810t;

    /* renamed from: v  reason: collision with root package name */
    public int f13811v;
    public final zc1.v y;

    /* loaded from: classes.dex */
    public static final class y {
        public y() {
        }

        public /* synthetic */ y(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public i9(zc1.a sink, boolean z2) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        this.f13807f = sink;
        this.f13810t = z2;
        zc1.v vVar = new zc1.v();
        this.y = vVar;
        this.f13811v = 16384;
        this.f13809s = new gv.n3(0, false, vVar, 3, null);
    }

    public final synchronized void b(tl settings) throws IOException {
        int i;
        try {
            Intrinsics.checkNotNullParameter(settings, "settings");
            if (!this.f13808fb) {
                mt(0, settings.c5() * 6, 4, 0);
                for (int i5 = 0; i5 < 10; i5++) {
                    if (settings.a(i5)) {
                        if (i5 != 4) {
                            if (i5 != 7) {
                                i = i5;
                            } else {
                                i = 4;
                            }
                        } else {
                            i = 3;
                        }
                        this.f13807f.writeShort(i);
                        this.f13807f.writeInt(settings.y(i5));
                    }
                }
                this.f13807f.flush();
            } else {
                throw new IOException("closed");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.f13808fb = true;
        this.f13807f.close();
    }

    public final synchronized void co(int i, n3 errorCode, byte[] debugData) throws IOException {
        boolean z2;
        try {
            Intrinsics.checkNotNullParameter(errorCode, "errorCode");
            Intrinsics.checkNotNullParameter(debugData, "debugData");
            if (!this.f13808fb) {
                boolean z3 = true;
                if (errorCode.y() != -1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    mt(0, debugData.length + 8, 7, 0);
                    this.f13807f.writeInt(i);
                    this.f13807f.writeInt(errorCode.y());
                    if (debugData.length != 0) {
                        z3 = false;
                    }
                    if (!z3) {
                        this.f13807f.write(debugData);
                    }
                    this.f13807f.flush();
                } else {
                    throw new IllegalArgumentException("errorCode.httpCode == -1");
                }
            } else {
                throw new IOException("closed");
            }
        } finally {
        }
    }

    public final synchronized void d(int i, int i5, List<zn> requestHeaders) throws IOException {
        int i6;
        Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
        if (!this.f13808fb) {
            this.f13809s.fb(requestHeaders);
            long m2 = this.y.m();
            int min = (int) Math.min(this.f13811v - 4, m2);
            int i8 = min + 4;
            long j2 = min;
            int i10 = (m2 > j2 ? 1 : (m2 == j2 ? 0 : -1));
            if (i10 == 0) {
                i6 = 4;
            } else {
                i6 = 0;
            }
            mt(i, i8, 5, i6);
            this.f13807f.writeInt(i5 & Integer.MAX_VALUE);
            this.f13807f.write(this.y, j2);
            if (i10 > 0) {
                yt(i, m2 - j2);
            }
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void flush() throws IOException {
        if (!this.f13808fb) {
            this.f13807f.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void k5(int i, long j2) throws IOException {
        boolean z2;
        if (!this.f13808fb) {
            if (j2 != 0 && j2 <= 2147483647L) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                mt(i, 4, 8, 0);
                this.f13807f.writeInt((int) j2);
                this.f13807f.flush();
            } else {
                throw new IllegalArgumentException(("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: " + j2).toString());
            }
        } else {
            throw new IOException("closed");
        }
    }

    public final void mt(int i, int i5, int i6, int i8) throws IOException {
        boolean z2;
        Logger logger = f13806w;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(v.f13842v.zn(false, i, i5, i6, i8));
        }
        boolean z3 = false;
        if (i5 <= this.f13811v) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            if ((((int) 2147483648L) & i) == 0) {
                z3 = true;
            }
            if (z3) {
                lc1.n3.k(this.f13807f, i5);
                this.f13807f.writeByte(i6 & 255);
                this.f13807f.writeByte(i8 & 255);
                this.f13807f.writeInt(i & Integer.MAX_VALUE);
                return;
            }
            throw new IllegalArgumentException(("reserved bit set: " + i).toString());
        }
        throw new IllegalArgumentException(("FRAME_SIZE_ERROR length > " + this.f13811v + ": " + i5).toString());
    }

    public final void p(int i, int i5, zc1.v vVar, int i6) throws IOException {
        mt(i, i6, 0, i5);
        if (i6 > 0) {
            zc1.a aVar = this.f13807f;
            Intrinsics.checkNotNull(vVar);
            aVar.write(vVar, i6);
        }
    }

    public final synchronized void r(boolean z2, int i, List<zn> headerBlock) throws IOException {
        int i5;
        Intrinsics.checkNotNullParameter(headerBlock, "headerBlock");
        if (!this.f13808fb) {
            this.f13809s.fb(headerBlock);
            long m2 = this.y.m();
            long min = Math.min(this.f13811v, m2);
            int i6 = (m2 > min ? 1 : (m2 == min ? 0 : -1));
            if (i6 == 0) {
                i5 = 4;
            } else {
                i5 = 0;
            }
            if (z2) {
                i5 |= 1;
            }
            mt(i, (int) min, 1, i5);
            this.f13807f.write(this.y, min);
            if (i6 > 0) {
                yt(i, m2 - min);
            }
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void s(boolean z2, int i, zc1.v vVar, int i5) throws IOException {
        if (!this.f13808fb) {
            p(i, z2 ? 1 : 0, vVar, i5);
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void ta(boolean z2, int i, int i5) throws IOException {
        if (!this.f13808fb) {
            mt(0, 8, 6, z2 ? 1 : 0);
            this.f13807f.writeInt(i);
            this.f13807f.writeInt(i5);
            this.f13807f.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void ud(int i, n3 errorCode) throws IOException {
        boolean z2;
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        if (!this.f13808fb) {
            if (errorCode.y() != -1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                mt(i, 4, 3, 0);
                this.f13807f.writeInt(errorCode.y());
                this.f13807f.flush();
            } else {
                throw new IllegalArgumentException("Failed requirement.");
            }
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void v() throws IOException {
        try {
            if (!this.f13808fb) {
                if (!this.f13810t) {
                    return;
                }
                Logger logger = f13806w;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(lc1.n3.p(">> CONNECTION " + v.y.r(), new Object[0]));
                }
                this.f13807f.x(v.y);
                this.f13807f.flush();
                return;
            }
            throw new IOException("closed");
        } catch (Throwable th) {
            throw th;
        }
    }

    public final int x4() {
        return this.f13811v;
    }

    public final synchronized void y(tl peerSettings) throws IOException {
        try {
            Intrinsics.checkNotNullParameter(peerSettings, "peerSettings");
            if (!this.f13808fb) {
                this.f13811v = peerSettings.v(this.f13811v);
                if (peerSettings.n3() != -1) {
                    this.f13809s.v(peerSettings.n3());
                }
                mt(0, 0, 4, 1);
                this.f13807f.flush();
            } else {
                throw new IOException("closed");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void yt(int i, long j2) throws IOException {
        int i5;
        while (j2 > 0) {
            long min = Math.min(this.f13811v, j2);
            j2 -= min;
            int i6 = (int) min;
            if (j2 == 0) {
                i5 = 4;
            } else {
                i5 = 0;
            }
            mt(i, i6, 9, i5);
            this.f13807f.write(this.y, min);
        }
    }
}
