package extension;


    import org.example.project.DriverManager;
    import org.junit.jupiter.api.extension.AfterAllCallback;
    import org.junit.jupiter.api.extension.BeforeAllCallback;
    import org.junit.jupiter.api.extension.ExtensionContext;

    import static org.example.project.DriverManager.*;

public class DriverExtension implements BeforeAllCallback, AfterAllCallback {
    @Override
    public void afterAll(ExtensionContext extensionContext) throws Exception {
        closeDriver();
    }

    @Override
    public void beforeAll(ExtensionContext extensionContext) throws Exception {
        getWebDriver();

    }
}