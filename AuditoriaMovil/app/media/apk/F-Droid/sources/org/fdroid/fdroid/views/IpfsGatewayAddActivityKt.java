package org.fdroid.fdroid.views;

import android.net.Uri;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.AppBarKt;
import androidx.compose.material.ColorsKt;
import androidx.compose.material.IconButtonKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.TextFieldKt;
import androidx.compose.material.TextKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.ContentPasteKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.ClipboardManager;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.ColorResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.unit.Dp;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.fdroid.fdroid.R;
import org.fdroid.fdroid.compose.ComposeUtils;
/* compiled from: IpfsGatewayAddActivity.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u001a1\u0010\u0006\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u000f\u0010\b\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b²\u0006\u000e\u0010\n\u001a\u00020\u00048\n@\nX\u008a\u008e\u0002"}, d2 = {"Lkotlin/Function0;", "", "onBackClicked", "Lkotlin/Function1;", "", "onAddUserGateway", "IpfsGatewayAddScreen", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "IpfsGatewayAddScreenPreview", "(Landroidx/compose/runtime/Composer;I)V", "errorMsg", "app_fullRelease"}, k = 2, mv = {1, 9, 0})
/* loaded from: classes2.dex */
public final class IpfsGatewayAddActivityKt {
    public static final void IpfsGatewayAddScreen(final Function0 onBackClicked, final Function1 onAddUserGateway, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(onBackClicked, "onBackClicked");
        Intrinsics.checkNotNullParameter(onAddUserGateway, "onAddUserGateway");
        Composer startRestartGroup = composer.startRestartGroup(354774652);
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changedInstance(onBackClicked) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changedInstance(onAddUserGateway) ? 32 : 16;
        }
        if ((i2 & 91) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(354774652, i2, -1, "org.fdroid.fdroid.views.IpfsGatewayAddScreen (IpfsGatewayAddActivity.kt:75)");
            }
            startRestartGroup.startReplaceableGroup(1662715357);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldValue((String) null, 0L, (TextRange) null, 7, (DefaultConstructorMarker) null), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final MutableState mutableState = (MutableState) rememberedValue;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(1662715428);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new FocusRequester();
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            final FocusRequester focusRequester = (FocusRequester) rememberedValue2;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(1662715478);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            final MutableState mutableState2 = (MutableState) rememberedValue3;
            startRestartGroup.endReplaceableGroup();
            composer2 = startRestartGroup;
            ScaffoldKt.m527Scaffold27mzLpw(null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 481065623, true, new Function2() { // from class: org.fdroid.fdroid.views.IpfsGatewayAddActivityKt$IpfsGatewayAddScreen$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i3) {
                    if ((i3 & 11) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(481065623, i3, -1, "org.fdroid.fdroid.views.IpfsGatewayAddScreen.<anonymous> (IpfsGatewayAddActivity.kt:81)");
                        }
                        float m1897constructorimpl = Dp.m1897constructorimpl(4);
                        long primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composer3, MaterialTheme.$stable));
                        Function2 m2533getLambda1$app_fullRelease = ComposableSingletons$IpfsGatewayAddActivityKt.INSTANCE.m2533getLambda1$app_fullRelease();
                        final Function0 function0 = Function0.this;
                        AppBarKt.m430TopAppBarxWeB9s(m2533getLambda1$app_fullRelease, null, ComposableLambdaKt.composableLambda(composer3, 192019933, true, new Function2() { // from class: org.fdroid.fdroid.views.IpfsGatewayAddActivityKt$IpfsGatewayAddScreen$1.1
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer4, int i4) {
                                if ((i4 & 11) != 2 || !composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(192019933, i4, -1, "org.fdroid.fdroid.views.IpfsGatewayAddScreen.<anonymous>.<anonymous> (IpfsGatewayAddActivity.kt:85)");
                                    }
                                    IconButtonKt.IconButton(Function0.this, null, false, null, ComposableSingletons$IpfsGatewayAddActivityKt.INSTANCE.m2534getLambda2$app_fullRelease(), composer4, 24576, 14);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer4.skipToGroupEnd();
                            }
                        }), null, primarySurface, 0L, m1897constructorimpl, composer3, 1573254, 42);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }), null, null, null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, 0L, 0L, ComposableLambdaKt.composableLambda(startRestartGroup, 1595711230, true, new Function3() { // from class: org.fdroid.fdroid.views.IpfsGatewayAddActivityKt$IpfsGatewayAddScreen$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    invoke((PaddingValues) obj, (Composer) obj2, ((Number) obj3).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(PaddingValues paddingValues, Composer composer3, int i3) {
                    int i4;
                    String IpfsGatewayAddScreen$lambda$3;
                    final MutableState mutableState3;
                    String IpfsGatewayAddScreen$lambda$32;
                    String IpfsGatewayAddScreen$lambda$33;
                    Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
                    if ((i3 & 14) == 0) {
                        i4 = i3 | (composer3.changed(paddingValues) ? 4 : 2);
                    } else {
                        i4 = i3;
                    }
                    if ((i4 & 91) == 18 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1595711230, i4, -1, "org.fdroid.fdroid.views.IpfsGatewayAddScreen.<anonymous> (IpfsGatewayAddActivity.kt:99)");
                    }
                    Arrangement arrangement = Arrangement.INSTANCE;
                    float f = 16;
                    Arrangement.HorizontalOrVertical m187spacedBy0680j_4 = arrangement.m187spacedBy0680j_4(Dp.m1897constructorimpl(f));
                    Modifier.Companion companion2 = Modifier.Companion;
                    Modifier m207padding3ABfNKs = PaddingKt.m207padding3ABfNKs(PaddingKt.padding(companion2, paddingValues), Dp.m1897constructorimpl(f));
                    MutableState mutableState4 = MutableState.this;
                    final FocusRequester focusRequester2 = focusRequester;
                    final MutableState mutableState5 = mutableState2;
                    final Function1 function1 = onAddUserGateway;
                    composer3.startReplaceableGroup(-483455358);
                    Alignment.Companion companion3 = Alignment.Companion;
                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(m187spacedBy0680j_4, companion3.getStart(), composer3, 6);
                    composer3.startReplaceableGroup(-1323940314);
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                    ComposeUiNode.Companion companion4 = ComposeUiNode.Companion;
                    Function0 constructor = companion4.getConstructor();
                    Function3 modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m207padding3ABfNKs);
                    if (!(composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor);
                    } else {
                        composer3.useNode();
                    }
                    Composer m624constructorimpl = Updater.m624constructorimpl(composer3);
                    Updater.m625setimpl(m624constructorimpl, columnMeasurePolicy, companion4.getSetMeasurePolicy());
                    Updater.m625setimpl(m624constructorimpl, currentCompositionLocalMap, companion4.getSetResolvedCompositionLocals());
                    Function2 setCompositeKeyHash = companion4.getSetCompositeKeyHash();
                    if (m624constructorimpl.getInserting() || !Intrinsics.areEqual(m624constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        m624constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m624constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    modifierMaterializerOf.invoke(SkippableUpdater.m617boximpl(SkippableUpdater.m618constructorimpl(composer3)), composer3, 0);
                    composer3.startReplaceableGroup(2058660585);
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    MaterialTheme materialTheme = MaterialTheme.INSTANCE;
                    int i5 = MaterialTheme.$stable;
                    TextKt.m581Text4IGK_g("Enter IPFS gateway URL", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, materialTheme.getTypography(composer3, i5).getBody1(), composer3, 6, 0, 65534);
                    composer3.startReplaceableGroup(-483455358);
                    MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion3.getStart(), composer3, 0);
                    composer3.startReplaceableGroup(-1323940314);
                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                    Function0 constructor2 = companion4.getConstructor();
                    Function3 modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(companion2);
                    if (!(composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor2);
                    } else {
                        composer3.useNode();
                    }
                    Composer m624constructorimpl2 = Updater.m624constructorimpl(composer3);
                    Updater.m625setimpl(m624constructorimpl2, columnMeasurePolicy2, companion4.getSetMeasurePolicy());
                    Updater.m625setimpl(m624constructorimpl2, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
                    Function2 setCompositeKeyHash2 = companion4.getSetCompositeKeyHash();
                    if (m624constructorimpl2.getInserting() || !Intrinsics.areEqual(m624constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        m624constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        m624constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    }
                    modifierMaterializerOf2.invoke(SkippableUpdater.m617boximpl(SkippableUpdater.m618constructorimpl(composer3)), composer3, 0);
                    composer3.startReplaceableGroup(2058660585);
                    TextFieldValue textFieldValue = (TextFieldValue) mutableState4.getValue();
                    IpfsGatewayAddScreen$lambda$3 = IpfsGatewayAddActivityKt.IpfsGatewayAddScreen$lambda$3(mutableState5);
                    boolean z = IpfsGatewayAddScreen$lambda$3.length() > 0;
                    Modifier focusRequester3 = FocusRequesterModifierKt.focusRequester(SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null), focusRequester2);
                    composer3.startReplaceableGroup(1162460447);
                    Object rememberedValue4 = composer3.rememberedValue();
                    Composer.Companion companion5 = Composer.Companion;
                    if (rememberedValue4 == companion5.getEmpty()) {
                        rememberedValue4 = new Function1() { // from class: org.fdroid.fdroid.views.IpfsGatewayAddActivityKt$IpfsGatewayAddScreen$2$1$1$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((LayoutCoordinates) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(LayoutCoordinates it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                FocusRequester.this.requestFocus();
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue4);
                    }
                    composer3.endReplaceableGroup();
                    Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(focusRequester3, (Function1) rememberedValue4);
                    composer3.startReplaceableGroup(1162460186);
                    Object rememberedValue5 = composer3.rememberedValue();
                    if (rememberedValue5 == companion5.getEmpty()) {
                        mutableState3 = mutableState4;
                        rememberedValue5 = new Function1() { // from class: org.fdroid.fdroid.views.IpfsGatewayAddActivityKt$IpfsGatewayAddScreen$2$1$1$2$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((TextFieldValue) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(TextFieldValue it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                MutableState.this.setValue(it);
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue5);
                    } else {
                        mutableState3 = mutableState4;
                    }
                    composer3.endReplaceableGroup();
                    final MutableState mutableState6 = mutableState3;
                    TextFieldKt.TextField(textFieldValue, (Function1) rememberedValue5, onGloballyPositioned, false, false, null, null, null, null, null, z, null, null, null, false, 0, 2, null, null, null, composer3, 48, 1572864, 982008);
                    composer3.startReplaceableGroup(-1388516361);
                    IpfsGatewayAddScreen$lambda$32 = IpfsGatewayAddActivityKt.IpfsGatewayAddScreen$lambda$3(mutableState5);
                    if (IpfsGatewayAddScreen$lambda$32.length() > 0) {
                        IpfsGatewayAddScreen$lambda$33 = IpfsGatewayAddActivityKt.IpfsGatewayAddScreen$lambda$3(mutableState5);
                        TextKt.m581Text4IGK_g(IpfsGatewayAddScreen$lambda$33, null, ColorResources_androidKt.colorResource(R.color.fdroid_error, composer3, 0), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, materialTheme.getTypography(composer3, i5).getBody1(), composer3, 0, 0, 65530);
                    }
                    composer3.endReplaceableGroup();
                    composer3.endReplaceableGroup();
                    composer3.endNode();
                    composer3.endReplaceableGroup();
                    composer3.endReplaceableGroup();
                    Arrangement.HorizontalOrVertical m187spacedBy0680j_42 = arrangement.m187spacedBy0680j_4(Dp.m1897constructorimpl(f));
                    Alignment.Vertical centerVertically = companion3.getCenterVertically();
                    composer3.startReplaceableGroup(693286680);
                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m187spacedBy0680j_42, centerVertically, composer3, 54);
                    composer3.startReplaceableGroup(-1323940314);
                    int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap3 = composer3.getCurrentCompositionLocalMap();
                    Function0 constructor3 = companion4.getConstructor();
                    Function3 modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(companion2);
                    if (!(composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor3);
                    } else {
                        composer3.useNode();
                    }
                    Composer m624constructorimpl3 = Updater.m624constructorimpl(composer3);
                    Updater.m625setimpl(m624constructorimpl3, rowMeasurePolicy, companion4.getSetMeasurePolicy());
                    Updater.m625setimpl(m624constructorimpl3, currentCompositionLocalMap3, companion4.getSetResolvedCompositionLocals());
                    Function2 setCompositeKeyHash3 = companion4.getSetCompositeKeyHash();
                    if (m624constructorimpl3.getInserting() || !Intrinsics.areEqual(m624constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                        m624constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        m624constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                    }
                    modifierMaterializerOf3.invoke(SkippableUpdater.m617boximpl(SkippableUpdater.m618constructorimpl(composer3)), composer3, 0);
                    composer3.startReplaceableGroup(2058660585);
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    final ClipboardManager clipboardManager = (ClipboardManager) composer3.consume(CompositionLocalsKt.getLocalClipboardManager());
                    ComposeUtils composeUtils = ComposeUtils.INSTANCE;
                    composeUtils.FDroidOutlineButton(StringResources_androidKt.stringResource(R.string.paste, composer3, 0), new Function0() { // from class: org.fdroid.fdroid.views.IpfsGatewayAddActivityKt$IpfsGatewayAddScreen$2$1$2$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m2542invoke();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: collision with other method in class */
                        public final void m2542invoke() {
                            if (ClipboardManager.this.hasText()) {
                                MutableState mutableState7 = mutableState6;
                                AnnotatedString text = ClipboardManager.this.getText();
                                mutableState7.setValue(new TextFieldValue((text == null || (r1 = text.getText()) == null) ? "" : "", 0L, (TextRange) null, 6, (DefaultConstructorMarker) null));
                            }
                        }
                    }, null, ContentPasteKt.getContentPaste(Icons.INSTANCE.getDefault()), composer3, 24576, 4);
                    SpacerKt.Spacer(RowScope.CC.weight$default(rowScopeInstance, companion2, 1.0f, false, 2, null), composer3, 0);
                    String stringResource = StringResources_androidKt.stringResource(R.string.ipfsgw_add_add, composer3, 0);
                    composer3.startReplaceableGroup(1162461764);
                    boolean changed = composer3.changed(function1);
                    Object rememberedValue6 = composer3.rememberedValue();
                    if (changed || rememberedValue6 == companion5.getEmpty()) {
                        rememberedValue6 = new Function0() { // from class: org.fdroid.fdroid.views.IpfsGatewayAddActivityKt$IpfsGatewayAddScreen$2$1$2$2$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Object invoke() {
                                m2543invoke();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke  reason: collision with other method in class */
                            public final void m2543invoke() {
                                boolean endsWith$default;
                                String str;
                                Set of;
                                boolean contains;
                                mutableState5.setValue("");
                                endsWith$default = StringsKt__StringsJVMKt.endsWith$default(((TextFieldValue) MutableState.this.getValue()).getText(), "/", false, 2, null);
                                if (endsWith$default) {
                                    str = ((TextFieldValue) MutableState.this.getValue()).getText();
                                } else {
                                    str = ((TextFieldValue) MutableState.this.getValue()).getText() + "/";
                                }
                                try {
                                    Uri parse = Uri.parse(str);
                                    of = SetsKt__SetsKt.setOf((Object[]) new String[]{"http", "https"});
                                    contains = CollectionsKt___CollectionsKt.contains(of, parse.getScheme());
                                    if (!contains) {
                                        mutableState5.setValue("IPFS gateway URL should start with `https://`");
                                    } else {
                                        function1.invoke(str);
                                    }
                                } catch (Exception e) {
                                    mutableState5.setValue("could not parse uri (" + e + ")");
                                }
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue6);
                    }
                    composer3.endReplaceableGroup();
                    composeUtils.FDroidButton(stringResource, (Function0) rememberedValue6, null, null, composer3, 24576, 12);
                    composer3.endReplaceableGroup();
                    composer3.endNode();
                    composer3.endReplaceableGroup();
                    composer3.endReplaceableGroup();
                    composer3.endReplaceableGroup();
                    composer3.endNode();
                    composer3.endReplaceableGroup();
                    composer3.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), startRestartGroup, 384, 12582912, 131067);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: org.fdroid.fdroid.views.IpfsGatewayAddActivityKt$IpfsGatewayAddScreen$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i3) {
                    IpfsGatewayAddActivityKt.IpfsGatewayAddScreen(Function0.this, onAddUserGateway, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String IpfsGatewayAddScreen$lambda$3(MutableState mutableState) {
        return (String) mutableState.getValue();
    }

    public static final void IpfsGatewayAddScreenPreview(Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(-384094241);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-384094241, i, -1, "org.fdroid.fdroid.views.IpfsGatewayAddScreenPreview (IpfsGatewayAddActivity.kt:180)");
            }
            ComposeUtils.INSTANCE.FDroidContent(ComposableSingletons$IpfsGatewayAddActivityKt.INSTANCE.m2535getLambda3$app_fullRelease(), startRestartGroup, 54);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: org.fdroid.fdroid.views.IpfsGatewayAddActivityKt$IpfsGatewayAddScreenPreview$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    IpfsGatewayAddActivityKt.IpfsGatewayAddScreenPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }
}
