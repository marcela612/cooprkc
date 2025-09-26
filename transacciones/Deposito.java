package transacciones;

import modelo.cuenta;

// Implementación de la interfaz transacción para el metodo depósito.
// Encapsula la lógica y los datos requeridos para el metodo depósito.


public class Deposito implements Transaccion {
    private final double monto;

    public Deposito (double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto del deposito debe ser positivo. ");
        }
        this.monto = monto;
    }

    @Override
    public void ejecutar (Cuenta cuenta) {
        cuenta.depositar(monto);
        cuenta.agregarTransaccion(this); //se registra por si misma en el historial.
        System.out.println(
            "Deposito exitoso: " + String.format("$%,.2f" , monto) +
            "en cuenta: " + cuenta.getNumeroCuenta() +
            ". saldo actual: " + String.format("$%,.2f" , cuenta.getSaldo())
        );
    }

    @Override
    public double getMonto() {
        return monto;
    }
}
