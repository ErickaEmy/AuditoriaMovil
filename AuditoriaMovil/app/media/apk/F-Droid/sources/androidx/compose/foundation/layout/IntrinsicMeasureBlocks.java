package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import java.util.List;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: RowColumnImpl.kt */
/* loaded from: classes.dex */
final class IntrinsicMeasureBlocks {
    public static final IntrinsicMeasureBlocks INSTANCE = new IntrinsicMeasureBlocks();
    private static final Function3 HorizontalMinWidth = new Function3() { // from class: androidx.compose.foundation.layout.IntrinsicMeasureBlocks$HorizontalMinWidth$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((List) obj, ((Number) obj2).intValue(), ((Number) obj3).intValue());
        }

        public final Integer invoke(List measurables, int i, int i2) {
            Intrinsics.checkNotNullParameter(measurables, "measurables");
            AnonymousClass1 anonymousClass1 = new Function2() { // from class: androidx.compose.foundation.layout.IntrinsicMeasureBlocks$HorizontalMinWidth$1.1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue());
                }

                public final Integer invoke(IntrinsicMeasurable intrinsicSize, int i3) {
                    Intrinsics.checkNotNullParameter(intrinsicSize, "$this$intrinsicSize");
                    return Integer.valueOf(intrinsicSize.minIntrinsicWidth(i3));
                }
            };
            AnonymousClass2 anonymousClass2 = new Function2() { // from class: androidx.compose.foundation.layout.IntrinsicMeasureBlocks$HorizontalMinWidth$1.2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue());
                }

                public final Integer invoke(IntrinsicMeasurable intrinsicSize, int i3) {
                    Intrinsics.checkNotNullParameter(intrinsicSize, "$this$intrinsicSize");
                    return Integer.valueOf(intrinsicSize.maxIntrinsicHeight(i3));
                }
            };
            LayoutOrientation layoutOrientation = LayoutOrientation.Horizontal;
            return Integer.valueOf(RowColumnImplKt.access$intrinsicSize(measurables, anonymousClass1, anonymousClass2, i, i2, layoutOrientation, layoutOrientation));
        }
    };
    private static final Function3 VerticalMinWidth = new Function3() { // from class: androidx.compose.foundation.layout.IntrinsicMeasureBlocks$VerticalMinWidth$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((List) obj, ((Number) obj2).intValue(), ((Number) obj3).intValue());
        }

        public final Integer invoke(List measurables, int i, int i2) {
            Intrinsics.checkNotNullParameter(measurables, "measurables");
            return Integer.valueOf(RowColumnImplKt.access$intrinsicSize(measurables, new Function2() { // from class: androidx.compose.foundation.layout.IntrinsicMeasureBlocks$VerticalMinWidth$1.1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue());
                }

                public final Integer invoke(IntrinsicMeasurable intrinsicSize, int i3) {
                    Intrinsics.checkNotNullParameter(intrinsicSize, "$this$intrinsicSize");
                    return Integer.valueOf(intrinsicSize.minIntrinsicWidth(i3));
                }
            }, new Function2() { // from class: androidx.compose.foundation.layout.IntrinsicMeasureBlocks$VerticalMinWidth$1.2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue());
                }

                public final Integer invoke(IntrinsicMeasurable intrinsicSize, int i3) {
                    Intrinsics.checkNotNullParameter(intrinsicSize, "$this$intrinsicSize");
                    return Integer.valueOf(intrinsicSize.maxIntrinsicHeight(i3));
                }
            }, i, i2, LayoutOrientation.Vertical, LayoutOrientation.Horizontal));
        }
    };
    private static final Function3 HorizontalMinHeight = new Function3() { // from class: androidx.compose.foundation.layout.IntrinsicMeasureBlocks$HorizontalMinHeight$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((List) obj, ((Number) obj2).intValue(), ((Number) obj3).intValue());
        }

        public final Integer invoke(List measurables, int i, int i2) {
            Intrinsics.checkNotNullParameter(measurables, "measurables");
            return Integer.valueOf(RowColumnImplKt.access$intrinsicSize(measurables, new Function2() { // from class: androidx.compose.foundation.layout.IntrinsicMeasureBlocks$HorizontalMinHeight$1.1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue());
                }

                public final Integer invoke(IntrinsicMeasurable intrinsicSize, int i3) {
                    Intrinsics.checkNotNullParameter(intrinsicSize, "$this$intrinsicSize");
                    return Integer.valueOf(intrinsicSize.minIntrinsicHeight(i3));
                }
            }, new Function2() { // from class: androidx.compose.foundation.layout.IntrinsicMeasureBlocks$HorizontalMinHeight$1.2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue());
                }

                public final Integer invoke(IntrinsicMeasurable intrinsicSize, int i3) {
                    Intrinsics.checkNotNullParameter(intrinsicSize, "$this$intrinsicSize");
                    return Integer.valueOf(intrinsicSize.maxIntrinsicWidth(i3));
                }
            }, i, i2, LayoutOrientation.Horizontal, LayoutOrientation.Vertical));
        }
    };
    private static final Function3 VerticalMinHeight = new Function3() { // from class: androidx.compose.foundation.layout.IntrinsicMeasureBlocks$VerticalMinHeight$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((List) obj, ((Number) obj2).intValue(), ((Number) obj3).intValue());
        }

        public final Integer invoke(List measurables, int i, int i2) {
            Intrinsics.checkNotNullParameter(measurables, "measurables");
            AnonymousClass1 anonymousClass1 = new Function2() { // from class: androidx.compose.foundation.layout.IntrinsicMeasureBlocks$VerticalMinHeight$1.1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue());
                }

                public final Integer invoke(IntrinsicMeasurable intrinsicSize, int i3) {
                    Intrinsics.checkNotNullParameter(intrinsicSize, "$this$intrinsicSize");
                    return Integer.valueOf(intrinsicSize.minIntrinsicHeight(i3));
                }
            };
            AnonymousClass2 anonymousClass2 = new Function2() { // from class: androidx.compose.foundation.layout.IntrinsicMeasureBlocks$VerticalMinHeight$1.2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue());
                }

                public final Integer invoke(IntrinsicMeasurable intrinsicSize, int i3) {
                    Intrinsics.checkNotNullParameter(intrinsicSize, "$this$intrinsicSize");
                    return Integer.valueOf(intrinsicSize.maxIntrinsicWidth(i3));
                }
            };
            LayoutOrientation layoutOrientation = LayoutOrientation.Vertical;
            return Integer.valueOf(RowColumnImplKt.access$intrinsicSize(measurables, anonymousClass1, anonymousClass2, i, i2, layoutOrientation, layoutOrientation));
        }
    };
    private static final Function3 HorizontalMaxWidth = new Function3() { // from class: androidx.compose.foundation.layout.IntrinsicMeasureBlocks$HorizontalMaxWidth$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((List) obj, ((Number) obj2).intValue(), ((Number) obj3).intValue());
        }

        public final Integer invoke(List measurables, int i, int i2) {
            Intrinsics.checkNotNullParameter(measurables, "measurables");
            AnonymousClass1 anonymousClass1 = new Function2() { // from class: androidx.compose.foundation.layout.IntrinsicMeasureBlocks$HorizontalMaxWidth$1.1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue());
                }

                public final Integer invoke(IntrinsicMeasurable intrinsicSize, int i3) {
                    Intrinsics.checkNotNullParameter(intrinsicSize, "$this$intrinsicSize");
                    return Integer.valueOf(intrinsicSize.maxIntrinsicWidth(i3));
                }
            };
            AnonymousClass2 anonymousClass2 = new Function2() { // from class: androidx.compose.foundation.layout.IntrinsicMeasureBlocks$HorizontalMaxWidth$1.2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue());
                }

                public final Integer invoke(IntrinsicMeasurable intrinsicSize, int i3) {
                    Intrinsics.checkNotNullParameter(intrinsicSize, "$this$intrinsicSize");
                    return Integer.valueOf(intrinsicSize.maxIntrinsicHeight(i3));
                }
            };
            LayoutOrientation layoutOrientation = LayoutOrientation.Horizontal;
            return Integer.valueOf(RowColumnImplKt.access$intrinsicSize(measurables, anonymousClass1, anonymousClass2, i, i2, layoutOrientation, layoutOrientation));
        }
    };
    private static final Function3 VerticalMaxWidth = new Function3() { // from class: androidx.compose.foundation.layout.IntrinsicMeasureBlocks$VerticalMaxWidth$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((List) obj, ((Number) obj2).intValue(), ((Number) obj3).intValue());
        }

        public final Integer invoke(List measurables, int i, int i2) {
            Intrinsics.checkNotNullParameter(measurables, "measurables");
            return Integer.valueOf(RowColumnImplKt.access$intrinsicSize(measurables, new Function2() { // from class: androidx.compose.foundation.layout.IntrinsicMeasureBlocks$VerticalMaxWidth$1.1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue());
                }

                public final Integer invoke(IntrinsicMeasurable intrinsicSize, int i3) {
                    Intrinsics.checkNotNullParameter(intrinsicSize, "$this$intrinsicSize");
                    return Integer.valueOf(intrinsicSize.maxIntrinsicWidth(i3));
                }
            }, new Function2() { // from class: androidx.compose.foundation.layout.IntrinsicMeasureBlocks$VerticalMaxWidth$1.2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue());
                }

                public final Integer invoke(IntrinsicMeasurable intrinsicSize, int i3) {
                    Intrinsics.checkNotNullParameter(intrinsicSize, "$this$intrinsicSize");
                    return Integer.valueOf(intrinsicSize.maxIntrinsicHeight(i3));
                }
            }, i, i2, LayoutOrientation.Vertical, LayoutOrientation.Horizontal));
        }
    };
    private static final Function3 HorizontalMaxHeight = new Function3() { // from class: androidx.compose.foundation.layout.IntrinsicMeasureBlocks$HorizontalMaxHeight$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((List) obj, ((Number) obj2).intValue(), ((Number) obj3).intValue());
        }

        public final Integer invoke(List measurables, int i, int i2) {
            Intrinsics.checkNotNullParameter(measurables, "measurables");
            return Integer.valueOf(RowColumnImplKt.access$intrinsicSize(measurables, new Function2() { // from class: androidx.compose.foundation.layout.IntrinsicMeasureBlocks$HorizontalMaxHeight$1.1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue());
                }

                public final Integer invoke(IntrinsicMeasurable intrinsicSize, int i3) {
                    Intrinsics.checkNotNullParameter(intrinsicSize, "$this$intrinsicSize");
                    return Integer.valueOf(intrinsicSize.maxIntrinsicHeight(i3));
                }
            }, new Function2() { // from class: androidx.compose.foundation.layout.IntrinsicMeasureBlocks$HorizontalMaxHeight$1.2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue());
                }

                public final Integer invoke(IntrinsicMeasurable intrinsicSize, int i3) {
                    Intrinsics.checkNotNullParameter(intrinsicSize, "$this$intrinsicSize");
                    return Integer.valueOf(intrinsicSize.maxIntrinsicWidth(i3));
                }
            }, i, i2, LayoutOrientation.Horizontal, LayoutOrientation.Vertical));
        }
    };
    private static final Function3 VerticalMaxHeight = new Function3() { // from class: androidx.compose.foundation.layout.IntrinsicMeasureBlocks$VerticalMaxHeight$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((List) obj, ((Number) obj2).intValue(), ((Number) obj3).intValue());
        }

        public final Integer invoke(List measurables, int i, int i2) {
            Intrinsics.checkNotNullParameter(measurables, "measurables");
            AnonymousClass1 anonymousClass1 = new Function2() { // from class: androidx.compose.foundation.layout.IntrinsicMeasureBlocks$VerticalMaxHeight$1.1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue());
                }

                public final Integer invoke(IntrinsicMeasurable intrinsicSize, int i3) {
                    Intrinsics.checkNotNullParameter(intrinsicSize, "$this$intrinsicSize");
                    return Integer.valueOf(intrinsicSize.maxIntrinsicHeight(i3));
                }
            };
            AnonymousClass2 anonymousClass2 = new Function2() { // from class: androidx.compose.foundation.layout.IntrinsicMeasureBlocks$VerticalMaxHeight$1.2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue());
                }

                public final Integer invoke(IntrinsicMeasurable intrinsicSize, int i3) {
                    Intrinsics.checkNotNullParameter(intrinsicSize, "$this$intrinsicSize");
                    return Integer.valueOf(intrinsicSize.maxIntrinsicWidth(i3));
                }
            };
            LayoutOrientation layoutOrientation = LayoutOrientation.Vertical;
            return Integer.valueOf(RowColumnImplKt.access$intrinsicSize(measurables, anonymousClass1, anonymousClass2, i, i2, layoutOrientation, layoutOrientation));
        }
    };

    private IntrinsicMeasureBlocks() {
    }

    public final Function3 getHorizontalMaxHeight() {
        return HorizontalMaxHeight;
    }

    public final Function3 getHorizontalMaxWidth() {
        return HorizontalMaxWidth;
    }

    public final Function3 getHorizontalMinHeight() {
        return HorizontalMinHeight;
    }

    public final Function3 getHorizontalMinWidth() {
        return HorizontalMinWidth;
    }

    public final Function3 getVerticalMaxHeight() {
        return VerticalMaxHeight;
    }

    public final Function3 getVerticalMaxWidth() {
        return VerticalMaxWidth;
    }

    public final Function3 getVerticalMinHeight() {
        return VerticalMinHeight;
    }

    public final Function3 getVerticalMinWidth() {
        return VerticalMinWidth;
    }
}
