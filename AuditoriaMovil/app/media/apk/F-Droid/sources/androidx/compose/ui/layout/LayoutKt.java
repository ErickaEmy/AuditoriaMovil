package androidx.compose.ui.layout;

import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ComposeUiNode;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Layout.kt */
/* loaded from: classes.dex */
public abstract class LayoutKt {
    public static final Function3 modifierMaterializerOf(final Modifier modifier) {
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        return ComposableLambdaKt.composableLambdaInstance(-1586257396, true, new Function3() { // from class: androidx.compose.ui.layout.LayoutKt$materializerOf$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                m1258invokeDeg8D_g(((SkippableUpdater) obj).m622unboximpl(), (Composer) obj2, ((Number) obj3).intValue());
                return Unit.INSTANCE;
            }

            /* renamed from: invoke-Deg8D_g  reason: not valid java name */
            public final void m1258invokeDeg8D_g(Composer composer, Composer composer2, int i) {
                Intrinsics.checkNotNullParameter(composer, "$this$null");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1586257396, i, -1, "androidx.compose.ui.layout.materializerOf.<anonymous> (Layout.kt:201)");
                }
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, Modifier.this);
                composer.startReplaceableGroup(509942095);
                Composer m624constructorimpl = Updater.m624constructorimpl(composer);
                ComposeUiNode.Companion companion = ComposeUiNode.Companion;
                Updater.m625setimpl(m624constructorimpl, materializeModifier, companion.getSetModifier());
                Function2 setCompositeKeyHash = companion.getSetCompositeKeyHash();
                if (m624constructorimpl.getInserting() || !Intrinsics.areEqual(m624constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m624constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m624constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                composer.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        });
    }

    public static final Function3 materializerOf(final Modifier modifier) {
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        return ComposableLambdaKt.composableLambdaInstance(-55743822, true, new Function3() { // from class: androidx.compose.ui.layout.LayoutKt$materializerOfWithCompositionLocalInjection$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                m1259invokeDeg8D_g(((SkippableUpdater) obj).m622unboximpl(), (Composer) obj2, ((Number) obj3).intValue());
                return Unit.INSTANCE;
            }

            /* renamed from: invoke-Deg8D_g  reason: not valid java name */
            public final void m1259invokeDeg8D_g(Composer composer, Composer composer2, int i) {
                Intrinsics.checkNotNullParameter(composer, "$this$null");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-55743822, i, -1, "androidx.compose.ui.layout.materializerOfWithCompositionLocalInjection.<anonymous> (Layout.kt:224)");
                }
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                Modifier materializeWithCompositionLocalInjectionInternal = ComposedModifierKt.materializeWithCompositionLocalInjectionInternal(composer2, Modifier.this);
                composer.startReplaceableGroup(509942095);
                Composer m624constructorimpl = Updater.m624constructorimpl(composer);
                ComposeUiNode.Companion companion = ComposeUiNode.Companion;
                Updater.m625setimpl(m624constructorimpl, materializeWithCompositionLocalInjectionInternal, companion.getSetModifier());
                Function2 setCompositeKeyHash = companion.getSetCompositeKeyHash();
                if (m624constructorimpl.getInserting() || !Intrinsics.areEqual(m624constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m624constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m624constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                composer.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        });
    }
}
