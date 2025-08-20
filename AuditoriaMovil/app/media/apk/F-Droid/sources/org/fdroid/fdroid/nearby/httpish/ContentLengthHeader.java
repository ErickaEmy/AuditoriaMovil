package org.fdroid.fdroid.nearby.httpish;
/* loaded from: classes2.dex */
public class ContentLengthHeader extends Header {
    @Override // org.fdroid.fdroid.nearby.httpish.Header
    public String getName() {
        return "content-length";
    }

    @Override // org.fdroid.fdroid.nearby.httpish.Header
    public void handle(FileDetails fileDetails, String str) {
        fileDetails.setFileSize(Integer.parseInt(str));
    }
}
