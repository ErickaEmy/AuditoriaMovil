package com.facebook.ads.redexgen.X;

import android.graphics.Rect;
import android.os.Handler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* renamed from: com.facebook.ads.redexgen.X.cR  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1292cR {
    public static String[] A0C = {"YcCIPLCDTe1wGTKdO7xqYhpFwQzvmXtt", "FfIdHaSVTal814YVh5tJNVr21T0wsSAo", "HLDls6wic6LzndIKtUvgWnGJ4QMP07cO", "ccYpD8PuArRKO9YkPTuVfhIh5pDN1br2", "LFFD576NBTVByEN649EglQB81U0zBBuc", "sO5gz1O188I9hNkbLLxzl8j4JWiDgVKK", "Hord6YvHX1lmSPmhXyMRW660HCYjcXOm", "5HbQDpK1pfSpB47EOovGOWVGJlrw1BSl"};
    public InterfaceC1296cV A00;
    public boolean A01;
    public final Rect A02;
    public final Rect A03;
    public final Handler A04;
    public final SU A05;
    public final InterfaceC1302cc A06;
    public final C1294cT A07;
    public final HB A08;
    public final Runnable A09;
    public final List<Rect> A0A;
    public final List<InterfaceC1281cG> A0B;

    public C1292cR(InterfaceC1302cc interfaceC1302cc, SU su, HB hb, C1294cT c1294cT, Handler handler) {
        this(interfaceC1302cc, su, hb, c1294cT, handler, 100);
    }

    public C1292cR(InterfaceC1302cc interfaceC1302cc, SU su, HB hb, C1294cT c1294cT, Handler handler, int i) {
        this.A03 = new Rect();
        this.A02 = new Rect();
        this.A0B = new ArrayList();
        this.A0A = new ArrayList();
        this.A01 = false;
        this.A06 = interfaceC1302cc;
        this.A05 = su;
        this.A08 = hb;
        this.A07 = c1294cT;
        this.A04 = handler;
        this.A09 = new RunnableC1293cS(this, i, new Exception());
    }

    private void A03(long j2) {
        if (this.A0B.isEmpty()) {
            this.A06.A8O(this.A0A);
            this.A08.A41(j2, this.A0A);
            this.A08.A5Z();
            return;
        }
        throw new IllegalStateException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A04(long j2) {
        this.A06.A8O(this.A0A);
        this.A08.A41(j2, this.A0A);
        if (this.A0B.isEmpty()) {
            this.A07.A03(this.A0B);
            Iterator<InterfaceC1281cG> it = this.A0B.iterator();
            loop0: while (true) {
                if (it.hasNext()) {
                    InterfaceC1281cG next = it.next();
                    C1300ca A00 = this.A07.A00(next);
                    for (Rect rect : this.A0A) {
                        if (next.A8N(this.A03, this.A02, rect) && A00 != C1300ca.A08) {
                            HB hb = this.A08;
                            Rect containerRect = this.A03;
                            Rect rect2 = this.A02;
                            if (A0C[0].charAt(21) != 'h') {
                                break loop0;
                            }
                            A0C[6] = "BhrT0c14O8Thrmtg3HRzOfRcpCyh5HNl";
                            hb.A3V(A00, containerRect, rect2);
                        }
                    }
                } else {
                    this.A08.A5Z();
                    InterfaceC1296cV interfaceC1296cV = this.A00;
                    if (interfaceC1296cV != null) {
                        interfaceC1296cV.AD2();
                    }
                    this.A0B.clear();
                    String[] strArr = A0C;
                    if (strArr[1].charAt(9) != strArr[3].charAt(9)) {
                        String[] strArr2 = A0C;
                        strArr2[1] = "lmQ3TWUKEycrXTOUs6diKoA3HcDn9Pdd";
                        strArr2[3] = "T2sieqBmgvCwHjMtYcExspPM2F3LyLlD";
                        return;
                    }
                }
            }
            throw new RuntimeException();
        }
        throw new IllegalStateException();
    }

    public final void A07() {
        InterfaceC1296cV interfaceC1296cV = this.A00;
        if (interfaceC1296cV != null) {
            interfaceC1296cV.AD2();
        }
        if (this.A01) {
            this.A04.removeCallbacks(this.A09);
            A03(this.A05.AAY());
        }
        this.A01 = false;
        if (A0C[0].charAt(21) != 'h') {
            throw new RuntimeException();
        }
        A0C[0] = "Da2exFZBguRvp8OTbNDxEhbqIKaEOHIs";
    }

    public final void A08() {
        if (!this.A01) {
            this.A01 = true;
            this.A04.post(this.A09);
        }
    }

    public final void A09(cX cXVar) {
        this.A08.AGH(cXVar);
    }

    public final void A0A(InterfaceC1296cV interfaceC1296cV) {
        this.A00 = interfaceC1296cV;
    }
}
