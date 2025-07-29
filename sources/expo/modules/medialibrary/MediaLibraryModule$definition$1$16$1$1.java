package expo.modules.medialibrary;

import expo.modules.kotlin.Promise;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.medialibrary.albums.migration.CheckIfAlbumShouldBeMigrated;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: MediaLibraryModule.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.medialibrary.MediaLibraryModule$definition$1$16$1$1", f = "MediaLibraryModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class MediaLibraryModule$definition$1$16$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $albumId;
    final /* synthetic */ Promise $promise;
    int label;
    final /* synthetic */ MediaLibraryModule this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MediaLibraryModule$definition$1$16$1$1(MediaLibraryModule mediaLibraryModule, String str, Promise promise, Continuation<? super MediaLibraryModule$definition$1$16$1$1> continuation) {
        super(2, continuation);
        this.this$0 = mediaLibraryModule;
        this.$albumId = str;
        this.$promise = promise;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MediaLibraryModule$definition$1$16$1$1(this.this$0, this.$albumId, this.$promise, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MediaLibraryModule$definition$1$16$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        try {
            new CheckIfAlbumShouldBeMigrated(this.this$0.getContext(), this.$albumId, this.$promise).execute();
        } catch (CodedException e) {
            this.$promise.reject(e);
        }
        return Unit.INSTANCE;
    }
}
