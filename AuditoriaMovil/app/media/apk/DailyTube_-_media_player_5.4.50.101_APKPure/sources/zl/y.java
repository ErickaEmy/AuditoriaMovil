package zl;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.icy.IcyInfo;
import hd.a;
import hd.gv;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import w0.v;
import w0.zn;
/* loaded from: classes.dex */
public final class y extends a {

    /* renamed from: zn  reason: collision with root package name */
    public static final Pattern f15673zn = Pattern.compile("(.+?)='(.*?)';", 32);
    public final CharsetDecoder y = v.f14523zn.newDecoder();

    /* renamed from: n3  reason: collision with root package name */
    public final CharsetDecoder f15674n3 = v.f14521n3.newDecoder();

    @Override // hd.a
    public Metadata n3(gv gvVar, ByteBuffer byteBuffer) {
        String zn2 = zn(byteBuffer);
        byte[] bArr = new byte[byteBuffer.limit()];
        byteBuffer.get(bArr);
        String str = null;
        if (zn2 == null) {
            return new Metadata(new IcyInfo(bArr, null, null));
        }
        Matcher matcher = f15673zn.matcher(zn2);
        String str2 = null;
        for (int i = 0; matcher.find(i); i = matcher.end()) {
            String group = matcher.group(1);
            String group2 = matcher.group(2);
            if (group != null) {
                String v2 = zn.v(group);
                v2.hashCode();
                if (!v2.equals("streamurl")) {
                    if (v2.equals("streamtitle")) {
                        str = group2;
                    }
                } else {
                    str2 = group2;
                }
            }
        }
        return new Metadata(new IcyInfo(bArr, str, str2));
    }

    @Nullable
    public final String zn(ByteBuffer byteBuffer) {
        try {
            return this.y.decode(byteBuffer).toString();
        } catch (CharacterCodingException unused) {
            try {
                String charBuffer = this.f15674n3.decode(byteBuffer).toString();
                this.f15674n3.reset();
                byteBuffer.rewind();
                return charBuffer;
            } catch (CharacterCodingException unused2) {
                this.f15674n3.reset();
                byteBuffer.rewind();
                return null;
            } catch (Throwable th) {
                this.f15674n3.reset();
                byteBuffer.rewind();
                throw th;
            }
        } finally {
            this.y.reset();
            byteBuffer.rewind();
        }
    }
}
