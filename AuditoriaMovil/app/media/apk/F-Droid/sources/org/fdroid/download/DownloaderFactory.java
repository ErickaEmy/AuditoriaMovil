package org.fdroid.download;

import android.net.Uri;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.fdroid.IndexFile;
import org.fdroid.database.Repository;
/* compiled from: DownloaderFactory.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&J@\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH$J&\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f¨\u0006\u0012"}, d2 = {"Lorg/fdroid/download/DownloaderFactory;", "", "()V", "create", "Lorg/fdroid/download/Downloader;", "repo", "Lorg/fdroid/database/Repository;", "uri", "Landroid/net/Uri;", "indexFile", "Lorg/fdroid/IndexFile;", "destFile", "Ljava/io/File;", "mirrors", "", "Lorg/fdroid/download/Mirror;", "tryFirst", "createWithTryFirstMirror", "database_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class DownloaderFactory {
    public abstract Downloader create(Repository repository, Uri uri, IndexFile indexFile, File file) throws IOException;

    protected abstract Downloader create(Repository repository, List<Mirror> list, Uri uri, IndexFile indexFile, File file, Mirror mirror) throws IOException;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.Object] */
    public final Downloader createWithTryFirstMirror(Repository repo, Uri uri, IndexFile indexFile, File destFile) throws IOException {
        ?? r1;
        Intrinsics.checkNotNullParameter(repo, "repo");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(indexFile, "indexFile");
        Intrinsics.checkNotNullParameter(destFile, "destFile");
        Iterator it = repo.getMirrors().iterator();
        while (true) {
            if (!it.hasNext()) {
                r1 = 0;
                break;
            }
            r1 = it.next();
            if (Intrinsics.areEqual(((Mirror) r1).getBaseUrl(), repo.getAddress())) {
                break;
            }
        }
        Mirror mirror = r1;
        if (mirror == null) {
            Log.w("DownloaderFactory", "Try-first mirror not found, disabled by user?");
        }
        return create(repo, repo.getMirrors(), uri, indexFile, destFile, mirror);
    }
}
