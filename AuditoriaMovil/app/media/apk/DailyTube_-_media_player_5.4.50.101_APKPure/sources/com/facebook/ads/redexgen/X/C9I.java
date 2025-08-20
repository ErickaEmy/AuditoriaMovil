package com.facebook.ads.redexgen.X;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* renamed from: com.facebook.ads.redexgen.X.9I  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C9I extends QS {
    public int A00;
    public boolean A01;
    public final AbstractC04788s<C9H> A02;
    public final AbstractC04788s<AnonymousClass98> A03;
    public final AbstractC04788s<O8> A04;
    public final AbstractC04788s<AnonymousClass93> A05;
    public final AbstractC04788s<C0812Mr> A06;
    public final AbstractC04788s<C0800Mf> A07;
    public final AbstractC04788s<C0795Ma> A08;
    public final AbstractC04788s<MU> A09;
    public final AbstractC04788s<C0789Lu> A0A;
    public final SA A0B;
    public final NX A0C;
    public final MV A0D;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public C9I(C1116Yn c1116Yn, J2 j2, SA sa, List<C2P> list, String str) {
        super(c1116Yn, j2, sa, list, str, !sa.A0h(), new QR(c1116Yn, sa));
        MV mv2 = new MV() { // from class: com.facebook.ads.redexgen.X.9J
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.AbstractC04788s
            /* renamed from: A00 */
            public final void A03(MW mw) {
                C9I.this.A0a();
            }
        };
        this.A0D = mv2;
        S7 s7 = new S7(this);
        this.A07 = s7;
        S3 s3 = new S3(this);
        this.A03 = s3;
        RH rh = new RH(this);
        this.A04 = rh;
        RA ra2 = new RA(this);
        this.A05 = ra2;
        C0902Qd c0902Qd = new C0902Qd(this);
        this.A02 = c0902Qd;
        C0901Qc c0901Qc = new C0901Qc(this);
        this.A06 = c0901Qc;
        C0899Qa c0899Qa = new C0899Qa(this);
        this.A09 = c0899Qa;
        QV qv = new QV(this);
        this.A0A = qv;
        S9 s9 = new S9(this);
        this.A08 = s9;
        NX nx = new NX() { // from class: com.facebook.ads.redexgen.X.9K
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.AbstractC04788s
            /* renamed from: A00 */
            public final void A03(C0834Nn c0834Nn) {
                SA sa2;
                C9I c9i = C9I.this;
                sa2 = c9i.A0B;
                c9i.A00 = sa2.getDuration();
            }
        };
        this.A0C = nx;
        this.A01 = false;
        this.A0B = sa;
        sa.getEventBus().A03(mv2, ra2, s7, rh, s3, c0902Qd, c0901Qc, c0899Qa, qv, nx, s9);
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public C9I(C1116Yn c1116Yn, J2 j2, SA sa, List<C2P> list, String str, Bundle bundle, Map<String, String> map) {
        super(c1116Yn, j2, sa, list, str, !sa.A0h(), bundle, map, new QR(c1116Yn, sa));
        MV mv2 = new MV() { // from class: com.facebook.ads.redexgen.X.9J
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.AbstractC04788s
            /* renamed from: A00 */
            public final void A03(MW mw) {
                C9I.this.A0a();
            }
        };
        this.A0D = mv2;
        S7 s7 = new S7(this);
        this.A07 = s7;
        S3 s3 = new S3(this);
        this.A03 = s3;
        RH rh = new RH(this);
        this.A04 = rh;
        RA ra2 = new RA(this);
        this.A05 = ra2;
        C0902Qd c0902Qd = new C0902Qd(this);
        this.A02 = c0902Qd;
        C0901Qc c0901Qc = new C0901Qc(this);
        this.A06 = c0901Qc;
        C0899Qa c0899Qa = new C0899Qa(this);
        this.A09 = c0899Qa;
        QV qv = new QV(this);
        this.A0A = qv;
        S9 s9 = new S9(this);
        this.A08 = s9;
        this.A0C = new NX() { // from class: com.facebook.ads.redexgen.X.9K
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.AbstractC04788s
            /* renamed from: A00 */
            public final void A03(C0834Nn c0834Nn) {
                SA sa2;
                C9I c9i = C9I.this;
                sa2 = c9i.A0B;
                c9i.A00 = sa2.getDuration();
            }
        };
        this.A01 = false;
        this.A0B = sa;
        sa.getEventBus().A03(mv2, ra2, s7, rh, s3, c0902Qd, c0901Qc, c0899Qa, qv, s9);
    }

    public C9I(C1116Yn c1116Yn, J2 j2, SA sa, String str) {
        this(c1116Yn, j2, sa, new ArrayList(), str);
    }

    public C9I(C1116Yn c1116Yn, J2 j2, SA sa, String str, Bundle bundle) {
        this(c1116Yn, j2, sa, new ArrayList(), str, bundle, null);
    }

    public C9I(C1116Yn c1116Yn, J2 j2, SA sa, String str, Map<String, String> extraParams) {
        this(c1116Yn, j2, sa, new ArrayList(), str, null, extraParams);
    }

    public final void A0i() {
        S8 s82 = new S8(this);
        if (this.A0B.A0l()) {
            ExecutorC0777Li.A00(s82);
        } else {
            this.A0B.getStateHandler().post(s82);
        }
    }
}
