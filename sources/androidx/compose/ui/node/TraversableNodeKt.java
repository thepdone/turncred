package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Actual_jvmKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.TraversableNode;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TraversableNode.kt */
@Metadata(d1 = {"\u0000.\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u001b\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u0002H\u0001¢\u0006\u0002\u0010\u0003\u001a\u0016\u0010\u0000\u001a\u0004\u0018\u00010\u0002*\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u001a-\u0010\u0007\u001a\u00020\b\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u0002H\u00012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\f\u001a(\u0010\u0007\u001a\u00020\b*\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\n\u001a-\u0010\r\u001a\u00020\b\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u0002H\u00012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\f\u001a(\u0010\r\u001a\u00020\b*\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\n\u001a-\u0010\u000e\u001a\u00020\b\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u0002H\u00012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u000f0\n¢\u0006\u0002\u0010\f\u001a(\u0010\u000e\u001a\u00020\b*\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f0\n¨\u0006\u0010"}, d2 = {"findNearestAncestor", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/ui/node/TraversableNode;", "(Landroidx/compose/ui/node/TraversableNode;)Landroidx/compose/ui/node/TraversableNode;", "Landroidx/compose/ui/node/DelegatableNode;", SDKConstants.PARAM_KEY, "", "traverseAncestors", "", "block", "Lkotlin/Function1;", "", "(Landroidx/compose/ui/node/TraversableNode;Lkotlin/jvm/functions/Function1;)V", "traverseChildren", "traverseDescendants", "Landroidx/compose/ui/node/TraversableNode$Companion$TraverseDescendantsAction;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TraversableNodeKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v11, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v9 */
    public static final <T extends TraversableNode> T findNearestAncestor(T t) {
        NodeChain nodes;
        T t2 = t;
        int iM3848constructorimpl = NodeKind.m3848constructorimpl(262144);
        if (!t2.getNode().getIsAttached()) {
            throw new IllegalStateException("visitAncestors called on an unattached node".toString());
        }
        Modifier.Node parent = t2.getNode().getParent();
        LayoutNode layoutNodeRequireLayoutNode = DelegatableNodeKt.requireLayoutNode(t2);
        while (layoutNodeRequireLayoutNode != null) {
            if ((layoutNodeRequireLayoutNode.getNodes().getHead().getAggregateChildKindSet() & iM3848constructorimpl) != 0) {
                while (parent != null) {
                    if ((parent.getKindSet() & iM3848constructorimpl) != 0) {
                        DelegatingNode delegatingNodePop = parent;
                        MutableVector mutableVector = null;
                        while (delegatingNodePop != 0) {
                            if (delegatingNodePop instanceof TraversableNode) {
                                T t3 = (T) delegatingNodePop;
                                if (Intrinsics.areEqual(t.getTraverseKey(), t3.getTraverseKey()) && Actual_jvmKt.areObjectsOfSameType(t, t3)) {
                                    return t3;
                                }
                            } else if ((delegatingNodePop.getKindSet() & iM3848constructorimpl) != 0 && (delegatingNodePop instanceof DelegatingNode)) {
                                Modifier.Node delegate = delegatingNodePop.getDelegate();
                                int i = 0;
                                delegatingNodePop = delegatingNodePop;
                                while (delegate != null) {
                                    if ((delegate.getKindSet() & iM3848constructorimpl) != 0) {
                                        i++;
                                        if (i == 1) {
                                            delegatingNodePop = delegate;
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
                                                mutableVector.add(delegate);
                                            }
                                        }
                                    }
                                    delegate = delegate.getChild();
                                    delegatingNodePop = delegatingNodePop;
                                }
                                if (i == 1) {
                                }
                            }
                            delegatingNodePop = DelegatableNodeKt.pop(mutableVector);
                        }
                    }
                    parent = parent.getParent();
                }
            }
            layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui_release();
            parent = (layoutNodeRequireLayoutNode == null || (nodes = layoutNodeRequireLayoutNode.getNodes()) == null) ? null : nodes.getTail();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r3v13, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7, types: [androidx.compose.ui.Modifier$Node] */
    public static final <T extends TraversableNode> void traverseAncestors(T t, Function1<? super T, Boolean> function1) {
        NodeChain nodes;
        T t2 = t;
        int iM3848constructorimpl = NodeKind.m3848constructorimpl(262144);
        if (!t2.getNode().getIsAttached()) {
            throw new IllegalStateException("visitAncestors called on an unattached node".toString());
        }
        Modifier.Node parent = t2.getNode().getParent();
        LayoutNode layoutNodeRequireLayoutNode = DelegatableNodeKt.requireLayoutNode(t2);
        while (layoutNodeRequireLayoutNode != null) {
            if ((layoutNodeRequireLayoutNode.getNodes().getHead().getAggregateChildKindSet() & iM3848constructorimpl) != 0) {
                while (parent != null) {
                    if ((parent.getKindSet() & iM3848constructorimpl) != 0) {
                        DelegatingNode delegatingNodePop = parent;
                        MutableVector mutableVector = null;
                        while (delegatingNodePop != 0) {
                            boolean zBooleanValue = true;
                            if (delegatingNodePop instanceof TraversableNode) {
                                TraversableNode traversableNode = (TraversableNode) delegatingNodePop;
                                if (Intrinsics.areEqual(t.getTraverseKey(), traversableNode.getTraverseKey()) && Actual_jvmKt.areObjectsOfSameType(t, traversableNode)) {
                                    zBooleanValue = function1.invoke(traversableNode).booleanValue();
                                }
                                if (!zBooleanValue) {
                                    return;
                                }
                            } else if ((delegatingNodePop.getKindSet() & iM3848constructorimpl) != 0 && (delegatingNodePop instanceof DelegatingNode)) {
                                Modifier.Node delegate = delegatingNodePop.getDelegate();
                                int i = 0;
                                delegatingNodePop = delegatingNodePop;
                                while (delegate != null) {
                                    if ((delegate.getKindSet() & iM3848constructorimpl) != 0) {
                                        i++;
                                        if (i == 1) {
                                            delegatingNodePop = delegate;
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
                                                mutableVector.add(delegate);
                                            }
                                        }
                                    }
                                    delegate = delegate.getChild();
                                    delegatingNodePop = delegatingNodePop;
                                }
                                if (i == 1) {
                                }
                            }
                            delegatingNodePop = DelegatableNodeKt.pop(mutableVector);
                        }
                    }
                    parent = parent.getParent();
                }
            }
            layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui_release();
            parent = (layoutNodeRequireLayoutNode == null || (nodes = layoutNodeRequireLayoutNode.getNodes()) == null) ? null : nodes.getTail();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x0032, code lost:
    
        continue;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r0v17, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v22, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v6, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r0v7, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r0v8, types: [androidx.compose.ui.Modifier$Node] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T extends androidx.compose.ui.node.TraversableNode> void traverseChildren(T r11, kotlin.jvm.functions.Function1<? super T, java.lang.Boolean> r12) {
        /*
            r0 = r11
            androidx.compose.ui.node.DelegatableNode r0 = (androidx.compose.ui.node.DelegatableNode) r0
            r1 = 262144(0x40000, float:3.67342E-40)
            int r1 = androidx.compose.ui.node.NodeKind.m3848constructorimpl(r1)
            androidx.compose.ui.Modifier$Node r2 = r0.getNode()
            boolean r2 = r2.getIsAttached()
            if (r2 == 0) goto Ld6
            androidx.compose.runtime.collection.MutableVector r2 = new androidx.compose.runtime.collection.MutableVector
            r3 = 16
            androidx.compose.ui.Modifier$Node[] r4 = new androidx.compose.ui.Modifier.Node[r3]
            r5 = 0
            r2.<init>(r4, r5)
            androidx.compose.ui.Modifier$Node r4 = r0.getNode()
            androidx.compose.ui.Modifier$Node r4 = r4.getChild()
            if (r4 != 0) goto L2f
            androidx.compose.ui.Modifier$Node r0 = r0.getNode()
            androidx.compose.ui.node.DelegatableNodeKt.access$addLayoutNodeChildren(r2, r0)
            goto L32
        L2f:
            r2.add(r4)
        L32:
            boolean r0 = r2.isNotEmpty()
            if (r0 == 0) goto Ld5
            int r0 = r2.getSize()
            r4 = 1
            int r0 = r0 - r4
            java.lang.Object r0 = r2.removeAt(r0)
            androidx.compose.ui.Modifier$Node r0 = (androidx.compose.ui.Modifier.Node) r0
            int r6 = r0.getAggregateChildKindSet()
            r6 = r6 & r1
            if (r6 != 0) goto L4f
            androidx.compose.ui.node.DelegatableNodeKt.access$addLayoutNodeChildren(r2, r0)
            goto L32
        L4f:
            if (r0 == 0) goto L32
            int r6 = r0.getKindSet()
            r6 = r6 & r1
            if (r6 == 0) goto Lcf
            r6 = 0
            r7 = r6
        L5a:
            if (r0 == 0) goto L32
            boolean r8 = r0 instanceof androidx.compose.ui.node.TraversableNode
            if (r8 == 0) goto L85
            androidx.compose.ui.node.TraversableNode r0 = (androidx.compose.ui.node.TraversableNode) r0
            java.lang.Object r8 = r11.getTraverseKey()
            java.lang.Object r9 = r0.getTraverseKey()
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual(r8, r9)
            if (r8 == 0) goto L81
            boolean r8 = androidx.compose.ui.Actual_jvmKt.areObjectsOfSameType(r11, r0)
            if (r8 == 0) goto L81
            java.lang.Object r0 = r12.invoke(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            goto L82
        L81:
            r0 = r4
        L82:
            if (r0 != 0) goto Lca
            return
        L85:
            int r8 = r0.getKindSet()
            r8 = r8 & r1
            if (r8 == 0) goto Lca
            boolean r8 = r0 instanceof androidx.compose.ui.node.DelegatingNode
            if (r8 == 0) goto Lca
            r8 = r0
            androidx.compose.ui.node.DelegatingNode r8 = (androidx.compose.ui.node.DelegatingNode) r8
            androidx.compose.ui.Modifier$Node r8 = r8.getDelegate()
            r9 = r5
        L98:
            if (r8 == 0) goto Lc7
            int r10 = r8.getKindSet()
            r10 = r10 & r1
            if (r10 == 0) goto La3
            r10 = r4
            goto La4
        La3:
            r10 = r5
        La4:
            if (r10 == 0) goto Lc2
            int r9 = r9 + 1
            if (r9 != r4) goto Lac
            r0 = r8
            goto Lc2
        Lac:
            if (r7 != 0) goto Lb5
            androidx.compose.runtime.collection.MutableVector r7 = new androidx.compose.runtime.collection.MutableVector
            androidx.compose.ui.Modifier$Node[] r10 = new androidx.compose.ui.Modifier.Node[r3]
            r7.<init>(r10, r5)
        Lb5:
            if (r0 == 0) goto Lbd
            if (r7 == 0) goto Lbc
            r7.add(r0)
        Lbc:
            r0 = r6
        Lbd:
            if (r7 == 0) goto Lc2
            r7.add(r8)
        Lc2:
            androidx.compose.ui.Modifier$Node r8 = r8.getChild()
            goto L98
        Lc7:
            if (r9 != r4) goto Lca
            goto L5a
        Lca:
            androidx.compose.ui.Modifier$Node r0 = androidx.compose.ui.node.DelegatableNodeKt.access$pop(r7)
            goto L5a
        Lcf:
            androidx.compose.ui.Modifier$Node r0 = r0.getChild()
            goto L4f
        Ld5:
            return
        Ld6:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "visitChildren called on an unattached node"
            java.lang.String r12 = r12.toString()
            r11.<init>(r12)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.TraversableNodeKt.traverseChildren(androidx.compose.ui.node.TraversableNode, kotlin.jvm.functions.Function1):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r8v9, types: [java.lang.Object] */
    public static final <T extends TraversableNode> void traverseDescendants(T t, Function1<? super T, ? extends TraversableNode.Companion.TraverseDescendantsAction> function1) {
        TraversableNode.Companion.TraverseDescendantsAction traverseDescendantsActionInvoke;
        T t2 = t;
        int iM3848constructorimpl = NodeKind.m3848constructorimpl(262144);
        if (!t2.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitSubtreeIf called on an unattached node");
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child = t2.getNode().getChild();
        if (child == null) {
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector, t2.getNode());
        } else {
            mutableVector.add(child);
        }
        while (mutableVector.isNotEmpty()) {
            Modifier.Node node = (Modifier.Node) mutableVector.removeAt(mutableVector.getSize() - 1);
            if ((node.getAggregateChildKindSet() & iM3848constructorimpl) != 0) {
                for (Modifier.Node child2 = node; child2 != null; child2 = child2.getChild()) {
                    if ((child2.getKindSet() & iM3848constructorimpl) != 0) {
                        DelegatingNode delegatingNodePop = child2;
                        MutableVector mutableVector2 = null;
                        while (delegatingNodePop != 0) {
                            if (delegatingNodePop instanceof TraversableNode) {
                                TraversableNode traversableNode = (TraversableNode) delegatingNodePop;
                                if (Intrinsics.areEqual(t.getTraverseKey(), traversableNode.getTraverseKey()) && Actual_jvmKt.areObjectsOfSameType(t, traversableNode)) {
                                    traverseDescendantsActionInvoke = function1.invoke(traversableNode);
                                } else {
                                    traverseDescendantsActionInvoke = TraversableNode.Companion.TraverseDescendantsAction.ContinueTraversal;
                                }
                                if (traverseDescendantsActionInvoke == TraversableNode.Companion.TraverseDescendantsAction.CancelTraversal) {
                                    return;
                                }
                                if (traverseDescendantsActionInvoke == TraversableNode.Companion.TraverseDescendantsAction.SkipSubtreeAndContinueTraversal) {
                                    break;
                                }
                            } else if ((delegatingNodePop.getKindSet() & iM3848constructorimpl) != 0 && (delegatingNodePop instanceof DelegatingNode)) {
                                Modifier.Node delegate = delegatingNodePop.getDelegate();
                                int i = 0;
                                delegatingNodePop = delegatingNodePop;
                                while (delegate != null) {
                                    if ((delegate.getKindSet() & iM3848constructorimpl) != 0) {
                                        i++;
                                        if (i == 1) {
                                            delegatingNodePop = delegate;
                                        } else {
                                            if (mutableVector2 == null) {
                                                mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (delegatingNodePop != 0) {
                                                if (mutableVector2 != null) {
                                                    mutableVector2.add(delegatingNodePop);
                                                }
                                                delegatingNodePop = 0;
                                            }
                                            if (mutableVector2 != null) {
                                                mutableVector2.add(delegate);
                                            }
                                        }
                                    }
                                    delegate = delegate.getChild();
                                    delegatingNodePop = delegatingNodePop;
                                }
                                if (i == 1) {
                                }
                            }
                            delegatingNodePop = DelegatableNodeKt.pop(mutableVector2);
                        }
                    }
                }
            }
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector, node);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r3v11, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r3v9 */
    public static final TraversableNode findNearestAncestor(DelegatableNode delegatableNode, Object obj) {
        NodeChain nodes;
        int iM3848constructorimpl = NodeKind.m3848constructorimpl(262144);
        if (!delegatableNode.getNode().getIsAttached()) {
            throw new IllegalStateException("visitAncestors called on an unattached node".toString());
        }
        Modifier.Node parent = delegatableNode.getNode().getParent();
        LayoutNode layoutNodeRequireLayoutNode = DelegatableNodeKt.requireLayoutNode(delegatableNode);
        while (layoutNodeRequireLayoutNode != null) {
            if ((layoutNodeRequireLayoutNode.getNodes().getHead().getAggregateChildKindSet() & iM3848constructorimpl) != 0) {
                while (parent != null) {
                    if ((parent.getKindSet() & iM3848constructorimpl) != 0) {
                        DelegatingNode delegatingNodePop = parent;
                        MutableVector mutableVector = null;
                        while (delegatingNodePop != 0) {
                            if (delegatingNodePop instanceof TraversableNode) {
                                TraversableNode traversableNode = (TraversableNode) delegatingNodePop;
                                if (Intrinsics.areEqual(obj, traversableNode.getTraverseKey())) {
                                    return traversableNode;
                                }
                            } else if ((delegatingNodePop.getKindSet() & iM3848constructorimpl) != 0 && (delegatingNodePop instanceof DelegatingNode)) {
                                Modifier.Node delegate = delegatingNodePop.getDelegate();
                                int i = 0;
                                delegatingNodePop = delegatingNodePop;
                                while (delegate != null) {
                                    if ((delegate.getKindSet() & iM3848constructorimpl) != 0) {
                                        i++;
                                        if (i == 1) {
                                            delegatingNodePop = delegate;
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
                                                mutableVector.add(delegate);
                                            }
                                        }
                                    }
                                    delegate = delegate.getChild();
                                    delegatingNodePop = delegatingNodePop;
                                }
                                if (i == 1) {
                                }
                            }
                            delegatingNodePop = DelegatableNodeKt.pop(mutableVector);
                        }
                    }
                    parent = parent.getParent();
                }
            }
            layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui_release();
            parent = (layoutNodeRequireLayoutNode == null || (nodes = layoutNodeRequireLayoutNode.getNodes()) == null) ? null : nodes.getTail();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v13, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [androidx.compose.ui.Modifier$Node] */
    public static final void traverseAncestors(DelegatableNode delegatableNode, Object obj, Function1<? super TraversableNode, Boolean> function1) {
        NodeChain nodes;
        int iM3848constructorimpl = NodeKind.m3848constructorimpl(262144);
        if (!delegatableNode.getNode().getIsAttached()) {
            throw new IllegalStateException("visitAncestors called on an unattached node".toString());
        }
        Modifier.Node parent = delegatableNode.getNode().getParent();
        LayoutNode layoutNodeRequireLayoutNode = DelegatableNodeKt.requireLayoutNode(delegatableNode);
        while (layoutNodeRequireLayoutNode != null) {
            if ((layoutNodeRequireLayoutNode.getNodes().getHead().getAggregateChildKindSet() & iM3848constructorimpl) != 0) {
                while (parent != null) {
                    if ((parent.getKindSet() & iM3848constructorimpl) != 0) {
                        DelegatingNode delegatingNodePop = parent;
                        MutableVector mutableVector = null;
                        while (delegatingNodePop != 0) {
                            if (delegatingNodePop instanceof TraversableNode) {
                                TraversableNode traversableNode = (TraversableNode) delegatingNodePop;
                                if (!(Intrinsics.areEqual(obj, traversableNode.getTraverseKey()) ? function1.invoke(traversableNode).booleanValue() : true)) {
                                    return;
                                }
                            } else if ((delegatingNodePop.getKindSet() & iM3848constructorimpl) != 0 && (delegatingNodePop instanceof DelegatingNode)) {
                                Modifier.Node delegate = delegatingNodePop.getDelegate();
                                int i = 0;
                                delegatingNodePop = delegatingNodePop;
                                while (delegate != null) {
                                    if ((delegate.getKindSet() & iM3848constructorimpl) != 0) {
                                        i++;
                                        if (i == 1) {
                                            delegatingNodePop = delegate;
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
                                                mutableVector.add(delegate);
                                            }
                                        }
                                    }
                                    delegate = delegate.getChild();
                                    delegatingNodePop = delegatingNodePop;
                                }
                                if (i == 1) {
                                }
                            }
                            delegatingNodePop = DelegatableNodeKt.pop(mutableVector);
                        }
                    }
                    parent = parent.getParent();
                }
            }
            layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui_release();
            parent = (layoutNodeRequireLayoutNode == null || (nodes = layoutNodeRequireLayoutNode.getNodes()) == null) ? null : nodes.getTail();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x002f, code lost:
    
        continue;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v16, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r10v17, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r10v19 */
    /* JADX WARN: Type inference failed for: r10v20 */
    /* JADX WARN: Type inference failed for: r10v21 */
    /* JADX WARN: Type inference failed for: r10v22, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r10v24 */
    /* JADX WARN: Type inference failed for: r10v25 */
    /* JADX WARN: Type inference failed for: r10v6, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r10v7, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r10v8, types: [androidx.compose.ui.Modifier$Node] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void traverseChildren(androidx.compose.ui.node.DelegatableNode r10, java.lang.Object r11, kotlin.jvm.functions.Function1<? super androidx.compose.ui.node.TraversableNode, java.lang.Boolean> r12) {
        /*
            r0 = 262144(0x40000, float:3.67342E-40)
            int r0 = androidx.compose.ui.node.NodeKind.m3848constructorimpl(r0)
            androidx.compose.ui.Modifier$Node r1 = r10.getNode()
            boolean r1 = r1.getIsAttached()
            if (r1 == 0) goto Lc8
            androidx.compose.runtime.collection.MutableVector r1 = new androidx.compose.runtime.collection.MutableVector
            r2 = 16
            androidx.compose.ui.Modifier$Node[] r3 = new androidx.compose.ui.Modifier.Node[r2]
            r4 = 0
            r1.<init>(r3, r4)
            androidx.compose.ui.Modifier$Node r3 = r10.getNode()
            androidx.compose.ui.Modifier$Node r3 = r3.getChild()
            if (r3 != 0) goto L2c
            androidx.compose.ui.Modifier$Node r10 = r10.getNode()
            androidx.compose.ui.node.DelegatableNodeKt.access$addLayoutNodeChildren(r1, r10)
            goto L2f
        L2c:
            r1.add(r3)
        L2f:
            boolean r10 = r1.isNotEmpty()
            if (r10 == 0) goto Lc7
            int r10 = r1.getSize()
            r3 = 1
            int r10 = r10 - r3
            java.lang.Object r10 = r1.removeAt(r10)
            androidx.compose.ui.Modifier$Node r10 = (androidx.compose.ui.Modifier.Node) r10
            int r5 = r10.getAggregateChildKindSet()
            r5 = r5 & r0
            if (r5 != 0) goto L4c
            androidx.compose.ui.node.DelegatableNodeKt.access$addLayoutNodeChildren(r1, r10)
            goto L2f
        L4c:
            if (r10 == 0) goto L2f
            int r5 = r10.getKindSet()
            r5 = r5 & r0
            if (r5 == 0) goto Lc2
            r5 = 0
            r6 = r5
        L57:
            if (r10 == 0) goto L2f
            boolean r7 = r10 instanceof androidx.compose.ui.node.TraversableNode
            if (r7 == 0) goto L78
            androidx.compose.ui.node.TraversableNode r10 = (androidx.compose.ui.node.TraversableNode) r10
            java.lang.Object r7 = r10.getTraverseKey()
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual(r11, r7)
            if (r7 == 0) goto L74
            java.lang.Object r10 = r12.invoke(r10)
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            goto L75
        L74:
            r10 = r3
        L75:
            if (r10 != 0) goto Lbd
            return
        L78:
            int r7 = r10.getKindSet()
            r7 = r7 & r0
            if (r7 == 0) goto Lbd
            boolean r7 = r10 instanceof androidx.compose.ui.node.DelegatingNode
            if (r7 == 0) goto Lbd
            r7 = r10
            androidx.compose.ui.node.DelegatingNode r7 = (androidx.compose.ui.node.DelegatingNode) r7
            androidx.compose.ui.Modifier$Node r7 = r7.getDelegate()
            r8 = r4
        L8b:
            if (r7 == 0) goto Lba
            int r9 = r7.getKindSet()
            r9 = r9 & r0
            if (r9 == 0) goto L96
            r9 = r3
            goto L97
        L96:
            r9 = r4
        L97:
            if (r9 == 0) goto Lb5
            int r8 = r8 + 1
            if (r8 != r3) goto L9f
            r10 = r7
            goto Lb5
        L9f:
            if (r6 != 0) goto La8
            androidx.compose.runtime.collection.MutableVector r6 = new androidx.compose.runtime.collection.MutableVector
            androidx.compose.ui.Modifier$Node[] r9 = new androidx.compose.ui.Modifier.Node[r2]
            r6.<init>(r9, r4)
        La8:
            if (r10 == 0) goto Lb0
            if (r6 == 0) goto Laf
            r6.add(r10)
        Laf:
            r10 = r5
        Lb0:
            if (r6 == 0) goto Lb5
            r6.add(r7)
        Lb5:
            androidx.compose.ui.Modifier$Node r7 = r7.getChild()
            goto L8b
        Lba:
            if (r8 != r3) goto Lbd
            goto L57
        Lbd:
            androidx.compose.ui.Modifier$Node r10 = androidx.compose.ui.node.DelegatableNodeKt.access$pop(r6)
            goto L57
        Lc2:
            androidx.compose.ui.Modifier$Node r10 = r10.getChild()
            goto L4c
        Lc7:
            return
        Lc8:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "visitChildren called on an unattached node"
            java.lang.String r11 = r11.toString()
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.TraversableNodeKt.traverseChildren(androidx.compose.ui.node.DelegatableNode, java.lang.Object, kotlin.jvm.functions.Function1):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r7v9, types: [java.lang.Object] */
    public static final void traverseDescendants(DelegatableNode delegatableNode, Object obj, Function1<? super TraversableNode, ? extends TraversableNode.Companion.TraverseDescendantsAction> function1) {
        TraversableNode.Companion.TraverseDescendantsAction traverseDescendantsActionInvoke;
        int iM3848constructorimpl = NodeKind.m3848constructorimpl(262144);
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitSubtreeIf called on an unattached node");
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child = delegatableNode.getNode().getChild();
        if (child == null) {
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector, delegatableNode.getNode());
        } else {
            mutableVector.add(child);
        }
        while (mutableVector.isNotEmpty()) {
            Modifier.Node node = (Modifier.Node) mutableVector.removeAt(mutableVector.getSize() - 1);
            if ((node.getAggregateChildKindSet() & iM3848constructorimpl) != 0) {
                for (Modifier.Node child2 = node; child2 != null; child2 = child2.getChild()) {
                    if ((child2.getKindSet() & iM3848constructorimpl) != 0) {
                        DelegatingNode delegatingNodePop = child2;
                        MutableVector mutableVector2 = null;
                        while (delegatingNodePop != 0) {
                            if (delegatingNodePop instanceof TraversableNode) {
                                TraversableNode traversableNode = (TraversableNode) delegatingNodePop;
                                if (Intrinsics.areEqual(obj, traversableNode.getTraverseKey())) {
                                    traverseDescendantsActionInvoke = function1.invoke(traversableNode);
                                } else {
                                    traverseDescendantsActionInvoke = TraversableNode.Companion.TraverseDescendantsAction.ContinueTraversal;
                                }
                                if (traverseDescendantsActionInvoke == TraversableNode.Companion.TraverseDescendantsAction.CancelTraversal) {
                                    return;
                                }
                                if (traverseDescendantsActionInvoke == TraversableNode.Companion.TraverseDescendantsAction.SkipSubtreeAndContinueTraversal) {
                                    break;
                                }
                            } else if ((delegatingNodePop.getKindSet() & iM3848constructorimpl) != 0 && (delegatingNodePop instanceof DelegatingNode)) {
                                Modifier.Node delegate = delegatingNodePop.getDelegate();
                                int i = 0;
                                delegatingNodePop = delegatingNodePop;
                                while (delegate != null) {
                                    if ((delegate.getKindSet() & iM3848constructorimpl) != 0) {
                                        i++;
                                        if (i == 1) {
                                            delegatingNodePop = delegate;
                                        } else {
                                            if (mutableVector2 == null) {
                                                mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (delegatingNodePop != 0) {
                                                if (mutableVector2 != null) {
                                                    mutableVector2.add(delegatingNodePop);
                                                }
                                                delegatingNodePop = 0;
                                            }
                                            if (mutableVector2 != null) {
                                                mutableVector2.add(delegate);
                                            }
                                        }
                                    }
                                    delegate = delegate.getChild();
                                    delegatingNodePop = delegatingNodePop;
                                }
                                if (i == 1) {
                                }
                            }
                            delegatingNodePop = DelegatableNodeKt.pop(mutableVector2);
                        }
                    }
                }
            }
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector, node);
        }
    }
}
