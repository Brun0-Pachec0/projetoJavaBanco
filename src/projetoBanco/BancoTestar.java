package projetoBanco;

public class BancoTestar {

	public static void main(String [] arg) {
		Banco pessoa1 = new Banco("Bruno", 42319566756, 1100f, 200f, 5000f);

		pessoa1.verificarEmprestimo();
		pessoa1.transferirEntreContas("Corrente")
		
	}
}
