package Controller;

import DAO.MealkitDAO;
import DAO.MealkitDAOImplement;
import DTO.MealkitDTO;
import Service.MealkitService;
<<<<<<< HEAD
import Utility.MealkitManager;
=======

import Service.ScanService;
>>>>>>> origin/main

import java.util.Scanner;

public class MainController extends Scene{

    private Scene sceneState = null;
    private MealkitDAOImplement mealkitDAOImplement = null;
    public MainController() {
        mealkitDAOImplement = new MealkitDAOImplement();
<<<<<<< HEAD
=======
        MealkitDAOImplement.getInstance().createTable();
>>>>>>> origin/main
    }

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

<<<<<<< HEAD
        int id = MealkitManager.scanner.nextInt();
=======
        int id = ScanService.scanner.nextInt();
>>>>>>> origin/main

        switch (id) {
            case 0:
                System.exit(0);
                break;
            case 1:
                System.out.println("상품 검색");
<<<<<<< HEAD
                sceneState = new CreateScene();
=======
                sceneState = new ReadScene();
>>>>>>> origin/main
                break;

            case 2:
                System.out.println("상품 추가");
<<<<<<< HEAD
                sceneState = new CreateScene();
=======
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

>>>>>>> origin/main
                break;

            case 3: {
                //상품업데이트
                System.out.print("변경할 밀키트 번호 입력 : ");
                Long mealId =  ScanService.scanner.nextLong();
                ScanService.scanner.nextLine();

                MealkitDTO mealkitDTO = new MealkitDTO(
<<<<<<< HEAD
                    mealkitDAOImplement.findById(1L)
=======
                    mealkitDAOImplement.findById(mealId)
>>>>>>> origin/main
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
<<<<<<< HEAD
                String mealPrice =  ScanService.scanner.nextLine();
                mealkitDAOImplement.findbyPrice();
                mealkitDTO.setMealName(mealPrice);
                mealkitDAOImplement.updateMealkit();
=======
                String MealPrice =  ScanService.scanner.nextLine();
                mealkitDTO.setMealName(MealPrice);
>>>>>>> origin/main

                // 상품정보
                System.out.print("변경할 상품정보 입력 : ");
                String MealInfo =  ScanService.scanner.nextLine();
                mealkitDTO.setMealName(MealInfo);


<<<<<<< HEAD
                mealkitDAOImplement.updateMealkit(MealkitDTO);
=======
                mealkitDAOImplement.updateMealkit(mealkitDTO);
>>>>>>> origin/main

                break;
            }
            case 4:
                System.out.println("상품 삭제");
<<<<<<< HEAD
                mealkitDAOImplement.findAll();

=======
>>>>>>> origin/main
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
