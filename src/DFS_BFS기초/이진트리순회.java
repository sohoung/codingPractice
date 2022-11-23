package DFS_BFS기초;

// 설명 : 이진트리를 전위와 후위로 출력하세요.

class Node {
    int data;  // 데이터 값
    Node lt,rt;  // 왼쪽 자식의 노드 주소와 오른쪽 자식의 노드 주소를 저장하는 변수
    public Node(int val) {
        data = val;
        lt=rt=null;
    }
}
public class 이진트리순회 {
    Node root;
    public void DFS(Node root) {

    }
    public static void main(String[] args) {
        이진트리순회  m = new 이진트리순회();
        m.root = new Node(1);
        m.root.lt = new Node(2);
        m.root.rt = new Node(3);
        m.root.lt.lt = new Node(4);
        m.root.lt.rt = new Node(5);
        m.root.rt.lt = new Node(6);
        m.root.rt.rt = new Node(7);
        m.DFS(m.root);
    }
}
