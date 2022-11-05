package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PopupController {
	@FXML
    private Text messageLabel;

    @FXML
    private Button noButton;

    @FXML
    private Button yesButton;
     
    
    private Runnable acceptCommand;
    
    private Runnable declineCommand;
    
    public void setMessage(String message) {
    	this.messageLabel.setText(message);
    }
    public void setOnAccept(Runnable method) {
    	this.acceptCommand = method;
    }
    public void setOnDecline(Runnable method) {
    	this.declineCommand = method;
    }
    public void doNothingOnDecline() {
    	this.declineCommand = ()->{};
    }
    public void onAccepted() {
    	acceptCommand.run();

    	close();
    }
    
    public void onDecline() {
    	declineCommand.run();
    	close();
    }
    
    private void close() {
    	((Stage)this.messageLabel.getScene().getWindow()).close();
    }
}
