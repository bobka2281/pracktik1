import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
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
            Answer.SearchItem selected = result.query.search[choice - 1];
            String url = selected.getUrl();
            browser(url);
            selection(sc, result, answer);
        } catch (NumberFormatException | IOException | URISyntaxException e) {
            System.out.println("Введите корректное число");
        }
    }
    private void browser(String url) throws IOException, URISyntaxException {
        Desktop.getDesktop().browse(new URI(url));
        System.out.println("Статья открыта");
    }
}
