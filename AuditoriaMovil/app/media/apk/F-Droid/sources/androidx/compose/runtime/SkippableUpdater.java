package androidx.compose.runtime;

import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Composer.kt */
/* loaded from: classes.dex */
public final class SkippableUpdater {
    private final Composer composer;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ SkippableUpdater m617boximpl(Composer composer) {
        return new SkippableUpdater(composer);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static Composer m618constructorimpl(Composer composer) {
        Intrinsics.checkNotNullParameter(composer, "composer");
        return composer;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m619equalsimpl(Composer composer, Object obj) {
        return (obj instanceof SkippableUpdater) && Intrinsics.areEqual(composer, ((SkippableUpdater) obj).m622unboximpl());
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m620hashCodeimpl(Composer composer) {
        return composer.hashCode();
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m621toStringimpl(Composer composer) {
        return "SkippableUpdater(composer=" + composer + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public boolean equals(Object obj) {
        return m619equalsimpl(this.composer, obj);
    }

    public int hashCode() {
        return m620hashCodeimpl(this.composer);
    }

    public String toString() {
        return m621toStringimpl(this.composer);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ Composer m622unboximpl() {
        return this.composer;
    }

    private /* synthetic */ SkippableUpdater(Composer composer) {
        this.composer = composer;
    }
}
