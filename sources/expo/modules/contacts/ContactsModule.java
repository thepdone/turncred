package expo.modules.contacts;

import android.app.Activity;
import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.net.Uri;
import android.os.RemoteException;
import android.provider.ContactsContract;
import androidx.tracing.Trace;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.actions.SearchIntents;
import expo.modules.contacts.models.BaseModel;
import expo.modules.contacts.models.BirthdayModel;
import expo.modules.contacts.models.DateModel;
import expo.modules.contacts.models.DateModelKt;
import expo.modules.contacts.models.EmailModel;
import expo.modules.contacts.models.ExtraNameModel;
import expo.modules.contacts.models.ImAddressModel;
import expo.modules.contacts.models.PhoneNumberModel;
import expo.modules.contacts.models.PostalAddressModel;
import expo.modules.contacts.models.RelationshipModel;
import expo.modules.contacts.models.UrlAddressModel;
import expo.modules.interfaces.permissions.Permissions;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.events.EventListenerWithSenderAndPayload;
import expo.modules.kotlin.events.EventName;
import expo.modules.kotlin.events.OnActivityResultPayload;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.functions.AsyncFunctionComponent;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.functions.BoolAsyncFunctionComponent;
import expo.modules.kotlin.functions.DoubleAsyncFunctionComponent;
import expo.modules.kotlin.functions.FloatAsyncFunctionComponent;
import expo.modules.kotlin.functions.IntAsyncFunctionComponent;
import expo.modules.kotlin.functions.StringAsyncFunctionComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.AnyTypeProvider;
import expo.modules.kotlin.types.LazyKType;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

/* compiled from: ContactsModule.kt */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0002J\b\u0010\u001c\u001a\u00020\u001aH\u0002JQ\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 2\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010\u00162\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\b\u0010%\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0002\u0010&J\u0012\u0010'\u001a\u0004\u0018\u00010\u001e2\u0006\u0010(\u001a\u00020)H\u0002J\"\u0010*\u001a\u0004\u0018\u00010+2\b\u0010,\u001a\u0004\u0018\u00010\u00162\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0002J*\u0010-\u001a\u0004\u0018\u00010\u001e2\u0006\u0010.\u001a\u00020\u00162\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\b\u0010%\u001a\u0004\u0018\u00010\u0016H\u0002J\u0014\u0010/\u001a\u0004\u0018\u00010\u00162\b\u0010,\u001a\u0004\u0018\u00010\u0016H\u0002J\u001c\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020+012\u0006\u00102\u001a\u000203H\u0002J&\u00104\u001a\u00020+2\b\u00105\u001a\u0004\u0018\u00010+2\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020701H\u0002J\u0018\u00108\u001a\u00020\u001a2\u0006\u00109\u001a\u00020+2\u0006\u0010:\u001a\u00020\u0004H\u0002J\u0018\u0010;\u001a\u00020\u001a2\u0006\u00109\u001a\u00020+2\u0006\u0010:\u001a\u00020\u0004H\u0002J:\u0010<\u001a\u0012\u0012\u0004\u0012\u00020+0=j\b\u0012\u0004\u0012\u00020+`>2\u0016\u0010?\u001a\u0012\u0012\u0004\u0012\u00020+0=j\b\u0012\u0004\u0012\u00020+`>2\b\u0010%\u001a\u0004\u0018\u00010\u0016H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006@"}, d2 = {"Lexpo/modules/contacts/ContactsModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "contactManipulationPromise", "Lexpo/modules/kotlin/Promise;", "contactPickingPromise", "currentActivity", "Landroid/app/Activity;", "getCurrentActivity", "()Landroid/app/Activity;", "permissionsManager", "Lexpo/modules/interfaces/permissions/Permissions;", "getPermissionsManager", "()Lexpo/modules/interfaces/permissions/Permissions;", "resolver", "Landroid/content/ContentResolver;", "getResolver", "()Landroid/content/ContentResolver;", "createProjectionForQuery", "Lexpo/modules/contacts/QueryArguments;", "keysToFetch", "", "", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "ensurePermissions", "", "ensureReadPermission", "ensureWritePermission", "fetchContacts", "Lexpo/modules/contacts/ContactPage;", "pageOffset", "", "pageSize", "queryStrings", "", "initQueryField", SDKConstants.PARAM_SORT_ORDER, "(II[Ljava/lang/String;Ljava/lang/String;Ljava/util/Set;Ljava/lang/String;)Lexpo/modules/contacts/ContactPage;", "getAllContactsAsync", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "Lexpo/modules/contacts/ContactQuery;", "getContactById", "Lexpo/modules/contacts/Contact;", "contactId", "getContactByName", SearchIntents.EXTRA_QUERY, "getLookupKeyForContactId", "loadContactsFrom", "", "cursor", "Landroid/database/Cursor;", "mutateContact", "initContact", "data", "", "presentEditForm", "contact", BaseJavaModule.METHOD_TYPE_PROMISE, "presentForm", "sortContactsBy", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "input", "expo-contacts_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ContactsModule extends Module {
    private Promise contactManipulationPromise;
    private Promise contactPickingPromise;

    /* JADX INFO: Access modifiers changed from: private */
    public final Permissions getPermissionsManager() throws Exceptions.PermissionsModuleNotFound {
        Permissions permissions = getAppContext().getPermissions();
        if (permissions != null) {
            return permissions;
        }
        throw new Exceptions.PermissionsModuleNotFound();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Activity getCurrentActivity() {
        return getAppContext().getThrowingActivity();
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        AsyncFunctionComponent asyncFunctionComponent;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent;
        AsyncFunctionComponent asyncFunctionComponent2;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent2;
        AsyncFunctionComponent asyncFunctionComponent3;
        AsyncFunctionComponent asyncFunctionComponent4;
        AsyncFunctionComponent asyncFunctionComponent5;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent3;
        AsyncFunctionComponent asyncFunctionComponent6;
        AsyncFunctionComponent asyncFunctionComponent7;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent4;
        AsyncFunctionComponent asyncFunctionComponent8;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent5;
        ContactsModule contactsModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (contactsModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(contactsModule);
            moduleDefinitionBuilder.Name("ExpoContacts");
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(Promise.class, Promise.class)) {
                asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent("requestPermissionsAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.contacts.ContactsModule$definition$lambda$13$$inlined$AsyncFunction$1
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        if (this.this$0.getPermissionsManager().isPermissionPresentInManifest("android.permission.WRITE_CONTACTS")) {
                            Permissions.askForPermissionsWithPermissionsManager(this.this$0.getPermissionsManager(), promise, "android.permission.READ_CONTACTS", "android.permission.WRITE_CONTACTS");
                        } else {
                            Permissions.askForPermissionsWithPermissionsManager(this.this$0.getPermissionsManager(), promise, "android.permission.READ_CONTACTS");
                        }
                    }
                });
            } else {
                AnyType[] anyTypeArr = new AnyType[1];
                AnyType anyType = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Promise.class), false));
                if (anyType == null) {
                    anyType = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.contacts.ContactsModule$definition$lambda$13$$inlined$AsyncFunction$2
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Promise.class);
                        }
                    }));
                }
                anyTypeArr[0] = anyType;
                Function1<Object[], Unit> function1 = new Function1<Object[], Unit>() { // from class: expo.modules.contacts.ContactsModule$definition$lambda$13$$inlined$AsyncFunction$3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        Promise promise = (Promise) objArr[0];
                        if (this.this$0.getPermissionsManager().isPermissionPresentInManifest("android.permission.WRITE_CONTACTS")) {
                            Permissions.askForPermissionsWithPermissionsManager(this.this$0.getPermissionsManager(), promise, "android.permission.READ_CONTACTS", "android.permission.WRITE_CONTACTS");
                        } else {
                            Permissions.askForPermissionsWithPermissionsManager(this.this$0.getPermissionsManager(), promise, "android.permission.READ_CONTACTS");
                        }
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    asyncFunctionComponent = new StringAsyncFunctionComponent("requestPermissionsAsync", anyTypeArr, function1);
                                } else {
                                    asyncFunctionComponent = new AsyncFunctionComponent("requestPermissionsAsync", anyTypeArr, function1);
                                }
                            } else {
                                asyncFunctionComponent = new FloatAsyncFunctionComponent("requestPermissionsAsync", anyTypeArr, function1);
                            }
                        } else {
                            asyncFunctionComponent = new DoubleAsyncFunctionComponent("requestPermissionsAsync", anyTypeArr, function1);
                        }
                    } else {
                        asyncFunctionComponent = new BoolAsyncFunctionComponent("requestPermissionsAsync", anyTypeArr, function1);
                    }
                } else {
                    asyncFunctionComponent = new IntAsyncFunctionComponent("requestPermissionsAsync", anyTypeArr, function1);
                }
                asyncFunctionWithPromiseComponent = asyncFunctionComponent;
            }
            moduleDefinitionBuilder2.getAsyncFunctions().put("requestPermissionsAsync", asyncFunctionWithPromiseComponent);
            ModuleDefinitionBuilder moduleDefinitionBuilder3 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(Promise.class, Promise.class)) {
                asyncFunctionWithPromiseComponent2 = new AsyncFunctionWithPromiseComponent("getPermissionsAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.contacts.ContactsModule$definition$lambda$13$$inlined$AsyncFunction$4
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        if (this.this$0.getPermissionsManager().isPermissionPresentInManifest("android.permission.WRITE_CONTACTS")) {
                            Permissions.getPermissionsWithPermissionsManager(this.this$0.getPermissionsManager(), promise, "android.permission.READ_CONTACTS", "android.permission.WRITE_CONTACTS");
                        } else {
                            Permissions.getPermissionsWithPermissionsManager(this.this$0.getPermissionsManager(), promise, "android.permission.READ_CONTACTS");
                        }
                    }
                });
            } else {
                AnyType[] anyTypeArr2 = new AnyType[1];
                AnyType anyType2 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Promise.class), false));
                if (anyType2 == null) {
                    anyType2 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.contacts.ContactsModule$definition$lambda$13$$inlined$AsyncFunction$5
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Promise.class);
                        }
                    }));
                }
                anyTypeArr2[0] = anyType2;
                Function1<Object[], Unit> function12 = new Function1<Object[], Unit>() { // from class: expo.modules.contacts.ContactsModule$definition$lambda$13$$inlined$AsyncFunction$6
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        Promise promise = (Promise) objArr[0];
                        if (this.this$0.getPermissionsManager().isPermissionPresentInManifest("android.permission.WRITE_CONTACTS")) {
                            Permissions.getPermissionsWithPermissionsManager(this.this$0.getPermissionsManager(), promise, "android.permission.READ_CONTACTS", "android.permission.WRITE_CONTACTS");
                        } else {
                            Permissions.getPermissionsWithPermissionsManager(this.this$0.getPermissionsManager(), promise, "android.permission.READ_CONTACTS");
                        }
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    asyncFunctionComponent2 = new StringAsyncFunctionComponent("getPermissionsAsync", anyTypeArr2, function12);
                                } else {
                                    asyncFunctionComponent2 = new AsyncFunctionComponent("getPermissionsAsync", anyTypeArr2, function12);
                                }
                            } else {
                                asyncFunctionComponent2 = new FloatAsyncFunctionComponent("getPermissionsAsync", anyTypeArr2, function12);
                            }
                        } else {
                            asyncFunctionComponent2 = new DoubleAsyncFunctionComponent("getPermissionsAsync", anyTypeArr2, function12);
                        }
                    } else {
                        asyncFunctionComponent2 = new BoolAsyncFunctionComponent("getPermissionsAsync", anyTypeArr2, function12);
                    }
                } else {
                    asyncFunctionComponent2 = new IntAsyncFunctionComponent("getPermissionsAsync", anyTypeArr2, function12);
                }
                asyncFunctionWithPromiseComponent2 = asyncFunctionComponent2;
            }
            moduleDefinitionBuilder3.getAsyncFunctions().put("getPermissionsAsync", asyncFunctionWithPromiseComponent2);
            ModuleDefinitionBuilder moduleDefinitionBuilder4 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr3 = new AnyType[1];
            AnyType anyType3 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(ContactQuery.class), false));
            if (anyType3 == null) {
                anyType3 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ContactQuery.class), false, new Function0<KType>() { // from class: expo.modules.contacts.ContactsModule$definition$lambda$13$$inlined$AsyncFunctionWithPromise$1
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(ContactQuery.class);
                    }
                }));
            }
            anyTypeArr3[0] = anyType3;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent6 = new AsyncFunctionWithPromiseComponent("getContactsAsync", anyTypeArr3, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.contacts.ContactsModule$definition$lambda$13$$inlined$AsyncFunctionWithPromise$2
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) throws MissingPermissionException {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    ContactQuery contactQuery = (ContactQuery) objArr[0];
                    this.this$0.ensureReadPermission();
                    BuildersKt__Builders_commonKt.launch$default(this.this$0.getAppContext().getBackgroundCoroutineScope(), null, null, new ContactsModule$definition$1$3$1(contactQuery, promise, this.this$0, null), 3, null);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) throws MissingPermissionException {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder4.getAsyncFunctions().put("getContactsAsync", asyncFunctionWithPromiseComponent6);
            ModuleDefinitionBuilder moduleDefinitionBuilder5 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr4 = new AnyType[2];
            AnyType anyType4 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Map.class), false));
            if (anyType4 == null) {
                anyType4 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Map.class), false, new Function0<KType>() { // from class: expo.modules.contacts.ContactsModule$definition$lambda$13$$inlined$AsyncFunction$7
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(Map.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(Object.class)));
                    }
                }));
            }
            anyTypeArr4[0] = anyType4;
            AnyType anyType5 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), true));
            if (anyType5 == null) {
                anyType5 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), true, new Function0<KType>() { // from class: expo.modules.contacts.ContactsModule$definition$lambda$13$$inlined$AsyncFunction$8
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.nullableTypeOf(String.class);
                    }
                }));
            }
            anyTypeArr4[1] = anyType5;
            Function1<Object[], String> function13 = new Function1<Object[], String>() { // from class: expo.modules.contacts.ContactsModule$definition$lambda$13$$inlined$AsyncFunction$9
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final String invoke(Object[] objArr) throws AddContactException, MissingPermissionException, RemoteException, Exceptions.ReactContextLost, OperationApplicationException {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Object obj = objArr[0];
                    this.this$0.ensurePermissions();
                    ContentProviderResult[] contentProviderResultArrApplyBatch = this.this$0.getResolver().applyBatch("com.android.contacts", this.this$0.mutateContact(null, (Map) obj).toInsertOperationList());
                    Intrinsics.checkNotNullExpressionValue(contentProviderResultArrApplyBatch, "applyBatch(...)");
                    if (!(contentProviderResultArrApplyBatch.length == 0)) {
                        ContentResolver resolver = this.this$0.getResolver();
                        Uri uri = contentProviderResultArrApplyBatch[0].uri;
                        Intrinsics.checkNotNull(uri);
                        Cursor cursorQuery = resolver.query(uri, new String[]{Columns.CONTACT_ID}, null, null, null);
                        try {
                            Cursor cursor = cursorQuery;
                            if (cursor == null) {
                                throw new RetrieveIdException();
                            }
                            cursor.moveToNext();
                            String strValueOf = String.valueOf(cursor.getLong(0));
                            CloseableKt.closeFinally(cursorQuery, null);
                            return strValueOf;
                        } finally {
                        }
                    } else {
                        throw new AddContactException();
                    }
                }
            };
            if (!Intrinsics.areEqual(String.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(String.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(String.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(String.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(String.class, String.class)) {
                                asyncFunctionComponent3 = new StringAsyncFunctionComponent("addContactAsync", anyTypeArr4, function13);
                            } else {
                                asyncFunctionComponent3 = new AsyncFunctionComponent("addContactAsync", anyTypeArr4, function13);
                            }
                        } else {
                            asyncFunctionComponent3 = new FloatAsyncFunctionComponent("addContactAsync", anyTypeArr4, function13);
                        }
                    } else {
                        asyncFunctionComponent3 = new DoubleAsyncFunctionComponent("addContactAsync", anyTypeArr4, function13);
                    }
                } else {
                    asyncFunctionComponent3 = new BoolAsyncFunctionComponent("addContactAsync", anyTypeArr4, function13);
                }
            } else {
                asyncFunctionComponent3 = new IntAsyncFunctionComponent("addContactAsync", anyTypeArr4, function13);
            }
            moduleDefinitionBuilder5.getAsyncFunctions().put("addContactAsync", asyncFunctionComponent3);
            ModuleDefinitionBuilder moduleDefinitionBuilder6 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(Map.class, Promise.class)) {
                asyncFunctionComponent4 = new AsyncFunctionWithPromiseComponent("updateContactAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.contacts.ContactsModule$definition$lambda$13$$inlined$AsyncFunction$10
                    {
                        super(2);
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) throws ContactUpdateException, MissingPermissionException, ContactNotFoundException, RemoteException, OperationApplicationException {
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        Map map = (Map) promise;
                        this.this$0.ensurePermissions();
                        Contact contactById = this.this$0.getContactById(map.containsKey("id") ? (String) map.get("id") : null, ContactsModuleKt.defaultFields);
                        if (contactById != null) {
                            ContentProviderResult[] contentProviderResultArrApplyBatch = this.this$0.getResolver().applyBatch("com.android.contacts", this.this$0.mutateContact(contactById, map).toUpdateOperationList());
                            Intrinsics.checkNotNullExpressionValue(contentProviderResultArrApplyBatch, "applyBatch(...)");
                            if (contentProviderResultArrApplyBatch.length == 0) {
                                throw new ContactUpdateException();
                            }
                            return;
                        }
                        throw new ContactNotFoundException();
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) throws ContactUpdateException, MissingPermissionException, ContactNotFoundException, RemoteException, OperationApplicationException {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                AnyType[] anyTypeArr5 = new AnyType[1];
                AnyType anyType6 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Map.class), false));
                if (anyType6 == null) {
                    anyType6 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Map.class), false, new Function0<KType>() { // from class: expo.modules.contacts.ContactsModule$definition$lambda$13$$inlined$AsyncFunction$11
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Map.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(Object.class)));
                        }
                    }));
                }
                anyTypeArr5[0] = anyType6;
                asyncFunctionComponent4 = new AsyncFunctionComponent("updateContactAsync", anyTypeArr5, new Function1<Object[], String>() { // from class: expo.modules.contacts.ContactsModule$definition$lambda$13$$inlined$AsyncFunction$12
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final String invoke(Object[] objArr) throws ContactUpdateException, MissingPermissionException, ContactNotFoundException, RemoteException, OperationApplicationException {
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        Map map = (Map) objArr[0];
                        this.this$0.ensurePermissions();
                        String str = map.containsKey("id") ? (String) map.get("id") : null;
                        Contact contactById = this.this$0.getContactById(str, ContactsModuleKt.defaultFields);
                        if (contactById != null) {
                            ContentProviderResult[] contentProviderResultArrApplyBatch = this.this$0.getResolver().applyBatch("com.android.contacts", this.this$0.mutateContact(contactById, map).toUpdateOperationList());
                            Intrinsics.checkNotNullExpressionValue(contentProviderResultArrApplyBatch, "applyBatch(...)");
                            if (contentProviderResultArrApplyBatch.length == 0) {
                                throw new ContactUpdateException();
                            }
                            return str;
                        }
                        throw new ContactNotFoundException();
                    }
                });
            }
            moduleDefinitionBuilder6.getAsyncFunctions().put("updateContactAsync", asyncFunctionComponent4);
            ModuleDefinitionBuilder moduleDefinitionBuilder7 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(String.class, Promise.class)) {
                asyncFunctionWithPromiseComponent3 = new AsyncFunctionWithPromiseComponent("removeContactAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.contacts.ContactsModule$definition$lambda$13$$inlined$AsyncFunction$13
                    {
                        super(2);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) throws MissingPermissionException {
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        this.this$0.ensurePermissions();
                        this.this$0.getResolver().delete(Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_URI, (String) promise), null, null);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) throws MissingPermissionException {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                AnyType[] anyTypeArr6 = new AnyType[1];
                AnyType anyType7 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), true));
                if (anyType7 == null) {
                    anyType7 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), true, new Function0<KType>() { // from class: expo.modules.contacts.ContactsModule$definition$lambda$13$$inlined$AsyncFunction$14
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(String.class);
                        }
                    }));
                }
                anyTypeArr6[0] = anyType7;
                Function1<Object[], Integer> function14 = new Function1<Object[], Integer>() { // from class: expo.modules.contacts.ContactsModule$definition$lambda$13$$inlined$AsyncFunction$15
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Integer invoke(Object[] objArr) throws MissingPermissionException {
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        String str = (String) objArr[0];
                        this.this$0.ensurePermissions();
                        return Integer.valueOf(this.this$0.getResolver().delete(Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_URI, str), null, null));
                    }
                };
                if (!Intrinsics.areEqual(Integer.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Integer.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Integer.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Integer.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Integer.class, String.class)) {
                                    asyncFunctionComponent5 = new StringAsyncFunctionComponent("removeContactAsync", anyTypeArr6, function14);
                                } else {
                                    asyncFunctionComponent5 = new AsyncFunctionComponent("removeContactAsync", anyTypeArr6, function14);
                                }
                            } else {
                                asyncFunctionComponent5 = new FloatAsyncFunctionComponent("removeContactAsync", anyTypeArr6, function14);
                            }
                        } else {
                            asyncFunctionComponent5 = new DoubleAsyncFunctionComponent("removeContactAsync", anyTypeArr6, function14);
                        }
                    } else {
                        asyncFunctionComponent5 = new BoolAsyncFunctionComponent("removeContactAsync", anyTypeArr6, function14);
                    }
                } else {
                    asyncFunctionComponent5 = new IntAsyncFunctionComponent("removeContactAsync", anyTypeArr6, function14);
                }
                asyncFunctionWithPromiseComponent3 = asyncFunctionComponent5;
            }
            moduleDefinitionBuilder7.getAsyncFunctions().put("removeContactAsync", asyncFunctionWithPromiseComponent3);
            ModuleDefinitionBuilder moduleDefinitionBuilder8 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr7 = new AnyType[2];
            AnyType anyType8 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), true));
            if (anyType8 == null) {
                anyType8 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), true, new Function0<KType>() { // from class: expo.modules.contacts.ContactsModule$definition$lambda$13$$inlined$AsyncFunction$16
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.nullableTypeOf(String.class);
                    }
                }));
            }
            anyTypeArr7[0] = anyType8;
            AnyType anyType9 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), true));
            if (anyType9 == null) {
                anyType9 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), true, new Function0<KType>() { // from class: expo.modules.contacts.ContactsModule$definition$lambda$13$$inlined$AsyncFunction$17
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.nullableTypeOf(String.class);
                    }
                }));
            }
            anyTypeArr7[1] = anyType9;
            Function1<Object[], Unit> function15 = new Function1<Object[], Unit>() { // from class: expo.modules.contacts.ContactsModule$definition$lambda$13$$inlined$AsyncFunction$18
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Object[] objArr) throws LookupKeyNotFoundException {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Object obj = objArr[0];
                    String str = (String) objArr[1];
                    String lookupKeyForContactId = this.this$0.getLookupKeyForContactId((String) obj);
                    if (lookupKeyForContactId == null) {
                        throw new LookupKeyNotFoundException();
                    }
                    Uri uriWithAppendedPath = Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_VCARD_URI, lookupKeyForContactId);
                    Intent intent = new Intent("android.intent.action.SEND");
                    intent.setType("text/x-vcard");
                    intent.putExtra("android.intent.extra.STREAM", uriWithAppendedPath);
                    intent.putExtra("android.intent.extra.SUBJECT", str);
                    this.this$0.getCurrentActivity().startActivity(intent);
                    return Unit.INSTANCE;
                }
            };
            if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(Unit.class, String.class)) {
                                asyncFunctionComponent6 = new StringAsyncFunctionComponent("shareContactAsync", anyTypeArr7, function15);
                            } else {
                                asyncFunctionComponent6 = new AsyncFunctionComponent("shareContactAsync", anyTypeArr7, function15);
                            }
                        } else {
                            asyncFunctionComponent6 = new FloatAsyncFunctionComponent("shareContactAsync", anyTypeArr7, function15);
                        }
                    } else {
                        asyncFunctionComponent6 = new DoubleAsyncFunctionComponent("shareContactAsync", anyTypeArr7, function15);
                    }
                } else {
                    asyncFunctionComponent6 = new BoolAsyncFunctionComponent("shareContactAsync", anyTypeArr7, function15);
                }
            } else {
                asyncFunctionComponent6 = new IntAsyncFunctionComponent("shareContactAsync", anyTypeArr7, function15);
            }
            moduleDefinitionBuilder8.getAsyncFunctions().put("shareContactAsync", asyncFunctionComponent6);
            ModuleDefinitionBuilder moduleDefinitionBuilder9 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(Map.class, Promise.class)) {
                asyncFunctionWithPromiseComponent4 = new AsyncFunctionWithPromiseComponent("writeContactToFileAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.contacts.ContactsModule$definition$lambda$13$$inlined$AsyncFunction$19
                    {
                        super(2);
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) throws LookupKeyNotFoundException, MissingPermissionException {
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        Map map = (Map) promise;
                        this.this$0.ensureReadPermission();
                        String lookupKeyForContactId = this.this$0.getLookupKeyForContactId(map.containsKey("id") ? (String) map.get("id") : null);
                        if (lookupKeyForContactId == null) {
                            throw new LookupKeyNotFoundException();
                        }
                        Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_VCARD_URI, lookupKeyForContactId).toString();
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) throws LookupKeyNotFoundException, MissingPermissionException {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                AnyType[] anyTypeArr8 = new AnyType[1];
                AnyType anyType10 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Map.class), false));
                if (anyType10 == null) {
                    anyType10 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Map.class), false, new Function0<KType>() { // from class: expo.modules.contacts.ContactsModule$definition$lambda$13$$inlined$AsyncFunction$20
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Map.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)), KTypeProjection.INSTANCE.invariant(Reflection.nullableTypeOf(Object.class)));
                        }
                    }));
                }
                anyTypeArr8[0] = anyType10;
                Function1<Object[], String> function16 = new Function1<Object[], String>() { // from class: expo.modules.contacts.ContactsModule$definition$lambda$13$$inlined$AsyncFunction$21
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final String invoke(Object[] objArr) throws LookupKeyNotFoundException, MissingPermissionException {
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        Map map = (Map) objArr[0];
                        this.this$0.ensureReadPermission();
                        String lookupKeyForContactId = this.this$0.getLookupKeyForContactId(map.containsKey("id") ? (String) map.get("id") : null);
                        if (lookupKeyForContactId == null) {
                            throw new LookupKeyNotFoundException();
                        }
                        return Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_VCARD_URI, lookupKeyForContactId).toString();
                    }
                };
                if (!Intrinsics.areEqual(String.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(String.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(String.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(String.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(String.class, String.class)) {
                                    asyncFunctionComponent7 = new StringAsyncFunctionComponent("writeContactToFileAsync", anyTypeArr8, function16);
                                } else {
                                    asyncFunctionComponent7 = new AsyncFunctionComponent("writeContactToFileAsync", anyTypeArr8, function16);
                                }
                            } else {
                                asyncFunctionComponent7 = new FloatAsyncFunctionComponent("writeContactToFileAsync", anyTypeArr8, function16);
                            }
                        } else {
                            asyncFunctionComponent7 = new DoubleAsyncFunctionComponent("writeContactToFileAsync", anyTypeArr8, function16);
                        }
                    } else {
                        asyncFunctionComponent7 = new BoolAsyncFunctionComponent("writeContactToFileAsync", anyTypeArr8, function16);
                    }
                } else {
                    asyncFunctionComponent7 = new IntAsyncFunctionComponent("writeContactToFileAsync", anyTypeArr8, function16);
                }
                asyncFunctionWithPromiseComponent4 = asyncFunctionComponent7;
            }
            moduleDefinitionBuilder9.getAsyncFunctions().put("writeContactToFileAsync", asyncFunctionWithPromiseComponent4);
            ModuleDefinitionBuilder moduleDefinitionBuilder10 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr9 = new AnyType[3];
            AnyType anyType11 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), true));
            if (anyType11 == null) {
                anyType11 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), true, new Function0<KType>() { // from class: expo.modules.contacts.ContactsModule$definition$lambda$13$$inlined$AsyncFunctionWithPromise$3
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.nullableTypeOf(String.class);
                    }
                }));
            }
            anyTypeArr9[0] = anyType11;
            AnyType anyType12 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Map.class), true));
            if (anyType12 == null) {
                anyType12 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Map.class), true, new Function0<KType>() { // from class: expo.modules.contacts.ContactsModule$definition$lambda$13$$inlined$AsyncFunctionWithPromise$4
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.nullableTypeOf(Map.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(Object.class)));
                    }
                }));
            }
            anyTypeArr9[1] = anyType12;
            AnyType anyType13 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Map.class), true));
            if (anyType13 == null) {
                anyType13 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Map.class), true, new Function0<KType>() { // from class: expo.modules.contacts.ContactsModule$definition$lambda$13$$inlined$AsyncFunctionWithPromise$5
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.nullableTypeOf(Map.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)), KTypeProjection.INSTANCE.invariant(Reflection.nullableTypeOf(Object.class)));
                    }
                }));
            }
            anyTypeArr9[2] = anyType13;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent7 = new AsyncFunctionWithPromiseComponent("presentFormAsync", anyTypeArr9, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.contacts.ContactsModule$definition$lambda$13$$inlined$AsyncFunctionWithPromise$6
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) throws IllegalAccessException, ContactManipulationInProgressException, MissingPermissionException, ContactNotFoundException, InstantiationException, IllegalArgumentException, InvocationTargetException {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = objArr[0];
                    Object obj2 = objArr[1];
                    Map map = (Map) obj2;
                    String str = (String) obj;
                    this.this$0.ensureReadPermission();
                    if (this.this$0.contactManipulationPromise != null) {
                        throw new ContactManipulationInProgressException();
                    }
                    if (str != null) {
                        Contact contactById = this.this$0.getContactById(str, ContactsModuleKt.defaultFields);
                        if (contactById != null) {
                            this.this$0.presentEditForm(contactById, promise);
                        } else {
                            throw new ContactNotFoundException();
                        }
                    }
                    if (map != null) {
                        this.this$0.presentForm(this.this$0.mutateContact(null, map), promise);
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) throws IllegalAccessException, ContactManipulationInProgressException, MissingPermissionException, ContactNotFoundException, InstantiationException, IllegalArgumentException, InvocationTargetException {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder10.getAsyncFunctions().put("presentFormAsync", asyncFunctionWithPromiseComponent7);
            moduleDefinitionBuilder.getEventListeners().put(EventName.ON_ACTIVITY_RESULT, new EventListenerWithSenderAndPayload(EventName.ON_ACTIVITY_RESULT, new Function2<Activity, OnActivityResultPayload, Unit>() { // from class: expo.modules.contacts.ContactsModule$definition$lambda$13$$inlined$OnActivityResult$1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Activity activity, OnActivityResultPayload onActivityResultPayload) {
                    invoke2(activity, onActivityResultPayload);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Activity sender, OnActivityResultPayload payload) {
                    Promise promise;
                    Uri data;
                    Intrinsics.checkNotNullParameter(sender, "sender");
                    Intrinsics.checkNotNullParameter(payload, "payload");
                    int requestCode = payload.getRequestCode();
                    int resultCode = payload.getResultCode();
                    Intent data2 = payload.getData();
                    if (requestCode == 2137 || requestCode == 2139) {
                        Promise promise2 = this.this$0.contactManipulationPromise;
                        if (promise2 == null) {
                            return;
                        }
                        promise2.resolve(0);
                        this.this$0.contactManipulationPromise = null;
                    }
                    if (requestCode != 2138 || (promise = this.this$0.contactPickingPromise) == null) {
                        return;
                    }
                    if (resultCode == -1) {
                        Contact contactById = this.this$0.getContactById((data2 == null || (data = data2.getData()) == null) ? null : data.getLastPathSegment(), ContactsModuleKt.defaultFields);
                        promise.resolve(contactById != null ? contactById.toMap(ContactsModuleKt.defaultFields) : null);
                    } else {
                        promise.resolve();
                    }
                    this.this$0.contactPickingPromise = null;
                }
            }));
            ModuleDefinitionBuilder moduleDefinitionBuilder11 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(Promise.class, Promise.class)) {
                asyncFunctionWithPromiseComponent5 = new AsyncFunctionWithPromiseComponent("presentContactPickerAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.contacts.ContactsModule$definition$lambda$13$$inlined$AsyncFunction$22
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) throws ContactPickingInProgressException {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) throws ContactPickingInProgressException {
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        if (this.this$0.contactPickingPromise != null) {
                            throw new ContactPickingInProgressException();
                        }
                        Intent intent = new Intent("android.intent.action.PICK");
                        intent.setType("vnd.android.cursor.dir/contact");
                        this.this$0.contactPickingPromise = promise;
                        this.this$0.getCurrentActivity().startActivityForResult(intent, ContactsModuleKt.RC_PICK_CONTACT);
                    }
                });
            } else {
                AnyType[] anyTypeArr10 = new AnyType[1];
                AnyType anyType14 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Promise.class), false));
                if (anyType14 == null) {
                    anyType14 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.contacts.ContactsModule$definition$lambda$13$$inlined$AsyncFunction$23
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Promise.class);
                        }
                    }));
                }
                anyTypeArr10[0] = anyType14;
                Function1<Object[], Unit> function17 = new Function1<Object[], Unit>() { // from class: expo.modules.contacts.ContactsModule$definition$lambda$13$$inlined$AsyncFunction$24
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) throws ContactPickingInProgressException {
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        Promise promise = (Promise) objArr[0];
                        if (this.this$0.contactPickingPromise != null) {
                            throw new ContactPickingInProgressException();
                        }
                        Intent intent = new Intent("android.intent.action.PICK");
                        intent.setType("vnd.android.cursor.dir/contact");
                        this.this$0.contactPickingPromise = promise;
                        this.this$0.getCurrentActivity().startActivityForResult(intent, ContactsModuleKt.RC_PICK_CONTACT);
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    asyncFunctionComponent8 = new StringAsyncFunctionComponent("presentContactPickerAsync", anyTypeArr10, function17);
                                } else {
                                    asyncFunctionComponent8 = new AsyncFunctionComponent("presentContactPickerAsync", anyTypeArr10, function17);
                                }
                            } else {
                                asyncFunctionComponent8 = new FloatAsyncFunctionComponent("presentContactPickerAsync", anyTypeArr10, function17);
                            }
                        } else {
                            asyncFunctionComponent8 = new DoubleAsyncFunctionComponent("presentContactPickerAsync", anyTypeArr10, function17);
                        }
                    } else {
                        asyncFunctionComponent8 = new BoolAsyncFunctionComponent("presentContactPickerAsync", anyTypeArr10, function17);
                    }
                } else {
                    asyncFunctionComponent8 = new IntAsyncFunctionComponent("presentContactPickerAsync", anyTypeArr10, function17);
                }
                asyncFunctionWithPromiseComponent5 = asyncFunctionComponent8;
            }
            moduleDefinitionBuilder11.getAsyncFunctions().put("presentContactPickerAsync", asyncFunctionWithPromiseComponent5);
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void presentForm(Contact contact, Promise promise) {
        Intent intent = new Intent("android.intent.action.INSERT", ContactsContract.Contacts.CONTENT_URI);
        intent.putExtra("name", contact.getFinalDisplayName());
        intent.putParcelableArrayListExtra("data", contact.getContentValues());
        this.contactManipulationPromise = promise;
        getCurrentActivity().startActivityForResult(intent, ContactsModuleKt.RC_ADD_CONTACT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void presentEditForm(Contact contact, Promise promise) {
        Uri lookupUri = ContactsContract.Contacts.getLookupUri(Long.parseLong(contact.getContactId()), contact.getLookupKey());
        Intent intent = new Intent("android.intent.action.EDIT");
        intent.setDataAndType(lookupUri, "vnd.android.cursor.item/contact");
        this.contactManipulationPromise = promise;
        getCurrentActivity().startActivityForResult(intent, ContactsModuleKt.RC_EDIT_CONTACT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ContentResolver getResolver() throws Exceptions.ReactContextLost {
        Context reactContext = getAppContext().getReactContext();
        if (reactContext == null) {
            throw new Exceptions.ReactContextLost();
        }
        ContentResolver contentResolver = reactContext.getContentResolver();
        Intrinsics.checkNotNullExpressionValue(contentResolver, "getContentResolver(...)");
        return contentResolver;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Contact mutateContact(Contact initContact, Map<String, ? extends Object> data) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        if (initContact == null) {
            String string = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            initContact = new Contact(string, getAppContext());
        }
        String str = (String) ContactsModuleKt.safeGet(data, "firstName");
        if (str != null) {
            initContact.setFirstName(str);
        }
        String str2 = (String) ContactsModuleKt.safeGet(data, "middleName");
        if (str2 != null) {
            initContact.setMiddleName(str2);
        }
        String str3 = (String) ContactsModuleKt.safeGet(data, "lastName");
        if (str3 != null) {
            initContact.setLastName(str3);
        }
        String str4 = (String) ContactsModuleKt.safeGet(data, "namePrefix");
        if (str4 != null) {
            initContact.setPrefix(str4);
        }
        String str5 = (String) ContactsModuleKt.safeGet(data, "nameSuffix");
        if (str5 != null) {
            initContact.setSuffix(str5);
        }
        String str6 = (String) ContactsModuleKt.safeGet(data, "phoneticFirstName");
        if (str6 != null) {
            initContact.setPhoneticFirstName(str6);
        }
        String str7 = (String) ContactsModuleKt.safeGet(data, "phoneticMiddleName");
        if (str7 != null) {
            initContact.setPhoneticMiddleName(str7);
        }
        String str8 = (String) ContactsModuleKt.safeGet(data, "phoneticLastName");
        if (str8 != null) {
            initContact.setPhoneticLastName(str8);
        }
        String str9 = (String) ContactsModuleKt.safeGet(data, "company");
        if (str9 != null) {
            initContact.setCompany(str9);
        }
        String str10 = (String) ContactsModuleKt.safeGet(data, "jobTitle");
        if (str10 != null) {
            initContact.setJobTitle(str10);
        }
        String str11 = (String) ContactsModuleKt.safeGet(data, "department");
        if (str11 != null) {
            initContact.setDepartment(str11);
        }
        String str12 = (String) ContactsModuleKt.safeGet(data, "note");
        if (str12 != null) {
            initContact.setNote(str12);
        }
        if (data.containsKey("image")) {
            Object obj = data.get("image");
            if (obj instanceof String) {
                initContact.setPhotoUri((String) obj);
                initContact.setHasPhoto(true);
            } else if (obj instanceof Map) {
                Map map = (Map) obj;
                if (map.containsKey(ShareConstants.MEDIA_URI)) {
                    initContact.setPhotoUri((String) map.get(ShareConstants.MEDIA_URI));
                    initContact.setHasPhoto(true);
                }
            }
        }
        List<PostalAddressModel> listDecodeList = BaseModel.INSTANCE.decodeList((List) ContactsModuleKt.safeGet(data, "addresses"), PostalAddressModel.class);
        if (listDecodeList != null) {
            initContact.setAddresses(listDecodeList);
        }
        List<PhoneNumberModel> listDecodeList2 = BaseModel.INSTANCE.decodeList((List) ContactsModuleKt.safeGet(data, "phoneNumbers"), PhoneNumberModel.class);
        if (listDecodeList2 != null) {
            initContact.setPhones(listDecodeList2);
        }
        List<EmailModel> listDecodeList3 = BaseModel.INSTANCE.decodeList((List) ContactsModuleKt.safeGet(data, "emails"), EmailModel.class);
        if (listDecodeList3 != null) {
            initContact.setEmails(listDecodeList3);
        }
        List<ImAddressModel> listDecodeList4 = BaseModel.INSTANCE.decodeList((List) ContactsModuleKt.safeGet(data, "instantMessageAddresses"), ImAddressModel.class);
        if (listDecodeList4 != null) {
            initContact.setImAddresses(listDecodeList4);
        }
        List<UrlAddressModel> listDecodeList5 = BaseModel.INSTANCE.decodeList((List) ContactsModuleKt.safeGet(data, "urlAddresses"), UrlAddressModel.class);
        if (listDecodeList5 != null) {
            initContact.setUrlAddresses(listDecodeList5);
        }
        List<ExtraNameModel> listDecodeList6 = BaseModel.INSTANCE.decodeList((List) ContactsModuleKt.safeGet(data, "extraNames"), ExtraNameModel.class);
        if (listDecodeList6 != null) {
            initContact.setExtraNames(listDecodeList6);
        }
        List<DateModel> listDecodeList7 = BaseModel.INSTANCE.decodeList((List) ContactsModuleKt.safeGet(data, "dates"), DateModel.class);
        if (listDecodeList7 != null) {
            initContact.setDates(listDecodeList7);
        }
        Object obj2 = data.get(DateModelKt.BIRTHDAY);
        if (obj2 != null) {
            if (!(obj2 instanceof Map)) {
                obj2 = null;
            }
            if (obj2 != null) {
                List<DateModel> dates = initContact.getDates();
                BirthdayModel birthdayModel = new BirthdayModel();
                birthdayModel.fromMap((Map) obj2);
                dates.add(birthdayModel);
            }
        }
        List<RelationshipModel> listDecodeList8 = BaseModel.INSTANCE.decodeList((List) ContactsModuleKt.safeGet(data, "relationships"), RelationshipModel.class);
        if (listDecodeList8 != null) {
            initContact.setRelationships(listDecodeList8);
        }
        Boolean bool = (Boolean) ContactsModuleKt.safeGet(data, "isFavorite");
        if (bool != null) {
            initContact.setFavorite(bool.booleanValue());
        }
        return initContact;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getLookupKeyForContactId(String contactId) {
        Cursor cursorQuery = getResolver().query(ContactsContract.Contacts.CONTENT_URI, new String[]{"lookup"}, "_id = " + contactId, null, null);
        if (cursorQuery == null) {
            return null;
        }
        Cursor cursor = cursorQuery;
        try {
            Cursor cursor2 = cursor;
            String string = cursor2.moveToFirst() ? cursor2.getString(0) : null;
            CloseableKt.closeFinally(cursor, null);
            return string;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(cursor, th);
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Contact getContactById(String contactId, Set<String> keysToFetch) {
        Cursor cursorQuery = getResolver().query(ContactsContract.Data.CONTENT_URI, createProjectionForQuery(keysToFetch).getProjection(), "contact_id = ?", new String[]{contactId}, null);
        if (cursorQuery == null) {
            return null;
        }
        Cursor cursor = cursorQuery;
        try {
            Contact contact = (Contact) CollectionsKt.firstOrNull(loadContactsFrom(cursor).values());
            CloseableKt.closeFinally(cursor, null);
            return contact;
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ContactPage getContactByName(String query, Set<String> keysToFetch, String sortOrder) {
        return fetchContacts(0, 9999, new String[]{query}, Columns.DISPLAY_NAME, keysToFetch, sortOrder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ContactPage getAllContactsAsync(ContactQuery options) {
        return fetchContacts(options.getPageOffset(), options.getPageSize(), null, null, options.getFields(), options.getSort());
    }

    private final QueryArguments createProjectionForQuery(Set<String> keysToFetch) {
        String str;
        ArrayList arrayList = new ArrayList(ContactsModuleKt.DEFAULT_PROJECTION);
        ArrayList arrayList2 = new ArrayList(CollectionsKt.listOf((Object[]) new String[]{"vnd.android.cursor.item/name", "vnd.android.cursor.item/organization"}));
        if (!keysToFetch.contains("phoneNumbers")) {
            str = "mimetype=? OR mimetype=?";
        } else {
            arrayList.add(Columns.DATA);
            arrayList.add(Columns.TYPE);
            arrayList.add(Columns.LABEL);
            arrayList.add(Columns.IS_PRIMARY);
            arrayList.add(Columns.ID);
            arrayList2.add("vnd.android.cursor.item/phone_v2");
            str = "mimetype=? OR mimetype=? OR mimetype=?";
        }
        if (keysToFetch.contains("emails")) {
            arrayList.add(Columns.DATA);
            arrayList.add(Columns.DATA);
            arrayList.add(Columns.TYPE);
            arrayList.add(Columns.LABEL);
            arrayList.add(Columns.IS_PRIMARY);
            arrayList.add(Columns.ID);
            str = str + " OR mimetype=?";
            arrayList2.add("vnd.android.cursor.item/email_v2");
        }
        if (keysToFetch.contains("addresses")) {
            arrayList.add(Columns.DATA);
            arrayList.add(Columns.TYPE);
            arrayList.add(Columns.LABEL);
            arrayList.add(Columns.DATA_4);
            arrayList.add(Columns.DATA_5);
            arrayList.add(Columns.DATA_6);
            arrayList.add(Columns.DATA_7);
            arrayList.add(Columns.DATA_8);
            arrayList.add(Columns.DATA_9);
            arrayList.add(Columns.DATA_10);
            str = str + " OR mimetype=?";
            arrayList2.add("vnd.android.cursor.item/postal-address_v2");
        }
        if (keysToFetch.contains("note")) {
            str = str + " OR mimetype=?";
            arrayList2.add("vnd.android.cursor.item/note");
        }
        if (keysToFetch.contains(DateModelKt.BIRTHDAY) || keysToFetch.contains("dates")) {
            str = str + " OR mimetype=?";
            arrayList2.add("vnd.android.cursor.item/contact_event");
        }
        if (keysToFetch.contains("instantMessageAddresses")) {
            arrayList.add(Columns.DATA);
            arrayList.add(Columns.TYPE);
            arrayList.add(Columns.DATA_5);
            arrayList.add(Columns.ID);
            str = str + " OR mimetype=?";
            arrayList2.add("vnd.android.cursor.item/im");
        }
        if (keysToFetch.contains("urlAddresses")) {
            arrayList.add(Columns.DATA);
            arrayList.add(Columns.TYPE);
            arrayList.add(Columns.ID);
            str = str + " OR mimetype=?";
            arrayList2.add("vnd.android.cursor.item/website");
        }
        if (keysToFetch.contains("extraNames")) {
            str = str + " OR mimetype=?";
            arrayList2.add("vnd.android.cursor.item/nickname");
        }
        if (keysToFetch.contains("relationships")) {
            arrayList.add(Columns.DATA);
            arrayList.add(Columns.TYPE);
            arrayList.add(Columns.ID);
            str = str + " OR mimetype=?";
            arrayList2.add("vnd.android.cursor.item/relation");
        }
        if (keysToFetch.contains("phoneticFirstName")) {
            arrayList.add(Columns.DATA_7);
        }
        if (keysToFetch.contains("phoneticLastName")) {
            arrayList.add(Columns.DATA_9);
        }
        if (keysToFetch.contains("phoneticMiddleName")) {
            arrayList.add(Columns.DATA_8);
        }
        if (keysToFetch.contains("namePrefix")) {
            arrayList.add(Columns.DATA_4);
        }
        if (keysToFetch.contains("nameSuffix")) {
            arrayList.add(Columns.DATA_6);
        }
        if (keysToFetch.contains("isFavorite")) {
            arrayList.add(Columns.STARRED);
        }
        return new QueryArguments((String[]) arrayList.toArray(new String[0]), str, (String[]) arrayList2.toArray(new String[0]));
    }

    private final ContactPage fetchContacts(int pageOffset, int pageSize, String[] queryStrings, String initQueryField, Set<String> keysToFetch, String sortOrder) throws Exceptions.ReactContextLost {
        Cursor cursorQuery;
        if (initQueryField == null) {
            initQueryField = Columns.CONTACT_ID;
        }
        boolean z = true;
        boolean z2 = pageSize == 0;
        QueryArguments queryArgumentsCreateProjectionForQuery = createProjectionForQuery(keysToFetch);
        ContentResolver resolver = getResolver();
        if (queryStrings != null && queryStrings.length != 0) {
            cursorQuery = resolver.query(ContactsContract.Data.CONTENT_URI, queryArgumentsCreateProjectionForQuery.getProjection(), initQueryField + " LIKE ?", queryStrings, null);
        } else {
            cursorQuery = resolver.query(ContactsContract.Data.CONTENT_URI, queryArgumentsCreateProjectionForQuery.getProjection(), queryArgumentsCreateProjectionForQuery.getSelection(), queryArgumentsCreateProjectionForQuery.getSelectionArgs(), null);
        }
        if (cursorQuery == null) {
            return null;
        }
        Cursor cursor = cursorQuery;
        try {
            Map<String, Contact> mapLoadContactsFrom = loadContactsFrom(cursor);
            ArrayList arrayList = new ArrayList();
            ArrayList<Contact> arrayListSortContactsBy = sortContactsBy(new ArrayList<>(mapLoadContactsFrom.values()), sortOrder);
            int size = arrayListSortContactsBy.size();
            for (int i = z2 ? 0 : pageOffset; i < size; i++) {
                Contact contact = arrayListSortContactsBy.get(i);
                Intrinsics.checkNotNullExpressionValue(contact, "get(...)");
                Contact contact2 = contact;
                if (!z2 && i - pageOffset >= pageSize) {
                    break;
                }
                arrayList.add(contact2);
            }
            ArrayList arrayList2 = arrayList;
            boolean z3 = pageOffset > 0;
            if (pageOffset + pageSize >= size) {
                z = false;
            }
            ContactPage contactPage = new ContactPage(arrayList2, z3, z, size);
            CloseableKt.closeFinally(cursor, null);
            return contactPage;
        } finally {
        }
    }

    private final ArrayList<Contact> sortContactsBy(ArrayList<Contact> input, String sortOrder) {
        if (Intrinsics.areEqual(sortOrder, "firstName")) {
            final AnonymousClass1 anonymousClass1 = new Function2<Contact, Contact, Integer>() { // from class: expo.modules.contacts.ContactsModule.sortContactsBy.1
                @Override // kotlin.jvm.functions.Function2
                public final Integer invoke(Contact contact, Contact contact2) {
                    return Integer.valueOf(StringsKt.compareTo(contact.getFinalFirstName(), contact2.getFinalFirstName(), true));
                }
            };
            CollectionsKt.sortWith(input, new Comparator() { // from class: expo.modules.contacts.ContactsModule$$ExternalSyntheticLambda0
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return ContactsModule.sortContactsBy$lambda$41(anonymousClass1, obj, obj2);
                }
            });
        } else if (Intrinsics.areEqual(sortOrder, "lastName")) {
            final AnonymousClass2 anonymousClass2 = new Function2<Contact, Contact, Integer>() { // from class: expo.modules.contacts.ContactsModule.sortContactsBy.2
                @Override // kotlin.jvm.functions.Function2
                public final Integer invoke(Contact contact, Contact contact2) {
                    return Integer.valueOf(StringsKt.compareTo(contact.getFinalLastName(), contact2.getFinalLastName(), true));
                }
            };
            CollectionsKt.sortWith(input, new Comparator() { // from class: expo.modules.contacts.ContactsModule$$ExternalSyntheticLambda1
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return ContactsModule.sortContactsBy$lambda$42(anonymousClass2, obj, obj2);
                }
            });
        }
        return input;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int sortContactsBy$lambda$41(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return ((Number) tmp0.invoke(obj, obj2)).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int sortContactsBy$lambda$42(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return ((Number) tmp0.invoke(obj, obj2)).intValue();
    }

    private final Map<String, Contact> loadContactsFrom(Cursor cursor) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        while (cursor.moveToNext()) {
            String string = cursor.getString(cursor.getColumnIndex(Columns.CONTACT_ID));
            Intrinsics.checkNotNull(string);
            Object contact = linkedHashMap.get(string);
            if (contact == null) {
                contact = new Contact(string, getAppContext());
                linkedHashMap.put(string, contact);
            }
            ((Contact) contact).fromCursor(cursor);
        }
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ensureReadPermission() throws MissingPermissionException {
        if (!getPermissionsManager().hasGrantedPermissions("android.permission.READ_CONTACTS")) {
            throw new MissingPermissionException("android.permission.READ_CONTACTS");
        }
    }

    private final void ensureWritePermission() throws MissingPermissionException {
        if (!getPermissionsManager().hasGrantedPermissions("android.permission.WRITE_CONTACTS")) {
            throw new MissingPermissionException("android.permission.WRITE_CONTACTS");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ensurePermissions() throws MissingPermissionException {
        ensureReadPermission();
        ensureWritePermission();
    }
}
