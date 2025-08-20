package rb;

import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public abstract class i9<T> extends z6 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i9(i4 database) {
        super(database);
        Intrinsics.checkNotNullParameter(database, "database");
    }

    public abstract void bind(u0.f fVar, T t2);

    @Override // rb.z6
    public abstract String createQuery();

    public final int handle(T t2) {
        u0.f acquire = acquire();
        try {
            bind(acquire, t2);
            return acquire.xc();
        } finally {
            release(acquire);
        }
    }

    public final int handleMultiple(Iterable<? extends T> entities) {
        Intrinsics.checkNotNullParameter(entities, "entities");
        u0.f acquire = acquire();
        try {
            int i = 0;
            for (T t2 : entities) {
                bind(acquire, t2);
                i += acquire.xc();
            }
            return i;
        } finally {
            release(acquire);
        }
    }

    public final int handleMultiple(T[] entities) {
        Intrinsics.checkNotNullParameter(entities, "entities");
        u0.f acquire = acquire();
        try {
            int i = 0;
            for (T t2 : entities) {
                bind(acquire, t2);
                i += acquire.xc();
            }
            return i;
        } finally {
            release(acquire);
        }
    }
}
