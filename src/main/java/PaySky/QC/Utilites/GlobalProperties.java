package PaySky.QC.Utilites;

import java.util.Properties;

public class GlobalProperties {

    /***
     * This class is responsible for getting the properties file at resources folder
     * **/
    public static Properties global_propertoes =  new Properties();
    public static String getProperty(String name) { return global_propertoes.getProperty(name);}


    public Properties getGlobalsValue() {
        Properties prop = new Properties();
        return prop;
    }
}
