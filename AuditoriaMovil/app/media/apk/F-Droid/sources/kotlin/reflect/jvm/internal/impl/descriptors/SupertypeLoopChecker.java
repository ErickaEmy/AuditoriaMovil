package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
/* compiled from: SupertypeLoopChecker.kt */
/* loaded from: classes2.dex */
public interface SupertypeLoopChecker {

    /* compiled from: SupertypeLoopChecker.kt */
    /* loaded from: classes2.dex */
    public static final class EMPTY implements SupertypeLoopChecker {
        public static final EMPTY INSTANCE = new EMPTY();

        private EMPTY() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker
        public Collection findLoopsInSupertypesAndDisconnect(TypeConstructor currentTypeConstructor, Collection superTypes, Function1 neighbors, Function1 reportLoop) {
            Intrinsics.checkNotNullParameter(currentTypeConstructor, "currentTypeConstructor");
            Intrinsics.checkNotNullParameter(superTypes, "superTypes");
            Intrinsics.checkNotNullParameter(neighbors, "neighbors");
            Intrinsics.checkNotNullParameter(reportLoop, "reportLoop");
            return superTypes;
        }
    }

    Collection findLoopsInSupertypesAndDisconnect(TypeConstructor typeConstructor, Collection collection, Function1 function1, Function1 function12);
}
