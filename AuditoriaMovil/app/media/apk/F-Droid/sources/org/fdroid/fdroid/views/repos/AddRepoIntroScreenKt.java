package org.fdroid.fdroid.views.repos;

import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.text.KeyboardActionScope;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material.AppBarKt;
import androidx.compose.material.ButtonDefaults;
import androidx.compose.material.ColorsKt;
import androidx.compose.material.ContentAlpha;
import androidx.compose.material.IconButtonKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.TextFieldKt;
import androidx.compose.material.TextKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.ArrowDropDownKt;
import androidx.compose.material.icons.filled.ArrowDropUpKt;
import androidx.compose.material.icons.filled.ContentPasteKt;
import androidx.compose.material.icons.filled.QrCodeKt;
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
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.ClipboardManager;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectionModeKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.unit.Dp;
import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanIntentResult;
import com.journeyapps.barcodescanner.ScanOptions;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.fdroid.fdroid.R;
import org.fdroid.fdroid.compose.ComposeUtils;
import org.fdroid.repo.AddRepoError;
import org.fdroid.repo.AddRepoState;
import org.fdroid.repo.Added;
import org.fdroid.repo.Adding;
import org.fdroid.repo.FetchResult;
import org.fdroid.repo.Fetching;
import org.fdroid.repo.None;
/* compiled from: AddRepoIntroScreen.kt */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\u001a)\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0007\u001aE\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\fH\u0007¢\u0006\u0002\u0010\u000e\u001a\r\u0010\u000f\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0010\u001a\r\u0010\u0011\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0010¨\u0006\u0012²\u0006\n\u0010\u0013\u001a\u00020\u0014X\u008a\u008e\u0002"}, d2 = {"AddRepoIntroContent", "", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "onFetchRepo", "Lkotlin/Function1;", "", "(Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "AddRepoIntroScreen", "state", "Lorg/fdroid/repo/AddRepoState;", "onAddRepo", "Lkotlin/Function0;", "onBackClicked", "(Lorg/fdroid/repo/AddRepoState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "AddRepoIntroScreenPreview", "(Landroidx/compose/runtime/Composer;I)V", "AddRepoIntroScreenPreviewNight", "app_fullRelease", "manualExpanded", ""}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AddRepoIntroScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean AddRepoIntroContent$lambda$8$lambda$2(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    public static final void AddRepoIntroScreen(final AddRepoState state, final Function1 onFetchRepo, final Function0 onAddRepo, final Function0 onBackClicked, Composer composer, final int i) {
        final String stringResource;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(onFetchRepo, "onFetchRepo");
        Intrinsics.checkNotNullParameter(onAddRepo, "onAddRepo");
        Intrinsics.checkNotNullParameter(onBackClicked, "onBackClicked");
        Composer startRestartGroup = composer.startRestartGroup(850783860);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(850783860, i, -1, "org.fdroid.fdroid.views.repos.AddRepoIntroScreen (AddRepoIntroScreen.kt:80)");
        }
        if (state instanceof Fetching) {
            startRestartGroup.startReplaceableGroup(1410112133);
            FetchResult fetchResult = ((Fetching) state).getFetchResult();
            if ((fetchResult instanceof FetchResult.IsNewMirror) || (fetchResult instanceof FetchResult.IsExistingMirror)) {
                startRestartGroup.startReplaceableGroup(1410112247);
                stringResource = StringResources_androidKt.stringResource(R.string.repo_add_mirror, startRestartGroup, 0);
                startRestartGroup.endReplaceableGroup();
            } else {
                startRestartGroup.startReplaceableGroup(1410112309);
                stringResource = StringResources_androidKt.stringResource(R.string.repo_add_new_title, startRestartGroup, 0);
                startRestartGroup.endReplaceableGroup();
            }
            startRestartGroup.endReplaceableGroup();
        } else {
            startRestartGroup.startReplaceableGroup(1410112384);
            stringResource = StringResources_androidKt.stringResource(R.string.repo_add_new_title, startRestartGroup, 0);
            startRestartGroup.endReplaceableGroup();
        }
        ScaffoldKt.m527Scaffold27mzLpw(null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1244361721, true, new Function2() { // from class: org.fdroid.fdroid.views.repos.AddRepoIntroScreenKt$AddRepoIntroScreen$1
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
                if ((i2 & 11) != 2 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1244361721, i2, -1, "org.fdroid.fdroid.views.repos.AddRepoIntroScreen.<anonymous> (AddRepoIntroScreen.kt:93)");
                    }
                    float m1897constructorimpl = Dp.m1897constructorimpl(4);
                    long primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composer2, MaterialTheme.$stable));
                    final String str = stringResource;
                    ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer2, 1585750709, true, new Function2() { // from class: org.fdroid.fdroid.views.repos.AddRepoIntroScreenKt$AddRepoIntroScreen$1.1
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
                            if ((i3 & 11) != 2 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1585750709, i3, -1, "org.fdroid.fdroid.views.repos.AddRepoIntroScreen.<anonymous>.<anonymous> (AddRepoIntroScreen.kt:102)");
                                }
                                TextKt.m581Text4IGK_g(str, AlphaKt.alpha(Modifier.Companion, ContentAlpha.INSTANCE.getHigh(composer3, ContentAlpha.$stable)), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer3, 0, 0, 131068);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    });
                    final Function0 function0 = onBackClicked;
                    AppBarKt.m430TopAppBarxWeB9s(composableLambda, null, ComposableLambdaKt.composableLambda(composer2, 1112515059, true, new Function2() { // from class: org.fdroid.fdroid.views.repos.AddRepoIntroScreenKt$AddRepoIntroScreen$1.2
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
                                    ComposerKt.traceEventStart(1112515059, i3, -1, "org.fdroid.fdroid.views.repos.AddRepoIntroScreen.<anonymous>.<anonymous> (AddRepoIntroScreen.kt:97)");
                                }
                                IconButtonKt.IconButton(Function0.this, null, false, null, ComposableSingletons$AddRepoIntroScreenKt.INSTANCE.m2618getLambda1$app_fullRelease(), composer3, 24576, 14);
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
        }), null, null, null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, 0L, 0L, ComposableLambdaKt.composableLambda(startRestartGroup, -428651598, true, new Function3() { // from class: org.fdroid.fdroid.views.repos.AddRepoIntroScreenKt$AddRepoIntroScreen$2
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
                Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
                if ((i2 & 14) == 0) {
                    i2 |= composer2.changed(paddingValues) ? 4 : 2;
                }
                if ((i2 & 91) != 18 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-428651598, i2, -1, "org.fdroid.fdroid.views.repos.AddRepoIntroScreen.<anonymous> (AddRepoIntroScreen.kt:109)");
                    }
                    AddRepoState addRepoState = AddRepoState.this;
                    if (Intrinsics.areEqual(addRepoState, None.INSTANCE)) {
                        composer2.startReplaceableGroup(-1130513876);
                        AddRepoIntroScreenKt.AddRepoIntroContent(paddingValues, onFetchRepo, composer2, i2 & 14);
                        composer2.endReplaceableGroup();
                    } else if (addRepoState instanceof Fetching) {
                        composer2.startReplaceableGroup(-1130513783);
                        if (((Fetching) AddRepoState.this).getReceivedRepo() == null) {
                            composer2.startReplaceableGroup(-1130513729);
                            RepoProgressScreenKt.RepoProgressScreen(paddingValues, StringResources_androidKt.stringResource(R.string.repo_state_fetching, composer2, 0), composer2, i2 & 14);
                            composer2.endReplaceableGroup();
                        } else {
                            composer2.startReplaceableGroup(-1130513604);
                            RepoPreviewScreenKt.RepoPreviewScreen(paddingValues, (Fetching) AddRepoState.this, onAddRepo, composer2, (i2 & 14) | 64);
                            composer2.endReplaceableGroup();
                        }
                        composer2.endReplaceableGroup();
                    } else if (Intrinsics.areEqual(addRepoState, Adding.INSTANCE)) {
                        composer2.startReplaceableGroup(-1130513498);
                        RepoProgressScreenKt.RepoProgressScreen(paddingValues, StringResources_androidKt.stringResource(R.string.repo_state_adding, composer2, 0), composer2, i2 & 14);
                        composer2.endReplaceableGroup();
                    } else if (addRepoState instanceof Added) {
                        composer2.startReplaceableGroup(-1130513396);
                        BoxKt.Box(PaddingKt.padding(Modifier.Companion, paddingValues), composer2, 0);
                        composer2.endReplaceableGroup();
                    } else if (addRepoState instanceof AddRepoError) {
                        composer2.startReplaceableGroup(-1130513305);
                        AddRepoErrorScreenKt.AddRepoErrorScreen(paddingValues, (AddRepoError) AddRepoState.this, composer2, (i2 & 14) | 64);
                        composer2.endReplaceableGroup();
                    } else {
                        composer2.startReplaceableGroup(-1130513255);
                        composer2.endReplaceableGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer2.skipToGroupEnd();
            }
        }), startRestartGroup, 384, 12582912, 131067);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: org.fdroid.fdroid.views.repos.AddRepoIntroScreenKt$AddRepoIntroScreen$3
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
                    AddRepoIntroScreenKt.AddRepoIntroScreen(AddRepoState.this, onFetchRepo, onAddRepo, onBackClicked, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v20 */
    public static final void AddRepoIntroContent(final PaddingValues paddingValues, final Function1 onFetchRepo, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Intrinsics.checkNotNullParameter(onFetchRepo, "onFetchRepo");
        Composer startRestartGroup = composer.startRestartGroup(1335287590);
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed(paddingValues) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changedInstance(onFetchRepo) ? 32 : 16;
        }
        int i3 = i2;
        if ((i3 & 91) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1335287590, i3, -1, "org.fdroid.fdroid.views.repos.AddRepoIntroContent (AddRepoIntroScreen.kt:127)");
            }
            Arrangement arrangement = Arrangement.INSTANCE;
            float f = 16;
            Arrangement.HorizontalOrVertical m187spacedBy0680j_4 = arrangement.m187spacedBy0680j_4(Dp.m1897constructorimpl(f));
            Alignment.Companion companion = Alignment.Companion;
            Alignment.Horizontal centerHorizontally = companion.getCenterHorizontally();
            Modifier.Companion companion2 = Modifier.Companion;
            Modifier padding = PaddingKt.padding(PaddingKt.m207padding3ABfNKs(ScrollKt.verticalScroll$default(SizeKt.fillMaxSize$default(companion2, 0.0f, 1, null), ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1), false, null, false, 14, null), Dp.m1897constructorimpl(f)), paddingValues);
            startRestartGroup.startReplaceableGroup(-483455358);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(m187spacedBy0680j_4, centerHorizontally, startRestartGroup, 54);
            startRestartGroup.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            ComposeUiNode.Companion companion3 = ComposeUiNode.Companion;
            Function0 constructor = companion3.getConstructor();
            Function3 modifierMaterializerOf = LayoutKt.modifierMaterializerOf(padding);
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
            Updater.m625setimpl(m624constructorimpl, columnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m625setimpl(m624constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = companion3.getSetCompositeKeyHash();
            if (m624constructorimpl.getInserting() || !Intrinsics.areEqual(m624constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m624constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m624constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            modifierMaterializerOf.invoke(SkippableUpdater.m617boximpl(SkippableUpdater.m618constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            composer2 = startRestartGroup;
            TextKt.m581Text4IGK_g(StringResources_androidKt.stringResource(R.string.repo_intro, startRestartGroup, 0), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, MaterialTheme.$stable).getBody1(), startRestartGroup, 0, 0, 65534);
            ScanContract scanContract = new ScanContract();
            composer2.startReplaceableGroup(1412446252);
            boolean z = (i3 & 112) == 32;
            Object rememberedValue = composer2.rememberedValue();
            if (z || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function1() { // from class: org.fdroid.fdroid.views.repos.AddRepoIntroScreenKt$AddRepoIntroContent$1$startForResult$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((ScanIntentResult) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(ScanIntentResult scanIntentResult) {
                        if (scanIntentResult.getContents() != null) {
                            Function1 function1 = Function1.this;
                            String contents = scanIntentResult.getContents();
                            Intrinsics.checkNotNullExpressionValue(contents, "getContents(...)");
                            function1.invoke(contents);
                        }
                    }
                };
                composer2.updateRememberedValue(rememberedValue);
            }
            composer2.endReplaceableGroup();
            final ManagedActivityResultLauncher rememberLauncherForActivityResult = ActivityResultRegistryKt.rememberLauncherForActivityResult(scanContract, (Function1) rememberedValue, composer2, 8);
            ComposeUtils.INSTANCE.FDroidButton(StringResources_androidKt.stringResource(R.string.repo_scan_qr_code, composer2, 0), new Function0() { // from class: org.fdroid.fdroid.views.repos.AddRepoIntroScreenKt$AddRepoIntroContent$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m2609invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: collision with other method in class */
                public final void m2609invoke() {
                    ManagedActivityResultLauncher managedActivityResultLauncher = ManagedActivityResultLauncher.this;
                    ScanOptions scanOptions = new ScanOptions();
                    scanOptions.setPrompt("");
                    scanOptions.setBeepEnabled(true);
                    scanOptions.setOrientationLocked(false);
                    scanOptions.setDesiredBarcodeFormats("QR_CODE");
                    scanOptions.addExtra("SCAN_TYPE", 2);
                    managedActivityResultLauncher.launch(scanOptions);
                }
            }, null, QrCodeKt.getQrCode(Icons.Filled.INSTANCE), composer2, 24576, 4);
            final boolean booleanValue = ((Boolean) composer2.consume(InspectionModeKt.getLocalInspectionMode())).booleanValue();
            Object[] objArr = new Object[0];
            composer2.startReplaceableGroup(1412446957);
            boolean changed = composer2.changed(booleanValue);
            Object rememberedValue2 = composer2.rememberedValue();
            if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: org.fdroid.fdroid.views.repos.AddRepoIntroScreenKt$AddRepoIntroContent$1$manualExpanded$2$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final MutableState invoke() {
                        MutableState mutableStateOf$default;
                        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(booleanValue), null, 2, null);
                        return mutableStateOf$default;
                    }
                };
                composer2.updateRememberedValue(rememberedValue2);
            }
            composer2.endReplaceableGroup();
            final MutableState mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr, null, null, (Function0) rememberedValue2, composer2, 8, 6);
            Arrangement.HorizontalOrVertical m187spacedBy0680j_42 = arrangement.m187spacedBy0680j_4(Dp.m1897constructorimpl(f));
            Alignment.Vertical centerVertically = companion.getCenterVertically();
            Modifier m228heightInVpY3zN4$default = SizeKt.m228heightInVpY3zN4$default(SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null), ButtonDefaults.INSTANCE.m436getMinHeightD9Ej5fM(), 0.0f, 2, null);
            composer2.startReplaceableGroup(1412447252);
            boolean changed2 = composer2.changed(mutableState);
            Object rememberedValue3 = composer2.rememberedValue();
            if (changed2 || rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = new Function0() { // from class: org.fdroid.fdroid.views.repos.AddRepoIntroScreenKt$AddRepoIntroContent$1$2$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m2610invoke();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: collision with other method in class */
                    public final void m2610invoke() {
                        boolean AddRepoIntroContent$lambda$8$lambda$2;
                        MutableState mutableState2 = MutableState.this;
                        AddRepoIntroContent$lambda$8$lambda$2 = AddRepoIntroScreenKt.AddRepoIntroContent$lambda$8$lambda$2(mutableState2);
                        AddRepoIntroScreenKt.AddRepoIntroContent$lambda$8$lambda$3(mutableState2, !AddRepoIntroContent$lambda$8$lambda$2);
                    }
                };
                composer2.updateRememberedValue(rememberedValue3);
            }
            composer2.endReplaceableGroup();
            Modifier m95clickableXHw0xAI$default = ClickableKt.m95clickableXHw0xAI$default(m228heightInVpY3zN4$default, false, null, null, rememberedValue3, 7, null);
            composer2.startReplaceableGroup(693286680);
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m187spacedBy0680j_42, centerVertically, composer2, 54);
            composer2.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
            Function0 constructor2 = companion3.getConstructor();
            Function3 modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m95clickableXHw0xAI$default);
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
            Updater.m625setimpl(m624constructorimpl2, rowMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m625setimpl(m624constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
            if (m624constructorimpl2.getInserting() || !Intrinsics.areEqual(m624constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m624constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m624constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            modifierMaterializerOf2.invoke(SkippableUpdater.m617boximpl(SkippableUpdater.m618constructorimpl(composer2)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            TextKt.m581Text4IGK_g(StringResources_androidKt.stringResource(R.string.repo_enter_url, composer2, 0), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, 0, 0, 131070);
            SpacerKt.Spacer(RowScope.CC.weight$default(rowScopeInstance, companion2, 1.0f, false, 2, null), composer2, 0);
            IconKt.m503Iconww6aTOc(AddRepoIntroContent$lambda$8$lambda$2(mutableState) ? ArrowDropUpKt.getArrowDropUp(Icons.INSTANCE.getDefault()) : ArrowDropDownKt.getArrowDropDown(Icons.INSTANCE.getDefault()), (String) null, (Modifier) null, 0L, composer2, 48, 12);
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            composer2.startReplaceableGroup(1412447747);
            Object rememberedValue4 = composer2.rememberedValue();
            Composer.Companion companion4 = Composer.Companion;
            if (rememberedValue4 == companion4.getEmpty()) {
                rememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldValue((String) null, 0L, (TextRange) null, 7, (DefaultConstructorMarker) null), null, 2, null);
                composer2.updateRememberedValue(rememberedValue4);
            }
            final MutableState mutableState2 = (MutableState) rememberedValue4;
            composer2.endReplaceableGroup();
            composer2.startReplaceableGroup(1412447822);
            Object rememberedValue5 = composer2.rememberedValue();
            if (rememberedValue5 == companion4.getEmpty()) {
                rememberedValue5 = new FocusRequester();
                composer2.updateRememberedValue(rememberedValue5);
            }
            final FocusRequester focusRequester = (FocusRequester) rememberedValue5;
            composer2.endReplaceableGroup();
            AnimatedVisibilityKt.AnimatedVisibility(columnScopeInstance, AddRepoIntroContent$lambda$8$lambda$2(mutableState), null, null, null, null, ComposableLambdaKt.composableLambda(composer2, -397246604, true, new Function3() { // from class: org.fdroid.fdroid.views.repos.AddRepoIntroScreenKt$AddRepoIntroContent$1$4
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    invoke((AnimatedVisibilityScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r49v0, types: [androidx.compose.runtime.Composer, java.lang.Object] */
                /* JADX WARN: Type inference failed for: r5v6 */
                public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer composer3, int i4) {
                    Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-397246604, i4, -1, "org.fdroid.fdroid.views.repos.AddRepoIntroContent.<anonymous>.<anonymous> (AddRepoIntroScreen.kt:185)");
                    }
                    Alignment.Companion companion5 = Alignment.Companion;
                    Alignment.Horizontal end = companion5.getEnd();
                    Arrangement arrangement2 = Arrangement.INSTANCE;
                    float f2 = 16;
                    Arrangement.HorizontalOrVertical m187spacedBy0680j_43 = arrangement2.m187spacedBy0680j_4(Dp.m1897constructorimpl(f2));
                    final MutableState mutableState3 = MutableState.this;
                    final Function1 function1 = onFetchRepo;
                    final FocusRequester focusRequester2 = focusRequester;
                    composer3.startReplaceableGroup(-483455358);
                    Modifier.Companion companion6 = Modifier.Companion;
                    MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(m187spacedBy0680j_43, end, composer3, 54);
                    composer3.startReplaceableGroup(-1323940314);
                    int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap3 = composer3.getCurrentCompositionLocalMap();
                    ComposeUiNode.Companion companion7 = ComposeUiNode.Companion;
                    Function0 constructor3 = companion7.getConstructor();
                    Function3 modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(companion6);
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
                    Updater.m625setimpl(m624constructorimpl3, columnMeasurePolicy2, companion7.getSetMeasurePolicy());
                    Updater.m625setimpl(m624constructorimpl3, currentCompositionLocalMap3, companion7.getSetResolvedCompositionLocals());
                    Function2 setCompositeKeyHash3 = companion7.getSetCompositeKeyHash();
                    if (m624constructorimpl3.getInserting() || !Intrinsics.areEqual(m624constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                        m624constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        m624constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                    }
                    modifierMaterializerOf3.invoke(SkippableUpdater.m617boximpl(SkippableUpdater.m618constructorimpl(composer3)), composer3, 0);
                    composer3.startReplaceableGroup(2058660585);
                    ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                    TextFieldValue textFieldValue = (TextFieldValue) mutableState3.getValue();
                    KeyboardOptions keyboardOptions = new KeyboardOptions(0, false, 0, ImeAction.Companion.m1684getGoeUduSuo(), 7, null);
                    composer3.startReplaceableGroup(-350842044);
                    boolean changed3 = composer3.changed(function1);
                    Object rememberedValue6 = composer3.rememberedValue();
                    if (changed3 || rememberedValue6 == Composer.Companion.getEmpty()) {
                        rememberedValue6 = new Function1() { // from class: org.fdroid.fdroid.views.repos.AddRepoIntroScreenKt$AddRepoIntroContent$1$4$1$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((KeyboardActionScope) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(KeyboardActionScope $receiver) {
                                Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                                Function1.this.invoke(((TextFieldValue) mutableState3.getValue()).getText());
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue6);
                    }
                    composer3.endReplaceableGroup();
                    KeyboardActions keyboardActions = new KeyboardActions(null, rememberedValue6, null, null, null, null, 61, null);
                    Modifier focusRequester3 = FocusRequesterModifierKt.focusRequester(SizeKt.fillMaxWidth$default(companion6, 0.0f, 1, null), focusRequester2);
                    composer3.startReplaceableGroup(-350841748);
                    Object rememberedValue7 = composer3.rememberedValue();
                    Composer.Companion companion8 = Composer.Companion;
                    if (rememberedValue7 == companion8.getEmpty()) {
                        rememberedValue7 = new Function1() { // from class: org.fdroid.fdroid.views.repos.AddRepoIntroScreenKt$AddRepoIntroContent$1$4$1$2$1
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
                        composer3.updateRememberedValue(rememberedValue7);
                    }
                    composer3.endReplaceableGroup();
                    Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(focusRequester3, (Function1) rememberedValue7);
                    composer3.startReplaceableGroup(-350842237);
                    Object rememberedValue8 = composer3.rememberedValue();
                    if (rememberedValue8 == companion8.getEmpty()) {
                        rememberedValue8 = new Function1() { // from class: org.fdroid.fdroid.views.repos.AddRepoIntroScreenKt$AddRepoIntroContent$1$4$1$3$1
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
                        composer3.updateRememberedValue(rememberedValue8);
                    }
                    composer3.endReplaceableGroup();
                    TextFieldKt.TextField(textFieldValue, (Function1) rememberedValue8, onGloballyPositioned, false, false, null, null, null, null, null, false, null, keyboardOptions, keyboardActions, false, 0, 2, null, null, null, composer3, 48, 1573248, 970744);
                    Arrangement.HorizontalOrVertical m187spacedBy0680j_44 = arrangement2.m187spacedBy0680j_4(Dp.m1897constructorimpl(f2));
                    Alignment.Vertical centerVertically2 = companion5.getCenterVertically();
                    composer3.startReplaceableGroup(693286680);
                    MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(m187spacedBy0680j_44, centerVertically2, composer3, 54);
                    composer3.startReplaceableGroup(-1323940314);
                    int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap4 = composer3.getCurrentCompositionLocalMap();
                    Function0 constructor4 = companion7.getConstructor();
                    Function3 modifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(companion6);
                    if (!(composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor4);
                    } else {
                        composer3.useNode();
                    }
                    Composer m624constructorimpl4 = Updater.m624constructorimpl(composer3);
                    Updater.m625setimpl(m624constructorimpl4, rowMeasurePolicy2, companion7.getSetMeasurePolicy());
                    Updater.m625setimpl(m624constructorimpl4, currentCompositionLocalMap4, companion7.getSetResolvedCompositionLocals());
                    Function2 setCompositeKeyHash4 = companion7.getSetCompositeKeyHash();
                    if (m624constructorimpl4.getInserting() || !Intrinsics.areEqual(m624constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                        m624constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                        m624constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                    }
                    modifierMaterializerOf4.invoke(SkippableUpdater.m617boximpl(SkippableUpdater.m618constructorimpl(composer3)), composer3, 0);
                    composer3.startReplaceableGroup(2058660585);
                    RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                    final ClipboardManager clipboardManager = (ClipboardManager) composer3.consume(CompositionLocalsKt.getLocalClipboardManager());
                    ComposeUtils composeUtils = ComposeUtils.INSTANCE;
                    composeUtils.FDroidOutlineButton(StringResources_androidKt.stringResource(R.string.paste, composer3, 0), new Function0() { // from class: org.fdroid.fdroid.views.repos.AddRepoIntroScreenKt$AddRepoIntroContent$1$4$1$4$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m2611invoke();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: collision with other method in class */
                        public final void m2611invoke() {
                            if (ClipboardManager.this.hasText()) {
                                MutableState mutableState4 = mutableState3;
                                AnnotatedString text = ClipboardManager.this.getText();
                                mutableState4.setValue(new TextFieldValue((text == null || (r1 = text.getText()) == null) ? "" : "", 0L, (TextRange) null, 6, (DefaultConstructorMarker) null));
                            }
                        }
                    }, null, ContentPasteKt.getContentPaste(Icons.INSTANCE.getDefault()), composer3, 24576, 4);
                    SpacerKt.Spacer(RowScope.CC.weight$default(rowScopeInstance2, companion6, 1.0f, false, 2, null), composer3, 0);
                    String stringResource = StringResources_androidKt.stringResource(R.string.repo_add_add, composer3, 0);
                    composer3.startReplaceableGroup(1263420298);
                    boolean changed4 = composer3.changed(function1);
                    Object rememberedValue9 = composer3.rememberedValue();
                    if (changed4 || rememberedValue9 == companion8.getEmpty()) {
                        rememberedValue9 = new Function0() { // from class: org.fdroid.fdroid.views.repos.AddRepoIntroScreenKt$AddRepoIntroContent$1$4$1$4$2$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Object invoke() {
                                m2612invoke();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke  reason: collision with other method in class */
                            public final void m2612invoke() {
                                Function1.this.invoke(((TextFieldValue) mutableState3.getValue()).getText());
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue9);
                    }
                    composer3.endReplaceableGroup();
                    composeUtils.FDroidButton(stringResource, (Function0) rememberedValue9, null, null, composer3, 24576, 12);
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
            }), composer2, 1572870, 30);
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: org.fdroid.fdroid.views.repos.AddRepoIntroScreenKt$AddRepoIntroContent$2
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

                public final void invoke(Composer composer3, int i4) {
                    AddRepoIntroScreenKt.AddRepoIntroContent(PaddingValues.this, onFetchRepo, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void AddRepoIntroContent$lambda$8$lambda$3(MutableState mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    public static final void AddRepoIntroScreenPreview(Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(1014078063);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1014078063, i, -1, "org.fdroid.fdroid.views.repos.AddRepoIntroScreenPreview (AddRepoIntroScreen.kt:234)");
            }
            ComposeUtils.INSTANCE.FDroidContent(ComposableSingletons$AddRepoIntroScreenKt.INSTANCE.m2619getLambda2$app_fullRelease(), startRestartGroup, 54);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: org.fdroid.fdroid.views.repos.AddRepoIntroScreenKt$AddRepoIntroScreenPreview$1
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
                    AddRepoIntroScreenKt.AddRepoIntroScreenPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final void AddRepoIntroScreenPreviewNight(Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(1366522945);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1366522945, i, -1, "org.fdroid.fdroid.views.repos.AddRepoIntroScreenPreviewNight (AddRepoIntroScreen.kt:242)");
            }
            ComposeUtils.INSTANCE.FDroidContent(ComposableSingletons$AddRepoIntroScreenKt.INSTANCE.m2620getLambda3$app_fullRelease(), startRestartGroup, 54);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: org.fdroid.fdroid.views.repos.AddRepoIntroScreenKt$AddRepoIntroScreenPreviewNight$1
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
                    AddRepoIntroScreenKt.AddRepoIntroScreenPreviewNight(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }
}
