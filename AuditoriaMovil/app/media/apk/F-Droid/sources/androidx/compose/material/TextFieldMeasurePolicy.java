package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TextField.kt */
/* loaded from: classes.dex */
public final class TextFieldMeasurePolicy implements MeasurePolicy {
    private final float animationProgress;
    private final PaddingValues paddingValues;
    private final boolean singleLine;

    private final int intrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i, Function2 function2) {
        IntrinsicMeasurable intrinsicMeasurable;
        Object obj;
        Object obj2;
        Object obj3;
        int m578calculateHeightO3s9Psw;
        for (Object obj4 : list) {
            if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj4), "TextField")) {
                int intValue = ((Number) function2.invoke(obj4, Integer.valueOf(i))).intValue();
                Iterator it = list.iterator();
                while (true) {
                    intrinsicMeasurable = null;
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj), "Label")) {
                        break;
                    }
                }
                IntrinsicMeasurable intrinsicMeasurable2 = (IntrinsicMeasurable) obj;
                int intValue2 = intrinsicMeasurable2 != null ? ((Number) function2.invoke(intrinsicMeasurable2, Integer.valueOf(i))).intValue() : 0;
                Iterator it2 = list.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        obj2 = null;
                        break;
                    }
                    obj2 = it2.next();
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj2), "Trailing")) {
                        break;
                    }
                }
                IntrinsicMeasurable intrinsicMeasurable3 = (IntrinsicMeasurable) obj2;
                int intValue3 = intrinsicMeasurable3 != null ? ((Number) function2.invoke(intrinsicMeasurable3, Integer.valueOf(i))).intValue() : 0;
                Iterator it3 = list.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        obj3 = null;
                        break;
                    }
                    obj3 = it3.next();
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj3), "Leading")) {
                        break;
                    }
                }
                IntrinsicMeasurable intrinsicMeasurable4 = (IntrinsicMeasurable) obj3;
                int intValue4 = intrinsicMeasurable4 != null ? ((Number) function2.invoke(intrinsicMeasurable4, Integer.valueOf(i))).intValue() : 0;
                Iterator it4 = list.iterator();
                while (true) {
                    if (!it4.hasNext()) {
                        break;
                    }
                    Object next = it4.next();
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) next), "Hint")) {
                        intrinsicMeasurable = next;
                        break;
                    }
                }
                IntrinsicMeasurable intrinsicMeasurable5 = intrinsicMeasurable;
                m578calculateHeightO3s9Psw = TextFieldKt.m578calculateHeightO3s9Psw(intValue, intValue2 > 0, intValue2, intValue4, intValue3, intrinsicMeasurable5 != null ? ((Number) function2.invoke(intrinsicMeasurable5, Integer.valueOf(i))).intValue() : 0, TextFieldImplKt.getZeroConstraints(), intrinsicMeasureScope.getDensity(), this.paddingValues);
                return m578calculateHeightO3s9Psw;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    private final int intrinsicWidth(List list, int i, Function2 function2) {
        IntrinsicMeasurable intrinsicMeasurable;
        Object obj;
        Object obj2;
        Object obj3;
        int m579calculateWidthVsPV1Ek;
        for (Object obj4 : list) {
            if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj4), "TextField")) {
                int intValue = ((Number) function2.invoke(obj4, Integer.valueOf(i))).intValue();
                Iterator it = list.iterator();
                while (true) {
                    intrinsicMeasurable = null;
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj), "Label")) {
                        break;
                    }
                }
                IntrinsicMeasurable intrinsicMeasurable2 = (IntrinsicMeasurable) obj;
                int intValue2 = intrinsicMeasurable2 != null ? ((Number) function2.invoke(intrinsicMeasurable2, Integer.valueOf(i))).intValue() : 0;
                Iterator it2 = list.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        obj2 = null;
                        break;
                    }
                    obj2 = it2.next();
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj2), "Trailing")) {
                        break;
                    }
                }
                IntrinsicMeasurable intrinsicMeasurable3 = (IntrinsicMeasurable) obj2;
                int intValue3 = intrinsicMeasurable3 != null ? ((Number) function2.invoke(intrinsicMeasurable3, Integer.valueOf(i))).intValue() : 0;
                Iterator it3 = list.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        obj3 = null;
                        break;
                    }
                    obj3 = it3.next();
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj3), "Leading")) {
                        break;
                    }
                }
                IntrinsicMeasurable intrinsicMeasurable4 = (IntrinsicMeasurable) obj3;
                int intValue4 = intrinsicMeasurable4 != null ? ((Number) function2.invoke(intrinsicMeasurable4, Integer.valueOf(i))).intValue() : 0;
                Iterator it4 = list.iterator();
                while (true) {
                    if (!it4.hasNext()) {
                        break;
                    }
                    Object next = it4.next();
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) next), "Hint")) {
                        intrinsicMeasurable = next;
                        break;
                    }
                }
                IntrinsicMeasurable intrinsicMeasurable5 = intrinsicMeasurable;
                m579calculateWidthVsPV1Ek = TextFieldKt.m579calculateWidthVsPV1Ek(intValue4, intValue3, intValue, intValue2, intrinsicMeasurable5 != null ? ((Number) function2.invoke(intrinsicMeasurable5, Integer.valueOf(i))).intValue() : 0, TextFieldImplKt.getZeroConstraints());
                return m579calculateWidthVsPV1Ek;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    public TextFieldMeasurePolicy(boolean z, float f, PaddingValues paddingValues) {
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        this.singleLine = z;
        this.animationProgress = f;
        this.paddingValues = paddingValues;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo13measure3p2s80s(final MeasureScope measure, List measurables, long j) {
        Object obj;
        Object obj2;
        Object obj3;
        int i;
        Object obj4;
        final int m579calculateWidthVsPV1Ek;
        final int m578calculateHeightO3s9Psw;
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        final int mo150roundToPx0680j_4 = measure.mo150roundToPx0680j_4(this.paddingValues.mo221calculateTopPaddingD9Ej5fM());
        int mo150roundToPx0680j_42 = measure.mo150roundToPx0680j_4(this.paddingValues.mo218calculateBottomPaddingD9Ej5fM());
        final int mo150roundToPx0680j_43 = measure.mo150roundToPx0680j_4(TextFieldKt.getTextFieldTopPadding());
        long m1863copyZbe2FdA$default = Constraints.m1863copyZbe2FdA$default(j, 0, 0, 0, 0, 10, null);
        Iterator it = measurables.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) obj), "Leading")) {
                break;
            }
        }
        Measurable measurable = (Measurable) obj;
        final Placeable mo1251measureBRTryo0 = measurable != null ? measurable.mo1251measureBRTryo0(m1863copyZbe2FdA$default) : null;
        int widthOrZero = TextFieldImplKt.widthOrZero(mo1251measureBRTryo0);
        Iterator it2 = measurables.iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it2.next();
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) obj2), "Trailing")) {
                break;
            }
        }
        Measurable measurable2 = (Measurable) obj2;
        final Placeable mo1251measureBRTryo02 = measurable2 != null ? measurable2.mo1251measureBRTryo0(ConstraintsKt.m1886offsetNN6EwU$default(m1863copyZbe2FdA$default, -widthOrZero, 0, 2, null)) : null;
        int i2 = -mo150roundToPx0680j_42;
        int i3 = -(widthOrZero + TextFieldImplKt.widthOrZero(mo1251measureBRTryo02));
        long m1885offsetNN6EwU = ConstraintsKt.m1885offsetNN6EwU(m1863copyZbe2FdA$default, i3, i2);
        Iterator it3 = measurables.iterator();
        while (true) {
            if (!it3.hasNext()) {
                obj3 = null;
                break;
            }
            obj3 = it3.next();
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) obj3), "Label")) {
                break;
            }
        }
        Measurable measurable3 = (Measurable) obj3;
        Placeable mo1251measureBRTryo03 = measurable3 != null ? measurable3.mo1251measureBRTryo0(m1885offsetNN6EwU) : null;
        if (mo1251measureBRTryo03 != null) {
            i = mo1251measureBRTryo03.get(AlignmentLineKt.getLastBaseline());
            if (i == Integer.MIN_VALUE) {
                i = mo1251measureBRTryo03.getHeight();
            }
        } else {
            i = 0;
        }
        final int max = Math.max(i, mo150roundToPx0680j_4);
        long m1885offsetNN6EwU2 = ConstraintsKt.m1885offsetNN6EwU(Constraints.m1863copyZbe2FdA$default(j, 0, 0, 0, 0, 11, null), i3, mo1251measureBRTryo03 != null ? (i2 - mo150roundToPx0680j_43) - max : (-mo150roundToPx0680j_4) - mo150roundToPx0680j_42);
        Iterator it4 = measurables.iterator();
        while (it4.hasNext()) {
            Measurable measurable4 = (Measurable) it4.next();
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable4), "TextField")) {
                final Placeable mo1251measureBRTryo04 = measurable4.mo1251measureBRTryo0(m1885offsetNN6EwU2);
                long m1863copyZbe2FdA$default2 = Constraints.m1863copyZbe2FdA$default(m1885offsetNN6EwU2, 0, 0, 0, 0, 14, null);
                Iterator it5 = measurables.iterator();
                while (true) {
                    if (!it5.hasNext()) {
                        obj4 = null;
                        break;
                    }
                    obj4 = it5.next();
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) obj4), "Hint")) {
                        break;
                    }
                }
                Measurable measurable5 = (Measurable) obj4;
                Placeable mo1251measureBRTryo05 = measurable5 != null ? measurable5.mo1251measureBRTryo0(m1863copyZbe2FdA$default2) : null;
                m579calculateWidthVsPV1Ek = TextFieldKt.m579calculateWidthVsPV1Ek(TextFieldImplKt.widthOrZero(mo1251measureBRTryo0), TextFieldImplKt.widthOrZero(mo1251measureBRTryo02), mo1251measureBRTryo04.getWidth(), TextFieldImplKt.widthOrZero(mo1251measureBRTryo03), TextFieldImplKt.widthOrZero(mo1251measureBRTryo05), j);
                m578calculateHeightO3s9Psw = TextFieldKt.m578calculateHeightO3s9Psw(mo1251measureBRTryo04.getHeight(), mo1251measureBRTryo03 != null, max, TextFieldImplKt.heightOrZero(mo1251measureBRTryo0), TextFieldImplKt.heightOrZero(mo1251measureBRTryo02), TextFieldImplKt.heightOrZero(mo1251measureBRTryo05), j, measure.getDensity(), this.paddingValues);
                final Placeable placeable = mo1251measureBRTryo03;
                final int i4 = i;
                final Placeable placeable2 = mo1251measureBRTryo05;
                return MeasureScope.CC.layout$default(measure, m579calculateWidthVsPV1Ek, m578calculateHeightO3s9Psw, null, new Function1() { // from class: androidx.compose.material.TextFieldMeasurePolicy$measure$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj5) {
                        invoke((Placeable.PlacementScope) obj5);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Placeable.PlacementScope layout) {
                        boolean z;
                        PaddingValues paddingValues;
                        int coerceAtLeast;
                        boolean z2;
                        float f;
                        Intrinsics.checkNotNullParameter(layout, "$this$layout");
                        if (Placeable.this == null) {
                            int i5 = m579calculateWidthVsPV1Ek;
                            int i6 = m578calculateHeightO3s9Psw;
                            Placeable placeable3 = mo1251measureBRTryo04;
                            Placeable placeable4 = placeable2;
                            Placeable placeable5 = mo1251measureBRTryo0;
                            Placeable placeable6 = mo1251measureBRTryo02;
                            z = this.singleLine;
                            float density = measure.getDensity();
                            paddingValues = this.paddingValues;
                            TextFieldKt.placeWithoutLabel(layout, i5, i6, placeable3, placeable4, placeable5, placeable6, z, density, paddingValues);
                            return;
                        }
                        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mo150roundToPx0680j_4 - i4, 0);
                        int i7 = m579calculateWidthVsPV1Ek;
                        int i8 = m578calculateHeightO3s9Psw;
                        Placeable placeable7 = mo1251measureBRTryo04;
                        Placeable placeable8 = Placeable.this;
                        Placeable placeable9 = placeable2;
                        Placeable placeable10 = mo1251measureBRTryo0;
                        Placeable placeable11 = mo1251measureBRTryo02;
                        z2 = this.singleLine;
                        int i9 = mo150roundToPx0680j_43 + max;
                        f = this.animationProgress;
                        TextFieldKt.placeWithLabel(layout, i7, i8, placeable7, placeable8, placeable9, placeable10, placeable11, z2, coerceAtLeast, i9, f, measure.getDensity());
                    }
                }, 4, null);
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List measurables, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        return intrinsicHeight(intrinsicMeasureScope, measurables, i, new Function2() { // from class: androidx.compose.material.TextFieldMeasurePolicy$maxIntrinsicHeight$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue());
            }

            public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, int i2) {
                Intrinsics.checkNotNullParameter(intrinsicMeasurable, "intrinsicMeasurable");
                return Integer.valueOf(intrinsicMeasurable.maxIntrinsicHeight(i2));
            }
        });
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List measurables, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        return intrinsicHeight(intrinsicMeasureScope, measurables, i, new Function2() { // from class: androidx.compose.material.TextFieldMeasurePolicy$minIntrinsicHeight$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue());
            }

            public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, int i2) {
                Intrinsics.checkNotNullParameter(intrinsicMeasurable, "intrinsicMeasurable");
                return Integer.valueOf(intrinsicMeasurable.minIntrinsicHeight(i2));
            }
        });
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List measurables, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        return intrinsicWidth(measurables, i, new Function2() { // from class: androidx.compose.material.TextFieldMeasurePolicy$maxIntrinsicWidth$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue());
            }

            public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, int i2) {
                Intrinsics.checkNotNullParameter(intrinsicMeasurable, "intrinsicMeasurable");
                return Integer.valueOf(intrinsicMeasurable.maxIntrinsicWidth(i2));
            }
        });
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List measurables, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        return intrinsicWidth(measurables, i, new Function2() { // from class: androidx.compose.material.TextFieldMeasurePolicy$minIntrinsicWidth$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue());
            }

            public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, int i2) {
                Intrinsics.checkNotNullParameter(intrinsicMeasurable, "intrinsicMeasurable");
                return Integer.valueOf(intrinsicMeasurable.minIntrinsicWidth(i2));
            }
        });
    }
}
