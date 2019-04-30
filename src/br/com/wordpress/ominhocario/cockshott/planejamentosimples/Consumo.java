package br.com.wordpress.ominhocario.cockshott.planejamentosimples;

import java.util.HashMap;

public class Consumo extends HashMap<Bem, Double>{
	public Consumo() {
		for (Bem b: Bem.values()) {
			this.put(b, 0.0);
		}
	}
	
	public String toString() {
		String s = "";
		for(Bem b: this.keySet()) {
			s += b + ": " + this.get(b) + ", ";
		}
		return s;
	}
	
	public void somar(Consumo c) {
		for(Bem b:c.keySet()) {
			this.put(b, 
				this.get(b) + c.get(b));
		}
	}
	
	public Consumo copiar() {
		Consumo c = new Consumo();
		
		for(Bem b:this.keySet()) {
			c.put(b, this.get(b));
		}
		
		return c;
	}
}
