package lesson12.jdbc.realExamle.dao.mobile;

import lesson12.jdbc.realExamle.pojo.Mobile;

import java.util.List;

public interface MobileDao {

    boolean add(Mobile mobile);

    Mobile getById(Integer id);

    boolean update(Mobile mobile);

    boolean deleteById(Integer id);

    List<Mobile> getAll();
}

