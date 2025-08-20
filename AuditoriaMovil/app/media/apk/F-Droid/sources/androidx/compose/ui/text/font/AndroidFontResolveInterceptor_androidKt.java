package androidx.compose.ui.text.font;

import android.content.Context;
import android.os.Build;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AndroidFontResolveInterceptor.android.kt */
/* loaded from: classes.dex */
public abstract class AndroidFontResolveInterceptor_androidKt {
    public static final AndroidFontResolveInterceptor AndroidFontResolveInterceptor(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new AndroidFontResolveInterceptor(Build.VERSION.SDK_INT >= 31 ? context.getResources().getConfiguration().fontWeightAdjustment : 0);
    }
}
