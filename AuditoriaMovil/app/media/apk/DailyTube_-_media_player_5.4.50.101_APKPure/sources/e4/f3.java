package e4;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.InternalFrame;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import v5.j5;
/* loaded from: classes.dex */
public final class f3 {

    /* renamed from: zn  reason: collision with root package name */
    public static final Pattern f7501zn = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");
    public int y = -1;

    /* renamed from: n3  reason: collision with root package name */
    public int f7502n3 = -1;

    public boolean gv(int i) {
        int i5 = i >> 12;
        int i6 = i & 4095;
        if (i5 <= 0 && i6 <= 0) {
            return false;
        }
        this.y = i5;
        this.f7502n3 = i6;
        return true;
    }

    public final boolean n3(String str) {
        Matcher matcher = f7501zn.matcher(str);
        if (matcher.find()) {
            try {
                int parseInt = Integer.parseInt((String) j5.i9(matcher.group(1)), 16);
                int parseInt2 = Integer.parseInt((String) j5.i9(matcher.group(2)), 16);
                if (parseInt > 0 || parseInt2 > 0) {
                    this.y = parseInt;
                    this.f7502n3 = parseInt2;
                    return true;
                }
                return false;
            } catch (NumberFormatException unused) {
                return false;
            }
        }
        return false;
    }

    public boolean y() {
        if (this.y != -1 && this.f7502n3 != -1) {
            return true;
        }
        return false;
    }

    public boolean zn(Metadata metadata) {
        for (int i = 0; i < metadata.v(); i++) {
            Metadata.Entry gv2 = metadata.gv(i);
            if (gv2 instanceof CommentFrame) {
                CommentFrame commentFrame = (CommentFrame) gv2;
                if ("iTunSMPB".equals(commentFrame.f4258fb) && n3(commentFrame.f4259s)) {
                    return true;
                }
            } else if (gv2 instanceof InternalFrame) {
                InternalFrame internalFrame = (InternalFrame) gv2;
                if ("com.apple.iTunes".equals(internalFrame.f4267v) && "iTunSMPB".equals(internalFrame.f4265fb) && n3(internalFrame.f4266s)) {
                    return true;
                }
            } else {
                continue;
            }
        }
        return false;
    }
}
