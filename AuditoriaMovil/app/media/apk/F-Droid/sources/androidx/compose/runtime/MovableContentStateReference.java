package androidx.compose.runtime;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Composer.kt */
/* loaded from: classes.dex */
public final class MovableContentStateReference {
    private final Anchor anchor;
    private final ControlledComposition composition;
    private List invalidations;
    private final PersistentCompositionLocalMap locals;
    private final Object parameter;
    private final SlotTable slotTable;

    public final Anchor getAnchor$runtime_release() {
        return this.anchor;
    }

    public final ControlledComposition getComposition$runtime_release() {
        return this.composition;
    }

    public final MovableContent getContent$runtime_release() {
        return null;
    }

    public final List getInvalidations$runtime_release() {
        return this.invalidations;
    }

    public final PersistentCompositionLocalMap getLocals$runtime_release() {
        return this.locals;
    }

    public final Object getParameter$runtime_release() {
        return this.parameter;
    }

    public final SlotTable getSlotTable$runtime_release() {
        return this.slotTable;
    }

    public MovableContentStateReference(MovableContent content, Object obj, ControlledComposition composition, SlotTable slotTable, Anchor anchor, List invalidations, PersistentCompositionLocalMap locals) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(composition, "composition");
        Intrinsics.checkNotNullParameter(slotTable, "slotTable");
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        Intrinsics.checkNotNullParameter(invalidations, "invalidations");
        Intrinsics.checkNotNullParameter(locals, "locals");
        this.parameter = obj;
        this.composition = composition;
        this.slotTable = slotTable;
        this.anchor = anchor;
        this.invalidations = invalidations;
        this.locals = locals;
    }
}
