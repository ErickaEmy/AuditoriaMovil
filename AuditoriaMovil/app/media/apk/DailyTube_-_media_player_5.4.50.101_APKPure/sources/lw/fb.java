package lw;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.offline.StreamKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import z0.d0;
import z0.f3;
import z0.x4;
/* loaded from: classes.dex */
public final class fb extends c5 {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f10389a;

    /* renamed from: c5  reason: collision with root package name */
    public final boolean f10390c5;

    /* renamed from: co  reason: collision with root package name */
    public final List<n3> f10391co;

    /* renamed from: f  reason: collision with root package name */
    public final long f10392f;

    /* renamed from: fb  reason: collision with root package name */
    public final boolean f10393fb;

    /* renamed from: gv  reason: collision with root package name */
    public final int f10394gv;

    /* renamed from: i9  reason: collision with root package name */
    public final int f10395i9;

    /* renamed from: mt  reason: collision with root package name */
    public final List<gv> f10396mt;
    @Nullable

    /* renamed from: p  reason: collision with root package name */
    public final DrmInitData f10397p;

    /* renamed from: r  reason: collision with root package name */
    public final long f10398r;

    /* renamed from: s  reason: collision with root package name */
    public final long f10399s;

    /* renamed from: t  reason: collision with root package name */
    public final int f10400t;

    /* renamed from: tl  reason: collision with root package name */
    public final long f10401tl;

    /* renamed from: v  reason: collision with root package name */
    public final long f10402v;

    /* renamed from: w  reason: collision with root package name */
    public final boolean f10403w;

    /* renamed from: wz  reason: collision with root package name */
    public final long f10404wz;

    /* renamed from: x4  reason: collision with root package name */
    public final a f10405x4;

    /* renamed from: xc  reason: collision with root package name */
    public final boolean f10406xc;

    /* renamed from: z  reason: collision with root package name */
    public final Map<Uri, zn> f10407z;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: gv  reason: collision with root package name */
        public final long f10408gv;

        /* renamed from: n3  reason: collision with root package name */
        public final boolean f10409n3;

        /* renamed from: v  reason: collision with root package name */
        public final boolean f10410v;
        public final long y;

        /* renamed from: zn  reason: collision with root package name */
        public final long f10411zn;

        public a(long j2, boolean z2, long j4, long j6, boolean z3) {
            this.y = j2;
            this.f10409n3 = z2;
            this.f10411zn = j4;
            this.f10408gv = j6;
            this.f10410v = z3;
        }
    }

    /* loaded from: classes.dex */
    public static final class n3 extends v {

        /* renamed from: f3  reason: collision with root package name */
        public final boolean f10414f3;

        /* renamed from: n  reason: collision with root package name */
        public final boolean f10415n;

        public n3(String str, @Nullable gv gvVar, long j2, int i, long j4, @Nullable DrmInitData drmInitData, @Nullable String str2, @Nullable String str3, long j6, long j7, boolean z2, boolean z3, boolean z4) {
            super(str, gvVar, j2, i, j4, drmInitData, str2, str3, j6, j7, z2);
            this.f10414f3 = z3;
            this.f10415n = z4;
        }

        public n3 n3(long j2, int i) {
            return new n3(this.y, this.f10423v, this.f10418fb, i, j2, this.f10422t, this.f10424w, this.f10419p, this.f10416co, this.f10425z, this.f10420r, this.f10414f3, this.f10415n);
        }
    }

    /* loaded from: classes.dex */
    public static class v implements Comparable<Long> {

        /* renamed from: co  reason: collision with root package name */
        public final long f10416co;

        /* renamed from: f  reason: collision with root package name */
        public final long f10417f;

        /* renamed from: fb  reason: collision with root package name */
        public final long f10418fb;
        @Nullable

        /* renamed from: p  reason: collision with root package name */
        public final String f10419p;

        /* renamed from: r  reason: collision with root package name */
        public final boolean f10420r;

        /* renamed from: s  reason: collision with root package name */
        public final int f10421s;
        @Nullable

        /* renamed from: t  reason: collision with root package name */
        public final DrmInitData f10422t;
        @Nullable

        /* renamed from: v  reason: collision with root package name */
        public final gv f10423v;
        @Nullable

        /* renamed from: w  reason: collision with root package name */
        public final String f10424w;
        public final String y;

        /* renamed from: z  reason: collision with root package name */
        public final long f10425z;

        @Override // java.lang.Comparable
        /* renamed from: y */
        public int compareTo(Long l2) {
            if (this.f10417f > l2.longValue()) {
                return 1;
            }
            if (this.f10417f < l2.longValue()) {
                return -1;
            }
            return 0;
        }

        public v(String str, @Nullable gv gvVar, long j2, int i, long j4, @Nullable DrmInitData drmInitData, @Nullable String str2, @Nullable String str3, long j6, long j7, boolean z2) {
            this.y = str;
            this.f10423v = gvVar;
            this.f10418fb = j2;
            this.f10421s = i;
            this.f10417f = j4;
            this.f10422t = drmInitData;
            this.f10424w = str2;
            this.f10419p = str3;
            this.f10416co = j6;
            this.f10425z = j7;
            this.f10420r = z2;
        }
    }

    /* loaded from: classes.dex */
    public static final class zn {

        /* renamed from: n3  reason: collision with root package name */
        public final long f10426n3;
        public final Uri y;

        /* renamed from: zn  reason: collision with root package name */
        public final int f10427zn;

        public zn(Uri uri, long j2, int i) {
            this.y = uri;
            this.f10426n3 = j2;
            this.f10427zn = i;
        }
    }

    public fb(int i, String str, List<String> list, long j2, boolean z2, long j4, boolean z3, int i5, long j6, int i6, long j7, long j8, boolean z4, boolean z5, boolean z7, @Nullable DrmInitData drmInitData, List<gv> list2, List<n3> list3, a aVar, Map<Uri, zn> map) {
        super(str, list, z4);
        this.f10394gv = i;
        this.f10399s = j4;
        this.f10393fb = z2;
        this.f10390c5 = z3;
        this.f10395i9 = i5;
        this.f10392f = j6;
        this.f10400t = i6;
        this.f10401tl = j7;
        this.f10404wz = j8;
        this.f10406xc = z5;
        this.f10403w = z7;
        this.f10397p = drmInitData;
        this.f10396mt = x4.d(list2);
        this.f10391co = x4.d(list3);
        this.f10407z = f3.s(map);
        if (!list3.isEmpty()) {
            n3 n3Var = (n3) d0.v(list3);
            this.f10398r = n3Var.f10417f + n3Var.f10418fb;
        } else if (!list2.isEmpty()) {
            gv gvVar = (gv) d0.v(list2);
            this.f10398r = gvVar.f10417f + gvVar.f10418fb;
        } else {
            this.f10398r = 0L;
        }
        long j9 = -9223372036854775807L;
        if (j2 != -9223372036854775807L) {
            if (j2 >= 0) {
                j9 = Math.min(this.f10398r, j2);
            } else {
                j9 = Math.max(0L, this.f10398r + j2);
            }
        }
        this.f10402v = j9;
        this.f10389a = j2 >= 0;
        this.f10405x4 = aVar;
    }

    public boolean a(@Nullable fb fbVar) {
        if (fbVar == null) {
            return true;
        }
        long j2 = this.f10392f;
        long j4 = fbVar.f10392f;
        if (j2 > j4) {
            return true;
        }
        if (j2 < j4) {
            return false;
        }
        int size = this.f10396mt.size() - fbVar.f10396mt.size();
        if (size != 0) {
            if (size > 0) {
                return true;
            }
            return false;
        }
        int size2 = this.f10391co.size();
        int size3 = fbVar.f10391co.size();
        if (size2 > size3) {
            return true;
        }
        if (size2 == size3 && this.f10406xc && !fbVar.f10406xc) {
            return true;
        }
        return false;
    }

    public fb gv() {
        if (this.f10406xc) {
            return this;
        }
        return new fb(this.f10394gv, this.y, this.f10387n3, this.f10402v, this.f10393fb, this.f10399s, this.f10390c5, this.f10395i9, this.f10392f, this.f10400t, this.f10401tl, this.f10404wz, this.f10388zn, true, this.f10403w, this.f10397p, this.f10396mt, this.f10391co, this.f10405x4, this.f10407z);
    }

    public long v() {
        return this.f10399s + this.f10398r;
    }

    public fb zn(long j2, int i) {
        return new fb(this.f10394gv, this.y, this.f10387n3, this.f10402v, this.f10393fb, j2, true, i, this.f10392f, this.f10400t, this.f10401tl, this.f10404wz, this.f10388zn, this.f10406xc, this.f10403w, this.f10397p, this.f10396mt, this.f10391co, this.f10405x4, this.f10407z);
    }

    /* loaded from: classes.dex */
    public static final class gv extends v {

        /* renamed from: f3  reason: collision with root package name */
        public final String f10412f3;

        /* renamed from: n  reason: collision with root package name */
        public final List<n3> f10413n;

        public gv(String str, long j2, long j4, @Nullable String str2, @Nullable String str3) {
            this(str, null, "", 0L, -1, -9223372036854775807L, null, str2, str3, j2, j4, false, x4.j5());
        }

        public gv n3(long j2, int i) {
            ArrayList arrayList = new ArrayList();
            long j4 = j2;
            for (int i5 = 0; i5 < this.f10413n.size(); i5++) {
                n3 n3Var = this.f10413n.get(i5);
                arrayList.add(n3Var.n3(j4, i));
                j4 += n3Var.f10418fb;
            }
            return new gv(this.y, this.f10423v, this.f10412f3, this.f10418fb, i, j2, this.f10422t, this.f10424w, this.f10419p, this.f10416co, this.f10425z, this.f10420r, arrayList);
        }

        public gv(String str, @Nullable gv gvVar, String str2, long j2, int i, long j4, @Nullable DrmInitData drmInitData, @Nullable String str3, @Nullable String str4, long j6, long j7, boolean z2, List<n3> list) {
            super(str, gvVar, j2, i, j4, drmInitData, str3, str4, j6, j7, z2);
            this.f10412f3 = str2;
            this.f10413n = x4.d(list);
        }
    }

    @Override // ea.y
    /* renamed from: n3 */
    public fb y(List<StreamKey> list) {
        return this;
    }
}
