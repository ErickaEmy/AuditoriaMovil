package androidx.compose.ui.input;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: InputModeManager.kt */
/* loaded from: classes.dex */
public final class InputModeManagerImpl implements InputModeManager {
    private final MutableState inputMode$delegate;
    private final Function1 onRequestInputModeChange;

    public /* synthetic */ InputModeManagerImpl(int i, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, function1);
    }

    private InputModeManagerImpl(int i, Function1 onRequestInputModeChange) {
        MutableState mutableStateOf$default;
        Intrinsics.checkNotNullParameter(onRequestInputModeChange, "onRequestInputModeChange");
        this.onRequestInputModeChange = onRequestInputModeChange;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(InputMode.m1104boximpl(i), null, 2, null);
        this.inputMode$delegate = mutableStateOf$default;
    }

    /* renamed from: setInputMode-iuPiT84  reason: not valid java name */
    public void m1114setInputModeiuPiT84(int i) {
        this.inputMode$delegate.setValue(InputMode.m1104boximpl(i));
    }

    @Override // androidx.compose.ui.input.InputModeManager
    /* renamed from: getInputMode-aOaMEAU */
    public int mo1113getInputModeaOaMEAU() {
        return ((InputMode) this.inputMode$delegate.getValue()).m1110unboximpl();
    }
}
