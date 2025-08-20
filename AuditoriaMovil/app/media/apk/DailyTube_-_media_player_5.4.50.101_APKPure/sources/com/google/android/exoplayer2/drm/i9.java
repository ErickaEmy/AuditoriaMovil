package com.google.android.exoplayer2.drm;

import android.media.DeniedByServerException;
import android.media.MediaCryptoException;
import android.media.MediaDrmException;
import android.media.NotProvisionedException;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.DrmInitData;
import fj.u0;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
/* loaded from: classes.dex */
public interface i9 {

    /* loaded from: classes.dex */
    public static final class gv {

        /* renamed from: n3  reason: collision with root package name */
        public final String f4125n3;
        public final byte[] y;

        public gv(byte[] bArr, String str) {
            this.y = bArr;
            this.f4125n3 = str;
        }

        public String n3() {
            return this.f4125n3;
        }

        public byte[] y() {
            return this.y;
        }
    }

    /* loaded from: classes.dex */
    public interface n3 {
        void y(i9 i9Var, @Nullable byte[] bArr, int i, int i5, @Nullable byte[] bArr2);
    }

    /* loaded from: classes.dex */
    public static final class y {

        /* renamed from: n3  reason: collision with root package name */
        public final String f4126n3;
        public final byte[] y;

        /* renamed from: zn  reason: collision with root package name */
        public final int f4127zn;

        public y(byte[] bArr, String str, int i) {
            this.y = bArr;
            this.f4126n3 = str;
            this.f4127zn = i;
        }

        public String n3() {
            return this.f4126n3;
        }

        public byte[] y() {
            return this.y;
        }
    }

    /* loaded from: classes.dex */
    public interface zn {
        i9 acquireExoMediaDrm(UUID uuid);
    }

    void a(@Nullable n3 n3Var);

    a9.n3 c5(byte[] bArr) throws MediaCryptoException;

    void f(byte[] bArr);

    void fb(byte[] bArr) throws DeniedByServerException;

    byte[] gv() throws MediaDrmException;

    boolean i9(byte[] bArr, String str);

    Map<String, String> n3(byte[] bArr);

    void release();

    int s();

    @Nullable
    byte[] t(byte[] bArr, byte[] bArr2) throws NotProvisionedException, DeniedByServerException;

    y tl(byte[] bArr, @Nullable List<DrmInitData.SchemeData> list, int i, @Nullable HashMap<String, String> hashMap) throws NotProvisionedException;

    void v(byte[] bArr, byte[] bArr2);

    void y(byte[] bArr, u0 u0Var);

    gv zn();
}
