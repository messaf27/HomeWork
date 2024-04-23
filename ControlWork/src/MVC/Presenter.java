package MVC;

public class Presenter {
    private Model model;
    private Viewer view;

    public Presenter(Model model, Viewer view) {
        this.model = model;
        this.view = view;
    }
}
