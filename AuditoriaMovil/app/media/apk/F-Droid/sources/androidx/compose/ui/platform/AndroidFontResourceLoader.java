package androidx.compose.ui.platform;

import android.content.Context;
import androidx.compose.ui.text.font.Font;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AndroidFontResourceLoader.android.kt */
/* loaded from: classes.dex */
public final class AndroidFontResourceLoader implements Font.ResourceLoader {
    private final Context context;

    public AndroidFontResourceLoader(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }
}
