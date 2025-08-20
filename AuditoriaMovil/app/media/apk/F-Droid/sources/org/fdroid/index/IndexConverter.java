package org.fdroid.index;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: IndexConverter.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lorg/fdroid/index/IndexConverter;", "", "defaultLocale", "", "(Ljava/lang/String;)V", "toIndexV2", "Lorg/fdroid/index/v2/IndexV2;", "v1", "Lorg/fdroid/index/v1/IndexV1;", "index_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class IndexConverter {
    private final String defaultLocale;

    public IndexConverter() {
        this(null, 1, null);
    }

    public IndexConverter(String defaultLocale) {
        Intrinsics.checkNotNullParameter(defaultLocale, "defaultLocale");
        this.defaultLocale = defaultLocale;
    }

    public /* synthetic */ IndexConverter(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? IndexConverterKt.DEFAULT_LOCALE : str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00d1, code lost:
        r14 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r14);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final org.fdroid.index.v2.IndexV2 toIndexV2(org.fdroid.index.v1.IndexV1 r20) {
        /*
            Method dump skipped, instructions count: 313
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.fdroid.index.IndexConverter.toIndexV2(org.fdroid.index.v1.IndexV1):org.fdroid.index.v2.IndexV2");
    }
}
