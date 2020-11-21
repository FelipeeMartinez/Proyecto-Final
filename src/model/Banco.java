package model;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Banco 
{
	Queue<Cliente> colaClientes = new PriorityQueue<Cliente>();
	
	public void agregarCliente(Cliente cliente) 
	{
		colaClientes.add(cliente);
	}
	
	public float calcularTotalDiaIngresos() 
	{
		float totalDineroBase = 2000;
		
		for(Cliente cliente : colaClientes) 
		{
			System.out.println("Cliente " + cliente.nombreReferencia);
			totalDineroBase = totalDineroBase + cliente.totalPago;
		}
		
		return totalDineroBase;
	}
	
	public float calcularTotalDiaIngresosCaja() 
	{
		float totalDineroBase = 500000;
		
		for(Cliente cliente : colaClientes) 
		{
			totalDineroBase = totalDineroBase + cliente.totalPago;
		}
		
		return totalDineroBase;
	}
	
	public float calculartotalretiros() 
	{
		float totalretiro = 0;
		for(Cliente cliente : colaClientes) 
		{
			for(String razon : cliente.listaRazonesVisita) 
			{
				if(razon != "consigacion") 
				{
					totalretiro += cliente.totalPago;
				}
			}
		}
		return totalretiro;
	}
	
	public float impuestoDian() 
	{
		float total = 0;
		int contador = 0;
		for(Cliente cliente : colaClientes) 
		{
			contador++;
		}
		total = contador * 1000;
		return total;
	}
	
	
	
	public String calcularRazonesParaIrAlBanco() 
	{
		Hashtable<String, Integer> hashRazones = new Hashtable<String, Integer>();
		
		for(Cliente cliente : colaClientes) 
		{
			for(String razon : cliente.listaRazonesVisita) 
			{
				int cant = 1;
				if(hashRazones.containsKey(razon)) 
				{
					cant = hashRazones.get(razon);
					cant++;
				}
				hashRazones.put(razon, cant);
			}
		}
		
		hashRazones.forEach((key, value) -> {
            System.out.println("El total de personas que hacen " + key + " al dia es de : " + value);
        });
		
		return " " ;
	}
	
	public String calcularRazonMasComun() 
	{

		Hashtable<String, Integer> hashRazones = new Hashtable<String, Integer>();
		
		for(Cliente cliente : colaClientes) 
		{
			for(String razon : cliente.listaRazonesVisita) 
			{
				int cant = 1;
				if(hashRazones.containsKey(razon)) 
				{
					cant = hashRazones.get(razon);
					cant++;
				}
				hashRazones.put(razon, cant);
			}
		}
		int mayor = 0;
		String razoncomun = " ";
		
		Enumeration<String> enumeration = hashRazones.keys(); 
        while(enumeration.hasMoreElements()) {
        String key = enumeration.nextElement();
        
		if(hashRazones.get(key) > mayor) 
		{
			razoncomun = key;
		}
	}
		return razoncomun;

  }
}	
