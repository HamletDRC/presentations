import javax.sql.DataSource;

public class UserService {

    private final DataSource dataSource;
    private final UserSettings settings;

    public UserService() {
        this(DatasourceFactory.getDefault(), new UserSettingsImpl()); 
    }

    UserService(DataSource dataSource, UserSettings settings) {
        this.dataSource = dataSource;
        this.settings = settings; 
    }
}

class UserSettings {}

class UserSettingsImpl extends UserSettings {}

class DatasourceFactory {

    public static DataSource getDefault() {
        return null;
    }
}
