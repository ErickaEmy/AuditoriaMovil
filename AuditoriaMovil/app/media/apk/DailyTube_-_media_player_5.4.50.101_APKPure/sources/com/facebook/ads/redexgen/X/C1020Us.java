package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.protocol.AdErrorType;
import java.util.Arrays;
import org.json.JSONException;
/* renamed from: com.facebook.ads.redexgen.X.Us  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1020Us implements RL {
    public static byte[] A03;
    public final /* synthetic */ long A00;
    public final /* synthetic */ K1 A01;
    public final /* synthetic */ K4 A02;

    static {
        A01();
    }

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 10);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{103, 54, 102, 103, 100, 53, 105, 101, 109, 116, 104, 105, 98, 95, 68, 66, 87, 83, 78, 72, 73, 29, 7, 24, 46, 57, 61, 46, 57, 107, 46, 57, 57, 36, 57, 107, 36, 40, 40, 62, 57, 57, 46, 47, 108, 90, 77, 73, 90, 77, 31, 77, 90, 79, 83, 86, 90, 91, 31, 76, 74, 92, 92, 90, 76, 76, 89, 74, 83, 83, 70, 122, 123, 32, 124, 123, 41, 47, 75, 74, 103, 75, 73, 84, 72, 65, 80, 65, 95, 94, 117, 66, 66, 95, 66};
    }

    public C1020Us(K4 k4, K1 k1, long j2) {
        this.A02 = k4;
        this.A01 = k1;
        this.A00 = j2;
    }

    private final void A02(RX rx) {
        C1116Yn c1116Yn;
        long j2;
        C1116Yn c1116Yn2;
        long j4;
        K5 k52;
        C1116Yn c1116Yn3;
        C1116Yn c1116Yn4;
        long j6;
        K0.A06(this.A01);
        try {
            RJ response = rx.A00();
            if (response != null) {
                String A69 = response.A69();
                k52 = this.A02.A05;
                c1116Yn3 = this.A02.A04;
                K7 serverResponse = k52.A06(c1116Yn3, A69, this.A00);
                if (serverResponse.A01() == K6.A03) {
                    C1017Uo c1017Uo = (C1017Uo) serverResponse;
                    String A04 = c1017Uo.A04();
                    AdErrorType adErrorTypeFromCode = AdErrorType.adErrorTypeFromCode(c1017Uo.A03(), AdErrorType.ERROR_MESSAGE);
                    if (A04 != null) {
                        A69 = A04;
                    }
                    c1116Yn4 = this.A02.A04;
                    C0S A0E = c1116Yn4.A0E();
                    j6 = this.A02.A00;
                    A0E.A2v(C0774Lf.A01(j6), adErrorTypeFromCode.getErrorCode(), A69, adErrorTypeFromCode.isPublicError());
                    this.A02.A0D(C0722Jb.A01(adErrorTypeFromCode, A69));
                    return;
                }
            }
            AdErrorType adErrorType = AdErrorType.NETWORK_ERROR;
            String errorMessage = rx.getMessage();
            c1116Yn2 = this.A02.A04;
            C0S A0E2 = c1116Yn2.A0E();
            j4 = this.A02.A00;
            A0E2.A2v(C0774Lf.A01(j4), adErrorType.getErrorCode(), errorMessage, adErrorType.isPublicError());
            this.A02.A0D(C0722Jb.A01(adErrorType, errorMessage));
        } catch (JSONException e2) {
            AdErrorType adErrorType2 = AdErrorType.NETWORK_ERROR;
            String errorMessage2 = rx.getMessage();
            c1116Yn = this.A02.A04;
            C0S A0E3 = c1116Yn.A0E();
            j2 = this.A02.A00;
            A0E3.A2v(C0774Lf.A01(j2), adErrorType2.getErrorCode(), A00(8, 15, 45) + e2.getMessage(), adErrorType2.isPublicError());
            this.A02.A0D(C0722Jb.A01(adErrorType2, errorMessage2));
        }
    }

    @Override // com.facebook.ads.redexgen.X.RL
    public final void AB9(RJ rj) {
        AbstractC0735Jp.A05(A00(78, 10, 46), A00(44, 27, 53), A00(0, 8, 90));
        if (rj != null) {
            String A69 = rj.A69();
            K0.A06(this.A01);
            this.A02.A0N(A69, this.A00, this.A01);
        }
    }

    @Override // com.facebook.ads.redexgen.X.RL
    public final void ABS(Exception exc) {
        C1116Yn c1116Yn;
        long j2;
        AbstractC0735Jp.A05(A00(88, 7, 58), A00(23, 21, 65), A00(71, 7, 18));
        if (RX.class.equals(exc.getClass())) {
            A02((RX) exc);
            return;
        }
        AdErrorType adErrorType = AdErrorType.NETWORK_ERROR;
        String errorMessage = exc.getMessage();
        c1116Yn = this.A02.A04;
        C0S A0E = c1116Yn.A0E();
        j2 = this.A02.A00;
        A0E.A2v(C0774Lf.A01(j2), adErrorType.getErrorCode(), errorMessage, adErrorType.isPublicError());
        this.A02.A0D(C0722Jb.A01(adErrorType, errorMessage));
    }
}
