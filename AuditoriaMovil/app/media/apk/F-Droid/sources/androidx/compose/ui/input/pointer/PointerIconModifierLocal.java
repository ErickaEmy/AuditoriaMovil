package androidx.compose.ui.input.pointer;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.modifier.ModifierLocalReadScope;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PointerIcon.kt */
/* loaded from: classes.dex */
public final class PointerIconModifierLocal implements PointerIcon, ModifierLocalProvider, ModifierLocalConsumer {
    private PointerIcon icon;
    private boolean isHovered;
    private boolean isPaused;
    private final ProvidableModifierLocal key;
    private Function1 onSetIcon;
    private boolean overrideDescendants;
    private final MutableState parentInfo$delegate;
    private final PointerIconModifierLocal value;

    @Override // androidx.compose.ui.Modifier
    public /* synthetic */ boolean all(Function1 function1) {
        return Modifier.Element.CC.$default$all(this, function1);
    }

    @Override // androidx.compose.ui.Modifier
    public /* synthetic */ Object foldIn(Object obj, Function2 function2) {
        return Modifier.Element.CC.$default$foldIn(this, obj, function2);
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalProvider
    public ProvidableModifierLocal getKey() {
        return this.key;
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalProvider
    public PointerIconModifierLocal getValue() {
        return this.value;
    }

    @Override // androidx.compose.ui.Modifier
    public /* synthetic */ Modifier then(Modifier modifier) {
        return Modifier.CC.$default$then(this, modifier);
    }

    private final PointerIconModifierLocal getParentInfo() {
        return (PointerIconModifierLocal) this.parentInfo$delegate.getValue();
    }

    private final void setParentInfo(PointerIconModifierLocal pointerIconModifierLocal) {
        this.parentInfo$delegate.setValue(pointerIconModifierLocal);
    }

    public PointerIconModifierLocal(PointerIcon icon, boolean z, Function1 onSetIcon) {
        MutableState mutableStateOf$default;
        ProvidableModifierLocal providableModifierLocal;
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(onSetIcon, "onSetIcon");
        this.icon = icon;
        this.overrideDescendants = z;
        this.onSetIcon = onSetIcon;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.parentInfo$delegate = mutableStateOf$default;
        providableModifierLocal = PointerIconKt.ModifierLocalPointerIcon;
        this.key = providableModifierLocal;
        this.value = this;
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalConsumer
    public void onModifierLocalsUpdated(ModifierLocalReadScope scope) {
        ProvidableModifierLocal providableModifierLocal;
        Intrinsics.checkNotNullParameter(scope, "scope");
        PointerIconModifierLocal parentInfo = getParentInfo();
        providableModifierLocal = PointerIconKt.ModifierLocalPointerIcon;
        setParentInfo((PointerIconModifierLocal) scope.getCurrent(providableModifierLocal));
        if (parentInfo == null || getParentInfo() != null) {
            return;
        }
        exit(parentInfo);
        this.onSetIcon = new Function1() { // from class: androidx.compose.ui.input.pointer.PointerIconModifierLocal$onModifierLocalsUpdated$1$1
            public final void invoke(PointerIcon pointerIcon) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((PointerIcon) obj);
                return Unit.INSTANCE;
            }
        };
    }

    public final boolean shouldUpdatePointerIcon() {
        PointerIconModifierLocal parentInfo = getParentInfo();
        return parentInfo == null || !parentInfo.hasOverride();
    }

    private final boolean hasOverride() {
        if (this.overrideDescendants) {
            return true;
        }
        PointerIconModifierLocal parentInfo = getParentInfo();
        return parentInfo != null && parentInfo.hasOverride();
    }

    public final void enter() {
        this.isHovered = true;
        if (this.isPaused) {
            return;
        }
        PointerIconModifierLocal parentInfo = getParentInfo();
        if (parentInfo != null) {
            parentInfo.pause();
        }
        this.onSetIcon.invoke(this.icon);
    }

    public final void exit() {
        exit(getParentInfo());
    }

    private final void exit(PointerIconModifierLocal pointerIconModifierLocal) {
        if (this.isHovered) {
            if (pointerIconModifierLocal == null) {
                this.onSetIcon.invoke(null);
            } else {
                pointerIconModifierLocal.reassignIcon();
            }
        }
        this.isHovered = false;
    }

    private final void reassignIcon() {
        this.isPaused = false;
        if (this.isHovered) {
            this.onSetIcon.invoke(this.icon);
        } else if (getParentInfo() == null) {
            this.onSetIcon.invoke(null);
        } else {
            PointerIconModifierLocal parentInfo = getParentInfo();
            if (parentInfo != null) {
                parentInfo.reassignIcon();
            }
        }
    }

    private final void pause() {
        this.isPaused = true;
        PointerIconModifierLocal parentInfo = getParentInfo();
        if (parentInfo != null) {
            parentInfo.pause();
        }
    }

    public final void updateValues(PointerIcon icon, boolean z, Function1 onSetIcon) {
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(onSetIcon, "onSetIcon");
        if (!Intrinsics.areEqual(this.icon, icon) && this.isHovered && !this.isPaused) {
            onSetIcon.invoke(icon);
        }
        this.icon = icon;
        this.overrideDescendants = z;
        this.onSetIcon = onSetIcon;
    }
}
