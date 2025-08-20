package com.facebook.ads.redexgen.X;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Region;
import android.util.SparseArray;
import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* loaded from: assets/audience_network.dex */
public final class G7 {
    public static byte[] A07;
    public static String[] A08 = {"qcU5l5rVDanZ0IBZnB67EILhI18GgdFe", "32XpuNghlFeF4zyqPL948gmCUNCGk", "bftD5DkqR73p2Uf2yBhEF5T9UOvyv9s", "0", "qryxRa4yOsFNWhLtu25s3YxhDLRy", "", "tLr9RBWs5E21", "UeFN6nMF8sjHvHxScJIKm37Ehl9oCVg2"};
    public static final byte[] A09;
    public static final byte[] A0A;
    public static final byte[] A0B;
    public Bitmap A00;
    public final Canvas A01;
    public final Paint A02;
    public final Paint A03;
    public final C0647Fz A04;
    public final G0 A05;
    public final G6 A06;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static C0647Fz A04(C0696Hy c0696Hy, int i) {
        int A04;
        int A042;
        int A043;
        int A044;
        int i5 = 8;
        int A045 = c0696Hy.A04(8);
        c0696Hy.A08(8);
        int i6 = i - 2;
        int[] A0F = A0F();
        int[] A0G = A0G();
        int[] A0H = A0H();
        while (i6 > 0) {
            int A046 = c0696Hy.A04(i5);
            int A047 = c0696Hy.A04(i5);
            int i8 = i6 - 2;
            int[] iArr = (A047 & NotificationCompat.FLAG_HIGH_PRIORITY) != 0 ? A0F : (A047 & 64) != 0 ? A0G : A0H;
            if ((A047 & 1) != 0) {
                A04 = c0696Hy.A04(i5);
                A042 = c0696Hy.A04(i5);
                A043 = c0696Hy.A04(i5);
                A044 = c0696Hy.A04(i5);
                i6 = i8 - 4;
            } else {
                A04 = c0696Hy.A04(6) << 2;
                A042 = c0696Hy.A04(4) << 4;
                A043 = c0696Hy.A04(4) << 4;
                A044 = c0696Hy.A04(2) << 6;
                i6 = i8 - 2;
            }
            if (A04 == 0) {
                A042 = 0;
                A043 = 0;
                A044 = 255;
            }
            iArr[A046] = A00((byte) (255 - (A044 & 255)), IF.A06((int) (A04 + ((A042 - 128) * 1.402d)), 0, 255), IF.A06((int) ((A04 - ((A043 - 128) * 0.34414d)) - ((A042 - 128) * 0.71414d)), 0, 255), IF.A06((int) (A04 + ((A043 - 128) * 1.772d)), 0, 255));
            i5 = 8;
        }
        return new C0647Fz(A045, A0F, A0G, A0H);
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static G0 A05(C0696Hy c0696Hy) {
        int i;
        int i5;
        int i6;
        int i8;
        c0696Hy.A08(4);
        boolean A0F = c0696Hy.A0F();
        c0696Hy.A08(3);
        int A04 = c0696Hy.A04(16);
        int A042 = c0696Hy.A04(16);
        if (A0F) {
            i = c0696Hy.A04(16);
            i8 = c0696Hy.A04(16);
            i5 = c0696Hy.A04(16);
            i6 = c0696Hy.A04(16);
        } else {
            i = 0;
            i5 = 0;
            i6 = A042;
            i8 = A04;
        }
        return new G0(A04, A042, i, i8, i5, i6);
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static G4 A08(C0696Hy c0696Hy, int i) {
        int i5 = 8;
        int A04 = c0696Hy.A04(8);
        c0696Hy.A08(4);
        boolean A0F = c0696Hy.A0F();
        c0696Hy.A08(3);
        int A042 = c0696Hy.A04(16);
        int A043 = c0696Hy.A04(16);
        int A044 = c0696Hy.A04(3);
        int A045 = c0696Hy.A04(3);
        c0696Hy.A08(2);
        int A046 = c0696Hy.A04(8);
        int A047 = c0696Hy.A04(8);
        int A048 = c0696Hy.A04(4);
        int A049 = c0696Hy.A04(2);
        c0696Hy.A08(2);
        int i6 = i - 10;
        SparseArray sparseArray = new SparseArray();
        while (i6 > 0) {
            int A0410 = c0696Hy.A04(16);
            int A0411 = c0696Hy.A04(2);
            int A0412 = c0696Hy.A04(2);
            int A0413 = c0696Hy.A04(12);
            c0696Hy.A08(4);
            int A0414 = c0696Hy.A04(12);
            i6 -= 6;
            int i8 = 0;
            int i10 = 0;
            if (A0411 == 1 || A0411 == 2) {
                i8 = c0696Hy.A04(i5);
                i10 = c0696Hy.A04(i5);
                i6 -= 2;
            }
            sparseArray.put(A0410, new G5(A0411, A0412, A0413, A0414, i8, i10));
            i5 = 8;
        }
        return new G4(A04, A0F, A042, A043, A044, A045, A046, A047, A048, A049, sparseArray);
    }

    public static String A09(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A07, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 17);
        }
        return new String(copyOfRange);
    }

    public static void A0A() {
        A07 = new byte[]{18, 55, 34, 55, 118, 48, 63, 51, 58, 50, 118, 58, 51, 56, 49, 34, 62, 118, 51, 46, 53, 51, 51, 50, 37, 118, 58, 63, 59, 63, 34, 106, 88, 76, 126, 79, 92, 93, 75, 92};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public final List<C0635Fn> A0I(byte[] bArr, int i) {
        C0696Hy c0696Hy = new C0696Hy(bArr, i);
        while (c0696Hy.A01() >= 48 && c0696Hy.A04(8) == 15) {
            A0C(c0696Hy, this.A06);
        }
        if (this.A06.A01 == null) {
            return Collections.emptyList();
        }
        G0 g0 = this.A06.A00 != null ? this.A06.A00 : this.A05;
        if (this.A00 == null || g0.A05 + 1 != this.A00.getWidth() || g0.A00 + 1 != this.A00.getHeight()) {
            Bitmap createBitmap = Bitmap.createBitmap(g0.A05 + 1, g0.A00 + 1, Bitmap.Config.ARGB_8888);
            this.A00 = createBitmap;
            this.A01.setBitmap(createBitmap);
        }
        ArrayList arrayList = new ArrayList();
        SparseArray<G3> sparseArray = this.A06.A01.A03;
        for (int i5 = 0; i5 < sparseArray.size(); i5++) {
            G3 valueAt = sparseArray.valueAt(i5);
            G4 g4 = this.A06.A08.get(sparseArray.keyAt(i5));
            int i6 = valueAt.A00 + g0.A02;
            int i8 = valueAt.A01 + g0.A04;
            this.A01.clipRect(i6, i8, Math.min(g4.A08 + i6, g0.A01), Math.min(g4.A02 + i8, g0.A03), Region.Op.REPLACE);
            C0647Fz c0647Fz = this.A06.A06.get(g4.A00);
            if (c0647Fz == null && (c0647Fz = this.A06.A04.get(g4.A00)) == null) {
                c0647Fz = this.A04;
            }
            SparseArray<G5> sparseArray2 = g4.A09;
            for (int i10 = 0; i10 < sparseArray2.size(); i10++) {
                int keyAt = sparseArray2.keyAt(i10);
                G5 valueAt2 = sparseArray2.valueAt(i10);
                G1 g12 = this.A06.A07.get(keyAt);
                String[] strArr = A08;
                if (strArr[0].charAt(24) == strArr[7].charAt(24)) {
                    throw new RuntimeException();
                }
                A08[1] = "0wDldquZfVkccfOmGfzJ1HL0d6oT0";
                if (g12 == null) {
                    g12 = this.A06.A05.get(keyAt);
                }
                if (g12 != null) {
                    A0B(g12, c0647Fz, g4.A01, i6 + valueAt2.A02, i8 + valueAt2.A05, g12.A01 ? null : this.A02, this.A01);
                }
            }
            if (g4.A0A) {
                this.A03.setColor(g4.A01 == 3 ? c0647Fz.A03[g4.A07] : g4.A01 == 2 ? c0647Fz.A02[g4.A06] : c0647Fz.A01[g4.A05]);
                this.A01.drawRect(i6, i8, g4.A08 + i6, g4.A02 + i8, this.A03);
            }
            arrayList.add(new C0635Fn(Bitmap.createBitmap(this.A00, i6, i8, g4.A08, g4.A02), i6 / g0.A05, 0, i8 / g0.A00, 0, g4.A08 / g0.A05, g4.A02 / g0.A00));
            this.A01.drawColor(0, PorterDuff.Mode.CLEAR);
        }
        return arrayList;
    }

    static {
        A0A();
        A09 = new byte[]{0, 7, 8, 15};
        A0A = new byte[]{0, 119, -120, -1};
        A0B = new byte[]{0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};
    }

    public G7(int i, int i5) {
        Paint paint = new Paint();
        this.A02 = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        paint.setPathEffect(null);
        Paint paint2 = new Paint();
        this.A03 = paint2;
        paint2.setStyle(Paint.Style.FILL);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        paint2.setPathEffect(null);
        this.A01 = new Canvas();
        this.A05 = new G0(719, 575, 0, 719, 0, 575);
        this.A04 = new C0647Fz(0, A0F(), A0G(), A0H());
        this.A06 = new G6(i, i5);
    }

    public static int A00(int i, int i5, int i6, int i8) {
        return (i << 24) | (i5 << 16) | (i6 << 8) | i8;
    }

    public static int A01(C0696Hy c0696Hy, int[] iArr, byte[] bArr, int i, int i5, Paint paint, Canvas canvas) {
        int i6 = i;
        boolean z2 = false;
        do {
            int i8 = 0;
            byte b2 = 0;
            int A04 = c0696Hy.A04(2);
            if (A04 != 0) {
                i8 = 1;
                if (A08[1].length() != 29) {
                    throw new RuntimeException();
                }
                A08[6] = "cKDkKJCaTP5Z";
                b2 = A04;
            } else if (c0696Hy.A0F()) {
                i8 = c0696Hy.A04(3) + 3;
                b2 = c0696Hy.A04(2);
                if (A08[1].length() == 29) {
                    A08[1] = "Xe5wyvwrL1rxQiCfD8ENREY9AaRUH";
                }
            } else if (c0696Hy.A0F()) {
                i8 = 1;
            } else {
                switch (c0696Hy.A04(2)) {
                    case 0:
                        z2 = true;
                        break;
                    case 1:
                        i8 = 2;
                        break;
                    case 2:
                        i8 = c0696Hy.A04(4) + 12;
                        b2 = c0696Hy.A04(2);
                        break;
                    case 3:
                        i8 = c0696Hy.A04(8) + 29;
                        if (A08[1].length() == 29) {
                            A08[5] = "eZC8v48u";
                            b2 = c0696Hy.A04(2);
                            break;
                        } else {
                            throw new RuntimeException();
                        }
                }
            }
            if (i8 != 0 && paint != null) {
                if (bArr != null) {
                    b2 = bArr[b2];
                }
                paint.setColor(iArr[b2]);
                canvas.drawRect(i6, i5, i6 + i8, i5 + 1, paint);
            }
            i6 += i8;
        } while (!z2);
        return i6;
    }

    public static int A02(C0696Hy c0696Hy, int[] iArr, byte[] bArr, int i, int i5, Paint paint, Canvas canvas) {
        int i6 = i;
        boolean z2 = false;
        do {
            int peek = 0;
            byte A04 = c0696Hy.A04(4);
            if (A04 != 0) {
                peek = 1;
            } else if (!c0696Hy.A0F()) {
                int A042 = c0696Hy.A04(3);
                if (A042 != 0) {
                    peek = A042 + 2;
                    A04 = 0;
                } else {
                    z2 = true;
                    A04 = 0;
                }
            } else if (!c0696Hy.A0F()) {
                peek = c0696Hy.A04(2) + 4;
                A04 = c0696Hy.A04(4);
            } else {
                switch (c0696Hy.A04(2)) {
                    case 0:
                        peek = 1;
                        if (A08[1].length() == 29) {
                            String[] strArr = A08;
                            strArr[3] = "b";
                            strArr[4] = "RKCQrML1KI9i2rbeBXbE06C32ORX";
                            A04 = 0;
                            break;
                        } else {
                            A04 = 0;
                            break;
                        }
                    case 1:
                        peek = 2;
                        A04 = 0;
                        break;
                    case 2:
                        peek = c0696Hy.A04(4) + 9;
                        A04 = c0696Hy.A04(4);
                        break;
                    case 3:
                        peek = c0696Hy.A04(8) + 25;
                        String[] strArr2 = A08;
                        if (strArr2[3].length() != strArr2[4].length()) {
                            A08[6] = "tDVEwF5JbpPt";
                            A04 = c0696Hy.A04(4);
                            break;
                        } else {
                            throw new RuntimeException();
                        }
                    default:
                        A04 = 0;
                        break;
                }
            }
            if (peek != 0 && paint != null) {
                if (bArr != null) {
                    A04 = bArr[A04];
                }
                paint.setColor(iArr[A04]);
                float f4 = i6;
                float f6 = i5;
                if (A08[6].length() != 12) {
                    throw new RuntimeException();
                }
                A08[1] = "PxagUxU0Gd3Wd2jZQY5J7se2mW8fT";
                canvas.drawRect(f4, f6, i6 + peek, i5 + 1, paint);
            }
            i6 += peek;
        } while (!z2);
        return i6;
    }

    public static int A03(C0696Hy c0696Hy, int[] iArr, byte[] bArr, int i, int i5, Paint paint, Canvas canvas) {
        int clutIndex;
        int i6 = i;
        boolean z2 = false;
        do {
            byte A04 = c0696Hy.A04(8);
            if (A04 != 0) {
                clutIndex = 1;
            } else if (!c0696Hy.A0F()) {
                clutIndex = c0696Hy.A04(7);
                if (A08[6].length() != 12) {
                    throw new RuntimeException();
                }
                A08[1] = "SuejjuLnG0h9t9VMaryqiTg33Oi2Z";
                if (clutIndex != 0) {
                    A04 = 0;
                } else {
                    z2 = true;
                    clutIndex = 0;
                    A04 = 0;
                }
            } else {
                clutIndex = c0696Hy.A04(7);
                A04 = c0696Hy.A04(8);
            }
            if (clutIndex != 0 && paint != null) {
                if (bArr != null) {
                    A04 = bArr[A04];
                }
                paint.setColor(iArr[A04]);
                canvas.drawRect(i6, i5, i6 + clutIndex, i5 + 1, paint);
            }
            i6 += clutIndex;
        } while (!z2);
        return i6;
    }

    public static G1 A06(C0696Hy c0696Hy) {
        int A04 = c0696Hy.A04(16);
        c0696Hy.A08(4);
        int objectId = c0696Hy.A04(2);
        boolean A0F = c0696Hy.A0F();
        c0696Hy.A08(1);
        byte[] bArr = null;
        byte[] bArr2 = null;
        if (objectId == 1) {
            int numberOfCodes = c0696Hy.A04(8);
            c0696Hy.A08(numberOfCodes * 16);
        } else if (objectId == 0) {
            int objectCodingMethod = c0696Hy.A04(16);
            int objectId2 = c0696Hy.A04(16);
            if (objectCodingMethod > 0) {
                bArr = new byte[objectCodingMethod];
                c0696Hy.A0E(bArr, 0, objectCodingMethod);
            }
            if (objectId2 > 0) {
                bArr2 = new byte[objectId2];
                c0696Hy.A0E(bArr2, 0, objectId2);
            } else {
                bArr2 = bArr;
            }
        }
        return new G1(A04, A0F, bArr, bArr2);
    }

    public static G2 A07(C0696Hy c0696Hy, int i) {
        int A04 = c0696Hy.A04(8);
        int A042 = c0696Hy.A04(4);
        int A043 = c0696Hy.A04(2);
        c0696Hy.A08(2);
        int i5 = i - 2;
        SparseArray sparseArray = new SparseArray();
        while (i5 > 0) {
            int remainingLength = c0696Hy.A04(8);
            c0696Hy.A08(8);
            int version = c0696Hy.A04(16);
            int timeoutSecs = c0696Hy.A04(16);
            i5 -= 6;
            sparseArray.put(remainingLength, new G3(version, timeoutSecs));
        }
        return new G2(A04, A042, A043, sparseArray);
    }

    public static void A0B(G1 g12, C0647Fz c0647Fz, int i, int i5, int i6, Paint paint, Canvas canvas) {
        int[] iArr;
        if (i == 3) {
            iArr = c0647Fz.A03;
        } else if (A08[2].length() == 20) {
            throw new RuntimeException();
        } else {
            A08[1] = "74G7JuTvJBV0INH1XI3DUfK6d2EWZ";
            if (i == 2) {
                iArr = c0647Fz.A02;
            } else {
                iArr = c0647Fz.A01;
            }
        }
        A0D(g12.A03, iArr, i, i5, i6, paint, canvas);
        A0D(g12.A02, iArr, i, i5, i6 + 1, paint, canvas);
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00f6, code lost:
        if (r0 != 0) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00f8, code lost:
        r7.A01 = r4;
        r7.A08.clear();
        r7.A06.clear();
        r7.A07.clear();
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0114, code lost:
        if (r0 != 0) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0117, code lost:
        if (r5 == null) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0119, code lost:
        r1 = r5.A02;
        r0 = r4.A02;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x011d, code lost:
        if (r1 == r0) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x011f, code lost:
        r7.A01 = r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void A0C(com.facebook.ads.redexgen.X.C0696Hy r6, com.facebook.ads.redexgen.X.G6 r7) {
        /*
            Method dump skipped, instructions count: 312
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.G7.A0C(com.facebook.ads.redexgen.X.Hy, com.facebook.ads.redexgen.X.G6):void");
    }

    public static void A0D(byte[] bArr, int[] iArr, int i, int i5, int i6, Paint paint, Canvas canvas) {
        byte[] clutMapTable4To8;
        byte[] clutMapTable4To82;
        int line = i6;
        C0696Hy c0696Hy = new C0696Hy(bArr);
        byte[] clutMapTable2To8 = null;
        byte[] clutMapTable2To4 = null;
        int column = i5;
        while (c0696Hy.A01() != 0) {
            switch (c0696Hy.A04(8)) {
                case 16:
                    if (i == 3) {
                        clutMapTable4To8 = clutMapTable2To4 == null ? A0A : clutMapTable2To4;
                    } else if (i == 2) {
                        clutMapTable4To8 = clutMapTable2To8 == null ? A09 : clutMapTable2To8;
                    } else {
                        clutMapTable4To8 = null;
                        if (A08[5].length() == 5) {
                            throw new RuntimeException();
                        }
                        String[] strArr = A08;
                        strArr[0] = "aCQdDxqS2bkmSWw219FL9FrVQLNlGxjh";
                        strArr[7] = "CXVqOrR1KNECyNPiemwICdwFVxmD3XsB";
                    }
                    if (A08[5].length() != 5) {
                        A08[1] = "sxwfPuAvCy0meNXm9qprXKFgJpDmZ";
                        column = A01(c0696Hy, iArr, clutMapTable4To8, column, line, paint, canvas);
                        c0696Hy.A05();
                        break;
                    } else {
                        throw new RuntimeException();
                    }
                case 17:
                    if (i == 3) {
                        clutMapTable4To82 = 0 == 0 ? A0B : null;
                    } else {
                        clutMapTable4To82 = null;
                    }
                    column = A02(c0696Hy, iArr, clutMapTable4To82, column, line, paint, canvas);
                    c0696Hy.A05();
                    break;
                case 18:
                    column = A03(c0696Hy, iArr, null, column, line, paint, canvas);
                    break;
                case 32:
                    clutMapTable2To8 = A0E(4, 4, c0696Hy);
                    break;
                case 33:
                    clutMapTable2To4 = A0E(4, 8, c0696Hy);
                    break;
                case 34:
                    clutMapTable2To4 = A0E(16, 8, c0696Hy);
                    break;
                case 240:
                    line += 2;
                    column = i5;
                    break;
            }
        }
    }

    public static byte[] A0E(int i, int i5, C0696Hy c0696Hy) {
        byte[] bArr = new byte[i];
        for (int i6 = 0; i6 < i; i6++) {
            bArr[i6] = (byte) c0696Hy.A04(i5);
        }
        return bArr;
    }

    public static int[] A0F() {
        return new int[]{0, -1, -16777216, -8421505};
    }

    public static int[] A0G() {
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i = 1; i < iArr.length; i++) {
            if (i < 8) {
                int i5 = i & 1;
                if (A08[1].length() != 29) {
                    throw new RuntimeException();
                }
                A08[6] = "OBOqbcJ5TVgi";
                int i6 = i5 != 0 ? 255 : 0;
                iArr[i] = A00(255, i6, (i & 2) != 0 ? 255 : 0, (i & 4) != 0 ? 255 : 0);
            } else {
                int i8 = (i & 1) != 0 ? 127 : 0;
                iArr[i] = A00(255, i8, (i & 2) != 0 ? 127 : 0, (i & 4) == 0 ? 0 : 127);
            }
        }
        return iArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:106:0x0161, code lost:
        if (r8 != 0) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0163, code lost:
        r0 = 170;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x01b3, code lost:
        if (r8 != 0) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x01b6, code lost:
        r0 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x003c, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int[] A0H() {
        /*
            Method dump skipped, instructions count: 480
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.G7.A0H():int[]");
    }

    public final void A0J() {
        this.A06.A00();
    }
}
