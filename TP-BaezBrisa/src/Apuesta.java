public class Apuesta {
    private String nombreGanador;
    private String apuestaRealizada;
    private int montoApostado;
    private String resultado;  // Puede ser "Ganó" o "Perdió"

    public Apuesta(String nombreGanador, String apuestaRealizada, int montoApostado) {
        this.nombreGanador = nombreGanador;
        this.apuestaRealizada = apuestaRealizada;
        this.montoApostado = montoApostado;
        this.resultado = (nombreGanador.equals(apuestaRealizada)) ? "Ganó" : "Perdió";
    }

    public String getNombreGanador() {
        return nombreGanador;
    }

    public String getApuestaRealizada() {
        return apuestaRealizada;
    }

    public int getMontoApostado() {
        return montoApostado;
    }

    public String getResultado() {
        return resultado;
    }

    @Override
    public String toString() {
        return "Apuesta{" +
               "nombreGanador='" + nombreGanador + '\'' +
               ", apuestaRealizada='" + apuestaRealizada + '\'' +
               ", montoApostado=" + montoApostado +
               ", resultado='" + resultado + '\'' +
               '}';
    }
}
