package folhaPagamento;
import java.util.Scanner;

public class funcionario {
    String nome;
    String dataNascimento;
    char tipoContrato; // E - Efetivo, H - Horista
    double salario;
    int numFilhosMenores;
    String dataAdmissao;

    Scanner entrada = new Scanner(System.in);
    
    public void iniciarAtributos(funcionario funcionarioEmpregado){
        iniciaNome(funcionarioEmpregado);
        iniciaDataNascimento(funcionarioEmpregado);
        contratar(funcionarioEmpregado);
    }
    public void iniciaNome(funcionario funcionarioEmpregado){
        System.out.println("Digite o nome do funcionário: ");
        this.nome = entrada.nextLine();
    }
    public void iniciaDataNascimento(funcionario funcionarioEmpregado){
        System.out.println("Digite a data de nascimento do funcionário: ");
        this.dataNascimento = entrada.nextLine();
    }
    
    public void contratar(funcionario funcionarioEmpregado){
        iniciaTipoContrato(funcionarioEmpregado);
        iniciaSalario(funcionarioEmpregado);
        iniciaNumFilhosMenores(funcionarioEmpregado);
        iniciaDataAdmissao(funcionarioEmpregado);
    }
    public void iniciaTipoContrato(funcionario funcionarioEmpregado){
        System.out.println("Digite o tipo de contrato do funcionário: ");
        this.tipoContrato = entrada.next().charAt(0);        
    }
    public void iniciaSalario(funcionario funcionarioEmpregado){
        System.out.println("Digite o salário do funcionário: ");
        this.salario = entrada.nextDouble();
    }
    public void iniciaNumFilhosMenores(funcionario funcionarioEmpregado){
        System.out.println("Digite o número de filhos menores do funcionário: ");
        this.numFilhosMenores = entrada.nextInt();
    }
    public void iniciaDataAdmissao(funcionario funcionarioEmpregado){
        System.out.println("Digite a data de admissão do funcionário: ");
        this.dataAdmissao = entrada.next();
    }
    public void getDados(){
        System.out.println("Nome: " + nome);
        System.out.println("Data de Nascimento: " + dataNascimento);
        System.out.println("Tipo de Contrato: " + tipoContrato);
        System.out.println("Salário: " + salario);
        System.out.println("Número de Filhos Menores: " + numFilhosMenores);
        System.out.println("Data de Admissão: " + dataAdmissao);
        System.out.println("\n");
    }
    public String getNome(){
        return nome;
    }
    public char getTipoContrato(){
        return tipoContrato;
    }
    public double getSalario(){
        return salario;
    }
    public int getNumFilhosMenores(){
        return numFilhosMenores;
    }
    public String getDataAdmissao(){
        return dataAdmissao;
    }


    public void setTipoContrato(char tipoContrato){
        this.tipoContrato = tipoContrato;
    }
    public void setSalario(double salario){
        this.salario = salario;
    }
    public void setNumFilhosMenores(int numFilhosMenores){
        this.numFilhosMenores = numFilhosMenores;
    }
    public void setDataAdmissao(String dataAdmissao){
        this.dataAdmissao = dataAdmissao;
    }
    
    
    public double salarioBruto(double horasTrabalho){
        if(Character.compare(tipoContrato, 'H') == 0){
            double salarioBruto = salario * horasTrabalho;
            return salarioBruto;
        }
        else{
            return salario;
        }
    }
    public double descontoINSS(){
        if(salario<=1659.38){
            return salario*0.08;
        }
        else if(salario>1659.38 && salario<=2765.66){
            return salario*0.09;
        }
        else if(salario>2765.66 && salario<=5531.31){
            return salario*0.11;
        }
        else{
            return 5531.31*0.11;
        }
    }
    public double descontoIR(){
        if(salario<=1903.98){
            return 0;
        }
        else if(salario>1903.98 && salario<=2826.65){
            return salario*0.075 - 142.80;
        }
        else if(salario>2826.65 && salario<=3751.05){
            return salario*0.15 - 354.80;
        }
        else if(salario>3751.05 && salario<=4664.68){
            return salario*0.225 - 636.13;
        }
        else{
            return salario*0.275 - 869.36;
        }
    }
    public double salarioLiquido(double horasTrabalho){
        return salarioBruto(horasTrabalho) - descontoINSS() - descontoIR();
    }

    

    
   
}
