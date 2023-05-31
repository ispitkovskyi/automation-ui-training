package framework.pages.about;

import framework.EnvironmentProperties;
import static framework.Constants.*;
/**
 * Created by ispitkovskyi on 6/24/2016.
 */
public class AboutPageFactory {
    public static PageAbout getInstance(){
        String host = EnvironmentProperties.get().getSiteHostname();
        switch(host){
            case APP_GARCINIA:
                return new PageAboutGarcinia();
            case APP_DETOX:
                return new PageAboutDetox();
            default:
                return null;
        }
    }
}
