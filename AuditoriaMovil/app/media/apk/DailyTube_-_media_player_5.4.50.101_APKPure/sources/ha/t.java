package ha;

import androidx.annotation.Nullable;
import java.nio.ByteBuffer;
import java.util.UUID;
import v5.r;
import v5.rz;
/* loaded from: classes.dex */
public final class t {

    /* loaded from: classes.dex */
    public static class y {

        /* renamed from: n3  reason: collision with root package name */
        public final int f8892n3;
        public final UUID y;

        /* renamed from: zn  reason: collision with root package name */
        public final byte[] f8893zn;

        public y(UUID uuid, int i, byte[] bArr) {
            this.y = uuid;
            this.f8892n3 = i;
            this.f8893zn = bArr;
        }
    }

    @Nullable
    public static UUID a(byte[] bArr) {
        y gv2 = gv(bArr);
        if (gv2 != null) {
            return gv2.y;
        }
        return null;
    }

    public static int fb(byte[] bArr) {
        y gv2 = gv(bArr);
        if (gv2 != null) {
            return gv2.f8892n3;
        }
        return -1;
    }

    @Nullable
    public static y gv(byte[] bArr) {
        rz rzVar = new rz(bArr);
        if (rzVar.fb() < 32) {
            return null;
        }
        rzVar.oz(0);
        if (rzVar.p() != rzVar.y() + 4 || rzVar.p() != 1886614376) {
            return null;
        }
        int zn2 = ha.y.zn(rzVar.p());
        if (zn2 > 1) {
            r.c5("PsshAtomUtil", "Unsupported pssh version: " + zn2);
            return null;
        }
        UUID uuid = new UUID(rzVar.d0(), rzVar.d0());
        if (zn2 == 1) {
            rzVar.ut(rzVar.b() * 16);
        }
        int b2 = rzVar.b();
        if (b2 != rzVar.y()) {
            return null;
        }
        byte[] bArr2 = new byte[b2];
        rzVar.t(bArr2, 0, b2);
        return new y(uuid, zn2, bArr2);
    }

    public static byte[] n3(UUID uuid, @Nullable UUID[] uuidArr, @Nullable byte[] bArr) {
        int i;
        int i5;
        if (bArr != null) {
            i = bArr.length;
        } else {
            i = 0;
        }
        int i6 = i + 32;
        if (uuidArr != null) {
            i6 += (uuidArr.length * 16) + 4;
        }
        ByteBuffer allocate = ByteBuffer.allocate(i6);
        allocate.putInt(i6);
        allocate.putInt(1886614376);
        if (uuidArr != null) {
            i5 = 16777216;
        } else {
            i5 = 0;
        }
        allocate.putInt(i5);
        allocate.putLong(uuid.getMostSignificantBits());
        allocate.putLong(uuid.getLeastSignificantBits());
        if (uuidArr != null) {
            allocate.putInt(uuidArr.length);
            for (UUID uuid2 : uuidArr) {
                allocate.putLong(uuid2.getMostSignificantBits());
                allocate.putLong(uuid2.getLeastSignificantBits());
            }
        }
        if (bArr != null && bArr.length != 0) {
            allocate.putInt(bArr.length);
            allocate.put(bArr);
        }
        return allocate.array();
    }

    @Nullable
    public static byte[] v(byte[] bArr, UUID uuid) {
        y gv2 = gv(bArr);
        if (gv2 == null) {
            return null;
        }
        if (uuid.equals(gv2.y)) {
            return gv2.f8893zn;
        }
        r.c5("PsshAtomUtil", "UUID mismatch. Expected: " + uuid + ", got: " + gv2.y + ".");
        return null;
    }

    public static byte[] y(UUID uuid, @Nullable byte[] bArr) {
        return n3(uuid, null, bArr);
    }

    public static boolean zn(byte[] bArr) {
        if (gv(bArr) != null) {
            return true;
        }
        return false;
    }
}
