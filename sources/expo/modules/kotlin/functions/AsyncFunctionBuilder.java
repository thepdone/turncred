package expo.modules.kotlin.functions;

import com.facebook.soloader.Elf64;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.AnyTypeProvider;
import expo.modules.kotlin.types.LazyKType;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* compiled from: AsyncFunctionBuilder.kt */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\u0010\u001a\u00020\u0011\"\u0006\b\u0000\u0010\u0012\u0018\u00012\u000e\b\u0004\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0014H\u0086\bø\u0001\u0000J#\u0010\u0010\u001a\u00020\u00112\u0010\b\u0004\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0014H\u0087\bø\u0001\u0000¢\u0006\u0002\b\u0015JA\u0010\u0010\u001a\u00020\u0011\"\u0006\b\u0000\u0010\u0012\u0018\u0001\"\u0006\b\u0001\u0010\u0016\u0018\u00012#\b\u0004\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u0002H\u00120\u0017H\u0086\bø\u0001\u0000J^\u0010\u0010\u001a\u00020\u0011\"\u0006\b\u0000\u0010\u0012\u0018\u0001\"\u0006\b\u0001\u0010\u0016\u0018\u0001\"\u0006\b\u0002\u0010\u001a\u0018\u000128\b\u0004\u0010\u0013\u001a2\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u0011H\u001a¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u0002H\u00120\u001bH\u0086\bø\u0001\u0000J{\u0010\u0010\u001a\u00020\u0011\"\u0006\b\u0000\u0010\u0012\u0018\u0001\"\u0006\b\u0001\u0010\u0016\u0018\u0001\"\u0006\b\u0002\u0010\u001a\u0018\u0001\"\u0006\b\u0003\u0010\u001d\u0018\u00012M\b\u0004\u0010\u0013\u001aG\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u0011H\u001a¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u0002H\u00120\u001eH\u0086\bø\u0001\u0000J\u0098\u0001\u0010\u0010\u001a\u00020\u0011\"\u0006\b\u0000\u0010\u0012\u0018\u0001\"\u0006\b\u0001\u0010\u0016\u0018\u0001\"\u0006\b\u0002\u0010\u001a\u0018\u0001\"\u0006\b\u0003\u0010\u001d\u0018\u0001\"\u0006\b\u0004\u0010 \u0018\u00012b\b\u0004\u0010\u0013\u001a\\\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u0011H\u001a¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u0011H ¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\"\u0012\u0004\u0012\u0002H\u00120!H\u0086\bø\u0001\u0000Jµ\u0001\u0010\u0010\u001a\u00020\u0011\"\u0006\b\u0000\u0010\u0012\u0018\u0001\"\u0006\b\u0001\u0010\u0016\u0018\u0001\"\u0006\b\u0002\u0010\u001a\u0018\u0001\"\u0006\b\u0003\u0010\u001d\u0018\u0001\"\u0006\b\u0004\u0010 \u0018\u0001\"\u0006\b\u0005\u0010#\u0018\u00012w\b\u0004\u0010\u0013\u001aq\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u0011H\u001a¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u0011H ¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\"\u0012\u0013\u0012\u0011H#¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(%\u0012\u0004\u0012\u0002H\u00120$H\u0086\bø\u0001\u0000JÔ\u0001\u0010\u0010\u001a\u00020\u0011\"\u0006\b\u0000\u0010\u0012\u0018\u0001\"\u0006\b\u0001\u0010\u0016\u0018\u0001\"\u0006\b\u0002\u0010\u001a\u0018\u0001\"\u0006\b\u0003\u0010\u001d\u0018\u0001\"\u0006\b\u0004\u0010 \u0018\u0001\"\u0006\b\u0005\u0010#\u0018\u0001\"\u0006\b\u0006\u0010&\u0018\u00012\u008d\u0001\b\u0004\u0010\u0013\u001a\u0086\u0001\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u0011H\u001a¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u0011H ¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\"\u0012\u0013\u0012\u0011H#¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(%\u0012\u0013\u0012\u0011H&¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b((\u0012\u0004\u0012\u0002H\u00120'H\u0086\bø\u0001\u0000Jñ\u0001\u0010\u0010\u001a\u00020\u0011\"\u0006\b\u0000\u0010\u0012\u0018\u0001\"\u0006\b\u0001\u0010\u0016\u0018\u0001\"\u0006\b\u0002\u0010\u001a\u0018\u0001\"\u0006\b\u0003\u0010\u001d\u0018\u0001\"\u0006\b\u0004\u0010 \u0018\u0001\"\u0006\b\u0005\u0010#\u0018\u0001\"\u0006\b\u0006\u0010&\u0018\u0001\"\u0006\b\u0007\u0010)\u0018\u00012¢\u0001\b\u0004\u0010\u0013\u001a\u009b\u0001\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u0011H\u001a¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u0011H ¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\"\u0012\u0013\u0012\u0011H#¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(%\u0012\u0013\u0012\u0011H&¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b((\u0012\u0013\u0012\u0011H)¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(+\u0012\u0004\u0012\u0002H\u00120*H\u0086\bø\u0001\u0000J\u008e\u0002\u0010\u0010\u001a\u00020\u0011\"\u0006\b\u0000\u0010\u0012\u0018\u0001\"\u0006\b\u0001\u0010\u0016\u0018\u0001\"\u0006\b\u0002\u0010\u001a\u0018\u0001\"\u0006\b\u0003\u0010\u001d\u0018\u0001\"\u0006\b\u0004\u0010 \u0018\u0001\"\u0006\b\u0005\u0010#\u0018\u0001\"\u0006\b\u0006\u0010&\u0018\u0001\"\u0006\b\u0007\u0010)\u0018\u0001\"\u0006\b\b\u0010,\u0018\u00012·\u0001\b\u0004\u0010\u0013\u001a°\u0001\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u0011H\u001a¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u0011H ¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\"\u0012\u0013\u0012\u0011H#¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(%\u0012\u0013\u0012\u0011H&¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b((\u0012\u0013\u0012\u0011H)¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(+\u0012\u0013\u0012\u0011H,¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(.\u0012\u0004\u0012\u0002H\u00120-H\u0086\bø\u0001\u0000J\u008b\u0002\u0010\u0010\u001a\u00020\u0011\"\u0006\b\u0000\u0010\u0012\u0018\u0001\"\u0006\b\u0001\u0010\u0016\u0018\u0001\"\u0006\b\u0002\u0010\u001a\u0018\u0001\"\u0006\b\u0003\u0010\u001d\u0018\u0001\"\u0006\b\u0004\u0010 \u0018\u0001\"\u0006\b\u0005\u0010#\u0018\u0001\"\u0006\b\u0006\u0010&\u0018\u0001\"\u0006\b\u0007\u0010)\u0018\u00012·\u0001\b\u0004\u0010\u0013\u001a°\u0001\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u0011H\u001a¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u0011H ¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\"\u0012\u0013\u0012\u0011H#¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(%\u0012\u0013\u0012\u0011H&¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b((\u0012\u0013\u0012\u0011H)¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(+\u0012\u0013\u0012\u00110/¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(.\u0012\u0004\u0012\u0002H\u00120-H\u0087\bø\u0001\u0000¢\u0006\u0002\b0Jî\u0001\u0010\u0010\u001a\u00020\u0011\"\u0006\b\u0000\u0010\u0012\u0018\u0001\"\u0006\b\u0001\u0010\u0016\u0018\u0001\"\u0006\b\u0002\u0010\u001a\u0018\u0001\"\u0006\b\u0003\u0010\u001d\u0018\u0001\"\u0006\b\u0004\u0010 \u0018\u0001\"\u0006\b\u0005\u0010#\u0018\u0001\"\u0006\b\u0006\u0010&\u0018\u00012¢\u0001\b\u0004\u0010\u0013\u001a\u009b\u0001\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u0011H\u001a¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u0011H ¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\"\u0012\u0013\u0012\u0011H#¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(%\u0012\u0013\u0012\u0011H&¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b((\u0012\u0013\u0012\u00110/¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(+\u0012\u0004\u0012\u0002H\u00120*H\u0087\bø\u0001\u0000¢\u0006\u0002\b0JÑ\u0001\u0010\u0010\u001a\u00020\u0011\"\u0006\b\u0000\u0010\u0012\u0018\u0001\"\u0006\b\u0001\u0010\u0016\u0018\u0001\"\u0006\b\u0002\u0010\u001a\u0018\u0001\"\u0006\b\u0003\u0010\u001d\u0018\u0001\"\u0006\b\u0004\u0010 \u0018\u0001\"\u0006\b\u0005\u0010#\u0018\u00012\u008d\u0001\b\u0004\u0010\u0013\u001a\u0086\u0001\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u0011H\u001a¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u0011H ¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\"\u0012\u0013\u0012\u0011H#¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(%\u0012\u0013\u0012\u00110/¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b((\u0012\u0004\u0012\u0002H\u00120'H\u0087\bø\u0001\u0000¢\u0006\u0002\b0J²\u0001\u0010\u0010\u001a\u00020\u0011\"\u0006\b\u0000\u0010\u0012\u0018\u0001\"\u0006\b\u0001\u0010\u0016\u0018\u0001\"\u0006\b\u0002\u0010\u001a\u0018\u0001\"\u0006\b\u0003\u0010\u001d\u0018\u0001\"\u0006\b\u0004\u0010 \u0018\u00012w\b\u0004\u0010\u0013\u001aq\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u0011H\u001a¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u0011H ¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110/¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(%\u0012\u0004\u0012\u0002H\u00120$H\u0087\bø\u0001\u0000¢\u0006\u0002\b0J\u0095\u0001\u0010\u0010\u001a\u00020\u0011\"\u0006\b\u0000\u0010\u0012\u0018\u0001\"\u0006\b\u0001\u0010\u0016\u0018\u0001\"\u0006\b\u0002\u0010\u001a\u0018\u0001\"\u0006\b\u0003\u0010\u001d\u0018\u00012b\b\u0004\u0010\u0013\u001a\\\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u0011H\u001a¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110/¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\"\u0012\u0004\u0012\u0002H\u00120!H\u0087\bø\u0001\u0000¢\u0006\u0002\b0Jx\u0010\u0010\u001a\u00020\u0011\"\u0006\b\u0000\u0010\u0012\u0018\u0001\"\u0006\b\u0001\u0010\u0016\u0018\u0001\"\u0006\b\u0002\u0010\u001a\u0018\u00012M\b\u0004\u0010\u0013\u001aG\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u0011H\u001a¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110/¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u0002H\u00120\u001eH\u0087\bø\u0001\u0000¢\u0006\u0002\b0J[\u0010\u0010\u001a\u00020\u0011\"\u0006\b\u0000\u0010\u0012\u0018\u0001\"\u0006\b\u0001\u0010\u0016\u0018\u000128\b\u0004\u0010\u0013\u001a2\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110/¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u0002H\u00120\u001bH\u0087\bø\u0001\u0000¢\u0006\u0002\b0J6\u00101\u001a\u00020\u0006\"\u0006\b\u0000\u0010\u0012\u0018\u00012\u001e\b\u0004\u00102\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001203\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0017H\u0086\b¢\u0006\u0002\u00104JS\u00101\u001a\u000205\"\u0006\b\u0000\u0010\u0012\u0018\u0001\"\u0006\b\u0001\u0010\u0016\u0018\u000123\b\u0004\u00102\u001a-\b\u0001\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001203\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001bH\u0086\b¢\u0006\u0002\u00106Jp\u00101\u001a\u000205\"\u0006\b\u0000\u0010\u0012\u0018\u0001\"\u0006\b\u0001\u0010\u0016\u0018\u0001\"\u0006\b\u0002\u0010\u001a\u0018\u00012H\b\u0004\u00102\u001aB\b\u0001\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u0011H\u001a¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001203\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001eH\u0086\b¢\u0006\u0002\u00107J\u008d\u0001\u00101\u001a\u000205\"\u0006\b\u0000\u0010\u0012\u0018\u0001\"\u0006\b\u0001\u0010\u0016\u0018\u0001\"\u0006\b\u0002\u0010\u001a\u0018\u0001\"\u0006\b\u0003\u0010\u001d\u0018\u00012]\b\u0004\u00102\u001aW\b\u0001\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u0011H\u001a¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001203\u0012\u0006\u0012\u0004\u0018\u00010\u00010!H\u0086\b¢\u0006\u0002\u00108Jª\u0001\u00101\u001a\u000205\"\u0006\b\u0000\u0010\u0012\u0018\u0001\"\u0006\b\u0001\u0010\u0016\u0018\u0001\"\u0006\b\u0002\u0010\u001a\u0018\u0001\"\u0006\b\u0003\u0010\u001d\u0018\u0001\"\u0006\b\u0004\u0010 \u0018\u00012r\b\u0004\u00102\u001al\b\u0001\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u0011H\u001a¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u0011H ¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\"\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001203\u0012\u0006\u0012\u0004\u0018\u00010\u00010$H\u0086\b¢\u0006\u0002\u00109JÉ\u0001\u00101\u001a\u000205\"\u0006\b\u0000\u0010\u0012\u0018\u0001\"\u0006\b\u0001\u0010\u0016\u0018\u0001\"\u0006\b\u0002\u0010\u001a\u0018\u0001\"\u0006\b\u0003\u0010\u001d\u0018\u0001\"\u0006\b\u0004\u0010 \u0018\u0001\"\u0006\b\u0005\u0010#\u0018\u00012\u0088\u0001\b\u0004\u00102\u001a\u0081\u0001\b\u0001\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u0011H\u001a¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u0011H ¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\"\u0012\u0013\u0012\u0011H#¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(%\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001203\u0012\u0006\u0012\u0004\u0018\u00010\u00010'H\u0086\b¢\u0006\u0002\u0010:Jæ\u0001\u00101\u001a\u000205\"\u0006\b\u0000\u0010\u0012\u0018\u0001\"\u0006\b\u0001\u0010\u0016\u0018\u0001\"\u0006\b\u0002\u0010\u001a\u0018\u0001\"\u0006\b\u0003\u0010\u001d\u0018\u0001\"\u0006\b\u0004\u0010 \u0018\u0001\"\u0006\b\u0005\u0010#\u0018\u0001\"\u0006\b\u0006\u0010&\u0018\u00012\u009d\u0001\b\u0004\u00102\u001a\u0096\u0001\b\u0001\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u0011H\u001a¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u0011H ¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\"\u0012\u0013\u0012\u0011H#¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(%\u0012\u0013\u0012\u0011H&¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b((\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001203\u0012\u0006\u0012\u0004\u0018\u00010\u00010*H\u0086\b¢\u0006\u0002\u0010;J\u0083\u0002\u00101\u001a\u000205\"\u0006\b\u0000\u0010\u0012\u0018\u0001\"\u0006\b\u0001\u0010\u0016\u0018\u0001\"\u0006\b\u0002\u0010\u001a\u0018\u0001\"\u0006\b\u0003\u0010\u001d\u0018\u0001\"\u0006\b\u0004\u0010 \u0018\u0001\"\u0006\b\u0005\u0010#\u0018\u0001\"\u0006\b\u0006\u0010&\u0018\u0001\"\u0006\b\u0007\u0010)\u0018\u00012²\u0001\b\u0004\u00102\u001a«\u0001\b\u0001\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u0011H\u001a¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u0011H ¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\"\u0012\u0013\u0012\u0011H#¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(%\u0012\u0013\u0012\u0011H&¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b((\u0012\u0013\u0012\u0011H)¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(+\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001203\u0012\u0006\u0012\u0004\u0018\u00010\u00010-H\u0086\b¢\u0006\u0002\u0010<J \u0002\u00101\u001a\u000205\"\u0006\b\u0000\u0010\u0012\u0018\u0001\"\u0006\b\u0001\u0010\u0016\u0018\u0001\"\u0006\b\u0002\u0010\u001a\u0018\u0001\"\u0006\b\u0003\u0010\u001d\u0018\u0001\"\u0006\b\u0004\u0010 \u0018\u0001\"\u0006\b\u0005\u0010#\u0018\u0001\"\u0006\b\u0006\u0010&\u0018\u0001\"\u0006\b\u0007\u0010)\u0018\u0001\"\u0006\b\b\u0010,\u0018\u00012Ç\u0001\b\u0004\u00102\u001aÀ\u0001\b\u0001\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u0011H\u001a¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u0011H ¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\"\u0012\u0013\u0012\u0011H#¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(%\u0012\u0013\u0012\u0011H&¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b((\u0012\u0013\u0012\u0011H)¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(+\u0012\u0013\u0012\u0011H,¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(.\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001203\u0012\u0006\u0012\u0004\u0018\u00010\u00010=H\u0086\b¢\u0006\u0002\u0010>J\r\u0010?\u001a\u00020\u0006H\u0000¢\u0006\u0002\b@R&\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\b\u001a\u0004\b\u000e\u0010\u000f\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006A"}, d2 = {"Lexpo/modules/kotlin/functions/AsyncFunctionBuilder;", "", "name", "", "(Ljava/lang/String;)V", "asyncFunctionComponent", "Lexpo/modules/kotlin/functions/BaseAsyncFunctionComponent;", "getAsyncFunctionComponent$annotations", "()V", "getAsyncFunctionComponent", "()Lexpo/modules/kotlin/functions/BaseAsyncFunctionComponent;", "setAsyncFunctionComponent", "(Lexpo/modules/kotlin/functions/BaseAsyncFunctionComponent;)V", "getName$annotations", "getName", "()Ljava/lang/String;", "AsyncBody", "Lexpo/modules/kotlin/functions/AsyncFunction;", "R", "body", "Lkotlin/Function0;", "AsyncBodyWithoutArgs", "P0", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "p0", "P1", "Lkotlin/Function2;", "p1", "P2", "Lkotlin/Function3;", "p2", "P3", "Lkotlin/Function4;", "p3", "P4", "Lkotlin/Function5;", "p4", "P5", "Lkotlin/Function6;", "p5", "P6", "Lkotlin/Function7;", "p6", "P7", "Lkotlin/Function8;", "p7", "Lexpo/modules/kotlin/Promise;", "AsyncFunctionWithPromise", "SuspendBody", "block", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function1;)Lexpo/modules/kotlin/functions/BaseAsyncFunctionComponent;", "Lexpo/modules/kotlin/functions/SuspendFunctionComponent;", "(Lkotlin/jvm/functions/Function2;)Lexpo/modules/kotlin/functions/SuspendFunctionComponent;", "(Lkotlin/jvm/functions/Function3;)Lexpo/modules/kotlin/functions/SuspendFunctionComponent;", "(Lkotlin/jvm/functions/Function4;)Lexpo/modules/kotlin/functions/SuspendFunctionComponent;", "(Lkotlin/jvm/functions/Function5;)Lexpo/modules/kotlin/functions/SuspendFunctionComponent;", "(Lkotlin/jvm/functions/Function6;)Lexpo/modules/kotlin/functions/SuspendFunctionComponent;", "(Lkotlin/jvm/functions/Function7;)Lexpo/modules/kotlin/functions/SuspendFunctionComponent;", "(Lkotlin/jvm/functions/Function8;)Lexpo/modules/kotlin/functions/SuspendFunctionComponent;", "Lkotlin/Function9;", "(Lkotlin/jvm/functions/Function9;)Lexpo/modules/kotlin/functions/SuspendFunctionComponent;", "build", "build$expo_modules_core_release", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AsyncFunctionBuilder {
    public static final int $stable = 8;
    private BaseAsyncFunctionComponent asyncFunctionComponent;
    private final String name;

    public static /* synthetic */ void getAsyncFunctionComponent$annotations() {
    }

    public static /* synthetic */ void getName$annotations() {
    }

    public AsyncFunctionBuilder(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
    }

    public final String getName() {
        return this.name;
    }

    public final BaseAsyncFunctionComponent getAsyncFunctionComponent() {
        return this.asyncFunctionComponent;
    }

    public final void setAsyncFunctionComponent(BaseAsyncFunctionComponent baseAsyncFunctionComponent) {
        this.asyncFunctionComponent = baseAsyncFunctionComponent;
    }

    /* compiled from: AsyncFunctionBuilder.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0010\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0005H\u008a@"}, d2 = {"<anonymous>", "", "R", "Lkotlinx/coroutines/CoroutineScope;", "it", ""}, k = 3, mv = {1, 9, 0}, xi = 176)
    @DebugMetadata(c = "expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$1", f = "AsyncFunctionBuilder.kt", i = {}, l = {17}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$1, reason: invalid class name and case insensitive filesystem */
    public static final class C04881 extends SuspendLambda implements Function3<CoroutineScope, Object[], Continuation<? super Object>, Object> {
        final /* synthetic */ Function1<Continuation<? super R>, Object> $block;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C04881(Function1<? super Continuation<? super R>, ? extends Object> function1, Continuation<? super C04881> continuation) {
            super(3, continuation);
            this.$block = function1;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Object[] objArr, Continuation<? super Object> continuation) {
            return invoke2(coroutineScope, objArr, (Continuation<Object>) continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Object[] objArr, Continuation<Object> continuation) {
            return new C04881(this.$block, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Function1<Continuation<? super R>, Object> function1 = this.$block;
                this.label = 1;
                obj = function1.invoke(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }

        public final Object invokeSuspend$$forInline(Object obj) {
            return this.$block.invoke(this);
        }
    }

    public final /* synthetic */ <R> BaseAsyncFunctionComponent SuspendBody(Function1<? super Continuation<? super R>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        SuspendFunctionComponent suspendFunctionComponent = new SuspendFunctionComponent(getName(), new AnyType[0], new C04881(block, null));
        setAsyncFunctionComponent(suspendFunctionComponent);
        return suspendFunctionComponent;
    }

    /* compiled from: AsyncFunctionBuilder.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\u0003\u0018\u0001*\u00020\u00042\u0010\u0010\u0005\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0006H\u008a@"}, d2 = {"<anonymous>", "", "R", "P0", "Lkotlinx/coroutines/CoroutineScope;", "<name for destructuring parameter 0>", ""}, k = 3, mv = {1, 9, 0}, xi = 176)
    @DebugMetadata(c = "expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$3", f = "AsyncFunctionBuilder.kt", i = {}, l = {25}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$3, reason: invalid class name and case insensitive filesystem */
    public static final class C04893 extends SuspendLambda implements Function3<CoroutineScope, Object[], Continuation<? super Object>, Object> {
        final /* synthetic */ Function2<P0, Continuation<? super R>, Object> $block;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C04893(Function2<? super P0, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super C04893> continuation) {
            super(3, continuation);
            this.$block = function2;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Object[] objArr, Continuation<? super Object> continuation) {
            return invoke2(coroutineScope, objArr, (Continuation<Object>) continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Object[] objArr, Continuation<Object> continuation) {
            C04893 c04893 = new C04893(this.$block, continuation);
            c04893.L$0 = objArr;
            return c04893.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Object obj2 = ((Object[]) this.L$0)[0];
                Function2<P0, Continuation<? super R>, Object> function2 = this.$block;
                this.label = 1;
                obj = function2.invoke(obj2, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }

        public final Object invokeSuspend$$forInline(Object obj) {
            return this.$block.invoke(((Object[]) this.L$0)[0], this);
        }
    }

    public final /* synthetic */ <R, P0> SuspendFunctionComponent SuspendBody(Function2<? super P0, ? super Continuation<? super R>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        String name = getName();
        Intrinsics.reifiedOperationMarker(4, "P0");
        AnyType[] anyTypeArr = new AnyType[1];
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$1 asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$1 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$1));
        }
        anyTypeArr[0] = anyType;
        SuspendFunctionComponent suspendFunctionComponent = new SuspendFunctionComponent(name, anyTypeArr, new C04893(block, null));
        setAsyncFunctionComponent(suspendFunctionComponent);
        return suspendFunctionComponent;
    }

    /* compiled from: AsyncFunctionBuilder.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\u0003\u0018\u0001\"\u0006\b\u0002\u0010\u0004\u0018\u0001*\u00020\u00052\u0010\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0007H\u008a@"}, d2 = {"<anonymous>", "", "R", "P0", "P1", "Lkotlinx/coroutines/CoroutineScope;", "<name for destructuring parameter 0>", ""}, k = 3, mv = {1, 9, 0}, xi = 176)
    @DebugMetadata(c = "expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$5", f = "AsyncFunctionBuilder.kt", i = {}, l = {34}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$5, reason: invalid class name and case insensitive filesystem */
    public static final class C04905 extends SuspendLambda implements Function3<CoroutineScope, Object[], Continuation<? super Object>, Object> {
        final /* synthetic */ Function3<P0, P1, Continuation<? super R>, Object> $block;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C04905(Function3<? super P0, ? super P1, ? super Continuation<? super R>, ? extends Object> function3, Continuation<? super C04905> continuation) {
            super(3, continuation);
            this.$block = function3;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Object[] objArr, Continuation<? super Object> continuation) {
            return invoke2(coroutineScope, objArr, (Continuation<Object>) continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Object[] objArr, Continuation<Object> continuation) {
            C04905 c04905 = new C04905(this.$block, continuation);
            c04905.L$0 = objArr;
            return c04905.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Object[] objArr = (Object[]) this.L$0;
                Object obj2 = objArr[0];
                Object obj3 = objArr[1];
                Function3<P0, P1, Continuation<? super R>, Object> function3 = this.$block;
                this.label = 1;
                obj = function3.invoke(obj2, obj3, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }

        public final Object invokeSuspend$$forInline(Object obj) {
            Object[] objArr = (Object[]) this.L$0;
            return this.$block.invoke(objArr[0], objArr[1], this);
        }
    }

    public final /* synthetic */ <R, P0, P1> SuspendFunctionComponent SuspendBody(Function3<? super P0, ? super P1, ? super Continuation<? super R>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        String name = getName();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Intrinsics.reifiedOperationMarker(4, "P1");
        AnyType[] anyTypeArr = new AnyType[2];
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$2 asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$2 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$2
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$2));
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$3 asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$3 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$3
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$3));
        }
        anyTypeArr[1] = anyType2;
        SuspendFunctionComponent suspendFunctionComponent = new SuspendFunctionComponent(name, anyTypeArr, new C04905(block, null));
        setAsyncFunctionComponent(suspendFunctionComponent);
        return suspendFunctionComponent;
    }

    /* compiled from: AsyncFunctionBuilder.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\u0003\u0018\u0001\"\u0006\b\u0002\u0010\u0004\u0018\u0001\"\u0006\b\u0003\u0010\u0005\u0018\u0001*\u00020\u00062\u0010\u0010\u0007\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\bH\u008a@"}, d2 = {"<anonymous>", "", "R", "P0", "P1", "P2", "Lkotlinx/coroutines/CoroutineScope;", "<name for destructuring parameter 0>", ""}, k = 3, mv = {1, 9, 0}, xi = 176)
    @DebugMetadata(c = "expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$7", f = "AsyncFunctionBuilder.kt", i = {}, l = {43}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$7, reason: invalid class name */
    public static final class AnonymousClass7 extends SuspendLambda implements Function3<CoroutineScope, Object[], Continuation<? super Object>, Object> {
        final /* synthetic */ Function4<P0, P1, P2, Continuation<? super R>, Object> $block;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass7(Function4<? super P0, ? super P1, ? super P2, ? super Continuation<? super R>, ? extends Object> function4, Continuation<? super AnonymousClass7> continuation) {
            super(3, continuation);
            this.$block = function4;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Object[] objArr, Continuation<? super Object> continuation) {
            return invoke2(coroutineScope, objArr, (Continuation<Object>) continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Object[] objArr, Continuation<Object> continuation) {
            AnonymousClass7 anonymousClass7 = new AnonymousClass7(this.$block, continuation);
            anonymousClass7.L$0 = objArr;
            return anonymousClass7.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Object[] objArr = (Object[]) this.L$0;
                Object obj2 = objArr[0];
                Object obj3 = objArr[1];
                Object obj4 = objArr[2];
                Function4<P0, P1, P2, Continuation<? super R>, Object> function4 = this.$block;
                this.label = 1;
                obj = function4.invoke(obj2, obj3, obj4, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }

        public final Object invokeSuspend$$forInline(Object obj) {
            Object[] objArr = (Object[]) this.L$0;
            return this.$block.invoke(objArr[0], objArr[1], objArr[2], this);
        }
    }

    public final /* synthetic */ <R, P0, P1, P2> SuspendFunctionComponent SuspendBody(Function4<? super P0, ? super P1, ? super P2, ? super Continuation<? super R>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        String name = getName();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Intrinsics.reifiedOperationMarker(4, "P1");
        Intrinsics.reifiedOperationMarker(4, "P2");
        AnyType[] anyTypeArr = new AnyType[3];
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$4 asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$4 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$4
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$4));
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$5 asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$5 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$5
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$5));
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$6 asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$6 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$6
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$6));
        }
        anyTypeArr[2] = anyType3;
        SuspendFunctionComponent suspendFunctionComponent = new SuspendFunctionComponent(name, anyTypeArr, new AnonymousClass7(block, null));
        setAsyncFunctionComponent(suspendFunctionComponent);
        return suspendFunctionComponent;
    }

    /* compiled from: AsyncFunctionBuilder.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\u0003\u0018\u0001\"\u0006\b\u0002\u0010\u0004\u0018\u0001\"\u0006\b\u0003\u0010\u0005\u0018\u0001\"\u0006\b\u0004\u0010\u0006\u0018\u0001*\u00020\u00072\u0010\u0010\b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\tH\u008a@"}, d2 = {"<anonymous>", "", "R", "P0", "P1", "P2", "P3", "Lkotlinx/coroutines/CoroutineScope;", "<name for destructuring parameter 0>", ""}, k = 3, mv = {1, 9, 0}, xi = 176)
    @DebugMetadata(c = "expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$9", f = "AsyncFunctionBuilder.kt", i = {}, l = {Elf64.Ehdr.E_EHSIZE}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$9, reason: invalid class name */
    public static final class AnonymousClass9 extends SuspendLambda implements Function3<CoroutineScope, Object[], Continuation<? super Object>, Object> {
        final /* synthetic */ Function5<P0, P1, P2, P3, Continuation<? super R>, Object> $block;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass9(Function5<? super P0, ? super P1, ? super P2, ? super P3, ? super Continuation<? super R>, ? extends Object> function5, Continuation<? super AnonymousClass9> continuation) {
            super(3, continuation);
            this.$block = function5;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Object[] objArr, Continuation<? super Object> continuation) {
            return invoke2(coroutineScope, objArr, (Continuation<Object>) continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Object[] objArr, Continuation<Object> continuation) {
            AnonymousClass9 anonymousClass9 = new AnonymousClass9(this.$block, continuation);
            anonymousClass9.L$0 = objArr;
            return anonymousClass9.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Object[] objArr = (Object[]) this.L$0;
                Object obj2 = objArr[0];
                Object obj3 = objArr[1];
                Object obj4 = objArr[2];
                Object obj5 = objArr[3];
                Function5<P0, P1, P2, P3, Continuation<? super R>, Object> function5 = this.$block;
                this.label = 1;
                obj = function5.invoke(obj2, obj3, obj4, obj5, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }

        public final Object invokeSuspend$$forInline(Object obj) {
            Object[] objArr = (Object[]) this.L$0;
            return this.$block.invoke(objArr[0], objArr[1], objArr[2], objArr[3], this);
        }
    }

    public final /* synthetic */ <R, P0, P1, P2, P3> SuspendFunctionComponent SuspendBody(Function5<? super P0, ? super P1, ? super P2, ? super P3, ? super Continuation<? super R>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        String name = getName();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Intrinsics.reifiedOperationMarker(4, "P1");
        Intrinsics.reifiedOperationMarker(4, "P2");
        Intrinsics.reifiedOperationMarker(4, "P3");
        AnyType[] anyTypeArr = new AnyType[4];
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$7 asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$7 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$7
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$7));
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$8 asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$8 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$8
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$8));
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$9 asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$9 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$9
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$9));
        }
        anyTypeArr[2] = anyType3;
        AnyTypeProvider anyTypeProvider4 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeProvider4.getTypesMap().get(new Pair(orCreateKotlinClass7, false));
        if (anyType4 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$10 asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$10 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$10
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P3");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P3");
            KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P3");
            anyType4 = new AnyType(new LazyKType(orCreateKotlinClass8, false, asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$10));
        }
        anyTypeArr[3] = anyType4;
        SuspendFunctionComponent suspendFunctionComponent = new SuspendFunctionComponent(name, anyTypeArr, new AnonymousClass9(block, null));
        setAsyncFunctionComponent(suspendFunctionComponent);
        return suspendFunctionComponent;
    }

    /* compiled from: AsyncFunctionBuilder.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\u0003\u0018\u0001\"\u0006\b\u0002\u0010\u0004\u0018\u0001\"\u0006\b\u0003\u0010\u0005\u0018\u0001\"\u0006\b\u0004\u0010\u0006\u0018\u0001\"\u0006\b\u0005\u0010\u0007\u0018\u0001*\u00020\b2\u0010\u0010\t\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\nH\u008a@"}, d2 = {"<anonymous>", "", "R", "P0", "P1", "P2", "P3", "P4", "Lkotlinx/coroutines/CoroutineScope;", "<name for destructuring parameter 0>", ""}, k = 3, mv = {1, 9, 0}, xi = 176)
    @DebugMetadata(c = "expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$11", f = "AsyncFunctionBuilder.kt", i = {}, l = {LockFreeTaskQueueCore.CLOSED_SHIFT}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$11, reason: invalid class name */
    public static final class AnonymousClass11 extends SuspendLambda implements Function3<CoroutineScope, Object[], Continuation<? super Object>, Object> {
        final /* synthetic */ Function6<P0, P1, P2, P3, P4, Continuation<? super R>, Object> $block;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass11(Function6<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super Continuation<? super R>, ? extends Object> function6, Continuation<? super AnonymousClass11> continuation) {
            super(3, continuation);
            this.$block = function6;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Object[] objArr, Continuation<? super Object> continuation) {
            return invoke2(coroutineScope, objArr, (Continuation<Object>) continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Object[] objArr, Continuation<Object> continuation) {
            AnonymousClass11 anonymousClass11 = new AnonymousClass11(this.$block, continuation);
            anonymousClass11.L$0 = objArr;
            return anonymousClass11.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Object[] objArr = (Object[]) this.L$0;
                Object obj2 = objArr[0];
                Object obj3 = objArr[1];
                Object obj4 = objArr[2];
                Object obj5 = objArr[3];
                Object obj6 = objArr[4];
                Function6<P0, P1, P2, P3, P4, Continuation<? super R>, Object> function6 = this.$block;
                this.label = 1;
                obj = function6.invoke(obj2, obj3, obj4, obj5, obj6, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }

        public final Object invokeSuspend$$forInline(Object obj) {
            Object[] objArr = (Object[]) this.L$0;
            return this.$block.invoke(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], this);
        }
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4> SuspendFunctionComponent SuspendBody(Function6<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super Continuation<? super R>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        String name = getName();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Intrinsics.reifiedOperationMarker(4, "P1");
        Intrinsics.reifiedOperationMarker(4, "P2");
        Intrinsics.reifiedOperationMarker(4, "P3");
        Intrinsics.reifiedOperationMarker(4, "P4");
        AnyType[] anyTypeArr = new AnyType[5];
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$11 asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$11 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$11
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$11));
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$12 asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$12 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$12
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$12));
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$13 asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$13 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$13
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$13));
        }
        anyTypeArr[2] = anyType3;
        AnyTypeProvider anyTypeProvider4 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeProvider4.getTypesMap().get(new Pair(orCreateKotlinClass7, false));
        if (anyType4 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$14 asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$14 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$14
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P3");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P3");
            KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P3");
            anyType4 = new AnyType(new LazyKType(orCreateKotlinClass8, false, asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$14));
        }
        anyTypeArr[3] = anyType4;
        AnyTypeProvider anyTypeProvider5 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P4");
        KClass orCreateKotlinClass9 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P4");
        AnyType anyType5 = anyTypeProvider5.getTypesMap().get(new Pair(orCreateKotlinClass9, false));
        if (anyType5 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$15 asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$15 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$15
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P4");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P4");
            KClass orCreateKotlinClass10 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P4");
            anyType5 = new AnyType(new LazyKType(orCreateKotlinClass10, false, asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$15));
        }
        anyTypeArr[4] = anyType5;
        SuspendFunctionComponent suspendFunctionComponent = new SuspendFunctionComponent(name, anyTypeArr, new AnonymousClass11(block, null));
        setAsyncFunctionComponent(suspendFunctionComponent);
        return suspendFunctionComponent;
    }

    /* compiled from: AsyncFunctionBuilder.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\u0003\u0018\u0001\"\u0006\b\u0002\u0010\u0004\u0018\u0001\"\u0006\b\u0003\u0010\u0005\u0018\u0001\"\u0006\b\u0004\u0010\u0006\u0018\u0001\"\u0006\b\u0005\u0010\u0007\u0018\u0001\"\u0006\b\u0006\u0010\b\u0018\u0001*\u00020\t2\u0010\u0010\n\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u000bH\u008a@"}, d2 = {"<anonymous>", "", "R", "P0", "P1", "P2", "P3", "P4", "P5", "Lkotlinx/coroutines/CoroutineScope;", "<name for destructuring parameter 0>", ""}, k = 3, mv = {1, 9, 0}, xi = 176)
    @DebugMetadata(c = "expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$13", f = "AsyncFunctionBuilder.kt", i = {}, l = {70}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$13, reason: invalid class name */
    public static final class AnonymousClass13 extends SuspendLambda implements Function3<CoroutineScope, Object[], Continuation<? super Object>, Object> {
        final /* synthetic */ Function7<P0, P1, P2, P3, P4, P5, Continuation<? super R>, Object> $block;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass13(Function7<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super Continuation<? super R>, ? extends Object> function7, Continuation<? super AnonymousClass13> continuation) {
            super(3, continuation);
            this.$block = function7;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Object[] objArr, Continuation<? super Object> continuation) {
            return invoke2(coroutineScope, objArr, (Continuation<Object>) continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Object[] objArr, Continuation<Object> continuation) {
            AnonymousClass13 anonymousClass13 = new AnonymousClass13(this.$block, continuation);
            anonymousClass13.L$0 = objArr;
            return anonymousClass13.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Object[] objArr = (Object[]) this.L$0;
                Object obj2 = objArr[0];
                Object obj3 = objArr[1];
                Object obj4 = objArr[2];
                Object obj5 = objArr[3];
                Object obj6 = objArr[4];
                Object obj7 = objArr[5];
                Function7<P0, P1, P2, P3, P4, P5, Continuation<? super R>, Object> function7 = this.$block;
                this.label = 1;
                obj = function7.invoke(obj2, obj3, obj4, obj5, obj6, obj7, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }

        public final Object invokeSuspend$$forInline(Object obj) {
            Object[] objArr = (Object[]) this.L$0;
            return this.$block.invoke(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], this);
        }
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4, P5> SuspendFunctionComponent SuspendBody(Function7<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super Continuation<? super R>, ? extends Object> block) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(block, "block");
        String name = getName();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Intrinsics.reifiedOperationMarker(4, "P1");
        Intrinsics.reifiedOperationMarker(4, "P2");
        Intrinsics.reifiedOperationMarker(4, "P3");
        Intrinsics.reifiedOperationMarker(4, "P4");
        Intrinsics.reifiedOperationMarker(4, "P5");
        AnyType[] anyTypeArr = new AnyType[6];
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$16 asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$16 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$16
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$16));
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$17 asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$17 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$17
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$17));
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$18 asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$18 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$18
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$18));
        }
        anyTypeArr[2] = anyType3;
        AnyTypeProvider anyTypeProvider4 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeProvider4.getTypesMap().get(new Pair(orCreateKotlinClass7, false));
        if (anyType4 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$19 asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$19 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$19
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P3");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P3");
            KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(Object.class);
            i = 3;
            Intrinsics.reifiedOperationMarker(3, "P3");
            anyType4 = new AnyType(new LazyKType(orCreateKotlinClass8, false, asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$19));
        } else {
            i = 3;
        }
        anyTypeArr[i] = anyType4;
        AnyTypeProvider anyTypeProvider5 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P4");
        KClass orCreateKotlinClass9 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(i, "P4");
        AnyType anyType5 = anyTypeProvider5.getTypesMap().get(new Pair(orCreateKotlinClass9, false));
        if (anyType5 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$20 asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$20 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$20
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P4");
                    return null;
                }
            };
            i2 = 4;
            Intrinsics.reifiedOperationMarker(4, "P4");
            KClass orCreateKotlinClass10 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P4");
            anyType5 = new AnyType(new LazyKType(orCreateKotlinClass10, false, asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$20));
        } else {
            i2 = 4;
        }
        anyTypeArr[i2] = anyType5;
        AnyTypeProvider anyTypeProvider6 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(i2, "P5");
        KClass orCreateKotlinClass11 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P5");
        AnyType anyType6 = anyTypeProvider6.getTypesMap().get(new Pair(orCreateKotlinClass11, false));
        if (anyType6 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$21 asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$21 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$21
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P5");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P5");
            KClass orCreateKotlinClass12 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P5");
            anyType6 = new AnyType(new LazyKType(orCreateKotlinClass12, false, asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$21));
        }
        anyTypeArr[5] = anyType6;
        SuspendFunctionComponent suspendFunctionComponent = new SuspendFunctionComponent(name, anyTypeArr, new AnonymousClass13(block, null));
        setAsyncFunctionComponent(suspendFunctionComponent);
        return suspendFunctionComponent;
    }

    /* compiled from: AsyncFunctionBuilder.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\u0003\u0018\u0001\"\u0006\b\u0002\u0010\u0004\u0018\u0001\"\u0006\b\u0003\u0010\u0005\u0018\u0001\"\u0006\b\u0004\u0010\u0006\u0018\u0001\"\u0006\b\u0005\u0010\u0007\u0018\u0001\"\u0006\b\u0006\u0010\b\u0018\u0001\"\u0006\b\u0007\u0010\t\u0018\u0001*\u00020\n2\u0010\u0010\u000b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\fH\u008a@"}, d2 = {"<anonymous>", "", "R", "P0", "P1", "P2", "P3", "P4", "P5", "P6", "Lkotlinx/coroutines/CoroutineScope;", "<name for destructuring parameter 0>", ""}, k = 3, mv = {1, 9, 0}, xi = 176)
    @DebugMetadata(c = "expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$15", f = "AsyncFunctionBuilder.kt", i = {}, l = {79}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$15, reason: invalid class name */
    public static final class AnonymousClass15 extends SuspendLambda implements Function3<CoroutineScope, Object[], Continuation<? super Object>, Object> {
        final /* synthetic */ Function8<P0, P1, P2, P3, P4, P5, P6, Continuation<? super R>, Object> $block;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass15(Function8<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super Continuation<? super R>, ? extends Object> function8, Continuation<? super AnonymousClass15> continuation) {
            super(3, continuation);
            this.$block = function8;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Object[] objArr, Continuation<? super Object> continuation) {
            return invoke2(coroutineScope, objArr, (Continuation<Object>) continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Object[] objArr, Continuation<Object> continuation) {
            AnonymousClass15 anonymousClass15 = new AnonymousClass15(this.$block, continuation);
            anonymousClass15.L$0 = objArr;
            return anonymousClass15.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Object[] objArr = (Object[]) this.L$0;
                Object obj2 = objArr[0];
                Object obj3 = objArr[1];
                Object obj4 = objArr[2];
                Object obj5 = objArr[3];
                Object obj6 = objArr[4];
                Object obj7 = objArr[5];
                Object obj8 = objArr[6];
                Function8<P0, P1, P2, P3, P4, P5, P6, Continuation<? super R>, Object> function8 = this.$block;
                this.label = 1;
                obj = function8.invoke(obj2, obj3, obj4, obj5, obj6, obj7, obj8, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }

        public final Object invokeSuspend$$forInline(Object obj) {
            Object[] objArr = (Object[]) this.L$0;
            return this.$block.invoke(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6], this);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r1v1 expo.modules.kotlin.functions.SuspendFunctionComponent, still in use, count: 2, list:
          (r1v1 expo.modules.kotlin.functions.SuspendFunctionComponent) from 0x009a: MOVE (r16v0 expo.modules.kotlin.functions.SuspendFunctionComponent) = (r1v1 expo.modules.kotlin.functions.SuspendFunctionComponent)
          (r1v1 expo.modules.kotlin.functions.SuspendFunctionComponent) from 0x008a: MOVE (r16v2 expo.modules.kotlin.functions.SuspendFunctionComponent) = (r1v1 expo.modules.kotlin.functions.SuspendFunctionComponent)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
        	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:91)
        	at jadx.core.utils.InsnRemover.addAndUnbind(InsnRemover.java:57)
        	at jadx.core.dex.visitors.ModVisitor.removeStep(ModVisitor.java:463)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:97)
        */
    public final /* synthetic */ <R, P0, P1, P2, P3, P4, P5, P6> expo.modules.kotlin.functions.SuspendFunctionComponent SuspendBody(kotlin.jvm.functions.Function8<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> r18) {
        /*
            Method dump skipped, instructions count: 628
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.kotlin.functions.AsyncFunctionBuilder.SuspendBody(kotlin.jvm.functions.Function8):expo.modules.kotlin.functions.SuspendFunctionComponent");
    }

    /* compiled from: AsyncFunctionBuilder.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\u0003\u0018\u0001\"\u0006\b\u0002\u0010\u0004\u0018\u0001\"\u0006\b\u0003\u0010\u0005\u0018\u0001\"\u0006\b\u0004\u0010\u0006\u0018\u0001\"\u0006\b\u0005\u0010\u0007\u0018\u0001\"\u0006\b\u0006\u0010\b\u0018\u0001\"\u0006\b\u0007\u0010\t\u0018\u0001\"\u0006\b\b\u0010\n\u0018\u0001*\u00020\u000b2\u0010\u0010\f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\rH\u008a@"}, d2 = {"<anonymous>", "", "R", "P0", "P1", "P2", "P3", "P4", "P5", "P6", "P7", "Lkotlinx/coroutines/CoroutineScope;", "<name for destructuring parameter 0>", ""}, k = 3, mv = {1, 9, 0}, xi = 176)
    @DebugMetadata(c = "expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$17", f = "AsyncFunctionBuilder.kt", i = {}, l = {88}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$17, reason: invalid class name */
    public static final class AnonymousClass17 extends SuspendLambda implements Function3<CoroutineScope, Object[], Continuation<? super Object>, Object> {
        final /* synthetic */ Function9<P0, P1, P2, P3, P4, P5, P6, P7, Continuation<? super R>, Object> $block;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass17(Function9<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? super Continuation<? super R>, ? extends Object> function9, Continuation<? super AnonymousClass17> continuation) {
            super(3, continuation);
            this.$block = function9;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Object[] objArr, Continuation<? super Object> continuation) {
            return invoke2(coroutineScope, objArr, (Continuation<Object>) continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Object[] objArr, Continuation<Object> continuation) {
            AnonymousClass17 anonymousClass17 = new AnonymousClass17(this.$block, continuation);
            anonymousClass17.L$0 = objArr;
            return anonymousClass17.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Object[] objArr = (Object[]) this.L$0;
                Object obj2 = objArr[0];
                Object obj3 = objArr[1];
                Object obj4 = objArr[2];
                Object obj5 = objArr[3];
                Object obj6 = objArr[4];
                Object obj7 = objArr[5];
                Object obj8 = objArr[6];
                Object obj9 = objArr[7];
                Function9<P0, P1, P2, P3, P4, P5, P6, P7, Continuation<? super R>, Object> function9 = this.$block;
                this.label = 1;
                obj = function9.invoke(obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }

        public final Object invokeSuspend$$forInline(Object obj) {
            Object[] objArr = (Object[]) this.L$0;
            return this.$block.invoke(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6], objArr[7], this);
        }
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4, P5, P6, P7> SuspendFunctionComponent SuspendBody(Function9<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? super Continuation<? super R>, ? extends Object> block) {
        String str;
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(block, "block");
        String name = getName();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Intrinsics.reifiedOperationMarker(4, "P1");
        Intrinsics.reifiedOperationMarker(4, "P2");
        Intrinsics.reifiedOperationMarker(4, "P3");
        Intrinsics.reifiedOperationMarker(4, "P4");
        Intrinsics.reifiedOperationMarker(4, "P5");
        Intrinsics.reifiedOperationMarker(4, "P6");
        Intrinsics.reifiedOperationMarker(4, "P7");
        AnyType[] anyTypeArr = new AnyType[8];
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$29 asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$29 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$29
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            str = name;
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$29));
        } else {
            str = name;
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$30 asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$30 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$30
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$30));
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$31 asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$31 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$31
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$31));
        }
        anyTypeArr[2] = anyType3;
        AnyTypeProvider anyTypeProvider4 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeProvider4.getTypesMap().get(new Pair(orCreateKotlinClass7, false));
        if (anyType4 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$32 asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$32 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$32
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P3");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P3");
            KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(Object.class);
            i = 3;
            Intrinsics.reifiedOperationMarker(3, "P3");
            anyType4 = new AnyType(new LazyKType(orCreateKotlinClass8, false, asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$32));
        } else {
            i = 3;
        }
        anyTypeArr[i] = anyType4;
        AnyTypeProvider anyTypeProvider5 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P4");
        KClass orCreateKotlinClass9 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(i, "P4");
        AnyType anyType5 = anyTypeProvider5.getTypesMap().get(new Pair(orCreateKotlinClass9, false));
        if (anyType5 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$33 asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$33 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$33
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P4");
                    return null;
                }
            };
            i2 = 4;
            Intrinsics.reifiedOperationMarker(4, "P4");
            KClass orCreateKotlinClass10 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P4");
            anyType5 = new AnyType(new LazyKType(orCreateKotlinClass10, false, asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$33));
        } else {
            i2 = 4;
        }
        anyTypeArr[i2] = anyType5;
        AnyTypeProvider anyTypeProvider6 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(i2, "P5");
        KClass orCreateKotlinClass11 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P5");
        AnyType anyType6 = anyTypeProvider6.getTypesMap().get(new Pair(orCreateKotlinClass11, false));
        if (anyType6 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$34 asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$34 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$34
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P5");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P5");
            KClass orCreateKotlinClass12 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P5");
            anyType6 = new AnyType(new LazyKType(orCreateKotlinClass12, false, asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$34));
        }
        anyTypeArr[5] = anyType6;
        AnyTypeProvider anyTypeProvider7 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P6");
        KClass orCreateKotlinClass13 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P6");
        AnyType anyType7 = anyTypeProvider7.getTypesMap().get(new Pair(orCreateKotlinClass13, false));
        if (anyType7 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$35 asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$35 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$35
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P6");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P6");
            KClass orCreateKotlinClass14 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P6");
            anyType7 = new AnyType(new LazyKType(orCreateKotlinClass14, false, asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$35));
        }
        anyTypeArr[6] = anyType7;
        AnyTypeProvider anyTypeProvider8 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P7");
        KClass orCreateKotlinClass15 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P7");
        AnyType anyType8 = anyTypeProvider8.getTypesMap().get(new Pair(orCreateKotlinClass15, false));
        if (anyType8 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$36 asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$36 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$36
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P7");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P7");
            KClass orCreateKotlinClass16 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P7");
            anyType8 = new AnyType(new LazyKType(orCreateKotlinClass16, false, asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$36));
        }
        anyTypeArr[7] = anyType8;
        SuspendFunctionComponent suspendFunctionComponent = new SuspendFunctionComponent(str, anyTypeArr, new AnonymousClass17(block, null));
        setAsyncFunctionComponent(suspendFunctionComponent);
        return suspendFunctionComponent;
    }

    public final AsyncFunction AsyncBodyWithoutArgs(final Function0<? extends Object> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        AsyncFunctionComponent asyncFunctionComponent = new AsyncFunctionComponent(getName(), new AnyType[0], new Function1<Object[], Object>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder.AsyncBody.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object[] it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return body.invoke();
            }
        });
        setAsyncFunctionComponent(asyncFunctionComponent);
        return asyncFunctionComponent;
    }

    public final /* synthetic */ <R> AsyncFunction AsyncBody(final Function0<? extends R> body) {
        AsyncFunctionComponent asyncFunctionComponent;
        Intrinsics.checkNotNullParameter(body, "body");
        String name = getName();
        AnyType[] anyTypeArr = new AnyType[0];
        Intrinsics.needClassReification();
        Function1<Object[], R> function1 = new Function1<Object[], R>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder.AsyncBody.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final R invoke(Object[] it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return body.invoke();
            }
        };
        Intrinsics.reifiedOperationMarker(3, "R");
        Intrinsics.reifiedOperationMarker(4, "R");
        if (Intrinsics.areEqual(Object.class, Integer.TYPE)) {
            asyncFunctionComponent = new IntAsyncFunctionComponent(name, anyTypeArr, function1);
        } else if (Intrinsics.areEqual(Object.class, Boolean.TYPE)) {
            asyncFunctionComponent = new BoolAsyncFunctionComponent(name, anyTypeArr, function1);
        } else if (Intrinsics.areEqual(Object.class, Double.TYPE)) {
            asyncFunctionComponent = new DoubleAsyncFunctionComponent(name, anyTypeArr, function1);
        } else if (Intrinsics.areEqual(Object.class, Float.TYPE)) {
            asyncFunctionComponent = new FloatAsyncFunctionComponent(name, anyTypeArr, function1);
        } else if (Intrinsics.areEqual(Object.class, String.class)) {
            asyncFunctionComponent = new StringAsyncFunctionComponent(name, anyTypeArr, function1);
        } else {
            asyncFunctionComponent = new AsyncFunctionComponent(name, anyTypeArr, function1);
        }
        setAsyncFunctionComponent(asyncFunctionComponent);
        return asyncFunctionComponent;
    }

    public final /* synthetic */ <R, P0> AsyncFunction AsyncBody(final Function1<? super P0, ? extends R> body) {
        AsyncFunctionComponent asyncFunctionComponent;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent;
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.reifiedOperationMarker(4, "P0");
        if (Object.class != Promise.class) {
            String name = getName();
            Intrinsics.reifiedOperationMarker(4, "P0");
            AnyType[] anyTypeArr = new AnyType[1];
            AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
            if (anyType == null) {
                Intrinsics.needClassReification();
                AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$1 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$1 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$1
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        Intrinsics.reifiedOperationMarker(6, "P0");
                        return null;
                    }
                };
                Intrinsics.reifiedOperationMarker(4, "P0");
                KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
                Intrinsics.reifiedOperationMarker(3, "P0");
                anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$1));
            }
            anyTypeArr[0] = anyType;
            Intrinsics.needClassReification();
            Function1<Object[], R> function1 = new Function1<Object[], R>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder.AsyncBody.6
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final R invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    return body.invoke(objArr[0]);
                }
            };
            Intrinsics.reifiedOperationMarker(3, "R");
            Intrinsics.reifiedOperationMarker(4, "R");
            if (Intrinsics.areEqual(Object.class, Integer.TYPE)) {
                asyncFunctionComponent = new IntAsyncFunctionComponent(name, anyTypeArr, function1);
            } else if (Intrinsics.areEqual(Object.class, Boolean.TYPE)) {
                asyncFunctionComponent = new BoolAsyncFunctionComponent(name, anyTypeArr, function1);
            } else if (Intrinsics.areEqual(Object.class, Double.TYPE)) {
                asyncFunctionComponent = new DoubleAsyncFunctionComponent(name, anyTypeArr, function1);
            } else if (Intrinsics.areEqual(Object.class, Float.TYPE)) {
                asyncFunctionComponent = new FloatAsyncFunctionComponent(name, anyTypeArr, function1);
            } else if (Intrinsics.areEqual(Object.class, String.class)) {
                asyncFunctionComponent = new StringAsyncFunctionComponent(name, anyTypeArr, function1);
            } else {
                asyncFunctionComponent = new AsyncFunctionComponent(name, anyTypeArr, function1);
            }
            asyncFunctionWithPromiseComponent = asyncFunctionComponent;
        } else {
            Intrinsics.needClassReification();
            asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent(getName(), new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder.AsyncBody.5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Function1<P0, R> function12 = body;
                    Intrinsics.reifiedOperationMarker(1, "P0");
                    function12.invoke(promise);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
        }
        setAsyncFunctionComponent(asyncFunctionWithPromiseComponent);
        return asyncFunctionWithPromiseComponent;
    }

    public final /* synthetic */ <R, P0, P1> AsyncFunction AsyncBody(final Function2<? super P0, ? super P1, ? extends R> body) {
        AsyncFunctionComponent asyncFunctionComponent;
        Intrinsics.checkNotNullParameter(body, "body");
        String name = getName();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Intrinsics.reifiedOperationMarker(4, "P1");
        AnyType[] anyTypeArr = new AnyType[2];
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$2 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$2 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$2
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$2));
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$3 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$3 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$3
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$3));
        }
        anyTypeArr[1] = anyType2;
        Intrinsics.needClassReification();
        Function1<Object[], R> function1 = new Function1<Object[], R>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder.AsyncBody.8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final R invoke(Object[] objArr) {
                Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                return body.invoke(objArr[0], objArr[1]);
            }
        };
        Intrinsics.reifiedOperationMarker(3, "R");
        Intrinsics.reifiedOperationMarker(4, "R");
        if (Intrinsics.areEqual(Object.class, Integer.TYPE)) {
            asyncFunctionComponent = new IntAsyncFunctionComponent(name, anyTypeArr, function1);
        } else if (Intrinsics.areEqual(Object.class, Boolean.TYPE)) {
            asyncFunctionComponent = new BoolAsyncFunctionComponent(name, anyTypeArr, function1);
        } else if (Intrinsics.areEqual(Object.class, Double.TYPE)) {
            asyncFunctionComponent = new DoubleAsyncFunctionComponent(name, anyTypeArr, function1);
        } else if (Intrinsics.areEqual(Object.class, Float.TYPE)) {
            asyncFunctionComponent = new FloatAsyncFunctionComponent(name, anyTypeArr, function1);
        } else if (Intrinsics.areEqual(Object.class, String.class)) {
            asyncFunctionComponent = new StringAsyncFunctionComponent(name, anyTypeArr, function1);
        } else {
            asyncFunctionComponent = new AsyncFunctionComponent(name, anyTypeArr, function1);
        }
        setAsyncFunctionComponent(asyncFunctionComponent);
        return asyncFunctionComponent;
    }

    public final /* synthetic */ <R, P0> AsyncFunction AsyncFunctionWithPromise(final Function2<? super P0, ? super Promise, ? extends R> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        String name = getName();
        Intrinsics.reifiedOperationMarker(4, "P0");
        AnyType[] anyTypeArr = new AnyType[1];
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$4 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$4 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$4
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$4));
        }
        anyTypeArr[0] = anyType;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent(name, anyTypeArr, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder.AsyncBody.10
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object[] objArr, Promise promise) {
                Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                Intrinsics.checkNotNullParameter(promise, "promise");
                body.invoke(objArr[0], promise);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                invoke2(objArr, promise);
                return Unit.INSTANCE;
            }
        });
        setAsyncFunctionComponent(asyncFunctionWithPromiseComponent);
        return asyncFunctionWithPromiseComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2> AsyncFunction AsyncBody(final Function3<? super P0, ? super P1, ? super P2, ? extends R> body) {
        AsyncFunctionComponent asyncFunctionComponent;
        Intrinsics.checkNotNullParameter(body, "body");
        String name = getName();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Intrinsics.reifiedOperationMarker(4, "P1");
        Intrinsics.reifiedOperationMarker(4, "P2");
        AnyType[] anyTypeArr = new AnyType[3];
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$5 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$5 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$5
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$5));
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$6 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$6 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$6
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$6));
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$7 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$7 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$7
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$7));
        }
        anyTypeArr[2] = anyType3;
        Intrinsics.needClassReification();
        Function1<Object[], R> function1 = new Function1<Object[], R>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder.AsyncBody.12
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final R invoke(Object[] objArr) {
                Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                return body.invoke(objArr[0], objArr[1], objArr[2]);
            }
        };
        Intrinsics.reifiedOperationMarker(3, "R");
        Intrinsics.reifiedOperationMarker(4, "R");
        if (Intrinsics.areEqual(Object.class, Integer.TYPE)) {
            asyncFunctionComponent = new IntAsyncFunctionComponent(name, anyTypeArr, function1);
        } else if (Intrinsics.areEqual(Object.class, Boolean.TYPE)) {
            asyncFunctionComponent = new BoolAsyncFunctionComponent(name, anyTypeArr, function1);
        } else if (Intrinsics.areEqual(Object.class, Double.TYPE)) {
            asyncFunctionComponent = new DoubleAsyncFunctionComponent(name, anyTypeArr, function1);
        } else if (Intrinsics.areEqual(Object.class, Float.TYPE)) {
            asyncFunctionComponent = new FloatAsyncFunctionComponent(name, anyTypeArr, function1);
        } else if (Intrinsics.areEqual(Object.class, String.class)) {
            asyncFunctionComponent = new StringAsyncFunctionComponent(name, anyTypeArr, function1);
        } else {
            asyncFunctionComponent = new AsyncFunctionComponent(name, anyTypeArr, function1);
        }
        setAsyncFunctionComponent(asyncFunctionComponent);
        return asyncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1> AsyncFunction AsyncFunctionWithPromise(final Function3<? super P0, ? super P1, ? super Promise, ? extends R> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        String name = getName();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Intrinsics.reifiedOperationMarker(4, "P1");
        AnyType[] anyTypeArr = new AnyType[2];
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$8 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$8 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$8
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$8));
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$9 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$9 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$9
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$9));
        }
        anyTypeArr[1] = anyType2;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent(name, anyTypeArr, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder.AsyncBody.14
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object[] objArr, Promise promise) {
                Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                Intrinsics.checkNotNullParameter(promise, "promise");
                body.invoke(objArr[0], objArr[1], promise);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                invoke2(objArr, promise);
                return Unit.INSTANCE;
            }
        });
        setAsyncFunctionComponent(asyncFunctionWithPromiseComponent);
        return asyncFunctionWithPromiseComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3> AsyncFunction AsyncBody(final Function4<? super P0, ? super P1, ? super P2, ? super P3, ? extends R> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        String name = getName();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Intrinsics.reifiedOperationMarker(4, "P1");
        Intrinsics.reifiedOperationMarker(4, "P2");
        Intrinsics.reifiedOperationMarker(4, "P3");
        AnyType[] anyTypeArr = new AnyType[4];
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$10 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$10 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$10
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$10));
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$11 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$11 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$11
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$11));
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$12 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$12 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$12
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$12));
        }
        anyTypeArr[2] = anyType3;
        AnyTypeProvider anyTypeProvider4 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeProvider4.getTypesMap().get(new Pair(orCreateKotlinClass7, false));
        if (anyType4 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$13 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$13 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$13
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P3");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P3");
            KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P3");
            anyType4 = new AnyType(new LazyKType(orCreateKotlinClass8, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$13));
        }
        anyTypeArr[3] = anyType4;
        Intrinsics.needClassReification();
        Function1<Object[], R> function1 = new Function1<Object[], R>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder.AsyncBody.16
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final R invoke(Object[] objArr) {
                Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                return body.invoke(objArr[0], objArr[1], objArr[2], objArr[3]);
            }
        };
        Intrinsics.reifiedOperationMarker(3, "R");
        Intrinsics.reifiedOperationMarker(4, "R");
        AsyncFunctionComponent intAsyncFunctionComponent = Intrinsics.areEqual(Object.class, Integer.TYPE) ? new IntAsyncFunctionComponent(name, anyTypeArr, function1) : Intrinsics.areEqual(Object.class, Boolean.TYPE) ? new BoolAsyncFunctionComponent(name, anyTypeArr, function1) : Intrinsics.areEqual(Object.class, Double.TYPE) ? new DoubleAsyncFunctionComponent(name, anyTypeArr, function1) : Intrinsics.areEqual(Object.class, Float.TYPE) ? new FloatAsyncFunctionComponent(name, anyTypeArr, function1) : Intrinsics.areEqual(Object.class, String.class) ? new StringAsyncFunctionComponent(name, anyTypeArr, function1) : new AsyncFunctionComponent(name, anyTypeArr, function1);
        setAsyncFunctionComponent(intAsyncFunctionComponent);
        return intAsyncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2> AsyncFunction AsyncFunctionWithPromise(final Function4<? super P0, ? super P1, ? super P2, ? super Promise, ? extends R> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        String name = getName();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Intrinsics.reifiedOperationMarker(4, "P1");
        Intrinsics.reifiedOperationMarker(4, "P2");
        AnyType[] anyTypeArr = new AnyType[3];
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$14 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$14 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$14
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$14));
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$15 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$15 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$15
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$15));
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$16 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$16 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$16
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$16));
        }
        anyTypeArr[2] = anyType3;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent(name, anyTypeArr, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder.AsyncBody.18
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object[] objArr, Promise promise) {
                Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                Intrinsics.checkNotNullParameter(promise, "promise");
                body.invoke(objArr[0], objArr[1], objArr[2], promise);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                invoke2(objArr, promise);
                return Unit.INSTANCE;
            }
        });
        setAsyncFunctionComponent(asyncFunctionWithPromiseComponent);
        return asyncFunctionWithPromiseComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4> AsyncFunction AsyncBody(final Function5<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? extends R> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        String name = getName();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Intrinsics.reifiedOperationMarker(4, "P1");
        Intrinsics.reifiedOperationMarker(4, "P2");
        Intrinsics.reifiedOperationMarker(4, "P3");
        Intrinsics.reifiedOperationMarker(4, "P4");
        AnyType[] anyTypeArr = new AnyType[5];
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$17 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$17 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$17
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$17));
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$18 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$18 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$18
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$18));
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$19 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$19 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$19
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$19));
        }
        anyTypeArr[2] = anyType3;
        AnyTypeProvider anyTypeProvider4 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeProvider4.getTypesMap().get(new Pair(orCreateKotlinClass7, false));
        if (anyType4 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$20 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$20 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$20
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P3");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P3");
            KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P3");
            anyType4 = new AnyType(new LazyKType(orCreateKotlinClass8, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$20));
        }
        anyTypeArr[3] = anyType4;
        AnyTypeProvider anyTypeProvider5 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P4");
        KClass orCreateKotlinClass9 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P4");
        AnyType anyType5 = anyTypeProvider5.getTypesMap().get(new Pair(orCreateKotlinClass9, false));
        if (anyType5 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$21 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$21 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$21
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P4");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P4");
            KClass orCreateKotlinClass10 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P4");
            anyType5 = new AnyType(new LazyKType(orCreateKotlinClass10, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$21));
        }
        anyTypeArr[4] = anyType5;
        Intrinsics.needClassReification();
        Function1<Object[], R> function1 = new Function1<Object[], R>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder.AsyncBody.20
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final R invoke(Object[] objArr) {
                Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                return body.invoke(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4]);
            }
        };
        Intrinsics.reifiedOperationMarker(3, "R");
        Intrinsics.reifiedOperationMarker(4, "R");
        AsyncFunctionComponent intAsyncFunctionComponent = Intrinsics.areEqual(Object.class, Integer.TYPE) ? new IntAsyncFunctionComponent(name, anyTypeArr, function1) : Intrinsics.areEqual(Object.class, Boolean.TYPE) ? new BoolAsyncFunctionComponent(name, anyTypeArr, function1) : Intrinsics.areEqual(Object.class, Double.TYPE) ? new DoubleAsyncFunctionComponent(name, anyTypeArr, function1) : Intrinsics.areEqual(Object.class, Float.TYPE) ? new FloatAsyncFunctionComponent(name, anyTypeArr, function1) : Intrinsics.areEqual(Object.class, String.class) ? new StringAsyncFunctionComponent(name, anyTypeArr, function1) : new AsyncFunctionComponent(name, anyTypeArr, function1);
        setAsyncFunctionComponent(intAsyncFunctionComponent);
        return intAsyncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3> AsyncFunction AsyncFunctionWithPromise(final Function5<? super P0, ? super P1, ? super P2, ? super P3, ? super Promise, ? extends R> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        String name = getName();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Intrinsics.reifiedOperationMarker(4, "P1");
        Intrinsics.reifiedOperationMarker(4, "P2");
        Intrinsics.reifiedOperationMarker(4, "P3");
        AnyType[] anyTypeArr = new AnyType[4];
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$22 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$22 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$22
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$22));
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$23 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$23 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$23
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$23));
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$24 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$24 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$24
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$24));
        }
        anyTypeArr[2] = anyType3;
        AnyTypeProvider anyTypeProvider4 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeProvider4.getTypesMap().get(new Pair(orCreateKotlinClass7, false));
        if (anyType4 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$25 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$25 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$25
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P3");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P3");
            KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P3");
            anyType4 = new AnyType(new LazyKType(orCreateKotlinClass8, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$25));
        }
        anyTypeArr[3] = anyType4;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent(name, anyTypeArr, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder.AsyncBody.22
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object[] objArr, Promise promise) {
                Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                Intrinsics.checkNotNullParameter(promise, "promise");
                body.invoke(objArr[0], objArr[1], objArr[2], objArr[3], promise);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                invoke2(objArr, promise);
                return Unit.INSTANCE;
            }
        });
        setAsyncFunctionComponent(asyncFunctionWithPromiseComponent);
        return asyncFunctionWithPromiseComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4, P5> AsyncFunction AsyncBody(final Function6<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? extends R> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        String name = getName();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Intrinsics.reifiedOperationMarker(4, "P1");
        Intrinsics.reifiedOperationMarker(4, "P2");
        Intrinsics.reifiedOperationMarker(4, "P3");
        Intrinsics.reifiedOperationMarker(4, "P4");
        Intrinsics.reifiedOperationMarker(4, "P5");
        AnyType[] anyTypeArr = new AnyType[6];
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$26 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$26 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$26
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$26));
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$27 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$27 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$27
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$27));
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$28 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$28 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$28
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$28));
        }
        anyTypeArr[2] = anyType3;
        AnyTypeProvider anyTypeProvider4 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeProvider4.getTypesMap().get(new Pair(orCreateKotlinClass7, false));
        if (anyType4 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$29 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$29 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$29
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P3");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P3");
            KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P3");
            anyType4 = new AnyType(new LazyKType(orCreateKotlinClass8, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$29));
        }
        anyTypeArr[3] = anyType4;
        AnyTypeProvider anyTypeProvider5 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P4");
        KClass orCreateKotlinClass9 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P4");
        AnyType anyType5 = anyTypeProvider5.getTypesMap().get(new Pair(orCreateKotlinClass9, false));
        if (anyType5 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$30 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$30 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$30
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P4");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P4");
            KClass orCreateKotlinClass10 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P4");
            anyType5 = new AnyType(new LazyKType(orCreateKotlinClass10, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$30));
        }
        anyTypeArr[4] = anyType5;
        AnyTypeProvider anyTypeProvider6 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P5");
        KClass orCreateKotlinClass11 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P5");
        AnyType anyType6 = anyTypeProvider6.getTypesMap().get(new Pair(orCreateKotlinClass11, false));
        if (anyType6 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$31 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$31 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$31
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P5");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P5");
            KClass orCreateKotlinClass12 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P5");
            anyType6 = new AnyType(new LazyKType(orCreateKotlinClass12, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$31));
        }
        anyTypeArr[5] = anyType6;
        Intrinsics.needClassReification();
        Function1<Object[], R> function1 = new Function1<Object[], R>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder.AsyncBody.24
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final R invoke(Object[] objArr) {
                Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                return body.invoke(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5]);
            }
        };
        Intrinsics.reifiedOperationMarker(3, "R");
        Intrinsics.reifiedOperationMarker(4, "R");
        AsyncFunctionComponent intAsyncFunctionComponent = Intrinsics.areEqual(Object.class, Integer.TYPE) ? new IntAsyncFunctionComponent(name, anyTypeArr, function1) : Intrinsics.areEqual(Object.class, Boolean.TYPE) ? new BoolAsyncFunctionComponent(name, anyTypeArr, function1) : Intrinsics.areEqual(Object.class, Double.TYPE) ? new DoubleAsyncFunctionComponent(name, anyTypeArr, function1) : Intrinsics.areEqual(Object.class, Float.TYPE) ? new FloatAsyncFunctionComponent(name, anyTypeArr, function1) : Intrinsics.areEqual(Object.class, String.class) ? new StringAsyncFunctionComponent(name, anyTypeArr, function1) : new AsyncFunctionComponent(name, anyTypeArr, function1);
        setAsyncFunctionComponent(intAsyncFunctionComponent);
        return intAsyncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4> AsyncFunction AsyncFunctionWithPromise(final Function6<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super Promise, ? extends R> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        String name = getName();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Intrinsics.reifiedOperationMarker(4, "P1");
        Intrinsics.reifiedOperationMarker(4, "P2");
        Intrinsics.reifiedOperationMarker(4, "P3");
        Intrinsics.reifiedOperationMarker(4, "P4");
        AnyType[] anyTypeArr = new AnyType[5];
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$32 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$32 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$32
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$32));
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$33 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$33 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$33
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$33));
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$34 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$34 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$34
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$34));
        }
        anyTypeArr[2] = anyType3;
        AnyTypeProvider anyTypeProvider4 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeProvider4.getTypesMap().get(new Pair(orCreateKotlinClass7, false));
        if (anyType4 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$35 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$35 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$35
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P3");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P3");
            KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P3");
            anyType4 = new AnyType(new LazyKType(orCreateKotlinClass8, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$35));
        }
        anyTypeArr[3] = anyType4;
        AnyTypeProvider anyTypeProvider5 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P4");
        KClass orCreateKotlinClass9 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P4");
        AnyType anyType5 = anyTypeProvider5.getTypesMap().get(new Pair(orCreateKotlinClass9, false));
        if (anyType5 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$36 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$36 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$36
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P4");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P4");
            KClass orCreateKotlinClass10 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P4");
            anyType5 = new AnyType(new LazyKType(orCreateKotlinClass10, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$36));
        }
        anyTypeArr[4] = anyType5;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent(name, anyTypeArr, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder.AsyncBody.26
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object[] objArr, Promise promise) {
                Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                Intrinsics.checkNotNullParameter(promise, "promise");
                body.invoke(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], promise);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                invoke2(objArr, promise);
                return Unit.INSTANCE;
            }
        });
        setAsyncFunctionComponent(asyncFunctionWithPromiseComponent);
        return asyncFunctionWithPromiseComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4, P5, P6> AsyncFunction AsyncBody(final Function7<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? extends R> body) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(body, "body");
        String name = getName();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Intrinsics.reifiedOperationMarker(4, "P1");
        Intrinsics.reifiedOperationMarker(4, "P2");
        Intrinsics.reifiedOperationMarker(4, "P3");
        Intrinsics.reifiedOperationMarker(4, "P4");
        Intrinsics.reifiedOperationMarker(4, "P5");
        Intrinsics.reifiedOperationMarker(4, "P6");
        AnyType[] anyTypeArr = new AnyType[7];
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$37 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$37 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$37
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$37));
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$38 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$38 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$38
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$38));
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$39 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$39 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$39
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$39));
        }
        anyTypeArr[2] = anyType3;
        AnyTypeProvider anyTypeProvider4 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeProvider4.getTypesMap().get(new Pair(orCreateKotlinClass7, false));
        if (anyType4 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$40 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$40 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$40
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P3");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P3");
            KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(Object.class);
            i = 3;
            Intrinsics.reifiedOperationMarker(3, "P3");
            anyType4 = new AnyType(new LazyKType(orCreateKotlinClass8, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$40));
        } else {
            i = 3;
        }
        anyTypeArr[i] = anyType4;
        AnyTypeProvider anyTypeProvider5 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P4");
        KClass orCreateKotlinClass9 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(i, "P4");
        AnyType anyType5 = anyTypeProvider5.getTypesMap().get(new Pair(orCreateKotlinClass9, false));
        if (anyType5 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$41 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$41 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$41
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P4");
                    return null;
                }
            };
            i2 = 4;
            Intrinsics.reifiedOperationMarker(4, "P4");
            KClass orCreateKotlinClass10 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P4");
            anyType5 = new AnyType(new LazyKType(orCreateKotlinClass10, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$41));
        } else {
            i2 = 4;
        }
        anyTypeArr[i2] = anyType5;
        AnyTypeProvider anyTypeProvider6 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(i2, "P5");
        KClass orCreateKotlinClass11 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P5");
        AnyType anyType6 = anyTypeProvider6.getTypesMap().get(new Pair(orCreateKotlinClass11, false));
        if (anyType6 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$42 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$42 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$42
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P5");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P5");
            KClass orCreateKotlinClass12 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P5");
            anyType6 = new AnyType(new LazyKType(orCreateKotlinClass12, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$42));
        }
        anyTypeArr[5] = anyType6;
        AnyTypeProvider anyTypeProvider7 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P6");
        KClass orCreateKotlinClass13 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P6");
        AnyType anyType7 = anyTypeProvider7.getTypesMap().get(new Pair(orCreateKotlinClass13, false));
        if (anyType7 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$43 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$43 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$43
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P6");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P6");
            KClass orCreateKotlinClass14 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P6");
            anyType7 = new AnyType(new LazyKType(orCreateKotlinClass14, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$43));
        }
        anyTypeArr[6] = anyType7;
        Intrinsics.needClassReification();
        Function1<Object[], R> function1 = new Function1<Object[], R>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder.AsyncBody.28
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final R invoke(Object[] objArr) {
                Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                return body.invoke(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6]);
            }
        };
        Intrinsics.reifiedOperationMarker(3, "R");
        Intrinsics.reifiedOperationMarker(4, "R");
        AsyncFunctionComponent intAsyncFunctionComponent = Intrinsics.areEqual(Object.class, Integer.TYPE) ? new IntAsyncFunctionComponent(name, anyTypeArr, function1) : Intrinsics.areEqual(Object.class, Boolean.TYPE) ? new BoolAsyncFunctionComponent(name, anyTypeArr, function1) : Intrinsics.areEqual(Object.class, Double.TYPE) ? new DoubleAsyncFunctionComponent(name, anyTypeArr, function1) : Intrinsics.areEqual(Object.class, Float.TYPE) ? new FloatAsyncFunctionComponent(name, anyTypeArr, function1) : Intrinsics.areEqual(Object.class, String.class) ? new StringAsyncFunctionComponent(name, anyTypeArr, function1) : new AsyncFunctionComponent(name, anyTypeArr, function1);
        setAsyncFunctionComponent(intAsyncFunctionComponent);
        return intAsyncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4, P5> AsyncFunction AsyncFunctionWithPromise(final Function7<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super Promise, ? extends R> body) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(body, "body");
        String name = getName();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Intrinsics.reifiedOperationMarker(4, "P1");
        Intrinsics.reifiedOperationMarker(4, "P2");
        Intrinsics.reifiedOperationMarker(4, "P3");
        Intrinsics.reifiedOperationMarker(4, "P4");
        Intrinsics.reifiedOperationMarker(4, "P5");
        AnyType[] anyTypeArr = new AnyType[6];
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$44 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$44 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$44
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$44));
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$45 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$45 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$45
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$45));
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$46 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$46 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$46
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$46));
        }
        anyTypeArr[2] = anyType3;
        AnyTypeProvider anyTypeProvider4 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeProvider4.getTypesMap().get(new Pair(orCreateKotlinClass7, false));
        if (anyType4 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$47 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$47 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$47
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P3");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P3");
            KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(Object.class);
            i = 3;
            Intrinsics.reifiedOperationMarker(3, "P3");
            anyType4 = new AnyType(new LazyKType(orCreateKotlinClass8, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$47));
        } else {
            i = 3;
        }
        anyTypeArr[i] = anyType4;
        AnyTypeProvider anyTypeProvider5 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P4");
        KClass orCreateKotlinClass9 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(i, "P4");
        AnyType anyType5 = anyTypeProvider5.getTypesMap().get(new Pair(orCreateKotlinClass9, false));
        if (anyType5 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$48 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$48 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$48
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P4");
                    return null;
                }
            };
            i2 = 4;
            Intrinsics.reifiedOperationMarker(4, "P4");
            KClass orCreateKotlinClass10 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P4");
            anyType5 = new AnyType(new LazyKType(orCreateKotlinClass10, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$48));
        } else {
            i2 = 4;
        }
        anyTypeArr[i2] = anyType5;
        AnyTypeProvider anyTypeProvider6 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(i2, "P5");
        KClass orCreateKotlinClass11 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P5");
        AnyType anyType6 = anyTypeProvider6.getTypesMap().get(new Pair(orCreateKotlinClass11, false));
        if (anyType6 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$49 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$49 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$49
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P5");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P5");
            KClass orCreateKotlinClass12 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P5");
            anyType6 = new AnyType(new LazyKType(orCreateKotlinClass12, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$49));
        }
        anyTypeArr[5] = anyType6;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent(name, anyTypeArr, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder.AsyncBody.30
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object[] objArr, Promise promise) {
                Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                Intrinsics.checkNotNullParameter(promise, "promise");
                body.invoke(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], promise);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                invoke2(objArr, promise);
                return Unit.INSTANCE;
            }
        });
        setAsyncFunctionComponent(asyncFunctionWithPromiseComponent);
        return asyncFunctionWithPromiseComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4, P5, P6, P7> AsyncFunction AsyncBody(final Function8<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? extends R> body) {
        String str;
        int i;
        int i2;
        AsyncFunctionComponent boolAsyncFunctionComponent;
        Intrinsics.checkNotNullParameter(body, "body");
        String name = getName();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Intrinsics.reifiedOperationMarker(4, "P1");
        Intrinsics.reifiedOperationMarker(4, "P2");
        Intrinsics.reifiedOperationMarker(4, "P3");
        Intrinsics.reifiedOperationMarker(4, "P4");
        Intrinsics.reifiedOperationMarker(4, "P5");
        Intrinsics.reifiedOperationMarker(4, "P6");
        Intrinsics.reifiedOperationMarker(4, "P7");
        AnyType[] anyTypeArr = new AnyType[8];
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$50 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$50 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$50
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            str = name;
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$50));
        } else {
            str = name;
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$51 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$51 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$51
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$51));
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$52 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$52 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$52
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$52));
        }
        anyTypeArr[2] = anyType3;
        AnyTypeProvider anyTypeProvider4 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeProvider4.getTypesMap().get(new Pair(orCreateKotlinClass7, false));
        if (anyType4 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$53 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$53 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$53
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P3");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P3");
            KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(Object.class);
            i = 3;
            Intrinsics.reifiedOperationMarker(3, "P3");
            anyType4 = new AnyType(new LazyKType(orCreateKotlinClass8, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$53));
        } else {
            i = 3;
        }
        anyTypeArr[i] = anyType4;
        AnyTypeProvider anyTypeProvider5 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P4");
        KClass orCreateKotlinClass9 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(i, "P4");
        AnyType anyType5 = anyTypeProvider5.getTypesMap().get(new Pair(orCreateKotlinClass9, false));
        if (anyType5 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$54 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$54 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$54
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P4");
                    return null;
                }
            };
            i2 = 4;
            Intrinsics.reifiedOperationMarker(4, "P4");
            KClass orCreateKotlinClass10 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P4");
            anyType5 = new AnyType(new LazyKType(orCreateKotlinClass10, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$54));
        } else {
            i2 = 4;
        }
        anyTypeArr[i2] = anyType5;
        AnyTypeProvider anyTypeProvider6 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(i2, "P5");
        KClass orCreateKotlinClass11 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P5");
        AnyType anyType6 = anyTypeProvider6.getTypesMap().get(new Pair(orCreateKotlinClass11, false));
        if (anyType6 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$55 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$55 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$55
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P5");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P5");
            KClass orCreateKotlinClass12 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P5");
            anyType6 = new AnyType(new LazyKType(orCreateKotlinClass12, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$55));
        }
        anyTypeArr[5] = anyType6;
        AnyTypeProvider anyTypeProvider7 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P6");
        KClass orCreateKotlinClass13 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P6");
        AnyType anyType7 = anyTypeProvider7.getTypesMap().get(new Pair(orCreateKotlinClass13, false));
        if (anyType7 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$56 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$56 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$56
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P6");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P6");
            KClass orCreateKotlinClass14 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P6");
            anyType7 = new AnyType(new LazyKType(orCreateKotlinClass14, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$56));
        }
        anyTypeArr[6] = anyType7;
        AnyTypeProvider anyTypeProvider8 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P7");
        KClass orCreateKotlinClass15 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P7");
        AnyType anyType8 = anyTypeProvider8.getTypesMap().get(new Pair(orCreateKotlinClass15, false));
        if (anyType8 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$57 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$57 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$57
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P7");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P7");
            KClass orCreateKotlinClass16 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P7");
            anyType8 = new AnyType(new LazyKType(orCreateKotlinClass16, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$57));
        }
        anyTypeArr[7] = anyType8;
        Intrinsics.needClassReification();
        Function1<Object[], R> function1 = new Function1<Object[], R>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder.AsyncBody.32
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final R invoke(Object[] objArr) {
                Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                return body.invoke(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6], objArr[7]);
            }
        };
        Intrinsics.reifiedOperationMarker(3, "R");
        Intrinsics.reifiedOperationMarker(4, "R");
        if (Intrinsics.areEqual(Object.class, Integer.TYPE)) {
            boolAsyncFunctionComponent = new IntAsyncFunctionComponent(str, anyTypeArr, function1);
        } else {
            String str2 = str;
            boolAsyncFunctionComponent = Intrinsics.areEqual(Object.class, Boolean.TYPE) ? new BoolAsyncFunctionComponent(str2, anyTypeArr, function1) : Intrinsics.areEqual(Object.class, Double.TYPE) ? new DoubleAsyncFunctionComponent(str2, anyTypeArr, function1) : Intrinsics.areEqual(Object.class, Float.TYPE) ? new FloatAsyncFunctionComponent(str2, anyTypeArr, function1) : Intrinsics.areEqual(Object.class, String.class) ? new StringAsyncFunctionComponent(str2, anyTypeArr, function1) : new AsyncFunctionComponent(str2, anyTypeArr, function1);
        }
        setAsyncFunctionComponent(boolAsyncFunctionComponent);
        return boolAsyncFunctionComponent;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r1v1 expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent, still in use, count: 2, list:
          (r1v1 expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent) from 0x009a: MOVE (r16v0 expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent) = (r1v1 expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent)
          (r1v1 expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent) from 0x008a: MOVE (r16v2 expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent) = (r1v1 expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
        	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:91)
        	at jadx.core.utils.InsnRemover.addAndUnbind(InsnRemover.java:57)
        	at jadx.core.dex.visitors.ModVisitor.removeStep(ModVisitor.java:463)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:97)
        */
    public final /* synthetic */ <R, P0, P1, P2, P3, P4, P5, P6> expo.modules.kotlin.functions.AsyncFunction AsyncFunctionWithPromise(final kotlin.jvm.functions.Function8<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super expo.modules.kotlin.Promise, ? extends R> r18) {
        /*
            Method dump skipped, instructions count: 630
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.kotlin.functions.AsyncFunctionBuilder.AsyncFunctionWithPromise(kotlin.jvm.functions.Function8):expo.modules.kotlin.functions.AsyncFunction");
    }

    public final BaseAsyncFunctionComponent build$expo_modules_core_release() {
        BaseAsyncFunctionComponent baseAsyncFunctionComponent = this.asyncFunctionComponent;
        if (baseAsyncFunctionComponent != null) {
            return baseAsyncFunctionComponent;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
