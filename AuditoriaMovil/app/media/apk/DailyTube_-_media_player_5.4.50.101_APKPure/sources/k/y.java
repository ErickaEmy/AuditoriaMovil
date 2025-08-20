package k;

import android.widget.CompoundButton;
/* loaded from: classes.dex */
public class y {

    /* renamed from: k.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0129y implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: n3  reason: collision with root package name */
        public final /* synthetic */ q9.v f9565n3;
        public final /* synthetic */ CompoundButton.OnCheckedChangeListener y;

        public C0129y(CompoundButton.OnCheckedChangeListener onCheckedChangeListener, q9.v vVar) {
            this.y = onCheckedChangeListener;
            this.f9565n3 = vVar;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
            CompoundButton.OnCheckedChangeListener onCheckedChangeListener = this.y;
            if (onCheckedChangeListener != null) {
                onCheckedChangeListener.onCheckedChanged(compoundButton, z2);
            }
            this.f9565n3.y();
        }
    }

    public static void n3(CompoundButton compoundButton, CompoundButton.OnCheckedChangeListener onCheckedChangeListener, q9.v vVar) {
        if (vVar == null) {
            compoundButton.setOnCheckedChangeListener(onCheckedChangeListener);
        } else {
            compoundButton.setOnCheckedChangeListener(new C0129y(onCheckedChangeListener, vVar));
        }
    }

    public static void y(CompoundButton compoundButton, boolean z2) {
        if (compoundButton.isChecked() != z2) {
            compoundButton.setChecked(z2);
        }
    }
}
