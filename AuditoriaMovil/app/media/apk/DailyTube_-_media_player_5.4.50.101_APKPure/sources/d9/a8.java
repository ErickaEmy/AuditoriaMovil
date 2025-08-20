package d9;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a8 {
    public static int a(byte[] bArr) {
        return (bArr[10] & 255) | ((bArr[11] & 255) << 8);
    }

    public static int fb(ByteBuffer byteBuffer) {
        byte b2 = 0;
        byte b3 = byteBuffer.get(0);
        if (byteBuffer.limit() > 1) {
            b2 = byteBuffer.get(1);
        }
        return (int) ((gv(b3, b2) * 48000) / 1000000);
    }

    public static long gv(byte b2, byte b3) {
        int i;
        int i5;
        int i6 = b2 & 255;
        int i8 = b2 & 3;
        if (i8 != 0) {
            i = 2;
            if (i8 != 1 && i8 != 2) {
                i = b3 & 63;
            }
        } else {
            i = 1;
        }
        int i10 = i6 >> 3;
        int i11 = i10 & 3;
        if (i10 >= 16) {
            i5 = 2500 << i11;
        } else if (i10 >= 12) {
            i5 = 10000 << (i10 & 1);
        } else if (i11 == 3) {
            i5 = 60000;
        } else {
            i5 = 10000 << i11;
        }
        return i * i5;
    }

    public static byte[] n3(long j2) {
        return ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(j2).array();
    }

    public static long s(long j2) {
        return (j2 * 1000000000) / 48000;
    }

    public static long v(byte[] bArr) {
        byte b2 = 0;
        byte b3 = bArr[0];
        if (bArr.length > 1) {
            b2 = bArr[1];
        }
        return gv(b3, b2);
    }

    public static List<byte[]> y(byte[] bArr) {
        long s2 = s(a(bArr));
        long s3 = s(3840L);
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(bArr);
        arrayList.add(n3(s2));
        arrayList.add(n3(s3));
        return arrayList;
    }

    public static int zn(byte[] bArr) {
        return bArr[9] & 255;
    }
}
