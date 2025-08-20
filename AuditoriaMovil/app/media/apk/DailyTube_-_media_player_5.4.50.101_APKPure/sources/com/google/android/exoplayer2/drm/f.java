package com.google.android.exoplayer2.drm;

import android.annotation.SuppressLint;
import android.media.DeniedByServerException;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaDrm;
import android.media.MediaDrmException;
import android.media.NotProvisionedException;
import android.media.UnsupportedSchemeException;
import android.media.metrics.LogSessionId;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.i9;
import f8.fh;
import f8.i4;
import fj.u0;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import v5.j5;
import v5.r;
import v5.rz;
/* loaded from: classes.dex */
public final class f implements i9 {

    /* renamed from: gv  reason: collision with root package name */
    public static final i9.zn f4122gv = new i9.zn() { // from class: f8.f3
        @Override // com.google.android.exoplayer2.drm.i9.zn
        public final com.google.android.exoplayer2.drm.i9 acquireExoMediaDrm(UUID uuid) {
            com.google.android.exoplayer2.drm.i9 d02;
            d02 = com.google.android.exoplayer2.drm.f.d0(uuid);
            return d02;
        }
    };

    /* renamed from: n3  reason: collision with root package name */
    public final MediaDrm f4123n3;
    public final UUID y;

    /* renamed from: zn  reason: collision with root package name */
    public int f4124zn;

    /* loaded from: classes.dex */
    public static class y {
        public static void n3(MediaDrm mediaDrm, byte[] bArr, u0 u0Var) {
            LogSessionId y = u0Var.y();
            if (!y.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
                ((MediaDrm.PlaybackComponent) v5.y.v(mediaDrm.getPlaybackComponent(bArr))).setLogSessionId(y);
            }
        }

        public static boolean y(MediaDrm mediaDrm, String str) {
            return mediaDrm.requiresSecureDecoder(str);
        }
    }

    public f(UUID uuid) throws UnsupportedSchemeException {
        v5.y.v(uuid);
        v5.y.n3(!m1.c5.f10605n3.equals(uuid), "Use C.CLEARKEY_UUID instead");
        this.y = uuid;
        MediaDrm mediaDrm = new MediaDrm(r(uuid));
        this.f4123n3 = mediaDrm;
        this.f4124zn = 1;
        if (m1.c5.f10604gv.equals(uuid) && fh()) {
            i4(mediaDrm);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0056, code lost:
        if ("AFTT".equals(r0) == false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static byte[] co(java.util.UUID r3, byte[] r4) {
        /*
            java.util.UUID r0 = m1.c5.f10606v
            boolean r1 = r0.equals(r3)
            if (r1 == 0) goto L18
            byte[] r1 = ha.t.v(r4, r3)
            if (r1 != 0) goto Lf
            goto L10
        Lf:
            r4 = r1
        L10:
            byte[] r4 = w(r4)
            byte[] r4 = ha.t.y(r0, r4)
        L18:
            int r1 = v5.j5.y
            r2 = 23
            if (r1 >= r2) goto L26
            java.util.UUID r1 = m1.c5.f10604gv
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L58
        L26:
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L5f
            java.lang.String r0 = "Amazon"
            java.lang.String r1 = v5.j5.f14370zn
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L5f
            java.lang.String r0 = v5.j5.f14361gv
            java.lang.String r1 = "AFTB"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L58
            java.lang.String r1 = "AFTS"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L58
            java.lang.String r1 = "AFTM"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L58
            java.lang.String r1 = "AFTT"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L5f
        L58:
            byte[] r3 = ha.t.v(r4, r3)
            if (r3 == 0) goto L5f
            return r3
        L5f:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.drm.f.co(java.util.UUID, byte[]):byte[]");
    }

    public static /* synthetic */ i9 d0(UUID uuid) {
        try {
            return rz(uuid);
        } catch (fh unused) {
            r.zn("FrameworkMediaDrm", "Failed to instantiate a FrameworkMediaDrm for uuid: " + uuid + ".");
            return new s();
        }
    }

    public static boolean fh() {
        return "ASUS_Z00AD".equals(j5.f14361gv);
    }

    public static void i4(MediaDrm mediaDrm) {
        mediaDrm.setPropertyString("securityLevel", "L3");
    }

    public static byte[] mt(UUID uuid, byte[] bArr) {
        if (m1.c5.f10607zn.equals(uuid)) {
            return f8.y.y(bArr);
        }
        return bArr;
    }

    public static DrmInitData.SchemeData n(UUID uuid, List<DrmInitData.SchemeData> list) {
        if (!m1.c5.f10604gv.equals(uuid)) {
            return list.get(0);
        }
        if (j5.y >= 28 && list.size() > 1) {
            DrmInitData.SchemeData schemeData = list.get(0);
            int i = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                DrmInitData.SchemeData schemeData2 = list.get(i5);
                byte[] bArr = (byte[]) v5.y.v(schemeData2.f4117f);
                if (j5.zn(schemeData2.f4119s, schemeData.f4119s) && j5.zn(schemeData2.f4118fb, schemeData.f4118fb) && ha.t.zn(bArr)) {
                    i += bArr.length;
                }
            }
            byte[] bArr2 = new byte[i];
            int i6 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                byte[] bArr3 = (byte[]) v5.y.v(list.get(i8).f4117f);
                int length = bArr3.length;
                System.arraycopy(bArr3, 0, bArr2, i6, length);
                i6 += length;
            }
            return schemeData.n3(bArr2);
        }
        for (int i10 = 0; i10 < list.size(); i10++) {
            DrmInitData.SchemeData schemeData3 = list.get(i10);
            int fb2 = ha.t.fb((byte[]) v5.y.v(schemeData3.f4117f));
            int i11 = j5.y;
            if (i11 < 23 && fb2 == 0) {
                return schemeData3;
            }
            if (i11 >= 23 && fb2 == 1) {
                return schemeData3;
            }
        }
        return list.get(0);
    }

    public static String p(String str) {
        if ("<LA_URL>https://x</LA_URL>".equals(str)) {
            return "";
        }
        if (j5.y == 33 && "https://default.url".equals(str)) {
            return "";
        }
        return str;
    }

    public static UUID r(UUID uuid) {
        if (j5.y < 27 && m1.c5.f10607zn.equals(uuid)) {
            return m1.c5.f10605n3;
        }
        return uuid;
    }

    public static f rz(UUID uuid) throws fh {
        try {
            return new f(uuid);
        } catch (UnsupportedSchemeException e2) {
            throw new fh(1, e2);
        } catch (Exception e3) {
            throw new fh(2, e3);
        }
    }

    public static byte[] w(byte[] bArr) {
        int indexOf;
        rz rzVar = new rz(bArr);
        int r2 = rzVar.r();
        short i42 = rzVar.i4();
        short i43 = rzVar.i4();
        if (i42 == 1 && i43 == 1) {
            short i44 = rzVar.i4();
            Charset charset = w0.v.f14522v;
            String d2 = rzVar.d(i44, charset);
            if (d2.contains("<LA_URL>")) {
                return bArr;
            }
            if (d2.indexOf("</DATA>") == -1) {
                r.c5("FrameworkMediaDrm", "Could not find the </DATA> tag. Skipping LA_URL workaround.");
            }
            String str = d2.substring(0, indexOf) + "<LA_URL>https://x</LA_URL>" + d2.substring(indexOf);
            int i = r2 + 52;
            ByteBuffer allocate = ByteBuffer.allocate(i);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            allocate.putInt(i);
            allocate.putShort(i42);
            allocate.putShort(i43);
            allocate.putShort((short) (str.length() * 2));
            allocate.put(str.getBytes(charset));
            return allocate.array();
        }
        r.a("FrameworkMediaDrm", "Unexpected record count or type. Skipping LA_URL workaround.");
        return bArr;
    }

    public static String z(UUID uuid, String str) {
        if (j5.y < 26 && m1.c5.f10607zn.equals(uuid) && ("video/mp4".equals(str) || "audio/mp4".equals(str))) {
            return "cenc";
        }
        return str;
    }

    @Override // com.google.android.exoplayer2.drm.i9
    public void a(@Nullable final i9.n3 n3Var) {
        MediaDrm.OnEventListener onEventListener;
        MediaDrm mediaDrm = this.f4123n3;
        if (n3Var == null) {
            onEventListener = null;
        } else {
            onEventListener = new MediaDrm.OnEventListener() { // from class: f8.n
                @Override // android.media.MediaDrm.OnEventListener
                public final void onEvent(MediaDrm mediaDrm2, byte[] bArr, int i, int i5, byte[] bArr2) {
                    com.google.android.exoplayer2.drm.f.this.c(n3Var, mediaDrm2, bArr, i, i5, bArr2);
                }
            };
        }
        mediaDrm.setOnEventListener(onEventListener);
    }

    public final /* synthetic */ void c(i9.n3 n3Var, MediaDrm mediaDrm, byte[] bArr, int i, int i5, byte[] bArr2) {
        n3Var.y(this, bArr, i, i5, bArr2);
    }

    @Override // com.google.android.exoplayer2.drm.i9
    public void f(byte[] bArr) {
        this.f4123n3.closeSession(bArr);
    }

    public String f3(String str) {
        return this.f4123n3.getPropertyString(str);
    }

    @Override // com.google.android.exoplayer2.drm.i9
    public void fb(byte[] bArr) throws DeniedByServerException {
        this.f4123n3.provideProvisionResponse(bArr);
    }

    @Override // com.google.android.exoplayer2.drm.i9
    public byte[] gv() throws MediaDrmException {
        return this.f4123n3.openSession();
    }

    @Override // com.google.android.exoplayer2.drm.i9
    public boolean i9(byte[] bArr, String str) {
        if (j5.y >= 31) {
            return y.y(this.f4123n3, str);
        }
        try {
            MediaCrypto mediaCrypto = new MediaCrypto(this.y, bArr);
            try {
                return mediaCrypto.requiresSecureDecoderComponent(str);
            } finally {
                mediaCrypto.release();
            }
        } catch (MediaCryptoException unused) {
            return true;
        }
    }

    @Override // com.google.android.exoplayer2.drm.i9
    public Map<String, String> n3(byte[] bArr) {
        return this.f4123n3.queryKeyStatus(bArr);
    }

    @Override // com.google.android.exoplayer2.drm.i9
    public synchronized void release() {
        int i = this.f4124zn - 1;
        this.f4124zn = i;
        if (i == 0) {
            this.f4123n3.release();
        }
    }

    @Override // com.google.android.exoplayer2.drm.i9
    public int s() {
        return 2;
    }

    @Override // com.google.android.exoplayer2.drm.i9
    @Nullable
    public byte[] t(byte[] bArr, byte[] bArr2) throws NotProvisionedException, DeniedByServerException {
        if (m1.c5.f10607zn.equals(this.y)) {
            bArr2 = f8.y.n3(bArr2);
        }
        return this.f4123n3.provideKeyResponse(bArr, bArr2);
    }

    @Override // com.google.android.exoplayer2.drm.i9
    @SuppressLint({"WrongConstant"})
    public i9.y tl(byte[] bArr, @Nullable List<DrmInitData.SchemeData> list, int i, @Nullable HashMap<String, String> hashMap) throws NotProvisionedException {
        DrmInitData.SchemeData schemeData;
        byte[] bArr2;
        String str;
        int i5;
        if (list != null) {
            schemeData = n(this.y, list);
            bArr2 = co(this.y, (byte[]) v5.y.v(schemeData.f4117f));
            str = z(this.y, schemeData.f4119s);
        } else {
            schemeData = null;
            bArr2 = null;
            str = null;
        }
        MediaDrm.KeyRequest keyRequest = this.f4123n3.getKeyRequest(bArr, bArr2, str, i, hashMap);
        byte[] mt2 = mt(this.y, keyRequest.getData());
        String p2 = p(keyRequest.getDefaultUrl());
        if (TextUtils.isEmpty(p2) && schemeData != null && !TextUtils.isEmpty(schemeData.f4118fb)) {
            p2 = schemeData.f4118fb;
        }
        if (j5.y >= 23) {
            i5 = keyRequest.getRequestType();
        } else {
            i5 = Integer.MIN_VALUE;
        }
        return new i9.y(mt2, p2, i5);
    }

    @Override // com.google.android.exoplayer2.drm.i9
    public void v(byte[] bArr, byte[] bArr2) {
        this.f4123n3.restoreKeys(bArr, bArr2);
    }

    @Override // com.google.android.exoplayer2.drm.i9
    /* renamed from: x4 */
    public i4 c5(byte[] bArr) throws MediaCryptoException {
        boolean z2;
        if (j5.y < 21 && m1.c5.f10604gv.equals(this.y) && "L3".equals(f3("securityLevel"))) {
            z2 = true;
        } else {
            z2 = false;
        }
        return new i4(r(this.y), bArr, z2);
    }

    @Override // com.google.android.exoplayer2.drm.i9
    public void y(byte[] bArr, u0 u0Var) {
        if (j5.y >= 31) {
            try {
                y.n3(this.f4123n3, bArr, u0Var);
            } catch (UnsupportedOperationException unused) {
                r.c5("FrameworkMediaDrm", "setLogSessionId failed.");
            }
        }
    }

    @Override // com.google.android.exoplayer2.drm.i9
    public i9.gv zn() {
        MediaDrm.ProvisionRequest provisionRequest = this.f4123n3.getProvisionRequest();
        return new i9.gv(provisionRequest.getData(), provisionRequest.getDefaultUrl());
    }
}
