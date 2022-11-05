package application;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import model.FileBuilder;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Scale;


public class Main extends Application {
	
	@Override
	public void start(Stage stage) {

		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource(FileBuilder.FXMLdestination("Workspace")));
			Parent root = loader.load();
			Scene scene = new Scene(root,1280,680);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.getIcons().add(IconLoader.load());
			stage.setTitle("Termverse");
			
			stage.setMinWidth(1280);
			stage.setMinHeight(720);
			stage.setResizable(true);
			
			
			initScale(scene, (Pane)root);
			
			stage.maxHeightProperty().bind(stage.widthProperty().multiply(72.0/128.0));
			stage.minHeightProperty().bind(stage.widthProperty().multiply(72.0/128.0));
			
			stage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	private void initScale(final Scene scene, final Pane contentPane) {
	    final double initWidth  = scene.getWidth();
	    final double initHeight = scene.getHeight();
	    final double ratio      = initWidth / initHeight;

	    SceneSizeChangeListener sizeListener = new SceneSizeChangeListener(scene, ratio, initHeight, initWidth, contentPane);
	    scene.widthProperty().addListener(sizeListener);
	    scene.heightProperty().addListener(sizeListener);
	  }
	
	
	private static class SceneSizeChangeListener implements ChangeListener<Number> {
	    private final Scene scene;
	    private final double ratio;
	    private final double initHeight;
	    private final double initWidth;
	    private final Pane pane;

	    public SceneSizeChangeListener(Scene scene, double ratio, double initHeight, double initWidth, Pane pane) {
	      this.scene = scene;
	      this.ratio = ratio;
	      this.initHeight = initHeight;
	      this.initWidth = initWidth;
	      this.pane = pane;
	    }
	
	@Override
    public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {
      final double newWidth  = scene.getWindow().getWidth();
      final double newHeight = scene.getWindow().getWidth();
      
      double scaleFactor = 0.0;
      if (newWidth / newHeight > ratio) {
    	  scaleFactor = newHeight / initHeight;
      }
      else {
    	  scaleFactor = newWidth / initWidth;
      }

      if (scaleFactor >= 1.0) {
        Scale scale = new Scale(scaleFactor, scaleFactor);
        scale.setPivotX(0);
        scale.setPivotY(0);
        scene.getRoot().getTransforms().setAll(scale);
        pane.setPrefWidth (newWidth  / scaleFactor);
        pane.setPrefHeight(newHeight / scaleFactor);

      } else {
        pane.setPrefWidth (Math.max(initWidth,  newWidth));
        pane.setPrefHeight(Math.max(initHeight, newHeight)); 
      }
      
    }
	}
}
