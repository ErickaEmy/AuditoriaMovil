package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import com.uv.v7.R;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;
/* renamed from: com.facebook.ads.redexgen.X.Ye  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1107Ye extends KT {
    public static byte[] A05;
    public final /* synthetic */ int A00;
    public final /* synthetic */ C04447f A01;
    public final /* synthetic */ AnonymousClass83 A02;
    public final /* synthetic */ C8B A03;
    public final /* synthetic */ String A04;

    static {
        A02();
    }

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 120);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A05 = new byte[]{-37, -3, 30, 27, 46, 32, -39, 28, 43, 26, 44, 33, -39, 27, 30, 28, 26, 46, 44, 30, -39, 44, -2, 39, 47, 34, 43, 40, 39, 38, 30, 39, 45, -3, 26, 45, 26, 9, 43, 40, 47, 34, 29, 30, 43, -39, 39, 40, 45, -39, 34, 39, 35, 30, 28, 45, 30, 29, -46, -24, -19, -22, -97, -24, -14, -97, -19, -12, -21, -21, -96, 30, 33, 33, 38, 49, 38, 44, 43, 30, 41, 28, 38, 43, 35, 44, 45, 66, 45, 53, 56, 45, 46, 56, 49, 43, 48, 53, 63, 55, 43, 63, 60, 45, 47, 49, 62, 60, 62, 67, 64, 104, 91, 89, 101, 104, 90, 85, 90, 87, 106, 87, 88, 87, 105, 91, -18, -31, -19, -15, -31, -17, -16, -37, -27, -32, 44, 46, 27, 45, 50, 41, 30, 49, 51, 32, 50, 55, 46, 35, 29, 33, 45, 34, 35};
    }

    public C1107Ye(C04447f c04447f, String str, int i, C8B c8b, AnonymousClass83 anonymousClass83) {
        this.A01 = c04447f;
        this.A04 = str;
        this.A00 = i;
        this.A03 = c8b;
        this.A02 = anonymousClass83;
    }

    @Override // com.facebook.ads.redexgen.X.KT
    public final void A06() {
        String str;
        Map<String, String> A4n;
        String A7F;
        AtomicReference atomicReference;
        try {
            if (AnonymousClass84.A0K(this.A01, this.A04, this.A00, this.A03)) {
                return;
            }
            JD.A08(this.A01, J5.A0A.toString() + A00(0, 1, 41) + this.A04);
            Throwable cause = this.A03.getCause();
            if (cause != null) {
                str = LW.A03(this.A01, cause);
            } else if (Ij.A0R(this.A01)) {
                C04447f c04447f = this.A01;
                Throwable deLogExceptionCause = this.A03;
                str = LW.A03(c04447f, deLogExceptionCause);
            } else {
                str = A00(0, 0, R.styleable.AppCompatTheme_textAppearancePopupMenuHeader) + this.A03.getMessage();
            }
            if (Ij.A0V(this.A01)) {
                A4n = this.A01.A03().A4n();
            } else {
                AnonymousClass83 anonymousClass83 = this.A02;
                if (anonymousClass83 != null) {
                    A4n = anonymousClass83.A6x();
                } else if (AnonymousClass84.A02) {
                    AnonymousClass84.A0F(new RuntimeException(A00(1, 57, 65), this.A03));
                    A4n = new HashMap<>();
                } else {
                    A4n = this.A01.A03().A4n();
                }
            }
            A4n.put(A00(136, 7, 65), this.A04);
            A4n.put(A00(143, 12, 70), String.valueOf(this.A00));
            JSONObject A03 = this.A03.A03();
            if (A03 != null) {
                A4n.put(A00(71, 15, 69), A03.toString());
            }
            if ((A00(R.styleable.AppCompatTheme_textAppearancePopupMenuHeader, 5, 99).equals(this.A04) || A00(R.styleable.AppCompatTheme_textColorSearchUrl, 15, 126).equals(this.A04)) && (A7F = this.A01.A03().A7F()) != null) {
                A4n.put(A00(86, 20, 84), A7F);
            }
            String A0B = this.A01.A0B();
            if (A0B != null && !TextUtils.isEmpty(A0B)) {
                A4n.put(A00(126, 10, 4), A0B);
            }
            atomicReference = AnonymousClass84.A0A;
            AnonymousClass82 anonymousClass82 = (AnonymousClass82) atomicReference.get();
            if (anonymousClass82 == null) {
                AnonymousClass84.A0F(new RuntimeException(A00(58, 13, 7)));
            } else {
                anonymousClass82.AHD(str, A4n, this.A01);
            }
        } catch (Throwable t2) {
            AnonymousClass84.A0F(t2);
        }
    }
}
