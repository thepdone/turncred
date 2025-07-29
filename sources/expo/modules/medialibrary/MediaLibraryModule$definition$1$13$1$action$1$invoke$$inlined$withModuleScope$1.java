package expo.modules.medialibrary;

import expo.modules.core.errors.ModuleDestroyedException;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.medialibrary.albums.DeleteAlbums;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: MediaLibraryModule.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "expo/modules/medialibrary/MediaLibraryModule$withModuleScope$1"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.medialibrary.MediaLibraryModule$definition$1$13$1$action$1$invoke$$inlined$withModuleScope$1", f = "MediaLibraryModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class MediaLibraryModule$definition$1$13$1$action$1$invoke$$inlined$withModuleScope$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List $albumIds$inlined;
    final /* synthetic */ Promise $promise;
    final /* synthetic */ Promise $promise$inlined;
    int label;
    final /* synthetic */ MediaLibraryModule this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaLibraryModule$definition$1$13$1$action$1$invoke$$inlined$withModuleScope$1(Promise promise, Continuation continuation, MediaLibraryModule mediaLibraryModule, List list, Promise promise2) {
        super(2, continuation);
        this.$promise = promise;
        this.this$0 = mediaLibraryModule;
        this.$albumIds$inlined = list;
        this.$promise$inlined = promise2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MediaLibraryModule$definition$1$13$1$action$1$invoke$$inlined$withModuleScope$1(this.$promise, continuation, this.this$0, this.$albumIds$inlined, this.$promise$inlined);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MediaLibraryModule$definition$1$13$1$action$1$invoke$$inlined$withModuleScope$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        try {
            new DeleteAlbums(this.this$0.getContext(), this.$albumIds$inlined, this.$promise$inlined).execute();
        } catch (ModuleDestroyedException e) {
            Promise promise = this.$promise;
            String tAG$expo_media_library_release = MediaLibraryModule.INSTANCE.getTAG$expo_media_library_release();
            Intrinsics.checkNotNullExpressionValue(tAG$expo_media_library_release, "<get-TAG>(...)");
            promise.reject(tAG$expo_media_library_release, "MediaLibrary module destroyed", e);
        } catch (CodedException e2) {
            this.$promise.reject(e2);
        }
        return Unit.INSTANCE;
    }
}
