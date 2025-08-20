package org.fdroid.download;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;
/* compiled from: HttpPoster.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lorg/fdroid/download/HttpPoster;", "", "httpManager", "Lorg/fdroid/download/HttpManager;", "url", "", "(Lorg/fdroid/download/HttpManager;Ljava/lang/String;)V", "post", "", "json", "download_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class HttpPoster {
    private final HttpManager httpManager;
    private final String url;

    public HttpPoster(HttpManager httpManager, String url) {
        Intrinsics.checkNotNullParameter(httpManager, "httpManager");
        Intrinsics.checkNotNullParameter(url, "url");
        this.httpManager = httpManager;
        this.url = url;
    }

    public final void post(String json) throws IOException {
        Intrinsics.checkNotNullParameter(json, "json");
        BuildersKt__BuildersKt.runBlocking$default(null, new HttpPoster$post$1(this, json, null), 1, null);
    }
}
