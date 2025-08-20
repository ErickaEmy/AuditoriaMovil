package d;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public final class gv {

    /* renamed from: n3  reason: collision with root package name */
    public final ColorStateList f6911n3;
    public final Shader y;

    /* renamed from: zn  reason: collision with root package name */
    public int f6912zn;

    public gv(Shader shader, ColorStateList colorStateList, int i) {
        this.y = shader;
        this.f6911n3 = colorStateList;
        this.f6912zn = i;
    }

    @Nullable
    public static gv fb(@NonNull Resources resources, int i, @Nullable Resources.Theme theme) {
        try {
            return y(resources, i, theme);
        } catch (Exception e2) {
            Log.e("ComplexColorCompat", "Failed to inflate ComplexColor.", e2);
            return null;
        }
    }

    public static gv gv(@NonNull Shader shader) {
        return new gv(shader, null, 0);
    }

    public static gv n3(int i) {
        return new gv(null, null, i);
    }

    @NonNull
    public static gv y(@NonNull Resources resources, int i, @Nullable Resources.Theme theme) throws IOException, XmlPullParserException {
        int next;
        XmlResourceParser xml = resources.getXml(i);
        AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
        do {
            next = xml.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            String name = xml.getName();
            name.hashCode();
            if (!name.equals("gradient")) {
                if (name.equals("selector")) {
                    return zn(zn.n3(resources, xml, asAttributeSet, theme));
                }
                throw new XmlPullParserException(xml.getPositionDescription() + ": unsupported complex color tag " + name);
            }
            return gv(a.n3(resources, xml, asAttributeSet, theme));
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static gv zn(@NonNull ColorStateList colorStateList) {
        return new gv(null, colorStateList, colorStateList.getDefaultColor());
    }

    @Nullable
    public Shader a() {
        return this.y;
    }

    public boolean c5() {
        ColorStateList colorStateList;
        if (this.y == null && (colorStateList = this.f6911n3) != null && colorStateList.isStateful()) {
            return true;
        }
        return false;
    }

    public void f(int i) {
        this.f6912zn = i;
    }

    public boolean i9(int[] iArr) {
        if (c5()) {
            ColorStateList colorStateList = this.f6911n3;
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (colorForState != this.f6912zn) {
                this.f6912zn = colorForState;
                return true;
            }
        }
        return false;
    }

    public boolean s() {
        if (this.y != null) {
            return true;
        }
        return false;
    }

    public boolean t() {
        if (!s() && this.f6912zn == 0) {
            return false;
        }
        return true;
    }

    public int v() {
        return this.f6912zn;
    }
}
