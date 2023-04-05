import org.example.src.domain.Nota;
import org.example.src.domain.Student;
import org.example.src.domain.Tema;
import org.example.src.repository.NotaXMLRepository;
import org.example.src.repository.StudentXMLRepository;
import org.example.src.repository.TemaXMLRepository;
import org.example.src.validation.*;
import org.junit.Before;
import org.junit.Test;
import org.example.src.service.*;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class serviceTest {
    private Service service;

    @Before
    public void beforeAll(){
        Validator<Student> studentValidator = new StudentValidator();
        Validator<Tema> temaValidator = new TemaValidator();
        Validator<Nota> notaValidator = new NotaValidator();

        StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
        TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "teme.xml");
        NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "note.xml");

        service = new Service(fileRepository1, fileRepository2, fileRepository3);
    }
    @Test
    public void testSaveStudentHappyCase(){
        service.deleteStudent("9");
        String id = "9";
        String nume = "andrei";
        int grupa = 400;

        ArrayList<Student> list = new ArrayList<>();
        var students = service.findAllStudents();
        students.forEach(list::add);
        var length = list.size();
        service.saveStudent(id, nume ,grupa);
        students = service.findAllStudents();
        list = new ArrayList<>();
        students.forEach(list::add);
        assertEquals(length + 1, list.size());
    }

    @Test
    public void testSaveStudentIdUnavailable(){
        String id = null;
        String nume = "andrei";
        int grupa = 400;

        ArrayList<Student> list = new ArrayList<>();
        var students = service.findAllStudents();
        students.forEach(list::add);
        var length = list.size();
        service.saveStudent(id, nume ,grupa);
        students = service.findAllStudents();
        list = new ArrayList<>();
        students.forEach(list::add);
        assertEquals(length, list.size());
    }

    @Test
    public void testSaveStudentNumeUnavailable(){
        service.deleteStudent("9");
        String id = "9";
        String nume = null;
        int grupa = 400;

        ArrayList<Student> list = new ArrayList<>();
        var students = service.findAllStudents();
        students.forEach(list::add);
        var length = list.size();
        service.saveStudent(id, nume ,grupa);
        students = service.findAllStudents();
        list = new ArrayList<>();
        students.forEach(list::add);
        assertEquals(length, list.size());
    }
}
