package androidx.compose.ui.graphics.colorspace;

import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ColorSpace.kt */
/* loaded from: classes.dex */
public abstract class ColorSpace {
    public static final Companion Companion = new Companion(null);
    private final int id;
    private final long model;
    private final String name;

    /* compiled from: ColorSpace.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ ColorSpace(String str, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, i);
    }

    public final int getId$ui_graphics_release() {
        return this.id;
    }

    public abstract float getMaxValue(int i);

    public abstract float getMinValue(int i);

    /* renamed from: getModel-xdoWZVw  reason: not valid java name */
    public final long m1002getModelxdoWZVw() {
        return this.model;
    }

    public final String getName() {
        return this.name;
    }

    public boolean isSrgb() {
        return false;
    }

    public abstract long toXy$ui_graphics_release(float f, float f2, float f3);

    public abstract float toZ$ui_graphics_release(float f, float f2, float f3);

    /* renamed from: xyzaToColor-JlNiLsg$ui_graphics_release  reason: not valid java name */
    public abstract long mo1003xyzaToColorJlNiLsg$ui_graphics_release(float f, float f2, float f3, float f4, ColorSpace colorSpace);

    private ColorSpace(String name, long j, int i) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.model = j;
        this.id = i;
        if (name.length() == 0) {
            throw new IllegalArgumentException("The name of a color space cannot be null and must contain at least 1 character");
        }
        if (i < -1 || i > 63) {
            throw new IllegalArgumentException("The id must be between -1 and 63");
        }
    }

    public final int getComponentCount() {
        return ColorModel.m996getComponentCountimpl(this.model);
    }

    public String toString() {
        return this.name + " (id=" + this.id + ", model=" + ((Object) ColorModel.m998toStringimpl(this.model)) + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ColorSpace colorSpace = (ColorSpace) obj;
        if (this.id == colorSpace.id && Intrinsics.areEqual(this.name, colorSpace.name)) {
            return ColorModel.m995equalsimpl0(this.model, colorSpace.model);
        }
        return false;
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + ColorModel.m997hashCodeimpl(this.model)) * 31) + this.id;
    }
}
