package org.fdroid.fdroid.views.repos;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.fdroid.fdroid.R;
/* compiled from: RepoProgressScreen.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ComposableSingletons$RepoProgressScreenKt {
    public static final ComposableSingletons$RepoProgressScreenKt INSTANCE = new ComposableSingletons$RepoProgressScreenKt();

    /* renamed from: lambda-1  reason: not valid java name */
    public static Function2 f34lambda1 = ComposableLambdaKt.composableLambdaInstance(-1944487630, false, new Function2() { // from class: org.fdroid.fdroid.views.repos.ComposableSingletons$RepoProgressScreenKt$lambda-1$1
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
                ComposerKt.traceEventStart(-1944487630, i, -1, "org.fdroid.fdroid.views.repos.ComposableSingletons$RepoProgressScreenKt.lambda-1.<anonymous> (RepoProgressScreen.kt:43)");
            }
            RepoProgressScreenKt.RepoProgressScreen(PaddingKt.m202PaddingValues0680j_4(Dp.m1897constructorimpl(0)), StringResources_androidKt.stringResource(R.string.repo_state_fetching, composer, 0), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: getLambda-1$app_fullRelease  reason: not valid java name */
    public final Function2 m2625getLambda1$app_fullRelease() {
        return f34lambda1;
    }
}
