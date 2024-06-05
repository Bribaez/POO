import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Equipo {
	private String nombre;
	private String ciudad;
	private LinkedList<Jugador> jugadores = new LinkedList<Jugador>();
	public Equipo(String nombre, String ciudad) {
		this.nombre = nombre;
		this.ciudad = ciudad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public LinkedList<Jugador> getJugadores() {
		return jugadores;
	}
	public void setJugadores(LinkedList<Jugador> jugadores) {
		this.jugadores = jugadores;
	}
	@Override
	public String toString() {
		return "\nEquipo [nombre=" + nombre + ", ciudad=" + ciudad + ", jugadores=" + jugadores +"]";
	} 
	public void agregarJugadoresFalso(int cant) {

		for (int i = 0; i < cant; i++) {
			boolean flag = true;
			do {
				String[] nombre = {"Manuel", "Lucas", "Daniel", "Hugo", "Alejandro","Mateo", "Martin","Camilo"};
				int edad = (int)(Math.random()*40+1);
				int camiseta = (int)(Math.random()*99+1);
				String[] posicion = {"Arquero","Delantero","Mediocampista","Defensor"};


				for (Jugador jugador: this.getJugadores()) {
					if (edad<=18) {
						flag=false;
					} else {
						if (jugador.getnCamiseta()==camiseta) {
							flag=false;

						}
					}



				}
				this.getJugadores().add(new Jugador(nombre[(int)(Math.random()*8)],edad,camiseta,posicion[(int)(Math.random()*4)]));

				break;
			} while (flag==true);


		}
	}
	public boolean agregarJugador(String nombre, int edad, int nCamiseta, String posicion) {
		for (Jugador jugador : jugadores) {

			if (jugador.getNombre().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Nombre vacio");
				return false;
			} else {
				if (edad>=0 && edad<=18) {
					JOptionPane.showMessageDialog(null, "No puede participar por ser menor de edad");
					return false;

				} else {
					if(jugador.getnCamiseta()==nCamiseta) {
						JOptionPane.showMessageDialog(null, "Se repite numero de camiseta");
						return false;
					}
				}
			}

		}

		//Validar datos
		this.getJugadores().add(new Jugador(nombre,edad,nCamiseta,posicion));
		return true;

	}


	public boolean eliminarJugador(String nombre) {
		for (Jugador jugador : jugadores) {
			if(jugador.getNombre()==nombre) {;
			this.getJugadores().remove(this.getJugadores().indexOf(jugador));
			return true;
			}
		}


		return false;

	}
}
