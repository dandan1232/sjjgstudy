//�����ݽṹ���㷨��Java�棩����5�棩�������ߣ�Ҷ���ǣ�2019��8��12��
//��7.2.2  ͼ���ڽӾ���洢�ṹ��ʵ��
//����7.1��  �����Ȩͼ��
//��7.2.3  ͼ���ڽӱ�洢�ṹ��ʵ��
//��7.3   ͼ�ı���
//��7.4.2   ��С�������Ĺ����㷨
//��7.5.1   ��Դ���·��
//��7.5.2 ÿ�Զ��������·��
//��ϰ����7-16�� Floyd�㷨
package data.PicGraph;

import data.Matrix.Triple;

public class G3u
{
    public static void main(String args[])
    {
    	//����7.1��  �����Ȩͼ��
        String[] vertexes={"A","B","C","D","E","F"};       //��Ȩ����ͼG3�Ķ��㼯��
        Triple[] edges={new Triple(0,1,45), new Triple(0,2,28), new Triple(0,3,10),
                        new Triple(1,0,45), new Triple(1,2,12), new Triple(1,4,21),
                        new Triple(2,0,28), new Triple(2,1,12), new Triple(2,3,17), new Triple(2,4,26),
                        new Triple(3,0,10), new Triple(3,2,17), new Triple(3,4,15), new Triple(3,5,13),
                        new Triple(4,1,21), new Triple(4,2,26), new Triple(4,3,15), new Triple(4,5,11),
                        new Triple(5,3,13), new Triple(5,4,11)};     //G3�ı߼���
        MatrixGraph<String> graph = new MatrixGraph<String>(vertexes, edges);  //�ڽӾ���洢��ͼ
        
//        MatrixGraph<String> graph = new MatrixGraph<String>();  //��ͼ�����²���
//        for(int i=0;  i<vertexes.length;  i++)
//            graph.insert(vertexes[i]);           //���붥��
//        for(int j=0;  j<edges.length;  j++)
//            graph.insert(edges[j]);              //�����
//        System.out.println("ͼ7.16����Ȩ����ͼG3��"+graph.toString());
        
        //��7.2.2  ͼ���ڽӱ�洢��ʵ��  //����7.1��  �����Ȩͼ��
        String edgestr="(0,1,45),(0,2,28),(0,3,10),(1,0,45),(1,2,12),(1,4,21),(2,0,28),(2,1,12),(2,3,17),(2,4,26),"+
                       "(3,0,10),(3,2,17),(3,4,15),(3,5,13),(4,1,21),(4,2,26),(4,3,15),(4,5,11),(5,3,13),(5,4,11)";//G3�ı߼���
//        AdjListGraph<String> graph = new AdjListGraph<String>(vertexes, edges);    //�ڽӱ�洢��ͼ
//        AdjListGraph<String> graph = new AdjListGraph<String>(vertexes, edgestr);//�ڽӱ�洢��ͼ
        System.out.println("ͼ7.18����Ȩ����ͼG3��"+graph.toString());

        //��2�����붥�㡢�����
        int i,j;
//        i=graph.insert("G");                     //���붥��
//        j=graph.insert("H");                     //���붥��
//        graph.insert(i,j,10);                    //�����
//        graph.insert(j,i,10);                    //�����
//        System.out.print("��Ȩ����ͼG3�����붥��"+graph.get(i)+"��");//+"�����붥��"+graph.get(j)+"��");
//        System.out.println(graph.toString());
        
        //��4��ɾ����
//      graph.remove(5,6);                   //ɾ���ߣ����Խ��
//        graph.remove(4,5);                   //ɾ����(E,F,11)
//        graph.remove(new Triple(5,4,0));     //ɾ����(F,E,11)
//        System.out.print("ɾ����(E,F,11)\nͼ7.23����ͼG1��"+graph.toString());

        //��5��ɾ������
//        i=3;
//        System.out.print("ͼ7.16����Ȩ����ͼG3��ɾ������"+graph.get(i));
//        graph.remove(i);                         //ɾ������

        
        //��7.3   ͼ�ı���
        //����ͼG1��F���㣬û��(E,F)�ߣ�û�ж���G�����³���������G��Ϊ�˲��Է���ͨͼ
        i=0;
        System.out.println("������ȱ�������ͼG1��");  //ͼ7.23 A����˼����7-3���������У�������
//        for(i=0;  i<graph.vertexCount();  i++)
            graph.DFSTraverse(i);

//        System.out.println("������ȱ�������ͼG1��");  //ͼ7.26 A
//        for(i=0;  i<graph.vertexCount();  i++)
//            graph.BFSTraverse(i);

        //��7.4.2   ��С�������Ĺ����㷨
//        System.out.println("��Ȩ����ͼG3��prim�㷨");
//        graph.minSpanTree();                //prim

        //7.5.1   �Ǹ�Ȩֵ�ĵ�Դ���·����Dijkstra�㷨��
//        System.out.println("��Ȩ����ͼG3��Dijkstra�㷨");
//        for(i=0;  i<graph.vertexCount();  i++)       //ͼ10.6
//            graph.shortestPath(i);               //����vi�ĵ�Դ���·����Dijkstra�㷨
        

      //��7.5.2  ��Floyd�㷨���Ȩͼÿ�Զ��������·����//ϰ����
//        System.out.println("��Ȩ����ͼG3��Floyd�㷨");
//        graph.shortestPath();                    //����Floyd�㷨���Ȩͼÿ�Զ��������·��
        
/*        //ϰ��7
        System.out.print("��"+graph.edgeCount()+"���ߣ�");
        i=0;
        System.out.println("����"+graph.get(i)+"�������"+graph.indegree(i)+
                                               "��������"+graph.outdegree(i));
*/ 
    }
}
/*          //��2�����붥�㣨3������� //�����ǵ�4��ģ���5��̲�ûд
int i=graph.insertVertex("F");           //���붥��F������
//System.out.println("ͼ7.17�����붥��F�����Ϊ"+i+"���������(D,F,13)��(E,F,11)");
graph.insertEdge(3,i,13);                //�����(D,F,13)
//graph.insertEdge(i,3,13);                //�����(F,D,13)
graph.insertEdge(new Triple(i,3,13));    //�����(F,D,13)
graph.insertEdge(4,i,11);                //�����(E,F,11)
graph.insertEdge(i,4,11);                //�����(F,E,11)
//graph.insertEdge(new Triple(i,4,11));  //�����(F,E,11)
//System.out.println("��Ȩ����ͼG3��"+graph.toString());
//graph.insertEdge(5,6,0);               //����ߣ����Խ��
*/        
//@author��Yeheya��2014��7��24�գ�2015-11-15��2019��10��27��