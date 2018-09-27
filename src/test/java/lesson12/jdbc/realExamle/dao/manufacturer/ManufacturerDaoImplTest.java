package lesson12.jdbc.realExamle.dao.manufacturer;

import lesson12.jdbc.realExamle.dao.BaseDaoTest;
import lesson12.jdbc.realExamle.pojo.Manufacturer;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static lesson12.jdbc.realExamle.dao.manufacturer.ManufacturerTestData.*;
import static org.assertj.core.api.Assertions.assertThat;

class ManufacturerDaoImplTest extends BaseDaoTest {

    private ManufacturerDao manufacturerDao = new ManufacturerDaoImpl();

    @Test
    void add() {
        Manufacturer newManufacturer = new Manufacturer(5, "Samsung", "Korea");
        manufacturerDao.add(newManufacturer);
        assertThat(Arrays.asList(MANUFACTURER_1, MANUFACTURER_2, MANUFACTURER_3, MANUFACTURER_4, newManufacturer))
                .usingFieldByFieldElementComparator().isEqualTo(manufacturerDao.getAll());
    }

    @Test
    void getById() {
        Manufacturer manufacturer = manufacturerDao.getById(3);
        assertThat(manufacturer).isEqualToComparingFieldByField(MANUFACTURER_3);
    }

    @Test
    void update() {
        Manufacturer updatedManufacturer = manufacturerDao.getById(1);
        updatedManufacturer.setCountry("Russia");
        manufacturerDao.update(updatedManufacturer);
        assertThat(updatedManufacturer).isEqualToComparingFieldByField(manufacturerDao.getById(1));

    }

    @Test
    void deleteById() {
        manufacturerDao.deleteById(3);
        assertThat(Arrays.asList(MANUFACTURER_1, MANUFACTURER_2, MANUFACTURER_4))
                .usingFieldByFieldElementComparator().isEqualTo(manufacturerDao.getAll());
    }

    @Test
    void getAll() {
        List<Manufacturer> manufacturers = manufacturerDao.getAll();
        assertThat(Arrays.asList(MANUFACTURER_1, MANUFACTURER_2, MANUFACTURER_3, MANUFACTURER_4))
                .usingFieldByFieldElementComparator().isEqualTo(manufacturers);
    }
}