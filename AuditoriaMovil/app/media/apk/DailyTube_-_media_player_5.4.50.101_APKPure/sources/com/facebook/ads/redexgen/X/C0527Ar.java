package com.facebook.ads.redexgen.X;

import android.media.AudioTrack;
/* renamed from: com.facebook.ads.redexgen.X.Ar  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0527Ar {
    public static String[] A06 = {"tMW2fkMpy5HihKk0yN3j3FySApib3JSJ", "DmNw9hS4nxXBj6Mr2INd4L8q1xMEyvKq", "0eqkaL3Dsezuu4pOs0MDPfwpckzWpND4", "49OOFjFtCxl3f3ujLPMCOchIYt8uEQEa", "MWNNllbG7VNHRaURq2pyYfck8pAxQtjw", "ldwZ0eJIezAamtWPjZLM2iroOhc1OYkS", "11ihmkQKk", "Tg3NlfrAQ4uSsG9"};
    public int A00;
    public long A01;
    public long A02;
    public long A03;
    public long A04;
    public final C0525Ap A05;

    public C0527Ar(AudioTrack audioTrack) {
        if (IF.A02 >= 19) {
            this.A05 = new C0525Ap(audioTrack);
            A05();
            return;
        }
        this.A05 = null;
        A00(3);
    }

    private void A00(int i) {
        this.A00 = i;
        switch (i) {
            case 0:
                this.A03 = 0L;
                this.A01 = -1L;
                long nanoTime = System.nanoTime();
                if (A06[6].length() != 9) {
                    throw new RuntimeException();
                }
                A06[6] = "I3kIT2QQI";
                this.A02 = nanoTime / 1000;
                this.A04 = 5000L;
                return;
            case 1:
                this.A04 = 5000L;
                return;
            case 2:
            case 3:
                this.A04 = 10000000L;
                return;
            case 4:
                this.A04 = 500000L;
                return;
            default:
                throw new IllegalStateException();
        }
    }

    public final long A01() {
        C0525Ap c0525Ap = this.A05;
        if (c0525Ap != null) {
            return c0525Ap.A00();
        }
        return -1L;
    }

    public final long A02() {
        C0525Ap c0525Ap = this.A05;
        if (c0525Ap != null) {
            return c0525Ap.A01();
        }
        return -9223372036854775807L;
    }

    public final void A03() {
        if (this.A00 == 4) {
            A05();
        }
    }

    public final void A04() {
        A00(4);
    }

    public final void A05() {
        if (this.A05 != null) {
            A00(0);
        }
    }

    public final boolean A06() {
        int i = this.A00;
        return i == 1 || i == 2;
    }

    public final boolean A07() {
        return this.A00 == 2;
    }

    public final boolean A08(long j2) {
        C0525Ap c0525Ap = this.A05;
        if (c0525Ap == null || j2 - this.A03 < this.A04) {
            return false;
        }
        this.A03 = j2;
        boolean A02 = c0525Ap.A02();
        switch (this.A00) {
            case 0:
                if (A02) {
                    long A01 = this.A05.A01();
                    long timestampPositionFrames = this.A02;
                    if (A01 >= timestampPositionFrames) {
                        this.A01 = this.A05.A00();
                        A00(1);
                        return A02;
                    }
                    return false;
                } else if (j2 - this.A02 <= 500000) {
                    return A02;
                } else {
                    A00(3);
                    return A02;
                }
            case 1:
                if (A02) {
                    long A00 = this.A05.A00();
                    long timestampPositionFrames2 = this.A01;
                    if (A00 > timestampPositionFrames2) {
                        A00(2);
                        return A02;
                    }
                    return A02;
                }
                A05();
                return A02;
            case 2:
                if (!A02) {
                    A05();
                    return A02;
                }
                return A02;
            case 3:
                if (A02) {
                    A05();
                    return A02;
                }
                return A02;
            case 4:
                return A02;
            default:
                throw new IllegalStateException();
        }
    }
}
