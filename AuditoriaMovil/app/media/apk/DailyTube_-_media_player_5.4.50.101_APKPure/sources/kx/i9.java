package kx;

import android.net.Uri;
import android.util.Base64;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.net.URLDecoder;
import m1.ne;
/* loaded from: classes.dex */
public final class i9 extends fb {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public byte[] f10039a;

    /* renamed from: fb  reason: collision with root package name */
    public int f10040fb;

    /* renamed from: s  reason: collision with root package name */
    public int f10041s;
    @Nullable

    /* renamed from: v  reason: collision with root package name */
    public p f10042v;

    public i9() {
        super(false);
    }

    @Override // kx.tl
    public void close() {
        if (this.f10039a != null) {
            this.f10039a = null;
            r();
        }
        this.f10042v = null;
    }

    @Override // kx.tl
    @Nullable
    public Uri n3() {
        p pVar = this.f10042v;
        if (pVar != null) {
            return pVar.y;
        }
        return null;
    }

    @Override // kx.c5
    public int read(byte[] bArr, int i, int i5) {
        if (i5 == 0) {
            return 0;
        }
        int i6 = this.f10041s;
        if (i6 == 0) {
            return -1;
        }
        int min = Math.min(i5, i6);
        System.arraycopy(v5.j5.i9(this.f10039a), this.f10040fb, bArr, i, min);
        this.f10040fb += min;
        this.f10041s -= min;
        mt(min);
        return min;
    }

    @Override // kx.tl
    public long y(p pVar) throws IOException {
        x4(pVar);
        this.f10042v = pVar;
        Uri uri = pVar.y;
        String scheme = uri.getScheme();
        boolean equals = "data".equals(scheme);
        v5.y.n3(equals, "Unsupported scheme: " + scheme);
        String[] ro2 = v5.j5.ro(uri.getSchemeSpecificPart(), ",");
        if (ro2.length == 2) {
            String str = ro2[1];
            if (ro2[0].contains(";base64")) {
                try {
                    this.f10039a = Base64.decode(str, 0);
                } catch (IllegalArgumentException e2) {
                    throw ne.gv("Error while parsing Base64 encoded string: " + str, e2);
                }
            } else {
                this.f10039a = v5.j5.ap(URLDecoder.decode(str, w0.v.y.name()));
            }
            long j2 = pVar.f10071fb;
            byte[] bArr = this.f10039a;
            if (j2 <= bArr.length) {
                int i = (int) j2;
                this.f10040fb = i;
                int length = bArr.length - i;
                this.f10041s = length;
                long j4 = pVar.f10075s;
                if (j4 != -1) {
                    this.f10041s = (int) Math.min(length, j4);
                }
                i4(pVar);
                long j6 = pVar.f10075s;
                if (j6 == -1) {
                    return this.f10041s;
                }
                return j6;
            }
            this.f10039a = null;
            throw new wz(2008);
        }
        throw ne.gv("Unexpected URI format: " + uri, null);
    }
}
