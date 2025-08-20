package af;

import android.os.Bundle;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import m1.s;
/* loaded from: classes.dex */
public final class lc implements m1.s {

    /* renamed from: fb  reason: collision with root package name */
    public int f329fb;

    /* renamed from: v  reason: collision with root package name */
    public final z0.x4<rs> f330v;
    public final int y;

    /* renamed from: s  reason: collision with root package name */
    public static final lc f327s = new lc(new rs[0]);

    /* renamed from: f  reason: collision with root package name */
    public static final String f326f = v5.j5.g3(0);

    /* renamed from: t  reason: collision with root package name */
    public static final s.y<lc> f328t = new s.y() { // from class: af.eb
        @Override // m1.s.y
        public final m1.s fromBundle(Bundle bundle) {
            lc v2;
            v2 = lc.v(bundle);
            return v2;
        }
    };

    public lc(rs... rsVarArr) {
        this.f330v = z0.x4.ud(rsVarArr);
        this.y = rsVarArr.length;
        a();
    }

    private void a() {
        int i = 0;
        while (i < this.f330v.size()) {
            int i5 = i + 1;
            for (int i6 = i5; i6 < this.f330v.size(); i6++) {
                if (this.f330v.get(i).equals(this.f330v.get(i6))) {
                    v5.r.gv("TrackGroupArray", "", new IllegalArgumentException("Multiple identical TrackGroups added to one TrackGroupArray."));
                }
            }
            i = i5;
        }
    }

    public static /* synthetic */ lc v(Bundle bundle) {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(f326f);
        if (parcelableArrayList == null) {
            return new lc(new rs[0]);
        }
        return new lc((rs[]) v5.gv.n3(rs.f375p, parcelableArrayList).toArray(new rs[0]));
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || lc.class != obj.getClass()) {
            return false;
        }
        lc lcVar = (lc) obj;
        if (this.y == lcVar.y && this.f330v.equals(lcVar.f330v)) {
            return true;
        }
        return false;
    }

    public boolean gv() {
        if (this.y == 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (this.f329fb == 0) {
            this.f329fb = this.f330v.hashCode();
        }
        return this.f329fb;
    }

    public rs n3(int i) {
        return this.f330v.get(i);
    }

    @Override // m1.s
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(f326f, v5.gv.gv(this.f330v));
        return bundle;
    }

    public int zn(rs rsVar) {
        int indexOf = this.f330v.indexOf(rsVar);
        if (indexOf < 0) {
            return -1;
        }
        return indexOf;
    }
}
