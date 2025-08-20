package org.fdroid.fdroid.views.repos;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import androidx.activity.compose.BackHandlerKt;
import androidx.activity.compose.ComponentActivityKt;
import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.core.content.ContextCompat;
import androidx.core.util.Consumer;
import androidx.lifecycle.LifecycleOwnerKt;
import info.guardianproject.netcipher.NetCipher;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KFunction;
import kotlin.text.MatchGroup;
import kotlin.text.MatchGroupCollection;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.fdroid.fdroid.FDroidApp;
import org.fdroid.fdroid.Preferences;
import org.fdroid.fdroid.R;
import org.fdroid.fdroid.compose.ComposeUtils;
import org.fdroid.fdroid.nearby.SwapService;
import org.fdroid.index.RepoManager;
import org.fdroid.repo.AddRepoError;
import org.fdroid.repo.AddRepoState;
/* compiled from: AddRepoActivity.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0012\u0010\u000b\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010\u000e\u001a\u00020\bH\u0014J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\nH\u0002J\b\u0010\u0011\u001a\u00020\bH\u0014R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lorg/fdroid/fdroid/views/repos/AddRepoActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "repoManager", "Lorg/fdroid/index/RepoManager;", "getRepoManager", "()Lorg/fdroid/index/RepoManager;", "fetchIfRepoUri", "", "str", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFetchRepo", "uriStr", "onResume", "app_fullRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AddRepoActivity extends AppCompatActivity {
    public static final int $stable = 0;

    /* JADX INFO: Access modifiers changed from: private */
    public final RepoManager getRepoManager() {
        RepoManager repoManager = FDroidApp.getRepoManager(this);
        Intrinsics.checkNotNullExpressionValue(repoManager, "getRepoManager(...)");
        return repoManager;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AddRepoActivity$onCreate$1(this, null), 3, null);
        ComponentActivityKt.setContent$default(this, null, ComposableLambdaKt.composableLambdaInstance(-90938685, true, new Function2() { // from class: org.fdroid.fdroid.views.repos.AddRepoActivity$onCreate$2
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
                        ComposerKt.traceEventStart(-90938685, i, -1, "org.fdroid.fdroid.views.repos.AddRepoActivity.onCreate.<anonymous> (AddRepoActivity.kt:56)");
                    }
                    ComposeUtils composeUtils = ComposeUtils.INSTANCE;
                    final AddRepoActivity addRepoActivity = AddRepoActivity.this;
                    composeUtils.FDroidContent(ComposableLambdaKt.composableLambda(composer, -1310081525, true, new Function2() { // from class: org.fdroid.fdroid.views.repos.AddRepoActivity$onCreate$2.1
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i2) {
                            RepoManager repoManager;
                            if ((i2 & 11) == 2 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1310081525, i2, -1, "org.fdroid.fdroid.views.repos.AddRepoActivity.onCreate.<anonymous>.<anonymous> (AddRepoActivity.kt:57)");
                            }
                            repoManager = AddRepoActivity.this.getRepoManager();
                            AddRepoState addRepoState = (AddRepoState) SnapshotStateKt.collectAsState(repoManager.getAddRepoState(), null, composer2, 8, 1).getValue();
                            boolean z = addRepoState instanceof AddRepoError;
                            composer2.startReplaceableGroup(753479601);
                            boolean changed = composer2.changed(AddRepoActivity.this);
                            final AddRepoActivity addRepoActivity2 = AddRepoActivity.this;
                            Object rememberedValue = composer2.rememberedValue();
                            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                                rememberedValue = new Function0() { // from class: org.fdroid.fdroid.views.repos.AddRepoActivity$onCreate$2$1$1$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Object invoke() {
                                        m2606invoke();
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke  reason: collision with other method in class */
                                    public final void m2606invoke() {
                                        RepoManager repoManager2;
                                        repoManager2 = AddRepoActivity.this.getRepoManager();
                                        repoManager2.abortAddingRepository();
                                    }
                                };
                                composer2.updateRememberedValue(rememberedValue);
                            }
                            composer2.endReplaceableGroup();
                            BackHandlerKt.BackHandler(z, (Function0) rememberedValue, composer2, 0, 0);
                            AddRepoActivity addRepoActivity3 = AddRepoActivity.this;
                            composer2.startReplaceableGroup(753479849);
                            boolean changed2 = composer2.changed(addRepoActivity3);
                            Object rememberedValue2 = composer2.rememberedValue();
                            if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                                rememberedValue2 = new AddRepoActivity$onCreate$2$1$2$1(addRepoActivity3);
                                composer2.updateRememberedValue(rememberedValue2);
                            }
                            composer2.endReplaceableGroup();
                            Function1 function1 = (Function1) ((KFunction) rememberedValue2);
                            composer2.startReplaceableGroup(753479900);
                            boolean changed3 = composer2.changed(AddRepoActivity.this);
                            final AddRepoActivity addRepoActivity4 = AddRepoActivity.this;
                            Object rememberedValue3 = composer2.rememberedValue();
                            if (changed3 || rememberedValue3 == Composer.Companion.getEmpty()) {
                                rememberedValue3 = new Function0() { // from class: org.fdroid.fdroid.views.repos.AddRepoActivity$onCreate$2$1$3$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Object invoke() {
                                        m2607invoke();
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke  reason: collision with other method in class */
                                    public final void m2607invoke() {
                                        RepoManager repoManager2;
                                        repoManager2 = AddRepoActivity.this.getRepoManager();
                                        repoManager2.addFetchedRepository();
                                    }
                                };
                                composer2.updateRememberedValue(rememberedValue3);
                            }
                            Function0 function0 = (Function0) rememberedValue3;
                            composer2.endReplaceableGroup();
                            composer2.startReplaceableGroup(753479976);
                            boolean changed4 = composer2.changed(AddRepoActivity.this);
                            final AddRepoActivity addRepoActivity5 = AddRepoActivity.this;
                            Object rememberedValue4 = composer2.rememberedValue();
                            if (changed4 || rememberedValue4 == Composer.Companion.getEmpty()) {
                                rememberedValue4 = new Function0() { // from class: org.fdroid.fdroid.views.repos.AddRepoActivity$onCreate$2$1$4$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Object invoke() {
                                        m2608invoke();
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke  reason: collision with other method in class */
                                    public final void m2608invoke() {
                                        AddRepoActivity.this.getOnBackPressedDispatcher().onBackPressed();
                                    }
                                };
                                composer2.updateRememberedValue(rememberedValue4);
                            }
                            composer2.endReplaceableGroup();
                            AddRepoIntroScreenKt.AddRepoIntroScreen(addRepoState, function1, function0, (Function0) rememberedValue4, composer2, 8);
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
        addOnNewIntentListener(new Consumer() { // from class: org.fdroid.fdroid.views.repos.AddRepoActivity$$ExternalSyntheticLambda0
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                AddRepoActivity.onCreate$lambda$2(AddRepoActivity.this, (Intent) obj);
            }
        });
        Intent intent = getIntent();
        if (intent != null) {
            onNewIntent(intent);
            intent.setData(null);
            intent.replaceExtras(new Bundle());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$2(AddRepoActivity this$0, Intent intent) {
        String stringExtra;
        String dataString;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String action = intent.getAction();
        if (action != null) {
            int hashCode = action.hashCode();
            if (hashCode == -1173264947) {
                if (action.equals("android.intent.action.SEND") && (stringExtra = intent.getStringExtra("android.intent.extra.TEXT")) != null) {
                    this$0.fetchIfRepoUri(stringExtra);
                }
            } else if (hashCode == -1173171990 && action.equals("android.intent.action.VIEW") && (dataString = intent.getDataString()) != null) {
                this$0.onFetchRepo(dataString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        FDroidApp.checkStartTor(this, Preferences.get());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (isChangingConfigurations()) {
            return;
        }
        getRepoManager().abortAddingRepository();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onFetchRepo(String str) {
        CharSequence trim;
        trim = StringsKt__StringsKt.trim(str);
        Uri parse = Uri.parse(trim.toString());
        if (getRepoManager().isSwapUri(parse)) {
            Intent intent = new Intent(this, SwapService.class);
            intent.setData(parse);
            ContextCompat.startForegroundService(this, intent);
            return;
        }
        getRepoManager().abortAddingRepository();
        RepoManager repoManager = getRepoManager();
        String uri = parse.toString();
        Intrinsics.checkNotNullExpressionValue(uri, "toString(...)");
        repoManager.fetchRepositoryPreview(uri, NetCipher.getProxy());
    }

    private final void fetchIfRepoUri(String str) {
        Set of;
        Set of2;
        MatchGroupCollection groups;
        MatchGroup matchGroup;
        MatchGroupCollection groups2;
        MatchGroup matchGroup2;
        RegexOption regexOption = RegexOption.IGNORE_CASE;
        RegexOption regexOption2 = RegexOption.MULTILINE;
        of = SetsKt__SetsKt.setOf((Object[]) new RegexOption[]{regexOption, regexOption2});
        Regex regex = new Regex("^.*((https|fdroidrepos)://.+/repo(\\?fingerprint=[A-F0-9]+)?) ?.*$", of);
        String str2 = null;
        MatchResult find$default = Regex.find$default(regex, str, 0, 2, null);
        String value = (find$default == null || (groups2 = find$default.getGroups()) == null || (matchGroup2 = groups2.get(1)) == null) ? null : matchGroup2.getValue();
        if (value != null) {
            String simpleName = Reflection.getOrCreateKotlinClass(AddRepoActivity.class).getSimpleName();
            Log.d(simpleName, "Found match: " + value);
            onFetchRepo(value);
            return;
        }
        of2 = SetsKt__SetsKt.setOf((Object[]) new RegexOption[]{regexOption, regexOption2});
        MatchResult find$default2 = Regex.find$default(new Regex("^.*(https://fdroid.link/.+) ?.*$", of2), str, 0, 2, null);
        if (find$default2 != null && (groups = find$default2.getGroups()) != null && (matchGroup = groups.get(1)) != null) {
            str2 = matchGroup.getValue();
        }
        if (str2 != null) {
            String simpleName2 = Reflection.getOrCreateKotlinClass(AddRepoActivity.class).getSimpleName();
            Log.d(simpleName2, "Found match: " + str2);
            onFetchRepo(str2);
            return;
        }
        Toast.makeText(this, R.string.repo_share_not_found, 1).show();
        finishAfterTransition();
    }
}
