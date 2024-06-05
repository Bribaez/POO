import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		GestorEquipos nuevo = new GestorEquipos();
		nuevo.getEquipos().add(new Equipo("Boca","La boca"));
		nuevo.getEquipos().add(new Equipo("River","Nuñez"));
		String[] Opciones = {

				"Jugar partido","Revisar Equipo","Ver la lista de equipos",
				"Agregar equipo","Buscar equipo","Salir"

		};
		int opcion =0;
		do {
			opcion = JOptionPane.showOptionDialog(null, "Bienvenido", null, 0, 0, null, Opciones, Opciones[0]);

			switch (opcion) {
			case 0:

				//Jugar partido
				JOptionPane.showMessageDialog(null, "El ganador es:"+
						nuevo.JugarPartido(nuevo.getEquipos().get(seleccionarEquipo(nuevo.getEquipos()))
								,nuevo.getEquipos().get(seleccionarEquipo(nuevo.getEquipos()))));

				break;
			case 1: 

				//Revisar equipo
				int seleccionado = seleccionarEquipo(nuevo.getEquipos());
				String[] opcionesDeJugadores = {
						"Agregar jugador","Rellenar jugadores",
						"Ver la lista de jugadores","Buscar jugador","Volver al menu principal",

				};
				int opcionJugadores=0;
				do {
					opcionJugadores = JOptionPane.showOptionDialog(null, "Menu de jugadores: ", null, seleccionado, opcionJugadores, null, opcionesDeJugadores, opcionesDeJugadores[0]);
					switch (opcionJugadores) {
					case 0:		
						//Agregar jugador 
						String nombre = JOptionPane.showInputDialog("Ingrese nombre");
						int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese edad"));
						int camiseta = Integer.parseInt(JOptionPane.showInputDialog("Ingrese numero camiseta"));
						String[] posiciones = {"Arquero","Delantero","Mediocampista","Defensor"};
						String posicion = (String) JOptionPane.showInputDialog(null, "Posición", null, 0, null, posiciones, posiciones[0]);
						if(nuevo.getEquipos().get(seleccionado).agregarJugador( nombre, edad, camiseta, posicion)) {
							JOptionPane.showMessageDialog(null, "Se pudo agregar!");
						}else {
							JOptionPane.showMessageDialog(null, "No se pudo agregar");

						}

						break;
					case 1: 			
						//Rellenar jugadores
						int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad"));
						nuevo.getEquipos().get(seleccionado).agregarJugadoresFalso(cantidad);
						break;
					case 2:
						//Ver la lista de jugadores
						if (nuevo.getEquipos().get(seleccionado).getJugadores().size()==0) {
							JOptionPane.showMessageDialog(null, "No hay jugadores");
						} else {
							JOptionPane.showMessageDialog(null,"Cantidad de jugadores: " + nuevo.getEquipos().get(0).getJugadores().size() + "   " + nuevo.getEquipos().get(seleccionado).getJugadores());
						}

						break;
					case 3:
						//Buscar jugador
						if (nuevo.getEquipos().get(seleccionado).getJugadores().size()==0) {
							JOptionPane.showMessageDialog(null, "No hay jugadores");
						} else {	
							String[] jugadores= new String[nuevo.getEquipos().get(seleccionado).getJugadores().size()]; 
							for (int i = 0; i < nuevo.getEquipos().get(seleccionado).getJugadores().size(); i++) {
								jugadores[i] =  nuevo.getEquipos().get(seleccionado).getJugadores().get(i).getNombre();
							}
							String seleccion = (String)JOptionPane.showInputDialog(null, "Jugadores",
									null, 0, null, jugadores, jugadores[0]);
							String[] opcionDeJugador = {
									"Eliminar jugador","Volver"
							};	
							int opcionJugador=0;
							do {
								opcionJugador = JOptionPane.showOptionDialog(null,  "Que deseas hacer con el jugador: "  , null, seleccionado, opcionJugador, null, opcionDeJugador, opcionDeJugador[0]);
								switch (opcionJugador) {
								case 0:
									//Eliminar jugador
									if(nuevo.getEquipos().get(seleccionado).eliminarJugador(seleccion) ) {
										JOptionPane.showMessageDialog(null, "Se pudo eliminar");

									}else {
										JOptionPane.showMessageDialog(null, "No se pudo eliminar");

									}

									break;

								default:
									break;
								}
							} while (opcionJugador!=1);
							break;
						}
					default:
						break;
					}

				} while (opcionJugadores!=4);

				break;
			case 2: 

				//Ver la lista de equipos
				if (nuevo.getEquipos().size()==0) {

					JOptionPane.showMessageDialog(null, "No hay equipos");
				} else {
					JOptionPane.showMessageDialog(null, "Cantidad de equipos: " + nuevo.getEquipos().get(0)  + "  "+ nuevo.getEquipos().toString());
				}
				break;
			case 3: 

				//Agregar equipo
				String nombre = JOptionPane.showInputDialog("Ingrese nombre del equipo");
				String ciudad =	JOptionPane.showInputDialog("Ingrese su ciudad");
				if (nuevo.agregarEquipo(nombre, ciudad)) {
					JOptionPane.showMessageDialog(null, "Se pudo agregar!");
				} else {
					JOptionPane.showMessageDialog(null, "No se pudo agregar!");
				}

				break;
			case 4: 

				//Buscar equipo
				String[] equipos= new String[nuevo.getEquipos().size()]; 
				for (int i = 0; i < nuevo.getEquipos().size(); i++) {
					equipos[i] =  nuevo.getEquipos().get(i).getNombre();
				}				
				String seleccion = (String)JOptionPane.showInputDialog(null, "Equipos",
						null, 0, null, equipos, equipos[0]);
				String[] opcionDeEquipos = { 
						"Eliminar equipo","Volver "

				};
				int opcionEquipo=0;
				do {
					opcionEquipo = JOptionPane.showOptionDialog(null,  "Que deseas hacer con el equipo", null, opcionEquipo, opcionEquipo, null, opcionDeEquipos, opcionDeEquipos[0]);
					switch (opcionEquipo) {
					case 0:
						//Eliminar equipo
						if(nuevo.eliminarEquipo(seleccion) ) {
							JOptionPane.showMessageDialog(null, "Se pudo eliminar");

						}else {
							JOptionPane.showMessageDialog(null, "No se pudo eliminar");

						}

						break;

					default:
						break;
					}
				} while (opcionEquipo!=1);



				break;

			case 5: 
				JOptionPane.showMessageDialog(null, "Salir menu principal");

				break;
			default:

				break;
			}

		} while (opcion!=5);




	}

	public static int seleccionarEquipo(LinkedList<Equipo> equipos) {
		String[] equiposarray = new String[equipos.size()];
		for (int i = 0; i < equipos.size(); i++) {
			equiposarray[i] = equipos.get(i).getNombre();
		}
		int opcion = JOptionPane.showOptionDialog(null, 
				"Seleccione equipo", null, 0, 0, null, equiposarray, equiposarray[0]);

		return opcion;


	}



}


