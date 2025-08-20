package org.fdroid.fdroid.views;

import androidx.compose.material.ContentAlpha;
import androidx.compose.material.IconKt;
import androidx.compose.material.TextKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.ArrowBackKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.res.StringResources_androidKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.fdroid.fdroid.R;
/* compiled from: IpfsGatewayAddActivity.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ComposableSingletons$IpfsGatewayAddActivityKt {
    public static final ComposableSingletons$IpfsGatewayAddActivityKt INSTANCE = new ComposableSingletons$IpfsGatewayAddActivityKt();

    /* renamed from: lambda-1  reason: not valid java name */
    public static Function2 f19lambda1 = ComposableLambdaKt.composableLambdaInstance(1599745883, false, new Function2() { // from class: org.fdroid.fdroid.views.ComposableSingletons$IpfsGatewayAddActivityKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            if ((i & 11) != 2 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1599745883, i, -1, "org.fdroid.fdroid.views.ComposableSingletons$IpfsGatewayAddActivityKt.lambda-1.<anonymous> (IpfsGatewayAddActivity.kt:90)");
                }
                TextKt.m581Text4IGK_g(StringResources_androidKt.stringResource(R.string.ipfsgw_add_title, composer, 0), AlphaKt.alpha(Modifier.Companion, ContentAlpha.INSTANCE.getHigh(composer, ContentAlpha.$stable)), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 0, 0, 131068);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    });

    /* renamed from: lambda-2  reason: not valid java name */
    public static Function2 f20lambda2 = ComposableLambdaKt.composableLambdaInstance(-236309383, false, new Function2() { // from class: org.fdroid.fdroid.views.ComposableSingletons$IpfsGatewayAddActivityKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            if ((i & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-236309383, i, -1, "org.fdroid.fdroid.views.ComposableSingletons$IpfsGatewayAddActivityKt.lambda-2.<anonymous> (IpfsGatewayAddActivity.kt:86)");
            }
            IconKt.m503Iconww6aTOc(ArrowBackKt.getArrowBack(Icons.Filled.INSTANCE), StringResources_androidKt.stringResource(R.string.back, composer, 0), (Modifier) null, 0L, composer, 0, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-3  reason: not valid java name */
    public static Function2 f21lambda3 = ComposableLambdaKt.composableLambdaInstance(842538791, false, new Function2() { // from class: org.fdroid.fdroid.views.ComposableSingletons$IpfsGatewayAddActivityKt$lambda-3$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            if ((i & 11) != 2 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(842538791, i, -1, "org.fdroid.fdroid.views.ComposableSingletons$IpfsGatewayAddActivityKt.lambda-3.<anonymous> (IpfsGatewayAddActivity.kt:182)");
                }
                IpfsGatewayAddActivityKt.IpfsGatewayAddScreen(new Function0() { // from class: org.fdroid.fdroid.views.ComposableSingletons$IpfsGatewayAddActivityKt$lambda-3$1.1
                    /* renamed from: invoke  reason: collision with other method in class */
                    public final void m2536invoke() {
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m2536invoke();
                        return Unit.INSTANCE;
                    }
                }, new Function1() { // from class: org.fdroid.fdroid.views.ComposableSingletons$IpfsGatewayAddActivityKt$lambda-3$1.2
                    public final void invoke(String it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((String) obj);
                        return Unit.INSTANCE;
                    }
                }, composer, 54);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    });

    /* renamed from: getLambda-1$app_fullRelease  reason: not valid java name */
    public final Function2 m2533getLambda1$app_fullRelease() {
        return f19lambda1;
    }

    /* renamed from: getLambda-2$app_fullRelease  reason: not valid java name */
    public final Function2 m2534getLambda2$app_fullRelease() {
        return f20lambda2;
    }

    /* renamed from: getLambda-3$app_fullRelease  reason: not valid java name */
    public final Function2 m2535getLambda3$app_fullRelease() {
        return f21lambda3;
    }
}
