package br.com.gceni;

public class Main {
    public static void main(String[] args) {
        System.out.println("Início do programa no método main.");
        a();
        System.out.println("Fim do programa no método main.");
    }

    static void a() {
        System.out.println("Início do método a.");
        b();
        System.out.println("Fim do método a.");
    }
    
    static void b() {
        System.out.println("Início do método b.");
        for (int i = 0; i < 5; i++) {
            System.out.println("I: "+i);
        }
        c();
        System.out.println("Fim do método b.");
    }

    static void c() {
        System.out.println("Início do método c.");
        //Thread..dumpStack();
        System.out.println("Finalizou o método c.");
    }

}
