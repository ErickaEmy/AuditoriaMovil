package org.fdroid.fdroid.views;

import android.os.Bundle;
import androidx.activity.compose.ComponentActivityKt;
import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.fdroid.fdroid.Preferences;
import org.fdroid.fdroid.compose.ComposeUtils;
/* compiled from: IpfsGatewaySettingsActivity.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lorg/fdroid/fdroid/views/IpfsGatewaySettingsActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "prefs", "Lorg/fdroid/fdroid/Preferences;", "getPrefs", "()Lorg/fdroid/fdroid/Preferences;", "setPrefs", "(Lorg/fdroid/fdroid/Preferences;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "app_fullRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class IpfsGatewaySettingsActivity extends AppCompatActivity {
    public static final int $stable = 8;
    public Preferences prefs;

    public final void setPrefs(Preferences preferences) {
        Intrinsics.checkNotNullParameter(preferences, "<set-?>");
        this.prefs = preferences;
    }

    public final Preferences getPrefs() {
        Preferences preferences = this.prefs;
        if (preferences != null) {
            return preferences;
        }
        Intrinsics.throwUninitializedPropertyAccessException("prefs");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Preferences preferences = Preferences.get();
        Intrinsics.checkNotNullExpressionValue(preferences, "get(...)");
        setPrefs(preferences);
        ComponentActivityKt.setContent$default(this, null, ComposableLambdaKt.composableLambdaInstance(-935875152, true, new Function2() { // from class: org.fdroid.fdroid.views.IpfsGatewaySettingsActivity$onCreate$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i) {
                if ((i & 11) != 2 || !composer.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-935875152, i, -1, "org.fdroid.fdroid.views.IpfsGatewaySettingsActivity.onCreate.<anonymous> (IpfsGatewaySettingsActivity.kt:60)");
                    }
                    ComposeUtils composeUtils = ComposeUtils.INSTANCE;
                    final IpfsGatewaySettingsActivity ipfsGatewaySettingsActivity = IpfsGatewaySettingsActivity.this;
                    composeUtils.FDroidContent(ComposableLambdaKt.composableLambda(composer, -1661483272, true, new Function2() { // from class: org.fdroid.fdroid.views.IpfsGatewaySettingsActivity$onCreate$1.1
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i2) {
                            if ((i2 & 11) != 2 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1661483272, i2, -1, "org.fdroid.fdroid.views.IpfsGatewaySettingsActivity.onCreate.<anonymous>.<anonymous> (IpfsGatewaySettingsActivity.kt:61)");
                                }
                                Preferences prefs = IpfsGatewaySettingsActivity.this.getPrefs();
                                final IpfsGatewaySettingsActivity ipfsGatewaySettingsActivity2 = IpfsGatewaySettingsActivity.this;
                                IpfsGatewaySettingsActivityKt.IpfsGatewaySettingsScreen(new Function0() { // from class: org.fdroid.fdroid.views.IpfsGatewaySettingsActivity.onCreate.1.1.1
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Object invoke() {
                                        m2544invoke();
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke  reason: collision with other method in class */
                                    public final void m2544invoke() {
                                        IpfsGatewaySettingsActivity.this.getOnBackPressedDispatcher().onBackPressed();
                                    }
                                }, prefs, composer2, 64);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), composer, 54);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer.skipToGroupEnd();
            }
        }), 1, null);
    }
}
