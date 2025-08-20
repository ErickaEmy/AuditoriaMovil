package org.fdroid.fdroid.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
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
import androidx.compose.material.FloatingActionButtonKt;
import androidx.compose.material.IconButtonKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.SwitchKt;
import androidx.compose.material.TextKt;
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
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.fdroid.fdroid.IPreferencesIpfs;
import org.fdroid.fdroid.Preferences;
import org.fdroid.fdroid.R;
import org.fdroid.fdroid.compose.ComposeUtils;
/* compiled from: IpfsGatewaySettingsActivity.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006\u001a#\u0010\u0007\u001a\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\n\u001a\r\u0010\u000b\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\f\u001a\u001d\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\u000e²\u0006\n\u0010\u0004\u001a\u00020\u0005X\u008a\u008e\u0002²\u0006.\u0010\u000f\u001a&\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00110\u0011 \u0012*\u0012\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00110\u0011\u0018\u00010\u00130\u0010X\u008a\u008e\u0002²\u0006.\u0010\u0014\u001a&\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00110\u0011 \u0012*\u0012\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00110\u0011\u0018\u00010\u00130\u0010X\u008a\u008e\u0002"}, d2 = {"DefaultGatewaysSettings", "", "prefs", "Lorg/fdroid/fdroid/IPreferencesIpfs;", "ipfsEnabled", "", "(Lorg/fdroid/fdroid/IPreferencesIpfs;ZLandroidx/compose/runtime/Composer;I)V", "IpfsGatewaySettingsScreen", "onBackClicked", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Lorg/fdroid/fdroid/IPreferencesIpfs;Landroidx/compose/runtime/Composer;I)V", "IpfsGatewaySettingsScreenPreview", "(Landroidx/compose/runtime/Composer;I)V", "UserGatewaysSettings", "app_fullRelease", "disabledDefaultGateways", "", "", "kotlin.jvm.PlatformType", "", "userGateways"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class IpfsGatewaySettingsActivityKt {
    public static final void IpfsGatewaySettingsScreen(final Function0 onBackClicked, final IPreferencesIpfs prefs, Composer composer, final int i) {
        Intrinsics.checkNotNullParameter(onBackClicked, "onBackClicked");
        Intrinsics.checkNotNullParameter(prefs, "prefs");
        Composer startRestartGroup = composer.startRestartGroup(1016342442);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1016342442, i, -1, "org.fdroid.fdroid.views.IpfsGatewaySettingsScreen (IpfsGatewaySettingsActivity.kt:72)");
        }
        final Context context = (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        startRestartGroup.startReplaceableGroup(545083810);
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(prefs.isIpfsEnabled()), null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        final MutableState mutableState = (MutableState) rememberedValue;
        startRestartGroup.endReplaceableGroup();
        ScaffoldKt.m527Scaffold27mzLpw(null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -437685009, true, new Function2() { // from class: org.fdroid.fdroid.views.IpfsGatewaySettingsActivityKt$IpfsGatewaySettingsScreen$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i2) {
                if ((i2 & 11) != 2 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-437685009, i2, -1, "org.fdroid.fdroid.views.IpfsGatewaySettingsScreen.<anonymous> (IpfsGatewaySettingsActivity.kt:78)");
                    }
                    float m1897constructorimpl = Dp.m1897constructorimpl(4);
                    long primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composer2, MaterialTheme.$stable));
                    Function2 m2537getLambda1$app_fullRelease = ComposableSingletons$IpfsGatewaySettingsActivityKt.INSTANCE.m2537getLambda1$app_fullRelease();
                    final Function0 function0 = Function0.this;
                    AppBarKt.m430TopAppBarxWeB9s(m2537getLambda1$app_fullRelease, null, ComposableLambdaKt.composableLambda(composer2, 543041129, true, new Function2() { // from class: org.fdroid.fdroid.views.IpfsGatewaySettingsActivityKt$IpfsGatewaySettingsScreen$1.1
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
                                    ComposerKt.traceEventStart(543041129, i3, -1, "org.fdroid.fdroid.views.IpfsGatewaySettingsScreen.<anonymous>.<anonymous> (IpfsGatewaySettingsActivity.kt:82)");
                                }
                                IconButtonKt.IconButton(Function0.this, null, false, null, ComposableSingletons$IpfsGatewaySettingsActivityKt.INSTANCE.m2538getLambda2$app_fullRelease(), composer3, 24576, 14);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }), null, primarySurface, 0L, m1897constructorimpl, composer2, 1573254, 42);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer2.skipToGroupEnd();
            }
        }), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -671655822, true, new Function2() { // from class: org.fdroid.fdroid.views.IpfsGatewaySettingsActivityKt$IpfsGatewaySettingsScreen$2
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
                boolean IpfsGatewaySettingsScreen$lambda$1;
                if ((i2 & 11) != 2 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-671655822, i2, -1, "org.fdroid.fdroid.views.IpfsGatewaySettingsScreen.<anonymous> (IpfsGatewaySettingsActivity.kt:96)");
                    }
                    IpfsGatewaySettingsScreen$lambda$1 = IpfsGatewaySettingsActivityKt.IpfsGatewaySettingsScreen$lambda$1(MutableState.this);
                    if (IpfsGatewaySettingsScreen$lambda$1) {
                        final Context context2 = context;
                        FloatingActionButtonKt.m501FloatingActionButtonbogVsAg(new Function0() { // from class: org.fdroid.fdroid.views.IpfsGatewaySettingsActivityKt$IpfsGatewaySettingsScreen$2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Object invoke() {
                                m2545invoke();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke  reason: collision with other method in class */
                            public final void m2545invoke() {
                                context2.startActivity(new Intent(context2, IpfsGatewayAddActivity.class));
                            }
                        }, null, null, null, 0L, 0L, null, ComposableSingletons$IpfsGatewaySettingsActivityKt.INSTANCE.m2539getLambda3$app_fullRelease(), composer2, 12582912, 126);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer2.skipToGroupEnd();
            }
        }), 0, false, null, false, null, 0.0f, 0L, 0L, 0L, 0L, 0L, ComposableLambdaKt.composableLambda(startRestartGroup, 1811401576, true, new Function3() { // from class: org.fdroid.fdroid.views.IpfsGatewaySettingsActivityKt$IpfsGatewaySettingsScreen$3
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

            public final void invoke(PaddingValues paddingValues, Composer composer2, int i2) {
                int i3;
                boolean IpfsGatewaySettingsScreen$lambda$1;
                boolean IpfsGatewaySettingsScreen$lambda$12;
                boolean IpfsGatewaySettingsScreen$lambda$13;
                Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
                if ((i2 & 14) == 0) {
                    i3 = i2 | (composer2.changed(paddingValues) ? 4 : 2);
                } else {
                    i3 = i2;
                }
                if ((i3 & 91) == 18 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1811401576, i3, -1, "org.fdroid.fdroid.views.IpfsGatewaySettingsScreen.<anonymous> (IpfsGatewaySettingsActivity.kt:104)");
                }
                Modifier.Companion companion = Modifier.Companion;
                Modifier verticalScroll$default = ScrollKt.verticalScroll$default(PaddingKt.padding(companion, paddingValues), ScrollKt.rememberScrollState(0, composer2, 0, 1), false, null, false, 14, null);
                final IPreferencesIpfs iPreferencesIpfs = IPreferencesIpfs.this;
                final MutableState mutableState2 = mutableState;
                composer2.startReplaceableGroup(733328855);
                Alignment.Companion companion2 = Alignment.Companion;
                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(companion2.getTopStart(), false, composer2, 0);
                composer2.startReplaceableGroup(-1323940314);
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                ComposeUiNode.Companion companion3 = ComposeUiNode.Companion;
                Function0 constructor = companion3.getConstructor();
                Function3 modifierMaterializerOf = LayoutKt.modifierMaterializerOf(verticalScroll$default);
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor);
                } else {
                    composer2.useNode();
                }
                Composer m624constructorimpl = Updater.m624constructorimpl(composer2);
                Updater.m625setimpl(m624constructorimpl, rememberBoxMeasurePolicy, companion3.getSetMeasurePolicy());
                Updater.m625setimpl(m624constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
                Function2 setCompositeKeyHash = companion3.getSetCompositeKeyHash();
                if (m624constructorimpl.getInserting() || !Intrinsics.areEqual(m624constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m624constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m624constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                modifierMaterializerOf.invoke(SkippableUpdater.m617boximpl(SkippableUpdater.m618constructorimpl(composer2)), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                Modifier m207padding3ABfNKs = PaddingKt.m207padding3ABfNKs(companion, Dp.m1897constructorimpl(16));
                composer2.startReplaceableGroup(-483455358);
                Arrangement arrangement = Arrangement.INSTANCE;
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion2.getStart(), composer2, 0);
                composer2.startReplaceableGroup(-1323940314);
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                Function0 constructor2 = companion3.getConstructor();
                Function3 modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m207padding3ABfNKs);
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor2);
                } else {
                    composer2.useNode();
                }
                Composer m624constructorimpl2 = Updater.m624constructorimpl(composer2);
                Updater.m625setimpl(m624constructorimpl2, columnMeasurePolicy, companion3.getSetMeasurePolicy());
                Updater.m625setimpl(m624constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
                Function2 setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
                if (m624constructorimpl2.getInserting() || !Intrinsics.areEqual(m624constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    m624constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    m624constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                modifierMaterializerOf2.invoke(SkippableUpdater.m617boximpl(SkippableUpdater.m618constructorimpl(composer2)), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
                composer2.startReplaceableGroup(693286680);
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getTop(), composer2, 0);
                composer2.startReplaceableGroup(-1323940314);
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                Function0 constructor3 = companion3.getConstructor();
                Function3 modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(fillMaxWidth$default);
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor3);
                } else {
                    composer2.useNode();
                }
                Composer m624constructorimpl3 = Updater.m624constructorimpl(composer2);
                Updater.m625setimpl(m624constructorimpl3, rowMeasurePolicy, companion3.getSetMeasurePolicy());
                Updater.m625setimpl(m624constructorimpl3, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
                Function2 setCompositeKeyHash3 = companion3.getSetCompositeKeyHash();
                if (m624constructorimpl3.getInserting() || !Intrinsics.areEqual(m624constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                    m624constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    m624constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                modifierMaterializerOf3.invoke(SkippableUpdater.m617boximpl(SkippableUpdater.m618constructorimpl(composer2)), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                TextKt.m581Text4IGK_g(StringResources_androidKt.stringResource(R.string.ipfsgw_explainer, composer2, 0), RowScope.CC.weight$default(RowScopeInstance.INSTANCE, companion, 1.0f, false, 2, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBody1(), composer2, 0, 0, 65532);
                IpfsGatewaySettingsScreen$lambda$1 = IpfsGatewaySettingsActivityKt.IpfsGatewaySettingsScreen$lambda$1(mutableState2);
                SwitchKt.Switch(IpfsGatewaySettingsScreen$lambda$1, new Function1() { // from class: org.fdroid.fdroid.views.IpfsGatewaySettingsActivityKt$IpfsGatewaySettingsScreen$3$1$1$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke(((Boolean) obj).booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z) {
                        IpfsGatewaySettingsActivityKt.IpfsGatewaySettingsScreen$lambda$2(mutableState2, z);
                        IPreferencesIpfs.this.mo2547setIpfsEnabled(z);
                    }
                }, null, false, null, null, composer2, 0, 60);
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                IpfsGatewaySettingsScreen$lambda$12 = IpfsGatewaySettingsActivityKt.IpfsGatewaySettingsScreen$lambda$1(mutableState2);
                IpfsGatewaySettingsActivityKt.DefaultGatewaysSettings(iPreferencesIpfs, IpfsGatewaySettingsScreen$lambda$12, composer2, 8);
                IpfsGatewaySettingsScreen$lambda$13 = IpfsGatewaySettingsActivityKt.IpfsGatewaySettingsScreen$lambda$1(mutableState2);
                IpfsGatewaySettingsActivityKt.UserGatewaysSettings(iPreferencesIpfs, IpfsGatewaySettingsScreen$lambda$13, composer2, 8);
                SpacerKt.Spacer(SizeKt.m226height3ABfNKs(companion, Dp.m1897constructorimpl(64)), composer2, 6);
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), startRestartGroup, 196992, 12582912, 131035);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: org.fdroid.fdroid.views.IpfsGatewaySettingsActivityKt$IpfsGatewaySettingsScreen$4
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
                    IpfsGatewaySettingsActivityKt.IpfsGatewaySettingsScreen(Function0.this, prefs, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void IpfsGatewaySettingsScreen$lambda$2(MutableState mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<String> DefaultGatewaysSettings$lambda$4(MutableState mutableState) {
        return (List) mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean IpfsGatewaySettingsScreen$lambda$1(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<String> UserGatewaysSettings$lambda$9(MutableState mutableState) {
        return (List) mutableState.getValue();
    }

    @SuppressLint({"MutableCollectionMutableState"})
    public static final void DefaultGatewaysSettings(final IPreferencesIpfs prefs, final boolean z, Composer composer, final int i) {
        Intrinsics.checkNotNullParameter(prefs, "prefs");
        Composer startRestartGroup = composer.startRestartGroup(-170757290);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-170757290, i, -1, "org.fdroid.fdroid.views.DefaultGatewaysSettings (IpfsGatewaySettingsActivity.kt:139)");
        }
        startRestartGroup.startReplaceableGroup(1189639683);
        Object rememberedValue = startRestartGroup.rememberedValue();
        Object obj = null;
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(prefs.getIpfsGwDisabledDefaults(), null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        final MutableState mutableState = (MutableState) rememberedValue;
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(-483455358);
        Modifier.Companion companion = Modifier.Companion;
        int i2 = 0;
        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), startRestartGroup, 0);
        int i3 = -1323940314;
        startRestartGroup.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
        ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
        Function0 constructor = companion2.getConstructor();
        Function3 modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion);
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
            startRestartGroup.createNode(constructor);
        } else {
            startRestartGroup.useNode();
        }
        Composer m624constructorimpl = Updater.m624constructorimpl(startRestartGroup);
        Updater.m625setimpl(m624constructorimpl, columnMeasurePolicy, companion2.getSetMeasurePolicy());
        Updater.m625setimpl(m624constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
        Function2 setCompositeKeyHash = companion2.getSetCompositeKeyHash();
        if (m624constructorimpl.getInserting() || !Intrinsics.areEqual(m624constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            m624constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m624constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        modifierMaterializerOf.invoke(SkippableUpdater.m617boximpl(SkippableUpdater.m618constructorimpl(startRestartGroup)), startRestartGroup, 0);
        int i4 = 2058660585;
        startRestartGroup.startReplaceableGroup(2058660585);
        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
        int i5 = 48;
        ComposeUtils.INSTANCE.CaptionText(StringResources_androidKt.stringResource(R.string.ipfsgw_caption_official_gateways, startRestartGroup, 0), startRestartGroup, 48);
        startRestartGroup.startReplaceableGroup(1189639877);
        for (final String str : Preferences.DEFAULT_IPFS_GATEWAYS) {
            Modifier.Companion companion3 = Modifier.Companion;
            float f = 4;
            Modifier m210paddingqDBjuR0 = PaddingKt.m210paddingqDBjuR0(SizeKt.fillMaxWidth$default(companion3, 0.0f, 1, obj), Dp.m1897constructorimpl(i5), Dp.m1897constructorimpl(f), Dp.m1897constructorimpl(i2), Dp.m1897constructorimpl(f));
            startRestartGroup.startReplaceableGroup(693286680);
            Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
            Alignment.Companion companion4 = Alignment.Companion;
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(start, companion4.getTop(), startRestartGroup, i2);
            startRestartGroup.startReplaceableGroup(i3);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, i2);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            ComposeUiNode.Companion companion5 = ComposeUiNode.Companion;
            Function0 constructor2 = companion5.getConstructor();
            Function3 modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m210paddingqDBjuR0);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor2);
            } else {
                startRestartGroup.useNode();
            }
            Composer m624constructorimpl2 = Updater.m624constructorimpl(startRestartGroup);
            Updater.m625setimpl(m624constructorimpl2, rowMeasurePolicy, companion5.getSetMeasurePolicy());
            Updater.m625setimpl(m624constructorimpl2, currentCompositionLocalMap2, companion5.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash2 = companion5.getSetCompositeKeyHash();
            if (m624constructorimpl2.getInserting() || !Intrinsics.areEqual(m624constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m624constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m624constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            modifierMaterializerOf2.invoke(SkippableUpdater.m617boximpl(SkippableUpdater.m618constructorimpl(startRestartGroup)), startRestartGroup, Integer.valueOf(i2));
            startRestartGroup.startReplaceableGroup(i4);
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            TextStyle body1 = MaterialTheme.INSTANCE.getTypography(startRestartGroup, MaterialTheme.$stable).getBody1();
            Modifier alpha = AlphaKt.alpha(rowScopeInstance.align(RowScope.CC.weight$default(rowScopeInstance, companion3, 1.0f, false, 2, null), companion4.getCenterVertically()), z ? 1.0f : 0.5f);
            Intrinsics.checkNotNull(str);
            TextKt.m581Text4IGK_g(str, alpha, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, body1, startRestartGroup, 0, 0, 65532);
            Composer composer2 = startRestartGroup;
            SwitchKt.Switch(!DefaultGatewaysSettings$lambda$4(mutableState).contains(str), new Function1() { // from class: org.fdroid.fdroid.views.IpfsGatewaySettingsActivityKt$DefaultGatewaysSettings$1$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke(((Boolean) obj2).booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z2) {
                    List DefaultGatewaysSettings$lambda$4;
                    List<String> mutableList;
                    DefaultGatewaysSettings$lambda$4 = IpfsGatewaySettingsActivityKt.DefaultGatewaysSettings$lambda$4(mutableState);
                    Intrinsics.checkNotNullExpressionValue(DefaultGatewaysSettings$lambda$4, "access$DefaultGatewaysSettings$lambda$4(...)");
                    mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) DefaultGatewaysSettings$lambda$4);
                    if (!z2) {
                        mutableList.add(str);
                    } else {
                        mutableList.remove(str);
                    }
                    mutableState.setValue(mutableList);
                    prefs.mo2548setIpfsGwDisabledDefaults(mutableList);
                }
            }, rowScopeInstance.align(companion3, companion4.getCenterVertically()), z, null, null, startRestartGroup, (i << 6) & 7168, 48);
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            mutableState = mutableState;
            startRestartGroup = composer2;
            i5 = 48;
            i4 = i4;
            i3 = -1323940314;
            i2 = i2;
            obj = null;
        }
        Composer composer3 = startRestartGroup;
        composer3.endReplaceableGroup();
        composer3.endReplaceableGroup();
        composer3.endNode();
        composer3.endReplaceableGroup();
        composer3.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = composer3.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: org.fdroid.fdroid.views.IpfsGatewaySettingsActivityKt$DefaultGatewaysSettings$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    invoke((Composer) obj2, ((Number) obj3).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer4, int i6) {
                    IpfsGatewaySettingsActivityKt.DefaultGatewaysSettings(IPreferencesIpfs.this, z, composer4, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    @SuppressLint({"MutableCollectionMutableState"})
    public static final void UserGatewaysSettings(final IPreferencesIpfs prefs, final boolean z, Composer composer, final int i) {
        List<String> UserGatewaysSettings$lambda$9;
        Intrinsics.checkNotNullParameter(prefs, "prefs");
        Composer startRestartGroup = composer.startRestartGroup(-1847366532);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1847366532, i, -1, "org.fdroid.fdroid.views.UserGatewaysSettings (IpfsGatewaySettingsActivity.kt:185)");
        }
        startRestartGroup.startReplaceableGroup(1389563298);
        Object rememberedValue = startRestartGroup.rememberedValue();
        Object obj = null;
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(prefs.getIpfsGwUserList(), null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        final MutableState mutableState = (MutableState) rememberedValue;
        startRestartGroup.endReplaceableGroup();
        ComposeUtils composeUtils = ComposeUtils.INSTANCE;
        int i2 = 48;
        composeUtils.LifecycleEventListener(new Function2() { // from class: org.fdroid.fdroid.views.IpfsGatewaySettingsActivityKt$UserGatewaysSettings$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                invoke((LifecycleOwner) obj2, (Lifecycle.Event) obj3);
                return Unit.INSTANCE;
            }

            public final void invoke(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                Intrinsics.checkNotNullParameter(lifecycleOwner, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(event, "event");
                if (Lifecycle.Event.ON_RESUME == event) {
                    mutableState.setValue(IPreferencesIpfs.this.getIpfsGwUserList());
                }
            }
        }, startRestartGroup, 48);
        startRestartGroup.startReplaceableGroup(-483455358);
        Modifier.Companion companion = Modifier.Companion;
        int i3 = 0;
        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
        ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
        Function0 constructor = companion2.getConstructor();
        Function3 modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion);
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
            startRestartGroup.createNode(constructor);
        } else {
            startRestartGroup.useNode();
        }
        Composer m624constructorimpl = Updater.m624constructorimpl(startRestartGroup);
        Updater.m625setimpl(m624constructorimpl, columnMeasurePolicy, companion2.getSetMeasurePolicy());
        Updater.m625setimpl(m624constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
        Function2 setCompositeKeyHash = companion2.getSetCompositeKeyHash();
        if (m624constructorimpl.getInserting() || !Intrinsics.areEqual(m624constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            m624constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m624constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        modifierMaterializerOf.invoke(SkippableUpdater.m617boximpl(SkippableUpdater.m618constructorimpl(startRestartGroup)), startRestartGroup, 0);
        int i4 = 2058660585;
        startRestartGroup.startReplaceableGroup(2058660585);
        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
        startRestartGroup.startReplaceableGroup(-918686857);
        Intrinsics.checkNotNullExpressionValue(UserGatewaysSettings$lambda$9(mutableState), "UserGatewaysSettings$lambda$9(...)");
        int i5 = 1;
        if (!UserGatewaysSettings$lambda$9.isEmpty()) {
            composeUtils.CaptionText(StringResources_androidKt.stringResource(R.string.ipfsgw_caption_custom_gateways, startRestartGroup, 0), startRestartGroup, 48);
        }
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(1389563750);
        for (final String str : UserGatewaysSettings$lambda$9(mutableState)) {
            Modifier.Companion companion3 = Modifier.Companion;
            float f = 4;
            Modifier m210paddingqDBjuR0 = PaddingKt.m210paddingqDBjuR0(SizeKt.fillMaxWidth$default(companion3, 0.0f, i5, obj), Dp.m1897constructorimpl(i2), Dp.m1897constructorimpl(f), Dp.m1897constructorimpl(i3), Dp.m1897constructorimpl(f));
            startRestartGroup.startReplaceableGroup(693286680);
            Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
            Alignment.Companion companion4 = Alignment.Companion;
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(start, companion4.getTop(), startRestartGroup, i3);
            startRestartGroup.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, i3);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            ComposeUiNode.Companion companion5 = ComposeUiNode.Companion;
            Function0 constructor2 = companion5.getConstructor();
            Function3 modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m210paddingqDBjuR0);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor2);
            } else {
                startRestartGroup.useNode();
            }
            Composer m624constructorimpl2 = Updater.m624constructorimpl(startRestartGroup);
            Updater.m625setimpl(m624constructorimpl2, rowMeasurePolicy, companion5.getSetMeasurePolicy());
            Updater.m625setimpl(m624constructorimpl2, currentCompositionLocalMap2, companion5.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash2 = companion5.getSetCompositeKeyHash();
            if (m624constructorimpl2.getInserting() || !Intrinsics.areEqual(m624constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m624constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m624constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            modifierMaterializerOf2.invoke(SkippableUpdater.m617boximpl(SkippableUpdater.m618constructorimpl(startRestartGroup)), startRestartGroup, Integer.valueOf(i3));
            startRestartGroup.startReplaceableGroup(i4);
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            TextStyle body1 = MaterialTheme.INSTANCE.getTypography(startRestartGroup, MaterialTheme.$stable).getBody1();
            Modifier alpha = AlphaKt.alpha(rowScopeInstance.align(RowScope.CC.weight$default(rowScopeInstance, companion3, 1.0f, false, 2, null), companion4.getCenterVertically()), z ? 1.0f : 0.5f);
            Intrinsics.checkNotNull(str);
            TextKt.m581Text4IGK_g(str, alpha, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, body1, startRestartGroup, 0, 0, 65532);
            Composer composer2 = startRestartGroup;
            IconButtonKt.IconButton(new Function0() { // from class: org.fdroid.fdroid.views.IpfsGatewaySettingsActivityKt$UserGatewaysSettings$2$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m2550invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: collision with other method in class */
                public final void m2550invoke() {
                    List UserGatewaysSettings$lambda$92;
                    List<String> mutableList;
                    UserGatewaysSettings$lambda$92 = IpfsGatewaySettingsActivityKt.UserGatewaysSettings$lambda$9(mutableState);
                    Intrinsics.checkNotNullExpressionValue(UserGatewaysSettings$lambda$92, "access$UserGatewaysSettings$lambda$9(...)");
                    mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) UserGatewaysSettings$lambda$92);
                    mutableList.remove(str);
                    mutableState.setValue(mutableList);
                    prefs.mo2549setIpfsGwUserList(mutableList);
                }
            }, rowScopeInstance.align(companion3, companion4.getCenterVertically()), z, null, ComposableSingletons$IpfsGatewaySettingsActivityKt.INSTANCE.m2540getLambda4$app_fullRelease(), startRestartGroup, ((i << 3) & 896) | 24576, 8);
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            mutableState = mutableState;
            startRestartGroup = composer2;
            i5 = 1;
            i4 = i4;
            i2 = 48;
            obj = null;
            i3 = i3;
        }
        Composer composer3 = startRestartGroup;
        composer3.endReplaceableGroup();
        composer3.endReplaceableGroup();
        composer3.endNode();
        composer3.endReplaceableGroup();
        composer3.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = composer3.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: org.fdroid.fdroid.views.IpfsGatewaySettingsActivityKt$UserGatewaysSettings$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    invoke((Composer) obj2, ((Number) obj3).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer4, int i6) {
                    IpfsGatewaySettingsActivityKt.UserGatewaysSettings(IPreferencesIpfs.this, z, composer4, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [org.fdroid.fdroid.views.IpfsGatewaySettingsActivityKt$IpfsGatewaySettingsScreenPreview$prefs$1] */
    public static final void IpfsGatewaySettingsScreenPreview(Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(-1596343769);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1596343769, i, -1, "org.fdroid.fdroid.views.IpfsGatewaySettingsScreenPreview (IpfsGatewaySettingsActivity.kt:235)");
            }
            final ?? r0 = new IPreferencesIpfs() { // from class: org.fdroid.fdroid.views.IpfsGatewaySettingsActivityKt$IpfsGatewaySettingsScreenPreview$prefs$1
                @Override // org.fdroid.fdroid.IPreferencesIpfs
                public boolean isIpfsEnabled() {
                    return true;
                }

                @Override // org.fdroid.fdroid.IPreferencesIpfs
                /* renamed from: setIpfsGwDisabledDefaults  reason: collision with other method in class */
                public /* bridge */ /* synthetic */ void mo2548setIpfsGwDisabledDefaults(List list) {
                    setIpfsGwDisabledDefaults((List<String>) list);
                }

                @Override // org.fdroid.fdroid.IPreferencesIpfs
                /* renamed from: setIpfsGwUserList  reason: collision with other method in class */
                public /* bridge */ /* synthetic */ void mo2549setIpfsGwUserList(List list) {
                    setIpfsGwUserList((List<String>) list);
                }

                @Override // org.fdroid.fdroid.IPreferencesIpfs
                /* renamed from: setIpfsEnabled */
                public Void mo2547setIpfsEnabled(boolean z) {
                    throw new NotImplementedError(null, 1, null);
                }

                @Override // org.fdroid.fdroid.IPreferencesIpfs
                public List<String> getIpfsGwUserList() {
                    List<String> listOf;
                    listOf = CollectionsKt__CollectionsJVMKt.listOf("https://my.imaginary.gateway/ifps/");
                    return listOf;
                }

                public Void setIpfsGwUserList(List<String> list) {
                    throw new NotImplementedError(null, 1, null);
                }

                @Override // org.fdroid.fdroid.IPreferencesIpfs
                public List<String> getIpfsGwDisabledDefaults() {
                    List<String> listOf;
                    listOf = CollectionsKt__CollectionsJVMKt.listOf("https://4everland.io/ipfs/");
                    return listOf;
                }

                public Void setIpfsGwDisabledDefaults(List<String> list) {
                    throw new NotImplementedError(null, 1, null);
                }
            };
            ComposeUtils.INSTANCE.FDroidContent(ComposableLambdaKt.composableLambda(startRestartGroup, -1708511377, true, new Function2() { // from class: org.fdroid.fdroid.views.IpfsGatewaySettingsActivityKt$IpfsGatewaySettingsScreenPreview$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    if ((i2 & 11) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1708511377, i2, -1, "org.fdroid.fdroid.views.IpfsGatewaySettingsScreenPreview.<anonymous> (IpfsGatewaySettingsActivity.kt:250)");
                        }
                        IpfsGatewaySettingsActivityKt.IpfsGatewaySettingsScreen(new Function0() { // from class: org.fdroid.fdroid.views.IpfsGatewaySettingsActivityKt$IpfsGatewaySettingsScreenPreview$1.1
                            /* renamed from: invoke  reason: collision with other method in class */
                            public final void m2546invoke() {
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Object invoke() {
                                m2546invoke();
                                return Unit.INSTANCE;
                            }
                        }, IpfsGatewaySettingsActivityKt$IpfsGatewaySettingsScreenPreview$prefs$1.this, composer2, 6);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }), startRestartGroup, 54);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: org.fdroid.fdroid.views.IpfsGatewaySettingsActivityKt$IpfsGatewaySettingsScreenPreview$2
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
                    IpfsGatewaySettingsActivityKt.IpfsGatewaySettingsScreenPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }
}
