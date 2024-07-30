package br.com.gceni;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class IOExCaracter02 {
    public static void main(String[] args) throws IOException {
        lerTecladoEscreverDocumento();
    }

    public static void lerTecladoEscreverDocumento() throws IOException {
        PrintWriter pw = new PrintWriter(System.out); // Cria um PrintWriter para escrever no console
        pw.println("Digite 3 recomendações: "); // Imprime uma mensagem no console
        pw.flush(); // Força a escrita imediata dos dados no console

        Scanner scan = new Scanner(System.in); // Cria um Scanner para ler entrada do teclado
        String line = scan.nextLine(); // Lê uma linha de entrada do teclado

        File f = new File("rec.txt"); // Cria um objeto File para representar o arquivo "rec.txt"

        BufferedWriter bw = new BufferedWriter(new FileWriter(f.getName())); // Cria um BufferedWriter para escrever no
                                                                             // arquivo

        // Loop para ler e escrever linhas até que "fim" seja inserido
        do {
            bw.write(line); // Escreve a linha lida no arquivo
            bw.newLine(); // Insere uma nova linha no arquivo
            line = scan.nextLine(); // Lê a próxima linha de entrada do teclado
        } while (!(line.equalsIgnoreCase("fim"))); // Continua o loop até "fim" ser inserido
        bw.flush(); // Força qualquer saída em buffer ser escrita no arquivo

        pw.printf("Arquivo '%s' foi criado com sucesso!", f.getName()); // Imprime uma mensagem de sucesso no console
        pw.close(); // Fecha o PrintWriter
        scan.close(); // Fecha o Scanner
        bw.close(); // Fecha o BufferedWriter
    }

}
