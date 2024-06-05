
import javax.swing.JOptionPane;
public class Jugador {
	private String nombre;
	private int edad;
	private int nCamiseta;
	private String posicion;

	public Jugador(String nombre, int edad, int nCamiseta, String posicion) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.nCamiseta = nCamiseta;
		this.posicion = posicion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	public int getnCamiseta() {
		return nCamiseta;
	}

	public void setnCamiseta(int nCamiseta) {
		this.nCamiseta = nCamiseta;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	@Override
	public String toString() {
		return "\nJugador [nombre=" + nombre + ", edad=" + edad + ", camiseta=" + nCamiseta + ", posicion=" + posicion
				+ "]";
	}

	

}
