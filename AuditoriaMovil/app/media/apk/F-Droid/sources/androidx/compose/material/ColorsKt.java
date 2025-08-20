package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Colors.kt */
/* loaded from: classes.dex */
public abstract class ColorsKt {
    private static final ProvidableCompositionLocal LocalColors = CompositionLocalKt.staticCompositionLocalOf(new Function0() { // from class: androidx.compose.material.ColorsKt$LocalColors$1
        @Override // kotlin.jvm.functions.Function0
        public final Colors invoke() {
            Colors m470lightColors2qZNXz8;
            m470lightColors2qZNXz8 = ColorsKt.m470lightColors2qZNXz8((r43 & 1) != 0 ? ColorKt.Color(4284612846L) : 0L, (r43 & 2) != 0 ? ColorKt.Color(4281794739L) : 0L, (r43 & 4) != 0 ? ColorKt.Color(4278442694L) : 0L, (r43 & 8) != 0 ? ColorKt.Color(4278290310L) : 0L, (r43 & 16) != 0 ? Color.Companion.m865getWhite0d7_KjU() : 0L, (r43 & 32) != 0 ? Color.Companion.m865getWhite0d7_KjU() : 0L, (r43 & 64) != 0 ? ColorKt.Color(4289724448L) : 0L, (r43 & 128) != 0 ? Color.Companion.m865getWhite0d7_KjU() : 0L, (r43 & 256) != 0 ? Color.Companion.m860getBlack0d7_KjU() : 0L, (r43 & 512) != 0 ? Color.Companion.m860getBlack0d7_KjU() : 0L, (r43 & 1024) != 0 ? Color.Companion.m860getBlack0d7_KjU() : 0L, (r43 & 2048) != 0 ? Color.Companion.m865getWhite0d7_KjU() : 0L);
            return m470lightColors2qZNXz8;
        }
    });

    public static final ProvidableCompositionLocal getLocalColors() {
        return LocalColors;
    }

    /* renamed from: lightColors-2qZNXz8  reason: not valid java name */
    public static final Colors m470lightColors2qZNXz8(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12) {
        return new Colors(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, true, null);
    }

    /* renamed from: darkColors-2qZNXz8  reason: not valid java name */
    public static final Colors m469darkColors2qZNXz8(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12) {
        return new Colors(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, false, null);
    }

    public static final long getPrimarySurface(Colors colors) {
        Intrinsics.checkNotNullParameter(colors, "<this>");
        return colors.isLight() ? colors.m450getPrimary0d7_KjU() : colors.m454getSurface0d7_KjU();
    }

    /* renamed from: contentColorFor-4WTKRHQ  reason: not valid java name */
    public static final long m467contentColorFor4WTKRHQ(Colors contentColorFor, long j) {
        Intrinsics.checkNotNullParameter(contentColorFor, "$this$contentColorFor");
        if (!Color.m851equalsimpl0(j, contentColorFor.m450getPrimary0d7_KjU()) && !Color.m851equalsimpl0(j, contentColorFor.m451getPrimaryVariant0d7_KjU())) {
            if (!Color.m851equalsimpl0(j, contentColorFor.m452getSecondary0d7_KjU()) && !Color.m851equalsimpl0(j, contentColorFor.m453getSecondaryVariant0d7_KjU())) {
                return Color.m851equalsimpl0(j, contentColorFor.m443getBackground0d7_KjU()) ? contentColorFor.m445getOnBackground0d7_KjU() : Color.m851equalsimpl0(j, contentColorFor.m454getSurface0d7_KjU()) ? contentColorFor.m449getOnSurface0d7_KjU() : Color.m851equalsimpl0(j, contentColorFor.m444getError0d7_KjU()) ? contentColorFor.m446getOnError0d7_KjU() : Color.Companion.m864getUnspecified0d7_KjU();
            }
            return contentColorFor.m448getOnSecondary0d7_KjU();
        }
        return contentColorFor.m447getOnPrimary0d7_KjU();
    }

    /* renamed from: contentColorFor-ek8zF_U  reason: not valid java name */
    public static final long m468contentColorForek8zF_U(long j, Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(441849991, i, -1, "androidx.compose.material.contentColorFor (Colors.kt:295)");
        }
        long m467contentColorFor4WTKRHQ = m467contentColorFor4WTKRHQ(MaterialTheme.INSTANCE.getColors(composer, 6), j);
        if (m467contentColorFor4WTKRHQ == Color.Companion.m864getUnspecified0d7_KjU()) {
            m467contentColorFor4WTKRHQ = ((Color) composer.consume(ContentColorKt.getLocalContentColor())).m859unboximpl();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return m467contentColorFor4WTKRHQ;
    }

    public static final void updateColorsFrom(Colors colors, Colors other) {
        Intrinsics.checkNotNullParameter(colors, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        colors.m462setPrimary8_81llA$material_release(other.m450getPrimary0d7_KjU());
        colors.m463setPrimaryVariant8_81llA$material_release(other.m451getPrimaryVariant0d7_KjU());
        colors.m464setSecondary8_81llA$material_release(other.m452getSecondary0d7_KjU());
        colors.m465setSecondaryVariant8_81llA$material_release(other.m453getSecondaryVariant0d7_KjU());
        colors.m455setBackground8_81llA$material_release(other.m443getBackground0d7_KjU());
        colors.m466setSurface8_81llA$material_release(other.m454getSurface0d7_KjU());
        colors.m456setError8_81llA$material_release(other.m444getError0d7_KjU());
        colors.m459setOnPrimary8_81llA$material_release(other.m447getOnPrimary0d7_KjU());
        colors.m460setOnSecondary8_81llA$material_release(other.m448getOnSecondary0d7_KjU());
        colors.m457setOnBackground8_81llA$material_release(other.m445getOnBackground0d7_KjU());
        colors.m461setOnSurface8_81llA$material_release(other.m449getOnSurface0d7_KjU());
        colors.m458setOnError8_81llA$material_release(other.m446getOnError0d7_KjU());
        colors.setLight$material_release(other.isLight());
    }
}
