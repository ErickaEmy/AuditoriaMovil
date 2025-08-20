package rb;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class c implements u0.i9, u0.c5 {

    /* renamed from: co  reason: collision with root package name */
    public static final y f13151co = new y(null);

    /* renamed from: z  reason: collision with root package name */
    public static final TreeMap<Integer, c> f13152z = new TreeMap<>();

    /* renamed from: f  reason: collision with root package name */
    public final String[] f13153f;

    /* renamed from: fb  reason: collision with root package name */
    public final long[] f13154fb;

    /* renamed from: p  reason: collision with root package name */
    public int f13155p;

    /* renamed from: s  reason: collision with root package name */
    public final double[] f13156s;

    /* renamed from: t  reason: collision with root package name */
    public final byte[][] f13157t;

    /* renamed from: v  reason: collision with root package name */
    public volatile String f13158v;

    /* renamed from: w  reason: collision with root package name */
    public final int[] f13159w;
    public final int y;

    /* loaded from: classes.dex */
    public static final class y {
        public /* synthetic */ y(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void n3() {
            TreeMap<Integer, c> treeMap = c.f13152z;
            if (treeMap.size() > 15) {
                int size = treeMap.size() - 10;
                Iterator<Integer> it = treeMap.descendingKeySet().iterator();
                Intrinsics.checkNotNullExpressionValue(it, "queryPool.descendingKeySet().iterator()");
                while (true) {
                    int i = size - 1;
                    if (size > 0) {
                        it.next();
                        it.remove();
                        size = i;
                    } else {
                        return;
                    }
                }
            }
        }

        public final c y(String query, int i) {
            Intrinsics.checkNotNullParameter(query, "query");
            TreeMap<Integer, c> treeMap = c.f13152z;
            synchronized (treeMap) {
                Map.Entry<Integer, c> ceilingEntry = treeMap.ceilingEntry(Integer.valueOf(i));
                if (ceilingEntry != null) {
                    treeMap.remove(ceilingEntry.getKey());
                    c sqliteQuery = ceilingEntry.getValue();
                    sqliteQuery.mt(query, i);
                    Intrinsics.checkNotNullExpressionValue(sqliteQuery, "sqliteQuery");
                    return sqliteQuery;
                }
                Unit unit = Unit.INSTANCE;
                c cVar = new c(i, null);
                cVar.mt(query, i);
                return cVar;
            }
        }

        public y() {
        }
    }

    public /* synthetic */ c(int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(i);
    }

    public static final c s(String str, int i) {
        return f13151co.y(str, i);
    }

    @Override // u0.c5
    public void e(int i, long j2) {
        this.f13159w[i] = 2;
        this.f13154fb[i] = j2;
    }

    public final void mt(String query, int i) {
        Intrinsics.checkNotNullParameter(query, "query");
        this.f13158v = query;
        this.f13155p = i;
    }

    public int p() {
        return this.f13155p;
    }

    @Override // u0.c5
    public void pz(int i) {
        this.f13159w[i] = 1;
    }

    public final void release() {
        TreeMap<Integer, c> treeMap = f13152z;
        synchronized (treeMap) {
            treeMap.put(Integer.valueOf(this.y), this);
            f13151co.n3();
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // u0.c5
    public void t(int i, double d2) {
        this.f13159w[i] = 3;
        this.f13156s[i] = d2;
    }

    @Override // u0.i9
    public void v(u0.c5 statement) {
        Intrinsics.checkNotNullParameter(statement, "statement");
        int p2 = p();
        if (1 <= p2) {
            int i = 1;
            while (true) {
                int i5 = this.f13159w[i];
                if (i5 != 1) {
                    if (i5 != 2) {
                        if (i5 != 3) {
                            if (i5 != 4) {
                                if (i5 == 5) {
                                    byte[] bArr = this.f13157t[i];
                                    if (bArr != null) {
                                        statement.yg(i, bArr);
                                    } else {
                                        throw new IllegalArgumentException("Required value was null.");
                                    }
                                }
                            } else {
                                String str = this.f13153f[i];
                                if (str != null) {
                                    statement.xg(i, str);
                                } else {
                                    throw new IllegalArgumentException("Required value was null.");
                                }
                            }
                        } else {
                            statement.t(i, this.f13156s[i]);
                        }
                    } else {
                        statement.e(i, this.f13154fb[i]);
                    }
                } else {
                    statement.pz(i);
                }
                if (i != p2) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    @Override // u0.c5
    public void xg(int i, String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.f13159w[i] = 4;
        this.f13153f[i] = value;
    }

    @Override // u0.i9
    public String y() {
        String str = this.f13158v;
        if (str != null) {
            return str;
        }
        throw new IllegalStateException("Required value was null.");
    }

    @Override // u0.c5
    public void yg(int i, byte[] value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.f13159w[i] = 5;
        this.f13157t[i] = value;
    }

    public c(int i) {
        this.y = i;
        int i5 = i + 1;
        this.f13159w = new int[i5];
        this.f13154fb = new long[i5];
        this.f13156s = new double[i5];
        this.f13153f = new String[i5];
        this.f13157t = new byte[i5];
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }
}
