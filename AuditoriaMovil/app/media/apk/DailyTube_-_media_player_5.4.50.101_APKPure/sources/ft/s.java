package ft;

import android.text.TextUtils;
import java.util.ArrayList;
import m1.ne;
import v5.rz;
/* loaded from: classes.dex */
public final class s extends qh.s {

    /* renamed from: w  reason: collision with root package name */
    public final zn f8261w;

    /* renamed from: xc  reason: collision with root package name */
    public final rz f8262xc;

    public s() {
        super("WebvttDecoder");
        this.f8262xc = new rz();
        this.f8261w = new zn();
    }

    public static int fh(rz rzVar) {
        int i = -1;
        int i5 = 0;
        while (i == -1) {
            i5 = rzVar.a();
            String co2 = rzVar.co();
            if (co2 == null) {
                i = 0;
            } else if ("STYLE".equals(co2)) {
                i = 2;
            } else if (co2.startsWith("NOTE")) {
                i = 1;
            } else {
                i = 3;
            }
        }
        rzVar.oz(i5);
        return i;
    }

    public static void rz(rz rzVar) {
        do {
        } while (!TextUtils.isEmpty(rzVar.co()));
    }

    @Override // qh.s
    public qh.c5 c(byte[] bArr, int i, boolean z2) throws qh.f {
        v wz2;
        this.f8262xc.o(bArr, i);
        ArrayList arrayList = new ArrayList();
        try {
            c5.v(this.f8262xc);
            do {
            } while (!TextUtils.isEmpty(this.f8262xc.co()));
            ArrayList arrayList2 = new ArrayList();
            while (true) {
                int fh2 = fh(this.f8262xc);
                if (fh2 != 0) {
                    if (fh2 == 1) {
                        rz(this.f8262xc);
                    } else if (fh2 == 2) {
                        if (arrayList2.isEmpty()) {
                            this.f8262xc.co();
                            arrayList.addAll(this.f8261w.gv(this.f8262xc));
                        } else {
                            throw new qh.f("A style block was found after the first cue.");
                        }
                    } else if (fh2 == 3 && (wz2 = a.wz(this.f8262xc, arrayList)) != null) {
                        arrayList2.add(wz2);
                    }
                } else {
                    return new f(arrayList2);
                }
            }
        } catch (ne e2) {
            throw new qh.f(e2);
        }
    }
}
