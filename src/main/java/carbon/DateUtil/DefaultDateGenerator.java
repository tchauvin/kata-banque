package carbon.DateUtil;

import java.util.Date;

/**
 * Created by tchauvin on 16/07/2017.
 */
public class DefaultDateGenerator implements DateGenerator {

    public DefaultDateGenerator() {
    }

    public Date getDate() {
        return new Date();
    }
}
