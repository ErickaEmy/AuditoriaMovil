package com.bumptech.glide.integration.ktx;

import ch.qos.logback.core.CoreConstants;
/* compiled from: Flows.kt */
/* loaded from: classes.dex */
public final class Size {
    private final int height;
    private final int width;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Size) {
            Size size = (Size) obj;
            return this.width == size.width && this.height == size.height;
        }
        return false;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        return (this.width * 31) + this.height;
    }

    public String toString() {
        return "Size(width=" + this.width + ", height=" + this.height + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public Size(int i, int i2) {
        this.width = i;
        this.height = i2;
        if (!FlowsKt.isValidGlideDimension(i)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (!FlowsKt.isValidGlideDimension(i2)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }
}
