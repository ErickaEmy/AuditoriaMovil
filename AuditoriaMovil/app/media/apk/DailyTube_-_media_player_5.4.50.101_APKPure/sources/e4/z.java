package e4;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.flac.PictureFrame;
import e4.x4;
import ho.n3;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import m1.ne;
/* loaded from: classes.dex */
public final class z {

    /* loaded from: classes.dex */
    public static final class y {
        @Nullable
        public x4 y;

        public y(@Nullable x4 x4Var) {
            this.y = x4Var;
        }
    }

    public static x4.y a(tl tlVar, int i) throws IOException {
        v5.rz rzVar = new v5.rz(i);
        tlVar.readFully(rzVar.v(), 0, i);
        return fb(rzVar);
    }

    public static void c5(tl tlVar) throws IOException {
        v5.rz rzVar = new v5.rz(4);
        tlVar.readFully(rzVar.v(), 0, 4);
        if (rzVar.a8() == 1716281667) {
            return;
        }
        throw ne.y("Failed to read FLAC stream marker.", null);
    }

    public static x4.y fb(v5.rz rzVar) {
        rzVar.ut(1);
        int x2 = rzVar.x();
        long a2 = rzVar.a() + x2;
        int i = x2 / 18;
        long[] jArr = new long[i];
        long[] jArr2 = new long[i];
        int i5 = 0;
        while (true) {
            if (i5 >= i) {
                break;
            }
            long d02 = rzVar.d0();
            if (d02 == -1) {
                jArr = Arrays.copyOf(jArr, i5);
                jArr2 = Arrays.copyOf(jArr2, i5);
                break;
            }
            jArr[i5] = d02;
            jArr2[i5] = rzVar.d0();
            rzVar.ut(2);
            i5++;
        }
        rzVar.ut((int) (a2 - rzVar.a()));
        return new x4.y(jArr, jArr2);
    }

    @Nullable
    public static Metadata gv(tl tlVar, boolean z2) throws IOException {
        tlVar.s();
        long t2 = tlVar.t();
        Metadata zn2 = zn(tlVar, z2);
        tlVar.p((int) (tlVar.t() - t2));
        return zn2;
    }

    public static List<String> i9(tl tlVar, int i) throws IOException {
        v5.rz rzVar = new v5.rz(i);
        tlVar.readFully(rzVar.v(), 0, i);
        rzVar.ut(4);
        return Arrays.asList(ej.i9(rzVar, false, false).f7492n3);
    }

    public static int n3(tl tlVar) throws IOException {
        tlVar.s();
        v5.rz rzVar = new v5.rz(2);
        tlVar.z(rzVar.v(), 0, 2);
        int yt2 = rzVar.yt();
        if ((yt2 >> 2) == 16382) {
            tlVar.s();
            return yt2;
        }
        tlVar.s();
        throw ne.y("First frame does not start with sync code.", null);
    }

    public static x4 s(tl tlVar) throws IOException {
        byte[] bArr = new byte[38];
        tlVar.readFully(bArr, 0, 38);
        return new x4(bArr, 4);
    }

    public static boolean v(tl tlVar, y yVar) throws IOException {
        tlVar.s();
        v5.fh fhVar = new v5.fh(new byte[4]);
        tlVar.z(fhVar.y, 0, 4);
        boolean fb2 = fhVar.fb();
        int s2 = fhVar.s(7);
        int s3 = fhVar.s(24) + 4;
        if (s2 == 0) {
            yVar.y = s(tlVar);
        } else {
            x4 x4Var = yVar.y;
            if (x4Var != null) {
                if (s2 == 3) {
                    yVar.y = x4Var.n3(a(tlVar, s3));
                } else if (s2 == 4) {
                    yVar.y = x4Var.zn(i9(tlVar, s3));
                } else if (s2 == 6) {
                    v5.rz rzVar = new v5.rz(s3);
                    tlVar.readFully(rzVar.v(), 0, s3);
                    rzVar.ut(4);
                    yVar.y = x4Var.y(z0.x4.o(PictureFrame.y(rzVar)));
                } else {
                    tlVar.p(s3);
                }
            } else {
                throw new IllegalArgumentException();
            }
        }
        return fb2;
    }

    public static boolean y(tl tlVar) throws IOException {
        v5.rz rzVar = new v5.rz(4);
        tlVar.z(rzVar.v(), 0, 4);
        if (rzVar.a8() != 1716281667) {
            return false;
        }
        return true;
    }

    @Nullable
    public static Metadata zn(tl tlVar, boolean z2) throws IOException {
        n3.y yVar;
        if (z2) {
            yVar = null;
        } else {
            yVar = ho.n3.f8924n3;
        }
        Metadata y2 = new n().y(tlVar, yVar);
        if (y2 == null || y2.v() == 0) {
            return null;
        }
        return y2;
    }
}
