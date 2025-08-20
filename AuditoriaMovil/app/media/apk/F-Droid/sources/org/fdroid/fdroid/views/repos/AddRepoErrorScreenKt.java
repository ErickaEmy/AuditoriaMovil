package org.fdroid.fdroid.views.repos;

import android.content.Context;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.ContentAlpha;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.TextKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.ErrorKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.InspectionModeKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.fdroid.fdroid.R;
import org.fdroid.fdroid.compose.ComposeUtils;
import org.fdroid.repo.AddRepoError;
/* compiled from: AddRepoErrorScreen.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u0003\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u0004\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u0005\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001a\u001d\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\u000b\u001a\r\u0010\f\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002¨\u0006\r"}, d2 = {"AddRepoErrorArchivePreview", "", "(Landroidx/compose/runtime/Composer;I)V", "AddRepoErrorInvalidFingerprintPreview", "AddRepoErrorInvalidIndexPreview", "AddRepoErrorIoErrorPreview", "AddRepoErrorScreen", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "state", "Lorg/fdroid/repo/AddRepoError;", "(Landroidx/compose/foundation/layout/PaddingValues;Lorg/fdroid/repo/AddRepoError;Landroidx/compose/runtime/Composer;I)V", "AddRepoErrorUnknownSourcesPreview", "app_fullRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AddRepoErrorScreenKt {

    /* compiled from: AddRepoErrorScreen.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AddRepoError.ErrorType.values().length];
            try {
                iArr[AddRepoError.ErrorType.INVALID_FINGERPRINT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AddRepoError.ErrorType.UNKNOWN_SOURCES_DISALLOWED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AddRepoError.ErrorType.INVALID_INDEX.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AddRepoError.ErrorType.IO_ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[AddRepoError.ErrorType.IS_ARCHIVE_REPO.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final void AddRepoErrorScreen(final PaddingValues paddingValues, final AddRepoError state, Composer composer, final int i) {
        String stringResource;
        Composer composer2;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Intrinsics.checkNotNullParameter(state, "state");
        Composer startRestartGroup = composer.startRestartGroup(734084327);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(734084327, i, -1, "org.fdroid.fdroid.views.repos.AddRepoErrorScreen (AddRepoErrorScreen.kt:38)");
        }
        Arrangement arrangement = Arrangement.INSTANCE;
        float f = 16;
        float m1897constructorimpl = Dp.m1897constructorimpl(f);
        Alignment.Companion companion = Alignment.Companion;
        Arrangement.Vertical m188spacedByD5KLDUw = arrangement.m188spacedByD5KLDUw(m1897constructorimpl, companion.getCenterVertically());
        Alignment.Horizontal centerHorizontally = companion.getCenterHorizontally();
        Modifier.Companion companion2 = Modifier.Companion;
        Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(PaddingKt.padding(PaddingKt.m207padding3ABfNKs(companion2, Dp.m1897constructorimpl(f)), paddingValues), 0.0f, 1, null);
        startRestartGroup.startReplaceableGroup(-483455358);
        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(m188spacedByD5KLDUw, centerHorizontally, startRestartGroup, 54);
        startRestartGroup.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
        ComposeUiNode.Companion companion3 = ComposeUiNode.Companion;
        Function0 constructor = companion3.getConstructor();
        Function3 modifierMaterializerOf = LayoutKt.modifierMaterializerOf(fillMaxSize$default);
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
        ImageVector error = ErrorKt.getError(Icons.INSTANCE.getDefault());
        ColorFilter.Companion companion4 = ColorFilter.Companion;
        MaterialTheme materialTheme = MaterialTheme.INSTANCE;
        int i2 = MaterialTheme.$stable;
        ImageKt.Image(error, (String) null, SizeKt.m231size3ABfNKs(companion2, Dp.m1897constructorimpl(48)), (Alignment) null, (ContentScale) null, 0.0f, ColorFilter.Companion.m866tintxETnrds$default(companion4, materialTheme.getColors(startRestartGroup, i2).m444getError0d7_KjU(), 0, 2, null), startRestartGroup, 432, 56);
        int i3 = WhenMappings.$EnumSwitchMapping$0[state.getErrorType().ordinal()];
        if (i3 == 1) {
            startRestartGroup.startReplaceableGroup(2037188729);
            stringResource = StringResources_androidKt.stringResource(R.string.bad_fingerprint, startRestartGroup, 0);
            startRestartGroup.endReplaceableGroup();
        } else if (i3 == 2) {
            startRestartGroup.startReplaceableGroup(2037188830);
            if (((Boolean) startRestartGroup.consume(InspectionModeKt.getLocalInspectionMode())).booleanValue()) {
                startRestartGroup.startReplaceableGroup(2037188885);
                stringResource = StringResources_androidKt.stringResource(R.string.has_disallow_install_unknown_sources, startRestartGroup, 0);
                startRestartGroup.endReplaceableGroup();
            } else {
                startRestartGroup.startReplaceableGroup(2037188992);
                stringResource = ManageReposActivity.getDisallowInstallUnknownSourcesErrorMessage((Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext()));
                startRestartGroup.endReplaceableGroup();
            }
            startRestartGroup.endReplaceableGroup();
        } else if (i3 == 3) {
            startRestartGroup.startReplaceableGroup(2037189121);
            stringResource = StringResources_androidKt.stringResource(R.string.repo_invalid, startRestartGroup, 0);
            startRestartGroup.endReplaceableGroup();
        } else if (i3 == 4) {
            startRestartGroup.startReplaceableGroup(2037189183);
            stringResource = StringResources_androidKt.stringResource(R.string.repo_io_error, startRestartGroup, 0);
            startRestartGroup.endReplaceableGroup();
        } else if (i3 != 5) {
            startRestartGroup.startReplaceableGroup(2037186312);
            startRestartGroup.endReplaceableGroup();
            throw new NoWhenBranchMatchedException();
        } else {
            startRestartGroup.startReplaceableGroup(2037189253);
            stringResource = StringResources_androidKt.stringResource(R.string.repo_error_adding_archive, startRestartGroup, 0);
            startRestartGroup.endReplaceableGroup();
        }
        String str = stringResource;
        TextStyle h5 = materialTheme.getTypography(startRestartGroup, i2).getH5();
        int m1824getCentere0LSkKk = TextAlign.Companion.m1824getCentere0LSkKk();
        Intrinsics.checkNotNull(str);
        TextKt.m581Text4IGK_g(str, null, 0L, 0L, null, null, null, 0L, null, TextAlign.m1817boximpl(m1824getCentere0LSkKk), 0L, 0, false, 0, 0, null, h5, startRestartGroup, 0, 0, 65022);
        startRestartGroup.startReplaceableGroup(454829366);
        if (state.getException() != null) {
            String valueOf = String.valueOf(state.getException());
            TextStyle body1 = materialTheme.getTypography(startRestartGroup, i2).getBody1();
            composer2 = startRestartGroup;
            TextKt.m581Text4IGK_g(valueOf, AlphaKt.alpha(companion2, ContentAlpha.INSTANCE.getMedium(startRestartGroup, ContentAlpha.$stable)), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, body1, composer2, 0, 0, 65532);
        } else {
            composer2 = startRestartGroup;
        }
        composer2.endReplaceableGroup();
        composer2.endReplaceableGroup();
        composer2.endNode();
        composer2.endReplaceableGroup();
        composer2.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: org.fdroid.fdroid.views.repos.AddRepoErrorScreenKt$AddRepoErrorScreen$2
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
                    AddRepoErrorScreenKt.AddRepoErrorScreen(PaddingValues.this, state, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final void AddRepoErrorInvalidFingerprintPreview(Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(1752043056);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1752043056, i, -1, "org.fdroid.fdroid.views.repos.AddRepoErrorInvalidFingerprintPreview (AddRepoErrorScreen.kt:82)");
            }
            ComposeUtils.INSTANCE.FDroidContent(ComposableSingletons$AddRepoErrorScreenKt.INSTANCE.m2613getLambda1$app_fullRelease(), startRestartGroup, 54);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: org.fdroid.fdroid.views.repos.AddRepoErrorScreenKt$AddRepoErrorInvalidFingerprintPreview$1
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
                    AddRepoErrorScreenKt.AddRepoErrorInvalidFingerprintPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final void AddRepoErrorIoErrorPreview(Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(961254175);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(961254175, i, -1, "org.fdroid.fdroid.views.repos.AddRepoErrorIoErrorPreview (AddRepoErrorScreen.kt:90)");
            }
            ComposeUtils.INSTANCE.FDroidContent(ComposableSingletons$AddRepoErrorScreenKt.INSTANCE.m2614getLambda2$app_fullRelease(), startRestartGroup, 54);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: org.fdroid.fdroid.views.repos.AddRepoErrorScreenKt$AddRepoErrorIoErrorPreview$1
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
                    AddRepoErrorScreenKt.AddRepoErrorIoErrorPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final void AddRepoErrorInvalidIndexPreview(Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(-1840611938);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1840611938, i, -1, "org.fdroid.fdroid.views.repos.AddRepoErrorInvalidIndexPreview (AddRepoErrorScreen.kt:98)");
            }
            ComposeUtils.INSTANCE.FDroidContent(ComposableSingletons$AddRepoErrorScreenKt.INSTANCE.m2615getLambda3$app_fullRelease(), startRestartGroup, 54);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: org.fdroid.fdroid.views.repos.AddRepoErrorScreenKt$AddRepoErrorInvalidIndexPreview$1
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
                    AddRepoErrorScreenKt.AddRepoErrorInvalidIndexPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final void AddRepoErrorUnknownSourcesPreview(Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(-1686221807);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1686221807, i, -1, "org.fdroid.fdroid.views.repos.AddRepoErrorUnknownSourcesPreview (AddRepoErrorScreen.kt:109)");
            }
            ComposeUtils.INSTANCE.FDroidContent(ComposableSingletons$AddRepoErrorScreenKt.INSTANCE.m2616getLambda4$app_fullRelease(), startRestartGroup, 54);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: org.fdroid.fdroid.views.repos.AddRepoErrorScreenKt$AddRepoErrorUnknownSourcesPreview$1
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
                    AddRepoErrorScreenKt.AddRepoErrorUnknownSourcesPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final void AddRepoErrorArchivePreview(Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(-744487073);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-744487073, i, -1, "org.fdroid.fdroid.views.repos.AddRepoErrorArchivePreview (AddRepoErrorScreen.kt:117)");
            }
            ComposeUtils.INSTANCE.FDroidContent(ComposableSingletons$AddRepoErrorScreenKt.INSTANCE.m2617getLambda5$app_fullRelease(), startRestartGroup, 54);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: org.fdroid.fdroid.views.repos.AddRepoErrorScreenKt$AddRepoErrorArchivePreview$1
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
                    AddRepoErrorScreenKt.AddRepoErrorArchivePreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }
}
