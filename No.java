package ListaSimplesEncadeada;
public class No<T> {

	protected No<T> proximo;
	protected T item;
	
	public No(T item){
		this.proximo = null;
		this.item = item;
	}
	
}
