package org.slf4j.helpers;
/* loaded from: classes2.dex */
public class FormattingTuple {
    public static FormattingTuple NULL = new FormattingTuple(null);
    private final Object[] argArray;
    private final String message;
    private final Throwable throwable;

    public String getMessage() {
        return this.message;
    }

    public FormattingTuple(String str) {
        this(str, null, null);
    }

    public FormattingTuple(String str, Object[] objArr, Throwable th) {
        this.message = str;
        this.throwable = th;
        this.argArray = objArr;
    }
}
