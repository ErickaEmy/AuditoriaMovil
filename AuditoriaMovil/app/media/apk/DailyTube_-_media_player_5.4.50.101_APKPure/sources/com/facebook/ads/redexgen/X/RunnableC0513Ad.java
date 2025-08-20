package com.facebook.ads.redexgen.X;
/* renamed from: com.facebook.ads.redexgen.X.Ad  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class RunnableC0513Ad implements Runnable {
    public static String[] A04 = {"FXI4YPweIufH3Pt2An4AzMiMJMICZW4T", "uwvDtUMtk5NfKP9ISDY7iI5dkoZYElca", "3X9Yz5oufkrzgSJKyyhGKrZukSdK4yin", "Yyt42t4P0aykOIe72Ke5sVEmhn6MxEuH", "iz4LAshm3lVaCmxiMFM9N835TW", "enfPo4zUqzsZuoLany8d1dcV5BB2cq5H", "laUDRm8UQKJHJcnNtldnOXq4xoZsd", "Oq3t3KRhK9K1doVwJCKt6wwkK0YNCaoI"};
    public final /* synthetic */ long A00;
    public final /* synthetic */ long A01;
    public final /* synthetic */ C0518Ai A02;
    public final /* synthetic */ String A03;

    public RunnableC0513Ad(C0518Ai c0518Ai, String str, long j2, long j4) {
        this.A02 = c0518Ai;
        this.A03 = str;
        this.A01 = j2;
        this.A00 = j4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        InterfaceC0519Aj interfaceC0519Aj;
        if (KL.A02(this)) {
            return;
        }
        try {
            interfaceC0519Aj = this.A02.A01;
            interfaceC0519Aj.AAo(this.A03, this.A01, this.A00);
        } catch (Throwable th) {
            KL.A00(th, this);
            String[] strArr = A04;
            if (strArr[4].length() == strArr[5].length()) {
                throw new RuntimeException();
            }
            A04[2] = "joW0YYt26OTJgtzaB2B3ZwKbOgOTkTMY";
        }
    }
}
