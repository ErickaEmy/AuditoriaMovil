package ho;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import com.google.android.exoplayer2.metadata.id3.BinaryFrame;
import com.google.android.exoplayer2.metadata.id3.ChapterFrame;
import com.google.android.exoplayer2.metadata.id3.ChapterTocFrame;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.GeobFrame;
import com.google.android.exoplayer2.metadata.id3.Id3Frame;
import com.google.android.exoplayer2.metadata.id3.MlltFrame;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import com.google.android.exoplayer2.metadata.id3.UrlLinkFrame;
import hd.a;
import hd.gv;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import v5.fh;
import v5.j5;
import v5.r;
import v5.rz;
import w0.v;
import w0.zn;
import z0.x4;
/* loaded from: classes.dex */
public final class n3 extends a {

    /* renamed from: n3  reason: collision with root package name */
    public static final y f8924n3 = new y() { // from class: ho.y
        @Override // ho.n3.y
        public final boolean evaluate(int i, int i5, int i6, int i8, int i10) {
            boolean d02;
            d02 = n3.d0(i, i5, i6, i8, i10);
            return d02;
        }
    };
    @Nullable
    public final y y;

    /* renamed from: ho.n3$n3  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0107n3 {

        /* renamed from: n3  reason: collision with root package name */
        public final boolean f8925n3;
        public final int y;

        /* renamed from: zn  reason: collision with root package name */
        public final int f8926zn;

        public C0107n3(int i, boolean z2, int i5) {
            this.y = i;
            this.f8925n3 = z2;
            this.f8926zn = i5;
        }
    }

    /* loaded from: classes.dex */
    public interface y {
        boolean evaluate(int i, int i5, int i6, int i8, int i10);
    }

    public n3() {
        this(null);
    }

    public static ApicFrame a(rz rzVar, int i, int i5) {
        int c2;
        String str;
        int ej2 = rzVar.ej();
        Charset i42 = i4(ej2);
        int i6 = i - 1;
        byte[] bArr = new byte[i6];
        rzVar.t(bArr, 0, i6);
        if (i5 == 2) {
            str = "image/" + zn.v(new String(bArr, 0, 3, v.f14521n3));
            if ("image/jpg".equals(str)) {
                str = "image/jpeg";
            }
            c2 = 2;
        } else {
            c2 = c(bArr, 0);
            String v2 = zn.v(new String(bArr, 0, c2, v.f14521n3));
            if (v2.indexOf(47) == -1) {
                str = "image/" + v2;
            } else {
                str = v2;
            }
        }
        int i8 = c2 + 2;
        int n2 = n(bArr, i8, ej2);
        return new ApicFrame(str, new String(bArr, i8, n2 - i8, i42), bArr[c2 + 1] & 255, gv(bArr, n2 + x4(ej2), i6));
    }

    public static int c(byte[] bArr, int i) {
        while (i < bArr.length) {
            if (bArr[i] == 0) {
                return i;
            }
            i++;
        }
        return bArr.length;
    }

    public static ChapterTocFrame c5(rz rzVar, int i, int i5, boolean z2, int i6, @Nullable y yVar) {
        boolean z3;
        boolean z4;
        int a2 = rzVar.a();
        int c2 = c(rzVar.v(), a2);
        String str = new String(rzVar.v(), a2, c2 - a2, v.f14521n3);
        rzVar.oz(c2 + 1);
        int ej2 = rzVar.ej();
        if ((ej2 & 2) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if ((ej2 & 1) != 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        int ej3 = rzVar.ej();
        String[] strArr = new String[ej3];
        for (int i8 = 0; i8 < ej3; i8++) {
            int a3 = rzVar.a();
            int c4 = c(rzVar.v(), a3);
            strArr[i8] = new String(rzVar.v(), a3, c4 - a3, v.f14521n3);
            rzVar.oz(c4 + 1);
        }
        ArrayList arrayList = new ArrayList();
        int i10 = a2 + i;
        while (rzVar.a() < i10) {
            Id3Frame f4 = f(i5, rzVar, z2, i6, yVar);
            if (f4 != null) {
                arrayList.add(f4);
            }
        }
        return new ChapterTocFrame(str, z3, z4, strArr, (Id3Frame[]) arrayList.toArray(new Id3Frame[0]));
    }

    @Nullable
    public static TextInformationFrame co(rz rzVar, int i) {
        if (i < 1) {
            return null;
        }
        int ej2 = rzVar.ej();
        int i5 = i - 1;
        byte[] bArr = new byte[i5];
        rzVar.t(bArr, 0, i5);
        int n2 = n(bArr, 0, ej2);
        return new TextInformationFrame("TXXX", new String(bArr, 0, n2, i4(ej2)), mt(bArr, ej2, n2 + x4(ej2)));
    }

    public static /* synthetic */ boolean d0(int i, int i5, int i6, int i8, int i10) {
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:131:0x0190, code lost:
        if (r13 == 67) goto L98;
     */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.exoplayer2.metadata.id3.Id3Frame f(int r19, v5.rz r20, boolean r21, int r22, @androidx.annotation.Nullable ho.n3.y r23) {
        /*
            Method dump skipped, instructions count: 549
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ho.n3.f(int, v5.rz, boolean, int, ho.n3$y):com.google.android.exoplayer2.metadata.id3.Id3Frame");
    }

    public static String f3(int i, int i5, int i6, int i8, int i10) {
        if (i == 2) {
            return String.format(Locale.US, "%c%c%c", Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i8));
        }
        return String.format(Locale.US, "%c%c%c%c", Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i8), Integer.valueOf(i10));
    }

    public static BinaryFrame fb(rz rzVar, int i, String str) {
        byte[] bArr = new byte[i];
        rzVar.t(bArr, 0, i);
        return new BinaryFrame(str, bArr);
    }

    public static int fh(rz rzVar, int i) {
        byte[] v2 = rzVar.v();
        int a2 = rzVar.a();
        int i5 = a2;
        while (true) {
            int i6 = i5 + 1;
            if (i6 < a2 + i) {
                if ((v2[i5] & 255) == 255 && v2[i6] == 0) {
                    System.arraycopy(v2, i5 + 2, v2, i6, (i - (i5 - a2)) - 2);
                    i--;
                }
                i5 = i6;
            } else {
                return i;
            }
        }
    }

    public static byte[] gv(byte[] bArr, int i, int i5) {
        if (i5 <= i) {
            return j5.f14357a;
        }
        return Arrays.copyOfRange(bArr, i, i5);
    }

    public static Charset i4(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return v.f14521n3;
                }
                return v.f14523zn;
            }
            return v.f14520gv;
        }
        return v.f14519a;
    }

    @Nullable
    public static CommentFrame i9(rz rzVar, int i) {
        if (i < 4) {
            return null;
        }
        int ej2 = rzVar.ej();
        Charset i42 = i4(ej2);
        byte[] bArr = new byte[3];
        rzVar.t(bArr, 0, 3);
        String str = new String(bArr, 0, 3);
        int i5 = i - 4;
        byte[] bArr2 = new byte[i5];
        rzVar.t(bArr2, 0, i5);
        int n2 = n(bArr2, 0, ej2);
        String str2 = new String(bArr2, 0, n2, i42);
        int x42 = n2 + x4(ej2);
        return new CommentFrame(str, str2, w(bArr2, x42, n(bArr2, x42, ej2), i42));
    }

    public static x4<String> mt(byte[] bArr, int i, int i5) {
        if (i5 >= bArr.length) {
            return x4.o("");
        }
        x4.y x42 = x4.x4();
        int n2 = n(bArr, i5, i);
        while (i5 < n2) {
            x42.y(new String(bArr, i5, n2 - i5, i4(i)));
            i5 = x4(i) + n2;
            n2 = n(bArr, i5, i);
        }
        x4<String> s2 = x42.s();
        if (s2.isEmpty()) {
            return x4.o("");
        }
        return s2;
    }

    public static int n(byte[] bArr, int i, int i5) {
        int c2 = c(bArr, i);
        if (i5 != 0 && i5 != 3) {
            while (c2 < bArr.length - 1) {
                if ((c2 - i) % 2 == 0 && bArr[c2 + 1] == 0) {
                    return c2;
                }
                c2 = c(bArr, c2 + 1);
            }
            return bArr.length;
        }
        return c2;
    }

    @Nullable
    public static TextInformationFrame p(rz rzVar, int i, String str) {
        if (i < 1) {
            return null;
        }
        int ej2 = rzVar.ej();
        int i5 = i - 1;
        byte[] bArr = new byte[i5];
        rzVar.t(bArr, 0, i5);
        return new TextInformationFrame(str, null, mt(bArr, ej2, 0));
    }

    @Nullable
    public static UrlLinkFrame r(rz rzVar, int i) {
        if (i < 1) {
            return null;
        }
        int ej2 = rzVar.ej();
        int i5 = i - 1;
        byte[] bArr = new byte[i5];
        rzVar.t(bArr, 0, i5);
        int n2 = n(bArr, 0, ej2);
        String str = new String(bArr, 0, n2, i4(ej2));
        int x42 = n2 + x4(ej2);
        return new UrlLinkFrame("WXXX", str, w(bArr, x42, c(bArr, x42), v.f14521n3));
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0079, code lost:
        if ((r10 & 1) != 0) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0087, code lost:
        if ((r10 & androidx.core.app.NotificationCompat.FLAG_HIGH_PRIORITY) != 0) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean rz(v5.rz r18, int r19, int r20, boolean r21) {
        /*
            r1 = r18
            r0 = r19
            int r2 = r18.a()
        L8:
            int r3 = r18.y()     // Catch: java.lang.Throwable -> L22
            r4 = 1
            r5 = r20
            if (r3 < r5) goto Lac
            r3 = 3
            r6 = 0
            if (r0 < r3) goto L25
            int r7 = r18.p()     // Catch: java.lang.Throwable -> L22
            long r8 = r18.a8()     // Catch: java.lang.Throwable -> L22
            int r10 = r18.yt()     // Catch: java.lang.Throwable -> L22
            goto L2f
        L22:
            r0 = move-exception
            goto Lb0
        L25:
            int r7 = r18.x()     // Catch: java.lang.Throwable -> L22
            int r8 = r18.x()     // Catch: java.lang.Throwable -> L22
            long r8 = (long) r8
            r10 = 0
        L2f:
            r11 = 0
            if (r7 != 0) goto L3d
            int r7 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r7 != 0) goto L3d
            if (r10 != 0) goto L3d
            r1.oz(r2)
            return r4
        L3d:
            r7 = 4
            if (r0 != r7) goto L6e
            if (r21 != 0) goto L6e
            r13 = 8421504(0x808080, double:4.160776E-317)
            long r13 = r13 & r8
            int r15 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r15 == 0) goto L4e
            r1.oz(r2)
            return r6
        L4e:
            r11 = 255(0xff, double:1.26E-321)
            long r13 = r8 & r11
            r15 = 8
            long r15 = r8 >> r15
            long r15 = r15 & r11
            r17 = 7
            long r15 = r15 << r17
            long r13 = r13 | r15
            r15 = 16
            long r15 = r8 >> r15
            long r15 = r15 & r11
            r17 = 14
            long r15 = r15 << r17
            long r13 = r13 | r15
            r15 = 24
            long r8 = r8 >> r15
            long r8 = r8 & r11
            r11 = 21
            long r8 = r8 << r11
            long r8 = r8 | r13
        L6e:
            if (r0 != r7) goto L7c
            r3 = r10 & 64
            if (r3 == 0) goto L76
            r3 = 1
            goto L77
        L76:
            r3 = 0
        L77:
            r7 = r10 & 1
            if (r7 == 0) goto L8b
            goto L8c
        L7c:
            if (r0 != r3) goto L8a
            r3 = r10 & 32
            if (r3 == 0) goto L84
            r3 = 1
            goto L85
        L84:
            r3 = 0
        L85:
            r7 = r10 & 128(0x80, float:1.794E-43)
            if (r7 == 0) goto L8b
            goto L8c
        L8a:
            r3 = 0
        L8b:
            r4 = 0
        L8c:
            if (r4 == 0) goto L90
            int r3 = r3 + 4
        L90:
            long r3 = (long) r3
            int r7 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r7 >= 0) goto L99
            r1.oz(r2)
            return r6
        L99:
            int r3 = r18.y()     // Catch: java.lang.Throwable -> L22
            long r3 = (long) r3
            int r7 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r7 >= 0) goto La6
            r1.oz(r2)
            return r6
        La6:
            int r3 = (int) r8
            r1.ut(r3)     // Catch: java.lang.Throwable -> L22
            goto L8
        Lac:
            r1.oz(r2)
            return r4
        Lb0:
            r1.oz(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ho.n3.rz(v5.rz, int, int, boolean):boolean");
    }

    public static ChapterFrame s(rz rzVar, int i, int i5, boolean z2, int i6, @Nullable y yVar) {
        long j2;
        long j4;
        int a2 = rzVar.a();
        int c2 = c(rzVar.v(), a2);
        String str = new String(rzVar.v(), a2, c2 - a2, v.f14521n3);
        rzVar.oz(c2 + 1);
        int p2 = rzVar.p();
        int p3 = rzVar.p();
        long a82 = rzVar.a8();
        if (a82 == 4294967295L) {
            j2 = -1;
        } else {
            j2 = a82;
        }
        long a83 = rzVar.a8();
        if (a83 == 4294967295L) {
            j4 = -1;
        } else {
            j4 = a83;
        }
        ArrayList arrayList = new ArrayList();
        int i8 = a2 + i;
        while (rzVar.a() < i8) {
            Id3Frame f4 = f(i5, rzVar, z2, i6, yVar);
            if (f4 != null) {
                arrayList.add(f4);
            }
        }
        return new ChapterFrame(str, p2, p3, j2, j4, (Id3Frame[]) arrayList.toArray(new Id3Frame[0]));
    }

    public static GeobFrame t(rz rzVar, int i) {
        int ej2 = rzVar.ej();
        Charset i42 = i4(ej2);
        int i5 = i - 1;
        byte[] bArr = new byte[i5];
        rzVar.t(bArr, 0, i5);
        int c2 = c(bArr, 0);
        String str = new String(bArr, 0, c2, v.f14521n3);
        int i6 = c2 + 1;
        int n2 = n(bArr, i6, ej2);
        String w4 = w(bArr, i6, n2, i42);
        int x42 = n2 + x4(ej2);
        int n4 = n(bArr, x42, ej2);
        return new GeobFrame(str, w4, w(bArr, x42, n4, i42), gv(bArr, n4 + x4(ej2), i5));
    }

    @Nullable
    public static C0107n3 tl(rz rzVar) {
        int x2;
        boolean z2 = false;
        if (rzVar.y() < 10) {
            r.c5("Id3Decoder", "Data too short to be an ID3 tag");
            return null;
        }
        if (rzVar.x() != 4801587) {
            r.c5("Id3Decoder", "Unexpected first three bytes of ID3 tag header: 0x" + String.format("%06X", Integer.valueOf(x2)));
            return null;
        }
        int ej2 = rzVar.ej();
        rzVar.ut(1);
        int ej3 = rzVar.ej();
        int z62 = rzVar.z6();
        if (ej2 == 2) {
            if ((ej3 & 64) != 0) {
                r.c5("Id3Decoder", "Skipped ID3 tag with majorVersion=2 and undefined compression scheme");
                return null;
            }
        } else if (ej2 == 3) {
            if ((ej3 & 64) != 0) {
                int p2 = rzVar.p();
                rzVar.ut(p2);
                z62 -= p2 + 4;
            }
        } else if (ej2 == 4) {
            if ((ej3 & 64) != 0) {
                int z63 = rzVar.z6();
                rzVar.ut(z63 - 4);
                z62 -= z63;
            }
            if ((ej3 & 16) != 0) {
                z62 -= 10;
            }
        } else {
            r.c5("Id3Decoder", "Skipped ID3 tag with unsupported majorVersion=" + ej2);
            return null;
        }
        if (ej2 < 4 && (ej3 & NotificationCompat.FLAG_HIGH_PRIORITY) != 0) {
            z2 = true;
        }
        return new C0107n3(ej2, z2, z62);
    }

    public static String w(byte[] bArr, int i, int i5, Charset charset) {
        if (i5 > i && i5 <= bArr.length) {
            return new String(bArr, i, i5 - i, charset);
        }
        return "";
    }

    public static MlltFrame wz(rz rzVar, int i) {
        int yt2 = rzVar.yt();
        int x2 = rzVar.x();
        int x3 = rzVar.x();
        int ej2 = rzVar.ej();
        int ej3 = rzVar.ej();
        fh fhVar = new fh();
        fhVar.tl(rzVar);
        int i5 = ((i - 10) * 8) / (ej2 + ej3);
        int[] iArr = new int[i5];
        int[] iArr2 = new int[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            int s2 = fhVar.s(ej2);
            int s3 = fhVar.s(ej3);
            iArr[i6] = s2;
            iArr2[i6] = s3;
        }
        return new MlltFrame(yt2, x2, x3, iArr, iArr2);
    }

    public static int x4(int i) {
        if (i != 0 && i != 3) {
            return 2;
        }
        return 1;
    }

    public static PrivFrame xc(rz rzVar, int i) {
        byte[] bArr = new byte[i];
        rzVar.t(bArr, 0, i);
        int c2 = c(bArr, 0);
        return new PrivFrame(new String(bArr, 0, c2, v.f14521n3), gv(bArr, c2 + 1, i));
    }

    public static UrlLinkFrame z(rz rzVar, int i, String str) {
        byte[] bArr = new byte[i];
        rzVar.t(bArr, 0, i);
        return new UrlLinkFrame(str, null, new String(bArr, 0, c(bArr, 0), v.f14521n3));
    }

    @Override // hd.a
    @Nullable
    public Metadata n3(gv gvVar, ByteBuffer byteBuffer) {
        return v(byteBuffer.array(), byteBuffer.limit());
    }

    @Nullable
    public Metadata v(byte[] bArr, int i) {
        int i5;
        ArrayList arrayList = new ArrayList();
        rz rzVar = new rz(bArr, i);
        C0107n3 tl2 = tl(rzVar);
        if (tl2 == null) {
            return null;
        }
        int a2 = rzVar.a();
        if (tl2.y == 2) {
            i5 = 6;
        } else {
            i5 = 10;
        }
        int i6 = tl2.f8926zn;
        if (tl2.f8925n3) {
            i6 = fh(rzVar, tl2.f8926zn);
        }
        rzVar.j(a2 + i6);
        boolean z2 = false;
        if (!rz(rzVar, tl2.y, i5, false)) {
            if (tl2.y == 4 && rz(rzVar, 4, i5, true)) {
                z2 = true;
            } else {
                r.c5("Id3Decoder", "Failed to validate ID3 tag with majorVersion=" + tl2.y);
                return null;
            }
        }
        while (rzVar.y() >= i5) {
            Id3Frame f4 = f(tl2.y, rzVar, z2, i5, this.y);
            if (f4 != null) {
                arrayList.add(f4);
            }
        }
        return new Metadata(arrayList);
    }

    public n3(@Nullable y yVar) {
        this.y = yVar;
    }
}
