package Controller;

import Service.ScanService;

public class MainScene extends Scene{

    @Override
    public void initialize() {}

    @Override
    public void render() {

        int i = ScanService.scanner.nextInt();

        switch (i) {
            case 1:
                System.out.println("상품 검색");
                break;

            case 2:
                System.out.println("상품 추가");
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
    public int update() {return 0;}

}
