package oa;

import android.content.Context;
import androidx.annotation.NonNull;
import gq.v;
import l.f;
import le.w;
/* loaded from: classes.dex */
public class n3 implements v {

    /* renamed from: v  reason: collision with root package name */
    public static final String f12241v = f.a("SystemAlarmScheduler");
    public final Context y;

    public n3(@NonNull Context context) {
        this.y = context.getApplicationContext();
    }

    @Override // gq.v
    public void cancel(@NonNull String str) {
        this.y.startService(androidx.work.impl.background.systemalarm.y.fb(this.y, str));
    }

    public final void n3(@NonNull w wVar) {
        f.zn().y(f12241v, String.format("Scheduling work with workSpecId %s", wVar.y), new Throwable[0]);
        this.y.startService(androidx.work.impl.background.systemalarm.y.a(this.y, wVar.y));
    }

    @Override // gq.v
    public void y(@NonNull w... wVarArr) {
        for (w wVar : wVarArr) {
            n3(wVar);
        }
    }

    @Override // gq.v
    public boolean zn() {
        return true;
    }
}
