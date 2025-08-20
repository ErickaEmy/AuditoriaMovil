package org.fdroid.index;

import kotlin.Metadata;
import org.fdroid.database.Repository;
/* compiled from: IndexUpdater.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&J \u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH&¨\u0006\r"}, d2 = {"Lorg/fdroid/index/IndexUpdateListener;", "", "onDownloadProgress", "", "repo", "Lorg/fdroid/database/Repository;", "bytesRead", "", "totalBytes", "onUpdateProgress", "appsProcessed", "", "totalApps", "database_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IndexUpdateListener {
    void onDownloadProgress(Repository repository, long j, long j2);

    void onUpdateProgress(Repository repository, int i, int i2);
}
