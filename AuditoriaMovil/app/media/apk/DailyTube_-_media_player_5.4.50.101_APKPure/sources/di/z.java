package di;

import android.os.ConditionVariable;
import androidx.annotation.Nullable;
import di.y;
import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
/* loaded from: classes.dex */
public final class z implements di.y {

    /* renamed from: t  reason: collision with root package name */
    public static final HashSet<File> f7303t = new HashSet<>();

    /* renamed from: a  reason: collision with root package name */
    public final Random f7304a;

    /* renamed from: c5  reason: collision with root package name */
    public long f7305c5;

    /* renamed from: f  reason: collision with root package name */
    public y.C0084y f7306f;

    /* renamed from: fb  reason: collision with root package name */
    public final boolean f7307fb;
    @Nullable

    /* renamed from: gv  reason: collision with root package name */
    public final a f7308gv;

    /* renamed from: i9  reason: collision with root package name */
    public boolean f7309i9;

    /* renamed from: n3  reason: collision with root package name */
    public final gv f7310n3;

    /* renamed from: s  reason: collision with root package name */
    public long f7311s;

    /* renamed from: v  reason: collision with root package name */
    public final HashMap<String, ArrayList<y.n3>> f7312v;
    public final File y;

    /* renamed from: zn  reason: collision with root package name */
    public final t f7313zn;

    /* loaded from: classes.dex */
    public class y extends Thread {
        public final /* synthetic */ ConditionVariable y;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public y(String str, ConditionVariable conditionVariable) {
            super(str);
            this.y = conditionVariable;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            synchronized (z.this) {
                this.y.open();
                z.this.z();
                z.this.f7310n3.v();
            }
        }
    }

    public z(File file, gv gvVar, da.n3 n3Var) {
        this(file, gvVar, n3Var, null, false, false);
    }

    public static long d0(String str) {
        return Long.parseLong(str.substring(0, str.indexOf(46)), 16);
    }

    public static synchronized boolean i4(File file) {
        boolean add;
        synchronized (z.class) {
            add = f7303t.add(file.getAbsoluteFile());
        }
        return add;
    }

    public static long w(File file) throws IOException {
        long abs;
        long nextLong = new SecureRandom().nextLong();
        if (nextLong == Long.MIN_VALUE) {
            abs = 0;
        } else {
            abs = Math.abs(nextLong);
        }
        String l2 = Long.toString(abs, 16);
        File file2 = new File(file, l2 + ".uid");
        if (file2.createNewFile()) {
            return abs;
        }
        throw new IOException("Failed to create UID file: " + file2);
    }

    public static long x4(File[] fileArr) {
        int length = fileArr.length;
        for (int i = 0; i < length; i++) {
            File file = fileArr[i];
            String name = file.getName();
            if (name.endsWith(".uid")) {
                try {
                    return d0(name);
                } catch (NumberFormatException unused) {
                    v5.r.zn("SimpleCache", "Malformed UID file: " + file);
                    file.delete();
                }
            }
        }
        return -1L;
    }

    public static void xc(File file) throws y.C0084y {
        if (!file.mkdirs() && !file.isDirectory()) {
            String str = "Failed to create cache directory: " + file;
            v5.r.zn("SimpleCache", str);
            throw new y.C0084y(str);
        }
    }

    @Override // di.y
    public synchronized long a(String str, long j2, long j4) {
        long j6;
        v5.y.fb(!this.f7309i9);
        if (j4 == -1) {
            j4 = Long.MAX_VALUE;
        }
        f fb2 = this.f7313zn.fb(str);
        if (fb2 != null) {
            j6 = fb2.zn(j2, j4);
        } else {
            j6 = -j4;
        }
        return j6;
    }

    public final void c(r rVar, c5 c5Var) {
        ArrayList<y.n3> arrayList = this.f7312v.get(rVar.y);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).a(this, rVar, c5Var);
            }
        }
        this.f7310n3.a(this, rVar, c5Var);
    }

    @Override // di.y
    public synchronized c5 c5(String str, long j2, long j4) throws InterruptedException, y.C0084y {
        c5 v2;
        v5.y.fb(!this.f7309i9);
        wz();
        while (true) {
            v2 = v(str, j2, j4);
            if (v2 == null) {
                wait();
            }
        }
        return v2;
    }

    public final r co(String str, long j2, long j4) {
        r v2;
        f fb2 = this.f7313zn.fb(str);
        if (fb2 == null) {
            return r.fb(str, j2, j4);
        }
        while (true) {
            v2 = fb2.v(j2, j4);
            if (!v2.f7252s || v2.f7250f.length() == v2.f7251fb) {
                break;
            }
            mg();
        }
        return v2;
    }

    public final void f3(r rVar) {
        ArrayList<y.n3> arrayList = this.f7312v.get(rVar.y);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).n3(this, rVar);
            }
        }
        this.f7310n3.n3(this, rVar);
    }

    @Override // di.y
    public synchronized void fb(c5 c5Var) {
        v5.y.fb(!this.f7309i9);
        rz(c5Var);
    }

    public synchronized void fh(String str) {
        v5.y.fb(!this.f7309i9);
        for (c5 c5Var : p(str)) {
            rz(c5Var);
        }
    }

    @Override // di.y
    public synchronized long gv(String str, long j2, long j4) {
        long j6;
        long j7;
        long j8 = Long.MAX_VALUE;
        if (j4 == -1) {
            j6 = Long.MAX_VALUE;
        } else {
            j6 = j4 + j2;
        }
        if (j6 >= 0) {
            j8 = j6;
        }
        j7 = 0;
        while (j2 < j8) {
            long a2 = a(str, j2, j8 - j2);
            if (a2 > 0) {
                j7 += a2;
            } else {
                a2 = -a2;
            }
            j2 += a2;
        }
        return j7;
    }

    @Override // di.y
    public synchronized void i9(File file, long j2) throws y.C0084y {
        boolean z2 = false;
        v5.y.fb(!this.f7309i9);
        if (!file.exists()) {
            return;
        }
        if (j2 == 0) {
            file.delete();
            return;
        }
        r rVar = (r) v5.y.v(r.a(file, j2, this.f7313zn));
        f fVar = (f) v5.y.v(this.f7313zn.fb(rVar.y));
        v5.y.fb(fVar.s(rVar.f7254v, rVar.f7251fb));
        long y2 = tl.y(fVar.gv());
        if (y2 != -1) {
            if (rVar.f7254v + rVar.f7251fb <= y2) {
                z2 = true;
            }
            v5.y.fb(z2);
        }
        if (this.f7308gv != null) {
            try {
                this.f7308gv.s(file.getName(), rVar.f7251fb, rVar.f7253t);
            } catch (IOException e2) {
                throw new y.C0084y(e2);
            }
        }
        tl(rVar);
        try {
            this.f7313zn.z();
            notifyAll();
        } catch (IOException e3) {
            throw new y.C0084y(e3);
        }
    }

    public final void mg() {
        ArrayList arrayList = new ArrayList();
        for (f fVar : this.f7313zn.s()) {
            Iterator<r> it = fVar.a().iterator();
            while (it.hasNext()) {
                r next = it.next();
                if (next.f7250f.length() != next.f7251fb) {
                    arrayList.add(next);
                }
            }
        }
        for (int i = 0; i < arrayList.size(); i++) {
            rz((c5) arrayList.get(i));
        }
    }

    public synchronized Set<String> mt() {
        v5.y.fb(!this.f7309i9);
        return new HashSet(this.f7313zn.t());
    }

    public final void n(c5 c5Var) {
        ArrayList<y.n3> arrayList = this.f7312v.get(c5Var.y);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).y(this, c5Var);
            }
        }
        this.f7310n3.y(this, c5Var);
    }

    @Override // di.y
    public synchronized void n3(c5 c5Var) {
        v5.y.fb(!this.f7309i9);
        f fVar = (f) v5.y.v(this.f7313zn.fb(c5Var.y));
        fVar.tl(c5Var.f7254v);
        this.f7313zn.p(fVar.f7256n3);
        notifyAll();
    }

    public synchronized NavigableSet<c5> p(String str) {
        TreeSet treeSet;
        try {
            v5.y.fb(!this.f7309i9);
            f fb2 = this.f7313zn.fb(str);
            if (fb2 != null && !fb2.fb()) {
                treeSet = new TreeSet((Collection) fb2.a());
            }
            treeSet = new TreeSet();
        } catch (Throwable th) {
            throw th;
        }
        return treeSet;
    }

    public final void r(File file, boolean z2, @Nullable File[] fileArr, @Nullable Map<String, v> map) {
        v vVar;
        long j2;
        long j4;
        if (fileArr != null && fileArr.length != 0) {
            for (File file2 : fileArr) {
                String name = file2.getName();
                if (z2 && name.indexOf(46) == -1) {
                    r(file2, false, file2.listFiles(), map);
                } else if (!z2 || (!t.w(name) && !name.endsWith(".uid"))) {
                    if (map != null) {
                        vVar = map.remove(name);
                    } else {
                        vVar = null;
                    }
                    if (vVar != null) {
                        j4 = vVar.y;
                        j2 = vVar.f7299n3;
                    } else {
                        j2 = -9223372036854775807L;
                        j4 = -1;
                    }
                    r v2 = r.v(file2, j4, j2, this.f7313zn);
                    if (v2 != null) {
                        tl(v2);
                    } else {
                        file2.delete();
                    }
                }
            }
        } else if (!z2) {
            file.delete();
        }
    }

    public final void rz(c5 c5Var) {
        f fb2 = this.f7313zn.fb(c5Var.y);
        if (fb2 != null && fb2.f(c5Var)) {
            this.f7305c5 -= c5Var.f7251fb;
            if (this.f7308gv != null) {
                String name = c5Var.f7250f.getName();
                try {
                    this.f7308gv.a(name);
                } catch (IOException unused) {
                    v5.r.c5("SimpleCache", "Failed to remove file index entry for: " + name);
                }
            }
            this.f7313zn.p(fb2.f7256n3);
            n(c5Var);
        }
    }

    @Override // di.y
    public synchronized void s(String str, xc xcVar) throws y.C0084y {
        v5.y.fb(!this.f7309i9);
        wz();
        this.f7313zn.v(str, xcVar);
        try {
            this.f7313zn.z();
        } catch (IOException e2) {
            throw new y.C0084y(e2);
        }
    }

    public final r ta(String str, r rVar) {
        boolean z2;
        if (!this.f7307fb) {
            return rVar;
        }
        String name = ((File) v5.y.v(rVar.f7250f)).getName();
        long j2 = rVar.f7251fb;
        long currentTimeMillis = System.currentTimeMillis();
        a aVar = this.f7308gv;
        if (aVar != null) {
            try {
                aVar.s(name, j2, currentTimeMillis);
            } catch (IOException unused) {
                v5.r.c5("SimpleCache", "Failed to update index with new touch timestamp.");
            }
            z2 = false;
        } else {
            z2 = true;
        }
        r t2 = this.f7313zn.fb(str).t(rVar, currentTimeMillis, z2);
        c(rVar, t2);
        return t2;
    }

    public final void tl(r rVar) {
        this.f7313zn.wz(rVar.y).y(rVar);
        this.f7305c5 += rVar.f7251fb;
        f3(rVar);
    }

    @Override // di.y
    @Nullable
    public synchronized c5 v(String str, long j2, long j4) throws y.C0084y {
        v5.y.fb(!this.f7309i9);
        wz();
        r co2 = co(str, j2, j4);
        if (co2.f7252s) {
            return ta(str, co2);
        } else if (this.f7313zn.wz(str).i9(j2, co2.f7251fb)) {
            return co2;
        } else {
            return null;
        }
    }

    public synchronized void wz() throws y.C0084y {
        y.C0084y c0084y = this.f7306f;
        if (c0084y != null) {
            throw c0084y;
        }
    }

    @Override // di.y
    public synchronized File y(String str, long j2, long j4) throws y.C0084y {
        f fb2;
        File file;
        try {
            v5.y.fb(!this.f7309i9);
            wz();
            fb2 = this.f7313zn.fb(str);
            v5.y.v(fb2);
            v5.y.fb(fb2.s(j2, j4));
            if (!this.y.exists()) {
                xc(this.y);
                mg();
            }
            this.f7310n3.gv(this, str, j2, j4);
            file = new File(this.y, Integer.toString(this.f7304a.nextInt(10)));
            if (!file.exists()) {
                xc(file);
            }
        } catch (Throwable th) {
            throw th;
        }
        return r.c5(file, fb2.y, j2, System.currentTimeMillis());
    }

    public final void z() {
        if (!this.y.exists()) {
            try {
                xc(this.y);
            } catch (y.C0084y e2) {
                this.f7306f = e2;
                return;
            }
        }
        File[] listFiles = this.y.listFiles();
        if (listFiles == null) {
            String str = "Failed to list cache directory files: " + this.y;
            v5.r.zn("SimpleCache", str);
            this.f7306f = new y.C0084y(str);
            return;
        }
        long x42 = x4(listFiles);
        this.f7311s = x42;
        if (x42 == -1) {
            try {
                this.f7311s = w(this.y);
            } catch (IOException e3) {
                String str2 = "Failed to create cache UID: " + this.y;
                v5.r.gv("SimpleCache", str2, e3);
                this.f7306f = new y.C0084y(str2, e3);
                return;
            }
        }
        try {
            this.f7313zn.xc(this.f7311s);
            a aVar = this.f7308gv;
            if (aVar != null) {
                aVar.v(this.f7311s);
                Map<String, v> n32 = this.f7308gv.n3();
                r(this.y, true, listFiles, n32);
                this.f7308gv.fb(n32.keySet());
            } else {
                r(this.y, true, listFiles, null);
            }
            this.f7313zn.co();
            try {
                this.f7313zn.z();
            } catch (IOException e5) {
                v5.r.gv("SimpleCache", "Storing index file failed", e5);
            }
        } catch (IOException e6) {
            String str3 = "Failed to initialize cache indices: " + this.y;
            v5.r.gv("SimpleCache", str3, e6);
            this.f7306f = new y.C0084y(str3, e6);
        }
    }

    @Override // di.y
    public synchronized wz zn(String str) {
        v5.y.fb(!this.f7309i9);
        return this.f7313zn.i9(str);
    }

    public z(File file, gv gvVar, @Nullable da.n3 n3Var, @Nullable byte[] bArr, boolean z2, boolean z3) {
        this(file, gvVar, new t(n3Var, file, bArr, z2, z3), (n3Var == null || z3) ? null : new a(n3Var));
    }

    public z(File file, gv gvVar, t tVar, @Nullable a aVar) {
        if (i4(file)) {
            this.y = file;
            this.f7310n3 = gvVar;
            this.f7313zn = tVar;
            this.f7308gv = aVar;
            this.f7312v = new HashMap<>();
            this.f7304a = new Random();
            this.f7307fb = gvVar.zn();
            this.f7311s = -1L;
            ConditionVariable conditionVariable = new ConditionVariable();
            new y("ExoPlayer:SimpleCacheInit", conditionVariable).start();
            conditionVariable.block();
            return;
        }
        throw new IllegalStateException("Another SimpleCache instance uses the folder: " + file);
    }
}
