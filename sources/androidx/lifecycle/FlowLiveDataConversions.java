package androidx.lifecycle;

import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.camera.camera2.internal.Camera2CameraInfoImpl;
import androidx.exifinterface.media.ExifInterface;
import com.nimbusds.jose.jwk.gen.OctetSequenceKeyGenerator;
import io.sentry.ProfilingTraceData;
import java.time.Duration;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;

/* compiled from: FlowLiveData.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003\u001a0\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007\u001a2\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000b"}, d2 = {"asFlow", "Lkotlinx/coroutines/flow/Flow;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/LiveData;", "asLiveData", ProfilingTraceData.TRUNCATION_REASON_TIMEOUT, "Ljava/time/Duration;", "context", "Lkotlin/coroutines/CoroutineContext;", "timeoutInMs", "", "lifecycle-livedata_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FlowLiveDataConversions {
    public static final <T> LiveData<T> asLiveData(Flow<? extends T> flow) {
        Intrinsics.checkNotNullParameter(flow, "<this>");
        return asLiveData$default(flow, (CoroutineContext) null, 0L, 3, (Object) null);
    }

    public static final <T> LiveData<T> asLiveData(Flow<? extends T> flow, CoroutineContext context) {
        Intrinsics.checkNotNullParameter(flow, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        return asLiveData$default(flow, context, 0L, 2, (Object) null);
    }

    public static /* synthetic */ LiveData asLiveData$default(Flow flow, CoroutineContext coroutineContext, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i & 2) != 0) {
            j = 5000;
        }
        return asLiveData(flow, coroutineContext, j);
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: FlowLiveData.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/LiveDataScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.lifecycle.FlowLiveDataConversions$asLiveData$1", f = "FlowLiveData.kt", i = {}, l = {78}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.lifecycle.FlowLiveDataConversions$asLiveData$1, reason: invalid class name and case insensitive filesystem */
    static final class C04261<T> extends SuspendLambda implements Function2<LiveDataScope<T>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Flow<T> $this_asLiveData;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C04261(Flow<? extends T> flow, Continuation<? super C04261> continuation) {
            super(2, continuation);
            this.$this_asLiveData = flow;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C04261 c04261 = new C04261(this.$this_asLiveData, continuation);
            c04261.L$0 = obj;
            return c04261;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(LiveDataScope<T> liveDataScope, Continuation<? super Unit> continuation) {
            return ((C04261) create(liveDataScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final LiveDataScope liveDataScope = (LiveDataScope) this.L$0;
                this.label = 1;
                if (this.$this_asLiveData.collect(new FlowCollector() { // from class: androidx.lifecycle.FlowLiveDataConversions.asLiveData.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(T t, Continuation<? super Unit> continuation) {
                        Object objEmit = liveDataScope.emit(t, continuation);
                        return objEmit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEmit : Unit.INSTANCE;
                    }
                }, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> LiveData<T> asLiveData(Flow<? extends T> flow, CoroutineContext context, long j) {
        Intrinsics.checkNotNullParameter(flow, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Camera2CameraInfoImpl.RedirectableLiveData redirectableLiveData = (LiveData<T>) CoroutineLiveDataKt.liveData(context, j, new C04261(flow, null));
        if (flow instanceof StateFlow) {
            if (ArchTaskExecutor.getInstance().isMainThread()) {
                redirectableLiveData.setValue(((StateFlow) flow).getValue());
            } else {
                redirectableLiveData.postValue(((StateFlow) flow).getValue());
            }
        }
        return redirectableLiveData;
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: FlowLiveData.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1", f = "FlowLiveData.kt", i = {0, 1, 2}, l = {107, OctetSequenceKeyGenerator.MIN_KEY_SIZE_BITS, 113, 115}, m = "invokeSuspend", n = {"observer", "observer", "observer"}, s = {"L$0", "L$0", "L$0"})
    /* renamed from: androidx.lifecycle.FlowLiveDataConversions$asFlow$1, reason: invalid class name */
    static final class AnonymousClass1<T> extends SuspendLambda implements Function2<ProducerScope<? super T>, Continuation<? super Unit>, Object> {
        final /* synthetic */ LiveData<T> $this_asFlow;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(LiveData<T> liveData, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$this_asFlow = liveData;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_asFlow, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ProducerScope<? super T> producerScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:28:0x009b A[RETURN] */
        /* JADX WARN: Type inference failed for: r1v0, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [androidx.lifecycle.Observer] */
        /* JADX WARN: Type inference failed for: r1v15 */
        /* JADX WARN: Type inference failed for: r1v16 */
        /* JADX WARN: Type inference failed for: r1v8 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
            /*
                r9 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r9.label
                r2 = 4
                r3 = 3
                r4 = 2
                r5 = 1
                r6 = 0
                if (r1 == 0) goto L40
                if (r1 == r5) goto L38
                if (r1 == r4) goto L2e
                if (r1 == r3) goto L26
                if (r1 == r2) goto L1d
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L1d:
                java.lang.Object r0 = r9.L$0
                java.lang.Throwable r0 = (java.lang.Throwable) r0
                kotlin.ResultKt.throwOnFailure(r10)
                goto Lca
            L26:
                java.lang.Object r1 = r9.L$0
                androidx.lifecycle.Observer r1 = (androidx.lifecycle.Observer) r1
                kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Throwable -> L36
                goto L9c
            L2e:
                java.lang.Object r1 = r9.L$0
                androidx.lifecycle.Observer r1 = (androidx.lifecycle.Observer) r1
                kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Throwable -> L36
                goto L8e
            L36:
                r10 = move-exception
                goto La2
            L38:
                java.lang.Object r1 = r9.L$0
                androidx.lifecycle.Observer r1 = (androidx.lifecycle.Observer) r1
                kotlin.ResultKt.throwOnFailure(r10)
                goto L6d
            L40:
                kotlin.ResultKt.throwOnFailure(r10)
                java.lang.Object r10 = r9.L$0
                kotlinx.coroutines.channels.ProducerScope r10 = (kotlinx.coroutines.channels.ProducerScope) r10
                androidx.lifecycle.FlowLiveDataConversions$asFlow$1$$ExternalSyntheticLambda0 r1 = new androidx.lifecycle.FlowLiveDataConversions$asFlow$1$$ExternalSyntheticLambda0
                r1.<init>()
                kotlinx.coroutines.MainCoroutineDispatcher r10 = kotlinx.coroutines.Dispatchers.getMain()
                kotlinx.coroutines.MainCoroutineDispatcher r10 = r10.getImmediate()
                kotlin.coroutines.CoroutineContext r10 = (kotlin.coroutines.CoroutineContext) r10
                androidx.lifecycle.FlowLiveDataConversions$asFlow$1$1 r7 = new androidx.lifecycle.FlowLiveDataConversions$asFlow$1$1
                androidx.lifecycle.LiveData<T> r8 = r9.$this_asFlow
                r7.<init>(r8, r1, r6)
                kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
                r8 = r9
                kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
                r9.L$0 = r1
                r9.label = r5
                java.lang.Object r10 = kotlinx.coroutines.BuildersKt.withContext(r10, r7, r8)
                if (r10 != r0) goto L6d
                return r0
            L6d:
                kotlinx.coroutines.MainCoroutineDispatcher r10 = kotlinx.coroutines.Dispatchers.getMain()     // Catch: java.lang.Throwable -> L36
                kotlinx.coroutines.MainCoroutineDispatcher r10 = r10.getImmediate()     // Catch: java.lang.Throwable -> L36
                kotlin.coroutines.CoroutineContext r10 = (kotlin.coroutines.CoroutineContext) r10     // Catch: java.lang.Throwable -> L36
                androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2 r5 = new androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2     // Catch: java.lang.Throwable -> L36
                androidx.lifecycle.LiveData<T> r7 = r9.$this_asFlow     // Catch: java.lang.Throwable -> L36
                r5.<init>(r7, r1, r6)     // Catch: java.lang.Throwable -> L36
                kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5     // Catch: java.lang.Throwable -> L36
                r7 = r9
                kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7     // Catch: java.lang.Throwable -> L36
                r9.L$0 = r1     // Catch: java.lang.Throwable -> L36
                r9.label = r4     // Catch: java.lang.Throwable -> L36
                java.lang.Object r10 = kotlinx.coroutines.BuildersKt.withContext(r10, r5, r7)     // Catch: java.lang.Throwable -> L36
                if (r10 != r0) goto L8e
                return r0
            L8e:
                r10 = r9
                kotlin.coroutines.Continuation r10 = (kotlin.coroutines.Continuation) r10     // Catch: java.lang.Throwable -> L36
                r9.L$0 = r1     // Catch: java.lang.Throwable -> L36
                r9.label = r3     // Catch: java.lang.Throwable -> L36
                java.lang.Object r10 = kotlinx.coroutines.DelayKt.awaitCancellation(r10)     // Catch: java.lang.Throwable -> L36
                if (r10 != r0) goto L9c
                return r0
            L9c:
                kotlin.KotlinNothingValueException r10 = new kotlin.KotlinNothingValueException     // Catch: java.lang.Throwable -> L36
                r10.<init>()     // Catch: java.lang.Throwable -> L36
                throw r10     // Catch: java.lang.Throwable -> L36
            La2:
                kotlinx.coroutines.MainCoroutineDispatcher r3 = kotlinx.coroutines.Dispatchers.getMain()
                kotlinx.coroutines.MainCoroutineDispatcher r3 = r3.getImmediate()
                kotlinx.coroutines.NonCancellable r4 = kotlinx.coroutines.NonCancellable.INSTANCE
                kotlin.coroutines.CoroutineContext r4 = (kotlin.coroutines.CoroutineContext) r4
                kotlin.coroutines.CoroutineContext r3 = r3.plus(r4)
                androidx.lifecycle.FlowLiveDataConversions$asFlow$1$3 r4 = new androidx.lifecycle.FlowLiveDataConversions$asFlow$1$3
                androidx.lifecycle.LiveData<T> r5 = r9.$this_asFlow
                r4.<init>(r5, r1, r6)
                kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
                r1 = r9
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r9.L$0 = r10
                r9.label = r2
                java.lang.Object r1 = kotlinx.coroutines.BuildersKt.withContext(r3, r4, r1)
                if (r1 != r0) goto Lc9
                return r0
            Lc9:
                r0 = r10
            Lca:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.FlowLiveDataConversions.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* compiled from: FlowLiveData.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1$1", f = "FlowLiveData.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: androidx.lifecycle.FlowLiveDataConversions$asFlow$1$1, reason: invalid class name and collision with other inner class name */
        static final class C00781 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Observer<T> $observer;
            final /* synthetic */ LiveData<T> $this_asFlow;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00781(LiveData<T> liveData, Observer<T> observer, Continuation<? super C00781> continuation) {
                super(2, continuation);
                this.$this_asFlow = liveData;
                this.$observer = observer;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00781(this.$this_asFlow, this.$observer, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C00781) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$this_asFlow.observeForever(this.$observer);
                return Unit.INSTANCE;
            }
        }

        /* compiled from: FlowLiveData.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2", f = "FlowLiveData.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2, reason: invalid class name */
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Observer<T> $observer;
            final /* synthetic */ LiveData<T> $this_asFlow;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(LiveData<T> liveData, Observer<T> observer, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.$this_asFlow = liveData;
                this.$observer = observer;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.$this_asFlow, this.$observer, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$this_asFlow.observeForever(this.$observer);
                return Unit.INSTANCE;
            }
        }

        /* compiled from: FlowLiveData.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1$3", f = "FlowLiveData.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: androidx.lifecycle.FlowLiveDataConversions$asFlow$1$3, reason: invalid class name */
        static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Observer<T> $observer;
            final /* synthetic */ LiveData<T> $this_asFlow;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass3(LiveData<T> liveData, Observer<T> observer, Continuation<? super AnonymousClass3> continuation) {
                super(2, continuation);
                this.$this_asFlow = liveData;
                this.$observer = observer;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass3(this.$this_asFlow, this.$observer, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$this_asFlow.removeObserver(this.$observer);
                return Unit.INSTANCE;
            }
        }
    }

    public static final <T> Flow<T> asFlow(LiveData<T> liveData) {
        Intrinsics.checkNotNullParameter(liveData, "<this>");
        return FlowKt.conflate(FlowKt.callbackFlow(new AnonymousClass1(liveData, null)));
    }

    public static /* synthetic */ LiveData asLiveData$default(Flow flow, Duration duration, CoroutineContext coroutineContext, int i, Object obj) {
        if ((i & 2) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return asLiveData(flow, duration, coroutineContext);
    }

    public static final <T> LiveData<T> asLiveData(Flow<? extends T> flow, Duration timeout, CoroutineContext context) {
        Intrinsics.checkNotNullParameter(flow, "<this>");
        Intrinsics.checkNotNullParameter(timeout, "timeout");
        Intrinsics.checkNotNullParameter(context, "context");
        return asLiveData(flow, context, Api26Impl.INSTANCE.toMillis(timeout));
    }
}
