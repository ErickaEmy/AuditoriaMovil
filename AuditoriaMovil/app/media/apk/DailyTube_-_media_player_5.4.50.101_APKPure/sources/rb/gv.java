package rb;

import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.database.SQLException;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.util.Pair;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
/* loaded from: classes.dex */
public final class gv implements u0.s, c5 {

    /* renamed from: fb  reason: collision with root package name */
    public final y f13164fb;

    /* renamed from: v  reason: collision with root package name */
    public final rb.zn f13165v;
    public final u0.s y;

    /* loaded from: classes.dex */
    public static final class y implements u0.fb {
        public final rb.zn y;

        /* loaded from: classes.dex */
        public static final class a extends Lambda implements Function1<u0.fb, String> {
            public static final a y = new a();

            public a() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: y */
            public final String invoke(u0.fb obj) {
                Intrinsics.checkNotNullParameter(obj, "obj");
                return obj.getPath();
            }
        }

        /* loaded from: classes.dex */
        public static final class fb extends Lambda implements Function1<u0.fb, Object> {
            public static final fb y = new fb();

            public fb() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: y */
            public final Object invoke(u0.fb it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return null;
            }
        }

        /* renamed from: rb.gv$y$gv  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public /* synthetic */ class C0199gv extends FunctionReferenceImpl implements Function1<u0.fb, Boolean> {
            public static final C0199gv y = new C0199gv();

            public C0199gv() {
                super(1, u0.fb.class, "inTransaction", "inTransaction()Z", 0);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: y */
            public final Boolean invoke(u0.fb p02) {
                Intrinsics.checkNotNullParameter(p02, "p0");
                return Boolean.valueOf(p02.xb());
            }
        }

        /* loaded from: classes.dex */
        public static final class n3 extends Lambda implements Function1<u0.fb, Object> {
            final /* synthetic */ String $sql;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public n3(String str) {
                super(1);
                this.$sql = str;
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: y */
            public final Object invoke(u0.fb db) {
                Intrinsics.checkNotNullParameter(db, "db");
                db.execSQL(this.$sql);
                return null;
            }
        }

        /* loaded from: classes.dex */
        public static final class v extends Lambda implements Function1<u0.fb, Boolean> {
            public static final v y = new v();

            public v() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: y */
            public final Boolean invoke(u0.fb db) {
                Intrinsics.checkNotNullParameter(db, "db");
                return Boolean.valueOf(db.gq());
            }
        }

        /* renamed from: rb.gv$y$y  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0200y extends Lambda implements Function1<u0.fb, List<? extends Pair<String, String>>> {
            public static final C0200y y = new C0200y();

            public C0200y() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: y */
            public final List<Pair<String, String>> invoke(u0.fb obj) {
                Intrinsics.checkNotNullParameter(obj, "obj");
                return obj.tl();
            }
        }

        /* loaded from: classes.dex */
        public static final class zn extends Lambda implements Function1<u0.fb, Object> {
            final /* synthetic */ Object[] $bindArgs;
            final /* synthetic */ String $sql;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public zn(String str, Object[] objArr) {
                super(1);
                this.$sql = str;
                this.$bindArgs = objArr;
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: y */
            public final Object invoke(u0.fb db) {
                Intrinsics.checkNotNullParameter(db, "db");
                db.fh(this.$sql, this.$bindArgs);
                return null;
            }
        }

        public y(rb.zn autoCloser) {
            Intrinsics.checkNotNullParameter(autoCloser, "autoCloser");
            this.y = autoCloser;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.y.gv();
        }

        @Override // u0.fb
        public void d0() {
            Unit unit;
            u0.fb s2 = this.y.s();
            if (s2 != null) {
                s2.d0();
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit != null) {
                return;
            }
            throw new IllegalStateException("setTransactionSuccessful called but delegateDb is null");
        }

        @Override // u0.fb
        public void execSQL(String sql) throws SQLException {
            Intrinsics.checkNotNullParameter(sql, "sql");
            this.y.fb(new n3(sql));
        }

        @Override // u0.fb
        public void fb() {
            try {
                this.y.i9().fb();
            } catch (Throwable th) {
                this.y.v();
                throw th;
            }
        }

        @Override // u0.fb
        public void fh(String sql, Object[] bindArgs) throws SQLException {
            Intrinsics.checkNotNullParameter(sql, "sql");
            Intrinsics.checkNotNullParameter(bindArgs, "bindArgs");
            this.y.fb(new zn(sql, bindArgs));
        }

        @Override // u0.fb
        public String getPath() {
            return (String) this.y.fb(a.y);
        }

        @Override // u0.fb
        public int getVersion() {
            return ((Number) this.y.fb(new MutablePropertyReference1Impl() { // from class: rb.gv.y.s
                @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
                public Object get(Object obj) {
                    return Integer.valueOf(((u0.fb) obj).getVersion());
                }
            })).intValue();
        }

        @Override // u0.fb
        public boolean gq() {
            return ((Boolean) this.y.fb(v.y)).booleanValue();
        }

        @Override // u0.fb
        public boolean isOpen() {
            u0.fb s2 = this.y.s();
            if (s2 == null) {
                return false;
            }
            return s2.isOpen();
        }

        @Override // u0.fb
        public Cursor ra(u0.i9 query, CancellationSignal cancellationSignal) {
            Intrinsics.checkNotNullParameter(query, "query");
            try {
                return new zn(this.y.i9().ra(query, cancellationSignal), this.y);
            } catch (Throwable th) {
                this.y.v();
                throw th;
            }
        }

        @Override // u0.fb
        public Cursor rb(String query) {
            Intrinsics.checkNotNullParameter(query, "query");
            try {
                return new zn(this.y.i9().rb(query), this.y);
            } catch (Throwable th) {
                this.y.v();
                throw th;
            }
        }

        @Override // u0.fb
        public u0.f rs(String sql) {
            Intrinsics.checkNotNullParameter(sql, "sql");
            return new n3(sql, this.y);
        }

        @Override // u0.fb
        public void rz() {
            try {
                this.y.i9().rz();
            } catch (Throwable th) {
                this.y.v();
                throw th;
            }
        }

        @Override // u0.fb
        public List<Pair<String, String>> tl() {
            return (List) this.y.fb(C0200y.y);
        }

        @Override // u0.fb
        public boolean xb() {
            if (this.y.s() == null) {
                return false;
            }
            return ((Boolean) this.y.fb(C0199gv.y)).booleanValue();
        }

        public final void y() {
            this.y.fb(fb.y);
        }

        @Override // u0.fb
        public Cursor y4(u0.i9 query) {
            Intrinsics.checkNotNullParameter(query, "query");
            try {
                return new zn(this.y.i9().y4(query), this.y);
            } catch (Throwable th) {
                this.y.v();
                throw th;
            }
        }

        @Override // u0.fb
        public void z6() {
            if (this.y.s() != null) {
                try {
                    u0.fb s2 = this.y.s();
                    Intrinsics.checkNotNull(s2);
                    s2.z6();
                    return;
                } finally {
                    this.y.v();
                }
            }
            throw new IllegalStateException("End transaction called but delegateDb is null");
        }
    }

    /* loaded from: classes.dex */
    public static final class zn implements Cursor {

        /* renamed from: v  reason: collision with root package name */
        public final rb.zn f13168v;
        public final Cursor y;

        public zn(Cursor delegate, rb.zn autoCloser) {
            Intrinsics.checkNotNullParameter(delegate, "delegate");
            Intrinsics.checkNotNullParameter(autoCloser, "autoCloser");
            this.y = delegate;
            this.f13168v = autoCloser;
        }

        @Override // android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.y.close();
            this.f13168v.v();
        }

        @Override // android.database.Cursor
        public void copyStringToBuffer(int i, CharArrayBuffer charArrayBuffer) {
            this.y.copyStringToBuffer(i, charArrayBuffer);
        }

        @Override // android.database.Cursor
        public void deactivate() {
            this.y.deactivate();
        }

        @Override // android.database.Cursor
        public byte[] getBlob(int i) {
            return this.y.getBlob(i);
        }

        @Override // android.database.Cursor
        public int getColumnCount() {
            return this.y.getColumnCount();
        }

        @Override // android.database.Cursor
        public int getColumnIndex(String str) {
            return this.y.getColumnIndex(str);
        }

        @Override // android.database.Cursor
        public int getColumnIndexOrThrow(String str) {
            return this.y.getColumnIndexOrThrow(str);
        }

        @Override // android.database.Cursor
        public String getColumnName(int i) {
            return this.y.getColumnName(i);
        }

        @Override // android.database.Cursor
        public String[] getColumnNames() {
            return this.y.getColumnNames();
        }

        @Override // android.database.Cursor
        public int getCount() {
            return this.y.getCount();
        }

        @Override // android.database.Cursor
        public double getDouble(int i) {
            return this.y.getDouble(i);
        }

        @Override // android.database.Cursor
        public Bundle getExtras() {
            return this.y.getExtras();
        }

        @Override // android.database.Cursor
        public float getFloat(int i) {
            return this.y.getFloat(i);
        }

        @Override // android.database.Cursor
        public int getInt(int i) {
            return this.y.getInt(i);
        }

        @Override // android.database.Cursor
        public long getLong(int i) {
            return this.y.getLong(i);
        }

        @Override // android.database.Cursor
        public Uri getNotificationUri() {
            return u0.zn.y(this.y);
        }

        @Override // android.database.Cursor
        public List<Uri> getNotificationUris() {
            return u0.a.y(this.y);
        }

        @Override // android.database.Cursor
        public int getPosition() {
            return this.y.getPosition();
        }

        @Override // android.database.Cursor
        public short getShort(int i) {
            return this.y.getShort(i);
        }

        @Override // android.database.Cursor
        public String getString(int i) {
            return this.y.getString(i);
        }

        @Override // android.database.Cursor
        public int getType(int i) {
            return this.y.getType(i);
        }

        @Override // android.database.Cursor
        public boolean getWantsAllOnMoveCalls() {
            return this.y.getWantsAllOnMoveCalls();
        }

        @Override // android.database.Cursor
        public boolean isAfterLast() {
            return this.y.isAfterLast();
        }

        @Override // android.database.Cursor
        public boolean isBeforeFirst() {
            return this.y.isBeforeFirst();
        }

        @Override // android.database.Cursor
        public boolean isClosed() {
            return this.y.isClosed();
        }

        @Override // android.database.Cursor
        public boolean isFirst() {
            return this.y.isFirst();
        }

        @Override // android.database.Cursor
        public boolean isLast() {
            return this.y.isLast();
        }

        @Override // android.database.Cursor
        public boolean isNull(int i) {
            return this.y.isNull(i);
        }

        @Override // android.database.Cursor
        public boolean move(int i) {
            return this.y.move(i);
        }

        @Override // android.database.Cursor
        public boolean moveToFirst() {
            return this.y.moveToFirst();
        }

        @Override // android.database.Cursor
        public boolean moveToLast() {
            return this.y.moveToLast();
        }

        @Override // android.database.Cursor
        public boolean moveToNext() {
            return this.y.moveToNext();
        }

        @Override // android.database.Cursor
        public boolean moveToPosition(int i) {
            return this.y.moveToPosition(i);
        }

        @Override // android.database.Cursor
        public boolean moveToPrevious() {
            return this.y.moveToPrevious();
        }

        @Override // android.database.Cursor
        public void registerContentObserver(ContentObserver contentObserver) {
            this.y.registerContentObserver(contentObserver);
        }

        @Override // android.database.Cursor
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            this.y.registerDataSetObserver(dataSetObserver);
        }

        @Override // android.database.Cursor
        public boolean requery() {
            return this.y.requery();
        }

        @Override // android.database.Cursor
        public Bundle respond(Bundle bundle) {
            return this.y.respond(bundle);
        }

        @Override // android.database.Cursor
        public void setExtras(Bundle extras) {
            Intrinsics.checkNotNullParameter(extras, "extras");
            u0.v.y(this.y, extras);
        }

        @Override // android.database.Cursor
        public void setNotificationUri(ContentResolver contentResolver, Uri uri) {
            this.y.setNotificationUri(contentResolver, uri);
        }

        @Override // android.database.Cursor
        public void setNotificationUris(ContentResolver cr2, List<? extends Uri> uris) {
            Intrinsics.checkNotNullParameter(cr2, "cr");
            Intrinsics.checkNotNullParameter(uris, "uris");
            u0.a.n3(this.y, cr2, uris);
        }

        @Override // android.database.Cursor
        public void unregisterContentObserver(ContentObserver contentObserver) {
            this.y.unregisterContentObserver(contentObserver);
        }

        @Override // android.database.Cursor
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            this.y.unregisterDataSetObserver(dataSetObserver);
        }
    }

    public gv(u0.s delegate, rb.zn autoCloser) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(autoCloser, "autoCloser");
        this.y = delegate;
        this.f13165v = autoCloser;
        autoCloser.f(y());
        this.f13164fb = new y(autoCloser);
    }

    @Override // u0.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f13164fb.close();
    }

    @Override // u0.s
    public String getDatabaseName() {
        return this.y.getDatabaseName();
    }

    @Override // u0.s
    public u0.fb getReadableDatabase() {
        this.f13164fb.y();
        return this.f13164fb;
    }

    @Override // u0.s
    public u0.fb getWritableDatabase() {
        this.f13164fb.y();
        return this.f13164fb;
    }

    @Override // u0.s
    public void setWriteAheadLoggingEnabled(boolean z2) {
        this.y.setWriteAheadLoggingEnabled(z2);
    }

    @Override // rb.c5
    public u0.s y() {
        return this.y;
    }

    /* loaded from: classes.dex */
    public static final class n3 implements u0.f {

        /* renamed from: fb  reason: collision with root package name */
        public final ArrayList<Object> f13166fb;

        /* renamed from: v  reason: collision with root package name */
        public final rb.zn f13167v;
        public final String y;

        /* JADX INFO: Add missing generic type declarations: [T] */
        /* renamed from: rb.gv$n3$n3  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0198n3<T> extends Lambda implements Function1<u0.fb, T> {
            final /* synthetic */ Function1<u0.f, T> $block;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public C0198n3(Function1<? super u0.f, ? extends T> function1) {
                super(1);
                this.$block = function1;
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: y */
            public final T invoke(u0.fb db) {
                Intrinsics.checkNotNullParameter(db, "db");
                u0.f rs2 = db.rs(n3.this.y);
                n3.this.s(rs2);
                return this.$block.invoke(rs2);
            }
        }

        /* loaded from: classes.dex */
        public static final class y extends Lambda implements Function1<u0.f, Long> {
            public static final y y = new y();

            public y() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: y */
            public final Long invoke(u0.f obj) {
                Intrinsics.checkNotNullParameter(obj, "obj");
                return Long.valueOf(obj.en());
            }
        }

        /* loaded from: classes.dex */
        public static final class zn extends Lambda implements Function1<u0.f, Integer> {
            public static final zn y = new zn();

            public zn() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: y */
            public final Integer invoke(u0.f obj) {
                Intrinsics.checkNotNullParameter(obj, "obj");
                return Integer.valueOf(obj.xc());
            }
        }

        public n3(String sql, rb.zn autoCloser) {
            Intrinsics.checkNotNullParameter(sql, "sql");
            Intrinsics.checkNotNullParameter(autoCloser, "autoCloser");
            this.y = sql;
            this.f13167v = autoCloser;
            this.f13166fb = new ArrayList<>();
        }

        @Override // u0.c5
        public void e(int i, long j2) {
            mt(i, Long.valueOf(j2));
        }

        @Override // u0.f
        public long en() {
            return ((Number) p(y.y)).longValue();
        }

        public final void mt(int i, Object obj) {
            int size;
            int i5 = i - 1;
            if (i5 >= this.f13166fb.size() && (size = this.f13166fb.size()) <= i5) {
                while (true) {
                    this.f13166fb.add(null);
                    if (size == i5) {
                        break;
                    }
                    size++;
                }
            }
            this.f13166fb.set(i5, obj);
        }

        public final <T> T p(Function1<? super u0.f, ? extends T> function1) {
            return (T) this.f13167v.fb(new C0198n3(function1));
        }

        @Override // u0.c5
        public void pz(int i) {
            mt(i, null);
        }

        public final void s(u0.f fVar) {
            Iterator<T> it = this.f13166fb.iterator();
            int i = 0;
            while (it.hasNext()) {
                it.next();
                int i5 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Object obj = this.f13166fb.get(i);
                if (obj == null) {
                    fVar.pz(i5);
                } else if (obj instanceof Long) {
                    fVar.e(i5, ((Number) obj).longValue());
                } else if (obj instanceof Double) {
                    fVar.t(i5, ((Number) obj).doubleValue());
                } else if (obj instanceof String) {
                    fVar.xg(i5, (String) obj);
                } else if (obj instanceof byte[]) {
                    fVar.yg(i5, (byte[]) obj);
                }
                i = i5;
            }
        }

        @Override // u0.c5
        public void t(int i, double d2) {
            mt(i, Double.valueOf(d2));
        }

        @Override // u0.f
        public int xc() {
            return ((Number) p(zn.y)).intValue();
        }

        @Override // u0.c5
        public void xg(int i, String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            mt(i, value);
        }

        @Override // u0.c5
        public void yg(int i, byte[] value) {
            Intrinsics.checkNotNullParameter(value, "value");
            mt(i, value);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }
    }
}
