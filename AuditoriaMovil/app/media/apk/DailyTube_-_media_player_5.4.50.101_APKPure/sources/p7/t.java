package p7;

import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.Arrays;
import kx.p;
import m1.m;
import v5.j5;
/* loaded from: classes.dex */
public abstract class t extends a {

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f12485f;

    /* renamed from: i9  reason: collision with root package name */
    public byte[] f12486i9;

    public t(kx.tl tlVar, p pVar, int i, m mVar, int i5, @Nullable Object obj, @Nullable byte[] bArr) {
        super(tlVar, pVar, i, mVar, i5, obj, -9223372036854775807L, -9223372036854775807L);
        t tVar;
        byte[] bArr2;
        if (bArr == null) {
            bArr2 = j5.f14357a;
            tVar = this;
        } else {
            tVar = this;
            bArr2 = bArr;
        }
        tVar.f12486i9 = bArr2;
    }

    public abstract void a(byte[] bArr, int i) throws IOException;

    public byte[] fb() {
        return this.f12486i9;
    }

    @Override // kx.ta.v
    public final void load() throws IOException {
        try {
            this.f12442c5.y(this.f12445n3);
            int i = 0;
            int i5 = 0;
            while (i != -1 && !this.f12485f) {
                s(i5);
                i = this.f12442c5.read(this.f12486i9, i5, 16384);
                if (i != -1) {
                    i5 += i;
                }
            }
            if (!this.f12485f) {
                a(this.f12486i9, i5);
            }
            kx.w.y(this.f12442c5);
        } catch (Throwable th) {
            kx.w.y(this.f12442c5);
            throw th;
        }
    }

    @Override // kx.ta.v
    public final void n3() {
        this.f12485f = true;
    }

    public final void s(int i) {
        byte[] bArr = this.f12486i9;
        if (bArr.length < i + 16384) {
            this.f12486i9 = Arrays.copyOf(bArr, bArr.length + 16384);
        }
    }
}
