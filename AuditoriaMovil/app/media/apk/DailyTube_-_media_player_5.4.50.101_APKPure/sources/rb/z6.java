package rb;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
/* loaded from: classes.dex */
public abstract class z6 {
    private final i4 database;
    private final AtomicBoolean lock;
    private final Lazy stmt$delegate;

    /* loaded from: classes.dex */
    public static final class y extends Lambda implements Function0<u0.f> {
        public y() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: y */
        public final u0.f invoke() {
            return z6.this.createNewStatement();
        }
    }

    public z6(i4 database) {
        Intrinsics.checkNotNullParameter(database, "database");
        this.database = database;
        this.lock = new AtomicBoolean(false);
        this.stmt$delegate = LazyKt.lazy(new y());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final u0.f createNewStatement() {
        return this.database.compileStatement(createQuery());
    }

    private final u0.f getStmt() {
        return (u0.f) this.stmt$delegate.getValue();
    }

    public u0.f acquire() {
        assertNotMainThread();
        return getStmt(this.lock.compareAndSet(false, true));
    }

    public void assertNotMainThread() {
        this.database.assertNotMainThread();
    }

    public abstract String createQuery();

    public void release(u0.f statement) {
        Intrinsics.checkNotNullParameter(statement, "statement");
        if (statement == getStmt()) {
            this.lock.set(false);
        }
    }

    private final u0.f getStmt(boolean z2) {
        if (z2) {
            return getStmt();
        }
        return createNewStatement();
    }
}
