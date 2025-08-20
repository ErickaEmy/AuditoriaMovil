package androidx.compose.runtime;

import java.util.Set;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CompositionContext.kt */
/* loaded from: classes.dex */
public abstract class CompositionContext {
    public abstract void composeInitial$runtime_release(ControlledComposition controlledComposition, Function2 function2);

    public void doneComposing$runtime_release() {
    }

    public abstract boolean getCollectingParameterInformation$runtime_release();

    public abstract int getCompoundHashKey$runtime_release();

    public abstract CoroutineContext getEffectCoroutineContext();

    public abstract void insertMovableContent$runtime_release(MovableContentStateReference movableContentStateReference);

    public abstract void invalidate$runtime_release(ControlledComposition controlledComposition);

    public abstract MovableContentState movableContentStateResolve$runtime_release(MovableContentStateReference movableContentStateReference);

    public abstract void recordInspectionTable$runtime_release(Set set);

    public void registerComposer$runtime_release(Composer composer) {
        Intrinsics.checkNotNullParameter(composer, "composer");
    }

    public abstract void reportRemovedComposition$runtime_release(ControlledComposition controlledComposition);

    public void startComposing$runtime_release() {
    }

    public void unregisterComposer$runtime_release(Composer composer) {
        Intrinsics.checkNotNullParameter(composer, "composer");
    }

    public abstract void unregisterComposition$runtime_release(ControlledComposition controlledComposition);

    public PersistentCompositionLocalMap getCompositionLocalScope$runtime_release() {
        return CompositionContextKt.access$getEmptyPersistentCompositionLocalMap$p();
    }
}
