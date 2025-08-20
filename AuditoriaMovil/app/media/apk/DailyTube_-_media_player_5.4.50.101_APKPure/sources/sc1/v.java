package sc1;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* loaded from: classes.dex */
public final class v {

    /* renamed from: gv  reason: collision with root package name */
    public static final String[] f13840gv;

    /* renamed from: v  reason: collision with root package name */
    public static final v f13842v = new v();
    public static final zc1.s y = zc1.s.fb.gv("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    /* renamed from: n3  reason: collision with root package name */
    public static final String[] f13841n3 = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

    /* renamed from: zn  reason: collision with root package name */
    public static final String[] f13843zn = new String[64];

    static {
        String[] strArr = new String[256];
        for (int i = 0; i < 256; i++) {
            String binaryString = Integer.toBinaryString(i);
            Intrinsics.checkNotNullExpressionValue(binaryString, "Integer.toBinaryString(it)");
            strArr[i] = StringsKt.replace$default(lc1.n3.p("%8s", binaryString), ' ', '0', false, 4, (Object) null);
        }
        f13840gv = strArr;
        String[] strArr2 = f13843zn;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        int i5 = iArr[0];
        strArr2[i5 | 8] = Intrinsics.stringPlus(strArr2[i5], "|PADDED");
        strArr2[4] = "END_HEADERS";
        strArr2[32] = "PRIORITY";
        strArr2[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i6 = 0; i6 < 3; i6++) {
            int i8 = iArr2[i6];
            int i10 = iArr[0];
            String[] strArr3 = f13843zn;
            int i11 = i10 | i8;
            strArr3[i11] = strArr3[i10] + "|" + strArr3[i8];
            strArr3[i11 | 8] = strArr3[i10] + "|" + strArr3[i8] + "|PADDED";
        }
        int length = f13843zn.length;
        for (int i12 = 0; i12 < length; i12++) {
            String[] strArr4 = f13843zn;
            if (strArr4[i12] == null) {
                strArr4[i12] = f13840gv[i12];
            }
        }
    }

    public final String n3(int i) {
        String[] strArr = f13841n3;
        if (i < strArr.length) {
            return strArr[i];
        }
        return lc1.n3.p("0x%02x", Integer.valueOf(i));
    }

    public final String y(int i, int i5) {
        String str;
        if (i5 == 0) {
            return "";
        }
        if (i != 2 && i != 3) {
            if (i != 4 && i != 6) {
                if (i != 7 && i != 8) {
                    String[] strArr = f13843zn;
                    if (i5 < strArr.length) {
                        str = strArr[i5];
                        Intrinsics.checkNotNull(str);
                    } else {
                        str = f13840gv[i5];
                    }
                    String str2 = str;
                    if (i == 5 && (i5 & 4) != 0) {
                        return StringsKt.replace$default(str2, "HEADERS", "PUSH_PROMISE", false, 4, (Object) null);
                    }
                    if (i == 0 && (i5 & 32) != 0) {
                        return StringsKt.replace$default(str2, "PRIORITY", "COMPRESSED", false, 4, (Object) null);
                    }
                    return str2;
                }
            } else if (i5 == 1) {
                return "ACK";
            } else {
                return f13840gv[i5];
            }
        }
        return f13840gv[i5];
    }

    public final String zn(boolean z2, int i, int i5, int i6, int i8) {
        String str;
        String n32 = n3(i6);
        String y2 = y(i6, i8);
        if (z2) {
            str = "<<";
        } else {
            str = ">>";
        }
        return lc1.n3.p("%s 0x%08x %5d %-13s %s", str, Integer.valueOf(i), Integer.valueOf(i5), n32, y2);
    }
}
