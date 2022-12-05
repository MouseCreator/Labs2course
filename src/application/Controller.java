package application;

import Structure.LogPassword;
import Structure.LoginPasswordPair;
import Structure.PasswordReader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class Controller {
	
	@FXML
	private TextField username;
	@FXML
	private PasswordField password;
	@FXML
	private Text output;
	@FXML
	private TextArea area;
	@FXML
	private Button saveBtn;
	@FXML
	private Button loadBtn;

	
	private void hideArea() {
		area.setVisible(false);
		loadBtn.setVisible(false);
		saveBtn.setVisible(false);
		area.setDisable(true);
		saveBtn.setDisable(true);
		loadBtn.setDisable(true);
	}
	private void showArea() {
		area.setDisable(false);
		saveBtn.setDisable(false);
		loadBtn.setDisable(false);
		area.setVisible(true);
		saveBtn.setVisible(true);
		loadBtn.setVisible(true);
	}
	public void tryToLogin(ActionEvent e) {
		String name = username.getText();
		String entered = password.getText();
		LoginPasswordPair pair = PasswordReader.getFromFile(name);
		if (!pair.empty()) {
			LogPassword.hashPassword(entered);
			boolean isRightPassword = LogPassword.validatePassword(entered, pair.password);
			if (isRightPassword) {
				output.setText("Welcome!");
				output.setFill(Color.GREEN);
				this.loadFromFile();
				showArea();
				
			} else {
				output.setText("Incorrect password!");
				output.setFill(Color.RED);
				hideArea();
			}
			
		}
		else {
			output.setText("This username doesn't exist!");
			output.setFill(Color.BLACK);
			hideArea();
		}
	}
	public void saveToFile() {
		PasswordReader.saveInfo(username.getText(), area.getText());
	}
	public void loadFromFile() {
		area.setText(PasswordReader.loadInfo(username.getText()));
	}
	
}
