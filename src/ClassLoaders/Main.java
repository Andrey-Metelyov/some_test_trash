package ClassLoaders;

import java.util.Comparator;
import java.util.List;

class Utils {
    static class User {
        private String name;
        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return name + "=" + age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }

    public static void sortUsers(List<User> users) {
        // your code here
        users.sort(
                Comparator.comparing(User::getName)
                        .thenComparing(User::getAge, Comparator.reverseOrder())
        );
    }

    public static void main(String[] args) {
        sortUsers(List.of(new User("John", 14), new User("Jane", 15), new User("John", 18)));
    }
}
