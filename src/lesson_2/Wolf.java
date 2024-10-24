package lesson_2;

public class Wolf {
    private String sex;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    private String nickname;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    private float weight;

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 8) {
            System.out.println("Некорректный возраст");
        } else {
            this.age = age;
        }
    }

    private String colour;

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void walk() {
        System.out.println("Волк " + nickname + " идёт.");
    }

    public void sit() {
        System.out.println("Волк " + nickname + " сидит.");
    }

    public void run() {
        System.out.println("Волк " + nickname + " бежит очень быстро.");
    }

    public void howl() {
        System.out.println("Волк " + nickname + " громко воет.");
    }

    public void hunt() {
        System.out.println("Волк " + nickname + " проголодался и вышел на охоту.");
    }
}
