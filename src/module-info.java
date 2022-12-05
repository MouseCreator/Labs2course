module lab2d {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	requires org.junit.jupiter.api;
	requires javafx.base;
	
	opens application to javafx.graphics, javafx.fxml;
}
