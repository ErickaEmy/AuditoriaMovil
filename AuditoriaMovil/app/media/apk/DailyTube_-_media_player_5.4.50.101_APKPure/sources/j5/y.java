package j5;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public final class y extends ClickableSpan {

    /* renamed from: fb  reason: collision with root package name */
    public final int f9372fb;

    /* renamed from: v  reason: collision with root package name */
    public final zn f9373v;
    public final int y;

    public y(int i, @NonNull zn znVar, int i5) {
        this.y = i;
        this.f9373v = znVar;
        this.f9372fb = i5;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(@NonNull View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.y);
        this.f9373v.y5(this.f9372fb, bundle);
    }
}
