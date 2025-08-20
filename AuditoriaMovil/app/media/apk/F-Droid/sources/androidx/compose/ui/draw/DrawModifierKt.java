package androidx.compose.ui.draw;

import androidx.compose.ui.Modifier;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DrawModifier.kt */
/* loaded from: classes.dex */
public abstract class DrawModifierKt {
    public static final Modifier drawBehind(Modifier modifier, Function1 onDraw) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(onDraw, "onDraw");
        return modifier.then(new DrawBehindElement(onDraw));
    }

    public static final Modifier drawWithCache(Modifier modifier, Function1 onBuildDrawCache) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(onBuildDrawCache, "onBuildDrawCache");
        return modifier.then(new DrawWithCacheElement(onBuildDrawCache));
    }

    public static final CacheDrawModifierNode CacheDrawModifierNode(Function1 onBuildDrawCache) {
        Intrinsics.checkNotNullParameter(onBuildDrawCache, "onBuildDrawCache");
        return new CacheDrawModifierNodeImpl(new CacheDrawScope(), onBuildDrawCache);
    }

    public static final Modifier drawWithContent(Modifier modifier, Function1 onDraw) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(onDraw, "onDraw");
        return modifier.then(new DrawWithContentElement(onDraw));
    }
}
