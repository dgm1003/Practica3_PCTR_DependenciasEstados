package src.p03.c01;

public class SistemaLanzador {
	/**
	 * El main recibe dos argumentos de entrada, args[0] que será el numero de puertas del parque y arg[1] correspondiente al
	 * máximo de personas que puede haber en el interior del parque.
	 * 
	 * @param args 
	 */
	
	public static void main(String[] args) {
		
		IParque parque = new Parque(Integer.parseInt(args[1]));
		char letra_puerta = 'A';
		
		System.out.println("¡Parque abierto!");
		
		for (int i = 0; i < Integer.parseInt(args[0]); i++) {
			
			String puerta = ""+((char) (letra_puerta++));
			
			// Creación de hilos de entrada
			ActividadEntradaPuerta entradas = new ActividadEntradaPuerta(puerta, parque);
			new Thread (entradas).start();
			
			// Creación de hilos de salida
			ActividadSalidaPuerta salidas = new ActividadSalidaPuerta(puerta, parque);
			new Thread (salidas).start();
			
			
		}
	}	
}