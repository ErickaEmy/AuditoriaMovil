package m0;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import androidx.annotation.NonNull;
import j0.f3;
import j0.j5;
import j0.r;
import j0.x4;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import n0.en;
import n0.fh;
import n0.j;
import n0.oz;
/* loaded from: classes.dex */
public class y {

    /* renamed from: v  reason: collision with root package name */
    public static final AtomicReference f10563v = new AtomicReference(null);

    /* renamed from: gv  reason: collision with root package name */
    public final n3 f10564gv;

    /* renamed from: n3  reason: collision with root package name */
    public final fh f10565n3;
    public final a y;

    /* renamed from: zn  reason: collision with root package name */
    public final Set f10566zn = new HashSet();

    public y(Context context) {
        try {
            a aVar = new a(context);
            this.y = aVar;
            this.f10564gv = new n3(aVar);
            this.f10565n3 = new fh(context);
        } catch (PackageManager.NameNotFoundException e2) {
            throw new j5("Failed to initialize FileStorage", e2);
        }
    }

    public static boolean a(Context context) {
        return f(context, true);
    }

    public static boolean f(final Context context, boolean z2) {
        if (t()) {
            return false;
        }
        AtomicReference atomicReference = f10563v;
        boolean y = y5.w.y(atomicReference, null, new y(context));
        y yVar = (y) atomicReference.get();
        if (y) {
            n0.j5.INSTANCE.y(new j0.co(context, v.y(), new r(context, yVar.y, new j0.p()), yVar.y, new co(), null));
            j.n3(new w(yVar));
            v.y().execute(new Runnable() { // from class: m0.xc
                @Override // java.lang.Runnable
                public final void run() {
                    Context context2 = context;
                    AtomicReference atomicReference2 = y.f10563v;
                    try {
                        en.s(context2).gv(true);
                    } catch (SecurityException unused) {
                        Log.e("SplitCompat", "Failed to set broadcast receiver to always on.");
                    }
                }
            });
        }
        try {
            yVar.i9(context, z2);
            return true;
        } catch (Exception e2) {
            Log.e("SplitCompat", "Error installing additional splits", e2);
            return false;
        }
    }

    public static boolean fb() {
        if (f10563v.get() != null) {
            return true;
        }
        return false;
    }

    public static boolean n3(@NonNull Context context) {
        if (t()) {
            return false;
        }
        y yVar = (y) f10563v.get();
        if (yVar == null) {
            if (context.getApplicationContext() != null) {
                y(context.getApplicationContext());
            }
            return y(context);
        }
        return yVar.f10564gv.n3(context, yVar.s());
    }

    public static boolean t() {
        return false;
    }

    public static boolean y(@NonNull Context context) {
        return f(context, false);
    }

    public final void c5(Set set) throws IOException {
        Iterator it = set.iterator();
        while (it.hasNext()) {
            a.t(this.y.fb((String) it.next()));
        }
        this.f10565n3.n3();
    }

    public final synchronized void i9(Context context, boolean z2) throws IOException {
        List<String> asList;
        ZipFile zipFile;
        try {
            if (z2) {
                this.y.f();
            } else {
                v.y().execute(new p(this));
            }
            String packageName = context.getPackageName();
            try {
                String[] strArr = context.getPackageManager().getPackageInfo(packageName, 0).splitNames;
                if (strArr == null) {
                    asList = new ArrayList();
                } else {
                    asList = Arrays.asList(strArr);
                }
                Set<z> i92 = this.y.i9();
                Set y = this.f10565n3.y();
                HashSet hashSet = new HashSet();
                Iterator it = i92.iterator();
                while (it.hasNext()) {
                    String n32 = ((z) it.next()).n3();
                    if (asList.contains(n32) || y.contains(oz.n3(n32))) {
                        hashSet.add(n32);
                        it.remove();
                    }
                }
                if (z2) {
                    c5(hashSet);
                } else if (!hashSet.isEmpty()) {
                    v.y().execute(new mt(this, hashSet));
                }
                HashSet hashSet2 = new HashSet();
                for (z zVar : i92) {
                    String n33 = zVar.n3();
                    if (!oz.a(n33)) {
                        hashSet2.add(n33);
                    }
                }
                for (String str : asList) {
                    if (!oz.a(str)) {
                        hashSet2.add(str);
                    }
                }
                HashSet<z> hashSet3 = new HashSet(i92.size());
                for (z zVar2 : i92) {
                    if (oz.v(zVar2.n3()) || hashSet2.contains(oz.n3(zVar2.n3()))) {
                        hashSet3.add(zVar2);
                    }
                }
                wz wzVar = new wz(this.y);
                x4 y2 = f3.y();
                ClassLoader classLoader = context.getClassLoader();
                if (z2) {
                    y2.n3(classLoader, wzVar.zn());
                } else {
                    Iterator it2 = hashSet3.iterator();
                    while (it2.hasNext()) {
                        Set n34 = wzVar.n3((z) it2.next());
                        if (n34 == null) {
                            it2.remove();
                        } else {
                            y2.n3(classLoader, n34);
                        }
                    }
                }
                HashSet hashSet4 = new HashSet();
                for (z zVar3 : hashSet3) {
                    try {
                        zipFile = new ZipFile(zVar3.y());
                    } catch (IOException e2) {
                        e = e2;
                        zipFile = null;
                    }
                    try {
                        ZipEntry entry = zipFile.getEntry("classes.dex");
                        zipFile.close();
                        if (entry != null && !y2.y(classLoader, this.y.y(zVar3.n3()), zVar3.y(), z2)) {
                            Log.w("SplitCompat", "split was not installed ".concat(zVar3.y().toString()));
                        }
                        hashSet4.add(zVar3.y());
                    } catch (IOException e3) {
                        e = e3;
                        if (zipFile != null) {
                            try {
                                zipFile.close();
                            } catch (IOException unused) {
                            }
                        }
                        throw e;
                    }
                }
                this.f10564gv.y(context, hashSet4);
                HashSet hashSet5 = new HashSet();
                for (z zVar4 : hashSet3) {
                    if (hashSet4.contains(zVar4.y())) {
                        new StringBuilder(zVar4.n3().length() + 30);
                        hashSet5.add(zVar4.n3());
                    } else {
                        new StringBuilder(zVar4.n3().length() + 35);
                    }
                }
                synchronized (this.f10566zn) {
                    this.f10566zn.addAll(hashSet5);
                }
            } catch (PackageManager.NameNotFoundException e5) {
                throw new IOException(String.format("Cannot load data for application '%s'", packageName), e5);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final Set s() {
        HashSet hashSet;
        synchronized (this.f10566zn) {
            hashSet = new HashSet(this.f10566zn);
        }
        return hashSet;
    }
}
