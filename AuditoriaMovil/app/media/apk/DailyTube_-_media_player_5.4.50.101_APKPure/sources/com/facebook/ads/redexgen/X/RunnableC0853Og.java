package com.facebook.ads.redexgen.X;
/* renamed from: com.facebook.ads.redexgen.X.Og  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class RunnableC0853Og implements Runnable {
    public static String[] A01 = {"ZvDtHAz5m48M18w3xVBvW9UUvAxUfTco", "Su9zcdtZ9ImnInrf0ILgVeApSeGsgvZI", "xXqvKIRF0PBjEGaR7TZ18ROMB", "m2Hewa3Z6gbURtNYV3SWt7DVdluwrYvz", "mWXUFmbAmKViJClAM9LXlAC", "0Y7AahKvzPLarINwhoocY8ezozCmsz", "5fBoxvqmYpNfoXwOAmWasRGE3QCsQXLn", "O4RwXCXfxOQMJWQD0Tqe5fA"};
    public final /* synthetic */ TT A00;

    public RunnableC0853Og(TT tt) {
        this.A00 = tt;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z2;
        if (KL.A02(this)) {
            return;
        }
        try {
            z2 = this.A00.A0O;
            if (!z2) {
                return;
            }
            this.A00.A0N();
        } catch (Throwable th) {
            String[] strArr = A01;
            if (strArr[0].charAt(31) == strArr[6].charAt(31)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[7] = "0ZDTnX20ALQ1qRFYGfQrfbk";
            strArr2[4] = "BYw49wL2ISjP5kGNoOWH1Xi";
            KL.A00(th, this);
        }
    }
}
