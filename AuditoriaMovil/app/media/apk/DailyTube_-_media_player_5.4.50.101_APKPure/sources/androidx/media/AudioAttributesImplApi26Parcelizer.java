package androidx.media;

import android.media.AudioAttributes;
import xb.n3;
/* loaded from: classes.dex */
public class AudioAttributesImplApi26Parcelizer {
    public static AudioAttributesImplApi26 read(n3 n3Var) {
        AudioAttributesImplApi26 audioAttributesImplApi26 = new AudioAttributesImplApi26();
        audioAttributesImplApi26.y = (AudioAttributes) n3Var.mt(audioAttributesImplApi26.y, 1);
        audioAttributesImplApi26.f2671n3 = n3Var.w(audioAttributesImplApi26.f2671n3, 2);
        return audioAttributesImplApi26;
    }

    public static void write(AudioAttributesImplApi26 audioAttributesImplApi26, n3 n3Var) {
        n3Var.f3(false, false);
        n3Var.ej(audioAttributesImplApi26.y, 1);
        n3Var.d(audioAttributesImplApi26.f2671n3, 2);
    }
}
