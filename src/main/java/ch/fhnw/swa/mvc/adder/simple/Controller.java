package ch.fhnw.swa.mvc.adder.simple;


public class Controller {

	public Controller(final View view) {
		Model m = view.model();
		view.op1().textProperty()
				.addListener((observable, oldValue, newValue) -> m.value1.set(intFromString(newValue, 10)));
		view.op2().textProperty()
				.addListener((observable, oldValue, newValue) -> m.value2.set(intFromString(newValue, 10)));
	}

	private int intFromString(String s, int base) {
		try {
			return Integer.parseInt(s, base);
		}
		catch (NumberFormatException e) {
			return 0;
		}
	}
}
