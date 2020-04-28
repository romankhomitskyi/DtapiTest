package dtapi.data.test;

public class NewTestRepository {
    private NewTestRepository() {
    }


    public static NewTest planets() {
        return new NewTest(
                "Назви планет",
                4,
                20,
                1
        );
    }
    public static NewTest photos() {
        return new NewTest(
                "Види фотографій",
                3,
                10,
                1
        );
    }
}
