package org.fdroid.fdroid.nearby.httpish;
/* loaded from: classes2.dex */
public class FileDetails {
    private String cacheTag;
    private long fileSize;

    public String getCacheTag() {
        return this.cacheTag;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCacheTag(String str) {
        this.cacheTag = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setFileSize(int i) {
        this.fileSize = i;
    }
}
