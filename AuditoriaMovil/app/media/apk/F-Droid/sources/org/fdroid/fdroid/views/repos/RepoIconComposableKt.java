package org.fdroid.fdroid.views.repos;

import android.content.Context;
import androidx.compose.foundation.ImageKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.InspectionModeKt;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.os.LocaleListCompat;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.integration.compose.GlideImageKt;
import com.bumptech.glide.request.BaseRequestOptions;
import com.google.accompanist.drawablepainter.DrawablePainterKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.fdroid.database.Repository;
import org.fdroid.fdroid.R;
import org.fdroid.fdroid.Utils;
/* compiled from: RepoIconComposable.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"RepoIcon", "", "repo", "Lorg/fdroid/database/Repository;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lorg/fdroid/database/Repository;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "app_fullRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RepoIconComposableKt {
    public static final void RepoIcon(final Repository repo, Modifier modifier, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(repo, "repo");
        Composer startRestartGroup = composer.startRestartGroup(-1729678669);
        Modifier.Companion companion = (i2 & 2) != 0 ? Modifier.Companion : modifier;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1729678669, i, -1, "org.fdroid.fdroid.views.repos.RepoIcon (RepoIconComposable.kt:18)");
        }
        if (((Boolean) startRestartGroup.consume(InspectionModeKt.getLocalInspectionMode())).booleanValue()) {
            startRestartGroup.startReplaceableGroup(-1914724224);
            ImageKt.Image(DrawablePainterKt.rememberDrawablePainter(ResourcesCompat.getDrawable(((Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext())).getResources(), R.drawable.ic_launcher, null), startRestartGroup, 8), (String) null, companion, (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, startRestartGroup, ((i << 3) & 896) | 56, 120);
            startRestartGroup.endReplaceableGroup();
            modifier2 = companion;
            composer2 = startRestartGroup;
        } else {
            startRestartGroup.startReplaceableGroup(-1914724002);
            LocaleListCompat localeListCompat = LocaleListCompat.getDefault();
            Intrinsics.checkNotNullExpressionValue(localeListCompat, "getDefault(...)");
            modifier2 = companion;
            composer2 = startRestartGroup;
            GlideImageKt.GlideImage(Utils.getGlideModel(repo, repo.getIcon(localeListCompat)), null, companion, null, null, 0.0f, null, null, null, new Function1() { // from class: org.fdroid.fdroid.views.repos.RepoIconComposableKt$RepoIcon$1
                @Override // kotlin.jvm.functions.Function1
                public final RequestBuilder invoke(RequestBuilder requestBuilder) {
                    Intrinsics.checkNotNullParameter(requestBuilder, "requestBuilder");
                    BaseRequestOptions error = ((RequestBuilder) requestBuilder.fallback(R.drawable.ic_repo_app_default)).error(R.drawable.ic_repo_app_default);
                    Intrinsics.checkNotNullExpressionValue(error, "error(...)");
                    return (RequestBuilder) error;
                }
            }, startRestartGroup, ((i << 3) & 896) | 805306424, 504);
            composer2.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            endRestartGroup.updateScope(new Function2() { // from class: org.fdroid.fdroid.views.repos.RepoIconComposableKt$RepoIcon$2
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

                public final void invoke(Composer composer3, int i3) {
                    RepoIconComposableKt.RepoIcon(Repository.this, modifier3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }
}
