package application;

import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.FileBuilder;

public class IconLoader {
	public static Image load() {
		return new Image(FileBuilder.getIconDestination());
	}
	
	public static Image loadAttentionIcon() {
		return new Image(FileBuilder.getAttentionIconDestination());
	}
	
	public static void addIcon(Stage addTo) {
		addTo.getIcons().add(load());
	}
	
	public static void addAttentionIcon(Stage addTo) {
		addTo.getIcons().add(loadAttentionIcon());
	}
}