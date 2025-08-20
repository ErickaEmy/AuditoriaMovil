package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArrayMap;
import androidx.compose.runtime.collection.IdentityArraySet;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Composition.kt */
/* loaded from: classes.dex */
public abstract class CompositionKt {
    private static final Object PendingApplyNoModifications = new Object();

    public static final Composition Composition(Applier applier, CompositionContext parent) {
        Intrinsics.checkNotNullParameter(applier, "applier");
        Intrinsics.checkNotNullParameter(parent, "parent");
        return new CompositionImpl(parent, applier, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addValue(IdentityArrayMap identityArrayMap, Object obj, Object obj2) {
        if (identityArrayMap.contains(obj)) {
            IdentityArraySet identityArraySet = (IdentityArraySet) identityArrayMap.get(obj);
            if (identityArraySet != null) {
                identityArraySet.add(obj2);
                return;
            }
            return;
        }
        IdentityArraySet identityArraySet2 = new IdentityArraySet();
        identityArraySet2.add(obj2);
        Unit unit = Unit.INSTANCE;
        identityArrayMap.set(obj, identityArraySet2);
    }
}
