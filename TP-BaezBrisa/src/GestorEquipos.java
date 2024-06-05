import java.util.LinkedList;

import javax.swing.JOptionPane;

public class GestorEquipos {
	private LinkedList<Equipo> equipos = new  LinkedList<Equipo> ();

	public GestorEquipos() {

	}

	public LinkedList<Equipo> getEquipos() {
		return equipos;
	}

	public void setEquipos(LinkedList<Equipo> equipos) {
		this.equipos = equipos;
	}
	public boolean agregarEquipo(String nombre,String ciudad) {
		for (Equipo equipo: equipos) {
			if (equipo.getNombre()==nombre) {
				JOptionPane.showMessageDialog(null, "Se repite equipo");
				return false;


			}
			

			
		}
		this.getEquipos().add(new Equipo(nombre,ciudad));
		return true;
	}
	  public boolean eliminarEquipo(String nombre) {


		    for (Equipo equipo : equipos) {
		      if(equipo.getNombre().equals(nombre)) {
		        this.getEquipos().remove(this.getEquipos().indexOf(equipo));
		        return true;
		      }
		    }


		    return false;

		  }
	
	public Equipo JugarPartido(Equipo equipo1, Equipo equipo2) {
		if (equipo1==equipo2) {
			JOptionPane.showMessageDialog(null, "No se puede jugar entre el mismo equipo");
			return null;
		} else {
			if (equipo1.getJugadores().size()<7 || equipo2.getJugadores().size()<7) {
				JOptionPane.showMessageDialog(null, "No se puede jugar, faltan jugadores");
				return null;
			} else {

				JOptionPane.showMessageDialog(null, "Se enfrentan " + equipo1.getNombre() + " vs " + equipo2.getNombre());

				int goles1;
				int goles2;
				do {
					goles1 = (int)(Math.random()*5);
					goles2 = (int)(Math.random()*5);
					if (goles1==goles2) {
						JOptionPane.showMessageDialog(null, "Hay penales");
					}
				} while (goles1==goles2);

				if (goles1>goles2) {

					return equipo1;
				} else {

					return equipo2;
				}
			}
		}

	}

}
