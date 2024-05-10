package levels;

import models.Subject;
import models.Teacher;
import utils.Data;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.Comparator;


public class Level3 {

    public static void main(String[] args) {
        List<Teacher> teachers = Data.employees();


        /* TO DO 1: Retourner une chaine de caractère qui contient tous les noms des enseignants en majuscule separés par # */
        String names = teachers.stream().map(teacher -> teacher.getName()).reduce((n1,n2) -> n1 + "#" + n2 ).orElse(" ");/* TO DO 1  hint(reduce)*/;

        /* TO DO 2: Retourner une set d'enseignants Java dont le salaire > 80000 */
        Set<Teacher> teachers1 = teachers.stream().filter(teacher -> teacher.getSubject()== Subject.JAVA && teacher.getSalary() >80000).collect(Collectors.toSet());/* TO DO 3 */;

        /* TO DO 3: Retourner une TreeSet d'enseignants (tri par nom et en cas d'égalité tri par salaire) */
        TreeSet<Teacher> sortedTeachersByNameAndSalary = teachers.stream()
                .collect(Collectors.toCollection(() -> new TreeSet<>(
                        Comparator.comparing(Teacher::getName)
                                .thenComparing(Teacher::getSalary)
                )));

        /* TO DO 4: Retourner une Map qui regroupe les enseignants par module */
        Map<Subject, List<Teacher>> teachersBySubject = teachers.stream()
                .collect(Collectors.groupingBy(Teacher::getSubject));
        /* TO DO 5: Retourner une Map qui regroupe les nom des enseignants par salaire */
        Map<Integer, String> namesBySalary = teachers.stream()
                .collect(Collectors.groupingBy(Teacher::getSalary,
                        Collectors.mapping(Teacher::getName, Collectors.joining(","))));

        /* TO DO 6: Afficher les nom des enseignants de chaque module */
        teachersBySubject.forEach((subject, teacherList) -> {
            System.out.println("Module: " + subject);
            teacherList.forEach(teacher -> System.out.println("- " + teacher.getName()));
        });

    }
}
