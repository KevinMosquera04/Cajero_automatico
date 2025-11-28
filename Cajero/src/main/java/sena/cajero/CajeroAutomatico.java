/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sena.cajero;

import javax.swing.JOptionPane;
import java.util.Random;

public class CajeroAutomatico {

    private int saldo = 7000000, SaldoCN = 20000000, retiroD = 2100000;
    private boolean continuar = true;

    public CajeroAutomatico() {
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getSaldoCN() {
        return SaldoCN;
    }

    public void setSaldoCN(int SaldoCN) {
        this.SaldoCN = SaldoCN;
    }

    public int getRetiroD() {
        return retiroD;
    }

    public void setRetiroD(int retiroD) {
        this.retiroD = retiroD;
    }

    public void CajeroAutomatico() {
        while (continuar) {
            try {
                StringBuilder menu = new StringBuilder("MENU CAJERO AUTOMATICO \n\n");
                menu.append("seleciones una opcion del 1 al 4 asi \n")
                        .append("1. consultar saldo \n")
                        .append("2. consignar dinero \n")
                        .append("3. retirar dinero \n")
                        .append("4. salir \n");
                String opcion = JOptionPane.showInputDialog(null, menu, "Cajero Automatico", JOptionPane.QUESTION_MESSAGE);
                if (opcion == null) {
                    if (confirmarSalida()) {
                        continuar = false;
                    }
                    continue;
                }
                int opc = Integer.parseInt(opcion);
                switch (opc) {
                    case 1:
                        consultar_saldo();
                        break;
                    case 2:
                        consignar_dinero();
                        break;
                    default:
                        throw new AssertionError();
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error", "Debes ingresar un numero del 1 al 4", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public boolean confirmarSalida() {
        int confirmar = JOptionPane.showConfirmDialog(null, "¿Estas seguro que deseas salir?", "confirmar Salida", JOptionPane.YES_NO_OPTION);
        return confirmar == JOptionPane.YES_OPTION;
    }

    public String id_validacion() {
        Random id = new Random();
        int numero = id.nextInt(9000) + 1000;
        return "ID de la operacion # " + numero + "\n";
    }

    public void consignar_dinero() {
        try {
            String valor = JOptionPane.showInputDialog(
                    null,
                    "Ingrese la cantidad a consignar",
                    "Consignar Dinero",
                    JOptionPane.QUESTION_MESSAGE
            );

            if (valor == null) {
                return;
            }

            int cantidad = Integer.parseInt(valor);

      
            if (cantidad < 10000) {
                JOptionPane.showMessageDialog(
                        null,
                        "El monto mínimo para consignar es 10.000.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }

         
            if (cantidad % 10000 != 0) {
                JOptionPane.showMessageDialog(
                        null,
                        "ERROR: Solo se acepta de 10.000 en adelante",
                        "Monto inválido",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }

        
            saldo += cantidad;

            String id = id_validacion();

            StringBuilder mensaje = new StringBuilder("CONSIGNACIÓN EXITOSA\n\n");
            mensaje.append(id)
                    .append("Valor consignado: $").append(String.format("%,d", cantidad)).append("\n")
                    .append("Nuevo saldo: $").append(String.format("%,d", saldo));

            JOptionPane.showMessageDialog(null, mensaje, "Consignación", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Debe ingresar un valor numérico válido.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void consultar_saldo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
