/**
 *  Un objeto de esta clase representa un envío de varios paquetes,
 *  máximo tres
 *
 *
 * @author Jonathan del arco 
 *
 */
public class Envio
{
    private final double PRECIO_KILO = 2.2;  // precio coste envío Kg. en euros
    private Paquete paquete1;
    private Paquete paquete2;
    private Paquete paquete3;
    /**
     * Constructor
     * Inicializa los paquetes a null (inicialmente el envío no tiene paquetes)
     */
    public Envio()    {
        this.paquete1 = null;
        this.paquete2 = null;
        this.paquete3 = null;
    }

    /**
     * accesor para el paquete1
     */
    public Paquete getPaquete1() {
        return paquete1;
    }

    /**
     * accesor para el paquete2
     */
    public Paquete getPaquete2() {
        return paquete2;
    }

    /**
     * accesor para el paquete3 
     */
    public Paquete getPaquete3() {
        return paquete3;
    }

    /**
     * Devuelve el nº de paquetes en el envío 
     * (dependerá de cuántos paquetes estén a null)
     */
    public int getNumeroPaquetes() {
        int contador = 0;
        if(paquete1 != null && paquete2 != null && paquete3 != null) {
            contador = 3;
        }else if(paquete1 != null && paquete2 == null && paquete3 == null){
            contador = 1;
        }else if(paquete1 != null && paquete2 != null && paquete3 == null){
            contador = 2;
        }
        return contador;
    }

    /**
     * Devuelve true si el envío está completo, false en otro caso
     * (tiene exactamente 3 paquetes)
     */
    public boolean envioCompleto() {
        boolean hayONoHay = true;
        switch(getNumeroPaquetes()){
            case 1: 
                return hayONoHay = false;
            case 2: 
                return hayONoHay = false;
            case 3: 
                return hayONoHay = true;
        }
        return hayONoHay;
    }

    /**
     * Se añade un nuevo paquete al envío
     * Si el envío está completo se muestra el mensaje "No se admiten más paquetes en el envío"
     * Si no está completo se añade el paquete al envío teniendo en cuenta si se añade como primero, segundo o tercero (no han de quedar huecos)
     */
    public void addPaquete(Paquete paquete) {
        if (this.paquete1 == null) {
            this.paquete1 = paquete;
        } else if (this.paquete2 == null){
            this.paquete2 = paquete;
        } else if (this.paquete3 == null) {
            this.paquete3 = paquete;
        } else {
            System.out.println("\n\nNo se admiten más paquetes en el envío");
        }
    }

    /**
     * Calcula y devuelve el coste total del envío
     *
     * Para calcular el coste:
     *      - se obtiene el peso facturable de cada paquete
     *      - se suman los pesos facturables de todos los paquetes del envío
     *      - se calcula el coste en euros según el precio del Kg
     *      (cada Kg. no completo se cobra entero, 5.8 Kg. se cobran como 6, 5.3 Kg. se cobran como 6)
     *
     *
     */
    public double calcularCosteTotalEnvio() {
        double costetotal =0;
        double pFacP1;
        double pFacP2;
        double pFacP3;
        double sumafacTotal;
        switch(getNumeroPaquetes()){
            case 1:
                pFacP1 = paquete1.calcularPesoFacturable();
                sumafacTotal = Math.ceil(pFacP1);
                costetotal = sumafacTotal*PRECIO_KILO;
            break;
            case 2:
                pFacP1 = paquete1.calcularPesoFacturable();
                pFacP2 = paquete2.calcularPesoFacturable();
                sumafacTotal = Math.ceil(pFacP1+pFacP2);
                costetotal = sumafacTotal*PRECIO_KILO;
            break;
            case 3:
                pFacP1 = paquete1.calcularPesoFacturable();
                pFacP2 = paquete2.calcularPesoFacturable();
                pFacP3 = paquete3.calcularPesoFacturable();
                sumafacTotal = Math.ceil(pFacP1+pFacP2+pFacP3);
                costetotal = sumafacTotal*PRECIO_KILO;
            break;
        }
        return costetotal;
    }

    /**
     * Representación textual del envío
     * con el formato exacto indicado
     * (leer enunciado)
     */
    public String toString() {
        if(getNumeroPaquetes() == 1){
            System.out.println("\nNº de paquetes: " + getNumeroPaquetes());
            System.out.println(paquete1.toString());
            System.out.printf(String.format("\n%20s: %10.2f €", "Coste total envío", calcularCosteTotalEnvio()));
        } else if(getNumeroPaquetes() == 2){
            System.out.println("\nNº de paquetes: " + getNumeroPaquetes());
            System.out.println(paquete1.toString());
            System.out.println(paquete2.toString());
            System.out.printf(String.format("\n%20s: %10.2f €", "Coste total envío", calcularCosteTotalEnvio()));
        } else if(getNumeroPaquetes() == 3){
            System.out.println("\n\nNº de paquetes: " + getNumeroPaquetes());
            System.out.println(paquete1.toString());
            System.out.println(paquete2.toString());
            System.out.println(paquete3.toString());
            System.out.printf(String.format("\n%20s: %10.2f €", "Coste total envío", calcularCosteTotalEnvio()));
        }
        return "";
    }

    /**
     * Muestra en pantalla el objeto actual
     * Este método se incluye como método de prueba
     * de la clase Envio
     */
    public void print() {
        System.out.println(this.toString());
    }
}
