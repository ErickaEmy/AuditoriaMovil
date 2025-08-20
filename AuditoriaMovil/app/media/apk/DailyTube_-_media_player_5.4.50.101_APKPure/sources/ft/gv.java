package ft;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public final class gv {

    /* renamed from: a  reason: collision with root package name */
    public int f8245a;

    /* renamed from: s  reason: collision with root package name */
    public int f8253s;

    /* renamed from: xc  reason: collision with root package name */
    public float f8259xc;
    public String y = "";

    /* renamed from: n3  reason: collision with root package name */
    public String f8251n3 = "";

    /* renamed from: zn  reason: collision with root package name */
    public Set<String> f8260zn = Collections.emptySet();

    /* renamed from: gv  reason: collision with root package name */
    public String f8249gv = "";
    @Nullable

    /* renamed from: v  reason: collision with root package name */
    public String f8256v = null;

    /* renamed from: fb  reason: collision with root package name */
    public boolean f8248fb = false;

    /* renamed from: c5  reason: collision with root package name */
    public boolean f8246c5 = false;

    /* renamed from: i9  reason: collision with root package name */
    public int f8250i9 = -1;

    /* renamed from: f  reason: collision with root package name */
    public int f8247f = -1;

    /* renamed from: t  reason: collision with root package name */
    public int f8254t = -1;

    /* renamed from: tl  reason: collision with root package name */
    public int f8255tl = -1;

    /* renamed from: wz  reason: collision with root package name */
    public int f8258wz = -1;

    /* renamed from: w  reason: collision with root package name */
    public int f8257w = -1;

    /* renamed from: p  reason: collision with root package name */
    public boolean f8252p = false;

    public static int fh(int i, String str, @Nullable String str2, int i5) {
        if (!str.isEmpty() && i != -1) {
            if (!str.equals(str2)) {
                return -1;
            }
            return i + i5;
        }
        return i;
    }

    public int a() {
        return this.f8258wz;
    }

    public void c(String str) {
        this.f8249gv = str;
    }

    public int c5() {
        int i;
        int i5 = this.f8254t;
        if (i5 == -1 && this.f8255tl == -1) {
            return -1;
        }
        int i6 = 0;
        if (i5 == 1) {
            i = 1;
        } else {
            i = 0;
        }
        if (this.f8255tl == 1) {
            i6 = 2;
        }
        return i | i6;
    }

    public gv co(float f4) {
        this.f8259xc = f4;
        return this;
    }

    public gv d0(boolean z2) {
        this.f8247f = z2 ? 1 : 0;
        return this;
    }

    public boolean f() {
        return this.f8248fb;
    }

    public void f3(String str) {
        this.y = str;
    }

    public int fb() {
        return this.f8257w;
    }

    @Nullable
    public String gv() {
        return this.f8256v;
    }

    public void i4(String[] strArr) {
        this.f8260zn = new HashSet(Arrays.asList(strArr));
    }

    public boolean i9() {
        return this.f8246c5;
    }

    public gv mt(@Nullable String str) {
        String v2;
        if (str == null) {
            v2 = null;
        } else {
            v2 = w0.zn.v(str);
        }
        this.f8256v = v2;
        return this;
    }

    public void n(String str) {
        this.f8251n3 = str;
    }

    public boolean n3() {
        return this.f8252p;
    }

    public gv p(int i) {
        this.f8245a = i;
        this.f8248fb = true;
        return this;
    }

    public gv r(boolean z2) {
        this.f8255tl = z2 ? 1 : 0;
        return this;
    }

    public int s(@Nullable String str, @Nullable String str2, Set<String> set, @Nullable String str3) {
        if (this.y.isEmpty() && this.f8251n3.isEmpty() && this.f8260zn.isEmpty() && this.f8249gv.isEmpty()) {
            return TextUtils.isEmpty(str2) ? 1 : 0;
        }
        int fh2 = fh(fh(fh(0, this.y, str, 1073741824), this.f8251n3, str2, 2), this.f8249gv, str3, 4);
        if (fh2 == -1 || !set.containsAll(this.f8260zn)) {
            return 0;
        }
        return fh2 + (this.f8260zn.size() * 4);
    }

    public boolean t() {
        if (this.f8250i9 == 1) {
            return true;
        }
        return false;
    }

    public boolean tl() {
        if (this.f8247f == 1) {
            return true;
        }
        return false;
    }

    public float v() {
        return this.f8259xc;
    }

    public gv w(boolean z2) {
        this.f8252p = z2;
        return this;
    }

    public gv wz(int i) {
        this.f8253s = i;
        this.f8246c5 = true;
        return this;
    }

    public gv x4(int i) {
        this.f8257w = i;
        return this;
    }

    public gv xc(boolean z2) {
        this.f8254t = z2 ? 1 : 0;
        return this;
    }

    public int y() {
        if (this.f8246c5) {
            return this.f8253s;
        }
        throw new IllegalStateException("Background color not defined.");
    }

    public gv z(int i) {
        this.f8258wz = i;
        return this;
    }

    public int zn() {
        if (this.f8248fb) {
            return this.f8245a;
        }
        throw new IllegalStateException("Font color not defined");
    }
}
