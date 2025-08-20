package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import com.facebook.ads.internal.protocol.AdErrorType;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.facebook.ads.redexgen.X.Jl  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0731Jl {
    public static byte[] A04;
    public static String[] A05 = {"YPLhW1YthHwH", "C5pYKBzTNFhaTyoOn8CLtRZjld8VucJT", "nwsPGMG6WiL6DBh0FHrHZ0R5IXcuLobJ", "gK87iCVuQY9qRaZHEz4I1", "yLpaI56t1HZbTv34O8DVm8KvrNdbdGTz", "u7C3r8DCX9eoMUGzC5EwjUGrObNKQaYD", "hw4dG9XbulEGH2HnH1CXedNx1Lx9pLFE", "teiwDyYVI0VIQpP4hHHpy5xIPHWhYAA5"};
    public final EnumC0730Jk A00;
    public final Long A01;
    public final String A02;
    public final String A03;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 18 out of bounds for length 18
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.restartVar(DebugInfoParser.java:193)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:141)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:118)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:567)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:39)
     */
    public C0731Jl(C04447f c04447f, String str, String str2, EnumC0726Jg enumC0726Jg) throws C0723Jc {
        String A01 = A01(270, 21, 101);
        String A012 = A01(291, 11, 100);
        String A013 = A01(247, 14, 65);
        String A014 = A01(310, 4, 74);
        String A015 = A01(302, 8, 85);
        if (TextUtils.isEmpty(str)) {
            this.A00 = EnumC0730Jk.A03;
            this.A01 = null;
            this.A03 = null;
            this.A02 = null;
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            switch (C0729Jj.A00[EnumC0730Jk.valueOf(jSONObject.getString(A014).toUpperCase()).ordinal()]) {
                case 1:
                    this.A00 = EnumC0730Jk.A02;
                    Long valueOf = Long.valueOf(jSONObject.getString(A01(241, 6, 45)));
                    this.A01 = valueOf;
                    if (jSONObject.has(A013)) {
                        this.A02 = jSONObject.getString(A013);
                    } else {
                        this.A02 = null;
                    }
                    this.A03 = jSONObject.getString(A01(261, 9, 2));
                    if (!jSONObject.getString(A012).equals(c04447f.A04().A8I())) {
                        throw new C0723Jc(AdErrorType.BID_IMPRESSION_MISMATCH, String.format(Locale.US, A01(0, 54, 78), valueOf, jSONObject.getString(A012), c04447f.A04().A8I()));
                    }
                    if (!jSONObject.getString(A01).equals(str2)) {
                        throw new C0723Jc(AdErrorType.BID_IMPRESSION_MISMATCH, String.format(Locale.US, A01(54, 50, 34), valueOf, jSONObject.getString(A01), str2));
                    }
                    HashSet hashSet = new HashSet(Arrays.asList(Integer.valueOf(EnumC0726Jg.A0G.A03()), Integer.valueOf(EnumC0726Jg.A0J.A03()), Integer.valueOf(EnumC0726Jg.A0H.A03()), Integer.valueOf(EnumC0726Jg.A0I.A03())));
                    if (jSONObject.getInt(A015) != enumC0726Jg.A03()) {
                        if (!hashSet.contains(Integer.valueOf(jSONObject.getInt(A015))) || !hashSet.contains(Integer.valueOf(enumC0726Jg.A03()))) {
                            throw new C0723Jc(AdErrorType.BID_IMPRESSION_MISMATCH, String.format(Locale.US, A01(104, 48, 77), valueOf, Integer.valueOf(jSONObject.getInt(A015)), enumC0726Jg));
                        }
                        return;
                    }
                    return;
                default:
                    throw new C0723Jc(AdErrorType.BID_PAYLOAD_ERROR, A01(210, 28, 16) + jSONObject.getString(A014));
            }
        } catch (JSONException e2) {
            c04447f.A07().A9a(A01(238, 3, 37), C8A.A0P, new C8B(e2));
            throw new C0723Jc(AdErrorType.BID_PAYLOAD_ERROR, A01(152, 18, 27), e2);
        }
    }

    public static String A01(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 99);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A04 = new byte[]{-13, 26, 21, -47, -42, 21, -47, 23, 32, 35, -47, 4, -11, -4, -47, 39, 22, 35, 36, 26, 32, 31, -47, -42, 36, -47, 19, 22, 26, 31, 24, -47, 38, 36, 22, 21, -47, 32, 31, -47, 4, -11, -4, -47, 39, 22, 35, 36, 26, 32, 31, -47, -42, 36, -57, -18, -23, -91, -86, -23, -91, -21, -12, -9, -91, -11, -15, -26, -24, -22, -14, -22, -13, -7, -91, -86, -8, -91, -25, -22, -18, -13, -20, -91, -6, -8, -22, -23, -91, -12, -13, -91, -11, -15, -26, -24, -22, -14, -22, -13, -7, -91, -86, -8, -14, 25, 20, -48, -43, 20, -48, 22, 31, 34, -48, 36, 21, 29, 32, 28, 17, 36, 21, -48, -43, 35, -48, 18, 21, 25, 30, 23, -48, 37, 35, 21, 20, -48, 31, 30, -48, 36, 21, 29, 32, 28, 17, 36, 21, -48, -43, 35, -57, -20, -12, -33, -22, -25, -30, -98, -64, -25, -30, -50, -33, -9, -22, -19, -33, -30, 15, 32, 40, 43, 39, 28, 47, 32, -37, -32, 46, -37, 36, 46, -37, 41, 42, 47, -37, 49, 28, 39, 36, 31, -37, 29, 28, 41, 41, 32, 45, -37, 47, 32, 40, 43, 39, 28, 47, 32, -56, -31, -26, -24, -29, -29, -30, -27, -25, -40, -41, -109, -75, -36, -41, -61, -44, -20, -33, -30, -44, -41, -109, -25, -20, -29, -40, -109, -23, -8, -15, -14, -7, -12, -17, -7, -12, 6, 13, 8, 3, 24, 13, 17, 9, 3, 24, 19, 15, 9, 18, -55, -54, -37, -50, -56, -54, -60, -50, -55, 58, 45, 59, 55, 52, 62, 45, 44, 39, 56, 52, 41, 43, 45, 53, 45, 54, 60, 39, 49, 44, 58, 43, 50, 38, 61, 44, 57, 58, 48, 54, 53, 44, 29, 37, 40, 36, 25, 44, 29, 33, 38, 29, 18};
    }

    static {
        A02();
    }

    public C0731Jl() {
        this.A00 = EnumC0730Jk.A03;
        this.A01 = null;
        this.A03 = null;
        this.A02 = null;
    }

    public static EnumC0726Jg A00(String str) throws C0723Jc {
        try {
            return EnumC0726Jg.A00(new JSONObject(str).getInt(A01(302, 8, 85)));
        } catch (JSONException e2) {
            throw new C0723Jc(AdErrorType.BID_PAYLOAD_ERROR, A01(152, 18, 27), e2);
        }
    }

    public static void A03(EnumC0726Jg enumC0726Jg) throws C0723Jc {
        if (EnumC0726Jg.A0F.equals(enumC0726Jg) || EnumC0726Jg.A0D.equals(enumC0726Jg) || EnumC0726Jg.A0E.equals(enumC0726Jg) || EnumC0726Jg.A0C.equals(enumC0726Jg)) {
            return;
        }
        throw new C0723Jc(AdErrorType.BID_IMPRESSION_MISMATCH, String.format(Locale.US, A01(170, 40, 88), Integer.valueOf(enumC0726Jg.A03())));
    }

    public final String A04() {
        Long l2 = this.A01;
        if (l2 == null) {
            return null;
        }
        String l3 = l2.toString();
        if (A05[5].charAt(0) != 'P') {
            A05[2] = "nWWGWN2JOSzWcz2EKeaa2WFuGi6FMoRa";
            return l3;
        }
        throw new RuntimeException();
    }

    public final String A05() {
        return this.A02;
    }

    public final boolean A06() {
        return this.A00 != EnumC0730Jk.A03;
    }
}
