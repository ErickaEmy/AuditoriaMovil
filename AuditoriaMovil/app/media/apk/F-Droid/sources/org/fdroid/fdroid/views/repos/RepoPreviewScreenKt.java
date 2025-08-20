package org.fdroid.fdroid.views.repos;

import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ImageKt;
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
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.material.CardKt;
import androidx.compose.material.ContentAlpha;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.ProgressIndicatorKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.InspectionModeKt;
import androidx.compose.ui.res.ColorResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum;
import androidx.compose.ui.unit.Dp;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.os.LocaleListCompat;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.integration.compose.GlideImageKt;
import com.bumptech.glide.request.BaseRequestOptions;
import com.google.accompanist.drawablepainter.DrawablePainterKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import org.fdroid.database.MinimalApp;
import org.fdroid.database.Repository;
import org.fdroid.fdroid.FDroidApp;
import org.fdroid.fdroid.R;
import org.fdroid.fdroid.Utils;
import org.fdroid.fdroid.compose.ComposeUtils;
import org.fdroid.index.v2.FileV2;
import org.fdroid.repo.FetchResult;
import org.fdroid.repo.Fetching;
/* compiled from: RepoPreviewScreen.kt */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a+\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b\u001a+\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\f\u001a\r\u0010\r\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u000e\u001a\r\u0010\u000f\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u000e\u001a\r\u0010\u0010\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u000e\u001a\r\u0010\u0011\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u000e\u001a\r\u0010\u0012\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u000e\u001a)\u0010\u0013\u001a\u00020\u0001*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\u0019¨\u0006\u001a"}, d2 = {"RepoPreviewHeader", "", "state", "Lorg/fdroid/repo/Fetching;", "onAddRepo", "Lkotlin/Function0;", "localeList", "Landroidx/core/os/LocaleListCompat;", "(Lorg/fdroid/repo/Fetching;Lkotlin/jvm/functions/Function0;Landroidx/core/os/LocaleListCompat;Landroidx/compose/runtime/Composer;I)V", "RepoPreviewScreen", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(Landroidx/compose/foundation/layout/PaddingValues;Lorg/fdroid/repo/Fetching;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "RepoPreviewScreenExistingMirrorPreview", "(Landroidx/compose/runtime/Composer;I)V", "RepoPreviewScreenExistingRepoPreview", "RepoPreviewScreenFetchingPreview", "RepoPreviewScreenNewMirrorPreview", "RepoPreviewScreenNewRepoAndNewMirrorPreview", "RepoPreviewApp", "Landroidx/compose/foundation/lazy/LazyItemScope;", "repo", "Lorg/fdroid/database/Repository;", "app", "Lorg/fdroid/database/MinimalApp;", "(Landroidx/compose/foundation/lazy/LazyItemScope;Lorg/fdroid/database/Repository;Lorg/fdroid/database/MinimalApp;Landroidx/core/os/LocaleListCompat;Landroidx/compose/runtime/Composer;I)V", "app_fullRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RepoPreviewScreenKt {
    public static final void RepoPreviewScreen(final PaddingValues paddingValues, final Fetching state, final Function0 onAddRepo, Composer composer, final int i) {
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(onAddRepo, "onAddRepo");
        Composer startRestartGroup = composer.startRestartGroup(-1925339862);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1925339862, i, -1, "org.fdroid.fdroid.views.repos.RepoPreviewScreen (RepoPreviewScreen.kt:63)");
        }
        final LocaleListCompat localeListCompat = LocaleListCompat.getDefault();
        Intrinsics.checkNotNullExpressionValue(localeListCompat, "getDefault(...)");
        LazyDslKt.LazyColumn(SizeKt.fillMaxWidth$default(PaddingKt.padding(Modifier.Companion, paddingValues), 0.0f, 1, null), null, PaddingKt.m202PaddingValues0680j_4(Dp.m1897constructorimpl(16)), false, Arrangement.INSTANCE.m187spacedBy0680j_4(Dp.m1897constructorimpl(8)), null, null, false, new Function1() { // from class: org.fdroid.fdroid.views.repos.RepoPreviewScreenKt$RepoPreviewScreen$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((LazyListScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(LazyListScope LazyColumn) {
                Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
                final Fetching fetching = Fetching.this;
                final Function0 function0 = onAddRepo;
                final LocaleListCompat localeListCompat2 = localeListCompat;
                LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-1537936706, true, new Function3() { // from class: org.fdroid.fdroid.views.repos.RepoPreviewScreenKt$RepoPreviewScreen$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                        invoke((LazyItemScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(LazyItemScope item, Composer composer2, int i2) {
                        Intrinsics.checkNotNullParameter(item, "$this$item");
                        if ((i2 & 81) == 16 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1537936706, i2, -1, "org.fdroid.fdroid.views.repos.RepoPreviewScreen.<anonymous>.<anonymous> (RepoPreviewScreen.kt:73)");
                        }
                        RepoPreviewScreenKt.RepoPreviewHeader(Fetching.this, function0, localeListCompat2, composer2, 520);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), 3, null);
                if (Fetching.this.getFetchResult() == null || (Fetching.this.getFetchResult() instanceof FetchResult.IsNewRepository) || (Fetching.this.getFetchResult() instanceof FetchResult.IsNewRepoAndNewMirror)) {
                    final Fetching fetching2 = Fetching.this;
                    LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-211657895, true, new Function3() { // from class: org.fdroid.fdroid.views.repos.RepoPreviewScreenKt$RepoPreviewScreen$1.2
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                            invoke((LazyItemScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(LazyItemScope item, Composer composer2, int i2) {
                            Intrinsics.checkNotNullParameter(item, "$this$item");
                            if ((i2 & 81) == 16 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-211657895, i2, -1, "org.fdroid.fdroid.views.repos.RepoPreviewScreen.<anonymous>.<anonymous> (RepoPreviewScreen.kt:80)");
                            }
                            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
                            float f = 8;
                            Arrangement.HorizontalOrVertical m187spacedBy0680j_4 = Arrangement.INSTANCE.m187spacedBy0680j_4(Dp.m1897constructorimpl(f));
                            Modifier.Companion companion = Modifier.Companion;
                            Modifier m211paddingqDBjuR0$default = PaddingKt.m211paddingqDBjuR0$default(companion, 0.0f, Dp.m1897constructorimpl(f), 0.0f, 0.0f, 13, null);
                            Fetching fetching3 = Fetching.this;
                            composer2.startReplaceableGroup(693286680);
                            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m187spacedBy0680j_4, centerVertically, composer2, 54);
                            composer2.startReplaceableGroup(-1323940314);
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                            ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
                            Function0 constructor = companion2.getConstructor();
                            Function3 modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m211paddingqDBjuR0$default);
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
                            Updater.m625setimpl(m624constructorimpl, rowMeasurePolicy, companion2.getSetMeasurePolicy());
                            Updater.m625setimpl(m624constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                            Function2 setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                            if (m624constructorimpl.getInserting() || !Intrinsics.areEqual(m624constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                m624constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                m624constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            modifierMaterializerOf.invoke(SkippableUpdater.m617boximpl(SkippableUpdater.m618constructorimpl(composer2)), composer2, 0);
                            composer2.startReplaceableGroup(2058660585);
                            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                            String stringResource = StringResources_androidKt.stringResource(R.string.repo_preview_included_apps, composer2, 0);
                            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
                            int i3 = MaterialTheme.$stable;
                            TextKt.m581Text4IGK_g(stringResource, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, materialTheme.getTypography(composer2, i3).getBody1(), composer2, 0, 0, 65534);
                            TextKt.m581Text4IGK_g(String.valueOf(fetching3.getApps().size()), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, materialTheme.getTypography(composer2, i3).getBody1(), composer2, 0, 0, 65534);
                            composer2.startReplaceableGroup(217610915);
                            if (!fetching3.getDone()) {
                                ProgressIndicatorKt.m517LinearProgressIndicator2cYBFYY(RowScope.CC.weight$default(rowScopeInstance, companion, 1.0f, false, 2, null), 0L, 0L, 0, composer2, 0, 14);
                            }
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            composer2.endNode();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), 3, null);
                    final List<MinimalApp> apps = Fetching.this.getApps();
                    final AnonymousClass3 anonymousClass3 = new Function1() { // from class: org.fdroid.fdroid.views.repos.RepoPreviewScreenKt$RepoPreviewScreen$1.3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(MinimalApp it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            return it.getPackageName();
                        }
                    };
                    final Fetching fetching3 = Fetching.this;
                    final LocaleListCompat localeListCompat3 = localeListCompat;
                    final RepoPreviewScreenKt$RepoPreviewScreen$1$invoke$$inlined$items$default$1 repoPreviewScreenKt$RepoPreviewScreen$1$invoke$$inlined$items$default$1 = new Function1() { // from class: org.fdroid.fdroid.views.repos.RepoPreviewScreenKt$RepoPreviewScreen$1$invoke$$inlined$items$default$1
                        @Override // kotlin.jvm.functions.Function1
                        public final Void invoke(MinimalApp minimalApp) {
                            return null;
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            return invoke((MinimalApp) obj);
                        }
                    };
                    LazyColumn.items(apps.size(), anonymousClass3 != null ? new Function1() { // from class: org.fdroid.fdroid.views.repos.RepoPreviewScreenKt$RepoPreviewScreen$1$invoke$$inlined$items$default$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            return invoke(((Number) obj).intValue());
                        }

                        public final Object invoke(int i2) {
                            return Function1.this.invoke(apps.get(i2));
                        }
                    } : null, new Function1() { // from class: org.fdroid.fdroid.views.repos.RepoPreviewScreenKt$RepoPreviewScreen$1$invoke$$inlined$items$default$3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            return invoke(((Number) obj).intValue());
                        }

                        public final Object invoke(int i2) {
                            return Function1.this.invoke(apps.get(i2));
                        }
                    }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4() { // from class: org.fdroid.fdroid.views.repos.RepoPreviewScreenKt$RepoPreviewScreen$1$invoke$$inlined$items$default$4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(4);
                        }

                        @Override // kotlin.jvm.functions.Function4
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            invoke((LazyItemScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(LazyItemScope items, int i2, Composer composer2, int i3) {
                            int i4;
                            Intrinsics.checkNotNullParameter(items, "$this$items");
                            if ((i3 & 14) == 0) {
                                i4 = (composer2.changed(items) ? 4 : 2) | i3;
                            } else {
                                i4 = i3;
                            }
                            if ((i3 & 112) == 0) {
                                i4 |= composer2.changed(i2) ? 32 : 16;
                            }
                            if ((i4 & 731) == 146 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-632812321, i4, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:144)");
                            }
                            MinimalApp minimalApp = (MinimalApp) apps.get(i2);
                            Repository receivedRepo = fetching3.getReceivedRepo();
                            if (receivedRepo != null) {
                                RepoPreviewScreenKt.RepoPreviewApp(items, receivedRepo, minimalApp, localeListCompat3, composer2, (i4 & 14) | 4672);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            throw new IllegalStateException("no repo".toString());
                        }
                    }));
                }
            }
        }, startRestartGroup, 24960, 234);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: org.fdroid.fdroid.views.repos.RepoPreviewScreenKt$RepoPreviewScreen$2
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
                    RepoPreviewScreenKt.RepoPreviewScreen(PaddingValues.this, state, onAddRepo, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final void RepoPreviewHeader(final Fetching state, final Function0 onAddRepo, final LocaleListCompat localeList, Composer composer, final int i) {
        String stringResource;
        Function0 function0;
        String stringResource2;
        String str;
        String replaceFirst$default;
        Composer composer2;
        Modifier.Companion companion;
        Composer composer3;
        Function0 function02;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(onAddRepo, "onAddRepo");
        Intrinsics.checkNotNullParameter(localeList, "localeList");
        Composer startRestartGroup = composer.startRestartGroup(-2115582612);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2115582612, i, -1, "org.fdroid.fdroid.views.repos.RepoPreviewHeader (RepoPreviewScreen.kt:108)");
        }
        Repository receivedRepo = state.getReceivedRepo();
        if (receivedRepo == null) {
            throw new IllegalStateException("repo was null".toString());
        }
        boolean booleanValue = ((Boolean) startRestartGroup.consume(InspectionModeKt.getLocalInspectionMode())).booleanValue();
        final Context context = (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        FetchResult fetchResult = state.getFetchResult();
        if (fetchResult instanceof FetchResult.IsNewRepository) {
            startRestartGroup.startReplaceableGroup(-544697495);
            stringResource = StringResources_androidKt.stringResource(R.string.repo_add_new_title, startRestartGroup, 0);
            startRestartGroup.endReplaceableGroup();
        } else if (fetchResult instanceof FetchResult.IsNewRepoAndNewMirror) {
            startRestartGroup.startReplaceableGroup(-544697415);
            stringResource = StringResources_androidKt.stringResource(R.string.repo_add_repo_and_mirror, startRestartGroup, 0);
            startRestartGroup.endReplaceableGroup();
        } else if (fetchResult instanceof FetchResult.IsNewMirror) {
            startRestartGroup.startReplaceableGroup(-544697339);
            stringResource = StringResources_androidKt.stringResource(R.string.repo_add_mirror, startRestartGroup, 0);
            startRestartGroup.endReplaceableGroup();
        } else if (!(fetchResult instanceof FetchResult.IsExistingRepository) && !(fetchResult instanceof FetchResult.IsExistingMirror)) {
            startRestartGroup.startReplaceableGroup(-544697186);
            startRestartGroup.endReplaceableGroup();
            throw new IllegalStateException(("Unexpected fetch state: " + state.getFetchResult()).toString());
        } else {
            startRestartGroup.startReplaceableGroup(-544697242);
            stringResource = StringResources_androidKt.stringResource(R.string.repo_view_repo, startRestartGroup, 0);
            startRestartGroup.endReplaceableGroup();
        }
        String str2 = stringResource;
        final FetchResult fetchResult2 = state.getFetchResult();
        if ((fetchResult2 instanceof FetchResult.IsNewRepository) || (fetchResult2 instanceof FetchResult.IsNewRepoAndNewMirror) || (fetchResult2 instanceof FetchResult.IsNewMirror)) {
            function0 = onAddRepo;
        } else {
            if (fetchResult2 instanceof FetchResult.IsExistingRepository) {
                function02 = new Function0() { // from class: org.fdroid.fdroid.views.repos.RepoPreviewScreenKt$RepoPreviewHeader$buttonAction$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m2644invoke();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: collision with other method in class */
                    public final void m2644invoke() {
                        RepoDetailsActivity.launch(context, ((FetchResult.IsExistingRepository) FetchResult.this).getExistingRepoId());
                    }
                };
            } else if (!(fetchResult2 instanceof FetchResult.IsExistingMirror)) {
                throw new IllegalStateException(("Unexpected fetch state: " + state.getFetchResult()).toString());
            } else {
                function02 = new Function0() { // from class: org.fdroid.fdroid.views.repos.RepoPreviewScreenKt$RepoPreviewHeader$buttonAction$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m2645invoke();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: collision with other method in class */
                    public final void m2645invoke() {
                        RepoDetailsActivity.launch(context, ((FetchResult.IsExistingMirror) FetchResult.this).getExistingRepoId());
                    }
                };
            }
            function0 = function02;
        }
        FetchResult fetchResult3 = state.getFetchResult();
        if (fetchResult3 instanceof FetchResult.IsNewRepository) {
            startRestartGroup.startReplaceableGroup(294279328);
            startRestartGroup.endReplaceableGroup();
            str = null;
        } else {
            if (fetchResult3 instanceof FetchResult.IsNewRepoAndNewMirror) {
                startRestartGroup.startReplaceableGroup(-544696406);
                stringResource2 = StringResources_androidKt.stringResource(R.string.repo_and_mirror_add_both_info, new Object[]{state.getFetchUrl()}, startRestartGroup, 64);
                startRestartGroup.endReplaceableGroup();
            } else if (fetchResult3 instanceof FetchResult.IsNewMirror) {
                startRestartGroup.startReplaceableGroup(-544696274);
                stringResource2 = StringResources_androidKt.stringResource(R.string.repo_mirror_add_info, new Object[]{state.getFetchUrl()}, startRestartGroup, 64);
                startRestartGroup.endReplaceableGroup();
            } else if (fetchResult3 instanceof FetchResult.IsExistingRepository) {
                startRestartGroup.startReplaceableGroup(-544696177);
                stringResource2 = StringResources_androidKt.stringResource(R.string.repo_exists, startRestartGroup, 0);
                startRestartGroup.endReplaceableGroup();
            } else if (!(fetchResult3 instanceof FetchResult.IsExistingMirror)) {
                startRestartGroup.startReplaceableGroup(-544696033);
                startRestartGroup.endReplaceableGroup();
                throw new IllegalStateException(("Unexpected fetch state: " + state.getFetchResult()).toString());
            } else {
                startRestartGroup.startReplaceableGroup(-544696109);
                stringResource2 = StringResources_androidKt.stringResource(R.string.repo_mirror_exists, new Object[]{state.getFetchUrl()}, startRestartGroup, 64);
                startRestartGroup.endReplaceableGroup();
            }
            str = stringResource2;
        }
        Arrangement arrangement = Arrangement.INSTANCE;
        float f = 16;
        Arrangement.HorizontalOrVertical m187spacedBy0680j_4 = arrangement.m187spacedBy0680j_4(Dp.m1897constructorimpl(f));
        Modifier.Companion companion2 = Modifier.Companion;
        Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null);
        startRestartGroup.startReplaceableGroup(-483455358);
        Alignment.Companion companion3 = Alignment.Companion;
        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(m187spacedBy0680j_4, companion3.getStart(), startRestartGroup, 6);
        startRestartGroup.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
        ComposeUiNode.Companion companion4 = ComposeUiNode.Companion;
        Function0 constructor = companion4.getConstructor();
        Function3 modifierMaterializerOf = LayoutKt.modifierMaterializerOf(fillMaxWidth$default);
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
        Updater.m625setimpl(m624constructorimpl, columnMeasurePolicy, companion4.getSetMeasurePolicy());
        Updater.m625setimpl(m624constructorimpl, currentCompositionLocalMap, companion4.getSetResolvedCompositionLocals());
        Function2 setCompositeKeyHash = companion4.getSetCompositeKeyHash();
        if (m624constructorimpl.getInserting() || !Intrinsics.areEqual(m624constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            m624constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m624constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        modifierMaterializerOf.invoke(SkippableUpdater.m617boximpl(SkippableUpdater.m618constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
        Arrangement.HorizontalOrVertical m187spacedBy0680j_42 = arrangement.m187spacedBy0680j_4(Dp.m1897constructorimpl(f));
        Alignment.Vertical centerVertically = companion3.getCenterVertically();
        startRestartGroup.startReplaceableGroup(693286680);
        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m187spacedBy0680j_42, centerVertically, startRestartGroup, 54);
        startRestartGroup.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
        Function0 constructor2 = companion4.getConstructor();
        Function3 modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(companion2);
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
        Updater.m625setimpl(m624constructorimpl2, rowMeasurePolicy, companion4.getSetMeasurePolicy());
        Updater.m625setimpl(m624constructorimpl2, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
        Function2 setCompositeKeyHash2 = companion4.getSetCompositeKeyHash();
        if (m624constructorimpl2.getInserting() || !Intrinsics.areEqual(m624constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
            m624constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
            m624constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
        }
        modifierMaterializerOf2.invoke(SkippableUpdater.m617boximpl(SkippableUpdater.m618constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
        RepoIconComposableKt.RepoIcon(receivedRepo, SizeKt.m231size3ABfNKs(companion2, Dp.m1897constructorimpl(48)), startRestartGroup, 56, 0);
        Alignment.Horizontal start = companion3.getStart();
        startRestartGroup.startReplaceableGroup(-483455358);
        MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement.getTop(), start, startRestartGroup, 48);
        startRestartGroup.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
        Function0 constructor3 = companion4.getConstructor();
        Function3 modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(companion2);
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
            startRestartGroup.createNode(constructor3);
        } else {
            startRestartGroup.useNode();
        }
        Composer m624constructorimpl3 = Updater.m624constructorimpl(startRestartGroup);
        Updater.m625setimpl(m624constructorimpl3, columnMeasurePolicy2, companion4.getSetMeasurePolicy());
        Updater.m625setimpl(m624constructorimpl3, currentCompositionLocalMap3, companion4.getSetResolvedCompositionLocals());
        Function2 setCompositeKeyHash3 = companion4.getSetCompositeKeyHash();
        if (m624constructorimpl3.getInserting() || !Intrinsics.areEqual(m624constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
            m624constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
            m624constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
        }
        modifierMaterializerOf3.invoke(SkippableUpdater.m617boximpl(SkippableUpdater.m618constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        String name = receivedRepo.getName(localeList);
        if (name == null) {
            name = "Unknown Repository";
        }
        FontWeight bold = FontWeight.Companion.getBold();
        MaterialTheme materialTheme = MaterialTheme.INSTANCE;
        int i2 = MaterialTheme.$stable;
        TextKt.m581Text4IGK_g(name, null, 0L, 0L, null, bold, null, 0L, null, null, 0L, 0, false, 1, 0, null, materialTheme.getTypography(startRestartGroup, i2).getBody1(), startRestartGroup, 196608, 3072, 57310);
        replaceFirst$default = StringsKt__StringsJVMKt.replaceFirst$default(receivedRepo.getAddress(), "https://", "", false, 4, null);
        TextKt.m581Text4IGK_g(replaceFirst$default, AlphaKt.alpha(companion2, ContentAlpha.INSTANCE.getMedium(startRestartGroup, ContentAlpha.$stable)), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, materialTheme.getTypography(startRestartGroup, i2).getBody2(), startRestartGroup, 0, 0, 65532);
        String formatLastUpdated = Utils.formatLastUpdated(((Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext())).getResources(), receivedRepo.getTimestamp());
        Intrinsics.checkNotNullExpressionValue(formatLastUpdated, "formatLastUpdated(...)");
        TextKt.m581Text4IGK_g(formatLastUpdated, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, materialTheme.getTypography(startRestartGroup, i2).getBody2(), startRestartGroup, 0, 0, 65534);
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(-1507520075);
        if (str != null) {
            Modifier m77backgroundbw27NRU$default = BackgroundKt.m77backgroundbw27NRU$default(SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null), ColorResources_androidKt.colorResource(R.color.warning, startRestartGroup, 0), null, 2, null);
            Alignment center = companion3.getCenter();
            startRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, startRestartGroup, 6);
            startRestartGroup.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0 constructor4 = companion4.getConstructor();
            Function3 modifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(m77backgroundbw27NRU$default);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor4);
            } else {
                startRestartGroup.useNode();
            }
            Composer m624constructorimpl4 = Updater.m624constructorimpl(startRestartGroup);
            Updater.m625setimpl(m624constructorimpl4, rememberBoxMeasurePolicy, companion4.getSetMeasurePolicy());
            Updater.m625setimpl(m624constructorimpl4, currentCompositionLocalMap4, companion4.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash4 = companion4.getSetCompositeKeyHash();
            if (m624constructorimpl4.getInserting() || !Intrinsics.areEqual(m624constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                m624constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                m624constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
            }
            modifierMaterializerOf4.invoke(SkippableUpdater.m617boximpl(SkippableUpdater.m618constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            composer2 = startRestartGroup;
            companion = companion2;
            TextKt.m581Text4IGK_g(str, PaddingKt.m207padding3ABfNKs(companion2, Dp.m1897constructorimpl(8)), ColorResources_androidKt.colorResource(17170443, startRestartGroup, 6), 0L, null, null, null, 0L, null, TextAlign.m1817boximpl(TextAlign.Companion.m1824getCentere0LSkKk()), 0L, 0, false, 0, 0, null, materialTheme.getTypography(startRestartGroup, i2).getBody2(), composer2, 48, 0, 65016);
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
        } else {
            composer2 = startRestartGroup;
            companion = companion2;
        }
        composer2.endReplaceableGroup();
        ComposeUtils.INSTANCE.FDroidButton(str2, function0, columnScopeInstance.align(companion, companion3.getEnd()), null, composer2, 24576, 8);
        String joinToString$default = booleanValue ? SequencesKt___SequencesKt.joinToString$default(new LoremIpsum(42).getValues(), " ", null, null, 0, null, null, 62, null) : receivedRepo.getDescription(localeList);
        Composer composer4 = composer2;
        composer4.startReplaceableGroup(-544694040);
        if (joinToString$default != null) {
            composer3 = composer4;
            TextKt.m581Text4IGK_g(joinToString$default, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, materialTheme.getTypography(composer3, i2).getBody2(), composer3, 0, 0, 65534);
        } else {
            composer3 = composer4;
        }
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
            endRestartGroup.updateScope(new Function2() { // from class: org.fdroid.fdroid.views.repos.RepoPreviewScreenKt$RepoPreviewHeader$2
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

                public final void invoke(Composer composer5, int i3) {
                    RepoPreviewScreenKt.RepoPreviewHeader(Fetching.this, onAddRepo, localeList, composer5, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final void RepoPreviewApp(final LazyItemScope lazyItemScope, final Repository repo, final MinimalApp app, final LocaleListCompat localeList, Composer composer, final int i) {
        Intrinsics.checkNotNullParameter(lazyItemScope, "<this>");
        Intrinsics.checkNotNullParameter(repo, "repo");
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(localeList, "localeList");
        Composer startRestartGroup = composer.startRestartGroup(427688889);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(427688889, i, -1, "org.fdroid.fdroid.views.repos.RepoPreviewApp (RepoPreviewScreen.kt:217)");
        }
        final boolean booleanValue = ((Boolean) startRestartGroup.consume(InspectionModeKt.getLocalInspectionMode())).booleanValue();
        CardKt.m440CardFjzlyU(SizeKt.fillMaxWidth$default(LazyItemScope.CC.animateItemPlacement$default(lazyItemScope, Modifier.Companion, null, 1, null), 0.0f, 1, null), null, 0L, 0L, null, 0.0f, ComposableLambdaKt.composableLambda(startRestartGroup, -528255498, true, new Function2() { // from class: org.fdroid.fdroid.views.repos.RepoPreviewScreenKt$RepoPreviewApp$1
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
                int i3;
                MinimalApp minimalApp;
                Modifier.Companion companion;
                if ((i2 & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-528255498, i2, -1, "org.fdroid.fdroid.views.repos.RepoPreviewApp.<anonymous> (RepoPreviewScreen.kt:224)");
                }
                Arrangement arrangement = Arrangement.INSTANCE;
                float f = 8;
                Arrangement.HorizontalOrVertical m187spacedBy0680j_4 = arrangement.m187spacedBy0680j_4(Dp.m1897constructorimpl(f));
                Modifier.Companion companion2 = Modifier.Companion;
                Modifier m207padding3ABfNKs = PaddingKt.m207padding3ABfNKs(companion2, Dp.m1897constructorimpl(f));
                boolean z = booleanValue;
                Repository repository = repo;
                MinimalApp minimalApp2 = app;
                LocaleListCompat localeListCompat = localeList;
                composer2.startReplaceableGroup(693286680);
                Alignment.Companion companion3 = Alignment.Companion;
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m187spacedBy0680j_4, companion3.getTop(), composer2, 6);
                composer2.startReplaceableGroup(-1323940314);
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                ComposeUiNode.Companion companion4 = ComposeUiNode.Companion;
                Function0 constructor = companion4.getConstructor();
                Function3 modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m207padding3ABfNKs);
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
                Updater.m625setimpl(m624constructorimpl, rowMeasurePolicy, companion4.getSetMeasurePolicy());
                Updater.m625setimpl(m624constructorimpl, currentCompositionLocalMap, companion4.getSetResolvedCompositionLocals());
                Function2 setCompositeKeyHash = companion4.getSetCompositeKeyHash();
                if (m624constructorimpl.getInserting() || !Intrinsics.areEqual(m624constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m624constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m624constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                modifierMaterializerOf.invoke(SkippableUpdater.m617boximpl(SkippableUpdater.m618constructorimpl(composer2)), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                if (z) {
                    composer2.startReplaceableGroup(1550343682);
                    i3 = 0;
                    ImageKt.Image(DrawablePainterKt.rememberDrawablePainter(ResourcesCompat.getDrawable(((Context) composer2.consume(AndroidCompositionLocals_androidKt.getLocalContext())).getResources(), R.drawable.ic_launcher, null), composer2, 8), (String) null, SizeKt.m231size3ABfNKs(companion2, Dp.m1897constructorimpl(38)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, composer2, 440, 120);
                    composer2.endReplaceableGroup();
                    minimalApp = minimalApp2;
                    companion = companion2;
                } else {
                    i3 = 0;
                    composer2.startReplaceableGroup(1550343964);
                    minimalApp = minimalApp2;
                    companion = companion2;
                    GlideImageKt.GlideImage(Utils.getGlideModel(repository, minimalApp2.getIcon(localeListCompat)), null, SizeKt.m231size3ABfNKs(companion2, Dp.m1897constructorimpl(38)), null, null, 0.0f, null, null, null, new Function1() { // from class: org.fdroid.fdroid.views.repos.RepoPreviewScreenKt$RepoPreviewApp$1$1$1
                        @Override // kotlin.jvm.functions.Function1
                        public final RequestBuilder invoke(RequestBuilder it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            BaseRequestOptions error = ((RequestBuilder) it.fallback(R.drawable.ic_repo_app_default)).error(R.drawable.ic_repo_app_default);
                            Intrinsics.checkNotNullExpressionValue(error, "error(...)");
                            return (RequestBuilder) error;
                        }
                    }, composer2, 805306808, 504);
                    composer2.endReplaceableGroup();
                }
                composer2.startReplaceableGroup(-483455358);
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion3.getStart(), composer2, i3);
                composer2.startReplaceableGroup(-1323940314);
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, i3);
                CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                Function0 constructor2 = companion4.getConstructor();
                Function3 modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(companion);
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
                Updater.m625setimpl(m624constructorimpl2, columnMeasurePolicy, companion4.getSetMeasurePolicy());
                Updater.m625setimpl(m624constructorimpl2, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
                Function2 setCompositeKeyHash2 = companion4.getSetCompositeKeyHash();
                if (m624constructorimpl2.getInserting() || !Intrinsics.areEqual(m624constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    m624constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    m624constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                modifierMaterializerOf2.invoke(SkippableUpdater.m617boximpl(SkippableUpdater.m618constructorimpl(composer2)), composer2, Integer.valueOf(i3));
                composer2.startReplaceableGroup(2058660585);
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                String name = minimalApp.getName();
                if (name == null) {
                    name = "Unknown app";
                }
                MaterialTheme materialTheme = MaterialTheme.INSTANCE;
                int i4 = MaterialTheme.$stable;
                TextKt.m581Text4IGK_g(name, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, materialTheme.getTypography(composer2, i4).getBody1(), composer2, 0, 0, 65534);
                String summary = minimalApp.getSummary();
                if (summary == null) {
                    summary = "";
                }
                TextKt.m581Text4IGK_g(summary, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, materialTheme.getTypography(composer2, i4).getBody2(), composer2, 0, 0, 65534);
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
        }), startRestartGroup, 1572864, 62);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: org.fdroid.fdroid.views.repos.RepoPreviewScreenKt$RepoPreviewApp$2
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
                    RepoPreviewScreenKt.RepoPreviewApp(LazyItemScope.this, repo, app, localeList, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [org.fdroid.fdroid.views.repos.RepoPreviewScreenKt$RepoPreviewScreenFetchingPreview$app1$1] */
    /* JADX WARN: Type inference failed for: r7v0, types: [org.fdroid.fdroid.views.repos.RepoPreviewScreenKt$RepoPreviewScreenFetchingPreview$app2$1] */
    /* JADX WARN: Type inference failed for: r8v0, types: [org.fdroid.fdroid.views.repos.RepoPreviewScreenKt$RepoPreviewScreenFetchingPreview$app3$1] */
    public static final void RepoPreviewScreenFetchingPreview(Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(-239945745);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-239945745, i, -1, "org.fdroid.fdroid.views.repos.RepoPreviewScreenFetchingPreview (RepoPreviewScreen.kt:257)");
            }
            final Repository createSwapRepo = FDroidApp.createSwapRepo("https://example.org", "foo bar");
            final ?? r6 = new MinimalApp() { // from class: org.fdroid.fdroid.views.repos.RepoPreviewScreenKt$RepoPreviewScreenFetchingPreview$app1$1
                private final long repoId;
                private final String packageName = "org.example";
                private final String name = "App 1 with a long name";
                private final String summary = "Summary of App1 which can also be a bit longer";

                @Override // org.fdroid.database.MinimalApp
                public FileV2 getIcon(LocaleListCompat localeList) {
                    Intrinsics.checkNotNullParameter(localeList, "localeList");
                    return null;
                }

                @Override // org.fdroid.database.MinimalApp
                public String getName() {
                    return this.name;
                }

                @Override // org.fdroid.database.MinimalApp
                public String getPackageName() {
                    return this.packageName;
                }

                @Override // org.fdroid.database.MinimalApp
                public long getRepoId() {
                    return this.repoId;
                }

                @Override // org.fdroid.database.MinimalApp
                public String getSummary() {
                    return this.summary;
                }
            };
            final ?? r7 = new MinimalApp() { // from class: org.fdroid.fdroid.views.repos.RepoPreviewScreenKt$RepoPreviewScreenFetchingPreview$app2$1
                private final long repoId;
                private final String packageName = "com.example";
                private final String name = "App 2 with a name that is even longer than the first app";
                private final String summary = "Summary of App2 which can also be a bit longer, even longer than other apps.";

                @Override // org.fdroid.database.MinimalApp
                public FileV2 getIcon(LocaleListCompat localeList) {
                    Intrinsics.checkNotNullParameter(localeList, "localeList");
                    return null;
                }

                @Override // org.fdroid.database.MinimalApp
                public String getName() {
                    return this.name;
                }

                @Override // org.fdroid.database.MinimalApp
                public String getPackageName() {
                    return this.packageName;
                }

                @Override // org.fdroid.database.MinimalApp
                public long getRepoId() {
                    return this.repoId;
                }

                @Override // org.fdroid.database.MinimalApp
                public String getSummary() {
                    return this.summary;
                }
            };
            final ?? r8 = new MinimalApp() { // from class: org.fdroid.fdroid.views.repos.RepoPreviewScreenKt$RepoPreviewScreenFetchingPreview$app3$1
                private final long repoId;
                private final String packageName = "net.example";
                private final String name = "App 3";
                private final String summary = "short summary";

                @Override // org.fdroid.database.MinimalApp
                public FileV2 getIcon(LocaleListCompat localeList) {
                    Intrinsics.checkNotNullParameter(localeList, "localeList");
                    return null;
                }

                @Override // org.fdroid.database.MinimalApp
                public String getName() {
                    return this.name;
                }

                @Override // org.fdroid.database.MinimalApp
                public String getPackageName() {
                    return this.packageName;
                }

                @Override // org.fdroid.database.MinimalApp
                public long getRepoId() {
                    return this.repoId;
                }

                @Override // org.fdroid.database.MinimalApp
                public String getSummary() {
                    return this.summary;
                }
            };
            ComposeUtils.INSTANCE.FDroidContent(ComposableLambdaKt.composableLambda(startRestartGroup, -941551305, true, new Function2() { // from class: org.fdroid.fdroid.views.repos.RepoPreviewScreenKt$RepoPreviewScreenFetchingPreview$1
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
                    List listOf;
                    if ((i2 & 11) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-941551305, i2, -1, "org.fdroid.fdroid.views.repos.RepoPreviewScreenFetchingPreview.<anonymous> (RepoPreviewScreen.kt:285)");
                        }
                        PaddingValues m202PaddingValues0680j_4 = PaddingKt.m202PaddingValues0680j_4(Dp.m1897constructorimpl(0));
                        String str = r1;
                        Repository repository = createSwapRepo;
                        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new MinimalApp[]{r6, r7, r8});
                        RepoPreviewScreenKt.RepoPreviewScreen(m202PaddingValues0680j_4, new Fetching(str, repository, listOf, FetchResult.IsNewRepository.INSTANCE, false, 16, null), new Function0() { // from class: org.fdroid.fdroid.views.repos.RepoPreviewScreenKt$RepoPreviewScreenFetchingPreview$1.1
                            /* renamed from: invoke  reason: collision with other method in class */
                            public final void m2648invoke() {
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Object invoke() {
                                m2648invoke();
                                return Unit.INSTANCE;
                            }
                        }, composer2, 454);
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
            endRestartGroup.updateScope(new Function2() { // from class: org.fdroid.fdroid.views.repos.RepoPreviewScreenKt$RepoPreviewScreenFetchingPreview$2
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
                    RepoPreviewScreenKt.RepoPreviewScreenFetchingPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final void RepoPreviewScreenNewMirrorPreview(Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(-292759008);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-292759008, i, -1, "org.fdroid.fdroid.views.repos.RepoPreviewScreenNewMirrorPreview (RepoPreviewScreen.kt:294)");
            }
            final Repository createSwapRepo = FDroidApp.createSwapRepo("https://example.org", "foo bar");
            ComposeUtils.INSTANCE.FDroidContent(ComposableLambdaKt.composableLambda(startRestartGroup, -567694888, true, new Function2() { // from class: org.fdroid.fdroid.views.repos.RepoPreviewScreenKt$RepoPreviewScreenNewMirrorPreview$1
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
                    List emptyList;
                    if ((i2 & 11) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-567694888, i2, -1, "org.fdroid.fdroid.views.repos.RepoPreviewScreenNewMirrorPreview.<anonymous> (RepoPreviewScreen.kt:297)");
                        }
                        PaddingValues m202PaddingValues0680j_4 = PaddingKt.m202PaddingValues0680j_4(Dp.m1897constructorimpl(0));
                        Repository repository = Repository.this;
                        emptyList = CollectionsKt__CollectionsKt.emptyList();
                        RepoPreviewScreenKt.RepoPreviewScreen(m202PaddingValues0680j_4, new Fetching("https://mirror.example.org", repository, emptyList, new FetchResult.IsNewMirror(0L), false, 16, null), new Function0() { // from class: org.fdroid.fdroid.views.repos.RepoPreviewScreenKt$RepoPreviewScreenNewMirrorPreview$1.1
                            /* renamed from: invoke  reason: collision with other method in class */
                            public final void m2649invoke() {
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Object invoke() {
                                m2649invoke();
                                return Unit.INSTANCE;
                            }
                        }, composer2, 454);
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
            endRestartGroup.updateScope(new Function2() { // from class: org.fdroid.fdroid.views.repos.RepoPreviewScreenKt$RepoPreviewScreenNewMirrorPreview$2
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
                    RepoPreviewScreenKt.RepoPreviewScreenNewMirrorPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final void RepoPreviewScreenNewRepoAndNewMirrorPreview(Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(-884684475);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-884684475, i, -1, "org.fdroid.fdroid.views.repos.RepoPreviewScreenNewRepoAndNewMirrorPreview (RepoPreviewScreen.kt:306)");
            }
            final Repository createSwapRepo = FDroidApp.createSwapRepo("https://example.org", "foo bar");
            ComposeUtils.INSTANCE.FDroidContent(ComposableLambdaKt.composableLambda(startRestartGroup, -657763587, true, new Function2() { // from class: org.fdroid.fdroid.views.repos.RepoPreviewScreenKt$RepoPreviewScreenNewRepoAndNewMirrorPreview$1
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
                    List emptyList;
                    if ((i2 & 11) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-657763587, i2, -1, "org.fdroid.fdroid.views.repos.RepoPreviewScreenNewRepoAndNewMirrorPreview.<anonymous> (RepoPreviewScreen.kt:309)");
                        }
                        PaddingValues m202PaddingValues0680j_4 = PaddingKt.m202PaddingValues0680j_4(Dp.m1897constructorimpl(0));
                        Repository repository = Repository.this;
                        emptyList = CollectionsKt__CollectionsKt.emptyList();
                        RepoPreviewScreenKt.RepoPreviewScreen(m202PaddingValues0680j_4, new Fetching("https://mirror.example.org", repository, emptyList, FetchResult.IsNewRepoAndNewMirror.INSTANCE, false, 16, null), new Function0() { // from class: org.fdroid.fdroid.views.repos.RepoPreviewScreenKt$RepoPreviewScreenNewRepoAndNewMirrorPreview$1.1
                            /* renamed from: invoke  reason: collision with other method in class */
                            public final void m2650invoke() {
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Object invoke() {
                                m2650invoke();
                                return Unit.INSTANCE;
                            }
                        }, composer2, 454);
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
            endRestartGroup.updateScope(new Function2() { // from class: org.fdroid.fdroid.views.repos.RepoPreviewScreenKt$RepoPreviewScreenNewRepoAndNewMirrorPreview$2
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
                    RepoPreviewScreenKt.RepoPreviewScreenNewRepoAndNewMirrorPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final void RepoPreviewScreenExistingRepoPreview(Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(-859214630);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-859214630, i, -1, "org.fdroid.fdroid.views.repos.RepoPreviewScreenExistingRepoPreview (RepoPreviewScreen.kt:318)");
            }
            final Repository createSwapRepo = FDroidApp.createSwapRepo("https://example.org", "foo bar");
            ComposeUtils.INSTANCE.FDroidContent(ComposableLambdaKt.composableLambda(startRestartGroup, -971382238, true, new Function2() { // from class: org.fdroid.fdroid.views.repos.RepoPreviewScreenKt$RepoPreviewScreenExistingRepoPreview$1
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
                    List emptyList;
                    if ((i2 & 11) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-971382238, i2, -1, "org.fdroid.fdroid.views.repos.RepoPreviewScreenExistingRepoPreview.<anonymous> (RepoPreviewScreen.kt:322)");
                        }
                        PaddingValues m202PaddingValues0680j_4 = PaddingKt.m202PaddingValues0680j_4(Dp.m1897constructorimpl(0));
                        String str = r1;
                        Repository repository = createSwapRepo;
                        emptyList = CollectionsKt__CollectionsKt.emptyList();
                        RepoPreviewScreenKt.RepoPreviewScreen(m202PaddingValues0680j_4, new Fetching(str, repository, emptyList, new FetchResult.IsExistingRepository(0L), false, 16, null), new Function0() { // from class: org.fdroid.fdroid.views.repos.RepoPreviewScreenKt$RepoPreviewScreenExistingRepoPreview$1.1
                            /* renamed from: invoke  reason: collision with other method in class */
                            public final void m2647invoke() {
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Object invoke() {
                                m2647invoke();
                                return Unit.INSTANCE;
                            }
                        }, composer2, 454);
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
            endRestartGroup.updateScope(new Function2() { // from class: org.fdroid.fdroid.views.repos.RepoPreviewScreenKt$RepoPreviewScreenExistingRepoPreview$2
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
                    RepoPreviewScreenKt.RepoPreviewScreenExistingRepoPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final void RepoPreviewScreenExistingMirrorPreview(Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(1808330477);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1808330477, i, -1, "org.fdroid.fdroid.views.repos.RepoPreviewScreenExistingMirrorPreview (RepoPreviewScreen.kt:331)");
            }
            final Repository createSwapRepo = FDroidApp.createSwapRepo("https://example.org", "foo bar");
            ComposeUtils.INSTANCE.FDroidContent(ComposableLambdaKt.composableLambda(startRestartGroup, 1389441589, true, new Function2() { // from class: org.fdroid.fdroid.views.repos.RepoPreviewScreenKt$RepoPreviewScreenExistingMirrorPreview$1
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
                    List emptyList;
                    if ((i2 & 11) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1389441589, i2, -1, "org.fdroid.fdroid.views.repos.RepoPreviewScreenExistingMirrorPreview.<anonymous> (RepoPreviewScreen.kt:334)");
                        }
                        PaddingValues m202PaddingValues0680j_4 = PaddingKt.m202PaddingValues0680j_4(Dp.m1897constructorimpl(0));
                        Repository repository = Repository.this;
                        emptyList = CollectionsKt__CollectionsKt.emptyList();
                        RepoPreviewScreenKt.RepoPreviewScreen(m202PaddingValues0680j_4, new Fetching("https://mirror.example.org", repository, emptyList, new FetchResult.IsExistingMirror(0L), false, 16, null), new Function0() { // from class: org.fdroid.fdroid.views.repos.RepoPreviewScreenKt$RepoPreviewScreenExistingMirrorPreview$1.1
                            /* renamed from: invoke  reason: collision with other method in class */
                            public final void m2646invoke() {
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Object invoke() {
                                m2646invoke();
                                return Unit.INSTANCE;
                            }
                        }, composer2, 454);
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
            endRestartGroup.updateScope(new Function2() { // from class: org.fdroid.fdroid.views.repos.RepoPreviewScreenKt$RepoPreviewScreenExistingMirrorPreview$2
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
                    RepoPreviewScreenKt.RepoPreviewScreenExistingMirrorPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }
}
