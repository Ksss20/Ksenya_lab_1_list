public class Main {
    public static void main(String[] args) {
        MyLinkedLink<Integer> list = new MyLinkedLink<>();

        for (int i = 0; i < 10; i++) {
            list.add(i + 1);
        }

        list.add(0, 0);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println();

        list.remove(3);
        list.remove(0);
        list.remove(0);
        list.removeLast();

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
