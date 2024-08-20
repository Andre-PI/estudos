package com.login;


class Alien{
    private String name;
    private int age;
    private String email;
   

    public String getName() {
        return name;
    }

   
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name){
        this.name = name;
    }


    public String separate(Alien alien){
        String[] arr = new String[3];
        arr[0] = this.name;
        arr[1] = String.valueOf(this.age);
        arr[2] = this.email;
        return String.join(",", arr);
    }
}

class cc{
    public static void main(String[] args) {
        Alien a = new Alien();
        a.setName("ragh");
        a.setAge(20);
        a.setEmail("ragh@gmail.com");
        
        System.out.println(a.separate(a));
        
    }


}