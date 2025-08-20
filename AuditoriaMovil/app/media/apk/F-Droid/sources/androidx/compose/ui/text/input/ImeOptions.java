package androidx.compose.ui.text.input;

import androidx.compose.foundation.ClickableElement$$ExternalSyntheticBackport0;
import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: ImeOptions.kt */
/* loaded from: classes.dex */
public final class ImeOptions {
    public static final Companion Companion = new Companion(null);
    private static final ImeOptions Default = new ImeOptions(false, 0, false, 0, 0, 31, null);
    private final boolean autoCorrect;
    private final int capitalization;
    private final int imeAction;
    private final int keyboardType;
    private final boolean singleLine;

    public /* synthetic */ ImeOptions(boolean z, int i, boolean z2, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, i, z2, i2, i3);
    }

    public final boolean getAutoCorrect() {
        return this.autoCorrect;
    }

    /* renamed from: getCapitalization-IUNYP9k  reason: not valid java name */
    public final int m1690getCapitalizationIUNYP9k() {
        return this.capitalization;
    }

    /* renamed from: getImeAction-eUduSuo  reason: not valid java name */
    public final int m1691getImeActioneUduSuo() {
        return this.imeAction;
    }

    /* renamed from: getKeyboardType-PjHm6EE  reason: not valid java name */
    public final int m1692getKeyboardTypePjHm6EE() {
        return this.keyboardType;
    }

    public final boolean getSingleLine() {
        return this.singleLine;
    }

    private ImeOptions(boolean z, int i, boolean z2, int i2, int i3) {
        this.singleLine = z;
        this.capitalization = i;
        this.autoCorrect = z2;
        this.keyboardType = i2;
        this.imeAction = i3;
    }

    public /* synthetic */ ImeOptions(boolean z, int i, boolean z2, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? false : z, (i4 & 2) != 0 ? KeyboardCapitalization.Companion.m1699getNoneIUNYP9k() : i, (i4 & 4) != 0 ? true : z2, (i4 & 8) != 0 ? KeyboardType.Companion.m1713getTextPjHm6EE() : i2, (i4 & 16) != 0 ? ImeAction.Companion.m1682getDefaulteUduSuo() : i3, null);
    }

    /* compiled from: ImeOptions.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ImeOptions getDefault() {
            return ImeOptions.Default;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ImeOptions) {
            ImeOptions imeOptions = (ImeOptions) obj;
            return this.singleLine == imeOptions.singleLine && KeyboardCapitalization.m1695equalsimpl0(this.capitalization, imeOptions.capitalization) && this.autoCorrect == imeOptions.autoCorrect && KeyboardType.m1703equalsimpl0(this.keyboardType, imeOptions.keyboardType) && ImeAction.m1678equalsimpl0(this.imeAction, imeOptions.imeAction);
        }
        return false;
    }

    public int hashCode() {
        return (((((((ClickableElement$$ExternalSyntheticBackport0.m(this.singleLine) * 31) + KeyboardCapitalization.m1696hashCodeimpl(this.capitalization)) * 31) + ClickableElement$$ExternalSyntheticBackport0.m(this.autoCorrect)) * 31) + KeyboardType.m1704hashCodeimpl(this.keyboardType)) * 31) + ImeAction.m1679hashCodeimpl(this.imeAction);
    }

    public String toString() {
        return "ImeOptions(singleLine=" + this.singleLine + ", capitalization=" + ((Object) KeyboardCapitalization.m1697toStringimpl(this.capitalization)) + ", autoCorrect=" + this.autoCorrect + ", keyboardType=" + ((Object) KeyboardType.m1705toStringimpl(this.keyboardType)) + ", imeAction=" + ((Object) ImeAction.m1680toStringimpl(this.imeAction)) + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
