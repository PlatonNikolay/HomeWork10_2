package home.work.stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        final ArrayList<Boy> boys = new ArrayList<>() {{
            add(new Boy("Николай", 68));
            add(new Boy("Пётр", 53));
            add(new Boy("Василий", 25));
            add(new Boy("Михаил", 19));
            add(new Boy("Алексей", 6));
            add(new Boy("Николай", 86));
            add(new Boy("Пётр", 35));
            add(new Boy("Михаил", 111));
            add(new Boy("Алексей", 22));
            add(new Boy("Михаил", 1));
            add(new Boy("Яков", 30));
        }};
        //Сортируем по возрасту
        //Группируем коллекцию <ключ, количество ключей>
        Map<String, Long> map = boys.stream()
                .filter(p -> p.getAge() >= 18)
                .collect(Collectors.groupingBy(Boy::getName, (Collectors.counting())));

        //Новый поток
        //Актуализируем количество тёзок(количество ключей минус 1)
        //Сортируем
        //Ограничиваем по количеству
        //Выводим с помощью стрима
        map.entrySet()
                .stream()
                .peek(p -> p.setValue(p.getValue() - 1))
                .sorted(Map.Entry.comparingByKey())
                .limit(4)
                .forEach(System.out::println);
    }
}
