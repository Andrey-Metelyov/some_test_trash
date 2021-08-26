package HtmlParser;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class Main {
    static class Tag {
        String tag;
        int tagStart;
        int tagEnd;

        public Tag(String tag, int tagStart, int tagEnd) {
            this.tag = tag;
            this.tagStart = tagStart;
            this.tagEnd = tagEnd;
        }

        boolean isClosingTag() {
            return tag.contains("/");
        }

        String getOpenTag() {
            return tag.replace("/", "");
        }

        @Override
        public String toString() {
            return "Tag{" +
                    "tag='" + tag + '\'' +
                    ", tagStart=" + tagStart +
                    ", tagEnd=" + tagEnd +
                    '}';
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder input = new StringBuilder();
        while (scanner.hasNext()) {
            input.append(scanner.next());
        }
        parse(input.toString());
//        parse("<html><a>hello</a><h1><h4>nestedHello</h4><h3>nestedWorld</h3><h6><br>top</br></h6></h1><br>world</br></html>");
    }

    private static void parse(String input) {
        int start = 0;
        Stack<Tag> stack = new Stack<>();
        Queue<String> queue = new ArrayDeque<>();
        while (start < input.length()) {
            Tag tag = getTag(input, start);
//            System.out.println("tag = " + tag);
            if (tag.isClosingTag()) {
                Tag prevTag = stack.peek();
//                System.out.println("tag = " + tag);
//                System.out.println("prevTag = " + prevTag);
                if (prevTag.tag.equals(tag.getOpenTag())) {
                    String tagContent = input.substring(prevTag.tagEnd, tag.tagStart);
                    queue.add(tagContent);
//                    System.out.println("tagContent = " + tagContent);
                    stack.pop();
                }
            } else {
                stack.add(tag);
            }
            start = tag.tagEnd;
        }
        for (String s : queue) {
            System.out.println(s);
        }
    }

    private static Tag getTag(String input, int start) {
        int tagStart = input.indexOf('<', start);
        int tagEnd = input.indexOf('>', tagStart) + 1;
        String tag = input.substring(tagStart, tagEnd);
        return new Tag(tag, tagStart, tagEnd);
    }
}