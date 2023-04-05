public class Main {
    public static void main(String[] args) {
        MyLinkedList lis = new MyLinkedList();
        lis.addNum(4);
        lis.addNum(2);
        lis.addNum(8);
        lis.addNum(13);
        lis.addNum(11);
        lis.addNum(1);

        System.out.println(lis);
        System.out.println(lis.size());

        for (MyLinkedList.Ysel i:lis) {
            System.out.println(i);
        }

        lis.removeNum(8);
        System.out.println("список после удаления");
        System.out.println(lis.size());
        for (MyLinkedList.Ysel i:lis) {
            System.out.println(i);
        }

    }

}