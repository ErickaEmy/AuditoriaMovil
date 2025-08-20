package dq;

import android.net.Uri;
import androidx.annotation.Nullable;
import dq.wz;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import v5.j5;
/* loaded from: classes.dex */
public class c5 extends a {
    @Nullable

    /* renamed from: p  reason: collision with root package name */
    public gv f7354p;

    /* renamed from: t  reason: collision with root package name */
    public boolean f7355t = true;

    /* renamed from: w  reason: collision with root package name */
    public long f7356w = -9223372036854775807L;

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0016, code lost:
        if (r0 != (-9223372036854775807L)) goto L5;
     */
    @Override // dq.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.List<dq.wz.gv> e(org.xmlpull.v1.XmlPullParser r22, long r23, long r25) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r21 = this;
            r9 = r21
            r10 = r22
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            boolean r0 = r9.f7355t
            r12 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r0 == 0) goto L19
            long r0 = r9.f7356w
            int r2 = (r0 > r12 ? 1 : (r0 == r12 ? 0 : -1))
            if (r2 == 0) goto L19
            goto L1b
        L19:
            r0 = 0
        L1b:
            r14 = 0
            r2 = r0
            r4 = r12
            r0 = 0
            r6 = 0
        L20:
            r22.next()
            java.lang.String r1 = "S"
            boolean r1 = v5.qn.a(r10, r1)
            if (r1 == 0) goto L53
            java.lang.String r1 = "t"
            long r15 = dq.a.k(r10, r1, r12)
            if (r0 == 0) goto L3b
            r0 = r21
            r1 = r11
            r7 = r15
            long r2 = r0.n3(r1, r2, r4, r6, r7)
        L3b:
            int r0 = (r15 > r12 ? 1 : (r15 == r12 ? 0 : -1))
            if (r0 == 0) goto L40
            goto L41
        L40:
            r15 = r2
        L41:
            java.lang.String r0 = "d"
            long r0 = dq.a.k(r10, r0, r12)
            java.lang.String r2 = "r"
            int r2 = dq.a.oz(r10, r2, r14)
            r3 = 1
            r4 = r0
            r6 = r2
            r2 = r15
            r0 = 1
            goto L56
        L53:
            dq.a.i4(r22)
        L56:
            java.lang.String r1 = "SegmentTimeline"
            boolean r1 = v5.qn.gv(r10, r1)
            if (r1 == 0) goto L20
            if (r0 == 0) goto L70
            r19 = 1000(0x3e8, double:4.94E-321)
            r15 = r25
            r17 = r23
            long r7 = v5.j5.x5(r15, r17, r19)
            r0 = r21
            r1 = r11
            r0.n3(r1, r2, r4, r6, r7)
        L70:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: dq.c5.e(org.xmlpull.v1.XmlPullParser, long, long):java.util.List");
    }

    @Override // dq.a, kx.z6.y
    /* renamed from: f3 */
    public zn y(Uri uri, InputStream inputStream) throws IOException {
        zn y = super.y(uri, inputStream);
        gv gvVar = this.f7354p;
        if (gvVar == null) {
            this.f7354p = new gv(y);
            return y;
        }
        return gvVar.n3(y);
    }

    /* JADX WARN: Removed duplicated region for block: B:87:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x020e A[LOOP:0: B:25:0x00a5->B:91:0x020e, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01cc A[SYNTHETIC] */
    @Override // dq.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public dq.zn f7(org.xmlpull.v1.XmlPullParser r47, android.net.Uri r48) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 540
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: dq.c5.f7(org.xmlpull.v1.XmlPullParser, android.net.Uri):dq.zn");
    }

    public final long n3(List<wz.gv> list, long j2, long j4, int i, long j6) {
        int tl2;
        if (i >= 0) {
            tl2 = i + 1;
        } else {
            tl2 = (int) j5.tl(j6 - j2, j4);
        }
        for (int i5 = 0; i5 < tl2; i5++) {
            list.add(tl(j2, j4));
            j2 += j4;
        }
        return j2;
    }

    public final boolean x4(String[] strArr) {
        for (String str : strArr) {
            if (str.startsWith("urn:dvb:dash:profile:dvb-dash:")) {
                return true;
            }
        }
        return false;
    }
}
