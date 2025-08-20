package org.fdroid.fdroid.views.repos;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.unit.Dp;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.fdroid.repo.AddRepoError;
/* compiled from: AddRepoErrorScreen.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ComposableSingletons$AddRepoErrorScreenKt {
    public static final ComposableSingletons$AddRepoErrorScreenKt INSTANCE = new ComposableSingletons$AddRepoErrorScreenKt();

    /* renamed from: lambda-1  reason: not valid java name */
    public static Function2 f26lambda1 = ComposableLambdaKt.composableLambdaInstance(1333154168, false, new Function2() { // from class: org.fdroid.fdroid.views.repos.ComposableSingletons$AddRepoErrorScreenKt$lambda-1$1
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
                ComposerKt.traceEventStart(1333154168, i, -1, "org.fdroid.fdroid.views.repos.ComposableSingletons$AddRepoErrorScreenKt.lambda-1.<anonymous> (AddRepoErrorScreen.kt:84)");
            }
            AddRepoErrorScreenKt.AddRepoErrorScreen(PaddingKt.m202PaddingValues0680j_4(Dp.m1897constructorimpl(0)), new AddRepoError(AddRepoError.ErrorType.INVALID_FINGERPRINT, null, 2, null), composer, 70);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-2  reason: not valid java name */
    public static Function2 f27lambda2 = ComposableLambdaKt.composableLambdaInstance(332172503, false, new Function2() { // from class: org.fdroid.fdroid.views.repos.ComposableSingletons$AddRepoErrorScreenKt$lambda-2$1
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
                ComposerKt.traceEventStart(332172503, i, -1, "org.fdroid.fdroid.views.repos.ComposableSingletons$AddRepoErrorScreenKt.lambda-2.<anonymous> (AddRepoErrorScreen.kt:92)");
            }
            AddRepoErrorScreenKt.AddRepoErrorScreen(PaddingKt.m202PaddingValues0680j_4(Dp.m1897constructorimpl(0)), new AddRepoError(AddRepoError.ErrorType.IO_ERROR, new IOException("foo bar")), composer, 70);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-3  reason: not valid java name */
    public static Function2 f28lambda3 = ComposableLambdaKt.composableLambdaInstance(1752749798, false, new Function2() { // from class: org.fdroid.fdroid.views.repos.ComposableSingletons$AddRepoErrorScreenKt$lambda-3$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            if ((i & 11) != 2 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1752749798, i, -1, "org.fdroid.fdroid.views.repos.ComposableSingletons$AddRepoErrorScreenKt.lambda-3.<anonymous> (AddRepoErrorScreen.kt:100)");
                }
                AddRepoErrorScreenKt.AddRepoErrorScreen(PaddingKt.m202PaddingValues0680j_4(Dp.m1897constructorimpl(0)), new AddRepoError(AddRepoError.ErrorType.INVALID_INDEX, new RuntimeException("foo bar")), composer, 70);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    });

    /* renamed from: lambda-4  reason: not valid java name */
    public static Function2 f29lambda4 = ComposableLambdaKt.composableLambdaInstance(-1619299495, false, new Function2() { // from class: org.fdroid.fdroid.views.repos.ComposableSingletons$AddRepoErrorScreenKt$lambda-4$1
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
                ComposerKt.traceEventStart(-1619299495, i, -1, "org.fdroid.fdroid.views.repos.ComposableSingletons$AddRepoErrorScreenKt.lambda-4.<anonymous> (AddRepoErrorScreen.kt:111)");
            }
            AddRepoErrorScreenKt.AddRepoErrorScreen(PaddingKt.m202PaddingValues0680j_4(Dp.m1897constructorimpl(0)), new AddRepoError(AddRepoError.ErrorType.UNKNOWN_SOURCES_DISALLOWED, null, 2, null), composer, 70);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-5  reason: not valid java name */
    public static Function2 f30lambda5 = ComposableLambdaKt.composableLambdaInstance(-1373568745, false, new Function2() { // from class: org.fdroid.fdroid.views.repos.ComposableSingletons$AddRepoErrorScreenKt$lambda-5$1
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
                ComposerKt.traceEventStart(-1373568745, i, -1, "org.fdroid.fdroid.views.repos.ComposableSingletons$AddRepoErrorScreenKt.lambda-5.<anonymous> (AddRepoErrorScreen.kt:119)");
            }
            AddRepoErrorScreenKt.AddRepoErrorScreen(PaddingKt.m202PaddingValues0680j_4(Dp.m1897constructorimpl(0)), new AddRepoError(AddRepoError.ErrorType.IS_ARCHIVE_REPO, null, 2, null), composer, 70);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: getLambda-1$app_fullRelease  reason: not valid java name */
    public final Function2 m2613getLambda1$app_fullRelease() {
        return f26lambda1;
    }

    /* renamed from: getLambda-2$app_fullRelease  reason: not valid java name */
    public final Function2 m2614getLambda2$app_fullRelease() {
        return f27lambda2;
    }

    /* renamed from: getLambda-3$app_fullRelease  reason: not valid java name */
    public final Function2 m2615getLambda3$app_fullRelease() {
        return f28lambda3;
    }

    /* renamed from: getLambda-4$app_fullRelease  reason: not valid java name */
    public final Function2 m2616getLambda4$app_fullRelease() {
        return f29lambda4;
    }

    /* renamed from: getLambda-5$app_fullRelease  reason: not valid java name */
    public final Function2 m2617getLambda5$app_fullRelease() {
        return f30lambda5;
    }
}
