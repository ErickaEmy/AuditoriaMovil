package androidx.compose.ui.platform;

import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.i18n.TextBundle;
/* compiled from: AccessibilityIterators.android.kt */
/* loaded from: classes.dex */
public abstract class AccessibilityIterators$AbstractTextSegmentIterator implements AccessibilityIterators$TextSegmentIterator {
    private final int[] segment = new int[2];
    protected String text;

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.text = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String getText() {
        String str = this.text;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException(TextBundle.TEXT_ENTRY);
        return null;
    }

    public void initialize(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        setText(text);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int[] getRange(int i, int i2) {
        if (i < 0 || i2 < 0 || i == i2) {
            return null;
        }
        int[] iArr = this.segment;
        iArr[0] = i;
        iArr[1] = i2;
        return iArr;
    }
}
