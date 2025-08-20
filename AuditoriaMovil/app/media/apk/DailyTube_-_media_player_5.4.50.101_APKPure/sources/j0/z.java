package j0;

import android.content.res.AssetManager;
import androidx.annotation.Nullable;
import java.io.File;
import java.io.IOException;
import m0.n3;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public final class z {
    @Nullable

    /* renamed from: n3  reason: collision with root package name */
    public XmlPullParser f9364n3;
    public final n3 y;

    public z(n3 n3Var) {
        this.y = n3Var;
    }

    public final void n3(AssetManager assetManager, File file) throws IOException {
        this.f9364n3 = assetManager.openXmlResourceParser(n3.zn(assetManager, file), "AndroidManifest.xml");
    }

    public final long y() throws IOException, XmlPullParserException {
        if (this.f9364n3 != null) {
            while (true) {
                int next = this.f9364n3.next();
                if (next != 2) {
                    if (next == 1) {
                        break;
                    }
                } else if (this.f9364n3.getName().equals("manifest")) {
                    String attributeValue = this.f9364n3.getAttributeValue("http://schemas.android.com/apk/res/android", "versionCode");
                    String attributeValue2 = this.f9364n3.getAttributeValue("http://schemas.android.com/apk/res/android", "versionCodeMajor");
                    if (attributeValue != null) {
                        try {
                            int parseInt = Integer.parseInt(attributeValue);
                            if (attributeValue2 == null) {
                                return parseInt;
                            }
                            try {
                                return (Integer.parseInt(attributeValue2) << 32) | (parseInt & 4294967295L);
                            } catch (NumberFormatException e2) {
                                throw new XmlPullParserException(String.format("Couldn't parse versionCodeMajor to int: %s", e2.getMessage()));
                            }
                        } catch (NumberFormatException e3) {
                            throw new XmlPullParserException(String.format("Couldn't parse versionCode to int: %s", e3.getMessage()));
                        }
                    }
                    throw new XmlPullParserException("Manifest entry doesn't contain 'versionCode' attribute.");
                }
            }
            throw new XmlPullParserException("Couldn't find manifest entry at top-level.");
        }
        throw new XmlPullParserException("Manifest file needs to be loaded before parsing.");
    }
}
