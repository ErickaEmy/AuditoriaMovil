package ch.qos.logback.core.pattern.parser;

import ch.qos.logback.core.pattern.FormatInfo;
/* loaded from: classes.dex */
public class FormattingNode extends Node {
    FormatInfo formatInfo;

    FormattingNode(int i) {
        super(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FormattingNode(int i, Object obj) {
        super(i, obj);
    }

    @Override // ch.qos.logback.core.pattern.parser.Node
    public boolean equals(Object obj) {
        if (super.equals(obj) && (obj instanceof FormattingNode)) {
            FormatInfo formatInfo = this.formatInfo;
            FormatInfo formatInfo2 = ((FormattingNode) obj).formatInfo;
            return formatInfo != null ? formatInfo.equals(formatInfo2) : formatInfo2 == null;
        }
        return false;
    }

    public FormatInfo getFormatInfo() {
        return this.formatInfo;
    }

    @Override // ch.qos.logback.core.pattern.parser.Node
    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        FormatInfo formatInfo = this.formatInfo;
        return hashCode + (formatInfo != null ? formatInfo.hashCode() : 0);
    }

    public void setFormatInfo(FormatInfo formatInfo) {
        this.formatInfo = formatInfo;
    }
}
