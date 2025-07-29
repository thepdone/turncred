package expo.modules.apploader;

import expo.modules.core.interfaces.Package;
import java.util.List;

/* loaded from: classes5.dex */
public interface AppLoaderPackagesProviderInterface<ReactPackageType> {
    List<Package> getExpoPackages();

    List<ReactPackageType> getPackages();
}
