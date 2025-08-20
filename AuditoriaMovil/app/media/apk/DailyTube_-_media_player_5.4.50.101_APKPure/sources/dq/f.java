package dq;

import androidx.annotation.Nullable;
import v5.j5;
/* loaded from: classes.dex */
public final class f {
    @Nullable

    /* renamed from: gv  reason: collision with root package name */
    public final String f7357gv;
    @Nullable

    /* renamed from: n3  reason: collision with root package name */
    public final String f7358n3;
    @Nullable

    /* renamed from: v  reason: collision with root package name */
    public final String f7359v;
    @Nullable
    public final String y;
    @Nullable

    /* renamed from: zn  reason: collision with root package name */
    public final String f7360zn;

    public f(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        this.y = str;
        this.f7358n3 = str2;
        this.f7360zn = str3;
        this.f7357gv = str4;
        this.f7359v = str5;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        if (j5.zn(this.y, fVar.y) && j5.zn(this.f7358n3, fVar.f7358n3) && j5.zn(this.f7360zn, fVar.f7360zn) && j5.zn(this.f7357gv, fVar.f7357gv) && j5.zn(this.f7359v, fVar.f7359v)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i;
        int i5;
        int i6;
        int i8;
        String str = this.y;
        int i10 = 0;
        if (str != null) {
            i = str.hashCode();
        } else {
            i = 0;
        }
        int i11 = (527 + i) * 31;
        String str2 = this.f7358n3;
        if (str2 != null) {
            i5 = str2.hashCode();
        } else {
            i5 = 0;
        }
        int i12 = (i11 + i5) * 31;
        String str3 = this.f7360zn;
        if (str3 != null) {
            i6 = str3.hashCode();
        } else {
            i6 = 0;
        }
        int i13 = (i12 + i6) * 31;
        String str4 = this.f7357gv;
        if (str4 != null) {
            i8 = str4.hashCode();
        } else {
            i8 = 0;
        }
        int i14 = (i13 + i8) * 31;
        String str5 = this.f7359v;
        if (str5 != null) {
            i10 = str5.hashCode();
        }
        return i14 + i10;
    }
}
