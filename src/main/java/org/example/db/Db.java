package org.example.db;

import lombok.*;
import org.example.entity.*;

import org.example.enums.AdminState;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

@Data
public class Db {

    private final ArrayList<Integer> uniqMealId = new ArrayList<>();
    private final HashMap<MenuType, ArrayList<Meal>> allMeals = new HashMap<>();

    private final HashMap<Long,User> users = new HashMap<>();

    private final HashMap<Long,ArrayList<Buyurtma>> mySavat = new HashMap<>();

    private final HashMap<Long,Xabar> xabarlar=new HashMap<>();

//    private final Set<MenuType> menuTypeSet=new HashSet<>();

    private final ArrayList<Buyurtma> history = new ArrayList<>();


    private final HashMap<Long,ArrayList<Buyurtma>> buyurtma = new HashMap<>();



    public Buyurtma getBuyurtma(String productId){
        ArrayList<Buyurtma> buyurtmasID = new ArrayList<>();
        buyurtma.forEach((aLong, buyurtmas) -> {
            for (Buyurtma buyurtma1 : buyurtmas) {
                if (buyurtma1.getProductId().equals(productId)){
                    buyurtmasID.addAll(buyurtmas);
                    break;
                }
            }
        });
        for (Buyurtma buyurtma1 : buyurtmasID) {
            if (buyurtma1.getProductId().equals(productId)) {
                return buyurtma1;
            }
        }
        return null;
    }

    public String[] getMealById(String id){
        String[] allMMP = new String[3];
        db.getAllMeals().forEach((menuType, meals) ->{
            for (Meal meal : meals) {
                if (meal.getId().equals(id)) {
                    allMMP[0] = menuType.getTitle();
                    allMMP[1]=meal.getTitle();
                    allMMP[2]= String.valueOf(meal.getPrice());
                    break;
                }
            }
        });
        return allMMP;
    }


//    public void addUser(User main) {
//        users.add(main);
//    }

//    public Optional<User> getUserById(String chatId) {
//        for (User user : users) {
//            if(user.getChatId().equals(Long.valueOf(chatId))){
//                return Optional.of(user);
//            }
//        }
//        return Optional.empty();
//    }

//    public Buyurtma getBuyurtmaById()


    private static Db db;

    public static Db getInstance() {
        if (db == null) {
            db=new Db();
//            User user = new User(1121l,"Muqad","+889984");
//            db.users.add(user)
            db.getAllMeals().put(new MenuType("Ichimlik","src/main/resources/imageMenu/ichimliklar.jpg"),new ArrayList<>());
            db.getAllMeals().put(new MenuType("Salatlar","photo"),new ArrayList<>());
            db.getAllMeals().put(new MenuType("Ovqatlar","src/main/resources/imageMenu/ovqatlar.jpg"),new ArrayList<>());
            db.getAllMeals().put(new MenuType("Muzqaymoqlar","photo"),new ArrayList<>());
            db.getAllMeals().put(new MenuType("Burgers","photo"),new ArrayList<>());
            db.getAllMeals().forEach((menuType, meals) -> {
                if (menuType.getTitle().equals("Ichimlik")){
                    meals.add(new Meal("Kola","src/main/resources/imageMeal/ichimliklar/cola.png"," 1 litrli",10000d));
                    meals.add(new Meal("Pepsi","src/main/resources/imageMeal/ichimliklar/Pepsi.jpg","1 litrli",12000d));
                    meals.add(new Meal("Dinay","src/main/resources/imageMeal/ichimliklar/Dinay.jpg","1 litrli",9000d));
                    meals.add(new Meal("Fanta","src/main/resources/imageMeal/ichimliklar/fanta.jpg","G1 litrli",10000d));
                    meals.add(new Meal("Maxito","src/main/resources/imageMeal/ichimliklar/Moxito.jpg","0.5 banchniy",13000d));
                }else if(menuType.getTitle().equals("Ovqatlar")){
                    meals.add(new Meal("Sho'rva","src/main/resources/imageMeal/ovqatlar/Sho'rva.jpg","Toshkent shorva pors",35000d));
                    meals.add(new Meal("Palov","src/main/resources/imageMeal/ovqatlar/Palov.jpg","Samarqand oshi pors",40000d));
                    meals.add(new Meal("Mastava","src/main/resources/imageMeal/ovqatlar/mastava.jpg","Naxorgi mastava pors",30000d));
                    meals.add(new Meal("Besh barmoq","src/main/resources/imageMeal/ovqatlar/beshbarmoq.jpg","Salat qoshimchasi bilan pors",45000d));
                    meals.add(new Meal("Chuchvara","src/main/resources/imageMeal/ovqatlar/chuchvara.jpg","Mazali chuchvara pors",23000d));
                    meals.add(new Meal("Qotirma","src/main/resources/imageMeal/ovqatlar/qotirma.jpg","200 gr gosht 100 gr kartoshka pors",38000d));
                }else if(menuType.getTitle().equals("Salatlar")){
                    meals.add(new Meal("Sezar","PhotoMeal","Mayanezli salat",12000d));
                    meals.add(new Meal("aliviya","PhotoMeal","Mayanezli salat ",13000d));
                    meals.add(new Meal("muskoy kapriz","PhotoMeal","Mayanezli salat",12000d));
                    meals.add(new Meal("svejiy salat","PhotoMeal","Pamidor bodring",5000d));
                }else if(menuType.getTitle().equals("Muzqaymoqlar")){
                    meals.add(new Meal("qulpnayli muzqaymoq","PhotoMeal","Qulpnay siropli",10000d));
                    meals.add(new Meal("shokoladli muzqaymoq","PhotoMeal","Shokolad siropli",10000d));
                    meals.add(new Meal("bananli muzqaymoq","PhotoMeal","Banan siropli",10000d));
                    meals.add(new Meal("oddiy muzqaymoq","PhotoMeal","Meva qoshilmagan",10000d));
                }else if(menuType.getTitle().equals("Burgers")){
                    meals.add(new Meal("Gamburger","PhotoMeal","Katletli",14000d));
                    meals.add(new Meal("Chizburger","PhotoMeal","Sirli",15000d));
                    meals.add(new Meal("Dablburger","PhotoMeal","2x katletli",26000d));
                    meals.add(new Meal("Dablchizburger","PhotoMeal","2x sirli",28000d));
                }
            });
            User user = new User(6436944940L,"Muqaddas","+99909992999", AdminState.DEFAULT);
            db.getUsers().put(6436944940L,user);

        }
        return db;
    }

    public void setXabar(Long chatId ,Xabar xabar) {
        xabarlar.put(chatId,xabar);

    }

//    public void createMenu(MenuType menu){
//        menuTypeSet.add(menu);
//    }



}
