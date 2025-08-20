package com.google.android.exoplayer2.drm;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.i9;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kx.d0;
import kx.j5;
import kx.p;
import kx.tl;
import kx.xc;
import z0.f3;
/* loaded from: classes.dex */
public final class t implements tl {

    /* renamed from: gv  reason: collision with root package name */
    public final Map<String, String> f4164gv;
    @Nullable

    /* renamed from: n3  reason: collision with root package name */
    public final String f4165n3;
    public final tl.y y;

    /* renamed from: zn  reason: collision with root package name */
    public final boolean f4166zn;

    public t(@Nullable String str, boolean z2, tl.y yVar) {
        boolean z3;
        if (z2 && TextUtils.isEmpty(str)) {
            z3 = false;
        } else {
            z3 = true;
        }
        v5.y.y(z3);
        this.y = yVar;
        this.f4165n3 = str;
        this.f4166zn = z2;
        this.f4164gv = new HashMap();
    }

    @Nullable
    public static String gv(d0.v vVar, int i) {
        Map<String, List<String>> map;
        List<String> list;
        int i5 = vVar.responseCode;
        if ((i5 != 307 && i5 != 308) || i >= 5 || (map = vVar.headerFields) == null || (list = map.get("Location")) == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static byte[] zn(tl.y yVar, String str, @Nullable byte[] bArr, Map<String, String> map) throws f8.d0 {
        j5 j5Var = new j5(yVar.y());
        p y = new p.n3().i9(str).v(map).gv(2).zn(bArr).n3(1).y();
        int i = 0;
        p pVar = y;
        while (true) {
            try {
                xc xcVar = new xc(j5Var, pVar);
                try {
                    byte[] vn2 = v5.j5.vn(xcVar);
                    v5.j5.wz(xcVar);
                    return vn2;
                } catch (d0.v e2) {
                    String gv2 = gv(e2, i);
                    if (gv2 != null) {
                        i++;
                        pVar = pVar.y().i9(gv2).y();
                        v5.j5.wz(xcVar);
                    } else {
                        throw e2;
                    }
                }
            } catch (Exception e3) {
                throw new f8.d0(y, (Uri) v5.y.v(j5Var.c5()), j5Var.fb(), j5Var.a(), e3);
            }
        }
    }

    @Override // com.google.android.exoplayer2.drm.tl
    public byte[] n3(UUID uuid, i9.y yVar) throws f8.d0 {
        String str;
        String n32 = yVar.n3();
        if (this.f4166zn || TextUtils.isEmpty(n32)) {
            n32 = this.f4165n3;
        }
        if (!TextUtils.isEmpty(n32)) {
            HashMap hashMap = new HashMap();
            UUID uuid2 = m1.c5.f10606v;
            if (uuid2.equals(uuid)) {
                str = "text/xml";
            } else if (m1.c5.f10607zn.equals(uuid)) {
                str = "application/json";
            } else {
                str = "application/octet-stream";
            }
            hashMap.put("Content-Type", str);
            if (uuid2.equals(uuid)) {
                hashMap.put("SOAPAction", "http://schemas.microsoft.com/DRM/2007/03/protocols/AcquireLicense");
            }
            synchronized (this.f4164gv) {
                hashMap.putAll(this.f4164gv);
            }
            return zn(this.y, n32, yVar.y(), hashMap);
        }
        p.n3 n3Var = new p.n3();
        Uri uri = Uri.EMPTY;
        throw new f8.d0(n3Var.c5(uri).y(), uri, f3.x4(), 0L, new IllegalStateException("No license URL"));
    }

    public void v(String str, String str2) {
        v5.y.v(str);
        v5.y.v(str2);
        synchronized (this.f4164gv) {
            this.f4164gv.put(str, str2);
        }
    }

    @Override // com.google.android.exoplayer2.drm.tl
    public byte[] y(UUID uuid, i9.gv gvVar) throws f8.d0 {
        return zn(this.y, gvVar.n3() + "&signedRequest=" + v5.j5.mg(gvVar.y()), null, Collections.emptyMap());
    }
}
