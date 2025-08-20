package androidx.media;

import xb.n3;
/* loaded from: classes.dex */
public class AudioAttributesCompatParcelizer {
    public static AudioAttributesCompat read(n3 n3Var) {
        AudioAttributesCompat audioAttributesCompat = new AudioAttributesCompat();
        audioAttributesCompat.y = (AudioAttributesImpl) n3Var.x4(audioAttributesCompat.y, 1);
        return audioAttributesCompat;
    }

    public static void write(AudioAttributesCompat audioAttributesCompat, n3 n3Var) {
        n3Var.f3(false, false);
        n3Var.k5(audioAttributesCompat.y, 1);
    }
}
