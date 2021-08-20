package arvore;

public class No {
	private boolean cor; //false = black, true = red
	private int valor;
	
	No esquerda, direita;
	No pai;
	
	public No avo(No no) {
		if (no != null && no.pai != null) {
			return no.pai.pai;
		}
		else {
			return null;
		}
	}
	
	public No (int numero) {
		setValor(numero);
	}
	
	public No tio(No no) {
		No auxiliar = avo(no);
		if (auxiliar == null) {
			return null;
		}
		if (no.pai == auxiliar.esquerda) {
			return auxiliar.direita;
		}
		else {
			return auxiliar.esquerda;
		}
	}

	public boolean isCor() {
		return cor;
	}

	public void setCor(boolean cor) {
		this.cor = cor;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
}
