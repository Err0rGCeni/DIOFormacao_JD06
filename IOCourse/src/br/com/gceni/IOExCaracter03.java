package br.com.gceni;

import java.io.*;

public class IOExCaracter03 {
    public static void main(String[] args) throws IOException {
        copiarArquivo();
    }

    public static void copiarArquivo() throws IOException {
        File f = new File("../../../rec.txt"); // Cria um objeto File representando o arquivo de origem
        String fileName = f.getName(); // Obtém o nome do arquivo de origem
    
        // Abre um BufferedReader para ler o arquivo de origem
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line = br.readLine(); // Lê a primeira linha do arquivo de origem
    
        // Cria um nome para o arquivo de destino adicionando "-edited.txt" ao nome do arquivo de origem
        String fileNameCopy = fileName.substring(0, fileName.indexOf(".")).concat("-edited.txt");
        File fcopy = new File(fileNameCopy); // Cria um objeto File para representar o arquivo de destino
    
        // Abre um BufferedWriter para escrever no arquivo de destino
        BufferedWriter bw = new BufferedWriter(new FileWriter(fcopy.getName()));
    
        // Loop para ler e escrever linhas até o final do arquivo de origem
        do {
            bw.write(line); // Escreve a linha lida no arquivo de destino
            bw.newLine(); // Insere uma nova linha no arquivo de destino
            bw.flush(); // Força a escrita imediata dos dados no arquivo de destino
            line = br.readLine(); // Lê a próxima linha do arquivo de origem
        } while (line != null); // Continua o loop até o final do arquivo de origem
    
        // Imprime uma mensagem indicando que a cópia foi concluída com sucesso
        System.out.printf("Arquivo '%s' -> '%s' copiado com sucesso!", fileName, fileNameCopy);

        PrintWriter pw = new PrintWriter(System.out);
        pw.println("Recomende 3 livros: ");
        pw.flush();

        adicionarInfoNoArquivo(fcopy.getName());

        pw.printf("Tamanho do arquivo %d bytes.", fcopy.length());
        
        br.close();
        bw.close();
        pw.close();
    }
    
    public static void adicionarInfoNoArquivo(String arquivo) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo, true));

        do {
            bw.write(line);
            bw.newLine();
            line = br.readLine();
        } while(!(line.equalsIgnoreCase("fim")));

        br.close();
        bw.close();        
    }
}
