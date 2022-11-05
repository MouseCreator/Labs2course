package application;

import model.Folder;

public abstract class AttachedToFolderController extends ActivePaneController {
	protected Folder folder;
	
	public Folder getFolder() {
		return folder;
	}
	public void setFolder(Folder folder) {
		this.folder = folder;
	}
	public AttachedToFolderController(WorkspaceController parent) {
		super(parent);
	}
	public AttachedToFolderController() {
		super();
	}
	@Override
	public void onClose() {
		getParent().getUserData().autoSave();
	}
}
