package g3;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import u0.fb;
/* loaded from: classes.dex */
public final class n3 extends y {
    public final Function1<fb, Unit> y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public n3(int i, int i5, Function1<? super fb, Unit> migrateCallback) {
        super(i, i5);
        Intrinsics.checkNotNullParameter(migrateCallback, "migrateCallback");
        this.y = migrateCallback;
    }

    @Override // g3.y
    public void migrate(fb database) {
        Intrinsics.checkNotNullParameter(database, "database");
        this.y.invoke(database);
    }
}
