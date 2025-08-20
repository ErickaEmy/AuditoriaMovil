package org.bouncycastle.pqc.crypto.sphincsplus;

import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.pqc.crypto.sphincsplus.SPHINCSPlusEngine;
import org.bouncycastle.util.Integers;
import org.bouncycastle.util.Pack;
/* loaded from: classes2.dex */
public class SPHINCSPlusParameters {
    private static final Map oidToParams;
    private static final Map paramsToOid;
    public static final SPHINCSPlusParameters sha256_128f;
    public static final SPHINCSPlusParameters sha256_128f_simple;
    public static final SPHINCSPlusParameters sha256_128s;
    public static final SPHINCSPlusParameters sha256_128s_simple;
    public static final SPHINCSPlusParameters sha256_192f;
    public static final SPHINCSPlusParameters sha256_192f_simple;
    public static final SPHINCSPlusParameters sha256_192s;
    public static final SPHINCSPlusParameters sha256_192s_simple;
    public static final SPHINCSPlusParameters sha256_256f;
    public static final SPHINCSPlusParameters sha256_256f_simple;
    public static final SPHINCSPlusParameters sha256_256s;
    public static final SPHINCSPlusParameters sha256_256s_simple;
    public static final SPHINCSPlusParameters shake256_128f;
    public static final SPHINCSPlusParameters shake256_128f_simple;
    public static final SPHINCSPlusParameters shake256_128s;
    public static final SPHINCSPlusParameters shake256_128s_simple;
    public static final SPHINCSPlusParameters shake256_192f;
    public static final SPHINCSPlusParameters shake256_192f_simple;
    public static final SPHINCSPlusParameters shake256_192s;
    public static final SPHINCSPlusParameters shake256_192s_simple;
    public static final SPHINCSPlusParameters shake256_256f;
    public static final SPHINCSPlusParameters shake256_256f_simple;
    public static final SPHINCSPlusParameters shake256_256s;
    public static final SPHINCSPlusParameters shake256_256s_simple;
    private static final Integer sphincsPlus_sha256_128f_robust;
    private static final Integer sphincsPlus_sha256_128f_simple;
    private static final Integer sphincsPlus_sha256_128s_robust;
    private static final Integer sphincsPlus_sha256_128s_simple;
    private static final Integer sphincsPlus_sha256_192f_robust;
    private static final Integer sphincsPlus_sha256_192f_simple;
    private static final Integer sphincsPlus_sha256_192s_robust;
    private static final Integer sphincsPlus_sha256_192s_simple;
    private static final Integer sphincsPlus_sha256_256f_robust;
    private static final Integer sphincsPlus_sha256_256f_simple;
    private static final Integer sphincsPlus_sha256_256s_robust;
    private static final Integer sphincsPlus_sha256_256s_simple;
    private static final Integer sphincsPlus_shake256_128f_robust;
    private static final Integer sphincsPlus_shake256_128f_simple;
    private static final Integer sphincsPlus_shake256_128s_robust;
    private static final Integer sphincsPlus_shake256_128s_simple;
    private static final Integer sphincsPlus_shake256_192f_robust;
    private static final Integer sphincsPlus_shake256_192f_simple;
    private static final Integer sphincsPlus_shake256_192s_robust;
    private static final Integer sphincsPlus_shake256_192s_simple;
    private static final Integer sphincsPlus_shake256_256f_robust;
    private static final Integer sphincsPlus_shake256_256f_simple;
    private static final Integer sphincsPlus_shake256_256s_robust;
    private static final Integer sphincsPlus_shake256_256s_simple;
    private final SPHINCSPlusEngine engine;
    private final String name;

    static {
        SPHINCSPlusParameters sPHINCSPlusParameters = new SPHINCSPlusParameters("sha256-128f-robust", new SPHINCSPlusEngine.Sha256Engine(true, 16, 16, 22, 6, 33, 66));
        sha256_128f = sPHINCSPlusParameters;
        SPHINCSPlusParameters sPHINCSPlusParameters2 = new SPHINCSPlusParameters("sha256-128s-robust", new SPHINCSPlusEngine.Sha256Engine(true, 16, 16, 7, 12, 14, 63));
        sha256_128s = sPHINCSPlusParameters2;
        SPHINCSPlusParameters sPHINCSPlusParameters3 = new SPHINCSPlusParameters("sha256-192f-robust", new SPHINCSPlusEngine.Sha256Engine(true, 24, 16, 22, 8, 33, 66));
        sha256_192f = sPHINCSPlusParameters3;
        SPHINCSPlusParameters sPHINCSPlusParameters4 = new SPHINCSPlusParameters("sha256-192s-robust", new SPHINCSPlusEngine.Sha256Engine(true, 24, 16, 7, 14, 17, 63));
        sha256_192s = sPHINCSPlusParameters4;
        SPHINCSPlusParameters sPHINCSPlusParameters5 = new SPHINCSPlusParameters("sha256-256f-robust", new SPHINCSPlusEngine.Sha256Engine(true, 32, 16, 17, 9, 35, 68));
        sha256_256f = sPHINCSPlusParameters5;
        SPHINCSPlusParameters sPHINCSPlusParameters6 = new SPHINCSPlusParameters("sha256-256s-robust", new SPHINCSPlusEngine.Sha256Engine(true, 32, 16, 8, 14, 22, 64));
        sha256_256s = sPHINCSPlusParameters6;
        SPHINCSPlusParameters sPHINCSPlusParameters7 = new SPHINCSPlusParameters("sha256-128f-simple", new SPHINCSPlusEngine.Sha256Engine(false, 16, 16, 22, 6, 33, 66));
        sha256_128f_simple = sPHINCSPlusParameters7;
        SPHINCSPlusParameters sPHINCSPlusParameters8 = new SPHINCSPlusParameters("sha256-128s-simple", new SPHINCSPlusEngine.Sha256Engine(false, 16, 16, 7, 12, 14, 63));
        sha256_128s_simple = sPHINCSPlusParameters8;
        SPHINCSPlusParameters sPHINCSPlusParameters9 = new SPHINCSPlusParameters("sha256-192f-simple", new SPHINCSPlusEngine.Sha256Engine(false, 24, 16, 22, 8, 33, 66));
        sha256_192f_simple = sPHINCSPlusParameters9;
        SPHINCSPlusParameters sPHINCSPlusParameters10 = new SPHINCSPlusParameters("sha256-192s-simple", new SPHINCSPlusEngine.Sha256Engine(false, 24, 16, 7, 14, 17, 63));
        sha256_192s_simple = sPHINCSPlusParameters10;
        SPHINCSPlusParameters sPHINCSPlusParameters11 = new SPHINCSPlusParameters("sha256-256f-simple", new SPHINCSPlusEngine.Sha256Engine(false, 32, 16, 17, 9, 35, 68));
        sha256_256f_simple = sPHINCSPlusParameters11;
        SPHINCSPlusParameters sPHINCSPlusParameters12 = new SPHINCSPlusParameters("sha256-256s-simple", new SPHINCSPlusEngine.Sha256Engine(false, 32, 16, 8, 14, 22, 64));
        sha256_256s_simple = sPHINCSPlusParameters12;
        SPHINCSPlusParameters sPHINCSPlusParameters13 = new SPHINCSPlusParameters("shake256-128f-robust", new SPHINCSPlusEngine.Shake256Engine(true, 16, 16, 22, 6, 33, 66));
        shake256_128f = sPHINCSPlusParameters13;
        SPHINCSPlusParameters sPHINCSPlusParameters14 = new SPHINCSPlusParameters("shake256-128s-robust", new SPHINCSPlusEngine.Shake256Engine(true, 16, 16, 7, 12, 14, 63));
        shake256_128s = sPHINCSPlusParameters14;
        SPHINCSPlusParameters sPHINCSPlusParameters15 = new SPHINCSPlusParameters("shake256-192f-robust", new SPHINCSPlusEngine.Shake256Engine(true, 24, 16, 22, 8, 33, 66));
        shake256_192f = sPHINCSPlusParameters15;
        SPHINCSPlusParameters sPHINCSPlusParameters16 = new SPHINCSPlusParameters("shake256-192s-robust", new SPHINCSPlusEngine.Shake256Engine(true, 24, 16, 7, 14, 17, 63));
        shake256_192s = sPHINCSPlusParameters16;
        SPHINCSPlusParameters sPHINCSPlusParameters17 = new SPHINCSPlusParameters("shake256-256f-robust", new SPHINCSPlusEngine.Shake256Engine(true, 32, 16, 17, 9, 35, 68));
        shake256_256f = sPHINCSPlusParameters17;
        SPHINCSPlusParameters sPHINCSPlusParameters18 = new SPHINCSPlusParameters("shake256-256s-robust", new SPHINCSPlusEngine.Shake256Engine(true, 32, 16, 8, 14, 22, 64));
        shake256_256s = sPHINCSPlusParameters18;
        SPHINCSPlusParameters sPHINCSPlusParameters19 = new SPHINCSPlusParameters("shake256-128f-simple", new SPHINCSPlusEngine.Shake256Engine(false, 16, 16, 22, 6, 33, 66));
        shake256_128f_simple = sPHINCSPlusParameters19;
        SPHINCSPlusParameters sPHINCSPlusParameters20 = new SPHINCSPlusParameters("shake256-128s-simple", new SPHINCSPlusEngine.Shake256Engine(false, 16, 16, 7, 12, 14, 63));
        shake256_128s_simple = sPHINCSPlusParameters20;
        SPHINCSPlusParameters sPHINCSPlusParameters21 = new SPHINCSPlusParameters("shake256-192f-simple", new SPHINCSPlusEngine.Shake256Engine(false, 24, 16, 22, 8, 33, 66));
        shake256_192f_simple = sPHINCSPlusParameters21;
        SPHINCSPlusParameters sPHINCSPlusParameters22 = new SPHINCSPlusParameters("shake256-192s-simple", new SPHINCSPlusEngine.Shake256Engine(false, 24, 16, 7, 14, 17, 63));
        shake256_192s_simple = sPHINCSPlusParameters22;
        SPHINCSPlusParameters sPHINCSPlusParameters23 = new SPHINCSPlusParameters("shake256-256f-simple", new SPHINCSPlusEngine.Shake256Engine(false, 32, 16, 17, 9, 35, 68));
        shake256_256f_simple = sPHINCSPlusParameters23;
        SPHINCSPlusParameters sPHINCSPlusParameters24 = new SPHINCSPlusParameters("shake256-256s-simple", new SPHINCSPlusEngine.Shake256Engine(false, 32, 16, 8, 14, 22, 64));
        shake256_256s_simple = sPHINCSPlusParameters24;
        Integer valueOf = Integers.valueOf(65793);
        sphincsPlus_sha256_128f_robust = valueOf;
        Integer valueOf2 = Integers.valueOf(65794);
        sphincsPlus_sha256_128s_robust = valueOf2;
        Integer valueOf3 = Integers.valueOf(65795);
        sphincsPlus_sha256_192f_robust = valueOf3;
        Integer valueOf4 = Integers.valueOf(65796);
        sphincsPlus_sha256_192s_robust = valueOf4;
        Integer valueOf5 = Integers.valueOf(65797);
        sphincsPlus_sha256_256f_robust = valueOf5;
        Integer valueOf6 = Integers.valueOf(65798);
        sphincsPlus_sha256_256s_robust = valueOf6;
        Integer valueOf7 = Integers.valueOf(66049);
        sphincsPlus_sha256_128f_simple = valueOf7;
        Integer valueOf8 = Integers.valueOf(66050);
        sphincsPlus_sha256_128s_simple = valueOf8;
        Integer valueOf9 = Integers.valueOf(66051);
        sphincsPlus_sha256_192f_simple = valueOf9;
        Integer valueOf10 = Integers.valueOf(66052);
        sphincsPlus_sha256_192s_simple = valueOf10;
        Integer valueOf11 = Integers.valueOf(66053);
        sphincsPlus_sha256_256f_simple = valueOf11;
        Integer valueOf12 = Integers.valueOf(66054);
        sphincsPlus_sha256_256s_simple = valueOf12;
        Integer valueOf13 = Integers.valueOf(131329);
        sphincsPlus_shake256_128f_robust = valueOf13;
        Integer valueOf14 = Integers.valueOf(131330);
        sphincsPlus_shake256_128s_robust = valueOf14;
        Integer valueOf15 = Integers.valueOf(131331);
        sphincsPlus_shake256_192f_robust = valueOf15;
        Integer valueOf16 = Integers.valueOf(131332);
        sphincsPlus_shake256_192s_robust = valueOf16;
        Integer valueOf17 = Integers.valueOf(131333);
        sphincsPlus_shake256_256f_robust = valueOf17;
        Integer valueOf18 = Integers.valueOf(131334);
        sphincsPlus_shake256_256s_robust = valueOf18;
        Integer valueOf19 = Integers.valueOf(131585);
        sphincsPlus_shake256_128f_simple = valueOf19;
        Integer valueOf20 = Integers.valueOf(131586);
        sphincsPlus_shake256_128s_simple = valueOf20;
        Integer valueOf21 = Integers.valueOf(131587);
        sphincsPlus_shake256_192f_simple = valueOf21;
        Integer valueOf22 = Integers.valueOf(131588);
        sphincsPlus_shake256_192s_simple = valueOf22;
        Integer valueOf23 = Integers.valueOf(131589);
        sphincsPlus_shake256_256f_simple = valueOf23;
        Integer valueOf24 = Integers.valueOf(131590);
        sphincsPlus_shake256_256s_simple = valueOf24;
        HashMap hashMap = new HashMap();
        oidToParams = hashMap;
        HashMap hashMap2 = new HashMap();
        paramsToOid = hashMap2;
        hashMap.put(valueOf, sPHINCSPlusParameters);
        hashMap.put(valueOf2, sPHINCSPlusParameters2);
        hashMap.put(valueOf3, sPHINCSPlusParameters3);
        hashMap.put(valueOf4, sPHINCSPlusParameters4);
        hashMap.put(valueOf5, sPHINCSPlusParameters5);
        hashMap.put(valueOf6, sPHINCSPlusParameters6);
        hashMap.put(valueOf7, sPHINCSPlusParameters7);
        hashMap.put(valueOf8, sPHINCSPlusParameters8);
        hashMap.put(valueOf9, sPHINCSPlusParameters9);
        hashMap.put(valueOf10, sPHINCSPlusParameters10);
        hashMap.put(valueOf11, sPHINCSPlusParameters11);
        hashMap.put(valueOf12, sPHINCSPlusParameters12);
        hashMap.put(valueOf13, sPHINCSPlusParameters13);
        hashMap.put(valueOf14, sPHINCSPlusParameters14);
        hashMap.put(valueOf15, sPHINCSPlusParameters15);
        hashMap.put(valueOf16, sPHINCSPlusParameters16);
        hashMap.put(valueOf17, sPHINCSPlusParameters17);
        hashMap.put(valueOf18, sPHINCSPlusParameters18);
        hashMap.put(valueOf19, sPHINCSPlusParameters19);
        hashMap.put(valueOf20, sPHINCSPlusParameters20);
        hashMap.put(valueOf21, sPHINCSPlusParameters21);
        hashMap.put(valueOf22, sPHINCSPlusParameters22);
        hashMap.put(valueOf23, sPHINCSPlusParameters23);
        hashMap.put(valueOf24, sPHINCSPlusParameters24);
        hashMap2.put(sPHINCSPlusParameters, valueOf);
        hashMap2.put(sPHINCSPlusParameters2, valueOf2);
        hashMap2.put(sPHINCSPlusParameters3, valueOf3);
        hashMap2.put(sPHINCSPlusParameters4, valueOf4);
        hashMap2.put(sPHINCSPlusParameters5, valueOf5);
        hashMap2.put(sPHINCSPlusParameters6, valueOf6);
        hashMap2.put(sPHINCSPlusParameters7, valueOf7);
        hashMap2.put(sPHINCSPlusParameters8, valueOf8);
        hashMap2.put(sPHINCSPlusParameters9, valueOf9);
        hashMap2.put(sPHINCSPlusParameters10, valueOf10);
        hashMap2.put(sPHINCSPlusParameters11, valueOf11);
        hashMap2.put(sPHINCSPlusParameters12, valueOf12);
        hashMap2.put(sPHINCSPlusParameters13, valueOf13);
        hashMap2.put(sPHINCSPlusParameters14, valueOf14);
        hashMap2.put(sPHINCSPlusParameters15, valueOf15);
        hashMap2.put(sPHINCSPlusParameters16, valueOf16);
        hashMap2.put(sPHINCSPlusParameters17, valueOf17);
        hashMap2.put(sPHINCSPlusParameters18, valueOf18);
        hashMap2.put(sPHINCSPlusParameters19, valueOf19);
        hashMap2.put(sPHINCSPlusParameters20, valueOf20);
        hashMap2.put(sPHINCSPlusParameters21, valueOf21);
        hashMap2.put(sPHINCSPlusParameters22, valueOf22);
        hashMap2.put(sPHINCSPlusParameters23, valueOf23);
        hashMap2.put(sPHINCSPlusParameters24, valueOf24);
    }

    private SPHINCSPlusParameters(String str, SPHINCSPlusEngine sPHINCSPlusEngine) {
        this.name = str;
        this.engine = sPHINCSPlusEngine;
    }

    public static Integer getID(SPHINCSPlusParameters sPHINCSPlusParameters) {
        return (Integer) paramsToOid.get(sPHINCSPlusParameters);
    }

    public static SPHINCSPlusParameters getParams(Integer num) {
        return (SPHINCSPlusParameters) oidToParams.get(num);
    }

    public byte[] getEncoded() {
        return Pack.intToBigEndian(getID(this).intValue());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SPHINCSPlusEngine getEngine() {
        return this.engine;
    }

    public String getName() {
        return this.name;
    }
}
