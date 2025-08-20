package androidx.compose.ui.graphics;

import kotlin.jvm.internal.Intrinsics;
/* compiled from: AndroidPathMeasure.android.kt */
/* loaded from: classes.dex */
public final class AndroidPathMeasure implements PathMeasure {
    private final android.graphics.PathMeasure internalPathMeasure;

    public AndroidPathMeasure(android.graphics.PathMeasure internalPathMeasure) {
        Intrinsics.checkNotNullParameter(internalPathMeasure, "internalPathMeasure");
        this.internalPathMeasure = internalPathMeasure;
    }

    @Override // androidx.compose.ui.graphics.PathMeasure
    public float getLength() {
        return this.internalPathMeasure.getLength();
    }

    @Override // androidx.compose.ui.graphics.PathMeasure
    public boolean getSegment(float f, float f2, Path destination, boolean z) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        android.graphics.PathMeasure pathMeasure = this.internalPathMeasure;
        if (!(destination instanceof AndroidPath)) {
            throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
        }
        return pathMeasure.getSegment(f, f2, ((AndroidPath) destination).getInternalPath(), z);
    }

    @Override // androidx.compose.ui.graphics.PathMeasure
    public void setPath(Path path, boolean z) {
        android.graphics.Path path2;
        android.graphics.PathMeasure pathMeasure = this.internalPathMeasure;
        if (path == null) {
            path2 = null;
        } else if (path instanceof AndroidPath) {
            path2 = ((AndroidPath) path).getInternalPath();
        } else {
            throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
        }
        pathMeasure.setPath(path2, z);
    }
}
