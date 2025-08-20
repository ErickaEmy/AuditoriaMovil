package rb;

import androidx.lifecycle.LiveData;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class xc {

    /* renamed from: n3  reason: collision with root package name */
    public final Set<LiveData<?>> f13270n3;
    public final i4 y;

    public xc(i4 database) {
        Intrinsics.checkNotNullParameter(database, "database");
        this.y = database;
        Set<LiveData<?>> newSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
        Intrinsics.checkNotNullExpressionValue(newSetFromMap, "newSetFromMap(IdentityHashMap())");
        this.f13270n3 = newSetFromMap;
    }

    public final void n3(LiveData<?> liveData) {
        Intrinsics.checkNotNullParameter(liveData, "liveData");
        this.f13270n3.add(liveData);
    }

    public final <T> LiveData<T> y(String[] tableNames, boolean z2, Callable<T> computeFunction) {
        Intrinsics.checkNotNullParameter(tableNames, "tableNames");
        Intrinsics.checkNotNullParameter(computeFunction, "computeFunction");
        return new rz(this.y, this, z2, computeFunction, tableNames);
    }

    public final void zn(LiveData<?> liveData) {
        Intrinsics.checkNotNullParameter(liveData, "liveData");
        this.f13270n3.remove(liveData);
    }
}
