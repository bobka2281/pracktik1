import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.InputMismatchException;
import java.util.Scanner;
class Opener {
    public void selection(Scanner scanner, Answer.SearchRes result, Answer answer) throws IOException {
        try {
            System.out.print("Введите номер статьи для открытия (0 - отмена): ");
            int choice = scanner.nextInt();
            if (choice == 0) {
                System.out.println("Выход из программы");
                return;
            }
            Answer.SearchItem selected = result.query.search[choice - 1];
            String url = selected.getUrl();
            browser(url);
            selection(scanner, result, answer);
        } catch (ArrayIndexOutOfBoundsException | IOException | URISyntaxException | InputMismatchException e) {
            System.out.println("Введите корректное число");
            scanner.nextLine();
            selection(scanner, result, answer);
        }
    }
    private void browser(String url) throws IOException, URISyntaxException {
        Desktop.getDesktop().browse(new URI(url));
        System.out.println("Статья открыта");
    }
}
