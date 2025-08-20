package com.facebook.ads.redexgen.X;

import android.graphics.Rect;
import android.view.View;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* renamed from: com.facebook.ads.redexgen.X.cU  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1295cU {
    public InterfaceC1296cV A00;
    public C1282cH A01;
    public final InterfaceC1304ce A03;
    public final InterfaceC1297cW A04;
    public final LinkedHashMap<Integer, Runnable> A05 = new LinkedHashMap<>();
    public final InterfaceC1296cV A02 = new HD(this);

    public C1295cU(InterfaceC1304ce interfaceC1304ce, InterfaceC1297cW interfaceC1297cW) {
        this.A03 = interfaceC1304ce;
        this.A04 = interfaceC1297cW;
    }

    public static C1295cU A01() {
        return new C1295cU(new HH(), null);
    }

    private void A03(AbstractC1298cY abstractC1298cY, InterfaceC1302cc interfaceC1302cc, HB hb) {
        C1282cH A00 = C1282cH.A00(abstractC1298cY, interfaceC1302cc, hb);
        this.A01 = A00;
        if (0 != 0) {
            A00.A01(null);
        }
        this.A01.A02(this.A02);
    }

    private final void A04(InterfaceC1281cG interfaceC1281cG) {
        C1282cH localViewpointWatcher = this.A01;
        if (localViewpointWatcher != null && interfaceC1281cG != null) {
            localViewpointWatcher.A03(interfaceC1281cG);
        }
    }

    private final void A05(InterfaceC1281cG interfaceC1281cG, C1300ca c1300ca) {
        C1282cH localViewpointWatcher = this.A01;
        if (localViewpointWatcher != null && interfaceC1281cG != null && c1300ca != null) {
            localViewpointWatcher.A04(interfaceC1281cG, c1300ca);
        }
    }

    public final void A06(View view) {
        A04(view != null ? H3.A00(view) : null);
    }

    public final void A07(View view, C1300ca c1300ca) {
        A05(view != null ? H3.A00(view) : null, c1300ca);
    }

    public final void A08(AbstractC1298cY abstractC1298cY, View view) {
        if (abstractC1298cY != null && view != null) {
            A03(abstractC1298cY, new HE(view, this.A03), new HB(null) { // from class: com.facebook.ads.redexgen.X.6w
                public static byte[] A09;
                public static String[] A0A = {"okBgSYhQGmV0QyU32992deBLR6XrdaZQ", "E", "ZDdZ5rthnspWTI3gzSJHBR7aYCyAxUsq", "EsXM2pc2I6J3hYC1V9OQRTCtALa8wmqB", "DKA0ex9266tXplnV6PUb8C0vdYHWYjG4", "tBgdKBpc94v7LWesC8aTGIaQqZdJYwjy", "iZindrm9v6DBRttH7DMzAa7", "d9237vu9oQoOcpvZwewcjFUDz74P7MIA"};
                public static final String A0B;
                public long A00;
                public cX A01;
                public final InterfaceC1297cW A02;
                public final Map<String, C1287cM> A06 = new HashMap();
                public final C1288cN A04 = new C1288cN();
                public final C1288cN A03 = new C1288cN();
                public final List<Rect> A05 = new ArrayList(1);
                public final boolean A08 = false;
                public final boolean A07 = false;

                public static String A02(int i, int i5, int i6) {
                    byte[] copyOfRange = Arrays.copyOfRange(A09, i, i + i5);
                    for (int i8 = 0; i8 < copyOfRange.length; i8++) {
                        copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 91);
                    }
                    return new String(copyOfRange);
                }

                public static void A03() {
                    A09 = new byte[]{41, 21, 20, 14, 93, 11, 20, 24, 10, 13, 18, 20, 19, 9, 93, 21, 28, 14, 93, 19, 18, 9, 93, 31, 24, 24, 19, 93, 16, 24, 28, 14, 8, 15, 24, 25, 93, 18, 15, 93, 20, 14, 93, 28, 93, 26, 15, 18, 8, 13, 93, 10, 21, 20, 30, 21, 93, 10, 20, 17, 17, 93, 19, 24, 11, 24, 15, 93, 15, 24, 9, 8, 15, 19, 93, 28, 93, 16, 24, 28, 14, 8, 15, 24, 16, 24, 19, 9, 93, 14, 20, 19, 30, 24, 93, 20, 9, 90, 14, 93, 16, 28, 25, 24, 93, 8, 13, 93, 18, 27, 93, 14, 8, 31, 11, 20, 24, 10, 14, 93, 9, 21, 28, 9, 93, 30, 18, 8, 17, 25, 93, 31, 24, 93, 18, 27, 27, 14, 30, 15, 24, 24, 19, 118, 125, 111, 75, 123, 121, 118, 63, 36, 61, 61, 113, 39, 56, 52, 38, 113, 33, 35, 62, 33, 52, 35, 37, 40, 113, 55, 62, 35, 113, 35, 52, 60, 62, 39, 52, 53, 113, 56, 37, 52, 60, 113, 125, 97, 104, 122, 92, 107, 126, 97, 124, 122};
                }

                static {
                    A03();
                    A0B = C04366w.class.getSimpleName();
                }

                {
                    this.A02 = r3;
                }

                public static Rect A00(C1287cM c1287cM) {
                    Rect rect;
                    Rect rect2;
                    Rect rect3;
                    Rect rect4;
                    Rect rect5;
                    if (c1287cM != null) {
                        rect = c1287cM.A02;
                        if (rect.top != Integer.MIN_VALUE) {
                            rect2 = c1287cM.A02;
                            if (rect2.left != Integer.MIN_VALUE) {
                                rect3 = c1287cM.A02;
                                String[] strArr = A0A;
                                if (strArr[1].length() == strArr[6].length()) {
                                    throw new RuntimeException();
                                }
                                String[] strArr2 = A0A;
                                strArr2[1] = "p";
                                strArr2[6] = "Kr6mbDoiLKwWSgNyXDF2oJW";
                                if (rect3.right != Integer.MIN_VALUE) {
                                    rect4 = c1287cM.A02;
                                    if (rect4.bottom != Integer.MIN_VALUE) {
                                        rect5 = c1287cM.A02;
                                        return rect5;
                                    }
                                }
                            }
                        }
                    }
                    throw new IllegalStateException(A02(0, 143, 38));
                }

                private C1287cM A01(C1300ca c1300ca, Rect rect, Rect rect2) {
                    boolean A06;
                    Rect rect3;
                    List list;
                    C1287cM c1287cM = this.A06.get(c1300ca.A04);
                    A06 = this.A04.A06(c1300ca);
                    if (A06) {
                        if (c1287cM != null) {
                            c1287cM.A01 = EnumC1291cQ.A04;
                        } else {
                            c1287cM = C1287cM.A03(this.A00);
                            this.A06.put(c1300ca.A04, c1287cM);
                        }
                    }
                    rect3 = c1287cM.A02;
                    rect3.set(rect2);
                    list = c1287cM.A03;
                    list.add(new Rect(rect));
                    return c1287cM;
                }

                private void A04(C1288cN c1288cN) {
                    Collection<C1300ca> A01;
                    List list;
                    A01 = c1288cN.A01();
                    for (C1300ca c1300ca : A01) {
                        C1287cM c1287cM = this.A06.get(c1300ca.A04);
                        if (c1287cM == null) {
                            if (0 != 0) {
                                String str = A02(150, 36, 10) + c1300ca.A04;
                                throw new NullPointerException(A02(186, 10, 85));
                            }
                        } else {
                            c1287cM.A01 = EnumC1291cQ.A03;
                            list = c1287cM.A03;
                            list.clear();
                            c1300ca.A03(this);
                            if (this.A08) {
                                Map<String, C1287cM> map = this.A06;
                                String[] strArr = A0A;
                                if (strArr[0].charAt(8) == strArr[2].charAt(8)) {
                                    throw new RuntimeException();
                                }
                                String[] strArr2 = A0A;
                                strArr2[0] = "dCpYPRypiVOHB4OlkAqBqk8EySqTLE1k";
                                strArr2[2] = "r3sjB169HJX8vOmMpko73ANLsggTEmi2";
                                map.remove(c1287cM);
                            } else {
                                continue;
                            }
                        }
                    }
                }

                private void A05(C1288cN c1288cN) {
                    Collection<C1300ca> A00;
                    A00 = c1288cN.A00();
                    for (C1300ca c1300ca : A00) {
                        c1300ca.A03(this);
                    }
                }

                @Override // com.facebook.ads.redexgen.X.HB
                public final void A3V(C1300ca c1300ca, Rect rect, Rect rect2) {
                    boolean A06;
                    List list;
                    Rect rect3;
                    List list2;
                    A01(c1300ca, rect, rect2);
                    C1300ca c1300ca2 = c1300ca.A01;
                    C1300ca parentViewpointData = C1300ca.A08;
                    if (c1300ca2 == parentViewpointData) {
                        return;
                    }
                    A06 = this.A03.A06(c1300ca2);
                    C1287cM parentViewProperties = this.A06.get(c1300ca2.A04);
                    if (A06) {
                        if (parentViewProperties == null) {
                            parentViewProperties = C1287cM.A03(this.A00);
                            rect3 = parentViewProperties.A02;
                            rect3.set(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
                            this.A06.put(c1300ca2.A04, parentViewProperties);
                        } else {
                            list2 = parentViewProperties.A03;
                            list2.clear();
                            if (!this.A07 || c1300ca2.A04()) {
                                parentViewProperties.A01 = EnumC1291cQ.A04;
                            }
                        }
                    }
                    list = parentViewProperties.A03;
                    list.add(new Rect(rect));
                }

                @Override // com.facebook.ads.redexgen.X.HB
                public final void A41(long j2, List<Rect> viewportRects) {
                    Collection<C1300ca> A01;
                    Collection<C1300ca> A012;
                    List list;
                    this.A00 = j2;
                    this.A05.clear();
                    for (Rect rect : viewportRects) {
                        this.A05.add(new Rect(rect));
                    }
                    A01 = this.A04.A01();
                    for (C1300ca c1300ca : A01) {
                        this.A06.remove(c1300ca.A04);
                    }
                    A012 = this.A03.A01();
                    for (C1300ca c1300ca2 : A012) {
                        this.A06.remove(c1300ca2.A04);
                    }
                    for (C1287cM c1287cM : this.A06.values()) {
                        list = c1287cM.A03;
                        list.clear();
                    }
                    this.A04.A04();
                    this.A03.A04();
                }

                @Override // com.facebook.ads.redexgen.X.HB
                public final void A5Z() {
                    Collection A00;
                    Collection A002;
                    A05(this.A04);
                    A04(this.A04);
                    A05(this.A03);
                    A04(this.A03);
                    if (0 != 0) {
                        String obj = toString();
                        List<Rect> list = this.A05;
                        A00 = this.A04.A00();
                        A002 = this.A03.A00();
                        new C1286cL(obj, this, list, A00, A002);
                        throw new NullPointerException(A02(143, 7, 67));
                    }
                }

                @Override // com.facebook.ads.redexgen.X.InterfaceC1290cP
                public final void A78(C1300ca c1300ca, Rect rect) {
                    List<Rect> list;
                    rect.setEmpty();
                    list = this.A06.get(c1300ca.A04).A03;
                    for (Rect rect2 : list) {
                        rect.union(rect2);
                    }
                }

                @Override // com.facebook.ads.redexgen.X.InterfaceC1290cP
                public final EnumC1291cQ A8J(C1300ca c1300ca) {
                    EnumC1291cQ enumC1291cQ;
                    enumC1291cQ = this.A06.get(c1300ca.A04).A01;
                    return enumC1291cQ;
                }

                @Override // com.facebook.ads.redexgen.X.InterfaceC1290cP
                public final void A8L(Rect rect) {
                    rect.setEmpty();
                    for (Rect rect2 : this.A05) {
                        rect.union(rect2);
                    }
                }

                @Override // com.facebook.ads.redexgen.X.InterfaceC1290cP
                public final float A8M(C1300ca c1300ca) {
                    List<Rect> list;
                    C1287cM c1287cM = this.A06.get(c1300ca.A04);
                    if (c1287cM != null) {
                        Rect A00 = A00(c1287cM);
                        int height = A00.height() * A00.width();
                        int totalVisibleArea = 0;
                        list = c1287cM.A03;
                        for (Rect rect : list) {
                            totalVisibleArea += rect.height() * rect.width();
                        }
                        return totalVisibleArea / height;
                    }
                    return 0.0f;
                }

                @Override // com.facebook.ads.redexgen.X.HB
                public final void AGH(cX cXVar) {
                    this.A01 = cXVar;
                }
            });
        }
    }
}
