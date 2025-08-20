package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import java.util.List;
/* renamed from: com.facebook.ads.redexgen.X.4X  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C4X {
    public static byte[] A01;
    public static String[] A02 = {"1CU3iw4Trc3qggngkxP7P26jEGLrLZaR", "qcH7HKgKdAybLTWn0rmK7JyCE0S9C8rn", "oNJ0dA1Zpt4CixMfeWT18n5RxX88Y0E3", "FZ8N3xW3PfzdZjJWrErZ2QIuE13XuJtD", "DvPOKoiXqOiYMgjx6IqCziqOSBLzEcJY", "MpMZeZ7xc490HXAXJonG5r1KTyiIoUHH", "NGMd8PbmdSzgSLgNcWdVjgLa", "jY1Ixh6DMe9BpV8yAbg842YJP45AQ2Eb"};
    public final C4W A00;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 6 out of bounds for length 6
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:118)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:567)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:39)
     */
    private int A00(List<AnonymousClass49> list) {
        int size = list.size() - 1;
        if (size >= 0) {
            list.get(size);
            throw new NullPointerException(A01(0, 3, 108));
        } else if (A02[6].length() != 11) {
            A02[4] = "ocUvr42PokE9Vws5XIbVQy60mJnyU043";
            return -1;
        } else {
            throw new RuntimeException();
        }
    }

    public static String A01(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i5);
        int i8 = 0;
        while (true) {
            int length = copyOfRange.length;
            if (A02[6].length() == 11) {
                throw new RuntimeException();
            }
            String[] strArr = A02;
            strArr[1] = "RV5OfyweW4wBRjSXE96KsfJWHrB947mL";
            strArr[5] = "jo6XK4IT7nYvaByB2JuHKkdYgu4o02Vy";
            if (i8 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 89);
            i8++;
        }
    }

    public static void A02() {
        A01 = new byte[]{86, 88, 81};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 9 out of bounds for length 7
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:118)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:567)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:39)
     */
    private void A03(List<AnonymousClass49> list, int i, int i5) {
        list.get(i);
        list.get(i5);
        throw new NullPointerException(A01(0, 3, 108));
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 4 out of bounds for length 4
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:118)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:567)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:39)
     */
    public final void A04(List<AnonymousClass49> list) {
        int A00 = A00(list);
        if (A00 != -1) {
            A03(list, A00, A00 + 1);
            throw null;
        }
    }

    static {
        A02();
    }

    public C4X(C4W c4w) {
        this.A00 = c4w;
    }
}
