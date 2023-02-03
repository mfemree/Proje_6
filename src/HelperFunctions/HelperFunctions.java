package HelperFunctions;

import Database.Address;

public class HelperFunctions {

    /*

        Proje kapsamında gerekli genel methodlari burada tanımlayacağız, buradaki methodlari birer doğrulayıcı yada
    oluşturucu olarak düşünebiliriz. Örneğin bir city nin varlığını doğrulama veya bir rastgele bir numara oluşturuma.

     */

    //---------------------------------------------------------------------------------------

    /*

        Bir method oluşturalım ve adına "checkCity" diyelim,
            Tipi: static
            Return tipi: String
            Parametre: String türünden bir city almalı

        Eğer ki city:
            Address classinin icerisindeki static arrayliste bulunan bir city e eşit değilse
            bir RuntimeException firlatsin ve şu mesaji geçsin:
                "We can not continue your process because, there is no shipping that location."
        Eğer ki city:
            Arraylistin içerisinde var ise o zaman city i dondursun.

     */

    public static String checkCity(String city){
//    if (Address.getCityList().contains(city)) return city;
//    else System.out.println("We can not continue your process because, there is no shipping that location.");
        try {
            if (Address.getCityList().contains(city)) return city;
            else throw new RuntimeException("We can not continue your process because, there is no shipping that location.");
        }catch (RuntimeException ex){
            System.out.println(ex.getMessage());
        }return null;
    }

    /*

        Bir method oluşturalım ve adına "generateShippingTrackingNumber" diyelim,
            Tipi: static
            Return tipi: String
            Parametre: String türünden bir fullname, bir city, bir zipcode almalı

        Bu methodun amacı bir kargo takip numarasi üretmektir.

        kargo takip numarası şu şekilde oluşacak ve daha sonrada return olacaktır.

            city nin ilk 3 harfi + zipcode + fullname in baş harfleri

        son olarak ise dönen değer tamamen büyük harde dönmelidir.

        örneğin bir takip kodu: IZM35430CK (Izmir + 35430 + Cem Karaca)

     */

 public static String generateShippingTrackingNumber(String fullname, String city, String zipcode) {
     String ilkHarfFullName = "";
     ilkHarfFullName += fullname.charAt(0);

     for (int i = 0; i <fullname.length() ; i++) {
         if (fullname.charAt(i) == ' ')
             ilkHarfFullName += fullname.charAt(i + 1);
     }

     String stn = city.substring(0, 3) + zipcode + ilkHarfFullName;

     return stn.toUpperCase();
 }

    /*

        Bir method oluşturalım ve adına "checkZipCode" diyelim,
            Tipi: static
            Return tipi: String
            Parametre: String türünden bir zipCode almalı

        Eğer ki zipCode:
            5 rakamdan oluşmuyorsa RuntimeException firlatmalı ve mesaj olarak ise "Please enter valid Zip Code"
            geçmeli
        diğer durumda ise zipCode unu döndürmeli
     */

    public static String checkZipCode(String zipCode) {

        try{

            if ( zipCode.length() == 5 && zipCode.replace("[^0-9]",""   ).length() == 5 )
                return zipCode;

            throw new RuntimeException("Please enter valid Zip Code");

        }catch (RuntimeException ex ) {
        System.out.println( ex.getMessage());
        }

        return null;
    }



}
