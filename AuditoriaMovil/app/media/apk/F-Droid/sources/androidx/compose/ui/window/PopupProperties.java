package androidx.compose.ui.window;

import androidx.compose.foundation.ClickableElement$$ExternalSyntheticBackport0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AndroidPopup.android.kt */
/* loaded from: classes.dex */
public final class PopupProperties {
    private final boolean clippingEnabled;
    private final boolean dismissOnBackPress;
    private final boolean dismissOnClickOutside;
    private final boolean excludeFromSystemGesture;
    private final boolean focusable;
    private final SecureFlagPolicy securePolicy;
    private final boolean usePlatformDefaultWidth;

    public final boolean getClippingEnabled() {
        return this.clippingEnabled;
    }

    public final boolean getDismissOnBackPress() {
        return this.dismissOnBackPress;
    }

    public final boolean getDismissOnClickOutside() {
        return this.dismissOnClickOutside;
    }

    public final boolean getExcludeFromSystemGesture() {
        return this.excludeFromSystemGesture;
    }

    public final boolean getFocusable() {
        return this.focusable;
    }

    public final SecureFlagPolicy getSecurePolicy() {
        return this.securePolicy;
    }

    public final boolean getUsePlatformDefaultWidth() {
        return this.usePlatformDefaultWidth;
    }

    public PopupProperties(boolean z, boolean z2, boolean z3, SecureFlagPolicy securePolicy, boolean z4, boolean z5, boolean z6) {
        Intrinsics.checkNotNullParameter(securePolicy, "securePolicy");
        this.focusable = z;
        this.dismissOnBackPress = z2;
        this.dismissOnClickOutside = z3;
        this.securePolicy = securePolicy;
        this.excludeFromSystemGesture = z4;
        this.clippingEnabled = z5;
        this.usePlatformDefaultWidth = z6;
    }

    public /* synthetic */ PopupProperties(boolean z, boolean z2, boolean z3, SecureFlagPolicy secureFlagPolicy, boolean z4, boolean z5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? true : z2, (i & 4) != 0 ? true : z3, (i & 8) != 0 ? SecureFlagPolicy.Inherit : secureFlagPolicy, (i & 16) != 0 ? true : z4, (i & 32) == 0 ? z5 : true);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PopupProperties(boolean z, boolean z2, boolean z3, SecureFlagPolicy securePolicy, boolean z4, boolean z5) {
        this(z, z2, z3, securePolicy, z4, z5, false);
        Intrinsics.checkNotNullParameter(securePolicy, "securePolicy");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PopupProperties) {
            PopupProperties popupProperties = (PopupProperties) obj;
            return this.focusable == popupProperties.focusable && this.dismissOnBackPress == popupProperties.dismissOnBackPress && this.dismissOnClickOutside == popupProperties.dismissOnClickOutside && this.securePolicy == popupProperties.securePolicy && this.excludeFromSystemGesture == popupProperties.excludeFromSystemGesture && this.clippingEnabled == popupProperties.clippingEnabled && this.usePlatformDefaultWidth == popupProperties.usePlatformDefaultWidth;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((ClickableElement$$ExternalSyntheticBackport0.m(this.dismissOnBackPress) * 31) + ClickableElement$$ExternalSyntheticBackport0.m(this.focusable)) * 31) + ClickableElement$$ExternalSyntheticBackport0.m(this.dismissOnBackPress)) * 31) + ClickableElement$$ExternalSyntheticBackport0.m(this.dismissOnClickOutside)) * 31) + this.securePolicy.hashCode()) * 31) + ClickableElement$$ExternalSyntheticBackport0.m(this.excludeFromSystemGesture)) * 31) + ClickableElement$$ExternalSyntheticBackport0.m(this.clippingEnabled)) * 31) + ClickableElement$$ExternalSyntheticBackport0.m(this.usePlatformDefaultWidth);
    }
}
