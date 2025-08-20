package com.facebook.ads.redexgen.X;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* renamed from: com.facebook.ads.redexgen.X.Vh  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1035Vh implements HU {
    public static byte[] A02;
    public static String[] A03 = {"V9uyJ8pLVYRD0ZldKEQ8Fm6zvmqMDXWy", "Hg71UAiYySRbQdhhlwilCiKnXjev2ePA", "dXXMV49sZASER8PJdu1teXvpuaC", "ItxDGkbDnUyb6oqtSMasVXx46j9iOzYk", "dhSjei0RHB98MxffIoNKZhf7ZhQ", "21gtHhMrMv89rh6v8Px22ucxkmd", "UIi9EoWARjlD8E8YBHi4CxflqQKZlpEG", "jZKVHFEUmyWXIM9jvQw89fwKPj"};
    public static final C1035Vh A04;
    public int A00;
    public final Map<String, byte[]> A01;

    public static String A01(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 95);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A02 = new byte[]{20, 51, 43, 60, 49, 52, 57, 125, 43, 60, 49, 40, 56, 125, 46, 52, 39, 56, 103, 125, 87, 107, 102, 35, 112, 106, 121, 102, 35, 108, 101, 35, 38, 112, 35, 43, 38, 103, 42, 35, 106, 112, 35, 100, 113, 102, 98, 119, 102, 113, 35, 119, 107, 98, 109, 35, 110, 98, 123, 106, 110, 118, 110, 35, 98, 111, 111, 108, 116, 102, 103, 57, 35, 38, 103, 79, 78, 92, 55, 34};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 8 out of bounds for length 7
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:118)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:567)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:39)
     */
    public static void A05(HashMap<String, byte[]> hashMap, Map<String, Object> map) {
        for (String str : map.keySet()) {
            byte[] A07 = A07(map.get(str));
            if (A07.length > 10485760) {
                throw new IllegalArgumentException(String.format(A01(20, 55, 92), str, Integer.valueOf(A07.length), 10485760));
            }
            hashMap.put(str, A07);
        }
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 7 out of bounds for length 6
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:118)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:567)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:39)
     */
    private boolean A06(Map<String, byte[]> map) {
        if (this.A01.size() != map.size()) {
            return false;
        }
        for (Map.Entry<String, byte[]> entry : this.A01.entrySet()) {
            if (!Arrays.equals(entry.getValue(), map.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    static {
        A03();
        A04 = new C1035Vh(Collections.emptyMap());
    }

    public C1035Vh(Map<String, byte[]> metadata) {
        this.A01 = Collections.unmodifiableMap(metadata);
    }

    public static C1035Vh A00(DataInputStream dataInputStream) throws IOException {
        int readInt = dataInputStream.readInt();
        HashMap hashMap = new HashMap();
        for (int i = 0; i < readInt; i++) {
            String readUTF = dataInputStream.readUTF();
            int valueSize = dataInputStream.readInt();
            if (valueSize >= 0) {
                if (A03[5].length() == 7) {
                    throw new RuntimeException();
                }
                A03[5] = "wIzKKnz4WNrtvGk5MZN9OtyZE";
                if (valueSize <= 10485760) {
                    byte[] bArr = new byte[valueSize];
                    dataInputStream.readFully(bArr);
                    hashMap.put(readUTF, bArr);
                }
            }
            throw new IOException(A01(0, 20, 2) + valueSize);
        }
        return new C1035Vh(hashMap);
    }

    public static Map<String, byte[]> A02(Map<String, byte[]> otherMetadata, HW hw2) {
        HashMap hashMap = new HashMap(otherMetadata);
        A04(hashMap, hw2.A04());
        A05(hashMap, hw2.A05());
        return hashMap;
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0005 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void A04(java.util.HashMap<java.lang.String, byte[]> r2, java.util.List<java.lang.String> r3) {
        /*
            r1 = 0
        L1:
            int r0 = r3.size()
            if (r1 >= r0) goto L11
            java.lang.Object r0 = r3.get(r1)
            r2.remove(r0)
            int r1 = r1 + 1
            goto L1
        L11:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1035Vh.A04(java.util.HashMap, java.util.List):void");
    }

    public static byte[] A07(Object obj) {
        if (obj instanceof Long) {
            return ByteBuffer.allocate(8).putLong(((Long) obj).longValue()).array();
        }
        if (obj instanceof String) {
            return ((String) obj).getBytes(Charset.forName(A01(75, 5, 69)));
        }
        if (obj instanceof byte[]) {
            return (byte[]) obj;
        }
        throw new IllegalArgumentException();
    }

    public final C1035Vh A08(HW hw2) {
        Map<String, byte[]> A022 = A02(this.A01, hw2);
        if (A06(A022)) {
            return this;
        }
        return new C1035Vh(A022);
    }

    public final void A09(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.A01.size());
        for (Map.Entry<String, byte[]> entry : this.A01.entrySet()) {
            dataOutputStream.writeUTF(entry.getKey());
            byte[] value = entry.getValue();
            dataOutputStream.writeInt(value.length);
            dataOutputStream.write(value);
        }
    }

    @Override // com.facebook.ads.redexgen.X.HU
    public final long A5p(String str, long j2) {
        if (this.A01.containsKey(str)) {
            byte[] bytes = this.A01.get(str);
            return ByteBuffer.wrap(bytes).getLong();
        }
        return j2;
    }

    @Override // com.facebook.ads.redexgen.X.HU
    public final String A5r(String str, String str2) {
        if (this.A01.containsKey(str)) {
            return new String(this.A01.get(str), Charset.forName(A01(75, 5, 69)));
        }
        return str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return A06(((C1035Vh) obj).A01);
    }

    public final int hashCode() {
        if (this.A00 == 0) {
            int i = 0;
            for (Map.Entry<String, byte[]> entry : this.A01.entrySet()) {
                int hashCode = entry.getKey().hashCode();
                int result = Arrays.hashCode(entry.getValue());
                i += hashCode ^ result;
            }
            this.A00 = i;
        }
        int result2 = this.A00;
        return result2;
    }
}
