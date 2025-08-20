package org.fdroid.index.v1;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: IndexV1StreamProcessor.kt */
/* loaded from: classes2.dex */
final class AppData {
    private final Map antiFeatures;
    private final List categories;
    private final Long suggestedVersionCode;
    private final Map whatsNew;

    public final Map getAntiFeatures() {
        return this.antiFeatures;
    }

    public final List getCategories() {
        return this.categories;
    }

    public final Long getSuggestedVersionCode() {
        return this.suggestedVersionCode;
    }

    public final Map getWhatsNew() {
        return this.whatsNew;
    }

    public AppData(Map antiFeatures, Map map, Long l, List categories) {
        Intrinsics.checkNotNullParameter(antiFeatures, "antiFeatures");
        Intrinsics.checkNotNullParameter(categories, "categories");
        this.antiFeatures = antiFeatures;
        this.whatsNew = map;
        this.suggestedVersionCode = l;
        this.categories = categories;
    }
}
