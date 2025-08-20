package androidx.compose.ui.text.platform;

import android.text.style.URLSpan;
import androidx.compose.ui.text.UrlAnnotation;
import java.util.WeakHashMap;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: URLSpanCache.kt */
/* loaded from: classes.dex */
public final class URLSpanCache {
    private final WeakHashMap spansByAnnotation = new WeakHashMap();

    public final URLSpan toURLSpan(UrlAnnotation urlAnnotation) {
        Intrinsics.checkNotNullParameter(urlAnnotation, "urlAnnotation");
        WeakHashMap weakHashMap = this.spansByAnnotation;
        Object obj = weakHashMap.get(urlAnnotation);
        if (obj == null) {
            obj = new URLSpan(urlAnnotation.getUrl());
            weakHashMap.put(urlAnnotation, obj);
        }
        return (URLSpan) obj;
    }
}
