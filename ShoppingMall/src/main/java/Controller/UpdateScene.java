package Controller;

import DAO.MealkitDAOImplement;
import DTO.MealkitDTO;
import OBJ.Mealkit;
import Service.ScanService;

public class UpdateScene extends Scene {
    @Override
    public int update() {

        MealkitDTO mealkitDTO = new MealkitDTO();

        System.out.println();
        System.out.println("*** 밀키트 상품 정보 업데이트 ***");
        System.out.println("==========================================");
        System.out.println("메뉴>");
        System.out.println("1. 상품 이름 변경");
        System.out.println("2. 카테고리 변경");
        System.out.println("3. 상품 가격 변경");
        System.out.println("4. 상품 정보 변경");
        System.out.println("5. 전체 정보 변경");



        int i = ScanService.scanner.nextInt();

        switch (i) {
            // 이름 변경
            case 1 : {
                System.out.print("변경할 이름 입력 : ");
                String mealName =  ScanService.scanner.nextLine();
                mealkitDTO.setMealName(mealName);

                MealkitDAOImplement.getInstance().updateName(mealkitDTO);
            }
            break;

            // 카테고리 변경
            case 2 : {
                System.out.print("변경할 카테고리 입력 : ");
                String MealCategory = ScanService.scanner.nextLine();
                mealkitDTO.setMealName(MealCategory);

                MealkitDAOImplement.getInstance().updateCategory(mealkitDTO);
            }
            break;

            // 가격 변경
            case 3 : {
                System.out.print("변경할 가격 입력 : ");
                String MealPrice = ScanService.scanner.nextLine();
                mealkitDTO.setMealName(MealPrice);

                MealkitDAOImplement.getInstance().updatePrice(mealkitDTO);
            }
            break;

            // 설명 변경
            case 4 : {
                System.out.print("변경할 상품정보 입력 : ");
                String MealInfo = ScanService.scanner.nextLine();
                mealkitDTO.setMealName(MealInfo);

                MealkitDAOImplement.getInstance().updateInfo(mealkitDTO);
            }
            break;

            // 상품 정보 전체 변경
            case 5 : {
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
                System.out.print("변경할 상품 정보 입력 : ");
                String MealInfo =  ScanService.scanner.nextLine();
                mealkitDTO.setMealName(MealInfo);

                MealkitDAOImplement.getInstance().updateAll(mealkitDTO);
            }
            break;

        }
        return 0;
    }
}

//case 3: {
//        //상품업데이트
//        System.out.print("변경할 밀키트 번호 입력 : ");
//        Long mealId =  ScanService.scanner.nextLong();
//        ScanService.scanner.nextLine();
//
//        MealkitDTO mealkitDTO = new MealkitDTO(
//        MealkitDAOImplement.getInstance().findById(mealId)
//        );
//
//        // 이름
//        System.out.print("변경할 이름 입력 : ");
//        String mealName =  ScanService.scanner.nextLine();
//        mealkitDTO.setMealName(mealName);
//
//        // 카테고리
//        System.out.print("변경할 카테고리 입력 : ");
//        String MealCategory =  ScanService.scanner.nextLine();
//        mealkitDTO.setMealName(MealCategory);
//
//        // 가격
//        System.out.print("변경할 가격 입력 : ");
//        String MealPrice =  ScanService.scanner.nextLine();
//        mealkitDTO.setMealName(MealPrice);
//
//        // 상품정보
//        System.out.print("변경할 상품정보 입력 : ");
//        String MealInfo =  ScanService.scanner.nextLine();
//        mealkitDTO.setMealName(MealInfo);
//
//
//        MealkitDAOImplement.getInstance().updateMealkit(mealkitDTO);
//
//        break;
//        }