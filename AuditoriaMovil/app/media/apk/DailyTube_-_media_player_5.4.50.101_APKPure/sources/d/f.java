package d;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.xmlpull.v1.XmlPullParser;
/* loaded from: classes.dex */
public class f {
    public static float a(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, int i, float f4) {
        if (!i9(xmlPullParser, str)) {
            return f4;
        }
        return typedArray.getFloat(i, f4);
    }

    @Nullable
    public static String c5(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, int i) {
        if (!i9(xmlPullParser, str)) {
            return null;
        }
        return typedArray.getString(i);
    }

    @NonNull
    public static TypedArray f(@NonNull Resources resources, @Nullable Resources.Theme theme, @NonNull AttributeSet attributeSet, @NonNull int[] iArr) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, iArr);
        }
        return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    public static int fb(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, int i, int i5) {
        if (!i9(xmlPullParser, str)) {
            return i5;
        }
        return typedArray.getInt(i, i5);
    }

    @NonNull
    public static ColorStateList gv(@NonNull TypedValue typedValue) {
        return ColorStateList.valueOf(typedValue.data);
    }

    public static boolean i9(@NonNull XmlPullParser xmlPullParser, @NonNull String str) {
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null) {
            return true;
        }
        return false;
    }

    public static int n3(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, int i, int i5) {
        if (!i9(xmlPullParser, str)) {
            return i5;
        }
        return typedArray.getColor(i, i5);
    }

    public static int s(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, int i, int i5) {
        if (!i9(xmlPullParser, str)) {
            return i5;
        }
        return typedArray.getResourceId(i, i5);
    }

    @Nullable
    public static TypedValue t(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, int i) {
        if (!i9(xmlPullParser, str)) {
            return null;
        }
        return typedArray.peekValue(i);
    }

    public static gv v(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @Nullable Resources.Theme theme, @NonNull String str, int i, int i5) {
        if (i9(xmlPullParser, str)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i, typedValue);
            int i6 = typedValue.type;
            if (i6 >= 28 && i6 <= 31) {
                return gv.n3(typedValue.data);
            }
            gv fb2 = gv.fb(typedArray.getResources(), typedArray.getResourceId(i, 0), theme);
            if (fb2 != null) {
                return fb2;
            }
        }
        return gv.n3(i5);
    }

    public static boolean y(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, int i, boolean z2) {
        if (!i9(xmlPullParser, str)) {
            return z2;
        }
        return typedArray.getBoolean(i, z2);
    }

    @Nullable
    public static ColorStateList zn(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @Nullable Resources.Theme theme, @NonNull String str, int i) {
        if (i9(xmlPullParser, str)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i, typedValue);
            int i5 = typedValue.type;
            if (i5 != 2) {
                if (i5 >= 28 && i5 <= 31) {
                    return gv(typedValue);
                }
                return zn.gv(typedArray.getResources(), typedArray.getResourceId(i, 0), theme);
            }
            throw new UnsupportedOperationException("Failed to resolve attribute at index " + i + ": " + typedValue);
        }
        return null;
    }
}
