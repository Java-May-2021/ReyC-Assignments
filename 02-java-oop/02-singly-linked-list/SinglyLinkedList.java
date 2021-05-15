public class SinglyLinkedList {
    public Node head;
    public SinglyLinkedList() {
        this.head = null;
    }
    public void add(int value) {
        Node newNode = new Node(value);
        if(this.head == null) {
            this.head = newNode;
            return;
        } else {
            Node runner = this.head;
            while(runner.next != null) {
                runner = runner.next;
            }
            runner.next = newNode;
        }
    }

    public void remove() {
        Node runner = this.head;
        Node prevRunner = null;
        while(runner.next != null) {
            prevRunner = runner;
            runner = runner.next;
        }
        prevRunner.next = null;
    }

    public void printValues() {
        Node runner = this.head;
        while(runner.next != null) {
            System.out.println(runner.value);
            runner = runner.next;
        }
        System.out.println(runner.value);
    }
}