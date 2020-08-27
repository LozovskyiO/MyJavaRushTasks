package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/* 
Любое дерево начинается с корня, поэтому не забудь в класс CustomTree добавить поле root типа Entry<String> c модификатором доступа по умолчанию.

Инициируй его в конструкторе CustomTree, имя (elementName) не важно.

Итак, основа дерева создана, пора тебе поработать немного самому

Необходимо написать методы, которые бы позволили создать такую структуру дерева и проводить операции над ней.

Тебе необходимо:
1) переопределить метод add(String s) - добавляет элементы дерева, в качестве параметра принимает имя элемента (elementName), искать место для вставки начинаем слева направо.
2) переопределить метод size() - возвращает текущее количество элементов в дереве.
3) реализовать метод getParent(String s) - возвращает имя родителя элемента дерева, имя которого было полученного в качестве параметра.

Если необходимо, можешь вводить дополнительные методы и поля, не указанные в задании.


Требования:
1. В классе CustomTree должно существовать поле root типа Entry.
2. В классе CustomTree должны быть переопределены методы add(String s) и size().
3. После добавления N элементов в дерево с помощью метода add, метод size должен возвращать N.
4. Метод getParent должен возвращать имя родителя для любого элемента дерева.
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {

    Entry<String> root;
    private int size;


    public CustomTree() {
        root = new Entry<>("");
        root.parent = null;
        root.leftChild = null;
        root.rightChild = null;
        size = 0;
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(String s) {
        boolean result = false;
        Queue<Entry<String>> queue = new ArrayDeque<>();
        queue.add(root);
        Entry<String> node;
        while (!queue.isEmpty()) {
            node = queue.poll();
            if (node.rightChild == null) {
                node.availableToAddRightChildren = true;
            }
            if (node.leftChild == null) {
                node.availableToAddLeftChildren = true;
            }
            if (node.isAvailableToAddChildren()) {
                if (node.parent == null) {
                    node.parent = node;
                }
                if (node.availableToAddLeftChildren) {
                    node.leftChild = new Entry<>(s);
                    node.leftChild.parent = node;
                    node.availableToAddLeftChildren = false;
                    result = true;
                    break;
                }
                if (node.availableToAddRightChildren) {
                    node.rightChild = new Entry<>(s);
                    node.rightChild.parent = node;
                    node.availableToAddRightChildren = false;
                    result = true;
                    break;
                }
            } else {
                queue.add(node.leftChild);
                queue.add(node.rightChild);
            }
        }
        size++;
        return result;
    }

    public String getParent(String s) {
        Entry<String> parent = getEntryParent(s);
        return parent != null ? parent.elementName : null;
    }

    private Entry<String> getEntryParent(String s) {
        Queue<Entry<String>> queue = new ArrayDeque<>();
        queue.add(root);
        Entry<String> node;
        Entry<String> parent = null;
        while (!queue.isEmpty()) {
            node = queue.poll();
            if (node.elementName.equalsIgnoreCase(s)) {
                parent = node.parent;
                break;
            } else {
                if (node.leftChild != null) {
                    queue.add(node.leftChild);
                }
                if (node.rightChild != null) {
                    queue.add(node.rightChild);
                }
            }
        }
        return parent;
    }

    public boolean remove(Object o) {
        if (!(o instanceof String)) {
            throw new UnsupportedOperationException();
        }
        boolean isModify = false;
        String str = (String) o;
        Entry<String> parent = getEntryParent(str);
        ArrayDeque<Entry<String>> queueA = new ArrayDeque<>();
        ArrayDeque<Entry<String>> queueB = new ArrayDeque<>();
        int count = 0;
        if (parent.rightChild != null && parent.rightChild.elementName.equalsIgnoreCase(str)) {
            queueA.add(parent.rightChild);
            queueB.add(parent.rightChild);
        }
        if (parent.leftChild != null && parent.leftChild.elementName.equalsIgnoreCase(str)) {
            queueA.add(parent.leftChild);
            queueB.add(parent.leftChild);
        }
        Entry<String> node;
        while (!queueA.isEmpty()) {
            node = queueA.poll();
            if (node.leftChild != null) {
                queueA.add(node.leftChild);
                queueB.add(node.leftChild);
            }
            if (node.rightChild != null) {
                queueA.add(node.rightChild);
                queueB.add(node.rightChild);
            }
        }
        count = queueB.size();
        while (!queueB.isEmpty()) {
            node = queueB.pollLast();
            if (node != null) {
                node.parent = null;
                node.leftChild = null;
                node.rightChild = null;
            }
        }
        if (parent.rightChild != null && parent.rightChild.elementName.equalsIgnoreCase(str)) {
            parent.rightChild = null;
            isModify = true;
        }
        if (parent.leftChild != null && parent.leftChild.elementName.equalsIgnoreCase(str)) {
            parent.leftChild = null;
            isModify = true;
        }
        size -= count;
        return isModify;
    }

    static class Entry<T> implements Serializable {
        String elementName;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
        }

        public boolean isAvailableToAddChildren() {
            return availableToAddLeftChildren || availableToAddRightChildren;
        }
    }
}
