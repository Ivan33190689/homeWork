package homeWork.family_tree;

import homeWork.family_tree.family.FamilyTree;
import homeWork.family_tree.human.Gender;
import homeWork.family_tree.human.Human;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();


        Human inna = new Human("Инна", LocalDate.of(1976, 5, 16), valera, vika, Gender.Female);
        Human roma = new Human("Роман", LocalDate.of(1978, 6, 25), Gender.Male);
        Human valera = new Human("Валерий", LocalDate.of(1953, 2, 10), Gender.Male);
        Human vika = new Human("Виктория", LocalDate.of(1955, 12, 23), Gender.Female);
        Human vera = new Human("Вера", LocalDate.of(1998, 7, 1), roma, inna, Gender.Female);
        Human karina = new Human("Карина", LocalDate.of(2002, 9, 21), roma, inna, Gender.Female);

        vika.setDayOfDeath(LocalDate.of(2022, 2, 24));

        familyTree.addHuman(inna);
        familyTree.addHuman(roma);
        familyTree.addHuman(vera);
        familyTree.addHuman(karina);

        System.out.println(familyTree);
    }
}