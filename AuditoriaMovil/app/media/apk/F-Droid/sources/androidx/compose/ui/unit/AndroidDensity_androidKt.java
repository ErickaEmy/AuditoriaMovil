package androidx.compose.ui.unit;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AndroidDensity.android.kt */
/* loaded from: classes.dex */
public abstract class AndroidDensity_androidKt {
    public static final Density Density(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return DensityKt.Density(context.getResources().getDisplayMetrics().density, context.getResources().getConfiguration().fontScale);
    }
}
