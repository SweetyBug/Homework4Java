import java.util.*;



public class Queue<T> {
    private T[] arr;
    private int index;
    private int front;
    private int rear;

    public Queue(int len) {
        this.index = 0;
        this.arr = (T[]) new Object[len];
    }

    public int size() {
        return this.index;
    }


    public boolean empty() {
        return this.size() == 0;
    }

    public void offer(T value, int len) {
        if (size() == len) {
            System.out.println("Очередь переполнена!");
        }else {
            for (int i = this.index; i >= 0; i--) {
                arr[i+1] = arr[i];
            }
            arr[0] = value;
            index++;
        }
    }

    public T poll(int len) {
        if (!(empty() == true)) {
            return this.arr[--index];
        } else {
            String error = "Невозможно удалить значение из пустой очереди!";
            return (T) error;
        }
    }

    public T peek() {
        if (!(empty() == true)) {
            return this.arr[0];
        } else {
            String error = "Очередь пуста!";
            return (T) error;
        }
    }

    public static String menuUser() {
        String menu = "1. Добавить элемент\n" +
                "2. Удалить элемент\n" +
                "3. Узнать заполненность очереди\n" +
                "4. Узнать элемент из головы очереди";
        return menu;
    }

    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);;
        int length = 11;
        Queue<String> que = new Queue<String>(length);
        while (true) {
            System.out.println("Выберите необходимое\n"+menuUser());
            String user = iScanner.nextLine();
            if (user.equals("1") || user.toLowerCase().equals("добавить элемент")) {
                System.out.println("Введите эллемент: ");
                String us = iScanner.nextLine();
                que.offer(us, length);
            } else if (user.equals("2") || user.toLowerCase().equals("удалить элемент")) {
                System.out.println(que.poll(length));
            } else if (user.equals("3") || user.toLowerCase().equals("узнать заполненность очереди")) {
                System.out.println(que.size());
            } else if (user.equals("4") || user.toLowerCase().equals("узнать первый элемент")) {
                System.out.println(que.peek());
            } else {
                System.out.println("Моя твоя не понимать...");
            }
            System.out.println('\n');
        }
    }
}
