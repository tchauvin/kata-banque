package carbon.DateUtil;

import java.util.Date;

/**
 * Created by tchauvin on 23/11/2017.
 */
public class TestDateGenerator implements DateGenerator {

    private Date date;

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
