package io.ktor.http;

import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
/* compiled from: HeaderValueWithParameters.kt */
/* loaded from: classes.dex */
public abstract class HeaderValueWithParameters {
    public static final Companion Companion = new Companion(null);
    private final String content;
    private final List parameters;

    /* compiled from: HeaderValueWithParameters.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String getContent() {
        return this.content;
    }

    public final List getParameters() {
        return this.parameters;
    }

    public HeaderValueWithParameters(String content, List parameters) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        this.content = content;
        this.parameters = parameters;
    }

    public final String parameter(String name) {
        int lastIndex;
        boolean equals;
        Intrinsics.checkNotNullParameter(name, "name");
        lastIndex = CollectionsKt__CollectionsKt.getLastIndex(this.parameters);
        if (lastIndex < 0) {
            return null;
        }
        int i = 0;
        while (true) {
            HeaderValueParam headerValueParam = (HeaderValueParam) this.parameters.get(i);
            equals = StringsKt__StringsJVMKt.equals(headerValueParam.getName(), name, true);
            if (equals) {
                return headerValueParam.getValue();
            }
            if (i == lastIndex) {
                return null;
            }
            i++;
        }
    }

    public String toString() {
        int lastIndex;
        boolean needQuotes;
        if (this.parameters.isEmpty()) {
            return this.content;
        }
        int length = this.content.length();
        int i = 0;
        int i2 = 0;
        for (HeaderValueParam headerValueParam : this.parameters) {
            i2 += headerValueParam.getName().length() + headerValueParam.getValue().length() + 3;
        }
        StringBuilder sb = new StringBuilder(length + i2);
        sb.append(this.content);
        lastIndex = CollectionsKt__CollectionsKt.getLastIndex(this.parameters);
        if (lastIndex >= 0) {
            while (true) {
                HeaderValueParam headerValueParam2 = (HeaderValueParam) this.parameters.get(i);
                sb.append("; ");
                sb.append(headerValueParam2.getName());
                sb.append("=");
                String value = headerValueParam2.getValue();
                needQuotes = HeaderValueWithParametersKt.needQuotes(value);
                if (needQuotes) {
                    sb.append(HeaderValueWithParametersKt.quote(value));
                } else {
                    sb.append(value);
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "{\n            val size =…   }.toString()\n        }");
        return sb2;
    }
}
