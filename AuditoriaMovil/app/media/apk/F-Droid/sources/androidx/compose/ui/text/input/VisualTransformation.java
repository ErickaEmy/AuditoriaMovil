package androidx.compose.ui.text.input;

import androidx.compose.ui.text.AnnotatedString;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: VisualTransformation.kt */
/* loaded from: classes.dex */
public interface VisualTransformation {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: VisualTransformation.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final VisualTransformation None = new VisualTransformation() { // from class: androidx.compose.ui.text.input.VisualTransformation$Companion$None$1
            @Override // androidx.compose.ui.text.input.VisualTransformation
            public final TransformedText filter(AnnotatedString text) {
                Intrinsics.checkNotNullParameter(text, "text");
                return new TransformedText(text, OffsetMapping.Companion.getIdentity());
            }
        };

        private Companion() {
        }

        public final VisualTransformation getNone() {
            return None;
        }
    }

    TransformedText filter(AnnotatedString annotatedString);
}
