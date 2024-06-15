package homeWork.family_tree.service;

import homeWork.family_tree.family.FamilyTree;
import homeWork.family_tree.human.Gender;
import homeWork.family_tree.human.Human;

import java.time.LocalDate;

public class Service {
    private FamilyTree familyTree;
    private long genHumanId;

    public Service() {
        genHumanId = 0;
        familyTree = new FamilyTree();
    }
    public void addHuman(String name, LocalDate dayOfBirth, LocalDate dayOfDeath, Human father, Human mother, Gender gender) {
        Human human = new Human(genHumanId, name, dayOfBirth, dayOfDeath, father, mother, gender);
        familyTree.addHuman(human);
    }
    public String getHumanListInfo() {
        StringBuilder stringBuild = new StringBuilder();
        stringBuild.append("Семейное дерево");

        for (Human human: familyTree) {
            stringBuild.append(human);
            stringBuild.append("\n");
        }
        return  stringBuild.toString();
    }
    public void sortByName() {
        FamilyTree.sortByName();
    }
}