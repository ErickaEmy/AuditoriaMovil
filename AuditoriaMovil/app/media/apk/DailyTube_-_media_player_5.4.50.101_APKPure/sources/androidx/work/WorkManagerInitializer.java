package androidx.work;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.work.y;
import java.util.Collections;
import java.util.List;
import l.f;
import l.r;
/* loaded from: classes.dex */
public final class WorkManagerInitializer implements tg.n3<r> {
    public static final String y = f.a("WrkMgrInitializer");

    @Override // tg.n3
    @NonNull
    public List<Class<? extends tg.n3<?>>> dependencies() {
        return Collections.emptyList();
    }

    @Override // tg.n3
    @NonNull
    /* renamed from: y */
    public r create(@NonNull Context context) {
        f.zn().y(y, "Initializing WorkManager with default configuration.", new Throwable[0]);
        r.s(context, new y.n3().y());
        return r.fb(context);
    }
}
