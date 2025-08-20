package com.facebook.ads.redexgen.X;

import android.os.ConditionVariable;
import android.util.Log;
import com.uv.v7.R;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeSet;
/* renamed from: com.facebook.ads.redexgen.X.Vg  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1034Vg implements HK {
    public static boolean A06;
    public static byte[] A07;
    public static String[] A08 = {"PZs3vIZtp1syVhF", "iN5G7Jyo65HiG11v5U3JAI3rcjEJu9Fh", "jWadhCo9gqYR1xuZ5eOebDdRLwIuwzoe", "5aVgPmkb9WO9SFxkSTOlcah0CKuDVehn", "Qok3N", "7mg38N8lomez8u4EtBpwlNJo", "Crj8XVI7aaG6XCZYe", "vguL8XPuWTEOQDWRTomV5"};
    public static final HashSet<File> A09;
    public long A00;
    public boolean A01;
    public final InterfaceC1036Vi A02;
    public final HS A03;
    public final File A04;
    public final HashMap<String, ArrayList<HJ>> A05;

    public static String A03(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A07, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 90);
        }
        return new String(copyOfRange);
    }

    public static void A06() {
        String[] strArr = A08;
        if (strArr[1].charAt(16) != strArr[2].charAt(16)) {
            throw new RuntimeException();
        }
        A08[3] = "N0vjWbyGqBS98Run3kOI6tTmnpu8bGoB";
        A07 = new byte[]{67, 108, 109, 118, 106, 103, 112, 34, 81, 107, 111, 114, 110, 103, 65, 99, 97, 106, 103, 34, 107, 108, 113, 118, 99, 108, 97, 103, 34, 119, 113, 103, 113, 34, 118, 106, 103, 34, 100, 109, 110, 102, 103, 112, 56, 34, 48, 10, 14, 19, 15, 6, 32, 2, 0, 11, 6, 121, 67, 71, 90, 70, 79, 105, 75, 73, 66, 79, 4, 67, 68, 67, 94, 67, 75, 70, 67, 80, 79, 2, 3, 96, 71, 92, 65, 90, 93, 84, 19, 90, 93, 87, 86, 75, 19, 85, 90, 95, 86, 19, 85, 82, 90, 95, 86, 87, 20, 22, 20, 31, 18, 19, 40, 20, 24, 25, 3, 18, 25, 3, 40, 30, 25, 19, 18, 15, 89, 18, 15, 30};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // com.facebook.ads.redexgen.X.HK
    public final synchronized void A4N(File file) throws HI {
        AbstractC0672Ha.A04(!this.A01);
        C1033Vf A00 = C1033Vf.A00(file, this.A03);
        AbstractC0672Ha.A04(A00 != null);
        HR A092 = this.A03.A09(A00.A04);
        AbstractC0672Ha.A01(A092);
        AbstractC0672Ha.A04(A092.A0D());
        if (file.exists()) {
            if (file.length() == 0) {
                file.delete();
                return;
            }
            long A002 = HV.A00(A092.A05());
            if (A002 != -1) {
                AbstractC0672Ha.A04(A00.A02 + A00.A01 <= A002);
            }
            A0A(A00);
            this.A03.A0G();
            notifyAll();
        }
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // com.facebook.ads.redexgen.X.HK
    public final synchronized NavigableSet<HO> A6H(String str) {
        HR A092;
        AbstractC0672Ha.A04(!this.A01);
        A092 = this.A03.A09(str);
        return (A092 == null || A092.A0C()) ? new TreeSet() : new TreeSet((Collection) A092.A08());
    }

    static {
        A06();
        A09 = new HashSet<>();
    }

    public C1034Vg(File file, InterfaceC1036Vi interfaceC1036Vi) {
        this(file, interfaceC1036Vi, null, false);
    }

    public C1034Vg(File file, InterfaceC1036Vi interfaceC1036Vi, HS hs) {
        if (A0D(file)) {
            this.A04 = file;
            this.A02 = interfaceC1036Vi;
            this.A03 = hs;
            this.A05 = new HashMap<>();
            ConditionVariable conditionVariable = new ConditionVariable();
            new HX(this, A03(57, 24, R.styleable.AppCompatTheme_toolbarNavigationButtonStyle), conditionVariable).start();
            conditionVariable.block();
            return;
        }
        throw new IllegalStateException(A03(0, 46, 88) + file);
    }

    public C1034Vg(File file, InterfaceC1036Vi interfaceC1036Vi, byte[] bArr, boolean z2) {
        this(file, interfaceC1036Vi, new HS(file, bArr, z2));
    }

    private C1033Vf A00(String str, long j2) throws HI {
        C1033Vf span;
        HR A092 = this.A03.A09(str);
        if (A092 == null) {
            C1033Vf A02 = C1033Vf.A02(str, j2);
            if (A08[7].length() != 15) {
                A08[3] = "R7TEvDOiyk4OKBf9PsOT39P5pIR22NMD";
                return A02;
            }
            throw new RuntimeException();
        }
        while (true) {
            span = A092.A06(j2);
            if (!span.A05 || span.A03.exists()) {
                break;
            }
            A05();
        }
        return span;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.HK
    /* renamed from: A01 */
    public final synchronized C1033Vf AGV(String str, long j2) throws InterruptedException, HI {
        C1033Vf span;
        while (true) {
            span = AGW(str, j2);
            if (span == null) {
                wait();
            }
        }
        return span;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.HK
    /* renamed from: A02 */
    public final synchronized C1033Vf AGW(String str, long j2) throws HI {
        AbstractC0672Ha.A04(!this.A01);
        C1033Vf A00 = A00(str, j2);
        if (A00.A05) {
            C1033Vf cacheSpan = this.A03.A09(str).A07(A00);
            A0C(A00, cacheSpan);
            return cacheSpan;
        }
        HR A0A = this.A03.A0A(str);
        if (A0A.A0D()) {
            return null;
        }
        A0A.A0B(true);
        return A00;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A04() {
        if (!this.A04.exists()) {
            this.A04.mkdirs();
            return;
        }
        this.A03.A0E();
        File[] listFiles = this.A04.listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file : listFiles) {
            if (!file.getName().equals(A03(R.styleable.AppCompatTheme_textAppearancePopupMenuHeader, 24, 45))) {
                C1033Vf A00 = file.length() > 0 ? C1033Vf.A00(file, this.A03) : null;
                if (A00 != null) {
                    A0A(A00);
                } else {
                    file.delete();
                }
            }
        }
        this.A03.A0F();
        try {
            this.A03.A0G();
        } catch (HI e2) {
            Log.e(A03(46, 11, 57), A03(81, 25, 105), e2);
        }
    }

    private void A05() throws HI {
        ArrayList arrayList = new ArrayList();
        for (HR hr : this.A03.A0D()) {
            Iterator<C1033Vf> it = hr.A08().iterator();
            while (it.hasNext()) {
                C1033Vf next = it.next();
                if (!next.A03.exists()) {
                    arrayList.add(next);
                }
            }
        }
        for (int i = 0; i < arrayList.size(); i++) {
            A08((HO) arrayList.get(i), false);
        }
        this.A03.A0F();
        this.A03.A0G();
    }

    private void A07(HO ho2) {
        ArrayList<HJ> arrayList = this.A05.get(ho2.A04);
        if (arrayList != null) {
            for (int i = arrayList.size() - 1; i >= 0; i--) {
                arrayList.get(i).ADC(this, ho2);
            }
        }
        this.A02.ADC(this, ho2);
    }

    private void A08(HO ho2, boolean z2) throws HI {
        HR A092 = this.A03.A09(ho2.A04);
        if (A092 == null || !A092.A0E(ho2)) {
            return;
        }
        this.A00 -= ho2.A01;
        if (z2) {
            try {
                this.A03.A0H(A092.A03);
                this.A03.A0G();
            } finally {
                A07(ho2);
            }
        }
    }

    private void A0A(C1033Vf c1033Vf) {
        this.A03.A0A(c1033Vf.A04).A09(c1033Vf);
        this.A00 += c1033Vf.A01;
        A0B(c1033Vf);
    }

    private void A0B(C1033Vf c1033Vf) {
        ArrayList<HJ> arrayList = this.A05.get(c1033Vf.A04);
        if (arrayList != null) {
            for (int i = arrayList.size() - 1; i >= 0; i--) {
                arrayList.get(i).ADB(this, c1033Vf);
            }
        }
        this.A02.ADB(this, c1033Vf);
    }

    private void A0C(C1033Vf c1033Vf, HO ho2) {
        ArrayList<HJ> arrayList = this.A05.get(c1033Vf.A04);
        if (arrayList != null) {
            int size = arrayList.size();
            String[] strArr = A08;
            if (strArr[1].charAt(16) != strArr[2].charAt(16)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A08;
            strArr2[0] = "YjLi8Ea68WiaTq3";
            strArr2[4] = "ACi8R";
            for (int i = size - 1; i >= 0; i--) {
                arrayList.get(i).ADD(this, c1033Vf, ho2);
            }
        }
        this.A02.ADD(this, c1033Vf, ho2);
    }

    public static synchronized boolean A0D(File file) {
        synchronized (C1034Vg.class) {
            if (A06) {
                return true;
            }
            return A09.add(file.getAbsoluteFile());
        }
    }

    @Override // com.facebook.ads.redexgen.X.HK
    public final synchronized void A3a(String str, HW hw2) throws HI {
        AbstractC0672Ha.A04(!this.A01);
        this.A03.A0I(str, hw2);
        this.A03.A0G();
    }

    @Override // com.facebook.ads.redexgen.X.HK
    public final synchronized long A6F() {
        AbstractC0672Ha.A04(!this.A01);
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.X.HK
    public final synchronized long A6G(String str, long j2, long j4) {
        HR cachedContent;
        AbstractC0672Ha.A04(!this.A01);
        cachedContent = this.A03.A09(str);
        return cachedContent != null ? cachedContent.A04(j2, j4) : -j4;
    }

    @Override // com.facebook.ads.redexgen.X.HK
    public final synchronized long A6W(String str) {
        return HV.A00(A6X(str));
    }

    @Override // com.facebook.ads.redexgen.X.HK
    public final synchronized HU A6X(String str) {
        AbstractC0672Ha.A04(!this.A01);
        return this.A03.A0B(str);
    }

    @Override // com.facebook.ads.redexgen.X.HK
    public final synchronized void AEZ(HO ho2) {
        AbstractC0672Ha.A04(!this.A01);
        HR A092 = this.A03.A09(ho2.A04);
        AbstractC0672Ha.A01(A092);
        AbstractC0672Ha.A04(A092.A0D());
        A092.A0B(false);
        this.A03.A0H(A092.A03);
        notifyAll();
    }

    @Override // com.facebook.ads.redexgen.X.HK
    public final synchronized void AF9(HO ho2) throws HI {
        AbstractC0672Ha.A04(!this.A01);
        A08(ho2, true);
    }

    @Override // com.facebook.ads.redexgen.X.HK
    public final synchronized void AFx(String str, long j2) throws HI {
        HW mutations = new HW();
        HV.A05(mutations, j2);
        A3a(str, mutations);
    }

    @Override // com.facebook.ads.redexgen.X.HK
    public final synchronized File AGT(String str, long j2, long j4) throws HI {
        HR A092;
        AbstractC0672Ha.A04(!this.A01);
        A092 = this.A03.A09(str);
        AbstractC0672Ha.A01(A092);
        AbstractC0672Ha.A04(A092.A0D());
        if (!this.A04.exists()) {
            this.A04.mkdirs();
            A05();
        }
        this.A02.ADE(this, str, j2, j4);
        return C1033Vf.A04(this.A04, A092.A02, j2, System.currentTimeMillis());
    }
}
