package q3;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.offline.StreamKey;
import ha.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import m1.m;
import v5.j5;
import v5.vl;
/* loaded from: classes.dex */
public class y implements ea.y<y> {

    /* renamed from: a  reason: collision with root package name */
    public final n3[] f12731a;

    /* renamed from: fb  reason: collision with root package name */
    public final long f12732fb;

    /* renamed from: gv  reason: collision with root package name */
    public final boolean f12733gv;

    /* renamed from: n3  reason: collision with root package name */
    public final int f12734n3;

    /* renamed from: s  reason: collision with root package name */
    public final long f12735s;
    @Nullable

    /* renamed from: v  reason: collision with root package name */
    public final C0185y f12736v;
    public final int y;

    /* renamed from: zn  reason: collision with root package name */
    public final int f12737zn;

    /* renamed from: q3.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0185y {

        /* renamed from: n3  reason: collision with root package name */
        public final byte[] f12753n3;
        public final UUID y;

        /* renamed from: zn  reason: collision with root package name */
        public final w[] f12754zn;

        public C0185y(UUID uuid, byte[] bArr, w[] wVarArr) {
            this.y = uuid;
            this.f12753n3 = bArr;
            this.f12754zn = wVarArr;
        }
    }

    public y(int i, int i5, long j2, long j4, long j6, int i6, boolean z2, @Nullable C0185y c0185y, n3[] n3VarArr) {
        this(i, i5, j4 == 0 ? -9223372036854775807L : j5.x5(j4, 1000000L, j2), j6 != 0 ? j5.x5(j6, 1000000L, j2) : -9223372036854775807L, i6, z2, c0185y, n3VarArr);
    }

    @Override // ea.y
    /* renamed from: n3 */
    public final y y(List<StreamKey> list) {
        ArrayList arrayList = new ArrayList(list);
        Collections.sort(arrayList);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        n3 n3Var = null;
        int i = 0;
        while (i < arrayList.size()) {
            StreamKey streamKey = (StreamKey) arrayList.get(i);
            n3 n3Var2 = this.f12731a[streamKey.f4332v];
            if (n3Var2 != n3Var && n3Var != null) {
                arrayList2.add(n3Var.n3((m[]) arrayList3.toArray(new m[0])));
                arrayList3.clear();
            }
            arrayList3.add(n3Var2.f12743i9[streamKey.f4330fb]);
            i++;
            n3Var = n3Var2;
        }
        if (n3Var != null) {
            arrayList2.add(n3Var.n3((m[]) arrayList3.toArray(new m[0])));
        }
        return new y(this.y, this.f12734n3, this.f12732fb, this.f12735s, this.f12737zn, this.f12733gv, this.f12736v, (n3[]) arrayList2.toArray(new n3[0]));
    }

    /* loaded from: classes.dex */
    public static class n3 {

        /* renamed from: a  reason: collision with root package name */
        public final int f12738a;
        @Nullable

        /* renamed from: c5  reason: collision with root package name */
        public final String f12739c5;

        /* renamed from: f  reason: collision with root package name */
        public final int f12740f;

        /* renamed from: fb  reason: collision with root package name */
        public final int f12741fb;

        /* renamed from: gv  reason: collision with root package name */
        public final String f12742gv;

        /* renamed from: i9  reason: collision with root package name */
        public final m[] f12743i9;

        /* renamed from: n3  reason: collision with root package name */
        public final String f12744n3;

        /* renamed from: s  reason: collision with root package name */
        public final int f12745s;

        /* renamed from: t  reason: collision with root package name */
        public final String f12746t;

        /* renamed from: tl  reason: collision with root package name */
        public final String f12747tl;

        /* renamed from: v  reason: collision with root package name */
        public final int f12748v;

        /* renamed from: w  reason: collision with root package name */
        public final long f12749w;

        /* renamed from: wz  reason: collision with root package name */
        public final List<Long> f12750wz;

        /* renamed from: xc  reason: collision with root package name */
        public final long[] f12751xc;
        public final int y;

        /* renamed from: zn  reason: collision with root package name */
        public final long f12752zn;

        public n3(String str, String str2, int i, String str3, long j2, String str4, int i5, int i6, int i8, int i10, @Nullable String str5, m[] mVarArr, List<Long> list, long j4) {
            this(str, str2, i, str3, j2, str4, i5, i6, i8, i10, str5, mVarArr, list, j5.q5(list, 1000000L, j2), j5.x5(j4, 1000000L, j2));
        }

        public int gv(long j2) {
            return j5.c5(this.f12751xc, j2, true, true);
        }

        public n3 n3(m[] mVarArr) {
            return new n3(this.f12746t, this.f12747tl, this.y, this.f12744n3, this.f12752zn, this.f12742gv, this.f12748v, this.f12738a, this.f12741fb, this.f12745s, this.f12739c5, mVarArr, this.f12750wz, this.f12751xc, this.f12749w);
        }

        public long v(int i) {
            return this.f12751xc[i];
        }

        public Uri y(int i, int i5) {
            boolean z2;
            boolean z3;
            boolean z4 = false;
            if (this.f12743i9 != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            v5.y.fb(z2);
            if (this.f12750wz != null) {
                z3 = true;
            } else {
                z3 = false;
            }
            v5.y.fb(z3);
            if (i5 < this.f12750wz.size()) {
                z4 = true;
            }
            v5.y.fb(z4);
            String num = Integer.toString(this.f12743i9[i].f10959p);
            String l2 = this.f12750wz.get(i5).toString();
            return vl.v(this.f12746t, this.f12747tl.replace("{bitrate}", num).replace("{Bitrate}", num).replace("{start time}", l2).replace("{start_time}", l2));
        }

        public long zn(int i) {
            if (i == this.f12740f - 1) {
                return this.f12749w;
            }
            long[] jArr = this.f12751xc;
            return jArr[i + 1] - jArr[i];
        }

        public n3(String str, String str2, int i, String str3, long j2, String str4, int i5, int i6, int i8, int i10, @Nullable String str5, m[] mVarArr, List<Long> list, long[] jArr, long j4) {
            this.f12746t = str;
            this.f12747tl = str2;
            this.y = i;
            this.f12744n3 = str3;
            this.f12752zn = j2;
            this.f12742gv = str4;
            this.f12748v = i5;
            this.f12738a = i6;
            this.f12741fb = i8;
            this.f12745s = i10;
            this.f12739c5 = str5;
            this.f12743i9 = mVarArr;
            this.f12750wz = list;
            this.f12751xc = jArr;
            this.f12749w = j4;
            this.f12740f = list.size();
        }
    }

    public y(int i, int i5, long j2, long j4, int i6, boolean z2, @Nullable C0185y c0185y, n3[] n3VarArr) {
        this.y = i;
        this.f12734n3 = i5;
        this.f12732fb = j2;
        this.f12735s = j4;
        this.f12737zn = i6;
        this.f12733gv = z2;
        this.f12736v = c0185y;
        this.f12731a = n3VarArr;
    }
}
