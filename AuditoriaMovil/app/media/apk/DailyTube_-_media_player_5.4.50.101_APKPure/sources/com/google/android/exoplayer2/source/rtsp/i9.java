package com.google.android.exoplayer2.source.rtsp;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.source.rtsp.fb;
import java.util.Arrays;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import kx.p;
import v5.j5;
/* loaded from: classes.dex */
public final class i9 extends kx.fb implements y, fb.n3 {

    /* renamed from: a  reason: collision with root package name */
    public final long f4630a;

    /* renamed from: fb  reason: collision with root package name */
    public byte[] f4631fb;

    /* renamed from: s  reason: collision with root package name */
    public int f4632s;

    /* renamed from: v  reason: collision with root package name */
    public final LinkedBlockingQueue<byte[]> f4633v;

    public i9(long j2) {
        super(true);
        this.f4630a = j2;
        this.f4633v = new LinkedBlockingQueue<>();
        this.f4631fb = new byte[0];
        this.f4632s = -1;
    }

    @Override // com.google.android.exoplayer2.source.rtsp.fb.n3
    public void c5(byte[] bArr) {
        this.f4633v.add(bArr);
    }

    @Override // kx.tl
    public void close() {
    }

    @Override // com.google.android.exoplayer2.source.rtsp.y
    public int gv() {
        return this.f4632s;
    }

    @Override // kx.tl
    @Nullable
    public Uri n3() {
        return null;
    }

    @Override // kx.c5
    public int read(byte[] bArr, int i, int i5) {
        if (i5 == 0) {
            return 0;
        }
        int min = Math.min(i5, this.f4631fb.length);
        System.arraycopy(this.f4631fb, 0, bArr, i, min);
        byte[] bArr2 = this.f4631fb;
        this.f4631fb = Arrays.copyOfRange(bArr2, min, bArr2.length);
        if (min == i5) {
            return min;
        }
        try {
            byte[] poll = this.f4633v.poll(this.f4630a, TimeUnit.MILLISECONDS);
            if (poll == null) {
                return -1;
            }
            int min2 = Math.min(i5 - min, poll.length);
            System.arraycopy(poll, 0, bArr, i + min, min2);
            if (min2 < poll.length) {
                this.f4631fb = Arrays.copyOfRange(poll, min2, poll.length);
            }
            return min + min2;
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            return -1;
        }
    }

    @Override // com.google.android.exoplayer2.source.rtsp.y
    public fb.n3 tl() {
        return this;
    }

    @Override // kx.tl
    public long y(p pVar) {
        this.f4632s = pVar.y.getPort();
        return -1L;
    }

    @Override // com.google.android.exoplayer2.source.rtsp.y
    public String zn() {
        boolean z2;
        if (this.f4632s != -1) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.fb(z2);
        return j5.rz("RTP/AVP/TCP;unicast;interleaved=%d-%d", Integer.valueOf(this.f4632s), Integer.valueOf(this.f4632s + 1));
    }
}
