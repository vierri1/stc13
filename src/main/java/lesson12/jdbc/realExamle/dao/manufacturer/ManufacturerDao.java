package lesson12.jdbc.realExamle.dao.manufacturer;

import lesson12.jdbc.realExamle.pojo.Manufacturer;

import java.util.List;

public interface ManufacturerDao {

    boolean add(Manufacturer manufacture);

    Manufacturer getById(Integer id);

    boolean update(Manufacturer mobile);

    boolean deleteById(Integer id);

    List<Manufacturer> getAll();
}
