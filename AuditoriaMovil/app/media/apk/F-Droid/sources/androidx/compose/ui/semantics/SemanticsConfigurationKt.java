package androidx.compose.ui.semantics;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SemanticsConfiguration.kt */
/* loaded from: classes.dex */
public abstract class SemanticsConfigurationKt {
    public static final Object getOrNull(SemanticsConfiguration semanticsConfiguration, SemanticsPropertyKey key) {
        Intrinsics.checkNotNullParameter(semanticsConfiguration, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        return semanticsConfiguration.getOrElseNullable(key, new Function0() { // from class: androidx.compose.ui.semantics.SemanticsConfigurationKt$getOrNull$1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return null;
            }
        });
    }
}
