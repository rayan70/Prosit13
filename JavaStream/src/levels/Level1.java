package levels;

import models.Subject;
import models.Teacher;
import utils.Data;

import java.util.List;

public class Level1 {

    public static void main(String[] args) {
        List<Teacher> teachers = Data.employees();

        /*
         * TO DO 1: Afficher tous les enseignants
         */
        teachers.stream().forEach(teacher -> System.out.println(teacher));

        /*
         * TO DO 2: Afficher les enseignants dont le nom commence par la lettre n
         */
        teachers.stream().filter(teacher -> teacher.getName().toLowerCase().startsWith("n")).forEach(teacher -> System.out.println(teacher));

        /*
         * TO DO 3: Afficher les enseignants dont le nom commence par la lettre n et le salaire > 100000
         */
        teachers.stream().filter(teacher -> teacher.getName().toLowerCase().startsWith("n")).filter(teacher -> teacher.getSalary() > 100000).forEach(teacher -> System.out.println((teacher)));

        /*
         * TO DO 4: Afficher les enseignants JAVA triés par salaire (éliminer les redondances)
         */
        teachers.stream()
                .filter(teacher -> teacher.getSubject() == Subject.JAVA) .sorted((teacher1, teacher2) -> Integer.compare(teacher1.getSalary(), teacher2.getSalary())).distinct().forEach(teacher -> System.out.println(teacher));
        /*
         * TO DO 5: Afficher les noms des enseignants dont le salaire > 60000 avec 2 manières différentes
         */

        /* First Way */
        teachers.stream()
                .filter(teacher -> teacher.getSalary() > 60000)
                .forEach(teacher -> System.out.println(teacher.getName()));
        /* Second Way */
        // Deuxième méthode
        teachers.stream()
                .filter(teacher -> teacher.getSalary() > 60000)
                .map(Teacher::getName) // ou .map(teacher -> teacher.getName())
                .forEach(System.out::println);


        /*
         * TO DO 6:  Ajouter 200 Dt pour les enseignants dont le nom commence par m et afficher celui qui a le salaire le plus élevé
         */
        teachers.stream()
                .filter(teacher -> teacher.getName().toLowerCase().startsWith("m"))
                .peek(teacher -> teacher.setSalary(teacher.getSalary() + 200)) // Ajoute 200 au salaire
                .max((teacher1, teacher2) -> Integer.compare(teacher1.getSalary(), teacher2.getSalary()))
                .ifPresent(highestPaidTeacher -> System.out.println("Enseignant avec le salaire le plus élevé après l'ajout : " + highestPaidTeacher));


    }
}
