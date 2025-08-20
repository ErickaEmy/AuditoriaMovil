package androidx.navigation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import androidx.annotation.NonNull;
import androidx.navigation.n3;
import androidx.navigation.s;
import androidx.navigation.zn;
import java.io.IOException;
import lc.f;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public final class fb {

    /* renamed from: zn  reason: collision with root package name */
    public static final ThreadLocal<TypedValue> f2748zn = new ThreadLocal<>();

    /* renamed from: n3  reason: collision with root package name */
    public i9 f2749n3;
    public Context y;

    public fb(@NonNull Context context, @NonNull i9 i9Var) {
        this.y = context;
        this.f2749n3 = i9Var;
    }

    public static f y(TypedValue typedValue, f fVar, f fVar2, String str, String str2) throws XmlPullParserException {
        if (fVar != null && fVar != fVar2) {
            throw new XmlPullParserException("Type is " + str + " but found " + str2 + ": " + typedValue.data);
        } else if (fVar == null) {
            return fVar2;
        } else {
            return fVar;
        }
    }

    public final void a(@NonNull Resources resources, @NonNull Bundle bundle, @NonNull AttributeSet attributeSet, int i) throws XmlPullParserException {
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, androidx.navigation.common.R$styleable.f2733w);
        String string = obtainAttributes.getString(androidx.navigation.common.R$styleable.f2726p);
        if (string != null) {
            n3 v2 = v(obtainAttributes, resources, i);
            if (v2.n3()) {
                v2.zn(string, bundle);
            }
            obtainAttributes.recycle();
            return;
        }
        throw new XmlPullParserException("Arguments must have a name");
    }

    public final void fb(@NonNull Resources resources, @NonNull gv gvVar, @NonNull AttributeSet attributeSet, int i) throws XmlPullParserException {
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, androidx.navigation.common.R$styleable.f2733w);
        String string = obtainAttributes.getString(androidx.navigation.common.R$styleable.f2726p);
        if (string != null) {
            gvVar.y(string, v(obtainAttributes, resources, i));
            obtainAttributes.recycle();
            return;
        }
        throw new XmlPullParserException("Arguments must have a name");
    }

    public final void gv(@NonNull Resources resources, @NonNull gv gvVar, @NonNull AttributeSet attributeSet, XmlResourceParser xmlResourceParser, int i) throws IOException, XmlPullParserException {
        int depth;
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, androidx.navigation.common.R$styleable.f2711a);
        int resourceId = obtainAttributes.getResourceId(androidx.navigation.common.R$styleable.f2718fb, 0);
        lc.zn znVar = new lc.zn(obtainAttributes.getResourceId(androidx.navigation.common.R$styleable.f2729s, 0));
        s.y yVar = new s.y();
        yVar.gv(obtainAttributes.getBoolean(androidx.navigation.common.R$styleable.f2716f, false));
        yVar.fb(obtainAttributes.getResourceId(androidx.navigation.common.R$styleable.f2734wz, -1), obtainAttributes.getBoolean(androidx.navigation.common.R$styleable.f2736xc, false));
        yVar.n3(obtainAttributes.getResourceId(androidx.navigation.common.R$styleable.f2713c5, -1));
        yVar.zn(obtainAttributes.getResourceId(androidx.navigation.common.R$styleable.f2722i9, -1));
        yVar.v(obtainAttributes.getResourceId(androidx.navigation.common.R$styleable.f2730t, -1));
        yVar.a(obtainAttributes.getResourceId(androidx.navigation.common.R$styleable.f2731tl, -1));
        znVar.v(yVar.y());
        Bundle bundle = new Bundle();
        int depth2 = xmlResourceParser.getDepth() + 1;
        while (true) {
            int next = xmlResourceParser.next();
            if (next == 1 || ((depth = xmlResourceParser.getDepth()) < depth2 && next == 3)) {
                break;
            } else if (next == 2 && depth <= depth2 && "argument".equals(xmlResourceParser.getName())) {
                a(resources, bundle, attributeSet, i);
            }
        }
        if (!bundle.isEmpty()) {
            znVar.gv(bundle);
        }
        gvVar.w(resourceId, znVar);
        obtainAttributes.recycle();
    }

    @NonNull
    public final gv n3(@NonNull Resources resources, @NonNull XmlResourceParser xmlResourceParser, @NonNull AttributeSet attributeSet, int i) throws XmlPullParserException, IOException {
        int depth;
        gv y = this.f2749n3.v(xmlResourceParser.getName()).y();
        y.xc(this.y, attributeSet);
        int depth2 = xmlResourceParser.getDepth() + 1;
        while (true) {
            int next = xmlResourceParser.next();
            if (next == 1 || ((depth = xmlResourceParser.getDepth()) < depth2 && next == 3)) {
                break;
            } else if (next == 2 && depth <= depth2) {
                String name = xmlResourceParser.getName();
                if ("argument".equals(name)) {
                    fb(resources, y, attributeSet, i);
                } else if ("deepLink".equals(name)) {
                    s(resources, y, attributeSet);
                } else if ("action".equals(name)) {
                    gv(resources, y, attributeSet, xmlResourceParser, i);
                } else if ("include".equals(name) && (y instanceof v)) {
                    TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, R$styleable.f2699mt);
                    ((v) y).r(zn(obtainAttributes.getResourceId(R$styleable.f2694co, 0)));
                    obtainAttributes.recycle();
                } else if (y instanceof v) {
                    ((v) y).r(n3(resources, xmlResourceParser, attributeSet, i));
                }
            }
        }
        return y;
    }

    public final void s(@NonNull Resources resources, @NonNull gv gvVar, @NonNull AttributeSet attributeSet) throws XmlPullParserException {
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, androidx.navigation.common.R$styleable.f2727r);
        String string = obtainAttributes.getString(androidx.navigation.common.R$styleable.f2717f3);
        String string2 = obtainAttributes.getString(androidx.navigation.common.R$styleable.f2735x4);
        String string3 = obtainAttributes.getString(androidx.navigation.common.R$styleable.f2721i4);
        if (TextUtils.isEmpty(string) && TextUtils.isEmpty(string2) && TextUtils.isEmpty(string3)) {
            throw new XmlPullParserException("Every <deepLink> must include at least one of app:uri, app:action, or app:mimeType");
        }
        zn.y yVar = new zn.y();
        if (string != null) {
            yVar.gv(string.replace("${applicationId}", this.y.getPackageName()));
        }
        if (!TextUtils.isEmpty(string2)) {
            yVar.n3(string2.replace("${applicationId}", this.y.getPackageName()));
        }
        if (string3 != null) {
            yVar.zn(string3.replace("${applicationId}", this.y.getPackageName()));
        }
        gvVar.n3(yVar.y());
        obtainAttributes.recycle();
    }

    @NonNull
    public final n3 v(@NonNull TypedArray typedArray, @NonNull Resources resources, int i) throws XmlPullParserException {
        f<Integer> fVar;
        n3.y yVar = new n3.y();
        boolean z2 = false;
        yVar.zn(typedArray.getBoolean(androidx.navigation.common.R$styleable.f2737z, false));
        ThreadLocal<TypedValue> threadLocal = f2748zn;
        TypedValue typedValue = threadLocal.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            threadLocal.set(typedValue);
        }
        String string = typedArray.getString(androidx.navigation.common.R$styleable.f2714co);
        Object obj = null;
        if (string != null) {
            fVar = f.y(string, resources.getResourcePackageName(i));
        } else {
            fVar = null;
        }
        int i5 = androidx.navigation.common.R$styleable.f2723mt;
        if (typedArray.getValue(i5, typedValue)) {
            f<Integer> fVar2 = f.f10281zn;
            if (fVar == fVar2) {
                int i6 = typedValue.resourceId;
                if (i6 != 0) {
                    obj = Integer.valueOf(i6);
                } else if (typedValue.type == 16 && typedValue.data == 0) {
                    obj = 0;
                } else {
                    throw new XmlPullParserException("unsupported value '" + ((Object) typedValue.string) + "' for " + fVar.zn() + ". Must be a reference to a resource.");
                }
            } else {
                int i8 = typedValue.resourceId;
                if (i8 != 0) {
                    if (fVar == null) {
                        fVar = fVar2;
                        obj = Integer.valueOf(i8);
                    } else {
                        throw new XmlPullParserException("unsupported value '" + ((Object) typedValue.string) + "' for " + fVar.zn() + ". You must use a \"" + fVar2.zn() + "\" type to reference other resources.");
                    }
                } else if (fVar == f.f10273f) {
                    obj = typedArray.getString(i5);
                } else {
                    int i10 = typedValue.type;
                    if (i10 != 3) {
                        if (i10 != 4) {
                            if (i10 != 5) {
                                if (i10 != 18) {
                                    if (i10 >= 16 && i10 <= 31) {
                                        f<Float> fVar3 = f.f10274fb;
                                        if (fVar == fVar3) {
                                            fVar = y(typedValue, fVar, fVar3, string, "float");
                                            obj = Float.valueOf(typedValue.data);
                                        } else {
                                            fVar = y(typedValue, fVar, f.f10277n3, string, "integer");
                                            obj = Integer.valueOf(typedValue.data);
                                        }
                                    } else {
                                        throw new XmlPullParserException("unsupported argument type " + typedValue.type);
                                    }
                                } else {
                                    fVar = y(typedValue, fVar, f.f10272c5, string, "boolean");
                                    if (typedValue.data != 0) {
                                        z2 = true;
                                    }
                                    obj = Boolean.valueOf(z2);
                                }
                            } else {
                                fVar = y(typedValue, fVar, f.f10277n3, string, "dimension");
                                obj = Integer.valueOf((int) typedValue.getDimension(resources.getDisplayMetrics()));
                            }
                        } else {
                            fVar = y(typedValue, fVar, f.f10274fb, string, "float");
                            obj = Float.valueOf(typedValue.getFloat());
                        }
                    } else {
                        String charSequence = typedValue.string.toString();
                        if (fVar == null) {
                            fVar = f.gv(charSequence);
                        }
                        obj = fVar.s(charSequence);
                    }
                }
            }
        }
        if (obj != null) {
            yVar.n3(obj);
        }
        if (fVar != null) {
            yVar.gv(fVar);
        }
        return yVar.y();
    }

    @NonNull
    @SuppressLint({"ResourceType"})
    public v zn(int i) {
        int next;
        Resources resources = this.y.getResources();
        XmlResourceParser xml = resources.getXml(i);
        AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
        while (true) {
            try {
                try {
                    next = xml.next();
                    if (next == 2 || next == 1) {
                        break;
                    }
                } catch (Exception e2) {
                    throw new RuntimeException("Exception inflating " + resources.getResourceName(i) + " line " + xml.getLineNumber(), e2);
                }
            } finally {
                xml.close();
            }
        }
        if (next == 2) {
            String name = xml.getName();
            gv n32 = n3(resources, xml, asAttributeSet, i);
            if (n32 instanceof v) {
                return (v) n32;
            }
            throw new IllegalArgumentException("Root element <" + name + "> did not inflate into a NavGraph");
        }
        throw new XmlPullParserException("No start tag found");
    }
}
