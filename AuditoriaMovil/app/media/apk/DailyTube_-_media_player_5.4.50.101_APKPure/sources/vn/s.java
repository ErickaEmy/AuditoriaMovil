package vn;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;
import wm.wz;
/* loaded from: classes.dex */
public class s {

    /* renamed from: n3  reason: collision with root package name */
    public final List<y<Integer, Integer>> f14458n3;
    public final List<y<wz, Path>> y;

    /* renamed from: zn  reason: collision with root package name */
    public final List<wm.s> f14459zn;

    public s(List<wm.s> list) {
        this.f14459zn = list;
        this.y = new ArrayList(list.size());
        this.f14458n3 = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            this.y.add(list.get(i).n3().gv());
            this.f14458n3.add(list.get(i).zn().y());
        }
    }

    public List<wm.s> n3() {
        return this.f14459zn;
    }

    public List<y<wz, Path>> y() {
        return this.y;
    }

    public List<y<Integer, Integer>> zn() {
        return this.f14458n3;
    }
}
