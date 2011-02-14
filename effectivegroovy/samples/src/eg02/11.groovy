package eg02


List<Person> people = Person.findAll();

for (Person p : people) {
    System.out.println(p.firstName);
}





// do not use each when you do not need to
for (Person p : people) {
    println(p.firstName)
}
