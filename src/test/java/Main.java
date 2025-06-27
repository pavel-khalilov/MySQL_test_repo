import common.ProjectUtils;

public class Main {
    public static void main(String[] args) {
        System.out.println(ProjectUtils.getPassword());
        System.out.println(ProjectUtils.getUrl());
        System.out.println(ProjectUtils.getUser());
        System.out.println(ProjectUtils.loadProperties());
    }
}
