package e7;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
/* loaded from: classes.dex */
public abstract class zn {

    /* renamed from: n3  reason: collision with root package name */
    public Context f7587n3;
    public TextInputLayout y;

    /* renamed from: zn  reason: collision with root package name */
    public CheckableImageButton f7588zn;

    public zn(@NonNull TextInputLayout textInputLayout) {
        this.y = textInputLayout;
        this.f7587n3 = textInputLayout.getContext();
        this.f7588zn = textInputLayout.getEndIconView();
    }

    public boolean gv() {
        return false;
    }

    public boolean n3(int i) {
        return true;
    }

    public abstract void y();

    public void zn(boolean z2) {
    }
}
