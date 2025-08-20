package org.fdroid.index.v2;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ConcurrentModificationException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.fdroid.CompatibilityChecker;
import org.fdroid.database.DbV2DiffStreamReceiver;
import org.fdroid.database.DbV2StreamReceiver;
import org.fdroid.database.FDroidDatabase;
import org.fdroid.database.FDroidDatabaseInt;
import org.fdroid.database.Repository;
import org.fdroid.database.RepositoryDaoInt;
import org.fdroid.database.RepositoryPreferences;
import org.fdroid.download.Downloader;
import org.fdroid.download.DownloaderFactory;
import org.fdroid.index.IndexFormatVersion;
import org.fdroid.index.IndexParser;
import org.fdroid.index.IndexParserKt;
import org.fdroid.index.IndexUpdateListener;
import org.fdroid.index.IndexUpdateResult;
import org.fdroid.index.IndexUpdater;
import org.fdroid.index.IndexUpdaterKt;
import org.fdroid.index.RepoUriBuilder;
import org.fdroid.index.TempFileProvider;
/* compiled from: IndexV2Updater.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ$\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00162\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0017H\u0002J(\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u0010$\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020\u001aH\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lorg/fdroid/index/v2/IndexV2Updater;", "Lorg/fdroid/index/IndexUpdater;", "database", "Lorg/fdroid/database/FDroidDatabase;", "tempFileProvider", "Lorg/fdroid/index/TempFileProvider;", "downloaderFactory", "Lorg/fdroid/download/DownloaderFactory;", "repoUriBuilder", "Lorg/fdroid/index/RepoUriBuilder;", "compatibilityChecker", "Lorg/fdroid/CompatibilityChecker;", "listener", "Lorg/fdroid/index/IndexUpdateListener;", "(Lorg/fdroid/database/FDroidDatabase;Lorg/fdroid/index/TempFileProvider;Lorg/fdroid/download/DownloaderFactory;Lorg/fdroid/index/RepoUriBuilder;Lorg/fdroid/CompatibilityChecker;Lorg/fdroid/index/IndexUpdateListener;)V", "db", "Lorg/fdroid/database/FDroidDatabaseInt;", "formatVersion", "Lorg/fdroid/index/IndexFormatVersion;", "getFormatVersion", "()Lorg/fdroid/index/IndexFormatVersion;", "getCertAndEntry", "Lkotlin/Pair;", "", "Lorg/fdroid/index/v2/Entry;", "repo", "Lorg/fdroid/database/Repository;", "certificate", "processStream", "Lorg/fdroid/index/IndexUpdateResult;", "entryFile", "Lorg/fdroid/index/v2/EntryFileV2;", "repoVersion", "", "streamProcessor", "Lorg/fdroid/index/v2/IndexV2StreamProcessor;", "updateRepo", "database_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class IndexV2Updater extends IndexUpdater {
    private final CompatibilityChecker compatibilityChecker;
    private final FDroidDatabaseInt db;
    private final DownloaderFactory downloaderFactory;
    private final IndexFormatVersion formatVersion;
    private final IndexUpdateListener listener;
    private final RepoUriBuilder repoUriBuilder;
    private final TempFileProvider tempFileProvider;

    @Override // org.fdroid.index.IndexUpdater
    public IndexFormatVersion getFormatVersion() {
        return this.formatVersion;
    }

    public /* synthetic */ IndexV2Updater(FDroidDatabase fDroidDatabase, TempFileProvider tempFileProvider, DownloaderFactory downloaderFactory, RepoUriBuilder repoUriBuilder, CompatibilityChecker compatibilityChecker, IndexUpdateListener indexUpdateListener, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(fDroidDatabase, tempFileProvider, downloaderFactory, (i & 8) != 0 ? IndexUpdaterKt.getDefaultRepoUriBuilder() : repoUriBuilder, compatibilityChecker, (i & 32) != 0 ? null : indexUpdateListener);
    }

    public IndexV2Updater(FDroidDatabase database, TempFileProvider tempFileProvider, DownloaderFactory downloaderFactory, RepoUriBuilder repoUriBuilder, CompatibilityChecker compatibilityChecker, IndexUpdateListener indexUpdateListener) {
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
        this.formatVersion = IndexFormatVersion.TWO;
        this.db = (FDroidDatabaseInt) database;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.fdroid.index.IndexUpdater
    public IndexUpdateResult updateRepo(Repository repo) {
        Intrinsics.checkNotNullParameter(repo, "repo");
        Entry entry = (Entry) getCertAndEntry(repo, repo.getCertificate()).component2();
        if (entry.getTimestamp() <= repo.getTimestamp()) {
            return IndexUpdateResult.Unchanged.INSTANCE;
        }
        EntryFileV2 diff = entry.getDiff(repo.getTimestamp());
        if (diff == null || repo.getFormatVersion() == IndexFormatVersion.ONE) {
            return processStream(repo, entry.getIndex(), entry.getVersion(), new IndexV2FullStreamProcessor(new DbV2StreamReceiver(this.db, repo.getRepoId(), this.compatibilityChecker), null, 2, null));
        }
        return processStream(repo, diff, entry.getVersion(), new IndexV2DiffStreamProcessor(new DbV2DiffStreamReceiver(this.db, repo.getRepoId(), this.compatibilityChecker), null, 2, null));
    }

    private final Pair getCertAndEntry(Repository repository, String str) {
        File createTempFile = this.tempFileProvider.createTempFile();
        Downloader createWithTryFirstMirror = this.downloaderFactory.createWithTryFirstMirror(repository, this.repoUriBuilder.getUri(repository, IndexV2UpdaterKt.SIGNED_FILE_NAME), FileV2.Companion.fromPath("/entry.jar"), createTempFile);
        IndexUpdaterKt.setIndexUpdateListener(createWithTryFirstMirror, this.listener, repository);
        try {
            createWithTryFirstMirror.download();
            return new EntryVerifier(createTempFile, str, null).getStreamAndVerify(new Function1() { // from class: org.fdroid.index.v2.IndexV2Updater$getCertAndEntry$1
                @Override // kotlin.jvm.functions.Function1
                public final Entry invoke(InputStream inputStream) {
                    Intrinsics.checkNotNullParameter(inputStream, "inputStream");
                    return IndexParserKt.parseEntry(IndexParser.INSTANCE, inputStream);
                }
            });
        } finally {
            createTempFile.delete();
        }
    }

    private final IndexUpdateResult processStream(final Repository repository, final EntryFileV2 entryFileV2, final long j, final IndexV2StreamProcessor indexV2StreamProcessor) {
        String trimStart;
        File createTempFile = this.tempFileProvider.createTempFile();
        DownloaderFactory downloaderFactory = this.downloaderFactory;
        RepoUriBuilder repoUriBuilder = this.repoUriBuilder;
        trimStart = StringsKt__StringsKt.trimStart(entryFileV2.getName(), '/');
        Downloader createWithTryFirstMirror = downloaderFactory.createWithTryFirstMirror(repository, repoUriBuilder.getUri(repository, trimStart), entryFileV2, createTempFile);
        IndexUpdaterKt.setIndexUpdateListener(createWithTryFirstMirror, this.listener, repository);
        try {
            createWithTryFirstMirror.download();
            final FileInputStream fileInputStream = new FileInputStream(createTempFile);
            final RepositoryDaoInt repositoryDao = this.db.getRepositoryDao();
            this.db.runInTransaction(new Runnable() { // from class: org.fdroid.index.v2.IndexV2Updater$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    IndexV2Updater.processStream$lambda$3$lambda$2(RepositoryDaoInt.this, repository, indexV2StreamProcessor, j, fileInputStream, this, entryFileV2);
                }
            });
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(fileInputStream, null);
            createTempFile.delete();
            return IndexUpdateResult.Processed.INSTANCE;
        } catch (Throwable th) {
            createTempFile.delete();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void processStream$lambda$3$lambda$2(RepositoryDaoInt repoDao, final Repository repo, IndexV2StreamProcessor streamProcessor, long j, FileInputStream inputStream, final IndexV2Updater this$0, final EntryFileV2 entryFile) {
        RepositoryPreferences copy;
        Intrinsics.checkNotNullParameter(repoDao, "$repoDao");
        Intrinsics.checkNotNullParameter(repo, "$repo");
        Intrinsics.checkNotNullParameter(streamProcessor, "$streamProcessor");
        Intrinsics.checkNotNullParameter(inputStream, "$inputStream");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(entryFile, "$entryFile");
        Repository repository = repoDao.getRepository(repo.getRepoId());
        Long valueOf = repository != null ? Long.valueOf(repository.getTimestamp()) : null;
        long timestamp = repo.getTimestamp();
        if (valueOf == null || valueOf.longValue() != timestamp) {
            long timestamp2 = repo.getTimestamp();
            throw new ConcurrentModificationException("Repo timestamp expected " + timestamp2 + ", but was " + valueOf);
        }
        streamProcessor.process(j, inputStream, new Function1() { // from class: org.fdroid.index.v2.IndexV2Updater$processStream$1$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Number) obj).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i) {
                IndexUpdateListener indexUpdateListener;
                indexUpdateListener = IndexV2Updater.this.listener;
                if (indexUpdateListener != null) {
                    indexUpdateListener.onUpdateProgress(repo, i, entryFile.getNumPackages());
                }
            }
        });
        RepositoryPreferences repositoryPreferences = repoDao.getRepositoryPreferences(repo.getRepoId());
        if (repositoryPreferences == null) {
            long repoId = repo.getRepoId();
            throw new IllegalStateException(("No repo prefs for " + repoId).toString());
        }
        copy = repositoryPreferences.copy((r22 & 1) != 0 ? repositoryPreferences.repoId : 0L, (r22 & 2) != 0 ? repositoryPreferences.weight : 0, (r22 & 4) != 0 ? repositoryPreferences.enabled : false, (r22 & 8) != 0 ? repositoryPreferences.lastUpdated : Long.valueOf(System.currentTimeMillis()), (r22 & 16) != 0 ? repositoryPreferences.lastETag : null, (r22 & 32) != 0 ? repositoryPreferences.userMirrors : null, (r22 & 64) != 0 ? repositoryPreferences.disabledMirrors : null, (r22 & 128) != 0 ? repositoryPreferences.username : null, (r22 & 256) != 0 ? repositoryPreferences.password : null);
        repoDao.updateRepositoryPreferences(copy);
    }
}
