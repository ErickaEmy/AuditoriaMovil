package androidx.compose.runtime.saveable;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SaveableStateRegistry.kt */
/* loaded from: classes.dex */
public abstract class SaveableStateRegistryKt {
    private static final ProvidableCompositionLocal LocalSaveableStateRegistry = CompositionLocalKt.staticCompositionLocalOf(new Function0() { // from class: androidx.compose.runtime.saveable.SaveableStateRegistryKt$LocalSaveableStateRegistry$1
        @Override // kotlin.jvm.functions.Function0
        public final SaveableStateRegistry invoke() {
            return null;
        }
    });

    public static final ProvidableCompositionLocal getLocalSaveableStateRegistry() {
        return LocalSaveableStateRegistry;
    }

    public static final SaveableStateRegistry SaveableStateRegistry(Map map, Function1 canBeSaved) {
        Intrinsics.checkNotNullParameter(canBeSaved, "canBeSaved");
        return new SaveableStateRegistryImpl(map, canBeSaved);
    }
}
