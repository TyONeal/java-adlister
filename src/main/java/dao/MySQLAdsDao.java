package dao;

import java.sql.*;

import com.mysql.cj.jdbc.Driver;
import dao.Ads;
import models.Ad;

import javax.servlet.ServletException;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {

    private Connection connection;
    private Statement statement;
    String selectAllQuery = "SELECT * FROM adlister_db.ads";


    public MySQLAdsDao(Config config) throws SQLException {
        DriverManager.registerDriver(new Driver());
        this.connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUser(),
                config.getPassword()
        );
    }

    @Override
    public List<Ad> all() {
            List<Ad> ads = new ArrayList<>();
        try{
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(selectAllQuery);
            while (rs.next()) {
                int id = rs.getInt("id");
                int userID = rs.getInt("user_id");
                String title = rs.getString("title");
                String description = rs.getString("description");

                Ad ad = new Ad(id, userID, title, description);
                ads.add(ad);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ads;
    }

    @Override
    public Long insert(Ad ad) throws SQLException {
        String sql = "INSERT INTO adlister_db.ads (user_id, title, description) VALUES (" +
                ad.getUserId() + ", '" +
                ad.getTitle() + "', '" +
                ad.getDescription() + "')";

        try (Statement statement = connection.createStatement()) {
            int rowsAffected = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);

            if (rowsAffected > 0) {
                ResultSet rs = statement.getGeneratedKeys();
                if (rs.next()) {
                    return rs.getLong(1); // Return the generated ID
                }
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return null; // Insertion failed
    }







}
