package org.fdroid.fdroid.views;

import android.os.Bundle;
import androidx.activity.compose.ComponentActivityKt;
import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.fdroid.fdroid.Preferences;
import org.fdroid.fdroid.compose.ComposeUtils;
/* compiled from: IpfsGatewayAddActivity.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014¨\u0006\u0007"}, d2 = {"Lorg/fdroid/fdroid/views/IpfsGatewayAddActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "app_fullRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class IpfsGatewayAddActivity extends AppCompatActivity {
    public static final int $stable = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ComponentActivityKt.setContent$default(this, null, ComposableLambdaKt.composableLambdaInstance(212474564, true, new Function2() { // from class: org.fdroid.fdroid.views.IpfsGatewayAddActivity$onCreate$1
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
                        ComposerKt.traceEventStart(212474564, i, -1, "org.fdroid.fdroid.views.IpfsGatewayAddActivity.onCreate.<anonymous> (IpfsGatewayAddActivity.kt:52)");
                    }
                    ComposeUtils composeUtils = ComposeUtils.INSTANCE;
                    final IpfsGatewayAddActivity ipfsGatewayAddActivity = IpfsGatewayAddActivity.this;
                    composeUtils.FDroidContent(ComposableLambdaKt.composableLambda(composer, -1514951156, true, new Function2() { // from class: org.fdroid.fdroid.views.IpfsGatewayAddActivity$onCreate$1.1
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i2) {
                            if ((i2 & 11) == 2 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1514951156, i2, -1, "org.fdroid.fdroid.views.IpfsGatewayAddActivity.onCreate.<anonymous>.<anonymous> (IpfsGatewayAddActivity.kt:53)");
                            }
                            composer2.startReplaceableGroup(-1425027509);
                            boolean changed = composer2.changed(IpfsGatewayAddActivity.this);
                            final IpfsGatewayAddActivity ipfsGatewayAddActivity2 = IpfsGatewayAddActivity.this;
                            Object rememberedValue = composer2.rememberedValue();
                            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                                rememberedValue = new Function0() { // from class: org.fdroid.fdroid.views.IpfsGatewayAddActivity$onCreate$1$1$1$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Object invoke() {
                                        m2541invoke();
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke  reason: collision with other method in class */
                                    public final void m2541invoke() {
                                        IpfsGatewayAddActivity.this.getOnBackPressedDispatcher().onBackPressed();
                                    }
                                };
                                composer2.updateRememberedValue(rememberedValue);
                            }
                            Function0 function0 = (Function0) rememberedValue;
                            composer2.endReplaceableGroup();
                            composer2.startReplaceableGroup(-1425027425);
                            boolean changed2 = composer2.changed(IpfsGatewayAddActivity.this);
                            final IpfsGatewayAddActivity ipfsGatewayAddActivity3 = IpfsGatewayAddActivity.this;
                            Object rememberedValue2 = composer2.rememberedValue();
                            if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                                rememberedValue2 = new Function1() { // from class: org.fdroid.fdroid.views.IpfsGatewayAddActivity$onCreate$1$1$2$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((String) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(String url) {
                                        List<String> mutableList;
                                        Intrinsics.checkNotNullParameter(url, "url");
                                        if (!Preferences.DEFAULT_IPFS_GATEWAYS.contains(url)) {
                                            List<String> ipfsGwUserList = Preferences.get().getIpfsGwUserList();
                                            Intrinsics.checkNotNullExpressionValue(ipfsGwUserList, "getIpfsGwUserList(...)");
                                            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) ipfsGwUserList);
                                            if (!mutableList.contains(url)) {
                                                mutableList.add(url);
                                                Preferences.get().mo2549setIpfsGwUserList(mutableList);
                                            }
                                        }
                                        IpfsGatewayAddActivity.this.finish();
                                    }
                                };
                                composer2.updateRememberedValue(rememberedValue2);
                            }
                            composer2.endReplaceableGroup();
                            IpfsGatewayAddActivityKt.IpfsGatewayAddScreen(function0, (Function1) rememberedValue2, composer2, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
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
