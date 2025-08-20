package j0;

import android.util.Pair;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public final class u0 {
    public static ByteBuffer a(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer.remaining() >= 4) {
            int i = byteBuffer.getInt();
            if (i >= 0) {
                if (i <= byteBuffer.remaining()) {
                    return v(byteBuffer, i);
                }
                int remaining = byteBuffer.remaining();
                StringBuilder sb = new StringBuilder(101);
                sb.append("Length-prefixed field longer than remaining buffer. Field length: ");
                sb.append(i);
                sb.append(", remaining: ");
                sb.append(remaining);
                throw new IOException(sb.toString());
            }
            throw new IllegalArgumentException("Negative length");
        }
        int remaining2 = byteBuffer.remaining();
        StringBuilder sb2 = new StringBuilder(93);
        sb2.append("Remaining buffer too short to contain length of length-prefixed field. Remaining: ");
        sb2.append(remaining2);
        throw new IOException(sb2.toString());
    }

    public static byte[] c5(ByteBuffer byteBuffer) throws IOException {
        int i = byteBuffer.getInt();
        if (i >= 0) {
            if (i <= byteBuffer.remaining()) {
                byte[] bArr = new byte[i];
                byteBuffer.get(bArr);
                return bArr;
            }
            int remaining = byteBuffer.remaining();
            StringBuilder sb = new StringBuilder(90);
            sb.append("Underflow while reading length-prefixed value. Length: ");
            sb.append(i);
            sb.append(", available: ");
            sb.append(remaining);
            throw new IOException(sb.toString());
        }
        throw new IOException("Negative length");
    }

    public static byte[][] f(int[] iArr, k[] kVarArr) throws DigestException {
        long j2;
        int i;
        int length;
        long j4 = 0;
        int i5 = 0;
        long j6 = 0;
        int i6 = 0;
        while (true) {
            j2 = 1048576;
            if (i6 >= 3) {
                break;
            }
            j6 += (kVarArr[i6].zza() + 1048575) / 1048576;
            i6++;
        }
        if (j6 < 2097151) {
            int i8 = (int) j6;
            byte[][] bArr = new byte[iArr.length];
            int i10 = 0;
            while (true) {
                length = iArr.length;
                if (i10 >= length) {
                    break;
                }
                byte[] bArr2 = new byte[(n3(iArr[i10]) * i8) + 5];
                bArr2[0] = 90;
                fb(i8, bArr2, 1);
                bArr[i10] = bArr2;
                i10++;
            }
            byte[] bArr3 = new byte[5];
            bArr3[0] = -91;
            MessageDigest[] messageDigestArr = new MessageDigest[length];
            for (int i11 = 0; i11 < iArr.length; i11++) {
                String gv2 = gv(iArr[i11]);
                try {
                    messageDigestArr[i11] = MessageDigest.getInstance(gv2);
                } catch (NoSuchAlgorithmException e2) {
                    throw new RuntimeException(gv2.concat(" digest not supported"), e2);
                }
            }
            int i12 = 0;
            int i13 = 0;
            for (i = 3; i12 < i; i = 3) {
                k kVar = kVarArr[i12];
                long j7 = j4;
                long zza = kVar.zza();
                while (zza > j4) {
                    int min = (int) Math.min(zza, j2);
                    fb(min, bArr3, 1);
                    for (int i14 = 0; i14 < length; i14++) {
                        messageDigestArr[i14].update(bArr3);
                    }
                    long j8 = j7;
                    try {
                        kVar.zzb(messageDigestArr, j8, min);
                        byte[] bArr4 = bArr3;
                        int i15 = 0;
                        while (i15 < iArr.length) {
                            int i16 = iArr[i15];
                            k kVar2 = kVar;
                            byte[] bArr5 = bArr[i15];
                            int n32 = n3(i16);
                            int i17 = length;
                            MessageDigest messageDigest = messageDigestArr[i15];
                            MessageDigest[] messageDigestArr2 = messageDigestArr;
                            int digest = messageDigest.digest(bArr5, (i13 * n32) + 5, n32);
                            if (digest == n32) {
                                i15++;
                                kVar = kVar2;
                                length = i17;
                                messageDigestArr = messageDigestArr2;
                            } else {
                                String algorithm = messageDigest.getAlgorithm();
                                StringBuilder sb = new StringBuilder(String.valueOf(algorithm).length() + 46);
                                sb.append("Unexpected output size of ");
                                sb.append(algorithm);
                                sb.append(" digest: ");
                                sb.append(digest);
                                throw new RuntimeException(sb.toString());
                            }
                        }
                        MessageDigest[] messageDigestArr3 = messageDigestArr;
                        long j9 = min;
                        long j10 = j8 + j9;
                        zza -= j9;
                        i13++;
                        bArr3 = bArr4;
                        j4 = 0;
                        j7 = j10;
                        messageDigestArr = messageDigestArr3;
                        j2 = 1048576;
                    } catch (IOException e3) {
                        StringBuilder sb2 = new StringBuilder(59);
                        sb2.append("Failed to digest chunk #");
                        sb2.append(i13);
                        sb2.append(" of section #");
                        sb2.append(i5);
                        throw new DigestException(sb2.toString(), e3);
                    }
                }
                i5++;
                i12++;
                j4 = 0;
                j2 = 1048576;
            }
            byte[][] bArr6 = new byte[iArr.length];
            for (int i18 = 0; i18 < iArr.length; i18++) {
                int i19 = iArr[i18];
                byte[] bArr7 = bArr[i18];
                String gv3 = gv(i19);
                try {
                    bArr6[i18] = MessageDigest.getInstance(gv3).digest(bArr7);
                } catch (NoSuchAlgorithmException e5) {
                    throw new RuntimeException(gv3.concat(" digest not supported"), e5);
                }
            }
            return bArr6;
        }
        StringBuilder sb3 = new StringBuilder(37);
        sb3.append("Too many chunks: ");
        sb3.append(j6);
        throw new DigestException(sb3.toString());
    }

    public static void fb(int i, byte[] bArr, int i5) {
        bArr[1] = (byte) (i & 255);
        bArr[2] = (byte) ((i >>> 8) & 255);
        bArr[3] = (byte) ((i >>> 16) & 255);
        bArr[4] = (byte) (i >> 24);
    }

    public static String gv(int i) {
        if (i != 1) {
            if (i == 2) {
                return "SHA-512";
            }
            StringBuilder sb = new StringBuilder(44);
            sb.append("Unknown content digest algorthm: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        }
        return "SHA-256";
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0048, code lost:
        r11 = zn(r4);
        r12 = zn(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0050, code lost:
        if (r11 == 1) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0052, code lost:
        if (r12 == 1) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.security.cert.X509Certificate[] i9(java.nio.ByteBuffer r22, java.util.Map r23, java.security.cert.CertificateFactory r24) throws java.lang.SecurityException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 736
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j0.u0.i9(java.nio.ByteBuffer, java.util.Map, java.security.cert.CertificateFactory):java.security.cert.X509Certificate[]");
    }

    public static int n3(int i) {
        if (i != 1) {
            if (i == 2) {
                return 64;
            }
            StringBuilder sb = new StringBuilder(44);
            sb.append("Unknown content digest algorthm: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        }
        return 32;
    }

    public static void s(Map map, FileChannel fileChannel, long j2, long j4, long j6, ByteBuffer byteBuffer) throws SecurityException {
        if (!map.isEmpty()) {
            k kpVar = new kp(fileChannel, 0L, j2);
            k kpVar2 = new kp(fileChannel, j4, j6 - j4);
            ByteBuffer duplicate = byteBuffer.duplicate();
            duplicate.order(ByteOrder.LITTLE_ENDIAN);
            bk.gv(duplicate, j2);
            k i4Var = new i4(duplicate);
            int size = map.size();
            int[] iArr = new int[size];
            int i = 0;
            for (Integer num : map.keySet()) {
                iArr[i] = num.intValue();
                i++;
            }
            try {
                byte[][] f4 = f(iArr, new k[]{kpVar, kpVar2, i4Var});
                for (int i5 = 0; i5 < size; i5++) {
                    int i6 = iArr[i5];
                    if (!MessageDigest.isEqual((byte[]) map.get(Integer.valueOf(i6)), f4[i5])) {
                        throw new SecurityException(gv(i6).concat(" digest of contents did not verify"));
                    }
                }
                return;
            } catch (DigestException e2) {
                throw new SecurityException("Failed to compute digest(s) of contents", e2);
            }
        }
        throw new SecurityException("No digests provided");
    }

    public static X509Certificate[][] t(FileChannel fileChannel, rb rbVar) throws SecurityException {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            try {
                ByteBuffer a2 = a(rb.gv(rbVar));
                int i = 0;
                while (a2.hasRemaining()) {
                    i++;
                    try {
                        arrayList.add(i9(a(a2), hashMap, certificateFactory));
                    } catch (IOException | SecurityException | BufferUnderflowException e2) {
                        StringBuilder sb = new StringBuilder(48);
                        sb.append("Failed to parse/verify signer #");
                        sb.append(i);
                        sb.append(" block");
                        throw new SecurityException(sb.toString(), e2);
                    }
                }
                if (i > 0) {
                    if (!hashMap.isEmpty()) {
                        s(hashMap, fileChannel, rb.y(rbVar), rb.n3(rbVar), rb.zn(rbVar), rb.v(rbVar));
                        return (X509Certificate[][]) arrayList.toArray(new X509Certificate[arrayList.size()]);
                    }
                    throw new SecurityException("No content digests found");
                }
                throw new SecurityException("No signers found");
            } catch (IOException e3) {
                throw new SecurityException("Failed to read list of signers", e3);
            }
        } catch (CertificateException e5) {
            throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e5);
        }
    }

    public static ByteBuffer v(ByteBuffer byteBuffer, int i) throws BufferUnderflowException {
        int limit = byteBuffer.limit();
        int position = byteBuffer.position();
        int i5 = i + position;
        if (i5 >= position && i5 <= limit) {
            byteBuffer.limit(i5);
            try {
                ByteBuffer slice = byteBuffer.slice();
                slice.order(byteBuffer.order());
                byteBuffer.position(i5);
                return slice;
            } finally {
                byteBuffer.limit(limit);
            }
        }
        throw new BufferUnderflowException();
    }

    public static X509Certificate[][] y(String str) throws g3, SecurityException, IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
        try {
            Pair zn2 = bk.zn(randomAccessFile);
            if (zn2 != null) {
                ByteBuffer byteBuffer = (ByteBuffer) zn2.first;
                long longValue = ((Long) zn2.second).longValue();
                long j2 = (-20) + longValue;
                if (j2 >= 0) {
                    randomAccessFile.seek(j2);
                    if (randomAccessFile.readInt() == 1347094023) {
                        throw new g3("ZIP64 APK not supported");
                    }
                }
                long y = bk.y(byteBuffer);
                if (y < longValue) {
                    if (bk.n3(byteBuffer) + y == longValue) {
                        if (y >= 32) {
                            ByteBuffer allocate = ByteBuffer.allocate(24);
                            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                            allocate.order(byteOrder);
                            randomAccessFile.seek(y - allocate.capacity());
                            randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
                            if (allocate.getLong(8) == 2334950737559900225L && allocate.getLong(16) == 3617552046287187010L) {
                                int i = 0;
                                long j4 = allocate.getLong(0);
                                if (j4 >= allocate.capacity() && j4 <= 2147483639) {
                                    int i5 = (int) (8 + j4);
                                    long j6 = y - i5;
                                    if (j6 >= 0) {
                                        ByteBuffer allocate2 = ByteBuffer.allocate(i5);
                                        allocate2.order(byteOrder);
                                        randomAccessFile.seek(j6);
                                        randomAccessFile.readFully(allocate2.array(), allocate2.arrayOffset(), allocate2.capacity());
                                        long j7 = allocate2.getLong(0);
                                        if (j7 == j4) {
                                            Pair create = Pair.create(allocate2, Long.valueOf(j6));
                                            ByteBuffer byteBuffer2 = (ByteBuffer) create.first;
                                            long longValue2 = ((Long) create.second).longValue();
                                            if (byteBuffer2.order() == byteOrder) {
                                                int capacity = byteBuffer2.capacity() - 24;
                                                if (capacity >= 8) {
                                                    int capacity2 = byteBuffer2.capacity();
                                                    if (capacity <= byteBuffer2.capacity()) {
                                                        int limit = byteBuffer2.limit();
                                                        int position = byteBuffer2.position();
                                                        byteBuffer2.position(0);
                                                        byteBuffer2.limit(capacity);
                                                        byteBuffer2.position(8);
                                                        ByteBuffer slice = byteBuffer2.slice();
                                                        slice.order(byteBuffer2.order());
                                                        byteBuffer2.position(0);
                                                        byteBuffer2.limit(limit);
                                                        byteBuffer2.position(position);
                                                        while (slice.hasRemaining()) {
                                                            i++;
                                                            if (slice.remaining() >= 8) {
                                                                long j8 = slice.getLong();
                                                                if (j8 >= 4 && j8 <= 2147483647L) {
                                                                    int i6 = (int) j8;
                                                                    int position2 = slice.position() + i6;
                                                                    if (i6 <= slice.remaining()) {
                                                                        if (slice.getInt() == 1896449818) {
                                                                            X509Certificate[][] t2 = t(randomAccessFile.getChannel(), new rb(v(slice, i6 - 4), longValue2, y, longValue, byteBuffer, (y) null));
                                                                            randomAccessFile.close();
                                                                            try {
                                                                                randomAccessFile.close();
                                                                            } catch (IOException unused) {
                                                                            }
                                                                            return t2;
                                                                        }
                                                                        slice.position(position2);
                                                                    } else {
                                                                        int remaining = slice.remaining();
                                                                        StringBuilder sb = new StringBuilder(91);
                                                                        sb.append("APK Signing Block entry #");
                                                                        sb.append(i);
                                                                        sb.append(" size out of range: ");
                                                                        sb.append(i6);
                                                                        sb.append(", available: ");
                                                                        sb.append(remaining);
                                                                        throw new g3(sb.toString());
                                                                    }
                                                                } else {
                                                                    StringBuilder sb2 = new StringBuilder(76);
                                                                    sb2.append("APK Signing Block entry #");
                                                                    sb2.append(i);
                                                                    sb2.append(" size out of range: ");
                                                                    sb2.append(j8);
                                                                    throw new g3(sb2.toString());
                                                                }
                                                            } else {
                                                                StringBuilder sb3 = new StringBuilder(70);
                                                                sb3.append("Insufficient data to read size of APK Signing Block entry #");
                                                                sb3.append(i);
                                                                throw new g3(sb3.toString());
                                                            }
                                                        }
                                                        throw new g3("No APK Signature Scheme v2 block in APK Signing Block");
                                                    }
                                                    StringBuilder sb4 = new StringBuilder(41);
                                                    sb4.append("end > capacity: ");
                                                    sb4.append(capacity);
                                                    sb4.append(" > ");
                                                    sb4.append(capacity2);
                                                    throw new IllegalArgumentException(sb4.toString());
                                                }
                                                StringBuilder sb5 = new StringBuilder(38);
                                                sb5.append("end < start: ");
                                                sb5.append(capacity);
                                                sb5.append(" < ");
                                                sb5.append(8);
                                                throw new IllegalArgumentException(sb5.toString());
                                            }
                                            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
                                        }
                                        StringBuilder sb6 = new StringBuilder(103);
                                        sb6.append("APK Signing Block sizes in header and footer do not match: ");
                                        sb6.append(j7);
                                        sb6.append(" vs ");
                                        sb6.append(j4);
                                        throw new g3(sb6.toString());
                                    }
                                    StringBuilder sb7 = new StringBuilder(59);
                                    sb7.append("APK Signing Block offset out of range: ");
                                    sb7.append(j6);
                                    throw new g3(sb7.toString());
                                }
                                StringBuilder sb8 = new StringBuilder(57);
                                sb8.append("APK Signing Block size out of range: ");
                                sb8.append(j4);
                                throw new g3(sb8.toString());
                            }
                            throw new g3("No APK Signing Block before ZIP Central Directory");
                        }
                        StringBuilder sb9 = new StringBuilder(87);
                        sb9.append("APK too small for APK Signing Block. ZIP Central Directory offset: ");
                        sb9.append(y);
                        throw new g3(sb9.toString());
                    }
                    throw new g3("ZIP Central Directory is not immediately followed by End of Central Directory");
                }
                StringBuilder sb10 = new StringBuilder(122);
                sb10.append("ZIP Central Directory offset out of range: ");
                sb10.append(y);
                sb10.append(". ZIP End of Central Directory offset: ");
                sb10.append(longValue);
                throw new g3(sb10.toString());
            }
            long length = randomAccessFile.length();
            StringBuilder sb11 = new StringBuilder(102);
            sb11.append("Not an APK file: ZIP End of Central Directory record not found in file with ");
            sb11.append(length);
            sb11.append(" bytes");
            throw new g3(sb11.toString());
        } catch (Throwable th) {
            try {
                randomAccessFile.close();
            } catch (IOException unused2) {
            }
            throw th;
        }
    }

    public static int zn(int i) {
        String str;
        if (i != 513) {
            if (i != 514) {
                if (i != 769) {
                    switch (i) {
                        case 257:
                        case 259:
                            return 1;
                        case 258:
                        case 260:
                            return 2;
                        default:
                            String valueOf = String.valueOf(Long.toHexString(i));
                            if (valueOf.length() != 0) {
                                str = "Unknown signature algorithm: 0x".concat(valueOf);
                            } else {
                                str = new String("Unknown signature algorithm: 0x");
                            }
                            throw new IllegalArgumentException(str);
                    }
                }
                return 1;
            }
            return 2;
        }
        return 1;
    }
}
