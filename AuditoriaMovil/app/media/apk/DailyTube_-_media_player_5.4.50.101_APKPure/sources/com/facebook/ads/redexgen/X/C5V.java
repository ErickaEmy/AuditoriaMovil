package com.facebook.ads.redexgen.X;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.internal.api.AudienceNetworkActivityApi;
import com.facebook.ads.internal.context.Repairable;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderImpl;
import com.facebook.ads.internal.protocol.AdPlacementType;
import com.uv.v7.R;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/* renamed from: com.facebook.ads.redexgen.X.5V */
/* loaded from: assets/audience_network.dex */
public final class C5V implements AudienceNetworkActivityApi, Repairable {
    public static byte[] A0P;
    public static String[] A0Q = {"6hyfNvrTK6t0uOk4ZUiKTcly4lO9QIT3", "Cx5XWQG9gTlQcsVl0OO6K9WlulTSTZ", "4fLDdlgMQ2q", "AM05mUF2qaDkDYU3MyDNTK", "rN7iVf06fBiMXo1UDWoI2bEJDxOmVmjv", "9bqAz3M9pAQkcUJXzFdGLS", "1D1uNCEUmAwDpqE", "h0QQnxfLOYpp7kAK6sPhgGYv8wQTA65G"};
    public int A00;
    public int A02;
    public long A03;
    public long A04;
    public Intent A05;
    public RelativeLayout A06;
    public KB A07;
    public MD A08;
    public AbstractC0809Mo A09;
    public C0827Ng A0A;
    public C0896Px A0B;
    public String A0C;
    public String A0D;
    public String A0E;
    public boolean A0G;
    public boolean A0H;
    public boolean A0I;
    public boolean A0J;
    public boolean A0K;
    public final AudienceNetworkActivity A0L;
    public final AudienceNetworkActivityApi A0M;
    public final C1116Yn A0N;
    public final List<C5T> A0O = new ArrayList();
    public int A01 = -1;
    public boolean A0F = false;

    public static String A06(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A0P, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 111);
        }
        return new String(copyOfRange);
    }

    public static void A0B() {
        A0P = new byte[]{-3, 38, 71, 68, 87, 73, -36, -11, -24, -23, -13, -20, -89, -5, -10, -89, -16, -11, -19, -20, -7, -89, -3, -16, -20, -2, -37, 0, -9, -20, -89, -19, -7, -10, -12, -89, -16, -11, -5, -20, -11, -5, -89, -10, -7, -89, -6, -24, -3, -20, -21, -48, -11, -6, -5, -24, -11, -22, -20, -38, -5, -24, -5, -20, -12, 1, -14, -12, -10, 7, -4, 9, -4, 7, 12, -44, -46, -35, -35, -42, -29, -59, -22, -31, -42, 1, 10, 7, 3, 12, 18, -14, 13, 9, 3, 12, -32, -20, -22, -85, -29, -34, -32, -30, -33, -20, -20, -24, -85, -34, -31, -16, -85, -34, -31, -17, -30, -19, -20, -17, -15, -26, -21, -28, -85, -61, -58, -53, -58, -48, -59, -36, -66, -63, -36, -49, -62, -51, -52, -49, -47, -58, -53, -60, -36, -61, -55, -52, -44, 15, 27, 25, -38, 18, 13, 15, 17, 14, 27, 27, 23, -38, 13, 16, 31, -38, 21, 26, 32, 17, 30, 31, 32, 21, 32, 21, 13, 24, -38, 13, 15, 32, 21, 34, 21, 32, 37, 11, 16, 17, 31, 32, 30, 27, 37, 17, 16, -23, -11, -13, -76, -20, -25, -23, -21, -24, -11, -11, -15, -76, -25, -22, -7, -76, -17, -12, -6, -21, -8, -7, -6, -17, -6, -17, -25, -14, -76, -22, -17, -7, -13, -17, -7, -7, -21, -22, 16, 28, 26, -37, 19, 14, 16, 18, 15, 28, 28, 24, -37, 14, 17, 32, -37, 22, 27, 33, 18, 31, 32, 33, 22, 33, 22, 14, 25, -37, 17, 22, 32, 29, 25, 14, 38, 18, 17, 54, 66, 64, 1, 57, 52, 54, 56, 53, 66, 66, 62, 1, 52, 55, 70, 1, 60, 65, 71, 56, 69, 70, 71, 60, 71, 60, 52, 63, 1, 56, 69, 69, 66, 69, 75, 87, 85, 22, 78, 73, 75, 77, 74, 87, 87, 83, 22, 73, 76, 91, 22, 81, 86, 92, 77, 90, 91, 92, 81, 92, 81, 73, 84, 22, 78, 81, 86, 81, 91, 80, 71, 73, 75, 92, 81, 94, 81, 92, 97, 40, 52, 50, -13, 43, 38, 40, 42, 39, 52, 52, 48, -13, 38, 41, 56, -13, 46, 51, 57, 42, 55, 56, 57, 46, 57, 46, 38, 49, -13, 46, 50, 53, 55, 42, 56, 56, 46, 52, 51, -13, 49, 52, 44, 44, 42, 41, 61, 78, 61, 70, 76, 14, 3, 16, 6, 21, 5, 3, 18, 7, -10, -18, -19, -14, -22, -3, -14, -8, -9, -51, -22, -3, -22, 85, 92, 83, 83, 75, 82, 65, 78, 78, 69, 64, 65, 32, 81, 73, 76, 79, 85, 79, -10, -14, -25, -23, -21, -13, -21, -12, -6, -49, -22, 41, 40, 43, 45, 43, 26, 34, 45, -16, -14, -27, -28, -27, -26, -23, -18, -27, -28, -49, -14, -23, -27, -18, -12, -31, -12, -23, -17, -18, -53, -27, -7, 54, 41, 53, 57, 41, 55, 56, 24, 45, 49, 41, 87, 79, 77, 84, 37, 74, 88, 73, 86, 55, 73, 71, 83, 82, 72, 87, -4, -9, -25, -9, -6, -15, -19, -10, -4, -23, -4, -15, -9, -10, 95, 88, 83, 91, 95, 79, 51, 78, -17, -30, -34, -16, -51, -14, -23, -34};
    }

    static {
        A0B();
    }

    public C5V(AudienceNetworkActivity audienceNetworkActivity, AudienceNetworkActivityApi audienceNetworkActivityApi) {
        this.A0L = audienceNetworkActivity;
        this.A0M = audienceNetworkActivityApi;
        C1116Yn A02 = C03955c.A02(audienceNetworkActivity);
        this.A0N = A02;
        A02.A0L(this);
    }

    private int A00() {
        Rect rect = new Rect();
        Window window = this.A0L.getWindow();
        if (window == null) {
            return 2;
        }
        window.getDecorView().getWindowVisibleDisplayFrame(rect);
        if (rect.top < 200 && rect.left < 200) {
            return 1;
        }
        return 0;
    }

    private MD A02(Intent intent) {
        MD A0I;
        MD A0R;
        MD A0P2;
        MD A0H;
        MD A02;
        MD A0O;
        MD A0N;
        MD A0Q2;
        MD A0G;
        MD A0L;
        MD A0J;
        MD A0K;
        MD A0M;
        C5S c5s = new C5S(this, intent, this.A0N.A09(), this.A0N, null);
        if (this.A07 == null) {
            return null;
        }
        switch (C5R.A00[this.A07.ordinal()]) {
            case 1:
                A0I = c5s.A0I(this.A06);
                return A0I;
            case 2:
                A0R = c5s.A0R();
                return A0R;
            case 3:
                A0P2 = c5s.A0P();
                if (A0Q[6].length() != 15) {
                    throw new RuntimeException();
                }
                A0Q[2] = "9AjKOltSNiH";
                return A0P2;
            case 4:
                A0H = c5s.A0H();
                return A0H;
            case 5:
                A02 = c5s.A02();
                return A02;
            case 6:
                A0O = c5s.A0O();
                return A0O;
            case 7:
                A0N = c5s.A0N();
                return A0N;
            case 8:
                A0Q2 = c5s.A0Q();
                return A0Q2;
            case 9:
                A0G = c5s.A0G();
                if (A0Q[1].length() != 0) {
                    A0Q[1] = "wwrXZHO6We2";
                    return A0G;
                }
                A0Q[1] = "bd05r2lrBXgQHiU8zhW56DndFWzJq";
                return A0G;
            case 10:
                A0L = c5s.A0L();
                return A0L;
            case 11:
                A0J = c5s.A0J();
                if (A0Q[2].length() != 25) {
                    A0Q[7] = "st3v0TpfdqXoPWlO02nQcse4uCAIapoF";
                    return A0J;
                }
                throw new RuntimeException();
            case 12:
                A0K = c5s.A0K();
                return A0K;
            case 13:
            case 14:
                A0M = c5s.A0M(this.A07);
                if (A0Q[7].charAt(27) != 'B') {
                    A0Q[1] = "x";
                    return A0M;
                }
                throw new RuntimeException();
            case 15:
                return c5s.A0U();
            default:
                return null;
        }
    }

    private String A05() {
        KB kb = this.A07;
        String value = kb != null ? kb.A02() : null;
        if (value != null) {
            return value;
        }
        return A06(429, 4, 120);
    }

    private void A08() {
        String str = this.A0E;
        if (str != null) {
            C0896Px A01 = AbstractC0895Pw.A01(this.A0N, str);
            this.A0B = A01;
            if (A01 != null) {
                this.A06.addView(this.A0B, new RelativeLayout.LayoutParams(-1, -1));
            }
        }
    }

    private void A09() {
        if ((this.A0N.A0F().A01() || C0705Ih.A1c(this.A0N)) && Build.VERSION.SDK_INT >= 24) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.facebook.ads.redexgen.X.5Q
                @Override // java.lang.Runnable
                public final void run() {
                    C5V.this.A0M();
                }
            }, 1000L);
        }
    }

    private void A0A() {
        boolean z2 = !this.A0J || C0705Ih.A1a(this.A0N);
        boolean shouldCallOnDestroy = this.A0I;
        if (!shouldCallOnDestroy && z2) {
            boolean shouldCallOnDestroy2 = A0I();
            if (shouldCallOnDestroy2) {
                A0G(QP.A03.A02());
            } else {
                A0G(A06(149, 48, 61));
            }
            this.A0I = true;
        }
    }

    private void A0C(Intent intent) {
        if (C0705Ih.A11(this.A0L)) {
            KB kb = this.A07;
            KB kb2 = KB.A03;
            if (A0Q[2].length() == 25) {
                throw new RuntimeException();
            }
            A0Q[1] = "ROWUzhbvPevH2";
            if (kb != kb2 && Build.VERSION.SDK_INT >= 18) {
                this.A0A = new C0827Ng();
                this.A0A.A0C(intent.getStringExtra(A06(448, 11, 23)));
                C0827Ng c0827Ng = this.A0A;
                String placementId = this.A0L.getPackageName();
                c0827Ng.A0B(placementId);
                String placementId2 = A06(491, 11, 85);
                long longExtra = intent.getLongExtra(placementId2, 0L);
                if (longExtra != 0) {
                    this.A0A.A09(longExtra);
                }
                TextView textView = new TextView(this.A0L);
                String placementId3 = A06(1, 5, R.styleable.AppCompatTheme_tooltipFrameBackground);
                textView.setText(placementId3);
                textView.setTextColor(-1);
                AbstractC0783Lo.A0M(textView, Color.argb(160, 0, 0, 0));
                textView.setPadding(5, 5, 5, 5);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(12, -1);
                layoutParams.addRule(11, -1);
                textView.setLayoutParams(layoutParams);
                C5U c5u = new C5U(this, null);
                textView.setOnLongClickListener(c5u);
                this.A06.setOnLongClickListener(c5u);
                this.A06.getOverlay().add(this.A0A);
            }
        }
    }

    private void A0D(Intent intent, Bundle bundle) {
        String A06 = A06(540, 8, 10);
        String A062 = A06(532, 8, 123);
        String A063 = A06(467, 24, 17);
        if (bundle != null) {
            Bundle A02 = C0754Kj.A02(bundle, DynamicLoaderImpl.class.getClassLoader());
            this.A01 = A02.getInt(A063, -1);
            this.A0C = A02.getString(A062);
            this.A07 = (KB) A02.getSerializable(A06);
            return;
        }
        this.A01 = intent.getIntExtra(A063, -1);
        this.A0C = intent.getStringExtra(A062);
        this.A07 = (KB) intent.getSerializableExtra(A06);
        this.A02 = intent.getIntExtra(A06(502, 16, 117), 0) * 1000;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0058, code lost:
        if (r3.equals(r6) != false) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void A0G(java.lang.String r6) {
        /*
            r5 = this;
            r2 = 355(0x163, float:4.97E-43)
            r1 = 47
            r0 = 86
            java.lang.String r0 = A06(r2, r1, r0)
            boolean r0 = r0.equals(r6)
            r4 = 1
            if (r0 != 0) goto L1d
            com.facebook.ads.redexgen.X.QP r0 = com.facebook.ads.redexgen.X.QP.A0A
            java.lang.String r0 = r0.A02()
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L1f
        L1d:
            r5.A0H = r4
        L1f:
            r2 = 275(0x113, float:3.85E-43)
            r1 = 35
            r0 = 100
            java.lang.String r0 = A06(r2, r1, r0)
            boolean r0 = r0.equals(r6)
            if (r0 != 0) goto L5a
            com.facebook.ads.redexgen.X.QP r0 = com.facebook.ads.redexgen.X.QP.A09
            java.lang.String r3 = r0.A02()
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.C5V.A0Q
            r0 = 6
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 15
            if (r1 == r0) goto L48
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L48:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C5V.A0Q
            java.lang.String r1 = "BsUqgJlN3izr4734FAkiK4"
            r0 = 5
            r2[r0] = r1
            java.lang.String r1 = "DZ4pb9dksBh2p0w2isnwDh"
            r0 = 3
            r2[r0] = r1
            boolean r0 = r3.equals(r6)
            if (r0 == 0) goto L5c
        L5a:
            r5.A0G = r4
        L5c:
            r2 = 96
            r1 = 53
            r0 = 14
            java.lang.String r0 = A06(r2, r1, r0)
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L72
            r0 = 9
            r5.finish(r0)
            return
        L72:
            r2 = 310(0x136, float:4.34E-43)
            r1 = 45
            r0 = 121(0x79, float:1.7E-43)
            java.lang.String r0 = A06(r2, r1, r0)
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L88
            r0 = 10
            r5.finish(r0)
            return
        L88:
            r0 = 0
            r5.A0P(r6, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5V.A0G(java.lang.String):void");
    }

    public void A0H(String str, C02911a c02911a) {
        if (this.A08 == null) {
            return;
        }
        if (this.A09 == null) {
            C1116Yn c1116Yn = this.A0N;
            this.A09 = AbstractC0810Mp.A02(c1116Yn, c1116Yn.A09(), str, c02911a, this.A08, new ZW(this, null));
            this.A09.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        }
        AbstractC0783Lo.A0J(this.A09);
        AbstractC0783Lo.A0T(this.A06);
        this.A06.addView(this.A09);
        this.A09.A0K();
    }

    private boolean A0I() {
        return this.A07 == KB.A0H || this.A07 == KB.A0G || this.A07 == KB.A08 || this.A07 == KB.A05 || this.A07 == KB.A0F;
    }

    public final AudienceNetworkActivity A0J() {
        return this.A0L;
    }

    public final C1116Yn A0K() {
        return this.A0N;
    }

    public final void A0L() {
        if (A0I()) {
            A0G(QP.A09.A02());
        } else {
            A0G(A06(275, 35, 100));
        }
    }

    public final /* synthetic */ void A0M() {
        if (this.A0L.isInMultiWindowMode()) {
            this.A0N.A0E().AA6(A00());
        }
    }

    public final void A0N(C5T c5t) {
        this.A0O.add(c5t);
    }

    public final void A0O(C5T c5t) {
        this.A0O.remove(c5t);
    }

    public final void A0P(String str, C04768q c04768q) {
        Intent intent = new Intent(str + A06(0, 1, 84) + this.A0C);
        if (c04768q != null) {
            intent.putExtra(A06(402, 5, 105), c04768q);
        }
        C03312o.A00(this.A0L).A07(intent);
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        AbstractC0760Kr.A00();
        if (0 != 0) {
            throw new NullPointerException(A06(433, 15, 109));
        }
        this.A0M.dump(str, fileDescriptor, printWriter, strArr);
    }

    public final void finish(int i) {
        this.A0N.A0E().A2c(String.valueOf(A0J().hashCode()), i, A05());
        if (this.A0L.isFinishing()) {
            return;
        }
        if (C0705Ih.A1U(this.A0N) && !this.A0H && !this.A0G) {
            this.A0N.A0E().AAX();
            A0L();
        }
        if (A0I() && !this.A0F) {
            A0G(QP.A05.A02());
        } else {
            A0G(A06(197, 39, 23));
        }
        this.A0J = true;
        A0A();
        this.A0M.finish(i);
    }

    public final void onActivityResult(int i, int i5, Intent intent) {
        MD md = this.A08;
        if (md != null && md.onActivityResult(i, i5, intent)) {
            return;
        }
        U1.A09(i, i5, intent);
    }

    public final void onBackPressed() {
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = this.A03;
        long currentTime = currentTimeMillis - this.A04;
        long j4 = j2 + currentTime;
        this.A03 = j4;
        this.A04 = currentTimeMillis;
        if (j4 > this.A02) {
            boolean shouldIntercept = false;
            for (C5T c5t : this.A0O) {
                if (c5t.A8u()) {
                    shouldIntercept = true;
                }
            }
            if (!shouldIntercept) {
                this.A0M.onBackPressed();
            }
        }
    }

    public final void onConfigurationChanged(Configuration configuration) {
        if (this.A00 != configuration.orientation) {
            HashMap hashMap = new HashMap();
            int i = configuration.orientation;
            String A06 = A06(518, 14, 25);
            if (i == 1) {
                hashMap.put(A06, A06(459, 8, 74));
            } else {
                hashMap.put(A06, A06(407, 9, 51));
            }
            J9 j9 = J9.A0K;
            MD md = this.A08;
            JA.A02(j9, hashMap, md == null ? A06(0, 0, 50) : md.getCurrentClientToken(), this.A0N.A09());
            this.A00 = configuration.orientation;
            A09();
        }
    }

    public final void onCreate(Bundle bundle) {
        AbstractC0785Lq.A02();
        if (C0705Ih.A1p(this.A0L)) {
            Window window = this.A0L.getWindow();
            String[] strArr = A0Q;
            if (strArr[0].charAt(26) != strArr[4].charAt(26)) {
                throw new RuntimeException();
            }
            A0Q[6] = "7njofUp2AYjKONZ";
            window.setFlags(16777216, 16777216);
        }
        Intent intent = C0754Kj.A01(this.A0L.getIntent(), DynamicLoaderImpl.class.getClassLoader());
        this.A05 = intent;
        C1116Yn A03 = C0754Kj.A03(intent);
        if (A03 != null) {
            C1116Yn startAdContext = this.A0N;
            startAdContext.A0J(A03.A0E());
            C1116Yn startAdContext2 = this.A0N;
            startAdContext2.A0C(A03.A0B());
            C1116Yn startAdContext3 = this.A0N;
            startAdContext3.A0M(A03.A0G());
        }
        A0D(this.A05, bundle);
        this.A0N.A0E().A2d(String.valueOf(A0J().hashCode()), A05());
        String stringExtra = this.A05.getStringExtra(A06(75, 10, 2));
        boolean z2 = stringExtra == null || !(stringExtra.equals(AdPlacementType.INTERSTITIAL.name()) || stringExtra.equals(AdPlacementType.REWARDED_VIDEO.name()));
        if (C0705Ih.A2N(this.A0N) && this.A07 == KB.A03 && z2) {
            this.A0L.getWindow().setFlags(512, 512);
        } else {
            this.A0L.requestWindowFeature(1);
            this.A0L.getWindow().setFlags(1024, 1024);
        }
        RelativeLayout relativeLayout = new RelativeLayout(this.A0L);
        this.A06 = relativeLayout;
        AbstractC0783Lo.A0M(relativeLayout, 0);
        this.A0L.setContentView(this.A06, new RelativeLayout.LayoutParams(-1, -1));
        MD A02 = A02(this.A05);
        this.A08 = A02;
        if (A02 == null) {
            this.A0N.A07().A9a(A06(64, 11, 36), C8A.A0A, new C8B(A06(6, 58, 24)));
            A0L();
            finish(7);
            return;
        }
        A02.A9Q(this.A05, bundle, this);
        A0G(A06(236, 39, 62));
        this.A04 = System.currentTimeMillis();
        this.A0E = this.A05.getStringExtra(A06(416, 13, 26));
        A08();
        A0C(this.A05);
        this.A00 = this.A0L.getResources().getConfiguration().orientation;
        String A06 = A06(85, 11, 47);
        if (bundle != null) {
            this.A0D = bundle.getString(A06);
        } else {
            this.A0D = this.A05.getStringExtra(A06);
        }
        if (C0705Ih.A1x(this.A0L) && this.A0L.getWindow() != null) {
            this.A0L.getWindow().addFlags(NotificationCompat.FLAG_HIGH_PRIORITY);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x0064, code lost:
        if (r3 != null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x006c, code lost:
        if (com.facebook.ads.redexgen.X.C0705Ih.A11(r4.A0L) == false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x006e, code lost:
        r4.A0A.A07();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0073, code lost:
        r3 = r4.A09;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0080, code lost:
        if (com.facebook.ads.redexgen.X.C5V.A0Q[2].length() == 25) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0082, code lost:
        r2 = com.facebook.ads.redexgen.X.C5V.A0Q;
        r2[5] = "rHb3ILEFnyWtMYiOwcguj0";
        r2[3] = "XKBHK5KZoSEcfbvzOM5yLt";
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x008e, code lost:
        if (r3 == null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0090, code lost:
        r3.A0J();
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0093, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0094, code lost:
        if (r3 == null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x009e, code lost:
        if (r3 != null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:?, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onDestroy() {
        /*
            r4 = this;
            com.facebook.ads.redexgen.X.Yn r0 = r4.A0N
            com.facebook.ads.redexgen.X.0S r2 = r0.A0E()
            com.facebook.ads.AudienceNetworkActivity r0 = r4.A0J()
            int r0 = r0.hashCode()
            java.lang.String r1 = java.lang.String.valueOf(r0)
            java.lang.String r0 = r4.A05()
            r2.A2e(r1, r0)
            r4.A0A()
            android.widget.RelativeLayout r0 = r4.A06
            if (r0 == 0) goto L23
            r0.removeAllViews()
        L23:
            com.facebook.ads.redexgen.X.MD r0 = r4.A08
            if (r0 == 0) goto L4e
            r0.onDestroy()
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C5V.A0Q
            r0 = 0
            r1 = r2[r0]
            r0 = 4
            r2 = r2[r0]
            r0 = 26
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto L44
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L44:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C5V.A0Q
            java.lang.String r1 = "BK5JyIukG"
            r0 = 1
            r2[r0] = r1
            r0 = 0
            r4.A08 = r0
        L4e:
            com.facebook.ads.redexgen.X.Ng r3 = r4.A0A
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C5V.A0Q
            r0 = 0
            r1 = r2[r0]
            r0 = 4
            r2 = r2[r0]
            r0 = 26
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto L97
            if (r3 == 0) goto L73
        L66:
            com.facebook.ads.AudienceNetworkActivity r0 = r4.A0L
            boolean r0 = com.facebook.ads.redexgen.X.C0705Ih.A11(r0)
            if (r0 == 0) goto L73
            com.facebook.ads.redexgen.X.Ng r0 = r4.A0A
            r0.A07()
        L73:
            com.facebook.ads.redexgen.X.Mo r3 = r4.A09
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.C5V.A0Q
            r0 = 2
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 25
            if (r1 == r0) goto L94
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C5V.A0Q
            java.lang.String r1 = "rHb3ILEFnyWtMYiOwcguj0"
            r0 = 5
            r2[r0] = r1
            java.lang.String r1 = "XKBHK5KZoSEcfbvzOM5yLt"
            r0 = 3
            r2[r0] = r1
            if (r3 == 0) goto L93
        L90:
            r3.A0J()
        L93:
            return
        L94:
            if (r3 == 0) goto L93
            goto L90
        L97:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C5V.A0Q
            java.lang.String r1 = "VoJV9dI9dal5KZ60JkB8i5Bpps"
            r0 = 2
            r2[r0] = r1
            if (r3 == 0) goto L73
            goto L66
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5V.onDestroy():void");
    }

    public final void onPause() {
        this.A0N.A0E().A2f(String.valueOf(A0J().hashCode()), A05());
        this.A03 += System.currentTimeMillis() - this.A04;
        MD md = this.A08;
        if (md != null) {
            md.ACW(false);
            if (!this.A0L.isFinishing()) {
                JA.A02(J9.A0E, null, this.A08.getCurrentClientToken(), this.A0N.A09());
                this.A0K = true;
            }
        }
    }

    public final void onResume() {
        this.A0N.A0E().A2g(String.valueOf(A0J().hashCode()), A05());
        this.A04 = System.currentTimeMillis();
        MD md = this.A08;
        if (md != null) {
            md.ACu(false);
            if (this.A0K) {
                JA.A02(J9.A0F, null, this.A08.getCurrentClientToken(), this.A0N.A09());
            }
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        MD md = this.A08;
        if (md != null) {
            md.AFT(bundle2);
        }
        bundle2.putInt(A06(467, 24, 17), this.A01);
        bundle2.putString(A06(532, 8, 123), this.A0C);
        bundle2.putString(A06(85, 11, 47), this.A0D);
        bundle2.putSerializable(A06(540, 8, 10), this.A07);
        C0754Kj.A09(bundle, bundle2);
    }

    public final void onStart() {
        this.A0N.A0E().A2h(String.valueOf(A0J().hashCode()), A05());
        int i = this.A01;
        if (i != -1) {
            M7.A02(this.A0L, i, this.A0N);
        }
    }

    public final void onStop() {
        this.A0N.A0E().A2i(String.valueOf(A0J().hashCode()), A05());
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return this.A0M.onTouchEvent(motionEvent);
    }

    public final void repair(Throwable th) {
        A0L();
        finish(5);
    }
}
