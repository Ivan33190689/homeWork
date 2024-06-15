package homeWork.family_tree;

import homeWork.family_tree.family.FamilyTree;
import homeWork.family_tree.human.Gender;
import homeWork.family_tree.human.Human;
import homeWork.family_tree.service.Service;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();


        String filePath = "src/homeWork/family_tree/myTree.txt";
//        FamilyTree familyTree = myTree();
        FamilyTree familyTree = load(filePath);
//        System.out.println(familyTree);

        save(familyTree, filePath);
    }
    private static FamilyTree load(String filePath) {
        Writeable writeable = new FileHandler();
        return (FamilyTree) writeable.read(filePath);
    }
    private static void save(FamilyTree familyTree, String filePath) {
        Writeable writeable = new FileHandler();
        writeable.save(familyTree, filePath);
    }
    private  static FamilyTree myTree() {
        FamilyTree familyTree = new FamilyTree();


        Human valera = new Human("Валерий", LocalDate.of(1953, 2, 10), Gender.Male);
        Human vika = new Human("Виктория", LocalDate.of(1955, 12, 23), Gender.Female);
        Human inna = new Human("Инна", LocalDate.of(1976, 5, 16), valera, vika, Gender.Female);
        Human roma = new Human("Роман", LocalDate.of(1978, 6, 25), Gender.Male);
        Human vera = new Human("Вера", LocalDate.of(1998, 7, 1), roma, inna, Gender.Female);
        Human karina = new Human("Карина", LocalDate.of(2002, 9, 21), roma, inna, Gender.Female);

        vika.setDayOfDeath(LocalDate.of(2022, 2, 24));

        familyTree.addHuman(inna);
        familyTree.addHuman(roma);
        familyTree.addHuman(vera);
        familyTree.addHuman(karina);
        familyTree.addHuman(valera);
        familyTree.addHuman(vika);

        return familyTree;
    }
}