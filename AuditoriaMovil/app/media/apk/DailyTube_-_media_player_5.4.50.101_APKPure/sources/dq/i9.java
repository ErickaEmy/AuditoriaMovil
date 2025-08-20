package dq;

import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class i9 {

    /* renamed from: gv  reason: collision with root package name */
    public final List<s> f7364gv;

    /* renamed from: n3  reason: collision with root package name */
    public final long f7365n3;
    @Nullable

    /* renamed from: v  reason: collision with root package name */
    public final fb f7366v;
    @Nullable
    public final String y;

    /* renamed from: zn  reason: collision with root package name */
    public final List<y> f7367zn;

    public i9(@Nullable String str, long j2, List<y> list) {
        this(str, j2, list, Collections.emptyList(), null);
    }

    public int y(int i) {
        int size = this.f7367zn.size();
        for (int i5 = 0; i5 < size; i5++) {
            if (this.f7367zn.get(i5).f7416n3 == i) {
                return i5;
            }
        }
        return -1;
    }

    public i9(@Nullable String str, long j2, List<y> list, List<s> list2) {
        this(str, j2, list, list2, null);
    }

    public i9(@Nullable String str, long j2, List<y> list, List<s> list2, @Nullable fb fbVar) {
        this.y = str;
        this.f7365n3 = j2;
        this.f7367zn = Collections.unmodifiableList(list);
        this.f7364gv = Collections.unmodifiableList(list2);
        this.f7366v = fbVar;
    }
}
