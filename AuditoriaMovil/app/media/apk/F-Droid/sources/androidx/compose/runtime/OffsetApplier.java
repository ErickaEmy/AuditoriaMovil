package androidx.compose.runtime;

import androidx.compose.runtime.Applier;
import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Applier.kt */
/* loaded from: classes.dex */
public final class OffsetApplier implements Applier {
    private final Applier applier;
    private int nesting;
    private final int offset;

    @Override // androidx.compose.runtime.Applier
    public /* synthetic */ void onBeginChanges() {
        Applier.CC.$default$onBeginChanges(this);
    }

    @Override // androidx.compose.runtime.Applier
    public /* synthetic */ void onEndChanges() {
        Applier.CC.$default$onEndChanges(this);
    }

    public OffsetApplier(Applier applier, int i) {
        Intrinsics.checkNotNullParameter(applier, "applier");
        this.applier = applier;
        this.offset = i;
    }

    @Override // androidx.compose.runtime.Applier
    public Object getCurrent() {
        return this.applier.getCurrent();
    }

    @Override // androidx.compose.runtime.Applier
    public void down(Object obj) {
        this.nesting++;
        this.applier.down(obj);
    }

    @Override // androidx.compose.runtime.Applier
    public void up() {
        int i = this.nesting;
        if (i > 0) {
            this.nesting = i - 1;
            this.applier.up();
            return;
        }
        ComposerKt.composeRuntimeError("OffsetApplier up called with no corresponding down".toString());
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.runtime.Applier
    public void insertTopDown(int i, Object obj) {
        this.applier.insertTopDown(i + (this.nesting == 0 ? this.offset : 0), obj);
    }

    @Override // androidx.compose.runtime.Applier
    public void insertBottomUp(int i, Object obj) {
        this.applier.insertBottomUp(i + (this.nesting == 0 ? this.offset : 0), obj);
    }

    @Override // androidx.compose.runtime.Applier
    public void remove(int i, int i2) {
        this.applier.remove(i + (this.nesting == 0 ? this.offset : 0), i2);
    }

    @Override // androidx.compose.runtime.Applier
    public void move(int i, int i2, int i3) {
        int i4 = this.nesting == 0 ? this.offset : 0;
        this.applier.move(i + i4, i2 + i4, i3);
    }

    @Override // androidx.compose.runtime.Applier
    public void clear() {
        ComposerKt.composeRuntimeError("Clear is not valid on OffsetApplier".toString());
        throw new KotlinNothingValueException();
    }
}
