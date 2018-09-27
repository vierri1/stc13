package lesson12.jdbc.realExamle.dao.mobile;

import lesson12.jdbc.realExamle.pojo.Mobile;

import static lesson12.jdbc.realExamle.dao.manufacturer.ManufacturerTestData.*;

public class MobileTestData {
    public final static Mobile MOBILE_1 = new Mobile(1, "c35", 5000f, MANUFACTURER_1);
    public final static Mobile MOBILE_2 = new Mobile(2, "3310", 2000f, MANUFACTURER_4);
    public final static Mobile MOBILE_3 = new Mobile(3, "5110", 5000f, MANUFACTURER_4);
    public final static Mobile MOBILE_4 = new Mobile(4, "3G", 12000f, MANUFACTURER_2);
    public final static Mobile MOBILE_5 = new Mobile(5, "c25", 3000f, MANUFACTURER_1);
    public final static Mobile MOBILE_6 = new Mobile(6, "Milestone", 1500f, MANUFACTURER_3);
}
