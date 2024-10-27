package lesson_2;

public class Wolf {
    private String sex;
    private String nickname;
    private float weight;
    private int age;
    private String color;

    public String getSex() {
        return sex;
    }

    public String getNickname() {
        return nickname;
    }

    public float getWeight() {
        return weight;
    }

    public int getAge() {
        return age;
    }

    public String getColor() {
        return color;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void setAge(int age) {
        if (age > 8) {
            System.out.println("Некорректный возраст");
        } else {
            this.age = age;
        }
    }

    public void setColor(String color) {
        this.color = color;
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
