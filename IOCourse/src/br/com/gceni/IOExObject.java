package br.com.gceni;

import java.io.*;

public class IOExObject {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        //serealizacao();
        desserealizacao("gato");
    }

    public static void serealizacao() throws FileNotFoundException, IOException {
        Gato gato = new Gato("Simba", 6, "amarelado");
        File f = new File("gato");

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream((f.getName())));
        oos.writeObject(gato);
        PrintStream ps = new PrintStream(System.out);
        ps.printf("Arquivo %s criado", f.getName());

        oos.close();
        ps.close();

    }

    public static void desserealizacao(String arquivo) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo));
        Gato objetoGato = (Gato) ois.readObject();
        System.out.println(objetoGato);

        ois.close();

        

    }

}
