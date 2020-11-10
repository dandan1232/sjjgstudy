package data.BinaryTTree;
import org.junit.Test;
public class TwoLinkBinTreeTest {

    @Test
    public void test() {
        TwoLinkBinTree<String> binTree = new TwoLinkBinTree<String>("��");

        TwoLinkBinTree.TreeNode node1 = binTree.addNode(binTree.getRoot(), "����", true);
        TwoLinkBinTree.TreeNode node2 = binTree.addNode(binTree.getRoot(), "����", false);
        TwoLinkBinTree.TreeNode node3 = binTree.addNode(node2, "������", true);
        TwoLinkBinTree.TreeNode node4 = binTree.addNode(node2, "������", false);
        TwoLinkBinTree.TreeNode node5 = binTree.addNode(node4, "��������", true);
        TwoLinkBinTree.TreeNode node6 = binTree.addNode(node3, "��������", false);
        TwoLinkBinTree.TreeNode node7 = binTree.addNode(node6, "����������", false);

        System.out.println("node2�����ӽڵ㣺" + binTree.getLeft(node2).data);
        System.out.println("node2�����ӽڵ㣺" + binTree.getRight(node2).data);

        System.out.println("������ȣ�" + binTree.getTreeDeep());

    }

}