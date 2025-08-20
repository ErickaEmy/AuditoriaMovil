package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.unit.Dp;
/* compiled from: AppBar.kt */
/* loaded from: classes.dex */
public final class AppBarDefaults {
    private static final PaddingValues ContentPadding;
    public static final AppBarDefaults INSTANCE = new AppBarDefaults();
    private static final float TopAppBarElevation = Dp.m1897constructorimpl(4);
    private static final float BottomAppBarElevation = Dp.m1897constructorimpl(8);

    private AppBarDefaults() {
    }

    public final PaddingValues getContentPadding() {
        return ContentPadding;
    }

    /* renamed from: getTopAppBarElevation-D9Ej5fM  reason: not valid java name */
    public final float m428getTopAppBarElevationD9Ej5fM() {
        return TopAppBarElevation;
    }

    static {
        float f;
        float f2;
        f = AppBarKt.AppBarHorizontalPadding;
        f2 = AppBarKt.AppBarHorizontalPadding;
        ContentPadding = PaddingKt.m206PaddingValuesa9UjIt4$default(f, 0.0f, f2, 0.0f, 10, null);
    }
}
