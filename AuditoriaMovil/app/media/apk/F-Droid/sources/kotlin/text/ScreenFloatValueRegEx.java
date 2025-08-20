package kotlin.text;

import ch.qos.logback.core.CoreConstants;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StringNumberConversionsJVM.kt */
/* loaded from: classes2.dex */
public final class ScreenFloatValueRegEx {
    public static final ScreenFloatValueRegEx INSTANCE = new ScreenFloatValueRegEx();
    public static final Regex value;

    private ScreenFloatValueRegEx() {
    }

    static {
        String str = "[eE][+-]?(\\p{Digit}+)";
        value = new Regex("[\\x00-\\x20]*[+-]?(NaN|Infinity|((" + (CoreConstants.LEFT_PARENTHESIS_CHAR + "(\\p{Digit}+)(\\.)?((\\p{Digit}+)?)(" + str + ")?)|(\\.((\\p{Digit}+))(" + str + ")?)|((" + ("(0[xX](\\p{XDigit}+)(\\.)?)|(0[xX](\\p{XDigit}+)?(\\.)(\\p{XDigit}+)" + CoreConstants.RIGHT_PARENTHESIS_CHAR) + ")[pP][+-]?(\\p{Digit}+)" + CoreConstants.RIGHT_PARENTHESIS_CHAR) + ")[fFdD]?))[\\x00-\\x20]*");
    }
}
