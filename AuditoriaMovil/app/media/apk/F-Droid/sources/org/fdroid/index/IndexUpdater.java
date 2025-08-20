package org.fdroid.index;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.fdroid.database.Repository;
import org.fdroid.download.NotFoundException;
import org.fdroid.index.IndexUpdateResult;
/* compiled from: IndexUpdater.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\nH\u0002J\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH$R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lorg/fdroid/index/IndexUpdater;", "", "()V", "formatVersion", "Lorg/fdroid/index/IndexFormatVersion;", "getFormatVersion", "()Lorg/fdroid/index/IndexFormatVersion;", "catchExceptions", "Lorg/fdroid/index/IndexUpdateResult;", "block", "Lkotlin/Function0;", "update", "repo", "Lorg/fdroid/database/Repository;", "updateRepo", "database_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class IndexUpdater {
    public abstract IndexFormatVersion getFormatVersion();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract IndexUpdateResult updateRepo(Repository repository);

    public final IndexUpdateResult update(final Repository repo) {
        Intrinsics.checkNotNullParameter(repo, "repo");
        return catchExceptions(new Function0() { // from class: org.fdroid.index.IndexUpdater$update$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final IndexUpdateResult invoke() {
                return IndexUpdater.this.updateRepo(repo);
            }
        });
    }

    private final IndexUpdateResult catchExceptions(Function0 function0) {
        try {
            return (IndexUpdateResult) function0.invoke();
        } catch (NotFoundException unused) {
            return IndexUpdateResult.NotFound.INSTANCE;
        } catch (Exception e) {
            return new IndexUpdateResult.Error(e);
        }
    }
}
