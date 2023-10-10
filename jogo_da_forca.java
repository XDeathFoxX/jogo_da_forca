package java_projetos.jogo_da_forca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class jogo_da_forca {
    
    public static void main(String[] args){

        ArrayList <String> paises = new ArrayList<>();
        ArrayList <String> letras_corretas = new ArrayList<>(); // Aqui criamos os arrays para receber as palavras que podem ser sorteadas para a palavra secreta
        ArrayList <String> times = new ArrayList<>();
        ArrayList <String> tema_escolhido = new ArrayList<>();
        ArrayList <String> comidas = new ArrayList<>();
        ArrayList <String> letras_com_acento = new ArrayList<>();
        ArrayList <String> letras_digitadas = new ArrayList<>();
        ArrayList <Character> acentos_a = new ArrayList<>();
        ArrayList <Character> acentos_u = new ArrayList<>();
        ArrayList <Character> acentos_o = new ArrayList<>();
        ArrayList <Character> acentos_e = new ArrayList<>();
        ArrayList <Character> acentos_i = new ArrayList<>();
        ArrayList <Character> acentos_cedilha = new ArrayList<>();
        ArrayList <Character> verifica_acento = new ArrayList<>();
        Map<Integer, String> acentos = new HashMap<Integer,String>();
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
        times.add("Bragantino");
        times.add("Palmeiras");
        comidas.add("Macarrão");
        comidas.add("Pizza");
        comidas.add("Carne");
        comidas.add("Arroz");
        comidas.add("Feijão");
        comidas.add("Lasanha");
        comidas.add("Strogonoff");
        acentos.put(0 , "ã");
        acentos.put(1 , "á");
        acentos.put(2 , "ó");
        acentos.put(3 , "ú");
        acentos.put(4 , "â");
        acentos.put(5 , "é");
        acentos.put(6 , "ê");
        acentos.put(7 , "í");
        acentos.put(8 , "î");
        acentos.put(9 , "û");
        acentos.put(10 , "ô");
        acentos.put(11 , "õ");
        acentos.put(12 , "ç");
        letras_com_acento.add("a");
        letras_com_acento.add("e");
        letras_com_acento.add("i");
        letras_com_acento.add("u");
        letras_com_acento.add("o");
        letras_com_acento.add("c");
        acentos_a.add('ã');
        acentos_a.add('á');
        acentos_a.add('â');
        acentos_u.add('ú');
        acentos_u.add('û');
        acentos_e.add('é');
        acentos_e.add('ê');
        acentos_i.add('í');
        acentos_i.add('î');
        acentos_o.add('ô');
        acentos_o.add('ó');
        acentos_o.add('õ');
        acentos_cedilha.add('ç');


        System.out.println("Digite a opção de tema desejado: \n 1 - Países \n 2 - Times \n 3 - Comidas");
        String tema = input.nextLine();

        switch(tema){
            case "1":
                tema_escolhido = paises;
                break;
            case "2":
                tema_escolhido = times; // Aqui fazemos a seleção do tema escolhido pelo usuário!
                break;
            case "3":
                tema_escolhido = comidas;
                break;
        }

        int num = random.nextInt(tema_escolhido.size()); // Aqui sorteamos uma palavra secreta pelo tamanho do array
        String escolhe_palavra = tema_escolhido.get(num).toLowerCase(); // Aqui pegamos a palavra secreta pelo indice sorteado do array
        String palavra_escolhida = escolhe_palavra;
        int tamanho_palavra = palavra_escolhida.length();
        
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
        String espaco0 = " ";
        for (int index = 0 ; index < palavra_escolhida.length() ; index ++){
            string.setCharAt(index,asterisco);
            if(espaco == palavra_escolhida.charAt(index)){
                string.setCharAt(index, espaco);
                letras_corretas.add(espaco0);
            }; // Aqui criamos uma string para fazer os asteriscos correspondentes pelo tamanho da palavra
        }
        
        System.out.println();
        String entrada = "";
        System.out.printf("A palavra secreta tem %d letras e você tem %d chances: %s",tamanho_palavra,chances,string);
        System.out.println();

        while (entrada != "sair"){ // Aqui criamos um loop para poder pedir a digitação de letras até que a palavra seja descoberta ou acabe as chances!
            
            System.out.println();
            System.out.println("Digite uma letra : ");
            
            String letra = input.nextLine().trim().toLowerCase(); // Aqui recebemos a entrada da letra e tratamos para retirar espaços e que entre sempre como
            System.out.println();                                // letra minúscula
            if (letra.length() == 1){
                char letra0 = letra.charAt(0);


                switch (letra0){
                case 'a':
                verifica_acento = acentos_a;
                break;

                case 'u':
                verifica_acento = acentos_u;
                break;
                
                case 'e':
                verifica_acento = acentos_e; // Aqui fazemos a atribuição dos acentos correspondentes pela letra digitada para fazer a verificação se existe na palavra secreta!
                break;

                case 'i':
                verifica_acento = acentos_i;
                break;

                case 'o':
                verifica_acento = acentos_o;
                break;

                case 'c':
                verifica_acento = acentos_cedilha;
                break;

            }

            for (int index_letra = 0; index_letra < palavra_escolhida.length(); index_letra ++){  
                for (int index_acento = 0; index_acento < verifica_acento.size(); index_acento ++){
                    if (letras_com_acento.contains(letra)){
                        if (palavra_escolhida.charAt(index_letra) == verifica_acento.get(index_acento)){
                            Character letra_acento;
                            letra_acento = verifica_acento.get(index_acento);
                            String letra_acentos = letra_acento.toString();
                            string.setCharAt(index_letra,letra_acento);
                            
                            if (letras_corretas.contains(letra_acentos)){ // Aqui fazemos a identificação do index da letra com acento a atribuiçaõ dela na string e nas letras_corretas!
                                
                            }else{
                                letras_corretas.add(letra_acentos);
                            }

                        }
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
                if (!letras_corretas.contains(letra)){
                    for(int cont = 0; cont < letra1; cont++){
                    letras_corretas.add(letra);
                    }
                }else{
                    // Aqui fazemos a adição das ocorrências das letras no array de letras corretas
            }

        }
            char primeira_letra = string.charAt(0);
            Character.toUpperCase(primeira_letra);
            
                switch (letra){ 
                    case "u":
                        if(letras_digitadas.contains(letra)){
                            System.out.println();
                            System.out.println("Letra já digitada, digite outra letra: ");
                            System.out.println();
                            System.out.println(string);
                            System.out.println();
                        }else if(palavra_escolhida.contains(acentos.get(3)) | palavra_escolhida.contains(acentos.get(9))){
                            System.out.println(string);
                        }else if(palavra_escolhida.contains(letra)){
                            System.out.println(string);
                        }else{
                            chances --;
                            System.out.println();
                            System.out.printf("Essa letra não existe na palavra secreta,você ainda tem %d chances ",chances);
                            System.out.println();
                            System.out.println(string);
                            System.out.println(); // Se a letra digitada não estiver na palavra secreta é diminuída uma chance!
                        }
                        break;
                    
                    case "a":
                        if(letras_digitadas.contains(letra)){
                            System.out.println();
                            System.out.println("Letra já digitada, digite outra letra: ");
                            System.out.println();
                            System.out.println(string);
                            System.out.println();
                        }else if(palavra_escolhida.contains(acentos.get(0)) | palavra_escolhida.contains(acentos.get(1)) | palavra_escolhida.contains(acentos.get(4))){
                            System.out.println(string);
                        }else if(palavra_escolhida.contains(letra)){
                            System.out.println(string);
                        }else{
                            chances --;
                            System.out.println();
                            System.out.printf("Essa letra não existe na palavra secreta,você ainda tem %d chances ",chances);
                            System.out.println();
                            System.out.println(string);
                            System.out.println(); // Se a letra digitada não estiver na palavra secreta é diminuída uma chance!
                        }
                        break;
                    
                    case "e":
                        if(letras_digitadas.contains(letra)){
                            System.out.println();
                            System.out.println("Letra já digitada, digite outra letra: ");
                            System.out.println();
                            System.out.println(string);
                            System.out.println();
                        }else if(palavra_escolhida.contains(acentos.get(5)) | palavra_escolhida.contains(acentos.get(6))){
                            System.out.println(string);
                        }else if(palavra_escolhida.contains(letra)){
                            System.out.println(string);
                        }else{
                            chances --;
                            System.out.println();
                            System.out.printf("Essa letra não existe na palavra secreta,você ainda tem %d chances ",chances);
                            System.out.println();
                            System.out.println(string);
                            System.out.println(); // Se a letra digitada não estiver na palavra secreta é diminuída uma chance!
                        }
                        break;

                    case "i":
                        if(letras_digitadas.contains(letra)){
                            System.out.println();
                            System.out.println("Letra já digitada, digite outra letra: ");
                            System.out.println();
                            System.out.println(string);
                            System.out.println();
                        }else if(palavra_escolhida.contains(acentos.get(7)) | palavra_escolhida.contains(acentos.get(8))){
                            System.out.println(string);
                        }else if(palavra_escolhida.contains(letra)){
                            System.out.println(string);
                        }else{
                            chances --;
                            System.out.println();
                            System.out.printf("Essa letra não existe na palavra secreta,você ainda tem %d chances ",chances);
                            System.out.println();
                            System.out.println(string);
                            System.out.println(); // Se a letra digitada não estiver na palavra secreta é diminuída uma chance!
                        }
                        break;

                    case "o":
                        if(letras_digitadas.contains(letra)){
                            System.out.println();
                            System.out.println("Letra já digitada, digite outra letra: ");
                            System.out.println();
                            System.out.println(string);
                            System.out.println();
                        }else if(palavra_escolhida.contains(acentos.get(2)) | palavra_escolhida.contains(acentos.get(10)) | palavra_escolhida.contains(acentos.get(11))){
                            System.out.println(string);
                        }else if(palavra_escolhida.contains(letra)){
                            System.out.println(string);
                        }else{
                            chances --;
                            System.out.println();
                            System.out.printf("Essa letra não existe na palavra secreta,você ainda tem %d chances ",chances);
                            System.out.println();
                            System.out.println(string);
                            System.out.println(); // Se a letra digitada não estiver na palavra secreta é diminuída uma chance!
                        }
                        break;
                    
                    case "c":
                        if(letras_digitadas.contains(letra)){
                            System.out.println();
                            System.out.println("Letra já digitada, digite outra letra: ");
                            System.out.println();
                            System.out.println(string);
                            System.out.println();
                        }else if(palavra_escolhida.contains(acentos.get(12))){
                            System.out.println(string);
                        }else if(palavra_escolhida.contains(letra)){
                            System.out.println(string);
                        }else{
                            chances --;
                            System.out.println();
                            System.out.printf("Essa letra não existe na palavra secreta,você ainda tem %d chances ",chances);
                            System.out.println();
                            System.out.println(string);
                            System.out.println(); // Se a letra digitada não estiver na palavra secreta é diminuída uma chance!
                        }
                        break;

                    default:
                        if(palavra_escolhida.contains(letra)){
                            System.out.println(string);
                        }else if(letras_digitadas.contains(letra)){
                            System.out.println();
                            System.out.println("Letra já digitada, digite outra letra: ");
                            System.out.println();
                            System.out.println(string);
                            System.out.println();
                        }else{
                            chances --;
                            System.out.println();
                            System.out.printf("Essa letra não existe na palavra secreta,você ainda tem %d chances ",chances);
                            System.out.println();
                            System.out.println(string);
                            System.out.println(); // Se a letra digitada não estiver na palavra secreta é diminuída uma chance!
                        }
                        break;
                    
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

            }else{
                System.out.println("Digite uma letra por vez, tente novamente! ");
            }
            letras_digitadas.add(letra);
        }
        input.close();
}
}