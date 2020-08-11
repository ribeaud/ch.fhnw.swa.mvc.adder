package ch.fhnw.swa.mvc.adder.withhex;

import javafx.beans.binding.NumberBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Model {
    public final IntegerProperty value1 = new SimpleIntegerProperty();
    public final IntegerProperty value2 = new SimpleIntegerProperty();
    public final NumberBinding sumVal = value1.add(value2);
}
