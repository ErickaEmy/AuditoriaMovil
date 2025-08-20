package okhttp3;

import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CookieJar.kt */
/* loaded from: classes2.dex */
public interface CookieJar {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final CookieJar NO_COOKIES = new Companion.NoCookies();

    List loadForRequest(HttpUrl httpUrl);

    void saveFromResponse(HttpUrl httpUrl, List list);

    /* compiled from: CookieJar.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        /* compiled from: CookieJar.kt */
        /* loaded from: classes2.dex */
        private static final class NoCookies implements CookieJar {
            @Override // okhttp3.CookieJar
            public void saveFromResponse(HttpUrl url, List cookies) {
                Intrinsics.checkNotNullParameter(url, "url");
                Intrinsics.checkNotNullParameter(cookies, "cookies");
            }

            @Override // okhttp3.CookieJar
            public List loadForRequest(HttpUrl url) {
                List emptyList;
                Intrinsics.checkNotNullParameter(url, "url");
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                return emptyList;
            }
        }
    }
}
