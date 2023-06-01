# Христијан Стефов 213016

## Control Flow Graph
![CFG](https://github.com/hstefov/SI_2023_lab2_213016/assets/106402579/f78157ad-6b90-475b-b3fc-ec4d3424e166)

## Цикломатска комплексност
Цикломатската комплексност на кодот е 11. Ја пресметав според тоа колку региони има во графот.
## Every branch
Има вкупно 5 тест случаи со кои се опфаќаат сите гранки:
```
1. Test1: 1-2, 2-3 , 3-25
        user1("Kiko",null,null)
2. Test2: 1-2, 2-4, 4-5, 6-7, 7-8, 8-9.1, 9.1-9.2, 9.2-10, 10-11, 11-12, 13-14, 14-9.3, 9.3-9.2, 15-16, 16-17, 17-18,18-20, 20-21.1, 21.1-21.2, 21.2-22, 22-21.3, 21.2-24, 24-25
        user2(null,"hahahahaha","kk@gmail.com")
        
3. Test3: 1-2, 2-4, 6-7, 7-8, 8-9.1, 9.1-9.2, 9.2-10, 10-11, 11-12, 13-14, 14-9.3, 9.3-9.2, 15-16, 16-17, 17-18,18-20, 20-21.1, 21.1-21.2, 21.2-22, 22-21.3, 21.3-21.2, 22-23, 23-25

        user3("random","!!!special%poiseod8","kk@protonmail.com")
        
4. Test4: 1-2, 2-4, 6-7, 7-(15,16,17), (15,16,17)-18, 18-19, 19-25
        user4("random","1","kkgmail.com")
        
5. Test5: 1-2, 2-4, 6-7, 7-(15,16,17), (15,16,17)-18, 18-20, 20-24, 24-25
        user5("random","1 1","nisto@gmail.com")
```
## Unit tests for Every branch
```
1. Test1:
        RuntimeException ex;
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(user1, users));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));
2. Test2:
        assertFalse(SILab2.function(user2, users));
3. Test3:
        assertFalse(SILab2.function(user3, users));
4. Test4:
        assertFalse(SILab2.function(user4, users));
5. Test5:
        assertFalse(SILab2.function(user5, users));
```
## Multiple condition
Има 4 можни случаи кои треба да се опфатат со Muiltiple condition.
1. TXX -> user=null, исполнет е првиот од трите услова и фрламе исклучок, па затоа останатите нема потреба да се проверуваат.
2. FTX -> user.password=null, првиот услов не е исполнет, вториот е исполнет и фрламе исклучок, а третиот нема потреба да го проверуваме
3. FFT -> user.email=null, првите два не се исполнети, третиот е исполнет и фрламе исклучок
4. FFF -> ниеден од условите не е исполнет
## Unit tests for Multiple condition
```
1. Test1:
        User user1 =  new User(null, null, null);
        RuntimeException ex;
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(user1, users));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));
2. Test2:
        User user2 = new User("random", null, null);
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(user2, users));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));
3. Test3:
      User user3 = new User("random", "pass", null);
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(user3, users));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));
4. Test4:
        User user4 = new User("Stojko", "xxx", "mail.com");
        assertFalse(SILab2.function(user4, users));
```


