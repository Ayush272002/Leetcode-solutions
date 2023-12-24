public class Main {
    public static void main(String[] args) {
        Solution s= new Solution();
        s.insertAtEnd(5);
        s.insertAtEnd(5);
        s.insertAtEnd(2);
        s.insertAtEnd(2);
        s.insertAtEnd(3);
        s.insertAtEnd(3);
        s.print();
        s.head = s.deleteDuplicateUnsorted(s.head);
        s.print();
    }
}
