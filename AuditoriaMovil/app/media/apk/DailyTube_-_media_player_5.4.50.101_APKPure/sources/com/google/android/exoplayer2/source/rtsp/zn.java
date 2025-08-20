package com.google.android.exoplayer2.source.rtsp;

import android.net.Uri;
import android.util.Base64;
import com.google.android.exoplayer2.source.rtsp.s;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import m1.ne;
import v5.j5;
/* loaded from: classes.dex */
public final class zn {

    /* renamed from: gv  reason: collision with root package name */
    public final String f4654gv;

    /* renamed from: n3  reason: collision with root package name */
    public final String f4655n3;
    public final int y;

    /* renamed from: zn  reason: collision with root package name */
    public final String f4656zn;

    public zn(int i, String str, String str2, String str3) {
        this.y = i;
        this.f4655n3 = str;
        this.f4656zn = str2;
        this.f4654gv = str3;
    }

    public final String n3(s.y yVar) {
        return j5.rz("Basic %s", Base64.encodeToString(s.gv(yVar.y + ":" + yVar.f4651n3), 0));
    }

    public String y(s.y yVar, Uri uri, int i) throws ne {
        int i5 = this.y;
        if (i5 != 1) {
            if (i5 == 2) {
                return zn(yVar, uri, i);
            }
            throw ne.a(null, new UnsupportedOperationException());
        }
        return n3(yVar);
    }

    public final String zn(s.y yVar, Uri uri, int i) throws ne {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            String z2 = s.z(i);
            String j32 = j5.j3(messageDigest.digest(s.gv(yVar.y + ":" + this.f4655n3 + ":" + yVar.f4651n3)));
            StringBuilder sb = new StringBuilder();
            sb.append(z2);
            sb.append(":");
            sb.append(uri);
            String j33 = j5.j3(messageDigest.digest(s.gv(sb.toString())));
            String j34 = j5.j3(messageDigest.digest(s.gv(j32 + ":" + this.f4656zn + ":" + j33)));
            if (this.f4654gv.isEmpty()) {
                return j5.rz("Digest username=\"%s\", realm=\"%s\", nonce=\"%s\", uri=\"%s\", response=\"%s\"", yVar.y, this.f4655n3, this.f4656zn, uri, j34);
            }
            return j5.rz("Digest username=\"%s\", realm=\"%s\", nonce=\"%s\", uri=\"%s\", response=\"%s\", opaque=\"%s\"", yVar.y, this.f4655n3, this.f4656zn, uri, j34, this.f4654gv);
        } catch (NoSuchAlgorithmException e2) {
            throw ne.a(null, e2);
        }
    }
}
