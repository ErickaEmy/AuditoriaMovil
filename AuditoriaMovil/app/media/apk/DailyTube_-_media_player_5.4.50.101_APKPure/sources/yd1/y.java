package yd1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
/* loaded from: classes.dex */
public class y {

    /* renamed from: n3  reason: collision with root package name */
    public static final C0255y f15340n3 = new C0255y(null);
    public final List<Object> y;

    /* renamed from: yd1.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0255y {
        public /* synthetic */ C0255y(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public C0255y() {
        }
    }

    public y() {
        this(null, 1, null);
    }

    public <T> T n3(KClass<?> clazz) {
        T t2;
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Iterator<T> it = this.y.iterator();
        do {
            t2 = null;
            if (!it.hasNext()) {
                break;
            }
            T next = it.next();
            if (clazz.isInstance(next)) {
                t2 = next;
                continue;
            }
        } while (t2 == null);
        return t2;
    }

    public String toString() {
        return Intrinsics.stringPlus("DefinitionParameters", CollectionsKt.toList(this.y));
    }

    public final y y(Object value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.y.add(value);
        return this;
    }

    public y(List<Object> _values) {
        Intrinsics.checkNotNullParameter(_values, "_values");
        this.y = _values;
    }

    public /* synthetic */ y(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ArrayList() : list);
    }
}
