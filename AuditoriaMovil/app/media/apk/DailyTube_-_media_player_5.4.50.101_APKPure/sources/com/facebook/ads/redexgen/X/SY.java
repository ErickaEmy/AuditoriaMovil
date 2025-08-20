package com.facebook.ads.redexgen.X;

import com.uv.v7.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import javax.annotation.Nullable;
import org.json.JSONObject;
/* loaded from: assets/audience_network.dex */
public final class SY {
    public static byte[] A03;
    public static String[] A04 = {"VT4fMDut957REDv81Zf67ZRXVgx5T5a8", "r", "Z8Owoyb", "FnQ4OiwpcdZoDsiJ2m5WJ2Um26YCJsc9", "WRxJAxd2kL6ougEGyIG1Du6QramXeho", "YseYEaNGGUDDQ4eQqZOUPTvdjgKCIPcf", "c4hktFWkJWdy9he8EQ0DeAgF43U5wP0s", "DRA64HFd"};
    public BlockingDeque<SZ> A00;
    public final int A01;
    @Nullable
    public final String A02;

    public static String A02(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 104);
        }
        return new String(copyOfRange);
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 5
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:118)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:567)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:39)
     */
    public static String A05(List<Long> list) {
        StringBuilder sb = new StringBuilder();
        for (Long l2 : list) {
            A09(sb, A00(l2.longValue()));
        }
        return A03(sb.toString());
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 2 out of bounds for length 2
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:118)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:567)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:39)
     */
    public static String A07(Map<String, Object> map) {
        return new JSONObject(map).toString();
    }

    public static void A08() {
        A03 = new byte[]{92, 95, 94, 89, 88, 91, 90, 85, 84, 87, 86, 81, 80, 83, 82, 77, 76, 79, 78, 73, 72, 75, 74, 69, 68, 71, 124, Byte.MAX_VALUE, 126, 121, 120, 123, 122, 117, 116, 119, 118, 113, 112, 115, 114, 109, 108, 111, 110, 105, 104, 107, 106, 101, 100, 103, 45, 44, 47, 46, 41, 40, 43, 42, 37, 36, 54, 50, 48, 51, 33, 55, 22, 55, 62, 38, 51, 45, 123, 42, 13, 57, 40, 37, 35, 57, 9, 54, 58, 40, 62, 61, 51, 58, 106, 111, 19, 27, 21, 15, 47, 19, 9, 18, 24, 51, 18, Byte.MAX_VALUE, 101, 64, Byte.MAX_VALUE, 115, 97, 119, 116, 122, 115, 35, 38, 104, 123, 108, 109, 119, 113, 112, 22, 79, 8, 31, 31, 79, 87, 79, 62, 36, 55, 40, 50, 40, 53, 46, 40, 40, 41, 50, 32, 44, 53, 50, 46, 44, 61, 79, 16};
    }

    static {
        A08();
    }

    public SY(@Nullable String str) {
        this(str, 2000);
    }

    public SY(@Nullable String str, int i) {
        this.A02 = str;
        this.A01 = i;
        this.A00 = new LinkedBlockingDeque();
    }

    public static long A00(long j2) {
        return (j2 << 1) ^ (j2 >> 63);
    }

    public static long A01(List<SZ> list, int i, int i5) {
        HashMap hashMap = new HashMap();
        for (int i6 = i + 1; i6 < i + i5; i6++) {
            long A032 = list.get(i6).A03();
            long A01 = list.get(i6).A01();
            if (hashMap.containsKey(Long.valueOf(A032))) {
                hashMap.put(Long.valueOf(A032), Integer.valueOf(((Integer) hashMap.get(Long.valueOf(A032))).intValue() + 1));
            } else {
                hashMap.put(Long.valueOf(A032), 1);
            }
            if (hashMap.containsKey(Long.valueOf(A01))) {
                hashMap.put(Long.valueOf(A01), Integer.valueOf(((Integer) hashMap.get(Long.valueOf(A01))).intValue() + 1));
            } else {
                Long valueOf = Long.valueOf(A01);
                int i8 = A04[2].length();
                if (i8 == 25) {
                    throw new RuntimeException();
                }
                String[] strArr = A04;
                strArr[6] = "1vNPfVBSY4dOMHCgW1yzfdLMrSn5bdwR";
                strArr[0] = "JWbjY4s0cXOj2VlFs0Pom5JqAlb5V7T0";
                hashMap.put(valueOf, 1);
            }
        }
        long j2 = 3333;
        int baseCountMax = 0;
        for (Map.Entry entry : hashMap.entrySet()) {
            int intValue = ((Integer) entry.getValue()).intValue();
            if (baseCountMax < intValue) {
                baseCountMax = intValue;
                j2 = ((Long) entry.getKey()).longValue();
            }
        }
        for (int baseCountMax2 = i + 1; baseCountMax2 < i + i5; baseCountMax2++) {
            list.get(baseCountMax2).A09(list.get(baseCountMax2).A03() - j2);
            list.get(baseCountMax2).A07(list.get(baseCountMax2).A01() - j2);
            if (A04[7].length() == 7) {
                throw new RuntimeException();
            }
            A04[4] = "Qmxl";
        }
        return j2;
    }

    public static String A03(String str) {
        String A02 = A02(0, 64, 117);
        StringBuilder sb = new StringBuilder(str);
        StringBuilder sb2 = new StringBuilder();
        StringBuilder p2 = new StringBuilder();
        int length = sb.length() % 3;
        if (length > 0) {
            while (length < 3) {
                String[] strArr = A04;
                if (strArr[6].charAt(27) != strArr[0].charAt(27)) {
                    throw new RuntimeException();
                }
                A04[2] = "LfiGB0y4";
                p2.append('=');
                sb.append((char) 0);
                length++;
            }
        }
        for (int n32 = 0; n32 < sb.length(); n32 += 3) {
            int charAt = (sb.charAt(n32) << 16) + (sb.charAt(n32 + 1) << '\b') + sb.charAt(n32 + 2);
            int n4 = (charAt >> 12) & 63;
            int n2 = (charAt >> 6) & 63;
            StringBuilder sb3 = sb2.append(A02.charAt((charAt >> 18) & 63));
            sb3.append(A02.charAt(n4)).append(A02.charAt(n2)).append(A02.charAt(charAt & 63));
        }
        StringBuilder r2 = new StringBuilder();
        String base64chars = sb2.substring(0, sb2.length() - p2.length());
        return r2.append(base64chars).append((Object) p2).toString();
    }

    @Nullable
    public static String A04(@Nullable List<SZ> list) {
        if (list == null) {
            return null;
        }
        return A06(list, 0, list.size(), false);
    }

    @Nullable
    public static String A06(@Nullable List<SZ> list, int i, int i5, boolean z2) {
        if (list == null || list.isEmpty() || i < 0 || i >= list.size() || i5 <= 0 || i + i5 > list.size()) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(A02(73, 2, 35), list.get(i).A05());
        hashMap.put(A02(R.styleable.AppCompatTheme_tooltipFrameBackground, 7, 118), 1);
        boolean z3 = false;
        boolean z4 = false;
        if (i5 > 1) {
            A0A(list, i, i5);
            hashMap.put(A02(64, 9, 58), Long.valueOf(A01(list, i, i5)));
            ArrayList arrayList = new ArrayList();
            List<Long> viewable50FrameTimestampList = new ArrayList<>();
            List<Long> audioFrameTimestampList = new ArrayList<>();
            for (int i6 = i + 1; i6 < i + i5; i6++) {
                arrayList.add(Long.valueOf(list.get(i6).A03()));
                arrayList.add(Long.valueOf(list.get(i6).A01()));
                arrayList.add(Long.valueOf(list.get(i6).A02()));
                viewable50FrameTimestampList.add(Long.valueOf(list.get(i6).A00()));
                if (list.get(i6).A00() != 0) {
                    z3 = true;
                }
                if (z2) {
                    audioFrameTimestampList.add(Long.valueOf(list.get(i6).A04()));
                    if (list.get(i6).A04() != 0) {
                        z4 = true;
                    }
                }
            }
            hashMap.put(A02(92, 2, 29), A05(arrayList));
            hashMap.put(A02(75, 6, 36), A05(viewable50FrameTimestampList));
            hashMap.put(A02(94, 9, 20), Boolean.valueOf(z3));
            if (z2) {
                hashMap.put(A02(81, 11, 55), A05(audioFrameTimestampList));
                hashMap.put(A02(103, 12, 126), Boolean.valueOf(z4));
            }
        }
        String A07 = A07(hashMap);
        if (A04[1].length() != 28) {
            A04[2] = "";
            if (A07.length() > 900000) {
                return A02(122, 29, 5);
            }
            return A07;
        }
        throw new RuntimeException();
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0005 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void A09(java.lang.StringBuilder r5, long r6) {
        /*
            r4 = 128(0x80, float:1.794E-43)
        L2:
            long r1 = (long) r4
            int r0 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r0 < 0) goto L15
            int r0 = r4 + (-1)
            long r2 = (long) r0
            long r2 = r2 & r6
            long r0 = (long) r4
            long r2 = r2 | r0
            int r0 = (int) r2
            char r1 = (char) r0
            r0 = 7
            long r6 = r6 >> r0
            r5.append(r1)
            goto L2
        L15:
            int r0 = (int) r6
            char r3 = (char) r0
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.SY.A04
            r0 = 6
            r1 = r2[r0]
            r0 = 0
            r2 = r2[r0]
            r0 = 27
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto L31
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L31:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.SY.A04
            java.lang.String r1 = "TgLp8xzira9J3G7G7T0jqPUigov5tglm"
            r0 = 6
            r2[r0] = r1
            java.lang.String r1 = "pcTwByMvDCDs4QWUJjAKPoIFXFV5AKB6"
            r0 = 0
            r2[r0] = r1
            r5.append(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.SY.A09(java.lang.StringBuilder, long):void");
    }

    public static void A0A(List<SZ> list, int i, int i5) {
        long A00;
        for (int i6 = (i + i5) - 1; i6 > i; i6--) {
            int i8 = i6 - 1;
            list.get(i6).A09(list.get(i6).A03() - list.get(i8).A03());
            int i10 = i6 - 1;
            list.get(i6).A07(list.get(i6).A01() - list.get(i10).A01());
            int i11 = i6 - 1;
            list.get(i6).A08(list.get(i6).A02() - list.get(i11).A02());
            SZ sz = list.get(i6);
            int i12 = i6 - 1;
            long j2 = 0;
            if (list.get(i12).A00() == -1) {
                A00 = 0;
            } else {
                int i13 = i6 - 1;
                A00 = list.get(i6).A00() - list.get(i13).A00();
            }
            sz.A06(A00);
            SZ sz2 = list.get(i6);
            int i14 = i6 - 1;
            if (list.get(i14).A04() != -1) {
                int i15 = i6 - 1;
                j2 = list.get(i6).A04() - list.get(i15).A04();
            }
            sz2.A0A(j2);
            list.get(i6).A08(list.get(i6).A02() - list.get(i6).A01());
        }
    }

    public final List<SZ> A0B() {
        ArrayList arrayList = new ArrayList();
        this.A00.drainTo(arrayList);
        return arrayList;
    }

    public final void A0C(SZ sz) {
        SZ peekLast = this.A00.peekLast();
        if (peekLast != null) {
            long A032 = peekLast.A03();
            if (A04[7].length() == 7) {
                throw new RuntimeException();
            }
            A04[1] = "fQhMIvl";
            if (A032 == sz.A03() && peekLast.A01() == sz.A01()) {
                return;
            }
        }
        this.A00.add(sz);
    }
}
