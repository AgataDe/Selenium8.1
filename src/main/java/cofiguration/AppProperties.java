package cofiguration;

import cofiguration.model.Browser;
import cofiguration.model.EnvironmentModel;
import cofiguration.model.TestData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class AppProperties {
    private Browser browser;
    private List<EnvironmentModel> listOfEnvironments;
    private TestData testData;
    private static Logger logger = LoggerFactory.getLogger(AppProperties.class);
    YamlReader yamlReader = new YamlReader();

    private AppProperties() {
        setBrowserProperties();
        setEnvProperties();
        setTestDataProperties();
    }

    public static AppProperties getInstance() {
        return AppProperties.AppPropertiesSingleton.INSTANCE;
    }


    private void setEnvProperties() {
        listOfEnvironments = yamlReader.getConfig().getEnvironment().getEnvProperties();
        for (EnvironmentModel environmentModel : listOfEnvironments) {
            if (environmentModel.isActive()) {
                Map<String, Object> envProperties = environmentModel.getModelProperties();
                for (Map.Entry entry : envProperties.entrySet()) {
                    System.setProperty(entry.getKey().toString(), entry.getValue().toString());
                    logger.info("Load env properties: {} = {}", entry.getKey().toString(), entry.getValue().toString());
                }
                break;
            }
        }
    }

    private void setBrowserProperties() {
        browser = yamlReader.getConfig().getBrowser();
        Map<String, Object> browserProperties = browser.getBrowserProperties();
        for (Map.Entry entry : browserProperties.entrySet()) {
            System.setProperty(entry.getKey().toString(), entry.getValue().toString());
            logger.info("Load browser properties: {} = {}", entry.getKey().toString(), entry.getValue().toString());
        }
    }

    private void setTestDataProperties() {
        testData = yamlReader.getConfig().getTestData();
        Map<String, Object> testDataProperties = testData.getTestDataProperties();
        for (Map.Entry entry : testDataProperties.entrySet()) {
            System.setProperty(entry.getKey().toString(), entry.getValue().toString());
            logger.info("Load test data properties: {} = {}", entry.getKey().toString(), entry.getValue().toString());
        }
    }

    private static class AppPropertiesSingleton {
        private static final AppProperties INSTANCE = new AppProperties();
    }

}
