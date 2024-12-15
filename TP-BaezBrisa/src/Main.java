import java.util.Iterator;
import javax.swing.ImageIcon;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        GestorEquipos nuevo = new GestorEquipos();
        nuevo.getEquipos().add(new Equipo("Boca", "La boca", "img/boca.png"));
        nuevo.getEquipos().add(new Equipo("River", "Nuñez", "img/river.jpg"));
        nuevo.getEquipos().add(new Equipo("Velez", "Liniers", "img/velez.png"));
        nuevo.getEquipos().add(new Equipo("Chacarita", "Chacarita", "img/chacarita.png"));
        nuevo.getEquipos().add(new Equipo("Chicago", "Nataderos", "img/chicago.png"));
        nuevo.getEquipos().add(new Equipo("San Lorenzo", "Boedo", "img/sanlorenzo.png"));
        nuevo.getEquipos().add(new Equipo("Platense", "La plata", "img/platense.png"));
        nuevo.getEquipos().add(new Equipo("Independiente", "Avellaneda", "img/independiente.png"));
        nuevo.RellenarTodosLosEquipos();

        LinkedList<Equipo> equiposGanadores = new LinkedList<Equipo>();
        LinkedList<Equipo> equiposFinalistas = new LinkedList<Equipo>();
        LinkedList<Equipo> equipoGanador = new LinkedList<Equipo>();
        List<Apuesta> historialApuestas = new LinkedList<>();

        String[] Opciones = {
            "Crear partido", "Revisar Equipo", "Ver la lista de equipos",
            "Agregar equipo", "Buscar equipo", "Salir"
        };
        int opcion = 0;
        do {
            opcion = JOptionPane.showOptionDialog(null, "Bienvenido", null, 0, 0, null, Opciones, Opciones[0]);

            switch (opcion) {
                case 0:
                    String[] OpcionesPartidos = {
                        "Jugar partido(con apuesta)", "Ver partido", "Historial apuesta","Salir"
                    };
                    int opcionpartido = 0;
                    do {
                        opcionpartido = JOptionPane.showOptionDialog(null, "Menu partido", "", 0, JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("img/1.jpg")), OpcionesPartidos, OpcionesPartidos[0]);
                        switch (opcionpartido) {
                            case 0:
                            	// Fase de grupos (partidos 1 a 4)
                            	if (Partido.getCantPartidos() < 4) {
                            	    JOptionPane.showMessageDialog(null, "Estamos en la fase de grupos. Partidos restantes: " + (4 - Partido.getCantPartidos()));
                            	    Equipo equipo1 = seleccionarEquipo(nuevo.getEquipos());
                            	    Equipo equipo2 = seleccionarEquipo(nuevo.getEquipos());

                            	    String[] opcionesApuesta = {equipo1.getNombre(), equipo2.getNombre()};
                            	    String apuesta = (String) JOptionPane.showInputDialog(null, "¿Por cuál equipo deseas apostar?", "Apuesta", JOptionPane.DEFAULT_OPTION, null, opcionesApuesta, opcionesApuesta[0]);

                            	    int montoApostado = 0;
                            	    boolean entradaValida = false;
                            	    while (!entradaValida) {
                            	        try {
                            	            montoApostado = Integer.parseInt(JOptionPane.showInputDialog("¿Cuánto quieres apostar?"));
                            	            if (montoApostado > 0) {
                            	                entradaValida = true;
                            	            } else {
                            	                JOptionPane.showMessageDialog(null, "Por favor ingresa un monto mayor que 0");
                            	            }
                            	        } catch (NumberFormatException e) {
                            	            JOptionPane.showMessageDialog(null, "Por favor ingresa un número válido");
                            	        }
                            	    }

                            	    // Jugar el partido
                            	    Partido jugado = nuevo.JugarPartido(equipo1, equipo2);
                            	    nuevo.getPartidos().add(jugado);

                            	    // Mostrar resultados
                            	    Equipo ganador = jugado.DeterminarGanador();
                            	    JOptionPane.showMessageDialog(null, "Se jugó el partido: " + jugado);
                            	    JOptionPane.showMessageDialog(null, "Clasificó a cuartos: " + ganador.getNombre(), "Ganador", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource(ganador.getFoto())));
                            	    equiposGanadores.add(ganador);

                            	    // Guardar y verificar apuesta
                            	    historialApuestas.add(new Apuesta(ganador.getNombre(), apuesta, montoApostado));
                            	    if (ganador.getNombre().equals(apuesta)) {
                            	        JOptionPane.showMessageDialog(null, "¡Felicidades! Ganaste la apuesta de $" + montoApostado * 2);
                            	    } else {
                            	        JOptionPane.showMessageDialog(null, "Perdiste la apuesta. ¡Suerte la próxima vez!");
                            	    }
                            	}

                            	// Fase de cuartos de final (partidos 5 a 6)
                            	if (Partido.getCantPartidos() >= 4 && Partido.getCantPartidos() <= 6 && equiposGanadores.size() >= 2) {
                            	    JOptionPane.showMessageDialog(null, "Estamos en la fase de cuartos de final. Partidos restantes: " + (6 - Partido.getCantPartidos()));

                            	    Equipo equipo1 = seleccionarEquipo(equiposGanadores);
                            	    Equipo equipo2 = seleccionarEquipo(equiposGanadores);

                            	    // Apuesta en cuartos
                            	    String apuesta = (String) JOptionPane.showInputDialog(null, "¿Por cuál equipo deseas apostar?", "Apuesta", JOptionPane.DEFAULT_OPTION, null, new String[]{equipo1.getNombre(), equipo2.getNombre()}, equipo1.getNombre());

                            	    int montoApostado = 0;
                            	    boolean entradaValida = false;
                            	    while (!entradaValida) {
                            	        try {
                            	            montoApostado = Integer.parseInt(JOptionPane.showInputDialog("¿Cuánto quieres apostar?"));
                            	            if (montoApostado > 0) {
                            	                entradaValida = true;
                            	            } else {
                            	                JOptionPane.showMessageDialog(null, "Por favor ingresa un monto mayor que 0");
                            	            }
                            	        } catch (NumberFormatException e) {
                            	            JOptionPane.showMessageDialog(null, "Por favor ingresa un número válido");
                            	        }
                            	    }

                            	    // Jugar el partido
                            	    Partido jugado = nuevo.JugarPartido(equipo1, equipo2);
                            	    nuevo.getPartidos().add(jugado);

                            	    // Mostrar resultados
                            	    Equipo ganador = jugado.DeterminarGanador();
                            	    JOptionPane.showMessageDialog(null, "Se jugó el partido " + jugado);
                            	    JOptionPane.showMessageDialog(null, "Clasificó a semifinales " + ganador.getNombre(), "Ganador", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource(ganador.getFoto())));
                            	    equiposFinalistas.add(ganador);

                            	    // Guardar y verificar apuesta
                            	    historialApuestas.add(new Apuesta(ganador.getNombre(), apuesta, montoApostado));
                            	    if (ganador.getNombre().equals(apuesta)) {
                            	        JOptionPane.showMessageDialog(null, "¡Felicidades! Ganaste la apuesta de $" + montoApostado * 2);
                            	    } else {
                            	        JOptionPane.showMessageDialog(null, "Perdiste la apuesta. ¡Suerte la próxima vez!");
                            	    }
                            	}

                            	// Fase de semifinales (partidos 7 a 8)
                            	if (Partido.getCantPartidos() >= 6 && Partido.getCantPartidos() <= 7 && equiposFinalistas.size() == 2) {
                            	    JOptionPane.showMessageDialog(null, "Estamos en la fase de semifinales. Partidos restantes: " + (7 - Partido.getCantPartidos()));

                            	    Equipo equipo1 = seleccionarEquipo(equiposFinalistas);
                            	    Equipo equipo2 = seleccionarEquipo(equiposFinalistas);

                            	    // Apuesta en semifinales
                            	    String apuesta = (String) JOptionPane.showInputDialog(null, "¿Por cuál equipo deseas apostar?", "Apuesta", JOptionPane.DEFAULT_OPTION, null, new String[]{equipo1.getNombre(), equipo2.getNombre()}, equipo1.getNombre());

                            	    int montoApostado = 0;
                            	    boolean entradaValida = false;
                            	    while (!entradaValida) {
                            	        try {
                            	            montoApostado = Integer.parseInt(JOptionPane.showInputDialog("¿Cuánto quieres apostar?"));
                            	            if (montoApostado > 0) {
                            	                entradaValida = true;
                            	            } else {
                            	                JOptionPane.showMessageDialog(null, "Por favor ingresa un monto mayor que 0");
                            	            }
                            	        } catch (NumberFormatException e) {
                            	            JOptionPane.showMessageDialog(null, "Por favor ingresa un número válido");
                            	        }
                            	    }

                            	    // Jugar el partido
                            	    Partido jugado = nuevo.JugarPartido(equipo1, equipo2);
                            	    nuevo.getPartidos().add(jugado);

                            	    // Mostrar resultados
                            	    Equipo ganador = jugado.DeterminarGanador();
                            	    JOptionPane.showMessageDialog(null, "Se jugó el partido " + jugado);
                            	    JOptionPane.showMessageDialog(null, "Clasificó a la final " + ganador.getNombre(), "Ganador", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource(ganador.getFoto())));
                            	    equiposFinalistas.add(ganador);

                            	    // Guardar y verificar apuesta
                            	    historialApuestas.add(new Apuesta(ganador.getNombre(), apuesta, montoApostado));
                            	    if (ganador.getNombre().equals(apuesta)) {
                            	        JOptionPane.showMessageDialog(null, "¡Felicidades! Ganaste la apuesta de $" + montoApostado * 2);
                            	    } else {
                            	        JOptionPane.showMessageDialog(null, "Perdiste la apuesta. ¡Suerte la próxima vez!");
                            	    }
                            	}

                            	// Fase final (partido 9)
                            	if (Partido.getCantPartidos() >= 7 && equiposFinalistas.size() == 2) {
                            	    JOptionPane.showMessageDialog(null, "Estamos en la final. ¡El último partido para determinar al campeón!");

                            	    Equipo equipo1 = seleccionarEquipo(equiposFinalistas);
                            	    Equipo equipo2 = seleccionarEquipo(equiposFinalistas);

                            	    // Apuesta en final
                            	    String apuesta = (String) JOptionPane.showInputDialog(null, "¿Por cuál equipo deseas apostar?", "Apuesta", JOptionPane.DEFAULT_OPTION, null, new String[]{equipo1.getNombre(), equipo2.getNombre()}, equipo1.getNombre());

                            	    int montoApostado = 0;
                            	    boolean entradaValida = false;
                            	    while (!entradaValida) {
                            	        try {
                            	            montoApostado = Integer.parseInt(JOptionPane.showInputDialog("¿Cuánto quieres apostar?"));
                            	            if (montoApostado > 0) {
                            	                entradaValida = true;
                            	            } else {
                            	                JOptionPane.showMessageDialog(null, "Por favor ingresa un monto mayor que 0");
                            	            }
                            	        } catch (NumberFormatException e) {
                            	            JOptionPane.showMessageDialog(null, "Por favor ingresa un número válido");
                            	        }
                            	    }

                            	    // Jugar el partido
                            	    Partido jugado = nuevo.JugarPartido(equipo1, equipo2);
                            	    nuevo.getPartidos().add(jugado);

                            	    // Mostrar resultados
                            	    Equipo ganador = jugado.DeterminarGanador();
                            	    JOptionPane.showMessageDialog(null, "Ganó el torneo " + ganador.getNombre(), "Ganador", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource(ganador.getFoto())));
                            	    equipoGanador.add(ganador);

                            	    // Guardar y verificar apuesta
                            	    historialApuestas.add(new Apuesta(ganador.getNombre(), apuesta, montoApostado));
                            	    if (ganador.getNombre().equals(apuesta)) {
                            	        JOptionPane.showMessageDialog(null, "¡Felicidades! Ganaste la apuesta de $" + montoApostado * 2);
                            	    } else {
                            	        JOptionPane.showMessageDialog(null, "Perdiste la apuesta. ¡Suerte la próxima vez!");
                            	    }
                            	}

                                break;
                            case 1:
                                // Ver partido
                                if (nuevo.getPartidos().isEmpty()) {
                                    JOptionPane.showMessageDialog(null, "Todavía no se ha iniciado el partido");
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
                                                JOptionPane.showMessageDialog(null, "Quedaron " + equiposGanadores);
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
                            case 2:
                                // Ver historial de apuestas
                                mostrarHistorialApuestas(historialApuestas);
                                break;
                            default:
                                break;
                        }
                    } while (opcionpartido != 3);
                    break;

                case 1:
                    // Revisar equipo
                    Equipo seleccionado = seleccionarEquipo(nuevo.getEquipos());
                    String[] opcionesDeJugadores = {
                        "Agregar jugador", "Rellenar jugadores",
                        "Ver la lista de jugadores", "Buscar jugador", "Volver al menu principal",
                    };
                    int opcionJugadores = 0;
                    do {
                        opcionJugadores = JOptionPane.showOptionDialog(null, "Menu de jugadores: ", null, 0, 0, null, opcionesDeJugadores, opcionesDeJugadores[0]);
                        switch (opcionJugadores) {
                            case 0:
                                // Agregar jugador
                                String nombre = JOptionPane.showInputDialog("Ingrese nombre");
                                int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese edad"));
                                int camiseta = Integer.parseInt(JOptionPane.showInputDialog("Ingrese numero camiseta"));
                                String[] posiciones = {"Arquero", "Delantero", "Mediocampista", "Defensor"};
                                String posicion = (String) JOptionPane.showInputDialog(null, "Posición", null, 0, null, posiciones, posiciones[0]);
                                seleccionado.agregarJugador(nombre, edad, camiseta, posicion);
                                break;
                            case 1:
                                // Rellenar jugadores
                                int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad"));
                                seleccionado.agregarJugadoresFalso(cantidad);
                                break;
                            case 2:
                                // Ver la lista de jugadores
                                if (seleccionado.getJugadores().size() == 0) {
                                    JOptionPane.showMessageDialog(null, "No hay jugadores");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Cantidad de jugadores: " + seleccionado.getJugadores().size() + "   " + seleccionado.getJugadores());
                                }
                                break;
                            case 3:
                                // Buscar jugador
                                if (seleccionado.getJugadores().size() == 0) {
                                    JOptionPane.showMessageDialog(null, "No hay jugadores");
                                } else {
                                    String[] jugadores = new String[seleccionado.getJugadores().size()];
                                    for (int i = 0; i < seleccionado.getJugadores().size(); i++) {
                                        jugadores[i] = Integer.toString(seleccionado.getJugadores().get(i).getnCamiseta());
                                    }
                                    String seleccion = (String) JOptionPane.showInputDialog(null, "Jugadores",
                                            null, 0, null, jugadores, jugadores[0]);
                                    for (int i = 0; i < seleccionado.getJugadores().size(); i++) {
                                        if (seleccionado.getJugadores().get(i).getnCamiseta() == Integer.parseInt(seleccion)) {
                                            JOptionPane.showMessageDialog(null, seleccionado.getJugadores().get(i));
                                            break;
                                        }
                                    }
                                }
                                break;
                            default:
                                break;
                        }
                    } while (opcionJugadores != 4);
                    break;

                case 4:
                    // Buscar equipo
                    String nombreEquipo = JOptionPane.showInputDialog("Ingrese el nombre del equipo que desea buscar");
                    Iterator<Equipo> it = nuevo.getEquipos().iterator();
                    boolean encontrado = false;
                    while (it.hasNext()) {
                        Equipo equipo = it.next();
                        if (equipo.getNombre().equalsIgnoreCase(nombreEquipo)) {
                            JOptionPane.showMessageDialog(null, "Equipo encontrado: " + equipo);
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        JOptionPane.showMessageDialog(null, "No se encontró el equipo");
                    }
                    break;
                case 5:
                    // Salir
                    JOptionPane.showMessageDialog(null, "Gracias por usar el sistema.");
                    break;
                default:
                    break;
            }
        } while (opcion != 5);
    }

    // Método para seleccionar un equipo
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

    // Mostrar historial de apuestas
    public static void mostrarHistorialApuestas(List<Apuesta> historial) {
        StringBuilder sb = new StringBuilder();
        int totalGanado = 0;
        int totalPerdido = 0;

        for (Apuesta apuesta : historial) {
            sb.append(apuesta).append("\n");

            // Verificar si el usuario ganó o perdió la apuesta
            if (apuesta.getResultado().equals("Ganó")) {
                totalGanado += apuesta.getMontoApostado() * 2; // Se duplica el monto apostado en caso de ganar
            } else if (apuesta.getResultado().equals("Perdió")) {
                totalPerdido += apuesta.getMontoApostado(); // Se pierde el monto apostado
            }
        }

        // Mostrar resumen de ganancias y pérdidas
        sb.append("\nResumen de apuestas:\n");
        sb.append("Total ganado: $").append(totalGanado).append("\n");
        sb.append("Total perdido: $").append(totalPerdido).append("\n");
        sb.append("Balance total: $").append(totalGanado - totalPerdido).append("\n");

        JOptionPane.showMessageDialog(null, sb.toString());
    }
}
