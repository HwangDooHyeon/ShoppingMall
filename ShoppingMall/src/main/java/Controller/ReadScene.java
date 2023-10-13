package Controller;

public class ReadScene extends Scene{

    @Override
    public void render() {
        System.out.println("a");
    }

    @Override
    public int update() {
        System.out.println("b");
        return 0;
    }
}
