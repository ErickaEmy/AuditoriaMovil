package com.facebook.ads.redexgen.X;

import com.uv.v7.R;
import java.util.Arrays;
/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum A05 uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:444)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:391)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:320)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:258)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* renamed from: com.facebook.ads.redexgen.X.1d  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class EnumC02941d {
    public static byte[] A01;
    public static final /* synthetic */ EnumC02941d[] A02;
    public static final EnumC02941d A03;
    public static final EnumC02941d A04;
    public static final EnumC02941d A05;
    public final String A00;

    public static String A01(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 32);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A01 = new byte[]{24, 23, 18, 27, 1, 14, 12, 27, 29, 31, 29, 22, 27, 3, 1, 28, 11, 10, 12, 3, 1, 22, 16, 18, 16, 27, 22, 119, 101, 98, 118, 105, 101, 119, Byte.MAX_VALUE, 112, 114, 101, 99, 97, 99, 104, 101};
    }

    static {
        A02();
        String A012 = A01(27, 16, 0);
        EnumC02941d enumC02941d = new EnumC02941d(A012, 0, A012);
        A05 = enumC02941d;
        String A013 = A01(13, 14, R.styleable.AppCompatTheme_tooltipFrameBackground);
        EnumC02941d enumC02941d2 = new EnumC02941d(A013, 1, A013);
        A04 = enumC02941d2;
        String A014 = A01(0, 13, 126);
        EnumC02941d enumC02941d3 = new EnumC02941d(A014, 2, A014);
        A03 = enumC02941d3;
        A02 = new EnumC02941d[]{enumC02941d, enumC02941d2, enumC02941d3};
    }

    public EnumC02941d(String str, int i, String str2) {
        this.A00 = str2;
    }

    public static EnumC02941d A00(String str) {
        EnumC02941d[] values;
        for (EnumC02941d enumC02941d : values()) {
            if (enumC02941d.A00.equalsIgnoreCase(str)) {
                return enumC02941d;
            }
        }
        return A03;
    }

    public static EnumC02941d valueOf(String str) {
        return (EnumC02941d) Enum.valueOf(EnumC02941d.class, str);
    }

    public static EnumC02941d[] values() {
        return (EnumC02941d[]) A02.clone();
    }
}
