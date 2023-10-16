package Controller;

import OBJ.Mealkit;
import Service.MealkitService;
import Service.ScanService;

public class ReadScene extends Scene{

    MealkitService mealkitService = null;
    public ReadScene(){
        mealkitService = new MealkitService();
    }

    @Override
    public int update() {
        System.out.println();
        System.out.println(" 밀키트 상품검색 ");
        System.out.println("==========================================");
        System.out.println("메뉴>");
        System.out.println("1. 전체 검색");
        System.out.println("2. 카테고리 검색");
        System.out.println("3. 상품이름 검색");
        System.out.println("4. 가격별 검색");

        int i = ScanService.scanner.nextInt();

        switch (i){
            case 1 : {
                //  전체 검색
                for (Mealkit mealkit : mealkitService.findAll()) {
                    System.out.println("---------------------------");
                    System.out.println(
                            mealkit.getMealName() + ", " +
                                    mealkit.getMealCategory() + ", " +
                                    mealkit.getMealPrice() + ", " +
                                    mealkit.getMealInfo());
                }
            }
            break;
            case 2 :{
                //  카테고리 검색
                System.out.print("카테고리 입력: ");
                String mealCategory = ScanService.scanner.nextLine();

                Mealkit mealkit = mealkitService.findbyCategory(mealCategory);
                System.out.println("---------------------------");
                System.out.println(
                        mealkit.getMealName() + ", " +
                                mealkit.getMealCategory() + ", " +
                                mealkit.getMealPrice() + ", " +
                                mealkit.getMealInfo());

            }
            break;
            case 3 :
            //이름 별 검색
            {   System.out.println("상품 이름 입력 : ");
                Mealkit mealkit = mealkitDAOImplement.findbyName(MealName);
                String MealName = ScanService.scanner.nextLine();
                mealkitDAOImplement.findbyName(MealName);}

            break;

            case 4 : {//상품 가격 검색
                System.out.println("상품 가격 입력 : ");
                Mealkit mealkit = mealkitDAOImplement.findbyName(MealPrice);
                String MealPrice = ScanService.scanner.nextLine();
                mealkitDAOImplement.findbyName(MealPrice);
            }
            break;
        }

        return 0;
    }

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
