package o0;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.InflateException;
import d.f;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import z6.zn;
/* loaded from: classes.dex */
public class v {

    /* loaded from: classes.dex */
    public static class y implements TypeEvaluator<zn.n3[]> {
        public zn.n3[] y;

        @Override // android.animation.TypeEvaluator
        /* renamed from: y */
        public zn.n3[] evaluate(float f4, zn.n3[] n3VarArr, zn.n3[] n3VarArr2) {
            if (z6.zn.n3(n3VarArr, n3VarArr2)) {
                if (!z6.zn.n3(this.y, n3VarArr)) {
                    this.y = z6.zn.a(n3VarArr);
                }
                for (int i = 0; i < n3VarArr.length; i++) {
                    this.y[i].gv(n3VarArr[i], n3VarArr2[i], f4);
                }
                return this.y;
            }
            throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
        }
    }

    public static int a(TypedArray typedArray, int i, int i5) {
        boolean z2;
        int i6;
        int i8;
        TypedValue peekValue = typedArray.peekValue(i);
        boolean z3 = true;
        if (peekValue != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            i6 = peekValue.type;
        } else {
            i6 = 0;
        }
        TypedValue peekValue2 = typedArray.peekValue(i5);
        if (peekValue2 == null) {
            z3 = false;
        }
        if (z3) {
            i8 = peekValue2.type;
        } else {
            i8 = 0;
        }
        if ((!z2 || !s(i6)) && (!z3 || !s(i8))) {
            return 0;
        }
        return 3;
    }

    public static Animator c5(Context context, int i) throws Resources.NotFoundException {
        if (Build.VERSION.SDK_INT >= 24) {
            return AnimatorInflater.loadAnimator(context, i);
        }
        return i9(context, context.getResources(), context.getTheme(), i);
    }

    public static void co(Path path, ObjectAnimator objectAnimator, float f4, String str, String str2) {
        PropertyValuesHolder propertyValuesHolder;
        PropertyValuesHolder propertyValuesHolder2;
        int i = 1;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        ArrayList arrayList = new ArrayList();
        float f6 = 0.0f;
        arrayList.add(Float.valueOf(0.0f));
        float f9 = 0.0f;
        do {
            f9 += pathMeasure.getLength();
            arrayList.add(Float.valueOf(f9));
        } while (pathMeasure.nextContour());
        PathMeasure pathMeasure2 = new PathMeasure(path, false);
        int min = Math.min(100, ((int) (f9 / f4)) + 1);
        float[] fArr = new float[min];
        float[] fArr2 = new float[min];
        float[] fArr3 = new float[2];
        float f10 = f9 / (min - 1);
        int i5 = 0;
        int i6 = 0;
        while (true) {
            propertyValuesHolder = null;
            if (i5 >= min) {
                break;
            }
            pathMeasure2.getPosTan(f6 - ((Float) arrayList.get(i6)).floatValue(), fArr3, null);
            fArr[i5] = fArr3[0];
            fArr2[i5] = fArr3[1];
            f6 += f10;
            int i8 = i6 + 1;
            if (i8 < arrayList.size() && f6 > ((Float) arrayList.get(i8)).floatValue()) {
                pathMeasure2.nextContour();
                i6 = i8;
            }
            i = 1;
            i5++;
        }
        if (str != null) {
            propertyValuesHolder2 = PropertyValuesHolder.ofFloat(str, fArr);
        } else {
            propertyValuesHolder2 = null;
        }
        if (str2 != null) {
            propertyValuesHolder = PropertyValuesHolder.ofFloat(str2, fArr2);
        }
        if (propertyValuesHolder2 == null) {
            PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[i];
            propertyValuesHolderArr[0] = propertyValuesHolder;
            objectAnimator.setValues(propertyValuesHolderArr);
        } else if (propertyValuesHolder == null) {
            PropertyValuesHolder[] propertyValuesHolderArr2 = new PropertyValuesHolder[i];
            propertyValuesHolderArr2[0] = propertyValuesHolder2;
            objectAnimator.setValues(propertyValuesHolderArr2);
        } else {
            PropertyValuesHolder[] propertyValuesHolderArr3 = new PropertyValuesHolder[2];
            propertyValuesHolderArr3[0] = propertyValuesHolder2;
            propertyValuesHolderArr3[i] = propertyValuesHolder;
            objectAnimator.setValues(propertyValuesHolderArr3);
        }
    }

    public static Animator f(Context context, Resources resources, Resources.Theme theme, int i, float f4) throws Resources.NotFoundException {
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                try {
                    xmlResourceParser = resources.getAnimation(i);
                    return y(context, resources, theme, xmlResourceParser, f4);
                } catch (IOException e2) {
                    Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
                    notFoundException.initCause(e2);
                    throw notFoundException;
                }
            } catch (XmlPullParserException e3) {
                Resources.NotFoundException notFoundException2 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
                notFoundException2.initCause(e3);
                throw notFoundException2;
            }
        } finally {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        }
    }

    public static int fb(Resources resources, Resources.Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        TypedArray f4 = f.f(resources, theme, attributeSet, o0.y.f12129i9);
        int i = 0;
        TypedValue t2 = f.t(f4, xmlPullParser, "value", 0);
        if (t2 != null && s(t2.type)) {
            i = 3;
        }
        f4.recycle();
        return i;
    }

    public static void gv(Keyframe[] keyframeArr, float f4, int i, int i5) {
        float f6 = f4 / ((i5 - i) + 2);
        while (i <= i5) {
            keyframeArr[i].setFraction(keyframeArr[i - 1].getFraction() + f6);
            i++;
        }
    }

    public static Animator i9(Context context, Resources resources, Resources.Theme theme, int i) throws Resources.NotFoundException {
        return f(context, resources, theme, i, 1.0f);
    }

    public static void mt(ValueAnimator valueAnimator, TypedArray typedArray, int i, float f4, XmlPullParser xmlPullParser) {
        ObjectAnimator objectAnimator = (ObjectAnimator) valueAnimator;
        String c52 = f.c5(typedArray, xmlPullParser, "pathData", 1);
        if (c52 != null) {
            String c53 = f.c5(typedArray, xmlPullParser, "propertyXName", 2);
            String c54 = f.c5(typedArray, xmlPullParser, "propertyYName", 3);
            if (i != 2) {
            }
            if (c53 == null && c54 == null) {
                throw new InflateException(typedArray.getPositionDescription() + " propertyXName or propertyYName is needed for PathData");
            }
            co(z6.zn.v(c52), objectAnimator, f4 * 0.5f, c53, c54);
            return;
        }
        objectAnimator.setPropertyName(f.c5(typedArray, xmlPullParser, "propertyName", 0));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.animation.Animator n3(android.content.Context r18, android.content.res.Resources r19, android.content.res.Resources.Theme r20, org.xmlpull.v1.XmlPullParser r21, android.util.AttributeSet r22, android.animation.AnimatorSet r23, int r24, float r25) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 263
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o0.v.n3(android.content.Context, android.content.res.Resources, android.content.res.Resources$Theme, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.animation.AnimatorSet, int, float):android.animation.Animator");
    }

    public static void p(ValueAnimator valueAnimator, TypedArray typedArray, TypedArray typedArray2, float f4, XmlPullParser xmlPullParser) {
        long fb2 = f.fb(typedArray, xmlPullParser, "duration", 1, 300);
        long fb3 = f.fb(typedArray, xmlPullParser, "startOffset", 2, 0);
        int fb4 = f.fb(typedArray, xmlPullParser, "valueType", 7, 4);
        if (f.i9(xmlPullParser, "valueFrom") && f.i9(xmlPullParser, "valueTo")) {
            if (fb4 == 4) {
                fb4 = a(typedArray, 5, 6);
            }
            PropertyValuesHolder v2 = v(typedArray, fb4, 5, 6, "");
            if (v2 != null) {
                valueAnimator.setValues(v2);
            }
        }
        valueAnimator.setDuration(fb2);
        valueAnimator.setStartDelay(fb3);
        valueAnimator.setRepeatCount(f.fb(typedArray, xmlPullParser, "repeatCount", 3, 0));
        valueAnimator.setRepeatMode(f.fb(typedArray, xmlPullParser, "repeatMode", 4, 1));
        if (typedArray2 != null) {
            mt(valueAnimator, typedArray2, fb4, f4, xmlPullParser);
        }
    }

    public static boolean s(int i) {
        if (i >= 28 && i <= 31) {
            return true;
        }
        return false;
    }

    public static ValueAnimator t(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, ValueAnimator valueAnimator, float f4, XmlPullParser xmlPullParser) throws Resources.NotFoundException {
        TypedArray f6 = f.f(resources, theme, attributeSet, o0.y.f12127fb);
        TypedArray f9 = f.f(resources, theme, attributeSet, o0.y.f12126f);
        if (valueAnimator == null) {
            valueAnimator = new ValueAnimator();
        }
        p(valueAnimator, f6, f9, f4, xmlPullParser);
        int s2 = f.s(f6, xmlPullParser, "interpolator", 0, 0);
        if (s2 > 0) {
            valueAnimator.setInterpolator(gv.y(context, s2));
        }
        f6.recycle();
        if (f9 != null) {
            f9.recycle();
        }
        return valueAnimator;
    }

    public static Keyframe tl(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, int i, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        boolean z2;
        Keyframe ofInt;
        TypedArray f4 = f.f(resources, theme, attributeSet, o0.y.f12129i9);
        float a2 = f.a(f4, xmlPullParser, "fraction", 3, -1.0f);
        TypedValue t2 = f.t(f4, xmlPullParser, "value", 0);
        if (t2 != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (i == 4) {
            if (z2 && s(t2.type)) {
                i = 3;
            } else {
                i = 0;
            }
        }
        if (z2) {
            if (i != 0) {
                if (i != 1 && i != 3) {
                    ofInt = null;
                } else {
                    ofInt = Keyframe.ofInt(a2, f.fb(f4, xmlPullParser, "value", 0, 0));
                }
            } else {
                ofInt = Keyframe.ofFloat(a2, f.a(f4, xmlPullParser, "value", 0, 0.0f));
            }
        } else if (i == 0) {
            ofInt = Keyframe.ofFloat(a2);
        } else {
            ofInt = Keyframe.ofInt(a2);
        }
        int s2 = f.s(f4, xmlPullParser, "interpolator", 1, 0);
        if (s2 > 0) {
            ofInt.setInterpolator(gv.y(context, s2));
        }
        f4.recycle();
        return ofInt;
    }

    public static PropertyValuesHolder v(TypedArray typedArray, int i, int i5, int i6, String str) {
        boolean z2;
        int i8;
        boolean z3;
        int i10;
        boolean z4;
        a aVar;
        int i11;
        int i12;
        int i13;
        float f4;
        PropertyValuesHolder ofFloat;
        float f6;
        float f9;
        PropertyValuesHolder ofObject;
        TypedValue peekValue = typedArray.peekValue(i5);
        if (peekValue != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            i8 = peekValue.type;
        } else {
            i8 = 0;
        }
        TypedValue peekValue2 = typedArray.peekValue(i6);
        if (peekValue2 != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            i10 = peekValue2.type;
        } else {
            i10 = 0;
        }
        if (i == 4) {
            if ((z2 && s(i8)) || (z3 && s(i10))) {
                i = 3;
            } else {
                i = 0;
            }
        }
        if (i == 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        PropertyValuesHolder propertyValuesHolder = null;
        if (i == 2) {
            String string = typedArray.getString(i5);
            String string2 = typedArray.getString(i6);
            zn.n3[] gv2 = z6.zn.gv(string);
            zn.n3[] gv3 = z6.zn.gv(string2);
            if (gv2 == null && gv3 == null) {
                return null;
            }
            if (gv2 != null) {
                y yVar = new y();
                if (gv3 != null) {
                    if (z6.zn.n3(gv2, gv3)) {
                        ofObject = PropertyValuesHolder.ofObject(str, yVar, gv2, gv3);
                    } else {
                        throw new InflateException(" Can't morph from " + string + " to " + string2);
                    }
                } else {
                    ofObject = PropertyValuesHolder.ofObject(str, yVar, gv2);
                }
                return ofObject;
            } else if (gv3 == null) {
                return null;
            } else {
                return PropertyValuesHolder.ofObject(str, new y(), gv3);
            }
        }
        if (i == 3) {
            aVar = a.y();
        } else {
            aVar = null;
        }
        if (z4) {
            if (z2) {
                if (i8 == 5) {
                    f6 = typedArray.getDimension(i5, 0.0f);
                } else {
                    f6 = typedArray.getFloat(i5, 0.0f);
                }
                if (z3) {
                    if (i10 == 5) {
                        f9 = typedArray.getDimension(i6, 0.0f);
                    } else {
                        f9 = typedArray.getFloat(i6, 0.0f);
                    }
                    ofFloat = PropertyValuesHolder.ofFloat(str, f6, f9);
                } else {
                    ofFloat = PropertyValuesHolder.ofFloat(str, f6);
                }
            } else {
                if (i10 == 5) {
                    f4 = typedArray.getDimension(i6, 0.0f);
                } else {
                    f4 = typedArray.getFloat(i6, 0.0f);
                }
                ofFloat = PropertyValuesHolder.ofFloat(str, f4);
            }
            propertyValuesHolder = ofFloat;
        } else if (z2) {
            if (i8 == 5) {
                i12 = (int) typedArray.getDimension(i5, 0.0f);
            } else if (s(i8)) {
                i12 = typedArray.getColor(i5, 0);
            } else {
                i12 = typedArray.getInt(i5, 0);
            }
            if (z3) {
                if (i10 == 5) {
                    i13 = (int) typedArray.getDimension(i6, 0.0f);
                } else if (s(i10)) {
                    i13 = typedArray.getColor(i6, 0);
                } else {
                    i13 = typedArray.getInt(i6, 0);
                }
                propertyValuesHolder = PropertyValuesHolder.ofInt(str, i12, i13);
            } else {
                propertyValuesHolder = PropertyValuesHolder.ofInt(str, i12);
            }
        } else if (z3) {
            if (i10 == 5) {
                i11 = (int) typedArray.getDimension(i6, 0.0f);
            } else if (s(i10)) {
                i11 = typedArray.getColor(i6, 0);
            } else {
                i11 = typedArray.getInt(i6, 0);
            }
            propertyValuesHolder = PropertyValuesHolder.ofInt(str, i11);
        }
        if (propertyValuesHolder != null && aVar != null) {
            propertyValuesHolder.setEvaluator(aVar);
            return propertyValuesHolder;
        }
        return propertyValuesHolder;
    }

    public static PropertyValuesHolder[] w(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        int i;
        PropertyValuesHolder[] propertyValuesHolderArr = null;
        ArrayList arrayList = null;
        while (true) {
            int eventType = xmlPullParser.getEventType();
            if (eventType == 3 || eventType == 1) {
                break;
            } else if (eventType != 2) {
                xmlPullParser.next();
            } else {
                if (xmlPullParser.getName().equals("propertyValuesHolder")) {
                    TypedArray f4 = f.f(resources, theme, attributeSet, o0.y.f12125c5);
                    String c52 = f.c5(f4, xmlPullParser, "propertyName", 3);
                    int fb2 = f.fb(f4, xmlPullParser, "valueType", 2, 4);
                    PropertyValuesHolder xc2 = xc(context, resources, theme, xmlPullParser, c52, fb2);
                    if (xc2 == null) {
                        xc2 = v(f4, fb2, 0, 1, c52);
                    }
                    if (xc2 != null) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(xc2);
                    }
                    f4.recycle();
                }
                xmlPullParser.next();
            }
        }
        if (arrayList != null) {
            int size = arrayList.size();
            propertyValuesHolderArr = new PropertyValuesHolder[size];
            for (i = 0; i < size; i++) {
                propertyValuesHolderArr[i] = (PropertyValuesHolder) arrayList.get(i);
            }
        }
        return propertyValuesHolderArr;
    }

    public static ObjectAnimator wz(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, float f4, XmlPullParser xmlPullParser) throws Resources.NotFoundException {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        t(context, resources, theme, attributeSet, objectAnimator, f4, xmlPullParser);
        return objectAnimator;
    }

    public static PropertyValuesHolder xc(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, String str, int i) throws XmlPullParserException, IOException {
        int size;
        PropertyValuesHolder propertyValuesHolder = null;
        ArrayList arrayList = null;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 3 || next == 1) {
                break;
            } else if (xmlPullParser.getName().equals("keyframe")) {
                if (i == 4) {
                    i = fb(resources, theme, Xml.asAttributeSet(xmlPullParser), xmlPullParser);
                }
                Keyframe tl2 = tl(context, resources, theme, Xml.asAttributeSet(xmlPullParser), i, xmlPullParser);
                if (tl2 != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(tl2);
                }
                xmlPullParser.next();
            }
        }
        if (arrayList != null && (size = arrayList.size()) > 0) {
            Keyframe keyframe = (Keyframe) arrayList.get(0);
            Keyframe keyframe2 = (Keyframe) arrayList.get(size - 1);
            float fraction = keyframe2.getFraction();
            if (fraction < 1.0f) {
                if (fraction < 0.0f) {
                    keyframe2.setFraction(1.0f);
                } else {
                    arrayList.add(arrayList.size(), zn(keyframe2, 1.0f));
                    size++;
                }
            }
            float fraction2 = keyframe.getFraction();
            if (fraction2 != 0.0f) {
                if (fraction2 < 0.0f) {
                    keyframe.setFraction(0.0f);
                } else {
                    arrayList.add(0, zn(keyframe, 0.0f));
                    size++;
                }
            }
            Keyframe[] keyframeArr = new Keyframe[size];
            arrayList.toArray(keyframeArr);
            for (int i5 = 0; i5 < size; i5++) {
                Keyframe keyframe3 = keyframeArr[i5];
                if (keyframe3.getFraction() < 0.0f) {
                    if (i5 == 0) {
                        keyframe3.setFraction(0.0f);
                    } else {
                        int i6 = size - 1;
                        if (i5 == i6) {
                            keyframe3.setFraction(1.0f);
                        } else {
                            int i8 = i5;
                            for (int i10 = i5 + 1; i10 < i6 && keyframeArr[i10].getFraction() < 0.0f; i10++) {
                                i8 = i10;
                            }
                            gv(keyframeArr, keyframeArr[i8 + 1].getFraction() - keyframeArr[i5 - 1].getFraction(), i5, i8);
                        }
                    }
                }
            }
            propertyValuesHolder = PropertyValuesHolder.ofKeyframe(str, keyframeArr);
            if (i == 3) {
                propertyValuesHolder.setEvaluator(a.y());
            }
        }
        return propertyValuesHolder;
    }

    public static Animator y(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, float f4) throws XmlPullParserException, IOException {
        return n3(context, resources, theme, xmlPullParser, Xml.asAttributeSet(xmlPullParser), null, 0, f4);
    }

    public static Keyframe zn(Keyframe keyframe, float f4) {
        if (keyframe.getType() == Float.TYPE) {
            return Keyframe.ofFloat(f4);
        }
        if (keyframe.getType() == Integer.TYPE) {
            return Keyframe.ofInt(f4);
        }
        return Keyframe.ofObject(f4);
    }
}
