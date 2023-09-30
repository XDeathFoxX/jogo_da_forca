package java_projetos.jogo_da_forca;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class jogo_da_forca {
    
    public static void main(String[] args){

        ArrayList <String> paises = new ArrayList<>();
        ArrayList <String> letras_corretas = new ArrayList<>(); // Aqui criamos os arrays para receber as palavras que podem ser sorteadas para a palavra secreta
        ArrayList <String> times = new ArrayList<>();
        ArrayList <String> tema_escolhido = new ArrayList<>();
        ArrayList <String> comidas = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        paises.add("Brasil");
        paises.add("Rússia");
        paises.add("Argentina");
        paises.add("Itália");
        paises.add("Afeganistão");
        paises.add("Costa Rica");
        paises.add("Malásia");
        paises.add("Estados Unidos da América");
        times.add("Flamengo");
        times.add("São Paulo");
        times.add("Corinthians");
        times.add("Internacional");
        times.add("Vasco da Gama");
        comidas.add("Macarrão");
        comidas.add("Pizza");
        comidas.add("Carne");
        comidas.add("Arroz");
        comidas.add("Feijão");
        
        System.out.println("Digite a opção de tema desejado: \n 1 - Países \n 2 - Times \n 3 - Comidas");
        String tema = input.nextLine();

        switch(tema){
            case "1":
                tema_escolhido = paises;
                break;
            case "2":
                tema_escolhido = times;
                break;
            case "3":
                tema_escolhido = comidas;
                break;
        }

        int num = random.nextInt(tema_escolhido.size()); // Aqui sorteamos uma palavra secreta pelo tamanho do array
        String escolhe_palavra = tema_escolhido.get(num).toLowerCase(); // Aqui pegamos a palavra secreta pelo indice sorteado do array
        String palavra_escolhida = escolhe_palavra;
        int tamanho_palavra = palavra_escolhida.length();
        
        char acento0 = 'ã';
        char acento1 = 'á';
        char acento2 = 'â';
        char acento3 = 'é';
        char acento4 = 'ê';
        char acento5 = 'í';
        char acento6 = 'î';
        char acento7 = 'ú';
        char acento8 = 'û';
        char acento9 = 'ô';
        char acento10 = 'ó';
        char acento11 = 'õ';
        char acento12 = 'ç';
        String a0 = "ã";
        String a1 = "á";
        String a2 = "â";
        String a3 = "é";
        String a4 = "ê";
        String a5 = "í";
        String a6 = "î";
        String a7 = "ú";
        String a8 = "û";
        String a9 = "ô";
        String a10 = "ó";
        String a11 = "õ";
        String a12 = "ç";
        
        char espaco = ' ';  
        char asterisco = '*';
        int chances = 0;

        if (tamanho_palavra > 0 && tamanho_palavra <= 5){
            chances = 5;
        }else if(tamanho_palavra > 5 && tamanho_palavra <= 8){
            chances = 7;
        }else if(tamanho_palavra > 8 && tamanho_palavra <= 12){ // Aqui definimos quantas chances o jogador terá pelo tamanho da palavra
            chances = 9;
        }else if(tamanho_palavra > 12 && tamanho_palavra <= 16){
            chances = 12;
        }else if(tamanho_palavra > 16){
            chances = 15;
        }


        StringBuilder string = new StringBuilder(palavra_escolhida);

        for (int index = 0 ; index < palavra_escolhida.length() ; index ++){
            string.setCharAt(index,asterisco);
            if(espaco == palavra_escolhida.charAt(index)){
                string.setCharAt(index, espaco);
            }; // Aqui criamos uma string para fazer os asteriscos correspondentes pelo tamanho da palavra
        }
        
        System.out.println();
        String entrada = "";
        System.out.printf("A palavra secreta tem %d letras e você tem %d chances: %s",tamanho_palavra,chances,string);
        System.out.println();
        String espaco0 = " ";

        for ( int a = 0 ; a < palavra_escolhida.length() ; a++){
            if(palavra_escolhida.charAt(a) == espaco){
                letras_corretas.add(espaco0);
            }
        }

        while (entrada != "sair"){ // Aqui criamos um loop para poder pedir a digitação de letras até que a palavra seja descoberta ou acabe as chances!

            System.out.println("Digite uma letra : ");
            
            String letra = input.nextLine().trim().toLowerCase(); // Aqui recebemos a entrada da letra e tratamos para retirar espaços e que entre sempre como
                                                                  // letra minúscula
        
        char letra0 = letra.charAt(0);
        
        if(letra0 == 'a'){
                if (palavra_escolhida.contains(a0)){
                    for (int index = 0 ; index < palavra_escolhida.length() ; index ++){
                        if (palavra_escolhida.charAt(index) == acento0){
                            string.setCharAt(index,acento0);
                            letras_corretas.add(a0);
                        }
                    }
                }else if (palavra_escolhida.contains(a1)){
                    for (int index = 0 ; index < palavra_escolhida.length() ; index ++){
                        if (palavra_escolhida.charAt(index) == acento1){
                            string.setCharAt(index, acento1);
                            letras_corretas.add(a1);
                        }
                    }
                }else if (palavra_escolhida.contains(a2)){
                    for (int index = 0 ; index < palavra_escolhida.length() ; index ++){
                        if (palavra_escolhida.charAt(index) == acento2){
                            string.setCharAt(index, acento2);
                            letras_corretas.add(a2);
                        }
                    }
                }
        }else if(letra0 == 'e'){
                if (palavra_escolhida.contains(a3)){
                    for (int index = 0 ; index < palavra_escolhida.length() ; index ++){
                        if (palavra_escolhida.charAt(index) == acento3){
                            string.setCharAt(index, acento3);
                            letras_corretas.add(a3);
                        }
                    }
                }else if (palavra_escolhida.contains(a4)){
                    for (int index = 0 ; index < palavra_escolhida.length() ; index ++){
                        if (palavra_escolhida.charAt(index) == acento4){
                            string.setCharAt(index, acento4);
                            letras_corretas.add(a4);
                        }
                    }
                }
        }else if(letra0 == 'i'){
                if (palavra_escolhida.contains(a5)){
                    for (int index = 0 ; index < palavra_escolhida.length() ; index ++){
                        if (palavra_escolhida.charAt(index) == acento5){
                            string.setCharAt(index, acento5);
                            letras_corretas.add(a5);
                        }
                    }
                }else if (palavra_escolhida.contains(a6)){
                    for (int index = 0 ; index < palavra_escolhida.length() ; index ++){
                        if (palavra_escolhida.charAt(index) == acento6){
                            string.setCharAt(index, acento6);
                            letras_corretas.add(a6);
                    }
                }
            }
        }else if(letra0 == 'u'){
                if (palavra_escolhida.contains(a7)){
                    for (int index = 0 ; index < palavra_escolhida.length() ; index ++){
                        if (palavra_escolhida.charAt(index) == acento7){
                            string.setCharAt(index, acento7);
                            letras_corretas.add(a7);
                        }
                    }
                }else if (palavra_escolhida.contains(a8)){
                    for (int index = 0 ; index < palavra_escolhida.length() ; index ++){
                        if (palavra_escolhida.charAt(index) == acento8){
                            string.setCharAt(index, acento8);
                            letras_corretas.add(a8);
                        }
                    }
                }
        }else if(letra0 == 'o'){
                if (palavra_escolhida.contains(a9)){
                    for (int index = 0 ; index < palavra_escolhida.length() ; index ++){
                        if (palavra_escolhida.charAt(index) == acento9){
                            string.setCharAt(index, acento9);
                            letras_corretas.add(a9);
                        }
                    }
                }else if (palavra_escolhida.contains(a10)){
                    for (int index = 0 ; index < palavra_escolhida.length() ; index ++){
                        if (palavra_escolhida.charAt(index) == acento10){
                            string.setCharAt(index, acento10);
                            letras_corretas.add(a10);
                        }
                    }
                }else if (palavra_escolhida.contains(a11)){
                    for (int index = 0 ; index < palavra_escolhida.length() ; index ++){
                        if (palavra_escolhida.charAt(index) == acento11){
                            string.setCharAt(index, acento11);
                            letras_corretas.add(a11);
                        }
                    }
                }
        }else if (letra0 == 'c')
                if (palavra_escolhida.contains(a12)){
                    for (int index = 0 ; index < palavra_escolhida.length() ; index ++){
                        if (palavra_escolhida.charAt(index) == acento12){
                            string.setCharAt(index, acento12);
                            letras_corretas.add(a12);
                        }
                    }
                }
                
        for (int a = 0 ; a < palavra_escolhida.length() ; a++){
            if (letra0 == palavra_escolhida.charAt(a)){ // Aqui fazemos um loop para percorrer toda a palavra e se a letra digitada estiver em alguma posição ela
                string.setCharAt(a,letra0);         // é colocada no lugar do asterisco na string
            }
        }  


        if (palavra_escolhida.contains(letra)){
            int count = 0;
            for(int o = 0;o < palavra_escolhida.length();o ++){
                if(palavra_escolhida.charAt(o) == letra0){   
                count ++; // Aqui fazemos um loop para contar as ocorrências de cada letra, se tiver mais de uma ocorrências ela são adicionadas proporcionalmente
                }      // no array de letras corretas para coincidir com o tamanho da palavra e aparecer a mensagem de venceu o jogo
        }
        int letra1 = count;
        for(int cont = 0; cont < letra1; cont++){
            letras_corretas.add(letra); // Aqui fazemos a adição das ocorrências das letras no array de letras corretas
        }
        //System.out.printf("A letra %s aparece %d vezes",letra0,letra1);
        //System.out.println();
    }
        char primeira_letra = string.charAt(0);
        Character.toUpperCase(primeira_letra);

        if (palavra_escolhida.contains(letra)){
            System.out.println(string); // Se a letra digitada estiver na palavra secreta a string com a letra em sua respectiva posição é impressa
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
            System.out.printf("Você perdeu,você gastou todas as chances, a palavra secreta era %s",palavra_escolhida);
            System.out.println(); // Se você perder todas as chances o jogo lamenta que você perdeu e te diz qual era a palavra secreta!
            break;   
        }
    }
input.close();
}
}


