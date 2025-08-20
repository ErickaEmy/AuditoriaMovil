package h4;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry;
import fj.u0;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import m1.m;
import v5.k5;
import v5.n;
import y3.ej;
/* loaded from: classes.dex */
public final class gv implements s {

    /* renamed from: gv  reason: collision with root package name */
    public static final int[] f8584gv = {8, 13, 11, 2, 0, 1, 7};

    /* renamed from: n3  reason: collision with root package name */
    public final int f8585n3;

    /* renamed from: zn  reason: collision with root package name */
    public final boolean f8586zn;

    public gv() {
        this(0, true);
    }

    public static ej a(int i, boolean z2, m mVar, @Nullable List<m> list, k5 k5Var) {
        int i5 = i | 16;
        if (list != null) {
            i5 = i | 48;
        } else if (z2) {
            list = Collections.singletonList(new m.n3().o4("application/cea-608").z6());
        } else {
            list = Collections.emptyList();
        }
        String str = mVar.f10942co;
        if (!TextUtils.isEmpty(str)) {
            if (!n.n3(str, "audio/mp4a-latm")) {
                i5 |= 2;
            }
            if (!n.n3(str, "video/avc")) {
                i5 |= 4;
            }
        }
        return new ej(2, k5Var, new y3.i9(i5, list));
    }

    public static boolean fb(m mVar) {
        Metadata metadata = mVar.f10972z;
        if (metadata == null) {
            return false;
        }
        for (int i = 0; i < metadata.v(); i++) {
            Metadata.Entry gv2 = metadata.gv(i);
            if (gv2 instanceof HlsTrackMetadataEntry) {
                return !((HlsTrackMetadataEntry) gv2).f4529fb.isEmpty();
            }
        }
        return false;
    }

    public static void n3(int i, List<Integer> list) {
        if (d1.a.c5(f8584gv, i) != -1 && !list.contains(Integer.valueOf(i))) {
            list.add(Integer.valueOf(i));
        }
    }

    public static boolean s(e4.t tVar, e4.tl tlVar) throws IOException {
        try {
            boolean a2 = tVar.a(tlVar);
            tlVar.s();
            return a2;
        } catch (EOFException unused) {
            tlVar.s();
            return false;
        } catch (Throwable th) {
            tlVar.s();
            throw th;
        }
    }

    public static ha.fb v(k5 k5Var, m mVar, @Nullable List<m> list) {
        int i;
        if (fb(mVar)) {
            i = 4;
        } else {
            i = 0;
        }
        if (list == null) {
            list = Collections.emptyList();
        }
        return new ha.fb(i, k5Var, null, list);
    }

    @Nullable
    @SuppressLint({"SwitchIntDef"})
    public final e4.t gv(int i, m mVar, @Nullable List<m> list, k5 k5Var) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 7) {
                        if (i != 8) {
                            if (i != 11) {
                                if (i != 13) {
                                    return null;
                                }
                                return new z(mVar.f10950fb, k5Var);
                            }
                            return a(this.f8585n3, this.f8586zn, mVar, list, k5Var);
                        }
                        return v(k5Var, mVar, list);
                    }
                    return new x1.a(0, 0L);
                }
                return new y3.s();
            }
            return new y3.v();
        }
        return new y3.n3();
    }

    @Override // h4.s
    /* renamed from: zn */
    public n3 y(Uri uri, m mVar, @Nullable List<m> list, k5 k5Var, Map<String, List<String>> map, e4.tl tlVar, u0 u0Var) throws IOException {
        int y = v5.tl.y(mVar.f10948f3);
        int n32 = v5.tl.n3(map);
        int zn2 = v5.tl.zn(uri);
        int[] iArr = f8584gv;
        ArrayList arrayList = new ArrayList(iArr.length);
        n3(y, arrayList);
        n3(n32, arrayList);
        n3(zn2, arrayList);
        for (int i : iArr) {
            n3(i, arrayList);
        }
        tlVar.s();
        e4.t tVar = null;
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            int intValue = ((Integer) arrayList.get(i5)).intValue();
            e4.t tVar2 = (e4.t) v5.y.v(gv(intValue, mVar, list, k5Var));
            if (s(tVar2, tlVar)) {
                return new n3(tVar2, mVar, k5Var);
            }
            if (tVar == null && (intValue == y || intValue == n32 || intValue == zn2 || intValue == 11)) {
                tVar = tVar2;
            }
        }
        return new n3((e4.t) v5.y.v(tVar), mVar, k5Var);
    }

    public gv(int i, boolean z2) {
        this.f8585n3 = i;
        this.f8586zn = z2;
    }
}
