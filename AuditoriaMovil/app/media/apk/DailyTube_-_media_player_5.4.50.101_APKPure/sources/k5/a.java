package k5;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import k5.fb;
/* loaded from: classes.dex */
public class a {
    public static final z.a<String, Typeface> y = new z.a<>(16);

    /* renamed from: n3  reason: collision with root package name */
    public static final ExecutorService f9572n3 = s.y("fonts-androidx", 10, 10000);

    /* renamed from: zn  reason: collision with root package name */
    public static final Object f9573zn = new Object();

    /* renamed from: gv  reason: collision with root package name */
    public static final z.s<String, ArrayList<vl.y<v>>> f9571gv = new z.s<>();

    /* loaded from: classes.dex */
    public class gv implements vl.y<v> {
        public final /* synthetic */ String y;

        public gv(String str) {
            this.y = str;
        }

        @Override // vl.y
        /* renamed from: y */
        public void accept(v vVar) {
            synchronized (a.f9573zn) {
                try {
                    z.s<String, ArrayList<vl.y<v>>> sVar = a.f9571gv;
                    ArrayList<vl.y<v>> arrayList = sVar.get(this.y);
                    if (arrayList == null) {
                        return;
                    }
                    sVar.remove(this.y);
                    for (int i = 0; i < arrayList.size(); i++) {
                        arrayList.get(i).accept(vVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class n3 implements vl.y<v> {
        public final /* synthetic */ k5.y y;

        public n3(k5.y yVar) {
            this.y = yVar;
        }

        @Override // vl.y
        /* renamed from: y */
        public void accept(v vVar) {
            if (vVar == null) {
                vVar = new v(-3);
            }
            this.y.n3(vVar);
        }
    }

    /* loaded from: classes.dex */
    public class y implements Callable<v> {

        /* renamed from: fb  reason: collision with root package name */
        public final /* synthetic */ k5.v f9575fb;

        /* renamed from: s  reason: collision with root package name */
        public final /* synthetic */ int f9576s;

        /* renamed from: v  reason: collision with root package name */
        public final /* synthetic */ Context f9577v;
        public final /* synthetic */ String y;

        public y(String str, Context context, k5.v vVar, int i) {
            this.y = str;
            this.f9577v = context;
            this.f9575fb = vVar;
            this.f9576s = i;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: y */
        public v call() {
            return a.zn(this.y, this.f9577v, this.f9575fb, this.f9576s);
        }
    }

    /* loaded from: classes.dex */
    public class zn implements Callable<v> {

        /* renamed from: fb  reason: collision with root package name */
        public final /* synthetic */ k5.v f9578fb;

        /* renamed from: s  reason: collision with root package name */
        public final /* synthetic */ int f9579s;

        /* renamed from: v  reason: collision with root package name */
        public final /* synthetic */ Context f9580v;
        public final /* synthetic */ String y;

        public zn(String str, Context context, k5.v vVar, int i) {
            this.y = str;
            this.f9580v = context;
            this.f9578fb = vVar;
            this.f9579s = i;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: y */
        public v call() {
            try {
                return a.zn(this.y, this.f9580v, this.f9578fb, this.f9579s);
            } catch (Throwable unused) {
                return new v(-3);
            }
        }
    }

    public static Typeface gv(@NonNull Context context, @NonNull k5.v vVar, int i, @Nullable Executor executor, @NonNull k5.y yVar) {
        String y2 = y(vVar, i);
        Typeface typeface = y.get(y2);
        if (typeface != null) {
            yVar.n3(new v(typeface));
            return typeface;
        }
        n3 n3Var = new n3(yVar);
        synchronized (f9573zn) {
            try {
                z.s<String, ArrayList<vl.y<v>>> sVar = f9571gv;
                ArrayList<vl.y<v>> arrayList = sVar.get(y2);
                if (arrayList != null) {
                    arrayList.add(n3Var);
                    return null;
                }
                ArrayList<vl.y<v>> arrayList2 = new ArrayList<>();
                arrayList2.add(n3Var);
                sVar.put(y2, arrayList2);
                zn znVar = new zn(y2, context, vVar, i);
                if (executor == null) {
                    executor = f9572n3;
                }
                s.n3(executor, znVar, new gv(y2));
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @SuppressLint({"WrongConstant"})
    public static int n3(@NonNull fb.y yVar) {
        int i = 1;
        if (yVar.zn() != 0) {
            if (yVar.zn() != 1) {
                return -3;
            }
            return -2;
        }
        fb.n3[] n32 = yVar.n3();
        if (n32 != null && n32.length != 0) {
            i = 0;
            for (fb.n3 n3Var : n32) {
                int n33 = n3Var.n3();
                if (n33 != 0) {
                    if (n33 < 0) {
                        return -3;
                    }
                    return n33;
                }
            }
        }
        return i;
    }

    public static Typeface v(@NonNull Context context, @NonNull k5.v vVar, @NonNull k5.y yVar, int i, int i5) {
        String y2 = y(vVar, i);
        Typeface typeface = y.get(y2);
        if (typeface != null) {
            yVar.n3(new v(typeface));
            return typeface;
        } else if (i5 == -1) {
            v zn2 = zn(y2, context, vVar, i);
            yVar.n3(zn2);
            return zn2.y;
        } else {
            try {
                v vVar2 = (v) s.zn(f9572n3, new y(y2, context, vVar, i), i5);
                yVar.n3(vVar2);
                return vVar2.y;
            } catch (InterruptedException unused) {
                yVar.n3(new v(-3));
                return null;
            }
        }
    }

    public static String y(@NonNull k5.v vVar, int i) {
        return vVar.gv() + "-" + i;
    }

    @NonNull
    public static v zn(@NonNull String str, @NonNull Context context, @NonNull k5.v vVar, int i) {
        z.a<String, Typeface> aVar = y;
        Typeface typeface = aVar.get(str);
        if (typeface != null) {
            return new v(typeface);
        }
        try {
            fb.y v2 = k5.gv.v(context, vVar, null);
            int n32 = n3(v2);
            if (n32 != 0) {
                return new v(n32);
            }
            Typeface n33 = z6.gv.n3(context, null, v2.n3(), i);
            if (n33 != null) {
                aVar.put(str, n33);
                return new v(n33);
            }
            return new v(-3);
        } catch (PackageManager.NameNotFoundException unused) {
            return new v(-1);
        }
    }

    /* loaded from: classes.dex */
    public static final class v {

        /* renamed from: n3  reason: collision with root package name */
        public final int f9574n3;
        public final Typeface y;

        public v(int i) {
            this.f9574n3 = i;
        }

        @SuppressLint({"WrongConstant"})
        public boolean y() {
            if (this.f9574n3 == 0) {
                return true;
            }
            return false;
        }

        @SuppressLint({"WrongConstant"})
        public v(@NonNull Typeface typeface) {
            this.y = typeface;
        }
    }
}
