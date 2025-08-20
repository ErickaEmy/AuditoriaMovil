package com.facebook.ads.redexgen.X;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.uv.v7.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.facebook.ads.redexgen.X.Fg  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0630Fg extends AbstractC1249bZ {
    public static byte[] A04;
    public static String[] A05 = {"eZwrQOnpnpQE2xbRo0zNjy7tlobdqdqH", "SFt7WwZUn", "NjRPf9lXQVcUlHZaPZ2tHyzwDKEOZm5m", "vsw9aGbGyLBdbL44W3z8tEYPUFR7w9", "bZApvv", "GYK1wV", "jBSwIULngy0dc0IzE6SbgF9ev3BAFzHy", "9HFC3JFq8"};
    public static final String A06;
    public OG A00;
    public final Uri A01;
    public final C1U A02;
    public final Map<String, String> A03;

    public static String A04(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            int i10 = (copyOfRange[i8] - i6) - 27;
            String[] strArr = A05;
            if (strArr[6].charAt(23) == strArr[0].charAt(23)) {
                throw new RuntimeException();
            }
            A05[3] = "uqLwDcTKX4SWJds2FMBMp5QNw2MnWtU";
            copyOfRange[i8] = (byte) i10;
        }
        return new String(copyOfRange);
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    private final List<Intent> A06() {
        List<C02780m> A052 = A05();
        ArrayList arrayList = new ArrayList();
        if (A052 != null) {
            for (C02780m c02780m : A052) {
                Intent A00 = A00(c02780m);
                if (A00 != null) {
                    arrayList.add(A00);
                }
            }
        }
        return arrayList;
    }

    public static void A07() {
        A04 = new byte[]{106, -105, -105, -108, -105, 69, -107, -122, -105, -104, -114, -109, -116, 69, -122, -107, -107, -104, -114, -103, -118, -124, -119, -122, -103, -122, -124, -97, -89, -86, -93, -94, 94, -78, -83, 94, -83, -82, -93, -84, 94, -85, -97, -80, -87, -93, -78, 94, -77, -80, -86, 120, 94, -29, -27, -5, 8, -2, 12, 9, 3, -2, -108, -95, -105, -91, -94, -100, -105, 97, -100, -95, -89, -104, -95, -89, 97, -108, -106, -89, -100, -94, -95, 97, 119, 124, 116, Byte.MAX_VALUE, -94, -81, -91, -77, -80, -86, -91, 111, -86, -81, -75, -90, -81, -75, 111, -94, -92, -75, -86, -80, -81, 111, -105, -118, -122, -104, -8, 7, 7, 10, 0, 11, -4, -10, -5, -8, 11, -8, -3, -15, 2, -5, -11, 4, -54, -65, -65, -12, -11, 4, -15, -7, -4, 3, -49, -7, -12, -51, -75, 3, -26, -25, -36, -27, -36, -37, -42, -37, -36, -36, -25, -29, -32, -27, -30, -108, -107, -118, -109, -118, -119, -124, -104, -103, -108, -105, -118, -124, -117, -122, -111, -111, -121, -122, -120, -112, -124, -102, -105, -111, -38, -37, -48, -39, -48, -49, -54, -34, -33, -38, -35, -48, -54, -32, -35, -41, -70, -85, -68, -67, -77, -72, -79, -51, -50, -55, -52, -65, -71, -61, -66, -10, -9, -14, -11, -24, -30, -8, -11, -17, -96, -95, -100, -97, -110, -116, -94, -97, -103, -116, -92, -110, -113, -116, -109, -114, -103, -103, -113, -114, -112, -104, -90, -105, -98, 108, -72, -87, -80, -76, -74, -77, -79, -76, -72, 126, -61, -63, -77, -64, -83, -80, -61, -76, -76, -77, -64, -77, -78, -83, -60, -73, -78, -77, -67, -83, -79, -70, -73, -79, -71};
    }

    static {
        A07();
        A06 = C0630Fg.class.getSimpleName();
    }

    public C0630Fg(C1116Yn c1116Yn, J2 j2, String str, Uri uri, Map<String, String> extraData, C02790o c02790o, boolean z2, C1U c1u) {
        super(c1116Yn, j2, str, c02790o, z2);
        this.A01 = uri;
        this.A03 = extraData;
        this.A02 = c1u;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0048, code lost:
        if (r4.startsWith(r0) != false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private android.content.Intent A00(com.facebook.ads.redexgen.X.C02780m r10) {
        /*
            Method dump skipped, instructions count: 286
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0630Fg.A00(com.facebook.ads.redexgen.X.0m):android.content.Intent");
    }

    private Intent A01(C02780m c02780m) {
        Intent intent = new Intent(A04(88, 26, 38));
        intent.addFlags(268435456);
        if (!TextUtils.isEmpty(c02780m.A05()) && !TextUtils.isEmpty(c02780m.A04())) {
            intent.setComponent(new ComponentName(c02780m.A05(), c02780m.A04()));
        }
        if (!TextUtils.isEmpty(c02780m.A03())) {
            intent.setData(AbstractC0767Ky.A00(c02780m.A03()));
        }
        return intent;
    }

    private final Uri A02() {
        String queryParameter = this.A01.getQueryParameter(A04(219, 9, 104));
        if (!TextUtils.isEmpty(queryParameter)) {
            return AbstractC0767Ky.A00(queryParameter);
        }
        Uri uri = this.A01;
        String storeUrl = A04(211, 8, 63);
        String storeId = uri.getQueryParameter(storeUrl);
        Locale locale = Locale.US;
        Object[] objArr = {storeId};
        String storeUrl2 = A04(126, 22, 117);
        return AbstractC0767Ky.A00(String.format(locale, storeUrl2, objArr));
    }

    private EnumC02720g A03() throws C0752Kh {
        C0764Kv c0764Kv = new C0764Kv();
        try {
            return C0764Kv.A05(c0764Kv, ((AbstractC02730h) this).A00, A02(), ((AbstractC02730h) this).A02, this.A03);
        } catch (C0752Kh unused) {
            String str = A04(26, 27, 35) + this.A01.toString();
            String queryParameter = this.A01.getQueryParameter(A04(228, 22, 18));
            if (queryParameter != null && queryParameter.length() > 0) {
                C0764Kv.A0D(c0764Kv, ((AbstractC02730h) this).A00, AbstractC0767Ky.A00(queryParameter), ((AbstractC02730h) this).A02);
            }
            return EnumC02720g.A08;
        }
    }

    private List<C02780m> A05() {
        String queryParameter = this.A01.getQueryParameter(A04(R.styleable.AppCompatTheme_tooltipForegroundColor, 12, 124));
        if (TextUtils.isEmpty(queryParameter)) {
            return null;
        }
        String appsiteDataString = A04(53, 2, 109);
        if (appsiteDataString.equals(queryParameter)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(queryParameter);
            String appsiteDataString2 = A04(55, 7, 127);
            JSONArray optJSONArray = jSONObject.optJSONArray(appsiteDataString2);
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    C02780m A00 = C02780m.A00(optJSONArray.optJSONObject(i));
                    if (A00 != null) {
                        arrayList.add(A00);
                    }
                }
            }
        } catch (JSONException e2) {
            AnonymousClass89 A07 = ((AbstractC02730h) this).A00.A07();
            int i5 = C8A.A24;
            C8B c8b = new C8B(e2);
            String appsiteDataString3 = A04(204, 7, 47);
            A07.A9a(appsiteDataString3, i5, c8b);
            String str = A06;
            String appsiteDataString4 = A04(0, 26, 10);
            Log.w(str, appsiteDataString4, e2);
        }
        return arrayList;
    }

    private boolean A08() {
        List<Intent> appLaunchIntents = A06();
        if (appLaunchIntents == null) {
            return false;
        }
        for (Intent intent : appLaunchIntents) {
            if (C0754Kj.A0C(((AbstractC02730h) this).A00, intent)) {
                return true;
            }
        }
        return false;
    }

    public static boolean A09(C1116Yn c1116Yn, String str) {
        if (Build.VERSION.SDK_INT >= 30 && str != null) {
            boolean A1g = C0705Ih.A1g(c1116Yn);
            if (A05[3].length() == 13) {
                throw new RuntimeException();
            }
            String[] strArr = A05;
            strArr[7] = "1LqNNd92i";
            strArr[1] = "QkgxMECyk";
            if (A1g) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1249bZ
    public final EnumC02720g A0D() {
        OG og;
        EnumC02720g enumC02720g = EnumC02720g.A08;
        if (((AbstractC1249bZ) this).A02) {
            enumC02720g = A0G();
        } else {
            this.A03.put(A04(188, 16, 80), String.valueOf(true));
        }
        if (!AbstractC0783Lo.A0e(((AbstractC02730h) this).A00, enumC02720g, this.A03)) {
            A0E(this.A03, enumC02720g);
            C1U.A06(this.A02, ((AbstractC02730h) this).A00);
        } else {
            EnumC02720g enumC02720g2 = EnumC02720g.A07;
            if (A05[2].charAt(11) != 'U') {
                throw new RuntimeException();
            }
            String[] strArr = A05;
            strArr[7] = "cFM2nXNzq";
            strArr[1] = "5qRqyCpR9";
            if (enumC02720g != enumC02720g2 && (og = this.A00) != null) {
                og.A0B(A04(264, 25, 51), this.A02, ((AbstractC02730h) this).A02);
            }
        }
        return enumC02720g;
    }

    public final EnumC02720g A0G() {
        EnumC02720g enumC02720g = EnumC02720g.A08;
        String A042 = A04(148, 15, 92);
        boolean A0F = A0F(this.A01);
        if (!A0F) {
            A0F = A08();
        }
        if (!A0F) {
            try {
                enumC02720g = A03();
                if (enumC02720g != EnumC02720g.A08) {
                    A042 = A04(188, 16, 80);
                } else {
                    A042 = A04(163, 25, 10);
                }
            } catch (Exception unused) {
                enumC02720g = EnumC02720g.A03;
            }
        }
        Map<String, String> map = this.A03;
        String redirectionAction = String.valueOf(true);
        map.put(A042, redirectionAction);
        return enumC02720g;
    }

    public final void A0H(OG og) {
        this.A00 = og;
    }
}
