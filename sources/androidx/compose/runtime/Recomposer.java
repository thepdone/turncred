package androidx.compose.runtime;

import androidx.collection.MutableScatterSet;
import androidx.compose.runtime.Recomposer;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.collection.ScatterSetWrapperKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet;
import androidx.compose.runtime.snapshots.MutableSnapshot;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotApplyResult;
import androidx.compose.runtime.tooling.CompositionData;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.zxing.pdf417.PDF417Common;
import com.nimbusds.jose.jwk.JWKParameterNames;
import io.sentry.protocol.SentryStackTrace;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExceptionsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: Recomposer.kt */
@Metadata(d1 = {"\u0000\u009a\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 ½\u00012\u00020\u0001:\n½\u0001¾\u0001¿\u0001À\u0001Á\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010`\u001a\u00020_2\u0006\u0010a\u001a\u00020\u0007H\u0002J\u0010\u0010b\u001a\u00020_2\u0006\u0010c\u001a\u00020dH\u0002J\u0006\u0010e\u001a\u00020fJ\u000e\u0010g\u001a\u00020_H\u0086@¢\u0006\u0002\u0010hJ\u000e\u0010i\u001a\u00020_H\u0082@¢\u0006\u0002\u0010hJ\u0006\u0010j\u001a\u00020_J\b\u0010k\u001a\u00020_H\u0002J\u0006\u0010l\u001a\u00020_J*\u0010m\u001a\u00020_2\u0006\u0010a\u001a\u00020\u00072\u0011\u0010n\u001a\r\u0012\u0004\u0012\u00020_0o¢\u0006\u0002\bpH\u0010¢\u0006\u0004\bq\u0010rJ:\u0010s\u001a\u0002Ht\"\u0004\b\u0000\u0010t2\u0006\u0010a\u001a\u00020\u00072\u000e\u0010u\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010U2\f\u0010v\u001a\b\u0012\u0004\u0012\u0002Ht0oH\u0082\b¢\u0006\u0002\u0010wJ\u0015\u0010x\u001a\u00020_2\u0006\u0010y\u001a\u00020\"H\u0010¢\u0006\u0002\bzJ\u0010\u0010{\u001a\n\u0012\u0004\u0012\u00020_\u0018\u00010^H\u0002J\b\u0010|\u001a\u00020_H\u0002J\u0015\u0010}\u001a\u00020_2\u0006\u0010y\u001a\u00020\"H\u0010¢\u0006\u0002\b~J\u0016\u0010\u007f\u001a\u00020_2\u0006\u0010a\u001a\u00020\u0007H\u0010¢\u0006\u0003\b\u0080\u0001J\u0019\u0010\u0081\u0001\u001a\u00020_2\b\u0010\u0082\u0001\u001a\u00030\u0083\u0001H\u0010¢\u0006\u0003\b\u0084\u0001J\u000f\u0010\u0085\u0001\u001a\u00020_H\u0086@¢\u0006\u0002\u0010hJ \u0010\u0086\u0001\u001a\u00020_2\u0006\u0010y\u001a\u00020\"2\u0007\u0010\u0087\u0001\u001a\u00020#H\u0010¢\u0006\u0003\b\u0088\u0001J\u0019\u0010\u0089\u0001\u001a\u0004\u0018\u00010#2\u0006\u0010y\u001a\u00020\"H\u0010¢\u0006\u0003\b\u008a\u0001J\u0007\u0010\u008b\u0001\u001a\u00020_J\u0011\u0010\u008c\u0001\u001a\u00020_2\u0006\u0010a\u001a\u00020\u0007H\u0002J.\u0010\u008d\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\r\u0010\u008e\u0001\u001a\b\u0012\u0004\u0012\u00020\"0\t2\u000e\u0010u\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010UH\u0002J#\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u00072\u0006\u0010a\u001a\u00020\u00072\u000e\u0010u\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010UH\u0002J0\u0010\u0090\u0001\u001a\u00020_2\r\u0010\u0091\u0001\u001a\b0\u0092\u0001j\u0003`\u0093\u00012\u000b\b\u0002\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u00072\t\b\u0002\u0010\u0095\u0001\u001a\u00020\u0017H\u0002J\u001e\u0010\u0096\u0001\u001a\u000f\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020_0\u0097\u00012\u0006\u0010a\u001a\u00020\u0007H\u0002JV\u0010\u0098\u0001\u001a\u00020_2D\u0010v\u001a@\b\u0001\u0012\u0005\u0012\u00030\u009a\u0001\u0012\u0017\u0012\u00150\u009b\u0001¢\u0006\u000f\b\u009c\u0001\u0012\n\b\u009d\u0001\u0012\u0005\b\b(\u009e\u0001\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020_0\u009f\u0001\u0012\u0006\u0012\u0004\u0018\u00010'0\u0099\u0001¢\u0006\u0003\b \u0001H\u0082@¢\u0006\u0003\u0010¡\u0001J\t\u0010¢\u0001\u001a\u00020\u0017H\u0002J \u0010¢\u0001\u001a\u00020_2\u0014\u0010£\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020_0\u0097\u0001H\u0082\bJ\u0011\u0010¤\u0001\u001a\u00020_2\u0006\u0010a\u001a\u00020\u0007H\u0002J\u001f\u0010¥\u0001\u001a\u00020_2\u000e\u0010¦\u0001\u001a\t\u0012\u0005\u0012\u00030§\u00010*H\u0010¢\u0006\u0003\b¨\u0001J\u0017\u0010©\u0001\u001a\u00020_2\u0006\u0010a\u001a\u00020\u0007H\u0010¢\u0006\u0003\bª\u0001J\u0012\u0010«\u0001\u001a\u00020_2\u0007\u0010¬\u0001\u001a\u00020QH\u0002J\u0011\u0010\u00ad\u0001\u001a\u00020_2\u0006\u0010a\u001a\u00020\u0007H\u0002J\u0017\u0010®\u0001\u001a\u00020_2\u0006\u0010a\u001a\u00020\u0007H\u0010¢\u0006\u0003\b¯\u0001J\u000b\u0010°\u0001\u001a\u0004\u0018\u000109H\u0002J\u0007\u0010±\u0001\u001a\u00020_J\t\u0010²\u0001\u001a\u00020_H\u0002J$\u0010³\u0001\u001a\u00020_2\b\u0010\u009e\u0001\u001a\u00030\u009b\u00012\b\u0010´\u0001\u001a\u00030µ\u0001H\u0082@¢\u0006\u0003\u0010¶\u0001J\u000f\u0010·\u0001\u001a\u00020_H\u0086@¢\u0006\u0002\u0010hJ\u0018\u0010¸\u0001\u001a\u00020_2\u0006\u0010L\u001a\u00020\u0003H\u0087@¢\u0006\u0003\u0010¹\u0001J\u0017\u0010º\u0001\u001a\u00020_2\u0006\u0010a\u001a\u00020\u0007H\u0010¢\u0006\u0003\b»\u0001J.\u0010¼\u0001\u001a\u000f\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020_0\u0097\u00012\u0006\u0010a\u001a\u00020\u00072\u000e\u0010u\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010UH\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u00178PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00178PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00178PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0019R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00070\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#0!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020\"0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010%\u001a\u001c\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010'0&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\u00060!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010+\u001a\u00020,8PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u000e\u0010/\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u00100\u001a\b\u0012\u0004\u0012\u00020\f018F¢\u0006\u0006\u001a\u0004\b2\u00103R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u000e\u00106\u001a\u000207X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010:\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010<\u001a\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b=\u0010\u0019R\u0014\u0010>\u001a\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b?\u0010\u0019R\u0014\u0010@\u001a\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bA\u0010\u0019R\u0014\u0010B\u001a\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bC\u0010\u0019R\u0011\u0010D\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\bE\u0010\u0019R\u0014\u0010F\u001a\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bG\u0010\u0019R\u000e\u0010H\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00070\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010KR\u0014\u0010L\u001a\u00020\u00038PX\u0090\u0004¢\u0006\u0006\u001a\u0004\bM\u00105R\u0012\u0010N\u001a\u00060OR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010P\u001a\u0004\u0018\u00010QX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010R\u001a\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bS\u0010\u0019R\u0014\u0010T\u001a\b\u0012\u0004\u0012\u00020'0UX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010V\u001a\b\u0012\u0004\u0012\u00020\f0W8FX\u0087\u0004¢\u0006\f\u0012\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[R\u000e\u0010\\\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010]\u001a\n\u0012\u0004\u0012\u00020_\u0018\u00010^X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Â\u0001"}, d2 = {"Landroidx/compose/runtime/Recomposer;", "Landroidx/compose/runtime/CompositionContext;", "effectCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/CoroutineContext;)V", "_knownCompositions", "", "Landroidx/compose/runtime/ControlledComposition;", "_knownCompositionsCache", "", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Landroidx/compose/runtime/Recomposer$State;", "broadcastFrameClock", "Landroidx/compose/runtime/BroadcastFrameClock;", "<set-?>", "", "changeCount", "getChangeCount", "()J", "closeCause", "", "collectingCallByInformation", "", "getCollectingCallByInformation$runtime_release", "()Z", "collectingParameterInformation", "getCollectingParameterInformation$runtime_release", "collectingSourceInformation", "getCollectingSourceInformation$runtime_release", "compositionInvalidations", "Landroidx/compose/runtime/collection/MutableVector;", "compositionValueStatesAvailable", "", "Landroidx/compose/runtime/MovableContentStateReference;", "Landroidx/compose/runtime/MovableContentState;", "compositionValuesAwaitingInsert", "compositionValuesRemoved", "Landroidx/compose/runtime/MovableContent;", "", "compositionsAwaitingApply", "compositionsRemoved", "", "compoundHashKey", "", "getCompoundHashKey$runtime_release", "()I", "concurrentCompositionsOutstanding", "currentState", "Lkotlinx/coroutines/flow/StateFlow;", "getCurrentState", "()Lkotlinx/coroutines/flow/StateFlow;", "getEffectCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "effectJob", "Lkotlinx/coroutines/CompletableJob;", "errorState", "Landroidx/compose/runtime/Recomposer$RecomposerErrorState;", "failedCompositions", "frameClockPaused", "hasBroadcastFrameClockAwaiters", "getHasBroadcastFrameClockAwaiters", "hasBroadcastFrameClockAwaitersLocked", "getHasBroadcastFrameClockAwaitersLocked", "hasConcurrentFrameWorkLocked", "getHasConcurrentFrameWorkLocked", "hasFrameWorkLocked", "getHasFrameWorkLocked", "hasPendingWork", "getHasPendingWork", "hasSchedulingWork", "getHasSchedulingWork", "isClosed", "knownCompositions", "getKnownCompositions", "()Ljava/util/List;", "recomposeCoroutineContext", "getRecomposeCoroutineContext$runtime_release", "recomposerInfo", "Landroidx/compose/runtime/Recomposer$RecomposerInfoImpl;", "runnerJob", "Lkotlinx/coroutines/Job;", "shouldKeepRecomposing", "getShouldKeepRecomposing", "snapshotInvalidations", "Landroidx/collection/MutableScatterSet;", "state", "Lkotlinx/coroutines/flow/Flow;", "getState$annotations", "()V", "getState", "()Lkotlinx/coroutines/flow/Flow;", "stateLock", "workContinuation", "Lkotlinx/coroutines/CancellableContinuation;", "", "addKnownCompositionLocked", "composition", "applyAndCheck", SentryStackTrace.JsonKeys.SNAPSHOT, "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "asRecomposerInfo", "Landroidx/compose/runtime/RecomposerInfo;", "awaitIdle", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitWorkAvailable", "cancel", "clearKnownCompositionsLocked", "close", "composeInitial", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "composeInitial$runtime_release", "(Landroidx/compose/runtime/ControlledComposition;Lkotlin/jvm/functions/Function2;)V", "composing", ExifInterface.GPS_DIRECTION_TRUE, "modifiedValues", "block", "(Landroidx/compose/runtime/ControlledComposition;Landroidx/collection/MutableScatterSet;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "deletedMovableContent", "reference", "deletedMovableContent$runtime_release", "deriveStateLocked", "discardUnusedValues", "insertMovableContent", "insertMovableContent$runtime_release", "invalidate", "invalidate$runtime_release", "invalidateScope", "scope", "Landroidx/compose/runtime/RecomposeScopeImpl;", "invalidateScope$runtime_release", "join", "movableContentStateReleased", "data", "movableContentStateReleased$runtime_release", "movableContentStateResolve", "movableContentStateResolve$runtime_release", "pauseCompositionFrameClock", "performInitialMovableContentInserts", "performInsertValues", "references", "performRecompose", "processCompositionError", JWKParameterNames.RSA_EXPONENT, "Ljava/lang/Exception;", "Lkotlin/Exception;", "failedInitialComposition", "recoverable", "readObserverOf", "Lkotlin/Function1;", "recompositionRunner", "Lkotlin/Function3;", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/compose/runtime/MonotonicFrameClock;", "Lkotlin/ParameterName;", "name", "parentFrameClock", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recordComposerModifications", "onEachInvalidComposition", "recordFailedCompositionLocked", "recordInspectionTable", "table", "Landroidx/compose/runtime/tooling/CompositionData;", "recordInspectionTable$runtime_release", "registerComposition", "registerComposition$runtime_release", "registerRunnerJob", "callingJob", "removeKnownCompositionLocked", "reportRemovedComposition", "reportRemovedComposition$runtime_release", "resetErrorState", "resumeCompositionFrameClock", "retryFailedCompositions", "runFrameLoop", "frameSignal", "Landroidx/compose/runtime/ProduceFrameSignal;", "(Landroidx/compose/runtime/MonotonicFrameClock;Landroidx/compose/runtime/ProduceFrameSignal;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runRecomposeAndApplyChanges", "runRecomposeConcurrentlyAndApplyChanges", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unregisterComposition", "unregisterComposition$runtime_release", "writeObserverOf", "Companion", "HotReloadable", "RecomposerErrorState", "RecomposerInfoImpl", "State", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Recomposer extends CompositionContext {
    private final List<ControlledComposition> _knownCompositions;
    private List<? extends ControlledComposition> _knownCompositionsCache;
    private final MutableStateFlow<State> _state;
    private final BroadcastFrameClock broadcastFrameClock;
    private long changeCount;
    private Throwable closeCause;
    private final MutableVector<ControlledComposition> compositionInvalidations;
    private final Map<MovableContentStateReference, MovableContentState> compositionValueStatesAvailable;
    private final List<MovableContentStateReference> compositionValuesAwaitingInsert;
    private final Map<MovableContent<Object>, List<MovableContentStateReference>> compositionValuesRemoved;
    private final List<ControlledComposition> compositionsAwaitingApply;
    private Set<ControlledComposition> compositionsRemoved;
    private int concurrentCompositionsOutstanding;
    private final CoroutineContext effectCoroutineContext;
    private final CompletableJob effectJob;
    private RecomposerErrorState errorState;
    private List<ControlledComposition> failedCompositions;
    private boolean frameClockPaused;
    private boolean isClosed;
    private final RecomposerInfoImpl recomposerInfo;
    private Job runnerJob;
    private MutableScatterSet<Object> snapshotInvalidations;
    private final Object stateLock;
    private CancellableContinuation<? super Unit> workContinuation;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final MutableStateFlow<PersistentSet<RecomposerInfoImpl>> _runningRecomposers = StateFlowKt.MutableStateFlow(ExtensionsKt.persistentSetOf());
    private static final AtomicReference<Boolean> _hotReloadEnabled = new AtomicReference<>(false);

    /* compiled from: Recomposer.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Landroidx/compose/runtime/Recomposer$State;", "", "(Ljava/lang/String;I)V", "ShutDown", "ShuttingDown", "Inactive", "InactivePendingWork", "Idle", "PendingWork", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum State {
        ShutDown,
        ShuttingDown,
        Inactive,
        InactivePendingWork,
        Idle,
        PendingWork
    }

    /* compiled from: Recomposer.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.runtime.Recomposer", f = "Recomposer.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {921, PDF417Common.MAX_CODEWORDS_IN_BARCODE}, m = "runFrameLoop", n = {"this", "parentFrameClock", "frameSignal", "toRecompose", "toApply", "this", "parentFrameClock", "frameSignal", "toRecompose", "toApply"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4"})
    /* renamed from: androidx.compose.runtime.Recomposer$runFrameLoop$1, reason: invalid class name and case insensitive filesystem */
    static final class C03601 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C03601(Continuation<? super C03601> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Recomposer.this.runFrameLoop(null, null, this);
        }
    }

    @Deprecated(message = "Replaced by currentState as a StateFlow", replaceWith = @ReplaceWith(expression = "currentState", imports = {}))
    public static /* synthetic */ void getState$annotations() {
    }

    @Override // androidx.compose.runtime.CompositionContext
    /* renamed from: getCollectingParameterInformation$runtime_release */
    public boolean getCollectingParameterInformation() {
        return false;
    }

    @Override // androidx.compose.runtime.CompositionContext
    /* renamed from: getCollectingSourceInformation$runtime_release */
    public boolean getCollectingSourceInformation() {
        return false;
    }

    @Override // androidx.compose.runtime.CompositionContext
    /* renamed from: getCompoundHashKey$runtime_release */
    public int getCompoundHashKey() {
        return 1000;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void recordInspectionTable$runtime_release(Set<CompositionData> table) {
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void registerComposition$runtime_release(ControlledComposition composition) {
    }

    public Recomposer(CoroutineContext coroutineContext) {
        BroadcastFrameClock broadcastFrameClock = new BroadcastFrameClock(new Function0<Unit>() { // from class: androidx.compose.runtime.Recomposer$broadcastFrameClock$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                CancellableContinuation cancellableContinuationDeriveStateLocked;
                Object obj = this.this$0.stateLock;
                Recomposer recomposer = this.this$0;
                synchronized (obj) {
                    cancellableContinuationDeriveStateLocked = recomposer.deriveStateLocked();
                    if (((Recomposer.State) recomposer._state.getValue()).compareTo(Recomposer.State.ShuttingDown) <= 0) {
                        throw ExceptionsKt.CancellationException("Recomposer shutdown; frame clock awaiter will never resume", recomposer.closeCause);
                    }
                }
                if (cancellableContinuationDeriveStateLocked != null) {
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuationDeriveStateLocked.resumeWith(Result.m5937constructorimpl(Unit.INSTANCE));
                }
            }
        });
        this.broadcastFrameClock = broadcastFrameClock;
        this.stateLock = new Object();
        this._knownCompositions = new ArrayList();
        this.snapshotInvalidations = new MutableScatterSet<>(0, 1, null);
        this.compositionInvalidations = new MutableVector<>(new ControlledComposition[16], 0);
        this.compositionsAwaitingApply = new ArrayList();
        this.compositionValuesAwaitingInsert = new ArrayList();
        this.compositionValuesRemoved = new LinkedHashMap();
        this.compositionValueStatesAvailable = new LinkedHashMap();
        this._state = StateFlowKt.MutableStateFlow(State.Inactive);
        CompletableJob completableJobJob = JobKt.Job((Job) coroutineContext.get(Job.INSTANCE));
        completableJobJob.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.compose.runtime.Recomposer$effectJob$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(final Throwable th) {
                CancellableContinuation cancellableContinuation;
                CancellableContinuation cancellableContinuation2;
                CancellationException CancellationException = ExceptionsKt.CancellationException("Recomposer effect job completed", th);
                Object obj = this.this$0.stateLock;
                final Recomposer recomposer = this.this$0;
                synchronized (obj) {
                    Job job = recomposer.runnerJob;
                    cancellableContinuation = null;
                    if (job != null) {
                        recomposer._state.setValue(Recomposer.State.ShuttingDown);
                        if (recomposer.isClosed) {
                            if (recomposer.workContinuation != null) {
                                cancellableContinuation2 = recomposer.workContinuation;
                            }
                            recomposer.workContinuation = null;
                            job.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.compose.runtime.Recomposer$effectJob$1$1$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Throwable th2) {
                                    invoke2(th2);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(Throwable th2) {
                                    Object obj2 = recomposer.stateLock;
                                    Recomposer recomposer2 = recomposer;
                                    Throwable th3 = th;
                                    synchronized (obj2) {
                                        if (th3 != null) {
                                            if (th2 != null) {
                                                if (th2 instanceof CancellationException) {
                                                    th2 = null;
                                                }
                                                if (th2 != null) {
                                                    kotlin.ExceptionsKt.addSuppressed(th3, th2);
                                                }
                                            }
                                        }
                                        th3 = null;
                                        recomposer2.closeCause = th3;
                                        recomposer2._state.setValue(Recomposer.State.ShutDown);
                                        Unit unit = Unit.INSTANCE;
                                    }
                                }
                            });
                            cancellableContinuation = cancellableContinuation2;
                        } else {
                            job.cancel(CancellationException);
                        }
                        cancellableContinuation2 = null;
                        recomposer.workContinuation = null;
                        job.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.compose.runtime.Recomposer$effectJob$1$1$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Throwable th2) {
                                invoke2(th2);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Throwable th2) {
                                Object obj2 = recomposer.stateLock;
                                Recomposer recomposer2 = recomposer;
                                Throwable th3 = th;
                                synchronized (obj2) {
                                    if (th3 != null) {
                                        if (th2 != null) {
                                            if (th2 instanceof CancellationException) {
                                                th2 = null;
                                            }
                                            if (th2 != null) {
                                                kotlin.ExceptionsKt.addSuppressed(th3, th2);
                                            }
                                        }
                                    }
                                    th3 = null;
                                    recomposer2.closeCause = th3;
                                    recomposer2._state.setValue(Recomposer.State.ShutDown);
                                    Unit unit = Unit.INSTANCE;
                                }
                            }
                        });
                        cancellableContinuation = cancellableContinuation2;
                    } else {
                        recomposer.closeCause = CancellationException;
                        recomposer._state.setValue(Recomposer.State.ShutDown);
                        Unit unit = Unit.INSTANCE;
                    }
                }
                if (cancellableContinuation != null) {
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m5937constructorimpl(Unit.INSTANCE));
                }
            }
        });
        this.effectJob = completableJobJob;
        this.effectCoroutineContext = coroutineContext.plus(broadcastFrameClock).plus(completableJobJob);
        this.recomposerInfo = new RecomposerInfoImpl();
    }

    public final long getChangeCount() {
        return this.changeCount;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final List<ControlledComposition> getKnownCompositions() {
        List list = this._knownCompositionsCache;
        List list2 = list;
        if (list == null) {
            List<ControlledComposition> list3 = this._knownCompositions;
            List listEmptyList = list3.isEmpty() ? CollectionsKt.emptyList() : new ArrayList(list3);
            this._knownCompositionsCache = listEmptyList;
            list2 = listEmptyList;
        }
        return list2;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public CoroutineContext getEffectCoroutineContext() {
        return this.effectCoroutineContext;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public CoroutineContext getRecomposeCoroutineContext$runtime_release() {
        return EmptyCoroutineContext.INSTANCE;
    }

    private final boolean getHasBroadcastFrameClockAwaitersLocked() {
        return !this.frameClockPaused && this.broadcastFrameClock.getHasAwaiters();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getHasBroadcastFrameClockAwaiters() {
        boolean hasBroadcastFrameClockAwaitersLocked;
        synchronized (this.stateLock) {
            hasBroadcastFrameClockAwaitersLocked = getHasBroadcastFrameClockAwaitersLocked();
        }
        return hasBroadcastFrameClockAwaitersLocked;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CancellableContinuation<Unit> deriveStateLocked() {
        State state;
        int i = 0;
        int i2 = 1;
        DefaultConstructorMarker defaultConstructorMarker = null;
        if (this._state.getValue().compareTo(State.ShuttingDown) <= 0) {
            clearKnownCompositionsLocked();
            this.snapshotInvalidations = new MutableScatterSet<>(i, i2, defaultConstructorMarker);
            this.compositionInvalidations.clear();
            this.compositionsAwaitingApply.clear();
            this.compositionValuesAwaitingInsert.clear();
            this.failedCompositions = null;
            CancellableContinuation<? super Unit> cancellableContinuation = this.workContinuation;
            if (cancellableContinuation != null) {
                CancellableContinuation.DefaultImpls.cancel$default(cancellableContinuation, null, 1, null);
            }
            this.workContinuation = null;
            this.errorState = null;
            return null;
        }
        if (this.errorState != null) {
            state = State.Inactive;
        } else if (this.runnerJob == null) {
            this.snapshotInvalidations = new MutableScatterSet<>(i, i2, defaultConstructorMarker);
            this.compositionInvalidations.clear();
            state = getHasBroadcastFrameClockAwaitersLocked() ? State.InactivePendingWork : State.Inactive;
        } else if (this.compositionInvalidations.isNotEmpty() || this.snapshotInvalidations.isNotEmpty() || !this.compositionsAwaitingApply.isEmpty() || !this.compositionValuesAwaitingInsert.isEmpty() || this.concurrentCompositionsOutstanding > 0 || getHasBroadcastFrameClockAwaitersLocked()) {
            state = State.PendingWork;
        } else {
            state = State.Idle;
        }
        this._state.setValue(state);
        if (state != State.PendingWork) {
            return null;
        }
        CancellableContinuation cancellableContinuation2 = this.workContinuation;
        this.workContinuation = null;
        return cancellableContinuation2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getShouldKeepRecomposing() {
        boolean z;
        synchronized (this.stateLock) {
            z = this.isClosed;
        }
        if (z) {
            Iterator<Job> it = this.effectJob.getChildren().iterator();
            while (it.hasNext()) {
                if (it.next().isActive()) {
                }
            }
            return false;
        }
        return true;
    }

    public final Flow<State> getState() {
        return getCurrentState();
    }

    public final StateFlow<State> getCurrentState() {
        return this._state;
    }

    /* compiled from: Recomposer.kt */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\u0006\u0010\u001a\u001a\u00020\u0015J\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cR\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Landroidx/compose/runtime/Recomposer$RecomposerInfoImpl;", "Landroidx/compose/runtime/RecomposerInfo;", "(Landroidx/compose/runtime/Recomposer;)V", "changeCount", "", "getChangeCount", "()J", "currentError", "Landroidx/compose/runtime/RecomposerErrorInfo;", "getCurrentError", "()Landroidx/compose/runtime/RecomposerErrorInfo;", "hasPendingWork", "", "getHasPendingWork", "()Z", "state", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/compose/runtime/Recomposer$State;", "getState", "()Lkotlinx/coroutines/flow/Flow;", "invalidateGroupsWithKey", "", SDKConstants.PARAM_KEY, "", "resetErrorState", "Landroidx/compose/runtime/Recomposer$RecomposerErrorState;", "retryFailedCompositions", "saveStateAndDisposeForHotReload", "", "Landroidx/compose/runtime/Recomposer$HotReloadable;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class RecomposerInfoImpl implements RecomposerInfo {
        public RecomposerInfoImpl() {
        }

        @Override // androidx.compose.runtime.RecomposerInfo
        public Flow<State> getState() {
            return Recomposer.this.getCurrentState();
        }

        @Override // androidx.compose.runtime.RecomposerInfo
        public boolean getHasPendingWork() {
            return Recomposer.this.getHasPendingWork();
        }

        @Override // androidx.compose.runtime.RecomposerInfo
        public long getChangeCount() {
            return Recomposer.this.getChangeCount();
        }

        public final RecomposerErrorInfo getCurrentError() {
            RecomposerErrorState recomposerErrorState;
            Object obj = Recomposer.this.stateLock;
            Recomposer recomposer = Recomposer.this;
            synchronized (obj) {
                recomposerErrorState = recomposer.errorState;
            }
            return recomposerErrorState;
        }

        public final void invalidateGroupsWithKey(int key) {
            List knownCompositions;
            Object obj = Recomposer.this.stateLock;
            Recomposer recomposer = Recomposer.this;
            synchronized (obj) {
                knownCompositions = recomposer.getKnownCompositions();
            }
            ArrayList arrayList = new ArrayList(knownCompositions.size());
            int size = knownCompositions.size();
            for (int i = 0; i < size; i++) {
                ControlledComposition controlledComposition = (ControlledComposition) knownCompositions.get(i);
                CompositionImpl compositionImpl = controlledComposition instanceof CompositionImpl ? (CompositionImpl) controlledComposition : null;
                if (compositionImpl != null) {
                    arrayList.add(compositionImpl);
                }
            }
            ArrayList arrayList2 = arrayList;
            int size2 = arrayList2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                ((CompositionImpl) arrayList2.get(i2)).invalidateGroupsWithKey(key);
            }
        }

        public final List<HotReloadable> saveStateAndDisposeForHotReload() {
            List knownCompositions;
            Object obj = Recomposer.this.stateLock;
            Recomposer recomposer = Recomposer.this;
            synchronized (obj) {
                knownCompositions = recomposer.getKnownCompositions();
            }
            ArrayList arrayList = new ArrayList(knownCompositions.size());
            int size = knownCompositions.size();
            for (int i = 0; i < size; i++) {
                ControlledComposition controlledComposition = (ControlledComposition) knownCompositions.get(i);
                CompositionImpl compositionImpl = controlledComposition instanceof CompositionImpl ? (CompositionImpl) controlledComposition : null;
                if (compositionImpl != null) {
                    arrayList.add(compositionImpl);
                }
            }
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList(arrayList2.size());
            int size2 = arrayList2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                HotReloadable hotReloadable = new HotReloadable((CompositionImpl) arrayList2.get(i2));
                hotReloadable.clearContent();
                arrayList3.add(hotReloadable);
            }
            return arrayList3;
        }

        public final RecomposerErrorState resetErrorState() {
            return Recomposer.this.resetErrorState();
        }

        public final void retryFailedCompositions() {
            Recomposer.this.retryFailedCompositions();
        }
    }

    /* compiled from: Recomposer.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\n\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\u0007J\u0006\u0010\f\u001a\u00020\u0007R\u001b\u0010\u0005\u001a\r\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/compose/runtime/Recomposer$HotReloadable;", "", "composition", "Landroidx/compose/runtime/CompositionImpl;", "(Landroidx/compose/runtime/CompositionImpl;)V", "composable", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "Lkotlin/jvm/functions/Function2;", "clearContent", "recompose", "resetContent", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class HotReloadable {
        private Function2<? super Composer, ? super Integer, Unit> composable;
        private final CompositionImpl composition;

        public HotReloadable(CompositionImpl compositionImpl) {
            this.composition = compositionImpl;
            this.composable = compositionImpl.getComposable();
        }

        public final void clearContent() {
            if (this.composition.getIsRoot()) {
                this.composition.setContent(ComposableSingletons$RecomposerKt.INSTANCE.m1735getLambda1$runtime_release());
            }
        }

        public final void resetContent() {
            this.composition.setComposable(this.composable);
        }

        public final void recompose() {
            if (this.composition.getIsRoot()) {
                this.composition.setContent(this.composable);
            }
        }
    }

    /* compiled from: Recomposer.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0002\u0010\u0007R\u0018\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/compose/runtime/Recomposer$RecomposerErrorState;", "Landroidx/compose/runtime/RecomposerErrorInfo;", "recoverable", "", "cause", "Ljava/lang/Exception;", "Lkotlin/Exception;", "(ZLjava/lang/Exception;)V", "getCause", "()Ljava/lang/Exception;", "getRecoverable", "()Z", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class RecomposerErrorState implements RecomposerErrorInfo {
        private final Exception cause;
        private final boolean recoverable;

        public RecomposerErrorState(boolean z, Exception exc) {
            this.recoverable = z;
            this.cause = exc;
        }

        @Override // androidx.compose.runtime.RecomposerErrorInfo
        public boolean getRecoverable() {
            return this.recoverable;
        }

        @Override // androidx.compose.runtime.RecomposerErrorInfo
        public Exception getCause() {
            return this.cause;
        }
    }

    public final RecomposerInfo asRecomposerInfo() {
        return this.recomposerInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean recordComposerModifications() {
        List<ControlledComposition> knownCompositions;
        boolean hasFrameWorkLocked;
        synchronized (this.stateLock) {
            if (this.snapshotInvalidations.isEmpty()) {
                return getHasFrameWorkLocked();
            }
            Set<? extends Object> setWrapIntoSet = ScatterSetWrapperKt.wrapIntoSet(this.snapshotInvalidations);
            DefaultConstructorMarker defaultConstructorMarker = null;
            int i = 1;
            int i2 = 0;
            this.snapshotInvalidations = new MutableScatterSet<>(i2, i, defaultConstructorMarker);
            synchronized (this.stateLock) {
                knownCompositions = getKnownCompositions();
            }
            try {
                Recomposer recomposer = this;
                int size = knownCompositions.size();
                for (int i3 = 0; i3 < size; i3++) {
                    knownCompositions.get(i3).recordModificationsOf(setWrapIntoSet);
                    if (this._state.getValue().compareTo(State.ShuttingDown) <= 0) {
                        break;
                    }
                }
                synchronized (this.stateLock) {
                    this.snapshotInvalidations = new MutableScatterSet<>(i2, i, defaultConstructorMarker);
                    Unit unit = Unit.INSTANCE;
                }
                synchronized (this.stateLock) {
                    if (deriveStateLocked() != null) {
                        throw new IllegalStateException("called outside of runRecomposeAndApplyChanges".toString());
                    }
                    hasFrameWorkLocked = getHasFrameWorkLocked();
                }
                return hasFrameWorkLocked;
            } catch (Throwable th) {
                synchronized (this.stateLock) {
                    this.snapshotInvalidations.addAll(setWrapIntoSet);
                    throw th;
                }
            }
        }
    }

    private final void recordComposerModifications(Function1<? super ControlledComposition, Unit> onEachInvalidComposition) {
        MutableScatterSet mutableScatterSet;
        int i;
        synchronized (this.stateLock) {
            int i2 = 1;
            try {
                mutableScatterSet = this.snapshotInvalidations;
                i = 0;
                if (mutableScatterSet.isNotEmpty()) {
                    this.snapshotInvalidations = new MutableScatterSet(i, i2, null);
                }
                InlineMarker.finallyStart(1);
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
        InlineMarker.finallyEnd(1);
        Set<? extends Object> setWrapIntoSet = ScatterSetWrapperKt.wrapIntoSet(mutableScatterSet);
        if (!setWrapIntoSet.isEmpty()) {
            List knownCompositions = getKnownCompositions();
            int size = knownCompositions.size();
            for (int i3 = 0; i3 < size; i3++) {
                ((ControlledComposition) knownCompositions.get(i3)).recordModificationsOf(setWrapIntoSet);
            }
        }
        MutableVector mutableVector = this.compositionInvalidations;
        int size2 = mutableVector.getSize();
        if (size2 > 0) {
            Object[] content = mutableVector.getContent();
            do {
                onEachInvalidComposition.invoke(content[i]);
                i++;
            } while (i < size2);
        }
        this.compositionInvalidations.clear();
        synchronized (this.stateLock) {
            try {
                if (deriveStateLocked() != null) {
                    throw new IllegalStateException("called outside of runRecomposeAndApplyChanges".toString());
                }
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
            } catch (Throwable th2) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th2;
            }
        }
        InlineMarker.finallyEnd(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void registerRunnerJob(Job callingJob) {
        synchronized (this.stateLock) {
            Throwable th = this.closeCause;
            if (th != null) {
                throw th;
            }
            if (this._state.getValue().compareTo(State.ShuttingDown) <= 0) {
                throw new IllegalStateException("Recomposer shut down".toString());
            }
            if (this.runnerJob != null) {
                throw new IllegalStateException("Recomposer already running".toString());
            }
            this.runnerJob = callingJob;
            deriveStateLocked();
        }
    }

    /* compiled from: Recomposer.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "parentFrameClock", "Landroidx/compose/runtime/MonotonicFrameClock;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.runtime.Recomposer$runRecomposeAndApplyChanges$2", f = "Recomposer.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {574, 585}, m = "invokeSuspend", n = {"parentFrameClock", "toRecompose", "toInsert", "toApply", "toLateApply", "toComplete", "modifiedValues", "modifiedValuesSet", "alreadyComposed", "parentFrameClock", "toRecompose", "toInsert", "toApply", "toLateApply", "toComplete", "modifiedValues", "modifiedValuesSet", "alreadyComposed"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8"})
    /* renamed from: androidx.compose.runtime.Recomposer$runRecomposeAndApplyChanges$2, reason: invalid class name and case insensitive filesystem */
    static final class C03622 extends SuspendLambda implements Function3<CoroutineScope, MonotonicFrameClock, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;

        C03622(Continuation<? super C03622> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(CoroutineScope coroutineScope, MonotonicFrameClock monotonicFrameClock, Continuation<? super Unit> continuation) {
            C03622 c03622 = Recomposer.this.new C03622(continuation);
            c03622.L$0 = monotonicFrameClock;
            return c03622.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:13:0x00c7  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x00f9  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0151  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0166  */
        /* JADX WARN: Type inference failed for: r10v11, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r10v8, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r11v13, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r11v16, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r9v10, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r9v13, types: [java.util.List] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0148 -> B:23:0x014b). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0151 -> B:25:0x015c). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r26) {
            /*
                Method dump skipped, instructions count: 361
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer.C03622.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0076  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00bd  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static final void invokeSuspend$clearRecompositionState(androidx.compose.runtime.Recomposer r21, java.util.List<androidx.compose.runtime.ControlledComposition> r22, java.util.List<androidx.compose.runtime.MovableContentStateReference> r23, java.util.List<androidx.compose.runtime.ControlledComposition> r24, androidx.collection.MutableScatterSet<androidx.compose.runtime.ControlledComposition> r25, androidx.collection.MutableScatterSet<androidx.compose.runtime.ControlledComposition> r26, androidx.collection.MutableScatterSet<java.lang.Object> r27, androidx.collection.MutableScatterSet<androidx.compose.runtime.ControlledComposition> r28) {
            /*
                Method dump skipped, instructions count: 294
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer.C03622.invokeSuspend$clearRecompositionState(androidx.compose.runtime.Recomposer, java.util.List, java.util.List, java.util.List, androidx.collection.MutableScatterSet, androidx.collection.MutableScatterSet, androidx.collection.MutableScatterSet, androidx.collection.MutableScatterSet):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$fillToInsert(List<MovableContentStateReference> list, Recomposer recomposer) {
            list.clear();
            synchronized (recomposer.stateLock) {
                List list2 = recomposer.compositionValuesAwaitingInsert;
                int size = list2.size();
                for (int i = 0; i < size; i++) {
                    list.add((MovableContentStateReference) list2.get(i));
                }
                recomposer.compositionValuesAwaitingInsert.clear();
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final Object runRecomposeAndApplyChanges(Continuation<? super Unit> continuation) {
        Object objRecompositionRunner = recompositionRunner(new C03622(null), continuation);
        return objRecompositionRunner == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objRecompositionRunner : Unit.INSTANCE;
    }

    static /* synthetic */ void processCompositionError$default(Recomposer recomposer, Exception exc, ControlledComposition controlledComposition, boolean z, int i, Object obj) throws Exception {
        if ((i & 2) != 0) {
            controlledComposition = null;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        recomposer.processCompositionError(exc, controlledComposition, z);
    }

    private final void processCompositionError(Exception e, ControlledComposition failedInitialComposition, boolean recoverable) throws Exception {
        int i = 0;
        if (_hotReloadEnabled.get().booleanValue() && !(e instanceof ComposeRuntimeError)) {
            synchronized (this.stateLock) {
                ActualAndroid_androidKt.logError("Error was captured in composition while live edit was enabled.", e);
                this.compositionsAwaitingApply.clear();
                this.compositionInvalidations.clear();
                this.snapshotInvalidations = new MutableScatterSet<>(i, 1, null);
                this.compositionValuesAwaitingInsert.clear();
                this.compositionValuesRemoved.clear();
                this.compositionValueStatesAvailable.clear();
                this.errorState = new RecomposerErrorState(recoverable, e);
                if (failedInitialComposition != null) {
                    recordFailedCompositionLocked(failedInitialComposition);
                }
                deriveStateLocked();
            }
            return;
        }
        synchronized (this.stateLock) {
            RecomposerErrorState recomposerErrorState = this.errorState;
            if (recomposerErrorState == null) {
                this.errorState = new RecomposerErrorState(false, e);
                Unit unit = Unit.INSTANCE;
            } else {
                throw recomposerErrorState.getCause();
            }
        }
        throw e;
    }

    private final void clearKnownCompositionsLocked() {
        this._knownCompositions.clear();
        this._knownCompositionsCache = CollectionsKt.emptyList();
    }

    private final void removeKnownCompositionLocked(ControlledComposition composition) {
        this._knownCompositions.remove(composition);
        this._knownCompositionsCache = null;
    }

    private final void addKnownCompositionLocked(ControlledComposition composition) {
        this._knownCompositions.add(composition);
        this._knownCompositionsCache = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RecomposerErrorState resetErrorState() {
        RecomposerErrorState recomposerErrorState;
        synchronized (this.stateLock) {
            recomposerErrorState = this.errorState;
            if (recomposerErrorState != null) {
                this.errorState = null;
                deriveStateLocked();
            }
        }
        return recomposerErrorState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void retryFailedCompositions() {
        List<ControlledComposition> list;
        int i;
        synchronized (this.stateLock) {
            list = this.failedCompositions;
            this.failedCompositions = null;
        }
        if (list == null) {
            return;
        }
        while (true) {
            i = 0;
            try {
                if (list.isEmpty()) {
                    break;
                }
                ControlledComposition controlledComposition = (ControlledComposition) CollectionsKt.removeLast(list);
                if (controlledComposition instanceof CompositionImpl) {
                    controlledComposition.invalidateAll();
                    controlledComposition.setContent(((CompositionImpl) controlledComposition).getComposable());
                    if (this.errorState != null) {
                        break;
                    }
                }
            } catch (Throwable th) {
                if (!list.isEmpty()) {
                    synchronized (this.stateLock) {
                        int size = list.size();
                        while (i < size) {
                            recordFailedCompositionLocked(list.get(i));
                            i++;
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                }
                throw th;
            }
        }
        if (list.isEmpty()) {
            return;
        }
        synchronized (this.stateLock) {
            int size2 = list.size();
            while (i < size2) {
                recordFailedCompositionLocked(list.get(i));
                i++;
            }
            Unit unit2 = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void recordFailedCompositionLocked(ControlledComposition composition) {
        ArrayList arrayList = this.failedCompositions;
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.failedCompositions = arrayList;
        }
        if (!arrayList.contains(composition)) {
            arrayList.add(composition);
        }
        removeKnownCompositionLocked(composition);
    }

    /* compiled from: Recomposer.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "parentFrameClock", "Landroidx/compose/runtime/MonotonicFrameClock;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.runtime.Recomposer$runRecomposeConcurrentlyAndApplyChanges$2", f = "Recomposer.kt", i = {0, 0, 0, 1}, l = {890, 910, 911}, m = "invokeSuspend", n = {"recomposeCoroutineScope", "frameSignal", "frameLoop", "frameLoop"}, s = {"L$0", "L$1", "L$2", "L$0"})
    /* renamed from: androidx.compose.runtime.Recomposer$runRecomposeConcurrentlyAndApplyChanges$2, reason: invalid class name and case insensitive filesystem */
    static final class C03632 extends SuspendLambda implements Function3<CoroutineScope, MonotonicFrameClock, Continuation<? super Unit>, Object> {
        final /* synthetic */ CoroutineContext $recomposeCoroutineContext;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ Recomposer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03632(CoroutineContext coroutineContext, Recomposer recomposer, Continuation<? super C03632> continuation) {
            super(3, continuation);
            this.$recomposeCoroutineContext = coroutineContext;
            this.this$0 = recomposer;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(CoroutineScope coroutineScope, MonotonicFrameClock monotonicFrameClock, Continuation<? super Unit> continuation) {
            C03632 c03632 = new C03632(this.$recomposeCoroutineContext, this.this$0, continuation);
            c03632.L$0 = coroutineScope;
            c03632.L$1 = monotonicFrameClock;
            return c03632.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x00b7  */
        /* JADX WARN: Removed duplicated region for block: B:80:0x01ab  */
        /* JADX WARN: Removed duplicated region for block: B:85:0x01d2 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:94:0x00d2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x00c8 -> B:12:0x003a). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r21) {
            /*
                Method dump skipped, instructions count: 470
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer.C03632.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final Object runRecomposeConcurrentlyAndApplyChanges(CoroutineContext coroutineContext, Continuation<? super Unit> continuation) {
        Object objRecompositionRunner = recompositionRunner(new C03632(coroutineContext, this, null), continuation);
        return objRecompositionRunner == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objRecompositionRunner : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x008c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ab A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Type inference failed for: r8v10, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r8v7, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v10, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v7, types: [java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00a9 -> B:13:0x0040). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object runFrameLoop(androidx.compose.runtime.MonotonicFrameClock r8, androidx.compose.runtime.ProduceFrameSignal r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof androidx.compose.runtime.Recomposer.C03601
            if (r0 == 0) goto L14
            r0 = r10
            androidx.compose.runtime.Recomposer$runFrameLoop$1 r0 = (androidx.compose.runtime.Recomposer.C03601) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            androidx.compose.runtime.Recomposer$runFrameLoop$1 r0 = new androidx.compose.runtime.Recomposer$runFrameLoop$1
            r0.<init>(r10)
        L19:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L66
            if (r2 == r4) goto L4e
            if (r2 != r3) goto L46
            java.lang.Object r8 = r0.L$4
            java.util.List r8 = (java.util.List) r8
            java.lang.Object r9 = r0.L$3
            java.util.List r9 = (java.util.List) r9
            java.lang.Object r2 = r0.L$2
            androidx.compose.runtime.ProduceFrameSignal r2 = (androidx.compose.runtime.ProduceFrameSignal) r2
            java.lang.Object r5 = r0.L$1
            androidx.compose.runtime.MonotonicFrameClock r5 = (androidx.compose.runtime.MonotonicFrameClock) r5
            java.lang.Object r6 = r0.L$0
            androidx.compose.runtime.Recomposer r6 = (androidx.compose.runtime.Recomposer) r6
            kotlin.ResultKt.throwOnFailure(r10)
        L40:
            r10 = r9
            r9 = r2
            r2 = r8
            r8 = r5
            r5 = r6
            goto L78
        L46:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L4e:
            java.lang.Object r8 = r0.L$4
            java.util.List r8 = (java.util.List) r8
            java.lang.Object r9 = r0.L$3
            java.util.List r9 = (java.util.List) r9
            java.lang.Object r2 = r0.L$2
            androidx.compose.runtime.ProduceFrameSignal r2 = (androidx.compose.runtime.ProduceFrameSignal) r2
            java.lang.Object r5 = r0.L$1
            androidx.compose.runtime.MonotonicFrameClock r5 = (androidx.compose.runtime.MonotonicFrameClock) r5
            java.lang.Object r6 = r0.L$0
            androidx.compose.runtime.Recomposer r6 = (androidx.compose.runtime.Recomposer) r6
            kotlin.ResultKt.throwOnFailure(r10)
            goto L92
        L66:
            kotlin.ResultKt.throwOnFailure(r10)
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.List r10 = (java.util.List) r10
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.List r2 = (java.util.List) r2
            r5 = r7
        L78:
            java.lang.Object r6 = r5.stateLock
            r0.L$0 = r5
            r0.L$1 = r8
            r0.L$2 = r9
            r0.L$3 = r10
            r0.L$4 = r2
            r0.label = r4
            java.lang.Object r6 = r9.awaitFrameRequest(r6, r0)
            if (r6 != r1) goto L8d
            return r1
        L8d:
            r6 = r5
            r5 = r8
            r8 = r2
            r2 = r9
            r9 = r10
        L92:
            androidx.compose.runtime.Recomposer$runFrameLoop$2 r10 = new androidx.compose.runtime.Recomposer$runFrameLoop$2
            r10.<init>()
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            r0.L$0 = r6
            r0.L$1 = r5
            r0.L$2 = r2
            r0.L$3 = r9
            r0.L$4 = r8
            r0.label = r3
            java.lang.Object r10 = r5.withFrameNanos(r10, r0)
            if (r10 != r1) goto L40
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer.runFrameLoop(androidx.compose.runtime.MonotonicFrameClock, androidx.compose.runtime.ProduceFrameSignal, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean getHasSchedulingWork() {
        /*
            r2 = this;
            java.lang.Object r0 = r2.stateLock
            monitor-enter(r0)
            androidx.collection.MutableScatterSet<java.lang.Object> r1 = r2.snapshotInvalidations     // Catch: java.lang.Throwable -> L1f
            boolean r1 = r1.isNotEmpty()     // Catch: java.lang.Throwable -> L1f
            if (r1 != 0) goto L1c
            androidx.compose.runtime.collection.MutableVector<androidx.compose.runtime.ControlledComposition> r1 = r2.compositionInvalidations     // Catch: java.lang.Throwable -> L1f
            boolean r1 = r1.isNotEmpty()     // Catch: java.lang.Throwable -> L1f
            if (r1 != 0) goto L1c
            boolean r1 = r2.getHasBroadcastFrameClockAwaitersLocked()     // Catch: java.lang.Throwable -> L1f
            if (r1 == 0) goto L1a
            goto L1c
        L1a:
            r1 = 0
            goto L1d
        L1c:
            r1 = 1
        L1d:
            monitor-exit(r0)
            return r1
        L1f:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer.getHasSchedulingWork():boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object awaitWorkAvailable(Continuation<? super Unit> continuation) {
        if (getHasSchedulingWork()) {
            return Unit.INSTANCE;
        }
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        synchronized (this.stateLock) {
            if (!getHasSchedulingWork()) {
                this.workContinuation = cancellableContinuationImpl2;
                cancellableContinuationImpl2 = null;
            }
        }
        if (cancellableContinuationImpl2 != null) {
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuationImpl2.resumeWith(Result.m5937constructorimpl(Unit.INSTANCE));
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }

    /* compiled from: Recomposer.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.runtime.Recomposer$recompositionRunner$2", f = "Recomposer.kt", i = {0, 0}, l = {1054}, m = "invokeSuspend", n = {"callingJob", "unregisterApplyObserver"}, s = {"L$0", "L$1"})
    /* renamed from: androidx.compose.runtime.Recomposer$recompositionRunner$2, reason: invalid class name and case insensitive filesystem */
    static final class C03592 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function3<CoroutineScope, MonotonicFrameClock, Continuation<? super Unit>, Object> $block;
        final /* synthetic */ MonotonicFrameClock $parentFrameClock;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C03592(Function3<? super CoroutineScope, ? super MonotonicFrameClock, ? super Continuation<? super Unit>, ? extends Object> function3, MonotonicFrameClock monotonicFrameClock, Continuation<? super C03592> continuation) {
            super(2, continuation);
            this.$block = function3;
            this.$parentFrameClock = monotonicFrameClock;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C03592 c03592 = Recomposer.this.new C03592(this.$block, this.$parentFrameClock, continuation);
            c03592.L$0 = obj;
            return c03592;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03592) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:53:0x00cc A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:55:0x009b A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 232
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer.C03592.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* compiled from: Recomposer.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.runtime.Recomposer$recompositionRunner$2$3", f = "Recomposer.kt", i = {}, l = {1055}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: androidx.compose.runtime.Recomposer$recompositionRunner$2$3, reason: invalid class name */
        static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function3<CoroutineScope, MonotonicFrameClock, Continuation<? super Unit>, Object> $block;
            final /* synthetic */ MonotonicFrameClock $parentFrameClock;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass3(Function3<? super CoroutineScope, ? super MonotonicFrameClock, ? super Continuation<? super Unit>, ? extends Object> function3, MonotonicFrameClock monotonicFrameClock, Continuation<? super AnonymousClass3> continuation) {
                super(2, continuation);
                this.$block = function3;
                this.$parentFrameClock = monotonicFrameClock;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$block, this.$parentFrameClock, continuation);
                anonymousClass3.L$0 = obj;
                return anonymousClass3;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                    Function3<CoroutineScope, MonotonicFrameClock, Continuation<? super Unit>, Object> function3 = this.$block;
                    MonotonicFrameClock monotonicFrameClock = this.$parentFrameClock;
                    this.label = 1;
                    if (function3.invoke(coroutineScope, monotonicFrameClock, this) == coroutine_suspended) {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object recompositionRunner(Function3<? super CoroutineScope, ? super MonotonicFrameClock, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(this.broadcastFrameClock, new C03592(function3, MonotonicFrameClockKt.getMonotonicFrameClock(continuation.getContext()), null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    public final void cancel() {
        synchronized (this.stateLock) {
            if (this._state.getValue().compareTo(State.Idle) >= 0) {
                this._state.setValue(State.ShuttingDown);
            }
            Unit unit = Unit.INSTANCE;
        }
        Job.DefaultImpls.cancel$default((Job) this.effectJob, (CancellationException) null, 1, (Object) null);
    }

    public final void close() {
        if (this.effectJob.complete()) {
            synchronized (this.stateLock) {
                this.isClosed = true;
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* compiled from: Recomposer.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/runtime/Recomposer$State;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.runtime.Recomposer$join$2", f = "Recomposer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.runtime.Recomposer$join$2, reason: invalid class name and case insensitive filesystem */
    static final class C03582 extends SuspendLambda implements Function2<State, Continuation<? super Boolean>, Object> {
        /* synthetic */ Object L$0;
        int label;

        C03582(Continuation<? super C03582> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C03582 c03582 = new C03582(continuation);
            c03582.L$0 = obj;
            return c03582;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(State state, Continuation<? super Boolean> continuation) {
            return ((C03582) create(state, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Boxing.boxBoolean(((State) this.L$0) == State.ShutDown);
        }
    }

    public final Object join(Continuation<? super Unit> continuation) {
        Object objFirst = FlowKt.first(getCurrentState(), new C03582(null), continuation);
        return objFirst == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objFirst : Unit.INSTANCE;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void composeInitial$runtime_release(ControlledComposition composition, Function2<? super Composer, ? super Integer, Unit> content) throws Exception {
        boolean zIsComposing = composition.isComposing();
        try {
            MutableSnapshot mutableSnapshotTakeMutableSnapshot = Snapshot.INSTANCE.takeMutableSnapshot(readObserverOf(composition), writeObserverOf(composition, null));
            try {
                MutableSnapshot mutableSnapshot = mutableSnapshotTakeMutableSnapshot;
                Snapshot snapshotMakeCurrent = mutableSnapshot.makeCurrent();
                try {
                    composition.composeContent(content);
                    Unit unit = Unit.INSTANCE;
                    if (!zIsComposing) {
                        Snapshot.INSTANCE.notifyObjectsInitialized();
                    }
                    synchronized (this.stateLock) {
                        if (this._state.getValue().compareTo(State.ShuttingDown) > 0 && !getKnownCompositions().contains(composition)) {
                            addKnownCompositionLocked(composition);
                        }
                        Unit unit2 = Unit.INSTANCE;
                    }
                    try {
                        performInitialMovableContentInserts(composition);
                        try {
                            composition.applyChanges();
                            composition.applyLateChanges();
                            if (zIsComposing) {
                                return;
                            }
                            Snapshot.INSTANCE.notifyObjectsInitialized();
                        } catch (Exception e) {
                            processCompositionError$default(this, e, null, false, 6, null);
                        }
                    } catch (Exception e2) {
                        processCompositionError(e2, composition, true);
                    }
                } finally {
                    mutableSnapshot.restoreCurrent(snapshotMakeCurrent);
                }
            } finally {
                applyAndCheck(mutableSnapshotTakeMutableSnapshot);
            }
        } catch (Exception e3) {
            processCompositionError(e3, composition, true);
        }
    }

    private final void performInitialMovableContentInserts(ControlledComposition composition) {
        synchronized (this.stateLock) {
            List<MovableContentStateReference> list = this.compositionValuesAwaitingInsert;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (Intrinsics.areEqual(list.get(i).getComposition(), composition)) {
                    Unit unit = Unit.INSTANCE;
                    ArrayList arrayList = new ArrayList();
                    performInitialMovableContentInserts$fillToInsert(arrayList, this, composition);
                    while (!arrayList.isEmpty()) {
                        performInsertValues(arrayList, null);
                        performInitialMovableContentInserts$fillToInsert(arrayList, this, composition);
                    }
                    return;
                }
            }
        }
    }

    private static final void performInitialMovableContentInserts$fillToInsert(List<MovableContentStateReference> list, Recomposer recomposer, ControlledComposition controlledComposition) {
        list.clear();
        synchronized (recomposer.stateLock) {
            Iterator<MovableContentStateReference> it = recomposer.compositionValuesAwaitingInsert.iterator();
            while (it.hasNext()) {
                MovableContentStateReference next = it.next();
                if (Intrinsics.areEqual(next.getComposition(), controlledComposition)) {
                    list.add(next);
                    it.remove();
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ControlledComposition performRecompose(final ControlledComposition composition, final MutableScatterSet<Object> modifiedValues) {
        Set<ControlledComposition> set;
        if (composition.isComposing() || composition.getDisposed() || ((set = this.compositionsRemoved) != null && set.contains(composition))) {
            return null;
        }
        MutableSnapshot mutableSnapshotTakeMutableSnapshot = Snapshot.INSTANCE.takeMutableSnapshot(readObserverOf(composition), writeObserverOf(composition, modifiedValues));
        try {
            MutableSnapshot mutableSnapshot = mutableSnapshotTakeMutableSnapshot;
            Snapshot snapshotMakeCurrent = mutableSnapshot.makeCurrent();
            if (modifiedValues != null) {
                try {
                    if (modifiedValues.isNotEmpty()) {
                        composition.prepareCompose(new Function0<Unit>() { // from class: androidx.compose.runtime.Recomposer$performRecompose$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                MutableScatterSet<Object> mutableScatterSet = modifiedValues;
                                ControlledComposition controlledComposition = composition;
                                Object[] objArr = mutableScatterSet.elements;
                                long[] jArr = mutableScatterSet.metadata;
                                int length = jArr.length - 2;
                                if (length < 0) {
                                    return;
                                }
                                int i = 0;
                                while (true) {
                                    long j = jArr[i];
                                    if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                                        int i2 = 8 - ((~(i - length)) >>> 31);
                                        for (int i3 = 0; i3 < i2; i3++) {
                                            if ((255 & j) < 128) {
                                                controlledComposition.recordWriteOf(objArr[(i << 3) + i3]);
                                            }
                                            j >>= 8;
                                        }
                                        if (i2 != 8) {
                                            return;
                                        }
                                    }
                                    if (i == length) {
                                        return;
                                    } else {
                                        i++;
                                    }
                                }
                            }
                        });
                    }
                } catch (Throwable th) {
                    mutableSnapshot.restoreCurrent(snapshotMakeCurrent);
                    throw th;
                }
            }
            boolean zRecompose = composition.recompose();
            mutableSnapshot.restoreCurrent(snapshotMakeCurrent);
            if (zRecompose) {
                return composition;
            }
            return null;
        } finally {
            applyAndCheck(mutableSnapshotTakeMutableSnapshot);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void discardUnusedValues() {
        int i;
        ArrayList arrayListEmptyList;
        synchronized (this.stateLock) {
            if (!this.compositionValuesRemoved.isEmpty()) {
                List listFlatten = CollectionsKt.flatten(this.compositionValuesRemoved.values());
                this.compositionValuesRemoved.clear();
                ArrayList arrayList = new ArrayList(listFlatten.size());
                int size = listFlatten.size();
                for (int i2 = 0; i2 < size; i2++) {
                    MovableContentStateReference movableContentStateReference = (MovableContentStateReference) listFlatten.get(i2);
                    arrayList.add(TuplesKt.to(movableContentStateReference, this.compositionValueStatesAvailable.get(movableContentStateReference)));
                }
                arrayListEmptyList = arrayList;
                this.compositionValueStatesAvailable.clear();
            } else {
                arrayListEmptyList = CollectionsKt.emptyList();
            }
        }
        int size2 = arrayListEmptyList.size();
        for (i = 0; i < size2; i++) {
            Pair pair = (Pair) arrayListEmptyList.get(i);
            MovableContentStateReference movableContentStateReference2 = (MovableContentStateReference) pair.component1();
            MovableContentState movableContentState = (MovableContentState) pair.component2();
            if (movableContentState != null) {
                movableContentStateReference2.getComposition().disposeUnusedMovableContent(movableContentState);
            }
        }
    }

    private final Function1<Object, Unit> readObserverOf(final ControlledComposition composition) {
        return new Function1<Object, Unit>() { // from class: androidx.compose.runtime.Recomposer.readObserverOf.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2(obj);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                composition.recordReadOf(obj);
            }
        };
    }

    private final Function1<Object, Unit> writeObserverOf(final ControlledComposition composition, final MutableScatterSet<Object> modifiedValues) {
        return new Function1<Object, Unit>() { // from class: androidx.compose.runtime.Recomposer.writeObserverOf.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2(obj);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                composition.recordWriteOf(obj);
                MutableScatterSet<Object> mutableScatterSet = modifiedValues;
                if (mutableScatterSet != null) {
                    mutableScatterSet.add(obj);
                }
            }
        };
    }

    private final <T> T composing(ControlledComposition composition, MutableScatterSet<Object> modifiedValues, Function0<? extends T> block) {
        MutableSnapshot mutableSnapshotTakeMutableSnapshot = Snapshot.INSTANCE.takeMutableSnapshot(readObserverOf(composition), writeObserverOf(composition, modifiedValues));
        try {
            MutableSnapshot mutableSnapshot = mutableSnapshotTakeMutableSnapshot;
            Snapshot snapshotMakeCurrent = mutableSnapshot.makeCurrent();
            try {
                return block.invoke();
            } finally {
                InlineMarker.finallyStart(1);
                mutableSnapshot.restoreCurrent(snapshotMakeCurrent);
                InlineMarker.finallyEnd(1);
            }
        } finally {
            InlineMarker.finallyStart(1);
            applyAndCheck(mutableSnapshotTakeMutableSnapshot);
            InlineMarker.finallyEnd(1);
        }
    }

    private final void applyAndCheck(MutableSnapshot snapshot) {
        try {
            if (snapshot.apply() instanceof SnapshotApplyResult.Failure) {
                throw new IllegalStateException("Unsupported concurrent change during composition. A state object was modified by composition as well as being modified outside composition.".toString());
            }
        } finally {
            snapshot.dispose();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean getHasPendingWork() {
        /*
            r2 = this;
            java.lang.Object r0 = r2.stateLock
            monitor-enter(r0)
            androidx.collection.MutableScatterSet<java.lang.Object> r1 = r2.snapshotInvalidations     // Catch: java.lang.Throwable -> L2d
            boolean r1 = r1.isNotEmpty()     // Catch: java.lang.Throwable -> L2d
            if (r1 != 0) goto L2a
            androidx.compose.runtime.collection.MutableVector<androidx.compose.runtime.ControlledComposition> r1 = r2.compositionInvalidations     // Catch: java.lang.Throwable -> L2d
            boolean r1 = r1.isNotEmpty()     // Catch: java.lang.Throwable -> L2d
            if (r1 != 0) goto L2a
            int r1 = r2.concurrentCompositionsOutstanding     // Catch: java.lang.Throwable -> L2d
            if (r1 > 0) goto L2a
            java.util.List<androidx.compose.runtime.ControlledComposition> r1 = r2.compositionsAwaitingApply     // Catch: java.lang.Throwable -> L2d
            java.util.Collection r1 = (java.util.Collection) r1     // Catch: java.lang.Throwable -> L2d
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L2d
            if (r1 == 0) goto L2a
            boolean r1 = r2.getHasBroadcastFrameClockAwaitersLocked()     // Catch: java.lang.Throwable -> L2d
            if (r1 == 0) goto L28
            goto L2a
        L28:
            r1 = 0
            goto L2b
        L2a:
            r1 = 1
        L2b:
            monitor-exit(r0)
            return r1
        L2d:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer.getHasPendingWork():boolean");
    }

    private final boolean getHasFrameWorkLocked() {
        return this.compositionInvalidations.isNotEmpty() || getHasBroadcastFrameClockAwaitersLocked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getHasConcurrentFrameWorkLocked() {
        return !this.compositionsAwaitingApply.isEmpty() || getHasBroadcastFrameClockAwaitersLocked();
    }

    /* compiled from: Recomposer.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/runtime/Recomposer$State;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.runtime.Recomposer$awaitIdle$2", f = "Recomposer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.runtime.Recomposer$awaitIdle$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<State, Continuation<? super Boolean>, Object> {
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(State state, Continuation<? super Boolean> continuation) {
            return ((AnonymousClass2) create(state, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Boxing.boxBoolean(((State) this.L$0).compareTo(State.Idle) > 0);
        }
    }

    public final Object awaitIdle(Continuation<? super Unit> continuation) {
        Object objCollect = FlowKt.collect(FlowKt.takeWhile(getCurrentState(), new AnonymousClass2(null)), continuation);
        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
    }

    public final void pauseCompositionFrameClock() {
        synchronized (this.stateLock) {
            this.frameClockPaused = true;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void resumeCompositionFrameClock() {
        CancellableContinuation<Unit> cancellableContinuationDeriveStateLocked;
        synchronized (this.stateLock) {
            if (this.frameClockPaused) {
                this.frameClockPaused = false;
                cancellableContinuationDeriveStateLocked = deriveStateLocked();
            } else {
                cancellableContinuationDeriveStateLocked = null;
            }
        }
        if (cancellableContinuationDeriveStateLocked != null) {
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuationDeriveStateLocked.resumeWith(Result.m5937constructorimpl(Unit.INSTANCE));
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public boolean getCollectingCallByInformation$runtime_release() {
        return _hotReloadEnabled.get().booleanValue();
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void unregisterComposition$runtime_release(ControlledComposition composition) {
        synchronized (this.stateLock) {
            removeKnownCompositionLocked(composition);
            this.compositionInvalidations.remove(composition);
            this.compositionsAwaitingApply.remove(composition);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void invalidate$runtime_release(ControlledComposition composition) {
        CancellableContinuation<Unit> cancellableContinuationDeriveStateLocked;
        synchronized (this.stateLock) {
            if (this.compositionInvalidations.contains(composition)) {
                cancellableContinuationDeriveStateLocked = null;
            } else {
                this.compositionInvalidations.add(composition);
                cancellableContinuationDeriveStateLocked = deriveStateLocked();
            }
        }
        if (cancellableContinuationDeriveStateLocked != null) {
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuationDeriveStateLocked.resumeWith(Result.m5937constructorimpl(Unit.INSTANCE));
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void invalidateScope$runtime_release(RecomposeScopeImpl scope) {
        CancellableContinuation<Unit> cancellableContinuationDeriveStateLocked;
        synchronized (this.stateLock) {
            this.snapshotInvalidations.add(scope);
            cancellableContinuationDeriveStateLocked = deriveStateLocked();
        }
        if (cancellableContinuationDeriveStateLocked != null) {
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuationDeriveStateLocked.resumeWith(Result.m5937constructorimpl(Unit.INSTANCE));
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void insertMovableContent$runtime_release(MovableContentStateReference reference) {
        CancellableContinuation<Unit> cancellableContinuationDeriveStateLocked;
        synchronized (this.stateLock) {
            this.compositionValuesAwaitingInsert.add(reference);
            cancellableContinuationDeriveStateLocked = deriveStateLocked();
        }
        if (cancellableContinuationDeriveStateLocked != null) {
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuationDeriveStateLocked.resumeWith(Result.m5937constructorimpl(Unit.INSTANCE));
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void deletedMovableContent$runtime_release(MovableContentStateReference reference) {
        synchronized (this.stateLock) {
            RecomposerKt.addMultiValue(this.compositionValuesRemoved, reference.getContent$runtime_release(), reference);
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void movableContentStateReleased$runtime_release(MovableContentStateReference reference, MovableContentState data) {
        synchronized (this.stateLock) {
            this.compositionValueStatesAvailable.put(reference, data);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void reportRemovedComposition$runtime_release(ControlledComposition composition) {
        synchronized (this.stateLock) {
            LinkedHashSet linkedHashSet = this.compositionsRemoved;
            if (linkedHashSet == null) {
                linkedHashSet = new LinkedHashSet();
                this.compositionsRemoved = linkedHashSet;
            }
            linkedHashSet.add(composition);
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public MovableContentState movableContentStateResolve$runtime_release(MovableContentStateReference reference) {
        MovableContentState movableContentStateRemove;
        synchronized (this.stateLock) {
            movableContentStateRemove = this.compositionValueStatesAvailable.remove(reference);
        }
        return movableContentStateRemove;
    }

    /* compiled from: Recomposer.kt */
    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0013\u001a\u00020\u00142\n\u0010\u0015\u001a\u00060\u000bR\u00020\fH\u0002J\r\u0010\u0016\u001a\u00020\u0014H\u0000¢\u0006\u0002\b\u0017J\u0013\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0000¢\u0006\u0002\b\u001bJ\u0015\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001eH\u0000¢\u0006\u0002\b\u001fJ\u0015\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u0001H\u0000¢\u0006\u0002\b\"J\u0014\u0010#\u001a\u00020\u00142\n\u0010\u0015\u001a\u00060\u000bR\u00020\fH\u0002J\r\u0010$\u001a\u00020\u0001H\u0000¢\u0006\u0002\b%J\u0015\u0010&\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\u0005H\u0000¢\u0006\u0002\b(R.\u0010\u0003\u001a\"\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004j\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u000bR\u00020\f0\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000e8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006)"}, d2 = {"Landroidx/compose/runtime/Recomposer$Companion;", "", "()V", "_hotReloadEnabled", "Ljava/util/concurrent/atomic/AtomicReference;", "", "kotlin.jvm.PlatformType", "Landroidx/compose/runtime/AtomicReference;", "_runningRecomposers", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "Landroidx/compose/runtime/Recomposer$RecomposerInfoImpl;", "Landroidx/compose/runtime/Recomposer;", "runningRecomposers", "Lkotlinx/coroutines/flow/StateFlow;", "", "Landroidx/compose/runtime/RecomposerInfo;", "getRunningRecomposers", "()Lkotlinx/coroutines/flow/StateFlow;", "addRunning", "", "info", "clearErrors", "clearErrors$runtime_release", "getCurrentErrors", "", "Landroidx/compose/runtime/RecomposerErrorInfo;", "getCurrentErrors$runtime_release", "invalidateGroupsWithKey", SDKConstants.PARAM_KEY, "", "invalidateGroupsWithKey$runtime_release", "loadStateAndComposeForHotReload", "token", "loadStateAndComposeForHotReload$runtime_release", "removeRunning", "saveStateAndDisposeForHotReload", "saveStateAndDisposeForHotReload$runtime_release", "setHotReloadEnabled", "value", "setHotReloadEnabled$runtime_release", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final StateFlow<Set<RecomposerInfo>> getRunningRecomposers() {
            return Recomposer._runningRecomposers;
        }

        public final void setHotReloadEnabled$runtime_release(boolean value) {
            Recomposer._hotReloadEnabled.set(Boolean.valueOf(value));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void addRunning(RecomposerInfoImpl info) {
            PersistentSet persistentSet;
            PersistentSet persistentSetAdd;
            do {
                persistentSet = (PersistentSet) Recomposer._runningRecomposers.getValue();
                persistentSetAdd = persistentSet.add((PersistentSet) info);
                if (persistentSet == persistentSetAdd) {
                    return;
                }
            } while (!Recomposer._runningRecomposers.compareAndSet(persistentSet, persistentSetAdd));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void removeRunning(RecomposerInfoImpl info) {
            PersistentSet persistentSet;
            PersistentSet persistentSetRemove;
            do {
                persistentSet = (PersistentSet) Recomposer._runningRecomposers.getValue();
                persistentSetRemove = persistentSet.remove((PersistentSet) info);
                if (persistentSet == persistentSetRemove) {
                    return;
                }
            } while (!Recomposer._runningRecomposers.compareAndSet(persistentSet, persistentSetRemove));
        }

        public final Object saveStateAndDisposeForHotReload$runtime_release() {
            Recomposer._hotReloadEnabled.set(true);
            Iterable iterable = (Iterable) Recomposer._runningRecomposers.getValue();
            ArrayList arrayList = new ArrayList();
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                CollectionsKt.addAll(arrayList, ((RecomposerInfoImpl) it.next()).saveStateAndDisposeForHotReload());
            }
            return arrayList;
        }

        public final void loadStateAndComposeForHotReload$runtime_release(Object token) {
            Recomposer._hotReloadEnabled.set(true);
            Iterator it = ((Iterable) Recomposer._runningRecomposers.getValue()).iterator();
            while (it.hasNext()) {
                ((RecomposerInfoImpl) it.next()).resetErrorState();
            }
            Intrinsics.checkNotNull(token, "null cannot be cast to non-null type kotlin.collections.List<androidx.compose.runtime.Recomposer.HotReloadable>");
            List list = (List) token;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ((HotReloadable) list.get(i)).resetContent();
            }
            int size2 = list.size();
            for (int i2 = 0; i2 < size2; i2++) {
                ((HotReloadable) list.get(i2)).recompose();
            }
            Iterator it2 = ((Iterable) Recomposer._runningRecomposers.getValue()).iterator();
            while (it2.hasNext()) {
                ((RecomposerInfoImpl) it2.next()).retryFailedCompositions();
            }
        }

        public final void invalidateGroupsWithKey$runtime_release(int key) {
            Recomposer._hotReloadEnabled.set(true);
            for (RecomposerInfoImpl recomposerInfoImpl : (Iterable) Recomposer._runningRecomposers.getValue()) {
                RecomposerErrorInfo currentError = recomposerInfoImpl.getCurrentError();
                if (currentError == null || currentError.getRecoverable()) {
                    recomposerInfoImpl.resetErrorState();
                    recomposerInfoImpl.invalidateGroupsWithKey(key);
                    recomposerInfoImpl.retryFailedCompositions();
                }
            }
        }

        public final List<RecomposerErrorInfo> getCurrentErrors$runtime_release() {
            Iterable iterable = (Iterable) Recomposer._runningRecomposers.getValue();
            ArrayList arrayList = new ArrayList();
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                RecomposerErrorInfo currentError = ((RecomposerInfoImpl) it.next()).getCurrentError();
                if (currentError != null) {
                    arrayList.add(currentError);
                }
            }
            return arrayList;
        }

        public final void clearErrors$runtime_release() {
            Iterable iterable = (Iterable) Recomposer._runningRecomposers.getValue();
            ArrayList arrayList = new ArrayList();
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                RecomposerErrorState recomposerErrorStateResetErrorState = ((RecomposerInfoImpl) it.next()).resetErrorState();
                if (recomposerErrorStateResetErrorState != null) {
                    arrayList.add(recomposerErrorStateResetErrorState);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00c9, code lost:
    
        r2 = r11.size();
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00ce, code lost:
    
        if (r3 >= r2) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00da, code lost:
    
        if (r11.get(r3).getSecond() == null) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00dc, code lost:
    
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00df, code lost:
    
        r2 = new java.util.ArrayList(r11.size());
        r3 = r11.size();
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00ed, code lost:
    
        if (r4 >= r3) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00ef, code lost:
    
        r10 = r11.get(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00f9, code lost:
    
        if (r10.getSecond() != null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00fb, code lost:
    
        r10 = r10.getFirst();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0102, code lost:
    
        r10 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0103, code lost:
    
        if (r10 == null) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0105, code lost:
    
        r2.add(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x010b, code lost:
    
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x010e, code lost:
    
        r2 = r2;
        r3 = r16.stateLock;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0112, code lost:
    
        monitor-enter(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0113, code lost:
    
        kotlin.collections.CollectionsKt.addAll(r16.compositionValuesAwaitingInsert, r2);
        r2 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x011e, code lost:
    
        monitor-exit(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x011f, code lost:
    
        r2 = new java.util.ArrayList(r11.size());
        r3 = r11.size();
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x012d, code lost:
    
        if (r4 >= r3) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x012f, code lost:
    
        r10 = r11.get(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x013a, code lost:
    
        if (r10.getSecond() == null) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x013c, code lost:
    
        r2.add(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0142, code lost:
    
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0145, code lost:
    
        r11 = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<androidx.compose.runtime.ControlledComposition> performInsertValues(java.util.List<androidx.compose.runtime.MovableContentStateReference> r17, androidx.collection.MutableScatterSet<java.lang.Object> r18) {
        /*
            Method dump skipped, instructions count: 371
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer.performInsertValues(java.util.List, androidx.collection.MutableScatterSet):java.util.List");
    }
}
