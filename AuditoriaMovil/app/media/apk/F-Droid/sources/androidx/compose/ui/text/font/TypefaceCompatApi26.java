package androidx.compose.ui.text.font;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import androidx.appcompat.app.ToolbarActionBar$$ExternalSyntheticThrowCCEIfNotNull0;
import androidx.compose.ui.text.TempListUtilsKt;
import androidx.compose.ui.unit.AndroidDensity_androidKt;
import androidx.compose.ui.unit.Density;
import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PlatformTypefaces.kt */
/* loaded from: classes.dex */
public final class TypefaceCompatApi26 {
    public static final TypefaceCompatApi26 INSTANCE = new TypefaceCompatApi26();
    private static ThreadLocal threadLocalPaint = new ThreadLocal();

    private TypefaceCompatApi26() {
    }

    public final Typeface setFontVariationSettings(Typeface typeface, FontVariation$Settings variationSettings, Context context) {
        Intrinsics.checkNotNullParameter(variationSettings, "variationSettings");
        Intrinsics.checkNotNullParameter(context, "context");
        if (typeface == null) {
            return null;
        }
        if (variationSettings.getSettings().isEmpty()) {
            return typeface;
        }
        Paint paint = (Paint) threadLocalPaint.get();
        if (paint == null) {
            paint = new Paint();
            threadLocalPaint.set(paint);
        }
        paint.setTypeface(typeface);
        paint.setFontVariationSettings(toAndroidString(variationSettings, context));
        return paint.getTypeface();
    }

    private final String toAndroidString(FontVariation$Settings fontVariation$Settings, Context context) {
        final Density Density = AndroidDensity_androidKt.Density(context);
        return TempListUtilsKt.fastJoinToString$default(fontVariation$Settings.getSettings(), null, null, null, 0, null, new Function1() { // from class: androidx.compose.ui.text.font.TypefaceCompatApi26$toAndroidString$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                ToolbarActionBar$$ExternalSyntheticThrowCCEIfNotNull0.m(obj);
                return invoke((FontVariation$Setting) null);
            }

            public final CharSequence invoke(FontVariation$Setting setting) {
                Intrinsics.checkNotNullParameter(setting, "setting");
                return CoreConstants.SINGLE_QUOTE_CHAR + setting.getAxisName() + "' " + setting.toVariationValue(Density.this);
            }
        }, 31, null);
    }
}
