package homework7;

public class MyTest{

//    @BeforeSuite
//    public static void beforeSuite1(){
//        System.out.println("before");
//    }
    @BeforeSuite
    public static void beforeSuite(){
        System.out.println("before");
    }
    @Test(priority = 1)
    public static void test1(){
        System.out.println("test 1");
    }
    @Test(priority = 2)
    public static void test2(){
        System.out.println("test 2");
    }
    @Test(priority = 3)
    public static void test3(){
        System.out.println("test 3");
    }
    @AfterSuite
    public static void afterSuite() {
        System.out.println("after");
    }

//    @AfterSuite
//    public static void afterSuite1() {
//        System.out.println("after");
//    }

}
