package sc1;

import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import sc1.s;
/* loaded from: classes.dex */
public final class a implements Closeable {

    /* renamed from: en */
    public static final zn f13645en = new zn(null);

    /* renamed from: f7 */
    public static final tl f13646f7;

    /* renamed from: b */
    public tl f13647b;

    /* renamed from: c */
    public long f13648c;

    /* renamed from: co */
    public final oc1.gv f13649co;

    /* renamed from: d */
    public long f13650d;

    /* renamed from: d0 */
    public long f13651d0;

    /* renamed from: ej */
    public long f13652ej;

    /* renamed from: f */
    public int f13653f;

    /* renamed from: f3 */
    public final sc1.t f13654f3;

    /* renamed from: fb */
    public final Map<Integer, sc1.c5> f13655fb;

    /* renamed from: fh */
    public long f13656fh;

    /* renamed from: j */
    public long f13657j;

    /* renamed from: j5 */
    public long f13658j5;

    /* renamed from: k */
    public final Set<Integer> f13659k;

    /* renamed from: n */
    public long f13660n;

    /* renamed from: o */
    public long f13661o;

    /* renamed from: oz */
    public final Socket f13662oz;

    /* renamed from: p */
    public final oc1.v f13663p;

    /* renamed from: q9 */
    public final v f13664q9;

    /* renamed from: qn */
    public long f13665qn;

    /* renamed from: r */
    public final oc1.gv f13666r;

    /* renamed from: s */
    public final String f13667s;

    /* renamed from: t */
    public int f13668t;

    /* renamed from: ut */
    public final sc1.i9 f13669ut;

    /* renamed from: v */
    public final gv f13670v;

    /* renamed from: w */
    public boolean f13671w;

    /* renamed from: x */
    public final tl f13672x;
    public final boolean y;

    /* renamed from: z */
    public final oc1.gv f13673z;

    /* renamed from: sc1.a$a */
    /* loaded from: classes.dex */
    public static final class C0215a extends oc1.y {

        /* renamed from: a */
        public final /* synthetic */ boolean f13674a;

        /* renamed from: c5 */
        public final /* synthetic */ zc1.v f13675c5;

        /* renamed from: f */
        public final /* synthetic */ boolean f13676f;

        /* renamed from: fb */
        public final /* synthetic */ a f13677fb;

        /* renamed from: i9 */
        public final /* synthetic */ int f13678i9;

        /* renamed from: s */
        public final /* synthetic */ int f13679s;

        /* renamed from: v */
        public final /* synthetic */ String f13680v;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0215a(String str, boolean z2, String str2, boolean z3, a aVar, int i, zc1.v vVar, int i5, boolean z4) {
            super(str2, z3);
            this.f13680v = str;
            this.f13674a = z2;
            this.f13677fb = aVar;
            this.f13679s = i;
            this.f13675c5 = vVar;
            this.f13678i9 = i5;
            this.f13676f = z4;
        }

        @Override // oc1.y
        public long a() {
            try {
                boolean y = this.f13677fb.f13654f3.y(this.f13679s, this.f13675c5, this.f13678i9, this.f13676f);
                if (y) {
                    this.f13677fb.vp().ud(this.f13679s, sc1.n3.CANCEL);
                }
                if (y || this.f13676f) {
                    synchronized (this.f13677fb) {
                        this.f13677fb.f13659k.remove(Integer.valueOf(this.f13679s));
                    }
                    return -1L;
                }
                return -1L;
            } catch (IOException unused) {
                return -1L;
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class c5 extends oc1.y {

        /* renamed from: a */
        public final /* synthetic */ boolean f13681a;

        /* renamed from: c5 */
        public final /* synthetic */ sc1.n3 f13682c5;

        /* renamed from: fb */
        public final /* synthetic */ a f13683fb;

        /* renamed from: s */
        public final /* synthetic */ int f13684s;

        /* renamed from: v */
        public final /* synthetic */ String f13685v;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c5(String str, boolean z2, String str2, boolean z3, a aVar, int i, sc1.n3 n3Var) {
            super(str2, z3);
            this.f13685v = str;
            this.f13681a = z2;
            this.f13683fb = aVar;
            this.f13684s = i;
            this.f13682c5 = n3Var;
        }

        @Override // oc1.y
        public long a() {
            this.f13683fb.f13654f3.n3(this.f13684s, this.f13682c5);
            synchronized (this.f13683fb) {
                this.f13683fb.f13659k.remove(Integer.valueOf(this.f13684s));
                Unit unit = Unit.INSTANCE;
            }
            return -1L;
        }
    }

    /* loaded from: classes.dex */
    public static final class f extends oc1.y {

        /* renamed from: a */
        public final /* synthetic */ boolean f13686a;

        /* renamed from: c5 */
        public final /* synthetic */ sc1.n3 f13687c5;

        /* renamed from: fb */
        public final /* synthetic */ a f13688fb;

        /* renamed from: s */
        public final /* synthetic */ int f13689s;

        /* renamed from: v */
        public final /* synthetic */ String f13690v;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(String str, boolean z2, String str2, boolean z3, a aVar, int i, sc1.n3 n3Var) {
            super(str2, z3);
            this.f13690v = str;
            this.f13686a = z2;
            this.f13688fb = aVar;
            this.f13689s = i;
            this.f13687c5 = n3Var;
        }

        @Override // oc1.y
        public long a() {
            try {
                this.f13688fb.im(this.f13689s, this.f13687c5);
                return -1L;
            } catch (IOException e2) {
                this.f13688fb.o4(e2);
                return -1L;
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class fb extends oc1.y {

        /* renamed from: a */
        public final /* synthetic */ boolean f13691a;

        /* renamed from: c5 */
        public final /* synthetic */ List f13692c5;

        /* renamed from: fb */
        public final /* synthetic */ a f13693fb;

        /* renamed from: i9 */
        public final /* synthetic */ boolean f13694i9;

        /* renamed from: s */
        public final /* synthetic */ int f13695s;

        /* renamed from: v */
        public final /* synthetic */ String f13696v;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public fb(String str, boolean z2, String str2, boolean z3, a aVar, int i, List list, boolean z4) {
            super(str2, z3);
            this.f13696v = str;
            this.f13691a = z2;
            this.f13693fb = aVar;
            this.f13695s = i;
            this.f13692c5 = list;
            this.f13694i9 = z4;
        }

        @Override // oc1.y
        public long a() {
            boolean gv2 = this.f13693fb.f13654f3.gv(this.f13695s, this.f13692c5, this.f13694i9);
            if (gv2) {
                try {
                    this.f13693fb.vp().ud(this.f13695s, sc1.n3.CANCEL);
                } catch (IOException unused) {
                    return -1L;
                }
            }
            if (gv2 || this.f13694i9) {
                synchronized (this.f13693fb) {
                    this.f13693fb.f13659k.remove(Integer.valueOf(this.f13695s));
                }
                return -1L;
            }
            return -1L;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class gv {

        /* renamed from: n3 */
        public static final n3 f13697n3 = new n3(null);
        public static final gv y = new y();

        /* loaded from: classes.dex */
        public static final class n3 {
            public n3() {
            }

            public /* synthetic */ n3(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* loaded from: classes.dex */
        public static final class y extends gv {
            @Override // sc1.a.gv
            public void v(sc1.c5 stream) throws IOException {
                Intrinsics.checkNotNullParameter(stream, "stream");
                stream.gv(sc1.n3.REFUSED_STREAM, null);
            }
        }

        public void gv(a connection, tl settings) {
            Intrinsics.checkNotNullParameter(connection, "connection");
            Intrinsics.checkNotNullParameter(settings, "settings");
        }

        public abstract void v(sc1.c5 c5Var) throws IOException;
    }

    /* loaded from: classes.dex */
    public static final class i9 extends oc1.y {

        /* renamed from: a */
        public final /* synthetic */ boolean f13698a;

        /* renamed from: fb */
        public final /* synthetic */ a f13699fb;

        /* renamed from: v */
        public final /* synthetic */ String f13700v;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i9(String str, boolean z2, String str2, boolean z3, a aVar) {
            super(str2, z3);
            this.f13700v = str;
            this.f13698a = z2;
            this.f13699fb = aVar;
        }

        @Override // oc1.y
        public long a() {
            this.f13699fb.uo(false, 2, 0);
            return -1L;
        }
    }

    /* loaded from: classes.dex */
    public static final class n3 {

        /* renamed from: a */
        public sc1.t f13701a;

        /* renamed from: c5 */
        public final oc1.v f13702c5;

        /* renamed from: fb */
        public int f13703fb;

        /* renamed from: gv */
        public zc1.a f13704gv;

        /* renamed from: n3 */
        public String f13705n3;

        /* renamed from: s */
        public boolean f13706s;

        /* renamed from: v */
        public gv f13707v;
        public Socket y;

        /* renamed from: zn */
        public zc1.fb f13708zn;

        public n3(boolean z2, oc1.v taskRunner) {
            Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
            this.f13706s = z2;
            this.f13702c5 = taskRunner;
            this.f13707v = gv.y;
            this.f13701a = sc1.t.y;
        }

        public final sc1.t a() {
            return this.f13701a;
        }

        public final zc1.fb c5() {
            zc1.fb fbVar = this.f13708zn;
            if (fbVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("source");
            }
            return fbVar;
        }

        public final n3 f(gv listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.f13707v = listener;
            return this;
        }

        public final zc1.a fb() {
            zc1.a aVar = this.f13704gv;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sink");
            }
            return aVar;
        }

        public final gv gv() {
            return this.f13707v;
        }

        public final oc1.v i9() {
            return this.f13702c5;
        }

        public final boolean n3() {
            return this.f13706s;
        }

        public final Socket s() {
            Socket socket = this.y;
            if (socket == null) {
                Intrinsics.throwUninitializedPropertyAccessException("socket");
            }
            return socket;
        }

        public final n3 t(int i) {
            this.f13703fb = i;
            return this;
        }

        public final n3 tl(Socket socket, String peerName, zc1.fb source, zc1.a sink) throws IOException {
            String str;
            Intrinsics.checkNotNullParameter(socket, "socket");
            Intrinsics.checkNotNullParameter(peerName, "peerName");
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(sink, "sink");
            this.y = socket;
            if (this.f13706s) {
                str = lc1.n3.f10302c5 + ' ' + peerName;
            } else {
                str = "MockWebServer " + peerName;
            }
            this.f13705n3 = str;
            this.f13708zn = source;
            this.f13704gv = sink;
            return this;
        }

        public final int v() {
            return this.f13703fb;
        }

        public final a y() {
            return new a(this);
        }

        public final String zn() {
            String str = this.f13705n3;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("connectionName");
            }
            return str;
        }
    }

    /* loaded from: classes.dex */
    public static final class s extends oc1.y {

        /* renamed from: a */
        public final /* synthetic */ boolean f13709a;

        /* renamed from: c5 */
        public final /* synthetic */ List f13710c5;

        /* renamed from: fb */
        public final /* synthetic */ a f13711fb;

        /* renamed from: s */
        public final /* synthetic */ int f13712s;

        /* renamed from: v */
        public final /* synthetic */ String f13713v;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public s(String str, boolean z2, String str2, boolean z3, a aVar, int i, List list) {
            super(str2, z3);
            this.f13713v = str;
            this.f13709a = z2;
            this.f13711fb = aVar;
            this.f13712s = i;
            this.f13710c5 = list;
        }

        @Override // oc1.y
        public long a() {
            if (this.f13711fb.f13654f3.zn(this.f13712s, this.f13710c5)) {
                try {
                    this.f13711fb.vp().ud(this.f13712s, sc1.n3.CANCEL);
                    synchronized (this.f13711fb) {
                        this.f13711fb.f13659k.remove(Integer.valueOf(this.f13712s));
                    }
                    return -1L;
                } catch (IOException unused) {
                    return -1L;
                }
            }
            return -1L;
        }
    }

    /* loaded from: classes.dex */
    public static final class t extends oc1.y {

        /* renamed from: a */
        public final /* synthetic */ boolean f13714a;

        /* renamed from: c5 */
        public final /* synthetic */ long f13715c5;

        /* renamed from: fb */
        public final /* synthetic */ a f13716fb;

        /* renamed from: s */
        public final /* synthetic */ int f13717s;

        /* renamed from: v */
        public final /* synthetic */ String f13718v;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(String str, boolean z2, String str2, boolean z3, a aVar, int i, long j2) {
            super(str2, z3);
            this.f13718v = str;
            this.f13714a = z2;
            this.f13716fb = aVar;
            this.f13717s = i;
            this.f13715c5 = j2;
        }

        @Override // oc1.y
        public long a() {
            try {
                this.f13716fb.vp().k5(this.f13717s, this.f13715c5);
                return -1L;
            } catch (IOException e2) {
                this.f13716fb.o4(e2);
                return -1L;
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class y extends oc1.y {

        /* renamed from: a */
        public final /* synthetic */ a f13746a;

        /* renamed from: fb */
        public final /* synthetic */ long f13747fb;

        /* renamed from: v */
        public final /* synthetic */ String f13748v;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public y(String str, String str2, a aVar, long j2) {
            super(str2, false, 2, null);
            this.f13748v = str;
            this.f13746a = aVar;
            this.f13747fb = j2;
        }

        @Override // oc1.y
        public long a() {
            boolean z2;
            synchronized (this.f13746a) {
                if (this.f13746a.f13648c < this.f13746a.f13660n) {
                    z2 = true;
                } else {
                    this.f13746a.f13660n++;
                    z2 = false;
                }
            }
            if (z2) {
                this.f13746a.o4(null);
                return -1L;
            }
            this.f13746a.uo(false, 1, 0);
            return this.f13747fb;
        }
    }

    /* loaded from: classes.dex */
    public static final class zn {
        public zn() {
        }

        public final tl y() {
            return a.f13646f7;
        }

        public /* synthetic */ zn(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        tl tlVar = new tl();
        tlVar.s(7, 65535);
        tlVar.s(5, 16384);
        f13646f7 = tlVar;
    }

    public a(n3 builder) {
        int i;
        tl tlVar;
        Intrinsics.checkNotNullParameter(builder, "builder");
        boolean n32 = builder.n3();
        this.y = n32;
        this.f13670v = builder.gv();
        this.f13655fb = new LinkedHashMap();
        String zn2 = builder.zn();
        this.f13667s = zn2;
        if (builder.n3()) {
            i = 3;
        } else {
            i = 2;
        }
        this.f13668t = i;
        oc1.v i92 = builder.i9();
        this.f13663p = i92;
        oc1.gv c52 = i92.c5();
        this.f13649co = c52;
        this.f13673z = i92.c5();
        this.f13666r = i92.c5();
        this.f13654f3 = builder.a();
        tl tlVar2 = new tl();
        if (builder.n3()) {
            tlVar2.s(7, 16777216);
        }
        Unit unit = Unit.INSTANCE;
        this.f13672x = tlVar2;
        this.f13647b = f13646f7;
        this.f13657j = tlVar.zn();
        this.f13662oz = builder.s();
        this.f13669ut = new sc1.i9(builder.fb(), n32);
        this.f13664q9 = new v(this, new sc1.s(builder.c5(), n32));
        this.f13659k = new LinkedHashSet();
        if (builder.v() != 0) {
            long nanos = TimeUnit.MILLISECONDS.toNanos(builder.v());
            String str = zn2 + " ping";
            c52.c5(new y(str, str, this, nanos), nanos);
        }
    }

    public static /* synthetic */ void gf(a aVar, boolean z2, oc1.v vVar, int i, Object obj) throws IOException {
        if ((i & 1) != 0) {
            z2 = true;
        }
        if ((i & 2) != 0) {
            vVar = oc1.v.f12249s;
        }
        aVar.nd(z2, vVar);
    }

    public final tl ad() {
        return this.f13672x;
    }

    public final boolean ap() {
        return this.y;
    }

    public final void br(int i, boolean z2, List<sc1.zn> alternating) throws IOException {
        Intrinsics.checkNotNullParameter(alternating, "alternating");
        this.f13669ut.r(z2, i, alternating);
    }

    public final synchronized void bv(long j2) {
        long j4 = this.f13658j5 + j2;
        this.f13658j5 = j4;
        long j6 = j4 - this.f13665qn;
        if (j6 >= this.f13672x.zn() / 2) {
            n7(0, j6);
            this.f13665qn += j6;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ct(sc1.n3.NO_ERROR, sc1.n3.CANCEL, null);
    }

    public final sc1.c5 cs(List<sc1.zn> requestHeaders, boolean z2) throws IOException {
        Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
        return x5(0, requestHeaders, z2);
    }

    public final void ct(sc1.n3 connectionCode, sc1.n3 streamCode, IOException iOException) {
        int i;
        sc1.c5[] c5VarArr;
        Intrinsics.checkNotNullParameter(connectionCode, "connectionCode");
        Intrinsics.checkNotNullParameter(streamCode, "streamCode");
        if (lc1.n3.f10306s && Thread.holdsLock(this)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread currentThread = Thread.currentThread();
            Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
            sb.append(currentThread.getName());
            sb.append(" MUST NOT hold lock on ");
            sb.append(this);
            throw new AssertionError(sb.toString());
        }
        try {
            wm(connectionCode);
        } catch (IOException unused) {
        }
        synchronized (this) {
            try {
                if (!this.f13655fb.isEmpty()) {
                    Object[] array = this.f13655fb.values().toArray(new sc1.c5[0]);
                    if (array != null) {
                        c5VarArr = (sc1.c5[]) array;
                        this.f13655fb.clear();
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                } else {
                    c5VarArr = null;
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (c5VarArr != null) {
            for (sc1.c5 c5Var : c5VarArr) {
                try {
                    c5Var.gv(streamCode, iOException);
                } catch (IOException unused2) {
                }
            }
        }
        try {
            this.f13669ut.close();
        } catch (IOException unused3) {
        }
        try {
            this.f13662oz.close();
        } catch (IOException unused4) {
        }
        this.f13649co.wz();
        this.f13673z.wz();
        this.f13666r.wz();
    }

    public final tl cy() {
        return this.f13647b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x0033, code lost:
        throw new java.io.IOException("stream closed");
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0035, code lost:
        r3 = java.lang.Math.min((int) java.lang.Math.min(r12, r5 - r3), r8.f13669ut.x4());
        r6 = r3;
        r8.f13661o += r6;
        r4 = kotlin.Unit.INSTANCE;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void fc(int r9, boolean r10, zc1.v r11, long r12) throws java.io.IOException {
        /*
            r8 = this;
            r0 = 0
            r1 = 0
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 != 0) goto Ld
            sc1.i9 r12 = r8.f13669ut
            r12.s(r10, r9, r11, r0)
            return
        Ld:
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 <= 0) goto L6c
            monitor-enter(r8)
        L12:
            long r3 = r8.f13661o     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L5d
            long r5 = r8.f13657j     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L5d
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 < 0) goto L34
            java.util.Map<java.lang.Integer, sc1.c5> r3 = r8.f13655fb     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L5d
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L5d
            boolean r3 = r3.containsKey(r4)     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L5d
            if (r3 == 0) goto L2c
            r8.wait()     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L5d
            goto L12
        L2a:
            r9 = move-exception
            goto L6a
        L2c:
            java.io.IOException r9 = new java.io.IOException     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L5d
            java.lang.String r10 = "stream closed"
            r9.<init>(r10)     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L5d
            throw r9     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L5d
        L34:
            long r5 = r5 - r3
            long r3 = java.lang.Math.min(r12, r5)     // Catch: java.lang.Throwable -> L2a
            int r4 = (int) r3     // Catch: java.lang.Throwable -> L2a
            sc1.i9 r3 = r8.f13669ut     // Catch: java.lang.Throwable -> L2a
            int r3 = r3.x4()     // Catch: java.lang.Throwable -> L2a
            int r3 = java.lang.Math.min(r4, r3)     // Catch: java.lang.Throwable -> L2a
            long r4 = r8.f13661o     // Catch: java.lang.Throwable -> L2a
            long r6 = (long) r3     // Catch: java.lang.Throwable -> L2a
            long r4 = r4 + r6
            r8.f13661o = r4     // Catch: java.lang.Throwable -> L2a
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L2a
            monitor-exit(r8)
            long r12 = r12 - r6
            sc1.i9 r4 = r8.f13669ut
            if (r10 == 0) goto L58
            int r5 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r5 != 0) goto L58
            r5 = 1
            goto L59
        L58:
            r5 = 0
        L59:
            r4.s(r5, r9, r11, r3)
            goto Ld
        L5d:
            java.lang.Thread r9 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> L2a
            r9.interrupt()     // Catch: java.lang.Throwable -> L2a
            java.io.InterruptedIOException r9 = new java.io.InterruptedIOException     // Catch: java.lang.Throwable -> L2a
            r9.<init>()     // Catch: java.lang.Throwable -> L2a
            throw r9     // Catch: java.lang.Throwable -> L2a
        L6a:
            monitor-exit(r8)
            throw r9
        L6c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: sc1.a.fc(int, boolean, zc1.v, long):void");
    }

    public final void flush() throws IOException {
        this.f13669ut.flush();
    }

    public final void i2(int i, sc1.n3 errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        String str = this.f13667s + '[' + i + "] onReset";
        this.f13673z.c5(new c5(str, true, str, true, this, i, errorCode), 0L);
    }

    public final boolean i3(int i) {
        if (i != 0 && (i & 1) == 0) {
            return true;
        }
        return false;
    }

    public final void im(int i, sc1.n3 statusCode) throws IOException {
        Intrinsics.checkNotNullParameter(statusCode, "statusCode");
        this.f13669ut.ud(i, statusCode);
    }

    public final void ix(int i, List<sc1.zn> requestHeaders, boolean z2) {
        Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
        String str = this.f13667s + '[' + i + "] onHeaders";
        this.f13673z.c5(new fb(str, true, str, true, this, i, requestHeaders, z2), 0L);
    }

    public final void j3() {
        synchronized (this) {
            long j2 = this.f13656fh;
            long j4 = this.f13651d0;
            if (j2 < j4) {
                return;
            }
            this.f13651d0 = j4 + 1;
            this.f13652ej = System.nanoTime() + 1000000000;
            Unit unit = Unit.INSTANCE;
            String str = this.f13667s + " ping";
            this.f13649co.c5(new i9(str, true, str, true, this), 0L);
        }
    }

    public final long l() {
        return this.f13657j;
    }

    public final int m() {
        return this.f13653f;
    }

    public final void mh(int i, sc1.n3 errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        String str = this.f13667s + '[' + i + "] writeSynReset";
        this.f13649co.c5(new f(str, true, str, true, this, i, errorCode), 0L);
    }

    public final void n7(int i, long j2) {
        String str = this.f13667s + '[' + i + "] windowUpdate";
        this.f13649co.c5(new t(str, true, str, true, this, i, j2), 0L);
    }

    public final void nd(boolean z2, oc1.v taskRunner) throws IOException {
        Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
        if (z2) {
            this.f13669ut.v();
            this.f13669ut.b(this.f13672x);
            int zn2 = this.f13672x.zn();
            if (zn2 != 65535) {
                this.f13669ut.k5(0, zn2 - 65535);
            }
        }
        oc1.gv c52 = taskRunner.c5();
        String str = this.f13667s;
        c52.c5(new oc1.zn(this.f13664q9, str, true, str, true), 0L);
    }

    public final void ne(int i) {
        this.f13653f = i;
    }

    public final int o0() {
        return this.f13668t;
    }

    public final void o4(IOException iOException) {
        sc1.n3 n3Var = sc1.n3.PROTOCOL_ERROR;
        ct(n3Var, n3Var, iOException);
    }

    public final gv pq() {
        return this.f13670v;
    }

    public final void q(tl tlVar) {
        Intrinsics.checkNotNullParameter(tlVar, "<set-?>");
        this.f13647b = tlVar;
    }

    public final Map<Integer, sc1.c5> qj() {
        return this.f13655fb;
    }

    public final synchronized sc1.c5 qk(int i) {
        return this.f13655fb.get(Integer.valueOf(i));
    }

    public final void ro(int i, zc1.fb source, int i5, boolean z2) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        zc1.v vVar = new zc1.v();
        long j2 = i5;
        source.q9(j2);
        source.read(vVar, j2);
        String str = this.f13667s + '[' + i + "] onData";
        this.f13673z.c5(new C0215a(str, true, str, true, this, i, vVar, i5, z2), 0L);
    }

    public final void uo(boolean z2, int i, int i5) {
        try {
            this.f13669ut.ta(z2, i, i5);
        } catch (IOException e2) {
            o4(e2);
        }
    }

    public final synchronized sc1.c5 vn(int i) {
        sc1.c5 remove;
        remove = this.f13655fb.remove(Integer.valueOf(i));
        notifyAll();
        return remove;
    }

    public final sc1.i9 vp() {
        return this.f13669ut;
    }

    public final synchronized boolean w2(long j2) {
        if (this.f13671w) {
            return false;
        }
        if (this.f13656fh < this.f13651d0) {
            if (j2 >= this.f13652ej) {
                return false;
            }
        }
        return true;
    }

    public final void wm(sc1.n3 statusCode) throws IOException {
        Intrinsics.checkNotNullParameter(statusCode, "statusCode");
        synchronized (this.f13669ut) {
            synchronized (this) {
                if (this.f13671w) {
                    return;
                }
                this.f13671w = true;
                int i = this.f13653f;
                Unit unit = Unit.INSTANCE;
                this.f13669ut.co(i, statusCode, lc1.n3.y);
            }
        }
    }

    public final sc1.c5 x5(int i, List<sc1.zn> list, boolean z2) throws IOException {
        int i5;
        sc1.c5 c5Var;
        boolean z3 = true;
        boolean z4 = !z2;
        synchronized (this.f13669ut) {
            try {
                synchronized (this) {
                    if (this.f13668t > 1073741823) {
                        wm(sc1.n3.REFUSED_STREAM);
                    }
                    if (!this.f13671w) {
                        i5 = this.f13668t;
                        this.f13668t = i5 + 2;
                        c5Var = new sc1.c5(i5, this, z4, false, null);
                        if (z2 && this.f13661o < this.f13657j && c5Var.mt() < c5Var.p()) {
                            z3 = false;
                        }
                        if (c5Var.r()) {
                            this.f13655fb.put(Integer.valueOf(i5), c5Var);
                        }
                        Unit unit = Unit.INSTANCE;
                    } else {
                        throw new sc1.y();
                    }
                }
                if (i == 0) {
                    this.f13669ut.r(z4, i5, list);
                } else if (!this.y) {
                    this.f13669ut.d(i, i5, list);
                } else {
                    throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z3) {
            this.f13669ut.flush();
        }
        return c5Var;
    }

    public final String yc() {
        return this.f13667s;
    }

    public final void yk(int i, List<sc1.zn> requestHeaders) {
        Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
        synchronized (this) {
            if (this.f13659k.contains(Integer.valueOf(i))) {
                mh(i, sc1.n3.PROTOCOL_ERROR);
                return;
            }
            this.f13659k.add(Integer.valueOf(i));
            String str = this.f13667s + '[' + i + "] onRequest";
            this.f13673z.c5(new s(str, true, str, true, this, i, requestHeaders), 0L);
        }
    }

    /* loaded from: classes.dex */
    public final class v implements s.zn, Function0<Unit> {

        /* renamed from: v */
        public final /* synthetic */ a f13719v;
        public final sc1.s y;

        /* loaded from: classes.dex */
        public static final class gv extends oc1.y {

            /* renamed from: a */
            public final /* synthetic */ boolean f13720a;

            /* renamed from: c5 */
            public final /* synthetic */ tl f13721c5;

            /* renamed from: fb */
            public final /* synthetic */ v f13722fb;

            /* renamed from: s */
            public final /* synthetic */ boolean f13723s;

            /* renamed from: v */
            public final /* synthetic */ String f13724v;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public gv(String str, boolean z2, String str2, boolean z3, v vVar, boolean z4, tl tlVar) {
                super(str2, z3);
                this.f13724v = str;
                this.f13720a = z2;
                this.f13722fb = vVar;
                this.f13723s = z4;
                this.f13721c5 = tlVar;
            }

            @Override // oc1.y
            public long a() {
                this.f13722fb.f(this.f13723s, this.f13721c5);
                return -1L;
            }
        }

        /* loaded from: classes.dex */
        public static final class n3 extends oc1.y {

            /* renamed from: a */
            public final /* synthetic */ boolean f13725a;

            /* renamed from: c5 */
            public final /* synthetic */ sc1.c5 f13726c5;

            /* renamed from: f */
            public final /* synthetic */ List f13727f;

            /* renamed from: fb */
            public final /* synthetic */ sc1.c5 f13728fb;

            /* renamed from: i9 */
            public final /* synthetic */ int f13729i9;

            /* renamed from: s */
            public final /* synthetic */ v f13730s;

            /* renamed from: t */
            public final /* synthetic */ boolean f13731t;

            /* renamed from: v */
            public final /* synthetic */ String f13732v;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public n3(String str, boolean z2, String str2, boolean z3, sc1.c5 c5Var, v vVar, sc1.c5 c5Var2, int i, List list, boolean z4) {
                super(str2, z3);
                this.f13732v = str;
                this.f13725a = z2;
                this.f13728fb = c5Var;
                this.f13730s = vVar;
                this.f13726c5 = c5Var2;
                this.f13729i9 = i;
                this.f13727f = list;
                this.f13731t = z4;
            }

            @Override // oc1.y
            public long a() {
                try {
                    this.f13730s.f13719v.pq().v(this.f13728fb);
                    return -1L;
                } catch (IOException e2) {
                    uc1.s fb2 = uc1.s.f14065zn.fb();
                    fb2.f("Http2Connection.Listener failure for " + this.f13730s.f13719v.yc(), 4, e2);
                    try {
                        this.f13728fb.gv(sc1.n3.PROTOCOL_ERROR, e2);
                        return -1L;
                    } catch (IOException unused) {
                        return -1L;
                    }
                }
            }
        }

        /* loaded from: classes.dex */
        public static final class y extends oc1.y {

            /* renamed from: a */
            public final /* synthetic */ boolean f13733a;

            /* renamed from: c5 */
            public final /* synthetic */ boolean f13734c5;

            /* renamed from: f */
            public final /* synthetic */ Ref$LongRef f13735f;

            /* renamed from: fb */
            public final /* synthetic */ v f13736fb;

            /* renamed from: i9 */
            public final /* synthetic */ tl f13737i9;

            /* renamed from: s */
            public final /* synthetic */ Ref$ObjectRef f13738s;

            /* renamed from: t */
            public final /* synthetic */ Ref$ObjectRef f13739t;

            /* renamed from: v */
            public final /* synthetic */ String f13740v;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public y(String str, boolean z2, String str2, boolean z3, v vVar, Ref$ObjectRef ref$ObjectRef, boolean z4, tl tlVar, Ref$LongRef ref$LongRef, Ref$ObjectRef ref$ObjectRef2) {
                super(str2, z3);
                this.f13740v = str;
                this.f13733a = z2;
                this.f13736fb = vVar;
                this.f13738s = ref$ObjectRef;
                this.f13734c5 = z4;
                this.f13737i9 = tlVar;
                this.f13735f = ref$LongRef;
                this.f13739t = ref$ObjectRef2;
            }

            @Override // oc1.y
            public long a() {
                this.f13736fb.f13719v.pq().gv(this.f13736fb.f13719v, (tl) this.f13738s.element);
                return -1L;
            }
        }

        /* loaded from: classes.dex */
        public static final class zn extends oc1.y {

            /* renamed from: a */
            public final /* synthetic */ boolean f13741a;

            /* renamed from: c5 */
            public final /* synthetic */ int f13742c5;

            /* renamed from: fb */
            public final /* synthetic */ v f13743fb;

            /* renamed from: s */
            public final /* synthetic */ int f13744s;

            /* renamed from: v */
            public final /* synthetic */ String f13745v;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public zn(String str, boolean z2, String str2, boolean z3, v vVar, int i, int i5) {
                super(str2, z3);
                this.f13745v = str;
                this.f13741a = z2;
                this.f13743fb = vVar;
                this.f13744s = i;
                this.f13742c5 = i5;
            }

            @Override // oc1.y
            public long a() {
                this.f13743fb.f13719v.uo(true, this.f13744s, this.f13742c5);
                return -1L;
            }
        }

        public v(a aVar, sc1.s reader) {
            Intrinsics.checkNotNullParameter(reader, "reader");
            this.f13719v = aVar;
            this.y = reader;
        }

        @Override // sc1.s.zn
        public void c5(int i, sc1.n3 errorCode, zc1.s debugData) {
            int i5;
            sc1.c5[] c5VarArr;
            Intrinsics.checkNotNullParameter(errorCode, "errorCode");
            Intrinsics.checkNotNullParameter(debugData, "debugData");
            debugData.j();
            synchronized (this.f13719v) {
                Object[] array = this.f13719v.qj().values().toArray(new sc1.c5[0]);
                if (array != null) {
                    c5VarArr = (sc1.c5[]) array;
                    this.f13719v.f13671w = true;
                    Unit unit = Unit.INSTANCE;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
            }
            for (sc1.c5 c5Var : c5VarArr) {
                if (c5Var.i9() > i && c5Var.z()) {
                    c5Var.n(sc1.n3.REFUSED_STREAM);
                    this.f13719v.vn(c5Var.i9());
                }
            }
        }

        /* JADX WARN: Can't wrap try/catch for region: R(15:6|7|(1:9)(1:54)|10|(2:15|(10:17|18|19|20|21|22|23|24|25|26)(2:51|52))|53|18|19|20|21|22|23|24|25|26) */
        /* JADX WARN: Code restructure failed: missing block: B:94:0x00dd, code lost:
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:95:0x00de, code lost:
            r21.f13719v.o4(r0);
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v1, types: [sc1.tl, T] */
        /* JADX WARN: Type inference failed for: r2v14 */
        /* JADX WARN: Type inference failed for: r2v15 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void f(boolean r22, sc1.tl r23) {
            /*
                Method dump skipped, instructions count: 269
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: sc1.a.v.f(boolean, sc1.tl):void");
        }

        @Override // sc1.s.zn
        public void fb(boolean z2, int i, int i5) {
            if (!z2) {
                String str = this.f13719v.yc() + " ping";
                this.f13719v.f13649co.c5(new zn(str, true, str, true, this, i, i5), 0L);
                return;
            }
            synchronized (this.f13719v) {
                try {
                    if (i != 1) {
                        if (i != 2) {
                            if (i == 3) {
                                this.f13719v.f13650d++;
                                a aVar = this.f13719v;
                                if (aVar != null) {
                                    aVar.notifyAll();
                                } else {
                                    throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                                }
                            }
                            Unit unit = Unit.INSTANCE;
                        } else {
                            this.f13719v.f13656fh++;
                        }
                    } else {
                        this.f13719v.f13648c++;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // sc1.s.zn
        public void gv(int i, int i5, List<sc1.zn> requestHeaders) {
            Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
            this.f13719v.yk(i5, requestHeaders);
        }

        @Override // sc1.s.zn
        public void i9(int i, sc1.n3 errorCode) {
            Intrinsics.checkNotNullParameter(errorCode, "errorCode");
            if (this.f13719v.i3(i)) {
                this.f13719v.i2(i, errorCode);
                return;
            }
            sc1.c5 vn2 = this.f13719v.vn(i);
            if (vn2 != null) {
                vn2.n(errorCode);
            }
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            t();
            return Unit.INSTANCE;
        }

        @Override // sc1.s.zn
        public void n3(boolean z2, int i, int i5, List<sc1.zn> headerBlock) {
            Intrinsics.checkNotNullParameter(headerBlock, "headerBlock");
            if (this.f13719v.i3(i)) {
                this.f13719v.ix(i, headerBlock, z2);
                return;
            }
            synchronized (this.f13719v) {
                sc1.c5 qk2 = this.f13719v.qk(i);
                if (qk2 == null) {
                    if (this.f13719v.f13671w) {
                        return;
                    }
                    if (i <= this.f13719v.m()) {
                        return;
                    }
                    if (i % 2 == this.f13719v.o0() % 2) {
                        return;
                    }
                    sc1.c5 c5Var = new sc1.c5(i, this.f13719v, false, z2, lc1.n3.yt(headerBlock));
                    this.f13719v.ne(i);
                    this.f13719v.qj().put(Integer.valueOf(i), c5Var);
                    String str = this.f13719v.yc() + '[' + i + "] onStream";
                    this.f13719v.f13663p.c5().c5(new n3(str, true, str, true, c5Var, this, qk2, i, headerBlock, z2), 0L);
                    return;
                }
                Unit unit = Unit.INSTANCE;
                qk2.f3(lc1.n3.yt(headerBlock), z2);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [sc1.n3] */
        /* JADX WARN: Type inference failed for: r0v3 */
        /* JADX WARN: Type inference failed for: r0v5, types: [sc1.s, java.io.Closeable] */
        public void t() {
            sc1.n3 n3Var;
            sc1.n3 n3Var2 = sc1.n3.INTERNAL_ERROR;
            IOException e2 = null;
            try {
                try {
                    this.y.s(this);
                    while (this.y.v(false, this)) {
                    }
                    sc1.n3 n3Var3 = sc1.n3.NO_ERROR;
                    try {
                        this.f13719v.ct(n3Var3, sc1.n3.CANCEL, null);
                        n3Var = n3Var3;
                    } catch (IOException e3) {
                        e2 = e3;
                        sc1.n3 n3Var4 = sc1.n3.PROTOCOL_ERROR;
                        a aVar = this.f13719v;
                        aVar.ct(n3Var4, n3Var4, e2);
                        n3Var = aVar;
                        n3Var2 = this.y;
                        lc1.n3.i9(n3Var2);
                    }
                } catch (Throwable th) {
                    th = th;
                    this.f13719v.ct(n3Var, n3Var2, e2);
                    lc1.n3.i9(this.y);
                    throw th;
                }
            } catch (IOException e5) {
                e2 = e5;
            } catch (Throwable th2) {
                th = th2;
                n3Var = n3Var2;
                this.f13719v.ct(n3Var, n3Var2, e2);
                lc1.n3.i9(this.y);
                throw th;
            }
            n3Var2 = this.y;
            lc1.n3.i9(n3Var2);
        }

        @Override // sc1.s.zn
        public void v(boolean z2, int i, zc1.fb source, int i5) throws IOException {
            Intrinsics.checkNotNullParameter(source, "source");
            if (this.f13719v.i3(i)) {
                this.f13719v.ro(i, source, i5, z2);
                return;
            }
            sc1.c5 qk2 = this.f13719v.qk(i);
            if (qk2 == null) {
                this.f13719v.mh(i, sc1.n3.PROTOCOL_ERROR);
                long j2 = i5;
                this.f13719v.bv(j2);
                source.skip(j2);
                return;
            }
            qk2.i4(source, i5);
            if (z2) {
                qk2.f3(lc1.n3.f10305n3, true);
            }
        }

        @Override // sc1.s.zn
        public void y(boolean z2, tl settings) {
            Intrinsics.checkNotNullParameter(settings, "settings");
            String str = this.f13719v.yc() + " applyAndAckSettings";
            this.f13719v.f13649co.c5(new gv(str, true, str, true, this, z2, settings), 0L);
        }

        @Override // sc1.s.zn
        public void zn(int i, long j2) {
            if (i == 0) {
                synchronized (this.f13719v) {
                    a aVar = this.f13719v;
                    aVar.f13657j = aVar.l() + j2;
                    a aVar2 = this.f13719v;
                    if (aVar2 != null) {
                        aVar2.notifyAll();
                        Unit unit = Unit.INSTANCE;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                    }
                }
                return;
            }
            sc1.c5 qk2 = this.f13719v.qk(i);
            if (qk2 != null) {
                synchronized (qk2) {
                    qk2.y(j2);
                    Unit unit2 = Unit.INSTANCE;
                }
            }
        }

        @Override // sc1.s.zn
        public void a() {
        }

        @Override // sc1.s.zn
        public void s(int i, int i5, int i6, boolean z2) {
        }
    }
}
