package s;

import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.Deque;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public class c5 {
    @NonNull
    public final Deque<WeakReference<XmlPullParser>> y = new ArrayDeque();

    public static boolean gv(@NonNull XmlPullParser xmlPullParser, @Nullable XmlPullParser xmlPullParser2) {
        if (xmlPullParser2 != null && xmlPullParser != xmlPullParser2) {
            try {
                if (xmlPullParser2.getEventType() == 2) {
                    return "include".equals(xmlPullParser2.getName());
                }
                return false;
            } catch (XmlPullParserException unused) {
                return false;
            }
        }
        return false;
    }

    public static boolean n3(@Nullable XmlPullParser xmlPullParser) {
        if (xmlPullParser == null) {
            return true;
        }
        try {
            if (xmlPullParser.getEventType() == 3) {
                return true;
            }
            if (xmlPullParser.getEventType() == 1) {
                return true;
            }
            return false;
        } catch (XmlPullParserException unused) {
            return true;
        }
    }

    @Nullable
    public static XmlPullParser zn(@NonNull Deque<WeakReference<XmlPullParser>> deque) {
        while (!deque.isEmpty()) {
            XmlPullParser xmlPullParser = deque.peek().get();
            if (n3(xmlPullParser)) {
                deque.pop();
            } else {
                return xmlPullParser;
            }
        }
        return null;
    }

    public boolean y(@NonNull AttributeSet attributeSet) {
        if (attributeSet instanceof XmlPullParser) {
            XmlPullParser xmlPullParser = (XmlPullParser) attributeSet;
            if (xmlPullParser.getDepth() == 1) {
                XmlPullParser zn2 = zn(this.y);
                this.y.push(new WeakReference<>(xmlPullParser));
                if (gv(xmlPullParser, zn2)) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }
}
