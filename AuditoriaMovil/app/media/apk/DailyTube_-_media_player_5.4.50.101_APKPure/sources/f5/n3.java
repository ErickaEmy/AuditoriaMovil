package f5;

import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
/* loaded from: classes.dex */
public final class n3 {

    /* renamed from: n3  reason: collision with root package name */
    public final DataOutputStream f7857n3;
    public final ByteArrayOutputStream y;

    public n3() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        this.y = byteArrayOutputStream;
        this.f7857n3 = new DataOutputStream(byteArrayOutputStream);
    }

    public static void n3(DataOutputStream dataOutputStream, String str) throws IOException {
        dataOutputStream.writeBytes(str);
        dataOutputStream.writeByte(0);
    }

    public byte[] y(EventMessage eventMessage) {
        this.y.reset();
        try {
            n3(this.f7857n3, eventMessage.y);
            String str = eventMessage.f4226v;
            if (str == null) {
                str = "";
            }
            n3(this.f7857n3, str);
            this.f7857n3.writeLong(eventMessage.f4223fb);
            this.f7857n3.writeLong(eventMessage.f4224s);
            this.f7857n3.write(eventMessage.f4222f);
            this.f7857n3.flush();
            return this.y.toByteArray();
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }
}
