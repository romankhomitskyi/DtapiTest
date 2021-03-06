package dtapi.data.user;

public final class UserRepository {
    private static volatile UserRepository instance = null;

    private UserRepository() {
    }

    public static UserRepository get() {
        if (instance == null) {
            synchronized (UserRepository.class) {
                if (instance == null) {
                    instance = new UserRepository();
                }
            }
        }
        return instance;
    }

    public IUser getDefault() {
        return getUser();
    }

    public IUser getAdmin() {
        return User.get()
                .setLogin("admin")
                .setPassword("dtapi_admin")
                .build();
    }

    public IUser getInvalidAdmin() {
        return User.get()
                .setLogin("admin")
                .setPassword("dtapi")

                .build();
    }

    public IUser getUser() {
        return User.get()
                .setLogin("yurik")
                .setPassword("qwerty123")

                .build();
    }

    public IUser getInvalidUser() {
        return User.get()
                .setLogin("yurik")
                .setPassword("qwerty")

                .build();
    }

    public IUser getInvalidUser2() {
        return User.get()
                .setLogin("")
                .setPassword("")

                .build();
    }

    public IUser getInvalidUser3() {
        return User.get()
                .setLogin("yur")
                .setPassword("qwerty123")

                .build();
    }

}
