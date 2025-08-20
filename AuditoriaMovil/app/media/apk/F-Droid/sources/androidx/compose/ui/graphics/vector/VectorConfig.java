package androidx.compose.ui.graphics.vector;

import kotlin.jvm.internal.Intrinsics;
/* compiled from: VectorPainter.kt */
/* loaded from: classes.dex */
public interface VectorConfig {

    /* compiled from: VectorPainter.kt */
    /* renamed from: androidx.compose.ui.graphics.vector.VectorConfig$-CC  reason: invalid class name */
    /* loaded from: classes.dex */
    public abstract /* synthetic */ class CC {
        public static Object $default$getOrDefault(VectorConfig vectorConfig, VectorProperty property, Object obj) {
            Intrinsics.checkNotNullParameter(property, "property");
            return obj;
        }
    }

    Object getOrDefault(VectorProperty vectorProperty, Object obj);
}
