package com.facebook.ads.redexgen.X;

import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* renamed from: com.facebook.ads.redexgen.X.Re  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class AsyncTaskC0929Re extends AsyncTask<String, Void, C0930Rf> {
    public static byte[] A05;
    public static String[] A06 = {"iMGBqiSHm2uYyOurEO", "JHkNge3qKUrOixxb", "Efd0ZU7p6XsOViiGEn9FTnCEMV0phXsZ", "Qqux8MYyckh5CceEy", "ksejtLtP", "6qwv67", "yXEFufBpuo", "JuPO8KFa"};
    public static final String A07;
    public static final Set<String> A08;
    public C04447f A00;
    public RJ A01;
    public InterfaceC0928Rd A02;
    public Map<String, String> A03;
    public Map<String, String> A04;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    private final C0930Rf A00(String... strArr) {
        if (KL.A02(this)) {
            return null;
        }
        try {
            String str = strArr[0];
            if (!TextUtils.isEmpty(str) && !A08.contains(str)) {
                String A02 = A02(str);
                Map<String, String> map = this.A03;
                if (map != null && !map.isEmpty()) {
                    for (Map.Entry<String, String> entry : this.A03.entrySet()) {
                        A02 = A03(A02, entry.getKey(), entry.getValue());
                    }
                }
                int i = 1;
                while (true) {
                    int i5 = i + 1;
                    if (i > 2) {
                        return null;
                    }
                    if (A06(A02)) {
                        return new C0930Rf(this.A01);
                    }
                    i = i5;
                }
            }
            return null;
        } catch (Throwable th) {
            KL.A00(th, this);
            return null;
        }
    }

    public static String A01(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 90);
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        A05 = new byte[]{48, 0, 3, 57, 33, 22, 22, 11, 22, 68, 11, 20, 1, 10, 13, 10, 3, 68, 17, 22, 8, 94, 68, 122, 117, 122, 119, 116, 124, 44, 55, 46, 46};
    }

    static {
        A04();
        A07 = AsyncTaskC0929Re.class.getSimpleName();
        HashSet hashSet = new HashSet();
        A08 = hashSet;
        hashSet.add(A01(0, 1, 73));
        hashSet.add(A01(29, 4, 24));
    }

    public AsyncTaskC0929Re(C04447f c04447f) {
        this(c04447f, null, null);
    }

    public AsyncTaskC0929Re(C04447f c04447f, Map<String, String> extraData) {
        this(c04447f, extraData, null);
    }

    public AsyncTaskC0929Re(C04447f c04447f, Map<String, String> extraData, Map<String, String> postData) {
        this.A00 = c04447f;
        this.A03 = extraData != null ? new HashMap(extraData) : null;
        this.A04 = postData != null ? new HashMap(postData) : null;
    }

    private String A02(String str) {
        try {
            return A03(str, A01(23, 6, 65), LJ.A01(this.A00.A03().A61()));
        } catch (Exception unused) {
            return str;
        }
    }

    private String A03(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return str;
        }
        String A01 = A01(3, 1, 92);
        if (str.contains(A01)) {
            A01 = A01(1, 1, 124);
        }
        StringBuilder append = new StringBuilder().append(str).append(A01).append(str2);
        String prepend = A01(2, 1, 100);
        StringBuilder append2 = append.append(prepend);
        String prepend2 = URLEncoder.encode(str3);
        return append2.append(prepend2).toString();
    }

    private final void A05(C0930Rf response) {
        if (KL.A02(this)) {
            return;
        }
        try {
            InterfaceC0928Rd interfaceC0928Rd = this.A02;
            if (interfaceC0928Rd != null) {
                interfaceC0928Rd.AEC(response);
            }
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    private boolean A06(String str) {
        RJ ADy;
        RK A00 = C0927Rc.A00(this.A00);
        try {
            Map<String, String> map = this.A04;
            if (map == null || map.size() == 0) {
                ADy = A00.ADy(str, new RY());
            } else {
                RY params = new RY();
                params.A05(this.A04);
                ADy = A00.ADz(str, params.A08());
            }
            this.A01 = ADy;
        } catch (Exception e2) {
            Log.e(A07, A01(4, 19, 62) + str, e2);
        }
        RJ rj = this.A01;
        String[] strArr = A06;
        if (strArr[4].length() != strArr[7].length()) {
            throw new RuntimeException();
        }
        A06[2] = "iiLT70HajwBiOF9fGWlLisdNhF1wiwwV";
        return rj != null && rj.A83() == 200;
    }

    public final void A07(InterfaceC0928Rd interfaceC0928Rd) {
        this.A02 = interfaceC0928Rd;
    }

    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ C0930Rf doInBackground(String[] strArr) {
        if (KL.A02(this)) {
            return null;
        }
        try {
            return A00(strArr);
        } catch (Throwable th) {
            KL.A00(th, this);
            return null;
        }
    }

    @Override // android.os.AsyncTask
    public final void onCancelled() {
        InterfaceC0928Rd interfaceC0928Rd = this.A02;
        if (interfaceC0928Rd != null) {
            interfaceC0928Rd.AEA();
        }
    }

    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ void onPostExecute(C0930Rf c0930Rf) {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(c0930Rf);
        } catch (Throwable th) {
            if (A06[3].length() != 17) {
                throw new RuntimeException();
            }
            A06[2] = "KahWFkeddZk466vYoInqTxrEqXEaISmf";
            KL.A00(th, this);
        }
    }
}
