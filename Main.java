package org.example.dz;
//Урок 5. Многопоточность
//        Есть пять философов (потоки), которые могут либо обедать либо размышлять.
//        Каждый философ должен пообедать три раза. Каждый прием пищи длиться
//        500 миллисекунд
//        После каждого приема пищи философ должен размышлять
//        Не должно возникнуть общей блокировки
//        Философы не должны есть больше одного раза подряд
//
//
//        Примечание: Задача немного модифицирована, а именно каждый филосов может
//        принимать пищу только двумя вилками, т.о. пять вилок на пять философов
//        обуславливают конкуренцию за ресурсы.
//
//        Дополнение
//
//        Реализовать многопоточное приложение имитирующее работу месенджера:
//        Хранение и работа с логом чата проводится в основном потоке
//        Остальные потоки - клиенты, хранят в себе имя пользователя, имет
//        графическую оболочку отображающую чат и позволяющую отправлять
//        сообщения в чат
//

import java.util.concurrent.atomic.AtomicBoolean;

public class Main {

      public static AtomicBoolean [] forks =  {new AtomicBoolean(true),
            new AtomicBoolean(true),new AtomicBoolean(true),
            new AtomicBoolean(true),new AtomicBoolean(true)};

    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");
        System.out.println("Начало собрания философов");
        System.out.println("-----------------------------------------------------------");
        Thread person0 = new Thread(new Person("Person1",0,1));
        Thread person1 = new Thread(new Person("Person2",1,2));
        Thread person2 = new Thread(new Person("Person3",2,3));
        Thread person3 = new Thread(new Person("Person4",3,4));
        Thread person4 = new Thread(new Person("Person5",4,0));
        person0.start();
        person1.start();
        person2.start();
        person3.start();
        person4.start();

    }
}
