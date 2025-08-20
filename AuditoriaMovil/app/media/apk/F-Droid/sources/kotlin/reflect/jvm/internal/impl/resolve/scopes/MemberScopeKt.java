package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MemberScope.kt */
/* loaded from: classes2.dex */
public abstract class MemberScopeKt {
    public static final Set flatMapClassifierNamesOrNull(Iterable iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        HashSet hashSet = new HashSet();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            Set classifierNames = ((MemberScope) it.next()).getClassifierNames();
            if (classifierNames == null) {
                return null;
            }
            CollectionsKt__MutableCollectionsKt.addAll(hashSet, classifierNames);
        }
        return hashSet;
    }
}
