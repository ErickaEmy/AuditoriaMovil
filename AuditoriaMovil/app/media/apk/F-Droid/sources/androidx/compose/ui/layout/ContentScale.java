package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Size;
/* compiled from: ContentScale.kt */
/* loaded from: classes.dex */
public interface ContentScale {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: ContentScale.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final ContentScale Crop = new ContentScale() { // from class: androidx.compose.ui.layout.ContentScale$Companion$Crop$1
            @Override // androidx.compose.ui.layout.ContentScale
            /* renamed from: computeScaleFactor-H7hwNQA */
            public long mo1242computeScaleFactorH7hwNQA(long j, long j2) {
                float m1244access$computeFillMaxDimensioniLBOSCw = ContentScaleKt.m1244access$computeFillMaxDimensioniLBOSCw(j, j2);
                return ScaleFactorKt.ScaleFactor(m1244access$computeFillMaxDimensioniLBOSCw, m1244access$computeFillMaxDimensioniLBOSCw);
            }
        };
        private static final ContentScale Fit = new ContentScale() { // from class: androidx.compose.ui.layout.ContentScale$Companion$Fit$1
            @Override // androidx.compose.ui.layout.ContentScale
            /* renamed from: computeScaleFactor-H7hwNQA */
            public long mo1242computeScaleFactorH7hwNQA(long j, long j2) {
                float m1245access$computeFillMinDimensioniLBOSCw = ContentScaleKt.m1245access$computeFillMinDimensioniLBOSCw(j, j2);
                return ScaleFactorKt.ScaleFactor(m1245access$computeFillMinDimensioniLBOSCw, m1245access$computeFillMinDimensioniLBOSCw);
            }
        };
        private static final ContentScale FillHeight = new ContentScale() { // from class: androidx.compose.ui.layout.ContentScale$Companion$FillHeight$1
            @Override // androidx.compose.ui.layout.ContentScale
            /* renamed from: computeScaleFactor-H7hwNQA */
            public long mo1242computeScaleFactorH7hwNQA(long j, long j2) {
                float m1243access$computeFillHeightiLBOSCw = ContentScaleKt.m1243access$computeFillHeightiLBOSCw(j, j2);
                return ScaleFactorKt.ScaleFactor(m1243access$computeFillHeightiLBOSCw, m1243access$computeFillHeightiLBOSCw);
            }
        };
        private static final ContentScale FillWidth = new ContentScale() { // from class: androidx.compose.ui.layout.ContentScale$Companion$FillWidth$1
            @Override // androidx.compose.ui.layout.ContentScale
            /* renamed from: computeScaleFactor-H7hwNQA */
            public long mo1242computeScaleFactorH7hwNQA(long j, long j2) {
                float m1246access$computeFillWidthiLBOSCw = ContentScaleKt.m1246access$computeFillWidthiLBOSCw(j, j2);
                return ScaleFactorKt.ScaleFactor(m1246access$computeFillWidthiLBOSCw, m1246access$computeFillWidthiLBOSCw);
            }
        };
        private static final ContentScale Inside = new ContentScale() { // from class: androidx.compose.ui.layout.ContentScale$Companion$Inside$1
            @Override // androidx.compose.ui.layout.ContentScale
            /* renamed from: computeScaleFactor-H7hwNQA */
            public long mo1242computeScaleFactorH7hwNQA(long j, long j2) {
                if (Size.m745getWidthimpl(j) <= Size.m745getWidthimpl(j2) && Size.m743getHeightimpl(j) <= Size.m743getHeightimpl(j2)) {
                    return ScaleFactorKt.ScaleFactor(1.0f, 1.0f);
                }
                float m1245access$computeFillMinDimensioniLBOSCw = ContentScaleKt.m1245access$computeFillMinDimensioniLBOSCw(j, j2);
                return ScaleFactorKt.ScaleFactor(m1245access$computeFillMinDimensioniLBOSCw, m1245access$computeFillMinDimensioniLBOSCw);
            }
        };
        private static final FixedScale None = new FixedScale(1.0f);
        private static final ContentScale FillBounds = new ContentScale() { // from class: androidx.compose.ui.layout.ContentScale$Companion$FillBounds$1
            @Override // androidx.compose.ui.layout.ContentScale
            /* renamed from: computeScaleFactor-H7hwNQA */
            public long mo1242computeScaleFactorH7hwNQA(long j, long j2) {
                return ScaleFactorKt.ScaleFactor(ContentScaleKt.m1246access$computeFillWidthiLBOSCw(j, j2), ContentScaleKt.m1243access$computeFillHeightiLBOSCw(j, j2));
            }
        };

        private Companion() {
        }

        public final ContentScale getCrop() {
            return Crop;
        }

        public final ContentScale getFit() {
            return Fit;
        }

        public final ContentScale getInside() {
            return Inside;
        }
    }

    /* renamed from: computeScaleFactor-H7hwNQA  reason: not valid java name */
    long mo1242computeScaleFactorH7hwNQA(long j, long j2);
}
