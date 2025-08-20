package vp;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import cs.a;
import gq.c5;
import gq.v;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import l.f;
import l.z;
import le.w;
import w2.gv;
import w2.zn;
/* loaded from: classes.dex */
public class n3 implements v, zn, gq.n3 {

    /* renamed from: co  reason: collision with root package name */
    public static final String f14480co = f.a("GreedyScheduler");

    /* renamed from: f  reason: collision with root package name */
    public y f14481f;

    /* renamed from: fb  reason: collision with root package name */
    public final gv f14482fb;

    /* renamed from: p  reason: collision with root package name */
    public Boolean f14483p;

    /* renamed from: t  reason: collision with root package name */
    public boolean f14485t;

    /* renamed from: v  reason: collision with root package name */
    public final c5 f14486v;
    public final Context y;

    /* renamed from: s  reason: collision with root package name */
    public final Set<w> f14484s = new HashSet();

    /* renamed from: w  reason: collision with root package name */
    public final Object f14487w = new Object();

    public n3(@NonNull Context context, @NonNull androidx.work.y yVar, @NonNull ix.y yVar2, @NonNull c5 c5Var) {
        this.y = context;
        this.f14486v = c5Var;
        this.f14482fb = new gv(context, yVar2, this);
        this.f14481f = new y(this, yVar.f());
    }

    public final void a() {
        this.f14483p = Boolean.valueOf(a.n3(this.y, this.f14486v.tl()));
    }

    @Override // gq.v
    public void cancel(@NonNull String str) {
        if (this.f14483p == null) {
            a();
        }
        if (!this.f14483p.booleanValue()) {
            f.zn().gv(f14480co, "Ignoring schedule request in non-main process", new Throwable[0]);
            return;
        }
        fb();
        f.zn().y(f14480co, String.format("Cancelling work ID %s", str), new Throwable[0]);
        y yVar = this.f14481f;
        if (yVar != null) {
            yVar.n3(str);
        }
        this.f14486v.fh(str);
    }

    public final void fb() {
        if (!this.f14485t) {
            this.f14486v.p().zn(this);
            this.f14485t = true;
        }
    }

    @Override // gq.n3
    public void gv(@NonNull String str, boolean z2) {
        s(str);
    }

    @Override // w2.zn
    public void n3(@NonNull List<String> list) {
        for (String str : list) {
            f.zn().y(f14480co, String.format("Constraints not met: Cancelling work ID %s", str), new Throwable[0]);
            this.f14486v.fh(str);
        }
    }

    public final void s(@NonNull String str) {
        synchronized (this.f14487w) {
            try {
                Iterator<w> it = this.f14484s.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    w next = it.next();
                    if (next.y.equals(str)) {
                        f.zn().y(f14480co, String.format("Stopping tracking for %s", str), new Throwable[0]);
                        this.f14484s.remove(next);
                        this.f14482fb.gv(this.f14484s);
                        break;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // w2.zn
    public void v(@NonNull List<String> list) {
        for (String str : list) {
            f.zn().y(f14480co, String.format("Constraints met: Scheduling work ID %s", str), new Throwable[0]);
            this.f14486v.n(str);
        }
    }

    @Override // gq.v
    public void y(@NonNull w... wVarArr) {
        if (this.f14483p == null) {
            a();
        }
        if (!this.f14483p.booleanValue()) {
            f.zn().gv(f14480co, "Ignoring schedule request in a secondary process", new Throwable[0]);
            return;
        }
        fb();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (w wVar : wVarArr) {
            long y = wVar.y();
            long currentTimeMillis = System.currentTimeMillis();
            if (wVar.f10338n3 == z.y.ENQUEUED) {
                if (currentTimeMillis < y) {
                    y yVar = this.f14481f;
                    if (yVar != null) {
                        yVar.y(wVar);
                    }
                } else if (wVar.n3()) {
                    int i = Build.VERSION.SDK_INT;
                    if (i >= 23 && wVar.f10336i9.s()) {
                        f.zn().y(f14480co, String.format("Ignoring WorkSpec %s, Requires device idle.", wVar), new Throwable[0]);
                    } else if (i >= 24 && wVar.f10336i9.v()) {
                        f.zn().y(f14480co, String.format("Ignoring WorkSpec %s, Requires ContentUri triggers.", wVar), new Throwable[0]);
                    } else {
                        hashSet.add(wVar);
                        hashSet2.add(wVar.y);
                    }
                } else {
                    f.zn().y(f14480co, String.format("Starting work for %s", wVar.y), new Throwable[0]);
                    this.f14486v.n(wVar.y);
                }
            }
        }
        synchronized (this.f14487w) {
            try {
                if (!hashSet.isEmpty()) {
                    f.zn().y(f14480co, String.format("Starting tracking for [%s]", TextUtils.join(",", hashSet2)), new Throwable[0]);
                    this.f14484s.addAll(hashSet);
                    this.f14482fb.gv(this.f14484s);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // gq.v
    public boolean zn() {
        return false;
    }
}
