package qj;

import android.os.Build;
import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public abstract class y implements qj.v {

    /* renamed from: zn  reason: collision with root package name */
    public static final Set<y> f12988zn = new HashSet();

    /* renamed from: n3  reason: collision with root package name */
    public final String f12989n3;
    public final String y;

    /* loaded from: classes.dex */
    public static class a extends y {
        public a(@NonNull String str, @NonNull String str2) {
            super(str, str2);
        }

        @Override // qj.y
        public final boolean n3() {
            if (Build.VERSION.SDK_INT >= 27) {
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public static class c5 extends y {
        public c5(@NonNull String str, @NonNull String str2) {
            super(str, str2);
        }

        @Override // qj.y
        public final boolean n3() {
            if (Build.VERSION.SDK_INT >= 33) {
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public static class fb extends y {
        public fb(@NonNull String str, @NonNull String str2) {
            super(str, str2);
        }

        @Override // qj.y
        public final boolean n3() {
            if (Build.VERSION.SDK_INT >= 28) {
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public static class gv extends y {
        public gv(@NonNull String str, @NonNull String str2) {
            super(str, str2);
        }

        @Override // qj.y
        public final boolean n3() {
            return false;
        }
    }

    /* loaded from: classes.dex */
    public static class n3 extends y {
        public n3(@NonNull String str, @NonNull String str2) {
            super(str, str2);
        }

        @Override // qj.y
        public final boolean n3() {
            if (Build.VERSION.SDK_INT >= 23) {
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public static class s extends y {
        public s(@NonNull String str, @NonNull String str2) {
            super(str, str2);
        }

        @Override // qj.y
        public final boolean n3() {
            if (Build.VERSION.SDK_INT >= 29) {
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public static class v extends y {
        public v(@NonNull String str, @NonNull String str2) {
            super(str, str2);
        }

        @Override // qj.y
        public final boolean n3() {
            if (Build.VERSION.SDK_INT >= 26) {
                return true;
            }
            return false;
        }
    }

    /* renamed from: qj.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0188y {
        public static final Set<String> y = new HashSet(Arrays.asList(tl.zn().y()));
    }

    /* loaded from: classes.dex */
    public static class zn extends y {
        public zn(@NonNull String str, @NonNull String str2) {
            super(str, str2);
        }

        @Override // qj.y
        public final boolean n3() {
            if (Build.VERSION.SDK_INT >= 24) {
                return true;
            }
            return false;
        }
    }

    public y(@NonNull String str, @NonNull String str2) {
        this.y = str;
        this.f12989n3 = str2;
        f12988zn.add(this);
    }

    @NonNull
    public static Set<y> v() {
        return Collections.unmodifiableSet(f12988zn);
    }

    public boolean gv() {
        return cd1.y.n3(C0188y.y, this.f12989n3);
    }

    public abstract boolean n3();

    @Override // qj.v
    @NonNull
    public String y() {
        return this.y;
    }

    @Override // qj.v
    public boolean zn() {
        if (!n3() && !gv()) {
            return false;
        }
        return true;
    }
}
