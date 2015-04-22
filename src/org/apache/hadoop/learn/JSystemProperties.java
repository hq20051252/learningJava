package org.apache.hadoop.learn;
import java.util.Properties;
public class JSystemProperties {
    public static void main(String[] args) {
        Properties prop = System.getProperties();
        prop.list(System.out);
    }
}