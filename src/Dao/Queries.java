package Dao;

import Model.Plant;

import java.sql.*;

public class Queries
{
    private static final String GETPLANTTBYNAAM =
            "SELECT * FROM plant WHERE type LIKE ?";
    private final Connection dbConnection;

    private PreparedStatement STMTGETPLANTBYNAAM;


    public Queries(Connection dbConnection) throws SQLException {
        this.dbConnection = dbConnection;
        STMTGETPLANTBYNAAM = dbConnection.prepareStatement(GETPLANTTBYNAAM);
    }

    public String getplantnaam(String naam) throws SQLException {
        String niets= "nietgelukt";
        STMTGETPLANTBYNAAM.setString(1, "%"+naam+"%");

        ResultSet rs = STMTGETPLANTBYNAAM.executeQuery();

        while (rs.next()) {
            int plantid = rs.getInt("plant_ID");
            String plantnaam = rs.getString("type");
            String familie = rs.getString("familie");
            System.out.println(plantid + "\t" + plantnaam +
                    "\t" + familie);
            //  return plantnaam;
        }
        return niets;

    }
}
