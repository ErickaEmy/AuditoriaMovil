package com.google.protobuf;

import androidx.core.app.NotificationCompat;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class Utf8 {
    public static final Processor y;

    /* loaded from: classes.dex */
    public static class DecodeUtil {
        public static void c5(byte b2, char[] cArr, int i) {
            cArr[i] = (char) b2;
        }

        public static void f(byte b2, byte b3, char[] cArr, int i) throws InvalidProtocolBufferException {
            if (b2 >= -62 && !tl(b3)) {
                cArr[i] = (char) (((b2 & 31) << 6) | mt(b3));
                return;
            }
            throw InvalidProtocolBufferException.s();
        }

        public static void i9(byte b2, byte b3, byte b4, char[] cArr, int i) throws InvalidProtocolBufferException {
            if (!tl(b3) && ((b2 != -32 || b3 >= -96) && ((b2 != -19 || b3 < -96) && !tl(b4)))) {
                cArr[i] = (char) (((b2 & 15) << 12) | (mt(b3) << 6) | mt(b4));
                return;
            }
            throw InvalidProtocolBufferException.s();
        }

        public static int mt(byte b2) {
            return b2 & 63;
        }

        public static char p(int i) {
            return (char) ((i & 1023) + 56320);
        }

        public static void s(byte b2, byte b3, byte b4, byte b5, char[] cArr, int i) throws InvalidProtocolBufferException {
            if (!tl(b3) && (((b2 << 28) + (b3 + 112)) >> 30) == 0 && !tl(b4) && !tl(b5)) {
                int mt2 = ((b2 & 7) << 18) | (mt(b3) << 12) | (mt(b4) << 6) | mt(b5);
                cArr[i] = t(mt2);
                cArr[i + 1] = p(mt2);
                return;
            }
            throw InvalidProtocolBufferException.s();
        }

        public static char t(int i) {
            return (char) ((i >>> 10) + 55232);
        }

        public static boolean tl(byte b2) {
            return b2 > -65;
        }

        public static boolean w(byte b2) {
            return b2 < -32;
        }

        public static boolean wz(byte b2) {
            return b2 >= 0;
        }

        public static boolean xc(byte b2) {
            return b2 < -16;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Processor {
        public static int tl(ByteBuffer byteBuffer, int i, int i5) {
            int tl2 = i + Utf8.tl(byteBuffer, i, i5);
            while (tl2 < i5) {
                int i6 = tl2 + 1;
                byte b2 = byteBuffer.get(tl2);
                if (b2 < 0) {
                    if (b2 < -32) {
                        if (i6 >= i5) {
                            return b2;
                        }
                        if (b2 < -62 || byteBuffer.get(i6) > -65) {
                            return -1;
                        }
                        tl2 += 2;
                    } else if (b2 < -16) {
                        if (i6 >= i5 - 1) {
                            return Utf8.p(byteBuffer, b2, i6, i5 - i6);
                        }
                        int i8 = tl2 + 2;
                        byte b3 = byteBuffer.get(i6);
                        if (b3 > -65 || ((b2 == -32 && b3 < -96) || ((b2 == -19 && b3 >= -96) || byteBuffer.get(i8) > -65))) {
                            return -1;
                        }
                        tl2 += 3;
                    } else if (i6 >= i5 - 2) {
                        return Utf8.p(byteBuffer, b2, i6, i5 - i6);
                    } else {
                        int i10 = tl2 + 2;
                        byte b4 = byteBuffer.get(i6);
                        if (b4 <= -65 && (((b2 << 28) + (b4 + 112)) >> 30) == 0) {
                            int i11 = tl2 + 3;
                            if (byteBuffer.get(i10) <= -65) {
                                tl2 += 4;
                                if (byteBuffer.get(i11) > -65) {
                                }
                            }
                        }
                        return -1;
                    }
                } else {
                    tl2 = i6;
                }
            }
            return 0;
        }

        public final void a(CharSequence charSequence, ByteBuffer byteBuffer) {
            if (byteBuffer.hasArray()) {
                int arrayOffset = byteBuffer.arrayOffset();
                Java8Compatibility.gv(byteBuffer, Utf8.c5(charSequence, byteBuffer.array(), byteBuffer.position() + arrayOffset, byteBuffer.remaining()) - arrayOffset);
            } else if (byteBuffer.isDirect()) {
                s(charSequence, byteBuffer);
            } else {
                fb(charSequence, byteBuffer);
            }
        }

        public final boolean c5(ByteBuffer byteBuffer, int i, int i5) {
            if (f(0, byteBuffer, i, i5) != 0) {
                return false;
            }
            return true;
        }

        public final int f(int i, ByteBuffer byteBuffer, int i5, int i6) {
            if (byteBuffer.hasArray()) {
                int arrayOffset = byteBuffer.arrayOffset();
                return t(i, byteBuffer.array(), i5 + arrayOffset, arrayOffset + i6);
            } else if (byteBuffer.isDirect()) {
                return xc(i, byteBuffer, i5, i6);
            } else {
                return wz(i, byteBuffer, i5, i6);
            }
        }

        public final void fb(CharSequence charSequence, ByteBuffer byteBuffer) {
            int i;
            int length = charSequence.length();
            int position = byteBuffer.position();
            int i5 = 0;
            while (i5 < length) {
                try {
                    char charAt = charSequence.charAt(i5);
                    if (charAt >= 128) {
                        break;
                    }
                    byteBuffer.put(position + i5, (byte) charAt);
                    i5++;
                } catch (IndexOutOfBoundsException unused) {
                    throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i5) + " at index " + (byteBuffer.position() + Math.max(i5, (position - byteBuffer.position()) + 1)));
                }
            }
            if (i5 == length) {
                Java8Compatibility.gv(byteBuffer, position + i5);
                return;
            }
            position += i5;
            while (i5 < length) {
                char charAt2 = charSequence.charAt(i5);
                if (charAt2 < 128) {
                    byteBuffer.put(position, (byte) charAt2);
                } else if (charAt2 < 2048) {
                    int i6 = position + 1;
                    try {
                        byteBuffer.put(position, (byte) ((charAt2 >>> 6) | 192));
                        byteBuffer.put(i6, (byte) ((charAt2 & '?') | NotificationCompat.FLAG_HIGH_PRIORITY));
                        position = i6;
                    } catch (IndexOutOfBoundsException unused2) {
                        position = i6;
                        throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i5) + " at index " + (byteBuffer.position() + Math.max(i5, (position - byteBuffer.position()) + 1)));
                    }
                } else if (charAt2 >= 55296 && 57343 >= charAt2) {
                    int i8 = i5 + 1;
                    if (i8 != length) {
                        try {
                            char charAt3 = charSequence.charAt(i8);
                            if (Character.isSurrogatePair(charAt2, charAt3)) {
                                int codePoint = Character.toCodePoint(charAt2, charAt3);
                                int i10 = position + 1;
                                try {
                                    byteBuffer.put(position, (byte) ((codePoint >>> 18) | 240));
                                    i = position + 2;
                                } catch (IndexOutOfBoundsException unused3) {
                                    position = i10;
                                    i5 = i8;
                                    throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i5) + " at index " + (byteBuffer.position() + Math.max(i5, (position - byteBuffer.position()) + 1)));
                                }
                                try {
                                    byteBuffer.put(i10, (byte) (((codePoint >>> 12) & 63) | NotificationCompat.FLAG_HIGH_PRIORITY));
                                    position += 3;
                                    byteBuffer.put(i, (byte) (((codePoint >>> 6) & 63) | NotificationCompat.FLAG_HIGH_PRIORITY));
                                    byteBuffer.put(position, (byte) ((codePoint & 63) | NotificationCompat.FLAG_HIGH_PRIORITY));
                                    i5 = i8;
                                } catch (IndexOutOfBoundsException unused4) {
                                    i5 = i8;
                                    position = i;
                                    throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i5) + " at index " + (byteBuffer.position() + Math.max(i5, (position - byteBuffer.position()) + 1)));
                                }
                            } else {
                                i5 = i8;
                            }
                        } catch (IndexOutOfBoundsException unused5) {
                        }
                    }
                    throw new UnpairedSurrogateException(i5, length);
                } else {
                    int i11 = position + 1;
                    byteBuffer.put(position, (byte) ((charAt2 >>> '\f') | 224));
                    position += 2;
                    byteBuffer.put(i11, (byte) (((charAt2 >>> 6) & 63) | NotificationCompat.FLAG_HIGH_PRIORITY));
                    byteBuffer.put(position, (byte) ((charAt2 & '?') | NotificationCompat.FLAG_HIGH_PRIORITY));
                }
                i5++;
                position++;
            }
            Java8Compatibility.gv(byteBuffer, position);
        }

        public abstract String gv(ByteBuffer byteBuffer, int i, int i5) throws InvalidProtocolBufferException;

        public final boolean i9(byte[] bArr, int i, int i5) {
            if (t(0, bArr, i, i5) != 0) {
                return false;
            }
            return true;
        }

        public abstract String n3(byte[] bArr, int i, int i5) throws InvalidProtocolBufferException;

        public abstract void s(CharSequence charSequence, ByteBuffer byteBuffer);

        public abstract int t(int i, byte[] bArr, int i5, int i6);

        public abstract int v(CharSequence charSequence, byte[] bArr, int i, int i5);

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0017, code lost:
            if (r8.get(r9) > (-65)) goto L12;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x004c, code lost:
            if (r8.get(r9) > (-65)) goto L31;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x008f, code lost:
            if (r8.get(r7) > (-65)) goto L51;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final int wz(int r7, java.nio.ByteBuffer r8, int r9, int r10) {
            /*
                r6 = this;
                if (r7 == 0) goto L92
                if (r9 < r10) goto L5
                return r7
            L5:
                byte r0 = (byte) r7
                r1 = -32
                r2 = -1
                r3 = -65
                if (r0 >= r1) goto L1e
                r7 = -62
                if (r0 < r7) goto L1d
                int r7 = r9 + 1
                byte r9 = r8.get(r9)
                if (r9 <= r3) goto L1a
                goto L1d
            L1a:
                r9 = r7
                goto L92
            L1d:
                return r2
            L1e:
                r4 = -16
                if (r0 >= r4) goto L4f
                int r7 = r7 >> 8
                int r7 = ~r7
                byte r7 = (byte) r7
                if (r7 != 0) goto L38
                int r7 = r9 + 1
                byte r9 = r8.get(r9)
                if (r7 < r10) goto L35
                int r7 = com.google.protobuf.Utf8.y(r0, r9)
                return r7
            L35:
                r5 = r9
                r9 = r7
                r7 = r5
            L38:
                if (r7 > r3) goto L4e
                r4 = -96
                if (r0 != r1) goto L40
                if (r7 < r4) goto L4e
            L40:
                r1 = -19
                if (r0 != r1) goto L46
                if (r7 >= r4) goto L4e
            L46:
                int r7 = r9 + 1
                byte r9 = r8.get(r9)
                if (r9 <= r3) goto L1a
            L4e:
                return r2
            L4f:
                int r1 = r7 >> 8
                int r1 = ~r1
                byte r1 = (byte) r1
                if (r1 != 0) goto L64
                int r7 = r9 + 1
                byte r1 = r8.get(r9)
                if (r7 < r10) goto L62
                int r7 = com.google.protobuf.Utf8.y(r0, r1)
                return r7
            L62:
                r9 = 0
                goto L6a
            L64:
                int r7 = r7 >> 16
                byte r7 = (byte) r7
                r5 = r9
                r9 = r7
                r7 = r5
            L6a:
                if (r9 != 0) goto L7c
                int r9 = r7 + 1
                byte r7 = r8.get(r7)
                if (r9 < r10) goto L79
                int r7 = com.google.protobuf.Utf8.n3(r0, r1, r7)
                return r7
            L79:
                r5 = r9
                r9 = r7
                r7 = r5
            L7c:
                if (r1 > r3) goto L91
                int r0 = r0 << 28
                int r1 = r1 + 112
                int r0 = r0 + r1
                int r0 = r0 >> 30
                if (r0 != 0) goto L91
                if (r9 > r3) goto L91
                int r9 = r7 + 1
                byte r7 = r8.get(r7)
                if (r7 <= r3) goto L92
            L91:
                return r2
            L92:
                int r7 = tl(r8, r9, r10)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.Processor.wz(int, java.nio.ByteBuffer, int, int):int");
        }

        public abstract int xc(int i, ByteBuffer byteBuffer, int i5, int i6);

        public final String y(ByteBuffer byteBuffer, int i, int i5) throws InvalidProtocolBufferException {
            if (byteBuffer.hasArray()) {
                return n3(byteBuffer.array(), byteBuffer.arrayOffset() + i, i5);
            } else if (byteBuffer.isDirect()) {
                return gv(byteBuffer, i, i5);
            } else {
                return zn(byteBuffer, i, i5);
            }
        }

        public final String zn(ByteBuffer byteBuffer, int i, int i5) throws InvalidProtocolBufferException {
            if ((i | i5 | ((byteBuffer.limit() - i) - i5)) >= 0) {
                int i6 = i + i5;
                char[] cArr = new char[i5];
                int i8 = 0;
                while (i < i6) {
                    byte b2 = byteBuffer.get(i);
                    if (!DecodeUtil.wz(b2)) {
                        break;
                    }
                    i++;
                    DecodeUtil.c5(b2, cArr, i8);
                    i8++;
                }
                int i10 = i8;
                while (i < i6) {
                    int i11 = i + 1;
                    byte b3 = byteBuffer.get(i);
                    if (DecodeUtil.wz(b3)) {
                        int i12 = i10 + 1;
                        DecodeUtil.c5(b3, cArr, i10);
                        while (i11 < i6) {
                            byte b4 = byteBuffer.get(i11);
                            if (!DecodeUtil.wz(b4)) {
                                break;
                            }
                            i11++;
                            DecodeUtil.c5(b4, cArr, i12);
                            i12++;
                        }
                        i10 = i12;
                        i = i11;
                    } else if (DecodeUtil.w(b3)) {
                        if (i11 < i6) {
                            i += 2;
                            DecodeUtil.f(b3, byteBuffer.get(i11), cArr, i10);
                            i10++;
                        } else {
                            throw InvalidProtocolBufferException.s();
                        }
                    } else if (DecodeUtil.xc(b3)) {
                        if (i11 < i6 - 1) {
                            int i13 = i + 2;
                            i += 3;
                            DecodeUtil.i9(b3, byteBuffer.get(i11), byteBuffer.get(i13), cArr, i10);
                            i10++;
                        } else {
                            throw InvalidProtocolBufferException.s();
                        }
                    } else if (i11 < i6 - 2) {
                        byte b5 = byteBuffer.get(i11);
                        int i14 = i + 3;
                        i += 4;
                        DecodeUtil.s(b3, b5, byteBuffer.get(i + 2), byteBuffer.get(i14), cArr, i10);
                        i10 += 2;
                    } else {
                        throw InvalidProtocolBufferException.s();
                    }
                }
                return new String(cArr, 0, i10);
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i), Integer.valueOf(i5)));
        }
    }

    /* loaded from: classes.dex */
    public static final class SafeProcessor extends Processor {
        public static int p(byte[] bArr, int i, int i5) {
            while (i < i5) {
                int i6 = i + 1;
                byte b2 = bArr[i];
                if (b2 < 0) {
                    if (b2 < -32) {
                        if (i6 >= i5) {
                            return b2;
                        }
                        if (b2 >= -62) {
                            i += 2;
                            if (bArr[i6] > -65) {
                            }
                        }
                        return -1;
                    } else if (b2 < -16) {
                        if (i6 >= i5 - 1) {
                            return Utf8.mt(bArr, i6, i5);
                        }
                        int i8 = i + 2;
                        byte b3 = bArr[i6];
                        if (b3 <= -65 && ((b2 != -32 || b3 >= -96) && (b2 != -19 || b3 < -96))) {
                            i += 3;
                            if (bArr[i8] > -65) {
                            }
                        }
                        return -1;
                    } else if (i6 >= i5 - 2) {
                        return Utf8.mt(bArr, i6, i5);
                    } else {
                        int i10 = i + 2;
                        byte b4 = bArr[i6];
                        if (b4 <= -65 && (((b2 << 28) + (b4 + 112)) >> 30) == 0) {
                            int i11 = i + 3;
                            if (bArr[i10] <= -65) {
                                i += 4;
                                if (bArr[i11] > -65) {
                                }
                            }
                        }
                        return -1;
                    }
                }
                i = i6;
            }
            return 0;
        }

        public static int w(byte[] bArr, int i, int i5) {
            while (i < i5 && bArr[i] >= 0) {
                i++;
            }
            if (i >= i5) {
                return 0;
            }
            return p(bArr, i, i5);
        }

        @Override // com.google.protobuf.Utf8.Processor
        public String gv(ByteBuffer byteBuffer, int i, int i5) throws InvalidProtocolBufferException {
            return zn(byteBuffer, i, i5);
        }

        @Override // com.google.protobuf.Utf8.Processor
        public String n3(byte[] bArr, int i, int i5) throws InvalidProtocolBufferException {
            if ((i | i5 | ((bArr.length - i) - i5)) >= 0) {
                int i6 = i + i5;
                char[] cArr = new char[i5];
                int i8 = 0;
                while (i < i6) {
                    byte b2 = bArr[i];
                    if (!DecodeUtil.wz(b2)) {
                        break;
                    }
                    i++;
                    DecodeUtil.c5(b2, cArr, i8);
                    i8++;
                }
                int i10 = i8;
                while (i < i6) {
                    int i11 = i + 1;
                    byte b3 = bArr[i];
                    if (DecodeUtil.wz(b3)) {
                        int i12 = i10 + 1;
                        DecodeUtil.c5(b3, cArr, i10);
                        while (i11 < i6) {
                            byte b4 = bArr[i11];
                            if (!DecodeUtil.wz(b4)) {
                                break;
                            }
                            i11++;
                            DecodeUtil.c5(b4, cArr, i12);
                            i12++;
                        }
                        i10 = i12;
                        i = i11;
                    } else if (DecodeUtil.w(b3)) {
                        if (i11 < i6) {
                            i += 2;
                            DecodeUtil.f(b3, bArr[i11], cArr, i10);
                            i10++;
                        } else {
                            throw InvalidProtocolBufferException.s();
                        }
                    } else if (DecodeUtil.xc(b3)) {
                        if (i11 < i6 - 1) {
                            int i13 = i + 2;
                            i += 3;
                            DecodeUtil.i9(b3, bArr[i11], bArr[i13], cArr, i10);
                            i10++;
                        } else {
                            throw InvalidProtocolBufferException.s();
                        }
                    } else if (i11 < i6 - 2) {
                        byte b5 = bArr[i11];
                        int i14 = i + 3;
                        i += 4;
                        DecodeUtil.s(b3, b5, bArr[i + 2], bArr[i14], cArr, i10);
                        i10 += 2;
                    } else {
                        throw InvalidProtocolBufferException.s();
                    }
                }
                return new String(cArr, 0, i10);
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i5)));
        }

        @Override // com.google.protobuf.Utf8.Processor
        public void s(CharSequence charSequence, ByteBuffer byteBuffer) {
            fb(charSequence, byteBuffer);
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0015, code lost:
            if (r8[r9] > (-65)) goto L12;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0046, code lost:
            if (r8[r9] > (-65)) goto L31;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x0083, code lost:
            if (r8[r7] > (-65)) goto L51;
         */
        @Override // com.google.protobuf.Utf8.Processor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int t(int r7, byte[] r8, int r9, int r10) {
            /*
                r6 = this;
                if (r7 == 0) goto L86
                if (r9 < r10) goto L5
                return r7
            L5:
                byte r0 = (byte) r7
                r1 = -32
                r2 = -1
                r3 = -65
                if (r0 >= r1) goto L1c
                r7 = -62
                if (r0 < r7) goto L1b
                int r7 = r9 + 1
                r9 = r8[r9]
                if (r9 <= r3) goto L18
                goto L1b
            L18:
                r9 = r7
                goto L86
            L1b:
                return r2
            L1c:
                r4 = -16
                if (r0 >= r4) goto L49
                int r7 = r7 >> 8
                int r7 = ~r7
                byte r7 = (byte) r7
                if (r7 != 0) goto L34
                int r7 = r9 + 1
                r9 = r8[r9]
                if (r7 < r10) goto L31
                int r7 = com.google.protobuf.Utf8.y(r0, r9)
                return r7
            L31:
                r5 = r9
                r9 = r7
                r7 = r5
            L34:
                if (r7 > r3) goto L48
                r4 = -96
                if (r0 != r1) goto L3c
                if (r7 < r4) goto L48
            L3c:
                r1 = -19
                if (r0 != r1) goto L42
                if (r7 >= r4) goto L48
            L42:
                int r7 = r9 + 1
                r9 = r8[r9]
                if (r9 <= r3) goto L18
            L48:
                return r2
            L49:
                int r1 = r7 >> 8
                int r1 = ~r1
                byte r1 = (byte) r1
                if (r1 != 0) goto L5c
                int r7 = r9 + 1
                r1 = r8[r9]
                if (r7 < r10) goto L5a
                int r7 = com.google.protobuf.Utf8.y(r0, r1)
                return r7
            L5a:
                r9 = 0
                goto L62
            L5c:
                int r7 = r7 >> 16
                byte r7 = (byte) r7
                r5 = r9
                r9 = r7
                r7 = r5
            L62:
                if (r9 != 0) goto L72
                int r9 = r7 + 1
                r7 = r8[r7]
                if (r9 < r10) goto L6f
                int r7 = com.google.protobuf.Utf8.n3(r0, r1, r7)
                return r7
            L6f:
                r5 = r9
                r9 = r7
                r7 = r5
            L72:
                if (r1 > r3) goto L85
                int r0 = r0 << 28
                int r1 = r1 + 112
                int r0 = r0 + r1
                int r0 = r0 >> 30
                if (r0 != 0) goto L85
                if (r9 > r3) goto L85
                int r9 = r7 + 1
                r7 = r8[r7]
                if (r7 <= r3) goto L86
            L85:
                return r2
            L86:
                int r7 = w(r8, r9, r10)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.SafeProcessor.t(int, byte[], int, int):int");
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
            return r10 + r0;
         */
        @Override // com.google.protobuf.Utf8.Processor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int v(java.lang.CharSequence r8, byte[] r9, int r10, int r11) {
            /*
                Method dump skipped, instructions count: 254
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.SafeProcessor.v(java.lang.CharSequence, byte[], int, int):int");
        }

        @Override // com.google.protobuf.Utf8.Processor
        public int xc(int i, ByteBuffer byteBuffer, int i5, int i6) {
            return wz(i, byteBuffer, i5, i6);
        }
    }

    /* loaded from: classes.dex */
    public static class UnpairedSurrogateException extends IllegalArgumentException {
        public UnpairedSurrogateException(int i, int i5) {
            super("Unpaired surrogate at index " + i + " of " + i5);
        }
    }

    /* loaded from: classes.dex */
    public static final class UnsafeProcessor extends Processor {
        public static int co(long j2, int i) {
            if (i < 16) {
                return 0;
            }
            int i5 = (int) ((-j2) & 7);
            int i6 = i5;
            while (i6 > 0) {
                long j4 = 1 + j2;
                if (UnsafeUtil.f3(j2) < 0) {
                    return i5 - i6;
                }
                i6--;
                j2 = j4;
            }
            int i8 = i - i5;
            while (i8 >= 8 && (UnsafeUtil.ta(j2) & (-9187201950435737472L)) == 0) {
                j2 += 8;
                i8 -= 8;
            }
            return i - i8;
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x0039, code lost:
            return -1;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static int mt(byte[] r10, long r11, int r13) {
            /*
                int r0 = z(r10, r11, r13)
                int r13 = r13 - r0
                long r0 = (long) r0
                long r11 = r11 + r0
            L7:
                r0 = 0
                r1 = 0
            L9:
                r2 = 1
                if (r13 <= 0) goto L1a
                long r4 = r11 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.n(r10, r11)
                if (r1 < 0) goto L19
                int r13 = r13 + (-1)
                r11 = r4
                goto L9
            L19:
                r11 = r4
            L1a:
                if (r13 != 0) goto L1d
                return r0
            L1d:
                int r0 = r13 + (-1)
                r4 = -32
                r5 = -1
                r6 = -65
                if (r1 >= r4) goto L3a
                if (r0 != 0) goto L29
                return r1
            L29:
                int r13 = r13 + (-2)
                r0 = -62
                if (r1 < r0) goto L39
                long r2 = r2 + r11
                byte r11 = com.google.protobuf.UnsafeUtil.n(r10, r11)
                if (r11 <= r6) goto L37
                goto L39
            L37:
                r11 = r2
                goto L7
            L39:
                return r5
            L3a:
                r7 = -16
                r8 = 2
                if (r1 >= r7) goto L65
                r7 = 2
                if (r0 >= r7) goto L48
                int r10 = x4(r10, r1, r11, r0)
                return r10
            L48:
                int r13 = r13 + (-3)
                long r2 = r2 + r11
                byte r0 = com.google.protobuf.UnsafeUtil.n(r10, r11)
                if (r0 > r6) goto L64
                r7 = -96
                if (r1 != r4) goto L57
                if (r0 < r7) goto L64
            L57:
                r4 = -19
                if (r1 != r4) goto L5d
                if (r0 >= r7) goto L64
            L5d:
                long r11 = r11 + r8
                byte r0 = com.google.protobuf.UnsafeUtil.n(r10, r2)
                if (r0 <= r6) goto L7
            L64:
                return r5
            L65:
                r4 = 3
                if (r0 >= r4) goto L6d
                int r10 = x4(r10, r1, r11, r0)
                return r10
            L6d:
                int r13 = r13 + (-4)
                long r2 = r2 + r11
                byte r0 = com.google.protobuf.UnsafeUtil.n(r10, r11)
                if (r0 > r6) goto L8f
                int r1 = r1 << 28
                int r0 = r0 + 112
                int r1 = r1 + r0
                int r0 = r1 >> 30
                if (r0 != 0) goto L8f
                long r8 = r8 + r11
                byte r0 = com.google.protobuf.UnsafeUtil.n(r10, r2)
                if (r0 > r6) goto L8f
                r0 = 3
                long r11 = r11 + r0
                byte r0 = com.google.protobuf.UnsafeUtil.n(r10, r8)
                if (r0 <= r6) goto L7
            L8f:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.UnsafeProcessor.mt(byte[], long, int):int");
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x0039, code lost:
            return -1;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static int p(long r10, int r12) {
            /*
                int r0 = co(r10, r12)
                long r1 = (long) r0
                long r10 = r10 + r1
                int r12 = r12 - r0
            L7:
                r0 = 0
                r1 = 0
            L9:
                r2 = 1
                if (r12 <= 0) goto L1a
                long r4 = r10 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.f3(r10)
                if (r1 < 0) goto L19
                int r12 = r12 + (-1)
                r10 = r4
                goto L9
            L19:
                r10 = r4
            L1a:
                if (r12 != 0) goto L1d
                return r0
            L1d:
                int r0 = r12 + (-1)
                r4 = -32
                r5 = -1
                r6 = -65
                if (r1 >= r4) goto L3a
                if (r0 != 0) goto L29
                return r1
            L29:
                int r12 = r12 + (-2)
                r0 = -62
                if (r1 < r0) goto L39
                long r2 = r2 + r10
                byte r10 = com.google.protobuf.UnsafeUtil.f3(r10)
                if (r10 <= r6) goto L37
                goto L39
            L37:
                r10 = r2
                goto L7
            L39:
                return r5
            L3a:
                r7 = -16
                r8 = 2
                if (r1 >= r7) goto L65
                r7 = 2
                if (r0 >= r7) goto L48
                int r10 = r(r10, r1, r0)
                return r10
            L48:
                int r12 = r12 + (-3)
                long r2 = r2 + r10
                byte r0 = com.google.protobuf.UnsafeUtil.f3(r10)
                if (r0 > r6) goto L64
                r7 = -96
                if (r1 != r4) goto L57
                if (r0 < r7) goto L64
            L57:
                r4 = -19
                if (r1 != r4) goto L5d
                if (r0 >= r7) goto L64
            L5d:
                long r10 = r10 + r8
                byte r0 = com.google.protobuf.UnsafeUtil.f3(r2)
                if (r0 <= r6) goto L7
            L64:
                return r5
            L65:
                r4 = 3
                if (r0 >= r4) goto L6d
                int r10 = r(r10, r1, r0)
                return r10
            L6d:
                int r12 = r12 + (-4)
                long r2 = r2 + r10
                byte r0 = com.google.protobuf.UnsafeUtil.f3(r10)
                if (r0 > r6) goto L8f
                int r1 = r1 << 28
                int r0 = r0 + 112
                int r1 = r1 + r0
                int r0 = r1 >> 30
                if (r0 != 0) goto L8f
                long r8 = r8 + r10
                byte r0 = com.google.protobuf.UnsafeUtil.f3(r2)
                if (r0 > r6) goto L8f
                r0 = 3
                long r10 = r10 + r0
                byte r0 = com.google.protobuf.UnsafeUtil.f3(r8)
                if (r0 <= r6) goto L7
            L8f:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.UnsafeProcessor.p(long, int):int");
        }

        public static int r(long j2, int i, int i5) {
            if (i5 == 0) {
                return Utf8.wz(i);
            }
            if (i5 == 1) {
                return Utf8.xc(i, UnsafeUtil.f3(j2));
            }
            if (i5 == 2) {
                return Utf8.w(i, UnsafeUtil.f3(j2), UnsafeUtil.f3(j2 + 1));
            }
            throw new AssertionError();
        }

        public static boolean w() {
            if (UnsafeUtil.a8() && UnsafeUtil.x()) {
                return true;
            }
            return false;
        }

        public static int x4(byte[] bArr, int i, long j2, int i5) {
            if (i5 == 0) {
                return Utf8.wz(i);
            }
            if (i5 == 1) {
                return Utf8.xc(i, UnsafeUtil.n(bArr, j2));
            }
            if (i5 == 2) {
                return Utf8.w(i, UnsafeUtil.n(bArr, j2), UnsafeUtil.n(bArr, j2 + 1));
            }
            throw new AssertionError();
        }

        public static int z(byte[] bArr, long j2, int i) {
            int i5 = 0;
            if (i < 16) {
                return 0;
            }
            int i6 = 8 - (((int) j2) & 7);
            while (i5 < i6) {
                long j4 = 1 + j2;
                if (UnsafeUtil.n(bArr, j2) < 0) {
                    return i5;
                }
                i5++;
                j2 = j4;
            }
            while (true) {
                int i8 = i5 + 8;
                if (i8 > i || (UnsafeUtil.d(bArr, UnsafeUtil.f6560s + j2) & (-9187201950435737472L)) != 0) {
                    break;
                }
                j2 += 8;
                i5 = i8;
            }
            while (i5 < i) {
                long j6 = j2 + 1;
                if (UnsafeUtil.n(bArr, j2) < 0) {
                    return i5;
                }
                i5++;
                j2 = j6;
            }
            return i;
        }

        @Override // com.google.protobuf.Utf8.Processor
        public String gv(ByteBuffer byteBuffer, int i, int i5) throws InvalidProtocolBufferException {
            if ((i | i5 | ((byteBuffer.limit() - i) - i5)) >= 0) {
                long f4 = UnsafeUtil.f(byteBuffer) + i;
                long j2 = i5 + f4;
                char[] cArr = new char[i5];
                int i6 = 0;
                while (f4 < j2) {
                    byte f32 = UnsafeUtil.f3(f4);
                    if (!DecodeUtil.wz(f32)) {
                        break;
                    }
                    f4++;
                    DecodeUtil.c5(f32, cArr, i6);
                    i6++;
                }
                while (f4 < j2) {
                    long j4 = f4 + 1;
                    byte f33 = UnsafeUtil.f3(f4);
                    if (DecodeUtil.wz(f33)) {
                        int i8 = i6 + 1;
                        DecodeUtil.c5(f33, cArr, i6);
                        while (j4 < j2) {
                            byte f34 = UnsafeUtil.f3(j4);
                            if (!DecodeUtil.wz(f34)) {
                                break;
                            }
                            j4++;
                            DecodeUtil.c5(f34, cArr, i8);
                            i8++;
                        }
                        i6 = i8;
                        f4 = j4;
                    } else if (DecodeUtil.w(f33)) {
                        if (j4 < j2) {
                            f4 += 2;
                            DecodeUtil.f(f33, UnsafeUtil.f3(j4), cArr, i6);
                            i6++;
                        } else {
                            throw InvalidProtocolBufferException.s();
                        }
                    } else if (DecodeUtil.xc(f33)) {
                        if (j4 < j2 - 1) {
                            long j6 = 2 + f4;
                            f4 += 3;
                            DecodeUtil.i9(f33, UnsafeUtil.f3(j4), UnsafeUtil.f3(j6), cArr, i6);
                            i6++;
                        } else {
                            throw InvalidProtocolBufferException.s();
                        }
                    } else if (j4 < j2 - 2) {
                        long j7 = f4 + 3;
                        f4 += 4;
                        DecodeUtil.s(f33, UnsafeUtil.f3(j4), UnsafeUtil.f3(2 + f4), UnsafeUtil.f3(j7), cArr, i6);
                        i6 += 2;
                    } else {
                        throw InvalidProtocolBufferException.s();
                    }
                }
                return new String(cArr, 0, i6);
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i), Integer.valueOf(i5)));
        }

        @Override // com.google.protobuf.Utf8.Processor
        public String n3(byte[] bArr, int i, int i5) throws InvalidProtocolBufferException {
            Charset charset = Internal.f6450n3;
            String str = new String(bArr, i, i5, charset);
            if (!str.contains("�")) {
                return str;
            }
            if (Arrays.equals(str.getBytes(charset), Arrays.copyOfRange(bArr, i, i5 + i))) {
                return str;
            }
            throw InvalidProtocolBufferException.s();
        }

        @Override // com.google.protobuf.Utf8.Processor
        public void s(CharSequence charSequence, ByteBuffer byteBuffer) {
            long j2;
            char c2;
            long j4;
            long j6;
            int i;
            long j7;
            int i5;
            char charAt;
            long f4 = UnsafeUtil.f(byteBuffer);
            long position = byteBuffer.position() + f4;
            long limit = byteBuffer.limit() + f4;
            int length = charSequence.length();
            if (length <= limit - position) {
                int i6 = 0;
                while (true) {
                    j2 = 1;
                    c2 = 128;
                    if (i6 >= length || (charAt = charSequence.charAt(i6)) >= 128) {
                        break;
                    }
                    UnsafeUtil.j5(position, (byte) charAt);
                    i6++;
                    position = 1 + position;
                }
                if (i6 == length) {
                    Java8Compatibility.gv(byteBuffer, (int) (position - f4));
                    return;
                }
                while (i6 < length) {
                    char charAt2 = charSequence.charAt(i6);
                    if (charAt2 < c2 && position < limit) {
                        UnsafeUtil.j5(position, (byte) charAt2);
                        j4 = f4;
                        j6 = limit;
                        i = i6;
                        j7 = j2;
                        position += j2;
                    } else if (charAt2 < 2048 && position <= limit - 2) {
                        j4 = f4;
                        long j8 = position + j2;
                        UnsafeUtil.j5(position, (byte) ((charAt2 >>> 6) | 960));
                        position += 2;
                        UnsafeUtil.j5(j8, (byte) ((charAt2 & '?') | NotificationCompat.FLAG_HIGH_PRIORITY));
                        j6 = limit;
                        i = i6;
                        j7 = j2;
                    } else {
                        j4 = f4;
                        if ((charAt2 < 55296 || 57343 < charAt2) && position <= limit - 3) {
                            long j9 = position + j2;
                            UnsafeUtil.j5(position, (byte) ((charAt2 >>> '\f') | 480));
                            long j10 = position + 2;
                            UnsafeUtil.j5(j9, (byte) (((charAt2 >>> 6) & 63) | NotificationCompat.FLAG_HIGH_PRIORITY));
                            position += 3;
                            UnsafeUtil.j5(j10, (byte) ((charAt2 & '?') | NotificationCompat.FLAG_HIGH_PRIORITY));
                            j6 = limit;
                            i = i6;
                            j7 = 1;
                        } else if (position <= limit - 4) {
                            i = i6 + 1;
                            if (i != length) {
                                char charAt3 = charSequence.charAt(i);
                                if (Character.isSurrogatePair(charAt2, charAt3)) {
                                    int codePoint = Character.toCodePoint(charAt2, charAt3);
                                    j7 = 1;
                                    UnsafeUtil.j5(position, (byte) ((codePoint >>> 18) | 240));
                                    j6 = limit;
                                    UnsafeUtil.j5(position + 1, (byte) (((codePoint >>> 12) & 63) | NotificationCompat.FLAG_HIGH_PRIORITY));
                                    long j11 = position + 3;
                                    UnsafeUtil.j5(position + 2, (byte) (((codePoint >>> 6) & 63) | NotificationCompat.FLAG_HIGH_PRIORITY));
                                    position += 4;
                                    UnsafeUtil.j5(j11, (byte) ((codePoint & 63) | NotificationCompat.FLAG_HIGH_PRIORITY));
                                } else {
                                    i6 = i;
                                }
                            }
                            throw new UnpairedSurrogateException(i6 - 1, length);
                        } else if (55296 <= charAt2 && charAt2 <= 57343 && ((i5 = i6 + 1) == length || !Character.isSurrogatePair(charAt2, charSequence.charAt(i5)))) {
                            throw new UnpairedSurrogateException(i6, length);
                        } else {
                            throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + position);
                        }
                        i6 = i + 1;
                        f4 = j4;
                        j2 = j7;
                        limit = j6;
                        c2 = 128;
                    }
                    i6 = i + 1;
                    f4 = j4;
                    j2 = j7;
                    limit = j6;
                    c2 = 128;
                }
                Java8Compatibility.gv(byteBuffer, (int) (position - f4));
                return;
            }
            throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(length - 1) + " at index " + byteBuffer.limit());
        }

        /* JADX WARN: Code restructure failed: missing block: B:35:0x0059, code lost:
            if (com.google.protobuf.UnsafeUtil.n(r13, r1) > (-65)) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x009e, code lost:
            if (com.google.protobuf.UnsafeUtil.n(r13, r1) > (-65)) goto L56;
         */
        @Override // com.google.protobuf.Utf8.Processor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int t(int r12, byte[] r13, int r14, int r15) {
            /*
                Method dump skipped, instructions count: 204
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.UnsafeProcessor.t(int, byte[], int, int):int");
        }

        @Override // com.google.protobuf.Utf8.Processor
        public int v(CharSequence charSequence, byte[] bArr, int i, int i5) {
            long j2;
            String str;
            String str2;
            int i6;
            long j4;
            long j6;
            char charAt;
            long j7 = i;
            long j8 = i5 + j7;
            int length = charSequence.length();
            String str3 = " at index ";
            String str4 = "Failed writing ";
            if (length <= i5 && bArr.length - i5 >= i) {
                int i8 = 0;
                while (true) {
                    j2 = 1;
                    if (i8 >= length || (charAt = charSequence.charAt(i8)) >= 128) {
                        break;
                    }
                    UnsafeUtil.qn(bArr, j7, (byte) charAt);
                    i8++;
                    j7 = 1 + j7;
                }
                if (i8 == length) {
                    return (int) j7;
                }
                while (i8 < length) {
                    char charAt2 = charSequence.charAt(i8);
                    if (charAt2 < 128 && j7 < j8) {
                        UnsafeUtil.qn(bArr, j7, (byte) charAt2);
                        j6 = j8;
                        str2 = str4;
                        j4 = j2;
                        j7 += j2;
                        str = str3;
                    } else {
                        if (charAt2 < 2048 && j7 <= j8 - 2) {
                            str = str3;
                            str2 = str4;
                            long j9 = j7 + j2;
                            UnsafeUtil.qn(bArr, j7, (byte) ((charAt2 >>> 6) | 960));
                            j7 += 2;
                            UnsafeUtil.qn(bArr, j9, (byte) ((charAt2 & '?') | NotificationCompat.FLAG_HIGH_PRIORITY));
                        } else {
                            str = str3;
                            str2 = str4;
                            if ((charAt2 < 55296 || 57343 < charAt2) && j7 <= j8 - 3) {
                                UnsafeUtil.qn(bArr, j7, (byte) ((charAt2 >>> '\f') | 480));
                                long j10 = j7 + 2;
                                UnsafeUtil.qn(bArr, j7 + 1, (byte) (((charAt2 >>> 6) & 63) | NotificationCompat.FLAG_HIGH_PRIORITY));
                                j7 += 3;
                                UnsafeUtil.qn(bArr, j10, (byte) ((charAt2 & '?') | NotificationCompat.FLAG_HIGH_PRIORITY));
                            } else if (j7 <= j8 - 4) {
                                int i10 = i8 + 1;
                                if (i10 != length) {
                                    char charAt3 = charSequence.charAt(i10);
                                    if (Character.isSurrogatePair(charAt2, charAt3)) {
                                        int codePoint = Character.toCodePoint(charAt2, charAt3);
                                        j4 = 1;
                                        UnsafeUtil.qn(bArr, j7, (byte) ((codePoint >>> 18) | 240));
                                        j6 = j8;
                                        UnsafeUtil.qn(bArr, j7 + 1, (byte) (((codePoint >>> 12) & 63) | NotificationCompat.FLAG_HIGH_PRIORITY));
                                        long j11 = j7 + 3;
                                        UnsafeUtil.qn(bArr, j7 + 2, (byte) (((codePoint >>> 6) & 63) | NotificationCompat.FLAG_HIGH_PRIORITY));
                                        j7 += 4;
                                        UnsafeUtil.qn(bArr, j11, (byte) ((codePoint & 63) | NotificationCompat.FLAG_HIGH_PRIORITY));
                                        i8 = i10;
                                    } else {
                                        i8 = i10;
                                    }
                                }
                                throw new UnpairedSurrogateException(i8 - 1, length);
                            } else if (55296 <= charAt2 && charAt2 <= 57343 && ((i6 = i8 + 1) == length || !Character.isSurrogatePair(charAt2, charSequence.charAt(i6)))) {
                                throw new UnpairedSurrogateException(i8, length);
                            } else {
                                throw new ArrayIndexOutOfBoundsException(str2 + charAt2 + str + j7);
                            }
                        }
                        j6 = j8;
                        j4 = 1;
                    }
                    i8++;
                    str3 = str;
                    str4 = str2;
                    j2 = j4;
                    j8 = j6;
                }
                return (int) j7;
            }
            throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(length - 1) + " at index " + (i + i5));
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x002e, code lost:
            if (com.google.protobuf.UnsafeUtil.f3(r1) > (-65)) goto L16;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0062, code lost:
            if (com.google.protobuf.UnsafeUtil.f3(r1) > (-65)) goto L35;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x00a3, code lost:
            if (com.google.protobuf.UnsafeUtil.f3(r1) > (-65)) goto L55;
         */
        @Override // com.google.protobuf.Utf8.Processor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int xc(int r11, java.nio.ByteBuffer r12, int r13, int r14) {
            /*
                Method dump skipped, instructions count: 212
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.UnsafeProcessor.xc(int, java.nio.ByteBuffer, int, int):int");
        }
    }

    static {
        Processor safeProcessor;
        if (UnsafeProcessor.w() && !Android.zn()) {
            safeProcessor = new UnsafeProcessor();
        } else {
            safeProcessor = new SafeProcessor();
        }
        y = safeProcessor;
    }

    public static int c5(CharSequence charSequence, byte[] bArr, int i, int i5) {
        return y.v(charSequence, bArr, i, i5);
    }

    public static boolean co(ByteBuffer byteBuffer) {
        return y.c5(byteBuffer, byteBuffer.position(), byteBuffer.remaining());
    }

    public static int f(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        while (i < length && charSequence.charAt(i) < 128) {
            i++;
        }
        int i5 = length;
        while (true) {
            if (i < length) {
                char charAt = charSequence.charAt(i);
                if (charAt < 2048) {
                    i5 += (127 - charAt) >>> 31;
                    i++;
                } else {
                    i5 += t(charSequence, i);
                    break;
                }
            } else {
                break;
            }
        }
        if (i5 >= length) {
            return i5;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (i5 + 4294967296L));
    }

    public static String fb(ByteBuffer byteBuffer, int i, int i5) throws InvalidProtocolBufferException {
        return y.y(byteBuffer, i, i5);
    }

    public static int i4(int i, byte[] bArr, int i5, int i6) {
        return y.t(i, bArr, i5, i6);
    }

    public static void i9(CharSequence charSequence, ByteBuffer byteBuffer) {
        y.a(charSequence, byteBuffer);
    }

    public static int mt(byte[] bArr, int i, int i5) {
        byte b2 = bArr[i - 1];
        int i6 = i5 - i;
        if (i6 != 0) {
            if (i6 != 1) {
                if (i6 == 2) {
                    return w(b2, bArr[i], bArr[i + 1]);
                }
                throw new AssertionError();
            }
            return xc(b2, bArr[i]);
        }
        return wz(b2);
    }

    public static int p(ByteBuffer byteBuffer, int i, int i5, int i6) {
        if (i6 != 0) {
            if (i6 != 1) {
                if (i6 == 2) {
                    return w(i, byteBuffer.get(i5), byteBuffer.get(i5 + 1));
                }
                throw new AssertionError();
            }
            return xc(i, byteBuffer.get(i5));
        }
        return wz(i);
    }

    public static boolean r(byte[] bArr, int i, int i5) {
        return y.i9(bArr, i, i5);
    }

    public static String s(byte[] bArr, int i, int i5) throws InvalidProtocolBufferException {
        return y.n3(bArr, i, i5);
    }

    public static int t(CharSequence charSequence, int i) {
        int length = charSequence.length();
        int i5 = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            if (charAt < 2048) {
                i5 += (127 - charAt) >>> 31;
            } else {
                i5 += 2;
                if (55296 <= charAt && charAt <= 57343) {
                    if (Character.codePointAt(charSequence, i) >= 65536) {
                        i++;
                    } else {
                        throw new UnpairedSurrogateException(i, length);
                    }
                }
            }
            i++;
        }
        return i5;
    }

    public static int tl(ByteBuffer byteBuffer, int i, int i5) {
        int i6 = i5 - 7;
        int i8 = i;
        while (i8 < i6 && (byteBuffer.getLong(i8) & (-9187201950435737472L)) == 0) {
            i8 += 8;
        }
        return i8 - i;
    }

    public static int w(int i, int i5, int i6) {
        if (i > -12 || i5 > -65 || i6 > -65) {
            return -1;
        }
        return (i ^ (i5 << 8)) ^ (i6 << 16);
    }

    public static int wz(int i) {
        if (i > -12) {
            return -1;
        }
        return i;
    }

    public static int x4(int i, ByteBuffer byteBuffer, int i5, int i6) {
        return y.f(i, byteBuffer, i5, i6);
    }

    public static int xc(int i, int i5) {
        if (i > -12 || i5 > -65) {
            return -1;
        }
        return i ^ (i5 << 8);
    }

    public static boolean z(byte[] bArr) {
        return y.i9(bArr, 0, bArr.length);
    }
}
