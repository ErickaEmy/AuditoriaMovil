package com.facebook.ads.redexgen.X;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
import java.util.Collections;
import java.util.List;
/* renamed from: com.facebook.ads.redexgen.X.63  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class AnonymousClass63 extends EM implements Handler.Callback {
    public static String[] A0D = {"gjDhtLri4FaGEAWjRmzGOIMLbPPteIUr", "gp3Mr1PqMY6rayIsxO9yJntmkSBHR7UD", "5ZPDaEp5A16UYvNfALSoSfbuhC4Pwik1", "wt", "uAQVQjgSUgDp2O8dWeXQS6qYbl", "Gm3ZCOzsQkh90YHushfajnERb16f", "RaSLUB1F0sju8CZYqMhotlzh76Y2FLCY", "Ujo7akDRrtwDl4IVTi3qcCtKoi2"};
    public int A00;
    public int A01;
    public Format A02;
    public WL A03;
    public C5 A04;
    public AbstractC0553Br A05;
    public AbstractC0553Br A06;
    public boolean A07;
    public boolean A08;
    public final Handler A09;
    public final C04999p A0A;
    public final InterfaceC0638Fq A0B;
    public final InterfaceC0639Fr A0C;

    public AnonymousClass63(InterfaceC0639Fr interfaceC0639Fr, Looper looper) {
        this(interfaceC0639Fr, looper, InterfaceC0638Fq.A00);
    }

    public AnonymousClass63(InterfaceC0639Fr interfaceC0639Fr, Looper looper, InterfaceC0638Fq interfaceC0638Fq) {
        super(3);
        this.A0C = (InterfaceC0639Fr) AbstractC0672Ha.A01(interfaceC0639Fr);
        this.A09 = looper == null ? null : new Handler(looper, this);
        this.A0B = interfaceC0638Fq;
        this.A0A = new C04999p();
    }

    private long A00() {
        int i = this.A01;
        if (i == -1 || i >= this.A06.A71()) {
            return Long.MAX_VALUE;
        }
        return this.A06.A70(this.A01);
    }

    private void A01() {
        A06(Collections.emptyList());
    }

    private void A02() {
        this.A04 = null;
        this.A01 = -1;
        AbstractC0553Br abstractC0553Br = this.A06;
        if (abstractC0553Br != null) {
            abstractC0553Br.A08();
            this.A06 = null;
        }
        AbstractC0553Br abstractC0553Br2 = this.A05;
        if (abstractC0553Br2 != null) {
            abstractC0553Br2.A08();
            this.A05 = null;
        }
    }

    private void A03() {
        A02();
        this.A03.AEV();
        this.A03 = null;
        this.A00 = 0;
    }

    private void A04() {
        A03();
        this.A03 = this.A0B.A4Z(this.A02);
    }

    private void A05(List<C0635Fn> list) {
        this.A0C.ABF(list);
    }

    private void A06(List<C0635Fn> list) {
        Handler handler = this.A09;
        if (handler != null) {
            handler.obtainMessage(0, list).sendToTarget();
        } else {
            A05(list);
        }
    }

    @Override // com.facebook.ads.redexgen.X.EM
    public final void A15() {
        this.A02 = null;
        A01();
        A03();
    }

    @Override // com.facebook.ads.redexgen.X.EM
    public final void A16(long j2, boolean z2) {
        A01();
        this.A07 = false;
        this.A08 = false;
        if (this.A00 != 0) {
            A04();
            return;
        }
        A02();
        this.A03.flush();
    }

    @Override // com.facebook.ads.redexgen.X.EM
    public final void A18(Format[] formatArr, long j2) throws C04879c {
        Format format = formatArr[0];
        this.A02 = format;
        if (this.A03 != null) {
            this.A00 = 1;
        } else {
            this.A03 = this.A0B.A4Z(format);
        }
    }

    @Override // com.facebook.ads.redexgen.X.Y5
    public final boolean A91() {
        return this.A08;
    }

    @Override // com.facebook.ads.redexgen.X.Y5
    public final boolean A9C() {
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0090, code lost:
        if (r6 == 0) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0094, code lost:
        if (r10.A00 != 2) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0096, code lost:
        A04();
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00a9, code lost:
        A02();
        r10.A08 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00bb, code lost:
        if (r6 == 0) goto L35;
     */
    @Override // com.facebook.ads.redexgen.X.Y5
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void AFB(long r11, long r13) throws com.facebook.ads.redexgen.X.C04879c {
        /*
            Method dump skipped, instructions count: 358
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass63.AFB(long, long):void");
    }

    @Override // com.facebook.ads.redexgen.X.AA
    public final int AGe(Format format) {
        if (this.A0B.AGf(format)) {
            return EM.A0y(null, format.A0H) ? 4 : 2;
        } else if (AbstractC0690Hs.A0A(format.A0O)) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                A05((List) message.obj);
                return true;
            default:
                throw new IllegalStateException();
        }
    }
}
