package dtapi.data.admin;

public final class AdminRepository {
    private static volatile AdminRepository instance = null;

    private AdminRepository() {
    }

    public static AdminRepository get() {
        if (instance == null) {
            synchronized (AdminRepository.class) {
                if (instance == null) {
                    instance = new AdminRepository();
                }
            }
        }
        return instance;
    }

    public IAdmin getDefault() {
        return getFirstAdmin();
    }

    public IAdmin getFirstAdmin() {
        return Admin.getAdmin()
                .setAdminLogin("admin1")
                .setAdminEmail("rthrhr@gmail.com")
                .setAdminPassword("qwerty123")
                .setAdminConfirmPassword("qwerty123")
                .build();
    }
    public IAdmin getSecondAdmin() {
        return Admin.getAdmin()
                .setAdminLogin("admin2")
                .setAdminEmail("rthrhr@gmail.com")
                .setAdminPassword("qwerty123")
                .setAdminConfirmPassword("qwerty123")
                .build();
    }
    public IAdmin getAdminWithEmptyFields() {
        return Admin.getAdmin()
                .setAdminLogin("")
                .setAdminEmail("")
                .setAdminPassword("")
                .setAdminConfirmPassword("")
                .build();
    }
    public IAdmin getAdminWithInvalidLogin() {
        return Admin.getAdmin()
                .setAdminLogin("admin")
                .setAdminEmail("htrhrjrtj@gmail.com")
                .setAdminPassword("qwerty123")
                .setAdminConfirmPassword("qwerty123")
                .build();
    }
    public IAdmin getAdminWithInvalidConfirmPassword() {
        return Admin.getAdmin()
                .setAdminLogin("admin3")
                .setAdminEmail("htrhrjrtj@gmail.com")
                .setAdminPassword("qwerty123")
                .setAdminConfirmPassword("qwerty")
                .build();
    }
}
