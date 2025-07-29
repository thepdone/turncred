package me.leolin.shortcutbadger.impl;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Build;
import expo.modules.notifications.service.NotificationsService;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import me.leolin.shortcutbadger.Badger;
import me.leolin.shortcutbadger.ShortcutBadgeException;
import me.leolin.shortcutbadger.util.BroadcastHelper;

@Deprecated
/* loaded from: classes2.dex */
public class XiaomiHomeBadger implements Badger {
    public static final String EXTRA_UPDATE_APP_COMPONENT_NAME = "android.intent.extra.update_application_component_name";
    public static final String EXTRA_UPDATE_APP_MSG_TEXT = "android.intent.extra.update_application_message_text";
    public static final String INTENT_ACTION = "android.intent.action.APPLICATION_MESSAGE_UPDATE";
    private ResolveInfo resolveInfo;

    @Override // me.leolin.shortcutbadger.Badger
    public void executeBadge(Context context, ComponentName componentName, int i) throws IllegalAccessException, ShortcutBadgeException, NoSuchFieldException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        Object objValueOf;
        Object objValueOf2 = "";
        try {
            Object objNewInstance = Class.forName("android.app.MiuiNotification").newInstance();
            Field declaredField = objNewInstance.getClass().getDeclaredField("messageCount");
            declaredField.setAccessible(true);
            if (i == 0) {
                objValueOf = "";
            } else {
                try {
                    objValueOf = Integer.valueOf(i);
                } catch (Exception unused) {
                    declaredField.set(objNewInstance, Integer.valueOf(i));
                }
            }
            declaredField.set(objNewInstance, String.valueOf(objValueOf));
        } catch (Exception unused2) {
            Intent intent = new Intent(INTENT_ACTION);
            intent.putExtra(EXTRA_UPDATE_APP_COMPONENT_NAME, componentName.getPackageName() + "/" + componentName.getClassName());
            if (i != 0) {
                objValueOf2 = Integer.valueOf(i);
            }
            intent.putExtra(EXTRA_UPDATE_APP_MSG_TEXT, String.valueOf(objValueOf2));
            try {
                BroadcastHelper.sendIntentExplicitly(context, intent);
            } catch (ShortcutBadgeException unused3) {
            }
        }
        if (Build.MANUFACTURER.equalsIgnoreCase("Xiaomi")) {
            tryNewMiuiBadge(context, i);
        }
    }

    private void tryNewMiuiBadge(Context context, int i) throws IllegalAccessException, ShortcutBadgeException, IllegalArgumentException, InvocationTargetException {
        if (this.resolveInfo == null) {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            this.resolveInfo = context.getPackageManager().resolveActivity(intent, 65536);
        }
        if (this.resolveInfo != null) {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(NotificationsService.NOTIFICATION_KEY);
            Notification notificationBuild = new Notification.Builder(context).setContentTitle("").setContentText("").setSmallIcon(this.resolveInfo.getIconResource()).build();
            try {
                Object obj = notificationBuild.getClass().getDeclaredField("extraNotification").get(notificationBuild);
                obj.getClass().getDeclaredMethod("setMessageCount", Integer.TYPE).invoke(obj, Integer.valueOf(i));
                notificationManager.notify(0, notificationBuild);
            } catch (Exception e) {
                throw new ShortcutBadgeException("not able to set badge", e);
            }
        }
    }

    @Override // me.leolin.shortcutbadger.Badger
    public List<String> getSupportLaunchers() {
        return Arrays.asList("com.miui.miuilite", "com.miui.home", "com.miui.miuihome", "com.miui.miuihome2", "com.miui.mihome", "com.miui.mihome2", "com.i.miui.launcher");
    }
}
