package lesson12.jdbc.realExamle.dao.mobile;

import lesson12.jdbc.realExamle.ConnectionManager.ConnectionManager;
import lesson12.jdbc.realExamle.ConnectionManager.ConnectionManagerJdbcImpl;
import lesson12.jdbc.realExamle.dao.manufacturer.ManufacturerDao;
import lesson12.jdbc.realExamle.dao.manufacturer.ManufacturerDaoImpl;
import lesson12.jdbc.realExamle.pojo.Manufacturer;
import lesson12.jdbc.realExamle.pojo.Mobile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MobileDaoImpl implements MobileDao {

    private ConnectionManager connectionManager = ConnectionManagerJdbcImpl.getInstance();
    private ManufacturerDao manufacturerDao = new ManufacturerDaoImpl();

    @Override
    public boolean add(Mobile mobile) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement("INSERT INTO mobile VALUES (DEFAULT, ?, ?, ?)")) {
            preparedStatement.setString(1, mobile.getModel());
            preparedStatement.setFloat(2, mobile.getPrice());
            preparedStatement.setInt(3, mobile.getManufacturer().getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Mobile getById(Integer id) {
        Mobile mobile = null;
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement("SELECT * FROM mobile WHERE id=?")) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Integer manufacturer_id = resultSet.getInt("manufacturer_id");
                Manufacturer manufacturer = manufacturerDao.getById(manufacturer_id);
                mobile = new Mobile(
                        resultSet.getInt("id"),
                        resultSet.getString("model"),
                        resultSet.getFloat("price"),
                        manufacturer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mobile;
    }

    @Override
    public boolean update(Mobile mobile) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE mobile SET model=?, price=?, manufacturer_id=? WHERE id=?")) {
            preparedStatement.setString(1, mobile.getModel());
            preparedStatement.setFloat(2, mobile.getPrice());
            preparedStatement.setInt(3, mobile.getManufacturer().getId());
            preparedStatement.setInt(4, mobile.getId());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteById(Integer id) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "DELETE FROM mobile WHERE id=?"
             )) {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Mobile> getAll() {
        List<Mobile> mobiles = null;
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement("SELECT * FROM mobile")) {
            mobiles = new ArrayList<>();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String model = resultSet.getString("model");
                Float price = resultSet.getFloat("price");
                Integer manufacturer_id = resultSet.getInt("manufacturer_id");
                mobiles.add(new Mobile(id, model, price, manufacturerDao.getById(manufacturer_id)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mobiles;
    }
}
