package a9;

import android.media.MediaCodec;
import androidx.annotation.Nullable;
import v5.j5;
/* loaded from: classes.dex */
public final class zn {

    /* renamed from: a  reason: collision with root package name */
    public int f87a;

    /* renamed from: c5  reason: collision with root package name */
    public final MediaCodec.CryptoInfo f88c5;

    /* renamed from: fb  reason: collision with root package name */
    public int f89fb;
    @Nullable

    /* renamed from: gv  reason: collision with root package name */
    public int[] f90gv;
    @Nullable

    /* renamed from: i9  reason: collision with root package name */
    public final n3 f91i9;
    @Nullable

    /* renamed from: n3  reason: collision with root package name */
    public byte[] f92n3;

    /* renamed from: s  reason: collision with root package name */
    public int f93s;
    @Nullable

    /* renamed from: v  reason: collision with root package name */
    public int[] f94v;
    @Nullable
    public byte[] y;

    /* renamed from: zn  reason: collision with root package name */
    public int f95zn;

    /* loaded from: classes.dex */
    public static final class n3 {

        /* renamed from: n3  reason: collision with root package name */
        public final MediaCodec.CryptoInfo.Pattern f96n3;
        public final MediaCodec.CryptoInfo y;

        public final void n3(int i, int i5) {
            this.f96n3.set(i, i5);
            this.y.setPattern(this.f96n3);
        }

        public n3(MediaCodec.CryptoInfo cryptoInfo) {
            this.y = cryptoInfo;
            this.f96n3 = new MediaCodec.CryptoInfo.Pattern(0, 0);
        }
    }

    public zn() {
        MediaCodec.CryptoInfo cryptoInfo = new MediaCodec.CryptoInfo();
        this.f88c5 = cryptoInfo;
        this.f91i9 = j5.y >= 24 ? new n3(cryptoInfo) : null;
    }

    public void n3(int i) {
        if (i == 0) {
            return;
        }
        if (this.f90gv == null) {
            int[] iArr = new int[1];
            this.f90gv = iArr;
            this.f88c5.numBytesOfClearData = iArr;
        }
        int[] iArr2 = this.f90gv;
        iArr2[0] = iArr2[0] + i;
    }

    public MediaCodec.CryptoInfo y() {
        return this.f88c5;
    }

    public void zn(int i, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i5, int i6, int i8) {
        this.f87a = i;
        this.f90gv = iArr;
        this.f94v = iArr2;
        this.f92n3 = bArr;
        this.y = bArr2;
        this.f95zn = i5;
        this.f89fb = i6;
        this.f93s = i8;
        MediaCodec.CryptoInfo cryptoInfo = this.f88c5;
        cryptoInfo.numSubSamples = i;
        cryptoInfo.numBytesOfClearData = iArr;
        cryptoInfo.numBytesOfEncryptedData = iArr2;
        cryptoInfo.key = bArr;
        cryptoInfo.iv = bArr2;
        cryptoInfo.mode = i5;
        if (j5.y >= 24) {
            ((n3) v5.y.v(this.f91i9)).n3(i6, i8);
        }
    }
}
