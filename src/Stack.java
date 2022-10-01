import java.util.*;


public class Stack<T> {
    private T[] arr;
    private int index;

    public Stack(int length) {
        this.index = 0;
        this.arr = (T[]) new Object[length];
    }

    public int size() {
        return this.index;
    }
    public boolean empty() {
        return this.size() == 0;
    }
    public void push(T value, int len) {
        if (size() == len) {
            System.out.println("Stack переполнен!");
        }else {
            this.arr[index++] = value;
        }
    }
    public T peek() {
        return this.arr[index-1];
    }
    public T pop() {
        if (empty() == true) {
            String error = "К сожалению невозможно удалить значение из пустого стека!";
            return (T) error;
        }else {
            return this.arr[--index];
        }
    }

    public static String menuUser() {
        String menu = "1. Добавить элемент\n" +
                "2. Удалить элемент\n" +
                "3. Узнать заполненность стека\n" +
                "4. Узнать последний элемент";
        return menu;
    }

    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);;
        int leng = 11;
        Stack<String> stack = new Stack<>(leng);
        while (true) {
            System.out.println("Выберите необходимое\n"+menuUser());
            String user = iScanner.nextLine();
            if (user.equals("1") || user.toLowerCase().equals("добавить элемент")) {
                System.out.println("Введите эллемент: ");
                String us = iScanner.nextLine();
                stack.push(us, leng);
            } else if (user.equals("2") || user.toLowerCase().equals("удалить элемент")) {
                System.out.println(stack.pop());
            } else if (user.equals("3") || user.toLowerCase().equals("узнать заполненность стека")) {
                System.out.println(stack.size());
            } else if (user.equals("4") || user.toLowerCase().equals("узнать последний элемент")) {
                System.out.println(stack.peek());
            } else {
                System.out.println("Моя твоя не понимать...");
            }
            System.out.println('\n');
        }
    }
}