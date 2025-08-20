package com.google.android.exoplayer2.drm;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.gv;
import com.google.android.exoplayer2.drm.v;
import java.util.Map;
import java.util.UUID;
/* loaded from: classes.dex */
public final class c5 implements gv {
    public final gv.y y;

    public c5(gv.y yVar) {
        this.y = (gv.y) v5.y.v(yVar);
    }

    @Override // com.google.android.exoplayer2.drm.gv
    @Nullable
    public Map<String, String> a() {
        return null;
    }

    @Override // com.google.android.exoplayer2.drm.gv
    public boolean fb(String str) {
        return false;
    }

    @Override // com.google.android.exoplayer2.drm.gv
    @Nullable
    public gv.y getError() {
        return this.y;
    }

    @Override // com.google.android.exoplayer2.drm.gv
    public int getState() {
        return 1;
    }

    @Override // com.google.android.exoplayer2.drm.gv
    public boolean gv() {
        return false;
    }

    @Override // com.google.android.exoplayer2.drm.gv
    public void n3(@Nullable v.y yVar) {
    }

    @Override // com.google.android.exoplayer2.drm.gv
    @Nullable
    public a9.n3 v() {
        return null;
    }

    @Override // com.google.android.exoplayer2.drm.gv
    public void y(@Nullable v.y yVar) {
    }

    @Override // com.google.android.exoplayer2.drm.gv
    public final UUID zn() {
        return m1.c5.y;
    }
}
