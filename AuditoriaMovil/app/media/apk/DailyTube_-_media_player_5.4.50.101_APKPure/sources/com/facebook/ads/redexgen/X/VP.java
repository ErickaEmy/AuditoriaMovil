package com.facebook.ads.redexgen.X;

import android.util.Log;
import android.util.Pair;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: assets/audience_network.dex */
public final class VP implements J0 {
    public static byte[] A02;
    public static String[] A03 = {"4VJF", "NMiFc9mQHDdEdTYDts8ebbMyjIljV2c0", "gJxI4lQggzgG7l1t48TOLBAVsZm4smpW", "RC", "7emK", "VnvWTQ3PSRLSSOUq71E5D", "jZ42e8scbVg896gjqaujwC7", "gj"};
    public static final String A04;
    public C1115Ym A00;
    public YH A01;

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i5);
        int i8 = 0;
        while (true) {
            int length = copyOfRange.length;
            String[] strArr = A03;
            if (strArr[0].length() != strArr[4].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A03;
            strArr2[5] = "6iaNxoAqzoeupDn53l2Cm";
            strArr2[6] = "N7vye13Dqewush4C3JTfsv4";
            if (i8 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 104);
            i8++;
        }
    }

    public static void A05() {
        A02 = new byte[]{21, 83, 90, 71, 21, 80, 67, 80, 91, 65, 124, 81, 21, 60, 111, 105, Byte.MAX_VALUE, Byte.MAX_VALUE, 121, 111, 111, 122, 105, 112, 112, 101, 50, 110, 101, 68, 77, 68, 85, 68, 69, 1, 68, 87, 68, 79, 85, 82, 1, 68, 89, 66, 68, 68, 69, 68, 69, 1, 83, 68, 85, 83, 88, 1, 77, 72, 76, 72, 85, 15, 1, 98, 78, 84, 79, 85, 27, 1, 72, 123, 104, 99, 121, 45, 121, 116, 125, 104, 45, 125, Byte.MAX_VALUE, 98, 110, 104, 126, 126, 104, 105, 45, 111, 116, 45, 121, 101, 104, 45, 126, 104, Byte.MAX_VALUE, 123, 104, Byte.MAX_VALUE, 55, 45, 84, 115, 123, 126, 119, 118, 50, 102, 125, 50, 98, 115, 96, 97, 119, 50, 115, 124, 50, 119, 100, 119, 124, 102, 50, 123, 124, 50, 119, 100, 119, 124, 102, 97, 50, 115, 96, 96, 115, 107, 50, 116, 125, 96, 50, 118, 123, 97, 98, 115, 102, 113, 122, 50, 116, 115, 123, 126, 103, 96, 119, 60, 65, 119, 96, 100, 119, 96, 50, 98, 96, 125, 113, 119, 97, 97, 119, 118, 50, 119, 100, 119, 124, 102, 91, 118, 50, 50, 4, 19, 23, 4, 19, 65, 19, 4, 21, 20, 19, 15, 4, 5, 65, 15, 14, 15, 76, 19, 4, 21, 19, 24, 0, 3, 13, 4, 65, 4, 19, 19, 14, 19, 65, 2, 14, 5, 4, 65, 42, 28, 11, 15, 28, 11, 89, 11, 28, 13, 12, 11, 23, 28, 29, 89, 11, 28, 13, 11, 0, 24, 27, 21, 28, 89, 28, 11, 11, 22, 11, 89, 26, 22, 29, 28, 89, 86, 109, 98, 97, 111, 102, 35, 119, 108, 35, 115, 98, 113, 112, 102, 35, 103, 102, 97, 118, 100, 79, 108, 100, 70, 117, 102, 109, 119, 35, 98, 119, 35, 6, 61, 50, 49, 63, 54, 115, 39, 60, 115, 35, 50, 33, 32, 54, 115, 54, 37, 54, 61, 39, 115, 50, 39, 115, 111, 84, 91, 88, 86, 95, 26, 78, 85, 26, 74, 91, 72, 73, 95, 26, 73, 95, 72, 76, 95, 72, 26, 72, 95, 73, 74, 85, 84, 73, 95, 26, 91, 78, 26, 74, 85, 73, 83, 78, 83, 85, 84, 26, 80, 92, 87, 86, 104, 109, 120, 109, 110, 109, Byte.MAX_VALUE, 105, 17, 2, 17, 26, 0, 7, 6, 5, 1, 20, 21, 18, 5, 77, 3, 15, 14, 6, 9, 7, 77, 5, 22, 5, 14, 20, 77, 13, 1, 7, 9, 3, 33, 34, 38, 51, 50, 53, 34, 24, 36, 40, 41, 33, 46, 32, 44, 33, 71, 90, 94, 86, 60, 39, 35, 45, 38, 59};
    }

    static {
        A05();
        A04 = VP.class.getSimpleName();
    }

    public VP(C1115Ym c1115Ym, YH yh) {
        this.A00 = c1115Ym;
        this.A01 = yh;
    }

    public static JSONArray A01(C1115Ym c1115Ym, JSONArray jSONArray, JSONArray jSONArray2) {
        int i = 0;
        if (jSONArray != null) {
            int limit = jSONArray.length();
            i = 0 + limit;
        }
        if (jSONArray2 != null) {
            int limit2 = jSONArray2.length();
            i += limit2;
        }
        return A02(c1115Ym, jSONArray, jSONArray2, i);
    }

    public static JSONArray A02(C1115Ym c1115Ym, JSONArray jSONArray, JSONArray jSONArray2, int i) {
        if (jSONArray == null) {
            return jSONArray2;
        }
        if (jSONArray2 == null) {
            return jSONArray;
        }
        int length = jSONArray.length();
        int length2 = jSONArray2.length();
        JSONArray jSONArray3 = new JSONArray();
        int debugIdx = 0;
        int limit = 0;
        JSONObject jSONObject = null;
        JSONObject jSONObject2 = null;
        double d2 = Double.MAX_VALUE;
        double d3 = Double.MAX_VALUE;
        while (true) {
            if ((debugIdx < length || limit < length2) && i > 0) {
                String[] strArr = A03;
                if (strArr[0].length() != strArr[4].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A03;
                strArr2[7] = "aN";
                strArr2[3] = "P5";
                String A00 = A00(435, 4, 91);
                if (debugIdx < length && jSONObject == null) {
                    try {
                        jSONObject = jSONArray.getJSONObject(debugIdx);
                        d2 = jSONObject.getDouble(A00);
                    } catch (JSONException e2) {
                        if (c1115Ym.A04().A8z()) {
                            Log.e(A04, A00(273, 33, 107) + debugIdx, e2);
                        }
                        jSONObject = null;
                        d2 = Double.MAX_VALUE;
                    }
                    debugIdx++;
                }
                if (limit < length2 && jSONObject2 == null) {
                    try {
                        jSONObject2 = jSONArray2.getJSONObject(limit);
                        d3 = jSONObject2.getDouble(A00);
                    } catch (JSONException e3) {
                        if (c1115Ym.A04().A8z()) {
                            Log.e(A04, A00(306, 25, 59) + limit, e3);
                        }
                        jSONObject2 = null;
                        d3 = Double.MAX_VALUE;
                    }
                    limit++;
                }
                if (jSONObject != null || jSONObject2 != null) {
                    if (jSONObject == null || d3 < d2) {
                        jSONArray3.put(jSONObject2);
                        jSONObject2 = null;
                        d3 = Double.MAX_VALUE;
                    } else {
                        jSONArray3.put(jSONObject);
                        jSONObject = null;
                        d2 = Double.MAX_VALUE;
                    }
                    i--;
                }
            }
        }
        if (i > 0) {
            if (jSONObject != null) {
                jSONArray3.put(jSONObject);
            } else if (jSONObject2 != null) {
                jSONArray3.put(jSONObject2);
            }
        }
        return jSONArray3;
    }

    private JSONObject A03() {
        JSONArray A032;
        JSONObject A5z = this.A01.A5z();
        JSONArray A5y = this.A01.A5y();
        if (Ij.A0P(this.A00) && (A032 = C8C.A03(this.A00)) != null && A032.length() > 0) {
            C1115Ym c1115Ym = this.A00;
            String[] strArr = A03;
            if (strArr[7].length() != strArr[3].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A03;
            strArr2[1] = "DqeH9SIpXFi3b8zfs8mhzwqF8zVFhPmm";
            strArr2[2] = "TV1z9woSYeZeWz7dxNs9KlrMFeTbS55S";
            A5y = A01(c1115Ym, A032, A5y);
        }
        JSONObject jSONObject = null;
        if (A5y != null) {
            try {
                jSONObject = new JSONObject();
                if (A5z != null) {
                    jSONObject.put(A00(439, 6, 32), A5z);
                }
                jSONObject.put(A00(387, 6, 28), A5y);
            } catch (JSONException unused) {
                return null;
            }
        }
        return jSONObject;
    }

    private JSONObject A04(int i) {
        int A08;
        JSONArray A042;
        Pair<JSONObject, JSONArray> tokensAndEvents = this.A01.A89(i);
        JSONObject jSONObject = (JSONObject) tokensAndEvents.first;
        JSONArray debugLogEvents = (JSONArray) tokensAndEvents.second;
        if (Ij.A0P(this.A00) && (A042 = C8C.A04(this.A00, (A08 = Ij.A08(this.A00)))) != null && A042.length() > 0) {
            debugLogEvents = A02(this.A00, A042, debugLogEvents, i + A08);
        }
        JSONObject payload = null;
        if (debugLogEvents != null) {
            try {
                payload = new JSONObject();
                if (jSONObject != null) {
                    payload.put(A00(439, 6, 32), jSONObject);
                }
                payload.put(A00(387, 6, 28), debugLogEvents);
            } catch (JSONException unused) {
                return null;
            }
        }
        return payload;
    }

    private void A06(String str) {
        if (C8C.A0I(str)) {
            C8C.A0B(this.A00, str);
        } else {
            this.A01.A8m(str);
        }
    }

    @Override // com.facebook.ads.redexgen.X.J0
    public final JSONObject A4a() {
        int eventLimit = Ij.A0F(this.A00);
        return eventLimit > 0 ? A04(eventLimit) : A03();
    }

    @Override // com.facebook.ads.redexgen.X.J0
    public final boolean A9A() {
        int eventCount = Ij.A0F(this.A00);
        if (eventCount < 1) {
            return false;
        }
        int A6z = this.A01.A6z();
        int eventLimit = C8C.A00(this.A00);
        return A6z + eventLimit > eventCount;
    }

    @Override // com.facebook.ads.redexgen.X.J0
    public final void AAi() {
        int A4I = this.A01.A4I(Ij.A0G(this.A00));
        if (A4I > 0) {
            this.A00.A07().A9a(A00(379, 8, 100), C8A.A10, new C8B(A00(28, 44, 73) + A4I));
        }
        C1115Ym c1115Ym = this.A00;
        String[] strArr = A03;
        String str = strArr[5];
        String str2 = strArr[6];
        int attemptsExceededEventsCount = str.length();
        int retryLimit = str2.length();
        if (attemptsExceededEventsCount == retryLimit) {
            throw new RuntimeException();
        }
        String[] strArr2 = A03;
        strArr2[5] = "bzDkK7DGlCk2AgYUikBmx";
        strArr2[6] = "oAHu9PBino36rPxONmBwiLk";
        C8C.A0F(c1115Ym);
    }

    @Override // com.facebook.ads.redexgen.X.J0
    public final void ABI(JSONArray jSONArray) {
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            try {
                A06(jSONArray.getJSONObject(i).getString(A00(433, 2, 45)));
            } catch (JSONException e2) {
                if (this.A00.A04().A8z()) {
                    String str = A04;
                    String[] strArr = A03;
                    String str2 = strArr[5];
                    String str3 = strArr[6];
                    int i5 = str2.length();
                    int length2 = str3.length();
                    if (i5 == length2) {
                        throw new RuntimeException();
                    }
                    String[] strArr2 = A03;
                    strArr2[1] = "UiT9WvgcUGvh4UJIWCcVV8uUv9KhPAuj";
                    strArr2[2] = "iCLGRVxWINjUDSHIa5c9b6YKh720uR79";
                    Log.e(str, A00(108, 62, 122), e2);
                } else {
                    continue;
                }
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.J0
    public final boolean ABJ(JSONArray jSONArray) {
        String A00 = A00(27, 1, 40);
        boolean z2 = true;
        boolean A0P = Ij.A0P(this.A00);
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String string = jSONObject.getString(A00(433, 2, 45));
                if (A00(393, 26, 8).equals(string)) {
                    C0705Ih.A0R(this.A00).A2X(jSONObject.getString(A00(419, 14, 47)));
                    this.A00.A03().AAL();
                } else {
                    int i5 = jSONObject.getInt(A00(375, 4, 91));
                    if (i5 == 1) {
                        if (this.A00.A04().A8z()) {
                            String str = A00(170, 25, 122) + string + A00(13, 14, 116);
                            String A72 = this.A01.A72(string);
                            if (A72 != null) {
                                String str2 = A00(72, 36, 101) + A72;
                            }
                        }
                        if (!this.A01.A53(string) && A0P) {
                            C8C.A0D(string);
                        }
                    } else {
                        String A002 = A00(0, 13, 93);
                        if (i5 >= 1000 && i5 < 2000) {
                            if (this.A00.A04().A8z()) {
                                Log.e(A04, A00(236, 37, 17) + i5 + A002 + string + A00);
                            }
                            A06(string);
                            z2 = false;
                        } else if (i5 >= 2000 && i5 < 3000) {
                            if (this.A00.A04().A8z()) {
                                Log.e(A04, A00(195, 41, 9) + i5 + A002 + string + A00);
                            }
                            if (!this.A01.A53(string) && A0P) {
                                C8C.A0D(string);
                            }
                        }
                    }
                }
            } catch (JSONException e2) {
                if (this.A00.A04().A8z()) {
                    Log.e(A04, A00(331, 44, 82) + i + A00, e2);
                }
                z2 = false;
            }
        }
        return z2;
    }

    @Override // com.facebook.ads.redexgen.X.J0
    public final void ACo() {
        this.A01.A4J();
        C8C.A07(this.A00);
    }
}
