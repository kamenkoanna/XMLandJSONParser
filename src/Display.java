public class Display {
    public static void show (Product p){
        System.out.println(p);
    }

    public static void show(Ecomarket ecomarket){
        ecomarket.getProductsList().forEach(System.out::println);
    }
}
