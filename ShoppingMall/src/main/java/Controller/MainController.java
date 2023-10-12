package Controller;

public class MainController extends Scene{

    private Scene sceneState = null;
//    @Override
//    public void initialize() {}

    public void setScene(int Id) {
        switch (Id) {
            case 0:
                sceneState = new Menu();
                break;
            case 1:
                System.out.println("상품 검색");
                sceneState = new ReadScene();
                break;

            case 2:
                System.out.println("상품 추가");
                sceneState = new CreateScene();
                break;

            case 3:
                System.out.println("상품 업데이트");
                break;

            case 4:
                System.out.println("상품 삭제");
                break;
        }

    }
    @Override
    public void render() {
        sceneState.render();
    }

    @Override
    public int update() {
        sceneState.update();
        return 0;
    }

}
