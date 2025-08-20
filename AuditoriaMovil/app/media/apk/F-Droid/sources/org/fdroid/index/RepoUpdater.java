package org.fdroid.index;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mu.KLogger;
import mu.KotlinLogging;
import org.fdroid.CompatibilityChecker;
import org.fdroid.database.FDroidDatabase;
import org.fdroid.database.Repository;
import org.fdroid.download.DownloaderFactory;
import org.fdroid.index.IndexUpdateResult;
import org.fdroid.index.v1.IndexV1Updater;
import org.fdroid.index.v2.IndexV2Updater;
/* compiled from: RepoUpdater.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J$\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00170\u001bH\u0002R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lorg/fdroid/index/RepoUpdater;", "", "tempDir", "Ljava/io/File;", "db", "Lorg/fdroid/database/FDroidDatabase;", "downloaderFactory", "Lorg/fdroid/download/DownloaderFactory;", "repoUriBuilder", "Lorg/fdroid/index/RepoUriBuilder;", "compatibilityChecker", "Lorg/fdroid/CompatibilityChecker;", "listener", "Lorg/fdroid/index/IndexUpdateListener;", "(Ljava/io/File;Lorg/fdroid/database/FDroidDatabase;Lorg/fdroid/download/DownloaderFactory;Lorg/fdroid/index/RepoUriBuilder;Lorg/fdroid/CompatibilityChecker;Lorg/fdroid/index/IndexUpdateListener;)V", "indexUpdater", "", "Lorg/fdroid/index/IndexUpdater;", "log", "Lmu/KLogger;", "tempFileProvider", "Lorg/fdroid/index/TempFileProvider;", "update", "Lorg/fdroid/index/IndexUpdateResult;", "repo", "Lorg/fdroid/database/Repository;", "doUpdate", "Lkotlin/Function1;", "database_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RepoUpdater {
    private final List<IndexUpdater> indexUpdater;
    private final KLogger log;
    private final TempFileProvider tempFileProvider;

    public RepoUpdater(final File tempDir, FDroidDatabase db, DownloaderFactory downloaderFactory, RepoUriBuilder repoUriBuilder, CompatibilityChecker compatibilityChecker, IndexUpdateListener listener) {
        List<IndexUpdater> listOf;
        Intrinsics.checkNotNullParameter(tempDir, "tempDir");
        Intrinsics.checkNotNullParameter(db, "db");
        Intrinsics.checkNotNullParameter(downloaderFactory, "downloaderFactory");
        Intrinsics.checkNotNullParameter(repoUriBuilder, "repoUriBuilder");
        Intrinsics.checkNotNullParameter(compatibilityChecker, "compatibilityChecker");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.log = KotlinLogging.INSTANCE.logger(new Function0() { // from class: org.fdroid.index.RepoUpdater$log$1
            /* renamed from: invoke  reason: collision with other method in class */
            public final void m2668invoke() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m2668invoke();
                return Unit.INSTANCE;
            }
        });
        TempFileProvider tempFileProvider = new TempFileProvider() { // from class: org.fdroid.index.RepoUpdater$$ExternalSyntheticLambda0
            @Override // org.fdroid.index.TempFileProvider
            public final File createTempFile() {
                File tempFileProvider$lambda$0;
                tempFileProvider$lambda$0 = RepoUpdater.tempFileProvider$lambda$0(tempDir);
                return tempFileProvider$lambda$0;
            }
        };
        this.tempFileProvider = tempFileProvider;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new IndexUpdater[]{new IndexV2Updater(db, tempFileProvider, downloaderFactory, repoUriBuilder, compatibilityChecker, listener), new IndexV1Updater(db, tempFileProvider, downloaderFactory, repoUriBuilder, compatibilityChecker, listener)});
        this.indexUpdater = listOf;
    }

    public /* synthetic */ RepoUpdater(File file, FDroidDatabase fDroidDatabase, DownloaderFactory downloaderFactory, RepoUriBuilder repoUriBuilder, CompatibilityChecker compatibilityChecker, IndexUpdateListener indexUpdateListener, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(file, fDroidDatabase, downloaderFactory, (i & 8) != 0 ? IndexUpdaterKt.getDefaultRepoUriBuilder() : repoUriBuilder, compatibilityChecker, indexUpdateListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final File tempFileProvider$lambda$0(File tempDir) {
        Intrinsics.checkNotNullParameter(tempDir, "$tempDir");
        File createTempFile = File.createTempFile("dl-", "", tempDir);
        Intrinsics.checkNotNullExpressionValue(createTempFile, "createTempFile(...)");
        return createTempFile;
    }

    public final IndexUpdateResult update(final Repository repo) {
        Intrinsics.checkNotNullParameter(repo, "repo");
        return update(repo, new Function1() { // from class: org.fdroid.index.RepoUpdater$update$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final IndexUpdateResult invoke(IndexUpdater updater) {
                Intrinsics.checkNotNullParameter(updater, "updater");
                return updater.update(Repository.this);
            }
        });
    }

    private final IndexUpdateResult update(final Repository repository, Function1 function1) {
        for (IndexUpdater indexUpdater : this.indexUpdater) {
            IndexFormatVersion formatVersion = repository.getFormatVersion();
            if (formatVersion != null && formatVersion.compareTo(indexUpdater.getFormatVersion()) > 0) {
                final String name = indexUpdater.getFormatVersion().name();
                this.log.warn(new Function0() { // from class: org.fdroid.index.RepoUpdater$update$2$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        String str = name;
                        String address = repository.getAddress();
                        return "Not using updater " + str + " for repo " + address;
                    }
                });
            } else {
                IndexUpdateResult indexUpdateResult = (IndexUpdateResult) function1.invoke(indexUpdater);
                if (!Intrinsics.areEqual(indexUpdateResult, IndexUpdateResult.NotFound.INSTANCE)) {
                    return indexUpdateResult;
                }
            }
        }
        String address = repository.getAddress();
        return new IndexUpdateResult.Error(new FileNotFoundException("No files found for " + address));
    }
}
