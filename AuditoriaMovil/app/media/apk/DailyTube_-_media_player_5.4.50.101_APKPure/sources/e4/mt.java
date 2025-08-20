package e4;

import android.net.Uri;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public interface mt {
    public static final mt y = new mt() { // from class: e4.w
        @Override // e4.mt
        public final t[] createExtractors() {
            return p.n3();
        }

        @Override // e4.mt
        public /* synthetic */ t[] y(Uri uri, Map map) {
            return p.y(this, uri, map);
        }
    };

    t[] createExtractors();

    t[] y(Uri uri, Map<String, List<String>> map);
}
