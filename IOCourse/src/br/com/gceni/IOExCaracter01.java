package br.com.gceni;

import java.io.*;

public class IOExCaracter01 {
    public static void main(String[] args) {
        try {
            receberTecladoImprimirConsole();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void receberTecladoImprimirConsole() throws IOException {

        /*
        InputStream is = System.in;                         -> Instância de InputStream, mas que só lê bytes
        InputStreamReader isr = new InputStreamReader(is);  -> Tipo de Reader que decodifica bytes em caracteres
        BufferedReader br = new BufferedReader(isr);        -> 
        br.readLine();
        */
        System.out.println("3 Filmes: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        /*      
        OutputStream os = System.out;
        OutputStreamWriter osw = new OutputStreamWriter(os);
        BufferedWriter bw = new BufferedWriter(osw);
        */

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        do {
            bw.write(line);
            bw.newLine();
            line = br.readLine();            
        } while (!(line.isEmpty()));
        
        bw.flush();

        br.close();
        bw.close();
    }
}
