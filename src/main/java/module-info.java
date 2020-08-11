module ch.fhnw.swa.mvc.adder {
	opens ch.fhnw.swa.mvc.adder.simple;
	opens ch.fhnw.swa.mvc.adder.withhex;

	requires javafx.base;
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
}