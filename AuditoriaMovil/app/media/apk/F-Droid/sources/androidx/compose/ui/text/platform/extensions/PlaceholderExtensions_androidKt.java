package androidx.compose.ui.text.platform.extensions;

import android.text.Spannable;
import androidx.appcompat.app.ToolbarActionBar$$ExternalSyntheticThrowCCEIfNotNull0;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.unit.Density;
import androidx.emoji2.text.EmojiSpan;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: PlaceholderExtensions.android.kt */
/* loaded from: classes.dex */
public abstract class PlaceholderExtensions_androidKt {
    public static final void setPlaceholders(Spannable spannable, List placeholders, Density density) {
        Intrinsics.checkNotNullParameter(spannable, "<this>");
        Intrinsics.checkNotNullParameter(placeholders, "placeholders");
        Intrinsics.checkNotNullParameter(density, "density");
        int size = placeholders.size();
        for (int i = 0; i < size; i++) {
            AnnotatedString.Range range = (AnnotatedString.Range) placeholders.get(i);
            ToolbarActionBar$$ExternalSyntheticThrowCCEIfNotNull0.m(range.component1());
            setPlaceholder(spannable, null, range.component2(), range.component3(), density);
        }
    }

    private static final void setPlaceholder(Spannable spannable, Placeholder placeholder, int i, int i2, Density density) {
        Object[] spans = spannable.getSpans(i, i2, EmojiSpan.class);
        Intrinsics.checkNotNullExpressionValue(spans, "getSpans(start, end, EmojiSpan::class.java)");
        for (Object obj : spans) {
            ToolbarActionBar$$ExternalSyntheticThrowCCEIfNotNull0.m(obj);
            spannable.removeSpan(null);
        }
        throw null;
    }
}
