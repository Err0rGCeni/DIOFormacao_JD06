package br.com.gceni;

import java.io.*;
import java.util.Scanner;

public class IOExData {
    public static void main(String[] args) {
        try {
            incluirProduto();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }        
    }

    public static void incluirProduto() throws IOException {
        File f = new File("peca-de-roupa.bin");

        PrintStream ps = new PrintStream(System.out);
        ps.flush();

        DataOutputStream dos = new DataOutputStream(new FileOutputStream(f.getPath()));

        Scanner scan = new Scanner(System.in);

        ps.println("Nome da peça: ");
        String nome = scan.nextLine();
        dos.writeUTF(nome);

        ps.print("Tamanho da paçea (P/M/G) ");
        char tamanho = (char) System.in.read();
        dos.writeChar(tamanho);

        ps.print("Quantidade: ");
        int quant = scan.nextInt();
        dos.writeInt(quant);

        ps.print("Preço unitário: ");
        double preço = scan.nextDouble();
        dos.writeDouble(preço);

        lerProduto(f.getPath());
        
        dos.close();
        scan.close();
    }

    public static void lerProduto(String arquivo) throws IOException {
        File f = new File(arquivo);

        DataInputStream dis = new DataInputStream(new FileInputStream(f.getPath()));

        String nome = dis.readUTF();
        char tamanho = dis.readChar();
        int quantidade = dis.readInt();
        double preço = dis.readDouble();

        System.out.printf("\nNome:\t%s\n", nome);
        System.out.printf("\nQuantidade:\t%d\n", quantidade);
        System.out.printf("\nTamanho:\t%s\n", tamanho);
        System.out.printf("\nPreço:\t%f\n", preço);

        dis.close();
    }

}
