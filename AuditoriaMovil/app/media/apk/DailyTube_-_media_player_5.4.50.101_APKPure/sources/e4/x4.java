package e4;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.flac.PictureFrame;
import java.util.Collections;
import java.util.List;
import m1.m;
import v5.j5;
/* loaded from: classes.dex */
public final class x4 {

    /* renamed from: a  reason: collision with root package name */
    public final int f7523a;

    /* renamed from: c5  reason: collision with root package name */
    public final int f7524c5;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public final y f7525f;

    /* renamed from: fb  reason: collision with root package name */
    public final int f7526fb;

    /* renamed from: gv  reason: collision with root package name */
    public final int f7527gv;

    /* renamed from: i9  reason: collision with root package name */
    public final long f7528i9;

    /* renamed from: n3  reason: collision with root package name */
    public final int f7529n3;

    /* renamed from: s  reason: collision with root package name */
    public final int f7530s;
    @Nullable

    /* renamed from: t  reason: collision with root package name */
    public final Metadata f7531t;

    /* renamed from: v  reason: collision with root package name */
    public final int f7532v;
    public final int y;

    /* renamed from: zn  reason: collision with root package name */
    public final int f7533zn;

    /* loaded from: classes.dex */
    public static class y {

        /* renamed from: n3  reason: collision with root package name */
        public final long[] f7534n3;
        public final long[] y;

        public y(long[] jArr, long[] jArr2) {
            this.y = jArr;
            this.f7534n3 = jArr2;
        }
    }

    public x4(byte[] bArr, int i) {
        v5.fh fhVar = new v5.fh(bArr);
        fhVar.w(i * 8);
        this.y = fhVar.s(16);
        this.f7529n3 = fhVar.s(16);
        this.f7533zn = fhVar.s(24);
        this.f7527gv = fhVar.s(24);
        int s2 = fhVar.s(20);
        this.f7532v = s2;
        this.f7523a = i9(s2);
        this.f7526fb = fhVar.s(3) + 1;
        int s3 = fhVar.s(5) + 1;
        this.f7530s = s3;
        this.f7524c5 = v(s3);
        this.f7528i9 = fhVar.i9(36);
        this.f7525f = null;
        this.f7531t = null;
    }

    public static int i9(int i) {
        switch (i) {
            case 8000:
                return 4;
            case 16000:
                return 5;
            case 22050:
                return 6;
            case 24000:
                return 7;
            case 32000:
                return 8;
            case 44100:
                return 9;
            case 48000:
                return 10;
            case 88200:
                return 1;
            case 96000:
                return 11;
            case 176400:
                return 2;
            case 192000:
                return 3;
            default:
                return -1;
        }
    }

    public static int v(int i) {
        if (i != 8) {
            if (i != 12) {
                if (i != 16) {
                    if (i != 20) {
                        if (i != 24) {
                            return -1;
                        }
                        return 6;
                    }
                    return 5;
                }
                return 4;
            }
            return 2;
        }
        return 1;
    }

    public long a() {
        long j2 = this.f7528i9;
        if (j2 == 0) {
            return -9223372036854775807L;
        }
        return (j2 * 1000000) / this.f7532v;
    }

    public long c5(long j2) {
        return j5.mt((j2 * this.f7532v) / 1000000, 0L, this.f7528i9 - 1);
    }

    public m fb(byte[] bArr, @Nullable Metadata metadata) {
        bArr[4] = Byte.MIN_VALUE;
        int i = this.f7527gv;
        if (i <= 0) {
            i = -1;
        }
        return new m.n3().o4("audio/flac").f7(i).a8(this.f7526fb).rs(this.f7532v).ut(Collections.singletonList(bArr)).en(s(metadata)).z6();
    }

    public long gv() {
        long j2;
        long j4;
        long j6;
        int i = this.f7527gv;
        if (i > 0) {
            j4 = (i + this.f7533zn) / 2;
            j6 = 1;
        } else {
            int i5 = this.y;
            if (i5 == this.f7529n3 && i5 > 0) {
                j2 = i5;
            } else {
                j2 = 4096;
            }
            j4 = ((j2 * this.f7526fb) * this.f7530s) / 8;
            j6 = 64;
        }
        return j4 + j6;
    }

    public x4 n3(@Nullable y yVar) {
        return new x4(this.y, this.f7529n3, this.f7533zn, this.f7527gv, this.f7532v, this.f7526fb, this.f7530s, this.f7528i9, yVar, this.f7531t);
    }

    @Nullable
    public Metadata s(@Nullable Metadata metadata) {
        Metadata metadata2 = this.f7531t;
        if (metadata2 != null) {
            return metadata2.n3(metadata);
        }
        return metadata;
    }

    public x4 y(List<PictureFrame> list) {
        return new x4(this.y, this.f7529n3, this.f7533zn, this.f7527gv, this.f7532v, this.f7526fb, this.f7530s, this.f7528i9, this.f7525f, s(new Metadata(list)));
    }

    public x4 zn(List<String> list) {
        return new x4(this.y, this.f7529n3, this.f7533zn, this.f7527gv, this.f7532v, this.f7526fb, this.f7530s, this.f7528i9, this.f7525f, s(ej.zn(list)));
    }

    public x4(int i, int i5, int i6, int i8, int i10, int i11, int i12, long j2, @Nullable y yVar, @Nullable Metadata metadata) {
        this.y = i;
        this.f7529n3 = i5;
        this.f7533zn = i6;
        this.f7527gv = i8;
        this.f7532v = i10;
        this.f7523a = i9(i10);
        this.f7526fb = i11;
        this.f7530s = i12;
        this.f7524c5 = v(i12);
        this.f7528i9 = j2;
        this.f7525f = yVar;
        this.f7531t = metadata;
    }
}
