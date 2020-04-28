package dtapi.data.enums;

public enum Pagination {
    NEXT_PAGE("next"),
    THE_LAST_PAGE("last"),
    PREVIOUS_PAGE("previous"),
    THE_FIRST_PAGE("first");

    public String page;

    Pagination(String page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return page;
    }
}

