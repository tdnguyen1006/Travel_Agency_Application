package pkg2130f16asn2_nguyen_nguyen_miguel;

import java.net.URL;
import java.security.SecureRandom;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Toan_Albert_Albryan_FXMLDocumentController {
        
    ObservableList<String> city = FXCollections.observableArrayList("TORONTO", "VANCOUVER", "WINNIPEG");
    ObservableList<String> title = FXCollections.observableArrayList("MR", "MRS", "MS");
    private final String host = "jdbc:derby:database/Flight;create=true";
    private final String username = "toan";
    private final String password = "toan";
    private Connection conn = null;
    public static Toan_Albert_Albryan_Flight flight = new Toan_Albert_Albryan_Flight();
    
    private void createConnection() throws SQLException
    {
        try
        {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            conn = DriverManager.getConnection(host, username, password);
        }
        catch(ClassNotFoundException | IllegalAccessException | InstantiationException ex)
        {
            ex.printStackTrace();
        }
    }
    
    private void createDBTable() throws SQLException
    {
        String Table_Name = "RESERVATION";
        String query = "create table " + Table_Name + "(" +
                       "	RESERVATION_ID VARCHAR(16) not null primary key,\n" +
                       "	TITLE VARCHAR(3),\n" +
                       "	FIRST_NAME VARCHAR(30),\n" +
                       "	LAST_NAME VARCHAR(30),\n" +
                       "	PASSPORT VARCHAR(7),\n" +
                       "	DOB VARCHAR(20),\n" +
                       "	EMAIL VARCHAR(100),\n" +
                       "	TEL VARCHAR(10),\n" +
                       "	DEPARTURE VARCHAR(10),\n" +
                       "	DESTINATION VARCHAR(10),\n" +
                       "	DATE_OF_LEAVING VARCHAR(20),\n" +
                       "	FLIGHT_NO VARCHAR(5),\n" +
                       "	FARE DOUBLE, TOTAL_FARE DOUBLE)";
        try
        {
            createConnection();
            Statement stmt = conn.createStatement();
            DatabaseMetaData dbmd = conn.getMetaData();
            ResultSet rs = dbmd.getTables(null, null, Table_Name, null);
            
            if(rs.next() == false)
            {
                stmt.execute(query);
            }
            
            stmt.close();
            rs.close();
        }
        catch(SQLException ex)
        {
            lblerr_tabTI.setVisible(true);
            lblerr_tabTI.setText(ex.getMessage());
        }
    }
    
    @FXML
    private ResourceBundle resources;
    
    @FXML
    private URL location;
    
    @FXML
    private ComboBox cbDestination;
    
    @FXML
    private ComboBox cbsource;
    
    @FXML
    private ComboBox cbtitle;
    
    @FXML
    private ComboBox cbtitle_update;
    
    @FXML
    private DatePicker dpLeavingDate;
    
    @FXML
    private DatePicker dpDoB;
    
    @FXML
    private DatePicker dpDoB_update;
    
    @FXML
    private TabPane tabPane;
    
    @FXML
    private Tab tabHome;
    
    @FXML
    private Tab tabFlight;
    
    @FXML
    private Tab tabTravellerInfo;
    
    @FXML
    private Tab tabSummary;
    
    @FXML
    private Tab tabSearch;
    
    @FXML
    private Tab tabUpdateInfo;
    
    @FXML
    private Label lblerr_tabFlight;
    
    @FXML
    private Label lblerr_tabTI;
    
    @FXML
    private Label lblerr_tabSeach;
    
    @FXML
    private Label lblName;
    
    @FXML
    private Label lblPassport;
    
    @FXML
    private Label lblDoB;
    
    @FXML
    private Label lblEmail;
    
    @FXML
    private Label lblTel;
    
    @FXML
    private Label lblReservationID;
    
    @FXML
    private Label lblsrc;
    
    @FXML
    private Label lbldestination;
    
    @FXML
    private Label lbldepartdate;
    
    @FXML
    private Label lblflightno;
    
    @FXML
    private Label lblfare;
    
    @FXML
    private Label lblerr_tabUpdate;
    
    @FXML
    private TextField txtFirst;
    
    @FXML
    private TextField txtLast;
    
    @FXML
    private TextField txtPassport;
    
    @FXML
    private TextField txtEmail;
    
    @FXML
    private TextField txtPhone;
    
    @FXML
    private TextField txtID;
    
    @FXML
    private TextField txtLName;
    
    @FXML
    private TextField txtPID;
    
    @FXML
    private TextField txtEmail_update;
    
    @FXML
    private TextField txtFirst_update;
    
    @FXML
    private TextField txtLast_update;
    
    @FXML
    private TextField txtPassport_update;
    
    @FXML
    private TextField txtPhone_update;
    
    @FXML
    private TextField txtRID;
    
    @FXML
    private void initialize() throws SQLException {
        remove_tab_Flight();
        remove_tab_Traveller_Info();
        remove_tab_Summary();
        remove_tab_Search();
        remove_tab_Update();
        createDBTable();
    }
    
    private void FillCityList()
    {
        cbsource.setItems(city);
        cbDestination.setItems(city);
    }
    
    private void FillTitleList()
    {
        cbtitle.setItems(title);
    }
    
    //Tab Control
    private void add_tab_home()
    {
        if(!tabPane. getTabs().contains(tabHome))
        {
            tabPane. getTabs().add(tabHome);
        }
    }
    
    private void add_tab_flight()
    {
        if(!tabPane. getTabs().contains(tabFlight))
        {
            tabPane. getTabs().add(tabFlight);
        }
    }
    
    private void add_tab_traveller_info()
    {
         if(!tabPane. getTabs().contains(tabTravellerInfo))
        {
            tabPane. getTabs().add(tabTravellerInfo);
        }
    }
    
    private void add_tab_Summary()
    {
         if(!tabPane. getTabs().contains(tabSummary))
        {
            tabPane. getTabs().add(tabSummary);
        }
    }
    
    private void add_tab_Update()
    {
         if(!tabPane. getTabs().contains(tabUpdateInfo))
        {
            tabPane. getTabs().add(tabUpdateInfo);
        }
    }
    
    private void add_tab_Search()
    {
         if(!tabPane. getTabs().contains(tabSearch))
        {
            tabPane. getTabs().add(tabSearch);
        }
    }
    
    private void remove_tab_home()
    {
        tabPane.getTabs().remove(tabHome);
    }
    
    private void remove_tab_Flight()
    {
        tabPane.getTabs().remove(tabFlight);
    }
    
    private void remove_tab_Traveller_Info()
    {
        tabPane.getTabs().remove(tabTravellerInfo);
    }
    
    private void remove_tab_Summary()
    {
        tabPane.getTabs().remove(tabSummary);
    }
    
    private void remove_tab_Search()
    {
        tabPane.getTabs().remove(tabSearch);
    }
    
    private void remove_tab_Update()
    {
        tabPane.getTabs().remove(tabUpdateInfo);
    }
    
    private void select_tab_home()
    {
        tabPane.getSelectionModel().select(tabHome);
    }
    
    private void select_tab_Flight()
    {
        tabPane.getSelectionModel().select(tabFlight);
    }
    
    private void select_tab_traveller_info()
    {
        tabPane.getSelectionModel().select(tabTravellerInfo);
    }
    
    private void select_tab_Summary()
    {
        tabPane.getSelectionModel().select(tabSummary);
    }
    
    private void select_tab_Update()
    {
        tabPane.getSelectionModel().select(tabUpdateInfo);
    }
    
    private void select_tab_Search()
    {
        tabPane.getSelectionModel().select(tabSearch);
    }
    
    private void clear_tab_Flight()
    {
        cbDestination.getSelectionModel().clearSelection();
        cbsource.getSelectionModel().clearSelection();
        dpLeavingDate.setValue(null);
        lblerr_tabFlight.setText("");
        lblerr_tabFlight.setVisible(false);
    }
    
    private void clear_tab_TI()
    {
        cbtitle.getSelectionModel().clearAndSelect(-1);
        dpDoB.setValue(null);
        txtFirst.setText("");
        txtLast.setText("");
        txtPassport.setText("");
        txtEmail.setText("");
        txtPhone.setText("");
        lblerr_tabTI.setText("");
        lblerr_tabTI.setVisible(false);
    }
    
    @FXML
    public void btnStart_Click(ActionEvent event)
    {
        remove_tab_home();
        add_tab_flight();
        select_tab_Flight();
        FillCityList();
        lblerr_tabFlight.setVisible(false);
    }
    
    @FXML
    public void btnHome_Click(ActionEvent event)
    {
       remove_tab_Flight();
       remove_tab_Traveller_Info();
       remove_tab_Summary();
       remove_tab_Search();
       remove_tab_Update();
       add_tab_home();
       select_tab_home();
       clear_tab_Flight();
       clear_tab_TI();
    }
    
    @FXML
    public void btnClear_tabFlight_Click(ActionEvent event)
    {
        clear_tab_Flight();
    }
    
    @FXML
    public void btnClear_tabTI_Click(ActionEvent event)
    {
        clear_tab_TI();
    }
    @FXML
    public void btnNext_tabFlight_Click(ActionEvent event)
    {
        if(cbsource.getValue() == null)
        {
            lblerr_tabFlight.setVisible(true);
            lblerr_tabFlight.setText("Leaving From cannot be blank.");
        }
        else if(cbDestination.getValue() == null)
        {
            lblerr_tabFlight.setVisible(true);
            lblerr_tabFlight.setText("Going To cannot be blank.");
        }
        else if(dpLeavingDate.getValue() == null)
        {
            lblerr_tabFlight.setVisible(true);
            lblerr_tabFlight.setText("Leaving On cannot be blank.");
        }
        else if(cbsource.getValue() == cbDestination.getValue())
        {
            lblerr_tabFlight.setVisible(true);
            lblerr_tabFlight.setText("Leaving From must be different from Going To");
        }
        else if(dpLeavingDate.getValue().isBefore(LocalDate.now().plusDays(1)) == true)
        {
            lblerr_tabFlight.setVisible(true);
            lblerr_tabFlight.setText("The earliest available date is: " + LocalDate.now().plusDays(1).format(DateTimeFormatter.ofPattern("dd MMMM yyyy")));
        }
        else
        {
            lblerr_tabFlight.setVisible(false);
            flight.setreservenumber(create_Reservation_Number());
            flight.setdateleaving(dpLeavingDate.getValue().format(DateTimeFormatter.ofPattern("dd MMMM yyyy")).toUpperCase().trim());
            flight.setsrc(cbsource.getValue().toString().toUpperCase().trim());
            flight.setdest(cbDestination.getValue().toString().toUpperCase().trim());
            flight.setFligthno("TC" + (int)(Math.random() * (999 - 100 + 1) + 100));
            switch(flight.getSource())
            {
                case "TORONTO":
                    switch(flight.getDest())
                    {
                        case "VANCOUVER":
                            flight.setfare(637);
                            break;
                        case "WINNIPEG":
                            flight.setfare(436);
                            break;
                    }
                    break;
                case "VANCOUVER":
                    switch(flight.getDest())
                    {
                        case "TORONTO":
                            flight.setfare(637);
                            break;
                        case "WINNIPEG":
                            flight.setfare(393);
                            break;
                    }
                    break;
                case "WINNIPEG":
                    switch(flight.getDest())
                    {
                        case "TORONTO":
                            flight.setfare(436);
                            break;
                        case "VANCOUVER":
                            flight.setfare(393);
                            break;
                    }
                    break;
            }
            remove_tab_Flight();
            add_tab_traveller_info();
            select_tab_traveller_info();
            FillTitleList();
        }
    }
    
    private String create_Reservation_Number()
    {
        Random rdn = new SecureRandom();
        String rn = "";
        String regex = "ABCDEFGHIJKMNPQRSTUVWXYZ123456789";
        for (int i = 0; i < 16; i++)
        {
            int index = (int)(rdn.nextDouble()*regex.length());
            rn += regex.substring(index, index + 1);
        }
        return rn;
    }
    
    @FXML
    public void btnBack_tabTI_Click(ActionEvent event)
    {
        remove_tab_Traveller_Info();
        add_tab_flight();
        select_tab_Flight();
        lblerr_tabTI.setVisible(false);
    }
    
    private boolean validateText(String str)
    {
        return str.matches("[a-zA-Z]+");
    }
    
    private boolean validatePassport(String str)
    {
        return str.matches("[a-zA-Z][0-9]{6}");
    }
    
    private boolean validatePhone(String str)
    {
        return str.matches("[1-9][0-9]{9}");
    }
    
    private boolean validateEmail(String str)
    {
        return str.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
    }
    
    @FXML
    public void btnNext_tabTI_Click(ActionEvent event)
    {
        if(cbtitle.getValue() == null)
        {
            lblerr_tabTI.setVisible(true);
            lblerr_tabTI.setText("Please indicate your Title.");
        }
        else if(validateText(txtFirst.getText()) == false)
        {
            lblerr_tabTI.setVisible(true);
            lblerr_tabTI.setText("First Name should be character only and cannot be blank.");
        }
        else if(validateText(txtLast.getText()) == false)
        {
            lblerr_tabTI.setVisible(true);
            lblerr_tabTI.setText("Last Name should be character only and cannot be blank.");
        }
        else if(validatePassport(txtPassport.getText()) == false)
        {
            lblerr_tabTI.setVisible(true);
            lblerr_tabTI.setText("Please enter the valid Passpor No/ID. Example: B123456");
        }
        else if(dpDoB.getValue() == null)
        {
            lblerr_tabTI.setVisible(true);
            lblerr_tabTI.setText("Date of Birth cannot be blank.");
        }
        else if(dpDoB.getValue().isAfter(LocalDate.now().minusYears(6)) == true)
        {
            lblerr_tabTI.setVisible(true);
            lblerr_tabTI.setText("Only person whose Date of Birth is before " + 
                    LocalDate.now().minusYears(6).format(DateTimeFormatter.ofPattern("dd MMMM yyyy")) + 
                    " can book a flight");
        }
        else if(validateEmail(txtEmail.getText()) == false)
        {
            lblerr_tabTI.setVisible(true);
            lblerr_tabTI.setText("Invalid Email Address. Example: info@gmail.com");
        }
        else if(validatePhone(txtPhone.getText()) == false)
        {
            lblerr_tabTI.setVisible(true);
            lblerr_tabTI.setText("Please enter the valid phone number. 10 digits only.");
        }
        else
        {
            traveller_info();
            insert_into_reservation_table();
        }
    }
    
    private void traveller_info()
    {
        flight.setTitle(cbtitle.getValue().toString().toUpperCase().trim());
        flight.setFirstName(txtFirst.getText().toUpperCase().trim());
        flight.setLastName(txtLast.getText().toUpperCase().trim());
        flight.setPassport(txtPassport.getText().toUpperCase().trim());
        flight.setDoB(dpDoB.getValue().format(DateTimeFormatter.ofPattern("dd MMMM yyyy")).toUpperCase().trim());
        flight.setemail(txtEmail.getText().trim());
        flight.setPhone(txtPhone.getText().trim());
    }
    
    private void clear_receipt()
    {
        lblName.setText("");
        lblPassport.setText("");
        lblDoB.setText("");
        lblEmail.setText("");
        lblTel.setText("");
        lblReservationID.setText("");
        lblsrc.setText("");
        lbldestination.setText("");
        lbldepartdate.setText("");
        lblflightno.setText("");
        lblfare.setText("");
    }
    
    private void display_receipt()
    {
        clear_receipt();
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        lblName.setText(flight.getTitle() + ". " + flight.getFirstName() + " " + flight.getLastName());
        lblPassport.setText(flight.getPassport());
        lblDoB.setText(flight.getDoB());
        lblEmail.setText(flight.getemail());
        lblTel.setText(flight.getPhone());
        lblReservationID.setText(flight.getreservenumber());
        lblsrc.setText(flight.getSource());
        lbldestination.setText(flight.getDest());
        lbldepartdate.setText(flight.getdateleaving());
        lblflightno.setText(flight.getFlightno());
        lblfare.setText(formatter.format(flight.calculateTotalFare()));
    }
    
    @FXML
    public void btnViewReservation_Click(ActionEvent event)
    {
        remove_tab_home();
        remove_tab_Update();
        select_tab_Search();
        add_tab_Search();
        txtID.setText("");
        txtLName.setText("");
        txtPID.setText("");
        lblerr_tabSeach.setVisible(false);
        lblerr_tabSeach.setText("");
    }
    
    private void insert_into_reservation_table()
    {
        try
        {
            String sql = "INSERT INTO RESERVATION(RESERVATION_ID, TITLE, FIRST_NAME, LAST_NAME, PASSPORT, DOB, EMAIL, TEL, DEPARTURE, DESTINATION, DATE_OF_LEAVING, FLIGHT_NO, FARE, TOTAL_FARE) " + 
                         "VALUES ('" + flight.getreservenumber() + "', '" + flight.getTitle() + "', '" + flight.getFirstName() + "', '" + flight.getLastName() + 
                         "', '" + flight.getPassport() + "', '" + flight.getDoB() + "', '" + flight.getemail() + "', '" + flight.getPhone() + "', '" + flight.getSource() + 
                         "', '" + flight.getDest() + "', '" + flight.getdateleaving() + "', '" + flight.getFlightno() + "', " + flight.getFare()+ ", " + flight.calculateTotalFare() +")";
            createConnection();
            Statement stmt = conn.createStatement();
            int i = stmt.executeUpdate(sql);
            if(i > 0)
            {
                remove_tab_Traveller_Info();
                add_tab_Summary();
                select_tab_Summary();
                display_receipt();
            }
            else
            {
                lblerr_tabTI.setVisible(true);
                lblerr_tabTI.setText("Error");
            }
            stmt.close();
        }
        catch(SQLException ex)
        {
            lblerr_tabTI.setVisible(true);
            lblerr_tabTI.setText(ex.getMessage());
        }
    }
    
    @FXML
    public void btnView_Click(ActionEvent event)
    {
        try
        {
            String sql = "SELECT * FROM RESERVATION WHERE RESERVATION_ID = '" + txtID.getText().toUpperCase() + "' AND LAST_NAME = '" + txtLName.getText().toUpperCase() + 
                         "' AND PASSPORT = '" + txtPID.getText().toUpperCase() + "'";
            createConnection();
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery(sql);
            int rowCount = rs.last() ? rs.getRow() : 0;
            if(rowCount == 1)
            {
                flight.setreservenumber(rs.getString("RESERVATION_ID"));
                flight.setdateleaving(rs.getString("DATE_OF_LEAVING"));
                flight.setsrc(rs.getString("DEPARTURE"));
                flight.setdest(rs.getString("DESTINATION"));
                flight.setFligthno(rs.getString("FLIGHT_NO"));
                flight.setTitle(rs.getString("TITLE"));
                flight.setFirstName(rs.getString("FIRST_NAME"));
                flight.setLastName(rs.getString("LAST_NAME"));
                flight.setPassport(rs.getString("PASSPORT"));
                flight.setDoB(rs.getString("DOB"));
                flight.setemail(rs.getString("EMAIL"));
                flight.setPhone(rs.getString("TEL"));
                flight.setfare(rs.getDouble("FARE"));
                
                display_receipt();
                remove_tab_Search();
                add_tab_Summary();
                select_tab_Summary();
            }
            else
            {
                lblerr_tabSeach.setVisible(true);
                lblerr_tabSeach.setText("No Record Found");
            }
            rs.close();
        }
        catch(SQLException ex)
        {
            lblerr_tabSeach.setVisible(true);
            lblerr_tabSeach.setText(ex.getMessage());
        }
    }
    
    @FXML
    public void btnGotoUpdate_Click(ActionEvent event)
    {
        try
        {
            String sql = "SELECT * FROM RESERVATION WHERE RESERVATION_ID = '" + txtID.getText().toUpperCase() + "' AND LAST_NAME = '" + txtLName.getText().toUpperCase() + 
                         "' AND PASSPORT = '" + txtPID.getText().toUpperCase() + "'";
            createConnection();
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery(sql);
            int rowCount = rs.last() ? rs.getRow() : 0;
            if(rowCount == 1)
            {
                flight.setreservenumber(rs.getString("RESERVATION_ID"));
                flight.setTitle(rs.getString("TITLE"));
                flight.setFirstName(rs.getString("FIRST_NAME"));
                flight.setLastName(rs.getString("LAST_NAME"));
                flight.setPassport(rs.getString("PASSPORT"));
                flight.setDoB(rs.getString("DOB"));
                flight.setemail(rs.getString("EMAIL"));
                flight.setPhone(rs.getString("TEL"));
                
                txtRID.setText(flight.getreservenumber());
                cbtitle_update.setItems(title);
                cbtitle_update.setValue(flight.getTitle());
                txtFirst_update.setText(flight.getFirstName());
                txtLast_update.setText(flight.getLastName());
                txtPassport_update.setText(flight.getPassport());
                txtEmail_update.setText(flight.getemail());
                txtPhone_update.setText(flight.getPhone());
                
                remove_tab_Search();
                add_tab_Update();
                select_tab_Update();
            }
            else
            {
                lblerr_tabSeach.setVisible(true);
                lblerr_tabSeach.setText("No Record Found");
            }
            rs.close();
        }
        catch(SQLException ex)
        {
            lblerr_tabSeach.setVisible(true);
            lblerr_tabSeach.setText(ex.getMessage());
        }
    }
    
    @FXML
    public void btnUpdate_Click(ActionEvent event)
    {
        if(cbtitle_update.getValue() == null)
        {
            lblerr_tabUpdate.setVisible(true);
            lblerr_tabUpdate.setText("Please indicate your Title.");
        }
        else if(validateText(txtFirst_update.getText()) == false)
        {
            lblerr_tabUpdate.setVisible(true);
            lblerr_tabUpdate.setText("First Name should be character only and cannot be blank.");
        }
        else if(validateText(txtLast_update.getText()) == false)
        {
            lblerr_tabUpdate.setVisible(true);
            lblerr_tabUpdate.setText("Last Name should be character only and cannot be blank.");
        }
        else if(validatePassport(txtPassport_update.getText()) == false)
        {
            lblerr_tabUpdate.setVisible(true);
            lblerr_tabUpdate.setText("Please enter the valid Passpor No/ID. Example: B123456");
        }
        else if(dpDoB_update.getValue() == null)
        {
            lblerr_tabUpdate.setVisible(true);
            lblerr_tabUpdate.setText("Date of Birth cannot be blank.");
        }
        else if(dpDoB_update.getValue().isAfter(LocalDate.now().minusYears(6)) == true)
        {
            lblerr_tabUpdate.setVisible(true);
            lblerr_tabUpdate.setText("Only person whose Date of Birth is before " + 
                    LocalDate.now().minusYears(6).format(DateTimeFormatter.ofPattern("dd MMMM yyyy")) + 
                    " can book a flight");
        }
        else if(validateEmail(txtEmail_update.getText()) == false)
        {
            lblerr_tabUpdate.setVisible(true);
            lblerr_tabUpdate.setText("Invalid Email Address. Example: info@gmail.com");
        }
        else if(validatePhone(txtPhone_update.getText()) == false)
        {
            lblerr_tabUpdate.setVisible(true);
            lblerr_tabUpdate.setText("Please enter the valid phone number. 10 digits only.");
        }
        else
        {
            try
            {
                String sql = "UPDATE RESERVATION SET " + 
                             "TITLE = '" + cbtitle_update.getValue().toString().toUpperCase() + 
                             "', FIRST_NAME = '" + txtFirst_update.getText().toUpperCase().trim() + 
                             "', LAST_NAME = '" + txtLast_update.getText().toUpperCase().trim() + 
                             "', PASSPORT = '" + txtPassport_update.getText().toUpperCase().trim() + 
                             "', DOB = '" + dpDoB_update.getValue().format(DateTimeFormatter.ofPattern("dd MMMM yyyy")).toUpperCase().trim() + 
                             "', EMAIL = '" + txtEmail_update.getText().trim() + 
                             "', TEL = '" + txtPhone_update.getText().trim() + "' WHERE RESERVATION_ID = '" + txtRID.getText() + "'";
                createConnection();
                Statement stmt = conn.createStatement();
                int i = stmt.executeUpdate(sql);
                if(i > 0)
                {
                    lblerr_tabUpdate.setVisible(true);
                    lblerr_tabUpdate.setText("Update Information Successfully.");
                }
                else
                {
                    lblerr_tabUpdate.setVisible(true);
                    lblerr_tabUpdate.setText("Update Information Failed.");
                }
                stmt.close();
            }
            catch(SQLException ex)
            {
                lblerr_tabUpdate.setVisible(true);
                lblerr_tabUpdate.setText(ex.getMessage());
            }
        }
    }
}
