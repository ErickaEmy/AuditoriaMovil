package androidx.compose.ui.text.android;

import android.os.Build;
import android.text.BoringLayout;
import android.text.Layout;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BoringLayoutFactory.kt */
/* loaded from: classes.dex */
public final class BoringLayoutFactory {
    public static final BoringLayoutFactory INSTANCE = new BoringLayoutFactory();

    private BoringLayoutFactory() {
    }

    public final BoringLayout.Metrics measure(CharSequence text, TextPaint paint, TextDirectionHeuristic textDir) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Intrinsics.checkNotNullParameter(textDir, "textDir");
        if (Build.VERSION.SDK_INT >= 33) {
            return BoringLayoutFactory33.isBoring(text, paint, textDir);
        }
        return BoringLayoutFactoryDefault.isBoring(text, paint, textDir);
    }

    public final BoringLayout create(CharSequence text, TextPaint paint, int i, BoringLayout.Metrics metrics, Layout.Alignment alignment, boolean z, boolean z2, TextUtils.TruncateAt truncateAt, int i2) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        if (i >= 0) {
            if (i2 >= 0) {
                if (Build.VERSION.SDK_INT >= 33) {
                    return BoringLayoutFactory33.create(text, paint, i, alignment, 1.0f, 0.0f, metrics, z, z2, truncateAt, i2);
                }
                return BoringLayoutFactoryDefault.create(text, paint, i, alignment, 1.0f, 0.0f, metrics, z, truncateAt, i2);
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public final boolean isFallbackLineSpacingEnabled(BoringLayout layout) {
        Intrinsics.checkNotNullParameter(layout, "layout");
        if (Build.VERSION.SDK_INT >= 33) {
            return BoringLayoutFactory33.INSTANCE.isFallbackLineSpacingEnabled(layout);
        }
        return false;
    }
}
