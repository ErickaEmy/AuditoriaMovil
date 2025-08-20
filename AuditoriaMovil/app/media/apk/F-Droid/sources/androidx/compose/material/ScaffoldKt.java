package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.asn1.cmp.PKIFailureInfo;
/* compiled from: Scaffold.kt */
/* loaded from: classes.dex */
public abstract class ScaffoldKt {
    private static final ProvidableCompositionLocal LocalFabPlacement = CompositionLocalKt.staticCompositionLocalOf(new Function0() { // from class: androidx.compose.material.ScaffoldKt$LocalFabPlacement$1
        @Override // kotlin.jvm.functions.Function0
        public final FabPlacement invoke() {
            return null;
        }
    });
    private static final float FabSpacing = Dp.m1897constructorimpl(16);

    public static final ProvidableCompositionLocal getLocalFabPlacement() {
        return LocalFabPlacement;
    }

    public static final ScaffoldState rememberScaffoldState(DrawerState drawerState, SnackbarHostState snackbarHostState, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1569641925);
        if ((i2 & 1) != 0) {
            drawerState = DrawerKt.rememberDrawerState(DrawerValue.Closed, null, composer, 6, 2);
        }
        if ((i2 & 2) != 0) {
            composer.startReplaceableGroup(-492369756);
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new SnackbarHostState();
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            snackbarHostState = (SnackbarHostState) rememberedValue;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1569641925, i, -1, "androidx.compose.material.rememberScaffoldState (Scaffold.kt:62)");
        }
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new ScaffoldState(drawerState, snackbarHostState);
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        ScaffoldState scaffoldState = (ScaffoldState) rememberedValue2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return scaffoldState;
    }

    /* JADX WARN: Code restructure failed: missing block: B:143:0x01b6, code lost:
        if (r0.changed(r55) == false) goto L63;
     */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x02d6  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x02df  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x02f2  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x02f9  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0326  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0328  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x032c  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x032e  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0332  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0334  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x034e  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x0353  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x035a  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0360  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x037b  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x038a  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0395  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x039b  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x03a9  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x03b4  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x03c3  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x03c9  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x03ec  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x0408  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x043b  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x0499  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x04b5  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x04dd  */
    /* JADX WARN: Removed duplicated region for block: B:299:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x013d  */
    /* renamed from: Scaffold-27mzLpw  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m527Scaffold27mzLpw(androidx.compose.ui.Modifier r41, androidx.compose.material.ScaffoldState r42, kotlin.jvm.functions.Function2 r43, kotlin.jvm.functions.Function2 r44, kotlin.jvm.functions.Function3 r45, kotlin.jvm.functions.Function2 r46, int r47, boolean r48, kotlin.jvm.functions.Function3 r49, boolean r50, androidx.compose.ui.graphics.Shape r51, float r52, long r53, long r55, long r57, long r59, long r61, final kotlin.jvm.functions.Function3 r63, androidx.compose.runtime.Composer r64, final int r65, final int r66, final int r67) {
        /*
            Method dump skipped, instructions count: 1275
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ScaffoldKt.m527Scaffold27mzLpw(androidx.compose.ui.Modifier, androidx.compose.material.ScaffoldState, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, int, boolean, kotlin.jvm.functions.Function3, boolean, androidx.compose.ui.graphics.Shape, float, long, long, long, long, long, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ScaffoldLayout-MDYNRJg  reason: not valid java name */
    public static final void m528ScaffoldLayoutMDYNRJg(final boolean z, final int i, final Function2 function2, final Function3 function3, final Function2 function22, final Function2 function23, final Function2 function24, Composer composer, final int i2) {
        int i3;
        int i4;
        Composer startRestartGroup = composer.startRestartGroup(-1401632215);
        int i5 = (i2 & 14) == 0 ? (startRestartGroup.changed(z) ? 4 : 2) | i2 : i2;
        if ((i2 & 112) == 0) {
            i5 |= startRestartGroup.changed(i) ? 32 : 16;
        }
        if ((i2 & 896) == 0) {
            i5 |= startRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i2 & 7168) == 0) {
            i5 |= startRestartGroup.changedInstance(function3) ? 2048 : 1024;
        }
        if ((57344 & i2) == 0) {
            i5 |= startRestartGroup.changedInstance(function22) ? 16384 : 8192;
        }
        if ((458752 & i2) == 0) {
            i5 |= startRestartGroup.changedInstance(function23) ? PKIFailureInfo.unsupportedVersion : PKIFailureInfo.notAuthorized;
        }
        if ((3670016 & i2) == 0) {
            i5 |= startRestartGroup.changedInstance(function24) ? PKIFailureInfo.badCertTemplate : PKIFailureInfo.signerNotTrusted;
        }
        final int i6 = i5;
        if ((2995931 & i6) != 599186 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1401632215, i6, -1, "androidx.compose.material.ScaffoldLayout (Scaffold.kt:227)");
            }
            Object[] objArr = {function2, function22, function23, FabPosition.m492boximpl(i), Boolean.valueOf(z), function24, function3};
            startRestartGroup.startReplaceableGroup(-568225417);
            int i7 = 0;
            boolean z2 = false;
            for (int i8 = 7; i7 < i8; i8 = 7) {
                z2 |= startRestartGroup.changed(objArr[i7]);
                i7++;
            }
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z2 || rememberedValue == Composer.Companion.getEmpty()) {
                i3 = 1;
                i4 = 0;
                Function2 function25 = new Function2() { // from class: androidx.compose.material.ScaffoldKt$ScaffoldLayout$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        return m530invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).m1877unboximpl());
                    }

                    /* renamed from: invoke-0kLqBqw  reason: not valid java name */
                    public final MeasureResult m530invoke0kLqBqw(final SubcomposeMeasureScope SubcomposeLayout, long j) {
                        Intrinsics.checkNotNullParameter(SubcomposeLayout, "$this$SubcomposeLayout");
                        final int m1872getMaxWidthimpl = Constraints.m1872getMaxWidthimpl(j);
                        final int m1871getMaxHeightimpl = Constraints.m1871getMaxHeightimpl(j);
                        final long m1863copyZbe2FdA$default = Constraints.m1863copyZbe2FdA$default(j, 0, 0, 0, 0, 10, null);
                        final Function2 function26 = Function2.this;
                        final Function2 function27 = function22;
                        final Function2 function28 = function23;
                        final int i9 = i;
                        final boolean z3 = z;
                        final Function2 function29 = function24;
                        final int i10 = i6;
                        final Function3 function32 = function3;
                        return MeasureScope.CC.layout$default(SubcomposeLayout, m1872getMaxWidthimpl, m1871getMaxHeightimpl, null, new Function1() { // from class: androidx.compose.material.ScaffoldKt$ScaffoldLayout$1$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((Placeable.PlacementScope) obj);
                                return Unit.INSTANCE;
                            }

                            /* JADX WARN: Removed duplicated region for block: B:100:0x022c  */
                            /* JADX WARN: Removed duplicated region for block: B:101:0x0232  */
                            /* JADX WARN: Removed duplicated region for block: B:103:0x0235  */
                            /* JADX WARN: Removed duplicated region for block: B:111:0x0269  */
                            /* JADX WARN: Removed duplicated region for block: B:113:0x026d  */
                            /* JADX WARN: Removed duplicated region for block: B:117:0x0279  */
                            /* JADX WARN: Removed duplicated region for block: B:120:0x02a8 A[LOOP:4: B:119:0x02a6->B:120:0x02a8, LOOP_END] */
                            /* JADX WARN: Removed duplicated region for block: B:123:0x02db A[LOOP:5: B:122:0x02d9->B:123:0x02db, LOOP_END] */
                            /* JADX WARN: Removed duplicated region for block: B:126:0x030b A[LOOP:6: B:125:0x0309->B:126:0x030b, LOOP_END] */
                            /* JADX WARN: Removed duplicated region for block: B:129:0x0328 A[LOOP:7: B:128:0x0326->B:129:0x0328, LOOP_END] */
                            /* JADX WARN: Removed duplicated region for block: B:132:0x0346 A[LOOP:8: B:131:0x0344->B:132:0x0346, LOOP_END] */
                            /* JADX WARN: Removed duplicated region for block: B:135:0x0364  */
                            /* JADX WARN: Removed duplicated region for block: B:86:0x01e6 A[LOOP:3: B:85:0x01e4->B:86:0x01e6, LOOP_END] */
                            /* JADX WARN: Removed duplicated region for block: B:89:0x01ff  */
                            /* JADX WARN: Removed duplicated region for block: B:90:0x0201  */
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                                To view partially-correct add '--show-bad-code' argument
                            */
                            public final void invoke(androidx.compose.ui.layout.Placeable.PlacementScope r30) {
                                /*
                                    Method dump skipped, instructions count: 906
                                    To view this dump add '--comments-level debug' option
                                */
                                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ScaffoldKt$ScaffoldLayout$1$1.AnonymousClass1.invoke(androidx.compose.ui.layout.Placeable$PlacementScope):void");
                            }
                        }, 4, null);
                    }
                };
                startRestartGroup.updateRememberedValue(function25);
                rememberedValue = function25;
            } else {
                i3 = 1;
                i4 = 0;
            }
            startRestartGroup.endReplaceableGroup();
            SubcomposeLayoutKt.SubcomposeLayout(null, (Function2) rememberedValue, startRestartGroup, i4, i3);
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
        endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ScaffoldKt$ScaffoldLayout$2
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

            public final void invoke(Composer composer2, int i9) {
                ScaffoldKt.m528ScaffoldLayoutMDYNRJg(z, i, function2, function3, function22, function23, function24, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
            }
        });
    }
}
