package yt;

import java.util.Locale;
/* loaded from: classes.dex */
public final class v {

    /* renamed from: a  reason: collision with root package name */
    public static final yt.gv f15478a;

    /* renamed from: gv  reason: collision with root package name */
    public static final yt.gv f15479gv;

    /* renamed from: v  reason: collision with root package name */
    public static final yt.gv f15481v;

    /* renamed from: zn  reason: collision with root package name */
    public static final yt.gv f15482zn;
    public static final yt.gv y = new C0256v(null, false);

    /* renamed from: n3  reason: collision with root package name */
    public static final yt.gv f15480n3 = new C0256v(null, true);

    /* loaded from: classes.dex */
    public static class a extends gv {

        /* renamed from: n3  reason: collision with root package name */
        public static final a f15483n3 = new a();

        public a() {
            super(null);
        }

        @Override // yt.v.gv
        public boolean n3() {
            if (yt.a.y(Locale.getDefault()) == 1) {
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class gv implements yt.gv {
        public final zn y;

        public gv(zn znVar) {
            this.y = znVar;
        }

        public abstract boolean n3();

        @Override // yt.gv
        public boolean y(CharSequence charSequence, int i, int i5) {
            if (charSequence != null && i >= 0 && i5 >= 0 && charSequence.length() - i5 >= i) {
                if (this.y == null) {
                    return n3();
                }
                return zn(charSequence, i, i5);
            }
            throw new IllegalArgumentException();
        }

        public final boolean zn(CharSequence charSequence, int i, int i5) {
            int y = this.y.y(charSequence, i, i5);
            if (y == 0) {
                return true;
            }
            if (y != 1) {
                return n3();
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public static class n3 implements zn {
        public static final n3 y = new n3();

        @Override // yt.v.zn
        public int y(CharSequence charSequence, int i, int i5) {
            int i6 = i5 + i;
            int i8 = 2;
            while (i < i6 && i8 == 2) {
                i8 = v.n3(Character.getDirectionality(charSequence.charAt(i)));
                i++;
            }
            return i8;
        }
    }

    /* renamed from: yt.v$v  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0256v extends gv {

        /* renamed from: n3  reason: collision with root package name */
        public final boolean f15484n3;

        public C0256v(zn znVar, boolean z2) {
            super(znVar);
            this.f15484n3 = z2;
        }

        @Override // yt.v.gv
        public boolean n3() {
            return this.f15484n3;
        }
    }

    /* loaded from: classes.dex */
    public static class y implements zn {

        /* renamed from: n3  reason: collision with root package name */
        public static final y f15485n3 = new y(true);
        public final boolean y;

        public y(boolean z2) {
            this.y = z2;
        }

        @Override // yt.v.zn
        public int y(CharSequence charSequence, int i, int i5) {
            int i6 = i5 + i;
            boolean z2 = false;
            while (i < i6) {
                int y = v.y(Character.getDirectionality(charSequence.charAt(i)));
                if (y != 0) {
                    if (y == 1) {
                        if (!this.y) {
                            return 1;
                        }
                    } else {
                        continue;
                        i++;
                    }
                } else if (this.y) {
                    return 0;
                }
                z2 = true;
                i++;
            }
            if (z2) {
                return this.y ? 1 : 0;
            }
            return 2;
        }
    }

    /* loaded from: classes.dex */
    public interface zn {
        int y(CharSequence charSequence, int i, int i5);
    }

    static {
        n3 n3Var = n3.y;
        f15482zn = new C0256v(n3Var, false);
        f15479gv = new C0256v(n3Var, true);
        f15481v = new C0256v(y.f15485n3, false);
        f15478a = a.f15483n3;
    }

    public static int n3(int i) {
        if (i != 0) {
            if (i == 1 || i == 2) {
                return 0;
            }
            switch (i) {
                case 14:
                case 15:
                    break;
                case 16:
                case 17:
                    return 0;
                default:
                    return 2;
            }
        }
        return 1;
    }

    public static int y(int i) {
        if (i == 0) {
            return 1;
        }
        if (i != 1 && i != 2) {
            return 2;
        }
        return 0;
    }
}
