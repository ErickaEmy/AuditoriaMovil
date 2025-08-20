package io.ktor.http.content;

import io.ktor.http.ContentType;
import io.ktor.http.Headers;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: OutgoingContent.kt */
/* loaded from: classes.dex */
public abstract class OutgoingContent {
    private OutgoingContent() {
    }

    public /* synthetic */ OutgoingContent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract Long getContentLength();

    public ContentType getContentType() {
        return null;
    }

    public Headers getHeaders() {
        return Headers.Companion.getEmpty();
    }

    /* compiled from: OutgoingContent.kt */
    /* loaded from: classes.dex */
    public static abstract class NoContent extends OutgoingContent {
        public NoContent() {
            super(null);
        }
    }

    /* compiled from: OutgoingContent.kt */
    /* loaded from: classes.dex */
    public static abstract class ReadChannelContent extends OutgoingContent {
        public abstract ByteReadChannel readFrom();

        public ReadChannelContent() {
            super(null);
        }
    }

    /* compiled from: OutgoingContent.kt */
    /* loaded from: classes.dex */
    public static abstract class ByteArrayContent extends OutgoingContent {
        public abstract byte[] bytes();

        public ByteArrayContent() {
            super(null);
        }
    }
}
