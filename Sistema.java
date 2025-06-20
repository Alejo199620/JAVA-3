import java.util.ArrayList;
import java.util.List;

/**
 * Class Sistema
 */
public class Sistema {

    //
    // Fields
    //
    private List<Persona> personas;
    private List<PiezaFisica> piezasFisicas;
    private List<Curso> cursos;
    
    //
    // Constructors
    //
    public Sistema() {
        this.personas = new ArrayList<>();
        this.piezasFisicas = new ArrayList<>();
        this.cursos = new ArrayList<>();
    }

    //
    // Other methods
    //

    /**
     * Registra una nueva persona
     * @param persona la persona a registrar
     */
    public void registrarPersona(Persona persona) {
        personas.add(persona);
    }

    /**
     * Edita los datos de una persona
     * @param id el ID de la persona
     * @param nuevoNombre el nuevo nombre
     * @param nuevoContacto el nuevo contacto
     */
    public void editarPersona(String id, String nuevoNombre, String nuevoContacto) {
        for (Persona persona : personas) {
            if (persona.getId().equals(id)) {
                persona.setNombre(nuevoNombre);
                persona.setContacto(nuevoContacto);
                break;
            }
        }
    }

    /**
     * Elimina una persona
     * @param id el ID de la persona a eliminar
     */
    public void eliminarPersona(String id) {
        personas.removeIf(p -> p.getId().equals(id));
    }

    /**
     * Registra una nueva pieza física
     * @param pieza la pieza a registrar
     */
    public void registrarPieza(PiezaFisica pieza) {
        piezasFisicas.add(pieza);
    }

    /**
     * Edita los datos de una pieza física
     * @param nombre el nombre de la pieza
     * @param nuevasDimensiones las nuevas dimensiones
     * @param nuevaUbicacion la nueva ubicación
     */
    public void editarPieza(String nombre, String nuevasDimensiones, String nuevaUbicacion) {
        for (PiezaFisica pieza : piezasFisicas) {
            if (pieza.getNombre().equals(nombre)) {
                pieza.setDimensiones(nuevasDimensiones);
                pieza.setUbicacion(nuevaUbicacion);
                break;
            }
        }
    }

    /**
     * Elimina una pieza física
     * @param nombre el nombre de la pieza a eliminar
     */
    public void eliminarPieza(String nombre) {
        piezasFisicas.removeIf(p -> p.getNombre().equals(nombre));
    }

    /**
     * Asigna un curso a un alumno
     * @param idAlumno el ID del alumno
     * @param codigoCurso el código del curso
     */
    public void asignarCursoAlumno(String idAlumno, String codigoCurso) {
        Alumno alumno = (Alumno) personas.stream()
            .filter(p -> p.getId().equals(idAlumno) && p instanceof Alumno)
            .findFirst()
            .orElse(null);
        
        Curso curso = cursos.stream()
            .filter(c -> c.getCodigo().equals(codigoCurso))
            .findFirst()
            .orElse(null);
        
        if (alumno != null && curso != null) {
            alumno.inscribirCurso(curso);
        }
    }

    /**
     * Asigna un curso a un profesor
     * @param idProfesor el ID del profesor
     * @param codigoCurso el código del curso
     */
    public void asignarCursoProfesor(String idProfesor, String codigoCurso) {
        Profesor profesor = (Profesor) personas.stream()
            .filter(p -> p.getId().equals(idProfesor) && p instanceof Profesor)
            .findFirst()
            .orElse(null);
        
        Curso curso = cursos.stream()
            .filter(c -> c.getCodigo().equals(codigoCurso))
            .findFirst()
            .orElse(null);
        
        if (profesor != null && curso != null) {
            profesor.asignarCurso(curso);
        }
    }

    /**
     * Consulta los cursos de un alumno
     * @param idAlumno el ID del alumno
     */
    public void consultarCursosPorAlumno(String idAlumno) {
        Alumno alumno = (Alumno) personas.stream()
            .filter(p -> p.getId().equals(idAlumno) && p instanceof Alumno)
            .findFirst()
            .orElse(null);
        
        if (alumno != null) {
            alumno.consultarCursos();
        } else {
            System.out.println("Alumno no encontrado");
        }
    }

    /**
     * Consulta los profesores de un alumno
     * @param idAlumno el ID del alumno
     */
    public void consultarProfesoresPorAlumno(String idAlumno) {
        Alumno alumno = (Alumno) personas.stream()
            .filter(p -> p.getId().equals(idAlumno) && p instanceof Alumno)
            .findFirst()
            .orElse(null);
        
        if (alumno != null) {
            alumno.verProfesores();
        } else {
            System.out.println("Alumno no encontrado");
        }
    }

    /**
     * Consulta las dimensiones de una pieza
     * @param nombrePieza el nombre de la pieza
     */
    public void consultarDimensiones(String nombrePieza) {
        PiezaFisica pieza = piezasFisicas.stream()
            .filter(p -> p.getNombre().equals(nombrePieza))
            .findFirst()
            .orElse(null);
        
        if (pieza != null) {
            pieza.consultarDimensiones();
        } else {
            System.out.println("Pieza no encontrada");
        }
    }

    // Getters para las listas
    
    /**
     * Obtiene la lista de todas las personas registradas
     * @return lista de personas
     */
    public List<Persona> getPersonas() {
        return new ArrayList<>(personas);
    }

    public List<Alumno> getAlumnos() {
        List<Alumno> alumnos = new ArrayList<>();
        for (Persona persona : personas) {
            if (persona instanceof Alumno) {
                alumnos.add((Alumno) persona);
            }
        }
        return alumnos;
    }

    public List<Profesor> getProfesores() {
        List<Profesor> profesores = new ArrayList<>();
        for (Persona persona : personas) {
            if (persona instanceof Profesor) {
                profesores.add((Profesor) persona);
            }
        }
        return profesores;
    }

    public List<Curso> getCursos() {
        return new ArrayList<>(cursos);
    }

    public List<PiezaFisica> getPiezasFisicas() {
        return new ArrayList<>(piezasFisicas);
    }
    
    /**
     * Agrega un nuevo curso al sistema
     * @param curso el curso a agregar
     */
    public void agregarCurso(Curso curso) {
        cursos.add(curso);
    }
}