package androidx.camera.core.internal;

import android.util.Pair;
import android.util.Rational;
import android.util.Size;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.utils.AspectRatioUtil;
import androidx.camera.core.impl.utils.CameraOrientationUtil;
import androidx.camera.core.impl.utils.CompareSizesByArea;
import androidx.camera.core.internal.utils.SizeUtil;
import androidx.camera.core.resolutionselector.AspectRatioStrategy;
import androidx.camera.core.resolutionselector.ResolutionFilter;
import androidx.camera.core.resolutionselector.ResolutionSelector;
import androidx.camera.core.resolutionselector.ResolutionStrategy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class SupportedOutputSizesSorter {
    private static final String TAG = "SupportedOutputSizesCollector";
    private final CameraInfoInternal mCameraInfoInternal;
    private final Rational mFullFovRatio;
    private final int mLensFacing;
    private final int mSensorOrientation;
    private final SupportedOutputSizesSorterLegacy mSupportedOutputSizesSorterLegacy;

    public SupportedOutputSizesSorter(CameraInfoInternal cameraInfoInternal, Size size) {
        Rational rationalCalculateFullFovRatioFromSupportedOutputSizes;
        this.mCameraInfoInternal = cameraInfoInternal;
        this.mSensorOrientation = cameraInfoInternal.getSensorRotationDegrees();
        this.mLensFacing = cameraInfoInternal.getLensFacing();
        if (size != null) {
            rationalCalculateFullFovRatioFromSupportedOutputSizes = calculateFullFovRatioFromActiveArraySize(size);
        } else {
            rationalCalculateFullFovRatioFromSupportedOutputSizes = calculateFullFovRatioFromSupportedOutputSizes(cameraInfoInternal);
        }
        this.mFullFovRatio = rationalCalculateFullFovRatioFromSupportedOutputSizes;
        this.mSupportedOutputSizesSorterLegacy = new SupportedOutputSizesSorterLegacy(cameraInfoInternal, rationalCalculateFullFovRatioFromSupportedOutputSizes);
    }

    private Rational calculateFullFovRatioFromActiveArraySize(Size size) {
        return new Rational(size.getWidth(), size.getHeight());
    }

    private Rational calculateFullFovRatioFromSupportedOutputSizes(CameraInfoInternal cameraInfoInternal) {
        List<Size> supportedResolutions = cameraInfoInternal.getSupportedResolutions(256);
        if (supportedResolutions.isEmpty()) {
            return null;
        }
        Size size = (Size) Collections.max(supportedResolutions, new CompareSizesByArea());
        return new Rational(size.getWidth(), size.getHeight());
    }

    public List<Size> getSortedSupportedOutputSizes(UseCaseConfig<?> useCaseConfig) {
        ImageOutputConfig imageOutputConfig = (ImageOutputConfig) useCaseConfig;
        List<Size> customOrderedResolutions = imageOutputConfig.getCustomOrderedResolutions(null);
        if (customOrderedResolutions != null) {
            return customOrderedResolutions;
        }
        ResolutionSelector resolutionSelector = imageOutputConfig.getResolutionSelector(null);
        List<Size> resolutionCandidateList = getResolutionCandidateList(imageOutputConfig.getSupportedResolutions(null), useCaseConfig.getInputFormat());
        if (resolutionSelector == null) {
            return this.mSupportedOutputSizesSorterLegacy.sortSupportedOutputSizes(resolutionCandidateList, useCaseConfig);
        }
        Size maxResolution = imageOutputConfig.getMaxResolution(null);
        int targetRotation = imageOutputConfig.getTargetRotation(0);
        if (!useCaseConfig.isHighResolutionDisabled(false)) {
            resolutionCandidateList = applyHighResolutionSettings(resolutionCandidateList, resolutionSelector, useCaseConfig.getInputFormat());
        }
        return sortSupportedOutputSizesByResolutionSelector(imageOutputConfig.getResolutionSelector(), resolutionCandidateList, maxResolution, targetRotation, this.mFullFovRatio, this.mSensorOrientation, this.mLensFacing);
    }

    private List<Size> getSizeListByFormat(List<Pair<Integer, Size[]>> list, int i) {
        Size[] sizeArr;
        if (list != null) {
            for (Pair<Integer, Size[]> pair : list) {
                if (((Integer) pair.first).intValue() == i) {
                    sizeArr = (Size[]) pair.second;
                    break;
                }
            }
            sizeArr = null;
        } else {
            sizeArr = null;
        }
        if (sizeArr == null) {
            return null;
        }
        return Arrays.asList(sizeArr);
    }

    public static List<Size> sortSupportedOutputSizesByResolutionSelector(ResolutionSelector resolutionSelector, List<Size> list, Size size, int i, Rational rational, int i2, int i3) {
        LinkedHashMap<Rational, List<Size>> linkedHashMapApplyAspectRatioStrategy = applyAspectRatioStrategy(list, resolutionSelector.getAspectRatioStrategy(), rational);
        if (size != null) {
            applyMaxResolutionRestriction(linkedHashMapApplyAspectRatioStrategy, size);
        }
        applyResolutionStrategy(linkedHashMapApplyAspectRatioStrategy, resolutionSelector.getResolutionStrategy());
        ArrayList arrayList = new ArrayList();
        Iterator<List<Size>> it = linkedHashMapApplyAspectRatioStrategy.values().iterator();
        while (it.hasNext()) {
            for (Size size2 : it.next()) {
                if (!arrayList.contains(size2)) {
                    arrayList.add(size2);
                }
            }
        }
        return applyResolutionFilter(arrayList, resolutionSelector.getResolutionFilter(), i, i2, i3);
    }

    private List<Size> getResolutionCandidateList(List<Pair<Integer, Size[]>> list, int i) {
        List<Size> sizeListByFormat = getSizeListByFormat(list, i);
        if (sizeListByFormat == null) {
            sizeListByFormat = this.mCameraInfoInternal.getSupportedResolutions(i);
        }
        ArrayList arrayList = new ArrayList(sizeListByFormat);
        Collections.sort(arrayList, new CompareSizesByArea(true));
        if (arrayList.isEmpty()) {
            Logger.w(TAG, "The retrieved supported resolutions from camera info internal is empty. Format is " + i + ".");
        }
        return arrayList;
    }

    private List<Size> applyHighResolutionSettings(List<Size> list, ResolutionSelector resolutionSelector, int i) {
        if (resolutionSelector.getAllowedResolutionMode() != 1) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        arrayList.addAll(this.mCameraInfoInternal.getSupportedHighResolutions(i));
        Collections.sort(arrayList, new CompareSizesByArea(true));
        return arrayList;
    }

    private static LinkedHashMap<Rational, List<Size>> applyAspectRatioStrategy(List<Size> list, AspectRatioStrategy aspectRatioStrategy, Rational rational) {
        return applyAspectRatioStrategyFallbackRule(groupSizesByAspectRatio(list), aspectRatioStrategy, rational);
    }

    private static LinkedHashMap<Rational, List<Size>> applyAspectRatioStrategyFallbackRule(Map<Rational, List<Size>> map, AspectRatioStrategy aspectRatioStrategy, Rational rational) {
        boolean z = true;
        if (rational != null && rational.getNumerator() < rational.getDenominator()) {
            z = false;
        }
        Rational targetAspectRatioRationalValue = getTargetAspectRatioRationalValue(aspectRatioStrategy.getPreferredAspectRatio(), z);
        if (aspectRatioStrategy.getFallbackRule() == 0) {
            Rational targetAspectRatioRationalValue2 = getTargetAspectRatioRationalValue(aspectRatioStrategy.getPreferredAspectRatio(), z);
            Iterator it = new ArrayList(map.keySet()).iterator();
            while (it.hasNext()) {
                Rational rational2 = (Rational) it.next();
                if (!rational2.equals(targetAspectRatioRationalValue2)) {
                    map.remove(rational2);
                }
            }
        }
        ArrayList<Rational> arrayList = new ArrayList(map.keySet());
        Collections.sort(arrayList, new AspectRatioUtil.CompareAspectRatiosByMappingAreaInFullFovAspectRatioSpace(targetAspectRatioRationalValue, rational));
        LinkedHashMap<Rational, List<Size>> linkedHashMap = new LinkedHashMap<>();
        for (Rational rational3 : arrayList) {
            linkedHashMap.put(rational3, map.get(rational3));
        }
        return linkedHashMap;
    }

    private static void applyResolutionStrategy(LinkedHashMap<Rational, List<Size>> linkedHashMap, ResolutionStrategy resolutionStrategy) {
        if (resolutionStrategy == null) {
            return;
        }
        Iterator<Rational> it = linkedHashMap.keySet().iterator();
        while (it.hasNext()) {
            applyResolutionStrategyFallbackRule(linkedHashMap.get(it.next()), resolutionStrategy);
        }
    }

    private static void applyResolutionStrategyFallbackRule(List<Size> list, ResolutionStrategy resolutionStrategy) {
        if (list.isEmpty()) {
            return;
        }
        Integer numValueOf = Integer.valueOf(resolutionStrategy.getFallbackRule());
        if (resolutionStrategy.equals(ResolutionStrategy.HIGHEST_AVAILABLE_STRATEGY)) {
            return;
        }
        Size boundSize = resolutionStrategy.getBoundSize();
        int iIntValue = numValueOf.intValue();
        if (iIntValue == 0) {
            sortSupportedSizesByFallbackRuleNone(list, boundSize);
            return;
        }
        if (iIntValue == 1) {
            sortSupportedSizesByFallbackRuleClosestHigherThenLower(list, boundSize, true);
            return;
        }
        if (iIntValue == 2) {
            sortSupportedSizesByFallbackRuleClosestHigherThenLower(list, boundSize, false);
        } else if (iIntValue == 3) {
            sortSupportedSizesByFallbackRuleClosestLowerThenHigher(list, boundSize, true);
        } else {
            if (iIntValue != 4) {
                return;
            }
            sortSupportedSizesByFallbackRuleClosestLowerThenHigher(list, boundSize, false);
        }
    }

    private static void applyMaxResolutionRestriction(LinkedHashMap<Rational, List<Size>> linkedHashMap, Size size) {
        int area = SizeUtil.getArea(size);
        Iterator<Rational> it = linkedHashMap.keySet().iterator();
        while (it.hasNext()) {
            List<Size> list = linkedHashMap.get(it.next());
            ArrayList arrayList = new ArrayList();
            for (Size size2 : list) {
                if (SizeUtil.getArea(size2) <= area) {
                    arrayList.add(size2);
                }
            }
            list.clear();
            list.addAll(arrayList);
        }
    }

    private static List<Size> applyResolutionFilter(List<Size> list, ResolutionFilter resolutionFilter, int i, int i2, int i3) {
        if (resolutionFilter == null) {
            return list;
        }
        List<Size> listFilter = resolutionFilter.filter(new ArrayList(list), CameraOrientationUtil.getRelativeImageRotation(CameraOrientationUtil.surfaceRotationToDegrees(i), i2, i3 == 1));
        if (list.containsAll(listFilter)) {
            return listFilter;
        }
        throw new IllegalArgumentException("The returned sizes list of the resolution filter must be a subset of the provided sizes list.");
    }

    private static void sortSupportedSizesByFallbackRuleNone(List<Size> list, Size size) {
        boolean zContains = list.contains(size);
        list.clear();
        if (zContains) {
            list.add(size);
        }
    }

    static void sortSupportedSizesByFallbackRuleClosestHigherThenLower(List<Size> list, Size size, boolean z) {
        ArrayList arrayList = new ArrayList();
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            Size size3 = list.get(size2);
            if (size3.getWidth() >= size.getWidth() && size3.getHeight() >= size.getHeight()) {
                break;
            }
            arrayList.add(0, size3);
        }
        list.removeAll(arrayList);
        Collections.reverse(list);
        if (z) {
            list.addAll(arrayList);
        }
    }

    private static void sortSupportedSizesByFallbackRuleClosestLowerThenHigher(List<Size> list, Size size, boolean z) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            Size size2 = list.get(i);
            if (size2.getWidth() <= size.getWidth() && size2.getHeight() <= size.getHeight()) {
                break;
            }
            arrayList.add(0, size2);
        }
        list.removeAll(arrayList);
        if (z) {
            list.addAll(arrayList);
        }
    }

    static Rational getTargetAspectRatioRationalValue(int i, boolean z) {
        if (i != -1) {
            if (i == 0) {
                if (z) {
                    return AspectRatioUtil.ASPECT_RATIO_4_3;
                }
                return AspectRatioUtil.ASPECT_RATIO_3_4;
            }
            if (i == 1) {
                if (z) {
                    return AspectRatioUtil.ASPECT_RATIO_16_9;
                }
                return AspectRatioUtil.ASPECT_RATIO_9_16;
            }
            Logger.e(TAG, "Undefined target aspect ratio: " + i);
        }
        return null;
    }

    static List<Rational> getResolutionListGroupingAspectRatioKeys(List<Size> list) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(AspectRatioUtil.ASPECT_RATIO_4_3);
        arrayList.add(AspectRatioUtil.ASPECT_RATIO_16_9);
        for (Size size : list) {
            Rational rational = new Rational(size.getWidth(), size.getHeight());
            if (!arrayList.contains(rational)) {
                Iterator it = arrayList.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (AspectRatioUtil.hasMatchingAspectRatio(size, (Rational) it.next())) {
                            break;
                        }
                    } else {
                        arrayList.add(rational);
                        break;
                    }
                }
            }
        }
        return arrayList;
    }

    static Map<Rational, List<Size>> groupSizesByAspectRatio(List<Size> list) {
        HashMap map = new HashMap();
        Iterator<Rational> it = getResolutionListGroupingAspectRatioKeys(list).iterator();
        while (it.hasNext()) {
            map.put(it.next(), new ArrayList());
        }
        for (Size size : list) {
            for (Rational rational : map.keySet()) {
                if (AspectRatioUtil.hasMatchingAspectRatio(size, rational)) {
                    ((List) map.get(rational)).add(size);
                }
            }
        }
        return map;
    }
}
