package ListaSimplesEncadeada;
public class ListaSimples<T> {

	private No<T> primeiro;
	private int tamanho;

	public ListaSimples(){
		tamanho = 0;
		primeiro = null;
	}

	public int tamanho(){
		return this.tamanho;
	}//________________________________________Fim tamanho


	private boolean eVazio(){
		if(primeiro == null){
			return true;
		}else{
			return false;
		}
	}//________________________________________Fim eVazio

	public void add(T item){

		No<T> novoNo = new No(item);  

		if(primeiro == null){
			primeiro = novoNo;
			tamanho++;
			//System.out.println(item);
		}else{
			
			No<T> aux = null;
			No<T> aux2 = primeiro;
			while(aux2 != null){

				aux = aux2;
				aux2 = aux2.proximo;				
			}
		
			aux.proximo = novoNo;
			tamanho++;
			//System.out.println(item);
		}

	}//________________________________________Fim Add

	public T pegarItem(){
		if(eVazio()){
			throw new IllegalAccessError("Erro");
		}
		return primeiro.item;
	}//______________________________________Fim pegarItem

	public T pegarItem(int posicao){
		if(eVazio()){
			throw new IllegalAccessError("Erro: posição informada inválida");
		}

		int cont =1;

		No<T> aux = null;
		No<T> novoNo = primeiro;
		
		while(novoNo != null && cont <= posicao){
			aux = novoNo;
			novoNo = novoNo.proximo;
			cont++;
		}
		return aux.item;
	}//______________________________________Fim pegarItem
	
	public boolean remover(int posicao){
		No<T> aux = primeiro;
		No<T> aux2 = null;
		if((eVazio() && posicao < 0) || posicao > tamanho){
			throw new IllegalAccessError("Erro: Não foi possível remover item com o posição informada");
		}else if(posicao == 1){
			primeiro = primeiro.proximo;
			tamanho--;
			return true;
		}
		else{
			int cont = 1;
			while(aux != null && cont<=posicao){
				aux2 = aux;
				aux = aux.proximo;
				cont++;
			}
			aux2.proximo = aux.proximo;
			tamanho--;
			return true;
		}
	}//_____________________________________Fim remover
	
	public String toString(){
		
		String to_string = "";
		if(primeiro==null){
			throw new IllegalAccessError("Erro");
		}else{
		No<T> no = primeiro;
		//No<T> no2 = null;
		while(no != null){
			to_string += no.item+" -> ";
			no = no.proximo;
		}
		}
		return to_string;
	}
}
