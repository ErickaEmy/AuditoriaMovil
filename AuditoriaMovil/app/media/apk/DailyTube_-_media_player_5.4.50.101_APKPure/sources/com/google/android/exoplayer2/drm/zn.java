package com.google.android.exoplayer2.drm;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.n3;
import f8.r;
import java.util.Map;
import kx.tl;
import kx.x4;
import m1.o0;
import v5.j5;
import z0.en;
/* loaded from: classes.dex */
public final class zn implements r {
    @Nullable

    /* renamed from: gv  reason: collision with root package name */
    public tl.y f4199gv;

    /* renamed from: n3  reason: collision with root package name */
    public o0.a f4200n3;
    @Nullable

    /* renamed from: v  reason: collision with root package name */
    public String f4201v;
    public final Object y = new Object();

    /* renamed from: zn  reason: collision with root package name */
    public a f4202zn;

    public final a n3(o0.a aVar) {
        String uri;
        tl.y yVar = this.f4199gv;
        if (yVar == null) {
            yVar = new x4.n3().v(this.f4201v);
        }
        Uri uri2 = aVar.f11033zn;
        if (uri2 == null) {
            uri = null;
        } else {
            uri = uri2.toString();
        }
        t tVar = new t(uri, aVar.f11031s, yVar);
        en<Map.Entry<String, String>> it = aVar.f11032v.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> next = it.next();
            tVar.v(next.getKey(), next.getValue());
        }
        n3 y = new n3.C0044n3().v(aVar.y, f.f4122gv).n3(aVar.f11024a).zn(aVar.f11027fb).gv(d1.a.wz(aVar.f11029i9)).y(tVar);
        y.ta(0, aVar.zn());
        return y;
    }

    @Override // f8.r
    public a y(o0 o0Var) {
        a aVar;
        v5.y.v(o0Var.f11022v);
        o0.a aVar2 = o0Var.f11022v.f11086zn;
        if (aVar2 != null && j5.y >= 18) {
            synchronized (this.y) {
                try {
                    if (!j5.zn(aVar2, this.f4200n3)) {
                        this.f4200n3 = aVar2;
                        this.f4202zn = n3(aVar2);
                    }
                    aVar = (a) v5.y.v(this.f4202zn);
                } catch (Throwable th) {
                    throw th;
                }
            }
            return aVar;
        }
        return a.y;
    }
}
