package org.fdroid.fdroid.views.appdetails;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.AndroidMenu_androidKt;
import androidx.compose.material.ContentAlphaKt;
import androidx.compose.material.ContentColorKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.OutlinedTextFieldKt;
import androidx.compose.material.TextFieldColors;
import androidx.compose.material.TextFieldDefaults;
import androidx.compose.material.TextKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.ArrowDropDownKt;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.res.ColorResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.unit.Dp;
import androidx.core.os.LocaleListCompat;
import androidx.core.util.Consumer;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.fdroid.database.Repository;
import org.fdroid.fdroid.R;
import org.fdroid.fdroid.compose.ComposeUtils;
import org.fdroid.fdroid.views.repos.RepoIconComposableKt;
import org.fdroid.index.IndexFormatVersion;
/* compiled from: RepoChooser.kt */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a]\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0007¢\u0006\u0002\u0010\r\u001a\r\u0010\u000e\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u000f\u001a\r\u0010\u0010\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u000f\u001a\r\u0010\u0011\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u000f\u001a'\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0003¢\u0006\u0002\u0010\u0016\u001a\u001d\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0015H\u0003¢\u0006\u0002\u0010\u0019\u001aH\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u001c2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u001d2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u001d¨\u0006\u001e²\u0006\n\u0010\u001f\u001a\u00020\u0015X\u008a\u008e\u0002"}, d2 = {"RepoChooser", "", "repos", "", "Lorg/fdroid/database/Repository;", "currentRepoId", "", "preferredRepoId", "onRepoChanged", "Lkotlin/Function1;", "onPreferredRepoChanged", "modifier", "Landroidx/compose/ui/Modifier;", "(Ljava/util/List;JJLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "RepoChooserNightPreview", "(Landroidx/compose/runtime/Composer;I)V", "RepoChooserPreview", "RepoChooserSingleRepoPreview", "RepoItem", "repo", "isPreferred", "", "(Lorg/fdroid/database/Repository;ZLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "getRepoString", "Landroidx/compose/ui/text/AnnotatedString;", "(Lorg/fdroid/database/Repository;ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/text/AnnotatedString;", "setContentRepoChooser", "composeView", "Landroidx/compose/ui/platform/ComposeView;", "Landroidx/core/util/Consumer;", "app_fullRelease", "expanded"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RepoChooserKt {
    public static final void setContentRepoChooser(ComposeView composeView, final List<Repository> repos, final long j, final long j2, final Consumer onRepoChanged, final Consumer onPreferredRepoChanged) {
        Intrinsics.checkNotNullParameter(composeView, "composeView");
        Intrinsics.checkNotNullParameter(repos, "repos");
        Intrinsics.checkNotNullParameter(onRepoChanged, "onRepoChanged");
        Intrinsics.checkNotNullParameter(onPreferredRepoChanged, "onPreferredRepoChanged");
        composeView.setContent(ComposableLambdaKt.composableLambdaInstance(-34211087, true, new Function2() { // from class: org.fdroid.fdroid.views.appdetails.RepoChooserKt$setContentRepoChooser$1
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

            public final void invoke(Composer composer, int i) {
                if ((i & 11) != 2 || !composer.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-34211087, i, -1, "org.fdroid.fdroid.views.appdetails.setContentRepoChooser.<anonymous> (RepoChooser.kt:61)");
                    }
                    ComposeUtils composeUtils = ComposeUtils.INSTANCE;
                    final List<Repository> list = repos;
                    final long j3 = j;
                    final long j4 = j2;
                    final Consumer consumer = onRepoChanged;
                    final Consumer consumer2 = onPreferredRepoChanged;
                    composeUtils.FDroidContent(ComposableLambdaKt.composableLambda(composer, -1825413063, true, new Function2() { // from class: org.fdroid.fdroid.views.appdetails.RepoChooserKt$setContentRepoChooser$1.1
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
                                    ComposerKt.traceEventStart(-1825413063, i2, -1, "org.fdroid.fdroid.views.appdetails.setContentRepoChooser.<anonymous>.<anonymous> (RepoChooser.kt:62)");
                                }
                                RepoChooserKt.RepoChooser(list, j3, j4, new C00391(consumer), new AnonymousClass2(consumer2), BackgroundKt.m77backgroundbw27NRU$default(Modifier.Companion, MaterialTheme.INSTANCE.getColors(composer2, MaterialTheme.$stable).m454getSurface0d7_KjU(), null, 2, null), composer2, 8, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* compiled from: RepoChooser.kt */
                        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                        /* renamed from: org.fdroid.fdroid.views.appdetails.RepoChooserKt$setContentRepoChooser$1$1$1  reason: invalid class name and collision with other inner class name */
                        /* loaded from: classes2.dex */
                        public /* synthetic */ class C00391 extends FunctionReferenceImpl implements Function1 {
                            C00391(Object obj) {
                                super(1, obj, Consumer.class, "accept", "accept(Ljava/lang/Object;)V", 0);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((Repository) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Repository repository) {
                                ((Consumer) this.receiver).accept(repository);
                            }
                        }

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* compiled from: RepoChooser.kt */
                        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                        /* renamed from: org.fdroid.fdroid.views.appdetails.RepoChooserKt$setContentRepoChooser$1$1$2  reason: invalid class name */
                        /* loaded from: classes2.dex */
                        public /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1 {
                            AnonymousClass2(Object obj) {
                                super(1, obj, Consumer.class, "accept", "accept(Ljava/lang/Object;)V", 0);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((Long) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Long l) {
                                ((Consumer) this.receiver).accept(l);
                            }
                        }
                    }), composer, 54);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer.skipToGroupEnd();
            }
        }));
    }

    private static final boolean RepoChooser$lambda$1(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    public static final void RepoChooser(final List<Repository> repos, final long j, final long j2, final Function1 onRepoChanged, final Function1 onPreferredRepoChanged, Modifier modifier, Composer composer, final int i, final int i2) {
        Object obj;
        long m849copywmQWz5c$default;
        Modifier modifier2;
        Intrinsics.checkNotNullParameter(repos, "repos");
        Intrinsics.checkNotNullParameter(onRepoChanged, "onRepoChanged");
        Intrinsics.checkNotNullParameter(onPreferredRepoChanged, "onPreferredRepoChanged");
        Composer startRestartGroup = composer.startRestartGroup(-851753508);
        Modifier.Companion companion = (i2 & 32) != 0 ? Modifier.Companion : modifier;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-851753508, i, -1, "org.fdroid.fdroid.views.appdetails.RepoChooser (RepoChooser.kt:82)");
        }
        if (repos.isEmpty()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
                final Modifier modifier3 = companion;
                endRestartGroup.updateScope(new Function2() { // from class: org.fdroid.fdroid.views.appdetails.RepoChooserKt$RepoChooser$1
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

                    public final void invoke(Composer composer2, int i3) {
                        RepoChooserKt.RepoChooser(repos, j, j2, onRepoChanged, onPreferredRepoChanged, modifier3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        startRestartGroup.startReplaceableGroup(247577543);
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        final MutableState mutableState = (MutableState) rememberedValue;
        startRestartGroup.endReplaceableGroup();
        Iterator<T> it = repos.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((Repository) obj).getRepoId() == j) {
                break;
            }
        }
        final Repository repository = (Repository) obj;
        if (repository == null) {
            throw new IllegalStateException("Current repoId not in list".toString());
        }
        final boolean z = repository.getRepoId() == j2;
        Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
        startRestartGroup.startReplaceableGroup(-483455358);
        Arrangement.Vertical top = Arrangement.INSTANCE.getTop();
        Alignment.Companion companion2 = Alignment.Companion;
        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion2.getStart(), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
        ComposeUiNode.Companion companion3 = ComposeUiNode.Companion;
        Function0 constructor = companion3.getConstructor();
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
        startRestartGroup.startReplaceableGroup(733328855);
        Modifier.Companion companion4 = Modifier.Companion;
        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(companion2.getTopStart(), false, startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
        Function0 constructor2 = companion3.getConstructor();
        Function3 modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(companion4);
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
        Updater.m625setimpl(m624constructorimpl2, rememberBoxMeasurePolicy, companion3.getSetMeasurePolicy());
        Updater.m625setimpl(m624constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
        Function2 setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
        if (m624constructorimpl2.getInserting() || !Intrinsics.areEqual(m624constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
            m624constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
            m624constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
        }
        modifierMaterializerOf2.invoke(SkippableUpdater.m617boximpl(SkippableUpdater.m618constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        if (z) {
            startRestartGroup.startReplaceableGroup(162228710);
            m849copywmQWz5c$default = ColorResources_androidKt.colorResource(R.color.fdroid_blue, startRestartGroup, 0);
            startRestartGroup.endReplaceableGroup();
        } else {
            startRestartGroup.startReplaceableGroup(162228813);
            m849copywmQWz5c$default = Color.m849copywmQWz5c$default(((Color) startRestartGroup.consume(ContentColorKt.getLocalContentColor())).m859unboximpl(), ((Number) startRestartGroup.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
            startRestartGroup.endReplaceableGroup();
        }
        long j3 = m849copywmQWz5c$default;
        TextFieldValue textFieldValue = new TextFieldValue(getRepoString(repository, repos.size() > 1 && z, startRestartGroup, 8), 0L, (TextRange) null, 6, (DefaultConstructorMarker) null);
        MaterialTheme materialTheme = MaterialTheme.INSTANCE;
        int i3 = MaterialTheme.$stable;
        TextStyle body2 = materialTheme.getTypography(startRestartGroup, i3).getBody2();
        final Modifier modifier4 = companion;
        TextFieldColors m565outlinedTextFieldColorsdx8h9Zs = TextFieldDefaults.INSTANCE.m565outlinedTextFieldColorsdx8h9Zs(0L, Color.m849copywmQWz5c$default(((Color) startRestartGroup.consume(ContentColorKt.getLocalContentColor())).m859unboximpl(), ((Number) startRestartGroup.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue(), 0.0f, 0.0f, 0.0f, 14, null), 0L, 0L, 0L, 0L, 0L, j3, 0L, 0L, materialTheme.getColors(startRestartGroup, i3).m449getOnSurface0d7_KjU(), 0L, 0L, 0L, 0L, 0L, 0L, j3, 0L, 0L, 0L, startRestartGroup, 0, 0, 48, 1964925);
        startRestartGroup.startReplaceableGroup(162230816);
        Modifier fillMaxWidth$default2 = SizeKt.fillMaxWidth$default(companion4, 0.0f, 1, null);
        startRestartGroup.startReplaceableGroup(162230846);
        if (repos.size() > 1) {
            startRestartGroup.startReplaceableGroup(638290570);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: org.fdroid.fdroid.views.appdetails.RepoChooserKt$RepoChooser$2$1$1$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m2574invoke();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: collision with other method in class */
                    public final void m2574invoke() {
                        RepoChooserKt.RepoChooser$lambda$2(MutableState.this, true);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceableGroup();
            modifier2 = ClickableKt.m95clickableXHw0xAI$default(fillMaxWidth$default2, false, null, null, (Function0) rememberedValue2, 7, null);
        } else {
            modifier2 = fillMaxWidth$default2;
        }
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        OutlinedTextFieldKt.OutlinedTextField(textFieldValue, new Function1() { // from class: org.fdroid.fdroid.views.appdetails.RepoChooserKt$RepoChooser$2$1$2
            public final void invoke(TextFieldValue it2) {
                Intrinsics.checkNotNullParameter(it2, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                invoke((TextFieldValue) obj2);
                return Unit.INSTANCE;
            }
        }, modifier2, false, false, body2, ComposableLambdaKt.composableLambda(startRestartGroup, 314970994, true, new Function2() { // from class: org.fdroid.fdroid.views.appdetails.RepoChooserKt$RepoChooser$2$1$3
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

            public final void invoke(Composer composer2, int i4) {
                if ((i4 & 11) != 2 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(314970994, i4, -1, "org.fdroid.fdroid.views.appdetails.RepoChooser.<anonymous>.<anonymous>.<anonymous> (RepoChooser.kt:107)");
                    }
                    if (repos.size() == 1) {
                        composer2.startReplaceableGroup(638289016);
                        TextKt.m581Text4IGK_g(StringResources_androidKt.stringResource(R.string.app_details_repository, composer2, 0), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, 0, 0, 131070);
                        composer2.endReplaceableGroup();
                    } else {
                        composer2.startReplaceableGroup(638289123);
                        TextKt.m581Text4IGK_g(StringResources_androidKt.stringResource(R.string.app_details_repositories, composer2, 0), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, 0, 0, 131070);
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
        }), null, ComposableLambdaKt.composableLambda(startRestartGroup, -1620950864, true, new Function2() { // from class: org.fdroid.fdroid.views.appdetails.RepoChooserKt$RepoChooser$2$1$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                invoke((Composer) obj2, ((Number) obj3).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i4) {
                if ((i4 & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1620950864, i4, -1, "org.fdroid.fdroid.views.appdetails.RepoChooser.<anonymous>.<anonymous>.<anonymous> (RepoChooser.kt:114)");
                }
                RepoIconComposableKt.RepoIcon(Repository.this, SizeKt.m231size3ABfNKs(Modifier.Companion, Dp.m1897constructorimpl(24)), composer2, 56, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), ComposableLambdaKt.composableLambda(startRestartGroup, 1706055503, true, new Function2() { // from class: org.fdroid.fdroid.views.appdetails.RepoChooserKt$RepoChooser$2$1$5
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

            public final void invoke(Composer composer2, int i4) {
                long m849copywmQWz5c$default2;
                if ((i4 & 11) != 2 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1706055503, i4, -1, "org.fdroid.fdroid.views.appdetails.RepoChooser.<anonymous>.<anonymous>.<anonymous> (RepoChooser.kt:117)");
                    }
                    if (repos.size() > 1) {
                        ImageVector arrowDropDown = ArrowDropDownKt.getArrowDropDown(Icons.INSTANCE.getDefault());
                        String stringResource = StringResources_androidKt.stringResource(R.string.app_details_repository_expand, composer2, 0);
                        if (z) {
                            composer2.startReplaceableGroup(638289678);
                            m849copywmQWz5c$default2 = ColorResources_androidKt.colorResource(R.color.fdroid_blue, composer2, 0);
                            composer2.endReplaceableGroup();
                        } else {
                            composer2.startReplaceableGroup(638289805);
                            m849copywmQWz5c$default2 = Color.m849copywmQWz5c$default(((Color) composer2.consume(ContentColorKt.getLocalContentColor())).m859unboximpl(), ((Number) composer2.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                            composer2.endReplaceableGroup();
                        }
                        IconKt.m503Iconww6aTOc(arrowDropDown, stringResource, (Modifier) null, m849copywmQWz5c$default2, composer2, 0, 4);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer2.skipToGroupEnd();
            }
        }), false, null, null, null, false, 0, 0, null, null, m565outlinedTextFieldColorsdx8h9Zs, startRestartGroup, 907545648, 24576, 507024);
        boolean RepoChooser$lambda$1 = RepoChooser$lambda$1(mutableState);
        startRestartGroup.startReplaceableGroup(162231053);
        Object rememberedValue3 = startRestartGroup.rememberedValue();
        if (rememberedValue3 == Composer.Companion.getEmpty()) {
            rememberedValue3 = new Function0() { // from class: org.fdroid.fdroid.views.appdetails.RepoChooserKt$RepoChooser$2$1$6$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m2575invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: collision with other method in class */
                public final void m2575invoke() {
                    RepoChooserKt.RepoChooser$lambda$2(MutableState.this, false);
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue3);
        }
        startRestartGroup.endReplaceableGroup();
        boolean z2 = z;
        AndroidMenu_androidKt.m427DropdownMenu4kj_NE(RepoChooser$lambda$1, (Function0) rememberedValue3, null, 0L, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1824529461, true, new Function3() { // from class: org.fdroid.fdroid.views.appdetails.RepoChooserKt$RepoChooser$2$1$7
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3, Object obj4) {
                invoke((ColumnScope) obj2, (Composer) obj3, ((Number) obj4).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(ColumnScope DropdownMenu, Composer composer2, int i4) {
                Intrinsics.checkNotNullParameter(DropdownMenu, "$this$DropdownMenu");
                if ((i4 & 81) != 16 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1824529461, i4, -1, "org.fdroid.fdroid.views.appdetails.RepoChooser.<anonymous>.<anonymous>.<anonymous> (RepoChooser.kt:146)");
                    }
                    final Function1 function1 = onRepoChanged;
                    final MutableState mutableState2 = mutableState;
                    final long j4 = j2;
                    for (final Repository repository2 : repos) {
                        AndroidMenu_androidKt.DropdownMenuItem(new Function0() { // from class: org.fdroid.fdroid.views.appdetails.RepoChooserKt$RepoChooser$2$1$7$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Object invoke() {
                                m2576invoke();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke  reason: collision with other method in class */
                            public final void m2576invoke() {
                                Function1.this.invoke(repository2);
                                RepoChooserKt.RepoChooser$lambda$2(mutableState2, false);
                            }
                        }, null, false, null, null, ComposableLambdaKt.composableLambda(composer2, -133859337, true, new Function3() { // from class: org.fdroid.fdroid.views.appdetails.RepoChooserKt$RepoChooser$2$1$7$1$2
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3, Object obj4) {
                                invoke((RowScope) obj2, (Composer) obj3, ((Number) obj4).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(RowScope DropdownMenuItem, Composer composer3, int i5) {
                                Intrinsics.checkNotNullParameter(DropdownMenuItem, "$this$DropdownMenuItem");
                                if ((i5 & 81) == 16 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-133859337, i5, -1, "org.fdroid.fdroid.views.appdetails.RepoChooser.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (RepoChooser.kt:151)");
                                }
                                Repository repository3 = Repository.this;
                                RepoChooserKt.RepoItem(repository3, repository3.getRepoId() == j4, null, composer3, 8, 4);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), composer2, 196608, 30);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer2.skipToGroupEnd();
            }
        }), startRestartGroup, 1572912, 60);
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(247580626);
        if (!z2) {
            ComposeUtils.INSTANCE.FDroidOutlineButton(StringResources_androidKt.stringResource(R.string.app_details_repository_button_prefer, startRestartGroup, 0), new Function0() { // from class: org.fdroid.fdroid.views.appdetails.RepoChooserKt$RepoChooser$2$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m2577invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: collision with other method in class */
                public final void m2577invoke() {
                    Function1.this.invoke(Long.valueOf(repository.getRepoId()));
                }
            }, PaddingKt.m211paddingqDBjuR0$default(columnScopeInstance.align(companion4, companion2.getEnd()), 0.0f, Dp.m1897constructorimpl(8), 0.0f, 0.0f, 13, null), null, startRestartGroup, 24576, 8);
        }
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup2 = startRestartGroup.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.updateScope(new Function2() { // from class: org.fdroid.fdroid.views.appdetails.RepoChooserKt$RepoChooser$3
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

                public final void invoke(Composer composer2, int i4) {
                    RepoChooserKt.RepoChooser(repos, j, j2, onRepoChanged, onPreferredRepoChanged, modifier4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void RepoChooser$lambda$2(MutableState mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void RepoItem(final Repository repository, final boolean z, Modifier modifier, Composer composer, final int i, final int i2) {
        Composer startRestartGroup = composer.startRestartGroup(885980742);
        final Modifier modifier2 = (i2 & 4) != 0 ? Modifier.Companion : modifier;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(885980742, i, -1, "org.fdroid.fdroid.views.appdetails.RepoItem (RepoChooser.kt:167)");
        }
        Arrangement.HorizontalOrVertical m187spacedBy0680j_4 = Arrangement.INSTANCE.m187spacedBy0680j_4(Dp.m1897constructorimpl(8));
        Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
        int i3 = ((i >> 6) & 14) | 432;
        startRestartGroup.startReplaceableGroup(693286680);
        int i4 = i3 >> 3;
        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m187spacedBy0680j_4, centerVertically, startRestartGroup, (i4 & 112) | (i4 & 14));
        startRestartGroup.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
        ComposeUiNode.Companion companion = ComposeUiNode.Companion;
        Function0 constructor = companion.getConstructor();
        Function3 modifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier2);
        int i5 = ((((i3 << 3) & 112) << 9) & 7168) | 6;
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
        Updater.m625setimpl(m624constructorimpl, rowMeasurePolicy, companion.getSetMeasurePolicy());
        Updater.m625setimpl(m624constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
        Function2 setCompositeKeyHash = companion.getSetCompositeKeyHash();
        if (m624constructorimpl.getInserting() || !Intrinsics.areEqual(m624constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            m624constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m624constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        modifierMaterializerOf.invoke(SkippableUpdater.m617boximpl(SkippableUpdater.m618constructorimpl(startRestartGroup)), startRestartGroup, Integer.valueOf((i5 >> 3) & 112));
        startRestartGroup.startReplaceableGroup(2058660585);
        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
        RepoIconComposableKt.RepoIcon(repository, SizeKt.m231size3ABfNKs(Modifier.Companion, Dp.m1897constructorimpl(24)), startRestartGroup, 56, 0);
        TextKt.m582TextIbK3jfQ(getRepoString(repository, z, startRestartGroup, (i & 112) | 8), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, MaterialTheme.$stable).getBody2(), startRestartGroup, 0, 0, 131070);
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: org.fdroid.fdroid.views.appdetails.RepoChooserKt$RepoItem$2
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

                public final void invoke(Composer composer2, int i6) {
                    RepoChooserKt.RepoItem(Repository.this, z, modifier2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    private static final AnnotatedString getRepoString(Repository repository, boolean z, Composer composer, int i) {
        composer.startReplaceableGroup(-2007149080);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2007149080, i, -1, "org.fdroid.fdroid.views.appdetails.getRepoString (RepoChooser.kt:182)");
        }
        AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, null);
        LocaleListCompat localeListCompat = LocaleListCompat.getDefault();
        Intrinsics.checkNotNullExpressionValue(localeListCompat, "getDefault(...)");
        String name = repository.getName(localeListCompat);
        if (name == null) {
            name = "Unknown Repository";
        }
        builder.append(name);
        composer.startReplaceableGroup(2051140580);
        if (z) {
            builder.append(" ");
            builder.pushStyle(new SpanStyle(0L, 0L, FontWeight.Companion.getBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, null, 65531, null));
            builder.append(" ");
            builder.append(StringResources_androidKt.stringResource(R.string.app_details_repository_preferred, composer, 0));
        }
        composer.endReplaceableGroup();
        AnnotatedString annotatedString = builder.toAnnotatedString();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return annotatedString;
    }

    public static final void RepoChooserSingleRepoPreview(Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(1842411059);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1842411059, i, -1, "org.fdroid.fdroid.views.appdetails.RepoChooserSingleRepoPreview (RepoChooser.kt:194)");
            }
            final Repository repository = new Repository(1L, "1", 1L, IndexFormatVersion.TWO, "null", 1L, 1, 1L, null, null, 768, null);
            ComposeUtils.INSTANCE.FDroidContent(ComposableLambdaKt.composableLambda(startRestartGroup, 1213329387, true, new Function2() { // from class: org.fdroid.fdroid.views.appdetails.RepoChooserKt$RepoChooserSingleRepoPreview$1
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
                    List listOf;
                    if ((i2 & 11) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1213329387, i2, -1, "org.fdroid.fdroid.views.appdetails.RepoChooserSingleRepoPreview.<anonymous> (RepoChooser.kt:197)");
                    }
                    listOf = CollectionsKt__CollectionsJVMKt.listOf(Repository.this);
                    RepoChooserKt.RepoChooser(listOf, 1L, 1L, new Function1() { // from class: org.fdroid.fdroid.views.appdetails.RepoChooserKt$RepoChooserSingleRepoPreview$1.1
                        public final void invoke(Repository it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((Repository) obj);
                            return Unit.INSTANCE;
                        }
                    }, new Function1() { // from class: org.fdroid.fdroid.views.appdetails.RepoChooserKt$RepoChooserSingleRepoPreview$1.2
                        public final void invoke(long j) {
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke(((Number) obj).longValue());
                            return Unit.INSTANCE;
                        }
                    }, null, composer2, 28088, 32);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
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
            endRestartGroup.updateScope(new Function2() { // from class: org.fdroid.fdroid.views.appdetails.RepoChooserKt$RepoChooserSingleRepoPreview$2
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
                    RepoChooserKt.RepoChooserSingleRepoPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final void RepoChooserPreview(Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(-1041903111);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1041903111, i, -1, "org.fdroid.fdroid.views.appdetails.RepoChooserPreview (RepoChooser.kt:203)");
            }
            IndexFormatVersion indexFormatVersion = IndexFormatVersion.TWO;
            final Repository repository = new Repository(1L, "1", 1L, indexFormatVersion, "null", 1L, 1, 1L, null, null, 768, null);
            final Repository repository2 = new Repository(2L, "2", 2L, indexFormatVersion, "null", 2L, 2, 2L, null, null, 768, null);
            final Repository repository3 = new Repository(3L, "2", 3L, indexFormatVersion, "null", 3L, 3, 3L, null, null, 768, null);
            ComposeUtils.INSTANCE.FDroidContent(ComposableLambdaKt.composableLambda(startRestartGroup, 264835505, true, new Function2() { // from class: org.fdroid.fdroid.views.appdetails.RepoChooserKt$RepoChooserPreview$1
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
                    if ((i2 & 11) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(264835505, i2, -1, "org.fdroid.fdroid.views.appdetails.RepoChooserPreview.<anonymous> (RepoChooser.kt:208)");
                    }
                    listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Repository[]{Repository.this, repository2, repository3});
                    RepoChooserKt.RepoChooser(listOf, 1L, 1L, new Function1() { // from class: org.fdroid.fdroid.views.appdetails.RepoChooserKt$RepoChooserPreview$1.1
                        public final void invoke(Repository it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((Repository) obj);
                            return Unit.INSTANCE;
                        }
                    }, new Function1() { // from class: org.fdroid.fdroid.views.appdetails.RepoChooserKt$RepoChooserPreview$1.2
                        public final void invoke(long j) {
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke(((Number) obj).longValue());
                            return Unit.INSTANCE;
                        }
                    }, null, composer2, 28088, 32);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
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
            endRestartGroup.updateScope(new Function2() { // from class: org.fdroid.fdroid.views.appdetails.RepoChooserKt$RepoChooserPreview$2
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
                    RepoChooserKt.RepoChooserPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final void RepoChooserNightPreview(Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(560426203);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(560426203, i, -1, "org.fdroid.fdroid.views.appdetails.RepoChooserNightPreview (RepoChooser.kt:214)");
            }
            IndexFormatVersion indexFormatVersion = IndexFormatVersion.TWO;
            final Repository repository = new Repository(1L, "1", 1L, indexFormatVersion, "null", 1L, 1, 1L, null, null, 768, null);
            final Repository repository2 = new Repository(2L, "2", 2L, indexFormatVersion, "null", 2L, 2, 2L, null, null, 768, null);
            final Repository repository3 = new Repository(3L, "2", 3L, indexFormatVersion, "null", 3L, 3, 3L, null, null, 768, null);
            ComposeUtils.INSTANCE.FDroidContent(ComposableLambdaKt.composableLambda(startRestartGroup, -995147741, true, new Function2() { // from class: org.fdroid.fdroid.views.appdetails.RepoChooserKt$RepoChooserNightPreview$1
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
                    if ((i2 & 11) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-995147741, i2, -1, "org.fdroid.fdroid.views.appdetails.RepoChooserNightPreview.<anonymous> (RepoChooser.kt:219)");
                    }
                    listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Repository[]{Repository.this, repository2, repository3});
                    RepoChooserKt.RepoChooser(listOf, 1L, 2L, new Function1() { // from class: org.fdroid.fdroid.views.appdetails.RepoChooserKt$RepoChooserNightPreview$1.1
                        public final void invoke(Repository it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((Repository) obj);
                            return Unit.INSTANCE;
                        }
                    }, new Function1() { // from class: org.fdroid.fdroid.views.appdetails.RepoChooserKt$RepoChooserNightPreview$1.2
                        public final void invoke(long j) {
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke(((Number) obj).longValue());
                            return Unit.INSTANCE;
                        }
                    }, null, composer2, 28088, 32);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
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
            endRestartGroup.updateScope(new Function2() { // from class: org.fdroid.fdroid.views.appdetails.RepoChooserKt$RepoChooserNightPreview$2
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
                    RepoChooserKt.RepoChooserNightPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }
}
