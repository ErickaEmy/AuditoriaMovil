package o6;

import java.io.EOFException;
import java.io.IOException;
import java.math.BigDecimal;
import o6.f;
/* loaded from: classes.dex */
public final class tl extends f {

    /* renamed from: co  reason: collision with root package name */
    public int f12214co;

    /* renamed from: f3  reason: collision with root package name */
    public String f12215f3;

    /* renamed from: p  reason: collision with root package name */
    public final zc1.v f12216p;

    /* renamed from: r  reason: collision with root package name */
    public int f12217r;

    /* renamed from: w  reason: collision with root package name */
    public final zc1.fb f12218w;

    /* renamed from: z  reason: collision with root package name */
    public long f12219z;

    /* renamed from: n  reason: collision with root package name */
    public static final zc1.s f12213n = zc1.s.a("'\\");

    /* renamed from: c  reason: collision with root package name */
    public static final zc1.s f12209c = zc1.s.a("\"\\");

    /* renamed from: d0  reason: collision with root package name */
    public static final zc1.s f12211d0 = zc1.s.a("{}[]:, \n\t\r\f/\\;#=");

    /* renamed from: fh  reason: collision with root package name */
    public static final zc1.s f12212fh = zc1.s.a("\n\r");

    /* renamed from: d  reason: collision with root package name */
    public static final zc1.s f12210d = zc1.s.a("*/");

    public tl(zc1.fb fbVar) {
        if (fbVar != null) {
            this.f12218w = fbVar;
            this.f12216p = fbVar.zn();
            j(6);
            return;
        }
        throw new NullPointerException("source == null");
    }

    public final boolean ad(int i) throws IOException {
        if (i != 9 && i != 10 && i != 12 && i != 13 && i != 32) {
            if (i != 35) {
                if (i != 44) {
                    if (i != 47 && i != 61) {
                        if (i != 123 && i != 125 && i != 58) {
                            if (i != 59) {
                                switch (i) {
                                    case 91:
                                    case 93:
                                        return false;
                                    case 92:
                                        break;
                                    default:
                                        return true;
                                }
                            }
                        } else {
                            return false;
                        }
                    }
                } else {
                    return false;
                }
            }
            yc();
            return false;
        }
        return false;
    }

    @Override // o6.f
    public String b() throws IOException {
        String u2;
        int i = this.f12214co;
        if (i == 0) {
            i = m();
        }
        if (i == 10) {
            u2 = l();
        } else if (i == 9) {
            u2 = qj(f12209c);
        } else if (i == 8) {
            u2 = qj(f12213n);
        } else if (i == 11) {
            u2 = this.f12215f3;
            this.f12215f3 = null;
        } else if (i == 16) {
            u2 = Long.toString(this.f12219z);
        } else if (i == 17) {
            u2 = this.f12216p.u(this.f12217r);
        } else {
            throw new s("Expected a string but was " + yt() + " at path " + getPath());
        }
        this.f12214co = 0;
        int[] iArr = this.f12158s;
        int i5 = this.y - 1;
        iArr[i5] = iArr[i5] + 1;
        return u2;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f12214co = 0;
        this.f12160v[0] = 8;
        this.y = 1;
        this.f12216p.s();
        this.f12218w.close();
    }

    public final void cs(zc1.s sVar) throws IOException {
        while (true) {
            long w92 = this.f12218w.w9(sVar);
            if (w92 != -1) {
                if (this.f12216p.ud(w92) == 92) {
                    this.f12216p.skip(w92 + 1);
                    x5();
                } else {
                    this.f12216p.skip(w92 + 1);
                    return;
                }
            } else {
                throw ap("Unterminated string");
            }
        }
    }

    @Override // o6.f
    public void ct() throws IOException {
        if (!this.f12159t) {
            int i = this.f12214co;
            if (i == 0) {
                i = m();
            }
            if (i == 14) {
                yk();
            } else if (i == 13) {
                cs(f12209c);
            } else if (i == 12) {
                cs(f12213n);
            } else if (i != 15) {
                throw new s("Expected a name but was " + yt() + " at path " + getPath());
            }
            this.f12214co = 0;
            this.f12157fb[this.y - 1] = "null";
            return;
        }
        f.n3 yt2 = yt();
        cy();
        throw new s("Cannot skip unexpected " + yt2 + " at " + getPath());
    }

    public String cy() throws IOException {
        String str;
        int i = this.f12214co;
        if (i == 0) {
            i = m();
        }
        if (i == 14) {
            str = l();
        } else if (i == 13) {
            str = qj(f12209c);
        } else if (i == 12) {
            str = qj(f12213n);
        } else if (i == 15) {
            str = this.f12215f3;
            this.f12215f3 = null;
        } else {
            throw new s("Expected a name but was " + yt() + " at path " + getPath());
        }
        this.f12214co = 0;
        this.f12157fb[this.y - 1] = str;
        return str;
    }

    @Override // o6.f
    public long d() throws IOException {
        String qj2;
        int i = this.f12214co;
        if (i == 0) {
            i = m();
        }
        if (i == 16) {
            this.f12214co = 0;
            int[] iArr = this.f12158s;
            int i5 = this.y - 1;
            iArr[i5] = iArr[i5] + 1;
            return this.f12219z;
        }
        if (i == 17) {
            this.f12215f3 = this.f12216p.u(this.f12217r);
        } else if (i != 9 && i != 8) {
            if (i != 11) {
                throw new s("Expected a long but was " + yt() + " at path " + getPath());
            }
        } else {
            if (i == 9) {
                qj2 = qj(f12209c);
            } else {
                qj2 = qj(f12213n);
            }
            this.f12215f3 = qj2;
            try {
                long parseLong = Long.parseLong(qj2);
                this.f12214co = 0;
                int[] iArr2 = this.f12158s;
                int i6 = this.y - 1;
                iArr2[i6] = iArr2[i6] + 1;
                return parseLong;
            } catch (NumberFormatException unused) {
            }
        }
        this.f12214co = 11;
        try {
            long longValueExact = new BigDecimal(this.f12215f3).longValueExact();
            this.f12215f3 = null;
            this.f12214co = 0;
            int[] iArr3 = this.f12158s;
            int i8 = this.y - 1;
            iArr3[i8] = iArr3[i8] + 1;
            return longValueExact;
        } catch (ArithmeticException | NumberFormatException unused2) {
            throw new s("Expected a long but was " + this.f12215f3 + " at path " + getPath());
        }
    }

    @Override // o6.f
    public int dm(f.y yVar) throws IOException {
        int[] iArr;
        int i;
        int i5 = this.f12214co;
        if (i5 == 0) {
            i5 = m();
        }
        if (i5 < 8 || i5 > 11) {
            return -1;
        }
        if (i5 == 11) {
            return o0(this.f12215f3, yVar);
        }
        int f4 = this.f12218w.f(yVar.f12171n3);
        if (f4 != -1) {
            this.f12214co = 0;
            int[] iArr2 = this.f12158s;
            int i6 = this.y - 1;
            iArr2[i6] = iArr2[i6] + 1;
            return f4;
        }
        String b2 = b();
        int o02 = o0(b2, yVar);
        if (o02 == -1) {
            this.f12214co = 11;
            this.f12215f3 = b2;
            this.f12158s[this.y - 1] = iArr[i] - 1;
        }
        return o02;
    }

    public final void ix() throws IOException {
        long m2;
        long w92 = this.f12218w.w9(f12212fh);
        zc1.v vVar = this.f12216p;
        if (w92 != -1) {
            m2 = w92 + 1;
        } else {
            m2 = vVar.m();
        }
        vVar.skip(m2);
    }

    @Override // o6.f
    public void j5() throws IOException {
        if (mt()) {
            this.f12215f3 = cy();
            this.f12214co = 11;
        }
    }

    @Override // o6.f
    public int jz(f.y yVar) throws IOException {
        int i = this.f12214co;
        if (i == 0) {
            i = m();
        }
        if (i < 12 || i > 15) {
            return -1;
        }
        if (i == 15) {
            return pq(this.f12215f3, yVar);
        }
        int f4 = this.f12218w.f(yVar.f12171n3);
        if (f4 != -1) {
            this.f12214co = 0;
            this.f12157fb[this.y - 1] = yVar.y[f4];
            return f4;
        }
        String str = this.f12157fb[this.y - 1];
        String cy2 = cy();
        int pq2 = pq(cy2, yVar);
        if (pq2 == -1) {
            this.f12214co = 15;
            this.f12215f3 = cy2;
            this.f12157fb[this.y - 1] = str;
        }
        return pq2;
    }

    public final String l() throws IOException {
        long w92 = this.f12218w.w9(f12211d0);
        if (w92 != -1) {
            return this.f12216p.u(w92);
        }
        return this.f12216p.wf();
    }

    public final int m() throws IOException {
        int[] iArr = this.f12160v;
        int i = this.y;
        int i5 = iArr[i - 1];
        if (i5 == 1) {
            iArr[i - 1] = 2;
        } else if (i5 == 2) {
            int qk2 = qk(true);
            this.f12216p.readByte();
            if (qk2 != 44) {
                if (qk2 != 59) {
                    if (qk2 == 93) {
                        this.f12214co = 4;
                        return 4;
                    }
                    throw ap("Unterminated array");
                }
                yc();
            }
        } else if (i5 != 3 && i5 != 5) {
            if (i5 == 4) {
                iArr[i - 1] = 5;
                int qk3 = qk(true);
                this.f12216p.readByte();
                if (qk3 != 58) {
                    if (qk3 == 61) {
                        yc();
                        if (this.f12218w.gv(1L) && this.f12216p.ud(0L) == 62) {
                            this.f12216p.readByte();
                        }
                    } else {
                        throw ap("Expected ':'");
                    }
                }
            } else if (i5 == 6) {
                iArr[i - 1] = 7;
            } else if (i5 == 7) {
                if (qk(false) == -1) {
                    this.f12214co = 18;
                    return 18;
                }
                yc();
            } else if (i5 != 9) {
                if (i5 == 8) {
                    throw new IllegalStateException("JsonReader is closed");
                }
            } else {
                throw null;
            }
        } else {
            iArr[i - 1] = 4;
            if (i5 == 5) {
                int qk4 = qk(true);
                this.f12216p.readByte();
                if (qk4 != 44) {
                    if (qk4 != 59) {
                        if (qk4 == 125) {
                            this.f12214co = 2;
                            return 2;
                        }
                        throw ap("Unterminated object");
                    }
                    yc();
                }
            }
            int qk5 = qk(true);
            if (qk5 != 34) {
                if (qk5 != 39) {
                    if (qk5 != 125) {
                        yc();
                        if (ad((char) qk5)) {
                            this.f12214co = 14;
                            return 14;
                        }
                        throw ap("Expected name");
                    } else if (i5 != 5) {
                        this.f12216p.readByte();
                        this.f12214co = 2;
                        return 2;
                    } else {
                        throw ap("Expected name");
                    }
                }
                this.f12216p.readByte();
                yc();
                this.f12214co = 12;
                return 12;
            }
            this.f12216p.readByte();
            this.f12214co = 13;
            return 13;
        }
        int qk6 = qk(true);
        if (qk6 != 34) {
            if (qk6 != 39) {
                if (qk6 != 44 && qk6 != 59) {
                    if (qk6 != 91) {
                        if (qk6 != 93) {
                            if (qk6 != 123) {
                                int vp2 = vp();
                                if (vp2 != 0) {
                                    return vp2;
                                }
                                int w22 = w2();
                                if (w22 != 0) {
                                    return w22;
                                }
                                if (ad(this.f12216p.ud(0L))) {
                                    yc();
                                    this.f12214co = 10;
                                    return 10;
                                }
                                throw ap("Expected value");
                            }
                            this.f12216p.readByte();
                            this.f12214co = 1;
                            return 1;
                        } else if (i5 == 1) {
                            this.f12216p.readByte();
                            this.f12214co = 4;
                            return 4;
                        }
                    } else {
                        this.f12216p.readByte();
                        this.f12214co = 3;
                        return 3;
                    }
                }
                if (i5 != 1 && i5 != 2) {
                    throw ap("Unexpected value");
                }
                yc();
                this.f12214co = 7;
                return 7;
            }
            yc();
            this.f12216p.readByte();
            this.f12214co = 8;
            return 8;
        }
        this.f12216p.readByte();
        this.f12214co = 9;
        return 9;
    }

    @Override // o6.f
    public boolean mt() throws IOException {
        int i = this.f12214co;
        if (i == 0) {
            i = m();
        }
        if (i != 2 && i != 4 && i != 18) {
            return true;
        }
        return false;
    }

    public final int o0(String str, f.y yVar) {
        int length = yVar.y.length;
        for (int i = 0; i < length; i++) {
            if (str.equals(yVar.y[i])) {
                this.f12214co = 0;
                int[] iArr = this.f12158s;
                int i5 = this.y - 1;
                iArr[i5] = iArr[i5] + 1;
                return i;
            }
        }
        return -1;
    }

    @Override // o6.f
    public void o4() throws IOException {
        if (!this.f12159t) {
            int i = 0;
            do {
                int i5 = this.f12214co;
                if (i5 == 0) {
                    i5 = m();
                }
                if (i5 == 3) {
                    j(1);
                } else if (i5 == 1) {
                    j(3);
                } else {
                    if (i5 == 4) {
                        i--;
                        if (i >= 0) {
                            this.y--;
                        } else {
                            throw new s("Expected a value but was " + yt() + " at path " + getPath());
                        }
                    } else if (i5 == 2) {
                        i--;
                        if (i >= 0) {
                            this.y--;
                        } else {
                            throw new s("Expected a value but was " + yt() + " at path " + getPath());
                        }
                    } else if (i5 != 14 && i5 != 10) {
                        if (i5 != 9 && i5 != 13) {
                            if (i5 != 8 && i5 != 12) {
                                if (i5 == 17) {
                                    this.f12216p.skip(this.f12217r);
                                } else if (i5 == 18) {
                                    throw new s("Expected a value but was " + yt() + " at path " + getPath());
                                }
                            } else {
                                cs(f12213n);
                            }
                        } else {
                            cs(f12209c);
                        }
                    } else {
                        yk();
                    }
                    this.f12214co = 0;
                }
                i++;
                this.f12214co = 0;
            } while (i != 0);
            int[] iArr = this.f12158s;
            int i6 = this.y;
            int i8 = i6 - 1;
            iArr[i8] = iArr[i8] + 1;
            this.f12157fb[i6 - 1] = "null";
            return;
        }
        throw new s("Cannot skip unexpected " + yt() + " at " + getPath());
    }

    @Override // o6.f
    public void p() throws IOException {
        int i = this.f12214co;
        if (i == 0) {
            i = m();
        }
        if (i == 2) {
            int i5 = this.y;
            int i6 = i5 - 1;
            this.y = i6;
            this.f12157fb[i6] = null;
            int[] iArr = this.f12158s;
            int i8 = i5 - 2;
            iArr[i8] = iArr[i8] + 1;
            this.f12214co = 0;
            return;
        }
        throw new s("Expected END_OBJECT but was " + yt() + " at path " + getPath());
    }

    public final int pq(String str, f.y yVar) {
        int length = yVar.y.length;
        for (int i = 0; i < length; i++) {
            if (str.equals(yVar.y[i])) {
                this.f12214co = 0;
                this.f12157fb[this.y - 1] = str;
                return i;
            }
        }
        return -1;
    }

    public final String qj(zc1.s sVar) throws IOException {
        StringBuilder sb = null;
        while (true) {
            long w92 = this.f12218w.w9(sVar);
            if (w92 != -1) {
                if (this.f12216p.ud(w92) == 92) {
                    if (sb == null) {
                        sb = new StringBuilder();
                    }
                    sb.append(this.f12216p.u(w92));
                    this.f12216p.readByte();
                    sb.append(x5());
                } else if (sb == null) {
                    String u2 = this.f12216p.u(w92);
                    this.f12216p.readByte();
                    return u2;
                } else {
                    sb.append(this.f12216p.u(w92));
                    this.f12216p.readByte();
                    return sb.toString();
                }
            } else {
                throw ap("Unterminated string");
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0025, code lost:
        r6.f12216p.skip(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002d, code lost:
        if (r2 != 47) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0037, code lost:
        if (r6.f12218w.gv(2) != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0039, code lost:
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003a, code lost:
        yc();
        r3 = r6.f12216p.ud(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0047, code lost:
        if (r3 == 42) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0049, code lost:
        if (r3 == 47) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004b, code lost:
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004c, code lost:
        r6.f12216p.readByte();
        r6.f12216p.readByte();
        ix();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005a, code lost:
        r6.f12216p.readByte();
        r6.f12216p.readByte();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0068, code lost:
        if (ro() == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0071, code lost:
        throw ap("Unterminated comment");
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0074, code lost:
        if (r2 != 35) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0076, code lost:
        yc();
        ix();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007d, code lost:
        return r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int qk(boolean r7) throws java.io.IOException {
        /*
            r6 = this;
            r0 = 0
        L1:
            r1 = 0
        L2:
            zc1.fb r2 = r6.f12218w
            int r3 = r1 + 1
            long r4 = (long) r3
            boolean r2 = r2.gv(r4)
            if (r2 == 0) goto L80
            zc1.v r2 = r6.f12216p
            long r4 = (long) r1
            byte r2 = r2.ud(r4)
            r4 = 10
            if (r2 == r4) goto L7e
            r4 = 32
            if (r2 == r4) goto L7e
            r4 = 13
            if (r2 == r4) goto L7e
            r4 = 9
            if (r2 != r4) goto L25
            goto L7e
        L25:
            zc1.v r3 = r6.f12216p
            long r4 = (long) r1
            r3.skip(r4)
            r1 = 47
            if (r2 != r1) goto L72
            zc1.fb r3 = r6.f12218w
            r4 = 2
            boolean r3 = r3.gv(r4)
            if (r3 != 0) goto L3a
            return r2
        L3a:
            r6.yc()
            zc1.v r3 = r6.f12216p
            r4 = 1
            byte r3 = r3.ud(r4)
            r4 = 42
            if (r3 == r4) goto L5a
            if (r3 == r1) goto L4c
            return r2
        L4c:
            zc1.v r1 = r6.f12216p
            r1.readByte()
            zc1.v r1 = r6.f12216p
            r1.readByte()
            r6.ix()
            goto L1
        L5a:
            zc1.v r1 = r6.f12216p
            r1.readByte()
            zc1.v r1 = r6.f12216p
            r1.readByte()
            boolean r1 = r6.ro()
            if (r1 == 0) goto L6b
            goto L1
        L6b:
            java.lang.String r7 = "Unterminated comment"
            o6.c5 r7 = r6.ap(r7)
            throw r7
        L72:
            r1 = 35
            if (r2 != r1) goto L7d
            r6.yc()
            r6.ix()
            goto L1
        L7d:
            return r2
        L7e:
            r1 = r3
            goto L2
        L80:
            if (r7 != 0) goto L84
            r7 = -1
            return r7
        L84:
            java.io.EOFException r7 = new java.io.EOFException
            java.lang.String r0 = "End of input"
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: o6.tl.qk(boolean):int");
    }

    @Override // o6.f
    public boolean r() throws IOException {
        int i = this.f12214co;
        if (i == 0) {
            i = m();
        }
        if (i == 5) {
            this.f12214co = 0;
            int[] iArr = this.f12158s;
            int i5 = this.y - 1;
            iArr[i5] = iArr[i5] + 1;
            return true;
        } else if (i == 6) {
            this.f12214co = 0;
            int[] iArr2 = this.f12158s;
            int i6 = this.y - 1;
            iArr2[i6] = iArr2[i6] + 1;
            return false;
        } else {
            throw new s("Expected a boolean but was " + yt() + " at path " + getPath());
        }
    }

    public final boolean ro() throws IOException {
        boolean z2;
        long m2;
        zc1.fb fbVar = this.f12218w;
        zc1.s sVar = f12210d;
        long hw2 = fbVar.hw(sVar);
        if (hw2 != -1) {
            z2 = true;
        } else {
            z2 = false;
        }
        zc1.v vVar = this.f12216p;
        if (z2) {
            m2 = hw2 + sVar.j();
        } else {
            m2 = vVar.m();
        }
        vVar.skip(m2);
        return z2;
    }

    @Override // o6.f
    public void s() throws IOException {
        int i = this.f12214co;
        if (i == 0) {
            i = m();
        }
        if (i == 4) {
            int i5 = this.y;
            this.y = i5 - 1;
            int[] iArr = this.f12158s;
            int i6 = i5 - 2;
            iArr[i6] = iArr[i6] + 1;
            this.f12214co = 0;
            return;
        }
        throw new s("Expected END_ARRAY but was " + yt() + " at path " + getPath());
    }

    @Override // o6.f
    public int ta() throws IOException {
        String qj2;
        int i = this.f12214co;
        if (i == 0) {
            i = m();
        }
        if (i == 16) {
            long j2 = this.f12219z;
            int i5 = (int) j2;
            if (j2 == i5) {
                this.f12214co = 0;
                int[] iArr = this.f12158s;
                int i6 = this.y - 1;
                iArr[i6] = iArr[i6] + 1;
                return i5;
            }
            throw new s("Expected an int but was " + this.f12219z + " at path " + getPath());
        }
        if (i == 17) {
            this.f12215f3 = this.f12216p.u(this.f12217r);
        } else if (i != 9 && i != 8) {
            if (i != 11) {
                throw new s("Expected an int but was " + yt() + " at path " + getPath());
            }
        } else {
            if (i == 9) {
                qj2 = qj(f12209c);
            } else {
                qj2 = qj(f12213n);
            }
            this.f12215f3 = qj2;
            try {
                int parseInt = Integer.parseInt(qj2);
                this.f12214co = 0;
                int[] iArr2 = this.f12158s;
                int i8 = this.y - 1;
                iArr2[i8] = iArr2[i8] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        }
        this.f12214co = 11;
        try {
            double parseDouble = Double.parseDouble(this.f12215f3);
            int i10 = (int) parseDouble;
            if (i10 == parseDouble) {
                this.f12215f3 = null;
                this.f12214co = 0;
                int[] iArr3 = this.f12158s;
                int i11 = this.y - 1;
                iArr3[i11] = iArr3[i11] + 1;
                return i10;
            }
            throw new s("Expected an int but was " + this.f12215f3 + " at path " + getPath());
        } catch (NumberFormatException unused2) {
            throw new s("Expected an int but was " + this.f12215f3 + " at path " + getPath());
        }
    }

    public String toString() {
        return "JsonReader(" + this.f12218w + ")";
    }

    @Override // o6.f
    public <T> T ud() throws IOException {
        int i = this.f12214co;
        if (i == 0) {
            i = m();
        }
        if (i == 7) {
            this.f12214co = 0;
            int[] iArr = this.f12158s;
            int i5 = this.y - 1;
            iArr[i5] = iArr[i5] + 1;
            return null;
        }
        throw new s("Expected null but was " + yt() + " at path " + getPath());
    }

    @Override // o6.f
    public void v() throws IOException {
        int i = this.f12214co;
        if (i == 0) {
            i = m();
        }
        if (i == 1) {
            j(3);
            this.f12214co = 0;
            return;
        }
        throw new s("Expected BEGIN_OBJECT but was " + yt() + " at path " + getPath());
    }

    public final int vp() throws IOException {
        String str;
        String str2;
        int i;
        byte ud2 = this.f12216p.ud(0L);
        if (ud2 != 116 && ud2 != 84) {
            if (ud2 != 102 && ud2 != 70) {
                if (ud2 != 110 && ud2 != 78) {
                    return 0;
                }
                str = "null";
                str2 = "NULL";
                i = 7;
            } else {
                str = "false";
                str2 = "FALSE";
                i = 6;
            }
        } else {
            str = "true";
            str2 = "TRUE";
            i = 5;
        }
        int length = str.length();
        int i5 = 1;
        while (i5 < length) {
            int i6 = i5 + 1;
            if (!this.f12218w.gv(i6)) {
                return 0;
            }
            byte ud3 = this.f12216p.ud(i5);
            if (ud3 != str.charAt(i5) && ud3 != str2.charAt(i5)) {
                return 0;
            }
            i5 = i6;
        }
        if (this.f12218w.gv(length + 1) && ad(this.f12216p.ud(length))) {
            return 0;
        }
        this.f12216p.skip(length);
        this.f12214co = i;
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x0081, code lost:
        if (ad(r11) != false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0083, code lost:
        if (r6 != 2) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0085, code lost:
        if (r7 == false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x008b, code lost:
        if (r8 != Long.MIN_VALUE) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x008d, code lost:
        if (r10 == false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0091, code lost:
        if (r8 != 0) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0093, code lost:
        if (r10 != false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0095, code lost:
        if (r10 == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0098, code lost:
        r8 = -r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0099, code lost:
        r16.f12219z = r8;
        r16.f12216p.skip(r5);
        r16.f12214co = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00a5, code lost:
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00a6, code lost:
        if (r6 == 2) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00a9, code lost:
        if (r6 == 4) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00ac, code lost:
        if (r6 != 7) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00af, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00b0, code lost:
        r16.f12217r = r5;
        r16.f12214co = 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00b6, code lost:
        return 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00b7, code lost:
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int w2() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 221
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o6.tl.w2():int");
    }

    @Override // o6.f
    public double x4() throws IOException {
        int i = this.f12214co;
        if (i == 0) {
            i = m();
        }
        if (i == 16) {
            this.f12214co = 0;
            int[] iArr = this.f12158s;
            int i5 = this.y - 1;
            iArr[i5] = iArr[i5] + 1;
            return this.f12219z;
        }
        if (i == 17) {
            this.f12215f3 = this.f12216p.u(this.f12217r);
        } else if (i == 9) {
            this.f12215f3 = qj(f12209c);
        } else if (i == 8) {
            this.f12215f3 = qj(f12213n);
        } else if (i == 10) {
            this.f12215f3 = l();
        } else if (i != 11) {
            throw new s("Expected a double but was " + yt() + " at path " + getPath());
        }
        this.f12214co = 11;
        try {
            double parseDouble = Double.parseDouble(this.f12215f3);
            if (!this.f12156f && (Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
                throw new c5("JSON forbids NaN and infinities: " + parseDouble + " at path " + getPath());
            }
            this.f12215f3 = null;
            this.f12214co = 0;
            int[] iArr2 = this.f12158s;
            int i6 = this.y - 1;
            iArr2[i6] = iArr2[i6] + 1;
            return parseDouble;
        } catch (NumberFormatException unused) {
            throw new s("Expected a double but was " + this.f12215f3 + " at path " + getPath());
        }
    }

    public final char x5() throws IOException {
        int i;
        if (this.f12218w.gv(1L)) {
            byte readByte = this.f12216p.readByte();
            if (readByte != 10 && readByte != 34 && readByte != 39 && readByte != 47 && readByte != 92) {
                if (readByte != 98) {
                    if (readByte != 102) {
                        if (readByte == 110) {
                            return '\n';
                        }
                        if (readByte != 114) {
                            if (readByte != 116) {
                                if (readByte != 117) {
                                    if (this.f12156f) {
                                        return (char) readByte;
                                    }
                                    throw ap("Invalid escape sequence: \\" + ((char) readByte));
                                } else if (this.f12218w.gv(4L)) {
                                    char c2 = 0;
                                    for (int i5 = 0; i5 < 4; i5++) {
                                        byte ud2 = this.f12216p.ud(i5);
                                        char c4 = (char) (c2 << 4);
                                        if (ud2 >= 48 && ud2 <= 57) {
                                            i = ud2 - 48;
                                        } else if (ud2 >= 97 && ud2 <= 102) {
                                            i = ud2 - 87;
                                        } else if (ud2 < 65 || ud2 > 70) {
                                            throw ap("\\u" + this.f12216p.u(4L));
                                        } else {
                                            i = ud2 - 55;
                                        }
                                        c2 = (char) (c4 + i);
                                    }
                                    this.f12216p.skip(4L);
                                    return c2;
                                } else {
                                    throw new EOFException("Unterminated escape sequence at path " + getPath());
                                }
                            }
                            return '\t';
                        }
                        return '\r';
                    }
                    return '\f';
                }
                return '\b';
            }
            return (char) readByte;
        }
        throw ap("Unterminated escape sequence");
    }

    @Override // o6.f
    public void y() throws IOException {
        int i = this.f12214co;
        if (i == 0) {
            i = m();
        }
        if (i == 3) {
            j(1);
            this.f12158s[this.y - 1] = 0;
            this.f12214co = 0;
            return;
        }
        throw new s("Expected BEGIN_ARRAY but was " + yt() + " at path " + getPath());
    }

    public final void yc() throws IOException {
        if (this.f12156f) {
            return;
        }
        throw ap("Use JsonReader.setLenient(true) to accept malformed JSON");
    }

    public final void yk() throws IOException {
        long w92 = this.f12218w.w9(f12211d0);
        zc1.v vVar = this.f12216p;
        if (w92 == -1) {
            w92 = vVar.m();
        }
        vVar.skip(w92);
    }

    @Override // o6.f
    public f.n3 yt() throws IOException {
        int i = this.f12214co;
        if (i == 0) {
            i = m();
        }
        switch (i) {
            case 1:
                return f.n3.BEGIN_OBJECT;
            case 2:
                return f.n3.END_OBJECT;
            case 3:
                return f.n3.BEGIN_ARRAY;
            case 4:
                return f.n3.END_ARRAY;
            case 5:
            case 6:
                return f.n3.BOOLEAN;
            case 7:
                return f.n3.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return f.n3.STRING;
            case 12:
            case 13:
            case 14:
            case 15:
                return f.n3.NAME;
            case 16:
            case 17:
                return f.n3.NUMBER;
            case 18:
                return f.n3.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }
}
