package androidx.compose.runtime.tooling;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import java.util.Set;
import kotlin.jvm.functions.Function0;
/* compiled from: InspectionTables.kt */
/* loaded from: classes.dex */
public abstract class InspectionTablesKt {
    private static final ProvidableCompositionLocal LocalInspectionTables = CompositionLocalKt.staticCompositionLocalOf(new Function0() { // from class: androidx.compose.runtime.tooling.InspectionTablesKt$LocalInspectionTables$1
        @Override // kotlin.jvm.functions.Function0
        public final Set invoke() {
            return null;
        }
    });

    public static final ProvidableCompositionLocal getLocalInspectionTables() {
        return LocalInspectionTables;
    }
}
