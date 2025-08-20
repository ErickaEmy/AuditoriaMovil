package af;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import m1.m;
import m1.s;
/* loaded from: classes.dex */
public final class rs implements m1.s {

    /* renamed from: f  reason: collision with root package name */
    public int f378f;

    /* renamed from: fb  reason: collision with root package name */
    public final int f379fb;

    /* renamed from: s  reason: collision with root package name */
    public final m[] f380s;

    /* renamed from: v  reason: collision with root package name */
    public final String f381v;
    public final int y;

    /* renamed from: t  reason: collision with root package name */
    public static final String f376t = v5.j5.g3(0);

    /* renamed from: w  reason: collision with root package name */
    public static final String f377w = v5.j5.g3(1);

    /* renamed from: p  reason: collision with root package name */
    public static final s.y<rs> f375p = new s.y() { // from class: af.o4
        @Override // m1.s.y
        public final m1.s fromBundle(Bundle bundle) {
            rs v2;
            v2 = rs.v(bundle);
            return v2;
        }
    };

    public rs(m... mVarArr) {
        this("", mVarArr);
    }

    public static void a(String str, @Nullable String str2, @Nullable String str3, int i) {
        v5.r.gv("TrackGroup", "", new IllegalStateException("Different " + str + " combined in one TrackGroup: '" + str2 + "' (track 0) and '" + str3 + "' (track " + i + ")"));
    }

    public static String fb(@Nullable String str) {
        if (str == null || str.equals("und")) {
            return "";
        }
        return str;
    }

    public static int s(int i) {
        return i | 16384;
    }

    public static /* synthetic */ rs v(Bundle bundle) {
        z0.x4 n32;
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(f376t);
        if (parcelableArrayList == null) {
            n32 = z0.x4.j5();
        } else {
            n32 = v5.gv.n3(m.f10917gq, parcelableArrayList);
        }
        return new rs(bundle.getString(f377w, ""), (m[]) n32.toArray(new m[0]));
    }

    public final void c5() {
        String fb2 = fb(this.f380s[0].f10950fb);
        int s2 = s(this.f380s[0].f10947f);
        int i = 1;
        while (true) {
            m[] mVarArr = this.f380s;
            if (i < mVarArr.length) {
                if (!fb2.equals(fb(mVarArr[i].f10950fb))) {
                    m[] mVarArr2 = this.f380s;
                    a("languages", mVarArr2[0].f10950fb, mVarArr2[i].f10950fb, i);
                    return;
                } else if (s2 != s(this.f380s[i].f10947f)) {
                    a("role flags", Integer.toBinaryString(this.f380s[0].f10947f), Integer.toBinaryString(this.f380s[i].f10947f), i);
                    return;
                } else {
                    i++;
                }
            } else {
                return;
            }
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || rs.class != obj.getClass()) {
            return false;
        }
        rs rsVar = (rs) obj;
        if (this.f381v.equals(rsVar.f381v) && Arrays.equals(this.f380s, rsVar.f380s)) {
            return true;
        }
        return false;
    }

    public int gv(m mVar) {
        int i = 0;
        while (true) {
            m[] mVarArr = this.f380s;
            if (i < mVarArr.length) {
                if (mVar == mVarArr[i]) {
                    return i;
                }
                i++;
            } else {
                return -1;
            }
        }
    }

    public int hashCode() {
        if (this.f378f == 0) {
            this.f378f = ((527 + this.f381v.hashCode()) * 31) + Arrays.hashCode(this.f380s);
        }
        return this.f378f;
    }

    @CheckResult
    public rs n3(String str) {
        return new rs(str, this.f380s);
    }

    @Override // m1.s
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>(this.f380s.length);
        for (m mVar : this.f380s) {
            arrayList.add(mVar.c5(true));
        }
        bundle.putParcelableArrayList(f376t, arrayList);
        bundle.putString(f377w, this.f381v);
        return bundle;
    }

    public m zn(int i) {
        return this.f380s[i];
    }

    public rs(String str, m... mVarArr) {
        v5.y.y(mVarArr.length > 0);
        this.f381v = str;
        this.f380s = mVarArr;
        this.y = mVarArr.length;
        int f4 = v5.n.f(mVarArr[0].f10948f3);
        this.f379fb = f4 == -1 ? v5.n.f(mVarArr[0].f10962r) : f4;
        c5();
    }
}
