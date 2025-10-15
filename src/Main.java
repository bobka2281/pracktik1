import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Введите запрос: ");
            String request = scanner.nextLine();

            Search search = new Search();
            String resp = search.wiki(request);

            Answer answer = new Answer();
            Answer.SearchRes result = answer.parse(resp);
            answer.printRes(result);

            Opener opener = new Opener();
            opener.selection(scanner, result, answer);

        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}