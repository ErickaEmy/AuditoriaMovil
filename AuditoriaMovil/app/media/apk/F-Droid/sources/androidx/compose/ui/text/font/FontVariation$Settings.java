package androidx.compose.ui.text.font;

import androidx.appcompat.app.ToolbarActionBar$$ExternalSyntheticThrowCCEIfNotNull0;
import ch.qos.logback.core.CoreConstants;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: FontVariation.kt */
/* loaded from: classes.dex */
public final class FontVariation$Settings {
    private final boolean needsDensity;
    private final List settings;

    public final List getSettings() {
        return this.settings;
    }

    public FontVariation$Settings(FontVariation$Setting... settings) {
        String joinToString$default;
        Intrinsics.checkNotNullParameter(settings, "settings");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (settings.length <= 0) {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                String str = (String) entry.getKey();
                List list = (List) entry.getValue();
                if (list.size() != 1) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(CoreConstants.SINGLE_QUOTE_CHAR);
                    sb.append(str);
                    sb.append("' must be unique. Actual [ [");
                    joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(list, null, null, null, 0, null, null, 63, null);
                    sb.append(joinToString$default);
                    sb.append(']');
                    throw new IllegalArgumentException(sb.toString().toString());
                }
                CollectionsKt__MutableCollectionsKt.addAll(arrayList, list);
            }
            ArrayList arrayList2 = new ArrayList(arrayList);
            this.settings = arrayList2;
            if (arrayList2.size() <= 0) {
                this.needsDensity = false;
                return;
            } else {
                ToolbarActionBar$$ExternalSyntheticThrowCCEIfNotNull0.m(arrayList2.get(0));
                throw null;
            }
        }
        FontVariation$Setting fontVariation$Setting = settings[0];
        throw null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FontVariation$Settings) && Intrinsics.areEqual(this.settings, ((FontVariation$Settings) obj).settings);
    }

    public int hashCode() {
        return this.settings.hashCode();
    }
}
