package br.com.wordpress.ominhocario.cockshott.planejamentosimples;

public enum Bem {
	FERRO("Ferro"), CARVAO("Carvão"), MILHO("Milho"), PAO("Pão"), MAO_DE_OBRA("Mão de Obra");
	
	private String nome;
	private Bem(String nome) {
		this.nome = nome;
	}
	
	public String toString() {
		return this.nome;
	}
}
