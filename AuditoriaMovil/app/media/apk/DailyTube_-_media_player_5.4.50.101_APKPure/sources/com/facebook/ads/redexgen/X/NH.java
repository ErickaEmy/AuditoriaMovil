package com.facebook.ads.redexgen.X;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.uv.v7.R;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public class NH implements View.OnClickListener {
    public static byte[] A01;
    public final /* synthetic */ NJ A00;

    static {
        A01();
    }

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 66);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-58, -57, -44, -38, -39, -97, -57, -47, -58, -45, -48, 20, 33, 18, 20, 22, 39, 28, 41, 28, 39, 44, -60, -47, -57, -43, -46, -52, -57, -111, -52, -47, -41, -56, -47, -41, -111, -60, -58, -41, -52, -46, -47, -111, -71, -84, -88, -70};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String str;
        String str2;
        String str3;
        C1116Yn c1116Yn;
        C1116Yn c1116Yn2;
        C1116Yn c1116Yn3;
        NI ni;
        if (KL.A02(this)) {
            return;
        }
        try {
            str = this.A00.A07;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            String A00 = A00(0, 11, 35);
            str2 = this.A00.A07;
            if (A00.equals(str2)) {
                return;
            }
            String A002 = A00(22, 26, 33);
            str3 = this.A00.A07;
            Intent intent = new Intent(A002, AbstractC0767Ky.A00(str3));
            intent.addFlags(268435456);
            c1116Yn = this.A00.A0B;
            c1116Yn.A0E().A8g();
            try {
                c1116Yn3 = this.A00.A0B;
                C0754Kj.A0C(c1116Yn3, intent);
                ni = this.A00.A05;
                ni.ACR();
            } catch (C0752Kh e2) {
                Throwable cause = e2.getCause();
                Throwable th = e2;
                if (cause != null) {
                    th = e2.getCause();
                }
                c1116Yn2 = this.A00.A0B;
                c1116Yn2.A07().A9a(A00(11, 11, R.styleable.AppCompatTheme_toolbarStyle), C8A.A00, new C8B(th));
            }
        } catch (Throwable th2) {
            KL.A00(th2, this);
        }
    }

    public NH(NJ nj2) {
        this.A00 = nj2;
    }
}
