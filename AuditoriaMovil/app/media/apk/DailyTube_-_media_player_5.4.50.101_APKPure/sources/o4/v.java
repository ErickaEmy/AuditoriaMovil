package o4;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class v implements zn {

    /* renamed from: n3  reason: collision with root package name */
    public int f12143n3;
    public String y;

    /* renamed from: zn  reason: collision with root package name */
    public int f12144zn;

    public v(String str, int i, int i5) {
        this.y = str;
        this.f12143n3 = i;
        this.f12144zn = i5;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        if (this.f12143n3 >= 0 && vVar.f12143n3 >= 0) {
            if (TextUtils.equals(this.y, vVar.y) && this.f12143n3 == vVar.f12143n3 && this.f12144zn == vVar.f12144zn) {
                return true;
            }
            return false;
        } else if (TextUtils.equals(this.y, vVar.y) && this.f12144zn == vVar.f12144zn) {
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return vl.zn.n3(this.y, Integer.valueOf(this.f12144zn));
    }
}
