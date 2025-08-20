package sc1;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zc1.s;
/* loaded from: classes.dex */
public final class zn {

    /* renamed from: a  reason: collision with root package name */
    public static final zc1.s f13844a;

    /* renamed from: c5  reason: collision with root package name */
    public static final zc1.s f13845c5;

    /* renamed from: fb  reason: collision with root package name */
    public static final zc1.s f13846fb;

    /* renamed from: gv  reason: collision with root package name */
    public static final zc1.s f13847gv;

    /* renamed from: i9  reason: collision with root package name */
    public static final y f13848i9 = new y(null);

    /* renamed from: s  reason: collision with root package name */
    public static final zc1.s f13849s;

    /* renamed from: v  reason: collision with root package name */
    public static final zc1.s f13850v;

    /* renamed from: n3  reason: collision with root package name */
    public final zc1.s f13851n3;
    public final int y;

    /* renamed from: zn  reason: collision with root package name */
    public final zc1.s f13852zn;

    /* loaded from: classes.dex */
    public static final class y {
        public y() {
        }

        public /* synthetic */ y(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        s.y yVar = zc1.s.fb;
        f13847gv = yVar.gv(":");
        f13850v = yVar.gv(":status");
        f13844a = yVar.gv(":method");
        f13846fb = yVar.gv(":path");
        f13849s = yVar.gv(":scheme");
        f13845c5 = yVar.gv(":authority");
    }

    public zn(zc1.s name, zc1.s value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        this.f13851n3 = name;
        this.f13852zn = value;
        this.y = name.j() + 32 + value.j();
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof zn) {
                zn znVar = (zn) obj;
                if (!Intrinsics.areEqual(this.f13851n3, znVar.f13851n3) || !Intrinsics.areEqual(this.f13852zn, znVar.f13852zn)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i;
        zc1.s sVar = this.f13851n3;
        int i5 = 0;
        if (sVar != null) {
            i = sVar.hashCode();
        } else {
            i = 0;
        }
        int i6 = i * 31;
        zc1.s sVar2 = this.f13852zn;
        if (sVar2 != null) {
            i5 = sVar2.hashCode();
        }
        return i6 + i5;
    }

    public final zc1.s n3() {
        return this.f13852zn;
    }

    public String toString() {
        return this.f13851n3.dm() + ": " + this.f13852zn.dm();
    }

    public final zc1.s y() {
        return this.f13851n3;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public zn(java.lang.String r2, java.lang.String r3) {
        /*
            r1 = this;
            java.lang.String r0 = "name"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            zc1.s$y r0 = zc1.s.fb
            zc1.s r2 = r0.gv(r2)
            zc1.s r3 = r0.gv(r3)
            r1.<init>(r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: sc1.zn.<init>(java.lang.String, java.lang.String):void");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public zn(zc1.s name, String value) {
        this(name, zc1.s.fb.gv(value));
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
    }
}
