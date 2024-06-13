import java.awt.Component;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		GestorEquipos nuevo = new GestorEquipos();
		nuevo.getEquipos().add(new Equipo("Boca","La boca"));
		nuevo.getEquipos().add(new Equipo("River","Nuñez"));
		nuevo.getEquipos().add(new Equipo("Velez","Liniers"));
		nuevo.getEquipos().add(new Equipo("Chacarita","Chacarita"));
		nuevo.getEquipos().add(new Equipo("Chicago","Nataderos"));
		nuevo.getEquipos().add(new Equipo("San Lorenzo","Boedo"));
		nuevo.getEquipos().add(new Equipo("Platense","La plata"));
		nuevo.RellenarTodosLosEquipos();
		String[] Opciones = {

				"Partido","Revisar Equipo","Ver la lista de equipos",
				"Agregar equipo","Buscar equipo","Salir"

		};
		int opcion =0;
		do {
			opcion = JOptionPane.showOptionDialog(null, "Bienvenido", null, 0, 0, null, Opciones, Opciones[0]);

			switch (opcion) {
			case 0:

				String[] OpcionesPartidos = {

						"Jugar partido","Elegir Equipo","Generar equipos",
						"Ver informacion","","Salir"
				};
				int opcionpartido =0;
				do {
					opcionpartido = JOptionPane.showOptionDialog(null, "Menu partido", null, 0, 0, null, OpcionesPartidos, OpcionesPartidos[0]);
					switch (opcionpartido) {
					case 0:

						//Jugar partido

						if (nuevo. .getEquipos(seleccionarEquipo(nuevo.getEquipos()).size()==0 ) { //seleccionado.getJugadores().size()==0
							JOptionPane.showMessageDialog(null, "No se seleccionaron los equipos");
						} else {
							JOptionPane.showMessageDialog(null, "Se seleccionaron los equipos");
						}
					/*	JOptionPane.showMessageDialog(null, "El ganador es:"+
								nuevo.JugarPartido(null, null) ); */
								
						break;
					case 1:
						//Elegir equipo 
						Equipo seleccionar = seleccionarEquipo(nuevo.getEquipos());
						
						/*JOptionPane.showMessageDialog(null, "El ganador es:"+
								nuevo.JugarPartido(seleccionarEquipo(nuevo.getEquipos())
										,seleccionarEquipo(nuevo.getEquipos())));*/
								
						break;		

					default:
						break;
					}
					
				} while (opcionpartido!=5);
				

				break;
			case 1: 

				//Revisar equipo
				Equipo seleccionado = seleccionarEquipo(nuevo.getEquipos());
				String[] opcionesDeJugadores = {
						"Agregar jugador","Rellenar jugadores",
						"Ver la lista de jugadores","Buscar jugador","Volver al menu principal",

				};
				int opcionJugadores=0;
				do {
					opcionJugadores = JOptionPane.showOptionDialog(null, "Menu de jugadores: ", null, 0, 0, null, opcionesDeJugadores, opcionesDeJugadores[0]);
					switch (opcionJugadores) {
					case 0:		
						//Agregar jugador 
						String nombre = JOptionPane.showInputDialog("Ingrese nombre");
						int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese edad"));
						int camiseta = Integer.parseInt(JOptionPane.showInputDialog("Ingrese numero camiseta"));
						String[] posiciones = {"Arquero","Delantero","Mediocampista","Defensor"};
						String posicion = (String) JOptionPane.showInputDialog(null, "Posición", null, 0, null, posiciones, posiciones[0]);
						seleccionado.agregarJugador( nombre, edad, camiseta, posicion); 
						break;
					case 1: 			
						//Rellenar jugadores
						int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad"));
						seleccionado.agregarJugadoresFalso(cantidad);
						break;
					case 2:
						//Ver la lista de jugadores
						if (seleccionado.getJugadores().size()==0) {
							JOptionPane.showMessageDialog(null, "No hay jugadores");
						} else {
							JOptionPane.showMessageDialog(null,"Cantidad de jugadores: " + seleccionado.getJugadores().size() + "   " + seleccionado.getJugadores());
						}
						break;
					case 3:
						//Buscar jugador
						if (seleccionado.getJugadores().size()==0) {
							JOptionPane.showMessageDialog(null, "No hay jugadores");
						} else {	
							String[] jugadores= new String[seleccionado.getJugadores().size()]; 
							for (int i = 0; i < seleccionado.getJugadores().size(); i++) {
								jugadores[i] =  Integer.toString(seleccionado.getJugadores().get(i).getnCamiseta());
							}
							String seleccion = (String)JOptionPane.showInputDialog(null, "Jugadores",
									null, 0, null, jugadores, jugadores[0]);
							String[] opcionDeJugador = {
									"Eliminar jugador","Volver"
							};	
							int opcionJugador=0;
							do {
								opcionJugador = JOptionPane.showOptionDialog(null,  "Que deseas hacer con el jugador: "  , null, 0, 0, null, opcionDeJugador, opcionDeJugador[0]);
								switch (opcionJugador) {
								case 0:
									//Eliminar jugador
									if(seleccionado.eliminarJugador(Integer.parseInt(seleccion))) {
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
				nuevo.agregarEquipo(nombre, ciudad);
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

	public static Equipo seleccionarEquipo(LinkedList<Equipo> equipos) {
		String[] equiposarray = new String[equipos.size()];
		for (int i = 0; i < equipos.size(); i++) {
			equiposarray[i] = equipos.get(i).getNombre();
		}
		int opcion = JOptionPane.showOptionDialog(null, 
				"Seleccione equipo", null, 0, 0, null, equiposarray, equiposarray[0]);
		Equipo selecionado = equipos.get(opcion);
		equipos.remove(opcion);
		return selecionado;


	}



}


