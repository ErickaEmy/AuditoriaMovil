package org.bouncycastle.tsp.ers;

import java.util.ArrayList;
import org.bouncycastle.asn1.tsp.PartialHashtree;
import org.bouncycastle.operator.DigestCalculator;
/* loaded from: classes2.dex */
public class BinaryTreeRootCalculator implements ERSRootNodeCalculator {
    @Override // org.bouncycastle.tsp.ers.ERSRootNodeCalculator
    public byte[] computeRootHash(DigestCalculator digestCalculator, PartialHashtree[] partialHashtreeArr) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i <= partialHashtreeArr.length - 2; i += 2) {
            arrayList.add(ERSUtil.calculateBranchHash(digestCalculator, ERSUtil.computeNodeHash(digestCalculator, partialHashtreeArr[i]), ERSUtil.computeNodeHash(digestCalculator, partialHashtreeArr[i + 1])));
        }
        if (partialHashtreeArr.length % 2 == 1) {
            arrayList.add(ERSUtil.computeNodeHash(digestCalculator, partialHashtreeArr[partialHashtreeArr.length - 1]));
        }
        while (true) {
            ArrayList arrayList2 = new ArrayList((arrayList.size() + 1) / 2);
            for (int i2 = 0; i2 <= arrayList.size() - 2; i2 += 2) {
                arrayList2.add(ERSUtil.calculateBranchHash(digestCalculator, (byte[]) arrayList.get(i2), (byte[]) arrayList.get(i2 + 1)));
            }
            if (arrayList.size() % 2 == 1) {
                arrayList2.add(arrayList.get(arrayList.size() - 1));
            }
            if (arrayList2.size() <= 1) {
                return (byte[]) arrayList2.get(0);
            }
            arrayList = arrayList2;
        }
    }
}
