package com.facebook.ads.redexgen.X;

import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.locks.Lock;
/* loaded from: assets/audience_network.dex */
public class EP extends AbstractC1112Yj<String> {
    public static byte[] A08;
    public static String[] A09 = {"l", "T0JdG9ZEnLfTeCeftC9G7d8cUsVG3XZb", "aLcPLzyPnyiGnlL0eBnocVG2Im", "W3EwFUE7CvVeZV", "t2q4fu0Y0bIBimY2SigNyotMmunbmEsF", "TUpEXXUjgi8xLksArOVlucAVZCM", "AqOn5F5Mae0spU5kh0gbanyLcs", "chqW8UrgIl8Ef4OOKimE4h"};
    public final /* synthetic */ double A00;
    public final /* synthetic */ double A01;
    public final /* synthetic */ int A02;
    public final /* synthetic */ C04507o A03;
    public final /* synthetic */ String A04;
    public final /* synthetic */ String A05;
    public final /* synthetic */ String A06;
    public final /* synthetic */ Map A07;

    public static String A01(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A08, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 32);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A08 = new byte[]{-112, -115, -96, -115, -114, -115, -97, -111};
    }

    static {
        A02();
    }

    public EP(C04507o c04507o, String str, String str2, int i, double d2, double d3, String str3, Map map) {
        this.A03 = c04507o;
        this.A06 = str;
        this.A05 = str2;
        this.A02 = i;
        this.A01 = d2;
        this.A00 = d3;
        this.A04 = str3;
        this.A07 = map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.AbstractC04527r
    /* renamed from: A00 */
    public final String A03() {
        C1115Ym c1115Ym;
        Lock lock;
        C1115Ym c1115Ym2;
        Lock lock2;
        C1115Ym c1115Ym3;
        Lock lock3;
        C1115Ym c1115Ym4;
        C1114Yl c1114Yl;
        C1113Yk c1113Yk;
        Lock lock4;
        C1115Ym c1115Ym5;
        String eventId = A01(0, 8, 12);
        c1115Ym = this.A03.A01;
        c1115Ym.A07().A8l(this.A06);
        if (TextUtils.isEmpty(this.A05)) {
            return null;
        }
        lock = C04507o.A08;
        lock.lock();
        String[] strArr = A09;
        if (strArr[6].length() != strArr[2].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A09;
        strArr2[1] = "mqnyRlomjFPPGlBu5iJ3A4HRnrnsorAH";
        strArr2[4] = "vLAqNnzkqKgbXCY8NZfbbPBhHyGRm9s6";
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                sQLiteDatabase = this.A03.A0E();
                sQLiteDatabase.beginTransaction();
                c1114Yl = this.A03.A02;
                c1113Yk = this.A03.A03;
                String A0E = c1114Yl.A0E(c1113Yk.A0C(this.A05), this.A02, this.A06, this.A01, this.A00, this.A04, this.A07);
                sQLiteDatabase.setTransactionSuccessful();
                if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                    try {
                        if (sQLiteDatabase.inTransaction()) {
                            sQLiteDatabase.endTransaction();
                        }
                    } catch (Exception e2) {
                        c1115Ym5 = this.A03.A01;
                        c1115Ym5.A07().A9a(eventId, C8A.A0z, new C8B(e2));
                    }
                }
                lock4 = C04507o.A08;
                lock4.unlock();
                return A0E;
            } catch (Throwable th) {
                if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                    try {
                        if (sQLiteDatabase.inTransaction()) {
                            sQLiteDatabase.endTransaction();
                        }
                    } catch (Exception e3) {
                        c1115Ym4 = this.A03.A01;
                        c1115Ym4.A07().A9a(eventId, C8A.A0z, new C8B(e3));
                    }
                }
                lock3 = C04507o.A08;
                lock3.unlock();
                throw th;
            }
        } catch (Exception e5) {
            A01(C7q.A06);
            c1115Ym2 = this.A03.A01;
            c1115Ym2.A07().A9a(eventId, C8A.A0y, new C8B(e5));
            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                try {
                    if (sQLiteDatabase.inTransaction()) {
                        sQLiteDatabase.endTransaction();
                    }
                } catch (Exception e6) {
                    c1115Ym3 = this.A03.A01;
                    c1115Ym3.A07().A9a(eventId, C8A.A0z, new C8B(e6));
                }
            }
            lock2 = C04507o.A08;
            lock2.unlock();
            return null;
        }
    }
}
