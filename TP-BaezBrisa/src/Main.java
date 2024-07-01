
import java.util.Iterator;
import javax.swing.ImageIcon;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		GestorEquipos nuevo = new GestorEquipos();
		nuevo.getEquipos().add(new Equipo("Boca","La boca", "img/boca.png"));
		nuevo.getEquipos().add(new Equipo("River","Nuñez", "img/river.jpg"));
		nuevo.getEquipos().add(new Equipo("Velez","Liniers", "img/velez.png"));
		nuevo.getEquipos().add(new Equipo("Chacarita","Chacarita", "img/chacarita.png"));
		nuevo.getEquipos().add(new Equipo("Chicago","Nataderos", "img/chicago.png"));
		nuevo.getEquipos().add(new Equipo("San Lorenzo","Boedo", "img/sanlorenzo.png"));
		nuevo.getEquipos().add(new Equipo("Platense","La plata", "img/platense.png"));
		nuevo.getEquipos().add(new Equipo("Independiente","Avellaneda", "img/independiente.png"));
		nuevo.RellenarTodosLosEquipos();
		LinkedList<Equipo> equiposGanadores = new  LinkedList<Equipo> ();
		LinkedList<Equipo> equiposFinalistas = new  LinkedList<Equipo> ();
		LinkedList<Equipo> equipoGanador = new  LinkedList<Equipo> ();
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

						"Jugar partido","Ver partido","Crear partido",
						"Ver informacion","","Salir"
				};
				int opcionpartido =0;
				do {
					opcionpartido = JOptionPane.showOptionDialog(null, 0, "Menu partido", 0, JOptionPane.DEFAULT_OPTION,  new ImageIcon(Main.class.getResource("img/1.jpg")), OpcionesPartidos, OpcionesPartidos[0]);
					switch (opcionpartido) {
					case 0:

						//Jugar partido
				
						if (Partido.getCantPartidos() < 4) {
							Partido jugado = nuevo.JugarPartido(seleccionarEquipo(nuevo.getEquipos()), seleccionarEquipo(nuevo.getEquipos()));
							nuevo.getPartidos().add(jugado);
							JOptionPane.showMessageDialog(null, "Se jugó el partido " + jugado);
							JOptionPane.showMessageDialog(null, "Clasifico a cuartos " + jugado.DeterminarGanador().getNombre(), "Ganador", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource(jugado.DeterminarGanador().getFoto())));
							equiposGanadores.add(jugado.DeterminarGanador());
						}

						if (Partido.getCantPartidos()>=4 &&  Partido.getCantPartidos()<=6 && equiposGanadores.size() >= 2) {
							Partido jugado = nuevo.JugarPartido(seleccionarEquipo(equiposGanadores), seleccionarEquipo(equiposGanadores));
							nuevo.getPartidos().add(jugado);
							JOptionPane.showMessageDialog(null, "Se jugó el partido " + jugado);
							JOptionPane.showMessageDialog(null, "Clasico a las semifinales " + jugado.DeterminarGanador().getNombre(), "Ganador", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource(jugado.DeterminarGanador().getFoto())));
							equiposFinalistas.add(jugado.DeterminarGanador());
						}

						if (Partido.getCantPartidos() >= 6 && Partido.getCantPartidos() <= 7 && equiposFinalistas.size() == 2) {
							Partido jugado = nuevo.JugarPartido(seleccionarEquipo(equiposFinalistas), seleccionarEquipo(equiposFinalistas));
							nuevo.getPartidos().add(jugado);
							JOptionPane.showMessageDialog(null, "Se jugó el partido " + jugado);
							JOptionPane.showMessageDialog(null, "Gano el torneo " + jugado.DeterminarGanador().getNombre(), "Ganador", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource(jugado.DeterminarGanador().getFoto())));
							equipoGanador.add(jugado.DeterminarGanador());
						}

						break;
					case 1:
						//Ver  lista 
						if (nuevo.getPartidos().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Todavia no se inicio el partido");
						} else {
							String[] opciones = {
									"Lista de ganadores",
									"Lista de semifinalistas",
									"Lista del ganador",
									"Lista en general"
							};

							String seleccion = (String) JOptionPane.showInputDialog(null,
									"Selecciona una opción:",
									"Lista de Partidos",
									0,
									null,
									opciones,
									opciones[0]);
						
						if (seleccion != null) {
		
							switch (seleccion) {
							case "Lista de cuartos":
								JOptionPane.showMessageDialog(null,"Quedaron " + equiposGanadores);
								break;
							case "Lista de semifinalistas":
								JOptionPane.showMessageDialog(null, "Quedaron: " + equiposFinalistas);
								break;
							case "Lista del ganador":
								JOptionPane.showMessageDialog(null, "Ganador: " + equipoGanador);
								break;
							case "Lista en general":
								JOptionPane.showMessageDialog(null, "General:" + nuevo.getPartidos());
								break;
							default:
	
								break;
							}
						}



					}


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


