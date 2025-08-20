package rb;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public abstract class f<T> extends z6 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(i4 database) {
        super(database);
        Intrinsics.checkNotNullParameter(database, "database");
    }

    public abstract void bind(u0.f fVar, T t2);

    public final void insert(T t2) {
        u0.f acquire = acquire();
        try {
            bind(acquire, t2);
            acquire.en();
        } finally {
            release(acquire);
        }
    }

    public final long insertAndReturnId(T t2) {
        u0.f acquire = acquire();
        try {
            bind(acquire, t2);
            return acquire.en();
        } finally {
            release(acquire);
        }
    }

    public final long[] insertAndReturnIdsArray(Collection<? extends T> entities) {
        Intrinsics.checkNotNullParameter(entities, "entities");
        u0.f acquire = acquire();
        try {
            long[] jArr = new long[entities.size()];
            int i = 0;
            for (T t2 : entities) {
                int i5 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                bind(acquire, t2);
                jArr[i] = acquire.en();
                i = i5;
            }
            release(acquire);
            return jArr;
        } catch (Throwable th) {
            release(acquire);
            throw th;
        }
    }

    public final Long[] insertAndReturnIdsArrayBox(Collection<? extends T> entities) {
        Intrinsics.checkNotNullParameter(entities, "entities");
        u0.f acquire = acquire();
        Iterator<? extends T> it = entities.iterator();
        try {
            int size = entities.size();
            Long[] lArr = new Long[size];
            for (int i = 0; i < size; i++) {
                bind(acquire, it.next());
                lArr[i] = Long.valueOf(acquire.en());
            }
            return lArr;
        } finally {
            release(acquire);
        }
    }

    public final List<Long> insertAndReturnIdsList(T[] entities) {
        Intrinsics.checkNotNullParameter(entities, "entities");
        u0.f acquire = acquire();
        try {
            List createListBuilder = CollectionsKt.createListBuilder();
            for (T t2 : entities) {
                bind(acquire, t2);
                createListBuilder.add(Long.valueOf(acquire.en()));
            }
            List<Long> build = CollectionsKt.build(createListBuilder);
            release(acquire);
            return build;
        } catch (Throwable th) {
            release(acquire);
            throw th;
        }
    }

    public final void insert(T[] entities) {
        Intrinsics.checkNotNullParameter(entities, "entities");
        u0.f acquire = acquire();
        try {
            for (T t2 : entities) {
                bind(acquire, t2);
                acquire.en();
            }
        } finally {
            release(acquire);
        }
    }

    public final long[] insertAndReturnIdsArray(T[] entities) {
        Intrinsics.checkNotNullParameter(entities, "entities");
        u0.f acquire = acquire();
        try {
            long[] jArr = new long[entities.length];
            int length = entities.length;
            int i = 0;
            int i5 = 0;
            while (i < length) {
                int i6 = i5 + 1;
                bind(acquire, entities[i]);
                jArr[i5] = acquire.en();
                i++;
                i5 = i6;
            }
            return jArr;
        } finally {
            release(acquire);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Long[] insertAndReturnIdsArrayBox(T[] entities) {
        Intrinsics.checkNotNullParameter(entities, "entities");
        u0.f acquire = acquire();
        Iterator it = ArrayIteratorKt.iterator(entities);
        try {
            int length = entities.length;
            Long[] lArr = new Long[length];
            for (int i = 0; i < length; i++) {
                bind(acquire, it.next());
                lArr[i] = Long.valueOf(acquire.en());
            }
            return lArr;
        } finally {
            release(acquire);
        }
    }

    public final List<Long> insertAndReturnIdsList(Collection<? extends T> entities) {
        Intrinsics.checkNotNullParameter(entities, "entities");
        u0.f acquire = acquire();
        try {
            List createListBuilder = CollectionsKt.createListBuilder();
            for (T t2 : entities) {
                bind(acquire, t2);
                createListBuilder.add(Long.valueOf(acquire.en()));
            }
            List<Long> build = CollectionsKt.build(createListBuilder);
            release(acquire);
            return build;
        } catch (Throwable th) {
            release(acquire);
            throw th;
        }
    }

    public final void insert(Iterable<? extends T> entities) {
        Intrinsics.checkNotNullParameter(entities, "entities");
        u0.f acquire = acquire();
        try {
            for (T t2 : entities) {
                bind(acquire, t2);
                acquire.en();
            }
        } finally {
            release(acquire);
        }
    }
}
