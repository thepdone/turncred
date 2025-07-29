package androidx.viewpager2.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes4.dex */
public final class FragmentViewHolder extends RecyclerView.ViewHolder {
    private FragmentViewHolder(FrameLayout frameLayout) {
        super(frameLayout);
    }

    static FragmentViewHolder create(ViewGroup viewGroup) {
        FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        frameLayout.setId(View.generateViewId());
        frameLayout.setSaveEnabled(false);
        return new FragmentViewHolder(frameLayout);
    }

    FrameLayout getContainer() {
        return (FrameLayout) this.itemView;
    }
}
