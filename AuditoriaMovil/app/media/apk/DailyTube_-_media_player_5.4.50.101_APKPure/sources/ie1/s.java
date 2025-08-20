package ie1;
/* loaded from: classes.dex */
public class s extends RuntimeException {
    private final int code;
    private final String message;
    public final transient mt<?> y;

    public s(mt<?> mtVar) {
        super(y(mtVar));
        this.code = mtVar.n3();
        this.message = mtVar.v();
        this.y = mtVar;
    }

    public static String y(mt<?> mtVar) {
        i4.n3(mtVar, "response == null");
        return "HTTP " + mtVar.n3() + " " + mtVar.v();
    }
}
