package paquete;
import java.util.ArrayList;

public class Carrito {
	
	ArrayList <String> carro = new ArrayList <String>();
	
	public Carrito() {
		// TODO Auto-generated constructor stub
	
	}
	
	public void setProducto(String x){
		carro.add(x);
	}
	
	public String getProducto(int x){
		
	return carro.get(x);	
	}
	
	public String getCarro(){
		String x = "";
		for(int i=0;i<carro.size();i++){
			
			x = x+carro.get(i)+"/";
		}
		
		return x;
	}
}
