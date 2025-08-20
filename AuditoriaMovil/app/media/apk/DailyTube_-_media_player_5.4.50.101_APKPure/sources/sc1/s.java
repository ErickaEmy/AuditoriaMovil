package sc1;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import sc1.gv;
import zc1.d;
import zc1.ta;
/* loaded from: classes.dex */
public final class s implements Closeable {

    /* renamed from: f  reason: collision with root package name */
    public static final Logger f13827f;

    /* renamed from: t  reason: collision with root package name */
    public static final y f13828t = new y(null);

    /* renamed from: fb  reason: collision with root package name */
    public final zc1.fb f13829fb;

    /* renamed from: s  reason: collision with root package name */
    public final boolean f13830s;

    /* renamed from: v  reason: collision with root package name */
    public final gv.y f13831v;
    public final n3 y;

    /* loaded from: classes.dex */
    public static final class y {
        public y() {
        }

        public final int n3(int i, int i5, int i6) throws IOException {
            if ((i5 & 8) != 0) {
                i--;
            }
            if (i6 <= i) {
                return i - i6;
            }
            throw new IOException("PROTOCOL_ERROR padding " + i6 + " > remaining length " + i);
        }

        public final Logger y() {
            return s.f13827f;
        }

        public /* synthetic */ y(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public interface zn {
        void a();

        void c5(int i, sc1.n3 n3Var, zc1.s sVar);

        void fb(boolean z2, int i, int i5);

        void gv(int i, int i5, List<sc1.zn> list) throws IOException;

        void i9(int i, sc1.n3 n3Var);

        void n3(boolean z2, int i, int i5, List<sc1.zn> list);

        void s(int i, int i5, int i6, boolean z2);

        void v(boolean z2, int i, zc1.fb fbVar, int i5) throws IOException;

        void y(boolean z2, tl tlVar);

        void zn(int i, long j2);
    }

    static {
        Logger logger = Logger.getLogger(v.class.getName());
        Intrinsics.checkNotNullExpressionValue(logger, "Logger.getLogger(Http2::class.java.name)");
        f13827f = logger;
    }

    public s(zc1.fb source, boolean z2) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.f13829fb = source;
        this.f13830s = z2;
        n3 n3Var = new n3(source);
        this.y = n3Var;
        this.f13831v = new gv.y(n3Var, 4096, 0, 4, null);
    }

    public final void b(zn znVar, int i, int i5, int i6) throws IOException {
        if (i == 4) {
            if (i6 != 0) {
                int readInt = this.f13829fb.readInt();
                sc1.n3 y2 = sc1.n3.f13818fh.y(readInt);
                if (y2 != null) {
                    znVar.i9(i6, y2);
                    return;
                }
                throw new IOException("TYPE_RST_STREAM unexpected error code: " + readInt);
            }
            throw new IOException("TYPE_RST_STREAM streamId == 0");
        }
        throw new IOException("TYPE_RST_STREAM length: " + i + " != 4");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f13829fb.close();
    }

    public final List<sc1.zn> co(int i, int i5, int i6, int i8) throws IOException {
        this.y.p(i);
        n3 n3Var = this.y;
        n3Var.mt(n3Var.y());
        this.y.co(i5);
        this.y.s(i6);
        this.y.r(i8);
        this.f13831v.f();
        return this.f13831v.v();
    }

    public final void d(zn znVar, int i, int i5, int i6) throws IOException {
        if (i == 5) {
            if (i6 != 0) {
                ta(znVar, i6);
                return;
            }
            throw new IOException("TYPE_PRIORITY streamId == 0");
        }
        throw new IOException("TYPE_PRIORITY length: " + i + " != 5");
    }

    public final void k5(zn znVar, int i, int i5, int i6) throws IOException {
        int readInt;
        if (i6 == 0) {
            if ((i5 & 1) != 0) {
                if (i == 0) {
                    znVar.a();
                    return;
                }
                throw new IOException("FRAME_SIZE_ERROR ack frame should be empty!");
            } else if (i % 6 == 0) {
                tl tlVar = new tl();
                IntProgression step = RangesKt.step(RangesKt.until(0, i), 6);
                int first = step.getFirst();
                int last = step.getLast();
                int step2 = step.getStep();
                if (step2 < 0 ? first >= last : first <= last) {
                    while (true) {
                        int zn2 = lc1.n3.zn(this.f13829fb.readShort(), 65535);
                        readInt = this.f13829fb.readInt();
                        if (zn2 != 2) {
                            if (zn2 != 3) {
                                if (zn2 != 4) {
                                    if (zn2 == 5 && (readInt < 16384 || readInt > 16777215)) {
                                        break;
                                    }
                                } else if (readInt >= 0) {
                                    zn2 = 7;
                                } else {
                                    throw new IOException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1");
                                }
                            } else {
                                zn2 = 4;
                            }
                        } else if (readInt != 0 && readInt != 1) {
                            throw new IOException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1");
                        }
                        tlVar.s(zn2, readInt);
                        if (first == last) {
                            break;
                        }
                        first += step2;
                    }
                    throw new IOException("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: " + readInt);
                }
                znVar.y(false, tlVar);
                return;
            } else {
                throw new IOException("TYPE_SETTINGS length % 6 != 0: " + i);
            }
        }
        throw new IOException("TYPE_SETTINGS streamId != 0");
    }

    public final void mt(zn znVar, int i, int i5, int i6) throws IOException {
        if (i >= 8) {
            if (i6 == 0) {
                int readInt = this.f13829fb.readInt();
                int readInt2 = this.f13829fb.readInt();
                int i8 = i - 8;
                sc1.n3 y2 = sc1.n3.f13818fh.y(readInt2);
                if (y2 != null) {
                    zc1.s sVar = zc1.s.s;
                    if (i8 > 0) {
                        sVar = this.f13829fb.y5(i8);
                    }
                    znVar.c5(readInt, y2, sVar);
                    return;
                }
                throw new IOException("TYPE_GOAWAY unexpected error code: " + readInt2);
            }
            throw new IOException("TYPE_GOAWAY streamId != 0");
        }
        throw new IOException("TYPE_GOAWAY length < 8: " + i);
    }

    public final void p(zn znVar, int i, int i5, int i6) throws IOException {
        boolean z2;
        if (i6 != 0) {
            int i8 = 0;
            if ((i5 & 1) != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if ((i5 & 32) == 0) {
                if ((i5 & 8) != 0) {
                    i8 = lc1.n3.n3(this.f13829fb.readByte(), 255);
                }
                znVar.v(z2, i6, this.f13829fb, f13828t.n3(i, i5, i8));
                this.f13829fb.skip(i8);
                return;
            }
            throw new IOException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA");
        }
        throw new IOException("PROTOCOL_ERROR: TYPE_DATA streamId == 0");
    }

    public final void r(zn znVar, int i, int i5, int i6) throws IOException {
        boolean z2;
        if (i6 != 0) {
            int i8 = 0;
            if ((i5 & 1) != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if ((i5 & 8) != 0) {
                i8 = lc1.n3.n3(this.f13829fb.readByte(), 255);
            }
            if ((i5 & 32) != 0) {
                ta(znVar, i6);
                i -= 5;
            }
            znVar.n3(z2, i6, -1, co(f13828t.n3(i, i5, i8), i8, i5, i6));
            return;
        }
        throw new IOException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0");
    }

    public final void s(zn handler) throws IOException {
        Intrinsics.checkNotNullParameter(handler, "handler");
        if (this.f13830s) {
            if (!v(true, handler)) {
                throw new IOException("Required SETTINGS preface not received");
            }
            return;
        }
        zc1.fb fbVar = this.f13829fb;
        zc1.s sVar = v.y;
        zc1.s y52 = fbVar.y5(sVar.j());
        Logger logger = f13827f;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(lc1.n3.p("<< CONNECTION " + y52.r(), new Object[0]));
        }
        if (Intrinsics.areEqual(sVar, y52)) {
            return;
        }
        throw new IOException("Expected a connection header but was " + y52.dm());
    }

    public final void ta(zn znVar, int i) throws IOException {
        boolean z2;
        int readInt = this.f13829fb.readInt();
        if ((readInt & ((int) 2147483648L)) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        znVar.s(i, readInt & Integer.MAX_VALUE, lc1.n3.n3(this.f13829fb.readByte(), 255) + 1, z2);
    }

    public final void ud(zn znVar, int i, int i5, int i6) throws IOException {
        int i8;
        if (i6 != 0) {
            if ((i5 & 8) != 0) {
                i8 = lc1.n3.n3(this.f13829fb.readByte(), 255);
            } else {
                i8 = 0;
            }
            znVar.gv(i6, this.f13829fb.readInt() & Integer.MAX_VALUE, co(f13828t.n3(i - 4, i5, i8), i8, i5, i6));
            return;
        }
        throw new IOException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0");
    }

    public final boolean v(boolean z2, zn handler) throws IOException {
        Intrinsics.checkNotNullParameter(handler, "handler");
        try {
            this.f13829fb.q9(9L);
            int ud2 = lc1.n3.ud(this.f13829fb);
            if (ud2 <= 16384) {
                int n32 = lc1.n3.n3(this.f13829fb.readByte(), 255);
                int n33 = lc1.n3.n3(this.f13829fb.readByte(), 255);
                int readInt = this.f13829fb.readInt() & Integer.MAX_VALUE;
                Logger logger = f13827f;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(v.f13842v.zn(true, readInt, ud2, n32, n33));
                }
                if (z2 && n32 != 4) {
                    throw new IOException("Expected a SETTINGS frame but was " + v.f13842v.n3(n32));
                }
                switch (n32) {
                    case 0:
                        p(handler, ud2, n33, readInt);
                        return true;
                    case 1:
                        r(handler, ud2, n33, readInt);
                        return true;
                    case 2:
                        d(handler, ud2, n33, readInt);
                        return true;
                    case 3:
                        b(handler, ud2, n33, readInt);
                        return true;
                    case 4:
                        k5(handler, ud2, n33, readInt);
                        return true;
                    case 5:
                        ud(handler, ud2, n33, readInt);
                        return true;
                    case 6:
                        x4(handler, ud2, n33, readInt);
                        return true;
                    case 7:
                        mt(handler, ud2, n33, readInt);
                        return true;
                    case 8:
                        yt(handler, ud2, n33, readInt);
                        return true;
                    default:
                        this.f13829fb.skip(ud2);
                        return true;
                }
            }
            throw new IOException("FRAME_SIZE_ERROR: " + ud2);
        } catch (EOFException unused) {
            return false;
        }
    }

    public final void x4(zn znVar, int i, int i5, int i6) throws IOException {
        if (i == 8) {
            if (i6 == 0) {
                int readInt = this.f13829fb.readInt();
                int readInt2 = this.f13829fb.readInt();
                boolean z2 = true;
                if ((i5 & 1) == 0) {
                    z2 = false;
                }
                znVar.fb(z2, readInt, readInt2);
                return;
            }
            throw new IOException("TYPE_PING streamId != 0");
        }
        throw new IOException("TYPE_PING length != 8: " + i);
    }

    public final void yt(zn znVar, int i, int i5, int i6) throws IOException {
        if (i == 4) {
            long gv2 = lc1.n3.gv(this.f13829fb.readInt(), 2147483647L);
            if (gv2 != 0) {
                znVar.zn(i6, gv2);
                return;
            }
            throw new IOException("windowSizeIncrement was 0");
        }
        throw new IOException("TYPE_WINDOW_UPDATE length !=4: " + i);
    }

    /* loaded from: classes.dex */
    public static final class n3 implements ta {

        /* renamed from: f  reason: collision with root package name */
        public int f13832f;

        /* renamed from: fb  reason: collision with root package name */
        public int f13833fb;

        /* renamed from: s  reason: collision with root package name */
        public int f13834s;

        /* renamed from: t  reason: collision with root package name */
        public final zc1.fb f13835t;

        /* renamed from: v  reason: collision with root package name */
        public int f13836v;
        public int y;

        public n3(zc1.fb source) {
            Intrinsics.checkNotNullParameter(source, "source");
            this.f13835t = source;
        }

        public final void co(int i) {
            this.f13832f = i;
        }

        public final void mt(int i) {
            this.y = i;
        }

        public final void p(int i) {
            this.f13834s = i;
        }

        public final void r(int i) {
            this.f13833fb = i;
        }

        public long read(zc1.v sink, long j2) throws IOException {
            Intrinsics.checkNotNullParameter(sink, "sink");
            while (true) {
                int i = this.f13834s;
                if (i == 0) {
                    this.f13835t.skip(this.f13832f);
                    this.f13832f = 0;
                    if ((this.f13836v & 4) != 0) {
                        return -1L;
                    }
                    v();
                } else {
                    long read = this.f13835t.read(sink, Math.min(j2, i));
                    if (read == -1) {
                        return -1L;
                    }
                    this.f13834s -= (int) read;
                    return read;
                }
            }
        }

        public final void s(int i) {
            this.f13836v = i;
        }

        public d timeout() {
            return this.f13835t.timeout();
        }

        public final void v() throws IOException {
            int i = this.f13833fb;
            int ud2 = lc1.n3.ud(this.f13835t);
            this.f13834s = ud2;
            this.y = ud2;
            int n32 = lc1.n3.n3(this.f13835t.readByte(), 255);
            this.f13836v = lc1.n3.n3(this.f13835t.readByte(), 255);
            y yVar = s.f13828t;
            if (yVar.y().isLoggable(Level.FINE)) {
                yVar.y().fine(v.f13842v.zn(true, this.f13833fb, this.y, n32, this.f13836v));
            }
            int readInt = this.f13835t.readInt() & Integer.MAX_VALUE;
            this.f13833fb = readInt;
            if (n32 == 9) {
                if (readInt == i) {
                    return;
                }
                throw new IOException("TYPE_CONTINUATION streamId changed");
            }
            throw new IOException(n32 + " != TYPE_CONTINUATION");
        }

        public final int y() {
            return this.f13834s;
        }

        public void close() throws IOException {
        }
    }
}
