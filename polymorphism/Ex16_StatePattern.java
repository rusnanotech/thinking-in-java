package biz.markov.thinking.polymorphism;

class AlertStatus {
    public String toString() {
        return "none";
    }
}

class Green extends AlertStatus {
    public String toString() {
        return "green";
    }
}

class Yellow extends AlertStatus {
    public String toString() {
        return "yellow";
    }
}

class Red extends AlertStatus {
    public String toString() {
        return "red";
    }
}

class Starship {
    private AlertStatus status;

    public Starship() {
        status = new Green();
    }

    public void setGreen() {
        status = new Green();
    }

    public void setYellow() {
        status = new Yellow();
    }

    public void setRed() {
        status = new Red();
    }

    public void checkStatus() {
        System.out.println(status);
    }
}

public class Ex16_StatePattern {
    public static void main(String args[]) {
        Starship starship = new Starship();

        starship.checkStatus();
        starship.setYellow();
        starship.checkStatus();
        starship.setRed();
        starship.checkStatus();
    }
}
