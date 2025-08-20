package org.fdroid.index.v1;

import java.io.File;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mu.KLogger;
import mu.KotlinLogging;
import org.fdroid.CompatibilityChecker;
import org.fdroid.database.DbV1StreamReceiver;
import org.fdroid.database.FDroidDatabase;
import org.fdroid.database.FDroidDatabaseInt;
import org.fdroid.database.Repository;
import org.fdroid.database.RepositoryDaoInt;
import org.fdroid.database.RepositoryPreferences;
import org.fdroid.download.Downloader;
import org.fdroid.download.DownloaderFactory;
import org.fdroid.index.IndexFormatVersion;
import org.fdroid.index.IndexUpdateListener;
import org.fdroid.index.IndexUpdateResult;
import org.fdroid.index.IndexUpdater;
import org.fdroid.index.IndexUpdaterKt;
import org.fdroid.index.RepoUriBuilder;
import org.fdroid.index.TempFileProvider;
import org.fdroid.index.v2.FileV2;
/* compiled from: IndexV1Updater.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lorg/fdroid/index/v1/IndexV1Updater;", "Lorg/fdroid/index/IndexUpdater;", "database", "Lorg/fdroid/database/FDroidDatabase;", "tempFileProvider", "Lorg/fdroid/index/TempFileProvider;", "downloaderFactory", "Lorg/fdroid/download/DownloaderFactory;", "repoUriBuilder", "Lorg/fdroid/index/RepoUriBuilder;", "compatibilityChecker", "Lorg/fdroid/CompatibilityChecker;", "listener", "Lorg/fdroid/index/IndexUpdateListener;", "(Lorg/fdroid/database/FDroidDatabase;Lorg/fdroid/index/TempFileProvider;Lorg/fdroid/download/DownloaderFactory;Lorg/fdroid/index/RepoUriBuilder;Lorg/fdroid/CompatibilityChecker;Lorg/fdroid/index/IndexUpdateListener;)V", "db", "Lorg/fdroid/database/FDroidDatabaseInt;", "formatVersion", "Lorg/fdroid/index/IndexFormatVersion;", "getFormatVersion", "()Lorg/fdroid/index/IndexFormatVersion;", "log", "Lmu/KLogger;", "updateRepo", "Lorg/fdroid/index/IndexUpdateResult;", "repo", "Lorg/fdroid/database/Repository;", "database_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class IndexV1Updater extends IndexUpdater {
    private final CompatibilityChecker compatibilityChecker;
    private final FDroidDatabaseInt db;
    private final DownloaderFactory downloaderFactory;
    private final IndexFormatVersion formatVersion;
    private final IndexUpdateListener listener;
    private final KLogger log;
    private final RepoUriBuilder repoUriBuilder;
    private final TempFileProvider tempFileProvider;

    @Override // org.fdroid.index.IndexUpdater
    public IndexFormatVersion getFormatVersion() {
        return this.formatVersion;
    }

    public /* synthetic */ IndexV1Updater(FDroidDatabase fDroidDatabase, TempFileProvider tempFileProvider, DownloaderFactory downloaderFactory, RepoUriBuilder repoUriBuilder, CompatibilityChecker compatibilityChecker, IndexUpdateListener indexUpdateListener, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(fDroidDatabase, tempFileProvider, downloaderFactory, (i & 8) != 0 ? IndexUpdaterKt.getDefaultRepoUriBuilder() : repoUriBuilder, compatibilityChecker, (i & 32) != 0 ? null : indexUpdateListener);
    }

    public IndexV1Updater(FDroidDatabase database, TempFileProvider tempFileProvider, DownloaderFactory downloaderFactory, RepoUriBuilder repoUriBuilder, CompatibilityChecker compatibilityChecker, IndexUpdateListener indexUpdateListener) {
        Intrinsics.checkNotNullParameter(database, "database");
        Intrinsics.checkNotNullParameter(tempFileProvider, "tempFileProvider");
        Intrinsics.checkNotNullParameter(downloaderFactory, "downloaderFactory");
        Intrinsics.checkNotNullParameter(repoUriBuilder, "repoUriBuilder");
        Intrinsics.checkNotNullParameter(compatibilityChecker, "compatibilityChecker");
        this.tempFileProvider = tempFileProvider;
        this.downloaderFactory = downloaderFactory;
        this.repoUriBuilder = repoUriBuilder;
        this.compatibilityChecker = compatibilityChecker;
        this.listener = indexUpdateListener;
        this.log = KotlinLogging.INSTANCE.logger(new Function0() { // from class: org.fdroid.index.v1.IndexV1Updater$log$1
            /* renamed from: invoke  reason: collision with other method in class */
            public final void m2670invoke() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m2670invoke();
                return Unit.INSTANCE;
            }
        });
        this.formatVersion = IndexFormatVersion.ONE;
        this.db = (FDroidDatabaseInt) database;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.fdroid.index.IndexUpdater
    public IndexUpdateResult updateRepo(final Repository repo) {
        Intrinsics.checkNotNullParameter(repo, "repo");
        if (repo.getFormatVersion() != null && repo.getFormatVersion() != IndexFormatVersion.ONE) {
            this.log.error(new Function0() { // from class: org.fdroid.index.v1.IndexV1Updater$updateRepo$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    String address = Repository.this.getAddress();
                    return "Format downgrade for " + address;
                }
            });
        }
        File createTempFile = this.tempFileProvider.createTempFile();
        Downloader createWithTryFirstMirror = this.downloaderFactory.createWithTryFirstMirror(repo, this.repoUriBuilder.getUri(repo, IndexV1UpdaterKt.SIGNED_FILE_NAME), FileV2.Companion.fromPath("/index-v1.jar"), createTempFile);
        createWithTryFirstMirror.setCacheTag(repo.getLastETag());
        IndexUpdaterKt.setIndexUpdateListener(createWithTryFirstMirror, this.listener, repo);
        try {
            createWithTryFirstMirror.download();
            if (createWithTryFirstMirror.hasChanged()) {
                final String cacheTag = createWithTryFirstMirror.getCacheTag();
                final IndexV1Verifier indexV1Verifier = new IndexV1Verifier(createTempFile, repo.getCertificate(), null);
                this.db.runInTransaction(new Runnable() { // from class: org.fdroid.index.v1.IndexV1Updater$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        IndexV1Updater.updateRepo$lambda$1(IndexV1Verifier.this, this, repo, cacheTag);
                    }
                });
                createTempFile.delete();
                return IndexUpdateResult.Processed.INSTANCE;
            }
            return IndexUpdateResult.Unchanged.INSTANCE;
        } catch (OldIndexException e) {
            if (e.isSameTimestamp()) {
                return IndexUpdateResult.Unchanged.INSTANCE;
            }
            throw e;
        } finally {
            createTempFile.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateRepo$lambda$1(IndexV1Verifier verifier, final IndexV1Updater this$0, final Repository repo, String str) {
        RepositoryPreferences copy;
        Intrinsics.checkNotNullParameter(verifier, "$verifier");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(repo, "$repo");
        verifier.getStreamAndVerify(new Function1() { // from class: org.fdroid.index.v1.IndexV1Updater$updateRepo$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InputStream) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(InputStream inputStream) {
                IndexUpdateListener indexUpdateListener;
                FDroidDatabaseInt fDroidDatabaseInt;
                CompatibilityChecker compatibilityChecker;
                Intrinsics.checkNotNullParameter(inputStream, "inputStream");
                indexUpdateListener = IndexV1Updater.this.listener;
                if (indexUpdateListener != null) {
                    indexUpdateListener.onUpdateProgress(repo, 0, 0);
                }
                fDroidDatabaseInt = IndexV1Updater.this.db;
                long repoId = repo.getRepoId();
                compatibilityChecker = IndexV1Updater.this.compatibilityChecker;
                new IndexV1StreamProcessor(new DbV1StreamReceiver(fDroidDatabaseInt, repoId, compatibilityChecker), repo.getTimestamp(), null, null, 12, null).process(inputStream);
            }
        });
        RepositoryDaoInt repositoryDao = this$0.db.getRepositoryDao();
        copy = r1.copy((r22 & 1) != 0 ? r1.repoId : 0L, (r22 & 2) != 0 ? r1.weight : 0, (r22 & 4) != 0 ? r1.enabled : false, (r22 & 8) != 0 ? r1.lastUpdated : Long.valueOf(System.currentTimeMillis()), (r22 & 16) != 0 ? r1.lastETag : str, (r22 & 32) != 0 ? r1.userMirrors : null, (r22 & 64) != 0 ? r1.disabledMirrors : null, (r22 & 128) != 0 ? r1.username : null, (r22 & 256) != 0 ? repo.getPreferences$database_release().password : null);
        repositoryDao.updateRepositoryPreferences(copy);
    }
}
