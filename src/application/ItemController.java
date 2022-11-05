package application;

import javafx.scene.layout.GridPane;
import model.Dates;
import model.SetIndex;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
public class ItemController {

	@FXML
    private Label createdDateLabel;

    @FXML
    private Label itemNameLabel;

    @FXML
    private Label studiedDateLabed;

    @FXML
    private ProgressBar studyProgressBar;

    @FXML
    private GridPane tagsGrid;

    @FXML
    private Label termCountLabel;
    
    private SetIndex index;
    
    
    
    
    public void setData(SetIndex from) {
    	this.index = from;
    	itemNameLabel.setText(from.getName());
    	createdDateLabel.setText("Created: " +Dates.toDateFormatShort( from.getCreatedDate()));
    	studiedDateLabed.setText("Last studied: " + Dates.toDateFormatShort(from.getLastStudied()));
    	studyProgressBar.setProgress(((float) from.getElementsMastered()) / from.getElementsCount());
    	
    	if (studyProgressBar.getProgress() < 0.5f) {
    		studyProgressBar.setStyle(" -fx-accent: red;");
    	}
    	else if (studyProgressBar.getProgress() < 1.f) {
    		studyProgressBar.setStyle(" -fx-accent: yellow;");
    	}
    	else {
    		studyProgressBar.setStyle(" -fx-accent: green;  ");
    	}
    	termCountLabel.setText(from.getElementsCount() + " terms");
    }
    
    public SetIndex getIndex() {
    	return index;
    }
    

}
