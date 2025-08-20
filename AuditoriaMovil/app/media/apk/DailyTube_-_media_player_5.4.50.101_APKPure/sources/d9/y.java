package d9;

import androidx.core.app.NotificationCompat;
import m1.ne;
/* loaded from: classes.dex */
public final class y {
    public static final int[] y = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};

    /* renamed from: n3  reason: collision with root package name */
    public static final int[] f7225n3 = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    /* loaded from: classes.dex */
    public static final class n3 {

        /* renamed from: n3  reason: collision with root package name */
        public final int f7226n3;
        public final int y;

        /* renamed from: zn  reason: collision with root package name */
        public final String f7227zn;

        public n3(int i, int i5, String str) {
            this.y = i;
            this.f7226n3 = i5;
            this.f7227zn = str;
        }
    }

    public static n3 a(byte[] bArr) throws ne {
        return v(new v5.fh(bArr), false);
    }

    public static void fb(v5.fh fhVar, int i, int i5) {
        if (fhVar.fb()) {
            v5.r.c5("AacUtil", "Unexpected frameLengthFlag = 1");
        }
        if (fhVar.fb()) {
            fhVar.mt(14);
        }
        boolean fb2 = fhVar.fb();
        if (i5 != 0) {
            if (i == 6 || i == 20) {
                fhVar.mt(3);
            }
            if (fb2) {
                if (i == 22) {
                    fhVar.mt(16);
                }
                if (i == 17 || i == 19 || i == 20 || i == 23) {
                    fhVar.mt(3);
                }
                fhVar.mt(1);
                return;
            }
            return;
        }
        throw new UnsupportedOperationException();
    }

    public static int gv(v5.fh fhVar) throws ne {
        int s2 = fhVar.s(4);
        if (s2 == 15) {
            if (fhVar.n3() >= 24) {
                return fhVar.s(24);
            }
            throw ne.y("AAC header insufficient data", null);
        } else if (s2 < 13) {
            return y[s2];
        } else {
            throw ne.y("AAC header wrong Sampling Frequency Index", null);
        }
    }

    public static byte[] n3(int i, int i5, int i6) {
        return new byte[]{(byte) (((i << 3) & 248) | ((i5 >> 1) & 7)), (byte) (((i5 << 7) & NotificationCompat.FLAG_HIGH_PRIORITY) | ((i6 << 3) & 120))};
    }

    public static n3 v(v5.fh fhVar, boolean z2) throws ne {
        int zn2 = zn(fhVar);
        int gv2 = gv(fhVar);
        int s2 = fhVar.s(4);
        String str = "mp4a.40." + zn2;
        if (zn2 == 5 || zn2 == 29) {
            gv2 = gv(fhVar);
            zn2 = zn(fhVar);
            if (zn2 == 22) {
                s2 = fhVar.s(4);
            }
        }
        if (z2) {
            if (zn2 != 1 && zn2 != 2 && zn2 != 3 && zn2 != 4 && zn2 != 6 && zn2 != 7 && zn2 != 17) {
                switch (zn2) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        break;
                    default:
                        throw ne.s("Unsupported audio object type: " + zn2);
                }
            }
            fb(fhVar, zn2, s2);
            switch (zn2) {
                case 17:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                    int s3 = fhVar.s(2);
                    if (s3 == 2 || s3 == 3) {
                        throw ne.s("Unsupported epConfig: " + s3);
                    }
            }
        }
        int i = f7225n3[s2];
        if (i != -1) {
            return new n3(gv2, i, str);
        }
        throw ne.y(null, null);
    }

    public static byte[] y(int i, int i5) {
        int i6 = 0;
        int i8 = 0;
        int i10 = -1;
        while (true) {
            int[] iArr = y;
            if (i8 >= iArr.length) {
                break;
            }
            if (i == iArr[i8]) {
                i10 = i8;
            }
            i8++;
        }
        int i11 = -1;
        while (true) {
            int[] iArr2 = f7225n3;
            if (i6 >= iArr2.length) {
                break;
            }
            if (i5 == iArr2[i6]) {
                i11 = i6;
            }
            i6++;
        }
        if (i != -1 && i11 != -1) {
            return n3(2, i10, i11);
        }
        throw new IllegalArgumentException("Invalid sample rate or number of channels: " + i + ", " + i5);
    }

    public static int zn(v5.fh fhVar) {
        int s2 = fhVar.s(5);
        if (s2 == 31) {
            return fhVar.s(6) + 32;
        }
        return s2;
    }
}
