package uk.ac.ucl.model;

public class ModelFactory {
    private static Model model;

    public static Model getModel() {
        if (model == null) {
            model = new Model();
        }
        return model;
    }

}
