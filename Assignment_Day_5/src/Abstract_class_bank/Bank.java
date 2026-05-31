package Abstract_class_bank;

abstract class Bank {
    abstract double getInterestRate();
}


class SBI extends Bank {
    double getInterestRate() {
        return 6.5;
    }
}

class HDFC extends Bank {
    double getInterestRate() {
        return 7.0;
    }
}

class ICICI extends Bank {
    double getInterestRate() {
        return 6.8;
    }
}

