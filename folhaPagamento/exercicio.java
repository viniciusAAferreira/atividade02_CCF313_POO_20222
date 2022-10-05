package folhaPagamento;
import java.util.ArrayList;
import java.util.Scanner;

public class exercicio {
    public static void main(String[] args) {
        int opcao = 0;
        funcionario empregado = new funcionario();
        ArrayList<funcionario> funcionarios = new ArrayList<>(); // Cria um array de funcionários
        Scanner entrada = new Scanner(System.in);

        do{
            
            System.out.println("Digite a opção desejada: ");
            System.out.println("1 - Inicializar o nome e a data de nascimento do funcionário");
            System.out.println("2 - Imprimir os dados do funcionário");
            System.out.println("3 - Calcular o sálario bruto do funcionário");
            System.out.println("4 - Calcular o sálario líquido do funcionário");
            System.out.println("5 - Calcular o valor do desconto do INSS");
            System.out.println("6 - Calcular o valor do desconto do IRRF");
            System.out.println("7 - Mostrar folha de pagamento do funcionário");
            System.out.println("8 - Alterar dados dos funcionários");
            System.out.println("-1 - Sair");
            opcao = entrada.nextInt();
            switch (opcao) {
                case 1:
                    empregado = new funcionario();
                    empregado.iniciarAtributos(empregado);
                    funcionarios.add(empregado);
                    break;
                
                case 2:
                    if(funcionarios.size() > 0){
                        for (int i = 0; i < funcionarios.size(); i++) {
                            funcionarios.get(i).getDados();
                        }
                    }else{
                        System.out.println("Não há funcionários cadastrados!");
                    }
                    break;
                
                case 3:
                    System.out.println("Digite o numero do funcionario a calcular o salario");
                    int i = entrada.nextInt();
                    System.out.println("Digite a quantidade de horas trabalhadas do funcionario que deseja calcular o salário bruto: ");
                    double horasDeTrabalho = entrada.nextDouble();
                    double saida = funcionarios.get(i).salarioBruto(horasDeTrabalho);
                    System.out.printf("O salário bruto eh: %f\n", saida);
                    break;
                
                case 4:
                    System.out.println("Digite o numero do funcionario a calcular o salario líquido");
                    int num = entrada.nextInt();
                    System.out.println("Digite a quantidade de horas trabalhadas do funcionario que deseja calcular o salário bruto: ");
                    double horas = entrada.nextDouble();
                    System.out.println("Salário líquido: " + funcionarios.get(num).salarioLiquido(horas));
                    break;

                case 5:
                    System.out.println("Digite o numero do funcionario a calcular o desconto INSS:");
                    int numFuncionario = entrada.nextInt();
                    System.out.println("Desconto INSS eh: " + funcionarios.get(numFuncionario).descontoINSS());
                    break;
                
                case 6:
                    System.out.println("Digite o numero do funcionario a calcular o desconto IRRF:");
                    int numFuncionario2 = entrada.nextInt();
                    System.out.println("Desconto IRRF eh: " + funcionarios.get(numFuncionario2).descontoIR());
                    break;
                
                case 7:
                    System.out.println("Digite o numero do funcionario a calcular o salario líquido");
                    int num1 = entrada.nextInt();
                    System.out.println("Digite a quantidade de horas trabalhadas do funcionario que deseja calcular o salário bruto: ");
                    double horas1 = entrada.nextDouble();
                    
                    System.out.println("FOLHA DE PAGAMENTO:");
                    System.out.println("Salário bruto: " + funcionarios.get(num1).salarioBruto(horas1));
                    System.out.println("Desconto INSS: " + funcionarios.get(num1).descontoINSS());
                    System.out.println("Desconto IRRF: " + funcionarios.get(num1).descontoIR());
                    System.out.println("Salário líquido: " + funcionarios.get(num1).salarioLiquido(horas1));
                    break;

                case 8:
                    
                    System.out.println("Digite o numero do funcionario a alterar os dados:");
                    int j = entrada.nextInt();
                    System.out.println("Digite o novo tipo de contrato do funcionario:");
                    funcionarios.get(j).setTipoContrato(entrada.next().charAt(0));
                    System.out.println("Digite o novo numero de filhos menos de idade do funcionario:");
                    funcionarios.get(j).setNumFilhosMenores(entrada.nextInt());
                    System.out.println("Digite o novo salário do funcionário:");
                    funcionarios.get(j).setSalario(entrada.nextDouble());
                    System.out.println("Digite a nova data de admissão do funcionário:"); 
                    funcionarios.get(j).setDataAdmissao(entrada.next());
                    break;

        
                default:
                    System.out.println("Opção inválida!");
            } 
            
        }while (opcao != -1);

        entrada.close();
    }
}