package CodeFiles.src.collectiondemo;

import java.util.Properties;

public class propertiesdemo
{
    static void main(String[] args) {
        Properties ob=new Properties();

        ob.setProperty("id", "101");
        ob.setProperty("name","jai");
        ob.setProperty("age","23");

        System.out.println(ob);
        System.out.println("Name : "+ob.getProperty("name"));

        String var = ob.remove("age").toString();
        System.out.println(ob);
        System.out.println("Var : "+var);

    }
}
