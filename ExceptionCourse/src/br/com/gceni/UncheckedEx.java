package br.com.gceni;

import javax.swing.*;

public class UncheckedEx {
    public static void main(String[] args) {

        do {
            // JOptionPane possibilita a criação de uma caixa de dialogo padrão
            // que ou solicita um valor para o usuário ou retorna uma informação.
            String a = JOptionPane.showInputDialog("Numerador: ");
            String b = JOptionPane.showInputDialog("Denominador: ");

            try {
                // Uma vez identificado que essa linha é passível de erro, usa-se um try-catch
                int resultado = dividir(Integer.parseInt(a), Integer.parseInt(b));
                System.out.println("Resultado: " + resultado);
                break;
            } catch (NumberFormatException e) {
                // Exceção por entrada não ser um número
                JOptionPane.showMessageDialog(null, "Entrada Inválida!" + e.getMessage());
                // e.printStackTrace();
            } catch (ArithmeticException e) {
                // Exceção por operação de divisão por zero inválida
                JOptionPane.showMessageDialog(null, "Divisão Inválida!" + e.getMessage());
            } finally {
                System.out.println("Finally!");
            }
        } while (true);
    }

    public static int dividir(int a, int b) {
        return a / b;
    }

    /*
     * Exception in thread "main" java.lang.NumberFormatException: For input string:
     * "Nome"
     * at java.base/java.lang.NumberFormatException.forInputString(
     * NumberFormatException.java:65) <- Exceptions que tratam erros de conversão
     * str -> int
     * NumberFormatException <- IllegalArgumentException <- RuntimeException <-
     * Exception <- Throwable
     * at java.base/java.lang.Integer.parseInt(Integer.java:652) <- Linha com
     * parseInt(String s, int radix) com conjunto de Ifs para Exceptions
     * at java.base/java.lang.Integer.parseInt(Integer.java:770) <- Linha com
     * sobrecarga do método parseInt(String s)
     * at br.com.gceni.UncheckedEx.main(UncheckedEx.java:12) <- Linha em que ocorreu
     * a Exception
     */

}
