package org.fdroid.repo;

import android.net.Uri;
import androidx.core.os.LocaleListCompat;
import java.io.File;
import java.io.InputStream;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationException;
import org.fdroid.database.Repository;
import org.fdroid.download.DownloaderFactory;
import org.fdroid.fdroid.nearby.peers.BonjourPeer;
import org.fdroid.index.IndexConverter;
import org.fdroid.index.IndexFormatVersion;
import org.fdroid.index.IndexParser;
import org.fdroid.index.IndexParserKt;
import org.fdroid.index.RepoUriBuilder;
import org.fdroid.index.SigningException;
import org.fdroid.index.TempFileProvider;
import org.fdroid.index.v1.IndexV1;
import org.fdroid.index.v1.IndexV1UpdaterKt;
import org.fdroid.index.v1.IndexV1Verifier;
import org.fdroid.index.v2.FileV2;
import org.fdroid.index.v2.IndexV2;
import org.fdroid.index.v2.PackageV2;
/* compiled from: RepoV1Fetcher.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ0\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096@¢\u0006\u0002\u0010\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lorg/fdroid/repo/RepoV1Fetcher;", "Lorg/fdroid/repo/RepoFetcher;", "tempFileProvider", "Lorg/fdroid/index/TempFileProvider;", "downloaderFactory", "Lorg/fdroid/download/DownloaderFactory;", "repoUriBuilder", "Lorg/fdroid/index/RepoUriBuilder;", "(Lorg/fdroid/index/TempFileProvider;Lorg/fdroid/download/DownloaderFactory;Lorg/fdroid/index/RepoUriBuilder;)V", "locales", "Landroidx/core/os/LocaleListCompat;", "fetchRepo", "", "uri", "Landroid/net/Uri;", "repo", "Lorg/fdroid/database/Repository;", "receiver", "Lorg/fdroid/repo/RepoPreviewReceiver;", BonjourPeer.FINGERPRINT, "", "(Landroid/net/Uri;Lorg/fdroid/database/Repository;Lorg/fdroid/repo/RepoPreviewReceiver;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "database_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RepoV1Fetcher implements RepoFetcher {
    private final DownloaderFactory downloaderFactory;
    private final LocaleListCompat locales;
    private final RepoUriBuilder repoUriBuilder;
    private final TempFileProvider tempFileProvider;

    public RepoV1Fetcher(TempFileProvider tempFileProvider, DownloaderFactory downloaderFactory, RepoUriBuilder repoUriBuilder) {
        Intrinsics.checkNotNullParameter(tempFileProvider, "tempFileProvider");
        Intrinsics.checkNotNullParameter(downloaderFactory, "downloaderFactory");
        Intrinsics.checkNotNullParameter(repoUriBuilder, "repoUriBuilder");
        this.tempFileProvider = tempFileProvider;
        this.downloaderFactory = downloaderFactory;
        this.repoUriBuilder = repoUriBuilder;
        LocaleListCompat localeListCompat = LocaleListCompat.getDefault();
        Intrinsics.checkNotNullExpressionValue(localeListCompat, "getDefault(...)");
        this.locales = localeListCompat;
    }

    @Override // org.fdroid.repo.RepoFetcher
    public Object fetchRepo(Uri uri, Repository repository, RepoPreviewReceiver repoPreviewReceiver, String str, Continuation continuation) throws SigningException, SerializationException {
        File createTempFile = this.tempFileProvider.createTempFile();
        try {
            this.downloaderFactory.create(repository, this.repoUriBuilder.getUri(repository, IndexV1UpdaterKt.SIGNED_FILE_NAME), FileV2.Companion.fromPath("/index-v1.jar"), createTempFile).download();
            Pair streamAndVerify = new IndexV1Verifier(createTempFile, null, str).getStreamAndVerify(new Function1() { // from class: org.fdroid.repo.RepoV1Fetcher$fetchRepo$2
                @Override // kotlin.jvm.functions.Function1
                public final IndexV1 invoke(InputStream inputStream) {
                    Intrinsics.checkNotNullParameter(inputStream, "inputStream");
                    return IndexParserKt.parseV1(IndexParser.INSTANCE, inputStream);
                }
            });
            createTempFile.delete();
            String str2 = (String) streamAndVerify.component1();
            IndexV1 indexV1 = (IndexV1) streamAndVerify.component2();
            int version = indexV1.getRepo().getVersion();
            IndexV2 indexV2 = new IndexConverter(null, 1, null).toIndexV2(indexV1);
            repoPreviewReceiver.onRepoReceived(RepoV2StreamReceiver.Companion.getRepository(indexV2.getRepo(), version, IndexFormatVersion.ONE, str2, repository.getUsername(), repository.getPassword()));
            for (Map.Entry<String, PackageV2> entry : indexV2.getPackages().entrySet()) {
                repoPreviewReceiver.onAppReceived(RepoV2StreamReceiver.Companion.getAppOverViewItem(entry.getKey(), entry.getValue(), this.locales));
            }
            return Unit.INSTANCE;
        } catch (Throwable th) {
            createTempFile.delete();
            throw th;
        }
    }
}
