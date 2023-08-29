import java.sql.*;

import com.mysql.cj.jdbc.Driver;

import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads{

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
    public List<Ad> all() throws SQLException {
        List<Ad> ads = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(selectAllQuery);
        while (rs.next()) {
            int id = rs.getInt("userid");
            String title = rs.getString("title");
            String description = rs.getString("description");
            int userID = rs.getInt("user_id");
            System.out.println("in the while loop");

            Ad ad = new Ad(id, userID, title, description);

            System.out.println(ad + " <-- this is the ad");
            ads.add(ad);

        }
        return ads;
    }

    @Override
    public Long insert(Ad ad) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate("INSERT INTO adlister_db.ads (id, user_id, title, description) VALUES (6, 1, 'testAd', 'This ad is a test')", Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = statement.getGeneratedKeys();
        long results = rs.getLong(1);
        return results;
    }
}
