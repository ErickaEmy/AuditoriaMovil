package androidx.media;

import android.media.AudioAttributes;
import xb.n3;
/* loaded from: classes.dex */
public class AudioAttributesImplApi21Parcelizer {
    public static AudioAttributesImplApi21 read(n3 n3Var) {
        AudioAttributesImplApi21 audioAttributesImplApi21 = new AudioAttributesImplApi21();
        audioAttributesImplApi21.y = (AudioAttributes) n3Var.mt(audioAttributesImplApi21.y, 1);
        audioAttributesImplApi21.f2671n3 = n3Var.w(audioAttributesImplApi21.f2671n3, 2);
        return audioAttributesImplApi21;
    }

    public static void write(AudioAttributesImplApi21 audioAttributesImplApi21, n3 n3Var) {
        n3Var.f3(false, false);
        n3Var.ej(audioAttributesImplApi21.y, 1);
        n3Var.d(audioAttributesImplApi21.f2671n3, 2);
    }
}
