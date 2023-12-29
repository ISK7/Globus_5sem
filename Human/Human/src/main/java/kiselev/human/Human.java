package kiselev.human;

public class Human {
    int date_of_birth;
    boolean is_man;
    String name, second_name, patronymic;
    public Human(int dob, boolean ism, String n,String sn, String p) {
        date_of_birth = dob;
        is_man = ism;
        name = n;
        second_name = sn;
        patronymic = p;
    }
    public void outInfo(){
        String gender = (is_man)?"man":"woman";
        System.out.println("Date of birth: " + date_of_birth + "\nIs: " + gender + "\nKnown as: " + name + " " + second_name + " " + patronymic);
    }
}
