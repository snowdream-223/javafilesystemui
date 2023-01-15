package test;

public class prosserbuder {
    public static void main(String[] args) {
        ProcessBuilder processBuilder = new ProcessBuilder("ipconfig");
        for (String s : processBuilder.command()) {

            System.out.println(s);
        }

    }
}
