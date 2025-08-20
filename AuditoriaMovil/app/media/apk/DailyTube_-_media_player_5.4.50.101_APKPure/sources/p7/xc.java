package p7;

import java.util.NoSuchElementException;
/* loaded from: classes.dex */
public interface xc {
    public static final xc y = new y();

    /* loaded from: classes.dex */
    public class y implements xc {
        @Override // p7.xc
        public long n3() {
            throw new NoSuchElementException();
        }

        @Override // p7.xc
        public boolean next() {
            return false;
        }

        @Override // p7.xc
        public long y() {
            throw new NoSuchElementException();
        }
    }

    long n3();

    boolean next();

    long y();
}
