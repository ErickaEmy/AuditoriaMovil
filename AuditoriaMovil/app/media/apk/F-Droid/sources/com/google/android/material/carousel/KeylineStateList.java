package com.google.android.material.carousel;

import androidx.core.math.MathUtils;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.carousel.KeylineState;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class KeylineStateList {
    private final KeylineState defaultState;
    private final float endShiftRange;
    private final List endStateSteps;
    private final float[] endStateStepsInterpolationPoints;
    private final float startShiftRange;
    private final List startStateSteps;
    private final float[] startStateStepsInterpolationPoints;

    /* JADX INFO: Access modifiers changed from: package-private */
    public KeylineState getDefaultState() {
        return this.defaultState;
    }

    private KeylineStateList(KeylineState keylineState, List list, List list2) {
        this.defaultState = keylineState;
        this.startStateSteps = Collections.unmodifiableList(list);
        this.endStateSteps = Collections.unmodifiableList(list2);
        float f = ((KeylineState) list.get(list.size() - 1)).getFirstKeyline().loc - keylineState.getFirstKeyline().loc;
        this.startShiftRange = f;
        float f2 = keylineState.getLastKeyline().loc - ((KeylineState) list2.get(list2.size() - 1)).getLastKeyline().loc;
        this.endShiftRange = f2;
        this.startStateStepsInterpolationPoints = getStateStepInterpolationPoints(f, list, true);
        this.endStateStepsInterpolationPoints = getStateStepInterpolationPoints(f2, list2, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static KeylineStateList from(Carousel carousel, KeylineState keylineState) {
        return new KeylineStateList(keylineState, getStateStepsStart(carousel, keylineState), getStateStepsEnd(carousel, keylineState));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public KeylineState getStartState() {
        List list = this.startStateSteps;
        return (KeylineState) list.get(list.size() - 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public KeylineState getEndState() {
        List list = this.endStateSteps;
        return (KeylineState) list.get(list.size() - 1);
    }

    public KeylineState getShiftedState(float f, float f2, float f3) {
        return getShiftedState(f, f2, f3, false);
    }

    KeylineState getShiftedState(float f, float f2, float f3, boolean z) {
        float lerp;
        List list;
        float[] fArr;
        float f4 = this.startShiftRange + f2;
        float f5 = f3 - this.endShiftRange;
        if (f < f4) {
            lerp = AnimationUtils.lerp(1.0f, 0.0f, f2, f4, f);
            list = this.startStateSteps;
            fArr = this.startStateStepsInterpolationPoints;
        } else if (f <= f5) {
            return this.defaultState;
        } else {
            lerp = AnimationUtils.lerp(0.0f, 1.0f, f5, f3, f);
            list = this.endStateSteps;
            fArr = this.endStateStepsInterpolationPoints;
        }
        if (z) {
            return closestStateStepFromInterpolation(list, lerp, fArr);
        }
        return lerp(list, lerp, fArr);
    }

    private static KeylineState lerp(List list, float f, float[] fArr) {
        float[] stateStepsRange = getStateStepsRange(list, f, fArr);
        return KeylineState.lerp((KeylineState) list.get((int) stateStepsRange[1]), (KeylineState) list.get((int) stateStepsRange[2]), stateStepsRange[0]);
    }

    private static float[] getStateStepsRange(List list, float f, float[] fArr) {
        int size = list.size();
        float f2 = fArr[0];
        int i = 1;
        while (i < size) {
            float f3 = fArr[i];
            if (f <= f3) {
                return new float[]{AnimationUtils.lerp(0.0f, 1.0f, f2, f3, f), (float) (i - 1), i};
            }
            i++;
            f2 = f3;
        }
        return new float[]{0.0f, 0.0f, 0.0f};
    }

    private KeylineState closestStateStepFromInterpolation(List list, float f, float[] fArr) {
        float[] stateStepsRange = getStateStepsRange(list, f, fArr);
        if (stateStepsRange[0] > 0.5f) {
            return (KeylineState) list.get((int) stateStepsRange[2]);
        }
        return (KeylineState) list.get((int) stateStepsRange[1]);
    }

    private static float[] getStateStepInterpolationPoints(float f, List list, boolean z) {
        float f2;
        int size = list.size();
        float[] fArr = new float[size];
        int i = 1;
        while (i < size) {
            int i2 = i - 1;
            KeylineState keylineState = (KeylineState) list.get(i2);
            KeylineState keylineState2 = (KeylineState) list.get(i);
            if (z) {
                f2 = keylineState2.getFirstKeyline().loc - keylineState.getFirstKeyline().loc;
            } else {
                f2 = keylineState.getLastKeyline().loc - keylineState2.getLastKeyline().loc;
            }
            fArr[i] = i == size + (-1) ? 1.0f : fArr[i2] + (f2 / f);
            i++;
        }
        return fArr;
    }

    private static boolean isFirstFocalItemAtLeftOfContainer(KeylineState keylineState) {
        return keylineState.getFirstFocalKeyline().locOffset - (keylineState.getFirstFocalKeyline().maskedItemSize / 2.0f) >= 0.0f && keylineState.getFirstFocalKeyline() == keylineState.getFirstNonAnchorKeyline();
    }

    private static boolean isLastFocalItemVisibleAtRightOfContainer(Carousel carousel, KeylineState keylineState) {
        int containerHeight = carousel.getContainerHeight();
        if (carousel.isHorizontal()) {
            containerHeight = carousel.getContainerWidth();
        }
        return keylineState.getLastFocalKeyline().locOffset + (keylineState.getLastFocalKeyline().maskedItemSize / 2.0f) <= ((float) containerHeight) && keylineState.getLastFocalKeyline() == keylineState.getLastNonAnchorKeyline();
    }

    private static List getStateStepsStart(Carousel carousel, KeylineState keylineState) {
        int i;
        ArrayList arrayList = new ArrayList();
        arrayList.add(keylineState);
        int findFirstNonAnchorKeylineIndex = findFirstNonAnchorKeylineIndex(keylineState);
        if (!isFirstFocalItemAtLeftOfContainer(keylineState) && findFirstNonAnchorKeylineIndex != -1) {
            int firstFocalKeylineIndex = keylineState.getFirstFocalKeylineIndex() - findFirstNonAnchorKeylineIndex;
            float containerWidth = carousel.isHorizontal() ? carousel.getContainerWidth() : carousel.getContainerHeight();
            float f = keylineState.getFirstKeyline().locOffset - (keylineState.getFirstKeyline().maskedItemSize / 2.0f);
            float f2 = 0.0f;
            if (firstFocalKeylineIndex <= 0 && keylineState.getFirstFocalKeyline().cutoff > 0.0f) {
                arrayList.add(shiftKeylinesAndCreateKeylineState(keylineState, f + keylineState.getFirstFocalKeyline().cutoff, containerWidth));
                return arrayList;
            }
            int i2 = 0;
            while (i2 < firstFocalKeylineIndex) {
                KeylineState keylineState2 = (KeylineState) arrayList.get(arrayList.size() - 1);
                int i3 = findFirstNonAnchorKeylineIndex + i2;
                int size = keylineState.getKeylines().size() - 1;
                float f3 = f2 + ((KeylineState.Keyline) keylineState.getKeylines().get(i3)).cutoff;
                arrayList.add(moveKeylineAndCreateKeylineState(keylineState2, findFirstNonAnchorKeylineIndex, i3 - 1 >= 0 ? findFirstIndexAfterLastFocalKeylineWithMask(keylineState2, ((KeylineState.Keyline) keylineState.getKeylines().get(i)).mask) - 1 : size, f + f3, (keylineState.getFirstFocalKeylineIndex() - i2) - 1, (keylineState.getLastFocalKeylineIndex() - i2) - 1, containerWidth));
                i2++;
                f2 = f3;
            }
        }
        return arrayList;
    }

    private static List getStateStepsEnd(Carousel carousel, KeylineState keylineState) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(keylineState);
        int findLastNonAnchorKeylineIndex = findLastNonAnchorKeylineIndex(keylineState);
        if (!isLastFocalItemVisibleAtRightOfContainer(carousel, keylineState) && findLastNonAnchorKeylineIndex != -1) {
            int lastFocalKeylineIndex = findLastNonAnchorKeylineIndex - keylineState.getLastFocalKeylineIndex();
            float containerWidth = carousel.isHorizontal() ? carousel.getContainerWidth() : carousel.getContainerHeight();
            float f = keylineState.getFirstKeyline().locOffset - (keylineState.getFirstKeyline().maskedItemSize / 2.0f);
            float f2 = 0.0f;
            if (lastFocalKeylineIndex <= 0 && keylineState.getLastFocalKeyline().cutoff > 0.0f) {
                arrayList.add(shiftKeylinesAndCreateKeylineState(keylineState, f - keylineState.getLastFocalKeyline().cutoff, containerWidth));
                return arrayList;
            }
            int i = 0;
            while (i < lastFocalKeylineIndex) {
                KeylineState keylineState2 = (KeylineState) arrayList.get(arrayList.size() - 1);
                int i2 = findLastNonAnchorKeylineIndex - i;
                float f3 = f2 + ((KeylineState.Keyline) keylineState.getKeylines().get(i2)).cutoff;
                int i3 = i2 + 1;
                arrayList.add(moveKeylineAndCreateKeylineState(keylineState2, findLastNonAnchorKeylineIndex, i3 < keylineState.getKeylines().size() ? findLastIndexBeforeFirstFocalKeylineWithMask(keylineState2, ((KeylineState.Keyline) keylineState.getKeylines().get(i3)).mask) + 1 : 0, f - f3, keylineState.getFirstFocalKeylineIndex() + i + 1, keylineState.getLastFocalKeylineIndex() + i + 1, containerWidth));
                i++;
                f2 = f3;
            }
        }
        return arrayList;
    }

    private static KeylineState shiftKeylinesAndCreateKeylineState(KeylineState keylineState, float f, float f2) {
        return moveKeylineAndCreateKeylineState(keylineState, 0, 0, f, keylineState.getFirstFocalKeylineIndex(), keylineState.getLastFocalKeylineIndex(), f2);
    }

    private static KeylineState moveKeylineAndCreateKeylineState(KeylineState keylineState, int i, int i2, float f, int i3, int i4, float f2) {
        ArrayList arrayList = new ArrayList(keylineState.getKeylines());
        arrayList.add(i2, (KeylineState.Keyline) arrayList.remove(i));
        KeylineState.Builder builder = new KeylineState.Builder(keylineState.getItemSize(), f2);
        int i5 = 0;
        while (i5 < arrayList.size()) {
            KeylineState.Keyline keyline = (KeylineState.Keyline) arrayList.get(i5);
            float f3 = keyline.maskedItemSize;
            builder.addKeyline(f + (f3 / 2.0f), keyline.mask, f3, i5 >= i3 && i5 <= i4, keyline.isAnchor, keyline.cutoff);
            f += keyline.maskedItemSize;
            i5++;
        }
        return builder.build();
    }

    private static int findFirstIndexAfterLastFocalKeylineWithMask(KeylineState keylineState, float f) {
        for (int lastFocalKeylineIndex = keylineState.getLastFocalKeylineIndex(); lastFocalKeylineIndex < keylineState.getKeylines().size(); lastFocalKeylineIndex++) {
            if (f == ((KeylineState.Keyline) keylineState.getKeylines().get(lastFocalKeylineIndex)).mask) {
                return lastFocalKeylineIndex;
            }
        }
        return keylineState.getKeylines().size() - 1;
    }

    private static int findLastIndexBeforeFirstFocalKeylineWithMask(KeylineState keylineState, float f) {
        for (int firstFocalKeylineIndex = keylineState.getFirstFocalKeylineIndex() - 1; firstFocalKeylineIndex >= 0; firstFocalKeylineIndex--) {
            if (f == ((KeylineState.Keyline) keylineState.getKeylines().get(firstFocalKeylineIndex)).mask) {
                return firstFocalKeylineIndex;
            }
        }
        return 0;
    }

    private static int findFirstNonAnchorKeylineIndex(KeylineState keylineState) {
        for (int i = 0; i < keylineState.getKeylines().size(); i++) {
            if (!((KeylineState.Keyline) keylineState.getKeylines().get(i)).isAnchor) {
                return i;
            }
        }
        return -1;
    }

    private static int findLastNonAnchorKeylineIndex(KeylineState keylineState) {
        for (int size = keylineState.getKeylines().size() - 1; size >= 0; size--) {
            if (!((KeylineState.Keyline) keylineState.getKeylines().get(size)).isAnchor) {
                return size;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map getKeylineStateForPositionMap(int i, int i2, int i3, boolean z) {
        float itemSize = this.defaultState.getItemSize();
        HashMap hashMap = new HashMap();
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if (i4 >= i) {
                break;
            }
            int i6 = z ? (i - i4) - 1 : i4;
            if (i6 * itemSize * (z ? -1 : 1) > i3 - this.endShiftRange || i4 >= i - this.endStateSteps.size()) {
                Integer valueOf = Integer.valueOf(i6);
                List list = this.endStateSteps;
                hashMap.put(valueOf, (KeylineState) list.get(MathUtils.clamp(i5, 0, list.size() - 1)));
                i5++;
            }
            i4++;
        }
        int i7 = 0;
        for (int i8 = i - 1; i8 >= 0; i8--) {
            int i9 = z ? (i - i8) - 1 : i8;
            if (i9 * itemSize * (z ? -1 : 1) < i2 + this.startShiftRange || i8 < this.startStateSteps.size()) {
                Integer valueOf2 = Integer.valueOf(i9);
                List list2 = this.startStateSteps;
                hashMap.put(valueOf2, (KeylineState) list2.get(MathUtils.clamp(i7, 0, list2.size() - 1)));
                i7++;
            }
        }
        return hashMap;
    }
}
