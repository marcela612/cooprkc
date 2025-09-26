package transacciones;

public interface Transaccion {
    vacio ejecutar(Cuenta cuenta);
    double obtenerMonto();
    
}
