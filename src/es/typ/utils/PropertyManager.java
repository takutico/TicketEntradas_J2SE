package es.typ.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class PropertyManager {

    private Properties props;
    private long lastModification = -1L;
    public static Object[][] propsInfo;
    private static PropertyManager propertyManager = null;
    private static String filename = "";

    private PropertyManager(String filename) {
        this.filename = filename;
        lastModification = -1L;
        readPropertyFile();
        propsInfo = getKeysAndValues();
    }

    @Override
    public Object clone() {
        throw new UnsupportedOperationException("This object is a singleton and thus cannot be overriden.");
    }

    private void readPropertyFile() {
        File propsFile = null;
        try {
            propsFile = new File(System.getProperty("user.dir") + File.separator + filename);
            long lastmod = propsFile.lastModified();
            if (lastmod == lastModification) {
                return;
            }
            lastModification = lastmod;
            props = new Properties();
            FileInputStream fis = new FileInputStream(propsFile);
            if (fis != null) {
                props.load(fis);
                fis.close();
            }
        } catch (IOException ex) {
            Log.getInstance().log("readPropertyFile IOException: " + ex.getMessage(), ex);
        }
    }

    public static synchronized PropertyManager getInstance() {
        if (propertyManager == null) {
            propertyManager = new PropertyManager("TicketEntradas_J2SE.properties");
        } else {
            //if new filename is passed then recreate the object
            if (!filename.equals("TicketEntradas_J2SE.properties")) {
                propertyManager = new PropertyManager("TicketEntradas_J2SE.properties");
            }
        }

        return propertyManager;
    }

    public String getProperty(String propName) {
        readPropertyFile();
        return props.getProperty(propName);
    }

    public String getProperty(String propName, String defaultvalue) {
        readPropertyFile();
        return props.getProperty(propName, defaultvalue);
    }

    public int getIntProperty(String propName) {
        readPropertyFile();
        String prop = props.getProperty(propName);
        if (prop == null) {
            return -1;
        }
        int result = -1;
        try {
            result = Integer.parseInt(prop);
        } catch (NumberFormatException nfe) {
            result = -1;
        }
        return result;
    }

    public int getIntProperty(String propName, int defaultvalue) {
        readPropertyFile();
        String prop = props.getProperty(propName);
        if (prop == null) {
            return defaultvalue;
        }
        int result = -1;
        try {
            result = Integer.parseInt(prop);
        } catch (NumberFormatException nfe) {
            result = defaultvalue;
        }
        return result;
    }

    public boolean getBooleanProperty(String propName, boolean defaultvalue) {
        readPropertyFile();
        String prop = props.getProperty(propName);
        if (prop == null) {
            return defaultvalue;
        }
        if ("true".equalsIgnoreCase(prop)) {
            return true;
        } else if ("T".equalsIgnoreCase(prop)) {
            return true;
        } else if ("1".equals(prop)) {
            return true;
        } else if ("SI".equalsIgnoreCase(prop)) {
            return true;
        }
        return false;
    }

    public void setProperty(String key, String value) {
        props.setProperty(key, value);
    }

    public boolean update() {
        File propsFile = null;
        try {
            propsFile = new File(System.getProperty("user.dir") + File.separator + filename);
            FileOutputStream fos = new FileOutputStream(propsFile);
            props.store(fos, "Generated settings");
            fos.close();
        } catch (IOException ex) {
            Log.getInstance().log("PropertyManager.update IOException: " + ex.getMessage(), ex);
            return false;
        }
        return true;
    }

    public boolean isTrueProperty(String propName) {
        String prop = getProperty(propName);
        if ("1".equals(prop)) {
            return true;
        } else if ("true".equalsIgnoreCase(prop)) {
            return true;
        } else if ("si".equalsIgnoreCase(prop)) {
            return true;
        }

        return false;
    }

    public Object[][] getKeysAndValues() {
        Set keys = props.keySet();
        Object[][] data = new Object[keys.size()][2];
        int i = 0;
        for (Object key : keys) {
            String keyStr = (String) key;
            String value = props.getProperty(keyStr);
            data[i++] = new Object[]{keyStr, value};
        }
        return data;
    }
}
