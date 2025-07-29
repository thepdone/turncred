package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
class BackStackState implements Parcelable {
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
    final List<String> mFragments;
    final List<BackStackRecordState> mTransactions;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    BackStackState(List<String> list, List<BackStackRecordState> list2) {
        this.mFragments = list;
        this.mTransactions = list2;
    }

    BackStackState(Parcel parcel) {
        this.mFragments = parcel.createStringArrayList();
        this.mTransactions = parcel.createTypedArrayList(BackStackRecordState.CREATOR);
    }

    List<BackStackRecord> instantiate(FragmentManager fragmentManager, Map<String, Fragment> map) {
        HashMap map2 = new HashMap(this.mFragments.size());
        for (String str : this.mFragments) {
            Fragment fragment = map.get(str);
            if (fragment != null) {
                map2.put(fragment.mWho, fragment);
            } else {
                Bundle savedState = fragmentManager.getFragmentStore().setSavedState(str, null);
                if (savedState != null) {
                    ClassLoader classLoader = fragmentManager.getHost().getContext().getClassLoader();
                    Fragment fragmentInstantiate = ((FragmentState) savedState.getParcelable("state")).instantiate(fragmentManager.getFragmentFactory(), classLoader);
                    fragmentInstantiate.mSavedFragmentState = savedState;
                    if (fragmentInstantiate.mSavedFragmentState.getBundle("savedInstanceState") == null) {
                        fragmentInstantiate.mSavedFragmentState.putBundle("savedInstanceState", new Bundle());
                    }
                    Bundle bundle = savedState.getBundle("arguments");
                    if (bundle != null) {
                        bundle.setClassLoader(classLoader);
                    }
                    fragmentInstantiate.setArguments(bundle);
                    map2.put(fragmentInstantiate.mWho, fragmentInstantiate);
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        Iterator<BackStackRecordState> it = this.mTransactions.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().instantiate(fragmentManager, map2));
        }
        return arrayList;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringList(this.mFragments);
        parcel.writeTypedList(this.mTransactions);
    }
}
