//《数据结构与算法（Java版）（第5版）》，作者：叶核亚，2019年8月12日
//§7.2.2  图的邻接矩阵存储结构和实现
//【例7.1】  构造带权图。
//§7.2.3  图的邻接表存储结构和实现
//§7.3   图的遍历
//§7.4.2   最小生成树的构造算法
//§7.5.1   单源最短路径
//§7.5.2 每对顶点间的最短路径
//【习题解答7-16】 Floyd算法
package data.PicGraph;

import data.Matrix.Triple;

public class G3u
{
    public static void main(String args[])
    {
    	//【例7.1】  构造带权图。
        String[] vertexes={"A","B","C","D","E","F"};       //带权无向图G3的顶点集合
        Triple[] edges={new Triple(0,1,45), new Triple(0,2,28), new Triple(0,3,10),
                        new Triple(1,0,45), new Triple(1,2,12), new Triple(1,4,21),
                        new Triple(2,0,28), new Triple(2,1,12), new Triple(2,3,17), new Triple(2,4,26),
                        new Triple(3,0,10), new Triple(3,2,17), new Triple(3,4,15), new Triple(3,5,13),
                        new Triple(4,1,21), new Triple(4,2,26), new Triple(4,3,15), new Triple(4,5,11),
                        new Triple(5,3,13), new Triple(5,4,11)};     //G3的边集合
        MatrixGraph<String> graph = new MatrixGraph<String>(vertexes, edges);  //邻接矩阵存储的图
        
//        MatrixGraph<String> graph = new MatrixGraph<String>();  //空图，以下测试
//        for(int i=0;  i<vertexes.length;  i++)
//            graph.insert(vertexes[i]);           //插入顶点
//        for(int j=0;  j<edges.length;  j++)
//            graph.insert(edges[j]);              //插入边
//        System.out.println("图7.16，带权无向图G3，"+graph.toString());
        
        //§7.2.2  图的邻接表存储和实现  //【例7.1】  构造带权图。
        String edgestr="(0,1,45),(0,2,28),(0,3,10),(1,0,45),(1,2,12),(1,4,21),(2,0,28),(2,1,12),(2,3,17),(2,4,26),"+
                       "(3,0,10),(3,2,17),(3,4,15),(3,5,13),(4,1,21),(4,2,26),(4,3,15),(4,5,11),(5,3,13),(5,4,11)";//G3的边集合
//        AdjListGraph<String> graph = new AdjListGraph<String>(vertexes, edges);    //邻接表存储的图
//        AdjListGraph<String> graph = new AdjListGraph<String>(vertexes, edgestr);//邻接表存储的图
        System.out.println("图7.18，带权无向图G3，"+graph.toString());

        //（2）插入顶点、插入边
        int i,j;
//        i=graph.insert("G");                     //插入顶点
//        j=graph.insert("H");                     //插入顶点
//        graph.insert(i,j,10);                    //插入边
//        graph.insert(j,i,10);                    //插入边
//        System.out.print("带权无向图G3，插入顶点"+graph.get(i)+"，");//+"，插入顶点"+graph.get(j)+"，");
//        System.out.println(graph.toString());
        
        //（4）删除边
//      graph.remove(5,6);                   //删除边，序号越界
//        graph.remove(4,5);                   //删除边(E,F,11)
//        graph.remove(new Triple(5,4,0));     //删除边(F,E,11)
//        System.out.print("删除边(E,F,11)\n图7.23无向图G1，"+graph.toString());

        //（5）删除顶点
//        i=3;
//        System.out.print("图7.16，带权无向图G3，删除顶点"+graph.get(i));
//        graph.remove(i);                         //删除顶点

        
        //§7.3   图的遍历
        //无向图G1：F顶点，没有(E,F)边，没有顶点G；以下程序运行有G，为了测试非连通图
        i=0;
        System.out.println("深度优先遍历无向图G1：");  //图7.23 A，【思考题7-3】遍历序列，生成树
//        for(i=0;  i<graph.vertexCount();  i++)
            graph.DFSTraverse(i);

//        System.out.println("广度优先遍历无向图G1：");  //图7.26 A
//        for(i=0;  i<graph.vertexCount();  i++)
//            graph.BFSTraverse(i);

        //§7.4.2   最小生成树的构造算法
//        System.out.println("带权无向图G3，prim算法");
//        graph.minSpanTree();                //prim

        //7.5.1   非负权值的单源最短路径（Dijkstra算法）
//        System.out.println("带权无向图G3，Dijkstra算法");
//        for(i=0;  i<graph.vertexCount();  i++)       //图10.6
//            graph.shortestPath(i);               //顶点vi的单源最短路径，Dijkstra算法
        

      //§7.5.2  以Floyd算法求带权图每对顶点间的最短路径。//习题解答
//        System.out.println("带权无向图G3，Floyd算法");
//        graph.shortestPath();                    //调用Floyd算法求带权图每对顶点间的最短路径
        
/*        //习题7
        System.out.print("有"+graph.edgeCount()+"条边，");
        i=0;
        System.out.println("顶点"+graph.get(i)+"的入度是"+graph.indegree(i)+
                                               "，出度是"+graph.outdegree(i));
*/ 
    }
}
/*          //（2）插入顶点（3）插入边 //以下是第4版的，第5版教材没写
int i=graph.insertVertex("F");           //插入顶点F，扩容
//System.out.println("图7.17，插入顶点F（序号为"+i+"），插入边(D,F,13)和(E,F,11)");
graph.insertEdge(3,i,13);                //插入边(D,F,13)
//graph.insertEdge(i,3,13);                //插入边(F,D,13)
graph.insertEdge(new Triple(i,3,13));    //插入边(F,D,13)
graph.insertEdge(4,i,11);                //插入边(E,F,11)
graph.insertEdge(i,4,11);                //插入边(F,E,11)
//graph.insertEdge(new Triple(i,4,11));  //插入边(F,E,11)
//System.out.println("带权无向图G3，"+graph.toString());
//graph.insertEdge(5,6,0);               //插入边，序号越界
*/        
//@author：Yeheya。2014年7月24日，2015-11-15，2019年10月27日