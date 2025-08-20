package org.fdroid.download;

import androidx.compose.foundation.ClickableElement$$ExternalSyntheticBackport0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: HeadInfo.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J<\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u001d"}, d2 = {"Lorg/fdroid/download/HeadInfo;", "", "eTagChanged", "", "eTag", "", "contentLength", "", "lastModified", "(ZLjava/lang/String;Ljava/lang/Long;Ljava/lang/String;)V", "getContentLength", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getETag", "()Ljava/lang/String;", "getETagChanged", "()Z", "getLastModified", "component1", "component2", "component3", "component4", "copy", "(ZLjava/lang/String;Ljava/lang/Long;Ljava/lang/String;)Lorg/fdroid/download/HeadInfo;", "equals", "other", "hashCode", "", "toString", "download_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class HeadInfo {
    private final Long contentLength;
    private final String eTag;
    private final boolean eTagChanged;
    private final String lastModified;

    public static /* synthetic */ HeadInfo copy$default(HeadInfo headInfo, boolean z, String str, Long l, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = headInfo.eTagChanged;
        }
        if ((i & 2) != 0) {
            str = headInfo.eTag;
        }
        if ((i & 4) != 0) {
            l = headInfo.contentLength;
        }
        if ((i & 8) != 0) {
            str2 = headInfo.lastModified;
        }
        return headInfo.copy(z, str, l, str2);
    }

    public final boolean component1() {
        return this.eTagChanged;
    }

    public final String component2() {
        return this.eTag;
    }

    public final Long component3() {
        return this.contentLength;
    }

    public final String component4() {
        return this.lastModified;
    }

    public final HeadInfo copy(boolean z, String str, Long l, String str2) {
        return new HeadInfo(z, str, l, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HeadInfo) {
            HeadInfo headInfo = (HeadInfo) obj;
            return this.eTagChanged == headInfo.eTagChanged && Intrinsics.areEqual(this.eTag, headInfo.eTag) && Intrinsics.areEqual(this.contentLength, headInfo.contentLength) && Intrinsics.areEqual(this.lastModified, headInfo.lastModified);
        }
        return false;
    }

    public final Long getContentLength() {
        return this.contentLength;
    }

    public final String getETag() {
        return this.eTag;
    }

    public final boolean getETagChanged() {
        return this.eTagChanged;
    }

    public final String getLastModified() {
        return this.lastModified;
    }

    public int hashCode() {
        int m = ClickableElement$$ExternalSyntheticBackport0.m(this.eTagChanged) * 31;
        String str = this.eTag;
        int hashCode = (m + (str == null ? 0 : str.hashCode())) * 31;
        Long l = this.contentLength;
        int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
        String str2 = this.lastModified;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        boolean z = this.eTagChanged;
        String str = this.eTag;
        Long l = this.contentLength;
        String str2 = this.lastModified;
        return "HeadInfo(eTagChanged=" + z + ", eTag=" + str + ", contentLength=" + l + ", lastModified=" + str2 + ")";
    }

    public HeadInfo(boolean z, String str, Long l, String str2) {
        this.eTagChanged = z;
        this.eTag = str;
        this.contentLength = l;
        this.lastModified = str2;
    }
}
