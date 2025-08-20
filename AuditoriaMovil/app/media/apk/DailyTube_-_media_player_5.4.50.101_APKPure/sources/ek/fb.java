package ek;

import androidx.annotation.Nullable;
import m1.m;
import v5.j5;
import v5.r;
import v5.rz;
import z0.x4;
/* loaded from: classes.dex */
public final class fb implements y {
    public final m y;

    public fb(m mVar) {
        this.y = mVar;
    }

    @Nullable
    public static y gv(int i, rz rzVar) {
        if (i == 2) {
            return zn(rzVar);
        }
        if (i == 1) {
            return v(rzVar);
        }
        r.c5("StreamFormatChunk", "Ignoring strf box for unsupported track type: " + j5.s8(i));
        return null;
    }

    @Nullable
    public static String n3(int i) {
        if (i != 1) {
            if (i != 85) {
                if (i != 255) {
                    if (i != 8192) {
                        if (i != 8193) {
                            return null;
                        }
                        return "audio/vnd.dts";
                    }
                    return "audio/ac3";
                }
                return "audio/mp4a-latm";
            }
            return "audio/mpeg";
        }
        return "audio/raw";
    }

    @Nullable
    public static y v(rz rzVar) {
        int c2 = rzVar.c();
        String n32 = n3(c2);
        if (n32 == null) {
            r.c5("StreamFormatChunk", "Ignoring track with unsupported format tag " + c2);
            return null;
        }
        int c4 = rzVar.c();
        int r2 = rzVar.r();
        rzVar.ut(6);
        int xg2 = j5.xg(rzVar.yt());
        int c6 = rzVar.c();
        byte[] bArr = new byte[c6];
        rzVar.t(bArr, 0, c6);
        m.n3 n3Var = new m.n3();
        n3Var.o4(n32).a8(c4).rs(r2);
        if ("audio/raw".equals(n32) && xg2 != 0) {
            n3Var.jz(xg2);
        }
        if ("audio/mp4a-latm".equals(n32) && c6 > 0) {
            n3Var.ut(x4.o(bArr));
        }
        return new fb(n3Var.z6());
    }

    @Nullable
    public static String y(int i) {
        switch (i) {
            case 808802372:
            case 877677894:
            case 1145656883:
            case 1145656920:
            case 1482049860:
            case 1684633208:
            case 2021026148:
                return "video/mp4v-es";
            case 826496577:
            case 828601953:
            case 875967048:
                return "video/avc";
            case 842289229:
                return "video/mp42";
            case 859066445:
                return "video/mp43";
            case 1196444237:
            case 1735420525:
                return "video/mjpeg";
            default:
                return null;
        }
    }

    @Nullable
    public static y zn(rz rzVar) {
        rzVar.ut(4);
        int r2 = rzVar.r();
        int r3 = rzVar.r();
        rzVar.ut(4);
        int r5 = rzVar.r();
        String y = y(r5);
        if (y == null) {
            r.c5("StreamFormatChunk", "Ignoring track with unsupported compression " + r5);
            return null;
        }
        m.n3 n3Var = new m.n3();
        n3Var.s8(r2).o(r3).o4(y);
        return new fb(n3Var.z6());
    }

    @Override // ek.y
    public int getType() {
        return 1718776947;
    }
}
