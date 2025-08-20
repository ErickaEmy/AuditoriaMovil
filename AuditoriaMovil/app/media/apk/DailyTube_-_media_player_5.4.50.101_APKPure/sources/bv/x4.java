package bv;

import android.graphics.Color;
import android.graphics.Rect;
import android.view.animation.Interpolator;
import fc.zn;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import nd.v;
import q.f;
import q.n3;
import q.t;
import wm.y;
import yk.s;
/* loaded from: classes.dex */
public class x4 {
    public static final zn.y y = zn.y.y(new String[]{"nm", "ind", "refId", "ty", "parent", "sw", "sh", "sc", "ks", "tt", "masksProperties", "shapes", "t", "ef", "sr", "st", "w", "h", "ip", "op", "tm", "cl", "hd"});

    /* renamed from: n3  reason: collision with root package name */
    public static final zn.y f3889n3 = zn.y.y(new String[]{"d", "a"});

    /* renamed from: zn  reason: collision with root package name */
    public static final zn.y f3890zn = zn.y.y(new String[]{"ty", "nm"});

    public static v n3(s sVar) {
        Rect n32 = sVar.n3();
        return new v(Collections.emptyList(), sVar, "__container", -1L, v.y.PRE_COMP, -1L, null, Collections.emptyList(), new t(), 0, 0, 0, 0.0f, 0.0f, n32.width(), n32.height(), null, null, Collections.emptyList(), v.n3.NONE, null, false, null, null);
    }

    public static v y(zn znVar, s sVar) throws IOException {
        ArrayList arrayList;
        ArrayList arrayList2;
        v.n3 n3Var = v.n3.NONE;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        znVar.s();
        Float valueOf = Float.valueOf(0.0f);
        Float valueOf2 = Float.valueOf(1.0f);
        v.n3 n3Var2 = n3Var;
        v.y yVar = null;
        String str = null;
        t tVar = null;
        q.i9 i9Var = null;
        f fVar = null;
        n3 n3Var3 = null;
        y yVar2 = null;
        i9 i9Var2 = null;
        long j2 = 0;
        long j4 = -1;
        float f4 = 0.0f;
        int i = 0;
        int i5 = 0;
        int i6 = 0;
        float f6 = 1.0f;
        float f9 = 0.0f;
        float f10 = 0.0f;
        float f11 = 0.0f;
        boolean z2 = false;
        float f12 = 0.0f;
        String str2 = "UNSET";
        String str3 = null;
        while (znVar.co()) {
            switch (znVar.j5(y)) {
                case 0:
                    str2 = znVar.ud();
                    break;
                case 1:
                    j2 = znVar.ta();
                    break;
                case 2:
                    str = znVar.ud();
                    break;
                case 3:
                    int ta2 = znVar.ta();
                    yVar = v.y.UNKNOWN;
                    if (ta2 >= yVar.ordinal()) {
                        break;
                    } else {
                        yVar = v.y.values()[ta2];
                        break;
                    }
                case 4:
                    j4 = znVar.ta();
                    break;
                case 5:
                    i = (int) (znVar.ta() * br.s.v());
                    break;
                case 6:
                    i5 = (int) (znVar.ta() * br.s.v());
                    break;
                case 7:
                    i6 = Color.parseColor(znVar.ud());
                    break;
                case 8:
                    tVar = zn.fb(znVar, sVar);
                    break;
                case 9:
                    int ta3 = znVar.ta();
                    if (ta3 >= v.n3.values().length) {
                        sVar.y("Unsupported matte type: " + ta3);
                        break;
                    } else {
                        n3Var2 = v.n3.values()[ta3];
                        int i8 = y.y[n3Var2.ordinal()];
                        if (i8 != 1) {
                            if (i8 == 2) {
                                sVar.y("Unsupported matte type: Luma Inverted");
                            }
                        } else {
                            sVar.y("Unsupported matte type: Luma");
                        }
                        sVar.mt(1);
                        break;
                    }
                case 10:
                    znVar.v();
                    while (znVar.co()) {
                        arrayList3.add(f3.y(znVar, sVar));
                    }
                    sVar.mt(arrayList3.size());
                    znVar.p();
                    break;
                case 11:
                    znVar.v();
                    while (znVar.co()) {
                        wm.zn y2 = s.y(znVar, sVar);
                        if (y2 != null) {
                            arrayList4.add(y2);
                        }
                    }
                    znVar.p();
                    break;
                case 12:
                    znVar.s();
                    while (znVar.co()) {
                        int j52 = znVar.j5(f3889n3);
                        if (j52 != 0) {
                            if (j52 != 1) {
                                znVar.j();
                                znVar.jz();
                            } else {
                                znVar.v();
                                if (znVar.co()) {
                                    fVar = n3.y(znVar, sVar);
                                }
                                while (znVar.co()) {
                                    znVar.jz();
                                }
                                znVar.p();
                            }
                        } else {
                            i9Var = gv.gv(znVar, sVar);
                        }
                    }
                    znVar.mt();
                    break;
                case 13:
                    znVar.v();
                    ArrayList arrayList5 = new ArrayList();
                    while (znVar.co()) {
                        znVar.s();
                        while (znVar.co()) {
                            int j53 = znVar.j5(f3890zn);
                            if (j53 != 0) {
                                if (j53 != 1) {
                                    znVar.j();
                                    znVar.jz();
                                } else {
                                    arrayList5.add(znVar.ud());
                                }
                            } else {
                                int ta4 = znVar.ta();
                                if (ta4 == 29) {
                                    yVar2 = v.n3(znVar, sVar);
                                } else if (ta4 == 25) {
                                    i9Var2 = new f().n3(znVar, sVar);
                                }
                            }
                        }
                        znVar.mt();
                    }
                    znVar.p();
                    sVar.y("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: " + arrayList5);
                    break;
                case 14:
                    f6 = (float) znVar.x4();
                    break;
                case 15:
                    f9 = (float) znVar.x4();
                    break;
                case 16:
                    f10 = (float) (znVar.x4() * br.s.v());
                    break;
                case 17:
                    f11 = (float) (znVar.x4() * br.s.v());
                    break;
                case 18:
                    f4 = (float) znVar.x4();
                    break;
                case 19:
                    f12 = (float) znVar.x4();
                    break;
                case 20:
                    n3Var3 = gv.a(znVar, sVar, false);
                    break;
                case 21:
                    str3 = znVar.ud();
                    break;
                case 22:
                    z2 = znVar.r();
                    break;
                default:
                    znVar.j();
                    znVar.jz();
                    break;
            }
        }
        znVar.mt();
        ArrayList arrayList6 = new ArrayList();
        if (f4 > 0.0f) {
            arrayList = arrayList3;
            arrayList2 = arrayList6;
            arrayList2.add(new uo.y(sVar, valueOf, valueOf, (Interpolator) null, 0.0f, Float.valueOf(f4)));
        } else {
            arrayList = arrayList3;
            arrayList2 = arrayList6;
        }
        if (f12 <= 0.0f) {
            f12 = sVar.a();
        }
        arrayList2.add(new uo.y(sVar, valueOf2, valueOf2, (Interpolator) null, f4, Float.valueOf(f12)));
        arrayList2.add(new uo.y(sVar, valueOf, valueOf, (Interpolator) null, f12, Float.valueOf(Float.MAX_VALUE)));
        if (str2.endsWith(".ai") || "ai".equals(str3)) {
            sVar.y("Convert your Illustrator layers to shape layers.");
        }
        return new v(arrayList4, sVar, str2, j2, yVar, j4, str, arrayList, tVar, i, i5, i6, f6, f9, f10, f11, i9Var, fVar, arrayList2, n3Var2, n3Var3, z2, yVar2, i9Var2);
    }
}
