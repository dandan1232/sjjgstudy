//�����ݽṹ���㷨��Java�棩����5�棩�������ߣ�Ҷ���ǣ�2019��8��9��
//��6.3   ������Ӧ��
//��6.3.1  Huffman��

import java.util.*;                              //��8���ã�ɢ��ӳ�� 

public class HuffmanTree
{
    private String charset;                      //�ַ�����
    private TriElement[] element;                //��̬��������������
 
    //����Huffman����weightsָ��Ȩֵ���ϣ�Ĭ���ַ������Ǵ�'A'��ʼ��weights.length���ַ�
    public HuffmanTree(int[] weights)
    {
        this.charset = "";
        int n = weights.length;                            //Ҷ�ӽ����
        for(int i=0; i<n; i++)                             //Ĭ���ַ������Ǵ�'A'��ʼ��n���ַ�
            this.charset += (char)('A'+i);    
        
        this.element = new TriElement[2*n-1];              //n��Ҷ�ӵ�Huffman������2n-1�����
        for(int i=0; i<n; i++)                             //Huffman����ʼ��n��Ҷ�ӽ��
            this.element[i] = new TriElement(weights[i]);  //�����޸�ĸ��Ҷ�ӽ��

        for(int i=n; i<2*n-1; i++)                         //����n-1��2�Ƚ��
        {
            int min1=Integer.MAX_VALUE, min2=min1;         //��С�ʹ�СȨֵ����ֵΪ�������ֵ
            int x1=-1, x2=-1;                              //��С�ʹ�СȨֵ����±�
            for(int j=0; j<i; j++)                         //Ѱ�������޸�ĸ����СȨֵ����±�
                if(this.element[j].parent==-1)             //��j������޸�ĸ
                {
                    if(this.element[j].data<min1)          //��j�����Ȩֵ��С
                    {
                        min2 = min1;                       //min2�ǵô�СȨֵ
                        x2 = x1;                           //x2�ǵô�СȨֵ����±�
                        min1 = this.element[j].data;       //min1�ǵ���СȨֵ
                        x1 = j;                            //x1�ǵ���СȨֵ����±�
                    }
                    else if(this.element[j].data<min2)     //��j�����Ȩֵ��С
                    {
                        min2 = element[j].data; 
                        x2 = j;
                    }
                }
            
            this.element[x1].parent = i;         //�ϲ�����Ȩֵ��С��������������С
            this.element[x2].parent = i;
            this.element[i] = new TriElement(min1+min2, -1, x1, x2); //�����㣬ָ��ֵ����ĸ�����Һ���
        }
    }
    
    private String huffmanCode(int i)            //����charset��i���ַ���Huffman�����ַ���
    {
        int n=8;
        char code[] = new char[n];               //�����ַ������ݴ�Huffman����
        int child=i, parent=this.element[child].parent;
        for(i=n-1; parent!=-1; i--)              //��Ҷ�������ֱ������㣬����洢����
        {
            code[i]=(element[parent].left==child)?'0':'1'; //���Һ��ӱ���Ϊ0��1
            child = parent;
            parent = element[child].parent;        
        }                       
        return new String(code, i+1, n-1-i);     //��code�����i+1��ʼ��n-1-i���ַ����촮
    }

    public String toString()                     //����Huffman���Ľ������������ַ��ı����ַ���
    {
        String str="Huffman���Ľ������:";
        for(int i=0; i<this.element.length; i++)
            str += this.element[i].toString()+"��";
        str += "\nHuffman���룺 ";
        for(int i=0; i<this.charset.length(); i++)         //�������Ҷ�ӽ���Huffman����
            str+=this.charset.charAt(i)+"��"+huffmanCode(i)+"��";
        return str;
    }//�˷��������������ַ����ϣ�����������롣
    //���Ϲ���Huffman��������Ҫ�ַ����ϡ�

    //����ѹ������text���ַ�ת����Huffman����洢������ѹ���ַ���
    public String encode(String text)
    {
        String compressed="";                    //��ѹ�������ݣ����ַ�����ʾ
        for(int i=0; i<text.length(); i++)
        {
//            int j=text.charAt(i)-'A';  //��õ�ǰ�ַ���Ĭ���ַ�������A��ʼ��n���ַ����е���ţ�O(1)
            int j=this.map.get(text.charAt(i)+"").intValue(); //��8�£���õ�ǰ�ַ�����ţ�O(1)
            compressed += this.huffmanCode(j);   //��Huffman���л�õ�j���ַ��ı���
        }
        return compressed;
    }
    //˵����
    //��1������Ĭ���ַ����ϵ�Ŀ���ǣ�Ϊ�ַ���������һ�����㹫ʽ��ʹ�����ַ�������ŵļ���ʱ����O(1)��
    //��2�����������ַ����ϣ�ѹ��ʱ����֪һ���ַ������֪�����ַ����ַ������е���ţ�
    //    �������8�£�ʹ��ɢ��ӳ�䣬�������ַ������һ��һ��ӳ�䡣

    //���ݽ�ѹ������ѹ��compressed�е�0/1���н���Huffman���룬���������ַ���
    public String decode(String compressed)
    {
        String text="";
        int node=this.element.length-1;          //node����һ���Ӹ�����Ҷ�ӵ�·��
        for(int i=0; i<compressed.length(); i++) 
        {
            if(compressed.charAt(i)=='0')        //����0��1�ֱ�������Һ�����
                node = element[node].left;
            else
                node = element[node].right;
            if(element[node].isLeaf())           //����Ҷ�ӽ��
            {
                text += this.charset.charAt(node);    //��֪�ַ���ţ����һ���ַ���O(1)
                node = this.element.length-1;    //node�ٴӸ���㿪ʼ
            }
        }
        return text;
    }
    //˵������ͼ��ѹ�����ѹ��������HuffmanTree����롣��Ϊ�������߲�����HuffmanTree��������Huffman���룬�����߿�������
    //     δ�ɹ���û�а취��ֻ���룬�����ַ���š���Ϊ���䳤���룬������֪���ȣ��޷���������ʹ��HuffmanTree���Ľ�����飬˽�г�Ա��
    //���ԣ���ȻҪ���ַ����ϡ�

    //��5��Ľ�����8�����ӹ���
    java.util.Map<String, Integer> map;          //��8�£�ӳ�䣬ɢ��ӳ�� 
    //����Huffman����charsetָ���ַ����ϣ�weights[]ָ��Ȩֵ���ϣ����鳤��ΪҶ�ӽ����
    public HuffmanTree(String charset, int[] weights)
    {
        this(weights);                           //����Huffman����Ĭ���ַ������ϣ���'A'��ʼ��weights.length���ַ���
        this.charset = charset;                  //ָ���ַ�����

        //�������ַ����ַ���ŵ�һ��һӳ�䣬ʹ�����ַ����ҵ���ŵļ���ʱ����O(1)��
        //ӳ��<�ַ�,�ַ����>
        this.map = new HashMap<String, Integer>();
        for(int i=0; i<this.charset.length(); i++)    //�������Ҷ�ӽ���Huffman����
            map.put(this.charset.charAt(i)+"", i);    //ӳ��Ԫ��<��i���ַ�, �ַ����i>
        System.out.print(map.toString());
    }
    //˵������ָ���ַ����ϣ���Ĭ���ַ���������Ч������㷨��ͬ���޷�ʶ�����ĸ��ַ����ϡ�
}
/*
�������˵�����¡�����д��¼���Ľ�Ҫ�������γ�����⡣��Ȼ�õ�4�����
*/
//@author  Yeheya��2014-7-21��2015-9-23��2016��2��2�գ�2019��9��13�գ�����