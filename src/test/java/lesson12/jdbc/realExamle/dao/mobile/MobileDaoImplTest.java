package lesson12.jdbc.realExamle.dao.mobile;

import lesson12.jdbc.realExamle.dao.BaseDaoTest;
import lesson12.jdbc.realExamle.pojo.Mobile;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static lesson12.jdbc.realExamle.dao.manufacturer.ManufacturerTestData.MANUFACTURER_2;
import static lesson12.jdbc.realExamle.dao.mobile.MobileTestData.*;
import static org.assertj.core.api.Assertions.assertThat;

class MobileDaoImplTest extends BaseDaoTest {

    private MobileDao mobileDao = new MobileDaoImpl();

    @Test
    void add() {
        Mobile newMobile = new Mobile(7, "6", 30000f, MANUFACTURER_2);
        mobileDao.add(newMobile);
        assertThat(Arrays.asList(MOBILE_1, MOBILE_2, MOBILE_3, MOBILE_4, MOBILE_5, MOBILE_6, newMobile))
                .usingElementComparatorIgnoringFields("manufacturer").isEqualTo(mobileDao.getAll());
    }

    @Test
    void getById() {
        Mobile mobile = mobileDao.getById(3);
        assertThat(mobile).isEqualToIgnoringGivenFields(MOBILE_3, "manufacturer");
        assertThat(mobile.getManufacturer()).isEqualToComparingFieldByField(MOBILE_3.getManufacturer());
    }

    @Test
    void update() {
        Mobile mobile = mobileDao.getById(2);
        mobile.setPrice(8800f);
        mobileDao.update(mobile);
        assertThat(mobile).isEqualToIgnoringGivenFields(mobileDao.getById(2), "manufacturer");
        assertThat(mobile).isEqualToIgnoringGivenFields(mobileDao.getById(2), "manufacturer");
    }

    @Test
    void deleteById() {
        mobileDao.deleteById(4);
        assertThat(Arrays.asList(MOBILE_1, MOBILE_2, MOBILE_3, MOBILE_5, MOBILE_6))
                .usingElementComparatorIgnoringFields("manufacturer").isEqualTo(mobileDao.getAll());
    }

    @Test
    void getAll() {
        List<Mobile> mobiles = mobileDao.getAll();
        assertThat(Arrays.asList(MOBILE_1, MOBILE_2, MOBILE_3, MOBILE_4, MOBILE_5, MOBILE_6))
                .usingElementComparatorIgnoringFields("manufacturer").isEqualTo(mobiles);
    }
}