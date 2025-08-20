package rb;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import androidx.lifecycle.LiveData;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* loaded from: classes.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    public rb.zn f13205a;

    /* renamed from: c5  reason: collision with root package name */
    public volatile u0.f f13206c5;

    /* renamed from: f  reason: collision with root package name */
    public final xc f13207f;

    /* renamed from: fb  reason: collision with root package name */
    public final AtomicBoolean f13208fb;

    /* renamed from: gv  reason: collision with root package name */
    public final Map<String, Integer> f13209gv;

    /* renamed from: i9  reason: collision with root package name */
    public final n3 f13210i9;

    /* renamed from: n3  reason: collision with root package name */
    public final Map<String, String> f13211n3;

    /* renamed from: s  reason: collision with root package name */
    public volatile boolean f13212s;

    /* renamed from: t  reason: collision with root package name */
    public final w.n3<zn, gv> f13213t;

    /* renamed from: tl  reason: collision with root package name */
    public z f13214tl;

    /* renamed from: v  reason: collision with root package name */
    public final String[] f13215v;

    /* renamed from: w  reason: collision with root package name */
    public final Runnable f13216w;

    /* renamed from: wz  reason: collision with root package name */
    public final Object f13217wz;

    /* renamed from: xc  reason: collision with root package name */
    public final Object f13218xc;
    public final i4 y;

    /* renamed from: zn  reason: collision with root package name */
    public final Map<String, Set<String>> f13219zn;

    /* renamed from: p  reason: collision with root package name */
    public static final y f13204p = new y(null);

    /* renamed from: mt  reason: collision with root package name */
    public static final String[] f13203mt = {"UPDATE", "DELETE", "INSERT"};

    /* loaded from: classes.dex */
    public static final class a implements Runnable {
        public a() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x0080, code lost:
            if (r0 != null) goto L31;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x0082, code lost:
            r0.v();
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x00a6, code lost:
            if (r0 == null) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x00bd, code lost:
            if (r0 == null) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x00c7, code lost:
            if (r2.isEmpty() != false) goto L49;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x00c9, code lost:
            r0 = r4.y.s();
            r1 = r4.y;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x00d1, code lost:
            monitor-enter(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x00d2, code lost:
            r1 = r1.s().iterator();
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x00de, code lost:
            if (r1.hasNext() == false) goto L41;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x00e0, code lost:
            ((rb.p.gv) ((java.util.Map.Entry) r1.next()).getValue()).n3(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x00f0, code lost:
            r1 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x00f2, code lost:
            r1 = kotlin.Unit.INSTANCE;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x00f4, code lost:
            monitor-exit(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x00f7, code lost:
            throw r1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x00f8, code lost:
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
                Method dump skipped, instructions count: 264
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: rb.p.a.run():void");
        }

        public final Set<Integer> y() {
            p pVar = p.this;
            Set createSetBuilder = SetsKt.createSetBuilder();
            Cursor query$default = i4.query$default(pVar.fb(), new u0.y("SELECT * FROM room_table_modification_log WHERE invalidated = 1;"), null, 2, null);
            try {
                Cursor cursor = query$default;
                while (cursor.moveToNext()) {
                    createSetBuilder.add(Integer.valueOf(cursor.getInt(0)));
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(query$default, null);
                Set<Integer> build = SetsKt.build(createSetBuilder);
                if (!build.isEmpty()) {
                    if (p.this.a() != null) {
                        u0.f a2 = p.this.a();
                        if (a2 != null) {
                            a2.xc();
                        } else {
                            throw new IllegalArgumentException("Required value was null.");
                        }
                    } else {
                        throw new IllegalStateException("Required value was null.");
                    }
                }
                return build;
            } finally {
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class gv {

        /* renamed from: gv  reason: collision with root package name */
        public final Set<String> f13220gv;

        /* renamed from: n3  reason: collision with root package name */
        public final int[] f13221n3;
        public final zn y;

        /* renamed from: zn  reason: collision with root package name */
        public final String[] f13222zn;

        public gv(zn observer, int[] tableIds, String[] tableNames) {
            boolean z2;
            Set<String> emptySet;
            Intrinsics.checkNotNullParameter(observer, "observer");
            Intrinsics.checkNotNullParameter(tableIds, "tableIds");
            Intrinsics.checkNotNullParameter(tableNames, "tableNames");
            this.y = observer;
            this.f13221n3 = tableIds;
            this.f13222zn = tableNames;
            if (tableNames.length == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                emptySet = SetsKt.setOf(tableNames[0]);
            } else {
                emptySet = SetsKt.emptySet();
            }
            this.f13220gv = emptySet;
            if (tableIds.length == tableNames.length) {
                return;
            }
            throw new IllegalStateException("Check failed.");
        }

        public final void n3(Set<Integer> invalidatedTablesIds) {
            Set<String> emptySet;
            Intrinsics.checkNotNullParameter(invalidatedTablesIds, "invalidatedTablesIds");
            int[] iArr = this.f13221n3;
            int length = iArr.length;
            if (length != 0) {
                int i = 0;
                if (length != 1) {
                    Set createSetBuilder = SetsKt.createSetBuilder();
                    int[] iArr2 = this.f13221n3;
                    int length2 = iArr2.length;
                    int i5 = 0;
                    while (i < length2) {
                        int i6 = i5 + 1;
                        if (invalidatedTablesIds.contains(Integer.valueOf(iArr2[i]))) {
                            createSetBuilder.add(this.f13222zn[i5]);
                        }
                        i++;
                        i5 = i6;
                    }
                    emptySet = SetsKt.build(createSetBuilder);
                } else if (invalidatedTablesIds.contains(Integer.valueOf(iArr[0]))) {
                    emptySet = this.f13220gv;
                } else {
                    emptySet = SetsKt.emptySet();
                }
            } else {
                emptySet = SetsKt.emptySet();
            }
            if (!emptySet.isEmpty()) {
                this.y.zn(emptySet);
            }
        }

        public final int[] y() {
            return this.f13221n3;
        }

        public final void zn(String[] tables) {
            Set<String> emptySet;
            String[] strArr;
            Intrinsics.checkNotNullParameter(tables, "tables");
            int length = this.f13222zn.length;
            if (length != 0) {
                if (length != 1) {
                    Set createSetBuilder = SetsKt.createSetBuilder();
                    for (String str : tables) {
                        for (String str2 : this.f13222zn) {
                            if (StringsKt.equals(str2, str, true)) {
                                createSetBuilder.add(str2);
                            }
                        }
                    }
                    emptySet = SetsKt.build(createSetBuilder);
                } else {
                    int length2 = tables.length;
                    int i = 0;
                    while (true) {
                        if (i < length2) {
                            if (StringsKt.equals(tables[i], this.f13222zn[0], true)) {
                                emptySet = this.f13220gv;
                                break;
                            }
                            i++;
                        } else {
                            emptySet = SetsKt.emptySet();
                            break;
                        }
                    }
                }
            } else {
                emptySet = SetsKt.emptySet();
            }
            if (!emptySet.isEmpty()) {
                this.y.zn(emptySet);
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class n3 {

        /* renamed from: v  reason: collision with root package name */
        public static final y f13223v = new y(null);

        /* renamed from: gv  reason: collision with root package name */
        public boolean f13224gv;

        /* renamed from: n3  reason: collision with root package name */
        public final boolean[] f13225n3;
        public final long[] y;

        /* renamed from: zn  reason: collision with root package name */
        public final int[] f13226zn;

        /* loaded from: classes.dex */
        public static final class y {
            public /* synthetic */ y(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public y() {
            }
        }

        public n3(int i) {
            this.y = new long[i];
            this.f13225n3 = new boolean[i];
            this.f13226zn = new int[i];
        }

        public final void gv() {
            synchronized (this) {
                Arrays.fill(this.f13225n3, false);
                this.f13224gv = true;
                Unit unit = Unit.INSTANCE;
            }
        }

        public final boolean n3(int... tableIds) {
            boolean z2;
            Intrinsics.checkNotNullParameter(tableIds, "tableIds");
            synchronized (this) {
                try {
                    z2 = false;
                    for (int i : tableIds) {
                        long[] jArr = this.y;
                        long j2 = jArr[i];
                        jArr[i] = 1 + j2;
                        if (j2 == 0) {
                            this.f13224gv = true;
                            z2 = true;
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return z2;
        }

        public final int[] y() {
            boolean z2;
            synchronized (this) {
                try {
                    if (!this.f13224gv) {
                        return null;
                    }
                    long[] jArr = this.y;
                    int length = jArr.length;
                    int i = 0;
                    int i5 = 0;
                    while (i < length) {
                        int i6 = i5 + 1;
                        int i8 = 1;
                        if (jArr[i] > 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        boolean[] zArr = this.f13225n3;
                        if (z2 != zArr[i5]) {
                            int[] iArr = this.f13226zn;
                            if (!z2) {
                                i8 = 2;
                            }
                            iArr[i5] = i8;
                        } else {
                            this.f13226zn[i5] = 0;
                        }
                        zArr[i5] = z2;
                        i++;
                        i5 = i6;
                    }
                    this.f13224gv = false;
                    return (int[]) this.f13226zn.clone();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final boolean zn(int... tableIds) {
            boolean z2;
            Intrinsics.checkNotNullParameter(tableIds, "tableIds");
            synchronized (this) {
                try {
                    z2 = false;
                    for (int i : tableIds) {
                        long[] jArr = this.y;
                        long j2 = jArr[i];
                        jArr[i] = j2 - 1;
                        if (j2 == 1) {
                            this.f13224gv = true;
                            z2 = true;
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return z2;
        }
    }

    /* loaded from: classes.dex */
    public static final class v extends zn {

        /* renamed from: n3  reason: collision with root package name */
        public final p f13227n3;

        /* renamed from: zn  reason: collision with root package name */
        public final WeakReference<zn> f13228zn;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v(p tracker, zn delegate) {
            super(delegate.y());
            Intrinsics.checkNotNullParameter(tracker, "tracker");
            Intrinsics.checkNotNullParameter(delegate, "delegate");
            this.f13227n3 = tracker;
            this.f13228zn = new WeakReference<>(delegate);
        }

        @Override // rb.p.zn
        public void zn(Set<String> tables) {
            Intrinsics.checkNotNullParameter(tables, "tables");
            zn znVar = this.f13228zn.get();
            if (znVar == null) {
                this.f13227n3.xc(this);
            } else {
                znVar.zn(tables);
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class y {
        public /* synthetic */ y(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String n3(String tableName, String triggerType) {
            Intrinsics.checkNotNullParameter(tableName, "tableName");
            Intrinsics.checkNotNullParameter(triggerType, "triggerType");
            return "`room_table_modification_trigger_" + tableName + '_' + triggerType + '`';
        }

        public final void y(u0.fb database) {
            Intrinsics.checkNotNullParameter(database, "database");
            if (database.gq()) {
                database.rz();
            } else {
                database.fb();
            }
        }

        public y() {
        }
    }

    /* loaded from: classes.dex */
    public static abstract class zn {
        public final String[] y;

        public zn(String[] tables) {
            Intrinsics.checkNotNullParameter(tables, "tables");
            this.y = tables;
        }

        public boolean n3() {
            return false;
        }

        public final String[] y() {
            return this.y;
        }

        public abstract void zn(Set<String> set);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public p(i4 database, Map<String, String> shadowTablesMap, Map<String, Set<String>> viewTables, String... tableNames) {
        String str;
        Intrinsics.checkNotNullParameter(database, "database");
        Intrinsics.checkNotNullParameter(shadowTablesMap, "shadowTablesMap");
        Intrinsics.checkNotNullParameter(viewTables, "viewTables");
        Intrinsics.checkNotNullParameter(tableNames, "tableNames");
        this.y = database;
        this.f13211n3 = shadowTablesMap;
        this.f13219zn = viewTables;
        this.f13208fb = new AtomicBoolean(false);
        this.f13210i9 = new n3(tableNames.length);
        this.f13207f = new xc(database);
        this.f13213t = new w.n3<>();
        this.f13217wz = new Object();
        this.f13218xc = new Object();
        this.f13209gv = new LinkedHashMap();
        int length = tableNames.length;
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            String str2 = tableNames[i];
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            String lowerCase = str2.toLowerCase(US);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            this.f13209gv.put(lowerCase, Integer.valueOf(i));
            String str3 = this.f13211n3.get(tableNames[i]);
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
        this.f13215v = strArr;
        for (Map.Entry<String, String> entry : this.f13211n3.entrySet()) {
            Locale US2 = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US2, "US");
            String lowerCase2 = entry.getValue().toLowerCase(US2);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
            if (this.f13209gv.containsKey(lowerCase2)) {
                Intrinsics.checkNotNullExpressionValue(US2, "US");
                String lowerCase3 = entry.getKey().toLowerCase(US2);
                Intrinsics.checkNotNullExpressionValue(lowerCase3, "this as java.lang.String).toLowerCase(locale)");
                Map<String, Integer> map = this.f13209gv;
                map.put(lowerCase3, MapsKt.getValue(map, lowerCase2));
            }
        }
        this.f13216w = new a();
    }

    public final u0.f a() {
        return this.f13206c5;
    }

    public final AtomicBoolean c5() {
        return this.f13208fb;
    }

    public final void co(u0.fb fbVar, int i) {
        fbVar.execSQL("INSERT OR IGNORE INTO room_table_modification_log VALUES(" + i + ", 0)");
        String str = this.f13215v[i];
        for (String str2 : f13203mt) {
            String str3 = "CREATE TEMP TRIGGER IF NOT EXISTS " + f13204p.n3(str, str2) + " AFTER " + str2 + " ON `" + str + "` BEGIN UPDATE room_table_modification_log SET invalidated = 1 WHERE table_id = " + i + " AND invalidated = 0; END";
            Intrinsics.checkNotNullExpressionValue(str3, "StringBuilder().apply(builderAction).toString()");
            fbVar.execSQL(str3);
        }
    }

    public final void f(u0.fb database) {
        Intrinsics.checkNotNullParameter(database, "database");
        synchronized (this.f13218xc) {
            if (this.f13212s) {
                Log.e("ROOM", "Invalidation tracker is initialized twice :/.");
                return;
            }
            database.execSQL("PRAGMA temp_store = MEMORY;");
            database.execSQL("PRAGMA recursive_triggers='ON';");
            database.execSQL("CREATE TEMP TABLE room_table_modification_log (table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)");
            i4(database);
            this.f13206c5 = database.rs("UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1");
            this.f13212s = true;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final String[] f3(String[] strArr) {
        String[] w4 = w(strArr);
        for (String str : w4) {
            Map<String, Integer> map = this.f13209gv;
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            String lowerCase = str.toLowerCase(US);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            if (!map.containsKey(lowerCase)) {
                throw new IllegalArgumentException(("There is no table with name " + str).toString());
            }
        }
        return w4;
    }

    public final i4 fb() {
        return this.y;
    }

    public <T> LiveData<T> gv(String[] tableNames, boolean z2, Callable<T> computeFunction) {
        Intrinsics.checkNotNullParameter(tableNames, "tableNames");
        Intrinsics.checkNotNullParameter(computeFunction, "computeFunction");
        return this.f13207f.y(f3(tableNames), z2, computeFunction);
    }

    public final void i4(u0.fb database) {
        Intrinsics.checkNotNullParameter(database, "database");
        if (database.xb()) {
            return;
        }
        try {
            Lock closeLock$room_runtime_release = this.y.getCloseLock$room_runtime_release();
            closeLock$room_runtime_release.lock();
            synchronized (this.f13217wz) {
                int[] y2 = this.f13210i9.y();
                if (y2 == null) {
                    closeLock$room_runtime_release.unlock();
                    return;
                }
                f13204p.y(database);
                int length = y2.length;
                int i = 0;
                int i5 = 0;
                while (i < length) {
                    int i6 = y2[i];
                    int i8 = i5 + 1;
                    if (i6 != 1) {
                        if (i6 == 2) {
                            r(database, i5);
                        }
                    } else {
                        co(database, i5);
                    }
                    i++;
                    i5 = i8;
                }
                database.d0();
                database.z6();
                Unit unit = Unit.INSTANCE;
                closeLock$room_runtime_release.unlock();
            }
        } catch (SQLiteException e2) {
            Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e2);
        } catch (IllegalStateException e3) {
            Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e3);
        }
    }

    public final Map<String, Integer> i9() {
        return this.f13209gv;
    }

    public final void mt(Context context, String name, Intent serviceIntent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(serviceIntent, "serviceIntent");
        this.f13214tl = new z(context, name, serviceIntent, this, this.y.getQueryExecutor());
    }

    @SuppressLint({"RestrictedApi"})
    public void n3(zn observer) {
        gv a2;
        Intrinsics.checkNotNullParameter(observer, "observer");
        String[] w4 = w(observer.y());
        ArrayList arrayList = new ArrayList(w4.length);
        for (String str : w4) {
            Map<String, Integer> map = this.f13209gv;
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            String lowerCase = str.toLowerCase(US);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            Integer num = map.get(lowerCase);
            if (num != null) {
                arrayList.add(num);
            } else {
                throw new IllegalArgumentException("There is no table with name " + str);
            }
        }
        int[] intArray = CollectionsKt.toIntArray(arrayList);
        gv gvVar = new gv(observer, intArray, w4);
        synchronized (this.f13213t) {
            a2 = this.f13213t.a(observer, gvVar);
        }
        if (a2 == null && this.f13210i9.n3(Arrays.copyOf(intArray, intArray.length))) {
            x4();
        }
    }

    public final void p(rb.zn autoCloser) {
        Intrinsics.checkNotNullParameter(autoCloser, "autoCloser");
        this.f13205a = autoCloser;
        autoCloser.tl(new Runnable() { // from class: rb.w
            @Override // java.lang.Runnable
            public final void run() {
                p.this.tl();
            }
        });
    }

    public final void r(u0.fb fbVar, int i) {
        String[] strArr;
        String str = this.f13215v[i];
        for (String str2 : f13203mt) {
            String str3 = "DROP TRIGGER IF EXISTS " + f13204p.n3(str, str2);
            Intrinsics.checkNotNullExpressionValue(str3, "StringBuilder().apply(builderAction).toString()");
            fbVar.execSQL(str3);
        }
    }

    public final w.n3<zn, gv> s() {
        return this.f13213t;
    }

    public final void t(String... tables) {
        Intrinsics.checkNotNullParameter(tables, "tables");
        synchronized (this.f13213t) {
            try {
                Iterator<Map.Entry<K, V>> it = this.f13213t.iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    Intrinsics.checkNotNullExpressionValue(entry, "(observer, wrapper)");
                    gv gvVar = (gv) entry.getValue();
                    if (!((zn) entry.getKey()).n3()) {
                        gvVar.zn(tables);
                    }
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void tl() {
        synchronized (this.f13218xc) {
            this.f13212s = false;
            this.f13210i9.gv();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final boolean v() {
        if (!this.y.isOpen()) {
            return false;
        }
        if (!this.f13212s) {
            this.y.getOpenHelper().getWritableDatabase();
        }
        if (!this.f13212s) {
            Log.e("ROOM", "database is not initialized even though it is open");
            return false;
        }
        return true;
    }

    public final String[] w(String[] strArr) {
        Set createSetBuilder = SetsKt.createSetBuilder();
        for (String str : strArr) {
            Map<String, Set<String>> map = this.f13219zn;
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            String lowerCase = str.toLowerCase(US);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            if (map.containsKey(lowerCase)) {
                Map<String, Set<String>> map2 = this.f13219zn;
                Intrinsics.checkNotNullExpressionValue(US, "US");
                String lowerCase2 = str.toLowerCase(US);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
                Set<String> set = map2.get(lowerCase2);
                Intrinsics.checkNotNull(set);
                createSetBuilder.addAll(set);
            } else {
                createSetBuilder.add(str);
            }
        }
        Object[] array = SetsKt.build(createSetBuilder).toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (String[]) array;
    }

    public void wz() {
        if (this.f13208fb.compareAndSet(false, true)) {
            rb.zn znVar = this.f13205a;
            if (znVar != null) {
                znVar.i9();
            }
            this.y.getQueryExecutor().execute(this.f13216w);
        }
    }

    public final void x4() {
        if (!this.y.isOpen()) {
            return;
        }
        i4(this.y.getOpenHelper().getWritableDatabase());
    }

    @SuppressLint({"RestrictedApi"})
    public void xc(zn observer) {
        gv fb2;
        Intrinsics.checkNotNullParameter(observer, "observer");
        synchronized (this.f13213t) {
            fb2 = this.f13213t.fb(observer);
        }
        if (fb2 != null) {
            n3 n3Var = this.f13210i9;
            int[] y2 = fb2.y();
            if (n3Var.zn(Arrays.copyOf(y2, y2.length))) {
                x4();
            }
        }
    }

    public final void z() {
        z zVar = this.f13214tl;
        if (zVar != null) {
            zVar.xc();
        }
        this.f13214tl = null;
    }

    public void zn(zn observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        n3(new v(this, observer));
    }
}
