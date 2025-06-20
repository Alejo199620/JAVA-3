import java.util.Scanner;

public class Main {
    private static Sistema sistema = new Sistema();
    private static Scanner scanner = new Scanner(System.in);



    // Método para cargar datos de ejemplo
    private static void cargarDatosEjemplo() {
        // 1. Registrar profesores
        Profesor profesor1 = new Profesor("P001", "Ana Martínez", "ana@email.com", "Matemáticas");
        Profesor profesor2 = new Profesor("P002", "Pedro Sánchez", "pedro@email.com", "Ciencias");
        Profesor profesor3 = new Profesor("P003", "Laura Díaz", "laura@email.com", "Historia");
        sistema.registrarPersona(profesor1);
        sistema.registrarPersona(profesor2);
        sistema.registrarPersona(profesor3);

        // 2. Registrar alumnos
        Alumno alumno1 = new Alumno("A001", "María González", "maria@email.com", "10°");
        Alumno alumno2 = new Alumno("A002", "Carlos Ruiz", "carlos@email.com", "11°");
        Alumno alumno3 = new Alumno("A003", "Luisa Fernández", "luisa@email.com", "9°");
        sistema.registrarPersona(alumno1);
        sistema.registrarPersona(alumno2);
        sistema.registrarPersona(alumno3);

        // 3. Registrar director
        Director director = new Director("D001", "Jorge López", "director@colegio.edu");
        sistema.registrarPersona(director);

        // 4. Registrar cursos
        Curso curso1 = new Curso("C101", "Matemáticas Avanzadas", "Lunes 8:00-10:00");
        Curso curso2 = new Curso("C102", "Física Básica", "Martes 10:00-12:00");
        Curso curso3 = new Curso("C103", "Historia Universal", "Miércoles 14:00-16:00");
        sistema.agregarCurso(curso1);
        sistema.agregarCurso(curso2);
        sistema.agregarCurso(curso3);

        // 5. Asignar profesores a cursos
        profesor1.asignarCurso(curso1);
        profesor2.asignarCurso(curso2);
        profesor3.asignarCurso(curso3);

        // 6. Inscribir alumnos a cursos
        alumno1.inscribirCurso(curso1); // María en Matemáticas
        alumno1.inscribirCurso(curso2); // María en Física
        alumno2.inscribirCurso(curso2); // Carlos en Física
        alumno2.inscribirCurso(curso3); // Carlos en Historia
        alumno3.inscribirCurso(curso1); // Luisa en Matemáticas
        alumno3.inscribirCurso(curso2); // Luisa en Física
        alumno3.inscribirCurso(curso3); // Luisa en Historia

        // 7. Registrar piezas físicas (aulas)
        PiezaFisica aula201 = new PiezaFisica("Aula 201", "Aula", "8m x 6m", "Edificio Principal - 2do piso");
        aula201.agregarMobiliario(new ElementoMobiliario("Silla", 30));
        aula201.agregarMobiliario(new ElementoMobiliario("Mesa profesor", 1));
        aula201.agregarMobiliario(new ElementoMobiliario("Pizarra", 1));

        PiezaFisica laboratorio101 = new PiezaFisica("Laboratorio 101", "Laboratorio", "10m x 8m", "Edificio Ciencias");
        laboratorio101.agregarMobiliario(new ElementoMobiliario("Mesa laboratorio", 20));
        laboratorio101.agregarMobiliario(new ElementoMobiliario("Campana extracción", 1));

        PiezaFisica oficinaDireccion = new PiezaFisica("Oficina Dirección", "Oficina", "5m x 4m", "Edificio Administrativo");
        oficinaDireccion.agregarMobiliario(new ElementoMobiliario("Escritorio", 1));
        oficinaDireccion.agregarMobiliario(new ElementoMobiliario("Silla", 2));
        oficinaDireccion.agregarMobiliario(new ElementoMobiliario("Archivador", 1));

        sistema.registrarPieza(aula201);
        sistema.registrarPieza(laboratorio101);
        sistema.registrarPieza(oficinaDireccion);

        System.out.println(" Datos de ejemplo cargados correctamente.");
    }
    // Método principal
    public static void main(String[] args) {
         cargarDatosEjemplo();
        boolean salir = false;
        
        while (!salir) {
            System.out.println("\n=== SISTEMA COLEGIO SAN FRANCISCO DE ASÍS ===");
            System.out.println("1. Administrador");
            System.out.println("2. Profesor");
            System.out.println("3. Alumno");
            System.out.println("4. Director");
            System.out.println("5. Salir");
            System.out.print("Seleccione su rol: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            
            switch (opcion) {
                case 1:
                    menuAdministrador();
                    break;
                case 2:
                    menuProfesor();
                    break;
                case 3:
                    menuAlumno();
                    break;
                case 4:
                    menuDirector();
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
        
        System.out.println("Sistema cerrado. ¡Hasta pronto!");
    }

    private static void menuAdministrador() {
        boolean volver = false;
        
        while (!volver) {
            System.out.println("\n=== MENÚ ADMINISTRADOR ===");
            System.out.println("1. Registrar pieza física");
            System.out.println("2. Registrar persona");
            System.out.println("3. Asignar alumno a curso");
            System.out.println("4. Asignar profesor a curso");
            System.out.println("5. Consultar dimensiones de pieza");
            System.out.println("6. Editar información existente");
            System.out.println("7. Eliminar registros");
            System.out.println("8. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (opcion) {
                case 1:
                    registrarPiezaFisica();
                    break;
                case 2:
                    registrarPersona();
                    break;
                case 3:
                    asignarAlumnoACurso();
                    break;
                case 4:
                    asignarProfesorACurso();
                    break;
                case 5:
                    consultarDimensionesPieza();
                    break;
                case 6:
                    editarInformacion();
                    break;
                case 7:
                    eliminarRegistro();
                    break;
                case 8:
                    volver = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static void registrarPiezaFisica() {
        System.out.println("\n=== REGISTRAR PIEZA FÍSICA ===");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Tipo (aula, laboratorio, oficina, etc.): ");
        String tipo = scanner.nextLine();
        
        System.out.print("Dimensiones: ");
        String dimensiones = scanner.nextLine();
        
        System.out.print("Ubicación: ");
        String ubicacion = scanner.nextLine();
        
        PiezaFisica pieza = new PiezaFisica(nombre, tipo, dimensiones, ubicacion);
        sistema.registrarPieza(pieza);
        
        // Opcional: agregar mobiliario
        System.out.println("\n¿Desea agregar mobiliario? (s/n)");
        String respuesta = scanner.nextLine();
        
        while (respuesta.equalsIgnoreCase("s")) {
            System.out.print("Tipo de mobiliario (silla, mesa, etc.): ");
            String tipoMobiliario = scanner.nextLine();
            
            System.out.print("Cantidad: ");
            int cantidad = scanner.nextInt();
            scanner.nextLine();
            
            ElementoMobiliario mobiliario = new ElementoMobiliario(tipoMobiliario, cantidad);
            pieza.agregarMobiliario(mobiliario);
            
            System.out.println("¿Agregar más mobiliario? (s/n)");
            respuesta = scanner.nextLine();
        }
        
        System.out.println("Pieza física registrada con éxito!");
    }

    private static void registrarPersona() {
        System.out.println("\n=== REGISTRAR PERSONA ===");
        System.out.println("1. Alumno");
        System.out.println("2. Profesor");
        System.out.println("3. Otro");
        System.out.print("Seleccione tipo de persona: ");
        
        int tipo = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("ID: ");
        String id = scanner.nextLine();
        
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Contacto: ");
        String contacto = scanner.nextLine();
        
        switch (tipo) {
            case 1:
                System.out.print("Grado: ");
                String grado = scanner.nextLine();
                Alumno alumno = new Alumno(id, nombre, contacto, grado);
                sistema.registrarPersona(alumno);
                System.out.println("Alumno registrado con éxito!");
                break;
            case 2:
                System.out.print("Especialidad: ");
                String especialidad = scanner.nextLine();
                Profesor profesor = new Profesor(id, nombre, contacto, especialidad);
                sistema.registrarPersona(profesor);
                System.out.println("Profesor registrado con éxito!");
                break;
            case 3:
                System.out.print("Rol: ");
                String rol = scanner.nextLine();
                Persona persona = new Persona(id, nombre, contacto, rol);
                sistema.registrarPersona(persona);
                System.out.println("Persona registrada con éxito!");
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    private static void asignarAlumnoACurso() {
        System.out.println("\n=== ASIGNAR ALUMNO A CURSO ===");
        
        // Mostrar lista de alumnos
        System.out.println("Alumnos disponibles:");
        for (Alumno alumno : sistema.getAlumnos()) {
            System.out.println(alumno.getId() + " - " + alumno.getNombre());
        }
        
        System.out.print("Ingrese ID del alumno: ");
        String idAlumno = scanner.nextLine();
        
        // Mostrar lista de cursos
        System.out.println("\nCursos disponibles:");
        for (Curso curso : sistema.getCursos()) {
            System.out.println(curso.getCodigo() + " - " + curso.getNombre());
        }
        
        System.out.print("Ingrese código del curso: ");
        String codigoCurso = scanner.nextLine();
        
        sistema.asignarCursoAlumno(idAlumno, codigoCurso);
        System.out.println("Asignación realizada con éxito!");
    }

    private static void asignarProfesorACurso() {
        System.out.println("\n=== ASIGNAR PROFESOR A CURSO ===");
        
        // Mostrar lista de profesores
        System.out.println("Profesores disponibles:");
        for (Profesor profesor : sistema.getProfesores()) {
            System.out.println(profesor.getId() + " - " + profesor.getNombre());
        }
        
        System.out.print("Ingrese ID del profesor: ");
        String idProfesor = scanner.nextLine();
        
        // Mostrar lista de cursos
        System.out.println("\nCursos disponibles:");
        for (Curso curso : sistema.getCursos()) {
            System.out.println(curso.getCodigo() + " - " + curso.getNombre());
        }
        
        System.out.print("Ingrese código del curso: ");
        String codigoCurso = scanner.nextLine();
        
        sistema.asignarCursoProfesor(idProfesor, codigoCurso);
        System.out.println("Asignación realizada con éxito!");
    }

    private static void consultarDimensionesPieza() {
        System.out.println("\n=== CONSULTAR DIMENSIONES DE PIEZA ===");
        
        // Mostrar lista de piezas
        System.out.println("Piezas disponibles:");
        for (PiezaFisica pieza : sistema.getPiezasFisicas()) {
            System.out.println(pieza.getNombre() + " - " + pieza.getTipo());
        }
        
        System.out.print("Ingrese nombre de la pieza: ");
        String nombrePieza = scanner.nextLine();
        
        sistema.consultarDimensiones(nombrePieza);
    }

    private static void editarInformacion() {
        System.out.println("\n=== EDITAR INFORMACIÓN ===");
        System.out.println("1. Editar persona");
        System.out.println("2. Editar pieza física");
        System.out.print("Seleccione qué desea editar: ");
        
        int opcion = scanner.nextInt();
        scanner.nextLine();
        
        switch (opcion) {
            case 1:
                // Mostrar lista de personas
                System.out.println("\nPersonas registradas:");
                for (Persona persona : sistema.getPersonas()) {
                    System.out.println(persona.getId() + " - " + persona.getNombre() + " (" + persona.getRol() + ")");
                }
                
                System.out.print("Ingrese ID de la persona a editar: ");
                String idPersona = scanner.nextLine();
                
                System.out.print("Nuevo nombre: ");
                String nuevoNombre = scanner.nextLine();
                
                System.out.print("Nuevo contacto: ");
                String nuevoContacto = scanner.nextLine();
                
                sistema.editarPersona(idPersona, nuevoNombre, nuevoContacto);
                System.out.println("Información actualizada con éxito!");
                break;
                
            case 2:
                // Mostrar lista de piezas
                System.out.println("\nPiezas registradas:");
                for (PiezaFisica pieza : sistema.getPiezasFisicas()) {
                    System.out.println(pieza.getNombre() + " - " + pieza.getTipo());
                }
                
                System.out.print("Ingrese nombre de la pieza a editar: ");
                String nombrePieza = scanner.nextLine();
                
                System.out.print("Nuevas dimensiones: ");
                String nuevasDimensiones = scanner.nextLine();
                
                System.out.print("Nueva ubicación: ");
                String nuevaUbicacion = scanner.nextLine();
                
                sistema.editarPieza(nombrePieza, nuevasDimensiones, nuevaUbicacion);
                System.out.println("Información actualizada con éxito!");
                break;
                
            default:
                System.out.println("Opción no válida.");
        }
    }

    private static void eliminarRegistro() {
        System.out.println("\n=== ELIMINAR REGISTRO ===");
        System.out.println("1. Eliminar persona");
        System.out.println("2. Eliminar pieza física");
        System.out.print("Seleccione qué desea eliminar: ");
        
        int opcion = scanner.nextInt();
        scanner.nextLine();
        
        switch (opcion) {
            case 1:
                // Mostrar lista de personas
                System.out.println("\nPersonas registradas:");
                for (Persona persona : sistema.getPersonas()) {
                    System.out.println(persona.getId() + " - " + persona.getNombre() + " (" + persona.getRol() + ")");
                }
                
                System.out.print("Ingrese ID de la persona a eliminar: ");
                String idPersona = scanner.nextLine();
                
                sistema.eliminarPersona(idPersona);
                System.out.println("Persona eliminada con éxito!");
                break;
                
            case 2:
                // Mostrar lista de piezas
                System.out.println("\nPiezas registradas:");
                for (PiezaFisica pieza : sistema.getPiezasFisicas()) {
                    System.out.println(pieza.getNombre() + " - " + pieza.getTipo());
                }
                
                System.out.print("Ingrese nombre de la pieza a eliminar: ");
                String nombrePieza = scanner.nextLine();
                
                sistema.eliminarPieza(nombrePieza);
                System.out.println("Pieza eliminada con éxito!");
                break;
                
            default:
                System.out.println("Opción no válida.");
        }
    }

    private static void menuProfesor() {
        System.out.println("\n=== MENÚ PROFESOR ===");
        System.out.print("Ingrese su ID: ");
        String idProfesor = scanner.nextLine();
        
        Profesor profesor = (Profesor) sistema.getPersonas().stream()
            .filter(p -> p.getId().equals(idProfesor) && p instanceof Profesor)
            .findFirst()
            .orElse(null);
        
        if (profesor == null) {
            System.out.println("Profesor no encontrado.");
            return;
        }
        
        boolean volver = false;
        
        while (!volver) {
            System.out.println("\nBienvenido, " + profesor.getNombre());
            System.out.println("1. Consultar cursos asignados");
            System.out.println("2. Ver lista de estudiantes por curso");
            System.out.println("3. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcion) {
                case 1:
                    profesor.consultarCursos();
                    break;
                case 2:
                    System.out.println("\nSus cursos:");
                    for (Curso curso : profesor.getCursosAsignados()) {
                        System.out.println(curso.getCodigo() + " - " + curso.getNombre());
                    }
                    
                    System.out.print("\nIngrese código del curso para ver estudiantes: ");
                    String codigoCurso = scanner.nextLine();
                    
                    Curso cursoSeleccionado = profesor.getCursosAsignados().stream()
                        .filter(c -> c.getCodigo().equals(codigoCurso))
                        .findFirst()
                        .orElse(null);
                    
                    if (cursoSeleccionado != null) {
                        profesor.verAlumnos(cursoSeleccionado);
                    } else {
                        System.out.println("Curso no encontrado.");
                    }
                    break;
                case 3:
                    volver = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static void menuAlumno() {
        System.out.println("\n=== MENÚ ALUMNO ===");
        System.out.print("Ingrese su ID: ");
        String idAlumno = scanner.nextLine();
        
        Alumno alumno = (Alumno) sistema.getPersonas().stream()
            .filter(p -> p.getId().equals(idAlumno) && p instanceof Alumno)
            .findFirst()
            .orElse(null);
        
        if (alumno == null) {
            System.out.println("Alumno no encontrado.");
            return;
        }
        
        boolean volver = false;
        
        while (!volver) {
            System.out.println("\nBienvenido, " + alumno.getNombre());
            System.out.println("1. Consultar cursos inscritos");
            System.out.println("2. Ver profesores asignados");
            System.out.println("3. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcion) {
                case 1:
                    alumno.consultarCursos();
                    break;
                case 2:
                    alumno.verProfesores();
                    break;
                case 3:
                    volver = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static void menuDirector() {
        boolean volver = false;
        
        while (!volver) {
            System.out.println("\n=== MENÚ DIRECTOR ===");
            System.out.println("1. Ver todos los alumnos");
            System.out.println("2. Ver todos los profesores");
            System.out.println("3. Ver todos los cursos");
            System.out.println("4. Ver todas las piezas físicas");
            System.out.println("5. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcion) {
                case 1:
                    System.out.println("\n=== LISTA DE ALUMNOS ===");
                    for (Alumno alumno : sistema.getAlumnos()) {
                        System.out.println(alumno.getId() + " - " + alumno.getNombre() + " - Grado: " + alumno.getGrado());
                    }
                    break;
                case 2:
                    System.out.println("\n=== LISTA DE PROFESORES ===");
                    for (Profesor profesor : sistema.getProfesores()) {
                        System.out.println(profesor.getId() + " - " + profesor.getNombre() + " - Especialidad: " + profesor.getEspecialidad());
                    }
                    break;
                case 3:
                    System.out.println("\n=== LISTA DE CURSOS ===");
                    for (Curso curso : sistema.getCursos()) {
                        System.out.println(curso.getCodigo() + " - " + curso.getNombre() + " - Horario: " + curso.getHorario());
                        if (curso.getProfesor() != null) {
                            System.out.println("   Profesor: " + curso.getProfesor().getNombre());
                        }
                        System.out.println("   Alumnos inscritos: " + curso.getAlumnos().size());
                    }
                    break;
                case 4:
                    System.out.println("\n=== LISTA DE PIEZAS FÍSICAS ===");
                    for (PiezaFisica pieza : sistema.getPiezasFisicas()) {
                        System.out.println(pieza.getNombre() + " - " + pieza.getTipo() + " - Ubicación: " + pieza.getUbicacion());
                        System.out.println("   Dimensiones: " + pieza.getDimensiones());
                        System.out.println("   Mobiliario: " + pieza.getMobiliario().size() + " elementos");
                    }
                    break;
                case 5:
                    volver = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}


