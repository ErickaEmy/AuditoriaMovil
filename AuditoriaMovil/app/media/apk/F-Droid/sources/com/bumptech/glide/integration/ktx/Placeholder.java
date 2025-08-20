package com.bumptech.glide.integration.ktx;

import android.graphics.drawable.Drawable;
import ch.qos.logback.core.CoreConstants;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Flows.kt */
/* loaded from: classes.dex */
public final class Placeholder extends GlideFlowInstant {
    private final Drawable placeholder;
    private final Status status;

    /* compiled from: Flows.kt */
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Status.values().length];
            iArr[Status.SUCCEEDED.ordinal()] = 1;
            iArr[Status.CLEARED.ordinal()] = 2;
            iArr[Status.RUNNING.ordinal()] = 3;
            iArr[Status.FAILED.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Placeholder) {
            Placeholder placeholder = (Placeholder) obj;
            return getStatus() == placeholder.getStatus() && Intrinsics.areEqual(this.placeholder, placeholder.placeholder);
        }
        return false;
    }

    public final Drawable getPlaceholder() {
        return this.placeholder;
    }

    @Override // com.bumptech.glide.integration.ktx.GlideFlowInstant
    public Status getStatus() {
        return this.status;
    }

    public int hashCode() {
        int hashCode = getStatus().hashCode() * 31;
        Drawable drawable = this.placeholder;
        return hashCode + (drawable == null ? 0 : drawable.hashCode());
    }

    public String toString() {
        return "Placeholder(status=" + getStatus() + ", placeholder=" + this.placeholder + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Placeholder(Status status, Drawable drawable) {
        super(null);
        Intrinsics.checkNotNullParameter(status, "status");
        this.status = status;
        this.placeholder = drawable;
        int i = WhenMappings.$EnumSwitchMapping$0[getStatus().ordinal()];
        if (i == 1) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (i != 2 && i != 3 && i != 4) {
            throw new NoWhenBranchMatchedException();
        }
    }
}
