import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public class GestorEquipos {
	private LinkedList<Equipo> equipos = new  LinkedList<Equipo> ();
	private LinkedList<Partido> partidos = new  LinkedList<Partido> ();

	public GestorEquipos() {

	}

	public LinkedList<Equipo> getEquipos() {
		return equipos;
	}

	public void setEquipos(LinkedList<Equipo> equipos) {
		this.equipos = equipos;
	}


	public LinkedList<Partido> getPartidos() {
		return partidos;
	}

	public void setPartidos(LinkedList<Partido> partidos) {
		this.partidos = partidos;
	}

	public boolean agregarEquipo(String nombre,String ciudad) {
		for (Equipo equipo: equipos) {
			if (equipo.getNombre()==nombre) {
				JOptionPane.showMessageDialog(null, "Se repite equipo");
				return false;


			}



		}
		JOptionPane.showMessageDialog(null, "Se pudo agregar");
		this.getEquipos().add(new Equipo(nombre,ciudad, ciudad));
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

	/*	public Partido JugarPartido(Equipo equipo1, Equipo equipo2) {
		if (equipo1==equipo2) {
			JOptionPane.showMessageDialog(null, "No se puede jugar entre el mismo equipo");
			return null;
		} else {
			if (equipo1.getJugadores().size()<7 || equipo2.getJugadores().size()<7) {
				JOptionPane.showMessageDialog(null, "No se puede jugar, faltan jugadores");
				return null;
			} else {

				JOptionPane.showMessageDialog(null, "Se enfrentan: " + equipo1.getNombre() + " vs " + equipo2.getNombre());

				int goles1;
				int goles2;
				do {
					goles1 = (int)(Math.random()*3);
					goles2 = (int)(Math.random()*3);
					if (goles1==goles2) {
						JOptionPane.showMessageDialog(null, "Hay penales");
					}
				} while (goles1==goles2);



					return new Partido(equipo1, equipo2, goles1, goles2);


			}
		}

	}
	 */
	public Partido JugarPartido(Equipo equipo1, Equipo equipo2) {
	    if (equipo1 == equipo2) {
	        JOptionPane.showMessageDialog(null, "No se puede jugar entre el mismo equipo");
	        return null;
	    } else {
	        if (equipo1.getJugadores().size() < 7 || equipo2.getJugadores().size() < 7) {
	            JOptionPane.showMessageDialog(null, "No se puede jugar, faltan jugadores");
	            return null;
	        } else {
	            JOptionPane.showMessageDialog(null, "Se enfrentan: " + equipo1.getNombre() + " vs " + equipo2.getNombre());

	            // Primer tiempo
	            int goles1PrimerTiempo = (int) (Math.random() * 3);
	            int goles2PrimerTiempo = (int) (Math.random() * 3);
	            JOptionPane.showMessageDialog(null, "Resultado del primer tiempo: " + equipo1.getNombre() + " " + goles1PrimerTiempo +
	                    " - " + goles2PrimerTiempo + " " + equipo2.getNombre());

	            // Segundo tiempo
	            int goles1SegundoTiempo = (int) (Math.random() * 3);
	            int goles2SegundoTiempo = (int) (Math.random() * 3);
	            JOptionPane.showMessageDialog(null, "Resultado del segundo tiempo: " + equipo1.getNombre() + " " + goles1SegundoTiempo +
	                    " - " + goles2SegundoTiempo + " " + equipo2.getNombre());

	            // Sumar los goles para obtener el resultado final
	            int goles1 = goles1PrimerTiempo + goles1SegundoTiempo;
	            int goles2 = goles2PrimerTiempo + goles2SegundoTiempo;


	            while (goles1 == goles2) {
	                JOptionPane.showMessageDialog(null, "Empataron el equipo " + equipo1.getNombre() + " - " + equipo2.getNombre());
	                goles1 = (int) (Math.random() * 5);
	                goles2 = (int) (Math.random() * 5);
	            }


	            if (goles1 == goles2) {
	                JOptionPane.showMessageDialog(null, "Empate en tiempo regular. Se jugarán penales.");
	                int golesPenales1 = 0;
	                int golesPenales2 = 0;

	           
	                while (golesPenales1 == golesPenales2) {
	                    golesPenales1 = (int) (Math.random() * 5);
	                    golesPenales2 = (int) (Math.random() * 5);
	                }

	       
	                JOptionPane.showMessageDialog(null, "Resultado de los penales: " + equipo1.getNombre() + " " + golesPenales1 +
	                        " - " + golesPenales2 + " " + equipo2.getNombre());

	          
	                if (golesPenales1 > golesPenales2) {
	                    JOptionPane.showMessageDialog(null, equipo1.getNombre() + " gana en penales!");
	                    goles1 = golesPenales1;
	                    goles2 = golesPenales2;
	                } else {
	                    JOptionPane.showMessageDialog(null, equipo2.getNombre() + " gana en penales!");
	                    goles1 = golesPenales1;
	                    goles2 = golesPenales2;
	                }
	            }

	         
	            JOptionPane.showMessageDialog(null, "Resultado final: " + equipo1.getNombre() + " " + goles1 +
	                    " - " + goles2 + " " + equipo2.getNombre());

	        
	            return new Partido(equipo1, equipo2, goles1, goles2);
	        }
	    }
	}

	public void RellenarTodosLosEquipos() {
		for (Equipo equipo : equipos) {
			equipo.agregarJugadoresFalso(11);
		}
	}

}
