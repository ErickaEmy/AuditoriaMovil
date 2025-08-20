package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: predefinedEnhancementInfo.kt */
/* loaded from: classes2.dex */
public final class TypeEnhancementInfo {
    private final Map map;

    public final Map getMap() {
        return this.map;
    }

    public TypeEnhancementInfo(Map map) {
        Intrinsics.checkNotNullParameter(map, "map");
        this.map = map;
    }
}
