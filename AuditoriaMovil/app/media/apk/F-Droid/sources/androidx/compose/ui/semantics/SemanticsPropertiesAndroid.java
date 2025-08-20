package androidx.compose.ui.semantics;

import kotlin.jvm.functions.Function2;
/* compiled from: SemanticsProperties.android.kt */
/* loaded from: classes.dex */
public final class SemanticsPropertiesAndroid {
    public static final SemanticsPropertiesAndroid INSTANCE = new SemanticsPropertiesAndroid();
    private static final SemanticsPropertyKey TestTagsAsResourceId = new SemanticsPropertyKey("TestTagsAsResourceId", new Function2() { // from class: androidx.compose.ui.semantics.SemanticsPropertiesAndroid$TestTagsAsResourceId$1
        public final Boolean invoke(Boolean bool, boolean z) {
            return bool;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return invoke((Boolean) obj, ((Boolean) obj2).booleanValue());
        }
    });

    private SemanticsPropertiesAndroid() {
    }

    public final SemanticsPropertyKey getTestTagsAsResourceId() {
        return TestTagsAsResourceId;
    }
}
