package dq;

import dq.tl;
import dq.wz;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import m1.m;
import v5.j5;
/* loaded from: classes.dex */
public final class gv {

    /* renamed from: n3  reason: collision with root package name */
    public static final y f7363n3 = new y(null);
    public zn y;

    /* loaded from: classes.dex */
    public static final class y {
        public /* synthetic */ y(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final tl.n3 y(tl.n3 representation, t tVar, long j2, long j4, long j6, long j7, long j8) {
            Intrinsics.checkNotNullParameter(representation, "representation");
            wz.y yVar = representation.f7389c5;
            Intrinsics.checkNotNull(yVar, "null cannot be cast to non-null type com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SegmentTemplate");
            wz.zn znVar = (wz.zn) yVar;
            wz.zn n32 = v.n3(tVar, znVar.f7395n3, znVar.f7396zn, j2, j4, j6, znVar.f7401a, znVar.f7402c5, znVar.f7408i9, znVar.f7407f, j7, j8);
            Intrinsics.checkNotNullExpressionValue(n32, "buildSegmentTemplate(...)");
            return new tl.n3(representation.y, representation.f7385n3, representation.f7388zn, n32, representation.f7387v, representation.f7382a, representation.f7383fb);
        }

        public y() {
        }
    }

    public gv(zn baseManifest) {
        Intrinsics.checkNotNullParameter(baseManifest, "baseManifest");
        this.y = baseManifest;
    }

    public final tl a(List<? extends tl> list, tl tlVar) {
        String str = tlVar.f7385n3.y;
        for (tl tlVar2 : list) {
            if (Intrinsics.areEqual(tlVar2.f7385n3.y, str)) {
                return tlVar2;
            }
        }
        return null;
    }

    public final boolean fb(List<? extends dq.y> list) {
        if (list.isEmpty()) {
            return false;
        }
        List<tl> representations = list.get(0).f7418zn;
        Intrinsics.checkNotNullExpressionValue(representations, "representations");
        if (representations.isEmpty()) {
            return false;
        }
        tl tlVar = representations.get(0);
        Intrinsics.checkNotNullExpressionValue(tlVar, "get(...)");
        tl tlVar2 = tlVar;
        if (tlVar2 instanceof tl.n3) {
            wz.y yVar = ((tl.n3) tlVar2).f7389c5;
            if ((yVar instanceof wz.n3) && yVar.f7401a != null) {
                return true;
            }
        }
        return false;
    }

    public final wz.n3 gv(wz.n3 n3Var, wz.n3 n3Var2, i9 i9Var) {
        int i;
        long j2 = this.y.y;
        long j4 = -9223372036854775807L;
        if (j2 != -9223372036854775807L) {
            j4 = i9Var.f7365n3 + j2;
        }
        List<wz.gv> list = n3Var2.f7401a;
        Intrinsics.checkNotNull(list);
        List<t> list2 = n3Var2.f7398i9;
        Intrinsics.checkNotNull(list2);
        List<wz.gv> list3 = n3Var.f7401a;
        Intrinsics.checkNotNull(list3);
        ArrayList arrayList = new ArrayList(list3);
        List<t> list4 = n3Var.f7398i9;
        Intrinsics.checkNotNull(list4);
        ArrayList arrayList2 = new ArrayList(list4);
        long size = n3Var.f7404gv + arrayList.size();
        long j6 = n3Var2.f7404gv;
        if (j6 >= size) {
            i = 0;
        } else {
            i = (int) (size - j6);
        }
        if (i < list.size()) {
            List<wz.gv> subList = list.subList(i, list.size());
            wz.gv gvVar = (wz.gv) CollectionsKt.last((List<? extends Object>) arrayList);
            long j7 = (gvVar.y + gvVar.f7397n3) - ((wz.gv) CollectionsKt.first((List<? extends Object>) subList)).y;
            for (wz.gv gvVar2 : subList) {
                arrayList.add(new wz.gv(gvVar2.y + j7, gvVar2.f7397n3));
                j7 = j7;
            }
            arrayList2.addAll(list2.subList(i, list2.size()));
        }
        wz.n3 y2 = v.y(n3Var.y, n3Var.f7395n3, n3Var.f7396zn, n3Var.f7404gv, n3Var.f7406v, arrayList, n3Var.f7402c5, arrayList2, j5.xb(this.y.f7419a), j5.xb(j4));
        Intrinsics.checkNotNullExpressionValue(y2, "buildSegmentList(...)");
        return y2;
    }

    public final zn n3(zn newManifest) {
        Intrinsics.checkNotNullParameter(newManifest, "newManifest");
        i9 gv2 = this.y.gv(0);
        Intrinsics.checkNotNullExpressionValue(gv2, "getPeriod(...)");
        i9 gv3 = newManifest.gv(0);
        Intrinsics.checkNotNullExpressionValue(gv3, "getPeriod(...)");
        List<dq.y> adaptationSets = gv2.f7367zn;
        Intrinsics.checkNotNullExpressionValue(adaptationSets, "adaptationSets");
        if (fb(adaptationSets)) {
            List<dq.y> adaptationSets2 = gv3.f7367zn;
            Intrinsics.checkNotNullExpressionValue(adaptationSets2, "adaptationSets");
            if (fb(adaptationSets2)) {
                tl tlVar = gv2.f7367zn.get(0).f7418zn.get(0);
                Intrinsics.checkNotNull(tlVar, "null cannot be cast to non-null type com.google.android.exoplayer2.source.dash.manifest.Representation.MultiSegmentRepresentation");
                long c52 = ((tl.n3) tlVar).c5();
                tl tlVar2 = gv3.f7367zn.get(0).f7418zn.get(0);
                Intrinsics.checkNotNull(tlVar2, "null cannot be cast to non-null type com.google.android.exoplayer2.source.dash.manifest.Representation.MultiSegmentRepresentation");
                if (((tl.n3) tlVar2).c5() <= c52) {
                    this.y = newManifest;
                    return newManifest;
                }
                List<dq.y> adaptationSets3 = gv3.f7367zn;
                Intrinsics.checkNotNullExpressionValue(adaptationSets3, "adaptationSets");
                i9 i9Var = new i9(gv2.y, gv2.f7365n3, y(gv2, adaptationSets3), gv2.f7364gv, gv2.f7366v);
                zn znVar = this.y;
                zn znVar2 = new zn(znVar.y, znVar.f7425n3, znVar.f7430zn, znVar.f7423gv, znVar.f7429v, znVar.f7419a, znVar.f7422fb, newManifest.f7426s, znVar.f7427t, newManifest.f7420c5, znVar.f7424i9, newManifest.f7421f, CollectionsKt.listOf(i9Var));
                this.y = znVar2;
                return znVar2;
            }
        }
        this.y = newManifest;
        return newManifest;
    }

    public final dq.y v(List<? extends dq.y> list, dq.y yVar) {
        m format = yVar.f7418zn.get(0).f7385n3;
        Intrinsics.checkNotNullExpressionValue(format, "format");
        for (dq.y yVar2 : list) {
            if (yVar2.f7416n3 == yVar.f7416n3) {
                m format2 = yVar2.f7418zn.get(0).f7385n3;
                Intrinsics.checkNotNullExpressionValue(format2, "format");
                if (Intrinsics.areEqual(format2.f10962r, format.f10962r) && Intrinsics.areEqual(format2.f10948f3, format.f10948f3)) {
                    return yVar2;
                }
            }
        }
        return null;
    }

    public final List<dq.y> y(i9 i9Var, List<? extends dq.y> list) {
        List<dq.y> adaptationSets = i9Var.f7367zn;
        Intrinsics.checkNotNullExpressionValue(adaptationSets, "adaptationSets");
        ArrayList arrayList = new ArrayList();
        for (dq.y yVar : adaptationSets) {
            dq.y v2 = v(list, yVar);
            if (v2 == null) {
                arrayList.add(yVar);
            } else {
                List<tl> representations = yVar.f7418zn;
                Intrinsics.checkNotNullExpressionValue(representations, "representations");
                List<tl> representations2 = v2.f7418zn;
                Intrinsics.checkNotNullExpressionValue(representations2, "representations");
                arrayList.add(new dq.y(yVar.y, yVar.f7416n3, zn(representations, representations2, i9Var), yVar.f7415gv, yVar.f7417v, yVar.f7414a));
            }
        }
        return arrayList;
    }

    public final List<tl> zn(List<? extends tl> list, List<? extends tl> list2, i9 i9Var) {
        ArrayList arrayList = new ArrayList();
        for (tl tlVar : list) {
            tl a2 = a(list2, tlVar);
            if (a2 == null) {
                arrayList.add(tlVar);
            } else {
                Intrinsics.checkNotNull(tlVar, "null cannot be cast to non-null type com.google.android.exoplayer2.source.dash.manifest.Representation.MultiSegmentRepresentation");
                wz.y yVar = ((tl.n3) tlVar).f7389c5;
                Intrinsics.checkNotNull(yVar, "null cannot be cast to non-null type com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SegmentList");
                wz.y yVar2 = ((tl.n3) a2).f7389c5;
                Intrinsics.checkNotNull(yVar2, "null cannot be cast to non-null type com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SegmentList");
                tl w4 = tl.w(tlVar.y, tlVar.f7385n3, tlVar.f7388zn, gv((wz.n3) yVar, (wz.n3) yVar2, i9Var), tlVar.f7387v, tlVar.f7382a, tlVar.f7383fb, null);
                Intrinsics.checkNotNullExpressionValue(w4, "newInstance(...)");
                arrayList.add(w4);
            }
        }
        return arrayList;
    }
}
