package rb;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.CancellationSignal;
import android.os.Looper;
import android.util.Log;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import u0.s;
/* loaded from: classes.dex */
public abstract class i4 {
    public static final zn Companion = new zn(null);
    private boolean allowMainThreadQueries;
    private rb.zn autoCloser;
    private final Map<String, Object> backingFieldMap;
    private u0.s internalOpenHelper;
    private Executor internalQueryExecutor;
    private Executor internalTransactionExecutor;
    protected List<? extends n3> mCallbacks;
    protected volatile u0.fb mDatabase;
    private final Map<Class<?>, Object> typeConverters;
    private boolean writeAheadLoggingEnabled;
    private final p invalidationTracker = createInvalidationTracker();
    private Map<Class<Object>, Object> autoMigrationSpecs = new LinkedHashMap();
    private final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private final ThreadLocal<Integer> suspendingTransactionId = new ThreadLocal<>();

    /* loaded from: classes.dex */
    public static abstract class a {
    }

    /* loaded from: classes.dex */
    public static final class fb extends Lambda implements Function1<u0.fb, Object> {
        public fb() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: y */
        public final Object invoke(u0.fb it) {
            Intrinsics.checkNotNullParameter(it, "it");
            i4.this.internalBeginTransaction();
            return null;
        }
    }

    /* loaded from: classes.dex */
    public enum gv {
        AUTOMATIC,
        TRUNCATE,
        WRITE_AHEAD_LOGGING;

        public final boolean gv(ActivityManager activityManager) {
            return u0.zn.n3(activityManager);
        }

        public final gv v(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (this != AUTOMATIC) {
                return this;
            }
            Object systemService = context.getSystemService("activity");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
            if (!gv((ActivityManager) systemService)) {
                return WRITE_AHEAD_LOGGING;
            }
            return TRUNCATE;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class n3 {
        public void n3(u0.fb db) {
            Intrinsics.checkNotNullParameter(db, "db");
        }

        public void y(u0.fb db) {
            Intrinsics.checkNotNullParameter(db, "db");
        }

        public void zn(u0.fb db) {
            Intrinsics.checkNotNullParameter(db, "db");
        }
    }

    /* loaded from: classes.dex */
    public static final class s extends Lambda implements Function1<u0.fb, Object> {
        public s() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: y */
        public final Object invoke(u0.fb it) {
            Intrinsics.checkNotNullParameter(it, "it");
            i4.this.internalEndTransaction();
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static class v {
        public final Map<Integer, TreeMap<Integer, g3.y>> y = new LinkedHashMap();

        public Map<Integer, Map<Integer, g3.y>> a() {
            return this.y;
        }

        public List<g3.y> gv(int i, int i5) {
            boolean z2;
            if (i == i5) {
                return CollectionsKt.emptyList();
            }
            if (i5 > i) {
                z2 = true;
            } else {
                z2 = false;
            }
            return v(new ArrayList(), z2, i, i5);
        }

        public void n3(g3.y... migrations) {
            Intrinsics.checkNotNullParameter(migrations, "migrations");
            for (g3.y yVar : migrations) {
                y(yVar);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:32:0x0016 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0017  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.util.List<g3.y> v(java.util.List<g3.y> r7, boolean r8, int r9, int r10) {
            /*
                r6 = this;
            L0:
                if (r8 == 0) goto L5
                if (r9 >= r10) goto L63
                goto L7
            L5:
                if (r9 <= r10) goto L63
            L7:
                java.util.Map<java.lang.Integer, java.util.TreeMap<java.lang.Integer, g3.y>> r0 = r6.y
                java.lang.Integer r1 = java.lang.Integer.valueOf(r9)
                java.lang.Object r0 = r0.get(r1)
                java.util.TreeMap r0 = (java.util.TreeMap) r0
                r1 = 0
                if (r0 != 0) goto L17
                return r1
            L17:
                if (r8 == 0) goto L1e
                java.util.NavigableSet r2 = r0.descendingKeySet()
                goto L22
            L1e:
                java.util.Set r2 = r0.keySet()
            L22:
                java.util.Iterator r2 = r2.iterator()
            L26:
                boolean r3 = r2.hasNext()
                if (r3 == 0) goto L5f
                java.lang.Object r3 = r2.next()
                java.lang.Integer r3 = (java.lang.Integer) r3
                java.lang.String r4 = "targetVersion"
                if (r8 == 0) goto L44
                int r5 = r9 + 1
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
                int r4 = r3.intValue()
                if (r5 > r4) goto L26
                if (r4 > r10) goto L26
                goto L4f
            L44:
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
                int r4 = r3.intValue()
                if (r10 > r4) goto L26
                if (r4 >= r9) goto L26
            L4f:
                java.lang.Object r9 = r0.get(r3)
                kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
                r7.add(r9)
                int r9 = r3.intValue()
                r0 = 1
                goto L60
            L5f:
                r0 = 0
            L60:
                if (r0 != 0) goto L0
                return r1
            L63:
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: rb.i4.v.v(java.util.List, boolean, int, int):java.util.List");
        }

        public final void y(g3.y yVar) {
            int i = yVar.startVersion;
            int i5 = yVar.endVersion;
            Map<Integer, TreeMap<Integer, g3.y>> map = this.y;
            Integer valueOf = Integer.valueOf(i);
            TreeMap<Integer, g3.y> treeMap = map.get(valueOf);
            if (treeMap == null) {
                treeMap = new TreeMap<>();
                map.put(valueOf, treeMap);
            }
            TreeMap<Integer, g3.y> treeMap2 = treeMap;
            if (treeMap2.containsKey(Integer.valueOf(i5))) {
                Log.w("ROOM", "Overriding migration " + treeMap2.get(Integer.valueOf(i5)) + " with " + yVar);
            }
            treeMap2.put(Integer.valueOf(i5), yVar);
        }

        public final boolean zn(int i, int i5) {
            Map<Integer, Map<Integer, g3.y>> a2 = a();
            if (a2.containsKey(Integer.valueOf(i))) {
                Map<Integer, g3.y> map = a2.get(Integer.valueOf(i));
                if (map == null) {
                    map = MapsKt.emptyMap();
                }
                return map.containsKey(Integer.valueOf(i5));
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public static class y<T extends i4> {

        /* renamed from: a  reason: collision with root package name */
        public List<Object> f13172a;

        /* renamed from: c5  reason: collision with root package name */
        public s.zn f13173c5;

        /* renamed from: co  reason: collision with root package name */
        public Set<Integer> f13174co;

        /* renamed from: f  reason: collision with root package name */
        public gv f13175f;

        /* renamed from: fb  reason: collision with root package name */
        public Executor f13176fb;

        /* renamed from: gv  reason: collision with root package name */
        public final List<n3> f13177gv;

        /* renamed from: i9  reason: collision with root package name */
        public boolean f13178i9;

        /* renamed from: mt  reason: collision with root package name */
        public Set<Integer> f13179mt;

        /* renamed from: n3  reason: collision with root package name */
        public final Class<T> f13180n3;

        /* renamed from: p  reason: collision with root package name */
        public final v f13181p;

        /* renamed from: r  reason: collision with root package name */
        public File f13182r;

        /* renamed from: s  reason: collision with root package name */
        public Executor f13183s;

        /* renamed from: t  reason: collision with root package name */
        public Intent f13184t;

        /* renamed from: tl  reason: collision with root package name */
        public boolean f13185tl;

        /* renamed from: v  reason: collision with root package name */
        public final List<Object> f13186v;

        /* renamed from: w  reason: collision with root package name */
        public TimeUnit f13187w;

        /* renamed from: wz  reason: collision with root package name */
        public boolean f13188wz;

        /* renamed from: x4  reason: collision with root package name */
        public Callable<InputStream> f13189x4;

        /* renamed from: xc  reason: collision with root package name */
        public long f13190xc;
        public final Context y;

        /* renamed from: z  reason: collision with root package name */
        public String f13191z;

        /* renamed from: zn  reason: collision with root package name */
        public final String f13192zn;

        public y(Context context, Class<T> klass, String str) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(klass, "klass");
            this.y = context;
            this.f13180n3 = klass;
            this.f13192zn = str;
            this.f13177gv = new ArrayList();
            this.f13186v = new ArrayList();
            this.f13172a = new ArrayList();
            this.f13175f = gv.AUTOMATIC;
            this.f13185tl = true;
            this.f13190xc = -1L;
            this.f13181p = new v();
            this.f13179mt = new LinkedHashSet();
        }

        public y<T> a() {
            this.f13185tl = true;
            this.f13188wz = true;
            return this;
        }

        public y<T> fb(s.zn znVar) {
            this.f13173c5 = znVar;
            return this;
        }

        public T gv() {
            int i;
            int i5;
            Executor executor = this.f13176fb;
            if (executor == null && this.f13183s == null) {
                Executor v2 = xc.y.v();
                this.f13183s = v2;
                this.f13176fb = v2;
            } else if (executor != null && this.f13183s == null) {
                this.f13183s = executor;
            } else if (executor == null) {
                this.f13176fb = this.f13183s;
            }
            Set<Integer> set = this.f13174co;
            if (set != null) {
                Intrinsics.checkNotNull(set);
                for (Integer num : set) {
                    int intValue = num.intValue();
                    if (this.f13179mt.contains(Integer.valueOf(intValue))) {
                        throw new IllegalArgumentException(("Inconsistency detected. A Migration was supplied to addMigration(Migration... migrations) that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(int... startVersions). Start version: " + intValue).toString());
                    }
                }
            }
            rb.v vVar = this.f13173c5;
            if (vVar == null) {
                vVar = new bk.a();
            }
            if (vVar != null) {
                if (this.f13190xc > 0) {
                    if (this.f13192zn != null) {
                        long j2 = this.f13190xc;
                        TimeUnit timeUnit = this.f13187w;
                        if (timeUnit != null) {
                            Executor executor2 = this.f13176fb;
                            if (executor2 != null) {
                                vVar = new rb.v(vVar, new rb.zn(j2, timeUnit, executor2));
                            } else {
                                throw new IllegalArgumentException("Required value was null.");
                            }
                        } else {
                            throw new IllegalArgumentException("Required value was null.");
                        }
                    } else {
                        throw new IllegalArgumentException("Cannot create auto-closing database for an in-memory database.");
                    }
                }
                String str = this.f13191z;
                if (str != null || this.f13182r != null || this.f13189x4 != null) {
                    if (this.f13192zn != null) {
                        int i6 = 0;
                        if (str == null) {
                            i = 0;
                        } else {
                            i = 1;
                        }
                        File file = this.f13182r;
                        if (file == null) {
                            i5 = 0;
                        } else {
                            i5 = 1;
                        }
                        Callable<InputStream> callable = this.f13189x4;
                        if (callable != null) {
                            i6 = 1;
                        }
                        if (i + i5 + i6 == 1) {
                            vVar = new d(str, file, callable, vVar);
                        } else {
                            throw new IllegalArgumentException("More than one of createFromAsset(), createFromInputStream(), and createFromFile() were called on this Builder, but the database can only be created using one of the three configurations.");
                        }
                    } else {
                        throw new IllegalArgumentException("Cannot create from asset or file for an in-memory database.");
                    }
                }
            } else {
                vVar = null;
            }
            d dVar = vVar;
            if (dVar != null) {
                Context context = this.y;
                String str2 = this.f13192zn;
                v vVar2 = this.f13181p;
                List<n3> list = this.f13177gv;
                boolean z2 = this.f13178i9;
                gv v3 = this.f13175f.v(context);
                Executor executor3 = this.f13176fb;
                if (executor3 != null) {
                    Executor executor4 = this.f13183s;
                    if (executor4 != null) {
                        rb.s sVar = new rb.s(context, str2, dVar, vVar2, list, z2, v3, executor3, executor4, this.f13184t, this.f13185tl, this.f13188wz, this.f13179mt, this.f13191z, this.f13182r, this.f13189x4, null, this.f13186v, this.f13172a);
                        T t2 = (T) x4.n3(this.f13180n3, "_Impl");
                        t2.init(sVar);
                        return t2;
                    }
                    throw new IllegalArgumentException("Required value was null.");
                }
                throw new IllegalArgumentException("Required value was null.");
            }
            throw new IllegalArgumentException("Required value was null.");
        }

        public y<T> n3(g3.y... migrations) {
            Intrinsics.checkNotNullParameter(migrations, "migrations");
            if (this.f13174co == null) {
                this.f13174co = new HashSet();
            }
            for (g3.y yVar : migrations) {
                Set<Integer> set = this.f13174co;
                Intrinsics.checkNotNull(set);
                set.add(Integer.valueOf(yVar.startVersion));
                Set<Integer> set2 = this.f13174co;
                Intrinsics.checkNotNull(set2);
                set2.add(Integer.valueOf(yVar.endVersion));
            }
            this.f13181p.n3((g3.y[]) Arrays.copyOf(migrations, migrations.length));
            return this;
        }

        public y<T> s(Executor executor) {
            Intrinsics.checkNotNullParameter(executor, "executor");
            this.f13176fb = executor;
            return this;
        }

        public y<T> v() {
            this.f13185tl = false;
            this.f13188wz = true;
            return this;
        }

        public y<T> y(n3 callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.f13177gv.add(callback);
            return this;
        }

        public y<T> zn() {
            this.f13178i9 = true;
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static final class zn {
        public /* synthetic */ zn(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public zn() {
        }
    }

    public i4() {
        Map<String, Object> synchronizedMap = Collections.synchronizedMap(new LinkedHashMap());
        Intrinsics.checkNotNullExpressionValue(synchronizedMap, "synchronizedMap(mutableMapOf())");
        this.backingFieldMap = synchronizedMap;
        this.typeConverters = new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void internalBeginTransaction() {
        assertNotMainThread();
        u0.fb writableDatabase = getOpenHelper().getWritableDatabase();
        getInvalidationTracker().i4(writableDatabase);
        if (writableDatabase.gq()) {
            writableDatabase.rz();
        } else {
            writableDatabase.fb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void internalEndTransaction() {
        getOpenHelper().getWritableDatabase().z6();
        if (!inTransaction()) {
            getInvalidationTracker().wz();
        }
    }

    public static /* synthetic */ Cursor query$default(i4 i4Var, u0.i9 i9Var, CancellationSignal cancellationSignal, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                cancellationSignal = null;
            }
            return i4Var.query(i9Var, cancellationSignal);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: query");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final <T> T unwrapOpenHelper(Class<T> cls, u0.s sVar) {
        if (cls.isInstance(sVar)) {
            return sVar;
        }
        if (sVar instanceof c5) {
            return (T) unwrapOpenHelper(cls, ((c5) sVar).y());
        }
        return null;
    }

    public void assertNotMainThread() {
        if (this.allowMainThreadQueries || !isMainThread$room_runtime_release()) {
            return;
        }
        throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
    }

    public void assertNotSuspendingTransaction() {
        if (!inTransaction() && this.suspendingTransactionId.get() != null) {
            throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.");
        }
    }

    public void beginTransaction() {
        assertNotMainThread();
        rb.zn znVar = this.autoCloser;
        if (znVar == null) {
            internalBeginTransaction();
        } else {
            znVar.fb(new fb());
        }
    }

    public abstract void clearAllTables();

    public void close() {
        if (isOpen()) {
            ReentrantReadWriteLock.WriteLock writeLock = this.readWriteLock.writeLock();
            Intrinsics.checkNotNullExpressionValue(writeLock, "readWriteLock.writeLock()");
            writeLock.lock();
            try {
                getInvalidationTracker().z();
                getOpenHelper().close();
            } finally {
                writeLock.unlock();
            }
        }
    }

    public u0.f compileStatement(String sql) {
        Intrinsics.checkNotNullParameter(sql, "sql");
        assertNotMainThread();
        assertNotSuspendingTransaction();
        return getOpenHelper().getWritableDatabase().rs(sql);
    }

    public abstract p createInvalidationTracker();

    public abstract u0.s createOpenHelper(rb.s sVar);

    public void endTransaction() {
        rb.zn znVar = this.autoCloser;
        if (znVar == null) {
            internalEndTransaction();
        } else {
            znVar.fb(new s());
        }
    }

    public final Map<Class<Object>, Object> getAutoMigrationSpecs() {
        return this.autoMigrationSpecs;
    }

    public List<g3.y> getAutoMigrations(Map<Class<Object>, Object> autoMigrationSpecs) {
        Intrinsics.checkNotNullParameter(autoMigrationSpecs, "autoMigrationSpecs");
        return CollectionsKt.emptyList();
    }

    public final Map<String, Object> getBackingFieldMap() {
        return this.backingFieldMap;
    }

    public final Lock getCloseLock$room_runtime_release() {
        ReentrantReadWriteLock.ReadLock readLock = this.readWriteLock.readLock();
        Intrinsics.checkNotNullExpressionValue(readLock, "readWriteLock.readLock()");
        return readLock;
    }

    public p getInvalidationTracker() {
        return this.invalidationTracker;
    }

    public u0.s getOpenHelper() {
        u0.s sVar = this.internalOpenHelper;
        if (sVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("internalOpenHelper");
            return null;
        }
        return sVar;
    }

    public Executor getQueryExecutor() {
        Executor executor = this.internalQueryExecutor;
        if (executor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("internalQueryExecutor");
            return null;
        }
        return executor;
    }

    public Set<Class<Object>> getRequiredAutoMigrationSpecs() {
        return SetsKt.emptySet();
    }

    public Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        return MapsKt.emptyMap();
    }

    public final ThreadLocal<Integer> getSuspendingTransactionId() {
        return this.suspendingTransactionId;
    }

    public Executor getTransactionExecutor() {
        Executor executor = this.internalTransactionExecutor;
        if (executor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("internalTransactionExecutor");
            return null;
        }
        return executor;
    }

    public <T> T getTypeConverter(Class<T> klass) {
        Intrinsics.checkNotNullParameter(klass, "klass");
        return (T) this.typeConverters.get(klass);
    }

    public boolean inTransaction() {
        return getOpenHelper().getWritableDatabase().xb();
    }

    public void init(rb.s configuration) {
        boolean z2 = false;
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        this.internalOpenHelper = createOpenHelper(configuration);
        Set<Class<Object>> requiredAutoMigrationSpecs = getRequiredAutoMigrationSpecs();
        BitSet bitSet = new BitSet();
        for (Class<Object> cls : requiredAutoMigrationSpecs) {
            int size = configuration.f13248mt.size() - 1;
            if (size >= 0) {
                while (true) {
                    int i = size - 1;
                    if (cls.isAssignableFrom(configuration.f13248mt.get(size).getClass())) {
                        bitSet.set(size);
                        break;
                    } else if (i < 0) {
                        break;
                    } else {
                        size = i;
                    }
                }
            }
            size = -1;
            if (size >= 0) {
                this.autoMigrationSpecs.put(cls, configuration.f13248mt.get(size));
            } else {
                throw new IllegalArgumentException(("A required auto migration spec (" + cls.getCanonicalName() + ") is missing in the database configuration.").toString());
            }
        }
        int size2 = configuration.f13248mt.size() - 1;
        if (size2 >= 0) {
            while (true) {
                int i5 = size2 - 1;
                if (bitSet.get(size2)) {
                    if (i5 < 0) {
                        break;
                    }
                    size2 = i5;
                } else {
                    throw new IllegalArgumentException("Unexpected auto migration specs found. Annotate AutoMigrationSpec implementation with @ProvidedAutoMigrationSpec annotation or remove this spec from the builder.");
                }
            }
        }
        for (g3.y yVar : getAutoMigrations(this.autoMigrationSpecs)) {
            if (!configuration.f13246gv.zn(yVar.startVersion, yVar.endVersion)) {
                configuration.f13246gv.n3(yVar);
            }
        }
        ta taVar = (ta) unwrapOpenHelper(ta.class, getOpenHelper());
        if (taVar != null) {
            taVar.p(configuration);
        }
        rb.gv gvVar = (rb.gv) unwrapOpenHelper(rb.gv.class, getOpenHelper());
        if (gvVar != null) {
            this.autoCloser = gvVar.f13165v;
            getInvalidationTracker().p(gvVar.f13165v);
        }
        if (configuration.f13245fb == gv.WRITE_AHEAD_LOGGING) {
            z2 = true;
        }
        getOpenHelper().setWriteAheadLoggingEnabled(z2);
        this.mCallbacks = configuration.f13254v;
        this.internalQueryExecutor = configuration.f13251s;
        this.internalTransactionExecutor = new a8(configuration.f13242c5);
        this.allowMainThreadQueries = configuration.f13241a;
        this.writeAheadLoggingEnabled = z2;
        if (configuration.f13247i9 != null) {
            if (configuration.f13249n3 != null) {
                getInvalidationTracker().mt(configuration.y, configuration.f13249n3, configuration.f13247i9);
            } else {
                throw new IllegalArgumentException("Required value was null.");
            }
        }
        Map<Class<?>, List<Class<?>>> requiredTypeConverters = getRequiredTypeConverters();
        BitSet bitSet2 = new BitSet();
        for (Map.Entry<Class<?>, List<Class<?>>> entry : requiredTypeConverters.entrySet()) {
            Class<?> key = entry.getKey();
            for (Class<?> cls2 : entry.getValue()) {
                int size3 = configuration.f13250p.size() - 1;
                if (size3 >= 0) {
                    while (true) {
                        int i6 = size3 - 1;
                        if (cls2.isAssignableFrom(configuration.f13250p.get(size3).getClass())) {
                            bitSet2.set(size3);
                            break;
                        } else if (i6 < 0) {
                            break;
                        } else {
                            size3 = i6;
                        }
                    }
                }
                size3 = -1;
                if (size3 >= 0) {
                    this.typeConverters.put(cls2, configuration.f13250p.get(size3));
                } else {
                    throw new IllegalArgumentException(("A required type converter (" + cls2 + ") for " + key.getCanonicalName() + " is missing in the database configuration.").toString());
                }
            }
        }
        int size4 = configuration.f13250p.size() - 1;
        if (size4 < 0) {
            return;
        }
        while (true) {
            int i8 = size4 - 1;
            if (bitSet2.get(size4)) {
                if (i8 >= 0) {
                    size4 = i8;
                } else {
                    return;
                }
            } else {
                throw new IllegalArgumentException("Unexpected type converter " + configuration.f13250p.get(size4) + ". Annotate TypeConverter class with @ProvidedTypeConverter annotation or remove this converter from the builder.");
            }
        }
    }

    public void internalInitInvalidationTracker(u0.fb db) {
        Intrinsics.checkNotNullParameter(db, "db");
        getInvalidationTracker().f(db);
    }

    public final boolean isMainThread$room_runtime_release() {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            return true;
        }
        return false;
    }

    public boolean isOpen() {
        Boolean bool;
        boolean isOpen;
        rb.zn znVar = this.autoCloser;
        if (znVar != null) {
            isOpen = znVar.t();
        } else {
            u0.fb fbVar = this.mDatabase;
            if (fbVar != null) {
                isOpen = fbVar.isOpen();
            } else {
                bool = null;
                return Intrinsics.areEqual(bool, Boolean.TRUE);
            }
        }
        bool = Boolean.valueOf(isOpen);
        return Intrinsics.areEqual(bool, Boolean.TRUE);
    }

    public final Cursor query(u0.i9 query) {
        Intrinsics.checkNotNullParameter(query, "query");
        return query$default(this, query, null, 2, null);
    }

    public void runInTransaction(Runnable body) {
        Intrinsics.checkNotNullParameter(body, "body");
        beginTransaction();
        try {
            body.run();
            setTransactionSuccessful();
        } finally {
            endTransaction();
        }
    }

    public final void setAutoMigrationSpecs(Map<Class<Object>, Object> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.autoMigrationSpecs = map;
    }

    public void setTransactionSuccessful() {
        getOpenHelper().getWritableDatabase().d0();
    }

    public Cursor query(String query, Object[] objArr) {
        Intrinsics.checkNotNullParameter(query, "query");
        return getOpenHelper().getWritableDatabase().y4(new u0.y(query, objArr));
    }

    public Cursor query(u0.i9 query, CancellationSignal cancellationSignal) {
        Intrinsics.checkNotNullParameter(query, "query");
        assertNotMainThread();
        assertNotSuspendingTransaction();
        if (cancellationSignal != null) {
            return getOpenHelper().getWritableDatabase().ra(query, cancellationSignal);
        }
        return getOpenHelper().getWritableDatabase().y4(query);
    }

    public <V> V runInTransaction(Callable<V> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        beginTransaction();
        try {
            V call = body.call();
            setTransactionSuccessful();
            return call;
        } finally {
            endTransaction();
        }
    }

    public static /* synthetic */ void getMCallbacks$annotations() {
    }

    public static /* synthetic */ void getMDatabase$annotations() {
    }

    public static /* synthetic */ void isOpen$annotations() {
    }
}
