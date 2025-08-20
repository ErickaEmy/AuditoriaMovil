package s;
/* loaded from: classes.dex */
public class t {

    /* renamed from: gv  reason: collision with root package name */
    public static t f13396gv;

    /* renamed from: n3  reason: collision with root package name */
    public long f13397n3;
    public long y;

    /* renamed from: zn  reason: collision with root package name */
    public int f13398zn;

    public static t n3() {
        if (f13396gv == null) {
            f13396gv = new t();
        }
        return f13396gv;
    }

    public void y(long j2, double d2, double d3) {
        float f4;
        float f6;
        double d4;
        double d5 = (0.01720197f * (((float) (j2 - 946728000000L)) / 8.64E7f)) + 6.24006f;
        double sin = (Math.sin(d5) * 0.03341960161924362d) + d5 + (Math.sin(2.0f * f6) * 3.4906598739326E-4d) + (Math.sin(f6 * 3.0f) * 5.236000106378924E-6d) + 1.796593063d + 3.141592653589793d;
        double round = ((float) Math.round((f4 - 9.0E-4f) - d4)) + 9.0E-4f + ((-d3) / 360.0d) + (Math.sin(d5) * 0.0053d) + (Math.sin(2.0d * sin) * (-0.0069d));
        double asin = Math.asin(Math.sin(sin) * Math.sin(0.4092797040939331d));
        double d6 = 0.01745329238474369d * d2;
        double sin2 = (Math.sin(-0.10471975803375244d) - (Math.sin(d6) * Math.sin(asin))) / (Math.cos(d6) * Math.cos(asin));
        if (sin2 >= 1.0d) {
            this.f13398zn = 1;
            this.y = -1L;
            this.f13397n3 = -1L;
        } else if (sin2 <= -1.0d) {
            this.f13398zn = 0;
            this.y = -1L;
            this.f13397n3 = -1L;
        } else {
            double acos = (float) (Math.acos(sin2) / 6.283185307179586d);
            this.y = Math.round((round + acos) * 8.64E7d) + 946728000000L;
            long round2 = Math.round((round - acos) * 8.64E7d) + 946728000000L;
            this.f13397n3 = round2;
            if (round2 < j2 && this.y > j2) {
                this.f13398zn = 0;
            } else {
                this.f13398zn = 1;
            }
        }
    }
}
