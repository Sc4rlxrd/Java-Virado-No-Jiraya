package javacore.resourcebundle;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleTest01 {

    public static void main(String[] args) {
        System.out.println(Locale.getDefault());
        ResourceBundle bundle = ResourceBundle.getBundle("messages", new Locale("pt", "BR"));
        boolean isExist = bundle.containsKey("KKK");
        System.out.println(isExist);
        System.out.println(bundle.getString("ola"));
        System.out.println(bundle.getString("bom.dia"));
        ResourceBundle bundle2 = ResourceBundle.getBundle("messages", new Locale("en", "US"));
        System.out.println(bundle2.getString("hello"));
        System.out.println(bundle2.getString("good.morring"));

    }


}
