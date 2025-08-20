package d;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.R$styleable;
import java.io.IOException;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public final class a {
    public static Shader.TileMode gv(int i) {
        if (i != 1) {
            if (i != 2) {
                return Shader.TileMode.CLAMP;
            }
            return Shader.TileMode.MIRROR;
        }
        return Shader.TileMode.REPEAT;
    }

    public static Shader n3(@NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws IOException, XmlPullParserException {
        String name = xmlPullParser.getName();
        if (name.equals("gradient")) {
            TypedArray f4 = f.f(resources, theme, attributeSet, R$styleable.f2152d0);
            float a2 = f.a(f4, xmlPullParser, "startX", R$styleable.f2146a8, 0.0f);
            float a3 = f.a(f4, xmlPullParser, "startY", R$styleable.f2179x, 0.0f);
            float a4 = f.a(f4, xmlPullParser, "endX", R$styleable.f2147b, 0.0f);
            float a5 = f.a(f4, xmlPullParser, "endY", R$styleable.f2162k5, 0.0f);
            float a6 = f.a(f4, xmlPullParser, "centerX", R$styleable.f2172ta, 0.0f);
            float a10 = f.a(f4, xmlPullParser, "centerY", R$styleable.f2151d, 0.0f);
            int fb2 = f.fb(f4, xmlPullParser, "type", R$styleable.f2163mg, 0);
            int n32 = f.n3(f4, xmlPullParser, "startColor", R$styleable.f2157fh, 0);
            boolean i92 = f.i9(xmlPullParser, "centerColor");
            int n33 = f.n3(f4, xmlPullParser, "centerColor", R$styleable.f2174ud, 0);
            int n34 = f.n3(f4, xmlPullParser, "endColor", R$styleable.f2169rz, 0);
            int fb3 = f.fb(f4, xmlPullParser, "tileMode", R$styleable.f2153ej, 0);
            float a11 = f.a(f4, xmlPullParser, "gradientRadius", R$styleable.f2184z6, 0.0f);
            f4.recycle();
            y y2 = y(zn(resources, xmlPullParser, attributeSet, theme), n32, n34, i92, n33);
            if (fb2 != 1) {
                if (fb2 != 2) {
                    return new LinearGradient(a2, a3, a4, a5, y2.y, y2.f6909n3, gv(fb3));
                }
                return new SweepGradient(a6, a10, y2.y, y2.f6909n3);
            } else if (a11 > 0.0f) {
                return new RadialGradient(a6, a10, a11, y2.y, y2.f6909n3, gv(fb3));
            } else {
                throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
            }
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid gradient color tag " + name);
    }

    public static y y(@Nullable y yVar, int i, int i5, boolean z2, int i6) {
        if (yVar != null) {
            return yVar;
        }
        if (z2) {
            return new y(i, i6, i5);
        }
        return new y(i, i5);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0080, code lost:
        throw new org.xmlpull.v1.XmlPullParserException(r10.getPositionDescription() + ": <item> tag requires a 'color' attribute and a 'offset' attribute!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static d.a.y zn(@androidx.annotation.NonNull android.content.res.Resources r9, @androidx.annotation.NonNull org.xmlpull.v1.XmlPullParser r10, @androidx.annotation.NonNull android.util.AttributeSet r11, @androidx.annotation.Nullable android.content.res.Resources.Theme r12) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            int r0 = r10.getDepth()
            r1 = 1
            int r0 = r0 + r1
            java.util.ArrayList r2 = new java.util.ArrayList
            r3 = 20
            r2.<init>(r3)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>(r3)
        L12:
            int r3 = r10.next()
            if (r3 == r1) goto L81
            int r5 = r10.getDepth()
            if (r5 >= r0) goto L21
            r6 = 3
            if (r3 == r6) goto L81
        L21:
            r6 = 2
            if (r3 == r6) goto L25
            goto L12
        L25:
            if (r5 > r0) goto L12
            java.lang.String r3 = r10.getName()
            java.lang.String r5 = "item"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L34
            goto L12
        L34:
            int[] r3 = androidx.core.R$styleable.f2182yt
            android.content.res.TypedArray r3 = d.f.f(r9, r12, r11, r3)
            int r5 = androidx.core.R$styleable.f2176vl
            boolean r6 = r3.hasValue(r5)
            int r7 = androidx.core.R$styleable.f2159hw
            boolean r8 = r3.hasValue(r7)
            if (r6 == 0) goto L66
            if (r8 == 0) goto L66
            r6 = 0
            int r5 = r3.getColor(r5, r6)
            r6 = 0
            float r6 = r3.getFloat(r7, r6)
            r3.recycle()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)
            r4.add(r3)
            java.lang.Float r3 = java.lang.Float.valueOf(r6)
            r2.add(r3)
            goto L12
        L66:
            org.xmlpull.v1.XmlPullParserException r9 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r10 = r10.getPositionDescription()
            r11.append(r10)
            java.lang.String r10 = ": <item> tag requires a 'color' attribute and a 'offset' attribute!"
            r11.append(r10)
            java.lang.String r10 = r11.toString()
            r9.<init>(r10)
            throw r9
        L81:
            int r9 = r4.size()
            if (r9 <= 0) goto L8d
            d.a$y r9 = new d.a$y
            r9.<init>(r4, r2)
            return r9
        L8d:
            r9 = 0
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: d.a.zn(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):d.a$y");
    }

    /* loaded from: classes.dex */
    public static final class y {

        /* renamed from: n3  reason: collision with root package name */
        public final float[] f6909n3;
        public final int[] y;

        public y(@NonNull List<Integer> list, @NonNull List<Float> list2) {
            int size = list.size();
            this.y = new int[size];
            this.f6909n3 = new float[size];
            for (int i = 0; i < size; i++) {
                this.y[i] = list.get(i).intValue();
                this.f6909n3[i] = list2.get(i).floatValue();
            }
        }

        public y(int i, int i5) {
            this.y = new int[]{i, i5};
            this.f6909n3 = new float[]{0.0f, 1.0f};
        }

        public y(int i, int i5, int i6) {
            this.y = new int[]{i, i5, i6};
            this.f6909n3 = new float[]{0.0f, 0.5f, 1.0f};
        }
    }
}
