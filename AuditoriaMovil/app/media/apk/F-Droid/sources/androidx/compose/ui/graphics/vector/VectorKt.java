package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.PathFillType;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
/* compiled from: Vector.kt */
/* loaded from: classes.dex */
public abstract class VectorKt {
    private static final int DefaultFillType;
    private static final int DefaultStrokeLineCap;
    private static final int DefaultStrokeLineJoin;
    private static final int DefaultTintBlendMode;
    private static final long DefaultTintColor;
    private static final List EmptyPath;

    public static final int getDefaultFillType() {
        return DefaultFillType;
    }

    public static final int getDefaultStrokeLineCap() {
        return DefaultStrokeLineCap;
    }

    public static final int getDefaultStrokeLineJoin() {
        return DefaultStrokeLineJoin;
    }

    public static final List getEmptyPath() {
        return EmptyPath;
    }

    static {
        List emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        EmptyPath = emptyList;
        DefaultStrokeLineCap = StrokeCap.Companion.m970getButtKaPHkGw();
        DefaultStrokeLineJoin = StrokeJoin.Companion.m981getMiterLxFBmk8();
        DefaultTintBlendMode = BlendMode.Companion.m826getSrcIn0nO6VwU();
        DefaultTintColor = Color.Companion.m863getTransparent0d7_KjU();
        DefaultFillType = PathFillType.Companion.m941getNonZeroRgk1Os();
    }
}
