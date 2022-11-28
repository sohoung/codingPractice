package DFS_BFS기초;

public class Tree말단노드까지의가장짧은경로_DFS {
    Node root;
    public int DFS(int L, Node root) {
        if(root.lt == null && root.rt == null) {
            return L;
        }
        else {
            return Math.min(DFS(L+1,root.lt), DFS(L+1, root.rt));
        }
    }
    public static void main(String[] args) {
        Tree말단노드까지의가장짧은경로_DFS  m = new Tree말단노드까지의가장짧은경로_DFS();
        m.root = new Node(1);
        m.root.lt = new Node(2);
        m.root.rt = new Node(3);
        m.root.lt.lt = new Node(4);
        m.root.lt.rt = new Node(5);
        System.out.println(m.DFS(0,m.root));
    }
}
