package homeWork.family_tree.family;

import homeWork.family_tree.human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    private List<Human> humanList;

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(List<Human> humanList) {
        this.humanList = humanList;
    }
    public boolean addHuman(Human human) {

        if (!humanList.contains(human)) {
            humanList.add(human);
            addToMother(human);
            addToFather(human);
            addToChildren(human);

            return true;
        }
        return false;
    }
    private void addToMother(Human human) {
            human.getMother().addChild(human);
    }
    private void addToFather(Human human) {
            human.getFather().addChild(human);
    }
    private void addToChildren(Human human) {
        for (Human child: human.getChildren()) {
            child.addParents(human);
        }
    }

    public Human findName(String name) {
        for (Human human: humanList) {
            if (human.getName().equals(name)) {
                return human;
            }
        }
        return null;
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Семейное дерево: \n");

        for (Human human: humanList) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
