package androidx.media;

import xb.n3;
/* loaded from: classes.dex */
public class AudioAttributesImplBaseParcelizer {
    public static AudioAttributesImplBase read(n3 n3Var) {
        AudioAttributesImplBase audioAttributesImplBase = new AudioAttributesImplBase();
        audioAttributesImplBase.y = n3Var.w(audioAttributesImplBase.y, 1);
        audioAttributesImplBase.f2673n3 = n3Var.w(audioAttributesImplBase.f2673n3, 2);
        audioAttributesImplBase.f2674zn = n3Var.w(audioAttributesImplBase.f2674zn, 3);
        audioAttributesImplBase.f2672gv = n3Var.w(audioAttributesImplBase.f2672gv, 4);
        return audioAttributesImplBase;
    }

    public static void write(AudioAttributesImplBase audioAttributesImplBase, n3 n3Var) {
        n3Var.f3(false, false);
        n3Var.d(audioAttributesImplBase.y, 1);
        n3Var.d(audioAttributesImplBase.f2673n3, 2);
        n3Var.d(audioAttributesImplBase.f2674zn, 3);
        n3Var.d(audioAttributesImplBase.f2672gv, 4);
    }
}
