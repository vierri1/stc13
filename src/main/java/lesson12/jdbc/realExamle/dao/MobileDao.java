package lesson12.jdbc.realExamle.dao;

import lesson12.jdbc.realExamle.pojo.Mobile;

public interface MobileDao {
    boolean addMobile(Mobile mobile);

    Mobile getMobileById(Integer id);

}
