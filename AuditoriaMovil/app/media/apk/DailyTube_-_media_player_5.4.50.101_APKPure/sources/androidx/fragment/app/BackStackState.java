package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.v;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class BackStackState implements Parcelable {
    public static final Parcelable.Creator<BackStackState> CREATOR = new Parcelable.Creator<BackStackState>() { // from class: androidx.fragment.app.BackStackState.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BackStackState createFromParcel(Parcel parcel) {
            return new BackStackState(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BackStackState[] newArray(int i) {
            return new BackStackState[i];
        }
    };
    final int mBreadCrumbShortTitleRes;
    final CharSequence mBreadCrumbShortTitleText;
    final int mBreadCrumbTitleRes;
    final CharSequence mBreadCrumbTitleText;
    final int[] mCurrentMaxLifecycleStates;
    final ArrayList<String> mFragmentWhos;
    final int mIndex;
    final String mName;
    final int[] mOldMaxLifecycleStates;
    final int[] mOps;
    final boolean mReorderingAllowed;
    final ArrayList<String> mSharedElementSourceNames;
    final ArrayList<String> mSharedElementTargetNames;
    final int mTransition;

    public BackStackState(BackStackRecord backStackRecord) {
        int size = backStackRecord.mOps.size();
        this.mOps = new int[size * 5];
        if (backStackRecord.mAddToBackStack) {
            this.mFragmentWhos = new ArrayList<>(size);
            this.mOldMaxLifecycleStates = new int[size];
            this.mCurrentMaxLifecycleStates = new int[size];
            int i = 0;
            for (int i5 = 0; i5 < size; i5++) {
                FragmentTransaction.Op op = backStackRecord.mOps.get(i5);
                int i6 = i + 1;
                this.mOps[i] = op.mCmd;
                ArrayList<String> arrayList = this.mFragmentWhos;
                Fragment fragment = op.mFragment;
                arrayList.add(fragment != null ? fragment.mWho : null);
                int[] iArr = this.mOps;
                iArr[i6] = op.mEnterAnim;
                iArr[i + 2] = op.mExitAnim;
                int i8 = i + 4;
                iArr[i + 3] = op.mPopEnterAnim;
                i += 5;
                iArr[i8] = op.mPopExitAnim;
                this.mOldMaxLifecycleStates[i5] = op.mOldMaxState.ordinal();
                this.mCurrentMaxLifecycleStates[i5] = op.mCurrentMaxState.ordinal();
            }
            this.mTransition = backStackRecord.mTransition;
            this.mName = backStackRecord.mName;
            this.mIndex = backStackRecord.mIndex;
            this.mBreadCrumbTitleRes = backStackRecord.mBreadCrumbTitleRes;
            this.mBreadCrumbTitleText = backStackRecord.mBreadCrumbTitleText;
            this.mBreadCrumbShortTitleRes = backStackRecord.mBreadCrumbShortTitleRes;
            this.mBreadCrumbShortTitleText = backStackRecord.mBreadCrumbShortTitleText;
            this.mSharedElementSourceNames = backStackRecord.mSharedElementSourceNames;
            this.mSharedElementTargetNames = backStackRecord.mSharedElementTargetNames;
            this.mReorderingAllowed = backStackRecord.mReorderingAllowed;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public BackStackRecord instantiate(FragmentManager fragmentManager) {
        BackStackRecord backStackRecord = new BackStackRecord(fragmentManager);
        int i = 0;
        int i5 = 0;
        while (i < this.mOps.length) {
            FragmentTransaction.Op op = new FragmentTransaction.Op();
            int i6 = i + 1;
            op.mCmd = this.mOps[i];
            FragmentManager.isLoggingEnabled(2);
            String str = this.mFragmentWhos.get(i5);
            if (str != null) {
                op.mFragment = fragmentManager.findActiveFragment(str);
            } else {
                op.mFragment = null;
            }
            op.mOldMaxState = v.zn.values()[this.mOldMaxLifecycleStates[i5]];
            op.mCurrentMaxState = v.zn.values()[this.mCurrentMaxLifecycleStates[i5]];
            int[] iArr = this.mOps;
            int i8 = iArr[i6];
            op.mEnterAnim = i8;
            int i10 = iArr[i + 2];
            op.mExitAnim = i10;
            int i11 = i + 4;
            int i12 = iArr[i + 3];
            op.mPopEnterAnim = i12;
            i += 5;
            int i13 = iArr[i11];
            op.mPopExitAnim = i13;
            backStackRecord.mEnterAnim = i8;
            backStackRecord.mExitAnim = i10;
            backStackRecord.mPopEnterAnim = i12;
            backStackRecord.mPopExitAnim = i13;
            backStackRecord.addOp(op);
            i5++;
        }
        backStackRecord.mTransition = this.mTransition;
        backStackRecord.mName = this.mName;
        backStackRecord.mIndex = this.mIndex;
        backStackRecord.mAddToBackStack = true;
        backStackRecord.mBreadCrumbTitleRes = this.mBreadCrumbTitleRes;
        backStackRecord.mBreadCrumbTitleText = this.mBreadCrumbTitleText;
        backStackRecord.mBreadCrumbShortTitleRes = this.mBreadCrumbShortTitleRes;
        backStackRecord.mBreadCrumbShortTitleText = this.mBreadCrumbShortTitleText;
        backStackRecord.mSharedElementSourceNames = this.mSharedElementSourceNames;
        backStackRecord.mSharedElementTargetNames = this.mSharedElementTargetNames;
        backStackRecord.mReorderingAllowed = this.mReorderingAllowed;
        backStackRecord.bumpBackStackNesting(1);
        return backStackRecord;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.mOps);
        parcel.writeStringList(this.mFragmentWhos);
        parcel.writeIntArray(this.mOldMaxLifecycleStates);
        parcel.writeIntArray(this.mCurrentMaxLifecycleStates);
        parcel.writeInt(this.mTransition);
        parcel.writeString(this.mName);
        parcel.writeInt(this.mIndex);
        parcel.writeInt(this.mBreadCrumbTitleRes);
        TextUtils.writeToParcel(this.mBreadCrumbTitleText, parcel, 0);
        parcel.writeInt(this.mBreadCrumbShortTitleRes);
        TextUtils.writeToParcel(this.mBreadCrumbShortTitleText, parcel, 0);
        parcel.writeStringList(this.mSharedElementSourceNames);
        parcel.writeStringList(this.mSharedElementTargetNames);
        parcel.writeInt(this.mReorderingAllowed ? 1 : 0);
    }

    public BackStackState(Parcel parcel) {
        this.mOps = parcel.createIntArray();
        this.mFragmentWhos = parcel.createStringArrayList();
        this.mOldMaxLifecycleStates = parcel.createIntArray();
        this.mCurrentMaxLifecycleStates = parcel.createIntArray();
        this.mTransition = parcel.readInt();
        this.mName = parcel.readString();
        this.mIndex = parcel.readInt();
        this.mBreadCrumbTitleRes = parcel.readInt();
        Parcelable.Creator creator = TextUtils.CHAR_SEQUENCE_CREATOR;
        this.mBreadCrumbTitleText = (CharSequence) creator.createFromParcel(parcel);
        this.mBreadCrumbShortTitleRes = parcel.readInt();
        this.mBreadCrumbShortTitleText = (CharSequence) creator.createFromParcel(parcel);
        this.mSharedElementSourceNames = parcel.createStringArrayList();
        this.mSharedElementTargetNames = parcel.createStringArrayList();
        this.mReorderingAllowed = parcel.readInt() != 0;
    }
}
