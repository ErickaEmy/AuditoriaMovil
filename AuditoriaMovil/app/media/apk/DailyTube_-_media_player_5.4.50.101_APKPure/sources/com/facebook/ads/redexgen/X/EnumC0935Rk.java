package com.facebook.ads.redexgen.X;

import androidx.core.app.NotificationCompat;
import com.uv.v7.R;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Rk  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public enum EnumC0935Rk {
    A09(A00(145, 13, 65), EnumC0937Rm.A02, true),
    A08(A00(NotificationCompat.FLAG_HIGH_PRIORITY, 17, 7), EnumC0937Rm.A03, true),
    A07(A00(R.styleable.AppCompatTheme_tooltipForegroundColor, 14, 69), EnumC0937Rm.A03, false),
    A0A(A00(171, 23, 11), EnumC0937Rm.A03, false),
    A0B(A00(158, 13, 70), EnumC0937Rm.A03, true),
    A06(A00(97, 17, R.styleable.AppCompatTheme_textColorAlertDialogListItem), EnumC0937Rm.A03, false);
    
    public static byte[] A03;
    public static String[] A04 = {"5nlxAwyA", "XE2Zsycz8fD7h8FgdoKIBt2o6qMFmPIY", "ofhaw7uVp81FR8wRHHXoQVmraV", "Aw6MVAVF6astqfly", "IHvRq", "3UILp2hbsByEPqyl", "Bb0lGURQLUOEhbLX0rukWyrGFqKWpMNP", "bqLym"};
    public EnumC0937Rm A00;
    public String A01;
    public boolean A02;

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i, i + i5);
        int i8 = 0;
        while (true) {
            int length = copyOfRange.length;
            if (A04[0].length() == 21) {
                throw new RuntimeException();
            }
            A04[6] = "L2okF1EslEaalsNeHTyc5h4gzS7LeSXc";
            if (i8 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 64);
            i8++;
        }
    }

    public static void A01() {
        A03 = new byte[]{-84, -77, -82, -82, -81, -68, -55, -66, -71, -75, -81, -72, -55, -77, -72, -80, -71, -24, -25, -29, -10, -9, -12, -25, 1, -27, -15, -16, -24, -21, -23, -102, -106, -117, -115, -113, -105, -113, -104, -98, -87, -112, -103, -100, -105, -117, -98, -99, -57, -61, -72, -70, -68, -60, -68, -59, -53, -42, -64, -69, -54, -6, -4, -17, -16, -17, -2, -19, -14, -17, -18, 9, -21, -18, 9, -4, -17, -3, -6, -7, -8, -3, -17, -3, -71, -69, -82, -81, -82, -67, -84, -79, -56, -66, -69, -75, -68, 16, 23, 18, 18, 19, 32, 13, 34, 29, 25, 19, 28, 13, 23, 28, 20, 29, -21, -22, -26, -7, -6, -9, -22, -28, -24, -12, -13, -21, -18, -20, -73, -77, -88, -86, -84, -76, -84, -75, -69, 116, -83, -74, -71, -76, -88, -69, -70, -15, -19, -30, -28, -26, -18, -26, -17, -11, -82, -22, -27, -12, -10, -8, -21, -20, -21, -6, -23, -18, -27, -5, -8, -14, -7, -69, -67, -80, -79, -80, -65, -82, -77, -80, -81, 120, -84, -81, 120, -67, -80, -66, -69, -70, -71, -66, -80, -66};
    }

    static {
        A01();
    }

    EnumC0935Rk(String str, EnumC0937Rm enumC0937Rm, boolean z2) {
        this.A01 = str;
        this.A00 = enumC0937Rm;
        this.A02 = z2;
    }

    public final EnumC0937Rm A02() {
        return this.A00;
    }

    public final String A03() {
        return this.A01;
    }

    public final boolean A04() {
        return this.A02;
    }
}
