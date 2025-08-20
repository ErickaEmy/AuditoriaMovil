package com.google.android.exoplayer2.drm;

import android.media.MediaDrmException;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.i9;
import f8.x4;
import fj.u0;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public final class s implements i9 {
    @Override // com.google.android.exoplayer2.drm.i9
    public void a(@Nullable i9.n3 n3Var) {
    }

    @Override // com.google.android.exoplayer2.drm.i9
    public a9.n3 c5(byte[] bArr) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.drm.i9
    public void f(byte[] bArr) {
    }

    @Override // com.google.android.exoplayer2.drm.i9
    public void fb(byte[] bArr) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.drm.i9
    public byte[] gv() throws MediaDrmException {
        throw new MediaDrmException("Attempting to open a session using a dummy ExoMediaDrm.");
    }

    @Override // com.google.android.exoplayer2.drm.i9
    public boolean i9(byte[] bArr, String str) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.drm.i9
    public Map<String, String> n3(byte[] bArr) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.drm.i9
    public void release() {
    }

    @Override // com.google.android.exoplayer2.drm.i9
    public int s() {
        return 1;
    }

    @Override // com.google.android.exoplayer2.drm.i9
    @Nullable
    public byte[] t(byte[] bArr, byte[] bArr2) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.drm.i9
    public i9.y tl(byte[] bArr, @Nullable List<DrmInitData.SchemeData> list, int i, @Nullable HashMap<String, String> hashMap) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.drm.i9
    public void v(byte[] bArr, byte[] bArr2) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.drm.i9
    public /* synthetic */ void y(byte[] bArr, u0 u0Var) {
        x4.y(this, bArr, u0Var);
    }

    @Override // com.google.android.exoplayer2.drm.i9
    public i9.gv zn() {
        throw new IllegalStateException();
    }
}
