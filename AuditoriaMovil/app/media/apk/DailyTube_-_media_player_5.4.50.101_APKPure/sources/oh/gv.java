package oh;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.SpannableStringBuilder;
import android.util.Base64;
import android.util.Pair;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import qh.n3;
/* loaded from: classes.dex */
public final class gv {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public final fb f12287a;
    @Nullable

    /* renamed from: c5  reason: collision with root package name */
    public final String f12288c5;

    /* renamed from: f  reason: collision with root package name */
    public final HashMap<String, Integer> f12289f;
    @Nullable

    /* renamed from: fb  reason: collision with root package name */
    public final String[] f12290fb;

    /* renamed from: gv  reason: collision with root package name */
    public final long f12291gv;
    @Nullable

    /* renamed from: i9  reason: collision with root package name */
    public final gv f12292i9;
    @Nullable

    /* renamed from: n3  reason: collision with root package name */
    public final String f12293n3;

    /* renamed from: s  reason: collision with root package name */
    public final String f12294s;

    /* renamed from: t  reason: collision with root package name */
    public final HashMap<String, Integer> f12295t;

    /* renamed from: tl  reason: collision with root package name */
    public List<gv> f12296tl;

    /* renamed from: v  reason: collision with root package name */
    public final long f12297v;
    @Nullable
    public final String y;

    /* renamed from: zn  reason: collision with root package name */
    public final boolean f12298zn;

    public gv(@Nullable String str, @Nullable String str2, long j2, long j4, @Nullable fb fbVar, @Nullable String[] strArr, String str3, @Nullable String str4, @Nullable gv gvVar) {
        boolean z2;
        this.y = str;
        this.f12293n3 = str2;
        this.f12288c5 = str4;
        this.f12287a = fbVar;
        this.f12290fb = strArr;
        if (str2 != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.f12298zn = z2;
        this.f12291gv = j2;
        this.f12297v = j4;
        this.f12294s = (String) v5.y.v(str3);
        this.f12292i9 = gvVar;
        this.f12289f = new HashMap<>();
        this.f12295t = new HashMap<>();
    }

    public static SpannableStringBuilder f(String str, Map<String, n3.C0187n3> map) {
        if (!map.containsKey(str)) {
            n3.C0187n3 c0187n3 = new n3.C0187n3();
            c0187n3.xc(new SpannableStringBuilder());
            map.put(str, c0187n3);
        }
        return (SpannableStringBuilder) v5.y.v(map.get(str).v());
    }

    public static gv gv(String str) {
        return new gv(null, a.n3(str), -9223372036854775807L, -9223372036854775807L, null, null, "", null, null);
    }

    public static void v(SpannableStringBuilder spannableStringBuilder) {
        y[] yVarArr;
        for (y yVar : (y[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), y.class)) {
            spannableStringBuilder.replace(spannableStringBuilder.getSpanStart(yVar), spannableStringBuilder.getSpanEnd(yVar), "");
        }
        for (int i = 0; i < spannableStringBuilder.length(); i++) {
            if (spannableStringBuilder.charAt(i) == ' ') {
                int i5 = i + 1;
                int i6 = i5;
                while (i6 < spannableStringBuilder.length() && spannableStringBuilder.charAt(i6) == ' ') {
                    i6++;
                }
                int i8 = i6 - i5;
                if (i8 > 0) {
                    spannableStringBuilder.delete(i, i8 + i);
                }
            }
        }
        if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(0) == ' ') {
            spannableStringBuilder.delete(0, 1);
        }
        for (int i10 = 0; i10 < spannableStringBuilder.length() - 1; i10++) {
            if (spannableStringBuilder.charAt(i10) == '\n') {
                int i11 = i10 + 1;
                if (spannableStringBuilder.charAt(i11) == ' ') {
                    spannableStringBuilder.delete(i11, i10 + 2);
                }
            }
        }
        if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == ' ') {
            spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
        }
        for (int i12 = 0; i12 < spannableStringBuilder.length() - 1; i12++) {
            if (spannableStringBuilder.charAt(i12) == ' ') {
                int i13 = i12 + 1;
                if (spannableStringBuilder.charAt(i13) == '\n') {
                    spannableStringBuilder.delete(i12, i13);
                }
            }
        }
        if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == '\n') {
            spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
        }
    }

    public static gv zn(@Nullable String str, long j2, long j4, @Nullable fb fbVar, @Nullable String[] strArr, String str2, @Nullable String str3, @Nullable gv gvVar) {
        return new gv(str, null, j2, j4, fbVar, strArr, str2, str3, gvVar);
    }

    public gv a(int i) {
        List<gv> list = this.f12296tl;
        if (list != null) {
            return list.get(i);
        }
        throw new IndexOutOfBoundsException();
    }

    public final void c5(TreeSet<Long> treeSet, boolean z2) {
        boolean z3;
        boolean equals = "p".equals(this.y);
        boolean equals2 = "div".equals(this.y);
        if (z2 || equals || (equals2 && this.f12288c5 != null)) {
            long j2 = this.f12291gv;
            if (j2 != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j2));
            }
            long j4 = this.f12297v;
            if (j4 != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j4));
            }
        }
        if (this.f12296tl == null) {
            return;
        }
        for (int i = 0; i < this.f12296tl.size(); i++) {
            gv gvVar = this.f12296tl.get(i);
            if (!z2 && !equals) {
                z3 = false;
            } else {
                z3 = true;
            }
            gvVar.c5(treeSet, z3);
        }
    }

    public int fb() {
        List<gv> list = this.f12296tl;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public long[] i9() {
        TreeSet<Long> treeSet = new TreeSet<>();
        int i = 0;
        c5(treeSet, false);
        long[] jArr = new long[treeSet.size()];
        Iterator<Long> it = treeSet.iterator();
        while (it.hasNext()) {
            jArr[i] = it.next().longValue();
            i++;
        }
        return jArr;
    }

    public final void n3(Map<String, fb> map, n3.C0187n3 c0187n3, int i, int i5, int i6) {
        fb a2 = a.a(this.f12287a, this.f12290fb, map);
        SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) c0187n3.v();
        if (spannableStringBuilder == null) {
            spannableStringBuilder = new SpannableStringBuilder();
            c0187n3.xc(spannableStringBuilder);
        }
        SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
        if (a2 != null) {
            a.y(spannableStringBuilder2, i, i5, a2, this.f12292i9, map, i6);
            if ("p".equals(this.y)) {
                if (a2.f() != Float.MAX_VALUE) {
                    c0187n3.tl((a2.f() * (-90.0f)) / 100.0f);
                }
                if (a2.tl() != null) {
                    c0187n3.w(a2.tl());
                }
                if (a2.s() != null) {
                    c0187n3.i9(a2.s());
                }
            }
        }
    }

    public List<qh.n3> s(long j2, Map<String, fb> map, Map<String, v> map2, Map<String, String> map3) {
        List<Pair<String, String>> arrayList = new ArrayList<>();
        wz(j2, this.f12294s, arrayList);
        TreeMap treeMap = new TreeMap();
        w(j2, false, this.f12294s, treeMap);
        xc(j2, map, map2, this.f12294s, treeMap);
        ArrayList arrayList2 = new ArrayList();
        for (Pair<String, String> pair : arrayList) {
            String str = map3.get(pair.second);
            if (str != null) {
                byte[] decode = Base64.decode(str, 0);
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length);
                v vVar = (v) v5.y.v(map2.get(pair.first));
                arrayList2.add(new n3.C0187n3().a(decodeByteArray).f(vVar.f12315n3).t(0).s(vVar.f12318zn, 0).c5(vVar.f12317v).wz(vVar.f12310a).fb(vVar.f12312fb).mt(vVar.f12314i9).y());
            }
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            v vVar2 = (v) v5.y.v(map2.get(entry.getKey()));
            n3.C0187n3 c0187n3 = (n3.C0187n3) entry.getValue();
            v((SpannableStringBuilder) v5.y.v(c0187n3.v()));
            c0187n3.s(vVar2.f12318zn, vVar2.f12313gv);
            c0187n3.c5(vVar2.f12317v);
            c0187n3.f(vVar2.f12315n3);
            c0187n3.wz(vVar2.f12310a);
            c0187n3.p(vVar2.f12311c5, vVar2.f12316s);
            c0187n3.mt(vVar2.f12314i9);
            arrayList2.add(c0187n3.y());
        }
        return arrayList2;
    }

    @Nullable
    public String[] t() {
        return this.f12290fb;
    }

    public boolean tl(long j2) {
        long j4 = this.f12291gv;
        if ((j4 == -9223372036854775807L && this.f12297v == -9223372036854775807L) || ((j4 <= j2 && this.f12297v == -9223372036854775807L) || ((j4 == -9223372036854775807L && j2 < this.f12297v) || (j4 <= j2 && j2 < this.f12297v)))) {
            return true;
        }
        return false;
    }

    public final void w(long j2, boolean z2, String str, Map<String, n3.C0187n3> map) {
        boolean z3;
        this.f12289f.clear();
        this.f12295t.clear();
        if ("metadata".equals(this.y)) {
            return;
        }
        if (!"".equals(this.f12294s)) {
            str = this.f12294s;
        }
        if (this.f12298zn && z2) {
            f(str, map).append((CharSequence) v5.y.v(this.f12293n3));
        } else if ("br".equals(this.y) && z2) {
            f(str, map).append('\n');
        } else if (tl(j2)) {
            for (Map.Entry<String, n3.C0187n3> entry : map.entrySet()) {
                this.f12289f.put(entry.getKey(), Integer.valueOf(((CharSequence) v5.y.v(entry.getValue().v())).length()));
            }
            boolean equals = "p".equals(this.y);
            for (int i = 0; i < fb(); i++) {
                gv a2 = a(i);
                if (!z2 && !equals) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                a2.w(j2, z3, str, map);
            }
            if (equals) {
                a.zn(f(str, map));
            }
            for (Map.Entry<String, n3.C0187n3> entry2 : map.entrySet()) {
                this.f12295t.put(entry2.getKey(), Integer.valueOf(((CharSequence) v5.y.v(entry2.getValue().v())).length()));
            }
        }
    }

    public final void wz(long j2, String str, List<Pair<String, String>> list) {
        if (!"".equals(this.f12294s)) {
            str = this.f12294s;
        }
        if (tl(j2) && "div".equals(this.y) && this.f12288c5 != null) {
            list.add(new Pair<>(str, this.f12288c5));
            return;
        }
        for (int i = 0; i < fb(); i++) {
            a(i).wz(j2, str, list);
        }
    }

    public final void xc(long j2, Map<String, fb> map, Map<String, v> map2, String str, Map<String, n3.C0187n3> map3) {
        String str2;
        int i;
        int i5;
        if (!tl(j2)) {
            return;
        }
        if ("".equals(this.f12294s)) {
            str2 = str;
        } else {
            str2 = this.f12294s;
        }
        Iterator<Map.Entry<String, Integer>> it = this.f12295t.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<String, Integer> next = it.next();
            String key = next.getKey();
            if (this.f12289f.containsKey(key)) {
                i5 = this.f12289f.get(key).intValue();
            } else {
                i5 = 0;
            }
            int intValue = next.getValue().intValue();
            if (i5 != intValue) {
                n3(map, (n3.C0187n3) v5.y.v(map3.get(key)), i5, intValue, ((v) v5.y.v(map2.get(str2))).f12314i9);
            }
        }
        for (i = 0; i < fb(); i++) {
            a(i).xc(j2, map, map2, str2, map3);
        }
    }

    public void y(gv gvVar) {
        if (this.f12296tl == null) {
            this.f12296tl = new ArrayList();
        }
        this.f12296tl.add(gvVar);
    }
}
