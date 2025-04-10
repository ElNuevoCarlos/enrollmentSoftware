package controller;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainMenuController {
	@FXML private BorderPane rootPane;
	
    public void goToStudents() {
    	// CIERRA LA VENTANA ACTUAL
        Stage currentStage = (Stage) rootPane.getScene().getWindow();
        currentStage.close();
        // CIERRA LA VENTANA ACTUAL
        Main.loadView("/view/Students.fxml");
    }

    public void goToCourses() {
    	// CIERRA LA VENTANA ACTUAL
        Stage currentStage = (Stage) rootPane.getScene().getWindow();
        currentStage.close();
        // CIERRA LA VENTANA ACTUAL
        Main.loadView("/view/Courses.fxml");
    }

    public void goToEnrollment() {
    	// CIERRA LA VENTANA ACTUAL
        Stage currentStage = (Stage) rootPane.getScene().getWindow();
        currentStage.close();
        // CIERRA LA VENTANA ACTUAL
        Main.loadView("/view/Enrollments.fxml");
    }

}
