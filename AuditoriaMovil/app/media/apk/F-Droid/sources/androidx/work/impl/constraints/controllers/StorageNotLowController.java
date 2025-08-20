package androidx.work.impl.constraints.controllers;

import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.model.WorkSpec;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ContraintControllers.kt */
/* loaded from: classes.dex */
public final class StorageNotLowController extends ConstraintController {
    private final int reason;

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    public int getReason() {
        return this.reason;
    }

    public boolean isConstrained(boolean z) {
        return !z;
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    public /* bridge */ /* synthetic */ boolean isConstrained(Object obj) {
        return isConstrained(((Boolean) obj).booleanValue());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StorageNotLowController(ConstraintTracker tracker) {
        super(tracker);
        Intrinsics.checkNotNullParameter(tracker, "tracker");
        this.reason = 9;
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    public boolean hasConstraint(WorkSpec workSpec) {
        Intrinsics.checkNotNullParameter(workSpec, "workSpec");
        return workSpec.constraints.requiresStorageNotLow();
    }
}
