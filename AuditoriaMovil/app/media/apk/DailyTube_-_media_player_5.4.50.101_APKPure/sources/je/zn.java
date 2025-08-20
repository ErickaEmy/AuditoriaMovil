package je;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import je.zn;
import m1.s;
import v5.j5;
/* loaded from: classes.dex */
public final class zn implements s {

    /* renamed from: f  reason: collision with root package name */
    public final int f9431f;

    /* renamed from: fb  reason: collision with root package name */
    public final long f9432fb;

    /* renamed from: s  reason: collision with root package name */
    public final long f9433s;

    /* renamed from: t  reason: collision with root package name */
    public final y[] f9434t;

    /* renamed from: v  reason: collision with root package name */
    public final int f9435v;
    @Nullable
    public final Object y;

    /* renamed from: w  reason: collision with root package name */
    public static final zn f9429w = new zn(null, new y[0], 0, -9223372036854775807L, 0);

    /* renamed from: p  reason: collision with root package name */
    public static final y f9427p = new y(0).c5(0);

    /* renamed from: co  reason: collision with root package name */
    public static final String f9424co = j5.g3(1);

    /* renamed from: z  reason: collision with root package name */
    public static final String f9430z = j5.g3(2);

    /* renamed from: r  reason: collision with root package name */
    public static final String f9428r = j5.g3(3);

    /* renamed from: f3  reason: collision with root package name */
    public static final String f9425f3 = j5.g3(4);

    /* renamed from: n  reason: collision with root package name */
    public static final s.y<zn> f9426n = new s.y() { // from class: je.y
        @Override // m1.s.y
        public final s fromBundle(Bundle bundle) {
            zn n32;
            n32 = zn.n3(bundle);
            return n32;
        }
    };

    /* loaded from: classes.dex */
    public static final class y implements s {

        /* renamed from: f  reason: collision with root package name */
        public final int[] f9445f;

        /* renamed from: fb  reason: collision with root package name */
        public final int f9446fb;

        /* renamed from: p  reason: collision with root package name */
        public final boolean f9447p;

        /* renamed from: s  reason: collision with root package name */
        public final Uri[] f9448s;

        /* renamed from: t  reason: collision with root package name */
        public final long[] f9449t;

        /* renamed from: v  reason: collision with root package name */
        public final int f9450v;

        /* renamed from: w  reason: collision with root package name */
        public final long f9451w;
        public final long y;

        /* renamed from: co  reason: collision with root package name */
        public static final String f9437co = j5.g3(0);

        /* renamed from: z  reason: collision with root package name */
        public static final String f9444z = j5.g3(1);

        /* renamed from: r  reason: collision with root package name */
        public static final String f9443r = j5.g3(2);

        /* renamed from: f3  reason: collision with root package name */
        public static final String f9440f3 = j5.g3(3);

        /* renamed from: n  reason: collision with root package name */
        public static final String f9442n = j5.g3(4);

        /* renamed from: c  reason: collision with root package name */
        public static final String f9436c = j5.g3(5);

        /* renamed from: d0  reason: collision with root package name */
        public static final String f9439d0 = j5.g3(6);

        /* renamed from: fh  reason: collision with root package name */
        public static final String f9441fh = j5.g3(7);

        /* renamed from: d  reason: collision with root package name */
        public static final s.y<y> f9438d = new s.y() { // from class: je.n3
            @Override // m1.s.y
            public final s fromBundle(Bundle bundle) {
                zn.y gv2;
                gv2 = zn.y.gv(bundle);
                return gv2;
            }
        };

        public y(long j2) {
            this(j2, -1, -1, new int[0], new Uri[0], new long[0], 0L, false);
        }

        public static y gv(Bundle bundle) {
            Uri[] uriArr;
            long[] jArr;
            long j2 = bundle.getLong(f9437co);
            int i = bundle.getInt(f9444z);
            int i5 = bundle.getInt(f9441fh);
            ArrayList parcelableArrayList = bundle.getParcelableArrayList(f9443r);
            int[] intArray = bundle.getIntArray(f9440f3);
            long[] longArray = bundle.getLongArray(f9442n);
            long j4 = bundle.getLong(f9436c);
            boolean z2 = bundle.getBoolean(f9439d0);
            if (intArray == null) {
                intArray = new int[0];
            }
            int[] iArr = intArray;
            if (parcelableArrayList == null) {
                uriArr = new Uri[0];
            } else {
                uriArr = (Uri[]) parcelableArrayList.toArray(new Uri[0]);
            }
            if (longArray == null) {
                jArr = new long[0];
            } else {
                jArr = longArray;
            }
            return new y(j2, i, i5, iArr, uriArr, jArr, j4, z2);
        }

        @CheckResult
        public static long[] n3(long[] jArr, int i) {
            int length = jArr.length;
            int max = Math.max(i, length);
            long[] copyOf = Arrays.copyOf(jArr, max);
            Arrays.fill(copyOf, length, max, -9223372036854775807L);
            return copyOf;
        }

        @CheckResult
        public static int[] zn(int[] iArr, int i) {
            int length = iArr.length;
            int max = Math.max(i, length);
            int[] copyOf = Arrays.copyOf(iArr, max);
            Arrays.fill(copyOf, length, max, 0);
            return copyOf;
        }

        public int a(int i) {
            int i5;
            int i6 = i + 1;
            while (true) {
                int[] iArr = this.f9445f;
                if (i6 >= iArr.length || this.f9447p || (i5 = iArr[i6]) == 0 || i5 == 1) {
                    break;
                }
                i6++;
            }
            return i6;
        }

        @CheckResult
        public y c5(int i) {
            int[] zn2 = zn(this.f9445f, i);
            long[] n32 = n3(this.f9449t, i);
            return new y(this.y, i, this.f9446fb, zn2, (Uri[]) Arrays.copyOf(this.f9448s, i), n32, this.f9451w, this.f9447p);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || y.class != obj.getClass()) {
                return false;
            }
            y yVar = (y) obj;
            if (this.y == yVar.y && this.f9450v == yVar.f9450v && this.f9446fb == yVar.f9446fb && Arrays.equals(this.f9448s, yVar.f9448s) && Arrays.equals(this.f9445f, yVar.f9445f) && Arrays.equals(this.f9449t, yVar.f9449t) && this.f9451w == yVar.f9451w && this.f9447p == yVar.f9447p) {
                return true;
            }
            return false;
        }

        public boolean fb() {
            if (this.f9450v == -1) {
                return true;
            }
            for (int i = 0; i < this.f9450v; i++) {
                int i5 = this.f9445f[i];
                if (i5 == 0 || i5 == 1) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            long j2 = this.y;
            long j4 = this.f9451w;
            return (((((((((((((this.f9450v * 31) + this.f9446fb) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + Arrays.hashCode(this.f9448s)) * 31) + Arrays.hashCode(this.f9445f)) * 31) + Arrays.hashCode(this.f9449t)) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31) + (this.f9447p ? 1 : 0);
        }

        public boolean s() {
            if (this.f9450v != -1 && v() >= this.f9450v) {
                return false;
            }
            return true;
        }

        @Override // m1.s
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putLong(f9437co, this.y);
            bundle.putInt(f9444z, this.f9450v);
            bundle.putInt(f9441fh, this.f9446fb);
            bundle.putParcelableArrayList(f9443r, new ArrayList<>(Arrays.asList(this.f9448s)));
            bundle.putIntArray(f9440f3, this.f9445f);
            bundle.putLongArray(f9442n, this.f9449t);
            bundle.putLong(f9436c, this.f9451w);
            bundle.putBoolean(f9439d0, this.f9447p);
            return bundle;
        }

        public int v() {
            return a(-1);
        }

        public y(long j2, int i, int i5, int[] iArr, Uri[] uriArr, long[] jArr, long j4, boolean z2) {
            v5.y.y(iArr.length == uriArr.length);
            this.y = j2;
            this.f9450v = i;
            this.f9446fb = i5;
            this.f9445f = iArr;
            this.f9448s = uriArr;
            this.f9449t = jArr;
            this.f9451w = j4;
            this.f9447p = z2;
        }
    }

    public zn(@Nullable Object obj, y[] yVarArr, long j2, long j4, int i) {
        this.y = obj;
        this.f9432fb = j2;
        this.f9433s = j4;
        this.f9435v = yVarArr.length + i;
        this.f9434t = yVarArr;
        this.f9431f = i;
    }

    public static zn n3(Bundle bundle) {
        y[] yVarArr;
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(f9424co);
        if (parcelableArrayList == null) {
            yVarArr = new y[0];
        } else {
            y[] yVarArr2 = new y[parcelableArrayList.size()];
            for (int i = 0; i < parcelableArrayList.size(); i++) {
                yVarArr2[i] = y.f9438d.fromBundle((Bundle) parcelableArrayList.get(i));
            }
            yVarArr = yVarArr2;
        }
        String str = f9430z;
        zn znVar = f9429w;
        return new zn(null, yVarArr, bundle.getLong(str, znVar.f9432fb), bundle.getLong(f9428r, znVar.f9433s), bundle.getInt(f9425f3, znVar.f9431f));
    }

    public final boolean a(long j2, long j4, int i) {
        if (j2 == Long.MIN_VALUE) {
            return false;
        }
        long j6 = zn(i).y;
        if (j6 == Long.MIN_VALUE) {
            if (j4 != -9223372036854775807L && j2 >= j4) {
                return false;
            }
            return true;
        } else if (j2 >= j6) {
            return false;
        } else {
            return true;
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zn.class != obj.getClass()) {
            return false;
        }
        zn znVar = (zn) obj;
        if (j5.zn(this.y, znVar.y) && this.f9435v == znVar.f9435v && this.f9432fb == znVar.f9432fb && this.f9433s == znVar.f9433s && this.f9431f == znVar.f9431f && Arrays.equals(this.f9434t, znVar.f9434t)) {
            return true;
        }
        return false;
    }

    public int gv(long j2, long j4) {
        if (j2 == Long.MIN_VALUE) {
            return -1;
        }
        if (j4 != -9223372036854775807L && j2 >= j4) {
            return -1;
        }
        int i = this.f9431f;
        while (i < this.f9435v && ((zn(i).y != Long.MIN_VALUE && zn(i).y <= j2) || !zn(i).s())) {
            i++;
        }
        if (i >= this.f9435v) {
            return -1;
        }
        return i;
    }

    public int hashCode() {
        int hashCode;
        int i = this.f9435v * 31;
        Object obj = this.y;
        if (obj == null) {
            hashCode = 0;
        } else {
            hashCode = obj.hashCode();
        }
        return ((((((((i + hashCode) * 31) + ((int) this.f9432fb)) * 31) + ((int) this.f9433s)) * 31) + this.f9431f) * 31) + Arrays.hashCode(this.f9434t);
    }

    @Override // m1.s
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        for (y yVar : this.f9434t) {
            arrayList.add(yVar.toBundle());
        }
        if (!arrayList.isEmpty()) {
            bundle.putParcelableArrayList(f9424co, arrayList);
        }
        long j2 = this.f9432fb;
        zn znVar = f9429w;
        if (j2 != znVar.f9432fb) {
            bundle.putLong(f9430z, j2);
        }
        long j4 = this.f9433s;
        if (j4 != znVar.f9433s) {
            bundle.putLong(f9428r, j4);
        }
        int i = this.f9431f;
        if (i != znVar.f9431f) {
            bundle.putInt(f9425f3, i);
        }
        return bundle;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AdPlaybackState(adsId=");
        sb.append(this.y);
        sb.append(", adResumePositionUs=");
        sb.append(this.f9432fb);
        sb.append(", adGroups=[");
        for (int i = 0; i < this.f9434t.length; i++) {
            sb.append("adGroup(timeUs=");
            sb.append(this.f9434t[i].y);
            sb.append(", ads=[");
            for (int i5 = 0; i5 < this.f9434t[i].f9445f.length; i5++) {
                sb.append("ad(state=");
                int i6 = this.f9434t[i].f9445f[i5];
                if (i6 != 0) {
                    if (i6 != 1) {
                        if (i6 != 2) {
                            if (i6 != 3) {
                                if (i6 != 4) {
                                    sb.append('?');
                                } else {
                                    sb.append('!');
                                }
                            } else {
                                sb.append('P');
                            }
                        } else {
                            sb.append('S');
                        }
                    } else {
                        sb.append('R');
                    }
                } else {
                    sb.append('_');
                }
                sb.append(", durationUs=");
                sb.append(this.f9434t[i].f9449t[i5]);
                sb.append(')');
                if (i5 < this.f9434t[i].f9445f.length - 1) {
                    sb.append(", ");
                }
            }
            sb.append("])");
            if (i < this.f9434t.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("])");
        return sb.toString();
    }

    public int v(long j2, long j4) {
        int i = this.f9435v - 1;
        while (i >= 0 && a(j2, j4, i)) {
            i--;
        }
        if (i < 0 || !zn(i).fb()) {
            return -1;
        }
        return i;
    }

    public y zn(int i) {
        int i5 = this.f9431f;
        if (i < i5) {
            return f9427p;
        }
        return this.f9434t[i - i5];
    }
}
