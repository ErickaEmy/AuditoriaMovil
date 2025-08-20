package org.fdroid.fdroid.views;

import androidx.compose.material.ContentAlpha;
import androidx.compose.material.IconKt;
import androidx.compose.material.TextKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.AddKt;
import androidx.compose.material.icons.filled.ArrowBackKt;
import androidx.compose.material.icons.filled.DeleteForeverKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.res.StringResources_androidKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.fdroid.fdroid.R;
/* compiled from: IpfsGatewaySettingsActivity.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ComposableSingletons$IpfsGatewaySettingsActivityKt {
    public static final ComposableSingletons$IpfsGatewaySettingsActivityKt INSTANCE = new ComposableSingletons$IpfsGatewaySettingsActivityKt();

    /* renamed from: lambda-1  reason: not valid java name */
    public static Function2 f22lambda1 = ComposableLambdaKt.composableLambdaInstance(-980721493, false, new Function2() { // from class: org.fdroid.fdroid.views.ComposableSingletons$IpfsGatewaySettingsActivityKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            if ((i & 11) != 2 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-980721493, i, -1, "org.fdroid.fdroid.views.ComposableSingletons$IpfsGatewaySettingsActivityKt.lambda-1.<anonymous> (IpfsGatewaySettingsActivity.kt:87)");
                }
                TextKt.m581Text4IGK_g(StringResources_androidKt.stringResource(R.string.ipfsgw_title, composer, 0), AlphaKt.alpha(Modifier.Companion, ContentAlpha.INSTANCE.getHigh(composer, ContentAlpha.$stable)), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 0, 0, 131068);
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
    public static Function2 f23lambda2 = ComposableLambdaKt.composableLambdaInstance(-2021754035, false, new Function2() { // from class: org.fdroid.fdroid.views.ComposableSingletons$IpfsGatewaySettingsActivityKt$lambda-2$1
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
                ComposerKt.traceEventStart(-2021754035, i, -1, "org.fdroid.fdroid.views.ComposableSingletons$IpfsGatewaySettingsActivityKt.lambda-2.<anonymous> (IpfsGatewaySettingsActivity.kt:83)");
            }
            IconKt.m503Iconww6aTOc(ArrowBackKt.getArrowBack(Icons.Filled.INSTANCE), StringResources_androidKt.stringResource(R.string.back, composer, 0), (Modifier) null, 0L, composer, 0, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-3  reason: not valid java name */
    public static Function2 f24lambda3 = ComposableLambdaKt.composableLambdaInstance(617013903, false, new Function2() { // from class: org.fdroid.fdroid.views.ComposableSingletons$IpfsGatewaySettingsActivityKt$lambda-3$1
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
                ComposerKt.traceEventStart(617013903, i, -1, "org.fdroid.fdroid.views.ComposableSingletons$IpfsGatewaySettingsActivityKt.lambda-3.<anonymous> (IpfsGatewaySettingsActivity.kt:100)");
            }
            IconKt.m503Iconww6aTOc(AddKt.getAdd(Icons.Filled.INSTANCE), StringResources_androidKt.stringResource(R.string.ipfsgw_add_add, composer, 0), (Modifier) null, 0L, composer, 0, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-4  reason: not valid java name */
    public static Function2 f25lambda4 = ComposableLambdaKt.composableLambdaInstance(490764964, false, new Function2() { // from class: org.fdroid.fdroid.views.ComposableSingletons$IpfsGatewaySettingsActivityKt$lambda-4$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            if ((i & 11) != 2 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(490764964, i, -1, "org.fdroid.fdroid.views.ComposableSingletons$IpfsGatewaySettingsActivityKt.lambda-4.<anonymous> (IpfsGatewaySettingsActivity.kt:223)");
                }
                IconKt.m503Iconww6aTOc(DeleteForeverKt.getDeleteForever(Icons.INSTANCE.getDefault()), "Localized description", (Modifier) null, 0L, composer, 48, 12);
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
    public final Function2 m2537getLambda1$app_fullRelease() {
        return f22lambda1;
    }

    /* renamed from: getLambda-2$app_fullRelease  reason: not valid java name */
    public final Function2 m2538getLambda2$app_fullRelease() {
        return f23lambda2;
    }

    /* renamed from: getLambda-3$app_fullRelease  reason: not valid java name */
    public final Function2 m2539getLambda3$app_fullRelease() {
        return f24lambda3;
    }

    /* renamed from: getLambda-4$app_fullRelease  reason: not valid java name */
    public final Function2 m2540getLambda4$app_fullRelease() {
        return f25lambda4;
    }
}
