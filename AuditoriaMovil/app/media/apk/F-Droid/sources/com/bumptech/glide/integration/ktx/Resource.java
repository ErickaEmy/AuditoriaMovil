package com.bumptech.glide.integration.ktx;

import ch.qos.logback.core.CoreConstants;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Flows.kt */
/* loaded from: classes.dex */
public final class Resource extends GlideFlowInstant {
    private final Object resource;
    private final Status status;

    /* compiled from: Flows.kt */
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Status.values().length];
            iArr[Status.SUCCEEDED.ordinal()] = 1;
            iArr[Status.RUNNING.ordinal()] = 2;
            iArr[Status.FAILED.ordinal()] = 3;
            iArr[Status.CLEARED.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Resource) {
            Resource resource = (Resource) obj;
            return getStatus() == resource.getStatus() && Intrinsics.areEqual(this.resource, resource.resource);
        }
        return false;
    }

    public final Object getResource() {
        return this.resource;
    }

    @Override // com.bumptech.glide.integration.ktx.GlideFlowInstant
    public Status getStatus() {
        return this.status;
    }

    public int hashCode() {
        int hashCode = getStatus().hashCode() * 31;
        Object obj = this.resource;
        return hashCode + (obj == null ? 0 : obj.hashCode());
    }

    public String toString() {
        return "Resource(status=" + getStatus() + ", resource=" + this.resource + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Resource(Status status, Object obj) {
        super(null);
        Intrinsics.checkNotNullParameter(status, "status");
        this.status = status;
        this.resource = obj;
        int i = WhenMappings.$EnumSwitchMapping$0[getStatus().ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            return;
        }
        if (i == 4) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        throw new NoWhenBranchMatchedException();
    }
}
