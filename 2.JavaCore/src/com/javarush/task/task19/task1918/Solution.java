package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат.

Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>

Первым параметром в метод main приходит тег. Например, "span".
Вывести на консоль все теги, которые соответствуют заданному тегу.
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле.
Количество пробелов, \n, \r не влияют на результат.
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нет.
Тег может содержать вложенные теги.

Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми


Требования:
1. Программа должна считывать имя файла с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое файла (используй FileReader).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна выводить в консоль все теги, которые соответствуют тегу, заданному в параметре метода main.

Можно просто создать очередь ArrayDeque<Integer> и идя по порядку по заданным тэгам (тупо слева направо) , если попался
открывающий тэг, закидывать его стартовый индекс (matcher.start()) в хвост очереди (deque.add()), а если закрывающий, то
дергать из хвоста очереди один индекс (deque.pollLast()), получая, таким образом пару индексов открывающий тэг -
закрывающий тэг. По этим индексам можно выводить в консоль сабстринги, предварительно добавив пары в HashMap и
отсортировав по индексам открывающих тэгов. Получается очень простое решение без вложенных циклов.

Да, два матчера простейших. Потом все найденное складывается в мап<Integer индекс начала в тексте, Boolean открывающий
или закрывающий>. Например, получится мап:{(3 откр),(10 закр),(25 откр),(32 откр),(45 закр),(56 закр)}. А дальше обход всех ключей мапа:
1) 3 откр - добавляем в очередь (у меня было ArrayDeque, это самое простое, т.к. есть метод pollLast() который возвращает
    и удалет последний элемент из очереди).
2) 10 закр - берем 3 откр, т.е. 3 - (10+длина тэга) - это первый результат.
3) 25 откр добавляем в очередь
4) 32 откр добаляем в очередь
5) 45 закр, берем из хвоста очереди 32 откр, 32-45 - второй результат.
6) 56 закр, берем из хвоста 25, 25-56 - третий результат.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.regex.Matcher;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();

        BufferedReader bufferedReader1 = new BufferedReader(new FileReader(fileName));
        StringBuilder stringBuilder = new StringBuilder();
        ArrayDeque<Character> arrayDeque = new ArrayDeque<>();

        while (bufferedReader1.ready()){
            arrayDeque.add((char) bufferedReader1.read());
        }

        Matcher matcher;



    }
}
