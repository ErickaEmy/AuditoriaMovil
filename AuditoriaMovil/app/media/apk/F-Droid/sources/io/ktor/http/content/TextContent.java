package io.ktor.http.content;

import ch.qos.logback.core.CoreConstants;
import io.ktor.http.ContentType;
import io.ktor.http.ContentTypesKt;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.content.OutgoingContent;
import io.ktor.utils.io.charsets.CharsetJVMKt;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt___StringsKt;
/* compiled from: TextContent.kt */
/* loaded from: classes.dex */
public final class TextContent extends OutgoingContent.ByteArrayContent {
    private final byte[] bytes;
    private final ContentType contentType;
    private final HttpStatusCode status;
    private final String text;

    @Override // io.ktor.http.content.OutgoingContent.ByteArrayContent
    public byte[] bytes() {
        return this.bytes;
    }

    @Override // io.ktor.http.content.OutgoingContent
    public ContentType getContentType() {
        return this.contentType;
    }

    public /* synthetic */ TextContent(String str, ContentType contentType, HttpStatusCode httpStatusCode, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, contentType, (i & 4) != 0 ? null : httpStatusCode);
    }

    public TextContent(String text, ContentType contentType, HttpStatusCode httpStatusCode) {
        byte[] encodeToByteArray;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        this.text = text;
        this.contentType = contentType;
        this.status = httpStatusCode;
        Charset charset = ContentTypesKt.charset(getContentType());
        charset = charset == null ? Charsets.UTF_8 : charset;
        if (Intrinsics.areEqual(charset, Charsets.UTF_8)) {
            encodeToByteArray = StringsKt__StringsJVMKt.encodeToByteArray(text);
        } else {
            CharsetEncoder newEncoder = charset.newEncoder();
            Intrinsics.checkNotNullExpressionValue(newEncoder, "charset.newEncoder()");
            encodeToByteArray = CharsetJVMKt.encodeToByteArray(newEncoder, text, 0, text.length());
        }
        this.bytes = encodeToByteArray;
    }

    @Override // io.ktor.http.content.OutgoingContent
    public Long getContentLength() {
        return Long.valueOf(this.bytes.length);
    }

    public String toString() {
        String take;
        StringBuilder sb = new StringBuilder();
        sb.append("TextContent[");
        sb.append(getContentType());
        sb.append("] \"");
        take = StringsKt___StringsKt.take(this.text, 30);
        sb.append(take);
        sb.append(CoreConstants.DOUBLE_QUOTE_CHAR);
        return sb.toString();
    }
}
