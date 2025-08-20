package f8;

import android.net.Uri;
import java.io.IOException;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public final class d0 extends IOException {
    public final long bytesLoaded;
    public final kx.p dataSpec;
    public final Map<String, List<String>> responseHeaders;
    public final Uri uriAfterRedirects;

    public d0(kx.p pVar, Uri uri, Map<String, List<String>> map, long j2, Throwable th) {
        super(th);
        this.dataSpec = pVar;
        this.uriAfterRedirects = uri;
        this.responseHeaders = map;
        this.bytesLoaded = j2;
    }
}
