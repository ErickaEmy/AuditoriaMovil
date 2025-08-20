package v5;

import android.util.Pair;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class a {
    public static final byte[] y = {0, 0, 0, 1};

    /* renamed from: n3  reason: collision with root package name */
    public static final String[] f14303n3 = {"", "A", "B", "C"};

    public static Pair<Integer, Integer> a(byte[] bArr) {
        boolean z2;
        boolean z3;
        boolean z4;
        rz rzVar = new rz(bArr);
        int i = 0;
        int i5 = 0;
        while (true) {
            int i6 = i5 + 3;
            if (i6 < bArr.length) {
                if (rzVar.x() == 1 && (bArr[i6] & 240) == 32) {
                    z2 = true;
                    break;
                }
                rzVar.oz(rzVar.a() - 2);
                i5++;
            } else {
                z2 = false;
                break;
            }
        }
        y.n3(z2, "Invalid input: VOL not found.");
        fh fhVar = new fh(bArr);
        fhVar.mt((i5 + 4) * 8);
        fhVar.mt(1);
        fhVar.mt(8);
        if (fhVar.fb()) {
            fhVar.mt(4);
            fhVar.mt(3);
        }
        if (fhVar.s(4) == 15) {
            fhVar.mt(8);
            fhVar.mt(8);
        }
        if (fhVar.fb()) {
            fhVar.mt(2);
            fhVar.mt(1);
            if (fhVar.fb()) {
                fhVar.mt(79);
            }
        }
        if (fhVar.s(2) == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        y.n3(z3, "Only supports rectangular video object layer shape.");
        y.y(fhVar.fb());
        int s2 = fhVar.s(16);
        y.y(fhVar.fb());
        if (fhVar.fb()) {
            if (s2 > 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            y.y(z4);
            for (int i8 = s2 - 1; i8 > 0; i8 >>= 1) {
                i++;
            }
            fhVar.mt(i);
        }
        y.y(fhVar.fb());
        int s3 = fhVar.s(13);
        y.y(fhVar.fb());
        int s4 = fhVar.s(13);
        y.y(fhVar.fb());
        fhVar.mt(1);
        return Pair.create(Integer.valueOf(s3), Integer.valueOf(s4));
    }

    public static boolean c5(List<byte[]> list) {
        if (list.size() != 1 || list.get(0).length != 1 || list.get(0)[0] != 1) {
            return false;
        }
        return true;
    }

    public static boolean fb(byte[] bArr, int i) {
        if (bArr.length - i <= y.length) {
            return false;
        }
        int i5 = 0;
        while (true) {
            byte[] bArr2 = y;
            if (i5 < bArr2.length) {
                if (bArr[i + i5] != bArr2[i5]) {
                    return false;
                }
                i5++;
            } else {
                return true;
            }
        }
    }

    public static byte[] gv(byte[] bArr, int i, int i5) {
        byte[] bArr2 = y;
        byte[] bArr3 = new byte[bArr2.length + i5];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        System.arraycopy(bArr, i, bArr3, bArr2.length, i5);
        return bArr3;
    }

    @Nullable
    public static byte[][] i9(byte[] bArr) {
        int length;
        if (!fb(bArr, 0)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        do {
            arrayList.add(Integer.valueOf(i));
            i = v(bArr, i + y.length);
        } while (i != -1);
        byte[][] bArr2 = new byte[arrayList.size()];
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            int intValue = ((Integer) arrayList.get(i5)).intValue();
            if (i5 < arrayList.size() - 1) {
                length = ((Integer) arrayList.get(i5 + 1)).intValue();
            } else {
                length = bArr.length;
            }
            int i6 = length - intValue;
            byte[] bArr3 = new byte[i6];
            System.arraycopy(bArr, intValue, bArr3, 0, i6);
            bArr2[i5] = bArr3;
        }
        return bArr2;
    }

    public static List<byte[]> n3(boolean z2) {
        return Collections.singletonList(z2 ? new byte[]{1} : new byte[]{0});
    }

    public static Pair<Integer, Integer> s(byte[] bArr) {
        rz rzVar = new rz(bArr);
        rzVar.oz(9);
        int ej2 = rzVar.ej();
        rzVar.oz(20);
        return Pair.create(Integer.valueOf(rzVar.b()), Integer.valueOf(ej2));
    }

    public static int v(byte[] bArr, int i) {
        int length = bArr.length - y.length;
        while (i <= length) {
            if (fb(bArr, i)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static String y(int i, int i5, int i6) {
        return String.format("avc1.%02X%02X%02X", Integer.valueOf(i), Integer.valueOf(i5), Integer.valueOf(i6));
    }

    public static String zn(int i, boolean z2, int i5, int i6, int[] iArr, int i8) {
        char c2;
        String str = f14303n3[i];
        Integer valueOf = Integer.valueOf(i5);
        Integer valueOf2 = Integer.valueOf(i6);
        if (z2) {
            c2 = 'H';
        } else {
            c2 = 'L';
        }
        StringBuilder sb = new StringBuilder(j5.rz("hvc1.%s%d.%X.%c%d", str, valueOf, valueOf2, Character.valueOf(c2), Integer.valueOf(i8)));
        int length = iArr.length;
        while (length > 0 && iArr[length - 1] == 0) {
            length--;
        }
        for (int i10 = 0; i10 < length; i10++) {
            sb.append(String.format(".%02X", Integer.valueOf(iArr[i10])));
        }
        return sb.toString();
    }
}
