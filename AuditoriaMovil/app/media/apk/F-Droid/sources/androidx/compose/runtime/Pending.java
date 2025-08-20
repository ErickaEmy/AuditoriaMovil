package androidx.compose.runtime;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Composer.kt */
/* loaded from: classes.dex */
final class Pending {
    private int groupIndex;
    private final HashMap groupInfos;
    private final List keyInfos;
    private final Lazy keyMap$delegate;
    private final int startIndex;
    private final List usedKeys;

    public final int getGroupIndex() {
        return this.groupIndex;
    }

    public final List getKeyInfos() {
        return this.keyInfos;
    }

    public final int getStartIndex() {
        return this.startIndex;
    }

    public final List getUsed() {
        return this.usedKeys;
    }

    public final void setGroupIndex(int i) {
        this.groupIndex = i;
    }

    public Pending(List keyInfos, int i) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(keyInfos, "keyInfos");
        this.keyInfos = keyInfos;
        this.startIndex = i;
        if (i < 0) {
            throw new IllegalArgumentException("Invalid start index".toString());
        }
        this.usedKeys = new ArrayList();
        HashMap hashMap = new HashMap();
        int size = keyInfos.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            KeyInfo keyInfo = (KeyInfo) this.keyInfos.get(i3);
            hashMap.put(Integer.valueOf(keyInfo.getLocation()), new GroupInfo(i3, i2, keyInfo.getNodes()));
            i2 += keyInfo.getNodes();
        }
        this.groupInfos = hashMap;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: androidx.compose.runtime.Pending$keyMap$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final HashMap invoke() {
                HashMap multiMap;
                Object joinedKey;
                multiMap = ComposerKt.multiMap();
                Pending pending = Pending.this;
                int size2 = pending.getKeyInfos().size();
                for (int i4 = 0; i4 < size2; i4++) {
                    KeyInfo keyInfo2 = (KeyInfo) pending.getKeyInfos().get(i4);
                    joinedKey = ComposerKt.getJoinedKey(keyInfo2);
                    ComposerKt.put(multiMap, joinedKey, keyInfo2);
                }
                return multiMap;
            }
        });
        this.keyMap$delegate = lazy;
    }

    public final HashMap getKeyMap() {
        return (HashMap) this.keyMap$delegate.getValue();
    }

    public final KeyInfo getNext(int i, Object obj) {
        Object pop;
        pop = ComposerKt.pop(getKeyMap(), obj != null ? new JoinedKey(Integer.valueOf(i), obj) : Integer.valueOf(i));
        return (KeyInfo) pop;
    }

    public final boolean recordUsed(KeyInfo keyInfo) {
        Intrinsics.checkNotNullParameter(keyInfo, "keyInfo");
        return this.usedKeys.add(keyInfo);
    }

    public final void registerMoveSlot(int i, int i2) {
        if (i > i2) {
            Collection<GroupInfo> values = this.groupInfos.values();
            Intrinsics.checkNotNullExpressionValue(values, "groupInfos.values");
            for (GroupInfo groupInfo : values) {
                int slotIndex = groupInfo.getSlotIndex();
                if (slotIndex == i) {
                    groupInfo.setSlotIndex(i2);
                } else if (i2 <= slotIndex && slotIndex < i) {
                    groupInfo.setSlotIndex(slotIndex + 1);
                }
            }
        } else if (i2 > i) {
            Collection<GroupInfo> values2 = this.groupInfos.values();
            Intrinsics.checkNotNullExpressionValue(values2, "groupInfos.values");
            for (GroupInfo groupInfo2 : values2) {
                int slotIndex2 = groupInfo2.getSlotIndex();
                if (slotIndex2 == i) {
                    groupInfo2.setSlotIndex(i2);
                } else if (i + 1 <= slotIndex2 && slotIndex2 < i2) {
                    groupInfo2.setSlotIndex(slotIndex2 - 1);
                }
            }
        }
    }

    public final void registerMoveNode(int i, int i2, int i3) {
        if (i > i2) {
            Collection<GroupInfo> values = this.groupInfos.values();
            Intrinsics.checkNotNullExpressionValue(values, "groupInfos.values");
            for (GroupInfo groupInfo : values) {
                int nodeIndex = groupInfo.getNodeIndex();
                if (i <= nodeIndex && nodeIndex < i + i3) {
                    groupInfo.setNodeIndex((nodeIndex - i) + i2);
                } else if (i2 <= nodeIndex && nodeIndex < i) {
                    groupInfo.setNodeIndex(nodeIndex + i3);
                }
            }
        } else if (i2 > i) {
            Collection<GroupInfo> values2 = this.groupInfos.values();
            Intrinsics.checkNotNullExpressionValue(values2, "groupInfos.values");
            for (GroupInfo groupInfo2 : values2) {
                int nodeIndex2 = groupInfo2.getNodeIndex();
                if (i <= nodeIndex2 && nodeIndex2 < i + i3) {
                    groupInfo2.setNodeIndex((nodeIndex2 - i) + i2);
                } else if (i + 1 <= nodeIndex2 && nodeIndex2 < i2) {
                    groupInfo2.setNodeIndex(nodeIndex2 - i3);
                }
            }
        }
    }

    public final void registerInsert(KeyInfo keyInfo, int i) {
        Intrinsics.checkNotNullParameter(keyInfo, "keyInfo");
        this.groupInfos.put(Integer.valueOf(keyInfo.getLocation()), new GroupInfo(-1, i, 0));
    }

    public final boolean updateNodeCount(int i, int i2) {
        int nodeIndex;
        GroupInfo groupInfo = (GroupInfo) this.groupInfos.get(Integer.valueOf(i));
        if (groupInfo != null) {
            int nodeIndex2 = groupInfo.getNodeIndex();
            int nodeCount = i2 - groupInfo.getNodeCount();
            groupInfo.setNodeCount(i2);
            if (nodeCount != 0) {
                Collection<GroupInfo> values = this.groupInfos.values();
                Intrinsics.checkNotNullExpressionValue(values, "groupInfos.values");
                for (GroupInfo groupInfo2 : values) {
                    if (groupInfo2.getNodeIndex() >= nodeIndex2 && !Intrinsics.areEqual(groupInfo2, groupInfo) && (nodeIndex = groupInfo2.getNodeIndex() + nodeCount) >= 0) {
                        groupInfo2.setNodeIndex(nodeIndex);
                    }
                }
                return true;
            }
            return true;
        }
        return false;
    }

    public final int slotPositionOf(KeyInfo keyInfo) {
        Intrinsics.checkNotNullParameter(keyInfo, "keyInfo");
        GroupInfo groupInfo = (GroupInfo) this.groupInfos.get(Integer.valueOf(keyInfo.getLocation()));
        if (groupInfo != null) {
            return groupInfo.getSlotIndex();
        }
        return -1;
    }

    public final int nodePositionOf(KeyInfo keyInfo) {
        Intrinsics.checkNotNullParameter(keyInfo, "keyInfo");
        GroupInfo groupInfo = (GroupInfo) this.groupInfos.get(Integer.valueOf(keyInfo.getLocation()));
        if (groupInfo != null) {
            return groupInfo.getNodeIndex();
        }
        return -1;
    }

    public final int updatedNodeCountOf(KeyInfo keyInfo) {
        Intrinsics.checkNotNullParameter(keyInfo, "keyInfo");
        GroupInfo groupInfo = (GroupInfo) this.groupInfos.get(Integer.valueOf(keyInfo.getLocation()));
        return groupInfo != null ? groupInfo.getNodeCount() : keyInfo.getNodes();
    }
}
