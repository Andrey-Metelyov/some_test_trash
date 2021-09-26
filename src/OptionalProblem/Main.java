package OptionalProblem;

import java.util.Optional;

class ValueProvider {
    public Optional<String> getValue() {
        return Optional.empty();
    }
}

public class Main {
    public static void main(String[] args) {
            ValueProvider provider = new ValueProvider();
            // use provider.getValue() to get Optional<String>
            provider.getValue().ifPresent(System.out::println);
    }
}
