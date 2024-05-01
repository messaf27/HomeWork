import UI.App;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        App app = new App();
        boolean result = app.run();

        System.out.printf(
                "Приложение завершилось %s\r\n",
                result ? "без ошибок" : "с ошибкой!");
    }

}
