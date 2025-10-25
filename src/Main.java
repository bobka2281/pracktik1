import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            searchAndShow(scanner);
        } catch (Exception e) {
            System.out.println(" Произошла Ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
    private static void searchAndShow(Scanner scanner) throws Exception {
        System.out.print("Введите запрос: ");
        String request = scanner.nextLine();

        Search search = new Search();
        String resp = search.wiki(request);

        Answer answer = new Answer();
        Answer.SearchRes result = answer.parse(resp);

        if (result.query == null || result.query.search == null || result.query.search.length == 0) {
            System.out.println("Ничего не найдено. Попробуйте другой запрос.\n");
            searchAndShow(scanner);
            return;
        }
        answer.printRes(result);
        Opener opener = new Opener();
        opener.selection(scanner, result, answer);
    }
}
