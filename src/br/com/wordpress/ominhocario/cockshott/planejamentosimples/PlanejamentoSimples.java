package br.com.wordpress.ominhocario.cockshott.planejamentosimples;

import java.util.HashMap;
import java.util.Map;

public class PlanejamentoSimples {
	private Map<Bem, Consumo> insumos;	
	private Consumo demandaInicial;
	
	private Consumo usados;
	private Consumo anterior;
	
	public PlanejamentoSimples() {
		insumos = new HashMap<>();
		
		insumos.put(Bem.FERRO, new Consumo());
		insumos.get(Bem.FERRO).put(Bem.FERRO, 0.05);
		insumos.get(Bem.FERRO).put(Bem.CARVAO, 2.0);
		insumos.get(Bem.FERRO).put(Bem.MAO_DE_OBRA, 20.0);
		
		insumos.put(Bem.CARVAO, new Consumo());
		insumos.get(Bem.CARVAO).put(Bem.CARVAO, 0.2);
		insumos.get(Bem.CARVAO).put(Bem.FERRO, 0.1);
		insumos.get(Bem.CARVAO).put(Bem.MAO_DE_OBRA, 3.0);
		
		insumos.put(Bem.MILHO, new Consumo());
		insumos.get(Bem.MILHO).put(Bem.MILHO, 0.1);
		insumos.get(Bem.MILHO).put(Bem.FERRO, 0.02);
		insumos.get(Bem.MILHO).put(Bem.MAO_DE_OBRA, 10.0);
		
		insumos.put(Bem.PAO, new Consumo());
		insumos.get(Bem.PAO).put(Bem.MILHO, 1.5);
		insumos.get(Bem.PAO).put(Bem.CARVAO, 0.5);
		insumos.get(Bem.PAO).put(Bem.MAO_DE_OBRA, 1.0);
		
		insumos.put(Bem.MAO_DE_OBRA, new Consumo());
		insumos.get(Bem.MAO_DE_OBRA).put(Bem.MILHO, 0.0);
		insumos.get(Bem.MAO_DE_OBRA).put(Bem.CARVAO, 0.0);
		insumos.get(Bem.MAO_DE_OBRA).put(Bem.MAO_DE_OBRA, 0.0);
		
		
		demandaInicial = new Consumo();
		demandaInicial.put(Bem.FERRO, 0.0);
		demandaInicial.put(Bem.CARVAO, 20000.0);
		demandaInicial.put(Bem.MILHO, 0.0);
		demandaInicial.put(Bem.PAO, 1000.0);
		demandaInicial.put(Bem.MAO_DE_OBRA, 0.0);
		
		
		usados = demandaInicial;
		anterior = new Consumo();
		
		for(Bem b:Bem.values())
			System.out.print(b + ",");
		System.out.println();
		
		System.out.println(usados);
		
		for (int l = 1; l <= 20; l++) {
			System.out.println("Etapa " + l + " do cálculo: ");
			calcularEtapa();
		}
	}
	
	
	public static void main(String [] args) {
		PlanejamentoSimples plan = new PlanejamentoSimples();
	}
	
	private void calcularEtapa() {
		Consumo temp = new Consumo();
		
		for (Bem i : Bem.values()) {
			String sI = i.toString();
			double incluidoEtapaAnterior = usados.get(i) - anterior.get(i);
			
			for (Bem j : insumos.get(i).keySet()) 
			{
				String sJ = j.toString();
				double necessarioPorUnidade = insumos.get(i).get(j);
				double qtdIncluirIntermediario = (incluidoEtapaAnterior) * necessarioPorUnidade;
				double novoTotal = temp.get(j) + qtdIncluirIntermediario;
				
				temp.put( j, novoTotal );
				
			}
		}
		
		anterior = usados.copiar();
		
		usados.somar( temp );
		System.out.println(usados);

	}
}
