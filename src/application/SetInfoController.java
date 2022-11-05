package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import model.FileBuilder;
import model.Folder;
import model.SetIndex;
import model.StudyTerm;
import model.TermList;

public class SetInfoController extends AttachedToStudySetIndexController implements Initializable{

    public SetInfoController(WorkspaceController parent) {
		super(parent);
	}
    public SetInfoController() {
		super();
	}
    
    public SetInfoController(WorkspaceController parent, SetIndex index) {
    	super(parent);
		this.index = index;
	}

	private TermList list;
    
    private ObservableList<StudyTerm> observableList = FXCollections.observableArrayList(); 
    @FXML
    private TableColumn<StudyTerm, Integer> idColumn;
	@FXML
    private TableColumn<StudyTerm, String> definitionColumn;

    @FXML
    private Pane itemPane;

    @FXML
    private TableColumn<StudyTerm, String> statusColumn;

    @FXML
    private TableColumn<StudyTerm, String> termColumn;

    @FXML
    private TableView<StudyTerm> termTable;
    @FXML
    private Button removeFromThisFolderBtn;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		idColumn.setCellValueFactory(new PropertyValueFactory<StudyTerm, Integer>("index"));
		termColumn.setCellValueFactory(new PropertyValueFactory<StudyTerm, String>("term"));
		definitionColumn.setCellValueFactory(new PropertyValueFactory<StudyTerm, String>("definition"));
		statusColumn.setCellValueFactory(new PropertyValueFactory<StudyTerm, String>("progressString"));
	}
	
	
	private void initItem(SetIndex from) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setLocation(getClass().getResource("item.fxml"));
		itemPane.getChildren().add(fxmlLoader.load());
		
		ItemController itemController = fxmlLoader.getController();
		itemController.setData(from);
	}	
	public void loadTems() throws IOException {
		list = FileBuilder.readTerms(index.getID());
		displayTerms();
	}
	
	public void displayTerms() {
		observableList.clear();
		observableList.addAll(list.asArrayList());
		termTable.setItems(observableList);
	}
	@Override
	public void initContent() {
		try {
			initItem(this.index);
			loadTems();
			initFolderButton();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void initFolderButton() {
		this.removeFromThisFolderBtn.setVisible(getParent().getLastActive().getIndex() != Folder.ALL_SETS);
	}
	public void startLearning() {
		getParent().loadAttachedToIndex(Pages.SET_WRITE, this.index);
	}
	
	public void onRefresh() throws IOException {
		list.refresh();
		index.setElementsMastered(0);
		initItem(index);
		displayTerms();
	}
	public void onEdit() {
		getParent().loadAttachedToIndex(Pages.SET_EDITOR, index);
	}
	public void onAddToFolder() {
		getParent().displayFoldersWindow();
		getParent().getFolderView().toAddIndex(index);
	}
	public void onRemoveFromFolder() {
		getParent().getUserData().removeSetFromFolder(index, getParent().getLastActive());
		getParent().refreshLastActive();
		getParent().loadAttachedToIndex(Pages.SET_INFO, index);
	}
	@Override
	public void onClose() {
		super.onClose();
		FileBuilder.writeTerms(index.getID(), list);
	}

}
