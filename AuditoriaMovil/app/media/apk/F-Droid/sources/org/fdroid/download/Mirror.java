package org.fdroid.download;

import androidx.compose.foundation.ClickableElement$$ExternalSyntheticBackport0;
import io.ktor.http.URLBuilder;
import io.ktor.http.URLBuilderKt;
import io.ktor.http.URLParserException;
import io.ktor.http.URLUtilsKt;
import io.ktor.http.Url;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mu.KLogger;
import mu.KotlinLogging;
import org.fdroid.fdroid.nearby.peers.BonjourPeer;
/* compiled from: Mirror.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J)\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\u0006\u0010\u001b\u001a\u00020\u0006J\u0006\u0010\u001c\u001a\u00020\u0006J\u0006\u0010\u001d\u001a\u00020\u0006J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u001b\u0010\f\u001a\u00020\r8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f¨\u0006 "}, d2 = {"Lorg/fdroid/download/Mirror;", "", "baseUrl", "", "location", "isIpfsGateway", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getBaseUrl", "()Ljava/lang/String;", "()Z", "getLocation", "url", "Lio/ktor/http/Url;", "getUrl", "()Lio/ktor/http/Url;", "url$delegate", "Lkotlin/Lazy;", "component1", "component2", "component3", "copy", "equals", "other", BonjourPeer.PATH, "hashCode", "", "isHttp", "isLocal", "isOnion", "toString", "Companion", "download_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class Mirror {
    public static final Companion Companion = new Companion(null);
    private final String baseUrl;
    private final boolean isIpfsGateway;
    private final String location;
    private final Lazy url$delegate;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Mirror(String baseUrl) {
        this(baseUrl, null, false, 6, null);
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Mirror(String baseUrl, String str) {
        this(baseUrl, str, false, 4, null);
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
    }

    public static /* synthetic */ Mirror copy$default(Mirror mirror, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mirror.baseUrl;
        }
        if ((i & 2) != 0) {
            str2 = mirror.location;
        }
        if ((i & 4) != 0) {
            z = mirror.isIpfsGateway;
        }
        return mirror.copy(str, str2, z);
    }

    public static final List<Mirror> fromStrings(List<String> list) {
        return Companion.fromStrings(list);
    }

    public final String component1() {
        return this.baseUrl;
    }

    public final String component2() {
        return this.location;
    }

    public final boolean component3() {
        return this.isIpfsGateway;
    }

    public final Mirror copy(String baseUrl, String str, boolean z) {
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        return new Mirror(baseUrl, str, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Mirror) {
            Mirror mirror = (Mirror) obj;
            return Intrinsics.areEqual(this.baseUrl, mirror.baseUrl) && Intrinsics.areEqual(this.location, mirror.location) && this.isIpfsGateway == mirror.isIpfsGateway;
        }
        return false;
    }

    public final String getBaseUrl() {
        return this.baseUrl;
    }

    public final String getLocation() {
        return this.location;
    }

    public int hashCode() {
        int hashCode = this.baseUrl.hashCode() * 31;
        String str = this.location;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + ClickableElement$$ExternalSyntheticBackport0.m(this.isIpfsGateway);
    }

    public final boolean isIpfsGateway() {
        return this.isIpfsGateway;
    }

    public String toString() {
        String str = this.baseUrl;
        String str2 = this.location;
        boolean z = this.isIpfsGateway;
        return "Mirror(baseUrl=" + str + ", location=" + str2 + ", isIpfsGateway=" + z + ")";
    }

    public Mirror(String baseUrl, String str, boolean z) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        this.baseUrl = baseUrl;
        this.location = str;
        this.isIpfsGateway = z;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: org.fdroid.download.Mirror$url$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Url invoke() {
                String trimEnd;
                try {
                    trimEnd = StringsKt__StringsKt.trimEnd(Mirror.this.getBaseUrl(), '/');
                    return URLUtilsKt.URLBuilder(trimEnd).build();
                } catch (URLParserException unused) {
                    KLogger logger = KotlinLogging.INSTANCE.logger(new Function0() { // from class: org.fdroid.download.Mirror$url$2$log$1
                        /* renamed from: invoke  reason: collision with other method in class */
                        public final void m2378invoke() {
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m2378invoke();
                            return Unit.INSTANCE;
                        }
                    });
                    final Mirror mirror = Mirror.this;
                    logger.warn(new Function0() { // from class: org.fdroid.download.Mirror$url$2.1
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            String baseUrl2 = Mirror.this.getBaseUrl();
                            return "Someone gave us an invalid URL: " + baseUrl2;
                        }
                    });
                    return URLUtilsKt.URLBuilder("http://127.0.0.1:64335").build();
                } catch (IllegalArgumentException unused2) {
                    KLogger logger2 = KotlinLogging.INSTANCE.logger(new Function0() { // from class: org.fdroid.download.Mirror$url$2$log$2
                        /* renamed from: invoke  reason: collision with other method in class */
                        public final void m2379invoke() {
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m2379invoke();
                            return Unit.INSTANCE;
                        }
                    });
                    final Mirror mirror2 = Mirror.this;
                    logger2.warn(new Function0() { // from class: org.fdroid.download.Mirror$url$2.2
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            String baseUrl2 = Mirror.this.getBaseUrl();
                            return "Someone gave us an invalid URL: " + baseUrl2;
                        }
                    });
                    return URLUtilsKt.URLBuilder("http://127.0.0.1:64335").build();
                }
            }
        });
        this.url$delegate = lazy;
    }

    public /* synthetic */ Mirror(String str, String str2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? false : z);
    }

    public final Url getUrl() {
        return (Url) this.url$delegate.getValue();
    }

    public final Url getUrl(String path) {
        String trimStart;
        Intrinsics.checkNotNullParameter(path, "path");
        URLBuilder URLBuilder = URLUtilsKt.URLBuilder(getUrl());
        trimStart = StringsKt__StringsKt.trimStart(path, '/');
        return URLBuilderKt.appendPathSegments$default(URLBuilder, new String[]{trimStart}, false, 2, null).build();
    }

    public final boolean isOnion() {
        return MirrorKt.isOnion(getUrl());
    }

    public final boolean isLocal() {
        return MirrorKt.isLocal(getUrl());
    }

    public final boolean isHttp() {
        boolean startsWith$default;
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(getUrl().getProtocol().getName(), "http", false, 2, null);
        return startsWith$default;
    }

    /* compiled from: Mirror.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004H\u0007¨\u0006\b"}, d2 = {"Lorg/fdroid/download/Mirror$Companion;", "", "()V", "fromStrings", "", "Lorg/fdroid/download/Mirror;", "list", "", "download_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final List<Mirror> fromStrings(List<String> list) {
            int collectionSizeOrDefault;
            Intrinsics.checkNotNullParameter(list, "list");
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            for (String str : list) {
                arrayList.add(new Mirror(str, null, false, 6, null));
            }
            return arrayList;
        }
    }
}
