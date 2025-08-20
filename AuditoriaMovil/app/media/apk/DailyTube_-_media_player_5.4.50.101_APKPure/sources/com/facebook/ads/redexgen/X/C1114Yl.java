package com.facebook.ads.redexgen.X;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import com.uv.v7.R;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;
/* renamed from: com.facebook.ads.redexgen.X.Yl  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1114Yl extends AbstractC04537s {
    public static byte[] A00;
    public static String[] A01 = {"jrDlnlrK", "iy84zN2ZyMyHjuWhjHotEPEqpiKyPe89", "dhX4OOJDnXlCZP9pL8vYTq2cDSC1Ep0f", "V5wGJKV", "mjidYuf4", "f2fONlBHJxOBrlG7qLTpq6ivaaiBfV2e", "tNB7OhzIAdgb5rZvvS5ZVqcHEeMF5GsI", "2zYeFugNugInNaPrLN78SJaAZY8hyaCl"};
    public static final C04497m A02;
    public static final C04497m A03;
    public static final C04497m A04;
    public static final C04497m A05;
    public static final C04497m A06;
    public static final C04497m A07;
    public static final C04497m A08;
    public static final C04497m A09;
    public static final C04497m A0A;
    public static final C04497m[] A0B;
    public static final String A0C;

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 42);
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        A00 = new byte[]{-102, -73, -102, -71, -92, -87, -81, -96, -94, -96, -83, -22, -35, -39, -28, -93, -107, -100, -107, -109, -92, 112, 122, 112, -106, -94, -97, -99, 112, -75, -58, -75, -66, -60, -61, 112, -89, -104, -107, -94, -107, 112, -11, -25, -18, -25, -27, -10, -62, 5, 17, 23, 16, 22, -54, -52, -53, -62, -24, -12, -15, -17, -62, 7, 24, 7, 16, 22, 21, -49, -64, -45, -49, -95, -110, -91, -95, 109, -99, -97, -106, -102, -114, -97, -90, 109, -104, -110, -90, -19, -34, -15, -19, -71, -21, -34, -33, -34, -21, -34, -25, -36, -34, -20, -71, 13, 8, 4, -2, 7, 12, -71, -24, -25, -71, -18, -23, -35, -38, -19, -34, -71, -36, -38, -20, -36, -38, -35, -34, -71, -24, -25, -71, -35, -34, -27, -34, -19, -34, -71, -21, -34, -20, -19, -21, -30, -36, -19, -17, 2, 2, -13, -5, -2, 2, -85, -88, -69, -88, -82, -65, -82, -73, -67, -88, -78, -83, -4, 13, -4, 5, 11, 10, -77, -75, -84, -78, -75, -84, -73, -68, -80, -94, -80, -80, -90, -84, -85, -100, -90, -95, -90, -104, -90, -90, -100, -94, -95, -110, -89, -100, -96, -104, -43, -54, -50, -58, -96, -101, -105, -111, -102, -117, -107, -112, -32, -27, -36, -47};
    }

    static {
        A04();
        C04497m c04497m = new C04497m(0, A00(159, 8, 31), A00(73, 16, 35));
        A04 = c04497m;
        C04497m c04497m2 = new C04497m(1, A00(207, 8, 2), A00(89, 59, R.styleable.AppCompatTheme_textColorSearchUrl));
        A09 = c04497m2;
        String A002 = A00(173, 8, 25);
        String A003 = A00(4, 7, 49);
        C04497m c04497m3 = new C04497m(2, A002, A003);
        A05 = c04497m3;
        String A004 = A00(215, 4, 66);
        String A005 = A00(69, 4, 81);
        C04497m c04497m4 = new C04497m(3, A004, A005);
        A0A = c04497m4;
        String A006 = A00(203, 4, 55);
        String A007 = A00(11, 4, R.styleable.AppCompatTheme_textColorAlertDialogListItem);
        C04497m c04497m5 = new C04497m(4, A006, A007);
        A08 = c04497m5;
        C04497m c04497m6 = new C04497m(5, A00(191, 12, 9), A007);
        A07 = c04497m6;
        C04497m c04497m7 = new C04497m(6, A00(181, 10, 19), A005);
        A06 = c04497m7;
        C04497m c04497m8 = new C04497m(7, A00(155, 4, 29), A005);
        A03 = c04497m8;
        C04497m c04497m9 = new C04497m(8, A00(148, 7, 100), A003);
        A02 = c04497m9;
        C04497m[] c04497mArr = {c04497m, c04497m2, c04497m3, c04497m4, c04497m5, c04497m6, c04497m7, c04497m8, c04497m9};
        A0B = c04497mArr;
        A0C = AbstractC04537s.A02(A00(167, 6, 109), c04497mArr);
    }

    public C1114Yl(C04507o c04507o) {
        super(c04507o);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC04537s
    public final String A06() {
        return A00(167, 6, 109);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC04537s
    public final C04497m[] A0A() {
        return A0B;
    }

    public final Cursor A0B() {
        return A05().rawQuery(A00(42, 27, 120), null);
    }

    public final Cursor A0C() {
        return A05().rawQuery(A0C, null);
    }

    public final Cursor A0D(String str) {
        return A05().rawQuery(A00(15, 27, 38) + A04.A01 + A00(0, 4, 80), new String[]{str});
    }

    public final String A0E(String str, int i, String str2, double d2, double d3, String str3, Map<String, String> map) throws SQLiteException {
        String uuid = UUID.randomUUID().toString();
        ContentValues contentValues = new ContentValues(9);
        String eventId = A04.A01;
        contentValues.put(eventId, uuid);
        String eventId2 = A09.A01;
        contentValues.put(eventId2, str);
        contentValues.put(A05.A01, Integer.valueOf(i));
        String eventId3 = A0A.A01;
        contentValues.put(eventId3, str2);
        contentValues.put(A08.A01, Double.valueOf(d2));
        contentValues.put(A07.A01, Double.valueOf(d3));
        String eventId4 = A06.A01;
        contentValues.put(eventId4, str3);
        String str4 = A03.A01;
        String eventId5 = map != null ? new JSONObject(map).toString() : null;
        contentValues.put(str4, eventId5);
        if (A01[2].charAt(6) != '9') {
            String[] strArr = A01;
            strArr[6] = "s3YvQaCKhotLBtEqHITMzm2bHxiojI5j";
            strArr[5] = "6LuOsEhvTekWWK5Zi4EuC4VUkJbxKkeL";
            contentValues.put(A02.A01, (Integer) 0);
            SQLiteDatabase A052 = A05();
            String eventId6 = A00(167, 6, 109);
            A052.insertOrThrow(eventId6, null, contentValues);
            return uuid;
        }
        throw new RuntimeException();
    }

    public final boolean A0F(String str) {
        return A05().delete(A00(167, 6, 109), new StringBuilder().append(A04.A01).append(A00(0, 4, 80)).toString(), new String[]{str}) > 0;
    }
}
