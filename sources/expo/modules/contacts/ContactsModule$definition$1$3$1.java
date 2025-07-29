package expo.modules.contacts;

import expo.modules.kotlin.Promise;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ContactsModule.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.contacts.ContactsModule$definition$1$3$1", f = "ContactsModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class ContactsModule$definition$1$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ContactQuery $options;
    final /* synthetic */ Promise $promise;
    int label;
    final /* synthetic */ ContactsModule this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ContactsModule$definition$1$3$1(ContactQuery contactQuery, Promise promise, ContactsModule contactsModule, Continuation<? super ContactsModule$definition$1$3$1> continuation) {
        super(2, continuation);
        this.$options = contactQuery;
        this.$promise = promise;
        this.this$0 = contactsModule;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ContactsModule$definition$1$3$1(this.$options, this.$promise, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ContactsModule$definition$1$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ContactPage allContactsAsync;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        List<String> id = this.$options.getId();
        if (id != null && !id.isEmpty()) {
            List<String> id2 = this.$options.getId();
            ContactsModule contactsModule = this.this$0;
            ContactQuery contactQuery = this.$options;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = id2.iterator();
            while (it.hasNext()) {
                Contact contactById = contactsModule.getContactById((String) it.next(), contactQuery.getFields());
                if (contactById != null) {
                    arrayList.add(contactById);
                }
            }
            this.$promise.resolve(ContactsModuleKt.toBundle(new ContactPage(arrayList, false, false, 0, 14, null), this.$options.getFields()));
            return Unit.INSTANCE;
        }
        String name = this.$options.getName();
        String str = name;
        if (str == null || StringsKt.isBlank(str)) {
            allContactsAsync = this.this$0.getAllContactsAsync(this.$options);
        } else {
            allContactsAsync = this.this$0.getContactByName("%" + name + "%", this.$options.getFields(), this.$options.getSort());
        }
        this.$promise.resolve(ContactsModuleKt.toBundle(allContactsAsync, this.$options.getFields()));
        return Unit.INSTANCE;
    }
}
