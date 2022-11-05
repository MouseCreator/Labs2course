package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class MenuBarController {

	@FXML
    private MenuBar CommonMenuBar;

    @FXML
    private MenuItem NewSetItem;

    @FXML
    private MenuItem OpenSetItem;

    @FXML
    private MenuItem ViewProfileItem;

    @FXML
    private MenuItem viewFolderItem;
    
    private WorkspaceController parentController;
	
	public void switchToEditor(ActionEvent event) throws IOException {
		parentController.loadAttachedToIndex(Pages.SET_EDITOR, parentController.getUserData().genNewIndex()); 
	}
	public void switchToSetOpen(ActionEvent event) throws IOException {
		parentController.loadWithAllFolders(Pages.SET_OPEN); 
	}
	public void viewFolderList(ActionEvent event) throws IOException {
		parentController.displayFoldersWindow();
	}
	public void switchToProfile(ActionEvent event) throws IOException {
		parentController.loadPage(Pages.PROFILE);
	}
	public void setParent(WorkspaceController controller) {
		parentController = controller;
	}
	
	
	

}
