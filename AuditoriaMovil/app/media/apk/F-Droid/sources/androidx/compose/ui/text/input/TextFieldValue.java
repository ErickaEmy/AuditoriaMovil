package androidx.compose.ui.text.input;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.SaversKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import ch.qos.logback.core.CoreConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: TextFieldValue.kt */
/* loaded from: classes.dex */
public final class TextFieldValue {
    public static final Companion Companion = new Companion(null);
    private static final Saver Saver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.input.TextFieldValue$Companion$Saver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope Saver2, TextFieldValue it) {
            ArrayList arrayListOf;
            Intrinsics.checkNotNullParameter(Saver2, "$this$Saver");
            Intrinsics.checkNotNullParameter(it, "it");
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(SaversKt.save(it.getAnnotatedString(), SaversKt.getAnnotatedStringSaver(), Saver2), SaversKt.save(TextRange.m1573boximpl(it.m1718getSelectiond9O1mEE()), SaversKt.getSaver(TextRange.Companion), Saver2));
            return arrayListOf;
        }
    }, new Function1() { // from class: androidx.compose.ui.text.input.TextFieldValue$Companion$Saver$2
        @Override // kotlin.jvm.functions.Function1
        public final TextFieldValue invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            List list = (List) it;
            Object obj = list.get(0);
            Saver annotatedStringSaver = SaversKt.getAnnotatedStringSaver();
            Boolean bool = Boolean.FALSE;
            TextRange textRange = null;
            AnnotatedString annotatedString = (Intrinsics.areEqual(obj, bool) || obj == null) ? null : (AnnotatedString) annotatedStringSaver.restore(obj);
            Intrinsics.checkNotNull(annotatedString);
            Object obj2 = list.get(1);
            Saver saver = SaversKt.getSaver(TextRange.Companion);
            if (!Intrinsics.areEqual(obj2, bool) && obj2 != null) {
                textRange = (TextRange) saver.restore(obj2);
            }
            Intrinsics.checkNotNull(textRange);
            return new TextFieldValue(annotatedString, textRange.m1589unboximpl(), (TextRange) null, 4, (DefaultConstructorMarker) null);
        }
    });
    private final AnnotatedString annotatedString;
    private final TextRange composition;
    private final long selection;

    /* compiled from: TextFieldValue.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ TextFieldValue(AnnotatedString annotatedString, long j, TextRange textRange, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, j, textRange);
    }

    public /* synthetic */ TextFieldValue(String str, long j, TextRange textRange, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, textRange);
    }

    public final AnnotatedString getAnnotatedString() {
        return this.annotatedString;
    }

    /* renamed from: getComposition-MzsxiRA  reason: not valid java name */
    public final TextRange m1717getCompositionMzsxiRA() {
        return this.composition;
    }

    /* renamed from: getSelection-d9O1mEE  reason: not valid java name */
    public final long m1718getSelectiond9O1mEE() {
        return this.selection;
    }

    private TextFieldValue(AnnotatedString annotatedString, long j, TextRange textRange) {
        Intrinsics.checkNotNullParameter(annotatedString, "annotatedString");
        this.annotatedString = annotatedString;
        this.selection = TextRangeKt.m1591coerceIn8ffj60Q(j, 0, getText().length());
        this.composition = textRange != null ? TextRange.m1573boximpl(TextRangeKt.m1591coerceIn8ffj60Q(textRange.m1589unboximpl(), 0, getText().length())) : null;
    }

    public /* synthetic */ TextFieldValue(AnnotatedString annotatedString, long j, TextRange textRange, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, (i & 2) != 0 ? TextRange.Companion.m1590getZerod9O1mEE() : j, (i & 4) != 0 ? null : textRange, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ TextFieldValue(String str, long j, TextRange textRange, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? TextRange.Companion.m1590getZerod9O1mEE() : j, (i & 4) != 0 ? null : textRange, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    private TextFieldValue(String text, long j, TextRange textRange) {
        this(new AnnotatedString(text, null, null, 6, null), j, textRange, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(text, "text");
    }

    public final String getText() {
        return this.annotatedString.getText();
    }

    /* renamed from: copy-3r_uNRQ$default  reason: not valid java name */
    public static /* synthetic */ TextFieldValue m1715copy3r_uNRQ$default(TextFieldValue textFieldValue, AnnotatedString annotatedString, long j, TextRange textRange, int i, Object obj) {
        if ((i & 1) != 0) {
            annotatedString = textFieldValue.annotatedString;
        }
        if ((i & 2) != 0) {
            j = textFieldValue.selection;
        }
        if ((i & 4) != 0) {
            textRange = textFieldValue.composition;
        }
        return textFieldValue.m1716copy3r_uNRQ(annotatedString, j, textRange);
    }

    /* renamed from: copy-3r_uNRQ  reason: not valid java name */
    public final TextFieldValue m1716copy3r_uNRQ(AnnotatedString annotatedString, long j, TextRange textRange) {
        Intrinsics.checkNotNullParameter(annotatedString, "annotatedString");
        return new TextFieldValue(annotatedString, j, textRange, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TextFieldValue) {
            TextFieldValue textFieldValue = (TextFieldValue) obj;
            return TextRange.m1578equalsimpl0(this.selection, textFieldValue.selection) && Intrinsics.areEqual(this.composition, textFieldValue.composition) && Intrinsics.areEqual(this.annotatedString, textFieldValue.annotatedString);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((this.annotatedString.hashCode() * 31) + TextRange.m1586hashCodeimpl(this.selection)) * 31;
        TextRange textRange = this.composition;
        return hashCode + (textRange != null ? TextRange.m1586hashCodeimpl(textRange.m1589unboximpl()) : 0);
    }

    public String toString() {
        return "TextFieldValue(text='" + ((Object) this.annotatedString) + "', selection=" + ((Object) TextRange.m1588toStringimpl(this.selection)) + ", composition=" + this.composition + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
