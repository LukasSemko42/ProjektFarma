package sk.upjs.paz;

import sk.upjs.jpaz2.*;

public class Launcher {

	public static void main(String[] args) {
		ObjectInspector oi = new ObjectInspector();
		Farma farm = new Farma(3);
		oi.inspect(farm);
	}
}