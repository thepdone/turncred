package expo.modules;

import expo.modules.adapters.react.ReactAdapterPackage;
import expo.modules.application.ApplicationModule;
import expo.modules.asset.AssetModule;
import expo.modules.backgroundfetch.BackgroundFetchModule;
import expo.modules.blur.BlurModule;
import expo.modules.brightness.BrightnessModule;
import expo.modules.camera.CameraViewModule;
import expo.modules.clipboard.ClipboardModule;
import expo.modules.constants.ConstantsModule;
import expo.modules.constants.ConstantsPackage;
import expo.modules.contacts.ContactsModule;
import expo.modules.core.BasePackage;
import expo.modules.core.interfaces.Package;
import expo.modules.crypto.CryptoModule;
import expo.modules.device.DeviceModule;
import expo.modules.documentpicker.DocumentPickerModule;
import expo.modules.fetch.ExpoFetchModule;
import expo.modules.filesystem.FileSystemModule;
import expo.modules.filesystem.FileSystemPackage;
import expo.modules.filesystem.next.FileSystemNextModule;
import expo.modules.font.FontLoaderModule;
import expo.modules.image.ExpoImageModule;
import expo.modules.imageloader.ImageLoaderPackage;
import expo.modules.imagemanipulator.ImageManipulatorModule;
import expo.modules.imagepicker.ImagePickerModule;
import expo.modules.intentlauncher.IntentLauncherModule;
import expo.modules.keepawake.KeepAwakeModule;
import expo.modules.keepawake.KeepAwakePackage;
import expo.modules.kotlin.ModulesProvider;
import expo.modules.kotlin.modules.Module;
import expo.modules.lineargradient.LinearGradientModule;
import expo.modules.linking.ExpoLinkingModule;
import expo.modules.linking.ExpoLinkingPackage;
import expo.modules.localauthentication.LocalAuthenticationModule;
import expo.modules.localization.LocalizationModule;
import expo.modules.localization.LocalizationPackage;
import expo.modules.material3theme.ExpoMaterial3ThemeModule;
import expo.modules.medialibrary.MediaLibraryModule;
import expo.modules.notifications.NotificationsPackage;
import expo.modules.notifications.badge.BadgeModule;
import expo.modules.notifications.notifications.background.ExpoBackgroundNotificationTasksModule;
import expo.modules.notifications.notifications.categories.ExpoNotificationCategoriesModule;
import expo.modules.notifications.notifications.channels.NotificationChannelGroupManagerModule;
import expo.modules.notifications.notifications.channels.NotificationChannelManagerModule;
import expo.modules.notifications.notifications.emitting.NotificationsEmitter;
import expo.modules.notifications.notifications.handling.NotificationsHandler;
import expo.modules.notifications.notifications.presentation.ExpoNotificationPresentationModule;
import expo.modules.notifications.notifications.scheduling.NotificationScheduler;
import expo.modules.notifications.permissions.NotificationPermissionsModule;
import expo.modules.notifications.serverregistration.ServerRegistrationModule;
import expo.modules.notifications.tokens.PushTokenModule;
import expo.modules.sharing.SharingModule;
import expo.modules.splashscreen.SplashScreenModule;
import expo.modules.storereview.StoreReviewModule;
import expo.modules.systemui.SystemUIModule;
import expo.modules.systemui.SystemUIPackage;
import expo.modules.taskManager.TaskManagerModule;
import expo.modules.taskManager.TaskManagerPackage;
import expo.modules.trackingtransparency.TrackingTransparencyModule;
import expo.modules.webbrowser.WebBrowserModule;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes5.dex */
public class ExpoModulesPackageList implements ModulesProvider {

    private static class LazyHolder {
        static final List<Package> packagesList = Arrays.asList(new ReactAdapterPackage(), new ConstantsPackage(), new BasePackage(), new FileSystemPackage(), new ImageLoaderPackage(), new KeepAwakePackage(), new ExpoLinkingPackage(), new LocalizationPackage(), new NotificationsPackage(), new SystemUIPackage(), new TaskManagerPackage());
        static final List<Class<? extends Module>> modulesList = Arrays.asList(ExpoMaterial3ThemeModule.class, ExpoFetchModule.class, ApplicationModule.class, AssetModule.class, BackgroundFetchModule.class, BlurModule.class, BrightnessModule.class, CameraViewModule.class, ClipboardModule.class, ConstantsModule.class, ContactsModule.class, CryptoModule.class, DeviceModule.class, DocumentPickerModule.class, FileSystemModule.class, FileSystemNextModule.class, FontLoaderModule.class, ExpoImageModule.class, ImageManipulatorModule.class, ImagePickerModule.class, IntentLauncherModule.class, KeepAwakeModule.class, LinearGradientModule.class, ExpoLinkingModule.class, LocalAuthenticationModule.class, LocalizationModule.class, MediaLibraryModule.class, BadgeModule.class, ExpoBackgroundNotificationTasksModule.class, ExpoNotificationCategoriesModule.class, NotificationChannelGroupManagerModule.class, NotificationChannelManagerModule.class, NotificationsEmitter.class, NotificationsHandler.class, NotificationPermissionsModule.class, ExpoNotificationPresentationModule.class, NotificationScheduler.class, ServerRegistrationModule.class, PushTokenModule.class, SharingModule.class, SplashScreenModule.class, StoreReviewModule.class, SystemUIModule.class, TaskManagerModule.class, TrackingTransparencyModule.class, WebBrowserModule.class);

        private LazyHolder() {
        }
    }

    public static List<Package> getPackageList() {
        return LazyHolder.packagesList;
    }

    @Override // expo.modules.kotlin.ModulesProvider
    public List<Class<? extends Module>> getModulesList() {
        return LazyHolder.modulesList;
    }
}
