package okhttp3.internal.publicsuffix;

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import lc1.n3;
import uc1.s;
import zc1.fb;
import zc1.p;
import zc1.wz;
/* loaded from: classes.dex */
public final class PublicSuffixDatabase {

    /* renamed from: gv  reason: collision with root package name */
    public byte[] f12340gv;

    /* renamed from: zn  reason: collision with root package name */
    public byte[] f12342zn;

    /* renamed from: s  reason: collision with root package name */
    public static final y f12338s = new y(null);

    /* renamed from: v  reason: collision with root package name */
    public static final byte[] f12339v = {(byte) 42};

    /* renamed from: a  reason: collision with root package name */
    public static final List<String> f12336a = CollectionsKt.listOf("*");

    /* renamed from: fb  reason: collision with root package name */
    public static final PublicSuffixDatabase f12337fb = new PublicSuffixDatabase();
    public final AtomicBoolean y = new AtomicBoolean(false);

    /* renamed from: n3  reason: collision with root package name */
    public final CountDownLatch f12341n3 = new CountDownLatch(1);

    /* loaded from: classes.dex */
    public static final class y {
        public y() {
        }

        public final String n3(byte[] bArr, byte[][] bArr2, int i) {
            int i5;
            int n32;
            boolean z2;
            int n33;
            int length = bArr.length;
            int i6 = 0;
            while (i6 < length) {
                int i8 = (i6 + length) / 2;
                while (i8 > -1 && bArr[i8] != ((byte) 10)) {
                    i8--;
                }
                int i10 = i8 + 1;
                int i11 = 1;
                while (true) {
                    i5 = i10 + i11;
                    if (bArr[i5] == ((byte) 10)) {
                        break;
                    }
                    i11++;
                }
                int i12 = i5 - i10;
                int i13 = i;
                boolean z3 = false;
                int i14 = 0;
                int i15 = 0;
                while (true) {
                    if (z3) {
                        n32 = 46;
                        z2 = false;
                    } else {
                        boolean z4 = z3;
                        n32 = n3.n3(bArr2[i13][i14], 255);
                        z2 = z4;
                    }
                    n33 = n32 - n3.n3(bArr[i10 + i15], 255);
                    if (n33 != 0) {
                        break;
                    }
                    i15++;
                    i14++;
                    if (i15 == i12) {
                        break;
                    } else if (bArr2[i13].length == i14) {
                        if (i13 == bArr2.length - 1) {
                            break;
                        }
                        i13++;
                        z3 = true;
                        i14 = -1;
                    } else {
                        z3 = z2;
                    }
                }
                if (n33 >= 0) {
                    if (n33 <= 0) {
                        int i16 = i12 - i15;
                        int length2 = bArr2[i13].length - i14;
                        int length3 = bArr2.length;
                        for (int i17 = i13 + 1; i17 < length3; i17++) {
                            length2 += bArr2[i17].length;
                        }
                        if (length2 >= i16) {
                            if (length2 <= i16) {
                                Charset UTF_8 = StandardCharsets.UTF_8;
                                Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
                                return new String(bArr, i10, i12, UTF_8);
                            }
                        }
                    }
                    i6 = i5 + 1;
                }
                length = i8;
            }
            return null;
        }

        public final PublicSuffixDatabase zn() {
            return PublicSuffixDatabase.f12337fb;
        }

        public /* synthetic */ y(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final List<String> a(String str) {
        List<String> split$default = StringsKt.split$default((CharSequence) str, new char[]{'.'}, false, 0, 6, (Object) null);
        if (Intrinsics.areEqual((String) CollectionsKt.last((List<? extends Object>) split$default), "")) {
            return CollectionsKt.dropLast(split$default, 1);
        }
        return split$default;
    }

    public final void gv() throws IOException {
        InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream("publicsuffixes.gz");
        if (resourceAsStream != null) {
            fb gv2 = p.gv(new wz(p.t(resourceAsStream)));
            try {
                byte[] qn2 = gv2.qn(gv2.readInt());
                byte[] qn3 = gv2.qn(gv2.readInt());
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(gv2, null);
                synchronized (this) {
                    Intrinsics.checkNotNull(qn2);
                    this.f12342zn = qn2;
                    Intrinsics.checkNotNull(qn3);
                    this.f12340gv = qn3;
                }
                this.f12341n3.countDown();
            } finally {
            }
        }
    }

    public final List<String> n3(List<String> list) {
        boolean z2;
        String str;
        String str2;
        String str3;
        List<String> emptyList;
        List<String> emptyList2;
        if (!this.y.get() && this.y.compareAndSet(false, true)) {
            v();
        } else {
            try {
                this.f12341n3.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
        if (this.f12342zn != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            int size = list.size();
            byte[][] bArr = new byte[size];
            for (int i = 0; i < size; i++) {
                String str4 = list.get(i);
                Charset UTF_8 = StandardCharsets.UTF_8;
                Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
                if (str4 != null) {
                    byte[] bytes = str4.getBytes(UTF_8);
                    Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                    bArr[i] = bytes;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
            }
            int i5 = 0;
            while (true) {
                str = null;
                if (i5 < size) {
                    y yVar = f12338s;
                    byte[] bArr2 = this.f12342zn;
                    if (bArr2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("publicSuffixListBytes");
                    }
                    str2 = yVar.n3(bArr2, bArr, i5);
                    if (str2 != null) {
                        break;
                    }
                    i5++;
                } else {
                    str2 = null;
                    break;
                }
            }
            if (size > 1) {
                byte[][] bArr3 = (byte[][]) bArr.clone();
                int length = bArr3.length - 1;
                for (int i6 = 0; i6 < length; i6++) {
                    bArr3[i6] = f12339v;
                    y yVar2 = f12338s;
                    byte[] bArr4 = this.f12342zn;
                    if (bArr4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("publicSuffixListBytes");
                    }
                    String n32 = yVar2.n3(bArr4, bArr3, i6);
                    if (n32 != null) {
                        str3 = n32;
                        break;
                    }
                }
            }
            str3 = null;
            if (str3 != null) {
                int i8 = size - 1;
                int i10 = 0;
                while (true) {
                    if (i10 >= i8) {
                        break;
                    }
                    y yVar3 = f12338s;
                    byte[] bArr5 = this.f12340gv;
                    if (bArr5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("publicSuffixExceptionListBytes");
                    }
                    String n33 = yVar3.n3(bArr5, bArr, i10);
                    if (n33 != null) {
                        str = n33;
                        break;
                    }
                    i10++;
                }
            }
            if (str != null) {
                return StringsKt.split$default((CharSequence) ('!' + str), new char[]{'.'}, false, 0, 6, (Object) null);
            } else if (str2 == null && str3 == null) {
                return f12336a;
            } else {
                if (str2 == null || (emptyList = StringsKt.split$default((CharSequence) str2, new char[]{'.'}, false, 0, 6, (Object) null)) == null) {
                    emptyList = CollectionsKt.emptyList();
                }
                if (str3 == null || (emptyList2 = StringsKt.split$default((CharSequence) str3, new char[]{'.'}, false, 0, 6, (Object) null)) == null) {
                    emptyList2 = CollectionsKt.emptyList();
                }
                if (emptyList.size() <= emptyList2.size()) {
                    return emptyList2;
                }
                return emptyList;
            }
        }
        throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
    }

    public final void v() {
        boolean z2 = false;
        while (true) {
            try {
                try {
                    gv();
                    break;
                } catch (InterruptedIOException unused) {
                    Thread.interrupted();
                    z2 = true;
                } catch (IOException e2) {
                    s.f14065zn.fb().f("Failed to read public suffix list", 5, e2);
                    if (z2) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                    return;
                }
            } catch (Throwable th) {
                if (z2) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z2) {
            Thread.currentThread().interrupt();
        }
    }

    public final String zn(String domain) {
        int size;
        int size2;
        Intrinsics.checkNotNullParameter(domain, "domain");
        String unicodeDomain = IDN.toUnicode(domain);
        Intrinsics.checkNotNullExpressionValue(unicodeDomain, "unicodeDomain");
        List<String> a2 = a(unicodeDomain);
        List<String> n32 = n3(a2);
        if (a2.size() == n32.size() && n32.get(0).charAt(0) != '!') {
            return null;
        }
        if (n32.get(0).charAt(0) == '!') {
            size = a2.size();
            size2 = n32.size();
        } else {
            size = a2.size();
            size2 = n32.size() + 1;
        }
        return SequencesKt.joinToString$default(SequencesKt.drop(CollectionsKt.asSequence(a(domain)), size - size2), ".", null, null, 0, null, null, 62, null);
    }
}
