package y3;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.List;
import m1.ne;
import v5.k5;
/* loaded from: classes.dex */
public interface ud {

    /* loaded from: classes.dex */
    public static final class gv {

        /* renamed from: gv  reason: collision with root package name */
        public int f15153gv;

        /* renamed from: n3  reason: collision with root package name */
        public final int f15154n3;

        /* renamed from: v  reason: collision with root package name */
        public String f15155v;
        public final String y;

        /* renamed from: zn  reason: collision with root package name */
        public final int f15156zn;

        public gv(int i, int i5) {
            this(Integer.MIN_VALUE, i, i5);
        }

        public final void gv() {
            if (this.f15153gv != Integer.MIN_VALUE) {
                return;
            }
            throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
        }

        public String n3() {
            gv();
            return this.f15155v;
        }

        public void y() {
            int i;
            int i5 = this.f15153gv;
            if (i5 == Integer.MIN_VALUE) {
                i = this.f15154n3;
            } else {
                i = i5 + this.f15156zn;
            }
            this.f15153gv = i;
            this.f15155v = this.y + this.f15153gv;
        }

        public int zn() {
            gv();
            return this.f15153gv;
        }

        public gv(int i, int i5, int i6) {
            String str;
            if (i != Integer.MIN_VALUE) {
                str = i + "/";
            } else {
                str = "";
            }
            this.y = str;
            this.f15154n3 = i5;
            this.f15156zn = i6;
            this.f15153gv = Integer.MIN_VALUE;
            this.f15155v = "";
        }
    }

    /* loaded from: classes.dex */
    public static final class n3 {

        /* renamed from: gv  reason: collision with root package name */
        public final byte[] f15157gv;
        @Nullable

        /* renamed from: n3  reason: collision with root package name */
        public final String f15158n3;
        public final int y;

        /* renamed from: zn  reason: collision with root package name */
        public final List<y> f15159zn;

        public n3(int i, @Nullable String str, @Nullable List<y> list, byte[] bArr) {
            List<y> unmodifiableList;
            this.y = i;
            this.f15158n3 = str;
            if (list == null) {
                unmodifiableList = Collections.emptyList();
            } else {
                unmodifiableList = Collections.unmodifiableList(list);
            }
            this.f15159zn = unmodifiableList;
            this.f15157gv = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static final class y {

        /* renamed from: n3  reason: collision with root package name */
        public final int f15160n3;
        public final String y;

        /* renamed from: zn  reason: collision with root package name */
        public final byte[] f15161zn;

        public y(String str, int i, byte[] bArr) {
            this.y = str;
            this.f15160n3 = i;
            this.f15161zn = bArr;
        }
    }

    /* loaded from: classes.dex */
    public interface zn {
        @Nullable
        ud n3(int i, n3 n3Var);

        SparseArray<ud> y();
    }

    void n3(v5.rz rzVar, int i) throws ne;

    void y(k5 k5Var, e4.wz wzVar, gv gvVar);

    void zn();
}
