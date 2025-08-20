package com.bumptech.glide.integration.compose;

import androidx.compose.ui.Modifier;
import ch.qos.logback.core.CoreConstants;
import com.bumptech.glide.integration.ktx.ResolvableGlideSize;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: GlideImage.kt */
/* loaded from: classes.dex */
final class SizeAndModifier {
    private final Modifier modifier;
    private final ResolvableGlideSize size;

    public final ResolvableGlideSize component1() {
        return this.size;
    }

    public final Modifier component2() {
        return this.modifier;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SizeAndModifier) {
            SizeAndModifier sizeAndModifier = (SizeAndModifier) obj;
            return Intrinsics.areEqual(this.size, sizeAndModifier.size) && Intrinsics.areEqual(this.modifier, sizeAndModifier.modifier);
        }
        return false;
    }

    public int hashCode() {
        return (this.size.hashCode() * 31) + this.modifier.hashCode();
    }

    public String toString() {
        return "SizeAndModifier(size=" + this.size + ", modifier=" + this.modifier + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public SizeAndModifier(ResolvableGlideSize size, Modifier modifier) {
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        this.size = size;
        this.modifier = modifier;
    }
}
