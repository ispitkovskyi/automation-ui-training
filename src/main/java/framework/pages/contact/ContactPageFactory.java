package framework.pages.contact;

import framework.EnvironmentProperties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.Properties;

import static framework.Constants.*;

/**
 * Created by IgorS on 6/30/2016.
 */
public class ContactPageFactory {

    private static Properties props;

    private static Properties createProps(){
        if(props == null){
            props = new Properties();
        }
        return props;
    }

    //TODO: Factory makes decision which localized resources should be loaded and object of which page should be created
    public static PageMainContact getInstance() throws Exception {
        System.out.println("Making decision which localized resources should be loaded.");
        if(EnvironmentProperties.get().getLanguage().equalsIgnoreCase(LOCALE_US)){
            loadLocale("us.properties");
        }else if(EnvironmentProperties.get().getLanguage().equalsIgnoreCase(LOCALE_GERMAN)){
            loadLocale("ger.properties");
        }

        System.out.println("Making decision instance of which decorator of Main Contact Page should be created.");
        String host = EnvironmentProperties.get().getSiteHostname();
        switch(host){
            case APP_GARCINIA:
                return new PageMainContactGarcinia();
            case APP_DETOX:
                return new PageMainContactDetox();
            default:
                return null;
        }
    }

    private static void loadLocale(String localizedFile) throws Exception {
        System.out.println(String.format("Loading %s localized resources", localizedFile));
        URL filePath = Thread.currentThread().getContextClassLoader().getResource(LOCALIZATION_DIR + localizedFile);
        File f = new File(filePath.getPath());

        if(!f.exists()){
            System.out.println("File does not exixt");
        }

        try {
            //InputStream in = ContactPageFactory.class.getResourceAsStream("/l10n/" + localizedFile);
            InputStream in = new FileInputStream(f);
            if(in != null) {
                try {
                    createProps().load(in);
                } catch (Exception e) {
                    System.out.println(e.getMessage() + " " + e.getStackTrace());
                }finally {
                    in.close();
                }
            }
        }catch(IOException e){
            throw new Exception("Could not find file with localized strings.");
        }

        Enumeration itr = props.keys();
        while(itr.hasMoreElements()){
            Object key = itr.nextElement();
            System.setProperty(key.toString(), props.get(key).toString());
        }
    }
}
