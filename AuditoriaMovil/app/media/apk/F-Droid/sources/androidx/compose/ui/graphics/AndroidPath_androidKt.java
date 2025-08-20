package androidx.compose.ui.graphics;

import kotlin.jvm.internal.Intrinsics;
/* compiled from: AndroidPath.android.kt */
/* loaded from: classes.dex */
public abstract class AndroidPath_androidKt {
    public static final Path Path() {
        return new AndroidPath(null, 1, null);
    }

    public static final Path asComposePath(android.graphics.Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        return new AndroidPath(path);
    }
}
