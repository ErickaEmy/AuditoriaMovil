package n6;

import android.util.Pair;
import e4.tl;
import java.io.IOException;
import m1.ne;
import v5.j5;
import v5.r;
import v5.rz;
/* loaded from: classes.dex */
public final class gv {

    /* loaded from: classes.dex */
    public static final class y {

        /* renamed from: n3  reason: collision with root package name */
        public final long f11808n3;
        public final int y;

        public y(int i, long j2) {
            this.y = i;
            this.f11808n3 = j2;
        }

        public static y y(tl tlVar, rz rzVar) throws IOException {
            tlVar.z(rzVar.v(), 0, 8);
            rzVar.oz(0);
            return new y(rzVar.p(), rzVar.f3());
        }
    }

    public static y gv(int i, tl tlVar, rz rzVar) throws IOException {
        y y2 = y.y(tlVar, rzVar);
        while (y2.y != i) {
            r.c5("WavHeaderReader", "Ignoring unknown WAV chunk: " + y2.y);
            long j2 = y2.f11808n3 + 8;
            if (j2 <= 2147483647L) {
                tlVar.p((int) j2);
                y2 = y.y(tlVar, rzVar);
            } else {
                throw ne.s("Chunk is too large (~2GB+) to skip; id: " + y2.y);
            }
        }
        return y2;
    }

    public static zn n3(tl tlVar) throws IOException {
        boolean z2;
        byte[] bArr;
        rz rzVar = new rz(16);
        y gv2 = gv(1718449184, tlVar, rzVar);
        if (gv2.f11808n3 >= 16) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.fb(z2);
        tlVar.z(rzVar.v(), 0, 16);
        rzVar.oz(0);
        int c2 = rzVar.c();
        int c4 = rzVar.c();
        int n2 = rzVar.n();
        int n4 = rzVar.n();
        int c6 = rzVar.c();
        int c7 = rzVar.c();
        int i = ((int) gv2.f11808n3) - 16;
        if (i > 0) {
            byte[] bArr2 = new byte[i];
            tlVar.z(bArr2, 0, i);
            bArr = bArr2;
        } else {
            bArr = j5.f14357a;
        }
        tlVar.p((int) (tlVar.t() - tlVar.getPosition()));
        return new zn(c2, c4, n2, n4, c6, c7, bArr);
    }

    public static Pair<Long, Long> v(tl tlVar) throws IOException {
        tlVar.s();
        y gv2 = gv(1684108385, tlVar, new rz(8));
        tlVar.p(8);
        return Pair.create(Long.valueOf(tlVar.getPosition()), Long.valueOf(gv2.f11808n3));
    }

    public static boolean y(tl tlVar) throws IOException {
        rz rzVar = new rz(8);
        int i = y.y(tlVar, rzVar).y;
        if (i != 1380533830 && i != 1380333108) {
            return false;
        }
        tlVar.z(rzVar.v(), 0, 4);
        rzVar.oz(0);
        int p2 = rzVar.p();
        if (p2 != 1463899717) {
            r.zn("WavHeaderReader", "Unsupported form type: " + p2);
            return false;
        }
        return true;
    }

    public static long zn(tl tlVar) throws IOException {
        rz rzVar = new rz(8);
        y y2 = y.y(tlVar, rzVar);
        if (y2.y != 1685272116) {
            tlVar.s();
            return -1L;
        }
        tlVar.wz(8);
        rzVar.oz(0);
        tlVar.z(rzVar.v(), 0, 8);
        long x42 = rzVar.x4();
        tlVar.p(((int) y2.f11808n3) + 8);
        return x42;
    }
}
