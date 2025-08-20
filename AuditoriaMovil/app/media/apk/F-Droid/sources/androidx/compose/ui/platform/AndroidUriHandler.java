package androidx.compose.ui.platform;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AndroidUriHandler.android.kt */
/* loaded from: classes.dex */
public final class AndroidUriHandler implements UriHandler {
    private final Context context;

    public AndroidUriHandler(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }
}
