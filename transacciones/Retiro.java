package transacciones;

import modelo.Cuenta;

// Impelmentación de la interfaz transacción para el metodo retiro.
// Encapsula la lógica de retiro, incluyendo el manejo de errores por los saldos insuficientes.

public class Retiro implements Transaccion {
    private final double monto;

    public Retiro (double monto){
        if (monto <= 0){
            throw new IllegalArgumentException("El monto del retiro debe ser positivo. ");
        }
        this.monto = monto;
    }

    /**
     * intenta ejecutar un retiro. si la cuenta lanza uan excepcion por el saldo insuficiente,
     * la captura y muestra un mensaje de error.
     * 
     * Se aplica gestion de errores 
     *  (try-catch): separa la logica de la operacion del manejo de sus posibles fallos.
     */

     @Override
     public void ejecutar (Cuenta cuenta) {
        try {
            cuenta.retirar(monto);
            cuenta.agregarTransaccion(this); //Solo se registra si el retiro fue exitoso.
            System.out.println(
                "Retiro exitoso: " + String.format("$%,.2f" , monto) +
                "de cuenta: " + cuenta.getNumeroCuenta() +
                ". Saldo actual: " + String.format("$%,.2f" , cuenta.getSaldo())
            );
        } catch (IllegalArgumentException | IllegalStateException e) {
            //Captura tanto errores de monto inválido y saldos insuficientes.
            System.err.println("Error en retiro de la cuenta " + cuenta.getNumeroCuenta() + ": " + e.getMessage());
        }
     }
    
     @Override
     public double getMonto() {
        return monto;
     }
}
