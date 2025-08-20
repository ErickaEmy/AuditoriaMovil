package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.text.Handle;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CanvasKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.ImageBitmapConfig;
import androidx.compose.ui.graphics.ImageBitmapKt;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.compose.ui.window.PopupProperties;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import org.bouncycastle.asn1.cmp.PKIFailureInfo;
/* compiled from: AndroidSelectionHandles.android.kt */
/* loaded from: classes.dex */
public abstract class AndroidSelectionHandles_androidKt {
    /* renamed from: SelectionHandle-8fL75-g  reason: not valid java name */
    public static final void m387SelectionHandle8fL75g(final long j, final boolean z, final ResolvedTextDirection direction, final boolean z2, final Modifier modifier, final Function2 function2, Composer composer, final int i) {
        int i2;
        HandleReferencePoint handleReferencePoint;
        Intrinsics.checkNotNullParameter(direction, "direction");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Composer startRestartGroup = composer.startRestartGroup(-616295642);
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= startRestartGroup.changed(direction) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= startRestartGroup.changed(z2) ? 2048 : 1024;
        }
        if ((57344 & i) == 0) {
            i2 |= startRestartGroup.changed(modifier) ? 16384 : 8192;
        }
        if ((458752 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(function2) ? PKIFailureInfo.unsupportedVersion : PKIFailureInfo.notAuthorized;
        }
        final int i3 = i2;
        if ((374491 & i3) != 74898 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-616295642, i3, -1, "androidx.compose.foundation.text.selection.SelectionHandle (AndroidSelectionHandles.android.kt:53)");
            }
            if (isLeft(z, direction, z2)) {
                handleReferencePoint = HandleReferencePoint.TopRight;
            } else {
                handleReferencePoint = HandleReferencePoint.TopLeft;
            }
            m386HandlePopupULxng0E(j, handleReferencePoint, ComposableLambdaKt.composableLambda(startRestartGroup, 732099485, true, new Function2() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$SelectionHandle$1
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

                public final void invoke(Composer composer2, int i4) {
                    if ((i4 & 11) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(732099485, i4, -1, "androidx.compose.foundation.text.selection.SelectionHandle.<anonymous> (AndroidSelectionHandles.android.kt:69)");
                        }
                        if (Function2.this == null) {
                            composer2.startReplaceableGroup(386443790);
                            Modifier modifier2 = modifier;
                            Boolean valueOf = Boolean.valueOf(z);
                            Offset m698boximpl = Offset.m698boximpl(j);
                            final boolean z3 = z;
                            final long j2 = j;
                            composer2.startReplaceableGroup(511388516);
                            boolean changed = composer2.changed(valueOf) | composer2.changed(m698boximpl);
                            Object rememberedValue = composer2.rememberedValue();
                            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                                rememberedValue = new Function1() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$SelectionHandle$1$1$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((SemanticsPropertyReceiver) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(SemanticsPropertyReceiver semantics) {
                                        Handle handle;
                                        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                                        SemanticsPropertyKey selectionHandleInfoKey = SelectionHandlesKt.getSelectionHandleInfoKey();
                                        if (z3) {
                                            handle = Handle.SelectionStart;
                                        } else {
                                            handle = Handle.SelectionEnd;
                                        }
                                        semantics.set(selectionHandleInfoKey, new SelectionHandleInfo(handle, j2, null));
                                    }
                                };
                                composer2.updateRememberedValue(rememberedValue);
                            }
                            composer2.endReplaceableGroup();
                            Modifier semantics$default = SemanticsModifierKt.semantics$default(modifier2, false, (Function1) rememberedValue, 1, null);
                            boolean z4 = z;
                            ResolvedTextDirection resolvedTextDirection = direction;
                            boolean z5 = z2;
                            int i5 = i3;
                            AndroidSelectionHandles_androidKt.DefaultSelectionHandle(semantics$default, z4, resolvedTextDirection, z5, composer2, (i5 & 112) | (i5 & 896) | (i5 & 7168));
                            composer2.endReplaceableGroup();
                        } else {
                            composer2.startReplaceableGroup(386444465);
                            Function2.this.invoke(composer2, Integer.valueOf((i3 >> 15) & 14));
                            composer2.endReplaceableGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }), startRestartGroup, (i3 & 14) | 384);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$SelectionHandle$2
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

            public final void invoke(Composer composer2, int i4) {
                AndroidSelectionHandles_androidKt.m387SelectionHandle8fL75g(j, z, direction, z2, modifier, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    public static final void DefaultSelectionHandle(final Modifier modifier, final boolean z, final ResolvedTextDirection direction, final boolean z2, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(direction, "direction");
        Composer startRestartGroup = composer.startRestartGroup(47957398);
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= startRestartGroup.changed(direction) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= startRestartGroup.changed(z2) ? 2048 : 1024;
        }
        if ((i2 & 5851) != 1170 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(47957398, i, -1, "androidx.compose.foundation.text.selection.DefaultSelectionHandle (AndroidSelectionHandles.android.kt:95)");
            }
            SpacerKt.Spacer(drawSelectionHandle(SizeKt.m232sizeVpY3zN4(modifier, SelectionHandlesKt.getHandleWidth(), SelectionHandlesKt.getHandleHeight()), z, direction, z2), startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$DefaultSelectionHandle$1
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

            public final void invoke(Composer composer2, int i3) {
                AndroidSelectionHandles_androidKt.DefaultSelectionHandle(Modifier.this, z, direction, z2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    public static final Modifier drawSelectionHandle(Modifier modifier, final boolean z, final ResolvedTextDirection direction, final boolean z2) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(direction, "direction");
        return ComposedModifierKt.composed$default(modifier, null, new Function3() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$drawSelectionHandle$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
            }

            /* JADX WARN: Code restructure failed: missing block: B:11:0x006d, code lost:
                if (r0 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L18;
             */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v4, types: [androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$drawSelectionHandle$1$1$1] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final androidx.compose.ui.Modifier invoke(androidx.compose.ui.Modifier r11, androidx.compose.runtime.Composer r12, int r13) {
                /*
                    r10 = this;
                    java.lang.String r0 = "$this$composed"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
                    r0 = -1538687176(0xffffffffa4497f38, float:-4.3692686E-17)
                    r12.startReplaceableGroup(r0)
                    boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                    if (r1 == 0) goto L17
                    r1 = -1
                    java.lang.String r2 = "androidx.compose.foundation.text.selection.drawSelectionHandle.<anonymous> (AndroidSelectionHandles.android.kt:111)"
                    androidx.compose.runtime.ComposerKt.traceEventStart(r0, r13, r1, r2)
                L17:
                    androidx.compose.runtime.ProvidableCompositionLocal r13 = androidx.compose.foundation.text.selection.TextSelectionColorsKt.getLocalTextSelectionColors()
                    java.lang.Object r13 = r12.consume(r13)
                    androidx.compose.foundation.text.selection.TextSelectionColors r13 = (androidx.compose.foundation.text.selection.TextSelectionColors) r13
                    long r1 = r13.m425getHandleColor0d7_KjU()
                    androidx.compose.ui.Modifier$Companion r13 = androidx.compose.ui.Modifier.Companion
                    r0 = 4
                    java.lang.Object[] r3 = new java.lang.Object[r0]
                    androidx.compose.ui.graphics.Color r4 = androidx.compose.ui.graphics.Color.m841boximpl(r1)
                    r5 = 0
                    r3[r5] = r4
                    boolean r4 = r1
                    java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
                    r6 = 1
                    r3[r6] = r4
                    r4 = 2
                    androidx.compose.ui.text.style.ResolvedTextDirection r6 = r2
                    r3[r4] = r6
                    boolean r4 = r3
                    java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
                    r6 = 3
                    r3[r6] = r4
                    boolean r4 = r1
                    androidx.compose.ui.text.style.ResolvedTextDirection r6 = r2
                    boolean r7 = r3
                    r8 = -568225417(0xffffffffde219177, float:-2.91055434E18)
                    r12.startReplaceableGroup(r8)
                    r8 = r5
                L55:
                    if (r5 >= r0) goto L61
                    r9 = r3[r5]
                    boolean r9 = r12.changed(r9)
                    r8 = r8 | r9
                    int r5 = r5 + 1
                    goto L55
                L61:
                    java.lang.Object r0 = r12.rememberedValue()
                    if (r8 != 0) goto L6f
                    androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
                    java.lang.Object r3 = r3.getEmpty()
                    if (r0 != r3) goto L7b
                L6f:
                    androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$drawSelectionHandle$1$1$1 r8 = new androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$drawSelectionHandle$1$1$1
                    r0 = r8
                    r3 = r4
                    r4 = r6
                    r5 = r7
                    r0.<init>()
                    r12.updateRememberedValue(r8)
                L7b:
                    r12.endReplaceableGroup()
                    kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
                    androidx.compose.ui.Modifier r13 = androidx.compose.ui.draw.DrawModifierKt.drawWithCache(r13, r0)
                    androidx.compose.ui.Modifier r11 = r11.then(r13)
                    boolean r13 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                    if (r13 == 0) goto L91
                    androidx.compose.runtime.ComposerKt.traceEventEnd()
                L91:
                    r12.endReplaceableGroup()
                    return r11
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$drawSelectionHandle$1.invoke(androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int):androidx.compose.ui.Modifier");
            }
        }, 1, null);
    }

    public static final ImageBitmap createHandleImage(CacheDrawScope cacheDrawScope, float f) {
        Intrinsics.checkNotNullParameter(cacheDrawScope, "<this>");
        int ceil = ((int) Math.ceil(f)) * 2;
        HandleImageCache handleImageCache = HandleImageCache.INSTANCE;
        ImageBitmap imageBitmap = handleImageCache.getImageBitmap();
        Canvas canvas = handleImageCache.getCanvas();
        CanvasDrawScope canvasDrawScope = handleImageCache.getCanvasDrawScope();
        if (imageBitmap == null || canvas == null || ceil > imageBitmap.getWidth() || ceil > imageBitmap.getHeight()) {
            imageBitmap = ImageBitmapKt.m908ImageBitmapx__hDU$default(ceil, ceil, ImageBitmapConfig.Companion.m902getAlpha8_sVssgQ(), false, null, 24, null);
            handleImageCache.setImageBitmap(imageBitmap);
            canvas = CanvasKt.Canvas(imageBitmap);
            handleImageCache.setCanvas(canvas);
        }
        ImageBitmap imageBitmap2 = imageBitmap;
        Canvas canvas2 = canvas;
        if (canvasDrawScope == null) {
            canvasDrawScope = new CanvasDrawScope();
            handleImageCache.setCanvasDrawScope(canvasDrawScope);
        }
        CanvasDrawScope canvasDrawScope2 = canvasDrawScope;
        LayoutDirection layoutDirection = cacheDrawScope.getLayoutDirection();
        long Size = androidx.compose.ui.geometry.SizeKt.Size(imageBitmap2.getWidth(), imageBitmap2.getHeight());
        CanvasDrawScope.DrawParams drawParams = canvasDrawScope2.getDrawParams();
        Density component1 = drawParams.component1();
        LayoutDirection component2 = drawParams.component2();
        Canvas component3 = drawParams.component3();
        long m1041component4NHjbRc = drawParams.m1041component4NHjbRc();
        CanvasDrawScope.DrawParams drawParams2 = canvasDrawScope2.getDrawParams();
        drawParams2.setDensity(cacheDrawScope);
        drawParams2.setLayoutDirection(layoutDirection);
        drawParams2.setCanvas(canvas2);
        drawParams2.m1043setSizeuvyYCjk(Size);
        canvas2.save();
        DrawScope.CC.m1063drawRectnJ9OG0$default(canvasDrawScope2, Color.Companion.m860getBlack0d7_KjU(), 0L, canvasDrawScope2.mo1040getSizeNHjbRc(), 0.0f, null, null, BlendMode.Companion.m801getClear0nO6VwU(), 58, null);
        DrawScope.CC.m1063drawRectnJ9OG0$default(canvasDrawScope2, ColorKt.Color(4278190080L), Offset.Companion.m721getZeroF1C5BW0(), androidx.compose.ui.geometry.SizeKt.Size(f, f), 0.0f, null, null, 0, 120, null);
        DrawScope.CC.m1056drawCircleVaOC9Bg$default(canvasDrawScope2, ColorKt.Color(4278190080L), f, OffsetKt.Offset(f, f), 0.0f, null, null, 0, 120, null);
        canvas2.restore();
        CanvasDrawScope.DrawParams drawParams3 = canvasDrawScope2.getDrawParams();
        drawParams3.setDensity(component1);
        drawParams3.setLayoutDirection(component2);
        drawParams3.setCanvas(component3);
        drawParams3.m1043setSizeuvyYCjk(m1041component4NHjbRc);
        return imageBitmap2;
    }

    /* renamed from: HandlePopup-ULxng0E  reason: not valid java name */
    public static final void m386HandlePopupULxng0E(final long j, final HandleReferencePoint handleReferencePoint, final Function2 content, Composer composer, final int i) {
        int i2;
        int roundToInt;
        int roundToInt2;
        Intrinsics.checkNotNullParameter(handleReferencePoint, "handleReferencePoint");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer startRestartGroup = composer.startRestartGroup(-1409050158);
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changed(handleReferencePoint) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= startRestartGroup.changedInstance(content) ? 256 : 128;
        }
        if ((i2 & 731) != 146 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1409050158, i2, -1, "androidx.compose.foundation.text.selection.HandlePopup (AndroidSelectionHandles.android.kt:223)");
            }
            roundToInt = MathKt__MathJVMKt.roundToInt(Offset.m709getXimpl(j));
            roundToInt2 = MathKt__MathJVMKt.roundToInt(Offset.m710getYimpl(j));
            long IntOffset = IntOffsetKt.IntOffset(roundToInt, roundToInt2);
            IntOffset m1929boximpl = IntOffset.m1929boximpl(IntOffset);
            startRestartGroup.startReplaceableGroup(511388516);
            boolean changed = startRestartGroup.changed(m1929boximpl) | startRestartGroup.changed(handleReferencePoint);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new HandlePositionProvider(handleReferencePoint, IntOffset, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            AndroidPopup_androidKt.Popup((HandlePositionProvider) rememberedValue, null, new PopupProperties(false, false, false, null, true, false, 15, null), content, startRestartGroup, ((i2 << 3) & 7168) | 384, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$HandlePopup$1
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

            public final void invoke(Composer composer2, int i3) {
                AndroidSelectionHandles_androidKt.m386HandlePopupULxng0E(j, handleReferencePoint, content, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isLeft(boolean z, ResolvedTextDirection resolvedTextDirection, boolean z2) {
        if (z) {
            return isHandleLtrDirection(resolvedTextDirection, z2);
        }
        return !isHandleLtrDirection(resolvedTextDirection, z2);
    }

    public static final boolean isHandleLtrDirection(ResolvedTextDirection direction, boolean z) {
        Intrinsics.checkNotNullParameter(direction, "direction");
        return (direction == ResolvedTextDirection.Ltr && !z) || (direction == ResolvedTextDirection.Rtl && z);
    }
}
