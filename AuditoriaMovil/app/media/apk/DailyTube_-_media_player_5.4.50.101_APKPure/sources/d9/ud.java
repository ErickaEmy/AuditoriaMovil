package d9;

import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public final class ud {
    public static final String[] y = {"audio/mpeg-L1", "audio/mpeg-L2", "audio/mpeg"};

    /* renamed from: n3  reason: collision with root package name */
    public static final int[] f7190n3 = {44100, 48000, 32000};

    /* renamed from: zn  reason: collision with root package name */
    public static final int[] f7192zn = {32000, 64000, 96000, 128000, 160000, 192000, 224000, 256000, 288000, 320000, 352000, 384000, 416000, 448000};

    /* renamed from: gv  reason: collision with root package name */
    public static final int[] f7189gv = {32000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000, 176000, 192000, 224000, 256000};

    /* renamed from: v  reason: collision with root package name */
    public static final int[] f7191v = {32000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000, 384000};

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f7187a = {32000, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000};

    /* renamed from: fb  reason: collision with root package name */
    public static final int[] f7188fb = {8000, 16000, 24000, 32000, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000};

    /* loaded from: classes.dex */
    public static final class y {

        /* renamed from: a  reason: collision with root package name */
        public int f7193a;

        /* renamed from: fb  reason: collision with root package name */
        public int f7194fb;

        /* renamed from: gv  reason: collision with root package name */
        public int f7195gv;
        @Nullable

        /* renamed from: n3  reason: collision with root package name */
        public String f7196n3;

        /* renamed from: v  reason: collision with root package name */
        public int f7197v;
        public int y;

        /* renamed from: zn  reason: collision with root package name */
        public int f7198zn;

        public boolean y(int i) {
            int i5;
            int i6;
            int i8;
            int i10;
            int i11;
            int i12;
            if (!ud.t(i) || (i5 = (i >>> 19) & 3) == 1 || (i6 = (i >>> 17) & 3) == 0 || (i8 = (i >>> 12) & 15) == 0 || i8 == 15 || (i10 = (i >>> 10) & 3) == 3) {
                return false;
            }
            this.y = i5;
            this.f7196n3 = ud.y[3 - i6];
            int i13 = ud.f7190n3[i10];
            this.f7195gv = i13;
            int i14 = 2;
            if (i5 == 2) {
                this.f7195gv = i13 / 2;
            } else if (i5 == 0) {
                this.f7195gv = i13 / 4;
            }
            int i15 = (i >>> 9) & 1;
            this.f7194fb = ud.f(i5, i6);
            if (i6 == 3) {
                if (i5 == 3) {
                    i12 = ud.f7192zn[i8 - 1];
                } else {
                    i12 = ud.f7189gv[i8 - 1];
                }
                this.f7193a = i12;
                this.f7198zn = (((i12 * 12) / this.f7195gv) + i15) * 4;
            } else {
                int i16 = 144;
                if (i5 == 3) {
                    if (i6 == 2) {
                        i11 = ud.f7191v[i8 - 1];
                    } else {
                        i11 = ud.f7187a[i8 - 1];
                    }
                    this.f7193a = i11;
                    this.f7198zn = ((i11 * 144) / this.f7195gv) + i15;
                } else {
                    int i17 = ud.f7188fb[i8 - 1];
                    this.f7193a = i17;
                    if (i6 == 1) {
                        i16 = 72;
                    }
                    this.f7198zn = ((i16 * i17) / this.f7195gv) + i15;
                }
            }
            if (((i >> 6) & 3) == 3) {
                i14 = 1;
            }
            this.f7197v = i14;
            return true;
        }
    }

    public static int f(int i, int i5) {
        if (i5 != 1) {
            if (i5 == 2) {
                return 1152;
            }
            if (i5 == 3) {
                return 384;
            }
            throw new IllegalArgumentException();
        } else if (i == 3) {
            return 1152;
        } else {
            return 576;
        }
    }

    public static int i9(int i) {
        int i5;
        int i6;
        int i8;
        int i10;
        int i11;
        int i12;
        if (!t(i) || (i5 = (i >>> 19) & 3) == 1 || (i6 = (i >>> 17) & 3) == 0 || (i8 = (i >>> 12) & 15) == 0 || i8 == 15 || (i10 = (i >>> 10) & 3) == 3) {
            return -1;
        }
        int i13 = f7190n3[i10];
        if (i5 == 2) {
            i13 /= 2;
        } else if (i5 == 0) {
            i13 /= 4;
        }
        int i14 = (i >>> 9) & 1;
        if (i6 == 3) {
            if (i5 == 3) {
                i12 = f7192zn[i8 - 1];
            } else {
                i12 = f7189gv[i8 - 1];
            }
            return (((i12 * 12) / i13) + i14) * 4;
        }
        if (i5 == 3) {
            if (i6 == 2) {
                i11 = f7191v[i8 - 1];
            } else {
                i11 = f7187a[i8 - 1];
            }
        } else {
            i11 = f7188fb[i8 - 1];
        }
        int i15 = 144;
        if (i5 == 3) {
            return ((i11 * 144) / i13) + i14;
        }
        if (i6 == 1) {
            i15 = 72;
        }
        return ((i15 * i11) / i13) + i14;
    }

    public static boolean t(int i) {
        if ((i & (-2097152)) == -2097152) {
            return true;
        }
        return false;
    }

    public static int tl(int i) {
        int i5;
        int i6;
        if (!t(i) || (i5 = (i >>> 19) & 3) == 1 || (i6 = (i >>> 17) & 3) == 0) {
            return -1;
        }
        int i8 = (i >>> 12) & 15;
        int i10 = (i >>> 10) & 3;
        if (i8 == 0 || i8 == 15 || i10 == 3) {
            return -1;
        }
        return f(i5, i6);
    }
}
