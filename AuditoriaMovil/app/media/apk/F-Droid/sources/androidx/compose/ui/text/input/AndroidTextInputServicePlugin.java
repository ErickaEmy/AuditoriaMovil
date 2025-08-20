package androidx.compose.ui.text.input;

import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AndroidTextInputServicePlugin.kt */
/* loaded from: classes.dex */
public final class AndroidTextInputServicePlugin implements PlatformTextInputPlugin {
    public static final AndroidTextInputServicePlugin INSTANCE = new AndroidTextInputServicePlugin();

    private AndroidTextInputServicePlugin() {
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputPlugin
    public Adapter createAdapter(PlatformTextInput platformTextInput, View view) {
        Intrinsics.checkNotNullParameter(platformTextInput, "platformTextInput");
        Intrinsics.checkNotNullParameter(view, "view");
        TextInputServiceAndroid textInputServiceAndroid = new TextInputServiceAndroid(view, platformTextInput);
        return new Adapter(new TextInputService(textInputServiceAndroid), textInputServiceAndroid);
    }

    /* compiled from: AndroidTextInputServicePlugin.kt */
    /* loaded from: classes.dex */
    public static final class Adapter implements PlatformTextInputAdapter {
        private final TextInputServiceAndroid androidService;
        private final TextInputService service;

        public final TextInputService getService() {
            return this.service;
        }

        public Adapter(TextInputService service, TextInputServiceAndroid androidService) {
            Intrinsics.checkNotNullParameter(service, "service");
            Intrinsics.checkNotNullParameter(androidService, "androidService");
            this.service = service;
            this.androidService = androidService;
        }

        @Override // androidx.compose.ui.text.input.PlatformTextInputAdapter
        public InputConnection createInputConnection(EditorInfo outAttrs) {
            Intrinsics.checkNotNullParameter(outAttrs, "outAttrs");
            return this.androidService.createInputConnection(outAttrs);
        }
    }
}
