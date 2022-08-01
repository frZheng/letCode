package Trees;


import java.io.*;
import java.util.*;

class Edge {
    int a, b, c;
    public Edge(int a, int b, int c) {
        this.a = a; // 节点 a
        this.b = b; // 节点 b
        this.c = c; // 节点a与节点b之间连接的权重
    }
}

class kruskal {
    static int res = 0;
    static int cnt = 0;
    private static int N = 100010; // 最多有N个节点
    private static int M = 200010; // 最多有M条边
    private static int[] p = new int[N];
    private static int n, m;
    private static int INF = 0x3f3f3f3f;
    private static Edge[] g = new Edge[M];

    public static int[][] visit;
    public static int find(int x) {
        //寻找x点的祖宗节点
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    public static void main(String[] args) throws IOException {
/* 样例
3 3 1
1 2 10
1 3 100
2 3 50
1 3

3 3 0
1 2 10
1 3 100
2 3 50

4 3 0
1 2 10
1 3 100
2 3 50
 */
        Scanner sc = new Scanner(System.in);
        String[] str1 = sc.nextLine().split(" ");
        n = Integer.parseInt(str1[0]);
        m = Integer.parseInt(str1[1]);
        int conn = Integer.parseInt(str1[2]);
        for (int i = 1; i <= n; i ++) {
            p[i] = i;//初始化并查集
        }
        for (int i = 0; i < m; i ++) {
            String[] str2 = sc.nextLine().split(" ");
            int a = Integer.parseInt(str2[0]);
            int b = Integer.parseInt(str2[1]);
            int c = Integer.parseInt(str2[2]);

            g[i] = new Edge(a, b, c);
        }
        visit = new int[n+1][m+1];
        for (int i = 0; i < conn; i ++) {
            String[] str2 = sc.nextLine().split(" ");
            int a = Integer.parseInt(str2[0]);
            int b = Integer.parseInt(str2[1]);
            p[a] = b;
            for (int j = 0; j < m; j ++) {
                if (g[j].a==a && g[j].b==b) {
                    res += g[j].c;
                    break;
                }
            }
            cnt++;
            visit[a][b] = 1;
            visit[b][a] = 1;
        }


        int t = kruskal();
        if (t == INF) {
            System.out.println("-1");
        } else {
            System.out.println(t);
        }

    }

    public static int kruskal() {
        Arrays.sort(g, 0, m, new Comparator<Edge>(){
            @Override
            public int compare(Edge e1, Edge e2){
                return e1.c - e2.c;
            }
        });

        for (int i = 0; i < m; i ++) {
            Edge tmp = g[i];
            int a = tmp.a;
            int b = tmp.b;
            int c = tmp.c;
            if (visit[b][a]==0 && visit[a][b]==0 ) {
                a = find(a);
                b = find(b);
                if (a != b) {
            /*
        如果a和b已经在一个集合当中了,说明这两个点已经被一种方式连接起来了,
        如果加入a-b这条边,会导致集合中有环的生成,而树中不允许有环生成,所以一个连通块中的点的数量假设
        为x,那么里面x个节点应该是被串联起来的,有x-1条边,所以只有当a,b所属的集合不同时,才能将a-b这条
        边加入到总集合当中去
        */
                    visit[a][b] = 1;
                    visit[b][a] = 1;
                    p[a] = b;
                    res += c;
                    cnt++;
                }
            }
        }
        if (cnt < n - 1) {
            // 边树小于n-1，不能构造最小生成树
            return INF;
        } else {
            return res;
        }
    }
}


