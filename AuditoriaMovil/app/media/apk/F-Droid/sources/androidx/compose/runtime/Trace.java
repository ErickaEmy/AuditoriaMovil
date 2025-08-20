package androidx.compose.runtime;

import kotlin.jvm.internal.Intrinsics;
/* compiled from: ActualAndroid.android.kt */
/* loaded from: classes.dex */
public final class Trace {
    public static final Trace INSTANCE = new Trace();

    private Trace() {
    }

    public final Object beginSection(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        android.os.Trace.beginSection(name);
        return null;
    }

    public final void endSection(Object obj) {
        android.os.Trace.endSection();
    }
}
