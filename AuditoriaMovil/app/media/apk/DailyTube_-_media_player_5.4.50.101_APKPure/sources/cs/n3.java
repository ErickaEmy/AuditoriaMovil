package cs;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import androidx.work.n3;
import java.util.List;
import l.wz;
import le.w;
/* loaded from: classes.dex */
public class n3 implements Runnable {

    /* renamed from: fb  reason: collision with root package name */
    public static final String f6866fb = l.f.a("EnqueueRunnable");

    /* renamed from: v  reason: collision with root package name */
    public final gq.zn f6867v = new gq.zn();
    public final gq.fb y;

    public n3(@NonNull gq.fb fbVar) {
        this.y = fbVar;
    }

    public static void fb(w wVar) {
        l.n3 n3Var = wVar.f10336i9;
        String str = wVar.f10347zn;
        if (!str.equals(ConstraintTrackingWorker.class.getName())) {
            if (n3Var.a() || n3Var.c5()) {
                n3.y yVar = new n3.y();
                yVar.zn(wVar.f10343v).v("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME", str);
                wVar.f10347zn = ConstraintTrackingWorker.class.getName();
                wVar.f10343v = yVar.y();
            }
        }
    }

    public static boolean n3(@NonNull gq.fb fbVar) {
        boolean zn2 = zn(fbVar.fb(), fbVar.a(), (String[]) gq.fb.t(fbVar).toArray(new String[0]), fbVar.gv(), fbVar.n3());
        fbVar.f();
        return zn2;
    }

    public static boolean s(@NonNull gq.c5 c5Var, @NonNull String str) {
        try {
            Class<?> cls = Class.forName(str);
            for (gq.v vVar : c5Var.mt()) {
                if (cls.isAssignableFrom(vVar.getClass())) {
                    return true;
                }
            }
        } catch (ClassNotFoundException unused) {
        }
        return false;
    }

    public static boolean v(@NonNull gq.fb fbVar) {
        List<gq.fb> v2 = fbVar.v();
        boolean z2 = false;
        if (v2 != null) {
            boolean z3 = false;
            for (gq.fb fbVar2 : v2) {
                if (!fbVar2.i9()) {
                    z3 |= v(fbVar2);
                } else {
                    l.f.zn().s(f6866fb, String.format("Already enqueued work ids (%s).", TextUtils.join(", ", fbVar2.zn())), new Throwable[0]);
                }
            }
            z2 = z3;
        }
        return n3(fbVar) | z2;
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01d7 A[LOOP:5: B:119:0x01d1->B:121:0x01d7, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0201 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x014c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean zn(gq.c5 r19, @androidx.annotation.NonNull java.util.List<? extends l.x4> r20, java.lang.String[] r21, java.lang.String r22, l.v r23) {
        /*
            Method dump skipped, instructions count: 520
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cs.n3.zn(gq.c5, java.util.List, java.lang.String[], java.lang.String, l.v):boolean");
    }

    public void a() {
        gq.c5 fb2 = this.y.fb();
        gq.a.n3(fb2.tl(), fb2.co(), fb2.mt());
    }

    @NonNull
    public l.wz gv() {
        return this.f6867v;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (!this.y.s()) {
                if (y()) {
                    gv.y(this.y.fb().t(), RescheduleReceiver.class, true);
                    a();
                }
                this.f6867v.y(l.wz.y);
                return;
            }
            throw new IllegalStateException(String.format("WorkContinuation has cycles (%s)", this.y));
        } catch (Throwable th) {
            this.f6867v.y(new wz.n3.y(th));
        }
    }

    public boolean y() {
        WorkDatabase co2 = this.y.fb().co();
        co2.beginTransaction();
        try {
            boolean v2 = v(this.y);
            co2.setTransactionSuccessful();
            return v2;
        } finally {
            co2.endTransaction();
        }
    }
}
