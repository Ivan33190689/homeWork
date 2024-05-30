package homeWork.family_tree.human;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicStampedReference;

public class Human {
    private String name;
    private LocalDate dayOfBirth, dayOfDeath;
    private Human father, mother;
    private List<Human> children;
    private Gender gender;

    public Human(String name, LocalDate dayOfBirth, LocalDate dayOfDeath, Human father, Human mother, Gender gender) {
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.dayOfDeath = dayOfDeath;
        this.father = father;
        this.mother = mother;
        this.gender = gender;
        children = new ArrayList<>();
    }

    public Human(String name, LocalDate dayOfBirth, Gender gender) {
        this(name, dayOfBirth, dayOfDeath: null, father: null, mother: null, gender);
    }
    public Human(String name, LocalDate dayOfBirth, Human father, Human mother, Gender gender) {
        this(name, dayOfBirth, dayOfDeath: null, father, mother, gender);
    }

    public String getName() {
        return name;
    }

    public LocalDate getDayOfBirth() {
        return dayOfBirth;
    }

    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;
    }

    public List<Human> getChildren() {
        return children;
    }

    public Gender getGender() {
        return gender;
    }

    public void setDayOfDeath(LocalDate dayOfDeath) {
        this.dayOfDeath = dayOfDeath;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public void setFather(Human father) {
        this.father = father;
    }
    public int getAge() {
        if (dayOfDeath == null) {
            return getPeriod(dayOfBirth, LocalDate.now());
        }
        return getPeriod(dayOfBirth, dayOfDeath);
    }
    private int getPeriod(LocalDate dayOfBirth, LocalDate dayOfDeath) {
        Period diff = Period.between(dayOfBirth, dayOfDeath);
        return diff.getYears();
    }

    public boolean addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }else {
            return false;
        }
    }
    public List<Human> getSibLings() {
        List<Human> sibLings = new ArrayList<>();
        if (father != null) {
            sibLings.addAll(father.getChildren());
        }
        if (mother != null) {
            sibLings.addAll(mother.getChildren());
        }
        sibLings.remove(this);
        return sibLings;
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();

        sb.append("Имя: ");
        sb.append(name);
        sb.append(", Возраст: ");
        sb.append(getAge());
        sb.append(", Пол: ");
        sb.append(getGender());
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getChildInfo());

        return sb.toString();
    }
    public String getFatherInfo() {
        String res = "Папа: ";
        Human father = getFather();

        if (father != null) {
            res += father.getName();
        }else {
            res += "неизвестен";
        }
        return res;
    }
    public String getMotherInfo() {
        String res = "Мама: ";
        Human mother = getMother();

        if (mother != null) {
            res += mother.getName();
        }else {
            res += "неизвестна";
        }
        return res;
    }
    public String getChildInfo() {
        StringBuilder res = new StringBuilder();
        res.append("Дети: ");

        if (children.size() != 0) {
            res.append(children.get(0).getName());

            for (int i = 1; i < children.size(); i++) {
                res.append(", ");
                res.append(children.get(i).getName());
            }
        } else {
                res.append("отсутствуют");
        }
        return res.toString();
    }
}