package androidx.compose.foundation.lazy;

import androidx.compose.foundation.CheckScrollableContainerConstraintsKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsStateKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffsetKt;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: LazyList.kt */
/* loaded from: classes.dex */
public abstract class LazyListKt {
    /* JADX WARN: Removed duplicated region for block: B:106:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x02f5  */
    /* JADX WARN: Removed duplicated region for block: B:175:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0138  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void LazyList(final androidx.compose.ui.Modifier r32, final androidx.compose.foundation.lazy.LazyListState r33, final androidx.compose.foundation.layout.PaddingValues r34, final boolean r35, final boolean r36, final androidx.compose.foundation.gestures.FlingBehavior r37, final boolean r38, int r39, androidx.compose.ui.Alignment.Horizontal r40, androidx.compose.foundation.layout.Arrangement.Vertical r41, androidx.compose.ui.Alignment.Vertical r42, androidx.compose.foundation.layout.Arrangement.Horizontal r43, final kotlin.jvm.functions.Function1 r44, androidx.compose.runtime.Composer r45, final int r46, final int r47, final int r48) {
        /*
            Method dump skipped, instructions count: 799
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyListKt.LazyList(androidx.compose.ui.Modifier, androidx.compose.foundation.lazy.LazyListState, androidx.compose.foundation.layout.PaddingValues, boolean, boolean, androidx.compose.foundation.gestures.FlingBehavior, boolean, int, androidx.compose.ui.Alignment$Horizontal, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.ui.Alignment$Vertical, androidx.compose.foundation.layout.Arrangement$Horizontal, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ScrollPositionUpdater(final Function0 function0, final LazyListState lazyListState, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-331135862);
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changed(lazyListState) ? 32 : 16;
        }
        if ((i2 & 91) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-331135862, i, -1, "androidx.compose.foundation.lazy.ScrollPositionUpdater (LazyList.kt:140)");
            }
            LazyListItemProvider lazyListItemProvider = (LazyListItemProvider) function0.invoke();
            if (lazyListItemProvider.getItemCount() > 0) {
                LazyListState.updateScrollPositionIfTheFirstItemWasMoved$foundation_release$default(lazyListState, lazyListItemProvider, 0, 2, null);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.lazy.LazyListKt$ScrollPositionUpdater$1
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

            public final void invoke(Composer composer2, int i3) {
                LazyListKt.ScrollPositionUpdater(Function0.this, lazyListState, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    private static final Function2 rememberLazyListMeasurePolicy(final Function0 function0, final LazyListState lazyListState, final PaddingValues paddingValues, final boolean z, final boolean z2, final int i, Alignment.Horizontal horizontal, Alignment.Vertical vertical, Arrangement.Horizontal horizontal2, Arrangement.Vertical vertical2, Composer composer, int i2, int i3) {
        composer.startReplaceableGroup(183156450);
        final Alignment.Horizontal horizontal3 = (i3 & 64) != 0 ? null : horizontal;
        final Alignment.Vertical vertical3 = (i3 & 128) != 0 ? null : vertical;
        final Arrangement.Horizontal horizontal4 = (i3 & 256) != 0 ? null : horizontal2;
        final Arrangement.Vertical vertical4 = (i3 & 512) != 0 ? null : vertical2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(183156450, i2, -1, "androidx.compose.foundation.lazy.rememberLazyListMeasurePolicy (LazyList.kt:152)");
        }
        Object[] objArr = {lazyListState, paddingValues, Boolean.valueOf(z), Boolean.valueOf(z2), horizontal3, vertical3, horizontal4, vertical4};
        composer.startReplaceableGroup(-568225417);
        boolean z3 = false;
        for (int i4 = 0; i4 < 8; i4++) {
            z3 |= composer.changed(objArr[i4]);
        }
        Object rememberedValue = composer.rememberedValue();
        if (z3 || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new Function2() { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    return m246invoke0kLqBqw((LazyLayoutMeasureScope) obj, ((Constraints) obj2).m1877unboximpl());
                }

                /* renamed from: invoke-0kLqBqw  reason: not valid java name */
                public final LazyListMeasureResult m246invoke0kLqBqw(final LazyLayoutMeasureScope lazyLayoutMeasureScope, final long j) {
                    int mo150roundToPx0680j_4;
                    int mo150roundToPx0680j_42;
                    float mo189getSpacingD9Ej5fM;
                    int m1872getMaxWidthimpl;
                    long IntOffset;
                    Intrinsics.checkNotNullParameter(lazyLayoutMeasureScope, "$this$null");
                    CheckScrollableContainerConstraintsKt.m90checkScrollableContainerConstraintsK40F9xA(j, z2 ? Orientation.Vertical : Orientation.Horizontal);
                    if (z2) {
                        mo150roundToPx0680j_4 = lazyLayoutMeasureScope.mo150roundToPx0680j_4(paddingValues.mo219calculateLeftPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
                    } else {
                        mo150roundToPx0680j_4 = lazyLayoutMeasureScope.mo150roundToPx0680j_4(PaddingKt.calculateStartPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                    }
                    if (z2) {
                        mo150roundToPx0680j_42 = lazyLayoutMeasureScope.mo150roundToPx0680j_4(paddingValues.mo220calculateRightPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
                    } else {
                        mo150roundToPx0680j_42 = lazyLayoutMeasureScope.mo150roundToPx0680j_4(PaddingKt.calculateEndPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                    }
                    int mo150roundToPx0680j_43 = lazyLayoutMeasureScope.mo150roundToPx0680j_4(paddingValues.mo221calculateTopPaddingD9Ej5fM());
                    int mo150roundToPx0680j_44 = lazyLayoutMeasureScope.mo150roundToPx0680j_4(paddingValues.mo218calculateBottomPaddingD9Ej5fM());
                    final int i5 = mo150roundToPx0680j_43 + mo150roundToPx0680j_44;
                    final int i6 = mo150roundToPx0680j_4 + mo150roundToPx0680j_42;
                    boolean z4 = z2;
                    int i7 = z4 ? i5 : i6;
                    int i8 = (!z4 || z) ? (z4 && z) ? mo150roundToPx0680j_44 : (z4 || z) ? mo150roundToPx0680j_42 : mo150roundToPx0680j_4 : mo150roundToPx0680j_43;
                    final int i9 = i7 - i8;
                    final long m1885offsetNN6EwU = ConstraintsKt.m1885offsetNN6EwU(j, -i6, -i5);
                    lazyListState.setDensity$foundation_release(lazyLayoutMeasureScope);
                    final LazyListItemProvider lazyListItemProvider = (LazyListItemProvider) function0.invoke();
                    lazyListItemProvider.getItemScope().setMaxSize(Constraints.m1872getMaxWidthimpl(m1885offsetNN6EwU), Constraints.m1871getMaxHeightimpl(m1885offsetNN6EwU));
                    if (z2) {
                        Arrangement.Vertical vertical5 = vertical4;
                        if (vertical5 == null) {
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                        mo189getSpacingD9Ej5fM = vertical5.mo189getSpacingD9Ej5fM();
                    } else {
                        Arrangement.Horizontal horizontal5 = horizontal4;
                        if (horizontal5 != null) {
                            mo189getSpacingD9Ej5fM = horizontal5.mo189getSpacingD9Ej5fM();
                        } else {
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                    }
                    final int mo150roundToPx0680j_45 = lazyLayoutMeasureScope.mo150roundToPx0680j_4(mo189getSpacingD9Ej5fM);
                    final int itemCount = lazyListItemProvider.getItemCount();
                    if (z2) {
                        m1872getMaxWidthimpl = Constraints.m1871getMaxHeightimpl(j) - i5;
                    } else {
                        m1872getMaxWidthimpl = Constraints.m1872getMaxWidthimpl(j) - i6;
                    }
                    int i10 = m1872getMaxWidthimpl;
                    if (!z || i10 > 0) {
                        IntOffset = IntOffsetKt.IntOffset(mo150roundToPx0680j_4, mo150roundToPx0680j_43);
                    } else {
                        boolean z5 = z2;
                        if (!z5) {
                            mo150roundToPx0680j_4 += i10;
                        }
                        if (z5) {
                            mo150roundToPx0680j_43 += i10;
                        }
                        IntOffset = IntOffsetKt.IntOffset(mo150roundToPx0680j_4, mo150roundToPx0680j_43);
                    }
                    final long j2 = IntOffset;
                    final boolean z6 = z2;
                    final Alignment.Horizontal horizontal6 = horizontal3;
                    final Alignment.Vertical vertical6 = vertical3;
                    final boolean z7 = z;
                    final int i11 = i8;
                    LazyListMeasuredItemProvider lazyListMeasuredItemProvider = new LazyListMeasuredItemProvider(m1885offsetNN6EwU, z6, lazyListItemProvider, lazyLayoutMeasureScope, itemCount, mo150roundToPx0680j_45, horizontal6, vertical6, z7, i11, i9, j2) { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1
                        final /* synthetic */ int $afterContentPadding;
                        final /* synthetic */ int $beforeContentPadding;
                        final /* synthetic */ Alignment.Horizontal $horizontalAlignment;
                        final /* synthetic */ boolean $isVertical;
                        final /* synthetic */ int $itemsCount;
                        final /* synthetic */ boolean $reverseLayout;
                        final /* synthetic */ int $spaceBetweenItems;
                        final /* synthetic */ LazyLayoutMeasureScope $this_null;
                        final /* synthetic */ Alignment.Vertical $verticalAlignment;
                        final /* synthetic */ long $visualItemOffset;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.$isVertical = z6;
                            this.$this_null = lazyLayoutMeasureScope;
                            this.$itemsCount = itemCount;
                            this.$spaceBetweenItems = mo150roundToPx0680j_45;
                            this.$horizontalAlignment = horizontal6;
                            this.$verticalAlignment = vertical6;
                            this.$reverseLayout = z7;
                            this.$beforeContentPadding = i11;
                            this.$afterContentPadding = i9;
                            this.$visualItemOffset = j2;
                        }

                        @Override // androidx.compose.foundation.lazy.LazyListMeasuredItemProvider
                        public LazyListMeasuredItem createItem(int i12, Object key, Object obj, List placeables) {
                            Intrinsics.checkNotNullParameter(key, "key");
                            Intrinsics.checkNotNullParameter(placeables, "placeables");
                            return new LazyListMeasuredItem(i12, placeables, this.$isVertical, this.$horizontalAlignment, this.$verticalAlignment, this.$this_null.getLayoutDirection(), this.$reverseLayout, this.$beforeContentPadding, this.$afterContentPadding, i12 == this.$itemsCount + (-1) ? 0 : this.$spaceBetweenItems, this.$visualItemOffset, key, obj, null);
                        }
                    };
                    lazyListState.m251setPremeasureConstraintsBRTryo0$foundation_release(lazyListMeasuredItemProvider.m250getChildConstraintsmsEJaDk());
                    Snapshot.Companion companion = Snapshot.Companion;
                    LazyListState lazyListState2 = lazyListState;
                    Snapshot createNonObservableSnapshot = companion.createNonObservableSnapshot();
                    try {
                        Snapshot makeCurrent = createNonObservableSnapshot.makeCurrent();
                        int updateScrollPositionIfTheFirstItemWasMoved$foundation_release = lazyListState2.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(lazyListItemProvider, lazyListState2.getFirstVisibleItemIndex());
                        int firstVisibleItemScrollOffset = lazyListState2.getFirstVisibleItemScrollOffset();
                        Unit unit = Unit.INSTANCE;
                        createNonObservableSnapshot.restoreCurrent(makeCurrent);
                        createNonObservableSnapshot.dispose();
                        LazyListMeasureResult m247measureLazyListCD5nmq0 = LazyListMeasureKt.m247measureLazyListCD5nmq0(itemCount, lazyListMeasuredItemProvider, i10, i8, i9, mo150roundToPx0680j_45, updateScrollPositionIfTheFirstItemWasMoved$foundation_release, firstVisibleItemScrollOffset, lazyListState.getScrollToBeConsumed$foundation_release(), m1885offsetNN6EwU, z2, lazyListItemProvider.getHeaderIndexes(), vertical4, horizontal4, z, lazyLayoutMeasureScope, lazyListState.getPlacementAnimator$foundation_release(), i, LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(lazyListItemProvider, lazyListState.getPinnedItems$foundation_release(), lazyListState.getBeyondBoundsInfo$foundation_release()), new Function3() { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                return invoke(((Number) obj).intValue(), ((Number) obj2).intValue(), (Function1) obj3);
                            }

                            public final MeasureResult invoke(int i12, int i13, Function1 placement) {
                                Map emptyMap;
                                Intrinsics.checkNotNullParameter(placement, "placement");
                                LazyLayoutMeasureScope lazyLayoutMeasureScope2 = LazyLayoutMeasureScope.this;
                                int m1884constrainWidthK40F9xA = ConstraintsKt.m1884constrainWidthK40F9xA(j, i12 + i6);
                                int m1883constrainHeightK40F9xA = ConstraintsKt.m1883constrainHeightK40F9xA(j, i13 + i5);
                                emptyMap = MapsKt__MapsKt.emptyMap();
                                return lazyLayoutMeasureScope2.layout(m1884constrainWidthK40F9xA, m1883constrainHeightK40F9xA, emptyMap, placement);
                            }
                        });
                        lazyListState.applyMeasureResult$foundation_release(m247measureLazyListCD5nmq0);
                        return m247measureLazyListCD5nmq0;
                    } catch (Throwable th) {
                        createNonObservableSnapshot.dispose();
                        throw th;
                    }
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        Function2 function2 = (Function2) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return function2;
    }
}
