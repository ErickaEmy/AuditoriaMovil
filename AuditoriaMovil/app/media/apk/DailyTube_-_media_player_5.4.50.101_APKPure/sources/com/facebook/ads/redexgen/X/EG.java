package com.facebook.ads.redexgen.X;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.facebook.ads.internal.exoplayer2.thirdparty.offline.DownloadAction;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
/* loaded from: assets/audience_network.dex */
public final class EG {
    public static byte[] A0F;
    public static String[] A0G = {"68X6mTnOwXdfZzYVO84LiBNlITu89iQX", "mcCM", "SB1U", "GkXNtRrGsWIfNkCQn88aLdXmD8Z6vhvm", "Qey5CsRmzWj382X", "n9", "Qz1jsOzCfP5BXHleCyslZPCOD1Jlt2Hf", "OEfF4KTHhKUz1ci9ksApPyeCZN0rEDYT"};
    public int A00;
    public boolean A01;
    public boolean A02;
    public boolean A03;
    public final int A04;
    public final int A05;
    public final Handler A06;
    public final Handler A07;
    public final HandlerThread A08;
    public final C0596Dw A09;
    public final EL A0A;
    public final ArrayList<ED> A0B;
    public final ArrayList<ED> A0C;
    public final CopyOnWriteArraySet<E9> A0D;
    public final DownloadAction.Deserializer[] A0E;

    public static String A05(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A0F, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 37);
        }
        return new String(copyOfRange);
    }

    public static void A0C() {
        A0F = new byte[]{6, 69, 74, 71, 85, 78, 67, 85, 6, 81, 79, 82, 78, 6, 62, 36, 64, 117, 33, 109, 100, 96, 114, 117, 33, 110, 111, 100, 33, 69, 100, 114, 100, 115, 104, 96, 109, 104, 123, 100, 115, 33, 104, 114, 33, 115, 100, 112, 116, 104, 115, 100, 101, 47, 82, 121, 97, 120, 122, 121, 119, 114, 91, 119, 120, 119, 113, 115, 100, 54, 112, Byte.MAX_VALUE, 122, 115, 54, Byte.MAX_VALUE, 57, 121, 42, 31, 13, 21, 94, 23, 13, 94, 31, 26, 26, 27, 26, 9, 60, 46, 54, 125, 46, 41, 60, 41, 56, 125, 52, 46, 125, 62, 53, 60, 51, 58, 56, 57};
    }

    static {
        A0C();
    }

    public EG(EL el, int i, int i5, File file, DownloadAction.Deserializer... deserializerArr) {
        AbstractC0672Ha.A05(deserializerArr.length > 0, A05(16, 38, 36));
        this.A0A = el;
        this.A04 = i;
        this.A05 = i5;
        this.A09 = new C0596Dw(file);
        this.A0E = deserializerArr;
        this.A01 = true;
        this.A0C = new ArrayList<>();
        this.A0B = new ArrayList<>();
        Looper myLooper = Looper.myLooper();
        this.A07 = new Handler(myLooper == null ? Looper.getMainLooper() : myLooper);
        HandlerThread handlerThread = new HandlerThread(A05(54, 24, 51));
        this.A08 = handlerThread;
        handlerThread.start();
        this.A06 = new Handler(handlerThread.getLooper());
        this.A0D = new CopyOnWriteArraySet<>();
        A08();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ED A02(DownloadAction downloadAction) {
        int i = this.A00;
        this.A00 = i + 1;
        ED ed = new ED(i, this, downloadAction, this.A05, null);
        this.A0C.add(ed);
        A0J(A05(78, 13, 91), ed);
        return ed;
    }

    private void A08() {
        this.A06.post(new E7(this));
    }

    private void A09() {
        if (!A0R()) {
            return;
        }
        Iterator<E9> it = this.A0D.iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            if (A0G[3].charAt(7) == 'd') {
                throw new RuntimeException();
            }
            String[] strArr = A0G;
            strArr[5] = "Uj";
            strArr[4] = "M47RheKcpZxFkBs";
            if (hasNext) {
                it.next().ABg(this);
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0A() {
        DownloadAction A06;
        boolean z2;
        if (!this.A02 || this.A03) {
            return;
        }
        int i = (this.A01 || this.A0B.size() == this.A04) ? 1 : 0;
        for (int i5 = 0; i5 < this.A0C.size(); i5++) {
            ED ed = this.A0C.get(i5);
            boolean A0H = ED.A0H(ed);
            if (A0G[0].charAt(7) == 'Z') {
                throw new RuntimeException();
            }
            String[] strArr = A0G;
            strArr[5] = "ZZ";
            strArr[4] = "k3SOhcJE6F5rWIN";
            if (A0H && ((z2 = (A06 = ED.A06(ed)).A03) || i == 0)) {
                boolean z3 = true;
                int i6 = 0;
                while (true) {
                    if (i6 >= i5) {
                        break;
                    }
                    ED ed2 = this.A0C.get(i6);
                    boolean skipDownloadActions = ED.A06(ed2).A09(A06);
                    if (skipDownloadActions) {
                        if (z2) {
                            z3 = false;
                            String str = ed + A05(0, 14, 3) + ed2;
                            ED.A0C(ed2);
                        } else {
                            boolean skipDownloadActions2 = ED.A06(ed2).A03;
                            if (skipDownloadActions2) {
                                z3 = false;
                                i = 1;
                                break;
                            }
                        }
                    }
                    i6++;
                }
                if (z3) {
                    ED.A0D(ed);
                    if (!z2) {
                        this.A0B.add(ed);
                        i = this.A0B.size() == this.A04 ? 1 : 0;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0B() {
        if (this.A03) {
            return;
        }
        DownloadAction[] downloadActionArr = new DownloadAction[this.A0C.size()];
        for (int i = 0; i < this.A0C.size(); i++) {
            downloadActionArr[i] = ED.A06(this.A0C.get(i));
        }
        this.A06.post(new E8(this, downloadActionArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0D(ED ed) {
        A0J(A05(91, 21, 120), ed);
        EF A0K = ed.A0K();
        Iterator<E9> it = this.A0D.iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            if (A0G[0].charAt(7) == 'Z') {
                throw new RuntimeException();
            }
            A0G[0] = "TUrgn6We5nsrVkZlQG2KUeV0nEHaGaai";
            if (hasNext) {
                it.next().ADI(this, A0K);
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0E(ED ed) {
        if (this.A03) {
            return;
        }
        boolean z2 = !ed.A0L();
        if (z2) {
            this.A0B.remove(ed);
        }
        A0D(ed);
        if (A0G[3].charAt(7) == 'd') {
            throw new RuntimeException();
        }
        A0G[6] = "xCRZPuTuqF5VhljpIGNZbvIN3H6gjFvE";
        boolean stopped = ed.A0M();
        if (stopped) {
            this.A0C.remove(ed);
            A0B();
        }
        if (z2) {
            A0A();
            A09();
        }
    }

    public static void A0J(String str, ED ed) {
        String str2 = str + A05(14, 2, 33) + ed;
    }

    public final int A0O(DownloadAction downloadAction) {
        AbstractC0672Ha.A04(!this.A03);
        ED A02 = A02(downloadAction);
        if (this.A02) {
            A0B();
            A0A();
            if (ED.A03(A02) == 0) {
                A0D(A02);
            }
        }
        return ED.A04(A02);
    }

    public final void A0P() {
        AbstractC0672Ha.A04(!this.A03);
        if (this.A01) {
            this.A01 = false;
            A0A();
        }
    }

    public final void A0Q(E9 e9) {
        this.A0D.add(e9);
    }

    /* JADX WARN: Incorrect condition in loop: B:7:0x0014 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean A0R() {
        /*
            r4 = this;
            boolean r0 = r4.A03
            r3 = 1
            r0 = r0 ^ r3
            com.facebook.ads.redexgen.X.AbstractC0672Ha.A04(r0)
            boolean r0 = r4.A02
            r2 = 0
            if (r0 != 0) goto Ld
            return r2
        Ld:
            r1 = 0
        Le:
            java.util.ArrayList<com.facebook.ads.redexgen.X.ED> r0 = r4.A0C
            int r0 = r0.size()
            if (r1 >= r0) goto L28
            java.util.ArrayList<com.facebook.ads.redexgen.X.ED> r0 = r4.A0C
            java.lang.Object r0 = r0.get(r1)
            com.facebook.ads.redexgen.X.ED r0 = (com.facebook.ads.redexgen.X.ED) r0
            boolean r0 = r0.A0L()
            if (r0 == 0) goto L25
            return r2
        L25:
            int r1 = r1 + 1
            goto Le
        L28:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EG.A0R():boolean");
    }

    public final EF[] A0S() {
        AbstractC0672Ha.A04(!this.A03);
        EF[] efArr = new EF[this.A0C.size()];
        for (int i = 0; i < efArr.length; i++) {
            efArr[i] = this.A0C.get(i).A0K();
        }
        return efArr;
    }
}
