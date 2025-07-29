package expo.modules.filesystem.next;

import android.content.Context;
import android.net.Uri;
import androidx.tracing.Trace;
import com.facebook.share.internal.ShareConstants;
import expo.modules.kotlin.classcomponent.ClassComponentBuilder;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.functions.AsyncFunctionBuilder;
import expo.modules.kotlin.functions.SuspendFunctionComponent;
import expo.modules.kotlin.functions.SyncFunctionComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.objects.PropertyComponentBuilderWithThis;
import expo.modules.kotlin.typedarray.TypedArray;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.AnyTypeProvider;
import expo.modules.kotlin.types.Either;
import expo.modules.kotlin.types.LazyKType;
import expo.modules.kotlin.types.ReturnType;
import expo.modules.kotlin.types.ReturnTypeProvider;
import io.sentry.rrweb.RRWebVideoEvent;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;

/* compiled from: FileSystemNextModule.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lexpo/modules/filesystem/next/FileSystemNextModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "expo-file-system_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FileSystemNextModule extends Module {
    /* JADX INFO: Access modifiers changed from: private */
    public final Context getContext() throws Exceptions.AppContextLost {
        Context reactContext = getAppContext().getReactContext();
        if (reactContext != null) {
            return reactContext;
        }
        throw new Exceptions.AppContextLost();
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        FileSystemNextModule fileSystemNextModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (fileSystemNextModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(fileSystemNextModule);
            moduleDefinitionBuilder.Name("FileSystemNext");
            moduleDefinitionBuilder.Constants(TuplesKt.to("documentDirectory", Uri.fromFile(getContext().getFilesDir()).toString() + "/"), TuplesKt.to("cacheDirectory", Uri.fromFile(getContext().getCacheDir()).toString() + "/"), TuplesKt.to("bundleDirectory", "asset:///"));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction = moduleDefinitionBuilder.AsyncFunction("downloadFileAsync");
            String name = asyncFunctionBuilderAsyncFunction.getName();
            AnyType[] anyTypeArr = new AnyType[2];
            AnyType anyType = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(URI.class), false));
            if (anyType == null) {
                str2 = "get";
                str = "exists";
                anyType = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(URI.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.next.FileSystemNextModule$definition$lambda$40$$inlined$Coroutine$1
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(URI.class);
                    }
                }));
            } else {
                str = "exists";
                str2 = "get";
            }
            anyTypeArr[0] = anyType;
            AnyType anyType2 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemPath.class), false));
            if (anyType2 == null) {
                anyType2 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(FileSystemPath.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.next.FileSystemNextModule$definition$lambda$40$$inlined$Coroutine$2
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(FileSystemPath.class);
                    }
                }));
            }
            anyTypeArr[1] = anyType2;
            asyncFunctionBuilderAsyncFunction.setAsyncFunctionComponent(new SuspendFunctionComponent(name, anyTypeArr, new FileSystemNextModule$definition$lambda$40$$inlined$Coroutine$3(null)));
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(FileSystemFile.class);
            String simpleName = JvmClassMappingKt.getJavaClass(orCreateKotlinClass).getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
            AnyType anyType3 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false));
            if (anyType3 == null) {
                anyType3 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.next.FileSystemNextModule$definition$lambda$40$$inlined$Class$1
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(FileSystemFile.class);
                    }
                }));
            }
            ClassComponentBuilder classComponentBuilder = new ClassComponentBuilder(simpleName, orCreateKotlinClass, anyType3);
            AnyType[] anyTypeArr2 = new AnyType[1];
            AnyType anyType4 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(URI.class), false));
            if (anyType4 == null) {
                anyType4 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(URI.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.next.FileSystemNextModule$definition$lambda$40$lambda$21$$inlined$Constructor$1
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(URI.class);
                    }
                }));
            }
            anyTypeArr2[0] = anyType4;
            ReturnType returnType = ReturnTypeProvider.INSTANCE.getTypes().get(Reflection.getOrCreateKotlinClass(Object.class));
            if (returnType == null) {
                returnType = new ReturnType(Reflection.getOrCreateKotlinClass(Object.class));
                ReturnTypeProvider.INSTANCE.getTypes().put(Reflection.getOrCreateKotlinClass(Object.class), returnType);
            }
            classComponentBuilder.setConstructor(new SyncFunctionComponent("constructor", anyTypeArr2, returnType, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.next.FileSystemNextModule$definition$lambda$40$lambda$21$$inlined$Constructor$2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    return new FileSystemFile(new File(((URI) objArr[0]).getPath()));
                }
            }));
            ClassComponentBuilder classComponentBuilder2 = classComponentBuilder;
            AnyType[] anyTypeArr3 = new AnyType[1];
            AnyType anyType5 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false));
            if (anyType5 == null) {
                anyType5 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.next.FileSystemNextModule$definition$lambda$40$lambda$21$$inlined$Function$1
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(FileSystemFile.class);
                    }
                }));
            }
            anyTypeArr3[0] = anyType5;
            ReturnType returnType2 = ReturnTypeProvider.INSTANCE.getTypes().get(Reflection.getOrCreateKotlinClass(Unit.class));
            if (returnType2 == null) {
                returnType2 = new ReturnType(Reflection.getOrCreateKotlinClass(Unit.class));
                ReturnTypeProvider.INSTANCE.getTypes().put(Reflection.getOrCreateKotlinClass(Unit.class), returnType2);
            }
            classComponentBuilder2.getSyncFunctions().put("delete", new SyncFunctionComponent("delete", anyTypeArr3, returnType2, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.next.FileSystemNextModule$definition$lambda$40$lambda$21$$inlined$Function$2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) throws UnableToDeleteException {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    FileSystemPath.delete$default((FileSystemFile) objArr[0], null, 1, null);
                    return Unit.INSTANCE;
                }
            }));
            ClassComponentBuilder classComponentBuilder3 = classComponentBuilder;
            AnyType[] anyTypeArr4 = new AnyType[1];
            AnyType anyType6 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false));
            if (anyType6 == null) {
                anyType6 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.next.FileSystemNextModule$definition$lambda$40$lambda$21$$inlined$Function$3
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(FileSystemFile.class);
                    }
                }));
            }
            anyTypeArr4[0] = anyType6;
            ReturnType returnType3 = ReturnTypeProvider.INSTANCE.getTypes().get(Reflection.getOrCreateKotlinClass(Unit.class));
            if (returnType3 == null) {
                returnType3 = new ReturnType(Reflection.getOrCreateKotlinClass(Unit.class));
                ReturnTypeProvider.INSTANCE.getTypes().put(Reflection.getOrCreateKotlinClass(Unit.class), returnType3);
            }
            classComponentBuilder3.getSyncFunctions().put("validatePath", new SyncFunctionComponent("validatePath", anyTypeArr4, returnType3, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.next.FileSystemNextModule$definition$lambda$40$lambda$21$$inlined$Function$4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    ((FileSystemFile) objArr[0]).validatePath();
                    return Unit.INSTANCE;
                }
            }));
            ClassComponentBuilder classComponentBuilder4 = classComponentBuilder;
            AnyType[] anyTypeArr5 = new AnyType[1];
            AnyType anyType7 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false));
            if (anyType7 == null) {
                anyType7 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.next.FileSystemNextModule$definition$lambda$40$lambda$21$$inlined$Function$5
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(FileSystemFile.class);
                    }
                }));
            }
            anyTypeArr5[0] = anyType7;
            ReturnType returnType4 = ReturnTypeProvider.INSTANCE.getTypes().get(Reflection.getOrCreateKotlinClass(Unit.class));
            if (returnType4 == null) {
                returnType4 = new ReturnType(Reflection.getOrCreateKotlinClass(Unit.class));
                ReturnTypeProvider.INSTANCE.getTypes().put(Reflection.getOrCreateKotlinClass(Unit.class), returnType4);
            }
            classComponentBuilder4.getSyncFunctions().put("create", new SyncFunctionComponent("create", anyTypeArr5, returnType4, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.next.FileSystemNextModule$definition$lambda$40$lambda$21$$inlined$Function$6
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) throws InvalidTypeFileException, IOException {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    ((FileSystemFile) objArr[0]).create();
                    return Unit.INSTANCE;
                }
            }));
            ClassComponentBuilder classComponentBuilder5 = classComponentBuilder;
            AnyType[] anyTypeArr6 = new AnyType[2];
            AnyType anyType8 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false));
            if (anyType8 == null) {
                anyType8 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.next.FileSystemNextModule$definition$lambda$40$lambda$21$$inlined$Function$7
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(FileSystemFile.class);
                    }
                }));
            }
            anyTypeArr6[0] = anyType8;
            AnyType anyType9 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Either.class), false));
            if (anyType9 == null) {
                anyType9 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Either.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.next.FileSystemNextModule$definition$lambda$40$lambda$21$$inlined$Function$8
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(Either.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(TypedArray.class)));
                    }
                }));
            }
            anyTypeArr6[1] = anyType9;
            ReturnType returnType5 = ReturnTypeProvider.INSTANCE.getTypes().get(Reflection.getOrCreateKotlinClass(Unit.class));
            if (returnType5 == null) {
                returnType5 = new ReturnType(Reflection.getOrCreateKotlinClass(Unit.class));
                ReturnTypeProvider.INSTANCE.getTypes().put(Reflection.getOrCreateKotlinClass(Unit.class), returnType5);
            }
            classComponentBuilder5.getSyncFunctions().put("write", new SyncFunctionComponent("write", anyTypeArr6, returnType5, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.next.FileSystemNextModule$definition$lambda$40$lambda$21$$inlined$Function$9
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) throws InvalidTypeFileException, IOException {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Object obj = objArr[0];
                    Either either = (Either) objArr[1];
                    FileSystemFile fileSystemFile = (FileSystemFile) obj;
                    if (either.isFirstType(Reflection.getOrCreateKotlinClass(String.class))) {
                        fileSystemFile.write((String) either.getFirstType(Reflection.getOrCreateKotlinClass(String.class)));
                    }
                    if (either.isSecondType(Reflection.getOrCreateKotlinClass(TypedArray.class))) {
                        fileSystemFile.write((TypedArray) either.getSecondType(Reflection.getOrCreateKotlinClass(TypedArray.class)));
                    }
                    return Unit.INSTANCE;
                }
            }));
            ClassComponentBuilder classComponentBuilder6 = classComponentBuilder;
            AnyType[] anyTypeArr7 = new AnyType[1];
            AnyType anyType10 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false));
            if (anyType10 == null) {
                anyType10 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.next.FileSystemNextModule$definition$lambda$40$lambda$21$$inlined$Function$10
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(FileSystemFile.class);
                    }
                }));
            }
            anyTypeArr7[0] = anyType10;
            ReturnType returnType6 = ReturnTypeProvider.INSTANCE.getTypes().get(Reflection.getOrCreateKotlinClass(String.class));
            if (returnType6 == null) {
                returnType6 = new ReturnType(Reflection.getOrCreateKotlinClass(String.class));
                ReturnTypeProvider.INSTANCE.getTypes().put(Reflection.getOrCreateKotlinClass(String.class), returnType6);
            }
            classComponentBuilder6.getSyncFunctions().put("text", new SyncFunctionComponent("text", anyTypeArr7, returnType6, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.next.FileSystemNextModule$definition$lambda$40$lambda$21$$inlined$Function$11
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    return ((FileSystemFile) objArr[0]).text();
                }
            }));
            ClassComponentBuilder classComponentBuilder7 = classComponentBuilder;
            AnyType[] anyTypeArr8 = new AnyType[1];
            AnyType anyType11 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false));
            if (anyType11 == null) {
                anyType11 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.next.FileSystemNextModule$definition$lambda$40$lambda$21$$inlined$Function$12
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(FileSystemFile.class);
                    }
                }));
            }
            anyTypeArr8[0] = anyType11;
            ReturnType returnType7 = ReturnTypeProvider.INSTANCE.getTypes().get(Reflection.getOrCreateKotlinClass(String.class));
            if (returnType7 == null) {
                returnType7 = new ReturnType(Reflection.getOrCreateKotlinClass(String.class));
                ReturnTypeProvider.INSTANCE.getTypes().put(Reflection.getOrCreateKotlinClass(String.class), returnType7);
            }
            classComponentBuilder7.getSyncFunctions().put("base64", new SyncFunctionComponent("base64", anyTypeArr8, returnType7, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.next.FileSystemNextModule$definition$lambda$40$lambda$21$$inlined$Function$13
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    return ((FileSystemFile) objArr[0]).base64();
                }
            }));
            ClassComponentBuilder classComponentBuilder8 = classComponentBuilder;
            AnyType[] anyTypeArr9 = new AnyType[1];
            AnyType anyType12 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false));
            if (anyType12 == null) {
                anyType12 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.next.FileSystemNextModule$definition$lambda$40$lambda$21$$inlined$Function$14
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(FileSystemFile.class);
                    }
                }));
            }
            anyTypeArr9[0] = anyType12;
            ReturnType returnType8 = ReturnTypeProvider.INSTANCE.getTypes().get(Reflection.getOrCreateKotlinClass(byte[].class));
            if (returnType8 == null) {
                returnType8 = new ReturnType(Reflection.getOrCreateKotlinClass(byte[].class));
                ReturnTypeProvider.INSTANCE.getTypes().put(Reflection.getOrCreateKotlinClass(byte[].class), returnType8);
            }
            classComponentBuilder8.getSyncFunctions().put("bytes", new SyncFunctionComponent("bytes", anyTypeArr9, returnType8, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.next.FileSystemNextModule$definition$lambda$40$lambda$21$$inlined$Function$15
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    return ((FileSystemFile) objArr[0]).bytes();
                }
            }));
            String str6 = str;
            PropertyComponentBuilderWithThis propertyComponentBuilderWithThis = new PropertyComponentBuilderWithThis(classComponentBuilder.getOwnerType().getKType(), str6);
            AnyType[] anyTypeArr10 = {new AnyType(propertyComponentBuilderWithThis.getThisType())};
            ReturnType returnType9 = ReturnTypeProvider.INSTANCE.getTypes().get(Reflection.getOrCreateKotlinClass(Boolean.class));
            if (returnType9 == null) {
                returnType9 = new ReturnType(Reflection.getOrCreateKotlinClass(Boolean.class));
                ReturnTypeProvider.INSTANCE.getTypes().put(Reflection.getOrCreateKotlinClass(Boolean.class), returnType9);
            }
            String str7 = str2;
            SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent(str7, anyTypeArr10, returnType9, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.next.FileSystemNextModule$definition$lambda$40$lambda$21$$inlined$Property$1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.valueOf(((FileSystemFile) it[0]).getExists());
                }
            });
            syncFunctionComponent.setOwnerType(propertyComponentBuilderWithThis.getThisType());
            syncFunctionComponent.setCanTakeOwner(true);
            propertyComponentBuilderWithThis.setGetter(syncFunctionComponent);
            classComponentBuilder.getProperties().put(str6, propertyComponentBuilderWithThis);
            ClassComponentBuilder classComponentBuilder9 = classComponentBuilder;
            AnyType[] anyTypeArr11 = new AnyType[2];
            AnyType anyType13 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false));
            if (anyType13 == null) {
                anyType13 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.next.FileSystemNextModule$definition$lambda$40$lambda$21$$inlined$Function$16
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(FileSystemFile.class);
                    }
                }));
            }
            anyTypeArr11[0] = anyType13;
            AnyType anyType14 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemPath.class), false));
            if (anyType14 == null) {
                anyType14 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(FileSystemPath.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.next.FileSystemNextModule$definition$lambda$40$lambda$21$$inlined$Function$17
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(FileSystemPath.class);
                    }
                }));
            }
            anyTypeArr11[1] = anyType14;
            ReturnType returnType10 = ReturnTypeProvider.INSTANCE.getTypes().get(Reflection.getOrCreateKotlinClass(Unit.class));
            if (returnType10 == null) {
                returnType10 = new ReturnType(Reflection.getOrCreateKotlinClass(Unit.class));
                ReturnTypeProvider.INSTANCE.getTypes().put(Reflection.getOrCreateKotlinClass(Unit.class), returnType10);
            }
            classComponentBuilder9.getSyncFunctions().put("copy", new SyncFunctionComponent("copy", anyTypeArr11, returnType10, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.next.FileSystemNextModule$definition$lambda$40$lambda$21$$inlined$Function$18
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    ((FileSystemFile) objArr[0]).copy((FileSystemPath) objArr[1]);
                    return Unit.INSTANCE;
                }
            }));
            ClassComponentBuilder classComponentBuilder10 = classComponentBuilder;
            AnyType[] anyTypeArr12 = new AnyType[2];
            AnyType anyType15 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false));
            if (anyType15 == null) {
                anyType15 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.next.FileSystemNextModule$definition$lambda$40$lambda$21$$inlined$Function$19
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(FileSystemFile.class);
                    }
                }));
            }
            anyTypeArr12[0] = anyType15;
            AnyType anyType16 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemPath.class), false));
            if (anyType16 == null) {
                anyType16 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(FileSystemPath.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.next.FileSystemNextModule$definition$lambda$40$lambda$21$$inlined$Function$20
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(FileSystemPath.class);
                    }
                }));
            }
            anyTypeArr12[1] = anyType16;
            ReturnType returnType11 = ReturnTypeProvider.INSTANCE.getTypes().get(Reflection.getOrCreateKotlinClass(Unit.class));
            if (returnType11 == null) {
                returnType11 = new ReturnType(Reflection.getOrCreateKotlinClass(Unit.class));
                ReturnTypeProvider.INSTANCE.getTypes().put(Reflection.getOrCreateKotlinClass(Unit.class), returnType11);
            }
            classComponentBuilder10.getSyncFunctions().put("move", new SyncFunctionComponent("move", anyTypeArr12, returnType11, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.next.FileSystemNextModule$definition$lambda$40$lambda$21$$inlined$Function$21
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    ((FileSystemFile) objArr[0]).move((FileSystemPath) objArr[1]);
                    return Unit.INSTANCE;
                }
            }));
            PropertyComponentBuilderWithThis propertyComponentBuilderWithThis2 = new PropertyComponentBuilderWithThis(classComponentBuilder.getOwnerType().getKType(), ShareConstants.MEDIA_URI);
            AnyType[] anyTypeArr13 = {new AnyType(propertyComponentBuilderWithThis2.getThisType())};
            ReturnType returnType12 = ReturnTypeProvider.INSTANCE.getTypes().get(Reflection.getOrCreateKotlinClass(String.class));
            if (returnType12 == null) {
                returnType12 = new ReturnType(Reflection.getOrCreateKotlinClass(String.class));
                ReturnTypeProvider.INSTANCE.getTypes().put(Reflection.getOrCreateKotlinClass(String.class), returnType12);
            }
            SyncFunctionComponent syncFunctionComponent2 = new SyncFunctionComponent(str7, anyTypeArr13, returnType12, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.next.FileSystemNextModule$definition$lambda$40$lambda$21$$inlined$Property$2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return ((FileSystemFile) it[0]).asString();
                }
            });
            syncFunctionComponent2.setOwnerType(propertyComponentBuilderWithThis2.getThisType());
            syncFunctionComponent2.setCanTakeOwner(true);
            propertyComponentBuilderWithThis2.setGetter(syncFunctionComponent2);
            classComponentBuilder.getProperties().put(ShareConstants.MEDIA_URI, propertyComponentBuilderWithThis2);
            PropertyComponentBuilderWithThis propertyComponentBuilderWithThis3 = new PropertyComponentBuilderWithThis(classComponentBuilder.getOwnerType().getKType(), "md5");
            AnyType[] anyTypeArr14 = {new AnyType(propertyComponentBuilderWithThis3.getThisType())};
            ReturnType returnType13 = ReturnTypeProvider.INSTANCE.getTypes().get(Reflection.getOrCreateKotlinClass(String.class));
            if (returnType13 == null) {
                returnType13 = new ReturnType(Reflection.getOrCreateKotlinClass(String.class));
                Map<KClass<?>, ReturnType> types = ReturnTypeProvider.INSTANCE.getTypes();
                str3 = ShareConstants.MEDIA_URI;
                types.put(Reflection.getOrCreateKotlinClass(String.class), returnType13);
            } else {
                str3 = ShareConstants.MEDIA_URI;
            }
            SyncFunctionComponent syncFunctionComponent3 = new SyncFunctionComponent(str7, anyTypeArr14, returnType13, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.next.FileSystemNextModule$definition$lambda$40$lambda$21$$inlined$Property$3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    try {
                        return ((FileSystemFile) it[0]).getMd5();
                    } catch (Exception unused) {
                        return null;
                    }
                }
            });
            syncFunctionComponent3.setOwnerType(propertyComponentBuilderWithThis3.getThisType());
            syncFunctionComponent3.setCanTakeOwner(true);
            propertyComponentBuilderWithThis3.setGetter(syncFunctionComponent3);
            classComponentBuilder.getProperties().put("md5", propertyComponentBuilderWithThis3);
            PropertyComponentBuilderWithThis propertyComponentBuilderWithThis4 = new PropertyComponentBuilderWithThis(classComponentBuilder.getOwnerType().getKType(), RRWebVideoEvent.JsonKeys.SIZE);
            AnyType[] anyTypeArr15 = {new AnyType(propertyComponentBuilderWithThis4.getThisType())};
            ReturnType returnType14 = ReturnTypeProvider.INSTANCE.getTypes().get(Reflection.getOrCreateKotlinClass(Long.class));
            if (returnType14 == null) {
                returnType14 = new ReturnType(Reflection.getOrCreateKotlinClass(Long.class));
                ReturnTypeProvider.INSTANCE.getTypes().put(Reflection.getOrCreateKotlinClass(Long.class), returnType14);
            }
            SyncFunctionComponent syncFunctionComponent4 = new SyncFunctionComponent(str7, anyTypeArr15, returnType14, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.next.FileSystemNextModule$definition$lambda$40$lambda$21$$inlined$Property$4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    try {
                        return ((FileSystemFile) it[0]).getSize();
                    } catch (Exception unused) {
                        return null;
                    }
                }
            });
            syncFunctionComponent4.setOwnerType(propertyComponentBuilderWithThis4.getThisType());
            syncFunctionComponent4.setCanTakeOwner(true);
            propertyComponentBuilderWithThis4.setGetter(syncFunctionComponent4);
            classComponentBuilder.getProperties().put(RRWebVideoEvent.JsonKeys.SIZE, propertyComponentBuilderWithThis4);
            PropertyComponentBuilderWithThis propertyComponentBuilderWithThis5 = new PropertyComponentBuilderWithThis(classComponentBuilder.getOwnerType().getKType(), "type");
            AnyType[] anyTypeArr16 = {new AnyType(propertyComponentBuilderWithThis5.getThisType())};
            ReturnType returnType15 = ReturnTypeProvider.INSTANCE.getTypes().get(Reflection.getOrCreateKotlinClass(String.class));
            if (returnType15 == null) {
                returnType15 = new ReturnType(Reflection.getOrCreateKotlinClass(String.class));
                str4 = "move";
                ReturnTypeProvider.INSTANCE.getTypes().put(Reflection.getOrCreateKotlinClass(String.class), returnType15);
            } else {
                str4 = "move";
            }
            SyncFunctionComponent syncFunctionComponent5 = new SyncFunctionComponent(str7, anyTypeArr16, returnType15, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.next.FileSystemNextModule$definition$lambda$40$lambda$21$$inlined$Property$5
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return ((FileSystemFile) it[0]).getType();
                }
            });
            syncFunctionComponent5.setOwnerType(propertyComponentBuilderWithThis5.getThisType());
            syncFunctionComponent5.setCanTakeOwner(true);
            propertyComponentBuilderWithThis5.setGetter(syncFunctionComponent5);
            classComponentBuilder.getProperties().put("type", propertyComponentBuilderWithThis5);
            ClassComponentBuilder classComponentBuilder11 = classComponentBuilder;
            AnyType[] anyTypeArr17 = new AnyType[1];
            AnyType anyType17 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false));
            if (anyType17 == null) {
                str5 = "delete";
                anyType17 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.next.FileSystemNextModule$definition$lambda$40$lambda$21$$inlined$Function$22
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(FileSystemFile.class);
                    }
                }));
            } else {
                str5 = "delete";
            }
            anyTypeArr17[0] = anyType17;
            ReturnType returnType16 = ReturnTypeProvider.INSTANCE.getTypes().get(Reflection.getOrCreateKotlinClass(FileSystemFileHandle.class));
            if (returnType16 == null) {
                returnType16 = new ReturnType(Reflection.getOrCreateKotlinClass(FileSystemFileHandle.class));
                ReturnTypeProvider.INSTANCE.getTypes().put(Reflection.getOrCreateKotlinClass(FileSystemFileHandle.class), returnType16);
            }
            classComponentBuilder11.getSyncFunctions().put("open", new SyncFunctionComponent("open", anyTypeArr17, returnType16, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.next.FileSystemNextModule$definition$lambda$40$lambda$21$$inlined$Function$23
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    return new FileSystemFileHandle((FileSystemFile) objArr[0]);
                }
            }));
            moduleDefinitionBuilder.getClassData().add(classComponentBuilder.buildClass());
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(FileSystemFileHandle.class);
            String simpleName2 = JvmClassMappingKt.getJavaClass(orCreateKotlinClass2).getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName2, "getSimpleName(...)");
            AnyType anyType18 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemFileHandle.class), false));
            if (anyType18 == null) {
                anyType18 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(FileSystemFileHandle.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.next.FileSystemNextModule$definition$lambda$40$$inlined$Class$2
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(FileSystemFileHandle.class);
                    }
                }));
            }
            ClassComponentBuilder classComponentBuilder12 = new ClassComponentBuilder(simpleName2, orCreateKotlinClass2, anyType18);
            AnyType[] anyTypeArr18 = new AnyType[1];
            AnyType anyType19 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false));
            if (anyType19 == null) {
                anyType19 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.next.FileSystemNextModule$definition$lambda$40$lambda$29$$inlined$Constructor$1
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(FileSystemFile.class);
                    }
                }));
            }
            anyTypeArr18[0] = anyType19;
            ReturnType returnType17 = ReturnTypeProvider.INSTANCE.getTypes().get(Reflection.getOrCreateKotlinClass(Object.class));
            if (returnType17 == null) {
                returnType17 = new ReturnType(Reflection.getOrCreateKotlinClass(Object.class));
                ReturnTypeProvider.INSTANCE.getTypes().put(Reflection.getOrCreateKotlinClass(Object.class), returnType17);
            }
            classComponentBuilder12.setConstructor(new SyncFunctionComponent("constructor", anyTypeArr18, returnType17, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.next.FileSystemNextModule$definition$lambda$40$lambda$29$$inlined$Constructor$2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    return new FileSystemFileHandle((FileSystemFile) objArr[0]);
                }
            }));
            ClassComponentBuilder classComponentBuilder13 = classComponentBuilder12;
            AnyType[] anyTypeArr19 = new AnyType[2];
            AnyType anyType20 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemFileHandle.class), false));
            if (anyType20 == null) {
                anyType20 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(FileSystemFileHandle.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.next.FileSystemNextModule$definition$lambda$40$lambda$29$$inlined$Function$1
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(FileSystemFileHandle.class);
                    }
                }));
            }
            anyTypeArr19[0] = anyType20;
            AnyType anyType21 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Integer.class), false));
            if (anyType21 == null) {
                anyType21 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.next.FileSystemNextModule$definition$lambda$40$lambda$29$$inlined$Function$2
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(Integer.TYPE);
                    }
                }));
            }
            anyTypeArr19[1] = anyType21;
            ReturnType returnType18 = ReturnTypeProvider.INSTANCE.getTypes().get(Reflection.getOrCreateKotlinClass(byte[].class));
            if (returnType18 == null) {
                returnType18 = new ReturnType(Reflection.getOrCreateKotlinClass(byte[].class));
                ReturnTypeProvider.INSTANCE.getTypes().put(Reflection.getOrCreateKotlinClass(byte[].class), returnType18);
            }
            classComponentBuilder13.getSyncFunctions().put("readBytes", new SyncFunctionComponent("readBytes", anyTypeArr19, returnType18, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.next.FileSystemNextModule$definition$lambda$40$lambda$29$$inlined$Function$3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    return ((FileSystemFileHandle) objArr[0]).read(((Number) objArr[1]).intValue());
                }
            }));
            ClassComponentBuilder classComponentBuilder14 = classComponentBuilder12;
            AnyType[] anyTypeArr20 = new AnyType[2];
            AnyType anyType22 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemFileHandle.class), false));
            if (anyType22 == null) {
                anyType22 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(FileSystemFileHandle.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.next.FileSystemNextModule$definition$lambda$40$lambda$29$$inlined$Function$4
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(FileSystemFileHandle.class);
                    }
                }));
            }
            anyTypeArr20[0] = anyType22;
            AnyType anyType23 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(byte[].class), false));
            if (anyType23 == null) {
                anyType23 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(byte[].class), false, new Function0<KType>() { // from class: expo.modules.filesystem.next.FileSystemNextModule$definition$lambda$40$lambda$29$$inlined$Function$5
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(byte[].class);
                    }
                }));
            }
            anyTypeArr20[1] = anyType23;
            ReturnType returnType19 = ReturnTypeProvider.INSTANCE.getTypes().get(Reflection.getOrCreateKotlinClass(Unit.class));
            if (returnType19 == null) {
                returnType19 = new ReturnType(Reflection.getOrCreateKotlinClass(Unit.class));
                ReturnTypeProvider.INSTANCE.getTypes().put(Reflection.getOrCreateKotlinClass(Unit.class), returnType19);
            }
            classComponentBuilder14.getSyncFunctions().put("writeBytes", new SyncFunctionComponent("writeBytes", anyTypeArr20, returnType19, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.next.FileSystemNextModule$definition$lambda$40$lambda$29$$inlined$Function$6
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) throws UnableToWriteHandleException, IOException, UnableToReadHandleException {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    ((FileSystemFileHandle) objArr[0]).write((byte[]) objArr[1]);
                    return Unit.INSTANCE;
                }
            }));
            ClassComponentBuilder classComponentBuilder15 = classComponentBuilder12;
            AnyType[] anyTypeArr21 = new AnyType[1];
            AnyType anyType24 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemFileHandle.class), false));
            if (anyType24 == null) {
                anyType24 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(FileSystemFileHandle.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.next.FileSystemNextModule$definition$lambda$40$lambda$29$$inlined$Function$7
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(FileSystemFileHandle.class);
                    }
                }));
            }
            anyTypeArr21[0] = anyType24;
            ReturnType returnType20 = ReturnTypeProvider.INSTANCE.getTypes().get(Reflection.getOrCreateKotlinClass(Unit.class));
            if (returnType20 == null) {
                returnType20 = new ReturnType(Reflection.getOrCreateKotlinClass(Unit.class));
                ReturnTypeProvider.INSTANCE.getTypes().put(Reflection.getOrCreateKotlinClass(Unit.class), returnType20);
            }
            classComponentBuilder15.getSyncFunctions().put("close", new SyncFunctionComponent("close", anyTypeArr21, returnType20, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.next.FileSystemNextModule$definition$lambda$40$lambda$29$$inlined$Function$8
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    ((FileSystemFileHandle) objArr[0]).close();
                    return Unit.INSTANCE;
                }
            }));
            PropertyComponentBuilderWithThis propertyComponentBuilderWithThis6 = new PropertyComponentBuilderWithThis(classComponentBuilder12.getOwnerType().getKType(), "offset");
            AnyType[] anyTypeArr22 = {new AnyType(propertyComponentBuilderWithThis6.getThisType())};
            ReturnType returnType21 = ReturnTypeProvider.INSTANCE.getTypes().get(Reflection.getOrCreateKotlinClass(Long.class));
            if (returnType21 == null) {
                returnType21 = new ReturnType(Reflection.getOrCreateKotlinClass(Long.class));
                ReturnTypeProvider.INSTANCE.getTypes().put(Reflection.getOrCreateKotlinClass(Long.class), returnType21);
            }
            SyncFunctionComponent syncFunctionComponent6 = new SyncFunctionComponent(str7, anyTypeArr22, returnType21, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.next.FileSystemNextModule$definition$lambda$40$lambda$29$$inlined$Property$1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return ((FileSystemFileHandle) it[0]).getOffset();
                }
            });
            syncFunctionComponent6.setOwnerType(propertyComponentBuilderWithThis6.getThisType());
            syncFunctionComponent6.setCanTakeOwner(true);
            propertyComponentBuilderWithThis6.setGetter(syncFunctionComponent6);
            classComponentBuilder12.getProperties().put("offset", propertyComponentBuilderWithThis6);
            AnyType[] anyTypeArr23 = new AnyType[2];
            anyTypeArr23[0] = new AnyType(propertyComponentBuilderWithThis6.getThisType());
            AnyType anyType25 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Long.class), false));
            if (anyType25 == null) {
                anyType25 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Long.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.next.FileSystemNextModule$definition$lambda$40$lambda$29$$inlined$set$1
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(Long.TYPE);
                    }
                }));
            }
            anyTypeArr23[1] = anyType25;
            ReturnType returnType22 = ReturnTypeProvider.INSTANCE.getTypes().get(Reflection.getOrCreateKotlinClass(Unit.class));
            if (returnType22 == null) {
                returnType22 = new ReturnType(Reflection.getOrCreateKotlinClass(Unit.class));
                ReturnTypeProvider.INSTANCE.getTypes().put(Reflection.getOrCreateKotlinClass(Unit.class), returnType22);
            }
            SyncFunctionComponent syncFunctionComponent7 = new SyncFunctionComponent("set", anyTypeArr23, returnType22, new Function1<Object[], Unit>() { // from class: expo.modules.filesystem.next.FileSystemNextModule$definition$lambda$40$lambda$29$$inlined$set$2
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] it) throws IOException {
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    Object obj2 = it[1];
                    if (obj2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                    }
                    ((FileSystemFileHandle) obj).setOffset(Long.valueOf(((Long) obj2).longValue()));
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr) throws IOException {
                    invoke2(objArr);
                    return Unit.INSTANCE;
                }
            });
            syncFunctionComponent7.setOwnerType(propertyComponentBuilderWithThis6.getThisType());
            syncFunctionComponent7.setCanTakeOwner(true);
            propertyComponentBuilderWithThis6.setSetter(syncFunctionComponent7);
            PropertyComponentBuilderWithThis propertyComponentBuilderWithThis7 = new PropertyComponentBuilderWithThis(classComponentBuilder12.getOwnerType().getKType(), RRWebVideoEvent.JsonKeys.SIZE);
            AnyType[] anyTypeArr24 = {new AnyType(propertyComponentBuilderWithThis7.getThisType())};
            ReturnType returnType23 = ReturnTypeProvider.INSTANCE.getTypes().get(Reflection.getOrCreateKotlinClass(Long.class));
            if (returnType23 == null) {
                returnType23 = new ReturnType(Reflection.getOrCreateKotlinClass(Long.class));
                ReturnTypeProvider.INSTANCE.getTypes().put(Reflection.getOrCreateKotlinClass(Long.class), returnType23);
            }
            SyncFunctionComponent syncFunctionComponent8 = new SyncFunctionComponent(str7, anyTypeArr24, returnType23, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.next.FileSystemNextModule$definition$lambda$40$lambda$29$$inlined$Property$2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return ((FileSystemFileHandle) it[0]).getSize();
                }
            });
            syncFunctionComponent8.setOwnerType(propertyComponentBuilderWithThis7.getThisType());
            syncFunctionComponent8.setCanTakeOwner(true);
            propertyComponentBuilderWithThis7.setGetter(syncFunctionComponent8);
            classComponentBuilder12.getProperties().put(RRWebVideoEvent.JsonKeys.SIZE, propertyComponentBuilderWithThis7);
            moduleDefinitionBuilder.getClassData().add(classComponentBuilder12.buildClass());
            KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(FileSystemDirectory.class);
            String simpleName3 = JvmClassMappingKt.getJavaClass(orCreateKotlinClass3).getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName3, "getSimpleName(...)");
            AnyType anyType26 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemDirectory.class), false));
            if (anyType26 == null) {
                anyType26 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(FileSystemDirectory.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.next.FileSystemNextModule$definition$lambda$40$$inlined$Class$3
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(FileSystemDirectory.class);
                    }
                }));
            }
            ClassComponentBuilder classComponentBuilder16 = new ClassComponentBuilder(simpleName3, orCreateKotlinClass3, anyType26);
            AnyType[] anyTypeArr25 = new AnyType[1];
            AnyType anyType27 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(URI.class), false));
            if (anyType27 == null) {
                anyType27 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(URI.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.next.FileSystemNextModule$definition$lambda$40$lambda$39$$inlined$Constructor$1
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(URI.class);
                    }
                }));
            }
            anyTypeArr25[0] = anyType27;
            ReturnType returnType24 = ReturnTypeProvider.INSTANCE.getTypes().get(Reflection.getOrCreateKotlinClass(Object.class));
            if (returnType24 == null) {
                returnType24 = new ReturnType(Reflection.getOrCreateKotlinClass(Object.class));
                ReturnTypeProvider.INSTANCE.getTypes().put(Reflection.getOrCreateKotlinClass(Object.class), returnType24);
            }
            classComponentBuilder16.setConstructor(new SyncFunctionComponent("constructor", anyTypeArr25, returnType24, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.next.FileSystemNextModule$definition$lambda$40$lambda$39$$inlined$Constructor$2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    return new FileSystemDirectory(new File(((URI) objArr[0]).getPath()));
                }
            }));
            ClassComponentBuilder classComponentBuilder17 = classComponentBuilder16;
            AnyType[] anyTypeArr26 = new AnyType[1];
            AnyType anyType28 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemDirectory.class), false));
            if (anyType28 == null) {
                anyType28 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(FileSystemDirectory.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.next.FileSystemNextModule$definition$lambda$40$lambda$39$$inlined$Function$1
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(FileSystemDirectory.class);
                    }
                }));
            }
            anyTypeArr26[0] = anyType28;
            ReturnType returnType25 = ReturnTypeProvider.INSTANCE.getTypes().get(Reflection.getOrCreateKotlinClass(Unit.class));
            if (returnType25 == null) {
                returnType25 = new ReturnType(Reflection.getOrCreateKotlinClass(Unit.class));
                ReturnTypeProvider.INSTANCE.getTypes().put(Reflection.getOrCreateKotlinClass(Unit.class), returnType25);
            }
            String str8 = str5;
            classComponentBuilder17.getSyncFunctions().put(str8, new SyncFunctionComponent(str8, anyTypeArr26, returnType25, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.next.FileSystemNextModule$definition$lambda$40$lambda$39$$inlined$Function$2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) throws UnableToDeleteException {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    FileSystemPath.delete$default((FileSystemDirectory) objArr[0], null, 1, null);
                    return Unit.INSTANCE;
                }
            }));
            ClassComponentBuilder classComponentBuilder18 = classComponentBuilder16;
            AnyType[] anyTypeArr27 = new AnyType[1];
            AnyType anyType29 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemDirectory.class), false));
            if (anyType29 == null) {
                anyType29 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(FileSystemDirectory.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.next.FileSystemNextModule$definition$lambda$40$lambda$39$$inlined$Function$3
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(FileSystemDirectory.class);
                    }
                }));
            }
            anyTypeArr27[0] = anyType29;
            ReturnType returnType26 = ReturnTypeProvider.INSTANCE.getTypes().get(Reflection.getOrCreateKotlinClass(Unit.class));
            if (returnType26 == null) {
                returnType26 = new ReturnType(Reflection.getOrCreateKotlinClass(Unit.class));
                ReturnTypeProvider.INSTANCE.getTypes().put(Reflection.getOrCreateKotlinClass(Unit.class), returnType26);
            }
            classComponentBuilder18.getSyncFunctions().put("create", new SyncFunctionComponent("create", anyTypeArr27, returnType26, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.next.FileSystemNextModule$definition$lambda$40$lambda$39$$inlined$Function$4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) throws InvalidTypeFolderException {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    ((FileSystemDirectory) objArr[0]).create();
                    return Unit.INSTANCE;
                }
            }));
            PropertyComponentBuilderWithThis propertyComponentBuilderWithThis8 = new PropertyComponentBuilderWithThis(classComponentBuilder16.getOwnerType().getKType(), str6);
            AnyType[] anyTypeArr28 = {new AnyType(propertyComponentBuilderWithThis8.getThisType())};
            ReturnType returnType27 = ReturnTypeProvider.INSTANCE.getTypes().get(Reflection.getOrCreateKotlinClass(Boolean.class));
            if (returnType27 == null) {
                returnType27 = new ReturnType(Reflection.getOrCreateKotlinClass(Boolean.class));
                ReturnTypeProvider.INSTANCE.getTypes().put(Reflection.getOrCreateKotlinClass(Boolean.class), returnType27);
            }
            SyncFunctionComponent syncFunctionComponent9 = new SyncFunctionComponent(str7, anyTypeArr28, returnType27, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.next.FileSystemNextModule$definition$lambda$40$lambda$39$$inlined$Property$1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.valueOf(((FileSystemDirectory) it[0]).getExists());
                }
            });
            syncFunctionComponent9.setOwnerType(propertyComponentBuilderWithThis8.getThisType());
            syncFunctionComponent9.setCanTakeOwner(true);
            propertyComponentBuilderWithThis8.setGetter(syncFunctionComponent9);
            classComponentBuilder16.getProperties().put(str6, propertyComponentBuilderWithThis8);
            ClassComponentBuilder classComponentBuilder19 = classComponentBuilder16;
            AnyType[] anyTypeArr29 = new AnyType[1];
            AnyType anyType30 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemDirectory.class), false));
            if (anyType30 == null) {
                anyType30 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(FileSystemDirectory.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.next.FileSystemNextModule$definition$lambda$40$lambda$39$$inlined$Function$5
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(FileSystemDirectory.class);
                    }
                }));
            }
            anyTypeArr29[0] = anyType30;
            ReturnType returnType28 = ReturnTypeProvider.INSTANCE.getTypes().get(Reflection.getOrCreateKotlinClass(Unit.class));
            if (returnType28 == null) {
                returnType28 = new ReturnType(Reflection.getOrCreateKotlinClass(Unit.class));
                ReturnTypeProvider.INSTANCE.getTypes().put(Reflection.getOrCreateKotlinClass(Unit.class), returnType28);
            }
            classComponentBuilder19.getSyncFunctions().put("validatePath", new SyncFunctionComponent("validatePath", anyTypeArr29, returnType28, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.next.FileSystemNextModule$definition$lambda$40$lambda$39$$inlined$Function$6
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    ((FileSystemDirectory) objArr[0]).validatePath();
                    return Unit.INSTANCE;
                }
            }));
            ClassComponentBuilder classComponentBuilder20 = classComponentBuilder16;
            AnyType[] anyTypeArr30 = new AnyType[2];
            AnyType anyType31 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemDirectory.class), false));
            if (anyType31 == null) {
                anyType31 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(FileSystemDirectory.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.next.FileSystemNextModule$definition$lambda$40$lambda$39$$inlined$Function$7
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(FileSystemDirectory.class);
                    }
                }));
            }
            anyTypeArr30[0] = anyType31;
            AnyType anyType32 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemPath.class), false));
            if (anyType32 == null) {
                anyType32 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(FileSystemPath.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.next.FileSystemNextModule$definition$lambda$40$lambda$39$$inlined$Function$8
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(FileSystemPath.class);
                    }
                }));
            }
            anyTypeArr30[1] = anyType32;
            ReturnType returnType29 = ReturnTypeProvider.INSTANCE.getTypes().get(Reflection.getOrCreateKotlinClass(Unit.class));
            if (returnType29 == null) {
                returnType29 = new ReturnType(Reflection.getOrCreateKotlinClass(Unit.class));
                ReturnTypeProvider.INSTANCE.getTypes().put(Reflection.getOrCreateKotlinClass(Unit.class), returnType29);
            }
            classComponentBuilder20.getSyncFunctions().put("copy", new SyncFunctionComponent("copy", anyTypeArr30, returnType29, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.next.FileSystemNextModule$definition$lambda$40$lambda$39$$inlined$Function$9
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    ((FileSystemDirectory) objArr[0]).copy((FileSystemPath) objArr[1]);
                    return Unit.INSTANCE;
                }
            }));
            ClassComponentBuilder classComponentBuilder21 = classComponentBuilder16;
            AnyType[] anyTypeArr31 = new AnyType[2];
            AnyType anyType33 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemDirectory.class), false));
            if (anyType33 == null) {
                anyType33 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(FileSystemDirectory.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.next.FileSystemNextModule$definition$lambda$40$lambda$39$$inlined$Function$10
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(FileSystemDirectory.class);
                    }
                }));
            }
            anyTypeArr31[0] = anyType33;
            AnyType anyType34 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemPath.class), false));
            if (anyType34 == null) {
                anyType34 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(FileSystemPath.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.next.FileSystemNextModule$definition$lambda$40$lambda$39$$inlined$Function$11
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(FileSystemPath.class);
                    }
                }));
            }
            anyTypeArr31[1] = anyType34;
            ReturnType returnType30 = ReturnTypeProvider.INSTANCE.getTypes().get(Reflection.getOrCreateKotlinClass(Unit.class));
            if (returnType30 == null) {
                returnType30 = new ReturnType(Reflection.getOrCreateKotlinClass(Unit.class));
                ReturnTypeProvider.INSTANCE.getTypes().put(Reflection.getOrCreateKotlinClass(Unit.class), returnType30);
            }
            String str9 = str4;
            classComponentBuilder21.getSyncFunctions().put(str9, new SyncFunctionComponent(str9, anyTypeArr31, returnType30, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.next.FileSystemNextModule$definition$lambda$40$lambda$39$$inlined$Function$12
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    ((FileSystemDirectory) objArr[0]).move((FileSystemPath) objArr[1]);
                    return Unit.INSTANCE;
                }
            }));
            String str10 = str3;
            PropertyComponentBuilderWithThis propertyComponentBuilderWithThis9 = new PropertyComponentBuilderWithThis(classComponentBuilder16.getOwnerType().getKType(), str10);
            AnyType[] anyTypeArr32 = {new AnyType(propertyComponentBuilderWithThis9.getThisType())};
            ReturnType returnType31 = ReturnTypeProvider.INSTANCE.getTypes().get(Reflection.getOrCreateKotlinClass(String.class));
            if (returnType31 == null) {
                returnType31 = new ReturnType(Reflection.getOrCreateKotlinClass(String.class));
                ReturnTypeProvider.INSTANCE.getTypes().put(Reflection.getOrCreateKotlinClass(String.class), returnType31);
            }
            SyncFunctionComponent syncFunctionComponent10 = new SyncFunctionComponent(str7, anyTypeArr32, returnType31, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.next.FileSystemNextModule$definition$lambda$40$lambda$39$$inlined$Property$2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return ((FileSystemDirectory) it[0]).asString();
                }
            });
            syncFunctionComponent10.setOwnerType(propertyComponentBuilderWithThis9.getThisType());
            syncFunctionComponent10.setCanTakeOwner(true);
            propertyComponentBuilderWithThis9.setGetter(syncFunctionComponent10);
            classComponentBuilder16.getProperties().put(str10, propertyComponentBuilderWithThis9);
            ClassComponentBuilder classComponentBuilder22 = classComponentBuilder16;
            AnyType[] anyTypeArr33 = new AnyType[1];
            AnyType anyType35 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemDirectory.class), false));
            if (anyType35 == null) {
                anyType35 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(FileSystemDirectory.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.next.FileSystemNextModule$definition$lambda$40$lambda$39$$inlined$Function$13
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(FileSystemDirectory.class);
                    }
                }));
            }
            anyTypeArr33[0] = anyType35;
            ReturnType returnType32 = ReturnTypeProvider.INSTANCE.getTypes().get(Reflection.getOrCreateKotlinClass(List.class));
            if (returnType32 == null) {
                returnType32 = new ReturnType(Reflection.getOrCreateKotlinClass(List.class));
                ReturnTypeProvider.INSTANCE.getTypes().put(Reflection.getOrCreateKotlinClass(List.class), returnType32);
            }
            classComponentBuilder22.getSyncFunctions().put("listAsRecords", new SyncFunctionComponent("listAsRecords", anyTypeArr33, returnType32, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.next.FileSystemNextModule$definition$lambda$40$lambda$39$$inlined$Function$14
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    return ((FileSystemDirectory) objArr[0]).listAsRecords();
                }
            }));
            moduleDefinitionBuilder.getClassData().add(classComponentBuilder16.buildClass());
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }
}
