package n5;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.scte35.PrivateCommand;
import com.google.android.exoplayer2.metadata.scte35.SpliceInsertCommand;
import com.google.android.exoplayer2.metadata.scte35.SpliceNullCommand;
import com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand;
import com.google.android.exoplayer2.metadata.scte35.TimeSignalCommand;
import hd.a;
import hd.gv;
import java.nio.ByteBuffer;
import v5.fh;
import v5.k5;
import v5.rz;
/* loaded from: classes.dex */
public final class y extends a {

    /* renamed from: zn  reason: collision with root package name */
    public k5 f11807zn;
    public final rz y = new rz();

    /* renamed from: n3  reason: collision with root package name */
    public final fh f11806n3 = new fh();

    @Override // hd.a
    public Metadata n3(gv gvVar, ByteBuffer byteBuffer) {
        Metadata.Entry spliceNullCommand;
        k5 k5Var = this.f11807zn;
        if (k5Var == null || gvVar.f8923co != k5Var.v()) {
            k5 k5Var2 = new k5(gvVar.f55f);
            this.f11807zn = k5Var2;
            k5Var2.y(gvVar.f55f - gvVar.f8923co);
        }
        byte[] array = byteBuffer.array();
        int limit = byteBuffer.limit();
        this.y.o(array, limit);
        this.f11806n3.xc(array, limit);
        this.f11806n3.mt(39);
        long s2 = (this.f11806n3.s(1) << 32) | this.f11806n3.s(32);
        this.f11806n3.mt(20);
        int s3 = this.f11806n3.s(12);
        int s4 = this.f11806n3.s(8);
        this.y.ut(14);
        if (s4 != 0) {
            if (s4 != 255) {
                if (s4 != 4) {
                    if (s4 != 5) {
                        if (s4 != 6) {
                            spliceNullCommand = null;
                        } else {
                            spliceNullCommand = TimeSignalCommand.y(this.y, s2, this.f11807zn);
                        }
                    } else {
                        spliceNullCommand = SpliceInsertCommand.y(this.y, s2, this.f11807zn);
                    }
                } else {
                    spliceNullCommand = SpliceScheduleCommand.y(this.y);
                }
            } else {
                spliceNullCommand = PrivateCommand.y(this.y, s3, s2);
            }
        } else {
            spliceNullCommand = new SpliceNullCommand();
        }
        if (spliceNullCommand == null) {
            return new Metadata(new Metadata.Entry[0]);
        }
        return new Metadata(spliceNullCommand);
    }
}
