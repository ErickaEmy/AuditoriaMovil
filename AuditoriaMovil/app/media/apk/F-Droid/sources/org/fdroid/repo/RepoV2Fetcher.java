package org.fdroid.repo;

import java.net.Proxy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mu.KLogger;
import mu.KotlinLogging;
import org.fdroid.download.DownloaderFactory;
import org.fdroid.download.HttpManager;
import org.fdroid.fdroid.nearby.peers.BonjourPeer;
import org.fdroid.index.RepoUriBuilder;
import org.fdroid.index.TempFileProvider;
/* compiled from: RepoV2Fetcher.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ0\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096@¢\u0006\u0002\u0010\u0019R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lorg/fdroid/repo/RepoV2Fetcher;", "Lorg/fdroid/repo/RepoFetcher;", "tempFileProvider", "Lorg/fdroid/index/TempFileProvider;", "downloaderFactory", "Lorg/fdroid/download/DownloaderFactory;", "httpManager", "Lorg/fdroid/download/HttpManager;", "repoUriBuilder", "Lorg/fdroid/index/RepoUriBuilder;", "proxy", "Ljava/net/Proxy;", "(Lorg/fdroid/index/TempFileProvider;Lorg/fdroid/download/DownloaderFactory;Lorg/fdroid/download/HttpManager;Lorg/fdroid/index/RepoUriBuilder;Ljava/net/Proxy;)V", "log", "Lmu/KLogger;", "fetchRepo", "", "uri", "Landroid/net/Uri;", "repo", "Lorg/fdroid/database/Repository;", "receiver", "Lorg/fdroid/repo/RepoPreviewReceiver;", BonjourPeer.FINGERPRINT, "", "(Landroid/net/Uri;Lorg/fdroid/database/Repository;Lorg/fdroid/repo/RepoPreviewReceiver;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "database_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RepoV2Fetcher implements RepoFetcher {
    private final DownloaderFactory downloaderFactory;
    private final HttpManager httpManager;
    private final KLogger log;
    private final Proxy proxy;
    private final RepoUriBuilder repoUriBuilder;
    private final TempFileProvider tempFileProvider;

    public RepoV2Fetcher(TempFileProvider tempFileProvider, DownloaderFactory downloaderFactory, HttpManager httpManager, RepoUriBuilder repoUriBuilder, Proxy proxy) {
        Intrinsics.checkNotNullParameter(tempFileProvider, "tempFileProvider");
        Intrinsics.checkNotNullParameter(downloaderFactory, "downloaderFactory");
        Intrinsics.checkNotNullParameter(httpManager, "httpManager");
        Intrinsics.checkNotNullParameter(repoUriBuilder, "repoUriBuilder");
        this.tempFileProvider = tempFileProvider;
        this.downloaderFactory = downloaderFactory;
        this.httpManager = httpManager;
        this.repoUriBuilder = repoUriBuilder;
        this.proxy = proxy;
        this.log = KotlinLogging.INSTANCE.logger(new Function0() { // from class: org.fdroid.repo.RepoV2Fetcher$log$1
            /* renamed from: invoke  reason: collision with other method in class */
            public final void m2672invoke() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m2672invoke();
                return Unit.INSTANCE;
            }
        });
    }

    public /* synthetic */ RepoV2Fetcher(TempFileProvider tempFileProvider, DownloaderFactory downloaderFactory, HttpManager httpManager, RepoUriBuilder repoUriBuilder, Proxy proxy, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(tempFileProvider, downloaderFactory, httpManager, repoUriBuilder, (i & 16) != 0 ? null : proxy);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x014c  */
    @Override // org.fdroid.repo.RepoFetcher
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object fetchRepo(android.net.Uri r22, org.fdroid.database.Repository r23, org.fdroid.repo.RepoPreviewReceiver r24, java.lang.String r25, kotlin.coroutines.Continuation r26) throws org.fdroid.index.SigningException {
        /*
            Method dump skipped, instructions count: 385
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.fdroid.repo.RepoV2Fetcher.fetchRepo(android.net.Uri, org.fdroid.database.Repository, org.fdroid.repo.RepoPreviewReceiver, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
