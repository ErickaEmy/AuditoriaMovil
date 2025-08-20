package kotlinx.coroutines.internal;

import java.util.ArrayList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: InlineList.kt */
/* loaded from: classes2.dex */
public abstract class InlineList {
    /* renamed from: constructor-impl  reason: not valid java name */
    public static Object m2287constructorimpl(Object obj) {
        return obj;
    }

    /* renamed from: constructor-impl$default  reason: not valid java name */
    public static /* synthetic */ Object m2288constructorimpl$default(Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            obj = null;
        }
        return m2287constructorimpl(obj);
    }

    /* renamed from: plus-FjFbRPM  reason: not valid java name */
    public static final Object m2289plusFjFbRPM(Object obj, Object obj2) {
        if (obj == null) {
            return m2287constructorimpl(obj2);
        }
        if (obj instanceof ArrayList) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
            ((ArrayList) obj).add(obj2);
            return m2287constructorimpl(obj);
        }
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(obj);
        arrayList.add(obj2);
        return m2287constructorimpl(arrayList);
    }
}
