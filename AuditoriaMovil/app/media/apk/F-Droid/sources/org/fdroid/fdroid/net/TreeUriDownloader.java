package org.fdroid.fdroid.net;

import android.content.Context;
import android.net.Uri;
import androidx.documentfile.provider.DocumentFile;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.ProtocolException;
import org.fdroid.IndexFile;
import org.fdroid.download.Downloader;
import org.fdroid.download.NotFoundException;
import org.fdroid.fdroid.FDroidApp;
/* loaded from: classes2.dex */
public class TreeUriDownloader extends Downloader {
    public static final String ESCAPED_SLASH = "%2F";
    public static final String TAG = "TreeUriDownloader";
    private final Context context;
    private final DocumentFile documentFile;
    private final Uri treeUri;

    @Override // org.fdroid.download.Downloader
    public void close() {
    }

    @Override // org.fdroid.download.Downloader
    public boolean hasChanged() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TreeUriDownloader(Uri uri, IndexFile indexFile, File file) {
        super(indexFile, file);
        Context fDroidApp = FDroidApp.getInstance();
        this.context = fDroidApp;
        String encodedPath = uri.getEncodedPath();
        String substring = encodedPath.substring(encodedPath.lastIndexOf(ESCAPED_SLASH) + 3);
        Uri build = uri.buildUpon().encodedPath(encodedPath.replace(substring, Uri.encode(substring))).build();
        this.treeUri = build;
        this.documentFile = DocumentFile.fromTreeUri(fDroidApp, build);
    }

    @Override // org.fdroid.download.Downloader
    protected InputStream getInputStream(boolean z) throws IOException, NotFoundException {
        try {
            InputStream openInputStream = this.context.getContentResolver().openInputStream(this.treeUri);
            if (openInputStream == null) {
                throw new IOException("InputStream was null");
            }
            return new BufferedInputStream(openInputStream);
        } catch (FileNotFoundException unused) {
            throw new NotFoundException();
        } catch (IllegalArgumentException e) {
            if (e.getMessage() != null && e.getMessage().contains("FileNotFoundException")) {
                throw new NotFoundException();
            }
            throw new ProtocolException(e.getLocalizedMessage());
        }
    }

    @Override // org.fdroid.download.Downloader
    protected long totalDownloadSize() {
        return getIndexFile().getSize() != null ? getIndexFile().getSize().longValue() : this.documentFile.length();
    }

    @Override // org.fdroid.download.Downloader
    public void download() throws IOException, InterruptedException {
        downloadFromStream(false);
    }
}
