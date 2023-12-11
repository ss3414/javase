package library.test;

import org.junit.jupiter.api.extension.*;

public class AnnotationExtension implements
        BeforeAllCallback,
        BeforeEachCallback,
        BeforeTestExecutionCallback,
        AfterTestExecutionCallback,
        AfterEachCallback,
        AfterAllCallback {

    @Override
    public void beforeAll(ExtensionContext extensionContext) {
        System.out.println("beforeAll");
    }

    @Override
    public void beforeEach(ExtensionContext extensionContext) {
        System.out.println("beforeEach");
    }

    @Override
    public void beforeTestExecution(ExtensionContext extensionContext) {
        System.out.println("beforeTestExecution");
    }

    @Override
    public void afterTestExecution(ExtensionContext extensionContext) {
        System.out.println("afterTestExecution");
    }

    @Override
    public void afterEach(ExtensionContext extensionContext) {
        System.out.println("afterEach");
    }

    @Override
    public void afterAll(ExtensionContext extensionContext) {
        System.out.println("afterAll");
    }

}
