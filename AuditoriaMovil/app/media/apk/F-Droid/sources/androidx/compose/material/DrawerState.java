package androidx.compose.material;

import androidx.compose.animation.core.TweenSpec;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.unit.Density;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Drawer.kt */
/* loaded from: classes.dex */
public final class DrawerState {
    public static final Companion Companion = new Companion(null);
    private final AnchoredDraggableState anchoredDraggableState;
    private Density density;

    public final AnchoredDraggableState getAnchoredDraggableState$material_release() {
        return this.anchoredDraggableState;
    }

    public final void setDensity$material_release(Density density) {
        this.density = density;
    }

    public DrawerState(DrawerValue initialValue, Function1 confirmStateChange) {
        TweenSpec tweenSpec;
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        Intrinsics.checkNotNullParameter(confirmStateChange, "confirmStateChange");
        tweenSpec = DrawerKt.AnimationSpec;
        this.anchoredDraggableState = new AnchoredDraggableState(initialValue, new Function1() { // from class: androidx.compose.material.DrawerState$anchoredDraggableState$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final Float invoke(float f) {
                Density requireDensity;
                float f2;
                requireDensity = DrawerState.this.requireDensity();
                f2 = DrawerKt.DrawerPositionalThreshold;
                return Float.valueOf(requireDensity.mo155toPx0680j_4(f2));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).floatValue());
            }
        }, new Function0() { // from class: androidx.compose.material.DrawerState$anchoredDraggableState$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                Density requireDensity;
                float f;
                requireDensity = DrawerState.this.requireDensity();
                f = DrawerKt.DrawerVelocityThreshold;
                return Float.valueOf(requireDensity.mo155toPx0680j_4(f));
            }
        }, tweenSpec, confirmStateChange);
    }

    public final boolean isOpen() {
        return getCurrentValue() == DrawerValue.Open;
    }

    public final DrawerValue getCurrentValue() {
        return (DrawerValue) this.anchoredDraggableState.getCurrentValue();
    }

    public final Object close(Continuation continuation) {
        Object coroutine_suspended;
        Object animateTo$default = AnchoredDraggableKt.animateTo$default(this.anchoredDraggableState, DrawerValue.Closed, 0.0f, continuation, 2, null);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return animateTo$default == coroutine_suspended ? animateTo$default : Unit.INSTANCE;
    }

    public final float requireOffset$material_release() {
        return this.anchoredDraggableState.requireOffset();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Density requireDensity() {
        Density density = this.density;
        if (density != null) {
            return density;
        }
        throw new IllegalArgumentException(("The density on DrawerState (" + this + ") was not set. Did you use DrawerState with the Drawer composable?").toString());
    }

    /* compiled from: Drawer.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Saver Saver(final Function1 confirmStateChange) {
            Intrinsics.checkNotNullParameter(confirmStateChange, "confirmStateChange");
            return SaverKt.Saver(new Function2() { // from class: androidx.compose.material.DrawerState$Companion$Saver$1
                @Override // kotlin.jvm.functions.Function2
                public final DrawerValue invoke(SaverScope Saver, DrawerState it) {
                    Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return it.getCurrentValue();
                }
            }, new Function1() { // from class: androidx.compose.material.DrawerState$Companion$Saver$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DrawerState invoke(DrawerValue it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new DrawerState(it, Function1.this);
                }
            });
        }
    }
}
