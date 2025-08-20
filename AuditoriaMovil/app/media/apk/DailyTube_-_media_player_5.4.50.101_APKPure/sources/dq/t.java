package dq;

import android.net.Uri;
import androidx.annotation.Nullable;
import v5.vl;
/* loaded from: classes.dex */
public final class t {

    /* renamed from: gv  reason: collision with root package name */
    public int f7379gv;

    /* renamed from: n3  reason: collision with root package name */
    public final long f7380n3;
    public final long y;

    /* renamed from: zn  reason: collision with root package name */
    public final String f7381zn;

    public t(@Nullable String str, long j2, long j4) {
        this.f7381zn = str == null ? "" : str;
        this.y = j2;
        this.f7380n3 = j4;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || t.class != obj.getClass()) {
            return false;
        }
        t tVar = (t) obj;
        if (this.y == tVar.y && this.f7380n3 == tVar.f7380n3 && this.f7381zn.equals(tVar.f7381zn)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (this.f7379gv == 0) {
            this.f7379gv = ((((527 + ((int) this.y)) * 31) + ((int) this.f7380n3)) * 31) + this.f7381zn.hashCode();
        }
        return this.f7379gv;
    }

    public Uri n3(String str) {
        return vl.v(str, this.f7381zn);
    }

    public String toString() {
        return "RangedUri(referenceUri=" + this.f7381zn + ", start=" + this.y + ", length=" + this.f7380n3 + ")";
    }

    @Nullable
    public t y(@Nullable t tVar, String str) {
        String zn2 = zn(str);
        if (tVar != null && zn2.equals(tVar.zn(str))) {
            long j2 = this.f7380n3;
            long j4 = -1;
            if (j2 != -1) {
                long j6 = this.y;
                if (j6 + j2 == tVar.y) {
                    long j7 = tVar.f7380n3;
                    if (j7 != -1) {
                        j4 = j2 + j7;
                    }
                    return new t(zn2, j6, j4);
                }
            }
            long j8 = tVar.f7380n3;
            if (j8 != -1) {
                long j9 = tVar.y;
                if (j9 + j8 == this.y) {
                    if (j2 != -1) {
                        j4 = j8 + j2;
                    }
                    return new t(zn2, j9, j4);
                }
            }
        }
        return null;
    }

    public String zn(String str) {
        return vl.gv(str, this.f7381zn);
    }
}
