import common.ProjectUtils;

public class Main {
    public static void main(String[] args) {
        System.out.println("Password: " + ProjectUtils.getPassword());
        System.out.println("Url: " + ProjectUtils.getUrl());
        System.out.println("User: " + ProjectUtils.getUser());
        System.out.println(ProjectUtils.loadProperties());
        System.out.println("is CI: " + ProjectUtils.isCI());
    }
}
