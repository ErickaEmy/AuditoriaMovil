package jq;

import android.content.Context;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class n3 implements h2.zn<Unit> {
    @Override // h2.zn
    public /* bridge */ /* synthetic */ Unit create(Context context) {
        y(context);
        return Unit.INSTANCE;
    }

    @Override // h2.zn
    public List<Class<? extends h2.zn<?>>> dependencies() {
        return CollectionsKt.emptyList();
    }

    public void y(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        sd1.y.y(de1.n3.n3(false, y.y, 1, null));
    }
}
