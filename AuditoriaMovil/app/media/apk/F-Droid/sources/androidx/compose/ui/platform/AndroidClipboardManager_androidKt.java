package androidx.compose.ui.platform;

import android.text.Annotation;
import android.text.SpannableString;
import android.text.Spanned;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.SpanStyle;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AndroidClipboardManager.android.kt */
/* loaded from: classes.dex */
public abstract class AndroidClipboardManager_androidKt {
    public static final AnnotatedString convertToAnnotatedString(CharSequence charSequence) {
        int lastIndex;
        if (charSequence == null) {
            return null;
        }
        if (!(charSequence instanceof Spanned)) {
            return new AnnotatedString(charSequence.toString(), null, null, 6, null);
        }
        Spanned spanned = (Spanned) charSequence;
        int i = 0;
        Annotation[] annotations = (Annotation[]) spanned.getSpans(0, charSequence.length(), Annotation.class);
        ArrayList arrayList = new ArrayList();
        Intrinsics.checkNotNullExpressionValue(annotations, "annotations");
        lastIndex = ArraysKt___ArraysKt.getLastIndex(annotations);
        if (lastIndex >= 0) {
            while (true) {
                Annotation annotation = annotations[i];
                if (Intrinsics.areEqual(annotation.getKey(), "androidx.compose.text.SpanStyle")) {
                    int spanStart = spanned.getSpanStart(annotation);
                    int spanEnd = spanned.getSpanEnd(annotation);
                    String value = annotation.getValue();
                    Intrinsics.checkNotNullExpressionValue(value, "span.value");
                    arrayList.add(new AnnotatedString.Range(new DecodeHelper(value).decodeSpanStyle(), spanStart, spanEnd));
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return new AnnotatedString(charSequence.toString(), arrayList, null, 4, null);
    }

    public static final CharSequence convertToCharSequence(AnnotatedString annotatedString) {
        Intrinsics.checkNotNullParameter(annotatedString, "<this>");
        if (annotatedString.getSpanStyles().isEmpty()) {
            return annotatedString.getText();
        }
        SpannableString spannableString = new SpannableString(annotatedString.getText());
        EncodeHelper encodeHelper = new EncodeHelper();
        List spanStyles = annotatedString.getSpanStyles();
        int size = spanStyles.size();
        for (int i = 0; i < size; i++) {
            AnnotatedString.Range range = (AnnotatedString.Range) spanStyles.get(i);
            int component2 = range.component2();
            int component3 = range.component3();
            encodeHelper.reset();
            encodeHelper.encode((SpanStyle) range.component1());
            spannableString.setSpan(new Annotation("androidx.compose.text.SpanStyle", encodeHelper.encodedString()), component2, component3, 33);
        }
        return spannableString;
    }
}
