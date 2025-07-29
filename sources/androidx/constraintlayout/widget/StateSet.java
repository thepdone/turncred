package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes4.dex */
public class StateSet {
    private static final boolean DEBUG = false;
    public static final String TAG = "ConstraintLayoutStates";
    ConstraintSet mDefaultConstraintSet;
    int mDefaultState = -1;
    int mCurrentStateId = -1;
    int mCurrentConstraintNumber = -1;
    private SparseArray<State> mStateList = new SparseArray<>();
    private SparseArray<ConstraintSet> mConstraintSetMap = new SparseArray<>();
    private ConstraintsChangedListener mConstraintsChangedListener = null;

    public StateSet(Context context, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        load(context, xmlPullParser);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void load(android.content.Context r9, org.xmlpull.v1.XmlPullParser r10) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r8 = this;
            android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r10)
            int[] r1 = androidx.constraintlayout.widget.R.styleable.StateSet
            android.content.res.TypedArray r0 = r9.obtainStyledAttributes(r0, r1)
            int r1 = r0.getIndexCount()
            r2 = 0
            r3 = r2
        L10:
            if (r3 >= r1) goto L25
            int r4 = r0.getIndex(r3)
            int r5 = androidx.constraintlayout.widget.R.styleable.StateSet_defaultState
            if (r4 != r5) goto L22
            int r5 = r8.mDefaultState
            int r4 = r0.getResourceId(r4, r5)
            r8.mDefaultState = r4
        L22:
            int r3 = r3 + 1
            goto L10
        L25:
            int r0 = r10.getEventType()     // Catch: java.io.IOException -> Lba org.xmlpull.v1.XmlPullParserException -> Lbf
            r1 = 0
        L2a:
            r3 = 1
            if (r0 == r3) goto Lc3
            if (r0 == 0) goto Lb1
            java.lang.String r4 = "StateSet"
            r5 = 3
            r6 = 2
            if (r0 == r6) goto L44
            if (r0 == r5) goto L39
            goto Lb4
        L39:
            java.lang.String r0 = r10.getName()     // Catch: java.io.IOException -> Lba org.xmlpull.v1.XmlPullParserException -> Lbf
            boolean r0 = r4.equals(r0)     // Catch: java.io.IOException -> Lba org.xmlpull.v1.XmlPullParserException -> Lbf
            if (r0 == 0) goto Lb4
            return
        L44:
            java.lang.String r0 = r10.getName()     // Catch: java.io.IOException -> Lba org.xmlpull.v1.XmlPullParserException -> Lbf
            int r7 = r0.hashCode()     // Catch: java.io.IOException -> Lba org.xmlpull.v1.XmlPullParserException -> Lbf
            switch(r7) {
                case 80204913: goto L6c;
                case 1301459538: goto L62;
                case 1382829617: goto L5a;
                case 1901439077: goto L50;
                default: goto L4f;
            }     // Catch: java.io.IOException -> Lba org.xmlpull.v1.XmlPullParserException -> Lbf
        L4f:
            goto L76
        L50:
            java.lang.String r4 = "Variant"
            boolean r4 = r0.equals(r4)     // Catch: java.io.IOException -> Lba org.xmlpull.v1.XmlPullParserException -> Lbf
            if (r4 == 0) goto L76
            r4 = r5
            goto L77
        L5a:
            boolean r4 = r0.equals(r4)     // Catch: java.io.IOException -> Lba org.xmlpull.v1.XmlPullParserException -> Lbf
            if (r4 == 0) goto L76
            r4 = r3
            goto L77
        L62:
            java.lang.String r4 = "LayoutDescription"
            boolean r4 = r0.equals(r4)     // Catch: java.io.IOException -> Lba org.xmlpull.v1.XmlPullParserException -> Lbf
            if (r4 == 0) goto L76
            r4 = r2
            goto L77
        L6c:
            java.lang.String r4 = "State"
            boolean r4 = r0.equals(r4)     // Catch: java.io.IOException -> Lba org.xmlpull.v1.XmlPullParserException -> Lbf
            if (r4 == 0) goto L76
            r4 = r6
            goto L77
        L76:
            r4 = -1
        L77:
            if (r4 == 0) goto Lb4
            if (r4 == r3) goto Lb4
            if (r4 == r6) goto La4
            if (r4 == r5) goto L99
            java.lang.String r3 = "ConstraintLayoutStates"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.io.IOException -> Lba org.xmlpull.v1.XmlPullParserException -> Lbf
            r4.<init>()     // Catch: java.io.IOException -> Lba org.xmlpull.v1.XmlPullParserException -> Lbf
            java.lang.String r5 = "unknown tag "
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.io.IOException -> Lba org.xmlpull.v1.XmlPullParserException -> Lbf
            java.lang.StringBuilder r0 = r4.append(r0)     // Catch: java.io.IOException -> Lba org.xmlpull.v1.XmlPullParserException -> Lbf
            java.lang.String r0 = r0.toString()     // Catch: java.io.IOException -> Lba org.xmlpull.v1.XmlPullParserException -> Lbf
            android.util.Log.v(r3, r0)     // Catch: java.io.IOException -> Lba org.xmlpull.v1.XmlPullParserException -> Lbf
            goto Lb4
        L99:
            androidx.constraintlayout.widget.StateSet$Variant r0 = new androidx.constraintlayout.widget.StateSet$Variant     // Catch: java.io.IOException -> Lba org.xmlpull.v1.XmlPullParserException -> Lbf
            r0.<init>(r9, r10)     // Catch: java.io.IOException -> Lba org.xmlpull.v1.XmlPullParserException -> Lbf
            if (r1 == 0) goto Lb4
            r1.add(r0)     // Catch: java.io.IOException -> Lba org.xmlpull.v1.XmlPullParserException -> Lbf
            goto Lb4
        La4:
            androidx.constraintlayout.widget.StateSet$State r1 = new androidx.constraintlayout.widget.StateSet$State     // Catch: java.io.IOException -> Lba org.xmlpull.v1.XmlPullParserException -> Lbf
            r1.<init>(r9, r10)     // Catch: java.io.IOException -> Lba org.xmlpull.v1.XmlPullParserException -> Lbf
            android.util.SparseArray<androidx.constraintlayout.widget.StateSet$State> r0 = r8.mStateList     // Catch: java.io.IOException -> Lba org.xmlpull.v1.XmlPullParserException -> Lbf
            int r3 = r1.mId     // Catch: java.io.IOException -> Lba org.xmlpull.v1.XmlPullParserException -> Lbf
            r0.put(r3, r1)     // Catch: java.io.IOException -> Lba org.xmlpull.v1.XmlPullParserException -> Lbf
            goto Lb4
        Lb1:
            r10.getName()     // Catch: java.io.IOException -> Lba org.xmlpull.v1.XmlPullParserException -> Lbf
        Lb4:
            int r0 = r10.next()     // Catch: java.io.IOException -> Lba org.xmlpull.v1.XmlPullParserException -> Lbf
            goto L2a
        Lba:
            r9 = move-exception
            r9.printStackTrace()
            goto Lc3
        Lbf:
            r9 = move-exception
            r9.printStackTrace()
        Lc3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.StateSet.load(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }

    public boolean needsToChange(int i, float f, float f2) {
        int i2 = this.mCurrentStateId;
        if (i2 != i) {
            return true;
        }
        State stateValueAt = i == -1 ? this.mStateList.valueAt(0) : this.mStateList.get(i2);
        return (this.mCurrentConstraintNumber == -1 || !stateValueAt.mVariants.get(this.mCurrentConstraintNumber).match(f, f2)) && this.mCurrentConstraintNumber != stateValueAt.findMatch(f, f2);
    }

    public void setOnConstraintsChanged(ConstraintsChangedListener constraintsChangedListener) {
        this.mConstraintsChangedListener = constraintsChangedListener;
    }

    public int stateGetConstraintID(int i, int i2, int i3) {
        return updateConstraints(-1, i, i2, i3);
    }

    public int convertToConstraintSet(int i, int i2, float f, float f2) {
        State state = this.mStateList.get(i2);
        if (state == null) {
            return i2;
        }
        if (f == -1.0f || f2 == -1.0f) {
            if (state.mConstraintID == i) {
                return i;
            }
            Iterator<Variant> it = state.mVariants.iterator();
            while (it.hasNext()) {
                if (i == it.next().mConstraintID) {
                    return i;
                }
            }
            return state.mConstraintID;
        }
        Iterator<Variant> it2 = state.mVariants.iterator();
        Variant variant = null;
        while (it2.hasNext()) {
            Variant next = it2.next();
            if (next.match(f, f2)) {
                if (i == next.mConstraintID) {
                    return i;
                }
                variant = next;
            }
        }
        if (variant != null) {
            return variant.mConstraintID;
        }
        return state.mConstraintID;
    }

    public int updateConstraints(int i, int i2, float f, float f2) {
        State stateValueAt;
        int iFindMatch;
        if (i != i2) {
            State state = this.mStateList.get(i2);
            if (state == null) {
                return -1;
            }
            int iFindMatch2 = state.findMatch(f, f2);
            return iFindMatch2 == -1 ? state.mConstraintID : state.mVariants.get(iFindMatch2).mConstraintID;
        }
        if (i2 == -1) {
            stateValueAt = this.mStateList.valueAt(0);
        } else {
            stateValueAt = this.mStateList.get(this.mCurrentStateId);
        }
        if (stateValueAt == null) {
            return -1;
        }
        return ((this.mCurrentConstraintNumber == -1 || !stateValueAt.mVariants.get(i).match(f, f2)) && i != (iFindMatch = stateValueAt.findMatch(f, f2))) ? iFindMatch == -1 ? stateValueAt.mConstraintID : stateValueAt.mVariants.get(iFindMatch).mConstraintID : i;
    }

    static class State {
        int mConstraintID;
        int mId;
        boolean mIsLayout;
        ArrayList<Variant> mVariants = new ArrayList<>();

        public State(Context context, XmlPullParser xmlPullParser) throws Resources.NotFoundException {
            this.mConstraintID = -1;
            this.mIsLayout = false;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.State);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == R.styleable.State_android_id) {
                    this.mId = typedArrayObtainStyledAttributes.getResourceId(index, this.mId);
                } else if (index == R.styleable.State_constraints) {
                    this.mConstraintID = typedArrayObtainStyledAttributes.getResourceId(index, this.mConstraintID);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.mConstraintID);
                    context.getResources().getResourceName(this.mConstraintID);
                    if ("layout".equals(resourceTypeName)) {
                        this.mIsLayout = true;
                    }
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        void add(Variant variant) {
            this.mVariants.add(variant);
        }

        public int findMatch(float f, float f2) {
            for (int i = 0; i < this.mVariants.size(); i++) {
                if (this.mVariants.get(i).match(f, f2)) {
                    return i;
                }
            }
            return -1;
        }
    }

    static class Variant {
        int mConstraintID;
        int mId;
        boolean mIsLayout;
        float mMaxHeight;
        float mMaxWidth;
        float mMinHeight;
        float mMinWidth;

        public Variant(Context context, XmlPullParser xmlPullParser) throws Resources.NotFoundException {
            this.mMinWidth = Float.NaN;
            this.mMinHeight = Float.NaN;
            this.mMaxWidth = Float.NaN;
            this.mMaxHeight = Float.NaN;
            this.mConstraintID = -1;
            this.mIsLayout = false;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.Variant);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == R.styleable.Variant_constraints) {
                    this.mConstraintID = typedArrayObtainStyledAttributes.getResourceId(index, this.mConstraintID);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.mConstraintID);
                    context.getResources().getResourceName(this.mConstraintID);
                    if ("layout".equals(resourceTypeName)) {
                        this.mIsLayout = true;
                    }
                } else if (index == R.styleable.Variant_region_heightLessThan) {
                    this.mMaxHeight = typedArrayObtainStyledAttributes.getDimension(index, this.mMaxHeight);
                } else if (index == R.styleable.Variant_region_heightMoreThan) {
                    this.mMinHeight = typedArrayObtainStyledAttributes.getDimension(index, this.mMinHeight);
                } else if (index == R.styleable.Variant_region_widthLessThan) {
                    this.mMaxWidth = typedArrayObtainStyledAttributes.getDimension(index, this.mMaxWidth);
                } else if (index == R.styleable.Variant_region_widthMoreThan) {
                    this.mMinWidth = typedArrayObtainStyledAttributes.getDimension(index, this.mMinWidth);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        boolean match(float f, float f2) {
            if (!Float.isNaN(this.mMinWidth) && f < this.mMinWidth) {
                return false;
            }
            if (!Float.isNaN(this.mMinHeight) && f2 < this.mMinHeight) {
                return false;
            }
            if (Float.isNaN(this.mMaxWidth) || f <= this.mMaxWidth) {
                return Float.isNaN(this.mMaxHeight) || f2 <= this.mMaxHeight;
            }
            return false;
        }
    }
}
