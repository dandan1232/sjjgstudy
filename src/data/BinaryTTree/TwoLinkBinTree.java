package data.BinaryTTree;
public class TwoLinkBinTree<E> {

        public static class TreeNode{

            Object data;
            TreeNode left;
            TreeNode right;

            public TreeNode(){}

            public TreeNode(Object data){
                this.data = data;
            }

            public TreeNode(Object data, TreeNode left, TreeNode right) {
                this.data = data;
                this.left = left;
                this.right = right;
            }

        }

        private TreeNode root;

        //��Ĭ�ϵĹ���������
        public TwoLinkBinTree(){
            this.root = new TreeNode();
        }

        //��ָ����Ԫ�ش���
        public TwoLinkBinTree(E data){
            this.root = new TreeNode(data);
        }

        /**
         * Ϊָ���ڵ�����ӽڵ�
         * @param parent ��Ҫ��ӽڵ�ĸ��ڵ������
         * @param data ������ӽڵ������
         * @param isLeft �Ƿ���������ӽڵ�
         * @return �����Ľڵ�
         */
        public TreeNode addNode(TreeNode parent, E data, boolean isLeft){
            if(parent == null){
                throw new RuntimeException(parent + "�ڵ�Ϊ�գ���������ӽڵ㣡");
            }

            if(isLeft && parent.left != null){
                throw new RuntimeException(parent + "�ڵ��������ӽڵ㣬����������ӽڵ㣡");
            }

            if(!isLeft && parent.right != null){
                throw new RuntimeException(parent + "�ڵ��������ӽڵ㣬����������ӽڵ㣡");
            }

            TreeNode newNode = new TreeNode(data);
            if(isLeft){
                parent.left = newNode;
            }else{
                parent.right = newNode;
            }

            return newNode;
        }

        //�ж϶������Ƿ�Ϊ��
        public boolean isEmpty(){
            return root.data == null;
        }

        //��ȡ���ڵ�
        public TreeNode getRoot(){
            if(isEmpty()){
                throw new RuntimeException("��Ϊ�գ��޷���ȡ���ڵ㣡");
            }
            return root;
        }

        //��ȡָ���ڵ�����ӽڵ�
        public TreeNode getLeft(TreeNode parent){
            if(parent == null){
                throw new RuntimeException(parent + "�ڵ�Ϊ�գ����ܻ�ȡ�ӽڵ㣡");
            }

            return parent.left == null ? null : parent.left;
        }

        //��ȡָ���ڵ�����ӽڵ�
        public TreeNode getRight(TreeNode parent){
            if(parent == null){
                throw new RuntimeException(parent + "�ڵ�Ϊ�գ����ܻ�ȡ�ӽڵ㣡");
            }

            return parent.right == null ? null : parent.right;
        }

        //��ȡָ���ڵ�����
        private int getDeep(TreeNode node){
            if(node == null){
                return 0;
            }

            if(node.left == null && node.right == null){
                return 1;
            }else{
                int leftDeep = getDeep(node.left);
                int rightDeep = getDeep(node.right);

                int max = leftDeep > rightDeep ? leftDeep : rightDeep;
                return max + 1;
            }
        }

        public int getTreeDeep(){
            return this.getDeep(root);
        }

    }
