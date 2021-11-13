/**
 * Prueba un envio de tres paquetes
 * 
 * @author jonathan del arco
 * 
 */
public class TestEnvio
{
    /**
     * Clase main test envio
     */
    public static void main(){
        Paquete paquete1 = new Paquete();
        Paquete paquete2 = new Paquete(40,60,40);

        Envio envio1 = new Envio();
        envio1.addPaquete(paquete1);
        envio1.addPaquete(paquete2);
        
        envio1.toString();
        
        Dimension dimension = new Dimension(50,50,70);
        Paquete paquete3 = new Paquete(dimension,13);
        envio1.addPaquete(paquete3);
        
        envio1.toString();
        
        paquete2.obtenerCopia();
        envio1.addPaquete(paquete2);
    }
}
