package androidx.compose.ui.text.android.style;

import android.graphics.Paint;
import android.text.Layout;
import androidx.compose.ui.text.android.TextLayoutKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: IndentationFixSpan.kt */
/* loaded from: classes.dex */
public abstract class IndentationFixSpanKt {

    /* compiled from: IndentationFixSpan.kt */
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Layout.Alignment.values().length];
            try {
                iArr[Layout.Alignment.ALIGN_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ float getEllipsizedLeftPadding$default(Layout layout, int i, Paint paint, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            paint = layout.getPaint();
            Intrinsics.checkNotNullExpressionValue(paint, "this.paint");
        }
        return getEllipsizedLeftPadding(layout, i, paint);
    }

    public static final float getEllipsizedLeftPadding(Layout layout, int i, Paint paint) {
        float abs;
        float width;
        Intrinsics.checkNotNullParameter(layout, "<this>");
        Intrinsics.checkNotNullParameter(paint, "paint");
        float lineLeft = layout.getLineLeft(i);
        if (TextLayoutKt.isLineEllipsized(layout, i) && layout.getParagraphDirection(i) == 1 && lineLeft < 0.0f) {
            float primaryHorizontal = (layout.getPrimaryHorizontal(layout.getLineStart(i) + layout.getEllipsisStart(i)) - lineLeft) + paint.measureText("…");
            Layout.Alignment paragraphAlignment = layout.getParagraphAlignment(i);
            if (paragraphAlignment != null && WhenMappings.$EnumSwitchMapping$0[paragraphAlignment.ordinal()] == 1) {
                abs = Math.abs(lineLeft);
                width = (layout.getWidth() - primaryHorizontal) / 2.0f;
            } else {
                abs = Math.abs(lineLeft);
                width = layout.getWidth() - primaryHorizontal;
            }
            return abs + width;
        }
        return 0.0f;
    }

    public static /* synthetic */ float getEllipsizedRightPadding$default(Layout layout, int i, Paint paint, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            paint = layout.getPaint();
            Intrinsics.checkNotNullExpressionValue(paint, "this.paint");
        }
        return getEllipsizedRightPadding(layout, i, paint);
    }

    public static final float getEllipsizedRightPadding(Layout layout, int i, Paint paint) {
        float width;
        float width2;
        Intrinsics.checkNotNullParameter(layout, "<this>");
        Intrinsics.checkNotNullParameter(paint, "paint");
        if (TextLayoutKt.isLineEllipsized(layout, i) && layout.getParagraphDirection(i) == -1 && layout.getWidth() < layout.getLineRight(i)) {
            float lineRight = (layout.getLineRight(i) - layout.getPrimaryHorizontal(layout.getLineStart(i) + layout.getEllipsisStart(i))) + paint.measureText("…");
            Layout.Alignment paragraphAlignment = layout.getParagraphAlignment(i);
            if (paragraphAlignment != null && WhenMappings.$EnumSwitchMapping$0[paragraphAlignment.ordinal()] == 1) {
                width = layout.getWidth() - layout.getLineRight(i);
                width2 = (layout.getWidth() - lineRight) / 2.0f;
            } else {
                width = layout.getWidth() - layout.getLineRight(i);
                width2 = layout.getWidth() - lineRight;
            }
            return width - width2;
        }
        return 0.0f;
    }
}
