package androidx.media;

import android.media.AudioAttributes;
import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public class AudioAttributesImplApi21 implements AudioAttributesImpl {

    /* renamed from: n3  reason: collision with root package name */
    public int f2671n3;
    public AudioAttributes y;

    public AudioAttributesImplApi21() {
        this.f2671n3 = -1;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesImplApi21)) {
            return false;
        }
        return this.y.equals(((AudioAttributesImplApi21) obj).y);
    }

    public int hashCode() {
        return this.y.hashCode();
    }

    @NonNull
    public String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.y;
    }

    public AudioAttributesImplApi21(AudioAttributes audioAttributes) {
        this(audioAttributes, -1);
    }

    public AudioAttributesImplApi21(AudioAttributes audioAttributes, int i) {
        this.y = audioAttributes;
        this.f2671n3 = i;
    }
}
