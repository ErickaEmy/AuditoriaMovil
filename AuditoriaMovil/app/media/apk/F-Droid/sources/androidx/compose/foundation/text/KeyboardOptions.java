package androidx.compose.foundation.text;

import androidx.compose.foundation.ClickableElement$$ExternalSyntheticBackport0;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.KeyboardCapitalization;
import androidx.compose.ui.text.input.KeyboardType;
import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: KeyboardOptions.kt */
/* loaded from: classes.dex */
public final class KeyboardOptions {
    public static final Companion Companion = new Companion(null);
    private static final KeyboardOptions Default = new KeyboardOptions(0, false, 0, 0, 15, null);
    private final boolean autoCorrect;
    private final int capitalization;
    private final int imeAction;
    private final int keyboardType;

    public /* synthetic */ KeyboardOptions(int i, boolean z, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, z, i2, i3);
    }

    private KeyboardOptions(int i, boolean z, int i2, int i3) {
        this.capitalization = i;
        this.autoCorrect = z;
        this.keyboardType = i2;
        this.imeAction = i3;
    }

    public /* synthetic */ KeyboardOptions(int i, boolean z, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? KeyboardCapitalization.Companion.m1699getNoneIUNYP9k() : i, (i4 & 2) != 0 ? true : z, (i4 & 4) != 0 ? KeyboardType.Companion.m1713getTextPjHm6EE() : i2, (i4 & 8) != 0 ? ImeAction.Companion.m1682getDefaulteUduSuo() : i3, null);
    }

    /* compiled from: KeyboardOptions.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KeyboardOptions getDefault() {
            return KeyboardOptions.Default;
        }
    }

    public final ImeOptions toImeOptions$foundation_release(boolean z) {
        return new ImeOptions(z, this.capitalization, this.autoCorrect, this.keyboardType, this.imeAction, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof KeyboardOptions) {
            KeyboardOptions keyboardOptions = (KeyboardOptions) obj;
            return KeyboardCapitalization.m1695equalsimpl0(this.capitalization, keyboardOptions.capitalization) && this.autoCorrect == keyboardOptions.autoCorrect && KeyboardType.m1703equalsimpl0(this.keyboardType, keyboardOptions.keyboardType) && ImeAction.m1678equalsimpl0(this.imeAction, keyboardOptions.imeAction);
        }
        return false;
    }

    public int hashCode() {
        return (((((KeyboardCapitalization.m1696hashCodeimpl(this.capitalization) * 31) + ClickableElement$$ExternalSyntheticBackport0.m(this.autoCorrect)) * 31) + KeyboardType.m1704hashCodeimpl(this.keyboardType)) * 31) + ImeAction.m1679hashCodeimpl(this.imeAction);
    }

    public String toString() {
        return "KeyboardOptions(capitalization=" + ((Object) KeyboardCapitalization.m1697toStringimpl(this.capitalization)) + ", autoCorrect=" + this.autoCorrect + ", keyboardType=" + ((Object) KeyboardType.m1705toStringimpl(this.keyboardType)) + ", imeAction=" + ((Object) ImeAction.m1680toStringimpl(this.imeAction)) + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
