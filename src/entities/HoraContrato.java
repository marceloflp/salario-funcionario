package entities;

import java.util.Date;

public class HoraContrato {
	private Date data;
	private double valorPorHora;
	private Integer hora;
	
	public HoraContrato() {
		
	}

	public HoraContrato(Date data, double valorPorHora, Integer hora) {
		this.data = data;
		this.valorPorHora = valorPorHora;
		this.hora = hora;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public double getValorPorHora() {
		return valorPorHora;
	}

	public void setValorPorHora(double valorPorHora) {
		this.valorPorHora = valorPorHora;
	}

	public Integer getHora() {
		return hora;
	}

	public void setHora(Integer hora) {
		this.hora = hora;
	}
	
	public double valorTotal() {
		return valorPorHora * hora;
	}
	
}
