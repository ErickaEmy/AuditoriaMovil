package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.work.impl.background.systemalarm.gv;
import java.util.ArrayList;
import java.util.List;
import l.f;
import le.w;
/* loaded from: classes.dex */
public class n3 {

    /* renamed from: v  reason: collision with root package name */
    public static final String f3714v = f.a("ConstraintsCmdHandler");

    /* renamed from: gv  reason: collision with root package name */
    public final w2.gv f3715gv;

    /* renamed from: n3  reason: collision with root package name */
    public final int f3716n3;
    public final Context y;

    /* renamed from: zn  reason: collision with root package name */
    public final gv f3717zn;

    public n3(@NonNull Context context, int i, @NonNull gv gvVar) {
        this.y = context;
        this.f3716n3 = i;
        this.f3717zn = gvVar;
        this.f3715gv = new w2.gv(context, gvVar.a(), null);
    }

    public void y() {
        List<w> n32 = this.f3717zn.fb().co().f().n3();
        ConstraintProxy.y(this.y, n32);
        this.f3715gv.gv(n32);
        ArrayList<w> arrayList = new ArrayList(n32.size());
        long currentTimeMillis = System.currentTimeMillis();
        for (w wVar : n32) {
            String str = wVar.y;
            if (currentTimeMillis >= wVar.y() && (!wVar.n3() || this.f3715gv.zn(str))) {
                arrayList.add(wVar);
            }
        }
        for (w wVar2 : arrayList) {
            String str2 = wVar2.y;
            Intent n33 = y.n3(this.y, str2);
            f.zn().y(f3714v, String.format("Creating a delay_met command for workSpec with id (%s)", str2), new Throwable[0]);
            gv gvVar = this.f3717zn;
            gvVar.f(new gv.n3(gvVar, n33, this.f3716n3));
        }
        this.f3715gv.v();
    }
}
