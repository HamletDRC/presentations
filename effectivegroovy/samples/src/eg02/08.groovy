package eg02

List<Person> people = Person.findAll();

String msg = "";
for (Person p : people) {
    msg = msg + p + "\n";
}
System.out.println(msg);





println people.join('\n')


println people.toListString()