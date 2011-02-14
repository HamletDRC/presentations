package eg03


BufferedReader input = new BufferedReader(new FileReader("./01.groovy"));
String str;
while ((str = input.readLine()) != null) {
    System.out.println(str);
}
try {input.close();} catch (IOException ex) {}











def file = new File('./01.groovy')
println file.text
file.text = file.text + '\n // hello! '
