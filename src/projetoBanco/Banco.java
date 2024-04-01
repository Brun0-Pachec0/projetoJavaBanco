package src.projetoBanco;

public class Banco {
	
	//atributos
	String nome;
	int cpf;
	float salario;
	float saldoCorrente;
	float saldoPoupanca;
	boolean devedor;
	boolean emprestimo;
	float valorEmprestimo;

	//Construtor padrão (sem parâmetros)
	public void Banco() {
		
	}
	
	
	//construtor com parâmetros
	public void Banco(String nome, int cpf, float salario, float saldoCorrente, float saldoPoupanca) {
		this.nome = nome;
		this.cpf = cpf;
		this.saldoCorrente = saldoCorrente;
		this.saldoPoupanca = saldoPoupanca;
		this.devedor = devedor;
		this.emprestimo = emprestimo;
		
		
		public void adicionarDinheiro(float valorAdionado, String nomeConta) {
			if (valorAdionado < 0) {
				System.out.println("[ERRO!] Não é possível adicionar valor negativo");
			} else if (valorAdionado === 0) {
				System.out.println("[ERRO!] Não é possível adicionar R$0,00 reais!");
			} else {
				if (nomeConta === "Corrente") {
					this.saldoCorrente += valorAdionado;
					System.out.println("Valor adicionado com sucesso!");
				} else if (nomeConta === "Poupanca") {
					this.saldoPoupanca += valorAdionado;
					System.out.println("Valor adicionado com sucesso!");
				} else {
					System.out.println("[ERRO!] Tipo de conta informado é inválido");
				}
			}
		}

		public void sacarDinheiro(float valorSacado, String nomeConta) {
			if (nomeConta === "Corrente") {
				if (valorSacado > saldoCorrente) {
					System.out.println("[ERRO!] Não foi possível realizar o saque, saldo menor do que valor solicitado");
				} else if (valorSacado === 0) {
					System.out.println("[ERRO!] Não é possível realizar o saque de R$0,00 reais");
				} else {
					saldoCorrente -= valorSacado;
					System.out.println("Valor sacado com sucesso!");
				}
			} else if (nomeConta === "Poupanca") {
				if (valorSacado > saldoPoupanca) {
					System.out.println("[ERRO!] Não foi possível realizar o saque, saldo menor do que valor solicitado");
				} else if (valorSacado === 0) {
					System.out.println("[ERRO!] Não é possível realizar o saque de R$0,00 reais");
				} else {
					saldoPoupanca -= valorSacado;
					System.out.println("Valor sacado com sucesso!");
				}
			}
		}


		public void transferirEntreContas(String contaParaEnviar, float valorEnvio) {
			if (contaParaEnviar === "Corrente") {
				if (valorEnvio > saldoCorrente) {
					System.out.println("[ERRO!] Não foi possível realizar o envio, saldo menor do que valor solicitado");
				} else if (valorEnvio === 0) {
					System.out.println("[ERRO!] Não é possível realizar o envio de R$0,00 reais");
				} else {
					saldoCorrente -= valorEnvio;
					saldoPoupanca += valorEnvio;
					System.out.println("Valor de R$" + valorEnvio + "enviado com sucesso!");
				}
			} else if (nomeConta === "Poupanca") {
				if (valorEnvio > saldoPoupanca) {
					System.out.println("[ERRO!] Não foi possível realizar o envio, saldo menor do que valor solicitado");
				} else if (valorEnvio === 0) {
					System.out.println("[ERRO!] Não é possível realizar o envio de R$0,00 reais");
				} else {
					saldoPoupanca -= valorEnvio;
					saldoCorrente+= valorEnvio;
					System.out.println("Valor enviado com sucesso!");
				}
			}
		}


		public void verSaldo(String conta) {
			if (conta === 'Corrente') {
				System.out.println("Saldo da conta Corrente: R$" + saldoCorrente);
			} else if (conta === 'Poupanca') {
				System.out.println("Saldo da conta Poupança: R$" + saldoPoupanca);
			}
		}


		public void verificaDebitos() {
			if (saldoCorrente < 0 || saldoPoupanca < 0) {
				System.out.println("Você está inadimplente! Verifique junto ao banco como pode ser resolvido");
				devedor = true;
			} else if (emprestimo) {
				System.out.println("Você possui um emprestimo em aberto");
				devedor = true;
			} else {
				System.out.println("Sua situação está adimplente! ");
				devedor = false;
			}
		}


		public void permiteEmprestimo(float valorEmprestimo) {
			if (saldoCorrente < 0 || saldoPoupanca < 0 ) {
				System.out.println("Empréstimo recusado! Verifique junto ao banco o que pode ser feito.");
			} else if (valorEmprestimo > (salario/100) * 35 ) {
				System.out.println("Não foi possível a liberação do valor de R$" + valorEmprestimo + " valor superior a 35% do salário.");
			} else {
				saldoCorrente += valorEmprestimo;
				devedor = true;
				emprestimo = true;
				valorEmprestimo = valorEmprestimo;
				System.out.println("Empréstimo solicitado liberado! Valor adicionado a conta corrente!");
			}
		}

		public void verificarEmprestimo() {
			if (emprestimo) {
				System.out.println("Você possui um emprestimo em aberto no valor de R$" + valorEmprestimo + " reais");
			}
		}
	}
	
}
