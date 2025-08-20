package r4;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.util.HashMap;
import v5.j5;
import z0.x4;
/* loaded from: classes.dex */
public final class n {

    /* renamed from: a  reason: collision with root package name */
    public final int f13071a;
    @Nullable

    /* renamed from: c5  reason: collision with root package name */
    public final String f13072c5;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public final String f13073f;
    @Nullable

    /* renamed from: fb  reason: collision with root package name */
    public final Uri f13074fb;
    @Nullable

    /* renamed from: gv  reason: collision with root package name */
    public final String f13075gv;
    @Nullable

    /* renamed from: i9  reason: collision with root package name */
    public final String f13076i9;

    /* renamed from: n3  reason: collision with root package name */
    public final z0.x4<r4.y> f13077n3;
    @Nullable

    /* renamed from: s  reason: collision with root package name */
    public final String f13078s;
    @Nullable

    /* renamed from: t  reason: collision with root package name */
    public final String f13079t;
    @Nullable

    /* renamed from: v  reason: collision with root package name */
    public final String f13080v;
    public final z0.f3<String, String> y;
    @Nullable

    /* renamed from: zn  reason: collision with root package name */
    public final String f13081zn;

    /* loaded from: classes.dex */
    public static final class n3 {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        public String f13082a;
        @Nullable

        /* renamed from: c5  reason: collision with root package name */
        public String f13083c5;
        @Nullable

        /* renamed from: f  reason: collision with root package name */
        public String f13084f;
        @Nullable

        /* renamed from: fb  reason: collision with root package name */
        public Uri f13085fb;
        @Nullable

        /* renamed from: gv  reason: collision with root package name */
        public String f13086gv;
        @Nullable

        /* renamed from: i9  reason: collision with root package name */
        public String f13087i9;
        @Nullable

        /* renamed from: s  reason: collision with root package name */
        public String f13089s;
        @Nullable

        /* renamed from: t  reason: collision with root package name */
        public String f13090t;
        @Nullable

        /* renamed from: v  reason: collision with root package name */
        public String f13091v;
        public final HashMap<String, String> y = new HashMap<>();

        /* renamed from: n3  reason: collision with root package name */
        public final x4.y<r4.y> f13088n3 = new x4.y<>();

        /* renamed from: zn  reason: collision with root package name */
        public int f13092zn = -1;

        public n3 co(String str) {
            this.f13083c5 = str;
            return this;
        }

        public n3 f3(String str) {
            this.f13082a = str;
            return this;
        }

        public n3 i4(String str) {
            this.f13086gv = str;
            return this;
        }

        public n3 mt(String str) {
            this.f13084f = str;
            return this;
        }

        public n3 n(Uri uri) {
            this.f13085fb = uri;
            return this;
        }

        public n3 p(String str) {
            this.f13089s = str;
            return this;
        }

        public n3 r(String str) {
            this.f13090t = str;
            return this;
        }

        public n3 tl(String str, String str2) {
            this.y.put(str, str2);
            return this;
        }

        public n3 w(int i) {
            this.f13092zn = i;
            return this;
        }

        public n3 wz(r4.y yVar) {
            this.f13088n3.y(yVar);
            return this;
        }

        public n3 x4(String str) {
            this.f13087i9 = str;
            return this;
        }

        public n xc() {
            return new n(this);
        }

        public n3 z(String str) {
            this.f13091v = str;
            return this;
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || n.class != obj.getClass()) {
            return false;
        }
        n nVar = (n) obj;
        if (this.f13071a == nVar.f13071a && this.y.equals(nVar.y) && this.f13077n3.equals(nVar.f13077n3) && j5.zn(this.f13075gv, nVar.f13075gv) && j5.zn(this.f13081zn, nVar.f13081zn) && j5.zn(this.f13080v, nVar.f13080v) && j5.zn(this.f13079t, nVar.f13079t) && j5.zn(this.f13074fb, nVar.f13074fb) && j5.zn(this.f13076i9, nVar.f13076i9) && j5.zn(this.f13073f, nVar.f13073f) && j5.zn(this.f13078s, nVar.f13078s) && j5.zn(this.f13072c5, nVar.f13072c5)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6;
        int hashCode7;
        int hashCode8;
        int hashCode9 = (((217 + this.y.hashCode()) * 31) + this.f13077n3.hashCode()) * 31;
        String str = this.f13075gv;
        int i = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i5 = (hashCode9 + hashCode) * 31;
        String str2 = this.f13081zn;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i6 = (i5 + hashCode2) * 31;
        String str3 = this.f13080v;
        if (str3 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str3.hashCode();
        }
        int i8 = (((i6 + hashCode3) * 31) + this.f13071a) * 31;
        String str4 = this.f13079t;
        if (str4 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = str4.hashCode();
        }
        int i10 = (i8 + hashCode4) * 31;
        Uri uri = this.f13074fb;
        if (uri == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = uri.hashCode();
        }
        int i11 = (i10 + hashCode5) * 31;
        String str5 = this.f13076i9;
        if (str5 == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = str5.hashCode();
        }
        int i12 = (i11 + hashCode6) * 31;
        String str6 = this.f13073f;
        if (str6 == null) {
            hashCode7 = 0;
        } else {
            hashCode7 = str6.hashCode();
        }
        int i13 = (i12 + hashCode7) * 31;
        String str7 = this.f13078s;
        if (str7 == null) {
            hashCode8 = 0;
        } else {
            hashCode8 = str7.hashCode();
        }
        int i14 = (i13 + hashCode8) * 31;
        String str8 = this.f13072c5;
        if (str8 != null) {
            i = str8.hashCode();
        }
        return i14 + i;
    }

    public n(n3 n3Var) {
        this.y = z0.f3.s(n3Var.y);
        this.f13077n3 = n3Var.f13088n3.s();
        this.f13081zn = (String) j5.i9(n3Var.f13086gv);
        this.f13075gv = (String) j5.i9(n3Var.f13091v);
        this.f13080v = (String) j5.i9(n3Var.f13082a);
        this.f13074fb = n3Var.f13085fb;
        this.f13078s = n3Var.f13089s;
        this.f13071a = n3Var.f13092zn;
        this.f13072c5 = n3Var.f13083c5;
        this.f13076i9 = n3Var.f13084f;
        this.f13073f = n3Var.f13090t;
        this.f13079t = n3Var.f13087i9;
    }
}
