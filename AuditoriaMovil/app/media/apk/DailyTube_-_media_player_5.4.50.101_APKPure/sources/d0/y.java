package d0;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R$styleable;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public class y {
    public final ConstraintLayout y;

    /* renamed from: n3  reason: collision with root package name */
    public int f6951n3 = -1;

    /* renamed from: zn  reason: collision with root package name */
    public int f6953zn = -1;

    /* renamed from: gv  reason: collision with root package name */
    public SparseArray<C0079y> f6950gv = new SparseArray<>();

    /* renamed from: v  reason: collision with root package name */
    public SparseArray<androidx.constraintlayout.widget.zn> f6952v = new SparseArray<>();

    /* loaded from: classes.dex */
    public static class n3 {

        /* renamed from: a  reason: collision with root package name */
        public androidx.constraintlayout.widget.zn f6954a;

        /* renamed from: gv  reason: collision with root package name */
        public float f6955gv;

        /* renamed from: n3  reason: collision with root package name */
        public float f6956n3;

        /* renamed from: v  reason: collision with root package name */
        public int f6957v;
        public float y;

        /* renamed from: zn  reason: collision with root package name */
        public float f6958zn;

        public n3(Context context, XmlPullParser xmlPullParser) {
            this.y = Float.NaN;
            this.f6956n3 = Float.NaN;
            this.f6958zn = Float.NaN;
            this.f6955gv = Float.NaN;
            this.f6957v = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.f1714bp);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R$styleable.f1775jh) {
                    this.f6957v = obtainStyledAttributes.getResourceId(index, this.f6957v);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f6957v);
                    context.getResources().getResourceName(this.f6957v);
                    if ("layout".equals(resourceTypeName)) {
                        androidx.constraintlayout.widget.zn znVar = new androidx.constraintlayout.widget.zn();
                        this.f6954a = znVar;
                        znVar.a(context, this.f6957v);
                    }
                } else if (index == R$styleable.f1871w3) {
                    this.f6955gv = obtainStyledAttributes.getDimension(index, this.f6955gv);
                } else if (index == R$styleable.f1808np) {
                    this.f6956n3 = obtainStyledAttributes.getDimension(index, this.f6956n3);
                } else if (index == R$styleable.f1861ur) {
                    this.f6958zn = obtainStyledAttributes.getDimension(index, this.f6958zn);
                } else if (index == R$styleable.f1843s6) {
                    this.y = obtainStyledAttributes.getDimension(index, this.y);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: d0.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0079y {

        /* renamed from: gv  reason: collision with root package name */
        public androidx.constraintlayout.widget.zn f6959gv;

        /* renamed from: n3  reason: collision with root package name */
        public ArrayList<n3> f6960n3 = new ArrayList<>();
        public int y;

        /* renamed from: zn  reason: collision with root package name */
        public int f6961zn;

        public C0079y(Context context, XmlPullParser xmlPullParser) {
            this.f6961zn = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.f1782kx);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R$styleable.f1730di) {
                    this.y = obtainStyledAttributes.getResourceId(index, this.y);
                } else if (index == R$styleable.f1865v5) {
                    this.f6961zn = obtainStyledAttributes.getResourceId(index, this.f6961zn);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f6961zn);
                    context.getResources().getResourceName(this.f6961zn);
                    if ("layout".equals(resourceTypeName)) {
                        androidx.constraintlayout.widget.zn znVar = new androidx.constraintlayout.widget.zn();
                        this.f6959gv = znVar;
                        znVar.a(context, this.f6961zn);
                    }
                }
            }
            obtainStyledAttributes.recycle();
        }

        public void y(n3 n3Var) {
            this.f6960n3.add(n3Var);
        }
    }

    public y(Context context, ConstraintLayout constraintLayout, int i) {
        this.y = constraintLayout;
        y(context, i);
    }

    public final void n3(Context context, XmlPullParser xmlPullParser) {
        int i;
        androidx.constraintlayout.widget.zn znVar = new androidx.constraintlayout.widget.zn();
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i5 = 0; i5 < attributeCount; i5++) {
            if ("id".equals(xmlPullParser.getAttributeName(i5))) {
                String attributeValue = xmlPullParser.getAttributeValue(i5);
                if (attributeValue.contains("/")) {
                    i = context.getResources().getIdentifier(attributeValue.substring(attributeValue.indexOf(47) + 1), "id", context.getPackageName());
                } else {
                    i = -1;
                }
                if (i == -1) {
                    if (attributeValue.length() > 1) {
                        i = Integer.parseInt(attributeValue.substring(1));
                    } else {
                        Log.e("ConstraintLayoutStates", "error in parsing id");
                    }
                }
                znVar.w(context, xmlPullParser);
                this.f6952v.put(i, znVar);
                return;
            }
        }
    }

    public final void y(Context context, int i) {
        XmlResourceParser xml = context.getResources().getXml(i);
        try {
            int eventType = xml.getEventType();
            C0079y c0079y = null;
            while (true) {
                char c2 = 1;
                if (eventType != 1) {
                    if (eventType != 0) {
                        if (eventType != 2) {
                            continue;
                        } else {
                            String name = xml.getName();
                            switch (name.hashCode()) {
                                case -1349929691:
                                    if (name.equals("ConstraintSet")) {
                                        c2 = 4;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 80204913:
                                    if (name.equals("State")) {
                                        c2 = 2;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 1382829617:
                                    if (name.equals("StateSet")) {
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 1657696882:
                                    if (name.equals("layoutDescription")) {
                                        c2 = 0;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 1901439077:
                                    if (name.equals("Variant")) {
                                        c2 = 3;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                default:
                                    c2 = 65535;
                                    break;
                            }
                            if (c2 != 2) {
                                if (c2 != 3) {
                                    if (c2 != 4) {
                                        continue;
                                    } else {
                                        n3(context, xml);
                                        continue;
                                    }
                                } else {
                                    n3 n3Var = new n3(context, xml);
                                    if (c0079y != null) {
                                        c0079y.y(n3Var);
                                        continue;
                                    } else {
                                        continue;
                                    }
                                }
                            } else {
                                c0079y = new C0079y(context, xml);
                                this.f6950gv.put(c0079y.y, c0079y);
                                continue;
                            }
                        }
                    } else {
                        xml.getName();
                        continue;
                    }
                    eventType = xml.next();
                } else {
                    return;
                }
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (XmlPullParserException unused) {
        }
    }

    public void zn(d0.n3 n3Var) {
    }
}
