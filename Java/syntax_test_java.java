// SYNTAX TEST "Java.sublime-syntax"

public class SyntaxTest {
    private String memberString = "Hello";
    private String memberString2 = new String("Hello");
    private String memberString3 = String.valueOf("Hello");
//                                ^ meta.assignment.rhs.java
//                                                 ^ string.quoted.double.java
    private int memberLpos = memberString3.indexOf("l");
//                                                     ^ punctuation.terminator.java

    public static void main(String... args) {
        String[] strings = new String[5];
//                         ^ keyword.control.new.java
        printList(Arrays.stream(args)
            .collect(Collectors.toCollection(ArrayList::new)));
//                                                      ^ meta.method.body.java - keyword.control.new.java
        anotherMethod();
        try (Stream<String> lines = Files.lines(path)) {
//                                                   ^ meta.method.body.java - meta.assignment.rhs.java
            lines.forEach(System.out::println);
        }
        try (for int i = 0; i < 10; i+= 2) {
            System.out.println(i);
        }
    }

    private static void printList(List<String> args) {
        args.stream().forEach(System.out::println);
    }

    private static void anotherMethod() {

    }
}
