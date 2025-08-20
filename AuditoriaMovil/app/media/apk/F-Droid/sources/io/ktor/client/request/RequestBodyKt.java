package io.ktor.client.request;

import io.ktor.util.AttributeKey;
/* compiled from: RequestBody.kt */
/* loaded from: classes.dex */
public abstract class RequestBodyKt {
    private static final AttributeKey BodyTypeAttributeKey = new AttributeKey("BodyTypeAttributeKey");

    public static final AttributeKey getBodyTypeAttributeKey() {
        return BodyTypeAttributeKey;
    }
}
