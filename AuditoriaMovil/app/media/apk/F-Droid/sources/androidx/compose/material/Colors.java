package androidx.compose.material;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.graphics.Color;
import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: Colors.kt */
/* loaded from: classes.dex */
public final class Colors {
    private final MutableState background$delegate;
    private final MutableState error$delegate;
    private final MutableState isLight$delegate;
    private final MutableState onBackground$delegate;
    private final MutableState onError$delegate;
    private final MutableState onPrimary$delegate;
    private final MutableState onSecondary$delegate;
    private final MutableState onSurface$delegate;
    private final MutableState primary$delegate;
    private final MutableState primaryVariant$delegate;
    private final MutableState secondary$delegate;
    private final MutableState secondaryVariant$delegate;
    private final MutableState surface$delegate;

    public /* synthetic */ Colors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, z);
    }

    private Colors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, boolean z) {
        this.primary$delegate = SnapshotStateKt.mutableStateOf(Color.m841boximpl(j), SnapshotStateKt.structuralEqualityPolicy());
        this.primaryVariant$delegate = SnapshotStateKt.mutableStateOf(Color.m841boximpl(j2), SnapshotStateKt.structuralEqualityPolicy());
        this.secondary$delegate = SnapshotStateKt.mutableStateOf(Color.m841boximpl(j3), SnapshotStateKt.structuralEqualityPolicy());
        this.secondaryVariant$delegate = SnapshotStateKt.mutableStateOf(Color.m841boximpl(j4), SnapshotStateKt.structuralEqualityPolicy());
        this.background$delegate = SnapshotStateKt.mutableStateOf(Color.m841boximpl(j5), SnapshotStateKt.structuralEqualityPolicy());
        this.surface$delegate = SnapshotStateKt.mutableStateOf(Color.m841boximpl(j6), SnapshotStateKt.structuralEqualityPolicy());
        this.error$delegate = SnapshotStateKt.mutableStateOf(Color.m841boximpl(j7), SnapshotStateKt.structuralEqualityPolicy());
        this.onPrimary$delegate = SnapshotStateKt.mutableStateOf(Color.m841boximpl(j8), SnapshotStateKt.structuralEqualityPolicy());
        this.onSecondary$delegate = SnapshotStateKt.mutableStateOf(Color.m841boximpl(j9), SnapshotStateKt.structuralEqualityPolicy());
        this.onBackground$delegate = SnapshotStateKt.mutableStateOf(Color.m841boximpl(j10), SnapshotStateKt.structuralEqualityPolicy());
        this.onSurface$delegate = SnapshotStateKt.mutableStateOf(Color.m841boximpl(j11), SnapshotStateKt.structuralEqualityPolicy());
        this.onError$delegate = SnapshotStateKt.mutableStateOf(Color.m841boximpl(j12), SnapshotStateKt.structuralEqualityPolicy());
        this.isLight$delegate = SnapshotStateKt.mutableStateOf(Boolean.valueOf(z), SnapshotStateKt.structuralEqualityPolicy());
    }

    /* renamed from: getBackground-0d7_KjU  reason: not valid java name */
    public final long m443getBackground0d7_KjU() {
        return ((Color) this.background$delegate.getValue()).m859unboximpl();
    }

    /* renamed from: getError-0d7_KjU  reason: not valid java name */
    public final long m444getError0d7_KjU() {
        return ((Color) this.error$delegate.getValue()).m859unboximpl();
    }

    /* renamed from: getOnBackground-0d7_KjU  reason: not valid java name */
    public final long m445getOnBackground0d7_KjU() {
        return ((Color) this.onBackground$delegate.getValue()).m859unboximpl();
    }

    /* renamed from: getOnError-0d7_KjU  reason: not valid java name */
    public final long m446getOnError0d7_KjU() {
        return ((Color) this.onError$delegate.getValue()).m859unboximpl();
    }

    /* renamed from: getOnPrimary-0d7_KjU  reason: not valid java name */
    public final long m447getOnPrimary0d7_KjU() {
        return ((Color) this.onPrimary$delegate.getValue()).m859unboximpl();
    }

    /* renamed from: getOnSecondary-0d7_KjU  reason: not valid java name */
    public final long m448getOnSecondary0d7_KjU() {
        return ((Color) this.onSecondary$delegate.getValue()).m859unboximpl();
    }

    /* renamed from: getOnSurface-0d7_KjU  reason: not valid java name */
    public final long m449getOnSurface0d7_KjU() {
        return ((Color) this.onSurface$delegate.getValue()).m859unboximpl();
    }

    /* renamed from: getPrimary-0d7_KjU  reason: not valid java name */
    public final long m450getPrimary0d7_KjU() {
        return ((Color) this.primary$delegate.getValue()).m859unboximpl();
    }

    /* renamed from: getPrimaryVariant-0d7_KjU  reason: not valid java name */
    public final long m451getPrimaryVariant0d7_KjU() {
        return ((Color) this.primaryVariant$delegate.getValue()).m859unboximpl();
    }

    /* renamed from: getSecondary-0d7_KjU  reason: not valid java name */
    public final long m452getSecondary0d7_KjU() {
        return ((Color) this.secondary$delegate.getValue()).m859unboximpl();
    }

    /* renamed from: getSecondaryVariant-0d7_KjU  reason: not valid java name */
    public final long m453getSecondaryVariant0d7_KjU() {
        return ((Color) this.secondaryVariant$delegate.getValue()).m859unboximpl();
    }

    /* renamed from: getSurface-0d7_KjU  reason: not valid java name */
    public final long m454getSurface0d7_KjU() {
        return ((Color) this.surface$delegate.getValue()).m859unboximpl();
    }

    public final boolean isLight() {
        return ((Boolean) this.isLight$delegate.getValue()).booleanValue();
    }

    /* renamed from: setPrimary-8_81llA$material_release  reason: not valid java name */
    public final void m462setPrimary8_81llA$material_release(long j) {
        this.primary$delegate.setValue(Color.m841boximpl(j));
    }

    /* renamed from: setPrimaryVariant-8_81llA$material_release  reason: not valid java name */
    public final void m463setPrimaryVariant8_81llA$material_release(long j) {
        this.primaryVariant$delegate.setValue(Color.m841boximpl(j));
    }

    /* renamed from: setSecondary-8_81llA$material_release  reason: not valid java name */
    public final void m464setSecondary8_81llA$material_release(long j) {
        this.secondary$delegate.setValue(Color.m841boximpl(j));
    }

    /* renamed from: setSecondaryVariant-8_81llA$material_release  reason: not valid java name */
    public final void m465setSecondaryVariant8_81llA$material_release(long j) {
        this.secondaryVariant$delegate.setValue(Color.m841boximpl(j));
    }

    /* renamed from: setBackground-8_81llA$material_release  reason: not valid java name */
    public final void m455setBackground8_81llA$material_release(long j) {
        this.background$delegate.setValue(Color.m841boximpl(j));
    }

    /* renamed from: setSurface-8_81llA$material_release  reason: not valid java name */
    public final void m466setSurface8_81llA$material_release(long j) {
        this.surface$delegate.setValue(Color.m841boximpl(j));
    }

    /* renamed from: setError-8_81llA$material_release  reason: not valid java name */
    public final void m456setError8_81llA$material_release(long j) {
        this.error$delegate.setValue(Color.m841boximpl(j));
    }

    /* renamed from: setOnPrimary-8_81llA$material_release  reason: not valid java name */
    public final void m459setOnPrimary8_81llA$material_release(long j) {
        this.onPrimary$delegate.setValue(Color.m841boximpl(j));
    }

    /* renamed from: setOnSecondary-8_81llA$material_release  reason: not valid java name */
    public final void m460setOnSecondary8_81llA$material_release(long j) {
        this.onSecondary$delegate.setValue(Color.m841boximpl(j));
    }

    /* renamed from: setOnBackground-8_81llA$material_release  reason: not valid java name */
    public final void m457setOnBackground8_81llA$material_release(long j) {
        this.onBackground$delegate.setValue(Color.m841boximpl(j));
    }

    /* renamed from: setOnSurface-8_81llA$material_release  reason: not valid java name */
    public final void m461setOnSurface8_81llA$material_release(long j) {
        this.onSurface$delegate.setValue(Color.m841boximpl(j));
    }

    /* renamed from: setOnError-8_81llA$material_release  reason: not valid java name */
    public final void m458setOnError8_81llA$material_release(long j) {
        this.onError$delegate.setValue(Color.m841boximpl(j));
    }

    public final void setLight$material_release(boolean z) {
        this.isLight$delegate.setValue(Boolean.valueOf(z));
    }

    /* renamed from: copy-pvPzIIM  reason: not valid java name */
    public final Colors m442copypvPzIIM(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, boolean z) {
        return new Colors(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, z, null);
    }

    public String toString() {
        return "Colors(primary=" + ((Object) Color.m858toStringimpl(m450getPrimary0d7_KjU())) + ", primaryVariant=" + ((Object) Color.m858toStringimpl(m451getPrimaryVariant0d7_KjU())) + ", secondary=" + ((Object) Color.m858toStringimpl(m452getSecondary0d7_KjU())) + ", secondaryVariant=" + ((Object) Color.m858toStringimpl(m453getSecondaryVariant0d7_KjU())) + ", background=" + ((Object) Color.m858toStringimpl(m443getBackground0d7_KjU())) + ", surface=" + ((Object) Color.m858toStringimpl(m454getSurface0d7_KjU())) + ", error=" + ((Object) Color.m858toStringimpl(m444getError0d7_KjU())) + ", onPrimary=" + ((Object) Color.m858toStringimpl(m447getOnPrimary0d7_KjU())) + ", onSecondary=" + ((Object) Color.m858toStringimpl(m448getOnSecondary0d7_KjU())) + ", onBackground=" + ((Object) Color.m858toStringimpl(m445getOnBackground0d7_KjU())) + ", onSurface=" + ((Object) Color.m858toStringimpl(m449getOnSurface0d7_KjU())) + ", onError=" + ((Object) Color.m858toStringimpl(m446getOnError0d7_KjU())) + ", isLight=" + isLight() + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
