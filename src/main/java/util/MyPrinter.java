package util;

public class MyPrinter {

    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void print(String text) {
        System.out.println(text);
    }
}
