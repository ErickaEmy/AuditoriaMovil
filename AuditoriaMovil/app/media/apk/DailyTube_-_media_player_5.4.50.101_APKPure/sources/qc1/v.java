package qc1;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;
import kc1.r;
import kc1.rz;
import kc1.tl;
import kc1.wz;
import kc1.z;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import zc1.s;
/* loaded from: classes.dex */
public final class v {

    /* renamed from: n3  reason: collision with root package name */
    public static final zc1.s f12803n3;
    public static final zc1.s y;

    static {
        s.y yVar = zc1.s.fb;
        y = yVar.gv("\"\\");
        f12803n3 = yVar.gv("\t ,=");
    }

    public static final String a(zc1.v vVar) {
        long w92 = vVar.w9(f12803n3);
        if (w92 == -1) {
            w92 = vVar.m();
        }
        if (w92 != 0) {
            return vVar.u(w92);
        }
        return null;
    }

    public static final boolean c5(zc1.v vVar, byte b2) {
        if (!vVar.nf() && vVar.ud(0L) == b2) {
            return true;
        }
        return false;
    }

    public static final void fb(wz receiveHeaders, r url, z headers) {
        Intrinsics.checkNotNullParameter(receiveHeaders, "$this$receiveHeaders");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(headers, "headers");
        if (receiveHeaders == wz.y) {
            return;
        }
        List<tl> v2 = tl.f9932wz.v(url, headers);
        if (v2.isEmpty()) {
            return;
        }
        receiveHeaders.saveFromResponse(url, v2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x0085, code lost:
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0085, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void gv(zc1.v r7, java.util.List<kc1.s> r8) throws java.io.EOFException {
        /*
            r0 = 0
        L1:
            r1 = r0
        L2:
            if (r1 != 0) goto Le
            s(r7)
            java.lang.String r1 = a(r7)
            if (r1 != 0) goto Le
            return
        Le:
            boolean r2 = s(r7)
            java.lang.String r3 = a(r7)
            if (r3 != 0) goto L2c
            boolean r7 = r7.nf()
            if (r7 != 0) goto L1f
            return
        L1f:
            kc1.s r7 = new kc1.s
            java.util.Map r0 = kotlin.collections.MapsKt.emptyMap()
            r7.<init>(r1, r0)
            r8.add(r7)
            return
        L2c:
            r4 = 61
            byte r4 = (byte) r4
            int r5 = lc1.n3.a8(r7, r4)
            boolean r6 = s(r7)
            if (r2 != 0) goto L68
            if (r6 != 0) goto L41
            boolean r2 = r7.nf()
            if (r2 == 0) goto L68
        L41:
            kc1.s r2 = new kc1.s
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r3)
            java.lang.String r3 = "="
            java.lang.String r3 = kotlin.text.StringsKt.repeat(r3, r5)
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            java.util.Map r3 = java.util.Collections.singletonMap(r0, r3)
            java.lang.String r4 = "Collections.singletonMap…ek + \"=\".repeat(eqCount))"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            r2.<init>(r1, r3)
            r8.add(r2)
            goto L1
        L68:
            java.util.LinkedHashMap r2 = new java.util.LinkedHashMap
            r2.<init>()
            int r6 = lc1.n3.a8(r7, r4)
            int r5 = r5 + r6
        L72:
            if (r3 != 0) goto L83
            java.lang.String r3 = a(r7)
            boolean r5 = s(r7)
            if (r5 == 0) goto L7f
            goto L85
        L7f:
            int r5 = lc1.n3.a8(r7, r4)
        L83:
            if (r5 != 0) goto L90
        L85:
            kc1.s r4 = new kc1.s
            r4.<init>(r1, r2)
            r8.add(r4)
            r1 = r3
            goto L2
        L90:
            r6 = 1
            if (r5 <= r6) goto L94
            return
        L94:
            boolean r6 = s(r7)
            if (r6 == 0) goto L9b
            return
        L9b:
            r6 = 34
            byte r6 = (byte) r6
            boolean r6 = c5(r7, r6)
            if (r6 == 0) goto La9
            java.lang.String r6 = v(r7)
            goto Lad
        La9:
            java.lang.String r6 = a(r7)
        Lad:
            if (r6 == 0) goto Lc7
            java.lang.Object r3 = r2.put(r3, r6)
            java.lang.String r3 = (java.lang.String) r3
            if (r3 == 0) goto Lb8
            return
        Lb8:
            boolean r3 = s(r7)
            if (r3 != 0) goto Lc5
            boolean r3 = r7.nf()
            if (r3 != 0) goto Lc5
            return
        Lc5:
            r3 = r0
            goto L72
        Lc7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: qc1.v.gv(zc1.v, java.util.List):void");
    }

    public static final List<kc1.s> n3(z parseChallenges, String headerName) {
        Intrinsics.checkNotNullParameter(parseChallenges, "$this$parseChallenges");
        Intrinsics.checkNotNullParameter(headerName, "headerName");
        ArrayList arrayList = new ArrayList();
        int size = parseChallenges.size();
        for (int i = 0; i < size; i++) {
            if (StringsKt.equals(headerName, parseChallenges.zn(i), true)) {
                try {
                    gv(new zc1.v().ne(parseChallenges.c5(i)), arrayList);
                } catch (EOFException e2) {
                    uc1.s.f14065zn.fb().f("Unable to parse challenge", 5, e2);
                }
            }
        }
        return arrayList;
    }

    public static final boolean s(zc1.v vVar) {
        boolean z2 = false;
        while (!vVar.nf()) {
            byte ud2 = vVar.ud(0L);
            if (ud2 != 9 && ud2 != 32) {
                if (ud2 != 44) {
                    break;
                }
                vVar.readByte();
                z2 = true;
            } else {
                vVar.readByte();
            }
        }
        return z2;
    }

    public static final String v(zc1.v vVar) throws EOFException {
        boolean z2;
        byte b2 = (byte) 34;
        if (vVar.readByte() == b2) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            zc1.v vVar2 = new zc1.v();
            while (true) {
                long w92 = vVar.w9(y);
                if (w92 == -1) {
                    return null;
                }
                if (vVar.ud(w92) == b2) {
                    vVar2.write(vVar, w92);
                    vVar.readByte();
                    return vVar2.wf();
                } else if (vVar.m() == w92 + 1) {
                    return null;
                } else {
                    vVar2.write(vVar, w92);
                    vVar.readByte();
                    vVar2.write(vVar, 1L);
                }
            }
        } else {
            throw new IllegalArgumentException("Failed requirement.");
        }
    }

    public static final boolean y(rz response) {
        Intrinsics.checkNotNullParameter(response, "response");
        return zn(response);
    }

    public static final boolean zn(rz promisesBody) {
        Intrinsics.checkNotNullParameter(promisesBody, "$this$promisesBody");
        if (Intrinsics.areEqual(promisesBody.o4().s(), "HEAD")) {
            return false;
        }
        int mt2 = promisesBody.mt();
        if (((mt2 >= 100 && mt2 < 200) || mt2 == 204 || mt2 == 304) && lc1.n3.co(promisesBody) == -1 && !StringsKt.equals("chunked", rz.d(promisesBody, "Transfer-Encoding", null, 2, null), true)) {
            return false;
        }
        return true;
    }
}
