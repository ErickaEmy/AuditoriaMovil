package td1;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class zn<T> {
    public final Function1<T, Unit> y;

    public zn() {
        this(null, 1, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof zn) && Intrinsics.areEqual(this.y, ((zn) obj).y)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        Function1<T, Unit> function1 = this.y;
        if (function1 == null) {
            return 0;
        }
        return function1.hashCode();
    }

    public String toString() {
        return "Callbacks(onClose=" + this.y + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public zn(Function1<? super T, Unit> function1) {
        this.y = function1;
    }

    public /* synthetic */ zn(Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : function1);
    }
}
