public class Tamagotchi {
    private int age;
    private int dureeDeVie;
    private int maxEnergie;
    private int energie;
    private String nom;

    public Tamagotchi(String nom) {
        this.nom = nom;
        age = 0;
        dureeDeVie = 9 + (int)(Math.random() * 6);
        maxEnergie = 5 + (int)(Math.random() * 5);
        energie = 3 + (int)(Math.random() * (maxEnergie - 2));
    }

    public String getNom() {
        return nom;
    }

    public void parler() {
        if (energie > 5) {
            System.out.println(nom + " : tout va bien !");
        } else {
            System.out.println(nom + " : je suis affamé !");
        }
    }

    public void manger() {
        if (energie == maxEnergie) {
            System.out.println(nom + " : je n'ai pas faim !!");
        } else {
            int repas = 1 + (int)(Math.random() * 3);
            energie = energie + repas;
            if (energie > maxEnergie) {
                energie = maxEnergie;
            }
            System.out.println(nom + " : Merci !");
        }
    }

    public boolean ageLimite() {
        return age >= dureeDeVie;
    }

    public boolean vivre() {
        if (age == dureeDeVie) {
            return true;
        }
        if (energie <= 0) {
            System.out.println(nom + " : je meurs... Arrrggh !");
            return false;
        }
        age = age + 1;
        energie = energie - 1;
        if (age == dureeDeVie) {
            System.out.println(nom + " : c'est gagné pour moi !");
        } else {
            parler();
        }
        return true;
    }
}
