package br.com.gceni;

import java.io.*;

public class IOExByte01 {
    public static void main(String[] args) throws IOException {
        copiarArquivo(); // Chamada do método para copiar o arquivo
    }

    public static void copiarArquivo() throws IOException {
        File f = new File("../../../rec.txt");
        // Obtém o nome do arquivo original
        String nomeArquivo = f.getName();
        System.out.println(nomeArquivo);
        // Abre um BufferedInputStream para ler o arquivo original
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(f.getName()));

        // Cria um nome para o arquivo de cópia
        String nomeArquivoCopy = nomeArquivo.substring(0, nomeArquivo.indexOf(".")).concat("-copy2.txt");
        File fCopy = new File(nomeArquivoCopy);

        // Abre um BufferedOutputStream para escrever no arquivo de cópia
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(nomeArquivoCopy));

        int line = 0;
        // Lê bytes do arquivo original e escreve no arquivo de cópia
        while ((line = bis.read()) != -1) {
            bos.write((char) line); // Escreve o byte lido no arquivo de cópia
            bos.flush(); // Força a escrita imediata dos dados no arquivo de cópia
        }

        bis.close(); // Fecha o BufferedInputStream
        bos.close(); // Fecha o BufferedOutputStream

        // Imprime uma mensagem indicando que o arquivo foi copiado com sucesso
        PrintStream ps = new PrintStream(System.out);
        ps.printf("Arquivo %s copiado.", fCopy.getName());
    }
}
