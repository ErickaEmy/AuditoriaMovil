package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import com.facebook.ads.internal.exoplayer2.thirdparty.offline.DownloadAction;
import com.uv.v7.R;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class R0 {
    public static R0 A09;
    public static byte[] A0A;
    public static final DownloadAction.Deserializer[] A0B;
    public EG A00;
    public HK A01;
    public File A02;
    public boolean A03;
    public final C1115Ym A06;
    public final E9 A07;
    public final Handler A04 = new Handler(Looper.getMainLooper());
    public final SparseArray<C0923Qy> A05 = new SparseArray<>();
    public final Runnable A08 = new RunnableC0922Qx(this);

    public static String A07(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A0A, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 103);
        }
        return new String(copyOfRange);
    }

    public static void A0C() {
        A0A = new byte[]{-103, -69, -14, -19, -34, -20, -77, -103, -69, -3, 20, 15, 0, 14, -69, -24, 19, 27, 18, 16, 19, 5, 8, 9, 8, -46, -60, -9, 24, 5, 24, 9, -34, -60, 27, 72, 72, 69, 72, 4, -10, 41, 74, 55, 74, 59, 16, -10, -44, -31, -13, -21, 33, 36, 46, 55, -19, 33, 35, 52, 41, 47, 46, 51, -40, -37, -27, -18, -92, -37, -26, -18, -27, -29, -26, -40, -37, -22, 33, 36, 51, -40, -42, -40, -35, -38};
    }

    static {
        A0C();
        A0B = new DownloadAction.Deserializer[]{WY.A03};
    }

    public R0(C1115Ym c1115Ym, EG eg) {
        C0742Jw c0742Jw = new C0742Jw(this);
        this.A07 = c0742Jw;
        this.A06 = c1115Ym;
        if (eg != null) {
            this.A00 = eg;
            eg.A0Q(c0742Jw);
        }
        A01().A0P();
    }

    private synchronized EG A01() {
        if (this.A00 == null) {
            EG eg = new EG(new EL(A03(), A02()), 10, 5, new File(A06(), A07(52, 12, 89)), A0B);
            this.A00 = eg;
            eg.A0Q(this.A07);
        }
        return this.A00;
    }

    private AnonymousClass41 A02() {
        return new AnonymousClass41(A07(78, 3, 89), null);
    }

    private final synchronized HK A03() {
        if (this.A01 == null) {
            this.A01 = new C1034Vg(new File(A06(), A07(64, 14, 16)), new C0546Bk(C0705Ih.A0P(this.A06)));
        }
        return this.A01;
    }

    public static C1037Vj A04(C1053Vz c1053Vz, HK hk) {
        return new C1037Vj(hk, c1053Vz, new C1049Vv(), null, 2, null);
    }

    public static synchronized R0 A05(C1115Ym c1115Ym) {
        R0 r0;
        synchronized (R0.class) {
            if (A09 == null) {
                A09 = new R0(c1115Ym, null);
            }
            r0 = A09;
        }
        return r0;
    }

    private File A06() {
        if (this.A02 == null) {
            this.A02 = this.A06.getCacheDir();
        }
        return this.A02;
    }

    public static String A08(C1115Ym c1115Ym, Uri uri) {
        try {
            if (!C0705Ih.A1T(c1115Ym)) {
                return null;
            }
            return new URI(uri.getScheme(), uri.getAuthority(), uri.getPath(), null, uri.getFragment()).toString();
        } catch (URISyntaxException e2) {
            c1115Ym.A07().A9a(A07(81, 5, 14), C8A.A0u, new C8B(e2));
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A09() {
        EF[] A0S;
        for (EF ef : A01().A0S()) {
            int taskId = ef.A02;
            C0923Qy c0923Qy = this.A05.get(taskId);
            if (c0923Qy != null) {
                int i = ef.A01;
                if (i == 2 || ef.A03 > c0923Qy.A00) {
                    String str = A07(15, 19, 61) + i + A07(0, 8, 18) + ef.A03;
                    c0923Qy.A01.ABL(c0923Qy.A02);
                    this.A05.remove(taskId);
                } else if (i == 4 || i == 3) {
                    String str2 = A07(34, 14, R.styleable.AppCompatTheme_textColorSearchUrl) + i;
                    c0923Qy.A01.ABT(ef.A05);
                    this.A05.remove(taskId);
                }
            }
            String str3 = A07(48, 4, 25) + taskId + A07(8, 7, 52) + ef.A03;
        }
    }

    private void A0A() {
        if (!this.A03) {
            this.A03 = true;
            this.A04.post(this.A08);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0B() {
        this.A04.removeCallbacks(this.A08);
        this.A03 = false;
    }

    public final C1037Vj A0F(Context context) {
        return A04(new C1053Vz(context, (HG<? super InterfaceC0667Gu>) null, A02()), A03());
    }

    public final void A0G(Uri uri, InterfaceC0924Qz interfaceC0924Qz, long j2) {
        String A08 = A08(this.A06, uri);
        if (A08 == null) {
            A08 = uri.toString();
        }
        boolean A0H = A0H(A08);
        this.A05.put(A01().A0O(new WY(uri, false, null, A08)), new C0923Qy(interfaceC0924Qz, j2, A0H, null));
        A0A();
    }

    public final boolean A0H(String str) {
        return A03().A6G(str, 0L, 1L) > 0;
    }
}
