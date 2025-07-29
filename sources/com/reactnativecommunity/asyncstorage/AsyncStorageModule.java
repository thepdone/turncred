package com.reactnativecommunity.asyncstorage;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteStatement;
import android.os.AsyncTask;
import com.facebook.common.logging.FLog;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.common.ModuleDataCleaner;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.Executor;

@ReactModule(name = AsyncStorageModule.NAME)
/* loaded from: classes5.dex */
public final class AsyncStorageModule extends NativeAsyncStorageModuleSpec implements ModuleDataCleaner.Cleanable, LifecycleEventListener {
    private static final int MAX_SQL_KEYS = 999;
    public static final String NAME = "RNCAsyncStorage";
    private final SerialExecutor executor;
    private ReactDatabaseSupplier mReactDatabaseSupplier;
    private boolean mShuttingDown;

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostPause() {
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostResume() {
    }

    public AsyncStorageModule(ReactApplicationContext reactApplicationContext) {
        this(reactApplicationContext, AsyncTask.THREAD_POOL_EXECUTOR);
    }

    @VisibleForTesting
    AsyncStorageModule(ReactApplicationContext reactApplicationContext, Executor executor) throws Throwable {
        super(reactApplicationContext);
        this.mShuttingDown = false;
        AsyncStorageExpoMigration.migrate(reactApplicationContext);
        this.executor = new SerialExecutor(executor);
        reactApplicationContext.addLifecycleEventListener(this);
        this.mReactDatabaseSupplier = ReactDatabaseSupplier.getInstance(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void initialize() {
        super.initialize();
        this.mShuttingDown = false;
    }

    @Override // com.facebook.react.bridge.NativeModule
    public void onCatalystInstanceDestroy() {
        this.mShuttingDown = true;
    }

    @Override // com.facebook.react.modules.common.ModuleDataCleaner.Cleanable
    public void clearSensitiveData() throws RuntimeException {
        this.mReactDatabaseSupplier.clearAndCloseDatabase();
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
        this.mReactDatabaseSupplier.closeDatabase();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.reactnativecommunity.asyncstorage.AsyncStorageModule$1] */
    @Override // com.reactnativecommunity.asyncstorage.NativeAsyncStorageModuleSpec
    @ReactMethod
    public void multiGet(final ReadableArray readableArray, final Callback callback) {
        if (readableArray == null) {
            callback.invoke(AsyncStorageErrorUtil.getInvalidKeyError(null), null);
        } else {
            new GuardedAsyncTask<Void, Void>(getReactApplicationContext()) { // from class: com.reactnativecommunity.asyncstorage.AsyncStorageModule.1
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.facebook.react.bridge.GuardedAsyncTask
                public void doInBackgroundGuarded(Void... voidArr) {
                    if (!AsyncStorageModule.this.ensureDatabase()) {
                        callback.invoke(AsyncStorageErrorUtil.getDBError(null), null);
                        return;
                    }
                    String[] strArr = {SDKConstants.PARAM_KEY, "value"};
                    HashSet hashSet = new HashSet();
                    WritableArray writableArrayCreateArray = Arguments.createArray();
                    for (int i = 0; i < readableArray.size(); i += AsyncStorageModule.MAX_SQL_KEYS) {
                        int iMin = Math.min(readableArray.size() - i, AsyncStorageModule.MAX_SQL_KEYS);
                        Cursor cursorQuery = AsyncStorageModule.this.mReactDatabaseSupplier.get().query("catalystLocalStorage", strArr, AsyncLocalStorageUtil.buildKeySelection(iMin), AsyncLocalStorageUtil.buildKeySelectionArgs(readableArray, i, iMin), null, null, null);
                        hashSet.clear();
                        try {
                            try {
                                if (cursorQuery.getCount() != readableArray.size()) {
                                    for (int i2 = i; i2 < i + iMin; i2++) {
                                        hashSet.add(readableArray.getString(i2));
                                    }
                                }
                                if (cursorQuery.moveToFirst()) {
                                    do {
                                        WritableArray writableArrayCreateArray2 = Arguments.createArray();
                                        writableArrayCreateArray2.pushString(cursorQuery.getString(0));
                                        writableArrayCreateArray2.pushString(cursorQuery.getString(1));
                                        writableArrayCreateArray.pushArray(writableArrayCreateArray2);
                                        hashSet.remove(cursorQuery.getString(0));
                                    } while (cursorQuery.moveToNext());
                                }
                                cursorQuery.close();
                                Iterator it = hashSet.iterator();
                                while (it.hasNext()) {
                                    String str = (String) it.next();
                                    WritableArray writableArrayCreateArray3 = Arguments.createArray();
                                    writableArrayCreateArray3.pushString(str);
                                    writableArrayCreateArray3.pushNull();
                                    writableArrayCreateArray.pushArray(writableArrayCreateArray3);
                                }
                                hashSet.clear();
                            } catch (Exception e) {
                                FLog.w("ReactNative", e.getMessage(), e);
                                callback.invoke(AsyncStorageErrorUtil.getError(null, e.getMessage()), null);
                                cursorQuery.close();
                                return;
                            }
                        } catch (Throwable th) {
                            cursorQuery.close();
                            throw th;
                        }
                    }
                    callback.invoke(null, writableArrayCreateArray);
                }
            }.executeOnExecutor(this.executor, new Void[0]);
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.reactnativecommunity.asyncstorage.AsyncStorageModule$2] */
    @Override // com.reactnativecommunity.asyncstorage.NativeAsyncStorageModuleSpec
    @ReactMethod
    public void multiSet(final ReadableArray readableArray, final Callback callback) {
        if (readableArray.size() == 0) {
            callback.invoke(new Object[0]);
        } else {
            new GuardedAsyncTask<Void, Void>(getReactApplicationContext()) { // from class: com.reactnativecommunity.asyncstorage.AsyncStorageModule.2
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.facebook.react.bridge.GuardedAsyncTask
                public void doInBackgroundGuarded(Void... voidArr) throws SQLException {
                    String str = null;
                    WritableMap error = null;
                    if (!AsyncStorageModule.this.ensureDatabase()) {
                        callback.invoke(AsyncStorageErrorUtil.getDBError(null));
                        return;
                    }
                    SQLiteStatement sQLiteStatementCompileStatement = AsyncStorageModule.this.mReactDatabaseSupplier.get().compileStatement("INSERT OR REPLACE INTO catalystLocalStorage VALUES (?, ?);");
                    try {
                        try {
                            AsyncStorageModule.this.mReactDatabaseSupplier.get().beginTransaction();
                            for (int i = 0; i < readableArray.size(); i++) {
                                if (readableArray.getArray(i).size() != 2) {
                                    WritableMap invalidValueError = AsyncStorageErrorUtil.getInvalidValueError(null);
                                    try {
                                        AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                                        return;
                                    } catch (Exception e) {
                                        FLog.w("ReactNative", e.getMessage(), e);
                                        if (invalidValueError == null) {
                                            AsyncStorageErrorUtil.getError(null, e.getMessage());
                                            return;
                                        }
                                        return;
                                    }
                                }
                                if (readableArray.getArray(i).getString(0) == null) {
                                    WritableMap invalidKeyError = AsyncStorageErrorUtil.getInvalidKeyError(null);
                                    try {
                                        AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                                        return;
                                    } catch (Exception e2) {
                                        FLog.w("ReactNative", e2.getMessage(), e2);
                                        if (invalidKeyError == null) {
                                            AsyncStorageErrorUtil.getError(null, e2.getMessage());
                                            return;
                                        }
                                        return;
                                    }
                                }
                                if (readableArray.getArray(i).getString(1) == null) {
                                    WritableMap invalidValueError2 = AsyncStorageErrorUtil.getInvalidValueError(null);
                                    try {
                                        AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                                        return;
                                    } catch (Exception e3) {
                                        FLog.w("ReactNative", e3.getMessage(), e3);
                                        if (invalidValueError2 == null) {
                                            AsyncStorageErrorUtil.getError(null, e3.getMessage());
                                            return;
                                        }
                                        return;
                                    }
                                }
                                sQLiteStatementCompileStatement.clearBindings();
                                sQLiteStatementCompileStatement.bindString(1, readableArray.getArray(i).getString(0));
                                sQLiteStatementCompileStatement.bindString(2, readableArray.getArray(i).getString(1));
                                sQLiteStatementCompileStatement.execute();
                            }
                            AsyncStorageModule.this.mReactDatabaseSupplier.get().setTransactionSuccessful();
                        } catch (Exception e4) {
                            FLog.w("ReactNative", e4.getMessage(), e4);
                            WritableMap error2 = AsyncStorageErrorUtil.getError(null, e4.getMessage());
                            try {
                                AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                            } catch (Exception e5) {
                                FLog.w("ReactNative", e5.getMessage(), e5);
                                if (error2 == null) {
                                    error = AsyncStorageErrorUtil.getError(null, e5.getMessage());
                                }
                            }
                            error = error2;
                        }
                        if (error != null) {
                            callback.invoke(error);
                        } else {
                            callback.invoke(new Object[0]);
                        }
                    } finally {
                        try {
                            AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                        } catch (Exception e6) {
                            FLog.w("ReactNative", e6.getMessage(), e6);
                            AsyncStorageErrorUtil.getError(null, e6.getMessage());
                        }
                    }
                }
            }.executeOnExecutor(this.executor, new Void[0]);
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.reactnativecommunity.asyncstorage.AsyncStorageModule$3] */
    @Override // com.reactnativecommunity.asyncstorage.NativeAsyncStorageModuleSpec
    @ReactMethod
    public void multiRemove(final ReadableArray readableArray, final Callback callback) {
        if (readableArray.size() == 0) {
            callback.invoke(new Object[0]);
        } else {
            new GuardedAsyncTask<Void, Void>(getReactApplicationContext()) { // from class: com.reactnativecommunity.asyncstorage.AsyncStorageModule.3
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.facebook.react.bridge.GuardedAsyncTask
                public void doInBackgroundGuarded(Void... voidArr) {
                    String str = null;
                    WritableMap error = null;
                    if (!AsyncStorageModule.this.ensureDatabase()) {
                        callback.invoke(AsyncStorageErrorUtil.getDBError(null));
                        return;
                    }
                    try {
                        try {
                            AsyncStorageModule.this.mReactDatabaseSupplier.get().beginTransaction();
                            for (int i = 0; i < readableArray.size(); i += AsyncStorageModule.MAX_SQL_KEYS) {
                                int iMin = Math.min(readableArray.size() - i, AsyncStorageModule.MAX_SQL_KEYS);
                                AsyncStorageModule.this.mReactDatabaseSupplier.get().delete("catalystLocalStorage", AsyncLocalStorageUtil.buildKeySelection(iMin), AsyncLocalStorageUtil.buildKeySelectionArgs(readableArray, i, iMin));
                            }
                            AsyncStorageModule.this.mReactDatabaseSupplier.get().setTransactionSuccessful();
                        } catch (Exception e) {
                            FLog.w("ReactNative", e.getMessage(), e);
                            WritableMap error2 = AsyncStorageErrorUtil.getError(null, e.getMessage());
                            try {
                                AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                            } catch (Exception e2) {
                                FLog.w("ReactNative", e2.getMessage(), e2);
                                if (error2 == null) {
                                    error = AsyncStorageErrorUtil.getError(null, e2.getMessage());
                                }
                            }
                            error = error2;
                        }
                        if (error != null) {
                            callback.invoke(error);
                        } else {
                            callback.invoke(new Object[0]);
                        }
                    } finally {
                        try {
                            AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                        } catch (Exception e3) {
                            FLog.w("ReactNative", e3.getMessage(), e3);
                            AsyncStorageErrorUtil.getError(null, e3.getMessage());
                        }
                    }
                }
            }.executeOnExecutor(this.executor, new Void[0]);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.reactnativecommunity.asyncstorage.AsyncStorageModule$4] */
    @Override // com.reactnativecommunity.asyncstorage.NativeAsyncStorageModuleSpec
    @ReactMethod
    public void multiMerge(final ReadableArray readableArray, final Callback callback) {
        new GuardedAsyncTask<Void, Void>(getReactApplicationContext()) { // from class: com.reactnativecommunity.asyncstorage.AsyncStorageModule.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.react.bridge.GuardedAsyncTask
            public void doInBackgroundGuarded(Void... voidArr) {
                String str = null;
                WritableMap error = null;
                if (!AsyncStorageModule.this.ensureDatabase()) {
                    callback.invoke(AsyncStorageErrorUtil.getDBError(null));
                    return;
                }
                try {
                    try {
                        AsyncStorageModule.this.mReactDatabaseSupplier.get().beginTransaction();
                        for (int i = 0; i < readableArray.size(); i++) {
                            if (readableArray.getArray(i).size() != 2) {
                                WritableMap invalidValueError = AsyncStorageErrorUtil.getInvalidValueError(null);
                                try {
                                    AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                                    return;
                                } catch (Exception e) {
                                    FLog.w("ReactNative", e.getMessage(), e);
                                    if (invalidValueError == null) {
                                        AsyncStorageErrorUtil.getError(null, e.getMessage());
                                        return;
                                    }
                                    return;
                                }
                            }
                            if (readableArray.getArray(i).getString(0) == null) {
                                WritableMap invalidKeyError = AsyncStorageErrorUtil.getInvalidKeyError(null);
                                try {
                                    AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                                    return;
                                } catch (Exception e2) {
                                    FLog.w("ReactNative", e2.getMessage(), e2);
                                    if (invalidKeyError == null) {
                                        AsyncStorageErrorUtil.getError(null, e2.getMessage());
                                        return;
                                    }
                                    return;
                                }
                            }
                            if (readableArray.getArray(i).getString(1) == null) {
                                WritableMap invalidValueError2 = AsyncStorageErrorUtil.getInvalidValueError(null);
                                try {
                                    AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                                    return;
                                } catch (Exception e3) {
                                    FLog.w("ReactNative", e3.getMessage(), e3);
                                    if (invalidValueError2 == null) {
                                        AsyncStorageErrorUtil.getError(null, e3.getMessage());
                                        return;
                                    }
                                    return;
                                }
                            }
                            if (!AsyncLocalStorageUtil.mergeImpl(AsyncStorageModule.this.mReactDatabaseSupplier.get(), readableArray.getArray(i).getString(0), readableArray.getArray(i).getString(1))) {
                                WritableMap dBError = AsyncStorageErrorUtil.getDBError(null);
                                try {
                                    AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                                    return;
                                } catch (Exception e4) {
                                    FLog.w("ReactNative", e4.getMessage(), e4);
                                    if (dBError == null) {
                                        AsyncStorageErrorUtil.getError(null, e4.getMessage());
                                        return;
                                    }
                                    return;
                                }
                            }
                        }
                        AsyncStorageModule.this.mReactDatabaseSupplier.get().setTransactionSuccessful();
                    } catch (Exception e5) {
                        FLog.w("ReactNative", e5.getMessage(), e5);
                        WritableMap error2 = AsyncStorageErrorUtil.getError(null, e5.getMessage());
                        try {
                            AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                        } catch (Exception e6) {
                            FLog.w("ReactNative", e6.getMessage(), e6);
                            if (error2 == null) {
                                error = AsyncStorageErrorUtil.getError(null, e6.getMessage());
                            }
                        }
                        error = error2;
                    }
                    if (error != null) {
                        callback.invoke(error);
                    } else {
                        callback.invoke(new Object[0]);
                    }
                } finally {
                    try {
                        AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                    } catch (Exception e7) {
                        FLog.w("ReactNative", e7.getMessage(), e7);
                        AsyncStorageErrorUtil.getError(null, e7.getMessage());
                    }
                }
            }
        }.executeOnExecutor(this.executor, new Void[0]);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.reactnativecommunity.asyncstorage.AsyncStorageModule$5] */
    @Override // com.reactnativecommunity.asyncstorage.NativeAsyncStorageModuleSpec
    @ReactMethod
    public void clear(final Callback callback) {
        new GuardedAsyncTask<Void, Void>(getReactApplicationContext()) { // from class: com.reactnativecommunity.asyncstorage.AsyncStorageModule.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.react.bridge.GuardedAsyncTask
            public void doInBackgroundGuarded(Void... voidArr) {
                if (!AsyncStorageModule.this.mReactDatabaseSupplier.ensureDatabase()) {
                    callback.invoke(AsyncStorageErrorUtil.getDBError(null));
                    return;
                }
                try {
                    AsyncStorageModule.this.mReactDatabaseSupplier.clear();
                    callback.invoke(new Object[0]);
                } catch (Exception e) {
                    FLog.w("ReactNative", e.getMessage(), e);
                    callback.invoke(AsyncStorageErrorUtil.getError(null, e.getMessage()));
                }
            }
        }.executeOnExecutor(this.executor, new Void[0]);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.reactnativecommunity.asyncstorage.AsyncStorageModule$6] */
    @Override // com.reactnativecommunity.asyncstorage.NativeAsyncStorageModuleSpec
    @ReactMethod
    public void getAllKeys(final Callback callback) {
        new GuardedAsyncTask<Void, Void>(getReactApplicationContext()) { // from class: com.reactnativecommunity.asyncstorage.AsyncStorageModule.6
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.react.bridge.GuardedAsyncTask
            public void doInBackgroundGuarded(Void... voidArr) {
                if (!AsyncStorageModule.this.ensureDatabase()) {
                    callback.invoke(AsyncStorageErrorUtil.getDBError(null), null);
                    return;
                }
                WritableArray writableArrayCreateArray = Arguments.createArray();
                Cursor cursorQuery = AsyncStorageModule.this.mReactDatabaseSupplier.get().query("catalystLocalStorage", new String[]{SDKConstants.PARAM_KEY}, null, null, null, null, null);
                try {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            do {
                                writableArrayCreateArray.pushString(cursorQuery.getString(0));
                            } while (cursorQuery.moveToNext());
                        }
                        cursorQuery.close();
                        callback.invoke(null, writableArrayCreateArray);
                    } catch (Exception e) {
                        FLog.w("ReactNative", e.getMessage(), e);
                        callback.invoke(AsyncStorageErrorUtil.getError(null, e.getMessage()), null);
                        cursorQuery.close();
                    }
                } catch (Throwable th) {
                    cursorQuery.close();
                    throw th;
                }
            }
        }.executeOnExecutor(this.executor, new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ensureDatabase() {
        return !this.mShuttingDown && this.mReactDatabaseSupplier.ensureDatabase();
    }
}
