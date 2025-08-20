package wn;

import android.os.Bundle;
import androidx.annotation.Nullable;
import java.util.Arrays;
import m1.s;
import v5.j5;
/* loaded from: classes.dex */
public final class zn implements m1.s {

    /* renamed from: f  reason: collision with root package name */
    public int f14659f;

    /* renamed from: fb  reason: collision with root package name */
    public final int f14660fb;
    @Nullable

    /* renamed from: s  reason: collision with root package name */
    public final byte[] f14661s;

    /* renamed from: v  reason: collision with root package name */
    public final int f14662v;
    public final int y;

    /* renamed from: t  reason: collision with root package name */
    public static final zn f14656t = new zn(1, 2, 3, null);

    /* renamed from: w  reason: collision with root package name */
    public static final String f14657w = j5.g3(0);

    /* renamed from: p  reason: collision with root package name */
    public static final String f14654p = j5.g3(1);

    /* renamed from: co  reason: collision with root package name */
    public static final String f14653co = j5.g3(2);

    /* renamed from: z  reason: collision with root package name */
    public static final String f14658z = j5.g3(3);

    /* renamed from: r  reason: collision with root package name */
    public static final s.y<zn> f14655r = new s.y() { // from class: wn.n3
        @Override // m1.s.y
        public final m1.s fromBundle(Bundle bundle) {
            zn gv2;
            gv2 = zn.gv(bundle);
            return gv2;
        }
    };

    public zn(int i, int i5, int i6, @Nullable byte[] bArr) {
        this.y = i;
        this.f14662v = i5;
        this.f14660fb = i6;
        this.f14661s = bArr;
    }

    public static /* synthetic */ zn gv(Bundle bundle) {
        return new zn(bundle.getInt(f14657w, -1), bundle.getInt(f14654p, -1), bundle.getInt(f14653co, -1), bundle.getByteArray(f14658z));
    }

    public static int n3(int i) {
        if (i == 1) {
            return 1;
        }
        if (i == 9) {
            return 6;
        }
        if (i != 4 && i != 5 && i != 6 && i != 7) {
            return -1;
        }
        return 2;
    }

    public static int zn(int i) {
        if (i != 1) {
            if (i == 16) {
                return 6;
            }
            if (i == 18) {
                return 7;
            }
            if (i != 6 && i != 7) {
                return -1;
            }
            return 3;
        }
        return 3;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zn.class != obj.getClass()) {
            return false;
        }
        zn znVar = (zn) obj;
        if (this.y == znVar.y && this.f14662v == znVar.f14662v && this.f14660fb == znVar.f14660fb && Arrays.equals(this.f14661s, znVar.f14661s)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (this.f14659f == 0) {
            this.f14659f = ((((((527 + this.y) * 31) + this.f14662v) * 31) + this.f14660fb) * 31) + Arrays.hashCode(this.f14661s);
        }
        return this.f14659f;
    }

    @Override // m1.s
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(f14657w, this.y);
        bundle.putInt(f14654p, this.f14662v);
        bundle.putInt(f14653co, this.f14660fb);
        bundle.putByteArray(f14658z, this.f14661s);
        return bundle;
    }

    public String toString() {
        boolean z2;
        StringBuilder sb = new StringBuilder();
        sb.append("ColorInfo(");
        sb.append(this.y);
        sb.append(", ");
        sb.append(this.f14662v);
        sb.append(", ");
        sb.append(this.f14660fb);
        sb.append(", ");
        if (this.f14661s != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        sb.append(z2);
        sb.append(")");
        return sb.toString();
    }
}
