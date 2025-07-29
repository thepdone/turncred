package expo.modules.interfaces.barcodescanner;

import java.util.List;

/* loaded from: classes5.dex */
public class BarCodeScannerResult {
    private List<Integer> mCornerPoints;
    private String mRaw;
    private int mReferenceImageHeight;
    private int mReferenceImageWidth;
    private int mType;
    private String mValue;

    public static class BoundingBox {
        private final int height;
        private final int width;
        private final int x;
        private final int y;

        public BoundingBox(int i, int i2, int i3, int i4) {
            this.x = i;
            this.y = i2;
            this.width = i3;
            this.height = i4;
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }

        public int getWidth() {
            return this.width;
        }

        public int getHeight() {
            return this.height;
        }
    }

    public BarCodeScannerResult(int i, String str, String str2, List<Integer> list, int i2, int i3) {
        this.mType = i;
        this.mValue = str;
        this.mRaw = str2;
        this.mCornerPoints = list;
        this.mReferenceImageHeight = i2;
        this.mReferenceImageWidth = i3;
    }

    public int getType() {
        return this.mType;
    }

    public String getValue() {
        return this.mValue;
    }

    public String getRaw() {
        return this.mRaw;
    }

    public List<Integer> getCornerPoints() {
        return this.mCornerPoints;
    }

    public void setCornerPoints(List<Integer> list) {
        this.mCornerPoints = list;
    }

    public int getReferenceImageHeight() {
        return this.mReferenceImageHeight;
    }

    public void setReferenceImageHeight(int i) {
        this.mReferenceImageHeight = i;
    }

    public int getReferenceImageWidth() {
        return this.mReferenceImageWidth;
    }

    public void setReferenceImageWidth(int i) {
        this.mReferenceImageWidth = i;
    }

    public BoundingBox getBoundingBox() {
        if (this.mCornerPoints.isEmpty()) {
            return new BoundingBox(0, 0, 0, 0);
        }
        int iMax = Integer.MIN_VALUE;
        int iMin = Integer.MAX_VALUE;
        int iMin2 = Integer.MAX_VALUE;
        int iMax2 = Integer.MIN_VALUE;
        for (int i = 0; i < this.mCornerPoints.size(); i += 2) {
            int iIntValue = this.mCornerPoints.get(i).intValue();
            int iIntValue2 = this.mCornerPoints.get(i + 1).intValue();
            iMin = Integer.min(iMin, iIntValue);
            iMin2 = Integer.min(iMin2, iIntValue2);
            iMax = Integer.max(iMax, iIntValue);
            iMax2 = Integer.max(iMax2, iIntValue2);
        }
        return new BoundingBox(iMin, iMin2, iMax - iMin, iMax2 - iMin2);
    }
}
