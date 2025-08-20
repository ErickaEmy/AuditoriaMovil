package o;

import android.annotation.SuppressLint;
import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
@SuppressLint({"PrivateConstructorForUtilityClass"})
/* loaded from: classes.dex */
public final class n3 {

    /* renamed from: o.n3$n3  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0168n3 extends InputConnectionWrapper {
        public final /* synthetic */ zn y;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0168n3(InputConnection inputConnection, boolean z2, zn znVar) {
            super(inputConnection, z2);
            this.y = znVar;
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean performPrivateCommand(String str, Bundle bundle) {
            if (n3.n3(str, bundle, this.y)) {
                return true;
            }
            return super.performPrivateCommand(str, bundle);
        }
    }

    /* loaded from: classes.dex */
    public class y extends InputConnectionWrapper {
        public final /* synthetic */ zn y;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public y(InputConnection inputConnection, boolean z2, zn znVar) {
            super(inputConnection, z2);
            this.y = znVar;
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean commitContent(InputContentInfo inputContentInfo, int i, Bundle bundle) {
            if (this.y.y(o.zn.a(inputContentInfo), i, bundle)) {
                return true;
            }
            return super.commitContent(inputContentInfo, i, bundle);
        }
    }

    /* loaded from: classes.dex */
    public interface zn {
        boolean y(@NonNull o.zn znVar, int i, @Nullable Bundle bundle);
    }

    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    public static boolean n3(@Nullable String str, @Nullable Bundle bundle, @NonNull zn znVar) {
        boolean z2;
        String str2;
        ResultReceiver resultReceiver;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        ?? r0 = 0;
        r0 = 0;
        if (bundle == null) {
            return false;
        }
        if (TextUtils.equals("androidx.core.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT", str)) {
            z2 = false;
        } else if (!TextUtils.equals("android.support.v13.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT", str)) {
            return false;
        } else {
            z2 = true;
        }
        if (z2) {
            str2 = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER";
        } else {
            str2 = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER";
        }
        try {
            ResultReceiver resultReceiver2 = (ResultReceiver) bundle.getParcelable(str2);
            if (z2) {
                str3 = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_URI";
            } else {
                str3 = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_URI";
            }
            try {
                Uri uri = (Uri) bundle.getParcelable(str3);
                if (z2) {
                    str4 = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION";
                } else {
                    str4 = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION";
                }
                ClipDescription clipDescription = (ClipDescription) bundle.getParcelable(str4);
                if (z2) {
                    str5 = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI";
                } else {
                    str5 = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI";
                }
                Uri uri2 = (Uri) bundle.getParcelable(str5);
                if (z2) {
                    str6 = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS";
                } else {
                    str6 = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS";
                }
                int i = bundle.getInt(str6);
                if (z2) {
                    str7 = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_OPTS";
                } else {
                    str7 = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_OPTS";
                }
                Bundle bundle2 = (Bundle) bundle.getParcelable(str7);
                if (uri != null && clipDescription != null) {
                    r0 = znVar.y(new o.zn(uri, clipDescription, uri2), i, bundle2);
                }
                if (resultReceiver2 != null) {
                    resultReceiver2.send(r0, null);
                }
                return r0;
            } catch (Throwable th) {
                th = th;
                resultReceiver = resultReceiver2;
                if (resultReceiver != null) {
                    resultReceiver.send(0, null);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            resultReceiver = null;
        }
    }

    @NonNull
    @Deprecated
    public static InputConnection y(@NonNull InputConnection inputConnection, @NonNull EditorInfo editorInfo, @NonNull zn znVar) {
        vl.zn.gv(inputConnection, "inputConnection must be non-null");
        vl.zn.gv(editorInfo, "editorInfo must be non-null");
        vl.zn.gv(znVar, "onCommitContentListener must be non-null");
        if (Build.VERSION.SDK_INT >= 25) {
            return new y(inputConnection, false, znVar);
        }
        if (o.y.y(editorInfo).length == 0) {
            return inputConnection;
        }
        return new C0168n3(inputConnection, false, znVar);
    }
}
