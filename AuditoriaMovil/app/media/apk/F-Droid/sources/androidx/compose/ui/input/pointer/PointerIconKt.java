package androidx.compose.ui.input.pointer;

import androidx.appcompat.app.ToolbarActionBar$$ExternalSyntheticThrowCCEIfNotNull0;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.modifier.ModifierLocalKt;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: PointerIcon.kt */
/* loaded from: classes.dex */
public abstract class PointerIconKt {
    private static final ProvidableModifierLocal ModifierLocalPointerIcon = ModifierLocalKt.modifierLocalOf(new Function0() { // from class: androidx.compose.ui.input.pointer.PointerIconKt$ModifierLocalPointerIcon$1
        @Override // kotlin.jvm.functions.Function0
        public final PointerIconModifierLocal invoke() {
            return null;
        }
    });

    public static /* synthetic */ Modifier pointerHoverIcon$default(Modifier modifier, PointerIcon pointerIcon, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return pointerHoverIcon(modifier, pointerIcon, z);
    }

    public static final Modifier pointerHoverIcon(Modifier modifier, final PointerIcon icon, final boolean z) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(icon, "icon");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1() { // from class: androidx.compose.ui.input.pointer.PointerIconKt$pointerHoverIcon$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                ToolbarActionBar$$ExternalSyntheticThrowCCEIfNotNull0.m(obj);
                invoke((InspectorInfo) null);
                return Unit.INSTANCE;
            }

            public final void invoke(InspectorInfo inspectorInfo) {
                Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
                throw null;
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3() { // from class: androidx.compose.ui.input.pointer.PointerIconKt$pointerHoverIcon$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
            }

            public final Modifier invoke(Modifier composed, Composer composer, int i) {
                Modifier modifier2;
                Modifier then;
                Intrinsics.checkNotNullParameter(composed, "$this$composed");
                composer.startReplaceableGroup(811087536);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(811087536, i, -1, "androidx.compose.ui.input.pointer.pointerHoverIcon.<anonymous> (PointerIcon.kt:89)");
                }
                final PointerIconService pointerIconService = (PointerIconService) composer.consume(CompositionLocalsKt.getLocalPointerIconService());
                if (pointerIconService == null) {
                    then = Modifier.Companion;
                } else {
                    final Function1 function1 = new Function1() { // from class: androidx.compose.ui.input.pointer.PointerIconKt$pointerHoverIcon$2$onSetIcon$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((PointerIcon) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(PointerIcon pointerIcon) {
                            PointerIconService.this.setIcon(pointerIcon);
                        }
                    };
                    PointerIcon pointerIcon = PointerIcon.this;
                    boolean z2 = z;
                    composer.startReplaceableGroup(-492369756);
                    Object rememberedValue = composer.rememberedValue();
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        rememberedValue = new PointerIconModifierLocal(pointerIcon, z2, function1);
                        composer.updateRememberedValue(rememberedValue);
                    }
                    composer.endReplaceableGroup();
                    final PointerIconModifierLocal pointerIconModifierLocal = (PointerIconModifierLocal) rememberedValue;
                    Object[] objArr = {pointerIconModifierLocal, PointerIcon.this, Boolean.valueOf(z), function1};
                    final PointerIcon pointerIcon2 = PointerIcon.this;
                    final boolean z3 = z;
                    composer.startReplaceableGroup(-568225417);
                    boolean z4 = false;
                    for (int i2 = 0; i2 < 4; i2++) {
                        z4 |= composer.changed(objArr[i2]);
                    }
                    Object rememberedValue2 = composer.rememberedValue();
                    if (z4 || rememberedValue2 == Composer.Companion.getEmpty()) {
                        rememberedValue2 = new Function0() { // from class: androidx.compose.ui.input.pointer.PointerIconKt$pointerHoverIcon$2$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Object invoke() {
                                m1184invoke();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke  reason: collision with other method in class */
                            public final void m1184invoke() {
                                PointerIconModifierLocal.this.updateValues(pointerIcon2, z3, function1);
                            }
                        };
                        composer.updateRememberedValue(rememberedValue2);
                    }
                    composer.endReplaceableGroup();
                    EffectsKt.SideEffect((Function0) rememberedValue2, composer, 0);
                    if (pointerIconModifierLocal.shouldUpdatePointerIcon()) {
                        composer.startReplaceableGroup(1157296644);
                        boolean changed = composer.changed(pointerIconModifierLocal);
                        Object rememberedValue3 = composer.rememberedValue();
                        if (changed || rememberedValue3 == Composer.Companion.getEmpty()) {
                            rememberedValue3 = new PointerIconKt$pointerHoverIcon$2$pointerInputModifier$1$1(pointerIconModifierLocal, null);
                            composer.updateRememberedValue(rememberedValue3);
                        }
                        composer.endReplaceableGroup();
                        modifier2 = SuspendingPointerInputFilterKt.pointerInput(composed, pointerIconModifierLocal, (Function2) rememberedValue3);
                    } else {
                        modifier2 = Modifier.Companion;
                    }
                    then = pointerIconModifierLocal.then(modifier2);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceableGroup();
                return then;
            }
        });
    }
}
