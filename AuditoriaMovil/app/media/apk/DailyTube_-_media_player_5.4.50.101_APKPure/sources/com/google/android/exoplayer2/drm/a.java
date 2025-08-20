package com.google.android.exoplayer2.drm;

import android.os.Looper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.gv;
import com.google.android.exoplayer2.drm.v;
import f8.fh;
import f8.mt;
import fj.u0;
import m1.m;
/* loaded from: classes.dex */
public interface a {
    @Deprecated

    /* renamed from: n3  reason: collision with root package name */
    public static final a f4121n3;
    public static final a y;

    /* loaded from: classes.dex */
    public interface n3 {
        public static final n3 y = new n3() { // from class: f8.co
            @Override // com.google.android.exoplayer2.drm.a.n3
            public final void release() {
                z.y();
            }
        };

        void release();
    }

    static {
        y yVar = new y();
        y = yVar;
        f4121n3 = yVar;
    }

    void gv(Looper looper, u0 u0Var);

    int n3(m mVar);

    void prepare();

    void release();

    @Nullable
    gv y(@Nullable v.y yVar, m mVar);

    n3 zn(@Nullable v.y yVar, m mVar);

    /* loaded from: classes.dex */
    public class y implements a {
        @Override // com.google.android.exoplayer2.drm.a
        public int n3(m mVar) {
            if (mVar.f10944d0 != null) {
                return 1;
            }
            return 0;
        }

        @Override // com.google.android.exoplayer2.drm.a
        public /* synthetic */ void prepare() {
            mt.n3(this);
        }

        @Override // com.google.android.exoplayer2.drm.a
        public /* synthetic */ void release() {
            mt.zn(this);
        }

        @Override // com.google.android.exoplayer2.drm.a
        @Nullable
        public gv y(@Nullable v.y yVar, m mVar) {
            if (mVar.f10944d0 == null) {
                return null;
            }
            return new c5(new gv.y(new fh(1), 6001));
        }

        @Override // com.google.android.exoplayer2.drm.a
        public /* synthetic */ n3 zn(v.y yVar, m mVar) {
            return mt.y(this, yVar, mVar);
        }

        @Override // com.google.android.exoplayer2.drm.a
        public void gv(Looper looper, u0 u0Var) {
        }
    }
}
