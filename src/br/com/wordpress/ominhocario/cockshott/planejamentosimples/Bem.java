package br.com.wordpress.ominhocario.cockshott.planejamentosimples;

public enum Bem {
	FERRO("Ferro"), CARVAO("Carv�o"), MILHO("Milho"), PAO("P�o"), MAO_DE_OBRA("M�o de Obra");
	
	private String nome;
	private Bem(String nome) {
		this.nome = nome;
	}
	
	public String toString() {
		return this.nome;
	}
}
