package k;

import android.widget.SeekBar;
/* loaded from: classes.dex */
public class a {

    /* loaded from: classes.dex */
    public interface gv {
        void onStopTrackingTouch(SeekBar seekBar);
    }

    /* loaded from: classes.dex */
    public interface n3 {
        void onProgressChanged(SeekBar seekBar, int i, boolean z2);
    }

    /* loaded from: classes.dex */
    public class y implements SeekBar.OnSeekBarChangeListener {

        /* renamed from: gv  reason: collision with root package name */
        public final /* synthetic */ gv f9558gv;

        /* renamed from: n3  reason: collision with root package name */
        public final /* synthetic */ q9.v f9559n3;
        public final /* synthetic */ n3 y;

        /* renamed from: zn  reason: collision with root package name */
        public final /* synthetic */ zn f9560zn;

        public y(n3 n3Var, q9.v vVar, zn znVar, gv gvVar) {
            this.y = n3Var;
            this.f9559n3 = vVar;
            this.f9560zn = znVar;
            this.f9558gv = gvVar;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z2) {
            n3 n3Var = this.y;
            if (n3Var != null) {
                n3Var.onProgressChanged(seekBar, i, z2);
            }
            q9.v vVar = this.f9559n3;
            if (vVar != null) {
                vVar.y();
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            zn znVar = this.f9560zn;
            if (znVar != null) {
                znVar.onStartTrackingTouch(seekBar);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            gv gvVar = this.f9558gv;
            if (gvVar != null) {
                gvVar.onStopTrackingTouch(seekBar);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface zn {
        void onStartTrackingTouch(SeekBar seekBar);
    }

    public static void n3(SeekBar seekBar, int i) {
        if (i != seekBar.getProgress()) {
            seekBar.setProgress(i);
        }
    }

    public static void y(SeekBar seekBar, zn znVar, gv gvVar, n3 n3Var, q9.v vVar) {
        if (znVar == null && gvVar == null && n3Var == null && vVar == null) {
            seekBar.setOnSeekBarChangeListener(null);
        } else {
            seekBar.setOnSeekBarChangeListener(new y(n3Var, vVar, znVar, gvVar));
        }
    }
}
