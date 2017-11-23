package carbon.DateUtil;

import java.util.Date;

/**
 * Created by tchauvin on 16/07/2017.
 */
public class TestDateGenerator implements DateGenerator {

    private static Date date;

    public TestDateGenerator(Date date) {
        this.date = date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

}
