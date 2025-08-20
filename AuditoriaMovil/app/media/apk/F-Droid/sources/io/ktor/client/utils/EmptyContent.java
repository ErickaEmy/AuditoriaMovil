package io.ktor.client.utils;

import io.ktor.http.content.OutgoingContent;
/* compiled from: Content.kt */
/* loaded from: classes.dex */
public final class EmptyContent extends OutgoingContent.NoContent {
    public static final EmptyContent INSTANCE = new EmptyContent();
    private static final long contentLength = 0;

    public String toString() {
        return "EmptyContent";
    }

    private EmptyContent() {
    }

    @Override // io.ktor.http.content.OutgoingContent
    public Long getContentLength() {
        return Long.valueOf(contentLength);
    }
}
