package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.PathFillType;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.asn1.cmp.PKIFailureInfo;
/* compiled from: VectorCompose.kt */
/* loaded from: classes.dex */
public abstract class VectorComposeKt {
    /* JADX WARN: Removed duplicated region for block: B:101:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:162:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0114  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void Group(java.lang.String r20, float r21, float r22, float r23, float r24, float r25, float r26, float r27, java.util.List r28, final kotlin.jvm.functions.Function2 r29, androidx.compose.runtime.Composer r30, final int r31, final int r32) {
        /*
            Method dump skipped, instructions count: 609
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.vector.VectorComposeKt.Group(java.lang.String, float, float, float, float, float, float, float, java.util.List, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: Path-9cdaXJ4  reason: not valid java name */
    public static final void m1086Path9cdaXJ4(final List pathData, int i, String str, Brush brush, float f, Brush brush2, float f2, float f3, int i2, int i3, float f4, float f5, float f6, float f7, Composer composer, final int i4, final int i5, final int i6) {
        Intrinsics.checkNotNullParameter(pathData, "pathData");
        Composer startRestartGroup = composer.startRestartGroup(-1478270750);
        int defaultFillType = (i6 & 2) != 0 ? VectorKt.getDefaultFillType() : i;
        String str2 = (i6 & 4) != 0 ? "" : str;
        Brush brush3 = (i6 & 8) != 0 ? null : brush;
        float f8 = (i6 & 16) != 0 ? 1.0f : f;
        final Brush brush4 = (i6 & 32) == 0 ? brush2 : null;
        float f9 = (i6 & 64) != 0 ? 1.0f : f2;
        float f10 = (i6 & 128) != 0 ? 0.0f : f3;
        int defaultStrokeLineCap = (i6 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : i2;
        int defaultStrokeLineJoin = (i6 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : i3;
        float f11 = (i6 & 1024) != 0 ? 4.0f : f4;
        float f12 = (i6 & 2048) != 0 ? 0.0f : f5;
        float f13 = (i6 & PKIFailureInfo.certConfirmed) != 0 ? 1.0f : f6;
        float f14 = (i6 & 8192) != 0 ? 0.0f : f7;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1478270750, i4, i5, "androidx.compose.ui.graphics.vector.Path (VectorCompose.kt:99)");
        }
        final VectorComposeKt$Path$1 vectorComposeKt$Path$1 = new Function0() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$1
            @Override // kotlin.jvm.functions.Function0
            public final PathComponent invoke() {
                return new PathComponent();
            }
        };
        startRestartGroup.startReplaceableGroup(1886828752);
        if (!(startRestartGroup.getApplier() instanceof VectorApplier)) {
            ComposablesKt.invalidApplier();
        }
        startRestartGroup.startNode();
        if (startRestartGroup.getInserting()) {
            startRestartGroup.createNode(new Function0() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path-9cdaXJ4$$inlined$ComposeNode$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Function0.this.invoke();
                }
            });
        } else {
            startRestartGroup.useNode();
        }
        Composer m624constructorimpl = Updater.m624constructorimpl(startRestartGroup);
        Updater.m625setimpl(m624constructorimpl, str2, new Function2() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((PathComponent) obj, (String) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(PathComponent set, String it) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                Intrinsics.checkNotNullParameter(it, "it");
                set.setName(it);
            }
        });
        Updater.m625setimpl(m624constructorimpl, pathData, new Function2() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$2
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((PathComponent) obj, (List) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(PathComponent set, List it) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                Intrinsics.checkNotNullParameter(it, "it");
                set.setPathData(it);
            }
        });
        Updater.m625setimpl(m624constructorimpl, PathFillType.m933boximpl(defaultFillType), new Function2() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$3
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                m1088invokepweu1eQ((PathComponent) obj, ((PathFillType) obj2).m939unboximpl());
                return Unit.INSTANCE;
            }

            /* renamed from: invoke-pweu1eQ  reason: not valid java name */
            public final void m1088invokepweu1eQ(PathComponent set, int i7) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.m1081setPathFillTypeoQ8Xj4U(i7);
            }
        });
        Updater.m625setimpl(m624constructorimpl, brush3, new Function2() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$4
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((PathComponent) obj, (Brush) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(PathComponent set, Brush brush5) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.setFill(brush5);
            }
        });
        Updater.m625setimpl(m624constructorimpl, Float.valueOf(f8), new Function2() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$5
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((PathComponent) obj, ((Number) obj2).floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(PathComponent set, float f15) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.setFillAlpha(f15);
            }
        });
        Updater.m625setimpl(m624constructorimpl, brush4, new Function2() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$6
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((PathComponent) obj, (Brush) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(PathComponent set, Brush brush5) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.setStroke(brush5);
            }
        });
        Updater.m625setimpl(m624constructorimpl, Float.valueOf(f9), new Function2() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$7
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((PathComponent) obj, ((Number) obj2).floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(PathComponent set, float f15) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.setStrokeAlpha(f15);
            }
        });
        Updater.m625setimpl(m624constructorimpl, Float.valueOf(f10), new Function2() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$8
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((PathComponent) obj, ((Number) obj2).floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(PathComponent set, float f15) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.setStrokeLineWidth(f15);
            }
        });
        Updater.m625setimpl(m624constructorimpl, StrokeJoin.m973boximpl(defaultStrokeLineJoin), new Function2() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$9
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                m1089invokekLtJ_vA((PathComponent) obj, ((StrokeJoin) obj2).m979unboximpl());
                return Unit.INSTANCE;
            }

            /* renamed from: invoke-kLtJ_vA  reason: not valid java name */
            public final void m1089invokekLtJ_vA(PathComponent set, int i7) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.m1083setStrokeLineJoinWw9F2mQ(i7);
            }
        });
        Updater.m625setimpl(m624constructorimpl, StrokeCap.m963boximpl(defaultStrokeLineCap), new Function2() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$10
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                m1087invokeCSYIeUk((PathComponent) obj, ((StrokeCap) obj2).m969unboximpl());
                return Unit.INSTANCE;
            }

            /* renamed from: invoke-CSYIeUk  reason: not valid java name */
            public final void m1087invokeCSYIeUk(PathComponent set, int i7) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.m1082setStrokeLineCapBeK7IIE(i7);
            }
        });
        Updater.m625setimpl(m624constructorimpl, Float.valueOf(f11), new Function2() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$11
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((PathComponent) obj, ((Number) obj2).floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(PathComponent set, float f15) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.setStrokeLineMiter(f15);
            }
        });
        Updater.m625setimpl(m624constructorimpl, Float.valueOf(f12), new Function2() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$12
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((PathComponent) obj, ((Number) obj2).floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(PathComponent set, float f15) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.setTrimPathStart(f15);
            }
        });
        Updater.m625setimpl(m624constructorimpl, Float.valueOf(f13), new Function2() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$13
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((PathComponent) obj, ((Number) obj2).floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(PathComponent set, float f15) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.setTrimPathEnd(f15);
            }
        });
        Updater.m625setimpl(m624constructorimpl, Float.valueOf(f14), new Function2() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$14
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((PathComponent) obj, ((Number) obj2).floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(PathComponent set, float f15) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.setTrimPathOffset(f15);
            }
        });
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final int i7 = defaultFillType;
        final String str3 = str2;
        final Brush brush5 = brush3;
        final float f15 = f8;
        final float f16 = f9;
        final float f17 = f10;
        final int i8 = defaultStrokeLineCap;
        final int i9 = defaultStrokeLineJoin;
        final float f18 = f11;
        final float f19 = f12;
        final float f20 = f13;
        final float f21 = f14;
        endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i10) {
                VectorComposeKt.m1086Path9cdaXJ4(pathData, i7, str3, brush5, f15, brush4, f16, f17, i8, i9, f18, f19, f20, f21, composer2, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), RecomposeScopeImplKt.updateChangedFlags(i5), i6);
            }
        });
    }
}
