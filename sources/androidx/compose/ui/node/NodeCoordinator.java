package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.MutableRectKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LookaheadLayoutCoordinates;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.react.uimanager.ViewProps;
import io.sentry.rrweb.RRWebVideoEvent;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: NodeCoordinator.kt */
@Metadata(d1 = {"\u0000 \u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b&\b \u0018\u0000 ®\u00022\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0004®\u0002¯\u0002B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J$\u0010\u0095\u0001\u001a\u00020\u001e2\u0007\u0010\u0096\u0001\u001a\u00020\u00002\u0007\u0010\u0097\u0001\u001a\u00020\u000b2\u0007\u0010\u0098\u0001\u001a\u00020%H\u0002J2\u0010\u0095\u0001\u001a\u00030\u0099\u00012\u0007\u0010\u0096\u0001\u001a\u00020\u00002\b\u0010\u009a\u0001\u001a\u00030\u0099\u00012\u0007\u0010\u009b\u0001\u001a\u00020%H\u0002ø\u0001\u0000¢\u0006\u0006\b\u009c\u0001\u0010\u009d\u0001J\u001d\u0010\u009e\u0001\u001a\u00020`2\u0006\u0010_\u001a\u00020`H\u0004ø\u0001\u0000¢\u0006\u0006\b\u009f\u0001\u0010 \u0001J'\u0010¡\u0001\u001a\u00020\u00172\b\u0010¢\u0001\u001a\u00030\u0099\u00012\u0006\u0010_\u001a\u00020`H\u0004ø\u0001\u0000¢\u0006\u0006\b£\u0001\u0010¤\u0001J\u001b\u0010¥\u0001\u001a\u00020\u001e2\u0007\u0010¦\u0001\u001a\u00020\u001c2\t\u0010§\u0001\u001a\u0004\u0018\u00010\u001dJ\u001c\u0010¨\u0001\u001a\u00020\u001e2\u0007\u0010¦\u0001\u001a\u00020\u001c2\b\u0010©\u0001\u001a\u00030ª\u0001H\u0004J\u001d\u0010«\u0001\u001a\u00020\u001e2\u0007\u0010¦\u0001\u001a\u00020\u001c2\t\u0010§\u0001\u001a\u0004\u0018\u00010\u001dH\u0002J\t\u0010¬\u0001\u001a\u00020\u001eH&J\u0018\u0010\u00ad\u0001\u001a\u00020\u00002\u0007\u0010®\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0003\b¯\u0001J*\u0010°\u0001\u001a\u00030\u0099\u00012\u0007\u0010q\u001a\u00030\u0099\u00012\t\b\u0002\u0010\u009b\u0001\u001a\u00020%H\u0016ø\u0001\u0000¢\u0006\u0006\b±\u0001\u0010²\u0001J\u001b\u0010³\u0001\u001a\u00020\u001e2\u0007\u0010´\u0001\u001a\u00020\u000b2\u0007\u0010\u0098\u0001\u001a\u00020%H\u0002J#\u0010µ\u0001\u001a\u00020%2\f\u0010¶\u0001\u001a\u0007\u0012\u0002\b\u00030·\u0001H\u0002ø\u0001\u0000¢\u0006\u0006\b¸\u0001\u0010¹\u0001J$\u0010º\u0001\u001a\u0005\u0018\u00010\u0086\u00012\f\u0010¶\u0001\u001a\u0007\u0012\u0002\b\u00030·\u0001ø\u0001\u0000¢\u0006\u0006\b»\u0001\u0010¼\u0001J\u0015\u0010½\u0001\u001a\u0005\u0018\u00010\u0086\u00012\u0007\u0010¾\u0001\u001a\u00020%H\u0002JC\u0010¿\u0001\u001a\u00020\u001e2\b\u0010À\u0001\u001a\u00030Á\u00012\b\u0010¢\u0001\u001a\u00030\u0099\u00012\b\u0010Â\u0001\u001a\u00030Ã\u00012\u0007\u0010Ä\u0001\u001a\u00020%2\u0007\u0010Å\u0001\u001a\u00020%ø\u0001\u0000¢\u0006\u0006\bÆ\u0001\u0010Ç\u0001JE\u0010È\u0001\u001a\u00020\u001e2\b\u0010À\u0001\u001a\u00030Á\u00012\b\u0010¢\u0001\u001a\u00030\u0099\u00012\b\u0010Â\u0001\u001a\u00030Ã\u00012\u0007\u0010Ä\u0001\u001a\u00020%2\u0007\u0010Å\u0001\u001a\u00020%H\u0016ø\u0001\u0000¢\u0006\u0006\bÉ\u0001\u0010Ç\u0001J\t\u0010Ê\u0001\u001a\u00020\u001eH\u0016J\u001f\u0010Ë\u0001\u001a\u00020%2\b\u0010¢\u0001\u001a\u00030\u0099\u0001H\u0004ø\u0001\u0000¢\u0006\u0006\bÌ\u0001\u0010Í\u0001J\u0007\u0010Î\u0001\u001a\u00020%J\u001c\u0010Ï\u0001\u001a\u00030Ð\u00012\u0007\u0010Ñ\u0001\u001a\u00020\u00032\u0007\u0010\u0098\u0001\u001a\u00020%H\u0016J)\u0010Ò\u0001\u001a\u00030\u0099\u00012\u0007\u0010Ñ\u0001\u001a\u00020\u00032\b\u0010Ó\u0001\u001a\u00030\u0099\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\bÔ\u0001\u0010Õ\u0001J2\u0010Ò\u0001\u001a\u00030\u0099\u00012\u0007\u0010Ñ\u0001\u001a\u00020\u00032\b\u0010Ó\u0001\u001a\u00030\u0099\u00012\u0007\u0010\u009b\u0001\u001a\u00020%H\u0016ø\u0001\u0000¢\u0006\u0006\bÖ\u0001\u0010×\u0001J \u0010Ø\u0001\u001a\u00030\u0099\u00012\b\u0010Ù\u0001\u001a\u00030\u0099\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\bÚ\u0001\u0010 \u0001J \u0010Û\u0001\u001a\u00030\u0099\u00012\b\u0010Ù\u0001\u001a\u00030\u0099\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\bÜ\u0001\u0010 \u0001J \u0010Ý\u0001\u001a\u00030\u0099\u00012\b\u0010Ù\u0001\u001a\u00030\u0099\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\bÞ\u0001\u0010 \u0001J \u0010ß\u0001\u001a\u00030\u0099\u00012\b\u0010¢\u0001\u001a\u00030\u0099\u0001H\u0002ø\u0001\u0000¢\u0006\u0006\bà\u0001\u0010 \u0001J\u000f\u0010á\u0001\u001a\u00020\u001eH\u0000¢\u0006\u0003\bâ\u0001J\t\u0010ã\u0001\u001a\u00020\u001eH\u0016J\u0007\u0010ä\u0001\u001a\u00020\u001eJ\u001b\u0010å\u0001\u001a\u00020\u001e2\u0007\u0010æ\u0001\u001a\u00020e2\u0007\u0010ç\u0001\u001a\u00020eH\u0014J\u0007\u0010è\u0001\u001a\u00020\u001eJ\u0007\u0010é\u0001\u001a\u00020\u001eJ\u0007\u0010ê\u0001\u001a\u00020\u001eJ\u001d\u0010ë\u0001\u001a\u00020\u001e2\u0007\u0010¦\u0001\u001a\u00020\u001c2\t\u0010§\u0001\u001a\u0004\u0018\u00010\u001dH\u0016J2\u0010ì\u0001\u001a\u00030í\u00012\u0007\u0010î\u0001\u001a\u00020;2\u0010\b\u0004\u0010ï\u0001\u001a\t\u0012\u0005\u0012\u00030í\u000102H\u0084\bø\u0001\u0000¢\u0006\u0006\bð\u0001\u0010ñ\u0001JA\u0010ò\u0001\u001a\u00020\u001e2\u0006\u0010q\u001a\u00020p2\u0007\u0010\u0091\u0001\u001a\u00020\u00172\u0019\u0010E\u001a\u0015\u0012\u0004\u0012\u00020C\u0012\u0004\u0012\u00020\u001e\u0018\u00010B¢\u0006\u0002\bDH\u0014ø\u0001\u0000¢\u0006\u0006\bó\u0001\u0010ô\u0001J.\u0010ò\u0001\u001a\u00020\u001e2\u0006\u0010q\u001a\u00020p2\u0007\u0010\u0091\u0001\u001a\u00020\u00172\u0006\u0010?\u001a\u00020\u001dH\u0014ø\u0001\u0000¢\u0006\u0006\bó\u0001\u0010õ\u0001JK\u0010ö\u0001\u001a\u00020\u001e2\u0006\u0010q\u001a\u00020p2\u0007\u0010\u0091\u0001\u001a\u00020\u00172\u0019\u0010E\u001a\u0015\u0012\u0004\u0012\u00020C\u0012\u0004\u0012\u00020\u001e\u0018\u00010B¢\u0006\u0002\bD2\b\u0010!\u001a\u0004\u0018\u00010\u001dH\u0002ø\u0001\u0000¢\u0006\u0006\b÷\u0001\u0010ø\u0001JI\u0010ù\u0001\u001a\u00020\u001e2\u0006\u0010q\u001a\u00020p2\u0007\u0010\u0091\u0001\u001a\u00020\u00172\u0019\u0010E\u001a\u0015\u0012\u0004\u0012\u00020C\u0012\u0004\u0012\u00020\u001e\u0018\u00010B¢\u0006\u0002\bD2\b\u0010?\u001a\u0004\u0018\u00010\u001dø\u0001\u0000¢\u0006\u0006\bú\u0001\u0010ø\u0001J,\u0010û\u0001\u001a\u00020\u001e2\u0007\u0010´\u0001\u001a\u00020\u000b2\u0007\u0010\u0098\u0001\u001a\u00020%2\t\b\u0002\u0010ü\u0001\u001a\u00020%H\u0000¢\u0006\u0003\bý\u0001J\u0007\u0010þ\u0001\u001a\u00020\u001eJ\u000f\u0010ÿ\u0001\u001a\u00020\u001eH\u0010¢\u0006\u0003\b\u0080\u0002J \u0010\u0081\u0002\u001a\u00030\u0099\u00012\b\u0010\u0082\u0002\u001a\u00030\u0099\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\b\u0083\u0002\u0010 \u0001J\u0007\u0010\u0084\u0002\u001a\u00020%J*\u0010\u0085\u0002\u001a\u00030\u0099\u00012\u0007\u0010q\u001a\u00030\u0099\u00012\t\b\u0002\u0010\u009b\u0001\u001a\u00020%H\u0016ø\u0001\u0000¢\u0006\u0006\b\u0086\u0002\u0010²\u0001J\b\u0010\u0087\u0002\u001a\u00030Ð\u0001J(\u0010\u0088\u0002\u001a\u00020\u001e2\u0007\u0010Ñ\u0001\u001a\u00020\u00032\b\u0010\u0089\u0002\u001a\u00030\u008a\u0002H\u0016ø\u0001\u0000¢\u0006\u0006\b\u008b\u0002\u0010\u008c\u0002J(\u0010\u008d\u0002\u001a\u00020\u001e2\u0007\u0010\u0096\u0001\u001a\u00020\u00002\b\u0010\u0089\u0002\u001a\u00030\u008a\u0002H\u0002ø\u0001\u0000¢\u0006\u0006\b\u008e\u0002\u0010\u008f\u0002J(\u0010\u0090\u0002\u001a\u00020\u001e2\u0007\u0010\u0096\u0001\u001a\u00020\u00002\b\u0010\u0089\u0002\u001a\u00030\u008a\u0002H\u0002ø\u0001\u0000¢\u0006\u0006\b\u0091\u0002\u0010\u008f\u0002J\u001f\u0010\u0092\u0002\u001a\u00020\u001e2\b\u0010\u0089\u0002\u001a\u00030\u008a\u0002H\u0016ø\u0001\u0000¢\u0006\u0006\b\u0093\u0002\u0010\u0094\u0002J-\u0010\u0095\u0002\u001a\u00020\u001e2\u0019\u0010E\u001a\u0015\u0012\u0004\u0012\u00020C\u0012\u0004\u0012\u00020\u001e\u0018\u00010B¢\u0006\u0002\bD2\t\b\u0002\u0010\u0096\u0002\u001a\u00020%J\u0014\u0010\u0097\u0002\u001a\u00020\u001e2\t\b\u0002\u0010\u0098\u0002\u001a\u00020%H\u0002JF\u0010\u0099\u0002\u001a\u00020\u001e\"\u0007\b\u0000\u0010\u009a\u0002\u0018\u00012\u000f\u0010¶\u0001\u001a\n\u0012\u0005\u0012\u0003H\u009a\u00020·\u00012\u0014\u0010ï\u0001\u001a\u000f\u0012\u0005\u0012\u0003H\u009a\u0002\u0012\u0004\u0012\u00020\u001e0BH\u0086\bø\u0001\u0000¢\u0006\u0006\b\u009b\u0002\u0010\u009c\u0002J2\u0010\u0099\u0002\u001a\u00020\u001e2\u0007\u0010\u009d\u0002\u001a\u00020e2\u0007\u0010¾\u0001\u001a\u00020%2\u0014\u0010ï\u0001\u001a\u000f\u0012\u0005\u0012\u00030\u0086\u0001\u0012\u0004\u0012\u00020\u001e0BH\u0086\bJ \u0010\u009e\u0002\u001a\u00030\u0099\u00012\b\u0010\u009f\u0002\u001a\u00030\u0099\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\b \u0002\u0010 \u0001J(\u0010¡\u0002\u001a\u00020\u001e2\u0007\u0010¦\u0001\u001a\u00020\u001c2\u0013\u0010ï\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001e0BH\u0084\bJ\u001f\u0010¢\u0002\u001a\u00020%2\b\u0010¢\u0001\u001a\u00030\u0099\u0001H\u0004ø\u0001\u0000¢\u0006\u0006\b£\u0002\u0010Í\u0001JL\u0010¤\u0002\u001a\u00020\u001e*\u0005\u0018\u00010\u0086\u00012\b\u0010À\u0001\u001a\u00030Á\u00012\b\u0010¢\u0001\u001a\u00030\u0099\u00012\b\u0010Â\u0001\u001a\u00030Ã\u00012\u0007\u0010Ä\u0001\u001a\u00020%2\u0007\u0010Å\u0001\u001a\u00020%H\u0002ø\u0001\u0000¢\u0006\u0006\b¥\u0002\u0010¦\u0002JU\u0010§\u0002\u001a\u00020\u001e*\u0005\u0018\u00010\u0086\u00012\b\u0010À\u0001\u001a\u00030Á\u00012\b\u0010¢\u0001\u001a\u00030\u0099\u00012\b\u0010Â\u0001\u001a\u00030Ã\u00012\u0007\u0010Ä\u0001\u001a\u00020%2\u0007\u0010Å\u0001\u001a\u00020%2\u0007\u0010¨\u0002\u001a\u00020\u0017H\u0002ø\u0001\u0000¢\u0006\u0006\b©\u0002\u0010ª\u0002JU\u0010«\u0002\u001a\u00020\u001e*\u0005\u0018\u00010\u0086\u00012\b\u0010À\u0001\u001a\u00030Á\u00012\b\u0010¢\u0001\u001a\u00030\u0099\u00012\b\u0010Â\u0001\u001a\u00030Ã\u00012\u0007\u0010Ä\u0001\u001a\u00020%2\u0007\u0010Å\u0001\u001a\u00020%2\u0007\u0010¨\u0002\u001a\u00020\u0017H\u0002ø\u0001\u0000¢\u0006\u0006\b¬\u0002\u0010ª\u0002J\r\u0010\u00ad\u0002\u001a\u00020\u0000*\u00020\u0003H\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R(\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0012\u0004\u0012\u00020\u001e0\u001bX\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001f\u0010 R\u0010\u0010!\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u0019R\u001a\u0010$\u001a\u00020%X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020%X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010'\"\u0004\b,\u0010)R\u0014\u0010-\u001a\u00020%8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010'R\u0014\u0010/\u001a\u00020%8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b0\u0010'R\u0014\u00101\u001a\b\u0012\u0004\u0012\u00020\u001e02X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00103\u001a\u00020%8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b3\u0010'R\u000e\u00104\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00105\u001a\u00020%8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b5\u0010'R\u000e\u00106\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u00108\u001a\u00020%2\u0006\u00107\u001a\u00020%@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b9\u0010'R\u001a\u0010:\u001a\u00020;8@X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b<\u0010=R\"\u0010?\u001a\u0004\u0018\u00010>2\b\u00107\u001a\u0004\u0018\u00010>@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b@\u0010ARD\u0010E\u001a\u0015\u0012\u0004\u0012\u00020C\u0012\u0004\u0012\u00020\u001e\u0018\u00010B¢\u0006\u0002\bD2\u0019\u00107\u001a\u0015\u0012\u0004\u0012\u00020C\u0012\u0004\u0012\u00020\u001e\u0018\u00010B¢\u0006\u0002\bD@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\u000e\u0010H\u001a\u00020IX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020KX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010L\u001a\u0004\u0018\u00010MX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010N\u001a\u00020K8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bO\u0010PR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010RR&\u0010T\u001a\u0004\u0018\u00010S2\b\u00107\u001a\u0004\u0018\u00010S@dX¦\u000e¢\u0006\f\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR$\u0010Z\u001a\u00020\t2\u0006\u0010Y\u001a\u00020\t8P@PX\u0090\u000e¢\u0006\f\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\u0017\u0010_\u001a\u00020`8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\ba\u0010=R\u001c\u0010b\u001a\u0010\u0012\u0004\u0012\u00020d\u0012\u0004\u0012\u00020e\u0018\u00010cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010f\u001a\u0004\u0018\u00010\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bg\u0010\u0012R\u0013\u0010h\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\bi\u0010\u0015R\u0016\u0010j\u001a\u0004\u0018\u00010k8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bl\u0010mR\u0013\u0010n\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\bo\u0010\u0015R,\u0010q\u001a\u00020p2\u0006\u00107\u001a\u00020p@TX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010u\u001a\u0004\br\u0010=\"\u0004\bs\u0010tR\u001a\u0010v\u001a\b\u0012\u0004\u0012\u00020d0w8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bx\u0010yR\u0014\u0010z\u001a\u00020\u000b8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b{\u0010|R\u000e\u0010}\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010~\u001a\u00020\u007f8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0007\u001a\u0005\b\u0080\u0001\u0010=R\u0018\u0010\u0081\u0001\u001a\u00030\u0082\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001R\u0016\u0010\u0085\u0001\u001a\u00030\u0086\u0001X¦\u0004¢\u0006\b\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001R!\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u0000X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001\"\u0006\b\u008c\u0001\u0010\u008d\u0001R!\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u0000X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008f\u0001\u0010\u008b\u0001\"\u0006\b\u0090\u0001\u0010\u008d\u0001R(\u0010\u0091\u0001\u001a\u00020\u00172\u0006\u00107\u001a\u00020\u0017@DX\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b\u0092\u0001\u0010\u0019\"\u0006\b\u0093\u0001\u0010\u0094\u0001\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006°\u0002"}, d2 = {"Landroidx/compose/ui/node/NodeCoordinator;", "Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/ui/node/OwnerScope;", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "(Landroidx/compose/ui/node/LayoutNode;)V", "_measureResult", "Landroidx/compose/ui/layout/MeasureResult;", "_rectCache", "Landroidx/compose/ui/geometry/MutableRect;", "alignmentLinesOwner", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "getAlignmentLinesOwner", "()Landroidx/compose/ui/node/AlignmentLinesOwner;", "child", "getChild", "()Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "coordinates", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "density", "", "getDensity", "()F", "drawBlock", "Lkotlin/Function2;", "Landroidx/compose/ui/graphics/Canvas;", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "", "getDrawBlock$annotations", "()V", "explicitLayer", "fontScale", "getFontScale", "forceMeasureWithLookaheadConstraints", "", "getForceMeasureWithLookaheadConstraints$ui_release", "()Z", "setForceMeasureWithLookaheadConstraints$ui_release", "(Z)V", "forcePlaceWithLookaheadOffset", "getForcePlaceWithLookaheadOffset$ui_release", "setForcePlaceWithLookaheadOffset$ui_release", "hasMeasureResult", "getHasMeasureResult", "introducesMotionFrameOfReference", "getIntroducesMotionFrameOfReference", "invalidateParentLayer", "Lkotlin/Function0;", "isAttached", "isClipping", "isValidOwnerScope", "lastLayerAlpha", "<set-?>", "lastLayerDrawingWasSkipped", "getLastLayerDrawingWasSkipped$ui_release", "lastMeasurementConstraints", "Landroidx/compose/ui/unit/Constraints;", "getLastMeasurementConstraints-msEJaDk$ui_release", "()J", "Landroidx/compose/ui/node/OwnedLayer;", "layer", "getLayer", "()Landroidx/compose/ui/node/OwnedLayer;", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "layerBlock", "getLayerBlock", "()Lkotlin/jvm/functions/Function1;", "layerDensity", "Landroidx/compose/ui/unit/Density;", "layerLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "layerPositionalProperties", "Landroidx/compose/ui/node/LayerPositionalProperties;", ViewProps.LAYOUT_DIRECTION, "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "Landroidx/compose/ui/node/LookaheadDelegate;", "lookaheadDelegate", "getLookaheadDelegate", "()Landroidx/compose/ui/node/LookaheadDelegate;", "setLookaheadDelegate", "(Landroidx/compose/ui/node/LookaheadDelegate;)V", "value", "measureResult", "getMeasureResult$ui_release", "()Landroidx/compose/ui/layout/MeasureResult;", "setMeasureResult$ui_release", "(Landroidx/compose/ui/layout/MeasureResult;)V", "minimumTouchTargetSize", "Landroidx/compose/ui/geometry/Size;", "getMinimumTouchTargetSize-NH-jbRc", "oldAlignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "", "parent", "getParent", "parentCoordinates", "getParentCoordinates", "parentData", "", "getParentData", "()Ljava/lang/Object;", "parentLayoutCoordinates", "getParentLayoutCoordinates", "Landroidx/compose/ui/unit/IntOffset;", ViewProps.POSITION, "getPosition-nOcc-ac", "setPosition--gyyYBs", "(J)V", "J", "providedAlignmentLines", "", "getProvidedAlignmentLines", "()Ljava/util/Set;", "rectCache", "getRectCache", "()Landroidx/compose/ui/geometry/MutableRect;", "released", RRWebVideoEvent.JsonKeys.SIZE, "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "snapshotObserver", "Landroidx/compose/ui/node/OwnerSnapshotObserver;", "getSnapshotObserver", "()Landroidx/compose/ui/node/OwnerSnapshotObserver;", "tail", "Landroidx/compose/ui/Modifier$Node;", "getTail", "()Landroidx/compose/ui/Modifier$Node;", "wrapped", "getWrapped$ui_release", "()Landroidx/compose/ui/node/NodeCoordinator;", "setWrapped$ui_release", "(Landroidx/compose/ui/node/NodeCoordinator;)V", "wrappedBy", "getWrappedBy$ui_release", "setWrappedBy$ui_release", ViewProps.Z_INDEX, "getZIndex", "setZIndex", "(F)V", "ancestorToLocal", "ancestor", "rect", "clipBounds", "Landroidx/compose/ui/geometry/Offset;", "offset", "includeMotionFrameOfReference", "ancestorToLocal-S_NoaFU", "(Landroidx/compose/ui/node/NodeCoordinator;JZ)J", "calculateMinimumTouchTargetPadding", "calculateMinimumTouchTargetPadding-E7KxVPU", "(J)J", "distanceInMinimumTouchTarget", "pointerPosition", "distanceInMinimumTouchTarget-tz77jQw", "(JJ)F", "draw", "canvas", "graphicsLayer", "drawBorder", "paint", "Landroidx/compose/ui/graphics/Paint;", "drawContainedDrawModifiers", "ensureLookaheadDelegateCreated", "findCommonAncestor", "other", "findCommonAncestor$ui_release", "fromParentPosition", "fromParentPosition-8S9VItk", "(JZ)J", "fromParentRect", "bounds", "hasNode", "type", "Landroidx/compose/ui/node/NodeKind;", "hasNode-H91voCI", "(I)Z", "head", "head-H91voCI", "(I)Landroidx/compose/ui/Modifier$Node;", "headNode", "includeTail", "hitTest", "hitTestSource", "Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "hitTestResult", "Landroidx/compose/ui/node/HitTestResult;", "isTouchEvent", "isInLayer", "hitTest-YqVAtuI", "(Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;JLandroidx/compose/ui/node/HitTestResult;ZZ)V", "hitTestChild", "hitTestChild-YqVAtuI", "invalidateLayer", "isPointerInBounds", "isPointerInBounds-k-4lQ0M", "(J)Z", "isTransparent", "localBoundingBoxOf", "Landroidx/compose/ui/geometry/Rect;", "sourceCoordinates", "localPositionOf", "relativeToSource", "localPositionOf-R5De75A", "(Landroidx/compose/ui/layout/LayoutCoordinates;J)J", "localPositionOf-S_NoaFU", "(Landroidx/compose/ui/layout/LayoutCoordinates;JZ)J", "localToRoot", "relativeToLocal", "localToRoot-MK-Hz9U", "localToScreen", "localToScreen-MK-Hz9U", "localToWindow", "localToWindow-MK-Hz9U", "offsetFromEdge", "offsetFromEdge-MK-Hz9U", "onCoordinatesUsed", "onCoordinatesUsed$ui_release", "onLayoutModifierNodeChanged", "onLayoutNodeAttach", "onMeasureResultChanged", "width", "height", "onMeasured", "onPlaced", "onRelease", "performDraw", "performingMeasure", "Landroidx/compose/ui/layout/Placeable;", "constraints", "block", "performingMeasure-K40F9xA", "(JLkotlin/jvm/functions/Function0;)Landroidx/compose/ui/layout/Placeable;", "placeAt", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "(JFLandroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "placeSelf", "placeSelf-MLgxB_4", "(JFLkotlin/jvm/functions/Function1;Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "placeSelfApparentToRealOffset", "placeSelfApparentToRealOffset-MLgxB_4", "rectInParent", "clipToMinimumTouchTargetSize", "rectInParent$ui_release", "releaseLayer", "replace", "replace$ui_release", "screenToLocal", "relativeToScreen", "screenToLocal-MK-Hz9U", "shouldSharePointerInputWithSiblings", "toParentPosition", "toParentPosition-8S9VItk", "touchBoundsInRoot", "transformFrom", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "transformFrom-EL8BTi8", "(Landroidx/compose/ui/layout/LayoutCoordinates;[F)V", "transformFromAncestor", "transformFromAncestor-EL8BTi8", "(Landroidx/compose/ui/node/NodeCoordinator;[F)V", "transformToAncestor", "transformToAncestor-EL8BTi8", "transformToScreen", "transformToScreen-58bKbWc", "([F)V", "updateLayerBlock", "forceUpdateLayerParameters", "updateLayerParameters", "invokeOnLayoutChange", "visitNodes", ExifInterface.GPS_DIRECTION_TRUE, "visitNodes-aLcG6gQ", "(ILkotlin/jvm/functions/Function1;)V", "mask", "windowToLocal", "relativeToWindow", "windowToLocal-MK-Hz9U", "withPositionTranslation", "withinLayerBounds", "withinLayerBounds-k-4lQ0M", "hit", "hit-1hIXUjU", "(Landroidx/compose/ui/Modifier$Node;Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;JLandroidx/compose/ui/node/HitTestResult;ZZ)V", "hitNear", "distanceFromEdge", "hitNear-JHbHoSQ", "(Landroidx/compose/ui/Modifier$Node;Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;JLandroidx/compose/ui/node/HitTestResult;ZZF)V", "speculativeHit", "speculativeHit-JHbHoSQ", "toCoordinator", "Companion", "HitTestSource", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class NodeCoordinator extends LookaheadCapablePlaceable implements Measurable, LayoutCoordinates, OwnerScope {
    public static final int $stable = 0;
    public static final String ExpectAttachedLayoutCoordinates = "LayoutCoordinate operations are only valid when isAttached is true";
    public static final String UnmeasuredError = "Asking for measurement result of unmeasured layout modifier";
    private MeasureResult _measureResult;
    private MutableRect _rectCache;
    private GraphicsLayer explicitLayer;
    private boolean forceMeasureWithLookaheadConstraints;
    private boolean forcePlaceWithLookaheadOffset;
    private boolean isClipping;
    private boolean lastLayerDrawingWasSkipped;
    private OwnedLayer layer;
    private Function1<? super GraphicsLayerScope, Unit> layerBlock;
    private LayerPositionalProperties layerPositionalProperties;
    private final LayoutNode layoutNode;
    private Map<AlignmentLine, Integer> oldAlignmentLines;
    private boolean released;
    private NodeCoordinator wrapped;
    private NodeCoordinator wrappedBy;
    private float zIndex;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Function1<NodeCoordinator, Unit> onCommitAffectingLayerParams = new Function1<NodeCoordinator, Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$Companion$onCommitAffectingLayerParams$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(NodeCoordinator nodeCoordinator) {
            invoke2(nodeCoordinator);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(NodeCoordinator nodeCoordinator) {
            if (nodeCoordinator.isValidOwnerScope()) {
                LayerPositionalProperties layerPositionalProperties = nodeCoordinator.layerPositionalProperties;
                if (layerPositionalProperties != null) {
                    NodeCoordinator.tmpLayerPositionalProperties.copyFrom(layerPositionalProperties);
                    NodeCoordinator.updateLayerParameters$default(nodeCoordinator, false, 1, null);
                    if (NodeCoordinator.tmpLayerPositionalProperties.hasSameValuesAs(layerPositionalProperties)) {
                        return;
                    }
                    LayoutNode layoutNode = nodeCoordinator.getLayoutNode();
                    LayoutNodeLayoutDelegate layoutDelegate = layoutNode.getLayoutDelegate();
                    if (layoutDelegate.getChildrenAccessingCoordinatesDuringPlacement() > 0) {
                        if (layoutDelegate.getCoordinatesAccessedDuringModifierPlacement() || layoutDelegate.getCoordinatesAccessedDuringPlacement()) {
                            LayoutNode.requestRelayout$ui_release$default(layoutNode, false, 1, null);
                        }
                        layoutDelegate.getMeasurePassDelegate().notifyChildrenUsingCoordinatesWhilePlacing();
                    }
                    Owner owner = layoutNode.getOwner();
                    if (owner != null) {
                        owner.requestOnPositionedCallback(layoutNode);
                        return;
                    }
                    return;
                }
                NodeCoordinator.updateLayerParameters$default(nodeCoordinator, false, 1, null);
            }
        }
    };
    private static final Function1<NodeCoordinator, Unit> onCommitAffectingLayer = new Function1<NodeCoordinator, Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$Companion$onCommitAffectingLayer$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(NodeCoordinator nodeCoordinator) {
            invoke2(nodeCoordinator);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(NodeCoordinator nodeCoordinator) {
            OwnedLayer layer = nodeCoordinator.getLayer();
            if (layer != null) {
                layer.invalidate();
            }
        }
    };
    private static final ReusableGraphicsLayerScope graphicsLayerScope = new ReusableGraphicsLayerScope();
    private static final LayerPositionalProperties tmpLayerPositionalProperties = new LayerPositionalProperties();
    private static final float[] tmpMatrix = Matrix.m2508constructorimpl$default(null, 1, null);
    private static final HitTestSource PointerInputSource = new HitTestSource() { // from class: androidx.compose.ui.node.NodeCoordinator$Companion$PointerInputSource$1
        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        public boolean shouldHitTestChildren(LayoutNode parentLayoutNode) {
            return true;
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        /* renamed from: childHitTest-YqVAtuI, reason: not valid java name */
        public void mo3843childHitTestYqVAtuI(LayoutNode layoutNode, long pointerPosition, HitTestResult hitTestResult, boolean isTouchEvent, boolean isInLayer) {
            layoutNode.m3765hitTestM_7yMNQ$ui_release(pointerPosition, hitTestResult, isTouchEvent, isInLayer);
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        /* renamed from: entityType-OLwlOKw, reason: not valid java name */
        public int mo3844entityTypeOLwlOKw() {
            return NodeKind.m3848constructorimpl(16);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v0, types: [androidx.compose.ui.Modifier$Node] */
        /* JADX WARN: Type inference failed for: r10v1, types: [androidx.compose.ui.Modifier$Node] */
        /* JADX WARN: Type inference failed for: r10v10 */
        /* JADX WARN: Type inference failed for: r10v11 */
        /* JADX WARN: Type inference failed for: r10v12 */
        /* JADX WARN: Type inference failed for: r10v4 */
        /* JADX WARN: Type inference failed for: r10v5, types: [androidx.compose.ui.Modifier$Node] */
        /* JADX WARN: Type inference failed for: r10v6, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r10v7 */
        /* JADX WARN: Type inference failed for: r10v8 */
        /* JADX WARN: Type inference failed for: r10v9 */
        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        public boolean interceptOutOfBoundsChildEvents(Modifier.Node node) {
            int iM3848constructorimpl = NodeKind.m3848constructorimpl(16);
            MutableVector mutableVector = null;
            while (node != 0) {
                if (node instanceof PointerInputModifierNode) {
                    if (((PointerInputModifierNode) node).interceptOutOfBoundsChildEvents()) {
                        return true;
                    }
                } else if ((node.getKindSet() & iM3848constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                    Modifier.Node delegate = node.getDelegate();
                    int i = 0;
                    node = node;
                    while (delegate != null) {
                        if ((delegate.getKindSet() & iM3848constructorimpl) != 0) {
                            i++;
                            if (i == 1) {
                                node = delegate;
                            } else {
                                if (mutableVector == null) {
                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (node != 0) {
                                    if (mutableVector != null) {
                                        mutableVector.add(node);
                                    }
                                    node = 0;
                                }
                                if (mutableVector != null) {
                                    mutableVector.add(delegate);
                                }
                            }
                        }
                        delegate = delegate.getChild();
                        node = node;
                    }
                    if (i == 1) {
                    }
                }
                node = DelegatableNodeKt.pop(mutableVector);
            }
            return false;
        }
    };
    private static final HitTestSource SemanticsSource = new HitTestSource() { // from class: androidx.compose.ui.node.NodeCoordinator$Companion$SemanticsSource$1
        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        public boolean interceptOutOfBoundsChildEvents(Modifier.Node node) {
            return false;
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        public boolean shouldHitTestChildren(LayoutNode parentLayoutNode) {
            SemanticsConfiguration collapsedSemantics$ui_release = parentLayoutNode.getCollapsedSemantics$ui_release();
            boolean z = false;
            if (collapsedSemantics$ui_release != null && collapsedSemantics$ui_release.getIsClearingSemantics()) {
                z = true;
            }
            return !z;
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        /* renamed from: childHitTest-YqVAtuI */
        public void mo3843childHitTestYqVAtuI(LayoutNode layoutNode, long pointerPosition, HitTestResult hitTestResult, boolean isTouchEvent, boolean isInLayer) {
            layoutNode.m3766hitTestSemanticsM_7yMNQ$ui_release(pointerPosition, hitTestResult, isTouchEvent, isInLayer);
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        /* renamed from: entityType-OLwlOKw */
        public int mo3844entityTypeOLwlOKw() {
            return NodeKind.m3848constructorimpl(8);
        }
    };
    private Density layerDensity = getLayoutNode().getDensity();
    private LayoutDirection layerLayoutDirection = getLayoutNode().getLayoutDirection();
    private float lastLayerAlpha = 0.8f;
    private long position = IntOffset.INSTANCE.m4875getZeronOccac();
    private final Function2<Canvas, GraphicsLayer, Unit> drawBlock = new Function2<Canvas, GraphicsLayer, Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$drawBlock$1
        {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Canvas canvas, GraphicsLayer graphicsLayer) {
            invoke2(canvas, graphicsLayer);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(final Canvas canvas, final GraphicsLayer graphicsLayer) {
            if (this.this$0.getLayoutNode().isPlaced()) {
                OwnerSnapshotObserver snapshotObserver = this.this$0.getSnapshotObserver();
                NodeCoordinator nodeCoordinator = this.this$0;
                Function1 function1 = NodeCoordinator.onCommitAffectingLayer;
                final NodeCoordinator nodeCoordinator2 = this.this$0;
                snapshotObserver.observeReads$ui_release(nodeCoordinator, function1, new Function0<Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$drawBlock$1.1
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
                        nodeCoordinator2.drawContainedDrawModifiers(canvas, graphicsLayer);
                    }
                });
                this.this$0.lastLayerDrawingWasSkipped = false;
                return;
            }
            this.this$0.lastLayerDrawingWasSkipped = true;
        }
    };
    private final Function0<Unit> invalidateParentLayer = new Function0<Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$invalidateParentLayer$1
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
            NodeCoordinator wrappedBy = this.this$0.getWrappedBy();
            if (wrappedBy != null) {
                wrappedBy.invalidateLayer();
            }
        }
    };

    /* compiled from: NodeCoordinator.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J:\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH&ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0010H&ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0010\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0005H&ø\u0001\u0002\u0082\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006\u0018À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "", "childHitTest", "", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "hitTestResult", "Landroidx/compose/ui/node/HitTestResult;", "isTouchEvent", "", "isInLayer", "childHitTest-YqVAtuI", "(Landroidx/compose/ui/node/LayoutNode;JLandroidx/compose/ui/node/HitTestResult;ZZ)V", "entityType", "Landroidx/compose/ui/node/NodeKind;", "entityType-OLwlOKw", "()I", "interceptOutOfBoundsChildEvents", "node", "Landroidx/compose/ui/Modifier$Node;", "shouldHitTestChildren", "parentLayoutNode", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface HitTestSource {
        /* renamed from: childHitTest-YqVAtuI */
        void mo3843childHitTestYqVAtuI(LayoutNode layoutNode, long pointerPosition, HitTestResult hitTestResult, boolean isTouchEvent, boolean isInLayer);

        /* renamed from: entityType-OLwlOKw */
        int mo3844entityTypeOLwlOKw();

        boolean interceptOutOfBoundsChildEvents(Modifier.Node node);

        boolean shouldHitTestChildren(LayoutNode parentLayoutNode);
    }

    private static /* synthetic */ void getDrawBlock$annotations() {
    }

    public abstract void ensureLookaheadDelegateCreated();

    public abstract LookaheadDelegate getLookaheadDelegate();

    public abstract Modifier.Node getTail();

    protected abstract void setLookaheadDelegate(LookaheadDelegate lookaheadDelegate);

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable, androidx.compose.ui.node.MeasureScopeWithLayoutNode
    public LayoutNode getLayoutNode() {
        return this.layoutNode;
    }

    public NodeCoordinator(LayoutNode layoutNode) {
        this.layoutNode = layoutNode;
    }

    /* renamed from: getForcePlaceWithLookaheadOffset$ui_release, reason: from getter */
    public final boolean getForcePlaceWithLookaheadOffset() {
        return this.forcePlaceWithLookaheadOffset;
    }

    public final void setForcePlaceWithLookaheadOffset$ui_release(boolean z) {
        this.forcePlaceWithLookaheadOffset = z;
    }

    /* renamed from: getForceMeasureWithLookaheadConstraints$ui_release, reason: from getter */
    public final boolean getForceMeasureWithLookaheadConstraints() {
        return this.forceMeasureWithLookaheadConstraints;
    }

    public final void setForceMeasureWithLookaheadConstraints$ui_release(boolean z) {
        this.forceMeasureWithLookaheadConstraints = z;
    }

    /* renamed from: getWrapped$ui_release, reason: from getter */
    public final NodeCoordinator getWrapped() {
        return this.wrapped;
    }

    public final void setWrapped$ui_release(NodeCoordinator nodeCoordinator) {
        this.wrapped = nodeCoordinator;
    }

    /* renamed from: getWrappedBy$ui_release, reason: from getter */
    public final NodeCoordinator getWrappedBy() {
        return this.wrappedBy;
    }

    public final void setWrappedBy$ui_release(NodeCoordinator nodeCoordinator) {
        this.wrappedBy = nodeCoordinator;
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
    public LayoutDirection getLayoutDirection() {
        return getLayoutNode().getLayoutDirection();
    }

    @Override // androidx.compose.ui.unit.Density
    public float getDensity() {
        return getLayoutNode().getDensity().getDensity();
    }

    @Override // androidx.compose.ui.unit.FontScaling
    public float getFontScale() {
        return getLayoutNode().getDensity().getFontScale();
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public LookaheadCapablePlaceable getParent() {
        return this.wrappedBy;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public LayoutCoordinates getCoordinates() {
        return this;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public boolean getIntroducesMotionFrameOfReference() {
        return getIsPlacedUnderMotionFrameOfReference();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Modifier.Node headNode(boolean includeTail) {
        Modifier.Node tail;
        if (getLayoutNode().getOuterCoordinator$ui_release() == this) {
            return getLayoutNode().getNodes().getHead();
        }
        if (includeTail) {
            NodeCoordinator nodeCoordinator = this.wrappedBy;
            if (nodeCoordinator != null && (tail = nodeCoordinator.getTail()) != null) {
                return tail.getChild();
            }
        } else {
            NodeCoordinator nodeCoordinator2 = this.wrappedBy;
            if (nodeCoordinator2 != null) {
                return nodeCoordinator2.getTail();
            }
        }
        return null;
    }

    public final void visitNodes(int mask, boolean includeTail, Function1<? super Modifier.Node, Unit> block) {
        Modifier.Node tail = getTail();
        if (!includeTail && (tail = tail.getParent()) == null) {
            return;
        }
        for (Modifier.Node nodeHeadNode = headNode(includeTail); nodeHeadNode != null && (nodeHeadNode.getAggregateChildKindSet() & mask) != 0; nodeHeadNode = nodeHeadNode.getChild()) {
            if ((nodeHeadNode.getKindSet() & mask) != 0) {
                block.invoke(nodeHeadNode);
            }
            if (nodeHeadNode == tail) {
                return;
            }
        }
    }

    /* renamed from: visitNodes-aLcG6gQ, reason: not valid java name */
    public final /* synthetic */ <T> void m3841visitNodesaLcG6gQ(int type, Function1<? super T, Unit> block) {
        boolean zM3857getIncludeSelfInTraversalH91voCI = NodeKindKt.m3857getIncludeSelfInTraversalH91voCI(type);
        Modifier.Node tail = getTail();
        if (!zM3857getIncludeSelfInTraversalH91voCI && (tail = tail.getParent()) == null) {
            return;
        }
        for (Modifier.Node nodeHeadNode = headNode(zM3857getIncludeSelfInTraversalH91voCI); nodeHeadNode != null && (nodeHeadNode.getAggregateChildKindSet() & type) != 0; nodeHeadNode = nodeHeadNode.getChild()) {
            if ((nodeHeadNode.getKindSet() & type) != 0) {
                Modifier.Node nodePop = nodeHeadNode;
                MutableVector mutableVector = null;
                while (nodePop != null) {
                    Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                    if (nodePop instanceof Object) {
                        block.invoke(nodePop);
                    } else if ((nodePop.getKindSet() & type) != 0 && (nodePop instanceof DelegatingNode)) {
                        int i = 0;
                        for (Modifier.Node delegate$ui_release = ((DelegatingNode) nodePop).getDelegate(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild()) {
                            if ((delegate$ui_release.getKindSet() & type) != 0) {
                                i++;
                                if (i == 1) {
                                    nodePop = delegate$ui_release;
                                } else {
                                    if (mutableVector == null) {
                                        mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                    }
                                    if (nodePop != null) {
                                        if (mutableVector != null) {
                                            mutableVector.add(nodePop);
                                        }
                                        nodePop = null;
                                    }
                                    if (mutableVector != null) {
                                        mutableVector.add(delegate$ui_release);
                                    }
                                }
                            }
                        }
                        if (i == 1) {
                        }
                    }
                    nodePop = DelegatableNodeKt.pop(mutableVector);
                }
            }
            if (nodeHeadNode == tail) {
                return;
            }
        }
    }

    /* renamed from: hasNode-H91voCI, reason: not valid java name */
    private final boolean m3820hasNodeH91voCI(int type) {
        Modifier.Node nodeHeadNode = headNode(NodeKindKt.m3857getIncludeSelfInTraversalH91voCI(type));
        return nodeHeadNode != null && DelegatableNodeKt.m3733has64DMado(nodeHeadNode, type);
    }

    /* renamed from: head-H91voCI, reason: not valid java name */
    public final Modifier.Node m3834headH91voCI(int type) {
        boolean zM3857getIncludeSelfInTraversalH91voCI = NodeKindKt.m3857getIncludeSelfInTraversalH91voCI(type);
        Modifier.Node tail = getTail();
        if (!zM3857getIncludeSelfInTraversalH91voCI && (tail = tail.getParent()) == null) {
            return null;
        }
        for (Modifier.Node nodeHeadNode = headNode(zM3857getIncludeSelfInTraversalH91voCI); nodeHeadNode != null && (nodeHeadNode.getAggregateChildKindSet() & type) != 0; nodeHeadNode = nodeHeadNode.getChild()) {
            if ((nodeHeadNode.getKindSet() & type) != 0) {
                return nodeHeadNode;
            }
            if (nodeHeadNode == tail) {
                return null;
            }
        }
        return null;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: getSize-YbymL2g */
    public final long mo3621getSizeYbymL2g() {
        return getMeasuredSize();
    }

    protected final Function1<GraphicsLayerScope, Unit> getLayerBlock() {
        return this.layerBlock;
    }

    public final boolean isTransparent() {
        if (this.layer != null && this.lastLayerAlpha <= 0.0f) {
            return true;
        }
        NodeCoordinator nodeCoordinator = this.wrappedBy;
        if (nodeCoordinator != null) {
            return nodeCoordinator.isTransparent();
        }
        return false;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public AlignmentLinesOwner getAlignmentLinesOwner() {
        return getLayoutNode().getLayoutDelegate().getAlignmentLinesOwner$ui_release();
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public LookaheadCapablePlaceable getChild() {
        return this.wrapped;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public void replace$ui_release() {
        GraphicsLayer graphicsLayer = this.explicitLayer;
        if (graphicsLayer != null) {
            mo3674placeAtf8xVGno(getPosition(), this.zIndex, graphicsLayer);
        } else {
            mo3614placeAtf8xVGno(getPosition(), this.zIndex, this.layerBlock);
        }
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public boolean getHasMeasureResult() {
        return this._measureResult != null;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public boolean isAttached() {
        return getTail().getIsAttached();
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public MeasureResult getMeasureResult$ui_release() {
        MeasureResult measureResult = this._measureResult;
        if (measureResult != null) {
            return measureResult;
        }
        throw new IllegalStateException(UnmeasuredError.toString());
    }

    public void setMeasureResult$ui_release(MeasureResult measureResult) {
        MeasureResult measureResult2 = this._measureResult;
        if (measureResult != measureResult2) {
            this._measureResult = measureResult;
            if (measureResult2 == null || measureResult.get$w() != measureResult2.get$w() || measureResult.get$h() != measureResult2.get$h()) {
                onMeasureResultChanged(measureResult.get$w(), measureResult.get$h());
            }
            Map<AlignmentLine, Integer> map = this.oldAlignmentLines;
            if (((map == null || map.isEmpty()) && measureResult.getAlignmentLines().isEmpty()) || Intrinsics.areEqual(measureResult.getAlignmentLines(), this.oldAlignmentLines)) {
                return;
            }
            getAlignmentLinesOwner().getAlignmentLines().onAlignmentsChanged();
            LinkedHashMap linkedHashMap = this.oldAlignmentLines;
            if (linkedHashMap == null) {
                linkedHashMap = new LinkedHashMap();
                this.oldAlignmentLines = linkedHashMap;
            }
            linkedHashMap.clear();
            linkedHashMap.putAll(measureResult.getAlignmentLines());
        }
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public Set<AlignmentLine> getProvidedAlignmentLines() {
        LinkedHashSet linkedHashSet = null;
        for (NodeCoordinator nodeCoordinator = this; nodeCoordinator != null; nodeCoordinator = nodeCoordinator.wrapped) {
            MeasureResult measureResult = nodeCoordinator._measureResult;
            Map<AlignmentLine, Integer> alignmentLines = measureResult != null ? measureResult.getAlignmentLines() : null;
            if (alignmentLines != null && (!alignmentLines.isEmpty())) {
                if (linkedHashSet == null) {
                    linkedHashSet = new LinkedHashSet();
                }
                linkedHashSet.addAll(alignmentLines.keySet());
            }
        }
        return linkedHashSet == null ? SetsKt.emptySet() : linkedHashSet;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    protected void onMeasureResultChanged(int width, int height) {
        NodeCoordinator nodeCoordinator;
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.mo3899resizeozmzZPI(IntSizeKt.IntSize(width, height));
        } else if (getLayoutNode().isPlaced() && (nodeCoordinator = this.wrappedBy) != null) {
            nodeCoordinator.invalidateLayer();
        }
        m3675setMeasuredSizeozmzZPI(IntSizeKt.IntSize(width, height));
        if (this.layerBlock != null) {
            updateLayerParameters(false);
        }
        int iM3848constructorimpl = NodeKind.m3848constructorimpl(4);
        boolean zM3857getIncludeSelfInTraversalH91voCI = NodeKindKt.m3857getIncludeSelfInTraversalH91voCI(iM3848constructorimpl);
        Modifier.Node tail = getTail();
        if (zM3857getIncludeSelfInTraversalH91voCI || (tail = tail.getParent()) != null) {
            for (Modifier.Node nodeHeadNode = headNode(zM3857getIncludeSelfInTraversalH91voCI); nodeHeadNode != null && (nodeHeadNode.getAggregateChildKindSet() & iM3848constructorimpl) != 0; nodeHeadNode = nodeHeadNode.getChild()) {
                if ((nodeHeadNode.getKindSet() & iM3848constructorimpl) != 0) {
                    DelegatingNode delegatingNodePop = nodeHeadNode;
                    MutableVector mutableVector = null;
                    while (delegatingNodePop != 0) {
                        if (delegatingNodePop instanceof DrawModifierNode) {
                            ((DrawModifierNode) delegatingNodePop).onMeasureResultChanged();
                        } else if ((delegatingNodePop.getKindSet() & iM3848constructorimpl) != 0 && (delegatingNodePop instanceof DelegatingNode)) {
                            Modifier.Node delegate$ui_release = delegatingNodePop.getDelegate();
                            int i = 0;
                            delegatingNodePop = delegatingNodePop;
                            while (delegate$ui_release != null) {
                                if ((delegate$ui_release.getKindSet() & iM3848constructorimpl) != 0) {
                                    i++;
                                    if (i == 1) {
                                        delegatingNodePop = delegate$ui_release;
                                    } else {
                                        if (mutableVector == null) {
                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                        }
                                        if (delegatingNodePop != 0) {
                                            if (mutableVector != null) {
                                                mutableVector.add(delegatingNodePop);
                                            }
                                            delegatingNodePop = 0;
                                        }
                                        if (mutableVector != null) {
                                            mutableVector.add(delegate$ui_release);
                                        }
                                    }
                                }
                                delegate$ui_release = delegate$ui_release.getChild();
                                delegatingNodePop = delegatingNodePop;
                            }
                            if (i == 1) {
                            }
                        }
                        delegatingNodePop = DelegatableNodeKt.pop(mutableVector);
                    }
                }
                if (nodeHeadNode == tail) {
                    break;
                }
            }
        }
        Owner owner = getLayoutNode().getOwner();
        if (owner != null) {
            owner.onLayoutChange(getLayoutNode());
        }
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    /* renamed from: getPosition-nOcc-ac, reason: from getter */
    public long getPosition() {
        return this.position;
    }

    /* renamed from: setPosition--gyyYBs, reason: not valid java name */
    protected void m3839setPositiongyyYBs(long j) {
        this.position = j;
    }

    public final float getZIndex() {
        return this.zIndex;
    }

    protected final void setZIndex(float f) {
        this.zIndex = f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v2, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v4, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    @Override // androidx.compose.ui.layout.Measured, androidx.compose.ui.layout.IntrinsicMeasurable
    public Object getParentData() {
        if (!getLayoutNode().getNodes().m3809hasH91voCI$ui_release(NodeKind.m3848constructorimpl(64))) {
            return null;
        }
        getTail();
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        for (Modifier.Node tail = getLayoutNode().getNodes().getTail(); tail != null; tail = tail.getParent()) {
            if ((NodeKind.m3848constructorimpl(64) & tail.getKindSet()) != 0) {
                int iM3848constructorimpl = NodeKind.m3848constructorimpl(64);
                MutableVector mutableVector = null;
                DelegatingNode delegatingNodePop = tail;
                while (delegatingNodePop != 0) {
                    if (delegatingNodePop instanceof ParentDataModifierNode) {
                        objectRef.element = ((ParentDataModifierNode) delegatingNodePop).modifyParentData(getLayoutNode().getDensity(), objectRef.element);
                    } else if ((delegatingNodePop.getKindSet() & iM3848constructorimpl) != 0 && (delegatingNodePop instanceof DelegatingNode)) {
                        Modifier.Node delegate$ui_release = delegatingNodePop.getDelegate();
                        int i = 0;
                        delegatingNodePop = delegatingNodePop;
                        while (delegate$ui_release != null) {
                            if ((delegate$ui_release.getKindSet() & iM3848constructorimpl) != 0) {
                                i++;
                                if (i == 1) {
                                    delegatingNodePop = delegate$ui_release;
                                } else {
                                    if (mutableVector == null) {
                                        mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                    }
                                    if (delegatingNodePop != 0) {
                                        if (mutableVector != null) {
                                            mutableVector.add(delegatingNodePop);
                                        }
                                        delegatingNodePop = 0;
                                    }
                                    if (mutableVector != null) {
                                        mutableVector.add(delegate$ui_release);
                                    }
                                }
                            }
                            delegate$ui_release = delegate$ui_release.getChild();
                            delegatingNodePop = delegatingNodePop;
                        }
                        if (i == 1) {
                        }
                    }
                    delegatingNodePop = DelegatableNodeKt.pop(mutableVector);
                }
            }
        }
        return objectRef.element;
    }

    public final void onCoordinatesUsed$ui_release() {
        getLayoutNode().getLayoutDelegate().onCoordinatesUsed();
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public final LayoutCoordinates getParentLayoutCoordinates() {
        if (!isAttached()) {
            InlineClassHelperKt.throwIllegalStateException(ExpectAttachedLayoutCoordinates);
        }
        onCoordinatesUsed$ui_release();
        return getLayoutNode().getOuterCoordinator$ui_release().wrappedBy;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public final LayoutCoordinates getParentCoordinates() {
        if (!isAttached()) {
            InlineClassHelperKt.throwIllegalStateException(ExpectAttachedLayoutCoordinates);
        }
        onCoordinatesUsed$ui_release();
        return this.wrappedBy;
    }

    protected final MutableRect getRectCache() {
        MutableRect mutableRect = this._rectCache;
        if (mutableRect != null) {
            return mutableRect;
        }
        MutableRect mutableRect2 = new MutableRect(0.0f, 0.0f, 0.0f, 0.0f);
        this._rectCache = mutableRect2;
        return mutableRect2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OwnerSnapshotObserver getSnapshotObserver() {
        return LayoutNodeKt.requireOwner(getLayoutNode()).getSnapshotObserver();
    }

    /* renamed from: getLastMeasurementConstraints-msEJaDk$ui_release, reason: not valid java name */
    public final long m3832getLastMeasurementConstraintsmsEJaDk$ui_release() {
        return getMeasurementConstraints();
    }

    /* renamed from: performingMeasure-K40F9xA, reason: not valid java name */
    protected final Placeable m3837performingMeasureK40F9xA(long constraints, Function0<? extends Placeable> block) {
        m3676setMeasurementConstraintsBRTryo0(constraints);
        return block.invoke();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.compose.ui.layout.Placeable
    /* renamed from: placeAt-f8xVGno */
    public void mo3614placeAtf8xVGno(long position, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock) {
        if (this.forcePlaceWithLookaheadOffset) {
            LookaheadDelegate lookaheadDelegate = getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            m3824placeSelfMLgxB_4(lookaheadDelegate.getPosition(), zIndex, layerBlock, null);
            return;
        }
        m3824placeSelfMLgxB_4(position, zIndex, layerBlock, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.compose.ui.layout.Placeable
    /* renamed from: placeAt-f8xVGno */
    public void mo3674placeAtf8xVGno(long position, float zIndex, GraphicsLayer layer) {
        if (this.forcePlaceWithLookaheadOffset) {
            LookaheadDelegate lookaheadDelegate = getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            m3824placeSelfMLgxB_4(lookaheadDelegate.getPosition(), zIndex, null, layer);
            return;
        }
        m3824placeSelfMLgxB_4(position, zIndex, null, layer);
    }

    /* renamed from: placeSelf-MLgxB_4, reason: not valid java name */
    private final void m3824placeSelfMLgxB_4(long position, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock, GraphicsLayer explicitLayer) {
        if (explicitLayer != null) {
            if (!(layerBlock == null)) {
                InlineClassHelperKt.throwIllegalArgumentException("both ways to create layers shouldn't be used together");
            }
            if (this.explicitLayer != explicitLayer) {
                this.explicitLayer = null;
                updateLayerBlock$default(this, null, false, 2, null);
                this.explicitLayer = explicitLayer;
            }
            if (this.layer == null) {
                OwnedLayer ownedLayerCreateLayer = LayoutNodeKt.requireOwner(getLayoutNode()).createLayer(this.drawBlock, this.invalidateParentLayer, explicitLayer);
                ownedLayerCreateLayer.mo3899resizeozmzZPI(getMeasuredSize());
                ownedLayerCreateLayer.mo3898movegyyYBs(position);
                this.layer = ownedLayerCreateLayer;
                getLayoutNode().setInnerLayerCoordinatorIsDirty$ui_release(true);
                this.invalidateParentLayer.invoke();
            }
        } else {
            if (this.explicitLayer != null) {
                this.explicitLayer = null;
                updateLayerBlock$default(this, null, false, 2, null);
            }
            updateLayerBlock$default(this, layerBlock, false, 2, null);
        }
        if (!IntOffset.m4864equalsimpl0(getPosition(), position)) {
            m3839setPositiongyyYBs(position);
            getLayoutNode().getLayoutDelegate().getMeasurePassDelegate().notifyChildrenUsingCoordinatesWhilePlacing();
            OwnedLayer ownedLayer = this.layer;
            if (ownedLayer != null) {
                ownedLayer.mo3898movegyyYBs(position);
            } else {
                NodeCoordinator nodeCoordinator = this.wrappedBy;
                if (nodeCoordinator != null) {
                    nodeCoordinator.invalidateLayer();
                }
            }
            invalidateAlignmentLinesFromPositionChange(this);
            Owner owner = getLayoutNode().getOwner();
            if (owner != null) {
                owner.onLayoutChange(getLayoutNode());
            }
        }
        this.zIndex = zIndex;
        if (getIsPlacingForAlignment()) {
            return;
        }
        captureRulers$ui_release(getMeasureResult$ui_release());
    }

    public final void releaseLayer() {
        if (this.layer != null) {
            if (this.explicitLayer != null) {
                this.explicitLayer = null;
            }
            updateLayerBlock$default(this, null, false, 2, null);
            LayoutNode.requestRelayout$ui_release$default(getLayoutNode(), false, 1, null);
        }
    }

    /* renamed from: placeSelfApparentToRealOffset-MLgxB_4, reason: not valid java name */
    public final void m3838placeSelfApparentToRealOffsetMLgxB_4(long position, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock, GraphicsLayer layer) {
        m3824placeSelfMLgxB_4(IntOffset.m4869plusqkQi6aY(position, getApparentToRealOffset()), zIndex, layerBlock, layer);
    }

    public final void draw(Canvas canvas, GraphicsLayer graphicsLayer) {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.drawLayer(canvas, graphicsLayer);
            return;
        }
        float fM4865getXimpl = IntOffset.m4865getXimpl(getPosition());
        float fM4866getYimpl = IntOffset.m4866getYimpl(getPosition());
        canvas.translate(fM4865getXimpl, fM4866getYimpl);
        drawContainedDrawModifiers(canvas, graphicsLayer);
        canvas.translate(-fM4865getXimpl, -fM4866getYimpl);
    }

    public void performDraw(Canvas canvas, GraphicsLayer graphicsLayer) {
        NodeCoordinator nodeCoordinator = this.wrapped;
        if (nodeCoordinator != null) {
            nodeCoordinator.draw(canvas, graphicsLayer);
        }
    }

    public static /* synthetic */ void updateLayerBlock$default(NodeCoordinator nodeCoordinator, Function1 function1, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateLayerBlock");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        nodeCoordinator.updateLayerBlock(function1, z);
    }

    public final void updateLayerBlock(Function1<? super GraphicsLayerScope, Unit> layerBlock, boolean forceUpdateLayerParameters) {
        Owner owner;
        if (!(layerBlock == null || this.explicitLayer == null)) {
            InlineClassHelperKt.throwIllegalArgumentException("layerBlock can't be provided when explicitLayer is provided");
        }
        LayoutNode layoutNode = getLayoutNode();
        boolean z = (!forceUpdateLayerParameters && this.layerBlock == layerBlock && Intrinsics.areEqual(this.layerDensity, layoutNode.getDensity()) && this.layerLayoutDirection == layoutNode.getLayoutDirection()) ? false : true;
        this.layerDensity = layoutNode.getDensity();
        this.layerLayoutDirection = layoutNode.getLayoutDirection();
        if (layoutNode.isAttached() && layerBlock != null) {
            this.layerBlock = layerBlock;
            if (this.layer != null) {
                if (z) {
                    updateLayerParameters$default(this, false, 1, null);
                    return;
                }
                return;
            }
            OwnedLayer ownedLayerCreateLayer$default = Owner.createLayer$default(LayoutNodeKt.requireOwner(layoutNode), this.drawBlock, this.invalidateParentLayer, null, 4, null);
            ownedLayerCreateLayer$default.mo3899resizeozmzZPI(getMeasuredSize());
            ownedLayerCreateLayer$default.mo3898movegyyYBs(getPosition());
            this.layer = ownedLayerCreateLayer$default;
            updateLayerParameters$default(this, false, 1, null);
            layoutNode.setInnerLayerCoordinatorIsDirty$ui_release(true);
            this.invalidateParentLayer.invoke();
            return;
        }
        this.layerBlock = null;
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.destroy();
            layoutNode.setInnerLayerCoordinatorIsDirty$ui_release(true);
            this.invalidateParentLayer.invoke();
            if (isAttached() && (owner = layoutNode.getOwner()) != null) {
                owner.onLayoutChange(layoutNode);
            }
        }
        this.layer = null;
        this.lastLayerDrawingWasSkipped = false;
    }

    static /* synthetic */ void updateLayerParameters$default(NodeCoordinator nodeCoordinator, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateLayerParameters");
        }
        if ((i & 1) != 0) {
            z = true;
        }
        nodeCoordinator.updateLayerParameters(z);
    }

    private final void updateLayerParameters(boolean invokeOnLayoutChange) {
        Owner owner;
        if (this.explicitLayer != null) {
            return;
        }
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            final Function1<? super GraphicsLayerScope, Unit> function1 = this.layerBlock;
            if (function1 != null) {
                ReusableGraphicsLayerScope reusableGraphicsLayerScope = graphicsLayerScope;
                reusableGraphicsLayerScope.reset();
                reusableGraphicsLayerScope.setGraphicsDensity$ui_release(getLayoutNode().getDensity());
                reusableGraphicsLayerScope.setLayoutDirection$ui_release(getLayoutNode().getLayoutDirection());
                reusableGraphicsLayerScope.m2589setSizeuvyYCjk(IntSizeKt.m4919toSizeozmzZPI(mo3621getSizeYbymL2g()));
                getSnapshotObserver().observeReads$ui_release(this, onCommitAffectingLayerParams, new Function0<Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator.updateLayerParameters.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
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
                        function1.invoke(NodeCoordinator.graphicsLayerScope);
                        NodeCoordinator.graphicsLayerScope.updateOutline$ui_release();
                    }
                });
                LayerPositionalProperties layerPositionalProperties = this.layerPositionalProperties;
                if (layerPositionalProperties == null) {
                    layerPositionalProperties = new LayerPositionalProperties();
                    this.layerPositionalProperties = layerPositionalProperties;
                }
                layerPositionalProperties.copyFrom(reusableGraphicsLayerScope);
                ownedLayer.updateLayerProperties(reusableGraphicsLayerScope);
                this.isClipping = reusableGraphicsLayerScope.getClip();
                this.lastLayerAlpha = reusableGraphicsLayerScope.getAlpha();
                if (!invokeOnLayoutChange || (owner = getLayoutNode().getOwner()) == null) {
                    return;
                }
                owner.onLayoutChange(getLayoutNode());
                return;
            }
            InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("updateLayerParameters requires a non-null layerBlock");
            throw new KotlinNothingValueException();
        }
        if (this.layerBlock == null) {
            return;
        }
        InlineClassHelperKt.throwIllegalStateException("null layer with a non-null layerBlock");
    }

    /* renamed from: getLastLayerDrawingWasSkipped$ui_release, reason: from getter */
    public final boolean getLastLayerDrawingWasSkipped() {
        return this.lastLayerDrawingWasSkipped;
    }

    public final OwnedLayer getLayer() {
        return this.layer;
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public boolean isValidOwnerScope() {
        return (this.layer == null || this.released || !getLayoutNode().isAttached()) ? false : true;
    }

    /* renamed from: getMinimumTouchTargetSize-NH-jbRc, reason: not valid java name */
    public final long m3833getMinimumTouchTargetSizeNHjbRc() {
        return this.layerDensity.mo695toSizeXkaWNTQ(getLayoutNode().getViewConfiguration().mo3769getMinimumTouchTargetSizeMYxV2XQ());
    }

    /* renamed from: hitTest-YqVAtuI, reason: not valid java name */
    public final void m3835hitTestYqVAtuI(HitTestSource hitTestSource, long pointerPosition, HitTestResult hitTestResult, boolean isTouchEvent, boolean isInLayer) {
        Modifier.Node nodeM3834headH91voCI = m3834headH91voCI(hitTestSource.mo3844entityTypeOLwlOKw());
        if (!m3842withinLayerBoundsk4lQ0M(pointerPosition)) {
            if (isTouchEvent) {
                float fM3830distanceInMinimumTouchTargettz77jQw = m3830distanceInMinimumTouchTargettz77jQw(pointerPosition, m3833getMinimumTouchTargetSizeNHjbRc());
                if (Float.isInfinite(fM3830distanceInMinimumTouchTargettz77jQw) || Float.isNaN(fM3830distanceInMinimumTouchTargettz77jQw) || !hitTestResult.isHitInMinimumTouchTargetBetter(fM3830distanceInMinimumTouchTargettz77jQw, false)) {
                    return;
                }
                m3822hitNearJHbHoSQ(nodeM3834headH91voCI, hitTestSource, pointerPosition, hitTestResult, isTouchEvent, false, fM3830distanceInMinimumTouchTargettz77jQw);
                return;
            }
            return;
        }
        if (nodeM3834headH91voCI == null) {
            mo3757hitTestChildYqVAtuI(hitTestSource, pointerPosition, hitTestResult, isTouchEvent, isInLayer);
            return;
        }
        if (m3836isPointerInBoundsk4lQ0M(pointerPosition)) {
            m3821hit1hIXUjU(nodeM3834headH91voCI, hitTestSource, pointerPosition, hitTestResult, isTouchEvent, isInLayer);
            return;
        }
        float fM3830distanceInMinimumTouchTargettz77jQw2 = !isTouchEvent ? Float.POSITIVE_INFINITY : m3830distanceInMinimumTouchTargettz77jQw(pointerPosition, m3833getMinimumTouchTargetSizeNHjbRc());
        if (!Float.isInfinite(fM3830distanceInMinimumTouchTargettz77jQw2) && !Float.isNaN(fM3830distanceInMinimumTouchTargettz77jQw2)) {
            if (hitTestResult.isHitInMinimumTouchTargetBetter(fM3830distanceInMinimumTouchTargettz77jQw2, isInLayer)) {
                m3822hitNearJHbHoSQ(nodeM3834headH91voCI, hitTestSource, pointerPosition, hitTestResult, isTouchEvent, isInLayer, fM3830distanceInMinimumTouchTargettz77jQw2);
                return;
            }
        }
        m3825speculativeHitJHbHoSQ(nodeM3834headH91voCI, hitTestSource, pointerPosition, hitTestResult, isTouchEvent, isInLayer, fM3830distanceInMinimumTouchTargettz77jQw2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: hit-1hIXUjU, reason: not valid java name */
    public final void m3821hit1hIXUjU(final Modifier.Node node, final HitTestSource hitTestSource, final long j, final HitTestResult hitTestResult, final boolean z, final boolean z2) {
        if (node == null) {
            mo3757hitTestChildYqVAtuI(hitTestSource, j, hitTestResult, z, z2);
        } else {
            hitTestResult.hit(node, z2, new Function0<Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$hit$1
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
                    this.this$0.m3821hit1hIXUjU(NodeCoordinatorKt.m3846nextUntilhw7D004(node, hitTestSource.mo3844entityTypeOLwlOKw(), NodeKind.m3848constructorimpl(2)), hitTestSource, j, hitTestResult, z, z2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: hitNear-JHbHoSQ, reason: not valid java name */
    public final void m3822hitNearJHbHoSQ(final Modifier.Node node, final HitTestSource hitTestSource, final long j, final HitTestResult hitTestResult, final boolean z, final boolean z2, final float f) {
        if (node == null) {
            mo3757hitTestChildYqVAtuI(hitTestSource, j, hitTestResult, z, z2);
        } else {
            hitTestResult.hitInMinimumTouchTarget(node, f, z2, new Function0<Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$hitNear$1
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
                    this.this$0.m3822hitNearJHbHoSQ(NodeCoordinatorKt.m3846nextUntilhw7D004(node, hitTestSource.mo3844entityTypeOLwlOKw(), NodeKind.m3848constructorimpl(2)), hitTestSource, j, hitTestResult, z, z2, f);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: speculativeHit-JHbHoSQ, reason: not valid java name */
    public final void m3825speculativeHitJHbHoSQ(final Modifier.Node node, final HitTestSource hitTestSource, final long j, final HitTestResult hitTestResult, final boolean z, final boolean z2, final float f) {
        if (node == null) {
            mo3757hitTestChildYqVAtuI(hitTestSource, j, hitTestResult, z, z2);
        } else if (!hitTestSource.interceptOutOfBoundsChildEvents(node)) {
            m3825speculativeHitJHbHoSQ(NodeCoordinatorKt.m3846nextUntilhw7D004(node, hitTestSource.mo3844entityTypeOLwlOKw(), NodeKind.m3848constructorimpl(2)), hitTestSource, j, hitTestResult, z, z2, f);
        } else {
            hitTestResult.speculativeHit(node, f, z2, new Function0<Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$speculativeHit$1
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
                    this.this$0.m3825speculativeHitJHbHoSQ(NodeCoordinatorKt.m3846nextUntilhw7D004(node, hitTestSource.mo3844entityTypeOLwlOKw(), NodeKind.m3848constructorimpl(2)), hitTestSource, j, hitTestResult, z, z2, f);
                }
            });
        }
    }

    /* renamed from: hitTestChild-YqVAtuI */
    public void mo3757hitTestChildYqVAtuI(HitTestSource hitTestSource, long pointerPosition, HitTestResult hitTestResult, boolean isTouchEvent, boolean isInLayer) {
        NodeCoordinator nodeCoordinator = this.wrapped;
        if (nodeCoordinator != null) {
            nodeCoordinator.m3835hitTestYqVAtuI(hitTestSource, m3819fromParentPosition8S9VItk$default(nodeCoordinator, pointerPosition, false, 2, null), hitTestResult, isTouchEvent, isInLayer);
        }
    }

    public final Rect touchBoundsInRoot() {
        if (!isAttached()) {
            return Rect.INSTANCE.getZero();
        }
        LayoutCoordinates layoutCoordinatesFindRootCoordinates = LayoutCoordinatesKt.findRootCoordinates(this);
        MutableRect rectCache = getRectCache();
        long jM3829calculateMinimumTouchTargetPaddingE7KxVPU = m3829calculateMinimumTouchTargetPaddingE7KxVPU(m3833getMinimumTouchTargetSizeNHjbRc());
        rectCache.setLeft(-Size.m2104getWidthimpl(jM3829calculateMinimumTouchTargetPaddingE7KxVPU));
        rectCache.setTop(-Size.m2101getHeightimpl(jM3829calculateMinimumTouchTargetPaddingE7KxVPU));
        rectCache.setRight(getMeasuredWidth() + Size.m2104getWidthimpl(jM3829calculateMinimumTouchTargetPaddingE7KxVPU));
        rectCache.setBottom(getMeasuredHeight() + Size.m2101getHeightimpl(jM3829calculateMinimumTouchTargetPaddingE7KxVPU));
        NodeCoordinator nodeCoordinator = this;
        while (nodeCoordinator != layoutCoordinatesFindRootCoordinates) {
            nodeCoordinator.rectInParent$ui_release(rectCache, false, true);
            if (rectCache.isEmpty()) {
                return Rect.INSTANCE.getZero();
            }
            nodeCoordinator = nodeCoordinator.wrappedBy;
            Intrinsics.checkNotNull(nodeCoordinator);
        }
        return MutableRectKt.toRect(rectCache);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: screenToLocal-MK-Hz9U */
    public long mo3627screenToLocalMKHz9U(long relativeToScreen) {
        if (!isAttached()) {
            InlineClassHelperKt.throwIllegalStateException(ExpectAttachedLayoutCoordinates);
        }
        return mo3622localPositionOfR5De75A(LayoutCoordinatesKt.findRootCoordinates(this), LayoutNodeKt.requireOwner(getLayoutNode()).mo3567screenToLocalMKHz9U(relativeToScreen));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: localToScreen-MK-Hz9U */
    public long mo3625localToScreenMKHz9U(long relativeToLocal) {
        if (!isAttached()) {
            InlineClassHelperKt.throwIllegalStateException(ExpectAttachedLayoutCoordinates);
        }
        return LayoutNodeKt.requireOwner(getLayoutNode()).mo3566localToScreenMKHz9U(mo3624localToRootMKHz9U(relativeToLocal));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: windowToLocal-MK-Hz9U */
    public long mo3630windowToLocalMKHz9U(long relativeToWindow) {
        if (!isAttached()) {
            InlineClassHelperKt.throwIllegalStateException(ExpectAttachedLayoutCoordinates);
        }
        LayoutCoordinates layoutCoordinatesFindRootCoordinates = LayoutCoordinatesKt.findRootCoordinates(this);
        return mo3622localPositionOfR5De75A(layoutCoordinatesFindRootCoordinates, Offset.m2039minusMKHz9U(LayoutNodeKt.requireOwner(getLayoutNode()).mo3901calculateLocalPositionMKHz9U(relativeToWindow), LayoutCoordinatesKt.positionInRoot(layoutCoordinatesFindRootCoordinates)));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: localToWindow-MK-Hz9U */
    public long mo3626localToWindowMKHz9U(long relativeToLocal) {
        return LayoutNodeKt.requireOwner(getLayoutNode()).mo3902calculatePositionInWindowMKHz9U(mo3624localToRootMKHz9U(relativeToLocal));
    }

    private final NodeCoordinator toCoordinator(LayoutCoordinates layoutCoordinates) {
        NodeCoordinator coordinator;
        LookaheadLayoutCoordinates lookaheadLayoutCoordinates = layoutCoordinates instanceof LookaheadLayoutCoordinates ? (LookaheadLayoutCoordinates) layoutCoordinates : null;
        if (lookaheadLayoutCoordinates != null && (coordinator = lookaheadLayoutCoordinates.getCoordinator()) != null) {
            return coordinator;
        }
        Intrinsics.checkNotNull(layoutCoordinates, "null cannot be cast to non-null type androidx.compose.ui.node.NodeCoordinator");
        return (NodeCoordinator) layoutCoordinates;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: localPositionOf-R5De75A */
    public long mo3622localPositionOfR5De75A(LayoutCoordinates sourceCoordinates, long relativeToSource) {
        return mo3623localPositionOfS_NoaFU(sourceCoordinates, relativeToSource, true);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: localPositionOf-S_NoaFU */
    public long mo3623localPositionOfS_NoaFU(LayoutCoordinates sourceCoordinates, long relativeToSource, boolean includeMotionFrameOfReference) {
        if (sourceCoordinates instanceof LookaheadLayoutCoordinates) {
            ((LookaheadLayoutCoordinates) sourceCoordinates).getCoordinator().onCoordinatesUsed$ui_release();
            return Offset.m2044unaryMinusF1C5BW0(sourceCoordinates.mo3623localPositionOfS_NoaFU(this, Offset.m2044unaryMinusF1C5BW0(relativeToSource), includeMotionFrameOfReference));
        }
        NodeCoordinator coordinator = toCoordinator(sourceCoordinates);
        coordinator.onCoordinatesUsed$ui_release();
        NodeCoordinator nodeCoordinatorFindCommonAncestor$ui_release = findCommonAncestor$ui_release(coordinator);
        while (coordinator != nodeCoordinatorFindCommonAncestor$ui_release) {
            relativeToSource = coordinator.m3840toParentPosition8S9VItk(relativeToSource, includeMotionFrameOfReference);
            coordinator = coordinator.wrappedBy;
            Intrinsics.checkNotNull(coordinator);
        }
        return m3818ancestorToLocalS_NoaFU(nodeCoordinatorFindCommonAncestor$ui_release, relativeToSource, includeMotionFrameOfReference);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: transformFrom-EL8BTi8 */
    public void mo3628transformFromEL8BTi8(LayoutCoordinates sourceCoordinates, float[] matrix) {
        NodeCoordinator coordinator = toCoordinator(sourceCoordinates);
        coordinator.onCoordinatesUsed$ui_release();
        NodeCoordinator nodeCoordinatorFindCommonAncestor$ui_release = findCommonAncestor$ui_release(coordinator);
        Matrix.m2517resetimpl(matrix);
        coordinator.m3828transformToAncestorEL8BTi8(nodeCoordinatorFindCommonAncestor$ui_release, matrix);
        m3827transformFromAncestorEL8BTi8(nodeCoordinatorFindCommonAncestor$ui_release, matrix);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: transformToScreen-58bKbWc */
    public void mo3629transformToScreen58bKbWc(float[] matrix) {
        Owner ownerRequireOwner = LayoutNodeKt.requireOwner(getLayoutNode());
        m3828transformToAncestorEL8BTi8(toCoordinator(LayoutCoordinatesKt.findRootCoordinates(this)), matrix);
        ownerRequireOwner.mo3565localToScreen58bKbWc(matrix);
    }

    /* renamed from: transformToAncestor-EL8BTi8, reason: not valid java name */
    private final void m3828transformToAncestorEL8BTi8(NodeCoordinator ancestor, float[] matrix) {
        NodeCoordinator nodeCoordinator = this;
        while (!Intrinsics.areEqual(nodeCoordinator, ancestor)) {
            OwnedLayer ownedLayer = nodeCoordinator.layer;
            if (ownedLayer != null) {
                ownedLayer.mo3900transform58bKbWc(matrix);
            }
            if (!IntOffset.m4864equalsimpl0(nodeCoordinator.getPosition(), IntOffset.INSTANCE.m4875getZeronOccac())) {
                float[] fArr = tmpMatrix;
                Matrix.m2517resetimpl(fArr);
                Matrix.m2528translateimpl$default(fArr, IntOffset.m4865getXimpl(r1), IntOffset.m4866getYimpl(r1), 0.0f, 4, null);
                Matrix.m2525timesAssign58bKbWc(matrix, fArr);
            }
            nodeCoordinator = nodeCoordinator.wrappedBy;
            Intrinsics.checkNotNull(nodeCoordinator);
        }
    }

    /* renamed from: transformFromAncestor-EL8BTi8, reason: not valid java name */
    private final void m3827transformFromAncestorEL8BTi8(NodeCoordinator ancestor, float[] matrix) {
        if (Intrinsics.areEqual(ancestor, this)) {
            return;
        }
        NodeCoordinator nodeCoordinator = this.wrappedBy;
        Intrinsics.checkNotNull(nodeCoordinator);
        nodeCoordinator.m3827transformFromAncestorEL8BTi8(ancestor, matrix);
        if (!IntOffset.m4864equalsimpl0(getPosition(), IntOffset.INSTANCE.m4875getZeronOccac())) {
            float[] fArr = tmpMatrix;
            Matrix.m2517resetimpl(fArr);
            Matrix.m2528translateimpl$default(fArr, -IntOffset.m4865getXimpl(getPosition()), -IntOffset.m4866getYimpl(getPosition()), 0.0f, 4, null);
            Matrix.m2525timesAssign58bKbWc(matrix, fArr);
        }
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.mo3895inverseTransform58bKbWc(matrix);
        }
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public Rect localBoundingBoxOf(LayoutCoordinates sourceCoordinates, boolean clipBounds) {
        if (!isAttached()) {
            InlineClassHelperKt.throwIllegalStateException(ExpectAttachedLayoutCoordinates);
        }
        if (!sourceCoordinates.isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("LayoutCoordinates " + sourceCoordinates + " is not attached!");
        }
        NodeCoordinator coordinator = toCoordinator(sourceCoordinates);
        coordinator.onCoordinatesUsed$ui_release();
        NodeCoordinator nodeCoordinatorFindCommonAncestor$ui_release = findCommonAncestor$ui_release(coordinator);
        MutableRect rectCache = getRectCache();
        rectCache.setLeft(0.0f);
        rectCache.setTop(0.0f);
        rectCache.setRight(IntSize.m4907getWidthimpl(sourceCoordinates.mo3621getSizeYbymL2g()));
        rectCache.setBottom(IntSize.m4906getHeightimpl(sourceCoordinates.mo3621getSizeYbymL2g()));
        while (coordinator != nodeCoordinatorFindCommonAncestor$ui_release) {
            rectInParent$ui_release$default(coordinator, rectCache, clipBounds, false, 4, null);
            if (rectCache.isEmpty()) {
                return Rect.INSTANCE.getZero();
            }
            coordinator = coordinator.wrappedBy;
            Intrinsics.checkNotNull(coordinator);
        }
        ancestorToLocal(nodeCoordinatorFindCommonAncestor$ui_release, rectCache, clipBounds);
        return MutableRectKt.toRect(rectCache);
    }

    /* renamed from: ancestorToLocal-S_NoaFU, reason: not valid java name */
    private final long m3818ancestorToLocalS_NoaFU(NodeCoordinator ancestor, long offset, boolean includeMotionFrameOfReference) {
        if (ancestor == this) {
            return offset;
        }
        NodeCoordinator nodeCoordinator = this.wrappedBy;
        if (nodeCoordinator == null || Intrinsics.areEqual(ancestor, nodeCoordinator)) {
            return m3831fromParentPosition8S9VItk(offset, includeMotionFrameOfReference);
        }
        return m3831fromParentPosition8S9VItk(nodeCoordinator.m3818ancestorToLocalS_NoaFU(ancestor, offset, includeMotionFrameOfReference), includeMotionFrameOfReference);
    }

    private final void ancestorToLocal(NodeCoordinator ancestor, MutableRect rect, boolean clipBounds) {
        if (ancestor == this) {
            return;
        }
        NodeCoordinator nodeCoordinator = this.wrappedBy;
        if (nodeCoordinator != null) {
            nodeCoordinator.ancestorToLocal(ancestor, rect, clipBounds);
        }
        fromParentRect(rect, clipBounds);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: localToRoot-MK-Hz9U */
    public long mo3624localToRootMKHz9U(long relativeToLocal) {
        if (!isAttached()) {
            InlineClassHelperKt.throwIllegalStateException(ExpectAttachedLayoutCoordinates);
        }
        onCoordinatesUsed$ui_release();
        long jM3826toParentPosition8S9VItk$default = relativeToLocal;
        for (NodeCoordinator nodeCoordinator = this; nodeCoordinator != null; nodeCoordinator = nodeCoordinator.wrappedBy) {
            jM3826toParentPosition8S9VItk$default = m3826toParentPosition8S9VItk$default(nodeCoordinator, jM3826toParentPosition8S9VItk$default, false, 2, null);
        }
        return jM3826toParentPosition8S9VItk$default;
    }

    protected final void withPositionTranslation(Canvas canvas, Function1<? super Canvas, Unit> block) {
        float fM4865getXimpl = IntOffset.m4865getXimpl(getPosition());
        float fM4866getYimpl = IntOffset.m4866getYimpl(getPosition());
        canvas.translate(fM4865getXimpl, fM4866getYimpl);
        block.invoke(canvas);
        canvas.translate(-fM4865getXimpl, -fM4866getYimpl);
    }

    /* renamed from: toParentPosition-8S9VItk$default, reason: not valid java name */
    public static /* synthetic */ long m3826toParentPosition8S9VItk$default(NodeCoordinator nodeCoordinator, long j, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toParentPosition-8S9VItk");
        }
        if ((i & 2) != 0) {
            z = true;
        }
        return nodeCoordinator.m3840toParentPosition8S9VItk(j, z);
    }

    /* renamed from: toParentPosition-8S9VItk, reason: not valid java name */
    public long m3840toParentPosition8S9VItk(long position, boolean includeMotionFrameOfReference) {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            position = ownedLayer.mo3897mapOffset8S9VItk(position, false);
        }
        return (includeMotionFrameOfReference || !getIsPlacedUnderMotionFrameOfReference()) ? IntOffsetKt.m4879plusNvtHpc(position, getPosition()) : position;
    }

    /* renamed from: fromParentPosition-8S9VItk$default, reason: not valid java name */
    public static /* synthetic */ long m3819fromParentPosition8S9VItk$default(NodeCoordinator nodeCoordinator, long j, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fromParentPosition-8S9VItk");
        }
        if ((i & 2) != 0) {
            z = true;
        }
        return nodeCoordinator.m3831fromParentPosition8S9VItk(j, z);
    }

    /* renamed from: fromParentPosition-8S9VItk, reason: not valid java name */
    public long m3831fromParentPosition8S9VItk(long position, boolean includeMotionFrameOfReference) {
        if (includeMotionFrameOfReference || !getIsPlacedUnderMotionFrameOfReference()) {
            position = IntOffsetKt.m4877minusNvtHpc(position, getPosition());
        }
        OwnedLayer ownedLayer = this.layer;
        return ownedLayer != null ? ownedLayer.mo3897mapOffset8S9VItk(position, true) : position;
    }

    protected final void drawBorder(Canvas canvas, Paint paint) {
        canvas.drawRect(new Rect(0.5f, 0.5f, IntSize.m4907getWidthimpl(getMeasuredSize()) - 0.5f, IntSize.m4906getHeightimpl(getMeasuredSize()) - 0.5f), paint);
    }

    public final void onLayoutNodeAttach() {
        updateLayerBlock(this.layerBlock, true);
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.invalidate();
        }
    }

    public final void onRelease() {
        this.released = true;
        this.invalidateParentLayer.invoke();
        releaseLayer();
    }

    public static /* synthetic */ void rectInParent$ui_release$default(NodeCoordinator nodeCoordinator, MutableRect mutableRect, boolean z, boolean z2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: rectInParent");
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        nodeCoordinator.rectInParent$ui_release(mutableRect, z, z2);
    }

    public final void rectInParent$ui_release(MutableRect bounds, boolean clipBounds, boolean clipToMinimumTouchTargetSize) {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            if (this.isClipping) {
                if (clipToMinimumTouchTargetSize) {
                    long jM3833getMinimumTouchTargetSizeNHjbRc = m3833getMinimumTouchTargetSizeNHjbRc();
                    float fM2104getWidthimpl = Size.m2104getWidthimpl(jM3833getMinimumTouchTargetSizeNHjbRc) / 2.0f;
                    float fM2101getHeightimpl = Size.m2101getHeightimpl(jM3833getMinimumTouchTargetSizeNHjbRc) / 2.0f;
                    bounds.intersect(-fM2104getWidthimpl, -fM2101getHeightimpl, IntSize.m4907getWidthimpl(mo3621getSizeYbymL2g()) + fM2104getWidthimpl, IntSize.m4906getHeightimpl(mo3621getSizeYbymL2g()) + fM2101getHeightimpl);
                } else if (clipBounds) {
                    bounds.intersect(0.0f, 0.0f, IntSize.m4907getWidthimpl(mo3621getSizeYbymL2g()), IntSize.m4906getHeightimpl(mo3621getSizeYbymL2g()));
                }
                if (bounds.isEmpty()) {
                    return;
                }
            }
            ownedLayer.mapBounds(bounds, false);
        }
        float fM4865getXimpl = IntOffset.m4865getXimpl(getPosition());
        bounds.setLeft(bounds.getLeft() + fM4865getXimpl);
        bounds.setRight(bounds.getRight() + fM4865getXimpl);
        float fM4866getYimpl = IntOffset.m4866getYimpl(getPosition());
        bounds.setTop(bounds.getTop() + fM4866getYimpl);
        bounds.setBottom(bounds.getBottom() + fM4866getYimpl);
    }

    private final void fromParentRect(MutableRect bounds, boolean clipBounds) {
        float fM4865getXimpl = IntOffset.m4865getXimpl(getPosition());
        bounds.setLeft(bounds.getLeft() - fM4865getXimpl);
        bounds.setRight(bounds.getRight() - fM4865getXimpl);
        float fM4866getYimpl = IntOffset.m4866getYimpl(getPosition());
        bounds.setTop(bounds.getTop() - fM4866getYimpl);
        bounds.setBottom(bounds.getBottom() - fM4866getYimpl);
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.mapBounds(bounds, true);
            if (this.isClipping && clipBounds) {
                bounds.intersect(0.0f, 0.0f, IntSize.m4907getWidthimpl(mo3621getSizeYbymL2g()), IntSize.m4906getHeightimpl(mo3621getSizeYbymL2g()));
                bounds.isEmpty();
            }
        }
    }

    /* renamed from: withinLayerBounds-k-4lQ0M, reason: not valid java name */
    protected final boolean m3842withinLayerBoundsk4lQ0M(long pointerPosition) {
        if (!OffsetKt.m2052isFinitek4lQ0M(pointerPosition)) {
            return false;
        }
        OwnedLayer ownedLayer = this.layer;
        return ownedLayer == null || !this.isClipping || ownedLayer.mo3896isInLayerk4lQ0M(pointerPosition);
    }

    /* renamed from: isPointerInBounds-k-4lQ0M, reason: not valid java name */
    protected final boolean m3836isPointerInBoundsk4lQ0M(long pointerPosition) {
        float fM2035getXimpl = Offset.m2035getXimpl(pointerPosition);
        float fM2036getYimpl = Offset.m2036getYimpl(pointerPosition);
        return fM2035getXimpl >= 0.0f && fM2036getYimpl >= 0.0f && fM2035getXimpl < ((float) getMeasuredWidth()) && fM2036getYimpl < ((float) getMeasuredHeight());
    }

    public void invalidateLayer() {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.invalidate();
            return;
        }
        NodeCoordinator nodeCoordinator = this.wrappedBy;
        if (nodeCoordinator != null) {
            nodeCoordinator.invalidateLayer();
        }
    }

    public void onLayoutModifierNodeChanged() {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.invalidate();
        }
    }

    public final NodeCoordinator findCommonAncestor$ui_release(NodeCoordinator other) {
        LayoutNode layoutNode = other.getLayoutNode();
        LayoutNode layoutNode2 = getLayoutNode();
        if (layoutNode == layoutNode2) {
            Modifier.Node tail = other.getTail();
            Modifier.Node tail2 = getTail();
            int iM3848constructorimpl = NodeKind.m3848constructorimpl(2);
            if (!tail2.getNode().getIsAttached()) {
                InlineClassHelperKt.throwIllegalStateException("visitLocalAncestors called on an unattached node");
            }
            for (Modifier.Node parent = tail2.getNode().getParent(); parent != null; parent = parent.getParent()) {
                if ((parent.getKindSet() & iM3848constructorimpl) != 0 && parent == tail) {
                    return other;
                }
            }
            return this;
        }
        while (layoutNode.getDepth() > layoutNode2.getDepth()) {
            layoutNode = layoutNode.getParent$ui_release();
            Intrinsics.checkNotNull(layoutNode);
        }
        while (layoutNode2.getDepth() > layoutNode.getDepth()) {
            layoutNode2 = layoutNode2.getParent$ui_release();
            Intrinsics.checkNotNull(layoutNode2);
        }
        while (layoutNode != layoutNode2) {
            layoutNode = layoutNode.getParent$ui_release();
            layoutNode2 = layoutNode2.getParent$ui_release();
            if (layoutNode == null || layoutNode2 == null) {
                throw new IllegalArgumentException("layouts are not part of the same hierarchy");
            }
        }
        return layoutNode2 == getLayoutNode() ? this : layoutNode == other.getLayoutNode() ? other : layoutNode.getInnerCoordinator$ui_release();
    }

    /* renamed from: offsetFromEdge-MK-Hz9U, reason: not valid java name */
    private final long m3823offsetFromEdgeMKHz9U(long pointerPosition) {
        float fM2035getXimpl = Offset.m2035getXimpl(pointerPosition);
        float fMax = Math.max(0.0f, fM2035getXimpl < 0.0f ? -fM2035getXimpl : fM2035getXimpl - getMeasuredWidth());
        float fM2036getYimpl = Offset.m2036getYimpl(pointerPosition);
        return OffsetKt.Offset(fMax, Math.max(0.0f, fM2036getYimpl < 0.0f ? -fM2036getYimpl : fM2036getYimpl - getMeasuredHeight()));
    }

    /* renamed from: calculateMinimumTouchTargetPadding-E7KxVPU, reason: not valid java name */
    protected final long m3829calculateMinimumTouchTargetPaddingE7KxVPU(long minimumTouchTargetSize) {
        return SizeKt.Size(Math.max(0.0f, (Size.m2104getWidthimpl(minimumTouchTargetSize) - getMeasuredWidth()) / 2.0f), Math.max(0.0f, (Size.m2101getHeightimpl(minimumTouchTargetSize) - getMeasuredHeight()) / 2.0f));
    }

    /* renamed from: distanceInMinimumTouchTarget-tz77jQw, reason: not valid java name */
    protected final float m3830distanceInMinimumTouchTargettz77jQw(long pointerPosition, long minimumTouchTargetSize) {
        if (getMeasuredWidth() >= Size.m2104getWidthimpl(minimumTouchTargetSize) && getMeasuredHeight() >= Size.m2101getHeightimpl(minimumTouchTargetSize)) {
            return Float.POSITIVE_INFINITY;
        }
        long jM3829calculateMinimumTouchTargetPaddingE7KxVPU = m3829calculateMinimumTouchTargetPaddingE7KxVPU(minimumTouchTargetSize);
        float fM2104getWidthimpl = Size.m2104getWidthimpl(jM3829calculateMinimumTouchTargetPaddingE7KxVPU);
        float fM2101getHeightimpl = Size.m2101getHeightimpl(jM3829calculateMinimumTouchTargetPaddingE7KxVPU);
        long jM3823offsetFromEdgeMKHz9U = m3823offsetFromEdgeMKHz9U(pointerPosition);
        if ((fM2104getWidthimpl > 0.0f || fM2101getHeightimpl > 0.0f) && Offset.m2035getXimpl(jM3823offsetFromEdgeMKHz9U) <= fM2104getWidthimpl && Offset.m2036getYimpl(jM3823offsetFromEdgeMKHz9U) <= fM2101getHeightimpl) {
            return Offset.m2034getDistanceSquaredimpl(jM3823offsetFromEdgeMKHz9U);
        }
        return Float.POSITIVE_INFINITY;
    }

    /* compiled from: NodeCoordinator.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\u00020\u0016X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0017\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0018"}, d2 = {"Landroidx/compose/ui/node/NodeCoordinator$Companion;", "", "()V", "ExpectAttachedLayoutCoordinates", "", "PointerInputSource", "Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "getPointerInputSource", "()Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "SemanticsSource", "getSemanticsSource", "UnmeasuredError", "graphicsLayerScope", "Landroidx/compose/ui/graphics/ReusableGraphicsLayerScope;", "onCommitAffectingLayer", "Lkotlin/Function1;", "Landroidx/compose/ui/node/NodeCoordinator;", "", "onCommitAffectingLayerParams", "tmpLayerPositionalProperties", "Landroidx/compose/ui/node/LayerPositionalProperties;", "tmpMatrix", "Landroidx/compose/ui/graphics/Matrix;", "[F", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HitTestSource getPointerInputSource() {
            return NodeCoordinator.PointerInputSource;
        }

        public final HitTestSource getSemanticsSource() {
            return NodeCoordinator.SemanticsSource;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r8v7, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9, types: [java.lang.Object] */
    public final void onMeasured() {
        Modifier.Node parent;
        if (m3820hasNodeH91voCI(NodeKind.m3848constructorimpl(128))) {
            Snapshot.Companion companion = Snapshot.INSTANCE;
            Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
            Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
            Snapshot snapshotMakeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
            try {
                int iM3848constructorimpl = NodeKind.m3848constructorimpl(128);
                boolean zM3857getIncludeSelfInTraversalH91voCI = NodeKindKt.m3857getIncludeSelfInTraversalH91voCI(iM3848constructorimpl);
                if (!zM3857getIncludeSelfInTraversalH91voCI) {
                    parent = getTail().getParent();
                    if (parent == null) {
                    }
                    Unit unit = Unit.INSTANCE;
                }
                parent = getTail();
                for (Modifier.Node nodeHeadNode = headNode(zM3857getIncludeSelfInTraversalH91voCI); nodeHeadNode != null && (nodeHeadNode.getAggregateChildKindSet() & iM3848constructorimpl) != 0; nodeHeadNode = nodeHeadNode.getChild()) {
                    if ((nodeHeadNode.getKindSet() & iM3848constructorimpl) != 0) {
                        MutableVector mutableVector = null;
                        DelegatingNode delegatingNodePop = nodeHeadNode;
                        while (delegatingNodePop != 0) {
                            if (delegatingNodePop instanceof LayoutAwareModifierNode) {
                                ((LayoutAwareModifierNode) delegatingNodePop).mo684onRemeasuredozmzZPI(getMeasuredSize());
                            } else if ((delegatingNodePop.getKindSet() & iM3848constructorimpl) != 0 && (delegatingNodePop instanceof DelegatingNode)) {
                                Modifier.Node delegate$ui_release = delegatingNodePop.getDelegate();
                                int i = 0;
                                delegatingNodePop = delegatingNodePop;
                                while (delegate$ui_release != null) {
                                    if ((delegate$ui_release.getKindSet() & iM3848constructorimpl) != 0) {
                                        i++;
                                        if (i == 1) {
                                            delegatingNodePop = delegate$ui_release;
                                        } else {
                                            if (mutableVector == null) {
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (delegatingNodePop != 0) {
                                                if (mutableVector != null) {
                                                    mutableVector.add(delegatingNodePop);
                                                }
                                                delegatingNodePop = 0;
                                            }
                                            if (mutableVector != null) {
                                                mutableVector.add(delegate$ui_release);
                                            }
                                        }
                                    }
                                    delegate$ui_release = delegate$ui_release.getChild();
                                    delegatingNodePop = delegatingNodePop;
                                }
                                if (i == 1) {
                                }
                            }
                            delegatingNodePop = DelegatableNodeKt.pop(mutableVector);
                        }
                    }
                    if (nodeHeadNode == parent) {
                        break;
                    }
                }
                Unit unit2 = Unit.INSTANCE;
            } finally {
                companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void drawContainedDrawModifiers(Canvas canvas, GraphicsLayer graphicsLayer) {
        Modifier.Node nodeM3834headH91voCI = m3834headH91voCI(NodeKind.m3848constructorimpl(4));
        if (nodeM3834headH91voCI == null) {
            performDraw(canvas, graphicsLayer);
        } else {
            getLayoutNode().getMDrawScope$ui_release().m3775draweZhPAX0$ui_release(canvas, IntSizeKt.m4919toSizeozmzZPI(mo3621getSizeYbymL2g()), this, nodeM3834headH91voCI, graphicsLayer);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    public final void onPlaced() {
        int iM3848constructorimpl = NodeKind.m3848constructorimpl(128);
        boolean zM3857getIncludeSelfInTraversalH91voCI = NodeKindKt.m3857getIncludeSelfInTraversalH91voCI(iM3848constructorimpl);
        Modifier.Node tail = getTail();
        if (!zM3857getIncludeSelfInTraversalH91voCI && (tail = tail.getParent()) == null) {
            return;
        }
        for (Modifier.Node nodeHeadNode = headNode(zM3857getIncludeSelfInTraversalH91voCI); nodeHeadNode != null && (nodeHeadNode.getAggregateChildKindSet() & iM3848constructorimpl) != 0; nodeHeadNode = nodeHeadNode.getChild()) {
            if ((nodeHeadNode.getKindSet() & iM3848constructorimpl) != 0) {
                DelegatingNode delegatingNodePop = nodeHeadNode;
                MutableVector mutableVector = null;
                while (delegatingNodePop != 0) {
                    if (delegatingNodePop instanceof LayoutAwareModifierNode) {
                        ((LayoutAwareModifierNode) delegatingNodePop).onPlaced(this);
                    } else if ((delegatingNodePop.getKindSet() & iM3848constructorimpl) != 0 && (delegatingNodePop instanceof DelegatingNode)) {
                        Modifier.Node delegate$ui_release = delegatingNodePop.getDelegate();
                        int i = 0;
                        delegatingNodePop = delegatingNodePop;
                        while (delegate$ui_release != null) {
                            if ((delegate$ui_release.getKindSet() & iM3848constructorimpl) != 0) {
                                i++;
                                if (i == 1) {
                                    delegatingNodePop = delegate$ui_release;
                                } else {
                                    if (mutableVector == null) {
                                        mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                    }
                                    if (delegatingNodePop != 0) {
                                        if (mutableVector != null) {
                                            mutableVector.add(delegatingNodePop);
                                        }
                                        delegatingNodePop = 0;
                                    }
                                    if (mutableVector != null) {
                                        mutableVector.add(delegate$ui_release);
                                    }
                                }
                            }
                            delegate$ui_release = delegate$ui_release.getChild();
                            delegatingNodePop = delegatingNodePop;
                        }
                        if (i == 1) {
                        }
                    }
                    delegatingNodePop = DelegatableNodeKt.pop(mutableVector);
                }
            }
            if (nodeHeadNode == tail) {
                return;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    public final boolean shouldSharePointerInputWithSiblings() {
        Modifier.Node nodeHeadNode = headNode(NodeKindKt.m3857getIncludeSelfInTraversalH91voCI(NodeKind.m3848constructorimpl(16)));
        if (nodeHeadNode != null && nodeHeadNode.getIsAttached()) {
            Modifier.Node node = nodeHeadNode;
            int iM3848constructorimpl = NodeKind.m3848constructorimpl(16);
            if (!node.getNode().getIsAttached()) {
                InlineClassHelperKt.throwIllegalStateException("visitLocalDescendants called on an unattached node");
            }
            Modifier.Node node2 = node.getNode();
            if ((node2.getAggregateChildKindSet() & iM3848constructorimpl) != 0) {
                while (node2 != null) {
                    if ((node2.getKindSet() & iM3848constructorimpl) != 0) {
                        DelegatingNode delegatingNodePop = node2;
                        MutableVector mutableVector = null;
                        while (delegatingNodePop != 0) {
                            if (delegatingNodePop instanceof PointerInputModifierNode) {
                                if (((PointerInputModifierNode) delegatingNodePop).sharePointerInputWithSiblings()) {
                                    return true;
                                }
                            } else if ((delegatingNodePop.getKindSet() & iM3848constructorimpl) != 0 && (delegatingNodePop instanceof DelegatingNode)) {
                                Modifier.Node delegate$ui_release = delegatingNodePop.getDelegate();
                                int i = 0;
                                delegatingNodePop = delegatingNodePop;
                                while (delegate$ui_release != null) {
                                    if ((delegate$ui_release.getKindSet() & iM3848constructorimpl) != 0) {
                                        i++;
                                        if (i == 1) {
                                            delegatingNodePop = delegate$ui_release;
                                        } else {
                                            if (mutableVector == null) {
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (delegatingNodePop != 0) {
                                                if (mutableVector != null) {
                                                    mutableVector.add(delegatingNodePop);
                                                }
                                                delegatingNodePop = 0;
                                            }
                                            if (mutableVector != null) {
                                                mutableVector.add(delegate$ui_release);
                                            }
                                        }
                                    }
                                    delegate$ui_release = delegate$ui_release.getChild();
                                    delegatingNodePop = delegatingNodePop;
                                }
                                if (i == 1) {
                                }
                            }
                            delegatingNodePop = DelegatableNodeKt.pop(mutableVector);
                        }
                    }
                    node2 = node2.getChild();
                }
            }
        }
        return false;
    }
}
