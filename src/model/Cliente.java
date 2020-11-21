package model;

import java.util.ArrayList;

public class Cliente implements Comparable<Cliente>
{
	public String id;
	public String nombreReferencia;
	public float totalPago;
	public int prioridad;
	ArrayList<String> listaRazonesVisita;
	
	public Cliente ( String id , String referencia , float pago , int prioridad) 
	{
		this.id = id;
		this.nombreReferencia = referencia;
		this.totalPago = pago;
		this.prioridad = prioridad;
		listaRazonesVisita = new ArrayList<String>();
	}

	@Override
	public int compareTo(Cliente otroCliente) 
	{
		return otroCliente.prioridad - this.prioridad;
	}

}
