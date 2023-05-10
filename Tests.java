public class Tests {
    public static void main(String[] args){
        testIsCoupe();
        testIsFast();
        testDistance();
    }
    public static void testIsCoupe() {
        // Test case 1: Invalid `Car` object
        Car invalidCar = new Car(-1, 2, 500);
        boolean expected = false;
        boolean actual = invalidCar.IsCoupe();
        System.out.println(String.format("Expected: %1$s, Actual: %2$s", expected, actual));

        // Test case 2: Normal `Car` object with 2 doors and less than 500 horsepower
        Car normalCar1 = new Car(4, 2, 499);
        expected = true;
        actual = normalCar1.IsCoupe();
        System.out.println(String.format("Expected: %1$s, Actual: %2$s", expected, actual));

        // Test case 3: Normal `Car` object with 2 doors and at least 500 horsepower
        Car normalCar2 = new Car(4, 2, 500);
        expected = true;
        actual = normalCar2.IsCoupe();
        System.out.println(String.format("Expected: %1$s, Actual: %2$s", expected, actual));

        // Test case 4: Normal `Car` object with more than 2 doors and less than 500 horsepower
        Car normalCar3 = new Car(4, 4, 499);
        expected = false;
        actual = normalCar3.IsCoupe();
        System.out.println(String.format("Expected: %1$s, Actual: %2$s", expected, actual));

        // Test case 5: Normal `Car` object with more than 2 doors and at least 500 horsepower
        Car normalCar4 = new Car(4, 4, 500);
        expected = false;
        actual = normalCar4.IsCoupe();
        System.out.println(String.format("Expected: %1$s, Actual: %2$s", expected, actual));
    }

    public static void testIsFast() {
        // Test case 1: Invalid `Car` object
        Car invalidCar = new Car(-1, 2, 500);
        boolean expected = false;
        boolean actual = invalidCar.IsFast();
        System.out.println(String.format("Expected: %1$s, Actual: %2$s", expected, actual));

        // Test case 2: Normal `Car` object with 2 doors and less than 500 horsepower
        Car normalCar1 = new Car(4, 2, 499);
        expected = false;
        actual = normalCar1.IsFast();
        System.out.println(String.format("Expected: %1$s, Actual: %2$s", expected, actual));

        // Test case 3: Normal `Car` object with 2 doors and at least 500 horsepower
        Car normalCar2 = new Car(4, 2, 500);
        expected = true;
        actual = normalCar1.IsFast();
        System.out.println(String.format("Expected: %1$s, Actual: %2$s", expected, actual));
    }

    public static void testDistance(){
        // Test case 1: Invalid `Car` object
        Car invalidCar = new Car(-1, 2, 500);
        int expected = 0;
        int actual = invalidCar.DriveDistance(500);
        System.out.println(String.format("Expected: %1$s, Actual: %2$s", expected, actual));

        // Test case 2: Valid `Car` object
        Car invalidCar1 = new Car(4, 2, 500);
        expected = 20;
        actual = invalidCar1.DriveDistance(1000);
        System.out.println(String.format("Expected: %1$s, Actual: %2$s", expected, actual));

        // Test case 3: Valid `Car` object - we just change doors to 4, time to distance should be same
        Car invalidCar2 = new Car(4, 4, 500);
        expected = 20;
        actual = invalidCar2.DriveDistance(1000);
        System.out.println(String.format("Expected: %1$s, Actual: %2$s", expected, actual));

        // Test case 4: Valid `Car` object - we increse HP and get there faster (expeced is lower)
        Car invalidCar3 = new Car(4, 4, 1000);
        expected = 10;
        actual = invalidCar3.DriveDistance(1000);
        System.out.println(String.format("Expected: %1$s, Actual: %2$s", expected, actual));

        // Test case 5: Valid `Car` object - we increse HP and get there faster (expeced is lower)
        Car invalidCar4 = new Car(4, 4, 0);
        expected = 0;
        actual = invalidCar4.DriveDistance(1000);
        System.out.println(String.format("Expected: %1$s, Actual: %2$s", expected, actual));
    }


    //граф на тек на програмата - не покривање јазли и покривање врски еднаш - Edge covarage
    public static void GraphFlowTests(){
        //------------------TEST1------------------
        //иницијализираме објект со стандарни вредност во конструктор
        var car1 = new Car(4, 4, 500);

        //за да извршиме edge coverage мораме имаме сет на тестови,
        // со кои ќе го извршиме / покриеме секој пат / path еднаш (не и повеќе)
        //во нашиот случај ги извршуваме следните тестови

        //Тест 1 (path t1) - овде го покриваме патот каде што ќе се изврши логиката во if условот
        //за измината дистанца во текотната вожнња
        car1.DriveDistance(1200);

        //------------------TEST2------------------
        //иницијализираме објект со стандарни вредност во конструктор
        var car2 = new Car(4, 4, 500);
        //Тест 2 (path t2) - овде го покриваме патот каде што не се извршува логиката во if условот
        //за измината дистанца во текотната вожнња
        car2.DriveDistance(500);

        //Овде Т = { t1, t2 }, односно ова множество тестови ги покрива врските еднаш
        // t1 = { 1, 2, 3} каде што 1 =  1200, 2 = сетирање на flag (поради структурата за избор if), 3 = резултат
        // t2 = { 1, 3 } каде што 1 = 500, 3 = резултат
    }

    //граф на тек на податоците - Data Flow Criteria
    public static void DataFlowTests(){
        //иницијализираме објект со стандарни вредност во конструктор
        var car = new Car(4, 4, 500);

        //за да исполниме Data Flow Criteria, вредностите во дефиницијата (def)s
        //мораат да достигнат барем еден, неколку или сите возможнИ (use)s

        //------------------TEST1------------------
        //иницијализираме објект со стандарни вредност во конструктор
        var car1 = new Car(4, 4, 500);

        //def во нашиот случај претставува варијаблата {needsService} која
        //се иницијализира како false во секој нов Car објект
        car1.DriveDistance(5000);
        boolean expected = true;
        boolean actual = car1.needsService;
        
        System.out.println(String.format("Expected: %1$s, Actual: %2$s", expected, actual));

        //при извршување на функцијата со input 5000
        //во if условот се сетира {needsService} варијаблата
        //во вредност true. Со ова исполнуваме Data Flow Criteria
        //поради тоа што нашиот def {needsService} е барем еднаш
        //употребена во if условот (use)
    }
}

