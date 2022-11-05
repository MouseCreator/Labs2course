module Lab2i {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
	requires org.junit.jupiter.api;
	
	opens application to javafx.graphics, javafx.fxml;
	
	opens model to javafx.fxml;
	
	exports model;
}
