package yc;
/* loaded from: classes.dex */
public final class v {

    /* renamed from: n3  reason: collision with root package name */
    public final long f15331n3;
    public final long y;

    /* renamed from: zn  reason: collision with root package name */
    public final int f15332zn;

    public v(long j2, long j4, int i) {
        this.y = j2;
        this.f15331n3 = j4;
        this.f15332zn = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        if (this.y == vVar.y && this.f15331n3 == vVar.f15331n3 && this.f15332zn == vVar.f15332zn) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((gv.y(this.y) * 31) + gv.y(this.f15331n3)) * 31) + this.f15332zn;
    }

    public final long n3() {
        return this.y;
    }

    public String toString() {
        return "Topic { " + ("TaxonomyVersion=" + this.y + ", ModelVersion=" + this.f15331n3 + ", TopicCode=" + this.f15332zn + " }");
    }

    public final long y() {
        return this.f15331n3;
    }

    public final int zn() {
        return this.f15332zn;
    }
}
