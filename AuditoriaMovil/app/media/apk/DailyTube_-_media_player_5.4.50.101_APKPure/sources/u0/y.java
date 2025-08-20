package u0;

import android.annotation.SuppressLint;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class y implements i9 {

    /* renamed from: fb  reason: collision with root package name */
    public static final C0225y f14028fb = new C0225y(null);

    /* renamed from: v  reason: collision with root package name */
    public final Object[] f14029v;
    public final String y;

    /* renamed from: u0.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0225y {
        public /* synthetic */ C0225y(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @SuppressLint({"SyntheticAccessor"})
        public final void n3(c5 statement, Object[] objArr) {
            Intrinsics.checkNotNullParameter(statement, "statement");
            if (objArr == null) {
                return;
            }
            int length = objArr.length;
            int i = 0;
            while (i < length) {
                Object obj = objArr[i];
                i++;
                y(statement, i, obj);
            }
        }

        public final void y(c5 c5Var, int i, Object obj) {
            long j2;
            if (obj == null) {
                c5Var.pz(i);
            } else if (obj instanceof byte[]) {
                c5Var.yg(i, (byte[]) obj);
            } else if (obj instanceof Float) {
                c5Var.t(i, ((Number) obj).floatValue());
            } else if (obj instanceof Double) {
                c5Var.t(i, ((Number) obj).doubleValue());
            } else if (obj instanceof Long) {
                c5Var.e(i, ((Number) obj).longValue());
            } else if (obj instanceof Integer) {
                c5Var.e(i, ((Number) obj).intValue());
            } else if (obj instanceof Short) {
                c5Var.e(i, ((Number) obj).shortValue());
            } else if (obj instanceof Byte) {
                c5Var.e(i, ((Number) obj).byteValue());
            } else if (obj instanceof String) {
                c5Var.xg(i, (String) obj);
            } else if (obj instanceof Boolean) {
                if (((Boolean) obj).booleanValue()) {
                    j2 = 1;
                } else {
                    j2 = 0;
                }
                c5Var.e(i, j2);
            } else {
                throw new IllegalArgumentException("Cannot bind " + obj + " at index " + i + " Supported types: Null, ByteArray, Float, Double, Long, Int, Short, Byte, String");
            }
        }

        public C0225y() {
        }
    }

    public y(String query, Object[] objArr) {
        Intrinsics.checkNotNullParameter(query, "query");
        this.y = query;
        this.f14029v = objArr;
    }

    @Override // u0.i9
    public void v(c5 statement) {
        Intrinsics.checkNotNullParameter(statement, "statement");
        f14028fb.n3(statement, this.f14029v);
    }

    @Override // u0.i9
    public String y() {
        return this.y;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public y(String query) {
        this(query, null);
        Intrinsics.checkNotNullParameter(query, "query");
    }
}
