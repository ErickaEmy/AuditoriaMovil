package androidx.room;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.LiveData;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.SetsKt__SetsJVMKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
/* compiled from: InvalidationTracker.kt */
/* loaded from: classes.dex */
public class InvalidationTracker {
    public static final Companion Companion = new Companion(null);
    private static final String[] TRIGGERS = {"UPDATE", "DELETE", "INSERT"};
    private AutoCloser autoCloser;
    private volatile SupportSQLiteStatement cleanupStatement;
    private final RoomDatabase database;
    private volatile boolean initialized;
    private final InvalidationLiveDataContainer invalidationLiveDataContainer;
    private MultiInstanceInvalidationClient multiInstanceInvalidationClient;
    private final ObservedTableTracker observedTableTracker;
    private final SafeIterableMap observerMap;
    private final AtomicBoolean pendingRefresh;
    public final Runnable refreshRunnable;
    private final Map shadowTablesMap;
    private final Object syncTriggersLock;
    private final Map tableIdLookup;
    private final String[] tablesNames;
    private final Object trackerLock;
    private final Map viewTables;

    public final SupportSQLiteStatement getCleanupStatement$room_runtime_release() {
        return this.cleanupStatement;
    }

    public final RoomDatabase getDatabase$room_runtime_release() {
        return this.database;
    }

    public final SafeIterableMap getObserverMap$room_runtime_release() {
        return this.observerMap;
    }

    public final AtomicBoolean getPendingRefresh() {
        return this.pendingRefresh;
    }

    public final Map getTableIdLookup$room_runtime_release() {
        return this.tableIdLookup;
    }

    public InvalidationTracker(RoomDatabase database, Map shadowTablesMap, Map viewTables, String... tableNames) {
        Object value;
        String str;
        Intrinsics.checkNotNullParameter(database, "database");
        Intrinsics.checkNotNullParameter(shadowTablesMap, "shadowTablesMap");
        Intrinsics.checkNotNullParameter(viewTables, "viewTables");
        Intrinsics.checkNotNullParameter(tableNames, "tableNames");
        this.database = database;
        this.shadowTablesMap = shadowTablesMap;
        this.viewTables = viewTables;
        this.pendingRefresh = new AtomicBoolean(false);
        this.observedTableTracker = new ObservedTableTracker(tableNames.length);
        this.invalidationLiveDataContainer = new InvalidationLiveDataContainer(database);
        this.observerMap = new SafeIterableMap();
        this.syncTriggersLock = new Object();
        this.trackerLock = new Object();
        this.tableIdLookup = new LinkedHashMap();
        int length = tableNames.length;
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            String str2 = tableNames[i];
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            String lowerCase = str2.toLowerCase(US);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            this.tableIdLookup.put(lowerCase, Integer.valueOf(i));
            String str3 = (String) this.shadowTablesMap.get(tableNames[i]);
            if (str3 != null) {
                Intrinsics.checkNotNullExpressionValue(US, "US");
                str = str3.toLowerCase(US);
                Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String).toLowerCase(locale)");
            } else {
                str = null;
            }
            if (str != null) {
                lowerCase = str;
            }
            strArr[i] = lowerCase;
        }
        this.tablesNames = strArr;
        for (Map.Entry entry : this.shadowTablesMap.entrySet()) {
            Locale US2 = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US2, "US");
            String lowerCase2 = ((String) entry.getValue()).toLowerCase(US2);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
            if (this.tableIdLookup.containsKey(lowerCase2)) {
                Intrinsics.checkNotNullExpressionValue(US2, "US");
                String lowerCase3 = ((String) entry.getKey()).toLowerCase(US2);
                Intrinsics.checkNotNullExpressionValue(lowerCase3, "this as java.lang.String).toLowerCase(locale)");
                Map map = this.tableIdLookup;
                value = MapsKt__MapsKt.getValue(map, lowerCase2);
                map.put(lowerCase3, value);
            }
        }
        this.refreshRunnable = new Runnable() { // from class: androidx.room.InvalidationTracker$refreshRunnable$1
            /* JADX WARN: Code restructure failed: missing block: B:25:0x0080, code lost:
                if (r0 != null) goto L31;
             */
            /* JADX WARN: Code restructure failed: missing block: B:26:0x0082, code lost:
                r0.decrementCountAndScheduleClose();
             */
            /* JADX WARN: Code restructure failed: missing block: B:38:0x00a6, code lost:
                if (r0 == null) goto L32;
             */
            /* JADX WARN: Code restructure failed: missing block: B:42:0x00bd, code lost:
                if (r0 == null) goto L32;
             */
            /* JADX WARN: Code restructure failed: missing block: B:45:0x00c8, code lost:
                if ((!r3.isEmpty()) == false) goto L49;
             */
            /* JADX WARN: Code restructure failed: missing block: B:46:0x00ca, code lost:
                r0 = r5.this$0.getObserverMap$room_runtime_release();
                r1 = r5.this$0;
             */
            /* JADX WARN: Code restructure failed: missing block: B:47:0x00d2, code lost:
                monitor-enter(r0);
             */
            /* JADX WARN: Code restructure failed: missing block: B:48:0x00d3, code lost:
                r1 = r1.getObserverMap$room_runtime_release().iterator();
             */
            /* JADX WARN: Code restructure failed: missing block: B:50:0x00df, code lost:
                if (r1.hasNext() == false) goto L41;
             */
            /* JADX WARN: Code restructure failed: missing block: B:51:0x00e1, code lost:
                ((androidx.room.InvalidationTracker.ObserverWrapper) ((java.util.Map.Entry) r1.next()).getValue()).notifyByTableInvalidStatus$room_runtime_release(r3);
             */
            /* JADX WARN: Code restructure failed: missing block: B:52:0x00f1, code lost:
                r1 = move-exception;
             */
            /* JADX WARN: Code restructure failed: missing block: B:54:0x00f3, code lost:
                r1 = kotlin.Unit.INSTANCE;
             */
            /* JADX WARN: Code restructure failed: missing block: B:55:0x00f5, code lost:
                monitor-exit(r0);
             */
            /* JADX WARN: Code restructure failed: missing block: B:58:0x00f8, code lost:
                throw r1;
             */
            /* JADX WARN: Code restructure failed: missing block: B:59:0x00f9, code lost:
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:73:?, code lost:
                return;
             */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void run() {
                /*
                    Method dump skipped, instructions count: 265
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.room.InvalidationTracker$refreshRunnable$1.run():void");
            }

            private final Set checkUpdatedTable() {
                Set createSetBuilder;
                Set build;
                InvalidationTracker invalidationTracker = InvalidationTracker.this;
                createSetBuilder = SetsKt__SetsJVMKt.createSetBuilder();
                Cursor query$default = RoomDatabase.query$default(invalidationTracker.getDatabase$room_runtime_release(), new SimpleSQLiteQuery("SELECT * FROM room_table_modification_log WHERE invalidated = 1;"), null, 2, null);
                while (query$default.moveToNext()) {
                    try {
                        createSetBuilder.add(Integer.valueOf(query$default.getInt(0)));
                    } finally {
                    }
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(query$default, null);
                build = SetsKt__SetsJVMKt.build(createSetBuilder);
                if (!build.isEmpty()) {
                    if (InvalidationTracker.this.getCleanupStatement$room_runtime_release() == null) {
                        throw new IllegalStateException("Required value was null.".toString());
                    }
                    SupportSQLiteStatement cleanupStatement$room_runtime_release = InvalidationTracker.this.getCleanupStatement$room_runtime_release();
                    if (cleanupStatement$room_runtime_release == null) {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                    cleanupStatement$room_runtime_release.executeUpdateDelete();
                }
                return build;
            }
        };
    }

    public final void setAutoCloser$room_runtime_release(AutoCloser autoCloser) {
        Intrinsics.checkNotNullParameter(autoCloser, "autoCloser");
        this.autoCloser = autoCloser;
        autoCloser.setAutoCloseCallback(new Runnable() { // from class: androidx.room.InvalidationTracker$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                InvalidationTracker.this.onAutoCloseCallback();
            }
        });
    }

    public final void internalInit$room_runtime_release(SupportSQLiteDatabase database) {
        Intrinsics.checkNotNullParameter(database, "database");
        synchronized (this.trackerLock) {
            if (this.initialized) {
                Log.e("ROOM", "Invalidation tracker is initialized twice :/.");
                return;
            }
            database.execSQL("PRAGMA temp_store = MEMORY;");
            database.execSQL("PRAGMA recursive_triggers='ON';");
            database.execSQL("CREATE TEMP TABLE room_table_modification_log (table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)");
            syncTriggers$room_runtime_release(database);
            this.cleanupStatement = database.compileStatement("UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1");
            this.initialized = true;
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onAutoCloseCallback() {
        synchronized (this.trackerLock) {
            this.initialized = false;
            this.observedTableTracker.resetTriggerState();
            SupportSQLiteStatement supportSQLiteStatement = this.cleanupStatement;
            if (supportSQLiteStatement != null) {
                supportSQLiteStatement.close();
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final void startMultiInstanceInvalidation$room_runtime_release(Context context, String name, Intent serviceIntent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(serviceIntent, "serviceIntent");
        this.multiInstanceInvalidationClient = new MultiInstanceInvalidationClient(context, name, serviceIntent, this, this.database.getQueryExecutor());
    }

    public final void stopMultiInstanceInvalidation$room_runtime_release() {
        MultiInstanceInvalidationClient multiInstanceInvalidationClient = this.multiInstanceInvalidationClient;
        if (multiInstanceInvalidationClient != null) {
            multiInstanceInvalidationClient.stop();
        }
        this.multiInstanceInvalidationClient = null;
    }

    private final void stopTrackingTable(SupportSQLiteDatabase supportSQLiteDatabase, int i) {
        String[] strArr;
        String str = this.tablesNames[i];
        for (String str2 : TRIGGERS) {
            String str3 = "DROP TRIGGER IF EXISTS " + Companion.getTriggerName$room_runtime_release(str, str2);
            Intrinsics.checkNotNullExpressionValue(str3, "StringBuilder().apply(builderAction).toString()");
            supportSQLiteDatabase.execSQL(str3);
        }
    }

    private final void startTrackingTable(SupportSQLiteDatabase supportSQLiteDatabase, int i) {
        supportSQLiteDatabase.execSQL("INSERT OR IGNORE INTO room_table_modification_log VALUES(" + i + ", 0)");
        String str = this.tablesNames[i];
        for (String str2 : TRIGGERS) {
            String str3 = "CREATE TEMP TRIGGER IF NOT EXISTS " + Companion.getTriggerName$room_runtime_release(str, str2) + " AFTER " + str2 + " ON `" + str + "` BEGIN UPDATE room_table_modification_log SET invalidated = 1 WHERE table_id = " + i + " AND invalidated = 0; END";
            Intrinsics.checkNotNullExpressionValue(str3, "StringBuilder().apply(builderAction).toString()");
            supportSQLiteDatabase.execSQL(str3);
        }
    }

    public void addObserver(Observer observer) {
        int[] intArray;
        ObserverWrapper observerWrapper;
        Intrinsics.checkNotNullParameter(observer, "observer");
        String[] resolveViews = resolveViews(observer.getTables$room_runtime_release());
        ArrayList arrayList = new ArrayList(resolveViews.length);
        for (String str : resolveViews) {
            Map map = this.tableIdLookup;
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            String lowerCase = str.toLowerCase(US);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            Integer num = (Integer) map.get(lowerCase);
            if (num == null) {
                throw new IllegalArgumentException("There is no table with name " + str);
            }
            arrayList.add(Integer.valueOf(num.intValue()));
        }
        intArray = CollectionsKt___CollectionsKt.toIntArray(arrayList);
        ObserverWrapper observerWrapper2 = new ObserverWrapper(observer, intArray, resolveViews);
        synchronized (this.observerMap) {
            observerWrapper = (ObserverWrapper) this.observerMap.putIfAbsent(observer, observerWrapper2);
        }
        if (observerWrapper == null && this.observedTableTracker.onAdded(Arrays.copyOf(intArray, intArray.length))) {
            syncTriggers$room_runtime_release();
        }
    }

    private final String[] validateAndResolveTableNames(String[] strArr) {
        String[] resolveViews = resolveViews(strArr);
        for (String str : resolveViews) {
            Map map = this.tableIdLookup;
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            String lowerCase = str.toLowerCase(US);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            if (!map.containsKey(lowerCase)) {
                throw new IllegalArgumentException(("There is no table with name " + str).toString());
            }
        }
        return resolveViews;
    }

    private final String[] resolveViews(String[] strArr) {
        Set createSetBuilder;
        Set build;
        createSetBuilder = SetsKt__SetsJVMKt.createSetBuilder();
        for (String str : strArr) {
            Map map = this.viewTables;
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            String lowerCase = str.toLowerCase(US);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            if (map.containsKey(lowerCase)) {
                Map map2 = this.viewTables;
                Intrinsics.checkNotNullExpressionValue(US, "US");
                String lowerCase2 = str.toLowerCase(US);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
                Object obj = map2.get(lowerCase2);
                Intrinsics.checkNotNull(obj);
                createSetBuilder.addAll((Collection) obj);
            } else {
                createSetBuilder.add(str);
            }
        }
        build = SetsKt__SetsJVMKt.build(createSetBuilder);
        return (String[]) build.toArray(new String[0]);
    }

    public void addWeakObserver(Observer observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        addObserver(new WeakObserver(this, observer));
    }

    public void removeObserver(Observer observer) {
        ObserverWrapper observerWrapper;
        Intrinsics.checkNotNullParameter(observer, "observer");
        synchronized (this.observerMap) {
            observerWrapper = (ObserverWrapper) this.observerMap.remove(observer);
        }
        if (observerWrapper != null) {
            ObservedTableTracker observedTableTracker = this.observedTableTracker;
            int[] tableIds$room_runtime_release = observerWrapper.getTableIds$room_runtime_release();
            if (observedTableTracker.onRemoved(Arrays.copyOf(tableIds$room_runtime_release, tableIds$room_runtime_release.length))) {
                syncTriggers$room_runtime_release();
            }
        }
    }

    public final boolean ensureInitialization$room_runtime_release() {
        if (this.database.isOpenInternal()) {
            if (!this.initialized) {
                this.database.getOpenHelper().getWritableDatabase();
            }
            if (this.initialized) {
                return true;
            }
            Log.e("ROOM", "database is not initialized even though it is open");
            return false;
        }
        return false;
    }

    public void refreshVersionsAsync() {
        if (this.pendingRefresh.compareAndSet(false, true)) {
            AutoCloser autoCloser = this.autoCloser;
            if (autoCloser != null) {
                autoCloser.incrementCountAndEnsureDbIsOpen();
            }
            this.database.getQueryExecutor().execute(this.refreshRunnable);
        }
    }

    public final void notifyObserversByTableNames(String... tables) {
        Intrinsics.checkNotNullParameter(tables, "tables");
        synchronized (this.observerMap) {
            try {
                for (Map.Entry entry : this.observerMap) {
                    Intrinsics.checkNotNullExpressionValue(entry, "(observer, wrapper)");
                    ObserverWrapper observerWrapper = (ObserverWrapper) entry.getValue();
                    if (!((Observer) entry.getKey()).isRemote$room_runtime_release()) {
                        observerWrapper.notifyByTableNames$room_runtime_release(tables);
                    }
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void syncTriggers$room_runtime_release(SupportSQLiteDatabase database) {
        Intrinsics.checkNotNullParameter(database, "database");
        if (database.inTransaction()) {
            return;
        }
        try {
            Lock closeLock$room_runtime_release = this.database.getCloseLock$room_runtime_release();
            closeLock$room_runtime_release.lock();
            synchronized (this.syncTriggersLock) {
                int[] tablesToSync = this.observedTableTracker.getTablesToSync();
                if (tablesToSync != null) {
                    Companion.beginTransactionInternal$room_runtime_release(database);
                    try {
                        int length = tablesToSync.length;
                        int i = 0;
                        int i2 = 0;
                        while (i < length) {
                            int i3 = tablesToSync[i];
                            int i4 = i2 + 1;
                            if (i3 == 1) {
                                startTrackingTable(database, i2);
                            } else if (i3 == 2) {
                                stopTrackingTable(database, i2);
                            }
                            i++;
                            i2 = i4;
                        }
                        database.setTransactionSuccessful();
                        database.endTransaction();
                        Unit unit = Unit.INSTANCE;
                        closeLock$room_runtime_release.unlock();
                        return;
                    } catch (Throwable th) {
                        database.endTransaction();
                        throw th;
                    }
                }
                closeLock$room_runtime_release.unlock();
            }
        } catch (SQLiteException e) {
            Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e);
        } catch (IllegalStateException e2) {
            Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e2);
        }
    }

    public final void syncTriggers$room_runtime_release() {
        if (this.database.isOpenInternal()) {
            syncTriggers$room_runtime_release(this.database.getOpenHelper().getWritableDatabase());
        }
    }

    public LiveData createLiveData(String[] tableNames, boolean z, Callable computeFunction) {
        Intrinsics.checkNotNullParameter(tableNames, "tableNames");
        Intrinsics.checkNotNullParameter(computeFunction, "computeFunction");
        return this.invalidationLiveDataContainer.create(validateAndResolveTableNames(tableNames), z, computeFunction);
    }

    /* compiled from: InvalidationTracker.kt */
    /* loaded from: classes.dex */
    public static final class ObserverWrapper {
        private final Observer observer;
        private final Set singleTableSet;
        private final int[] tableIds;
        private final String[] tableNames;

        public final int[] getTableIds$room_runtime_release() {
            return this.tableIds;
        }

        public ObserverWrapper(Observer observer, int[] tableIds, String[] tableNames) {
            Set emptySet;
            Intrinsics.checkNotNullParameter(observer, "observer");
            Intrinsics.checkNotNullParameter(tableIds, "tableIds");
            Intrinsics.checkNotNullParameter(tableNames, "tableNames");
            this.observer = observer;
            this.tableIds = tableIds;
            this.tableNames = tableNames;
            if (!(tableNames.length == 0)) {
                emptySet = SetsKt__SetsJVMKt.setOf(tableNames[0]);
            } else {
                emptySet = SetsKt__SetsKt.emptySet();
            }
            this.singleTableSet = emptySet;
            if (tableIds.length != tableNames.length) {
                throw new IllegalStateException("Check failed.".toString());
            }
        }

        public final void notifyByTableInvalidStatus$room_runtime_release(Set invalidatedTablesIds) {
            Set emptySet;
            Set createSetBuilder;
            Intrinsics.checkNotNullParameter(invalidatedTablesIds, "invalidatedTablesIds");
            int[] iArr = this.tableIds;
            int length = iArr.length;
            if (length != 0) {
                int i = 0;
                if (length == 1) {
                    emptySet = invalidatedTablesIds.contains(Integer.valueOf(iArr[0])) ? this.singleTableSet : SetsKt__SetsKt.emptySet();
                } else {
                    createSetBuilder = SetsKt__SetsJVMKt.createSetBuilder();
                    int[] iArr2 = this.tableIds;
                    int length2 = iArr2.length;
                    int i2 = 0;
                    while (i < length2) {
                        int i3 = i2 + 1;
                        if (invalidatedTablesIds.contains(Integer.valueOf(iArr2[i]))) {
                            createSetBuilder.add(this.tableNames[i2]);
                        }
                        i++;
                        i2 = i3;
                    }
                    emptySet = SetsKt__SetsJVMKt.build(createSetBuilder);
                }
            } else {
                emptySet = SetsKt__SetsKt.emptySet();
            }
            if (!emptySet.isEmpty()) {
                this.observer.onInvalidated(emptySet);
            }
        }

        public final void notifyByTableNames$room_runtime_release(String[] tables) {
            Set emptySet;
            boolean equals;
            Set createSetBuilder;
            String[] strArr;
            boolean equals2;
            Intrinsics.checkNotNullParameter(tables, "tables");
            int length = this.tableNames.length;
            if (length != 0) {
                if (length != 1) {
                    createSetBuilder = SetsKt__SetsJVMKt.createSetBuilder();
                    for (String str : tables) {
                        for (String str2 : this.tableNames) {
                            equals2 = StringsKt__StringsJVMKt.equals(str2, str, true);
                            if (equals2) {
                                createSetBuilder.add(str2);
                            }
                        }
                    }
                    emptySet = SetsKt__SetsJVMKt.build(createSetBuilder);
                } else {
                    int length2 = tables.length;
                    int i = 0;
                    while (true) {
                        if (i < length2) {
                            equals = StringsKt__StringsJVMKt.equals(tables[i], this.tableNames[0], true);
                            if (equals) {
                                emptySet = this.singleTableSet;
                                break;
                            }
                            i++;
                        } else {
                            emptySet = SetsKt__SetsKt.emptySet();
                            break;
                        }
                    }
                }
            } else {
                emptySet = SetsKt__SetsKt.emptySet();
            }
            if (!emptySet.isEmpty()) {
                this.observer.onInvalidated(emptySet);
            }
        }
    }

    /* compiled from: InvalidationTracker.kt */
    /* loaded from: classes.dex */
    public static abstract class Observer {
        private final String[] tables;

        public final String[] getTables$room_runtime_release() {
            return this.tables;
        }

        public boolean isRemote$room_runtime_release() {
            return false;
        }

        public abstract void onInvalidated(Set set);

        public Observer(String[] tables) {
            Intrinsics.checkNotNullParameter(tables, "tables");
            this.tables = tables;
        }
    }

    /* compiled from: InvalidationTracker.kt */
    /* loaded from: classes.dex */
    public static final class ObservedTableTracker {
        public static final Companion Companion = new Companion(null);
        private boolean needsSync;
        private final long[] tableObservers;
        private final int[] triggerStateChanges;
        private final boolean[] triggerStates;

        /* compiled from: InvalidationTracker.kt */
        /* loaded from: classes.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public ObservedTableTracker(int i) {
            this.tableObservers = new long[i];
            this.triggerStates = new boolean[i];
            this.triggerStateChanges = new int[i];
        }

        public final boolean onAdded(int... tableIds) {
            boolean z;
            Intrinsics.checkNotNullParameter(tableIds, "tableIds");
            synchronized (this) {
                try {
                    z = false;
                    for (int i : tableIds) {
                        long[] jArr = this.tableObservers;
                        long j = jArr[i];
                        jArr[i] = 1 + j;
                        if (j == 0) {
                            z = true;
                            this.needsSync = true;
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return z;
        }

        public final boolean onRemoved(int... tableIds) {
            boolean z;
            Intrinsics.checkNotNullParameter(tableIds, "tableIds");
            synchronized (this) {
                try {
                    z = false;
                    for (int i : tableIds) {
                        long[] jArr = this.tableObservers;
                        long j = jArr[i];
                        jArr[i] = j - 1;
                        if (j == 1) {
                            z = true;
                            this.needsSync = true;
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return z;
        }

        public final void resetTriggerState() {
            synchronized (this) {
                Arrays.fill(this.triggerStates, false);
                this.needsSync = true;
                Unit unit = Unit.INSTANCE;
            }
        }

        public final int[] getTablesToSync() {
            synchronized (this) {
                try {
                    if (this.needsSync) {
                        long[] jArr = this.tableObservers;
                        int length = jArr.length;
                        int i = 0;
                        int i2 = 0;
                        while (i < length) {
                            int i3 = i2 + 1;
                            int i4 = 1;
                            boolean z = jArr[i] > 0;
                            boolean[] zArr = this.triggerStates;
                            if (z != zArr[i2]) {
                                int[] iArr = this.triggerStateChanges;
                                if (!z) {
                                    i4 = 2;
                                }
                                iArr[i2] = i4;
                            } else {
                                this.triggerStateChanges[i2] = 0;
                            }
                            zArr[i2] = z;
                            i++;
                            i2 = i3;
                        }
                        this.needsSync = false;
                        return (int[]) this.triggerStateChanges.clone();
                    }
                    return null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* compiled from: InvalidationTracker.kt */
    /* loaded from: classes.dex */
    public static final class WeakObserver extends Observer {
        private final WeakReference delegateRef;
        private final InvalidationTracker tracker;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WeakObserver(InvalidationTracker tracker, Observer delegate) {
            super(delegate.getTables$room_runtime_release());
            Intrinsics.checkNotNullParameter(tracker, "tracker");
            Intrinsics.checkNotNullParameter(delegate, "delegate");
            this.tracker = tracker;
            this.delegateRef = new WeakReference(delegate);
        }

        @Override // androidx.room.InvalidationTracker.Observer
        public void onInvalidated(Set tables) {
            Intrinsics.checkNotNullParameter(tables, "tables");
            Observer observer = (Observer) this.delegateRef.get();
            if (observer == null) {
                this.tracker.removeObserver(this);
            } else {
                observer.onInvalidated(tables);
            }
        }
    }

    /* compiled from: InvalidationTracker.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getTriggerName$room_runtime_release(String tableName, String triggerType) {
            Intrinsics.checkNotNullParameter(tableName, "tableName");
            Intrinsics.checkNotNullParameter(triggerType, "triggerType");
            return "`room_table_modification_trigger_" + tableName + '_' + triggerType + '`';
        }

        public final void beginTransactionInternal$room_runtime_release(SupportSQLiteDatabase database) {
            Intrinsics.checkNotNullParameter(database, "database");
            if (database.isWriteAheadLoggingEnabled()) {
                database.beginTransactionNonExclusive();
            } else {
                database.beginTransaction();
            }
        }
    }
}
