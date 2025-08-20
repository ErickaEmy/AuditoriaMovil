package d9;

import android.media.AudioDeviceInfo;
import androidx.annotation.Nullable;
import d9.x4;
import fj.u0;
import java.nio.ByteBuffer;
import m1.br;
import m1.m;
/* loaded from: classes.dex */
public class z6 implements x4 {
    public final x4 y;

    public z6(x4 x4Var) {
        this.y = x4Var;
    }

    @Override // d9.x4
    public boolean a() {
        return this.y.a();
    }

    @Override // d9.x4
    public void c() {
        this.y.c();
    }

    @Override // d9.x4
    public void c5(@Nullable AudioDeviceInfo audioDeviceInfo) {
        this.y.c5(audioDeviceInfo);
    }

    @Override // d9.x4
    public void co() throws x4.v {
        this.y.co();
    }

    @Override // d9.x4
    public void f(int i) {
        this.y.f(i);
    }

    @Override // d9.x4
    public void f3() {
        this.y.f3();
    }

    @Override // d9.x4
    public void flush() {
        this.y.flush();
    }

    @Override // d9.x4
    public void i4(long j2) {
        this.y.i4(j2);
    }

    @Override // d9.x4
    public boolean i9() {
        return this.y.i9();
    }

    @Override // d9.x4
    public void mt() {
        this.y.mt();
    }

    @Override // d9.x4
    public boolean n3(m mVar) {
        return this.y.n3(mVar);
    }

    @Override // d9.x4
    public void p(v vVar) {
        this.y.p(vVar);
    }

    @Override // d9.x4
    public void pause() {
        this.y.pause();
    }

    @Override // d9.x4
    public void play() {
        this.y.play();
    }

    @Override // d9.x4
    public long r(boolean z2) {
        return this.y.r(z2);
    }

    @Override // d9.x4
    public void s(boolean z2) {
        this.y.s(z2);
    }

    @Override // d9.x4
    public void setVolume(float f4) {
        this.y.setVolume(f4);
    }

    @Override // d9.x4
    public void tl() {
        this.y.tl();
    }

    @Override // d9.x4
    public br v() {
        return this.y.v();
    }

    @Override // d9.x4
    public boolean w(ByteBuffer byteBuffer, long j2, int i) throws x4.n3, x4.v {
        return this.y.w(byteBuffer, j2, i);
    }

    @Override // d9.x4
    public int wz(m mVar) {
        return this.y.wz(mVar);
    }

    @Override // d9.x4
    public void x4(m mVar, int i, @Nullable int[] iArr) throws x4.y {
        this.y.x4(mVar, i, iArr);
    }

    @Override // d9.x4
    public void xc(@Nullable u0 u0Var) {
        this.y.xc(u0Var);
    }

    @Override // d9.x4
    public void y() {
        this.y.y();
    }

    @Override // d9.x4
    public void z(n nVar) {
        this.y.z(nVar);
    }

    @Override // d9.x4
    public void zn(br brVar) {
        this.y.zn(brVar);
    }
}
