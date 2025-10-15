import java.awt.Desktop;
import java.net.URI;
import java.util.Scanner;
class Opener {
    public void selection(Scanner sc, Answer.SearchRes result, Answer answer) {
        if (result.query == null || result.query.search == null || result.query.search.length == 0) {
            System.out.println("Ничего не найдено");
            return;
        }
        try {
            System.out.print("Введите номер статьи для открытия (0 - отмена): ");
            int choice = sc.nextInt();
            if (choice == 0) {
                System.out.println("Выход из программы");
                return;
            }
            if (choice < 1 || choice > result.query.search.length) {
                System.out.println("Ошибка: введите число от 1 до " + result.query.search.length);
                return;
            }
            Answer.SearchItem selectedItem = result.query.search[choice - 1];
            String url = selectedItem.getUrl();
            browse(url);
            selection(sc, result, answer);
        } catch (Exception e) {
            System.out.println("Введите корректное число");

        }
    }
    private void browse(String url) throws Exception {
        Desktop.getDesktop().browse(new URI(url));
        System.out.println("Статья открыта");
    }
}