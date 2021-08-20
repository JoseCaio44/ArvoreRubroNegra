package arvore;

public class Arvore {
	
	private No raiz;

	public void inserir(int numero) { 
		No no = new No(numero);		  
		inserirCaso1(no);
	}
	
	void inserirCaso1 (No no) {
		if (no.pai == null) {
			no.setCor(false);
		}
		else {
			inserirCaso2(no);
		}
	}
	
	void inserirCaso2(No no) {
		if (no.pai.isCor() == false) {
			return ;
		}
		else {
			inserirCaso3(no);
		}
	}
	
	void inserirCaso3(No no) {
		No t = no.tio(no), g;
		
		if ((t != null) && (t.isCor() == true)) {
			no.pai.setCor(false);
			t.setCor(false);
			g = no.avo(no);
			g.setCor(true);
			inserirCaso1(g);
		}
		else {
			inserirCaso4(no);
		}
	}
	
	void inserirCaso4(No no) {
		No a = no.avo(no), p = no.pai;
		
		if (no == p.direita && p == a.esquerda) {
			rotacaoEsquerda(p);
			no = no.esquerda;
		} else if (no == p.esquerda && p == a.direita) {
			rotacaoDireita(p);
			no = no.direita;
		}
		else {
			inserirCaso5(no);
		}
	}
	
	void inserirCaso5 (No no) {
		No a = no.avo(no);
		no.pai.setCor(false);
		a.setCor(true);
		
		if (no == no.pai.esquerda) {
			rotacaoDireita(a);
		}
		else {
			rotacaoEsquerda(a);
		}
	}
	
	public void rotacaoEsquerda(No inicial) {

		No direita = inicial.direita;
		inicial.direita.pai = inicial.pai;

		inicial.direita = direita.esquerda;

		if (inicial.direita != null) {
			inicial.direita.pai = inicial;
		}

		direita.esquerda = inicial;
		inicial.pai = direita;

		if (direita.pai != null) {

			if (direita.pai.direita == inicial) {
				direita.pai.direita = direita;
			
			} else if (direita.pai.esquerda == inicial) {
				direita.pai.esquerda = direita;
			}
		}
	}

	public void rotacaoDireita(No inicial) {

		No esquerda = inicial.esquerda;
		esquerda.pai = inicial.pai;

		inicial.esquerda = esquerda.direita;

		if (inicial.esquerda != null) {
			inicial.pai = inicial.esquerda;
		}

		esquerda.direita = inicial;
		inicial.pai = esquerda;

		if (esquerda.pai != null) {

			if (esquerda.pai.direita == inicial) {
				esquerda.pai.direita = esquerda;
			
			} else if (esquerda.pai.esquerda == inicial) {
				esquerda.pai.esquerda = esquerda;
			}
		}
	}
	
	public void ordem (No no) {
		if (no != null) {
			ordem(no.esquerda);
			System.out.print(no.getValor() + " , " + "cor: " + no.isCor());
			ordem(no.direita);
		}
	}
	
	public void ordem () {
		System.out.println("Imprimindo os valores da arvore em ordem");
		ordem(this.raiz);
	}

}
