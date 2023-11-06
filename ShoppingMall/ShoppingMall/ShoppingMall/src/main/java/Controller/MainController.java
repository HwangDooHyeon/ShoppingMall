package Controller;

import DAO.MealkitDAOImplement;
import DTO.MealkitDTO;


import Service.ScanService;

import java.util.Scanner;

public class MainController extends Scene{

    private Scene sceneState = null;

    public MainController() {
        MealkitDAOImplement.getInstance().createTable();
    }

    public void setScene() {
        Menu menu = new Menu();
        menu.render();

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
//                sceneState = new CreateScene();
                MealkitDTO mealkitDTO = new MealkitDTO();

                System.out.print("상품 이름 입력: ");
                mealkitDTO.setMealName(
                        ScanService.scanner.nextLine());

                System.out.print("상품 카테고리 입력: ");
                mealkitDTO.setMealCategory(
                        ScanService.scanner.nextLine());

                System.out.print("상품 가격 입력: ");
                mealkitDTO.setMealPrice(
                        ScanService.scanner.nextInt());

                System.out.print("상품 정보 입력: ");
                mealkitDTO.setMealInfo(
                        ScanService.scanner.nextLine());

                MealkitDAOImplement.getInstance().create(mealkitDTO);

                break;

            case 3: {
                //상품업데이트
                System.out.print("변경할 밀키트 번호 입력 : ");
                Long mealId =  ScanService.scanner.nextLong();
                ScanService.scanner.nextLine();

                MealkitDTO mealkitDTO = new MealkitDTO(
                        MealkitDAOImplement.findById(mealId)
                );

                // 이름
                System.out.print("변경할 이름 입력 : ");
                String mealName =  ScanService.scanner.nextLine();
                mealkitDTO.setMealName(mealName);

                // 카테고리
                System.out.print("변경할 카테고리 입력 : ");
                String MealCategory =  ScanService.scanner.nextLine();
                mealkitDTO.setMealName(MealCategory);

                // 가격
                System.out.print("변경할 가격 입력 : ");
                String MealPrice =  ScanService.scanner.nextLine();
                mealkitDTO.setMealName(MealPrice);

                // 상품정보
                System.out.print("변경할 상품정보 입력 : ");
                String MealInfo =  ScanService.scanner.nextLine();
                mealkitDTO.setMealName(MealInfo);


                MealkitDAOImplement.getInstance().updateMealkit(mealkitDTO);

                break;
            }
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