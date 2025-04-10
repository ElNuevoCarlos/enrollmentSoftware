package controller;

import java.sql.Connection;

import application.Main;
import data.CourseDAO;
import data.DBConnection;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Book;
import model.Course;


public class CoursesController {
	@FXML private BorderPane rootPane;
    @FXML private TextField codeField;
    @FXML private TextField nameField;
    @FXML private TextField creditsField;
    @FXML private TableView<Course> courseTable;
    @FXML private TableColumn<Course, String> codeColumn;
    @FXML private TableColumn<Course, String> titleColumn;
    @FXML private TableColumn<Course, Integer> creditsColumn;
    
    private Connection connection = DBConnection.getInstance().getConnection();
    private CourseDAO courseDAO = new CourseDAO(connection);
    
    @FXML
    public void initialize() {
        codeColumn.setCellValueFactory(new PropertyValueFactory<>("code"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        creditsColumn.setCellValueFactory(new PropertyValueFactory<>("credits"));
        loadCourses();
    }

    public void loadCourses() {
        courseTable.getItems().setAll(courseDAO.fetch());
    }
    @FXML public void handleSaveCourse() {
    	this.clearFields();
    	
    }
    @FXML public void handleUpdateCourse() {
    	
    	
    }
    @FXML public void handleDeleteCourse() {
		Course course = courseTable.getSelectionModel().getSelectedItem();
		courseDAO.delete(course.getCode());
		initialize();
		this.AlertWindow(null, "Data Successfully Deleted", AlertType.CONFIRMATION);
		
    }
       
    private void clearFields() {
        codeField.clear();
        nameField.clear();
        creditsField.clear();
    }
    @FXML public void goBack() {
    	// CIERRA LA VENTANA ACTUAL
        Stage currentStage = (Stage) rootPane.getScene().getWindow();
        currentStage.close();
        // CIERRA LA VENTANA ACTUAL
        Main.loadView("/view/MainMenu.fxml");
    }
    private void AlertWindow(String text, String content, AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(null);
        alert.setHeaderText(text);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
