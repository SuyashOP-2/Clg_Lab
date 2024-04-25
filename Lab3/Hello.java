// Java code -> java compiler -> ByteCode -> {JDK[JRE(JVM)]} [Java Runtime Environment] [Java Virtual Machine]
// Java is Strongly typed.

class Calculator {
    int p;
    public int add() {
        System.out.println("Att the add() ");
        return 0;
    }
}

class Hello {
    public static void main(String[] args) {

        Calculator cal = new Calculator();
        cal.add();
    }
}