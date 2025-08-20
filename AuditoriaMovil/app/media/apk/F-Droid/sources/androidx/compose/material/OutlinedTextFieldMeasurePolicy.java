package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
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
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.MathHelpersKt;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OutlinedTextField.kt */
/* loaded from: classes.dex */
public final class OutlinedTextFieldMeasurePolicy implements MeasurePolicy {
    private final float animationProgress;
    private final Function1 onLabelMeasured;
    private final PaddingValues paddingValues;
    private final boolean singleLine;

    private final int intrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i, Function2 function2) {
        IntrinsicMeasurable intrinsicMeasurable;
        Object obj;
        Object obj2;
        Object obj3;
        int m512calculateHeightO3s9Psw;
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
                m512calculateHeightO3s9Psw = OutlinedTextFieldKt.m512calculateHeightO3s9Psw(intValue4, intValue3, intValue, intValue2, intrinsicMeasurable5 != null ? ((Number) function2.invoke(intrinsicMeasurable5, Integer.valueOf(i))).intValue() : 0, this.animationProgress, TextFieldImplKt.getZeroConstraints(), intrinsicMeasureScope.getDensity(), this.paddingValues);
                return m512calculateHeightO3s9Psw;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    private final int intrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i, Function2 function2) {
        IntrinsicMeasurable intrinsicMeasurable;
        Object obj;
        Object obj2;
        Object obj3;
        int m513calculateWidthO3s9Psw;
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
                m513calculateWidthO3s9Psw = OutlinedTextFieldKt.m513calculateWidthO3s9Psw(intValue4, intValue3, intValue, intValue2, intrinsicMeasurable5 != null ? ((Number) function2.invoke(intrinsicMeasurable5, Integer.valueOf(i))).intValue() : 0, this.animationProgress, TextFieldImplKt.getZeroConstraints(), intrinsicMeasureScope.getDensity(), this.paddingValues);
                return m513calculateWidthO3s9Psw;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    public OutlinedTextFieldMeasurePolicy(Function1 onLabelMeasured, boolean z, float f, PaddingValues paddingValues) {
        Intrinsics.checkNotNullParameter(onLabelMeasured, "onLabelMeasured");
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        this.onLabelMeasured = onLabelMeasured;
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
        Object obj4;
        final int m513calculateWidthO3s9Psw;
        final int m512calculateHeightO3s9Psw;
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        int mo150roundToPx0680j_4 = measure.mo150roundToPx0680j_4(this.paddingValues.mo218calculateBottomPaddingD9Ej5fM());
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
        Placeable mo1251measureBRTryo0 = measurable != null ? measurable.mo1251measureBRTryo0(m1863copyZbe2FdA$default) : null;
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
        Placeable mo1251measureBRTryo02 = measurable2 != null ? measurable2.mo1251measureBRTryo0(ConstraintsKt.m1886offsetNN6EwU$default(m1863copyZbe2FdA$default, -widthOrZero, 0, 2, null)) : null;
        int widthOrZero2 = widthOrZero + TextFieldImplKt.widthOrZero(mo1251measureBRTryo02);
        int mo150roundToPx0680j_42 = measure.mo150roundToPx0680j_4(this.paddingValues.mo219calculateLeftPaddingu2uoSUM(measure.getLayoutDirection())) + measure.mo150roundToPx0680j_4(this.paddingValues.mo220calculateRightPaddingu2uoSUM(measure.getLayoutDirection()));
        int i = -widthOrZero2;
        int i2 = -mo150roundToPx0680j_4;
        long m1885offsetNN6EwU = ConstraintsKt.m1885offsetNN6EwU(m1863copyZbe2FdA$default, MathHelpersKt.lerp(i - mo150roundToPx0680j_42, -mo150roundToPx0680j_42, this.animationProgress), i2);
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
            this.onLabelMeasured.invoke(Size.m739boximpl(SizeKt.Size(mo1251measureBRTryo03.getWidth(), mo1251measureBRTryo03.getHeight())));
        }
        long m1863copyZbe2FdA$default2 = Constraints.m1863copyZbe2FdA$default(ConstraintsKt.m1885offsetNN6EwU(j, i, i2 - Math.max(TextFieldImplKt.heightOrZero(mo1251measureBRTryo03) / 2, measure.mo150roundToPx0680j_4(this.paddingValues.mo221calculateTopPaddingD9Ej5fM()))), 0, 0, 0, 0, 11, null);
        Iterator it4 = measurables.iterator();
        while (it4.hasNext()) {
            Measurable measurable4 = (Measurable) it4.next();
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable4), "TextField")) {
                final Placeable mo1251measureBRTryo04 = measurable4.mo1251measureBRTryo0(m1863copyZbe2FdA$default2);
                long m1863copyZbe2FdA$default3 = Constraints.m1863copyZbe2FdA$default(m1863copyZbe2FdA$default2, 0, 0, 0, 0, 14, null);
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
                Placeable mo1251measureBRTryo05 = measurable5 != null ? measurable5.mo1251measureBRTryo0(m1863copyZbe2FdA$default3) : null;
                m513calculateWidthO3s9Psw = OutlinedTextFieldKt.m513calculateWidthO3s9Psw(TextFieldImplKt.widthOrZero(mo1251measureBRTryo0), TextFieldImplKt.widthOrZero(mo1251measureBRTryo02), mo1251measureBRTryo04.getWidth(), TextFieldImplKt.widthOrZero(mo1251measureBRTryo03), TextFieldImplKt.widthOrZero(mo1251measureBRTryo05), this.animationProgress, j, measure.getDensity(), this.paddingValues);
                m512calculateHeightO3s9Psw = OutlinedTextFieldKt.m512calculateHeightO3s9Psw(TextFieldImplKt.heightOrZero(mo1251measureBRTryo0), TextFieldImplKt.heightOrZero(mo1251measureBRTryo02), mo1251measureBRTryo04.getHeight(), TextFieldImplKt.heightOrZero(mo1251measureBRTryo03), TextFieldImplKt.heightOrZero(mo1251measureBRTryo05), this.animationProgress, j, measure.getDensity(), this.paddingValues);
                Iterator it6 = measurables.iterator();
                while (it6.hasNext()) {
                    Measurable measurable6 = (Measurable) it6.next();
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable6), "border")) {
                        final Placeable mo1251measureBRTryo06 = measurable6.mo1251measureBRTryo0(ConstraintsKt.Constraints(m513calculateWidthO3s9Psw != Integer.MAX_VALUE ? m513calculateWidthO3s9Psw : 0, m513calculateWidthO3s9Psw, m512calculateHeightO3s9Psw != Integer.MAX_VALUE ? m512calculateHeightO3s9Psw : 0, m512calculateHeightO3s9Psw));
                        final Placeable placeable = mo1251measureBRTryo0;
                        final Placeable placeable2 = mo1251measureBRTryo02;
                        final Placeable placeable3 = mo1251measureBRTryo03;
                        final Placeable placeable4 = mo1251measureBRTryo05;
                        return MeasureScope.CC.layout$default(measure, m513calculateWidthO3s9Psw, m512calculateHeightO3s9Psw, null, new Function1() { // from class: androidx.compose.material.OutlinedTextFieldMeasurePolicy$measure$2
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
                                float f;
                                boolean z;
                                PaddingValues paddingValues;
                                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                                int i3 = m512calculateHeightO3s9Psw;
                                int i4 = m513calculateWidthO3s9Psw;
                                Placeable placeable5 = placeable;
                                Placeable placeable6 = placeable2;
                                Placeable placeable7 = mo1251measureBRTryo04;
                                Placeable placeable8 = placeable3;
                                Placeable placeable9 = placeable4;
                                Placeable placeable10 = mo1251measureBRTryo06;
                                f = this.animationProgress;
                                z = this.singleLine;
                                float density = measure.getDensity();
                                LayoutDirection layoutDirection = measure.getLayoutDirection();
                                paddingValues = this.paddingValues;
                                OutlinedTextFieldKt.place(layout, i3, i4, placeable5, placeable6, placeable7, placeable8, placeable9, placeable10, f, z, density, layoutDirection, paddingValues);
                            }
                        }, 4, null);
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List measurables, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        return intrinsicHeight(intrinsicMeasureScope, measurables, i, new Function2() { // from class: androidx.compose.material.OutlinedTextFieldMeasurePolicy$maxIntrinsicHeight$1
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
        return intrinsicHeight(intrinsicMeasureScope, measurables, i, new Function2() { // from class: androidx.compose.material.OutlinedTextFieldMeasurePolicy$minIntrinsicHeight$1
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
        return intrinsicWidth(intrinsicMeasureScope, measurables, i, new Function2() { // from class: androidx.compose.material.OutlinedTextFieldMeasurePolicy$maxIntrinsicWidth$1
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
        return intrinsicWidth(intrinsicMeasureScope, measurables, i, new Function2() { // from class: androidx.compose.material.OutlinedTextFieldMeasurePolicy$minIntrinsicWidth$1
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
