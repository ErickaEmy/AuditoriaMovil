package p0;

import androidx.annotation.Nullable;
import java.io.IOException;
import java.io.StringReader;
import m1.ne;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import p0.n3;
import v5.qn;
import v5.r;
import z0.x4;
/* loaded from: classes.dex */
public final class v {
    public static final String[] y = {"Camera:MotionPhoto", "GCamera:MotionPhoto", "Camera:MicroVideo", "GCamera:MicroVideo"};

    /* renamed from: n3  reason: collision with root package name */
    public static final String[] f12374n3 = {"Camera:MotionPhotoPresentationTimestampUs", "GCamera:MotionPhotoPresentationTimestampUs", "Camera:MicroVideoPresentationTimestampUs", "GCamera:MicroVideoPresentationTimestampUs"};

    /* renamed from: zn  reason: collision with root package name */
    public static final String[] f12375zn = {"Camera:MicroVideoOffset", "GCamera:MicroVideoOffset"};

    public static x4<n3.y> a(XmlPullParser xmlPullParser, String str, String str2) throws XmlPullParserException, IOException {
        long j2;
        long j4;
        x4.y x42 = x4.x4();
        String str3 = str + ":Item";
        String str4 = str + ":Directory";
        do {
            xmlPullParser.next();
            if (qn.a(xmlPullParser, str3)) {
                String y2 = qn.y(xmlPullParser, str2 + ":Mime");
                String y7 = qn.y(xmlPullParser, str2 + ":Semantic");
                String y8 = qn.y(xmlPullParser, str2 + ":Length");
                String y9 = qn.y(xmlPullParser, str2 + ":Padding");
                if (y2 != null && y7 != null) {
                    if (y8 != null) {
                        j2 = Long.parseLong(y8);
                    } else {
                        j2 = 0;
                    }
                    if (y9 != null) {
                        j4 = Long.parseLong(y9);
                    } else {
                        j4 = 0;
                    }
                    x42.y(new n3.y(y2, y7, j2, j4));
                } else {
                    return x4.j5();
                }
            }
        } while (!qn.gv(xmlPullParser, str4));
        return x42.s();
    }

    public static boolean gv(XmlPullParser xmlPullParser) {
        for (String str : y) {
            String y2 = qn.y(xmlPullParser, str);
            if (y2 != null) {
                if (Integer.parseInt(y2) != 1) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    @Nullable
    public static n3 n3(String str) throws XmlPullParserException, IOException {
        XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
        newPullParser.setInput(new StringReader(str));
        newPullParser.next();
        if (qn.a(newPullParser, "x:xmpmeta")) {
            x4<n3.y> j52 = x4.j5();
            long j2 = -9223372036854775807L;
            do {
                newPullParser.next();
                if (qn.a(newPullParser, "rdf:Description")) {
                    if (!gv(newPullParser)) {
                        return null;
                    }
                    j2 = v(newPullParser);
                    j52 = zn(newPullParser);
                } else if (qn.a(newPullParser, "Container:Directory")) {
                    j52 = a(newPullParser, "Container", "Item");
                } else if (qn.a(newPullParser, "GContainer:Directory")) {
                    j52 = a(newPullParser, "GContainer", "GContainerItem");
                }
            } while (!qn.gv(newPullParser, "x:xmpmeta"));
            if (j52.isEmpty()) {
                return null;
            }
            return new n3(j2, j52);
        }
        throw ne.y("Couldn't find xmp metadata", null);
    }

    public static long v(XmlPullParser xmlPullParser) {
        for (String str : f12374n3) {
            String y2 = qn.y(xmlPullParser, str);
            if (y2 != null) {
                long parseLong = Long.parseLong(y2);
                if (parseLong == -1) {
                    return -9223372036854775807L;
                }
                return parseLong;
            }
        }
        return -9223372036854775807L;
    }

    @Nullable
    public static n3 y(String str) throws IOException {
        try {
            return n3(str);
        } catch (NumberFormatException | ne | XmlPullParserException unused) {
            r.c5("MotionPhotoXmpParser", "Ignoring unexpected XMP metadata");
            return null;
        }
    }

    public static x4<n3.y> zn(XmlPullParser xmlPullParser) {
        for (String str : f12375zn) {
            String y2 = qn.y(xmlPullParser, str);
            if (y2 != null) {
                return x4.j(new n3.y("image/jpeg", "Primary", 0L, 0L), new n3.y("video/mp4", "MotionPhoto", Long.parseLong(y2), 0L));
            }
        }
        return x4.j5();
    }
}
