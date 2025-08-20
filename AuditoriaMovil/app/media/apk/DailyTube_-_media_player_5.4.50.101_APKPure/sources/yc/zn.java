package yc;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class zn {
    public final List<v> y;

    public zn(List<v> topics) {
        Intrinsics.checkNotNullParameter(topics, "topics");
        this.y = topics;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zn)) {
            return false;
        }
        zn znVar = (zn) obj;
        if (this.y.size() != znVar.y.size()) {
            return false;
        }
        return Intrinsics.areEqual(new HashSet(this.y), new HashSet(znVar.y));
    }

    public int hashCode() {
        return Objects.hash(this.y);
    }

    public String toString() {
        return "Topics=" + this.y;
    }

    public final List<v> y() {
        return this.y;
    }
}
