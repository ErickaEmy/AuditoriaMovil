package androidx.compose.ui.semantics;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
/* compiled from: SemanticsProperties.kt */
/* loaded from: classes.dex */
public final class SemanticsPropertyKey {
    private final Function2 mergePolicy;
    private final String name;

    public final String getName() {
        return this.name;
    }

    public SemanticsPropertyKey(String name, Function2 mergePolicy) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(mergePolicy, "mergePolicy");
        this.name = name;
        this.mergePolicy = mergePolicy;
    }

    public /* synthetic */ SemanticsPropertyKey(String str, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? new Function2() { // from class: androidx.compose.ui.semantics.SemanticsPropertyKey.1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return obj == null ? obj2 : obj;
            }
        } : function2);
    }

    public final Object merge(Object obj, Object obj2) {
        return this.mergePolicy.invoke(obj, obj2);
    }

    public final void setValue(SemanticsPropertyReceiver thisRef, KProperty property, Object obj) {
        Intrinsics.checkNotNullParameter(thisRef, "thisRef");
        Intrinsics.checkNotNullParameter(property, "property");
        thisRef.set(this, obj);
    }

    public String toString() {
        return "SemanticsPropertyKey: " + this.name;
    }
}
