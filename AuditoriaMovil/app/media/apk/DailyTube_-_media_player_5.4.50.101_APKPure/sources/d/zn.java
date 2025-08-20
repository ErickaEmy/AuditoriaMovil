package d;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public final class zn {
    public static final ThreadLocal<TypedValue> y = new ThreadLocal<>();

    public static boolean a(@NonNull Resources resources, int i) {
        TypedValue zn2 = zn();
        resources.getValue(i, zn2, true);
        int i5 = zn2.type;
        if (i5 >= 28 && i5 <= 31) {
            return true;
        }
        return false;
    }

    public static int fb(int i, float f4, float f6) {
        boolean z2;
        if (f6 >= 0.0f && f6 <= 100.0f) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (f4 == 1.0f && !z2) {
            return i;
        }
        int n32 = a8.y.n3((int) ((Color.alpha(i) * f4) + 0.5f), 0, 255);
        if (z2) {
            y zn2 = y.zn(i);
            i = y.tl(zn2.i9(), zn2.c5(), f6);
        }
        return (i & 16777215) | (n32 << 24);
    }

    @Nullable
    public static ColorStateList gv(@NonNull Resources resources, int i, @Nullable Resources.Theme theme) {
        try {
            return y(resources, resources.getXml(i), theme);
        } catch (Exception e2) {
            Log.e("CSLCompat", "Failed to inflate ColorStateList.", e2);
            return null;
        }
    }

    @NonNull
    public static ColorStateList n3(@NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        String name = xmlPullParser.getName();
        if (name.equals("selector")) {
            return v(resources, xmlPullParser, attributeSet, theme);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid color state list tag " + name);
    }

    public static TypedArray s(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, iArr);
        }
        return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.content.res.ColorStateList v(@androidx.annotation.NonNull android.content.res.Resources r17, @androidx.annotation.NonNull org.xmlpull.v1.XmlPullParser r18, @androidx.annotation.NonNull android.util.AttributeSet r19, @androidx.annotation.Nullable android.content.res.Resources.Theme r20) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 253
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d.zn.v(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):android.content.res.ColorStateList");
    }

    @NonNull
    public static ColorStateList y(@NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return n3(resources, xmlPullParser, asAttributeSet, theme);
        }
        throw new XmlPullParserException("No start tag found");
    }

    @NonNull
    public static TypedValue zn() {
        ThreadLocal<TypedValue> threadLocal = y;
        TypedValue typedValue = threadLocal.get();
        if (typedValue == null) {
            TypedValue typedValue2 = new TypedValue();
            threadLocal.set(typedValue2);
            return typedValue2;
        }
        return typedValue;
    }
}
