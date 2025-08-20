package br;
/* loaded from: classes.dex */
public class a {

    /* renamed from: n3  reason: collision with root package name */
    public int f3867n3;
    public float y;

    public void y(float f4) {
        float f6 = this.y + f4;
        this.y = f6;
        int i = this.f3867n3 + 1;
        this.f3867n3 = i;
        if (i == Integer.MAX_VALUE) {
            this.y = f6 / 2.0f;
            this.f3867n3 = i / 2;
        }
    }
}
