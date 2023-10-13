package Controller;

import Service.ScanService;

public class MainController extends Scene{

    private Scene sceneState = null;

    public void setScene() {
        System.out.println();
        System.out.println("*** 밀키트 관리프로그램 ***");
        System.out.println("==========================================");
        System.out.println("메뉴>");
        System.out.println("1. 상품 검색");
        System.out.println("2. 상품 추가");
        System.out.println("3. 상품 업데이트");
        System.out.println("4. 상품 삭제");
        System.out.println("0. 종료");
        System.out.println("==========================================");
        System.out.print("선택>> ");

        int id = ScanService.scanner.nextInt();

        switch (id) {
            case 0:
                System.exit(0);
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
