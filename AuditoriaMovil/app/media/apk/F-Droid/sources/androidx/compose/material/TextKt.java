package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.text.TextStyle;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Text.kt */
/* loaded from: classes.dex */
public abstract class TextKt {
    private static final ProvidableCompositionLocal LocalTextStyle = CompositionLocalKt.compositionLocalOf(SnapshotStateKt.structuralEqualityPolicy(), new Function0() { // from class: androidx.compose.material.TextKt$LocalTextStyle$1
        @Override // kotlin.jvm.functions.Function0
        public final TextStyle invoke() {
            return TypographyKt.getDefaultTextStyle();
        }
    });

    public static final ProvidableCompositionLocal getLocalTextStyle() {
        return LocalTextStyle;
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x02e2  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x02fa  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0310  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x032a  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0335  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x035d  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0360  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x040c  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x042d  */
    /* JADX WARN: Removed duplicated region for block: B:267:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0133  */
    /* renamed from: Text--4IGK_g  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m581Text4IGK_g(final java.lang.String r68, androidx.compose.ui.Modifier r69, long r70, long r72, androidx.compose.ui.text.font.FontStyle r74, androidx.compose.ui.text.font.FontWeight r75, androidx.compose.ui.text.font.FontFamily r76, long r77, androidx.compose.ui.text.style.TextDecoration r79, androidx.compose.ui.text.style.TextAlign r80, long r81, int r83, boolean r84, int r85, int r86, kotlin.jvm.functions.Function1 r87, androidx.compose.ui.text.TextStyle r88, androidx.compose.runtime.Composer r89, final int r90, final int r91, final int r92) {
        /*
            Method dump skipped, instructions count: 1104
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextKt.m581Text4IGK_g(java.lang.String, androidx.compose.ui.Modifier, long, long, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontFamily, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.text.style.TextAlign, long, int, boolean, int, int, kotlin.jvm.functions.Function1, androidx.compose.ui.text.TextStyle, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x02df  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x02f5  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x02f9  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0305  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x030b  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0318  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x031d  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x032c  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0346  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x0379  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x0380  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0433  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x045b  */
    /* JADX WARN: Removed duplicated region for block: B:276:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0135  */
    /* renamed from: Text-IbK3jfQ  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m582TextIbK3jfQ(final androidx.compose.ui.text.AnnotatedString r69, androidx.compose.ui.Modifier r70, long r71, long r73, androidx.compose.ui.text.font.FontStyle r75, androidx.compose.ui.text.font.FontWeight r76, androidx.compose.ui.text.font.FontFamily r77, long r78, androidx.compose.ui.text.style.TextDecoration r80, androidx.compose.ui.text.style.TextAlign r81, long r82, int r84, boolean r85, int r86, int r87, java.util.Map r88, kotlin.jvm.functions.Function1 r89, androidx.compose.ui.text.TextStyle r90, androidx.compose.runtime.Composer r91, final int r92, final int r93, final int r94) {
        /*
            Method dump skipped, instructions count: 1140
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextKt.m582TextIbK3jfQ(androidx.compose.ui.text.AnnotatedString, androidx.compose.ui.Modifier, long, long, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontFamily, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.text.style.TextAlign, long, int, boolean, int, int, java.util.Map, kotlin.jvm.functions.Function1, androidx.compose.ui.text.TextStyle, androidx.compose.runtime.Composer, int, int, int):void");
    }

    public static final void ProvideTextStyle(final TextStyle value, final Function2 content, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer startRestartGroup = composer.startRestartGroup(1772272796);
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed(value) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changedInstance(content) ? 32 : 16;
        }
        if ((i2 & 91) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1772272796, i2, -1, "androidx.compose.material.ProvideTextStyle (Text.kt:393)");
            }
            ProvidableCompositionLocal providableCompositionLocal = LocalTextStyle;
            CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{providableCompositionLocal.provides(((TextStyle) startRestartGroup.consume(providableCompositionLocal)).merge(value))}, content, startRestartGroup, (i2 & 112) | 8);
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
        endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TextKt$ProvideTextStyle$1
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
                TextKt.ProvideTextStyle(TextStyle.this, content, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }
}
