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