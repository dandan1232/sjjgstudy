package data.BinaryTTree;

public class BinaryTree2{
    public static void main(String[] args) {
        BinaryTree binaryTree=new BinaryTree();
        binaryTree.insert("A");
        binaryTree.insert(binaryTree.root,true,"B");
        binaryTree.insert(binaryTree.root,false,"C");
        binaryTree.insert(binaryTree.root.left,true,"D");
        binaryTree.insert(binaryTree.root.right,true,"E");
        binaryTree.insert(binaryTree.root.right,false,"F");
        binaryTree.insert(binaryTree.root.left.left,false,"G");
        binaryTree.insert(binaryTree.root.right.right,true,"H");

        System.out.println("�ȸ����������");
        binaryTree.preorder();
        System.out.println("�и����������");
        binaryTree.inorder();
        System.out.println("������������");
        binaryTree.postorder();
    }
}
