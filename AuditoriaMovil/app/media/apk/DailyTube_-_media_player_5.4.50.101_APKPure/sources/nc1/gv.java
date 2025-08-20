package nc1;

import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import uc1.s;
import zc1.f;
import zc1.fb;
import zc1.p;
import zc1.rz;
import zc1.ta;
/* loaded from: classes.dex */
public final class gv implements Closeable, Flushable {

    /* renamed from: b */
    public final int f11858b;

    /* renamed from: c */
    public boolean f11859c;

    /* renamed from: co */
    public boolean f11860co;

    /* renamed from: d */
    public final v f11861d;

    /* renamed from: d0 */
    public long f11862d0;

    /* renamed from: ej */
    public final tc1.y f11863ej;

    /* renamed from: f */
    public long f11864f;

    /* renamed from: f3 */
    public boolean f11865f3;

    /* renamed from: fb */
    public final File f11866fb;

    /* renamed from: fh */
    public final oc1.gv f11867fh;

    /* renamed from: j5 */
    public final int f11868j5;

    /* renamed from: n */
    public boolean f11869n;

    /* renamed from: p */
    public int f11870p;

    /* renamed from: r */
    public boolean f11871r;

    /* renamed from: s */
    public final File f11872s;

    /* renamed from: t */
    public zc1.a f11873t;

    /* renamed from: v */
    public final File f11874v;

    /* renamed from: w */
    public final LinkedHashMap<String, zn> f11875w;

    /* renamed from: x */
    public final File f11876x;
    public long y;

    /* renamed from: z */
    public boolean f11877z;

    /* renamed from: y5 */
    public static final y f11857y5 = new y(null);

    /* renamed from: qn */
    public static final String f11854qn = "journal";

    /* renamed from: o */
    public static final String f11851o = "journal.tmp";

    /* renamed from: j */
    public static final String f11848j = "journal.bkp";

    /* renamed from: oz */
    public static final String f11852oz = "libcore.io.DiskLruCache";

    /* renamed from: ut */
    public static final String f11856ut = "1";

    /* renamed from: q9 */
    public static final long f11853q9 = -1;

    /* renamed from: k */
    public static final Regex f11850k = new Regex("[a-z0-9_-]{1,120}");

    /* renamed from: f7 */
    public static final String f11847f7 = "CLEAN";

    /* renamed from: en */
    public static final String f11846en = "DIRTY";

    /* renamed from: jz */
    public static final String f11849jz = "REMOVE";

    /* renamed from: u */
    public static final String f11855u = "READ";

    /* loaded from: classes.dex */
    public static final class a extends Lambda implements Function1<IOException, Unit> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a() {
            super(1);
            gv.this = r1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(IOException iOException) {
            y(iOException);
            return Unit.INSTANCE;
        }

        public final void y(IOException it) {
            Intrinsics.checkNotNullParameter(it, "it");
            gv gvVar = gv.this;
            if (!lc1.n3.f10306s || Thread.holdsLock(gvVar)) {
                gv.this.f11860co = true;
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread currentThread = Thread.currentThread();
            Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
            sb.append(currentThread.getName());
            sb.append(" MUST hold lock on ");
            sb.append(gvVar);
            throw new AssertionError(sb.toString());
        }
    }

    /* renamed from: nc1.gv$gv */
    /* loaded from: classes.dex */
    public final class C0164gv implements Closeable {

        /* renamed from: f */
        public final /* synthetic */ gv f11878f;

        /* renamed from: fb */
        public final List<ta> f11879fb;

        /* renamed from: s */
        public final long[] f11880s;

        /* renamed from: v */
        public final long f11881v;
        public final String y;

        public C0164gv(gv gvVar, String key, long j2, List<? extends ta> sources, long[] lengths) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(sources, "sources");
            Intrinsics.checkNotNullParameter(lengths, "lengths");
            this.f11878f = gvVar;
            this.y = key;
            this.f11881v = j2;
            this.f11879fb = sources;
            this.f11880s = lengths;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (ta taVar : this.f11879fb) {
                lc1.n3.i9(taVar);
            }
        }

        public final ta v(int i) {
            return this.f11879fb.get(i);
        }

        public final n3 y() throws IOException {
            return this.f11878f.b(this.y, this.f11881v);
        }
    }

    /* loaded from: classes.dex */
    public final class n3 {

        /* renamed from: gv */
        public final /* synthetic */ gv f11882gv;

        /* renamed from: n3 */
        public boolean f11883n3;
        public final boolean[] y;

        /* renamed from: zn */
        public final zn f11884zn;

        /* loaded from: classes.dex */
        public static final class y extends Lambda implements Function1<IOException, Unit> {
            final /* synthetic */ int $index$inlined;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public y(int i) {
                super(1);
                n3.this = r1;
                this.$index$inlined = i;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IOException iOException) {
                y(iOException);
                return Unit.INSTANCE;
            }

            public final void y(IOException it) {
                Intrinsics.checkNotNullParameter(it, "it");
                synchronized (n3.this.f11882gv) {
                    n3.this.zn();
                    Unit unit = Unit.INSTANCE;
                }
            }
        }

        public n3(gv gvVar, zn entry) {
            boolean[] zArr;
            Intrinsics.checkNotNullParameter(entry, "entry");
            this.f11882gv = gvVar;
            this.f11884zn = entry;
            if (entry.fb()) {
                zArr = null;
            } else {
                zArr = new boolean[gvVar.dm()];
            }
            this.y = zArr;
        }

        public final rz a(int i) {
            synchronized (this.f11882gv) {
                if (!this.f11883n3) {
                    if (!Intrinsics.areEqual(this.f11884zn.n3(), this)) {
                        return p.n3();
                    }
                    if (!this.f11884zn.fb()) {
                        boolean[] zArr = this.y;
                        Intrinsics.checkNotNull(zArr);
                        zArr[i] = true;
                    }
                    try {
                        return new nc1.v(this.f11882gv.jz().v(this.f11884zn.zn().get(i)), new y(i));
                    } catch (FileNotFoundException unused) {
                        return p.n3();
                    }
                }
                throw new IllegalStateException("Check failed.");
            }
        }

        public final zn gv() {
            return this.f11884zn;
        }

        public final void n3() throws IOException {
            synchronized (this.f11882gv) {
                try {
                    if (!this.f11883n3) {
                        if (Intrinsics.areEqual(this.f11884zn.n3(), this)) {
                            this.f11882gv.d(this, true);
                        }
                        this.f11883n3 = true;
                        Unit unit = Unit.INSTANCE;
                    } else {
                        throw new IllegalStateException("Check failed.");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final boolean[] v() {
            return this.y;
        }

        public final void y() throws IOException {
            synchronized (this.f11882gv) {
                try {
                    if (!this.f11883n3) {
                        if (Intrinsics.areEqual(this.f11884zn.n3(), this)) {
                            this.f11882gv.d(this, false);
                        }
                        this.f11883n3 = true;
                        Unit unit = Unit.INSTANCE;
                    } else {
                        throw new IllegalStateException("Check failed.");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final void zn() {
            if (Intrinsics.areEqual(this.f11884zn.n3(), this)) {
                if (this.f11882gv.f11877z) {
                    this.f11882gv.d(this, false);
                } else {
                    this.f11884zn.p(true);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class v extends oc1.y {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v(String str) {
            super(str, false, 2, null);
            gv.this = r3;
        }

        @Override // oc1.y
        public long a() {
            synchronized (gv.this) {
                if (!gv.this.f11871r || gv.this.j5()) {
                    return -1L;
                }
                try {
                    gv.this.qj();
                } catch (IOException unused) {
                    gv.this.f11869n = true;
                }
                try {
                    if (gv.this.o4()) {
                        gv.this.o0();
                        gv.this.f11870p = 0;
                    }
                } catch (IOException unused2) {
                    gv.this.f11859c = true;
                    gv.this.f11873t = p.zn(p.n3());
                }
                return -1L;
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class y {
        public y() {
        }

        public /* synthetic */ y(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public final class zn {

        /* renamed from: a */
        public n3 f11886a;

        /* renamed from: c5 */
        public final String f11887c5;

        /* renamed from: fb */
        public int f11888fb;

        /* renamed from: gv */
        public boolean f11889gv;

        /* renamed from: i9 */
        public final /* synthetic */ gv f11890i9;

        /* renamed from: n3 */
        public final List<File> f11891n3;

        /* renamed from: s */
        public long f11892s;

        /* renamed from: v */
        public boolean f11893v;
        public final long[] y;

        /* renamed from: zn */
        public final List<File> f11894zn;

        /* loaded from: classes.dex */
        public static final class y extends f {

            /* renamed from: fb */
            public final /* synthetic */ ta f11895fb;
            public boolean y;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public y(ta taVar, ta taVar2) {
                super(taVar2);
                zn.this = r1;
                this.f11895fb = taVar;
            }

            public void close() {
                super.close();
                if (!this.y) {
                    this.y = true;
                    synchronized (zn.this.f11890i9) {
                        try {
                            zn znVar = zn.this;
                            znVar.wz(znVar.a() - 1);
                            if (zn.this.a() == 0 && zn.this.c5()) {
                                zn znVar2 = zn.this;
                                znVar2.f11890i9.cy(znVar2);
                            }
                            Unit unit = Unit.INSTANCE;
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            }
        }

        public zn(gv gvVar, String key) {
            Intrinsics.checkNotNullParameter(key, "key");
            this.f11890i9 = gvVar;
            this.f11887c5 = key;
            this.y = new long[gvVar.dm()];
            this.f11891n3 = new ArrayList();
            this.f11894zn = new ArrayList();
            StringBuilder sb = new StringBuilder(key);
            sb.append('.');
            int length = sb.length();
            int dm2 = gvVar.dm();
            for (int i = 0; i < dm2; i++) {
                sb.append(i);
                this.f11891n3.add(new File(gvVar.j(), sb.toString()));
                sb.append(".tmp");
                this.f11894zn.add(new File(gvVar.j(), sb.toString()));
                sb.setLength(length);
            }
        }

        public final int a() {
            return this.f11888fb;
        }

        public final boolean c5() {
            return this.f11893v;
        }

        public final void co(zc1.a writer) throws IOException {
            Intrinsics.checkNotNullParameter(writer, "writer");
            for (long j2 : this.y) {
                writer.writeByte(32).f7(j2);
            }
        }

        public final ta f(int i) {
            ta gv2 = this.f11890i9.jz().gv(this.f11891n3.get(i));
            if (this.f11890i9.f11877z) {
                return gv2;
            }
            this.f11888fb++;
            return new y(gv2, gv2);
        }

        public final boolean fb() {
            return this.f11889gv;
        }

        public final String gv() {
            return this.f11887c5;
        }

        public final Void i9(List<String> list) throws IOException {
            throw new IOException("unexpected journal line: " + list);
        }

        public final C0164gv mt() {
            gv gvVar = this.f11890i9;
            if (lc1.n3.f10306s && !Thread.holdsLock(gvVar)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Thread ");
                Thread currentThread = Thread.currentThread();
                Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
                sb.append(currentThread.getName());
                sb.append(" MUST hold lock on ");
                sb.append(gvVar);
                throw new AssertionError(sb.toString());
            } else if (!this.f11889gv) {
                return null;
            } else {
                if (!this.f11890i9.f11877z && (this.f11886a != null || this.f11893v)) {
                    return null;
                }
                ArrayList<ta> arrayList = new ArrayList();
                long[] jArr = (long[]) this.y.clone();
                try {
                    int dm2 = this.f11890i9.dm();
                    for (int i = 0; i < dm2; i++) {
                        arrayList.add(f(i));
                    }
                    return new C0164gv(this.f11890i9, this.f11887c5, this.f11892s, arrayList, jArr);
                } catch (FileNotFoundException unused) {
                    for (ta taVar : arrayList) {
                        lc1.n3.i9(taVar);
                    }
                    try {
                        this.f11890i9.cy(this);
                    } catch (IOException unused2) {
                    }
                    return null;
                }
            }
        }

        public final n3 n3() {
            return this.f11886a;
        }

        public final void p(boolean z2) {
            this.f11893v = z2;
        }

        public final long s() {
            return this.f11892s;
        }

        public final void t(n3 n3Var) {
            this.f11886a = n3Var;
        }

        public final void tl(List<String> strings) throws IOException {
            Intrinsics.checkNotNullParameter(strings, "strings");
            if (strings.size() == this.f11890i9.dm()) {
                try {
                    int size = strings.size();
                    for (int i = 0; i < size; i++) {
                        this.y[i] = Long.parseLong(strings.get(i));
                    }
                    return;
                } catch (NumberFormatException unused) {
                    i9(strings);
                    throw new KotlinNothingValueException();
                }
            }
            i9(strings);
            throw new KotlinNothingValueException();
        }

        public final long[] v() {
            return this.y;
        }

        public final void w(long j2) {
            this.f11892s = j2;
        }

        public final void wz(int i) {
            this.f11888fb = i;
        }

        public final void xc(boolean z2) {
            this.f11889gv = z2;
        }

        public final List<File> y() {
            return this.f11891n3;
        }

        public final List<File> zn() {
            return this.f11894zn;
        }
    }

    public gv(tc1.y fileSystem, File directory, int i, int i5, long j2, oc1.v taskRunner) {
        boolean z2;
        Intrinsics.checkNotNullParameter(fileSystem, "fileSystem");
        Intrinsics.checkNotNullParameter(directory, "directory");
        Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
        this.f11863ej = fileSystem;
        this.f11876x = directory;
        this.f11858b = i;
        this.f11868j5 = i5;
        this.y = j2;
        this.f11875w = new LinkedHashMap<>(0, 0.75f, true);
        this.f11867fh = taskRunner.c5();
        this.f11861d = new v(lc1.n3.f10302c5 + " Cache");
        if (j2 > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            if (i5 > 0) {
                this.f11874v = new File(directory, f11854qn);
                this.f11866fb = new File(directory, f11851o);
                this.f11872s = new File(directory, f11848j);
                return;
            }
            throw new IllegalArgumentException("valueCount <= 0");
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public static /* synthetic */ n3 k5(gv gvVar, String str, long j2, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            j2 = f11853q9;
        }
        return gvVar.b(str, j2);
    }

    public final synchronized boolean ad(String key) throws IOException {
        Intrinsics.checkNotNullParameter(key, "key");
        ct();
        ta();
        l(key);
        zn znVar = this.f11875w.get(key);
        if (znVar == null) {
            return false;
        }
        Intrinsics.checkNotNullExpressionValue(znVar, "lruEntries[key] ?: return false");
        boolean cy2 = cy(znVar);
        if (cy2 && this.f11864f <= this.y) {
            this.f11869n = false;
        }
        return cy2;
    }

    public final zc1.a ap() throws FileNotFoundException {
        return p.zn(new nc1.v(this.f11863ej.n3(this.f11874v), new a()));
    }

    public final synchronized n3 b(String key, long j2) throws IOException {
        n3 n3Var;
        Intrinsics.checkNotNullParameter(key, "key");
        ct();
        ta();
        l(key);
        zn znVar = this.f11875w.get(key);
        if (j2 != f11853q9 && (znVar == null || znVar.s() != j2)) {
            return null;
        }
        if (znVar != null) {
            n3Var = znVar.n3();
        } else {
            n3Var = null;
        }
        if (n3Var != null) {
            return null;
        }
        if (znVar != null && znVar.a() != 0) {
            return null;
        }
        if (!this.f11869n && !this.f11859c) {
            zc1.a aVar = this.f11873t;
            Intrinsics.checkNotNull(aVar);
            aVar.n(f11846en).writeByte(32).n(key).writeByte(10);
            aVar.flush();
            if (this.f11860co) {
                return null;
            }
            if (znVar == null) {
                znVar = new zn(this, key);
                this.f11875w.put(key, znVar);
            }
            n3 n3Var2 = new n3(this, znVar);
            znVar.t(n3Var2);
            return n3Var2;
        }
        oc1.gv.i9(this.f11867fh, this.f11861d, 0L, 2, null);
        return null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        zn[] znVarArr;
        n3 n32;
        try {
            if (this.f11871r && !this.f11865f3) {
                Collection<zn> values = this.f11875w.values();
                Intrinsics.checkNotNullExpressionValue(values, "lruEntries.values");
                Object[] array = values.toArray(new zn[0]);
                if (array != null) {
                    for (zn znVar : (zn[]) array) {
                        if (znVar.n3() != null && (n32 = znVar.n3()) != null) {
                            n32.zn();
                        }
                    }
                    qj();
                    zc1.a aVar = this.f11873t;
                    Intrinsics.checkNotNull(aVar);
                    aVar.close();
                    this.f11873t = null;
                    this.f11865f3 = true;
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            this.f11865f3 = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void ct() throws IOException {
        try {
            if (lc1.n3.f10306s && !Thread.holdsLock(this)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Thread ");
                Thread currentThread = Thread.currentThread();
                Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
                sb.append(currentThread.getName());
                sb.append(" MUST hold lock on ");
                sb.append(this);
                throw new AssertionError(sb.toString());
            }
            if (this.f11871r) {
                return;
            }
            if (this.f11863ej.y(this.f11872s)) {
                if (this.f11863ej.y(this.f11874v)) {
                    this.f11863ej.fb(this.f11872s);
                } else {
                    this.f11863ej.a(this.f11872s, this.f11874v);
                }
            }
            this.f11877z = lc1.n3.rz(this.f11863ej, this.f11872s);
            if (this.f11863ej.y(this.f11874v)) {
                try {
                    m();
                    yc();
                    this.f11871r = true;
                    return;
                } catch (IOException e2) {
                    s fb2 = s.f14065zn.fb();
                    fb2.f("DiskLruCache " + this.f11876x + " is corrupt: " + e2.getMessage() + ", removing", 5, e2);
                    ud();
                    this.f11865f3 = false;
                }
            }
            o0();
            this.f11871r = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final boolean cy(zn entry) throws IOException {
        zc1.a aVar;
        Intrinsics.checkNotNullParameter(entry, "entry");
        if (!this.f11877z) {
            if (entry.a() > 0 && (aVar = this.f11873t) != null) {
                aVar.n(f11846en);
                aVar.writeByte(32);
                aVar.n(entry.gv());
                aVar.writeByte(10);
                aVar.flush();
            }
            if (entry.a() > 0 || entry.n3() != null) {
                entry.p(true);
                return true;
            }
        }
        n3 n32 = entry.n3();
        if (n32 != null) {
            n32.zn();
        }
        int i = this.f11868j5;
        for (int i5 = 0; i5 < i; i5++) {
            this.f11863ej.fb(entry.y().get(i5));
            this.f11864f -= entry.v()[i5];
            entry.v()[i5] = 0;
        }
        this.f11870p++;
        zc1.a aVar2 = this.f11873t;
        if (aVar2 != null) {
            aVar2.n(f11849jz);
            aVar2.writeByte(32);
            aVar2.n(entry.gv());
            aVar2.writeByte(10);
        }
        this.f11875w.remove(entry.gv());
        if (o4()) {
            oc1.gv.i9(this.f11867fh, this.f11861d, 0L, 2, null);
        }
        return true;
    }

    public final synchronized void d(n3 editor, boolean z2) throws IOException {
        Intrinsics.checkNotNullParameter(editor, "editor");
        zn gv2 = editor.gv();
        if (Intrinsics.areEqual(gv2.n3(), editor)) {
            if (z2 && !gv2.fb()) {
                int i = this.f11868j5;
                for (int i5 = 0; i5 < i; i5++) {
                    boolean[] v2 = editor.v();
                    Intrinsics.checkNotNull(v2);
                    if (v2[i5]) {
                        if (!this.f11863ej.y(gv2.zn().get(i5))) {
                            editor.y();
                            return;
                        }
                    } else {
                        editor.y();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i5);
                    }
                }
            }
            int i6 = this.f11868j5;
            for (int i8 = 0; i8 < i6; i8++) {
                File file = gv2.zn().get(i8);
                if (z2 && !gv2.c5()) {
                    if (this.f11863ej.y(file)) {
                        File file2 = gv2.y().get(i8);
                        this.f11863ej.a(file, file2);
                        long j2 = gv2.v()[i8];
                        long zn2 = this.f11863ej.zn(file2);
                        gv2.v()[i8] = zn2;
                        this.f11864f = (this.f11864f - j2) + zn2;
                    }
                } else {
                    this.f11863ej.fb(file);
                }
            }
            gv2.t(null);
            if (gv2.c5()) {
                cy(gv2);
                return;
            }
            this.f11870p++;
            zc1.a aVar = this.f11873t;
            Intrinsics.checkNotNull(aVar);
            if (!gv2.fb() && !z2) {
                this.f11875w.remove(gv2.gv());
                aVar.n(f11849jz).writeByte(32);
                aVar.n(gv2.gv());
                aVar.writeByte(10);
                aVar.flush();
                if (this.f11864f <= this.y || o4()) {
                    oc1.gv.i9(this.f11867fh, this.f11861d, 0L, 2, null);
                }
                return;
            }
            gv2.xc(true);
            aVar.n(f11847f7).writeByte(32);
            aVar.n(gv2.gv());
            gv2.co(aVar);
            aVar.writeByte(10);
            if (z2) {
                long j4 = this.f11862d0;
                this.f11862d0 = 1 + j4;
                gv2.w(j4);
            }
            aVar.flush();
            if (this.f11864f <= this.y) {
            }
            oc1.gv.i9(this.f11867fh, this.f11861d, 0L, 2, null);
            return;
        }
        throw new IllegalStateException("Check failed.");
    }

    public final int dm() {
        return this.f11868j5;
    }

    @Override // java.io.Flushable
    public synchronized void flush() throws IOException {
        if (!this.f11871r) {
            return;
        }
        ta();
        qj();
        zc1.a aVar = this.f11873t;
        Intrinsics.checkNotNull(aVar);
        aVar.flush();
    }

    public final File j() {
        return this.f11876x;
    }

    public final boolean j5() {
        return this.f11865f3;
    }

    public final tc1.y jz() {
        return this.f11863ej;
    }

    public final void l(String str) {
        if (f11850k.matches(str)) {
            return;
        }
        throw new IllegalArgumentException(("keys must match regex [a-z0-9_-]{1,120}: \"" + str + '\"').toString());
    }

    public final void m() throws IOException {
        fb gv2 = p.gv(this.f11863ej.gv(this.f11874v));
        try {
            String vl2 = gv2.vl();
            String vl3 = gv2.vl();
            String vl4 = gv2.vl();
            String vl5 = gv2.vl();
            String vl6 = gv2.vl();
            if (Intrinsics.areEqual(f11852oz, vl2) && Intrinsics.areEqual(f11856ut, vl3) && Intrinsics.areEqual(String.valueOf(this.f11858b), vl4) && Intrinsics.areEqual(String.valueOf(this.f11868j5), vl5) && vl6.length() <= 0) {
                int i = 0;
                while (true) {
                    try {
                        pq(gv2.vl());
                        i++;
                    } catch (EOFException unused) {
                        this.f11870p = i - this.f11875w.size();
                        if (!gv2.nf()) {
                            o0();
                        } else {
                            this.f11873t = ap();
                        }
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(gv2, null);
                        return;
                    }
                }
            } else {
                throw new IOException("unexpected journal header: [" + vl2 + ", " + vl3 + ", " + vl5 + ", " + vl6 + ']');
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(gv2, th);
                throw th2;
            }
        }
    }

    public final synchronized void o0() throws IOException {
        try {
            zc1.a aVar = this.f11873t;
            if (aVar != null) {
                aVar.close();
            }
            zc1.a zn2 = p.zn(this.f11863ej.v(this.f11866fb));
            zn2.n(f11852oz).writeByte(10);
            zn2.n(f11856ut).writeByte(10);
            zn2.f7(this.f11858b).writeByte(10);
            zn2.f7(this.f11868j5).writeByte(10);
            zn2.writeByte(10);
            for (zn znVar : this.f11875w.values()) {
                if (znVar.n3() != null) {
                    zn2.n(f11846en).writeByte(32);
                    zn2.n(znVar.gv());
                    zn2.writeByte(10);
                } else {
                    zn2.n(f11847f7).writeByte(32);
                    zn2.n(znVar.gv());
                    znVar.co(zn2);
                    zn2.writeByte(10);
                }
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(zn2, null);
            if (this.f11863ej.y(this.f11874v)) {
                this.f11863ej.a(this.f11874v, this.f11872s);
            }
            this.f11863ej.a(this.f11866fb, this.f11874v);
            this.f11863ej.fb(this.f11872s);
            this.f11873t = ap();
            this.f11860co = false;
            this.f11859c = false;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final boolean o4() {
        int i = this.f11870p;
        if (i >= 2000 && i >= this.f11875w.size()) {
            return true;
        }
        return false;
    }

    public final void pq(String str) throws IOException {
        String substring;
        int indexOf$default = StringsKt.indexOf$default((CharSequence) str, ' ', 0, false, 6, (Object) null);
        if (indexOf$default != -1) {
            int i = indexOf$default + 1;
            int indexOf$default2 = StringsKt.indexOf$default((CharSequence) str, ' ', i, false, 4, (Object) null);
            if (indexOf$default2 == -1) {
                if (str != null) {
                    substring = str.substring(i);
                    Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
                    String str2 = f11849jz;
                    if (indexOf$default == str2.length() && StringsKt.startsWith$default(str, str2, false, 2, (Object) null)) {
                        this.f11875w.remove(substring);
                        return;
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
            } else if (str != null) {
                substring = str.substring(i, indexOf$default2);
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            } else {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            zn znVar = this.f11875w.get(substring);
            if (znVar == null) {
                znVar = new zn(this, substring);
                this.f11875w.put(substring, znVar);
            }
            if (indexOf$default2 != -1) {
                String str3 = f11847f7;
                if (indexOf$default == str3.length() && StringsKt.startsWith$default(str, str3, false, 2, (Object) null)) {
                    int i5 = indexOf$default2 + 1;
                    if (str != null) {
                        String substring2 = str.substring(i5);
                        Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.String).substring(startIndex)");
                        List<String> split$default = StringsKt.split$default((CharSequence) substring2, new char[]{' '}, false, 0, 6, (Object) null);
                        znVar.xc(true);
                        znVar.t(null);
                        znVar.tl(split$default);
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
            }
            if (indexOf$default2 == -1) {
                String str4 = f11846en;
                if (indexOf$default == str4.length() && StringsKt.startsWith$default(str, str4, false, 2, (Object) null)) {
                    znVar.t(new n3(this, znVar));
                    return;
                }
            }
            if (indexOf$default2 == -1) {
                String str5 = f11855u;
                if (indexOf$default == str5.length() && StringsKt.startsWith$default(str, str5, false, 2, (Object) null)) {
                    return;
                }
            }
            throw new IOException("unexpected journal line: " + str);
        }
        throw new IOException("unexpected journal line: " + str);
    }

    public final void qj() throws IOException {
        while (this.f11864f > this.y) {
            if (!qk()) {
                return;
            }
        }
        this.f11869n = false;
    }

    public final boolean qk() {
        for (zn toEvict : this.f11875w.values()) {
            if (!toEvict.c5()) {
                Intrinsics.checkNotNullExpressionValue(toEvict, "toEvict");
                cy(toEvict);
                return true;
            }
        }
        return false;
    }

    public final synchronized void ta() {
        if (this.f11865f3) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public final void ud() throws IOException {
        close();
        this.f11863ej.deleteContents(this.f11876x);
    }

    public final void yc() throws IOException {
        this.f11863ej.fb(this.f11866fb);
        Iterator<zn> it = this.f11875w.values().iterator();
        while (it.hasNext()) {
            zn next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "i.next()");
            zn znVar = next;
            int i = 0;
            if (znVar.n3() == null) {
                int i5 = this.f11868j5;
                while (i < i5) {
                    this.f11864f += znVar.v()[i];
                    i++;
                }
            } else {
                znVar.t(null);
                int i6 = this.f11868j5;
                while (i < i6) {
                    this.f11863ej.fb(znVar.y().get(i));
                    this.f11863ej.fb(znVar.zn().get(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    public final synchronized C0164gv yt(String key) throws IOException {
        Intrinsics.checkNotNullParameter(key, "key");
        ct();
        ta();
        l(key);
        zn znVar = this.f11875w.get(key);
        if (znVar == null) {
            return null;
        }
        Intrinsics.checkNotNullExpressionValue(znVar, "lruEntries[key] ?: return null");
        C0164gv mt2 = znVar.mt();
        if (mt2 == null) {
            return null;
        }
        this.f11870p++;
        zc1.a aVar = this.f11873t;
        Intrinsics.checkNotNull(aVar);
        aVar.n(f11855u).writeByte(32).n(key).writeByte(10);
        if (o4()) {
            oc1.gv.i9(this.f11867fh, this.f11861d, 0L, 2, null);
        }
        return mt2;
    }
}
