package d;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Base64;
import android.util.Xml;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.R$styleable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public class v {

    /* loaded from: classes.dex */
    public static final class gv {

        /* renamed from: a  reason: collision with root package name */
        public final int f6934a;

        /* renamed from: gv  reason: collision with root package name */
        public final String f6935gv;

        /* renamed from: n3  reason: collision with root package name */
        public final int f6936n3;

        /* renamed from: v  reason: collision with root package name */
        public final int f6937v;
        @NonNull
        public final String y;

        /* renamed from: zn  reason: collision with root package name */
        public final boolean f6938zn;

        public gv(@NonNull String str, int i, boolean z2, @Nullable String str2, int i5, int i6) {
            this.y = str;
            this.f6936n3 = i;
            this.f6938zn = z2;
            this.f6935gv = str2;
            this.f6937v = i5;
            this.f6934a = i6;
        }

        public boolean a() {
            return this.f6938zn;
        }

        @Nullable
        public String gv() {
            return this.f6935gv;
        }

        public int n3() {
            return this.f6934a;
        }

        public int v() {
            return this.f6936n3;
        }

        @NonNull
        public String y() {
            return this.y;
        }

        public int zn() {
            return this.f6937v;
        }
    }

    /* loaded from: classes.dex */
    public interface n3 {
    }

    /* renamed from: d.v$v  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0078v implements n3 {
        @Nullable

        /* renamed from: gv  reason: collision with root package name */
        public final String f6939gv;

        /* renamed from: n3  reason: collision with root package name */
        public final int f6940n3;
        @NonNull
        public final k5.v y;

        /* renamed from: zn  reason: collision with root package name */
        public final int f6941zn;

        public C0078v(@NonNull k5.v vVar, int i, int i5, @Nullable String str) {
            this.y = vVar;
            this.f6941zn = i;
            this.f6940n3 = i5;
            this.f6939gv = str;
        }

        public int gv() {
            return this.f6940n3;
        }

        @NonNull
        public k5.v n3() {
            return this.y;
        }

        public int y() {
            return this.f6941zn;
        }

        @Nullable
        public String zn() {
            return this.f6939gv;
        }
    }

    /* loaded from: classes.dex */
    public static class y {
        public static int y(TypedArray typedArray, int i) {
            return typedArray.getType(i);
        }
    }

    /* loaded from: classes.dex */
    public static final class zn implements n3 {
        @NonNull
        public final gv[] y;

        public zn(@NonNull gv[] gvVarArr) {
            this.y = gvVarArr;
        }

        @NonNull
        public gv[] y() {
            return this.y;
        }
    }

    public static gv a(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        boolean z2;
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.f2177w);
        int i = R$styleable.f2165n;
        if (!obtainAttributes.hasValue(i)) {
            i = R$styleable.f2164mt;
        }
        int i5 = obtainAttributes.getInt(i, 400);
        int i6 = R$styleable.f2160i4;
        if (!obtainAttributes.hasValue(i6)) {
            i6 = R$styleable.f2150co;
        }
        if (1 == obtainAttributes.getInt(i6, 0)) {
            z2 = true;
        } else {
            z2 = false;
        }
        int i8 = R$styleable.f2148c;
        if (!obtainAttributes.hasValue(i8)) {
            i8 = R$styleable.f2183z;
        }
        int i10 = R$styleable.f2155f3;
        if (!obtainAttributes.hasValue(i10)) {
            i10 = R$styleable.f2168r;
        }
        String string = obtainAttributes.getString(i10);
        int i11 = obtainAttributes.getInt(i8, 0);
        int i12 = R$styleable.f2180x4;
        if (!obtainAttributes.hasValue(i12)) {
            i12 = R$styleable.f2167p;
        }
        int resourceId = obtainAttributes.getResourceId(i12, 0);
        String string2 = obtainAttributes.getString(i12);
        obtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            fb(xmlPullParser);
        }
        return new gv(string2, i5, z2, string, i11, resourceId);
    }

    public static void fb(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int i = 1;
        while (i > 0) {
            int next = xmlPullParser.next();
            if (next != 2) {
                if (next == 3) {
                    i--;
                }
            } else {
                i++;
            }
        }
    }

    @Nullable
    public static n3 gv(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return v(xmlPullParser, resources);
        }
        fb(xmlPullParser);
        return null;
    }

    @Nullable
    public static n3 n3(@NonNull XmlPullParser xmlPullParser, @NonNull Resources resources) throws XmlPullParserException, IOException {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return gv(xmlPullParser, resources);
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static List<byte[]> s(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(Base64.decode(str, 0));
        }
        return arrayList;
    }

    @Nullable
    public static n3 v(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.f2170s);
        String string = obtainAttributes.getString(R$styleable.f2149c5);
        String string2 = obtainAttributes.getString(R$styleable.f2173tl);
        String string3 = obtainAttributes.getString(R$styleable.f2178wz);
        int resourceId = obtainAttributes.getResourceId(R$styleable.f2161i9, 0);
        int integer = obtainAttributes.getInteger(R$styleable.f2154f, 1);
        int integer2 = obtainAttributes.getInteger(R$styleable.f2171t, 500);
        String string4 = obtainAttributes.getString(R$styleable.f2181xc);
        obtainAttributes.recycle();
        if (string != null && string2 != null && string3 != null) {
            while (xmlPullParser.next() != 3) {
                fb(xmlPullParser);
            }
            return new C0078v(new k5.v(string, string2, string3, zn(resources, resourceId)), integer, integer2, string4);
        }
        ArrayList arrayList = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("font")) {
                    arrayList.add(a(xmlPullParser, resources));
                } else {
                    fb(xmlPullParser);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new zn((gv[]) arrayList.toArray(new gv[0]));
    }

    public static int y(TypedArray typedArray, int i) {
        return y.y(typedArray, i);
    }

    @NonNull
    public static List<List<byte[]>> zn(@NonNull Resources resources, int i) {
        if (i == 0) {
            return Collections.emptyList();
        }
        TypedArray obtainTypedArray = resources.obtainTypedArray(i);
        try {
            if (obtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (y(obtainTypedArray, 0) == 1) {
                for (int i5 = 0; i5 < obtainTypedArray.length(); i5++) {
                    int resourceId = obtainTypedArray.getResourceId(i5, 0);
                    if (resourceId != 0) {
                        arrayList.add(s(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(s(resources.getStringArray(i)));
            }
            return arrayList;
        } finally {
            obtainTypedArray.recycle();
        }
    }
}
