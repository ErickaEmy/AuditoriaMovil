package org.fdroid.fdroid.nearby.httpish;
/* loaded from: classes2.dex */
public class ETagHeader extends Header {
    @Override // org.fdroid.fdroid.nearby.httpish.Header
    public String getName() {
        return "etag";
    }

    @Override // org.fdroid.fdroid.nearby.httpish.Header
    public void handle(FileDetails fileDetails, String str) {
        fileDetails.setCacheTag(str);
    }
}
