public class Client {
    public static void main(String[] args) {
        double x = Double.parseDouble(System.getenv("X"));
        double y = Double.parseDouble(System.getenv("Y"));
        double z = Double.parseDouble(System.getenv("Z"));
        Formula formula = new Formula(-3,2,1);
        formula.valid();



    }
}
