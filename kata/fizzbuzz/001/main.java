import static java.lang.System.err;
import static java.lang.System.out;
import static java.lang.System.exit;

record Mapping(int denominator, String text) {}

void main(String[] args) {
    var usage = "Usage: program <number>";

    if (args.length != 1) {
        err.println(usage);
        exit(1);
    }

    int input = 1;

    try {
        input = Integer.parseInt(args[0]);
    } catch (Throwable t) {
        err.println(usage);
        err.println("Error during String to int convertion: " + t.getMessage());
        t.printStackTrace();
    }

    Mapping[] mappings = {
        new Mapping(3, "fizz"),
        new Mapping(5, "buzz"),
        new Mapping(7, "gazz")
    };

    var firstWord = true;
    var builder = new StringBuilder();

    for (Mapping mapping : mappings) {
        if (input % mapping.denominator == 0) {
            if (!firstWord) {
                builder.append(" ");
            }

            builder.append(mapping.text);
            firstWord = false;
        }
    }

    out.println(builder.toString());
}