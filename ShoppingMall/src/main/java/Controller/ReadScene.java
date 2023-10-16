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
    public void render() {
    }

    @Override
    public int update() {
        System.out.println();
        System.out.println("*** 밀키트 상품검색 ***");
        System.out.println("==========================================");
        System.out.println("메뉴>");
        System.out.println("1. 전체 검색");
        System.out.println("2. 카테고리 검색");
        System.out.println("3. 상품이름 검색");
        System.out.println("4. 가격별 검색");

        int i = ScanService.scanner.nextInt();

        switch (i){
            case 1 : {
                // ** 전체 검색
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
                // ** 카테고리 검색
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
        }
        return 0;
    }
}
