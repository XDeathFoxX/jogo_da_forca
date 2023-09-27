package java_projetos.jogo_da_forca;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

// PRECISO CRIAR UM MECANISMO DE AUTO COMPLETE PARA PALAVRAS COM ACENTO!
public class jogo_da_forca {
    
    public static void main(String[] args){

        ArrayList <String> paises = new ArrayList<>();
        ArrayList <String> letras_corretas = new ArrayList<>(); // Aqui criamos os arrays para receber as palavras que podem ser sorteadas para a palavra secreta
        ArrayList <String> times = new ArrayList<>();

        Scanner input = new Scanner(System.in);
        Random random = new Random();

        paises.add("Brasil");
        paises.add("Russia");
        paises.add("Argentina");
        paises.add("Italia");
        paises.add("Afeganistao");
        times.add("Flamengo");
        times.add("São Paulo");
        times.add("Corinthians");

        //PRECISO FAZER UMA FUNÇÃO PARA PODER ESCOLHER ENTRE OS TEMAS, E DEPOIS DE SELECIONAR O TEMA ESCOLHIDO RANDOMIZAR A PALAVRA DO TEMA

        int num = random.nextInt(paises.size()); // Aqui sorteamos uma palavra secreta pelo tamanho do array
        //System.out.println(paises.toString());
        String pais_escolhido = paises.get(num).toLowerCase(); // Aqui pegamos a palavra secreta pelo indice sorteado do array
        //System.out.println(pais_escolhido);
        String palavra_escolhida = pais_escolhido;
        int tamanho_palavra = palavra_escolhida.length();
            
        char asterisco = '*';
        int chances = 0;

        if (tamanho_palavra > 0 && tamanho_palavra < 5){
            chances = 5;
        }else if(tamanho_palavra > 5 && tamanho_palavra < 8){
            chances = 7;
        }else if(tamanho_palavra > 8 && tamanho_palavra < 12){ // Aqui definimos quantas chances o jogador terá pelo tamanho da palavra
            chances = 9;
        }else if(tamanho_palavra > 12 && tamanho_palavra < 16){
            chances = 12;
        }else if(tamanho_palavra > 16){
            chances = 15;
        }

        StringBuilder string = new StringBuilder(pais_escolhido);

        for (int index = 0 ; index < pais_escolhido.length() ; index ++){
            string.setCharAt(index,asterisco); // Aqui criamos uma string para fazer os asteriscos correspondentes pelo tamanho da palavra
        }
        System.out.println("A palavra secreta é " + string);
        
        System.out.println("");
        String entrada = "";
        System.out.printf("A palavra secreta tem %d letras e você tem %d chances: ",tamanho_palavra,chances);
        System.out.println();
        
        while (entrada != "sair"){ // Aqui criamos um loop para poder pedir a digitação de letras até que a palavra seja descoberta ou acabe as chances!

            System.out.println("Digite uma letra : ");
            
            String letra = input.nextLine().trim().toLowerCase(); // Aqui recebemos a entrada da letra e tratamos para retirar espaços e que entre sempre como
                                                                  // letra minúscula
        
        char letra0 = letra.charAt(0);


        for (int a = 0 ; a < pais_escolhido.length() ; a++){
            if (letra0 == pais_escolhido.charAt(a)){ // Aqui fazemos um loop para percorrer toda a palavra e se a letra digitada estiver em alguma posição ela
                string.setCharAt(a,letra0);         // é colocada no lugar do asterisco na string
            }
        }  
          
        if (pais_escolhido.contains(letra)){
            int count=0;
            for(int o =0;o<palavra_escolhida.length();o++){
                if(palavra_escolhida.charAt(o)==letra0){   
                count++; // Aqui fazemos um loop para contar as ocorrências de cada letra, se tiver mais de uma ocorrências ela são adicionadas proporcionalmente
                }       // no array de letras corretas para coincidir com o tamanho da palavra e aparecer a mensagem de venceu o jogo
        }
        int letra1 = count;
        //System.out.printf("A letra %s aparece %d vezes",letra0,letra1);
        //System.out.println();

        for(int cont = 0; cont < letra1; cont++){
            letras_corretas.add(letra); // Aqui fazemos a adição das ocorrências das letras no array de letras corretas
        }
    }    

        if (pais_escolhido.contains(letra)){
            System.out.println(string); // Se a letra digitada estiver na palavra secreta a string com a letra em sua respectiva posição é impressa
            //System.out.println(letras_corretas);
        }else{
            chances--;
            System.out.printf("Essa letra não existe na palavra secreta,você ainda tem %d chances ",chances);
            System.out.println(); // Se a letra digitada não estiver na palavra secreta é diminuída uma chance!
        }
        if(letras_corretas.size() == palavra_escolhida.length()){
            System.out.println("Parabéns,você venceu,acertou todas as letras");
            break; // Se o tamanho do array de letras corretas for o mesmo do tamanho da palavra secreta o jogo te parabeniza por vencer e encerra!
        }
        if (chances == 0){
            System.out.printf("Você perdeu,você gastou todas as chances, a palavra secreta era %s",pais_escolhido);
            System.out.println(); // Se você perder todas as chances o jogo lamenta que você perdeu e te diz qual era a palavra secreta!
            break;   
        }
    }
input.close();
}
}


