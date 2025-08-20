package bk;

import android.database.sqlite.SQLiteStatement;
import kotlin.jvm.internal.Intrinsics;
import u0.f;
/* loaded from: classes.dex */
public final class s extends fb implements f {

    /* renamed from: v  reason: collision with root package name */
    public final SQLiteStatement f3859v;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(SQLiteStatement delegate) {
        super(delegate);
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.f3859v = delegate;
    }

    @Override // u0.f
    public long en() {
        return this.f3859v.executeInsert();
    }

    @Override // u0.f
    public int xc() {
        return this.f3859v.executeUpdateDelete();
    }
}
