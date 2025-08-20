package ft;

import java.util.ArrayList;
import java.util.Collections;
import qh.n3;
import v5.j5;
import v5.rz;
/* loaded from: classes.dex */
public final class y extends qh.s {

    /* renamed from: xc  reason: collision with root package name */
    public final rz f8265xc;

    public y() {
        super("Mp4WebvttDecoder");
        this.f8265xc = new rz();
    }

    public static qh.n3 fh(rz rzVar, int i) throws qh.f {
        CharSequence charSequence = null;
        n3.C0187n3 c0187n3 = null;
        while (i > 0) {
            if (i >= 8) {
                int p2 = rzVar.p();
                int p3 = rzVar.p();
                int i5 = p2 - 8;
                String ta2 = j5.ta(rzVar.v(), rzVar.a(), i5);
                rzVar.ut(i5);
                i = (i - 8) - i5;
                if (p3 == 1937011815) {
                    c0187n3 = a.xc(ta2);
                } else if (p3 == 1885436268) {
                    charSequence = a.p(null, ta2.trim(), Collections.emptyList());
                }
            } else {
                throw new qh.f("Incomplete vtt cue box header found.");
            }
        }
        if (charSequence == null) {
            charSequence = "";
        }
        if (c0187n3 != null) {
            return c0187n3.xc(charSequence).y();
        }
        return a.t(charSequence);
    }

    @Override // qh.s
    public qh.c5 c(byte[] bArr, int i, boolean z2) throws qh.f {
        this.f8265xc.o(bArr, i);
        ArrayList arrayList = new ArrayList();
        while (this.f8265xc.y() > 0) {
            if (this.f8265xc.y() >= 8) {
                int p2 = this.f8265xc.p();
                if (this.f8265xc.p() == 1987343459) {
                    arrayList.add(fh(this.f8265xc, p2 - 8));
                } else {
                    this.f8265xc.ut(p2 - 8);
                }
            } else {
                throw new qh.f("Incomplete Mp4Webvtt Top Level box header found.");
            }
        }
        return new n3(arrayList);
    }
}
