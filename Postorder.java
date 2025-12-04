import java.util.Scanner;
class Postorder {
    public static class Node{
        int data;
        Node left, right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static Node root = null;
    public static Node queue[] = new Node[100];
    public static int i=-1,j=-1;
    
    public static void append(int data){
        Node newNode = new Node(data);
        if(root == null){
            root = newNode;
            queue[++j] = newNode;
            ++i;
        }else{
            Node temp = root;
            while(true){
                if(temp.left == null){
                    temp.left = newNode;
                    queue[++j] = newNode;
                    break;
                }
                if(temp.right == null){
                    temp.right = newNode;
                    queue[++j] = newNode;
                    break;
                }
                temp = queue[++i];
            }
        }
    }
    
    public static void display(Node root){
        if(root == null){
            return;
        }
        display(root.left);
        display(root.right);
	System.out.print(root.data+" ");
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int data;
        do{
            data = sc.nextInt();
            if(data>0){
                append(data);
            }
        }while(data>0);
        display(root);
    }
}