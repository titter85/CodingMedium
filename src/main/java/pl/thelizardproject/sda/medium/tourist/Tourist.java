package pl.thelizardproject.sda.medium.tourist;

/**
 * Created by Dominik on 06-07-2017.
 */
public class Tourist {
    String name;
    int age;
    boolean disabled;

    public Tourist(String newName, int newAge, boolean isDisabled){
        this.name = newName;
        this.age = newAge;
        this.disabled = isDisabled;
    }
}
