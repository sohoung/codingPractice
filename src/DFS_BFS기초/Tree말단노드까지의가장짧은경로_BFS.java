package DFS_BFS기초;

import java.util.LinkedList;
import java.util.Queue;

public class Tree말단노드까지의가장짧은경로_BFS {
    Node root;
    public int BFS(Node root) {
        Queue<Node> Q = new LinkedList<>();
        Q.offer(root);
        int L = 0;
        while(!Q.isEmpty()) {
            int len = Q.size();
            for(int i = 0; i < len; i++) {
                Node cur = Q.poll();
                if(cur.lt == null && cur.rt == null) {
                    return L;
                }
                if(cur.lt == null) {
                    Q.offer(cur.lt);
                }
                if(cur.rt == null) {
                    Q.offer(cur.rt);
                }
            }
            L++;
        }
        return 0;
    }
    public static void main(String[] args) {
        Tree말단노드까지의가장짧은경로_BFS m = new Tree말단노드까지의가장짧은경로_BFS();
        m.root = new Node(1);
        m.root.lt = new Node(2);
        m.root.rt = new Node(3);
        m.root.lt.lt = new Node(4);
        m.root.lt.rt = new Node(5);
        System.out.println(m.BFS(m.root));
    }
}
