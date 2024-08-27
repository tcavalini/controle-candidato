package candidatura;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.lang.model.util.ElementScanner14;
public class ProcessoSeletivo {
    public static void main(String[] args) throws Exception {
        String [] candidatos = {"Thiago", "Elio", "Jennifer", "Mel", "Elektra"};
        for(String candidato: candidatos){
            entrandoEmContato(candidato);
        }
        
        
    }
    static void entrandoEmContato(String candidato){
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do{
            atendeu = atender();
            continuarTentando = !atendeu;
            if(continuarTentando)
                tentativasRealizadas++;
            else
                System.out.println("CONTATO REALIZADO COM SUCESSO.");

        }while(continuarTentando && tentativasRealizadas < 3);
    
        if(atendeu)
            System.out.println("CONSEGUIMOS CONTATO COM " + candidato + " NA " + tentativasRealizadas + "ª TENTATIVA");
        else
            System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidato + ", NÚMERO MAXIMO DE ENTATIVAS" + tentativasRealizadas + " TENTATIVAS.");
    }
    static boolean atender(){
        return new Random().nextInt(3)==1;
    }


    static void imprimirSelecionados(){
        String [] candidatos = {"Thiago", "Elio", "Jennifer", "Mel", "Elektra"};
        System.out.println("Imprimindo a lista de candidatos informando o indice do elemento");
        for(String candidato : candidatos){
            System.out.println("O candidado selecionado foi " + candidato);
        }
    }

    static void selecaoCandidatos(){
        String [] candidatos = {"Thiago", "Rodrigo", "Jennifer", "Mel", "Elektra", "Francisca", "Elio", "Fernando", "José"};

        int candidatoAtual = 0;
        int candidatosSelecionados = 0;
        double salarioBase = 2000.0;
        while(candidatosSelecionados < 5 && candidatoAtual < candidatos.length) {
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();            

            System.out.println("O candidato " + candidato + ", solicitou o valor de R$ " + salarioPretendido + " de salário.");
            if (salarioBase >= salarioPretendido){
                System.out.println("O candidado " + candidato + " foi selecionado para a vaga.");
                candidatosSelecionados++;
            }else{
                System.out.println("O candidado " + candidato + " não foi selecionado para a vaga.");                
            }
            candidatoAtual++;            
        }
    }
    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }
    static void analisarCandidato(double salarioPretendido){
        double salarioBase = 2000.0;
        if (salarioBase > salarioPretendido){
            System.out.println("Ligar para o candidato.");
        }else if(salarioBase == salarioPretendido){
            System.out.println("Ligar para o candidato com contra proposta.");
        }else{
            System.out.println("Aguardando demais candidatos.");

        }
        
    }
}
