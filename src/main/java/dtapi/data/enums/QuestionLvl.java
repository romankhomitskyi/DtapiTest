package dtapi.data.enums;

public enum QuestionLvl {
    FIRST_LVL("1"),
    SECOND_LVL("2"),
    THIRD_LVL("3"),
    FOURTH_LVL("4"),
    FIFTH_LVL("5");

    public String lvl;

    QuestionLvl(String lvl) {
        this.lvl = lvl;
    }

    @Override
    public String toString() {
        return lvl;
    }
}
