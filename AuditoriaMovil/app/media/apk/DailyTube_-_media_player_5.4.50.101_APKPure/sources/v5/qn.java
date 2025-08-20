package v5;

import androidx.annotation.Nullable;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public final class qn {
    public static boolean a(XmlPullParser xmlPullParser, String str) throws XmlPullParserException {
        if (v(xmlPullParser) && xmlPullParser.getName().equals(str)) {
            return true;
        }
        return false;
    }

    public static boolean fb(XmlPullParser xmlPullParser, String str) throws XmlPullParserException {
        if (v(xmlPullParser) && s(xmlPullParser.getName()).equals(str)) {
            return true;
        }
        return false;
    }

    public static boolean gv(XmlPullParser xmlPullParser, String str) throws XmlPullParserException {
        if (zn(xmlPullParser) && xmlPullParser.getName().equals(str)) {
            return true;
        }
        return false;
    }

    @Nullable
    public static String n3(XmlPullParser xmlPullParser, String str) {
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            if (s(xmlPullParser.getAttributeName(i)).equals(str)) {
                return xmlPullParser.getAttributeValue(i);
            }
        }
        return null;
    }

    public static String s(String str) {
        int indexOf = str.indexOf(58);
        if (indexOf != -1) {
            return str.substring(indexOf + 1);
        }
        return str;
    }

    public static boolean v(XmlPullParser xmlPullParser) throws XmlPullParserException {
        if (xmlPullParser.getEventType() == 2) {
            return true;
        }
        return false;
    }

    @Nullable
    public static String y(XmlPullParser xmlPullParser, String str) {
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            if (xmlPullParser.getAttributeName(i).equals(str)) {
                return xmlPullParser.getAttributeValue(i);
            }
        }
        return null;
    }

    public static boolean zn(XmlPullParser xmlPullParser) throws XmlPullParserException {
        if (xmlPullParser.getEventType() == 3) {
            return true;
        }
        return false;
    }
}
