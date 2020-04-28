package dtapi.data.enums;

public enum RowsOnPage {
    FIVE(5),
    TEN(10),
    TWENTY(20);


    private int filter;

    RowsOnPage(int filter) {
        this.filter = filter;
    }

    @Override
    public String toString() {
        return ((String.valueOf(filter)));
    }
}
