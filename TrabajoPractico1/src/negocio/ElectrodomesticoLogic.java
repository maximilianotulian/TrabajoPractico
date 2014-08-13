package negocio;

import java.util.ArrayList;

import datos.*;
import entidades.*;

public class ElectrodomesticoLogic {
	static ElectrodomesticoAdapter adap = new ElectrodomesticoAdapter();
	public static ArrayList<Electrodomestico> getall(){
		return adap.getAll();
	}
	public static ArrayList<Television> getallBD(){
		return adap.getallBD();
	}
	public static void deleteOne(Electrodomestico e){
		adap.deleteOne(e);
	}
	public static void addOne(Electrodomestico e){
		adap.addOne(e);
	}
}