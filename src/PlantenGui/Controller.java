package PlantenGui;

import Dao.Database;
import Dao.Queries;
import Model.Plant;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.sql.Connection;
import java.sql.SQLException;

public class Controller {
    public Button btnVooruit;
    public Button btnAchteruit;
    public TextField txtInvoerPlant;
    public TextArea txtUitvoerPlant;
    private Connection dbConnection;
    public Queries queries;

    public  void initialize() throws SQLException {

        // Connection con = Database.getInstance().getConnection();
        dbConnection = Database.getInstance().getConnection();
        System.out.println(dbConnection);
        queries= new Queries(dbConnection);
    }
    public void clicked_Vooruit(MouseEvent mouseEvent) throws SQLException {
        txtUitvoerPlant.setText(txtUitvoerPlant.getText()+ queries.getplantnaam(txtInvoerPlant.getText()));


    }

    public void clicked_Achteruit(MouseEvent mouseEvent) {
    }
}
