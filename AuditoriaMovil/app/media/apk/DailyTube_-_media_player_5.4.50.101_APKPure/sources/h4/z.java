package h4;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import e4.d0;
import e4.fh;
import e4.ta;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import m1.m;
import m1.ne;
import v5.k5;
import v5.rz;
/* loaded from: classes.dex */
public final class z implements e4.t {

    /* renamed from: fb  reason: collision with root package name */
    public static final Pattern f8707fb = Pattern.compile("LOCAL:([^,]+)");

    /* renamed from: s  reason: collision with root package name */
    public static final Pattern f8708s = Pattern.compile("MPEGTS:(-?\\d+)");

    /* renamed from: a  reason: collision with root package name */
    public int f8709a;

    /* renamed from: gv  reason: collision with root package name */
    public e4.wz f8710gv;

    /* renamed from: n3  reason: collision with root package name */
    public final k5 f8711n3;
    @Nullable
    public final String y;

    /* renamed from: zn  reason: collision with root package name */
    public final rz f8713zn = new rz();

    /* renamed from: v  reason: collision with root package name */
    public byte[] f8712v = new byte[1024];

    public z(@Nullable String str, k5 k5Var) {
        this.y = str;
        this.f8711n3 = k5Var;
    }

    @Override // e4.t
    public boolean a(e4.tl tlVar) throws IOException {
        tlVar.v(this.f8712v, 0, 6, false);
        this.f8713zn.o(this.f8712v, 6);
        if (ft.c5.n3(this.f8713zn)) {
            return true;
        }
        tlVar.v(this.f8712v, 6, 3, false);
        this.f8713zn.o(this.f8712v, 9);
        return ft.c5.n3(this.f8713zn);
    }

    public final void gv() throws ne {
        rz rzVar = new rz(this.f8712v);
        ft.c5.v(rzVar);
        long j2 = 0;
        long j4 = 0;
        for (String co2 = rzVar.co(); !TextUtils.isEmpty(co2); co2 = rzVar.co()) {
            if (co2.startsWith("X-TIMESTAMP-MAP")) {
                Matcher matcher = f8707fb.matcher(co2);
                if (matcher.find()) {
                    Matcher matcher2 = f8708s.matcher(co2);
                    if (matcher2.find()) {
                        j4 = ft.c5.gv((String) v5.y.v(matcher.group(1)));
                        j2 = k5.a(Long.parseLong((String) v5.y.v(matcher2.group(1))));
                    } else {
                        throw ne.y("X-TIMESTAMP-MAP doesn't contain media timestamp: " + co2, null);
                    }
                } else {
                    throw ne.y("X-TIMESTAMP-MAP doesn't contain local timestamp: " + co2, null);
                }
            }
        }
        Matcher y = ft.c5.y(rzVar);
        if (y == null) {
            n3(0L);
            return;
        }
        long gv2 = ft.c5.gv((String) v5.y.v(y.group(1)));
        long n32 = this.f8711n3.n3(k5.i9((j2 + gv2) - j4));
        ta n33 = n3(n32 - gv2);
        this.f8713zn.o(this.f8712v, this.f8709a);
        n33.zn(this.f8713zn, this.f8709a);
        n33.gv(n32, 1, this.f8709a, 0, null);
    }

    public final ta n3(long j2) {
        ta a2 = this.f8710gv.a(0, 3);
        a2.v(new m.n3().o4("text/vtt").k(this.y).nf(j2).z6());
        this.f8710gv.xc();
        return a2;
    }

    @Override // e4.t
    public int v(e4.tl tlVar, d0 d0Var) throws IOException {
        int length;
        v5.y.v(this.f8710gv);
        int length2 = (int) tlVar.getLength();
        int i = this.f8709a;
        byte[] bArr = this.f8712v;
        if (i == bArr.length) {
            if (length2 != -1) {
                length = length2;
            } else {
                length = bArr.length;
            }
            this.f8712v = Arrays.copyOf(bArr, (length * 3) / 2);
        }
        byte[] bArr2 = this.f8712v;
        int i5 = this.f8709a;
        int read = tlVar.read(bArr2, i5, bArr2.length - i5);
        if (read != -1) {
            int i6 = this.f8709a + read;
            this.f8709a = i6;
            if (length2 == -1 || i6 != length2) {
                return 0;
            }
        }
        gv();
        return -1;
    }

    @Override // e4.t
    public void y(long j2, long j4) {
        throw new IllegalStateException();
    }

    @Override // e4.t
    public void zn(e4.wz wzVar) {
        this.f8710gv = wzVar;
        wzVar.t(new fh.n3(-9223372036854775807L));
    }

    @Override // e4.t
    public void release() {
    }
}
