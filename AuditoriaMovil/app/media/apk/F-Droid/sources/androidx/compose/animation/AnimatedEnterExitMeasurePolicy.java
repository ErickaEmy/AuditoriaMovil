package androidx.compose.animation;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
/* compiled from: AnimatedVisibility.kt */
/* loaded from: classes.dex */
final class AnimatedEnterExitMeasurePolicy implements MeasurePolicy {
    private final AnimatedVisibilityScopeImpl scope;

    public AnimatedEnterExitMeasurePolicy(AnimatedVisibilityScopeImpl scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.scope = scope;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List measurables, final int i) {
        Sequence asSequence;
        Sequence map;
        Comparable maxOrNull;
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        asSequence = CollectionsKt___CollectionsKt.asSequence(measurables);
        map = SequencesKt___SequencesKt.map(asSequence, new Function1() { // from class: androidx.compose.animation.AnimatedEnterExitMeasurePolicy$minIntrinsicWidth$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Integer invoke(IntrinsicMeasurable it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Integer.valueOf(it.minIntrinsicWidth(i));
            }
        });
        maxOrNull = SequencesKt___SequencesKt.maxOrNull(map);
        Integer num = (Integer) maxOrNull;
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List measurables, final int i) {
        Sequence asSequence;
        Sequence map;
        Comparable maxOrNull;
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        asSequence = CollectionsKt___CollectionsKt.asSequence(measurables);
        map = SequencesKt___SequencesKt.map(asSequence, new Function1() { // from class: androidx.compose.animation.AnimatedEnterExitMeasurePolicy$minIntrinsicHeight$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Integer invoke(IntrinsicMeasurable it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Integer.valueOf(it.minIntrinsicHeight(i));
            }
        });
        maxOrNull = SequencesKt___SequencesKt.maxOrNull(map);
        Integer num = (Integer) maxOrNull;
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List measurables, final int i) {
        Sequence asSequence;
        Sequence map;
        Comparable maxOrNull;
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        asSequence = CollectionsKt___CollectionsKt.asSequence(measurables);
        map = SequencesKt___SequencesKt.map(asSequence, new Function1() { // from class: androidx.compose.animation.AnimatedEnterExitMeasurePolicy$maxIntrinsicWidth$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Integer invoke(IntrinsicMeasurable it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Integer.valueOf(it.maxIntrinsicWidth(i));
            }
        });
        maxOrNull = SequencesKt___SequencesKt.maxOrNull(map);
        Integer num = (Integer) maxOrNull;
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List measurables, final int i) {
        Sequence asSequence;
        Sequence map;
        Comparable maxOrNull;
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        asSequence = CollectionsKt___CollectionsKt.asSequence(measurables);
        map = SequencesKt___SequencesKt.map(asSequence, new Function1() { // from class: androidx.compose.animation.AnimatedEnterExitMeasurePolicy$maxIntrinsicHeight$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Integer invoke(IntrinsicMeasurable it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Integer.valueOf(it.maxIntrinsicHeight(i));
            }
        });
        maxOrNull = SequencesKt___SequencesKt.maxOrNull(map);
        Integer num = (Integer) maxOrNull;
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v15 */
    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult mo13measure3p2s80s(MeasureScope measure, List measurables, long j) {
        int collectionSizeOrDefault;
        Object obj;
        int lastIndex;
        int lastIndex2;
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(measurables, 10);
        final ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator it = measurables.iterator();
        while (it.hasNext()) {
            arrayList.add(((Measurable) it.next()).mo1251measureBRTryo0(j));
        }
        Placeable placeable = null;
        int i = 1;
        if (arrayList.isEmpty()) {
            obj = null;
        } else {
            obj = arrayList.get(0);
            int width = ((Placeable) obj).getWidth();
            lastIndex = CollectionsKt__CollectionsKt.getLastIndex(arrayList);
            if (1 <= lastIndex) {
                int i2 = 1;
                while (true) {
                    Object obj2 = arrayList.get(i2);
                    int width2 = ((Placeable) obj2).getWidth();
                    if (width < width2) {
                        obj = obj2;
                        width = width2;
                    }
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
        }
        Placeable placeable2 = (Placeable) obj;
        int width3 = placeable2 != null ? placeable2.getWidth() : 0;
        if (!arrayList.isEmpty()) {
            Object obj3 = arrayList.get(0);
            int height = ((Placeable) obj3).getHeight();
            lastIndex2 = CollectionsKt__CollectionsKt.getLastIndex(arrayList);
            Object obj4 = obj3;
            if (1 <= lastIndex2) {
                while (true) {
                    Object obj5 = arrayList.get(i);
                    int height2 = ((Placeable) obj5).getHeight();
                    obj3 = obj4;
                    if (height < height2) {
                        obj3 = obj5;
                        height = height2;
                    }
                    if (i == lastIndex2) {
                        break;
                    }
                    i++;
                    obj4 = obj3;
                }
            }
            placeable = obj3;
        }
        Placeable placeable3 = placeable;
        int height3 = placeable3 != null ? placeable3.getHeight() : 0;
        this.scope.getTargetSize$animation_release().setValue(IntSize.m1946boximpl(IntSizeKt.IntSize(width3, height3)));
        return MeasureScope.CC.layout$default(measure, width3, height3, null, new Function1() { // from class: androidx.compose.animation.AnimatedEnterExitMeasurePolicy$measure$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void invoke(Placeable.PlacementScope layout) {
                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                List list = arrayList;
                int size = list.size();
                for (int i3 = 0; i3 < size; i3++) {
                    Placeable.PlacementScope.place$default(layout, (Placeable) list.get(i3), 0, 0, 0.0f, 4, null);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj6) {
                invoke((Placeable.PlacementScope) obj6);
                return Unit.INSTANCE;
            }
        }, 4, null);
    }
}
