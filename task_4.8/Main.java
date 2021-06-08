import java.util.Scanner;

/*
 *  ***Гостиница***
 *  1) Гостиница
 *  2) Номера (кол-во мест(1-3), сан.узел(есть/нет), питаение(есть/нет), wifi(есть/нет), свободен/занят)
 *
 *   *Задание для лабораторной работы №4*
 *   Освободить комнату
 *   Вывести свойства комнаты
 *   Показать комнаты с WiFi
 *   Показать комнаты с WC
 *   Показать комнаты с Eat
 *   Показать комнаты по кол-ву спальных мест
 *   Отобразить список команд
 * */
public class Main {
  public static void main(String[] args) {
    Room[] rooms = {
            new Room((byte) 1, false, false, true, (byte) 11),
            new Room((byte) 2, true, true, false, (byte) 12),
            new Room((byte) 1, false, true, true, (byte) 13),
            new Room((byte) 3, true, false, false, (byte) 21),
            new Room((byte) 2, false, false, false, (byte) 22),
            new Room((byte) 1, true, true, true, (byte) 23),
            new Room((byte) 3, false, true, false, (byte) 31),
            new Room((byte) 3, true, true, false, (byte) 32),
            new Room((byte) 1, false, false, true, (byte) 33),
    };
    Hotel hotel = new Hotel(rooms);
    Scanner scanner = new Scanner(System.in);
    String command;
    showCommands();
    while (true) {
      System.out.println("Введите команду");
      command = scanner.nextLine();
      if (command.equals("getFreeRooms") || command.equals("gfr")) {
        hotel.getFreeRooms();
      } else if (command.equals("reserveRoom") || command.equals("rr")) {
        System.out.print("Введите номер комнаты для бронирования: ");
        byte roomNumber = (byte) scanner.nextInt();
        hotel.reserveRoom(roomNumber);
      } else if (command.equals("freeRoom") || command.equals("fr")) {
        System.out.print("Введите номер комнаты для освобождения: ");
        byte roomNumber = (byte) scanner.nextInt();
        hotel.freeRoom(roomNumber);
      } else if (command.equals("propertyRoom") || command.equals("pr")) {
        System.out.print("Введите номер комнаты для показа свойств: ");
        byte roomNumber = (byte) scanner.nextInt();
        for(int i=0; i<hotel.getRooms().length; i++) {
          if( hotel.getRooms()[i].getRoomNumber() == roomNumber)     hotel.getRooms()[i].roomProperties();
        }
      } else if (command.equals("showWiFiRooms") || command.equals("swfr")) {
        hotel.showWiFiRooms();
      } else if (command.equals("showWcRooms") || command.equals("swcw")) {
        hotel.showWcRooms();
      } else if (command.equals("showEatRooms") || command.equals("ser")) {
        hotel.showEatRooms();
      } else if (command.equals("showSortedRooms") || command.equals("ssr")) {
        hotel.showQuantitySortedRooms();
      } else if (command.equals("help") || command.equals("?")) {
        showCommands();
      } else if (command.equals("exit") || command.equals("e")) {
        break;
      }
    }
  }
  public static void showCommands(){
    System.out.println("Список команд:\n"
            + "Свободные комнаты - getFreeRooms иди gfr\n" +
            "Забронировать комнату - reserveRoom или rr\n" +
            "Освободить комнату - freeRoom или fr\n" +
            "Показать свойства комнаты - propertyRoom или pr"+
            "\n" +
            "Показать комнаты с wiFi - showWiFiRooms или swfr\n" +
            "Показать комнаты с туалетом - showWcRooms или swr\n" +
            "Показать комнаты с питанием - showEatRooms или ser\n" +
            "Показать сортированный список комнат\n" +
            " по количеству спальных мест - showSortedRooms или ssr\n" +
            "Отобразить список команд - help или ?\n" +
            "Выъод - exit или e");
  }

}

/*

class Hotel {
  Room[] rooms;

  public Room[] getRooms() {
    return rooms;
  }

  public Hotel(Room[] rooms) {
    this.rooms = rooms;
  }

  public void getFreeRooms(){
    String freeRoomsList = "";
    for (int i = 0; i < rooms.length; i++) {
      if (rooms[i].isFree()) freeRoomsList += rooms[i].getRoomNumber()+", ";
    }
    System.out.println("Номера свободных комнат "+freeRoomsList);
  }
  public void reserveRoom(byte roomNumber){
    String info = "Такой комнаты не существует";
    for (int i = 0; i < rooms.length; i++) {
      Room room = rooms[i];
      if(room.getRoomNumber() == roomNumber && room.isFree()){
        room.setFree(false);
        info = ("Комната номер "+roomNumber+" успешно забронированна");
        break;
      }else if(room.getRoomNumber() == roomNumber && !room.isFree()){
        info = "Комната "+roomNumber+" занята";
        break;
      }
    }
    System.out.println(info);
  }

  public void freeRoom(byte roomNumber){
    String info = "Такой комнаты не существует";
    for (int i = 0; i < rooms.length; i++) {
      Room room = rooms[i];
      if(room.getRoomNumber() == roomNumber && !room.isFree()){
        room.setFree(true);
        info = ("Комната номер "+roomNumber+" успешно освобождена");
        break;
      }else if(room.getRoomNumber() == roomNumber && room.isFree()){
        info = "Комната "+roomNumber+" была свободна";
        break;
      }
    }
    System.out.println(info);
  }

  public void showWiFiRooms(){

    String wifiRoomsList = "";
    for (int i = 0; i < rooms.length; i++) {
      if (rooms[i].isWifi()) wifiRoomsList += rooms[i].getRoomNumber()+", ";
    }
    System.out.println("Номера комнат c WiFi: "+ wifiRoomsList);
  }

  public void showWcRooms(){

    String wcRoomsList = "";
    for (int i = 0; i < rooms.length; i++) {
      if (rooms[i].isWc()) wcRoomsList += rooms[i].getRoomNumber()+", ";
    }
    System.out.println("Номера комнат c туалетом: "+ wcRoomsList);
  }
  public void showEatRooms(){

    String eatRoomsList = "";
    for (int i = 0; i < rooms.length; i++) {
      if (rooms[i].isEat()) eatRoomsList += rooms[i].getRoomNumber()+", ";
    }
    System.out.println("Номера комнат c питанием: "+ eatRoomsList);
  }

  public void showQuantitySortedRooms(){
    String quantitySortedRoomsList = "";
    Room[] sortedRooms = bubbleSort(rooms);

    for (int i = 0; i < rooms.length; i++) {

      quantitySortedRoomsList += rooms[i].getRoomNumber()+" мест "+ rooms[i].getQuantity() +"\n ";
    }
    System.out.println("Номера комнат c количеством спальных мест:\n "+ quantitySortedRoomsList);
  }

  public static Room[] bubbleSort(Room[] array) {
    boolean sorted = false;
    Room temp;
    while(!sorted) {
      sorted = true;
      for (int i = 0; i < array.length - 1; i++) {
        if (array[i].getQuantity() < array[i+1].getQuantity()) {
          temp = array[i];
          array[i] = array[i+1];
          array[i+1] = temp;
          sorted = false;
        }
      }
    }
    return array;
  }
}
*/
/*
 * 2) Номера (кол-во мест(1-3), сан.узел(есть/нет), питаение(есть/нет), wifi(есть/нет), свободен/занят)
 */
/*
class Room {
  private byte quantity;
  private boolean wc;
  private boolean eat;
  private boolean wifi;
  private boolean isFree;
  private byte roomNumber;

  public Room(byte quantity, boolean wc, boolean eat, boolean wifi,byte roomNumber) {
    this.quantity = quantity;
    this.wc = wc;
    this.eat = eat;
    this.wifi = wifi;
    this.isFree = true;
    this.roomNumber = roomNumber;
  }


  public byte getRoomNumber() {
    return roomNumber;
  }

  public byte getQuantity() {
    return quantity;
  }

  public boolean isWc() {
    return wc;
  }

  public boolean isEat() {
    return eat;
  }

  public boolean isWifi() {
    return wifi;
  }

  public boolean isFree() {
    return isFree;
  }

  public void setFree(boolean free) {
    isFree = free;
  }

  public void roomProperties (){
    System.out.println("Свойства комнаты " +
            getRoomNumber() +
            " :\nСпальных мест: "+ getQuantity()
            + "\nТуалет: " + isWc()
            + "\nWifi: "+ isWifi()
            + "\nПитание: " + isEat()
            + "\nСвободна: " + isFree());
  }
}
*/