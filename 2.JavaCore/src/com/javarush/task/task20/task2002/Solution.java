package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            //File yourFile = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream("C:\\Users\\NIck\\Desktop\\myfile.txt");
            InputStream inputStream = new FileInputStream("C:\\Users\\NIck\\Desktop\\myfil1.txt");

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут

            User user = new User();
            user.setFirstName("Rubi");
            user.setLastName("Rail");
            user.setBirthDate(new Date(1508944516168L));
            user.setMale(true);
            user.setCountry(User.Country.OTHER);

            User user1 = new User();
            user1.setFirstName("Vasa1");
            user1.setLastName("Peta1");
            user1.setBirthDate(new Date(1508944516163L));
            user1.setMale(true);
            user1.setCountry(User.Country.RUSSIA);

            User user3 = new User();
            user3.setFirstName("Solo");
            user3.setLastName("Han");
            user3.setBirthDate(new Date(1508944516169L));
            user3.setMale(true);
            user3.setCountry(User.Country.UKRAINE);

            javaRush.users.add(user);
            javaRush.users.add(user1);
            javaRush.users.add(user3);
            javaRush.save(outputStream);

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the codeGym object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

            System.out.println(javaRush.equals(loadedObject));

            for(User i:javaRush.users)
            {
                System.out.println(i.toString());
            }


        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {

            PrintWriter pw = new PrintWriter(outputStream);

            if(users.size() > 0)
            {
                //StringBuilder sb = new StringBuilder();
                for (User user:users)
                {
                    if(user.getFirstName()!=null){pw.println(user.getFirstName());}
                    if(user.getLastName()!=null){pw.println(user.getLastName());}
                    if(user.getBirthDate()!=null){pw.println(user.getBirthDate().getTime());}
                    if(user.getCountry()!=null){pw.println(user.getCountry());}
                    pw.println(user.isMale());
                }
                pw.flush();
            }
            //implement this method - реализуйте этот метод
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            while (reader.ready()) {
                User addedUser = new User();
                addedUser.setFirstName(reader.readLine());
                addedUser.setLastName(reader.readLine());
                //date
                Date date = new Date(Long.parseLong(reader.readLine()));
                addedUser.setBirthDate(date);
                String countr = reader.readLine();
                addedUser.setCountry(User.Country.valueOf(countr));
                addedUser.setMale(Boolean.parseBoolean(reader.readLine()));
                int sov = 0;
                for (User user : users) {
                    if (addedUser.equals(user)) {
                        sov++;
                    }
                }
                if (sov == 0) {
                    System.out.println("Oh, he is new");
                    this.users.add(addedUser);
                }
            }
            reader.close();

        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}