package l;

import androidx.annotation.NonNull;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
/* loaded from: classes.dex */
public final class z {

    /* renamed from: a  reason: collision with root package name */
    public int f10240a;
    @NonNull

    /* renamed from: gv  reason: collision with root package name */
    public Set<String> f10241gv;
    @NonNull

    /* renamed from: n3  reason: collision with root package name */
    public y f10242n3;
    @NonNull

    /* renamed from: v  reason: collision with root package name */
    public androidx.work.n3 f10243v;
    @NonNull
    public UUID y;
    @NonNull

    /* renamed from: zn  reason: collision with root package name */
    public androidx.work.n3 f10244zn;

    /* loaded from: classes.dex */
    public enum y {
        ENQUEUED,
        RUNNING,
        SUCCEEDED,
        FAILED,
        BLOCKED,
        CANCELLED;

        public boolean y() {
            if (this != SUCCEEDED && this != FAILED && this != CANCELLED) {
                return false;
            }
            return true;
        }
    }

    public z(@NonNull UUID uuid, @NonNull y yVar, @NonNull androidx.work.n3 n3Var, @NonNull List<String> list, @NonNull androidx.work.n3 n3Var2, int i) {
        this.y = uuid;
        this.f10242n3 = yVar;
        this.f10244zn = n3Var;
        this.f10241gv = new HashSet(list);
        this.f10243v = n3Var2;
        this.f10240a = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || z.class != obj.getClass()) {
            return false;
        }
        z zVar = (z) obj;
        if (this.f10240a != zVar.f10240a || !this.y.equals(zVar.y) || this.f10242n3 != zVar.f10242n3 || !this.f10244zn.equals(zVar.f10244zn) || !this.f10241gv.equals(zVar.f10241gv)) {
            return false;
        }
        return this.f10243v.equals(zVar.f10243v);
    }

    public int hashCode() {
        return (((((((((this.y.hashCode() * 31) + this.f10242n3.hashCode()) * 31) + this.f10244zn.hashCode()) * 31) + this.f10241gv.hashCode()) * 31) + this.f10243v.hashCode()) * 31) + this.f10240a;
    }

    public String toString() {
        return "WorkInfo{mId='" + this.y + "', mState=" + this.f10242n3 + ", mOutputData=" + this.f10244zn + ", mTags=" + this.f10241gv + ", mProgress=" + this.f10243v + '}';
    }
}
