package d9;

import d9.fb;
/* loaded from: classes.dex */
public final class x extends c {
    /* JADX WARN: Removed duplicated region for block: B:16:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00af A[LOOP:4: B:30:0x00af->B:31:0x00b1, LOOP_START, PHI: r0 
      PHI: (r0v1 int) = (r0v0 int), (r0v2 int) binds: [B:15:0x0036, B:31:0x00b1] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // d9.fb
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void c5(java.nio.ByteBuffer r10) {
        /*
            r9 = this;
            int r0 = r10.position()
            int r1 = r10.limit()
            int r2 = r1 - r0
            d9.fb$y r3 = r9.f6983n3
            int r3 = r3.f7039zn
            r4 = 805306368(0x30000000, float:4.656613E-10)
            r5 = 536870912(0x20000000, float:1.0842022E-19)
            r6 = 268435456(0x10000000, float:2.5243549E-29)
            r7 = 4
            r8 = 3
            if (r3 == r8) goto L29
            if (r3 == r7) goto L2c
            if (r3 == r6) goto L2e
            if (r3 == r5) goto L27
            if (r3 != r4) goto L21
            goto L2c
        L21:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            r10.<init>()
            throw r10
        L27:
            int r2 = r2 / 3
        L29:
            int r2 = r2 * 2
            goto L2e
        L2c:
            int r2 = r2 / 2
        L2e:
            java.nio.ByteBuffer r2 = r9.t(r2)
            d9.fb$y r3 = r9.f6983n3
            int r3 = r3.f7039zn
            if (r3 == r8) goto Laf
            if (r3 == r7) goto L89
            if (r3 == r6) goto L74
            if (r3 == r5) goto L5d
            if (r3 != r4) goto L57
        L40:
            if (r0 >= r1) goto Lc4
            int r3 = r0 + 2
            byte r3 = r10.get(r3)
            r2.put(r3)
            int r3 = r0 + 3
            byte r3 = r10.get(r3)
            r2.put(r3)
            int r0 = r0 + 4
            goto L40
        L57:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            r10.<init>()
            throw r10
        L5d:
            if (r0 >= r1) goto Lc4
            int r3 = r0 + 1
            byte r3 = r10.get(r3)
            r2.put(r3)
            int r3 = r0 + 2
            byte r3 = r10.get(r3)
            r2.put(r3)
            int r0 = r0 + 3
            goto L5d
        L74:
            if (r0 >= r1) goto Lc4
            int r3 = r0 + 1
            byte r3 = r10.get(r3)
            r2.put(r3)
            byte r3 = r10.get(r0)
            r2.put(r3)
            int r0 = r0 + 2
            goto L74
        L89:
            if (r0 >= r1) goto Lc4
            float r3 = r10.getFloat(r0)
            r4 = -1082130432(0xffffffffbf800000, float:-1.0)
            r5 = 1065353216(0x3f800000, float:1.0)
            float r3 = v5.j5.w(r3, r4, r5)
            r4 = 1191181824(0x46fffe00, float:32767.0)
            float r3 = r3 * r4
            int r3 = (int) r3
            short r3 = (short) r3
            r4 = r3 & 255(0xff, float:3.57E-43)
            byte r4 = (byte) r4
            r2.put(r4)
            int r3 = r3 >> 8
            r3 = r3 & 255(0xff, float:3.57E-43)
            byte r3 = (byte) r3
            r2.put(r3)
            int r0 = r0 + 4
            goto L89
        Laf:
            if (r0 >= r1) goto Lc4
            r3 = 0
            r2.put(r3)
            byte r3 = r10.get(r0)
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r3 = r3 + (-128)
            byte r3 = (byte) r3
            r2.put(r3)
            int r0 = r0 + 1
            goto Laf
        Lc4:
            int r0 = r10.limit()
            r10.position(r0)
            r2.flip()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: d9.x.c5(java.nio.ByteBuffer):void");
    }

    @Override // d9.c
    public fb.y zn(fb.y yVar) throws fb.n3 {
        int i = yVar.f7039zn;
        if (i != 3 && i != 2 && i != 268435456 && i != 536870912 && i != 805306368 && i != 4) {
            throw new fb.n3(yVar);
        }
        if (i != 2) {
            return new fb.y(yVar.y, yVar.f7038n3, 2);
        }
        return fb.y.f7036v;
    }
}
