package sc1;

import androidx.core.app.NotificationCompat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zc1.p;
import zc1.ta;
/* loaded from: classes.dex */
public final class gv {

    /* renamed from: n3  reason: collision with root package name */
    public static final Map<zc1.s, Integer> f13787n3;
    public static final zn[] y;

    /* renamed from: zn  reason: collision with root package name */
    public static final gv f13788zn;

    static {
        gv gvVar = new gv();
        f13788zn = gvVar;
        zn znVar = new zn(zn.f13845c5, "");
        zc1.s sVar = zn.f13844a;
        zn znVar2 = new zn(sVar, "GET");
        zn znVar3 = new zn(sVar, "POST");
        zc1.s sVar2 = zn.f13846fb;
        zn znVar4 = new zn(sVar2, "/");
        zn znVar5 = new zn(sVar2, "/index.html");
        zc1.s sVar3 = zn.f13849s;
        zn znVar6 = new zn(sVar3, "http");
        zn znVar7 = new zn(sVar3, "https");
        zc1.s sVar4 = zn.f13850v;
        y = new zn[]{znVar, znVar2, znVar3, znVar4, znVar5, znVar6, znVar7, new zn(sVar4, "200"), new zn(sVar4, "204"), new zn(sVar4, "206"), new zn(sVar4, "304"), new zn(sVar4, "400"), new zn(sVar4, "404"), new zn(sVar4, "500"), new zn("accept-charset", ""), new zn("accept-encoding", "gzip, deflate"), new zn("accept-language", ""), new zn("accept-ranges", ""), new zn("accept", ""), new zn("access-control-allow-origin", ""), new zn("age", ""), new zn("allow", ""), new zn("authorization", ""), new zn("cache-control", ""), new zn("content-disposition", ""), new zn("content-encoding", ""), new zn("content-language", ""), new zn("content-length", ""), new zn("content-location", ""), new zn("content-range", ""), new zn("content-type", ""), new zn("cookie", ""), new zn("date", ""), new zn("etag", ""), new zn("expect", ""), new zn("expires", ""), new zn("from", ""), new zn("host", ""), new zn("if-match", ""), new zn("if-modified-since", ""), new zn("if-none-match", ""), new zn("if-range", ""), new zn("if-unmodified-since", ""), new zn("last-modified", ""), new zn("link", ""), new zn("location", ""), new zn("max-forwards", ""), new zn("proxy-authenticate", ""), new zn("proxy-authorization", ""), new zn("range", ""), new zn("referer", ""), new zn("refresh", ""), new zn("retry-after", ""), new zn("server", ""), new zn("set-cookie", ""), new zn("strict-transport-security", ""), new zn("transfer-encoding", ""), new zn("user-agent", ""), new zn("vary", ""), new zn("via", ""), new zn("www-authenticate", "")};
        f13787n3 = gvVar.gv();
    }

    public final Map<zc1.s, Integer> gv() {
        zn[] znVarArr = y;
        LinkedHashMap linkedHashMap = new LinkedHashMap(znVarArr.length);
        int length = znVarArr.length;
        for (int i = 0; i < length; i++) {
            zn[] znVarArr2 = y;
            if (!linkedHashMap.containsKey(znVarArr2[i].f13851n3)) {
                linkedHashMap.put(znVarArr2[i].f13851n3, Integer.valueOf(i));
            }
        }
        Map<zc1.s, Integer> unmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        Intrinsics.checkNotNullExpressionValue(unmodifiableMap, "Collections.unmodifiableMap(result)");
        return unmodifiableMap;
    }

    public final Map<zc1.s, Integer> n3() {
        return f13787n3;
    }

    public final zc1.s y(zc1.s name) throws IOException {
        Intrinsics.checkNotNullParameter(name, "name");
        int j2 = name.j();
        for (int i = 0; i < j2; i++) {
            byte b2 = (byte) 65;
            byte b3 = (byte) 90;
            byte s2 = name.s(i);
            if (b2 <= s2 && b3 >= s2) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + name.dm());
            }
        }
        return name;
    }

    public final zn[] zn() {
        return y;
    }

    /* loaded from: classes.dex */
    public static final class n3 {

        /* renamed from: a  reason: collision with root package name */
        public int f13789a;

        /* renamed from: c5  reason: collision with root package name */
        public final boolean f13790c5;

        /* renamed from: fb  reason: collision with root package name */
        public int f13791fb;

        /* renamed from: gv  reason: collision with root package name */
        public zn[] f13792gv;

        /* renamed from: i9  reason: collision with root package name */
        public final zc1.v f13793i9;

        /* renamed from: n3  reason: collision with root package name */
        public boolean f13794n3;

        /* renamed from: s  reason: collision with root package name */
        public int f13795s;

        /* renamed from: v  reason: collision with root package name */
        public int f13796v;
        public int y;

        /* renamed from: zn  reason: collision with root package name */
        public int f13797zn;

        public n3(int i, boolean z2, zc1.v out) {
            Intrinsics.checkNotNullParameter(out, "out");
            this.f13795s = i;
            this.f13790c5 = z2;
            this.f13793i9 = out;
            this.y = Integer.MAX_VALUE;
            this.f13797zn = i;
            zn[] znVarArr = new zn[8];
            this.f13792gv = znVarArr;
            this.f13796v = znVarArr.length - 1;
        }

        public final void a(zc1.s data) throws IOException {
            Intrinsics.checkNotNullParameter(data, "data");
            if (this.f13790c5) {
                f fVar = f.f13774gv;
                if (fVar.gv(data) < data.j()) {
                    zc1.v vVar = new zc1.v();
                    fVar.zn(data, vVar);
                    zc1.s bk2 = vVar.bk();
                    s(bk2.j(), 127, NotificationCompat.FLAG_HIGH_PRIORITY);
                    this.f13793i9.qk(bk2);
                    return;
                }
            }
            s(data.j(), 127, 0);
            this.f13793i9.qk(data);
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x007e  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00c4  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x00cc  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void fb(java.util.List<sc1.zn> r13) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 264
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: sc1.gv.n3.fb(java.util.List):void");
        }

        public final void gv(zn znVar) {
            int i = znVar.y;
            int i5 = this.f13797zn;
            if (i > i5) {
                n3();
                return;
            }
            zn((this.f13791fb + i) - i5);
            int i6 = this.f13789a + 1;
            zn[] znVarArr = this.f13792gv;
            if (i6 > znVarArr.length) {
                zn[] znVarArr2 = new zn[znVarArr.length * 2];
                System.arraycopy(znVarArr, 0, znVarArr2, znVarArr.length, znVarArr.length);
                this.f13796v = this.f13792gv.length - 1;
                this.f13792gv = znVarArr2;
            }
            int i8 = this.f13796v;
            this.f13796v = i8 - 1;
            this.f13792gv[i8] = znVar;
            this.f13789a++;
            this.f13791fb += i;
        }

        public final void n3() {
            ArraysKt.fill$default(this.f13792gv, null, 0, 0, 6, null);
            this.f13796v = this.f13792gv.length - 1;
            this.f13789a = 0;
            this.f13791fb = 0;
        }

        public final void s(int i, int i5, int i6) {
            if (i < i5) {
                this.f13793i9.w2(i | i6);
                return;
            }
            this.f13793i9.w2(i6 | i5);
            int i8 = i - i5;
            while (i8 >= 128) {
                this.f13793i9.w2(128 | (i8 & 127));
                i8 >>>= 7;
            }
            this.f13793i9.w2(i8);
        }

        public final void v(int i) {
            this.f13795s = i;
            int min = Math.min(i, 16384);
            int i5 = this.f13797zn;
            if (i5 == min) {
                return;
            }
            if (min < i5) {
                this.y = Math.min(this.y, min);
            }
            this.f13794n3 = true;
            this.f13797zn = min;
            y();
        }

        public final void y() {
            int i = this.f13797zn;
            int i5 = this.f13791fb;
            if (i < i5) {
                if (i == 0) {
                    n3();
                } else {
                    zn(i5 - i);
                }
            }
        }

        public final int zn(int i) {
            int i5;
            int i6 = 0;
            if (i > 0) {
                int length = this.f13792gv.length;
                while (true) {
                    length--;
                    i5 = this.f13796v;
                    if (length < i5 || i <= 0) {
                        break;
                    }
                    zn znVar = this.f13792gv[length];
                    Intrinsics.checkNotNull(znVar);
                    i -= znVar.y;
                    int i8 = this.f13791fb;
                    zn znVar2 = this.f13792gv[length];
                    Intrinsics.checkNotNull(znVar2);
                    this.f13791fb = i8 - znVar2.y;
                    this.f13789a--;
                    i6++;
                }
                zn[] znVarArr = this.f13792gv;
                System.arraycopy(znVarArr, i5 + 1, znVarArr, i5 + 1 + i6, this.f13789a);
                zn[] znVarArr2 = this.f13792gv;
                int i10 = this.f13796v;
                Arrays.fill(znVarArr2, i10 + 1, i10 + 1 + i6, (Object) null);
                this.f13796v += i6;
            }
            return i6;
        }

        public /* synthetic */ n3(int i, boolean z2, zc1.v vVar, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? 4096 : i, (i5 & 2) != 0 ? true : z2, vVar);
        }
    }

    /* loaded from: classes.dex */
    public static final class y {

        /* renamed from: a  reason: collision with root package name */
        public int f13798a;

        /* renamed from: fb  reason: collision with root package name */
        public final int f13799fb;

        /* renamed from: gv  reason: collision with root package name */
        public int f13800gv;

        /* renamed from: n3  reason: collision with root package name */
        public final zc1.fb f13801n3;

        /* renamed from: s  reason: collision with root package name */
        public int f13802s;

        /* renamed from: v  reason: collision with root package name */
        public int f13803v;
        public final List<zn> y;

        /* renamed from: zn  reason: collision with root package name */
        public zn[] f13804zn;

        public y(ta source, int i, int i5) {
            Intrinsics.checkNotNullParameter(source, "source");
            this.f13799fb = i;
            this.f13802s = i5;
            this.y = new ArrayList();
            this.f13801n3 = p.gv(source);
            zn[] znVarArr = new zn[8];
            this.f13804zn = znVarArr;
            this.f13800gv = znVarArr.length - 1;
        }

        public final zc1.s a(int i) throws IOException {
            if (s(i)) {
                return gv.f13788zn.zn()[i].f13851n3;
            }
            int zn2 = zn(i - gv.f13788zn.zn().length);
            if (zn2 >= 0) {
                zn[] znVarArr = this.f13804zn;
                if (zn2 < znVarArr.length) {
                    zn znVar = znVarArr[zn2];
                    Intrinsics.checkNotNull(znVar);
                    return znVar.f13851n3;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        public final int c5() throws IOException {
            return lc1.n3.n3(this.f13801n3.readByte(), 255);
        }

        public final void f() throws IOException {
            while (!this.f13801n3.nf()) {
                int n32 = lc1.n3.n3(this.f13801n3.readByte(), 255);
                if (n32 != 128) {
                    if ((n32 & NotificationCompat.FLAG_HIGH_PRIORITY) == 128) {
                        t(tl(n32, 127) - 1);
                    } else if (n32 == 64) {
                        xc();
                    } else if ((n32 & 64) == 64) {
                        wz(tl(n32, 63) - 1);
                    } else if ((n32 & 32) == 32) {
                        int tl2 = tl(n32, 31);
                        this.f13802s = tl2;
                        if (tl2 >= 0 && tl2 <= this.f13799fb) {
                            y();
                        } else {
                            throw new IOException("Invalid dynamic table size update " + this.f13802s);
                        }
                    } else if (n32 != 16 && n32 != 0) {
                        w(tl(n32, 15) - 1);
                    } else {
                        p();
                    }
                } else {
                    throw new IOException("index == 0");
                }
            }
        }

        public final void fb(int i, zn znVar) {
            this.y.add(znVar);
            int i5 = znVar.y;
            if (i != -1) {
                zn znVar2 = this.f13804zn[zn(i)];
                Intrinsics.checkNotNull(znVar2);
                i5 -= znVar2.y;
            }
            int i6 = this.f13802s;
            if (i5 > i6) {
                n3();
                return;
            }
            int gv2 = gv((this.f13798a + i5) - i6);
            if (i == -1) {
                int i8 = this.f13803v + 1;
                zn[] znVarArr = this.f13804zn;
                if (i8 > znVarArr.length) {
                    zn[] znVarArr2 = new zn[znVarArr.length * 2];
                    System.arraycopy(znVarArr, 0, znVarArr2, znVarArr.length, znVarArr.length);
                    this.f13800gv = this.f13804zn.length - 1;
                    this.f13804zn = znVarArr2;
                }
                int i10 = this.f13800gv;
                this.f13800gv = i10 - 1;
                this.f13804zn[i10] = znVar;
                this.f13803v++;
            } else {
                this.f13804zn[i + zn(i) + gv2] = znVar;
            }
            this.f13798a += i5;
        }

        public final int gv(int i) {
            int i5;
            int i6 = 0;
            if (i > 0) {
                int length = this.f13804zn.length;
                while (true) {
                    length--;
                    i5 = this.f13800gv;
                    if (length < i5 || i <= 0) {
                        break;
                    }
                    zn znVar = this.f13804zn[length];
                    Intrinsics.checkNotNull(znVar);
                    int i8 = znVar.y;
                    i -= i8;
                    this.f13798a -= i8;
                    this.f13803v--;
                    i6++;
                }
                zn[] znVarArr = this.f13804zn;
                System.arraycopy(znVarArr, i5 + 1, znVarArr, i5 + 1 + i6, this.f13803v);
                this.f13800gv += i6;
            }
            return i6;
        }

        public final zc1.s i9() throws IOException {
            boolean z2;
            int c52 = c5();
            if ((c52 & NotificationCompat.FLAG_HIGH_PRIORITY) == 128) {
                z2 = true;
            } else {
                z2 = false;
            }
            long tl2 = tl(c52, 127);
            if (z2) {
                zc1.a vVar = new zc1.v();
                f.f13774gv.n3(this.f13801n3, tl2, vVar);
                return vVar.bk();
            }
            return this.f13801n3.y5(tl2);
        }

        public final void n3() {
            ArraysKt.fill$default(this.f13804zn, null, 0, 0, 6, null);
            this.f13800gv = this.f13804zn.length - 1;
            this.f13803v = 0;
            this.f13798a = 0;
        }

        public final void p() throws IOException {
            this.y.add(new zn(gv.f13788zn.y(i9()), i9()));
        }

        public final boolean s(int i) {
            if (i >= 0 && i <= gv.f13788zn.zn().length - 1) {
                return true;
            }
            return false;
        }

        public final void t(int i) throws IOException {
            if (s(i)) {
                this.y.add(gv.f13788zn.zn()[i]);
                return;
            }
            int zn2 = zn(i - gv.f13788zn.zn().length);
            if (zn2 >= 0) {
                zn[] znVarArr = this.f13804zn;
                if (zn2 < znVarArr.length) {
                    zn znVar = znVarArr[zn2];
                    Intrinsics.checkNotNull(znVar);
                    this.y.add(znVar);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        public final int tl(int i, int i5) throws IOException {
            int i6 = i & i5;
            if (i6 < i5) {
                return i6;
            }
            int i8 = 0;
            while (true) {
                int c52 = c5();
                if ((c52 & NotificationCompat.FLAG_HIGH_PRIORITY) != 0) {
                    i5 += (c52 & 127) << i8;
                    i8 += 7;
                } else {
                    return i5 + (c52 << i8);
                }
            }
        }

        public final List<zn> v() {
            List<zn> list = CollectionsKt.toList(this.y);
            this.y.clear();
            return list;
        }

        public final void w(int i) throws IOException {
            this.y.add(new zn(a(i), i9()));
        }

        public final void wz(int i) throws IOException {
            fb(-1, new zn(a(i), i9()));
        }

        public final void xc() throws IOException {
            fb(-1, new zn(gv.f13788zn.y(i9()), i9()));
        }

        public final void y() {
            int i = this.f13802s;
            int i5 = this.f13798a;
            if (i < i5) {
                if (i == 0) {
                    n3();
                } else {
                    gv(i5 - i);
                }
            }
        }

        public final int zn(int i) {
            return this.f13800gv + 1 + i;
        }

        public /* synthetic */ y(ta taVar, int i, int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
            this(taVar, i, (i6 & 4) != 0 ? i : i5);
        }
    }
}
