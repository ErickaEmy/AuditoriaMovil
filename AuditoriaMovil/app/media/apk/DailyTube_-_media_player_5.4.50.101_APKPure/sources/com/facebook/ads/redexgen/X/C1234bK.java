package com.facebook.ads.redexgen.X;

import android.os.Handler;
import android.text.TextUtils;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.facebook.ads.internal.protocol.AdPlacementType;
import com.uv.v7.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;
/* renamed from: com.facebook.ads.redexgen.X.bK  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1234bK implements InterfaceC02760k, InterfaceC02800p {
    public static byte[] A0C;
    public static String[] A0D = {"OTBhn", "woE0GsYsDC", "jJJsRhZ6eh", "RbmDZKGZyk", "MbYnCV2deeCvNEpfUSPgn7RvJuamywdV", "va4Mi1JJiq4w08mNkhVxy34L1bzftr4W", "QQZqW8pW387BdDH3gcXSwYVoWAeaIxNz", "E72k8"};
    public static final String A0E;
    public int A00;
    public AnonymousClass14 A01;
    public AnonymousClass15 A02;
    public AnonymousClass16 A03;
    public JO A04;
    public List<V2> A05;
    public boolean A06;
    public boolean A07;
    public boolean A08;
    public boolean A09;
    public final C1116Yn A0A;
    public final String A0B;

    public static String A02(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A0C, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ R.styleable.AppCompatTheme_textAppearancePopupMenuHeader);
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        A0C = new byte[]{124, 89, 92, 77, 73, 88, 79, 29, 92, 81, 79, 88, 92, 89, 68, 29, 81, 82, 92, 89, 88, 89, 29, 89, 92, 73, 92, 93, 114, 119, 125, 117, 62, 118, Byte.MAX_VALUE, 110, 110, 123, 112, 123, 122, 62, 113, 112, 62, 114, 113, 125, 117, 109, 125, 108, 123, 123, 112, 62, Byte.MAX_VALUE, 122, 104, 71, 66, 72, 64, 11, 71, 68, 76, 76, 78, 79, 11, 9, 4, 4, 13, 26, 60, 17, 24, 13, 64, 66, 81, 71, 64, 77, 87, 54, 52, 39, 49, 60, 59, 49, 92, 75, 37, 42, 47, 55, 38, 49, 38, 39, 28, 32, 47, 42, 32, 40, 28, 39, 38, 47, 34, 58, 28, 46, 48, 93, 71, 107, 87, 70, 81, 85, 64, 93, 66, 81, 107, 85, 71, 107, 87, 64, 85, 107, 66, 6, 79, 82, 93, 76, 79, 84, 83, 72, 23, 12, 11, 19, 23, 7, 43, 6, 94, 65, 77, 95};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    private void A06(Map<String, String> map, Map<String, String> map2) {
        try {
            new Handler().postDelayed(new C1235bL(this, map2, A03(map)), this.A01.A07() * 1000);
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0121, code lost:
        if (r3 != false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0123, code lost:
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0148, code lost:
        if (r3 != false) goto L45;
     */
    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A0M(java.util.Map<java.lang.String, java.lang.String> r8) {
        /*
            Method dump skipped, instructions count: 333
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1234bK.A0M(java.util.Map):void");
    }

    static {
        A04();
        A0E = C1234bK.class.getSimpleName();
    }

    public C1234bK(C1116Yn c1116Yn) {
        this(c1116Yn, new AnonymousClass14());
    }

    public C1234bK(C1116Yn c1116Yn, AnonymousClass14 anonymousClass14) {
        this.A0B = UUID.randomUUID().toString();
        this.A00 = 200;
        this.A01 = anonymousClass14;
        this.A0A = c1116Yn;
    }

    private Map<String, String> A03(Map<String, String> map) {
        HashMap hashMap = new HashMap();
        String A02 = A02(156, 4, 66);
        if (map.containsKey(A02)) {
            hashMap.put(A02, map.get(A02));
        }
        String A022 = A02(140, 8, 86);
        if (map.containsKey(A022)) {
            hashMap.put(A022, map.get(A022));
        }
        return hashMap;
    }

    private void A05(AnonymousClass14 anonymousClass14) {
        if (!this.A06) {
            this.A01 = anonymousClass14;
            List<AnonymousClass14> A0f = anonymousClass14.A0f();
            if (A0f != null && A0f.size() > 0) {
                int size = A0f.size();
                ArrayList arrayList = new ArrayList(size);
                for (int i = 0; i < size; i++) {
                    C1234bK adapter = new C1234bK(this.A0A);
                    adapter.A05(A0f.get(i));
                    arrayList.add(new V2(this.A0A, adapter, (C8T) null, this.A04));
                }
                this.A05 = arrayList;
            }
            this.A06 = true;
            this.A07 = A07();
            return;
        }
        throw new IllegalStateException(A02(0, 27, 87));
    }

    private boolean A07() {
        if (((!this.A01.A0h() && !TextUtils.isEmpty(this.A01.A0W())) || (!TextUtils.isEmpty(this.A01.A0T()) && this.A01.A0h())) && (this.A01.A0G() != null || this.A01.A0h())) {
            JP A0F = this.A01.A0F();
            if (A0D[2].length() != 10) {
                throw new RuntimeException();
            }
            A0D[6] = "coz4LHwVNN2LSDndRSBnj9WvwXuRM5HO";
            if (A0F != null || A7e() == AdPlacementType.NATIVE_BANNER) {
                return true;
            }
        }
        return false;
    }

    public final int A08() {
        return this.A01.A02();
    }

    public final int A09() {
        return this.A01.A05();
    }

    public final int A0A() {
        int A06 = this.A01.A06();
        if (A06 < 0 || A06 > 100) {
            return 0;
        }
        return A06;
    }

    public final int A0B() {
        return this.A00;
    }

    public final int A0C() {
        return this.A01.A08();
    }

    public final int A0D() {
        return this.A01.A09();
    }

    public final AnonymousClass14 A0E() {
        return this.A01;
    }

    public final AnonymousClass15 A0F() {
        return this.A02;
    }

    public final String A0G() {
        return this.A01.A0a();
    }

    public final List<V2> A0H() {
        if (!A0R()) {
            return null;
        }
        return this.A05;
    }

    public final void A0I() {
        if (!this.A09) {
            String A0b = A0E().A0b();
            if (A0D[2].length() != 10) {
                throw new RuntimeException();
            }
            A0D[5] = "8ArINtb0xmmgo9NmELWQk3NiIhKYvaDc";
            if (A0b != null) {
                this.A0A.A09().AE1(A0b);
            }
            this.A09 = true;
        }
    }

    public final void A0J() {
        Iterator<V2> it;
        List<V2> list = this.A05;
        if (list == null) {
            return;
        }
        boolean isEmpty = list.isEmpty();
        if (A0D[6].charAt(13) != 'D') {
            throw new RuntimeException();
        }
        A0D[6] = "kj4WnsmCok25qDrlf1kxSYggARLvW33C";
        if (!isEmpty) {
            List<V2> list2 = this.A05;
            if (A0D[2].length() != 10) {
                it = list2.iterator();
            } else {
                A0D[2] = "wGXHpE1nya";
                it = list2.iterator();
            }
            while (true) {
                boolean hasNext = it.hasNext();
                if (A0D[2].length() != 10) {
                    A0D[6] = "0lb5BUzW8n1EJDWyWAqaA7d0lZJNpkzV";
                    if (!hasNext) {
                        return;
                    }
                } else {
                    A0D[5] = "QJQdkpg5cmGOeaue26HVF3aLtsB2qwfM";
                    if (!hasNext) {
                        return;
                    }
                }
                it.next().unregisterView();
            }
        }
    }

    public final void A0K(AnonymousClass15 anonymousClass15) {
        this.A02 = anonymousClass15;
    }

    public final void A0L(C1116Yn c1116Yn, AnonymousClass15 anonymousClass15, J2 j2, C03121v c03121v, JO jo) {
        int i;
        this.A02 = anonymousClass15;
        this.A04 = jo;
        JSONObject A03 = c03121v.A03();
        C8T A01 = c03121v.A01();
        if (A01 != null) {
            i = A01.A06();
        } else {
            i = 200;
        }
        this.A00 = i;
        A05(AnonymousClass17.A00(c1116Yn, A03, LJ.A02(A03, A02(94, 2, 85))));
        if (AbstractC02770l.A06(c1116Yn, this, j2)) {
            c1116Yn.A0E().A4K();
            anonymousClass15.ACQ(this, C0722Jb.A00(AdErrorType.NO_FILL));
            return;
        }
        if (anonymousClass15 != null) {
            anonymousClass15.ACN(this);
        }
        AnonymousClass16 anonymousClass16 = new AnonymousClass16(c1116Yn, this.A0B, this, anonymousClass15);
        this.A03 = anonymousClass16;
        anonymousClass16.A02();
    }

    public final void A0N(Map<String, String> extraData) {
        this.A0A.A09().A9W(this.A01.A0Y(), extraData);
    }

    public final void A0O(Map<String, String> map) {
        if (A0R() && !this.A08) {
            AnonymousClass15 anonymousClass15 = this.A02;
            if (anonymousClass15 != null) {
                anonymousClass15.ACO(this);
            }
            HashMap hashMap = new HashMap();
            if (map != null) {
                hashMap.putAll(map);
            }
            if (this.A01.A0h()) {
                hashMap.put(A02(87, 7, 63), String.valueOf(A0E().A04()));
                hashMap.put(A02(80, 7, 73), String.valueOf(A0E().A03()));
            }
            if (!TextUtils.isEmpty(A6T())) {
                if (!this.A01.A0h()) {
                    this.A0A.A0E().A2k();
                    C2O.A00(this.A01.A0Z());
                }
                this.A0A.A09().A9g(A6T(), hashMap);
            }
            if (A0T() || A0U()) {
                A06(map, hashMap);
            }
            this.A08 = true;
        }
    }

    public final boolean A0P() {
        return true;
    }

    public final boolean A0Q() {
        return A0R() && this.A01.A0B() != null;
    }

    public final boolean A0R() {
        return this.A06 && this.A07;
    }

    public final boolean A0S() {
        return this.A01.A0g();
    }

    public final boolean A0T() {
        if (C0705Ih.A1B(this.A0A) && A0R()) {
            boolean A0i = this.A01.A0i();
            if (A0D[4].charAt(15) != 'f') {
                throw new RuntimeException();
            }
            A0D[6] = "hsrOxssvGH6abDOIeI9T6FJFSNjQSl4a";
            if (A0i) {
                return true;
            }
        }
        return false;
    }

    public final boolean A0U() {
        if (C0705Ih.A1B(this.A0A) && A0R()) {
            boolean A0j = this.A01.A0j();
            String[] strArr = A0D;
            if (strArr[0].length() != strArr[7].length()) {
                throw new RuntimeException();
            }
            A0D[2] = "qputmJyOXU";
            if (A0j) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC02760k
    public final String A6T() {
        return this.A01.A0Y();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC02760k
    public final Collection<String> A6n() {
        return A0E().A0e();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC02760k
    public final EnumC02750j A7E() {
        return A0E().A0C();
    }

    public AdPlacementType A7e() {
        return AdPlacementType.NATIVE;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC02800p
    public final boolean AGd() {
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC02800p
    public final void onDestroy() {
        AnonymousClass16 anonymousClass16 = this.A03;
        if (anonymousClass16 != null) {
            anonymousClass16.A03();
        }
    }
}
