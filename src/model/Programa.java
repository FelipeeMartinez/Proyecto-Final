package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Programa 
{
	public static void main (String[] args) throws NumberFormatException, IOException 
	{
		Banco bank = new Banco();
		
		BufferedReader buf = new BufferedReader(new FileReader("bancox-datos.txt"));
		
		int cantcliente = Integer.parseInt(buf.readLine());
		
		 String[] arrDatoscliente;
	        
	        for(int i=0; i<cantcliente;i++) 
	        {	
	            arrDatoscliente = buf.readLine().split(",");
	            Cliente cliente = new Cliente(arrDatoscliente[0],arrDatoscliente[1] , Float.parseFloat(arrDatoscliente[2]) , 
	            		Integer.parseInt(arrDatoscliente[3]));
	            if(cliente.listaRazonesVisita != null) 
	            {
	            	String razonvisita = arrDatoscliente[4];
	            	cliente.listaRazonesVisita.add(razonvisita);
	            }
	            
	           bank.agregarCliente(cliente);
	        }
	        
	        /*Prioridades Banco
	         * 10-Cliente adulto mayor 50 años o Señoras en embarazo = Prioridad Alta
	         * 5-Cliente Juridico o Vip = Prioridad Media
	         * 1-Cliente Natural = Prioridad baja
	         */
	        
	     //Total Dinero en dia suma ingresos
		float totalDiaIngreso = bank.calcularTotalDiaIngresos();
		System.out.println( "El total de dinero ingresado en el dia es de  " + "$" + totalDiaIngreso + " Pesos");
		System.out.println("---------------------------------------------------------------------------");
		//Total retiros en el dia
		float totalretiros = bank.calculartotalretiros();
		System.out.println("El total de retiros en el dia es de " + "$" + totalretiros + " Pesos");
		
		//Arqueo caja
		float totalcaja = bank.calcularTotalDiaIngresosCaja() - bank.calculartotalretiros();
		System.out.println("Total caja dia " +"$" + totalcaja+ " Pesos");
		
		//Cuanto corresponde a la dian por operaciones
		//cada operacion vale 1000
		float valorXOperacion = bank.impuestoDian();
		float residuoCorrespondienteADian = totalcaja - bank.impuestoDian();
		System.out.println("El valor del impuesto para la dian es de "+"$"+valorXOperacion + " pesos " + "En caja quedan " + 
		"$"+ residuoCorrespondienteADian + " pesos");
		System.out.println("---------------------------------------------------------------------------");
		//Total Razones de personas que van al banco 
		bank.calcularRazonesParaIrAlBanco();
		
		//Razon mas comun para ir al banco
		String razonComun = bank.calcularRazonMasComun();
		System.out.println("La razon mas comun en el dia para ir al banco es : " + razonComun  );
	    
		
	
		
		
		
	}
	

}
